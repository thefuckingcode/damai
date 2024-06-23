package cn.damai.launcher.splash.model.request;

import cn.damai.commonbusiness.wannasee.listener.OnBizListener;
import cn.damai.launcher.splash.model.AdFile;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import tb.xs0;

/* compiled from: Taobao */
public class TsAdDownloadRequest extends TimeSensitiveRequest<File> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String picUrl;

    public TsAdDownloadRequest(int i, String str) {
        super(i);
        this.picUrl = str;
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.launcher.splash.model.request.TimeSensitiveRequest
    public void callRequest(OnBizListener<File> onBizListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1783819375")) {
            ipChange.ipc$dispatch("-1783819375", new Object[]{this, onBizListener});
            return;
        }
        AdFile.downloadIfNoneCache(xs0.a(), this.picUrl, onBizListener);
    }
}
