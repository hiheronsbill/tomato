package com.meike.mongodb.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @Desc 租户标识，mongo中所有集合对应实体类的父类
 * @Version V1.0
 **/
@Data
public class TenantSymbol {

    @Field("tenantCode")
    String tenantCode;

}
