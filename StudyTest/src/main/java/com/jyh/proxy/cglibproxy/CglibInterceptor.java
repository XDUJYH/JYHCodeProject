package com.jyh.proxy.cglibproxy;

import com.jyh.proxy.jdkproxy.DaoTransaction;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


public class CglibInterceptor implements MethodInterceptor {

    DaoTransaction transaction;

    private Object obj;

    public CglibInterceptor(DaoTransaction transaction, Object obj) {
        this.transaction = transaction;
        this.obj = obj;
    }


    @Override
    /**
     * o 代理类对象
     * method 当前被代理拦截的方法
     * args 拦截方法的参数
     * methodProxy 代理类对应目标类的代理方法
     * 创建 CGLIB 动态代理类
     */
    //TODO：请详细理解methodProxy.invokeSuper(o, args)和method.invoke(obj, args)的区别！！！
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object ret = null;
        //事务增强
        if(method.getName().equals("sing")){
            transaction.before();
            ret = methodProxy.invokeSuper(o, args);
            transaction.after();
        }else {
            ret = methodProxy.invokeSuper(o, args);
        }

        return ret;
    }
}
