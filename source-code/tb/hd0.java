package tb;

import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.ImageData;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class hd0 implements RequestListener<ImageData, vz0> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* renamed from: a */
    public void onSuccess(kl1<vz0> kl1, ImageData imageData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2091406236")) {
            ipChange.ipc$dispatch("-2091406236", new Object[]{this, kl1, imageData});
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
    public void onFail(kl1<vz0> kl1, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1420561734")) {
            ipChange.ipc$dispatch("-1420561734", new Object[]{this, kl1, str, str2});
        }
    }
}
