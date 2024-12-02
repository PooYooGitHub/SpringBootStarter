package org.example.logstarter.autoconfigure;

import org.emample.log.config.LogConfig;
import org.emample.log.service.LogService;
import org.example.logstarter.properties.LogConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 用于自动配置日志库中的服务类的自动配置类
 */
// 该类标记为配置类
@Configuration
// 通过@EnableConfigurationProperties注解指定我们的属性配置类，才能在这个类中使用自动装配获取到属性配置类的Bean并读取配置
@EnableConfigurationProperties(LogConfigProperties.class)
public class LogServiceAutoConfiguration {

    /**
     * 获取属性配置类以读取配置文件中的配置值
     */
    @Autowired
    private LogConfigProperties logConfigProperties;

    /**
     * 在这里创建服务类LogService的实例，设定配置并注册为Bean
     */
    @Bean
    public LogService logService() {
        // 以读取的配置值创建配置对象
        LogConfig config = new LogConfig();
        config.setShowTime(logConfigProperties.isShowTime());
        // 实例化日志服务类并设定配置
        LogService service = new LogService();
        service.setConfig(config);
        // 输出一个提示语
        System.out.println("------- LogService自动配置完成！-------");
        return service;
    }

}
