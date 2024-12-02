package org.example.logstarter.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 用于读取配置文件(application.properties或application.yml)中的配置的属性配置类
 */
@Data
@ConfigurationProperties(prefix = "org.example.log")
public class LogConfigProperties {
    /**
     * 是否显示时间（默认为false）
     */
    private boolean showTime = false;
}
