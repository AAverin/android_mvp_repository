package anton.averin.pro.tests.sampleapp.utils;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

import anton.averin.pro.tests.sampleapp.Config;

@Singleton
public class LLogger {

    @Inject
    public LLogger() {
    }

    public static void log_e_static(String TAG, Object... message) {
        if (!Config.isLoggingEnabled) {
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Object msg : message) {
            stringBuilder.append(String.valueOf(msg));
        }
        Log.e(TAG, stringBuilder.toString());
    }

    public void log(String TAG, Object... message) {
        if (!Config.isLoggingEnabled) {
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Object msg : message) {
            stringBuilder.append(String.valueOf(msg));
        }
        Log.d(TAG, stringBuilder.toString());
    }

    public void log_e(String TAG, Object... message) {
        if (!Config.isLoggingEnabled) {
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Object msg : message) {
            stringBuilder.append(String.valueOf(msg));
        }
        Log.e(TAG, stringBuilder.toString());
    }

    public void logArray(Object o, String[] array) {
        String tag = o.getClass().getSimpleName();
        StringBuilder stringBuilder = new StringBuilder();
        for (String msg : array) {
            stringBuilder.append(String.valueOf(msg));
            stringBuilder.append(", ");
        }
        Log.d(tag, stringBuilder.toString());
    }

    public void log(Object o, Throwable t, Object... message) {
        if (!Config.isLoggingEnabled) {
            return;
        }

        String tag = o.getClass().getSimpleName();
        StringBuilder stringBuilder = new StringBuilder();
        for (Object msg : message) {
            stringBuilder.append(String.valueOf(msg));
        }
        Log.d(tag, stringBuilder.toString(), t);
    }

    public void log_e(Object o, Throwable t, Object... message) {
        if (!Config.isLoggingEnabled) {
            return;
        }

        String tag = o.getClass().getSimpleName();
        StringBuilder stringBuilder = new StringBuilder();
        for (Object msg : message) {
            stringBuilder.append(String.valueOf(msg));
        }
        Log.e(tag, stringBuilder.toString(), t);
    }

    public void log(Object o, Object... message) {
        log(o.getClass().getSimpleName(), message);
    }

    public void log_e(Object o, Object... message) {
        log_e(o.getClass().getSimpleName(), message);
    }

}
