package tb;

import android.text.TextUtils;
import cn.damai.solid.util.Constant;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.solid.monitor.IMonitor;
import com.youku.arch.solid.monitor.SolidMonitor;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class jf1 implements IMonitor {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            int[] iArr = new int[SolidMonitor.Stage.values().length];
            a = iArr;
            iArr[SolidMonitor.Stage.SOLID_LIB_START_DOWNLOAD.ordinal()] = 1;
            a[SolidMonitor.Stage.SOLID_LIB_DOWNLOAD.ordinal()] = 2;
        }
    }

    @Override // com.youku.arch.solid.monitor.IMonitor
    public void reportStageResult(SolidMonitor.Stage stage, Map<SolidMonitor.Params, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "64385523")) {
            ipChange.ipc$dispatch("64385523", new Object[]{this, stage, map});
            return;
        }
        cn.damai.solid.a.f("reportStageResult stageName " + stage.name());
        try {
            int i = a.a[stage.ordinal()];
            if (i == 1) {
                String str = map.get(SolidMonitor.Params.LIB_NAME);
                vc2.e(str);
                cn.damai.solid.a.f("SOLID_LIB_START_DOWNLOAD start libName=" + str);
            } else if (i == 2) {
                String str2 = map.get(SolidMonitor.Params.SUCCESS);
                String str3 = map.get(SolidMonitor.Params.LIB_NAME);
                if (str3 == null) {
                    str3 = "unknown.lib";
                }
                HashMap hashMap = new HashMap();
                hashMap.put("libName", str3);
                if (TextUtils.equals("1", str2)) {
                    vc2.d(hashMap);
                } else {
                    String str4 = map.get(SolidMonitor.Params.ERROR_MSG);
                    if (str4 == null) {
                        str4 = "xcdn_download_fail";
                    }
                    vc2.c(Constant.CODE_XCDN_DOWNLOAD_FAIL, str4, hashMap);
                }
                cn.damai.solid.a.f("SOLID_LIB_DOWNLOAD end libName=" + str3 + " status=" + str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
