//
//class Logger {
//    String name;
//    Level loggerLevel;
//    Config config;
//
//    Logger(name, loggerLevel) {
//    }
//    info(msg) {
//        this.log(Level.Info, msg);
//    }
//    error(msg) {
//        this.log(Level.Error, msg);
//    }
//    log(level, msg) {
//        if(!Level.isMoreGeneral(this.loggerLevel, level))
//            return;
//        for(appender: config.getAppenders())
//            appender.append(this.name, level, msg)
//    }
//}
//
//class LogManager {
//    LoggerRegistry registry;
//
//    Logger getLogger(name, level) {
//        if(!LoggerRegistry.exists(name))
//            LoggerRegistry.put(name, new Logger(name, level));
//        return LoggerRegistry.get(name);
//    }
//}
//
//class LoggerRegistry {
//    static Map<String, Logger> loggersMap;
//    static boolean exists(name) {
//        return loggersMap.exists(name);
//    }
//    void put(name, logger);
//}
//
//enum Level {
//    Fatal,
//    Warning,
//    Error,
//    Info,
//    Debug
//
//    boolean isMoreGeneral(Level curLevel, Level testLevel) {
//        return testLevel <= curLevel;  // For eg. Fatal log should print no matter what the log level is
//    }
//}
//
//class Config {
//    List<Appender> appenders;
//
//    addAppenders();
//    removeAppenders();
//}
//
//interface Appender {
//    void append(loggerName, level, msg);
//    void append(loggerName, msg);
//}
//
//class AbstractAppender {
//    Level level; // Appender level
//}
//
//class ConsoleAppender extends AbstractAppender {
//    void append(loggerName, level, msg) {
//        if(!Level.isMoreGeneral(this.level, level))
//            return;
//        else
//            append(loggerName, msg);
//    }
//}
//
