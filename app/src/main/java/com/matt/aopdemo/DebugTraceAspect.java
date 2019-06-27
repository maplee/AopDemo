package com.matt.aopdemo;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class DebugTraceAspect {

    private static final String TAG = "DebugTraceAspect";


    /**
     * 整个表达式可以分为五个部分：
     *
     * execution()是表达式主体
     * 第一个*号代表返回类型，*号代表所有的类型。
     * 包名 表示需要拦截的包名，这里使用*.代表匹配所有的包名。
     * 第二个*号表示类名，后面跟.MainActivity是指具体的类名叫MainActivity。
     * *(..) 最后这个星号表示方法名，+.代表具体的函数名，*号通配符，包括括弧号里面表示方法的参数，两个dot代表任意参数。
     *
     */
    @Pointcut("execution(@com.matt.aopdemo.DebugTrace * *..*.*(..))")
    public void DebugTraceMethod(){
        Log.e(TAG, "DebugTraceMethod: " );
    }


    /**
     * joinPoint.proceed() 执行注解所标识的代码
     * @After 可以在方法前插入代码
     * @Before 可以在方法后插入代码
     * @Around 可以在方法前后各插入代码
     */
    @Around("DebugTraceMethod()")
    public void beforeDebugTraceMethod(JoinPoint joinPoint) throws Throwable{
        String key = joinPoint.getSignature().toString();
        Log.e(TAG, "beforeDeb:"+key);
        Log.e(TAG, "beforeDebug:"+joinPoint.toString());
    }



    @Before("execution(* android.support.v7.app.AppCompatActivity.on**(..)))")
    public void onActivityMethodBefore(JoinPoint joinPoint) throws Throwable{
        Log.e(TAG, "onActivityMethodBefore: "+joinPoint.getSignature().toString() );
    }

}
