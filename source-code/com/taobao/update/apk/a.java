package com.taobao.update.apk;

import android.content.Intent;
import com.taobao.update.adapter.UpdateMonitor;
import com.taobao.update.apk.ApkUpdateContext;
import com.taobao.update.apk.processor.KillAppProcessor;
import com.taobao.update.framework.UpdateRuntime;
import com.taobao.update.utils.Constants;
import tb.be0;
import tb.dj2;
import tb.eb;
import tb.j6;
import tb.pi1;
import tb.zj1;

/* compiled from: Taobao */
public class a {
    private UpdateMonitor a = null;

    public a() {
        try {
            this.a = (UpdateMonitor) eb.getInstance(UpdateMonitor.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ApkUpdateContext a(boolean z, MainUpdateData mainUpdateData) {
        ApkUpdateContext apkUpdateContext = new ApkUpdateContext();
        apkUpdateContext.context = UpdateRuntime.getContext();
        apkUpdateContext.background = z;
        apkUpdateContext.mainUpdate = mainUpdateData;
        String str = mainUpdateData.version;
        String downloadUrl = mainUpdateData.getDownloadUrl();
        UpdateMonitor updateMonitor = this.a;
        if (updateMonitor != null) {
            updateMonitor.add("apefficiency", true, "revupdate", "", "", str, downloadUrl, 0, 0);
        }
        UpdateRuntime.log("UpdateFlowController start to execute in background " + z);
        j6.getProcessor(be0.class).execute(apkUpdateContext);
        UpdateMonitor updateMonitor2 = this.a;
        if (updateMonitor2 != null) {
            updateMonitor2.add("apefficiency", apkUpdateContext.success, "disk", String.valueOf(apkUpdateContext.errorCode), apkUpdateContext.errorMsg, str, downloadUrl, 0, 0);
        }
        if (!apkUpdateContext.success) {
            UpdateRuntime.log("UpdateFlowController failed to pass EnvCheckProcessor " + apkUpdateContext);
            return apkUpdateContext;
        }
        UpdateRuntime.log("UpdateFlowController start to do apk update ");
        j6.getProcessor(zj1.class).execute(apkUpdateContext);
        UpdateMonitor updateMonitor3 = this.a;
        if (updateMonitor3 != null) {
            updateMonitor3.add("apefficiency", apkUpdateContext.success, "notifytimes", String.valueOf(apkUpdateContext.errorCode), apkUpdateContext.errorMsg, str, downloadUrl, 0, 0);
        }
        if (!apkUpdateContext.success) {
            if (apkUpdateContext.exceedUpdateTimes.booleanValue()) {
                UpdateRuntime.log("update check not pass, exceedUpdateTimes=true");
            } else {
                UpdateRuntime.log("update check not pass, exceedUpdateTimes=false");
            }
            UpdateRuntime.log("UpdateFlowController failed to pass NotifyTimesCheckProcessor " + apkUpdateContext);
            return apkUpdateContext;
        } else if (apkUpdateContext.isForceUpdate() || apkUpdateContext.notifyPolicy == ApkUpdateContext.NotifyPolicy.DEFAULT) {
            return pi1.getInstance().doUpdate(apkUpdateContext, str, downloadUrl);
        } else {
            return apkUpdateContext;
        }
    }

    public dj2 execute(boolean z, MainUpdateData mainUpdateData) {
        ApkUpdateContext apkUpdateContext = null;
        try {
            Intent intent = new Intent(Constants.UPDATE_MESSAGE_NAME);
            intent.putExtra(Constants.HAS_APk_UPDATE, true);
            UpdateRuntime.getContext().sendBroadcast(intent);
            apkUpdateContext = a(z, mainUpdateData);
            UpdateMonitor updateMonitor = this.a;
            if (updateMonitor != null) {
                updateMonitor.commit("apefficiency");
            }
            if (apkUpdateContext.isForceUpdate() && !apkUpdateContext.isDownloadError) {
                UpdateRuntime.log("UpdateFlowController start to do KillAppProcessor ");
                new KillAppProcessor().execute(apkUpdateContext);
            }
        } catch (Throwable th) {
            UpdateRuntime.log("do apk update error", th);
        }
        return apkUpdateContext;
    }
}
