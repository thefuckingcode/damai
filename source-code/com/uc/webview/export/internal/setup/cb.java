package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCHashMap;
import com.uc.webview.export.cyclone.UCKnownException;
import com.uc.webview.export.cyclone.update.UpdateService;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.update.b;
import java.io.File;
import java.util.Map;
import java.util.concurrent.Callable;

/* compiled from: Taobao */
final class cb extends b.a {
    final /* synthetic */ File a;
    final /* synthetic */ bq b;
    final /* synthetic */ by c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    cb(by byVar, Context context, Callable callable, Map map, File file, bq bqVar) {
        super(context, callable, map);
        this.c = byVar;
        this.a = file;
        this.b = bqVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        if (r2.getAbsolutePath().startsWith(r4.a.getAbsolutePath()) == false) goto L_0x0024;
     */
    @Override // com.uc.webview.export.internal.update.b.a
    public final void a(UpdateService updateService) {
        File file;
        bt btVar;
        String str;
        try {
            UCMRunningInfo totalLoadedUCM = UCSetupTask.getTotalLoadedUCM();
            if (!(totalLoadedUCM == null || (btVar = totalLoadedUCM.ucmPackageInfo) == null || (str = btVar.dataDir) == null)) {
                file = new File(str);
            }
            file = null;
            File file2 = this.a;
            if (file == null) {
                file = updateService.getExtractDir();
            }
            UCCyclone.recursiveDelete(file2, true, file);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            super.a(updateService);
            this.c.callbackStat(new Pair<>("sdk_ucm_wifi", null));
        } catch (Throwable th2) {
            throw new RuntimeException(th2.getMessage());
        }
    }

    @Override // com.uc.webview.export.internal.update.b.a
    public final void b(UpdateService updateService) {
        synchronized (this.c) {
            this.c.h = true;
        }
        super.b(updateService);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:8|(1:10)(1:11)|12|(2:13|14)|15|17|18|19|20|21) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0059 */
    @Override // com.uc.webview.export.internal.update.b.a
    public final void c(UpdateService updateService) {
        synchronized (this.c) {
            this.c.h = true;
        }
        try {
            if (this.c.getExtraException() == null) {
                Throwable exception = updateService.getException();
                String str = "";
                String str2 = "";
                String str3 = "";
                UCKnownException uCKnownException = exception instanceof UCKnownException ? (UCKnownException) exception : new UCKnownException(exception);
                String str4 = "" + uCKnownException.errCode();
                try {
                    str2 = uCKnownException.getRootCause().getMessage();
                } catch (Throwable unused) {
                }
                str3 = String.valueOf(Integer.parseInt(str2.substring(str2.indexOf("httpcode:") + 9)));
                str = uCKnownException.getRootCause().getClass().getSimpleName();
                this.c.callbackStat(new Pair<>(IWaStat.SETUP_TASK_UPDATE, new UCHashMap().set("cnt", "1").set("code", str3).set("err", str4).set("cls", str).set("msg", str2)));
            }
            if (updateService.getException() != null) {
                this.c.setExtraException(new UCSetupException(updateService.getException()));
            }
            ValueCallback callback = this.c.getCallback(UCCore.EVENT_DOWNLOAD_EXCEPTION);
            if (callback != null) {
                callback.onReceiveValue(this.c);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.c(updateService);
    }

    @Override // com.uc.webview.export.internal.update.b.a
    public final void d(UpdateService updateService) {
        super.d(updateService);
        this.b.a(0, null);
    }

    @Override // com.uc.webview.export.internal.update.b.a
    public final void e(UpdateService updateService) {
        synchronized (this.c) {
            this.c.i = true;
        }
        Throwable exception = updateService.getException();
        super.e(updateService);
        this.b.a(3, exception);
        ValueCallback callback = this.c.getCallback(UCCore.EVENT_DOWNLOAD_FAILED);
        if (callback != null) {
            callback.onReceiveValue(this.c);
        }
    }

    @Override // com.uc.webview.export.internal.update.b.a
    public final void f(UpdateService updateService) {
        super.f(updateService);
        this.b.a(4, null);
    }

    @Override // com.uc.webview.export.internal.update.b.a
    public final void g(UpdateService updateService) {
        super.g(updateService);
        File downloadFile = updateService.getDownloadFile();
        if (downloadFile != null) {
            this.c.c = downloadFile.getAbsolutePath();
        }
        ValueCallback callback = this.c.getCallback(UCCore.EVENT_DOWNLOAD_FILE_DELETE);
        if (callback != null) {
            callback.onReceiveValue(this.c);
        }
    }

    @Override // com.uc.webview.export.internal.update.b.a
    public final void h(UpdateService updateService) {
        super.h(updateService);
        this.c.mPercent = updateService.getPercent();
        ValueCallback callback = this.c.getCallback(UCCore.EVENT_UPDATE_PROGRESS);
        if (callback != null) {
            callback.onReceiveValue(this.c);
        }
    }
}
