package com.matt.aopdemo;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MethodAspect {

    private static final String TAG = "ConstructorAspect";

    @Pointcut("call(* com.matt.aopdemo.Animal.fly(..))")
    public void callMethod() {
        Log.e(TAG, "callMethod: " );
    }

    @Before("callMethod()")
    public void beforeMethodCall(JoinPoint joinPoint) {
        Log.e(TAG, "before->" + joinPoint.getTarget().toString() + "#" + joinPoint.getSignature().getName());
    }
}
