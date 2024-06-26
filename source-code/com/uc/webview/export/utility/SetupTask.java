package com.uc.webview.export.utility;

import android.util.Pair;
import com.uc.webview.export.annotations.Api;
import com.uc.webview.export.cyclone.UCHashMap;
import com.uc.webview.export.cyclone.UCLogger;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.setup.UCSetupException;
import com.uc.webview.export.internal.setup.UCSetupTask;
import com.uc.webview.export.internal.setup.bt;
import com.uc.webview.export.internal.utility.Log;
import java.util.Map;

@Api
/* compiled from: Taobao */
public abstract class SetupTask extends UCSetupTask<SetupTask, SetupTask> {
    public static bt sFirstUCM;
    private final String a = "SetupTask";

    /* access modifiers changed from: protected */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
    public void callStatException(String str, UCSetupException uCSetupException) {
        String str2;
        String str3 = "";
        try {
            str2 = uCSetupException.getRootCause().getClass().getName();
            String message = uCSetupException.getRootCause().getMessage();
            int i = 256;
            if (256 > message.length()) {
                i = message.length();
            }
            str3 = message.substring(0, i);
        } catch (Exception unused) {
            str2 = str3;
        }
        try {
            callbackStat(new Pair<>(str, new UCHashMap().set("cnt", "1").set("err", String.valueOf(uCSetupException.errCode())).set("cls", str2).set("msg", str3)));
        } catch (Throwable unused2) {
        }
    }

    public void callbackFinishStat(String str) {
        UCLogger create = UCLogger.create("i", "SetupTask");
        if (create != null) {
            create.print("finish: core=" + str, new Throwable[0]);
        }
    }

    public String getFirstUCMFileHashs() {
        StringBuilder sb = new StringBuilder();
        try {
            bt btVar = sFirstUCM;
            if (btVar != null) {
                for (Map.Entry<String, String> entry : btVar.getFileHashs().entrySet()) {
                    sb.append(entry.getKey());
                    sb.append("=");
                    sb.append(entry.getValue());
                    sb.append(";");
                }
            } else {
                sb.append("first_ucm=null;");
            }
        } catch (Throwable th) {
            Log.d("SetupTask", "getFirstUCMFileHashs error", th);
        }
        return sb.toString();
    }

    @Override // com.uc.webview.export.internal.setup.UCAsyncTask
    public int getPercent() {
        return super.getPercent();
    }

    @Override // com.uc.webview.export.internal.setup.UCAsyncTask
    public void setException(UCSetupException uCSetupException) {
        setException(uCSetupException, true);
    }

    public void startSync() {
        start();
        try {
            Thread.sleep(200);
        } catch (Throwable unused) {
        }
        SDKFactory.h();
    }

    @Override // com.uc.webview.export.internal.setup.BaseSetupTask
    public SetupTask setAsDefault() {
        SDKFactory.t = this;
        SDKFactory.k = true;
        return this;
    }

    public void setException(UCSetupException uCSetupException, boolean z) {
        super.setException(uCSetupException);
        callStatException(IWaStat.SETUP_TOTAL_EXCEPTION, uCSetupException);
        callbackFinishStat("0");
        if (z) {
            SDKFactory.a(uCSetupException.toRunnable());
        }
    }
}
