package org.emample.log.service;

import org.emample.log.config.LogConfig;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogService {
    /**
     * 日志配置字段（需要用户注入，因此这个字段要有Setter方法）
     */
    private LogConfig config;

    // config字段的setter方法
    public void setConfig(LogConfig config) {
        this.config = config;
    }

    /**
     * 工具类：获取当前时间字符串
     *
     * @return 当前时间字符串
     */
    private String getTimeString() {
        // 自定义时间格式：年/月/日-时/分/秒
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm:ss");
        // 时间对象转换成自定义的字符串形式
        return LocalDateTime.now().format(format);
    }

    /**
     * 输出告示类消息
     *
     * @param message 日志消息
     */
    public void info(String message) {
        // 根据配置判断是否输出时间
        String messageString = config.isShowTime() ? "[INFO] " + getTimeString() + " " + message : "[INFO] " + message;
        System.out.println(messageString);
    }

    /**
     * 输出警告类消息
     *
     * @param message 日志消息
     */
    public void warn(String message) {
        // 根据配置判断是否输出时间
        String messageString = config.isShowTime() ? "[WARN] " + getTimeString() + " " + message : "[WARN] " + message;
        System.out.println(messageString);
    }
}
