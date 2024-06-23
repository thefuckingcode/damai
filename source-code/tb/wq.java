package tb;

import android.app.Activity;
import cn.damai.commonbusiness.screenshot.ScreenShotDetector;
import cn.damai.h5container.DMH5Fragment;

/* compiled from: Taobao */
public final /* synthetic */ class wq implements ScreenShotDetector.IScreenShotExtraListener {
    public final /* synthetic */ DMH5Fragment a;

    public /* synthetic */ wq(DMH5Fragment dMH5Fragment) {
        this.a = dMH5Fragment;
    }

    @Override // cn.damai.commonbusiness.screenshot.ScreenShotDetector.IScreenShotExtraListener
    public final void onDetected(String str, Activity activity) {
        DMH5Fragment.m28screenShotExtraListener$lambda6(this.a, str, activity);
    }
}
