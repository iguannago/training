package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.WebUtils;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@EnableAspectJAutoProxy
@SpringBootApplication
@Log
public class UtilExampleApplication {

    @Aspect
    @Component
    public static class SimpleBeforeAspect {

        @Before("execution(* begin(..))")
        public void before(JoinPoint joinPoint) {
            log.info("--------------");
            log.info("before()");
            log.info(joinPoint.toString());
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DemoClass {
        private List<Map<String, Object>> list = new ArrayList<>();

        @PostConstruct
        public void begin() {
            log.info("begin()");
        }
    }

    @Bean
    DemoClass demoClass() {
        return new DemoClass();
    }

    @Bean
    CommandLineRunner demo(DemoClass demo) {
        return args -> {
            Assert.notNull(demo.getList(), "the list cannot be null");
            beanUtils(demo);
            classUtils();
            systemPropertyUtils();
            fileCopyUtils();
            web();
        };
    }

    private void web() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForEntity("http://localhost:8080/hi?age=38", Void.class);
    }

    @RestController
    public static class SimpleRestController {

        @GetMapping("/hi")
        void hi(HttpServletRequest request) {
            int age = ServletRequestUtils.getIntParameter(request, "age", -1);
            log.info("age is: " + age);
            File tempDir = WebUtils.getTempDir(request.getServletContext());
            log.info("tempDir: " + tempDir.getAbsolutePath());
        }

    }

    private void fileCopyUtils() {
        File file = new File(SystemPropertyUtils.resolvePlaceholders("${user.home}"),
                "/data/myGitHub/spring/util-example/util-example/tips.txt");
        try (Reader reader = new FileReader(file)) {
            log.info("file reader: " + FileCopyUtils.copyToString(reader));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void systemPropertyUtils() {
        String resolvePlaceholders = SystemPropertyUtils.resolvePlaceholders("my user home is: ${user.home}");
        log.info("resolvePlaceholders: " + resolvePlaceholders);
    }

    private void classUtils() {
        Constructor<DemoClass> demoClassConstructor = ClassUtils.getConstructorIfAvailable(DemoClass.class);
        log.info("demoClassConstructor: " + demoClassConstructor);
        try {
            DemoClass demoClass = demoClassConstructor.newInstance();
            log.info("new instance: " + demoClass);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void beanUtils(DemoClass demo) {
        PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(demo.getClass());
        for (PropertyDescriptor pd : propertyDescriptors) {
            log.info("pd: " + pd.getName());
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(UtilExampleApplication.class, args);
    }
}
