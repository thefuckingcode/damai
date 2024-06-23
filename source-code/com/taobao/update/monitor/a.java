package com.taobao.update.monitor;

import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.taobao.tao.log.statistics.TLogEventConst;
import java.util.HashMap;
import java.util.Map;
import tb.gs2;
import tb.ns2;

/* compiled from: Taobao */
public class a {
    private Map<String, Boolean> a = new HashMap(2);

    private synchronized void a(String str) {
        if (this.a.get(str) == null) {
            this.a.put(str, Boolean.TRUE);
            AppMonitor.register("update", str, MeasureSet.create().addMeasure("elapsed_time"), DimensionSet.create().addDimension("fromVersion").addDimension("toVersion").addDimension(TLogEventConst.PARAM_UPLOAD_STAGE).addDimension("success").addDimension("error_code").addDimension("error_msg").addDimension("url").addDimension("disk_size"));
        }
    }

    /* access modifiers changed from: protected */
    public void b(String str, gs2 gs2) {
        if (gs2 != null) {
            a(str);
            AppMonitor.Stat.commit("update", str, DimensionValueSet.create().setValue("fromVersion", TextUtils.isEmpty(gs2.fromVersion) ? ns2.getVersionName() : gs2.fromVersion).setValue("toVersion", gs2.toVersion).setValue(TLogEventConst.PARAM_UPLOAD_STAGE, gs2.arg).setValue("success", gs2.success ? "true" : "false").setValue("error_code", gs2.errorCode).setValue("error_msg", gs2.errorMsg).setValue("url", gs2.url).setValue("disk_size", gs2.disk_size), MeasureValueSet.create().setValue("elapsed_time", (double) gs2.elapsed_time));
        }
    }
}
