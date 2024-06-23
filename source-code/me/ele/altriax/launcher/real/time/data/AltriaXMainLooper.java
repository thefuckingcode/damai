package me.ele.altriax.launcher.real.time.data;

import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.util.Printer;
import androidx.annotation.NonNull;

@Deprecated
/* compiled from: Taobao */
public class AltriaXMainLooper {
    private static final String MESSAGE_END = "<<<<< Finished to";
    private static final String MESSAGE_START = ">>>>> Dispatching to";
    private static final String TAG = "AltriaXMainLooper";
    private String endName;
    private MainLooperMessageListener mainLooperMessageListener;

    /* compiled from: Taobao */
    public static class IoDHHolder {
        private static final AltriaXMainLooper instance = new AltriaXMainLooper();
    }

    /* compiled from: Taobao */
    public interface MainLooperMessageListener {
        void onMainLooperMessage(@NonNull String str, long j);
    }

    /* compiled from: Taobao */
    public class MainLooperPrinter implements Printer {
        @NonNull
        private final MainLooperMessageListener mainLooperMessageListener;
        private long startTime;

        public MainLooperPrinter(@NonNull MainLooperMessageListener mainLooperMessageListener2) {
            this.mainLooperMessageListener = mainLooperMessageListener2;
        }

        public void println(String str) {
            if (str.startsWith(AltriaXMainLooper.MESSAGE_START)) {
                this.startTime = SystemClock.uptimeMillis();
            } else if (str.startsWith(AltriaXMainLooper.MESSAGE_END) && this.startTime > 0) {
                this.mainLooperMessageListener.onMainLooperMessage(str, SystemClock.uptimeMillis() - this.startTime);
                if (str.contains(AltriaXMainLooper.this.endName)) {
                    Looper.getMainLooper().setMessageLogging(null);
                }
            }
        }
    }

    public static AltriaXMainLooper getInstance() {
        return IoDHHolder.instance;
    }

    public void setEndName(@NonNull String str) {
        this.endName = str;
    }

    public void setMainLooperMessageListener(@NonNull MainLooperMessageListener mainLooperMessageListener2) {
        this.mainLooperMessageListener = mainLooperMessageListener2;
    }

    public void start() {
        if (this.mainLooperMessageListener != null && Log.isLoggable(TAG, 2)) {
            Looper.getMainLooper().setMessageLogging(new MainLooperPrinter(this.mainLooperMessageListener));
        }
    }

    private AltriaXMainLooper() {
        this.endName = "DistributedTasks";
    }
}
