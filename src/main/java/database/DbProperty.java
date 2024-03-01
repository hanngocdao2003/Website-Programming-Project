package database;

import java.io.InputStream;
import java.util.Properties;

public class DbProperty {
    private static Properties properties = new Properties();
    private static String name;
    private  static String user;
    private  static String host;
    private static  String pass;
    private static  String port;

    static {
        InputStream inputStream = DbProperty.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(inputStream);

            host = properties.getProperty("db.host");
            user = properties.getProperty("db.user");

            pass = properties.getProperty("db.pass");
            port = properties.getProperty("db.port");
            name = properties.getProperty("db.name");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Properties getProperties() {
        return properties;
    }

    public static void setProperties(Properties properties) {
        DbProperty.properties = properties;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        DbProperty.name = name;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        DbProperty.user = user;
    }

    public static String getHost() {
        return host;
    }

    public static void setHost(String host) {
        DbProperty.host = host;
    }

    public static String getPass() {
        return pass;
    }

    public static void setPass(String pass) {
        DbProperty.pass = pass;
    }

    public static String getPort() {
        return port;
    }

    public static void setPort(String port) {
        DbProperty.port = port;
    }

    public static void main(String[] args) {
        System.out.println(DbProperty.getProperties());
    }
}
