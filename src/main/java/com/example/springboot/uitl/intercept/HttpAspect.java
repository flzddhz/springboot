//package com.example.springboot.uitl.intercept;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Component
//@Aspect
//public class HttpAspect {
//    @Pointcut("execution(* com.universe.polaris.controller.*.*(..))")
//    public void controllerPointcut() {
//    }
//
//
//    @Before("controllerPointcut()")
//    public void before(JoinPoint joinPoint) {
//        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = requestAttributes.getRequest();
//        /**
//         * url
//         */
//        log.info("Before：url={}", request.getRequestURL());
//        /**
//         * ip
//         */
//        log.info("Before：ip={}", request.getRemoteAddr());
//        /**
//         * 请求方式
//         */
//        log.info("Before：method={}", request.getMethod());
//        /**
//         * 代理类
//         */
//        log.info("Before：代理类调用的方法:{}", joinPoint.getSignature().getDeclaringTypeName() + "#" + joinPoint.getSignature().getName());
//        StringBuilder sb = new StringBuilder();
//        for (Object temp : joinPoint.getArgs()) {
//            sb.append(temp.toString());
//        }
//        /**
//         * 参数
//         */
//        log.info("params={}", sb.toString());
//    }
//
//    @Around("controllerPointcut()")
//    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
//        try {
//            log.info("Around: 环绕执行");
//            return proceedingJoinPoint.proceed();
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @AfterReturning(pointcut = "controllerPointcut()", returning = "object")
//    public void afterReturning(Object object) {
//        log.info("AfterReturning 执行: response={}", JSON.toJSONString(object));
//    }
//
//    @AfterThrowing(throwing = "e", pointcut = "controllerPointcut()")
//    public void afterThrowing(Throwable e) {
//        log.error("系统异常:{}", e.getMessage());
//    }
//}
