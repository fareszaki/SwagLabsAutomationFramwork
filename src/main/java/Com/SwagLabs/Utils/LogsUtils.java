package Com.SwagLabs.Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogsUtils {

     public static final String Logs_Path ="test-outputs/Logs";
    private  LogsUtils(){} ;
    public static Logger getLogger(){
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[3].getClassName());
    }

    public static void warn(String... Message){
        getLogger().warn(String.join(" " , Message));
    }

    public static  void info(String... Message ){
        getLogger().info(String.join(" " , Message));
    }
    public static  void error(String... Message ){
        getLogger().error(String.join(" " , Message));
    }
    public static  void debug(String... Message ){
        getLogger().debug(String.join(" " , Message));
    }
    public static  void trace(String... Message ){
        getLogger().trace(String.join(" " , Message));
    }
    public static  void fatal(String... Message ){
        getLogger().fatal(String.join(" " , Message));
    }

}
