package tb;

import android.app.Application;
import com.alibaba.pictures.share.R$string;
import com.alibaba.pictures.share.ShareManager;
import com.alibaba.pictures.share.common.share.ShareChannel;
import com.alibaba.pictures.share.common.share.ShareException;
import com.alibaba.pictures.share.common.share.ShareService;
import com.alibaba.pictures.share.common.util.ShareUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.passport.result.AbsResult;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.Nullable;

@JvmName(name = "CallBackUtils")
/* compiled from: Taobao */
public final class df {
    private static transient /* synthetic */ IpChange $ipChange;

    public static final void a(@Nullable ShareChannel shareChannel, int i) {
        ShareManager.IShareMonitor r;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1150176136")) {
            ipChange.ipc$dispatch("-1150176136", new Object[]{shareChannel, Integer.valueOf(i)});
            return;
        }
        v92.d("CallBackUtils", "onException:" + i);
        z92 z92 = z92.INSTANCE;
        if (shareChannel == ShareChannel.WEIBO && i == 1003) {
            Application a = ShareManager.INSTANCE.a();
            if (a != null) {
                String string = a.getString(R$string.share_fail);
                k21.h(string, "getString(R.string.share_fail)");
                ShareUtil.n(string);
            } else {
                v92.f();
                ur2 ur2 = ur2.INSTANCE;
            }
        }
        ShareService.ShareActionListener a2 = z92.a();
        if (a2 != null) {
            a2.onException(shareChannel, new ShareException(i));
        }
        if (shareChannel != null && (r = ShareManager.INSTANCE.b().r()) != null) {
            r.shareResult(shareChannel, 2, new ShareException(i).getStatusMsg());
        }
    }

    public static final void b(@Nullable ShareChannel shareChannel) {
        ShareManager.IShareMonitor r;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-291152905")) {
            ipChange.ipc$dispatch("-291152905", new Object[]{shareChannel});
            return;
        }
        v92.d("CallBackUtils", "onSuccess");
        ShareService.ShareActionListener a = z92.INSTANCE.a();
        if (a != null) {
            a.onComplete(shareChannel);
        }
        if (shareChannel != null && (r = ShareManager.INSTANCE.b().r()) != null) {
            r.shareResult(shareChannel, 1, AbsResult.MSG_SUCCESS);
        }
    }
}
