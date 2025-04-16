package Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
   private static final Logger logger = LogManager.getLogger(Thread.currentThread().getStackTrace()[3].getClassName());
    public static void Info(String message){
        logger.info(message);
    }
    public static void Error(String message){
        logger.error(message);
    }
    public static void Warn(String message){
        logger.warn(message);
    }
    public  static  void trace(String message){
        logger.trace(message);
    }
}
