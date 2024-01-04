package com.railway.Utils;


public class ThreadLocalUtil {

    private static final ThreadLocal<Object> threadLocal = new ThreadLocal<>();
    /**
     * 设置线程携带的数据
     */
    public static void saveUser(Object user){
        threadLocal.set(user);
    }
    /**
     * 获取线程携带的数据
     */
    public static Object getUser(){
        return threadLocal.get();
    }

    /**
     * 删除线程携带的数据
     */
    public static void removeUser(){
        threadLocal.remove();
    }
}
