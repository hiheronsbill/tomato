package org.springframework.data.mongodb.core;


import com.meike.mongodb.util.TenantHolder;
import com.mongodb.client.MongoClient;
import com.mongodb.client.result.DeleteResult;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * @Desc MongoTemplate的子类，当无法通过切面注入tenantCode时，在此重写对应方法，植入tenantCode
 * @Author zhxy
 * @Date 2021/10/15 11:19
 * @Version V1.0
 **/
public class EcmMongoTemplate extends MongoTemplate {

    private static final String TENANT_CODE = "tenantCode";


    public EcmMongoTemplate(MongoClient mongoClient, String databaseName) {
        super(mongoClient, databaseName);
    }

    public EcmMongoTemplate(MongoDatabaseFactory mongoDbFactory) {
        super(mongoDbFactory);
    }

    public EcmMongoTemplate(MongoDatabaseFactory mongoDbFactory, MongoConverter mongoConverter) {
        super(mongoDbFactory, mongoConverter);
    }

    @Override
    public <T> DeleteResult doRemove(String collectionName, Query query, Class<T> entityClass, boolean multi) {
        if (query == null) {
            query = new Query();
        }
        query.addCriteria(Criteria.where(TENANT_CODE).is(TenantHolder.currentTenant()));
        return super.doRemove(collectionName, query, entityClass, multi);
    }
}
