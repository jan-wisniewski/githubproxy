package com.wisniewskijan.githubproxy.config.aop.annotations;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class HeaderChecker {

    @Value("${config.headers.incorrect}")
    private String[] incorrectHeaders;

    @Value("${config.headers.correct}")
    private String[] correctHeaders;

    @Value("${config.headers.key}")
    private String key;

    @Before("@annotation(com.wisniewskijan.githubproxy.config.aop.annotations.Restrict)")
    public void restrict(final JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Restrict annotation = signature.getMethod().getAnnotation(Restrict.class);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        if (annotation.isProperHeader() && !isProperHeader(request)) {
            throw new IllegalStateException("Resource accepts only: "+ Arrays.toString(correctHeaders));
        }
    }

    private boolean isProperHeader(final HttpServletRequest request) {
        return request.getHeader(key) != null && Arrays.stream(correctHeaders).anyMatch(e -> e.equals(request.getHeader(key)));
    }

}
