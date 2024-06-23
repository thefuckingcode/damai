package com.taobao.tao.log.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;
import com.taobao.tao.log.LogLevel;
import com.taobao.tao.log.TLogController;
import com.taobao.tao.log.TLogNative;
import com.taobao.tao.log.TLogUtils;
import java.util.Map;
import tb.ki2;

/* compiled from: Taobao */
public class TLogMultiProcessReceiver extends BroadcastReceiver {
    private static final String TAG = "TLogProcessReceiver";

    private void changeLogLevel(Intent intent) {
        if (intent != null) {
            Log.e(TAG, "TLog MultiProcess changeLogLevel");
            try {
                TLogController.getInstance().setLogLevel((LogLevel) intent.getSerializableExtra(TLogMultiProcessTool.PARAM_LOG_LEVEL));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void changeModuleLevel(Intent intent) {
        if (intent != null) {
            Log.e(TAG, "TLog MultiProcess changeModuleLevel");
            try {
                String stringExtra = intent.getStringExtra(TLogMultiProcessTool.PARAM_MODULE_LEVEL);
                if ("off".equals(stringExtra)) {
                    TLogController.getInstance().cleanModuleFilter();
                    return;
                }
                Map<String, LogLevel> makeModule = TLogUtils.makeModule(stringExtra);
                if (makeModule != null && makeModule.size() > 0) {
                    TLogController.getInstance().addModuleFilter(makeModule);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void flushLog() {
        try {
            Log.e(TAG, "TLog MultiProcess flushLog");
            TLogNative.appenderFlushData(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onReceive$3(Intent intent) {
        try {
            Log.d(TAG, "Receive action: " + intent.getAction());
            char c = 65535;
            if (Process.myPid() == intent.getIntExtra(TLogMultiProcessTool.PARAM_PID, -1)) {
                Log.d(TAG, "The sender is current process!");
                return;
            }
            String action = intent.getAction();
            int hashCode = action.hashCode();
            if (hashCode != -836891243) {
                if (hashCode != -730623461) {
                    if (hashCode == -268762717) {
                        if (action.equals(TLogMultiProcessTool.ACTION_CHANGE_MODULE_LEVEL)) {
                            c = 2;
                        }
                    }
                } else if (action.equals(TLogMultiProcessTool.ACTION_FLUSH)) {
                    c = 0;
                }
            } else if (action.equals(TLogMultiProcessTool.ACTION_CHANGE_LOG_LEVEL)) {
                c = 1;
            }
            if (c == 0) {
                flushLog();
            } else if (c == 1) {
                changeLogLevel(intent);
            } else if (c == 2) {
                changeModuleLevel(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (!TLogMultiProcessTool.isEnable(context)) {
            Log.e(TAG, "The TLogMultiProcessNotify is disable");
        } else if (intent != null && intent.getAction() != null) {
            TLogThreadPool.getInstance().execute(new ki2(this, intent));
        }
    }
}
