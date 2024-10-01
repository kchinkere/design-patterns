package designpatterns.behavioral.chain.of.responsibility.example;

public abstract class Logger {
    public static final int INFO = 1;
    public static final int DEBUG = 2;
    public static final int ERROR = 3;

    protected int level;
    protected Logger nextLogger;

    public void nextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if(this.level <= level) {
            write(message);
        }

        if(nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    abstract void write(String message);
}
