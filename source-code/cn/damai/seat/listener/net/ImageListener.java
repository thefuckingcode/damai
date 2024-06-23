package cn.damai.seat.listener.net;

import android.text.TextUtils;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.ImageData;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.kl1;
import tb.u62;
import tb.vz0;

/* compiled from: Taobao */
public abstract class ImageListener implements RequestListener<ImageData, vz0> {
    private static transient /* synthetic */ IpChange $ipChange;
    private long itemId;
    private long performId;

    public ImageListener(long j, long j2) {
        this.itemId = j;
        this.performId = j2;
    }

    private void sunFire(kl1<vz0> kl1, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "156266826")) {
            ipChange.ipc$dispatch("156266826", new Object[]{this, kl1, str, str2});
            return;
        }
        String d = kl1.d();
        if (!kl1.a().c()) {
            u62.i(d, "unknown", str, this.itemId + "", this.performId + "");
        } else if (TextUtils.equals(str, ImageData.CODE_SVG_BUILD_FAIL)) {
            u62.l(d, "unknown", str, this.itemId + "", this.performId + "");
        } else {
            u62.j(d, str2, str, this.itemId + "", this.performId + "");
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
    public void onFail(kl1<vz0> kl1, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "299361475")) {
            ipChange.ipc$dispatch("299361475", new Object[]{this, kl1, str, str2});
            return;
        }
        if (!(kl1 == null || kl1.a() == null)) {
            sunFire(kl1, str, str2);
        }
        onNetFail(kl1, str, str2);
    }

    public abstract void onNetFail(kl1<vz0> kl1, String str, String str2);

    public abstract void onNetSuccess(kl1<vz0> kl1, ImageData imageData);

    public void onSuccess(kl1<vz0> kl1, ImageData imageData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1580550867")) {
            ipChange.ipc$dispatch("-1580550867", new Object[]{this, kl1, imageData});
            return;
        }
        if (imageData.isSvg() && !imageData.isHasFloorId()) {
            u62.k(kl1.d(), "unknown", ImageData.CODE_SVG_NONE_FLOOR, this.itemId + "", this.performId + "");
        }
        onNetSuccess(kl1, imageData);
    }
}
