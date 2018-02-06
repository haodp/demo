package com.demo.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Properties;

/**
 * Created by yagu on 16/2/4.
 */
@Slf4j
public final class PropertiesUtil {
    /****
     * 配置文件.
     */
    private static final String DEFAULT_PROP_FILE = "config/ip.properties";
    private static Properties prop = new Properties();

    /****
     * 定义常量.
     */
    private PropertiesUtil() {
    }

    static {
        reload();
    }

    public static void reload() {
        try {
            Properties properties = new Properties();
            properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(DEFAULT_PROP_FILE));
            prop = properties;
        } catch (Throwable e) {
            log.error("load properties exception", e);
        }
    }

    public static String get(String key) {
        if (StringUtils.isBlank(key)) {
            return "";
        }
        return String.valueOf(prop.get(key));
    }

    public static String get(String key, String defaultValue) {
        if (StringUtils.isBlank(key)) {
            return defaultValue;
        }
        return String.valueOf(prop.get(key));
    }
}
