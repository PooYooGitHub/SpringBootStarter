package org.example.nomalproject;

import jakarta.annotation.PostConstruct;
import org.emample.log.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NomalProjectApplication {
    /**
     * 在需要使用的地方自动装配一下即可！
     */
    @Autowired
    private LogService logService;

    @PostConstruct
    private void init() {
        // 测试调用
        logService.info("调用日志服务！");
    }



    public static void main(String[] args) {
        SpringApplication.run(NomalProjectApplication.class, args);
    }

}
