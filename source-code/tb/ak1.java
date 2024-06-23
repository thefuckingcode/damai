package tb;

import android.text.TextUtils;
import android.util.Log;
import com.taobao.update.adapter.UserAction;
import com.taobao.update.apk.ApkUpdateContext;
import com.taobao.update.apk.MainUpdateData;
import com.taobao.update.framework.Processor;
import com.taobao.update.framework.UpdateRuntime;
import com.taobao.update.main.R$string;
import java.text.DecimalFormat;
import java.util.concurrent.CountDownLatch;

/* compiled from: Taobao */
public class ak1 implements Processor<ApkUpdateContext> {
    private h6 a = new h6();

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements UserAction {
        final /* synthetic */ ApkUpdateContext a;
        final /* synthetic */ CountDownLatch b;

        /* renamed from: tb.ak1$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        class C0296a implements UserAction {
            C0296a() {
            }

            @Override // com.taobao.update.adapter.UserAction
            public String getCancelText() {
                return "退出";
            }

            @Override // com.taobao.update.adapter.UserAction
            public String getConfirmText() {
                return "立即下载";
            }

            @Override // com.taobao.update.adapter.UserAction
            public String getTitleText() {
                return null;
            }

            @Override // com.taobao.update.adapter.UserAction
            public void onCancel() {
                ak1.this.a.commitNotify(a.this.a, "ForceUpdateClickCancel", Boolean.TRUE, null);
                a aVar = a.this;
                ApkUpdateContext apkUpdateContext = aVar.a;
                apkUpdateContext.success = false;
                apkUpdateContext.errorCode = -51;
                aVar.b.countDown();
            }

            @Override // com.taobao.update.adapter.UserAction
            public void onConfirm() {
                ak1.this.a.commitNotify(a.this.a, "ForceUpdateClickConfirm", Boolean.TRUE, null);
                a.this.b.countDown();
            }
        }

        a(ApkUpdateContext apkUpdateContext, CountDownLatch countDownLatch) {
            this.a = apkUpdateContext;
            this.b = countDownLatch;
        }

        @Override // com.taobao.update.adapter.UserAction
        public String getCancelText() {
            return "取消";
        }

        @Override // com.taobao.update.adapter.UserAction
        public String getConfirmText() {
            return "立即下载";
        }

        @Override // com.taobao.update.adapter.UserAction
        public String getTitleText() {
            return null;
        }

        @Override // com.taobao.update.adapter.UserAction
        public void onCancel() {
            if (this.a.isForceUpdate()) {
                ak1.this.a.commitNotify(this.a, "clickCancel", Boolean.TRUE, "ForceUpdate");
                UpdateRuntime.doUIAlertForConfirm(ns2.getAppNameString(R$string.confirm_forceupdate_cancel, UpdateRuntime.sAppName), new C0296a());
                return;
            }
            ak1.this.a.commitNotify(this.a, "clickCancel", Boolean.TRUE, null);
            ApkUpdateContext apkUpdateContext = this.a;
            apkUpdateContext.success = false;
            apkUpdateContext.errorCode = -51;
            this.b.countDown();
        }

        @Override // com.taobao.update.adapter.UserAction
        public void onConfirm() {
            ak1.this.a.commitNotify(this.a, "clickConfirm", Boolean.TRUE, null);
            this.b.countDown();
        }
    }

    private String b(long j) {
        if (j / 1048576 > 0) {
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            return "" + decimalFormat.format((double) (((float) j) / 1048576.0f)) + "MB";
        }
        long j2 = j / 1024;
        if (j2 > 0) {
            return "" + j2 + "KB";
        }
        return "" + j + "B";
    }

    private boolean c(ApkUpdateContext apkUpdateContext) {
        return !apkUpdateContext.isSilentUpdate();
    }

    public void execute(ApkUpdateContext apkUpdateContext) {
        MainUpdateData mainUpdateData = apkUpdateContext.mainUpdate;
        if (mainUpdateData == null || TextUtils.isEmpty(mainUpdateData.getDownloadUrl())) {
            apkUpdateContext.success = false;
            apkUpdateContext.errorCode = 31;
            Log.d("Updater", "no update");
            return;
        }
        u21 u21 = new u21();
        u21.a = mainUpdateData.getDownloadUrl();
        u21.b = mainUpdateData.size;
        u21.c = mainUpdateData.md5;
        String d = ub0.c().d(ns2.getStorePath(apkUpdateContext.context) + "/apkupdate/" + mainUpdateData.version, u21);
        if (!TextUtils.isEmpty(d)) {
            Log.d("Updater", "apk has downloaded");
            apkUpdateContext.apkPath = d;
        } else if (c(apkUpdateContext)) {
            apkUpdateContext.hasNotified = true;
            CountDownLatch countDownLatch = new CountDownLatch(1);
            a aVar = new a(apkUpdateContext, countDownLatch);
            Log.d("Updater", "start to doUIAlertForConfirm");
            UpdateRuntime.doUIAlertForConfirm(mainUpdateData.info + "\n\n更新包大小：" + b(mainUpdateData.size), aVar);
            this.a.commitNotify(apkUpdateContext, "popUpdate", Boolean.TRUE, null);
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
                this.a.commitNotify(apkUpdateContext, "popUpdate", Boolean.FALSE, "popUpdate failure");
            }
        }
    }
}
