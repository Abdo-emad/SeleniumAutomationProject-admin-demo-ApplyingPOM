package Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
   private static final Logger logger = LogManager.getLogger(Thread.currentThread().getStackTrace()[3].getClassName());
    public static void Info(String message){
        logger.info(message);
    }
    public  static  void trace(String message){
        logger.trace(message);
    }

    public static void info(String... message){
        logger.info(String.join("",message));
    }

    public static void error(String... message){
        logger.error(String.join("",message));
    }

    public static void warning(String... message){
        logger.warn(String.join("",message));
    }
}
