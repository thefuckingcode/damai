package cn.damai.launcher.splash.model.listener;

import androidx.annotation.NonNull;
import cn.damai.launcher.splash.api.SplashApi;
import cn.damai.launcher.splash.api.SplashResponse;
import cn.damai.launcher.ut.LauncherUTHelper;
import cn.damai.launcher.utils.SplashXFlushHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import tb.d20;

/* compiled from: Taobao */
public class OnAdXFlushProcessor implements OnAdFetchListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isUseCache;
    private SplashResponse mResponse;

    public OnAdXFlushProcessor(boolean z) {
        this.isUseCache = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002a, code lost:
        if (r9 != 5) goto L_0x0068;
     */
    @Override // cn.damai.launcher.splash.model.listener.OnAdFetchListener
    public void dispatchAdFetchPhaseFail(int i, String str, String str2) {
        SplashResponse splashResponse;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-660729261")) {
            ipChange.ipc$dispatch("-660729261", new Object[]{this, Integer.valueOf(i), str, str2});
            return;
        }
        if (i != 2) {
            String str3 = "";
            if (i == 3) {
                SplashResponse splashResponse2 = this.mResponse;
                if (splashResponse2 != null) {
                    str3 = splashResponse2.getPic();
                }
                SplashXFlushHelper.b(String.valueOf(str), "DMImageLoader.onFail", d20.c(), str3);
            } else if (i == 4) {
                SplashResponse splashResponse3 = this.mResponse;
                if (splashResponse3 != null) {
                    str3 = splashResponse3.getPic();
                }
                SplashXFlushHelper.b(String.valueOf(str), "ad_file_turn_to_drawable_fail", d20.c(), str3);
            }
            z = true;
        } else {
            SplashXFlushHelper.e(SplashApi.API_SPLASH_ADVERT, str, str2, "n/a", d20.c());
        }
        if (!this.isUseCache && z && (splashResponse = this.mResponse) != null && splashResponse.isPicUrlValid()) {
            LauncherUTHelper.getInstance().j(this.mResponse.getPic(), this.mResponse.getSchema());
        }
    }

    @Override // cn.damai.launcher.splash.model.listener.OnAdFetchListener
    public void dispatchAdFetchSuccess(@NonNull File file, @NonNull SplashResponse splashResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1419370945")) {
            ipChange.ipc$dispatch("-1419370945", new Object[]{this, file, splashResponse});
            return;
        }
        this.mResponse = splashResponse;
    }
}
