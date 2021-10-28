package com.meike.mongodb.util;

/**
 * @Desc 存储租户信息，供线程全局使用
 * @Author zhxy
 * @Date 2021/9/28 09:58
 * @Version V1.0
 **/
public class TenantHolder {


    private static final ThreadLocal<String> tenantThreadLocal = new ThreadLocal<>();

    /**
     * 将租户信息保存到当前线程
     *
     * @param tenantCode
     */
    public static void keepTenant(String tenantCode) {
        tenantThreadLocal.set(tenantCode);
    }

    /**
     * 获取当前线程的租户信息
     */
    public static String currentTenant() {
        return tenantThreadLocal.get();
    }

    /**
     * 删除当前线程的租户信息
     */
    public static void clear() {
        tenantThreadLocal.remove();
    }

}
