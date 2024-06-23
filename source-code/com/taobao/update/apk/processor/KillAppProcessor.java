package com.taobao.update.apk.processor;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import com.taobao.update.apk.ApkUpdateContext;
import com.taobao.update.framework.Processor;
import tb.ns2;

/* compiled from: Taobao */
public class KillAppProcessor implements Processor<ApkUpdateContext> {
    public void execute(final ApkUpdateContext apkUpdateContext) {
        if (apkUpdateContext.isForceUpdate()) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                /* class com.taobao.update.apk.processor.KillAppProcessor.AnonymousClass1 */

                public void run() {
                    ns2.killChildProcesses(apkUpdateContext.context);
                    int myPid = Process.myPid();
                    Log.d("Updater", "atlas killprocess:" + myPid);
                    Process.killProcess(myPid);
                }
            }, 1000);
        }
    }
}
