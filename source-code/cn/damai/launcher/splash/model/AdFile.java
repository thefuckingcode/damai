package cn.damai.launcher.splash.model;

import android.content.Context;
import cn.damai.commonbusiness.wannasee.listener.OnBizListener;
import cn.damai.launcher.splash.model.bean.AdFileResult;
import cn.damai.launcher.splash.model.listener.OnAdMainThreadFileListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import tb.b72;
import tb.sb0;
import tb.ub0;
import tb.wb1;

/* compiled from: Taobao */
public class AdFile {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String AD_DIR = "ad_dir";

    private AdFile() {
    }

    public static void downloadIfNoneCache(Context context, String str, final OnBizListener<File> onBizListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1963997849")) {
            ipChange.ipc$dispatch("-1963997849", new Object[]{context, str, onBizListener});
            return;
        }
        AdFileResult isHasCacheAdFile = isHasCacheAdFile(context, str);
        if (isHasCacheAdFile.isHasCacheAdFile) {
            onBizListener.onBizSuccess(isHasCacheAdFile.cacheAdFile);
            return;
        }
        sb0 sb0 = new sb0(str);
        b72.d(getAdDir(context));
        sb0.b.f = getAdDir(context).getAbsolutePath();
        sb0.a.get(0).d = getAdFileName(str);
        sb0.b.m = true;
        ub0.c().b(sb0, new OnAdMainThreadFileListener(new OnBizListener<String>() {
            /* class cn.damai.launcher.splash.model.AdFile.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.commonbusiness.wannasee.listener.OnBizListener
            public void onBizFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1318405993")) {
                    ipChange.ipc$dispatch("1318405993", new Object[]{this, str, str2});
                    return;
                }
                OnBizListener.this.onBizFail(str, str2);
            }

            public void onBizSuccess(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-616602786")) {
                    ipChange.ipc$dispatch("-616602786", new Object[]{this, str});
                    return;
                }
                OnBizListener.this.onBizSuccess(new File(str));
            }
        }));
    }

    private static File getAdDir(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "359087271")) {
            return (File) ipChange.ipc$dispatch("359087271", new Object[]{context});
        }
        File file = new File(context.getFilesDir(), AD_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File getAdFile(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2081823398")) {
            return new File(getAdDir(context), getAdFileName(str));
        }
        return (File) ipChange.ipc$dispatch("-2081823398", new Object[]{context, str});
    }

    public static String getAdFileName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-481110142")) {
            return (String) ipChange.ipc$dispatch("-481110142", new Object[]{str});
        }
        return wb1.b(str) + "_temp";
    }

    public static AdFileResult isHasCacheAdFile(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1263140855")) {
            return (AdFileResult) ipChange.ipc$dispatch("1263140855", new Object[]{context, str});
        }
        File adFile = getAdFile(context, str);
        if (adFile.exists() && adFile.isFile()) {
            return new AdFileResult(true, adFile);
        }
        return new AdFileResult(false, null);
    }
}
