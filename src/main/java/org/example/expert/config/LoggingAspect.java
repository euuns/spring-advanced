package org.example.expert.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@RequiredArgsConstructor
public class LoggingAspect {

    @Autowired
    private HttpServletRequest request;

    private final ObjectMapper mapper;

    private final Logger log = LoggerFactory.getLogger(getClass());


    @Around("execution(* org.example.expert.domain.*.*.*AdminController.*(..))")
    public void adminLogging(ProceedingJoinPoint joinPoint) throws Throwable {

        Object[] args = joinPoint.getArgs();

        log.info("method = {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());

        log.info("user = {}", request.getAttribute("userId"));
        log.info("url = {}", LocalDateTime.now());
        log.info("time = {}", request.getRequestURL().toString());

        String request = mapper.writeValueAsString(args);
        log.info("request = {}", request);

        String response = mapper.writeValueAsString(joinPoint.proceed());
        log.info("response = {}", response);


    }


}
