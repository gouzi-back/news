package com.edu.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Auther:haha
 * @Date:2021/1/21 - 01 - 21 15:05
 * @Description:com.edu.util
 * @Version: 1.0
 */

/*读取数据库属性文件获取数据库星系
  如何让用户只能创建一个ConfigManager?单例模式

*/

public class ConfigManager {
    private static ConfigManager configManager;
    private Properties properties;

    public ConfigManager() {
        String configFile = "database.properties";
        InputStream in = ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
        properties=new Properties();
        try {
            properties.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //提供给别人一个唯一的从configManager对象  懒汉模式
    public static synchronized ConfigManager getInstance(){
        if (configManager == null) {
            configManager = new ConfigManager();
        }
        return configManager;
    }
    //根据属性文件中的键获取对应的值
    public String getString(String key) {
        return properties.getProperty(key);
    }
}
