package org.springframework.data.mongodb.core;

import com.meike.mongodb.entity.TenantSymbol;
import com.meike.mongodb.util.TenantHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.Collection;


/**
 * @Desc 通过mongoTemplate操作数据库，都需要携带tenantCode
 * @Author zhxy
 * @Date 2021/9/28 13:57
 * @Version V1.0
 **/
@Component
@Aspect
@Order(2)
public class MongoTemplateAop {

    /**
     * 由于每种数据操作不同、传参不同，故植入租户标识逻辑也各不相同，为避免造成混乱，减少判断、与逻辑复杂度，
     * 为每个pointcut单独声明@Around方法处理
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MongoTemplateAop.class);

    private static final String TENANT_CODE = "tenantCode";
    private static final String ID = "_id";

    @Autowired
    private MongoTemplate mongoTemplate;


    @Pointcut("execution(* org.springframework.data.mongodb.core.MongoTemplate.insert(..))")
    public void insert() {
    }

    @Pointcut("execution(* org.springframework.data.mongodb.core.MongoTemplate.save(..))")
    public void save() {
    }

    @Pointcut("execution(* org.springframework.data.mongodb.core.MongoTemplate.updateFirst(..))")
    public void updateFirst() {
    }

    @Pointcut("execution(* org.springframework.data.mongodb.core.MongoTemplate.updateMulti(..))")
    public void updateMulti() {
    }

    @Pointcut("execution(* org.springframework.data.mongodb.core.MongoTemplate.upsert(..))")
    public void upsert() {
    }

    @Pointcut("execution(* org.springframework.data.mongodb.core.MongoTemplate.find(..))")
    public void find() {
    }

    @Pointcut("execution(* org.springframework.data.mongodb.core.MongoTemplate.findOne(..))")
    public void findOne() {
    }

    @Pointcut("execution(* org.springframework.data.mongodb.core.MongoTemplate.findAll(..))")
    public void findAll() {
    }

    @Pointcut("execution(* org.springframework.data.mongodb.core.MongoTemplate.findById(..))")
    public void findById() {
    }

    @Pointcut("execution(* org.springframework.data.mongodb.core.MongoTemplate.findAndModify(..))")
    public void findAndModify() {
    }

    @Pointcut("execution(* org.springframework.data.mongodb.core.MongoTemplate.findDistinct(..))")
    public void findDistinct() {
    }

    @Pointcut("execution(* org.springframework.data.mongodb.core.MongoTemplate.exists(..))")
    public void exists() {
    }

    /**
     * 无法切入doRemove，采用在EcmMongoTemplate中植入tenantCode
     */
    @Pointcut("execution(* org.springframework.data.mongodb.core.MongoTemplate.remove(..))")
    public void remove() {
    }

    @Pointcut("execution(* org.springframework.data.mongodb.core.MongoTemplate.count(..))")
    public void count() {
    }

    @Pointcut("execution(* org.springframework.data.mongodb.core.MongoTemplate.aggregate(..))")
    public void aggregate() {
    }

    @Pointcut("execution(* org.springframework.data.mongodb.core.MongoTemplate.bulkOps(..))")
    public void bulkOps() {
    }

    /**
     * insert新数据时，填充tenantCode
     *
     * @param joinPoint
     */
    @Around("insert()")
    public Object insertAround(ProceedingJoinPoint joinPoint) {

        // 1、获取insert参数，植入tenantCode
        Object[] args = joinPoint.getArgs();
        if (args[0] instanceof Collection) {
            // 批量插入时为每个文档植入tenantCode
            for (Object o : ((Collection) args[0])) {
                if (o instanceof TenantSymbol) {
                    ((TenantSymbol) o).setTenantCode(TenantHolder.currentTenant());
                }
            }
        } else if (args[0] instanceof TenantSymbol) {
            // 单条插入时植入tenantCode
            ((TenantSymbol) args[0]).setTenantCode(TenantHolder.currentTenant());
        } else {
            throw new RuntimeException("");
        }
        // 2、执行数据操作
        return processData(joinPoint);

    }

    /**
     * save数据时，填充tenantCode
     *
     * @param joinPoint
     */
    @Around("save()")
    public Object saveAround(ProceedingJoinPoint joinPoint) {

        // 1、获取save参数，植入tenantCode
        Object[] args = joinPoint.getArgs();
        if (args[0] instanceof TenantSymbol) {
            ((TenantSymbol) args[0]).setTenantCode(TenantHolder.currentTenant());
        } else {
            throw new RuntimeException("");
        }
        // 2、执行数据操作
        return processData(joinPoint);
    }

    /**
     * 为第一个参数为Query的数据操作，增加查询条件tenantCode
     *
     * @param joinPoint
     * @return
     */
    @Around("find() || findOne() || findAndModify() || findDistinct() || updateFirst() || updateMulti() || upsert() || exists() || count()")
    public Object aroundWithQuery(ProceedingJoinPoint joinPoint) {

        // 1、获取查询参数，植入tenantCode
        Object[] args = joinPoint.getArgs();
        if (args[0] instanceof Query) {
            ((Query) args[0]).addCriteria(Criteria.where(TENANT_CODE).is(TenantHolder.currentTenant()));
        } else {
            throw new RuntimeException("");
        }
        // 2、执行数据操作
        return processData(joinPoint);
    }

    /**
     * findAll数据时，查询条件携带tenantCode
     *
     * @param joinPoint
     */
    @Around("findAll()")
    public Object findAllAround(ProceedingJoinPoint joinPoint) {

        // 1、获取查询参数
        Object[] args = joinPoint.getArgs();
        // 2、通过将findAll转换为find，以便查询条件携带tenantCode
        if (args.length == 1) {
            return mongoTemplate.find(new Query(), (Class) args[0]);
        } else {
            return mongoTemplate.find(new Query(), (Class) args[0], (String) args[1]);
        }
    }


    /**
     * findById时，查询条件携带tenantCode
     *
     * @param joinPoint
     * @return
     */
    @Around("findById()")
    public Object findByIdAround(ProceedingJoinPoint joinPoint) {

        // 1、获取查询参数
        Object[] args = joinPoint.getArgs();
        // 2、通过将findById转换为findOne，以便查询条件携带tenantCode
        if (args.length == 2) {
            return mongoTemplate.findOne(new Query(Criteria.where(ID).is(args[0])), (Class) args[1]);
        } else {
            return mongoTemplate.findOne(new Query(Criteria.where(ID).is(args[0])), (Class) args[1], (String) args[2]);
        }
    }

    /**
     * aggregate查询，携带tenantCode参数
     *
     * @param joinPoint
     * @return
     */
    @Around("aggregate()")
    public Object aggregateAround(ProceedingJoinPoint joinPoint) {

        // 1、获取聚合查询参数
        Object[] args = joinPoint.getArgs();
        if (args[0] instanceof Aggregation) {
            // 2、条件tenantCode过滤条件
            Aggregation aggregation = (Aggregation) args[0];
            MatchOperation match = Aggregation.match(Criteria.where(TENANT_CODE).is(TenantHolder.currentTenant()));
            aggregation.getPipeline().add(match);
        } else {
            throw new RuntimeException("");
        }
        // 3、执行数据查询
        return processData(joinPoint);
    }

    /**
     * 执行最终的数据操作
     *
     * @param joinPoint
     * @return
     */
    private Object processData(ProceedingJoinPoint joinPoint) {
        // 执行数据操作,并返回结果
        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }


}
