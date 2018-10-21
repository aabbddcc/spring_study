package com.example.helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
运行后在浏览器中访问：
http://localhost:8080
http://localhost:8080/index
*/
@RestController
public class HelloController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping({"/", "/index"})
    private String index() {
        //日志级别从低到高分为TRACE < DEBUG < INFO < WARN < ERROR < FATAL，如果设置为WARN，则低于WARN的信息都不会输出。
        logger.trace("日志输出 trace");
        logger.debug("日志输出 debug");
        logger.info("日志输出 info");
        logger.warn("日志输出 warn");
        logger.error("日志输出 error");
        return "hello world";
    }
}
