package com.sample.factory.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LogManager.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.sample.factory.controller..*(..)))")
    public void controller() {
    }

    @Around("controller() && !@annotation(com.sample.factory.aspect.annotation.NoLogging)")
    public Object profileAllMethods(final JoinPoint joinPoint) throws Throwable {
        final MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        final MethodInvocationProceedingJoinPoint invocationProceedingJoinPoint = (MethodInvocationProceedingJoinPoint) joinPoint;
        //Get intercepted method details
        final String className = methodSignature.getDeclaringType().getSimpleName();
        final String methodName = methodSignature.getName();
        final String requestId = UUID.randomUUID().toString();
        final StringBuilder requestObjectBuilder = new StringBuilder();
        int i = 1;
        for (final Object requestObj : joinPoint.getArgs()) {
            requestObjectBuilder.append("Req obj-" + i + ": " + requestObj.toString() + ", ");
            i++;
        }
        if (i > 1) {
            requestObjectBuilder.deleteCharAt(requestObjectBuilder.length() - 2);
        }
        final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        if (request != null) {
            final String qString = request.getQueryString();
            String reqPath = request.getServletPath();
            if (qString != null) {
                reqPath = reqPath + "?" + qString;
            }
            LOGGER.info("Request Id:: " + requestId + ", Method type:: " + request.getMethod() + ", Path:: " + reqPath + ", Mode:: Enter, Target:: " + className + "." + methodName + ", Request Object:: " + requestObjectBuilder);
        }
        //Starting the stop watch for service execution
        final Long currTimeInMillis = System.currentTimeMillis();
        final Object result = invocationProceedingJoinPoint.proceed();
        final Long executionTimeInMillis = System.currentTimeMillis() - currTimeInMillis;
        //Log method execution time
        LOGGER.info("Request Id:: " + requestId + ", Mode:: Exit, Target:: " + className + "." + methodName + ", Execution time:: " + executionTimeInMillis + " ms, Result:: ");
        return result;
    }

}
