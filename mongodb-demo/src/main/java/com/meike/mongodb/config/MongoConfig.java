package com.meike.mongodb.config;

import com.meike.mongodb.convert.BigDecimalToDecimal128Converter;
import com.meike.mongodb.convert.Decimal128ToBigDecimalConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.data.convert.CustomConversions;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.core.EcmMongoTemplate;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.convert.*;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/9/11 10:20
 * @Version V1.0
 **/

@Configuration
@ComponentScan(basePackages = {"org.springframework.data.mongodb.core"})
@EnableMongoRepositories(basePackages = {"com.meike.mongodb.repository"})
public class MongoConfig {

    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MongoConfig.class);


    @Bean
    @ConfigurationProperties(prefix = "spring.data.mongodb")
    @Primary
    public MongoProperties mongoProperties() {
        return new MongoProperties();
    }


    @Bean
    @Primary
    public MongoDatabaseFactory mongoDatabaseFactory() {
        return new SimpleMongoClientDatabaseFactory(mongoProperties().getUri());
    }

//    @Bean
//    public MongoTemplate mongoTemplate(MongoDatabaseFactory factory, MongoConverter converter) {
//        return new EcmMongoTemplate(factory, converter);
//    }

//    @Bean
//    @Primary
//    public MongoClient mongoClient(){
//        return MongoClients.create();
//    }

//    @Bean
//    @ConditionalOnProperty(name = "mongo.transaction.enable", havingValue = "true")
//    MongoTransactionManager mongoTransactionManager(MongoDatabaseFactory factory) {
//        return new MongoTransactionManager(factory);
//    }
//
//    @Bean
//    public MappingMongoConverter mappingMongoConverter(MongoMappingContext context, BeanFactory beanFactory, MongoDatabaseFactory factory) {
//        DbRefResolver dbRefResolver = new DefaultDbRefResolver(factory);
//        MappingMongoConverter mappingConverter = new MappingMongoConverter(dbRefResolver, context);
//        try {
//            mappingConverter.setCustomConversions(beanFactory.getBean(CustomConversions.class));
//        } catch (NoSuchBeanDefinitionException e) {
//            LOGGER.warn(e.getMessage(), e);
//        }
//
//        // Don't save _class to mongo
//        mappingConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
//        List<Object> list = new ArrayList<>();
//        list.add(new BigDecimalToDecimal128Converter());//自定义的类型转换器
//        list.add(new Decimal128ToBigDecimalConverter());//自定义的类型转换器
//        mappingConverter.setCustomConversions(new MongoCustomConversions(list));
//        mappingConverter.setMapKeyDotReplacement("=");//避免异常，将‘.’替换成‘=’
//        return mappingConverter;
//    }

}
