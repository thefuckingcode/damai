package tb;

import cn.damai.commonbusiness.home.bean.HeadLottieStyleBean;
import cn.damai.message.observer.Action;
import cn.damai.tetris.component.home.viewholder.BannerViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
public class yy2 implements Action<HeadLottieStyleBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    private WeakReference<BannerViewHolder> a;

    public yy2(BannerViewHolder bannerViewHolder) {
        this.a = new WeakReference<>(bannerViewHolder);
    }

    /* renamed from: a */
    public void call(HeadLottieStyleBean headLottieStyleBean) {
        BannerViewHolder bannerViewHolder;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1513815316")) {
            ipChange.ipc$dispatch("1513815316", new Object[]{this, headLottieStyleBean});
            return;
        }
        WeakReference<BannerViewHolder> weakReference = this.a;
        if (weakReference != null && (bannerViewHolder = weakReference.get()) != null) {
            bannerViewHolder.updateUiByHeadLottieStyle(headLottieStyleBean);
        }
    }
}
