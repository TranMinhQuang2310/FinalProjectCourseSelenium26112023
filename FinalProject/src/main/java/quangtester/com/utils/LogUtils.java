package quangtester.com.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class LogUtils {

    //import thư viện
    private static final Logger LOGGER = (Logger) LogManager.getLogger(LogUtils.class);

    //Info Level Logs => Thông tin
    public static void info (String message) {

        LOGGER.info(message);
    }
    public static void info01 (Object object) {
        LOGGER.info(object);
    }

    //Warn Level Logs => Cảnh báo
    public static void warn (String message) {
        LOGGER.warn(message);
    }
    public static void warn01 (Object object) {
        LOGGER.warn(object);
    }

    //Error Level Logs => Lỗi
    public static void error (String message) {
        LOGGER.error(message);
    }
    public static void error01 (Object object) {
        LOGGER.error(object);
    }

    //Fatal Level Logs
    public static void fatal (String message) {
        LOGGER.fatal(message);
    }

    //Debug Level Logs
    public static void debug (String message) {
        LOGGER.debug(message);
    }
    public static void debug01 (Object object) {
        LOGGER.debug(object);
    }

}
