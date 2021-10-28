package com.mk.java.lambda;

import java.lang.reflect.ParameterizedType;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/8/23 21:07
 * @Version V1.0
 **/
public class WorkImpl <T> implements Work<T>{

    @Override
    public T find() {
        return null;
    }

    public Class<T> getEntityClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Class<T> getEntityClass2(){
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
