package cn.damai.tetris.component.drama.mvp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.tetris.component.drama.bean.XBannerBean;
import cn.damai.tetris.component.drama.mvp.LoopViewPagerBannerContract;
import cn.damai.tetris.core.AbsView;
import cn.damai.uikit.banner.sub.BannerItem;
import cn.damai.uikit.banner.sub.XBanner;
import cn.damai.uikit.banner.sub.XIndicator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.g70;
import tb.v50;

/* compiled from: Taobao */
public class LoopViewPagerBannerView extends AbsView<LoopViewPagerBannerContract.Presenter> implements LoopViewPagerBannerContract.View<LoopViewPagerBannerContract.Presenter>, XBanner.OnBannerClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private final XBanner mXBanner;
    private ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER_CROP;
    private TextView titleView;

    /* compiled from: Taobao */
    public class a implements XBanner.BannerItemViewCreator {
        private static transient /* synthetic */ IpChange $ipChange;

        /* renamed from: cn.damai.tetris.component.drama.mvp.LoopViewPagerBannerView$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public class C0048a implements DMImageCreator.DMImageFailListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ ImageView a;

            C0048a(a aVar, ImageView imageView) {
                this.a = imageView;
            }

            @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
            public void onFail(DMImageCreator.d dVar) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-442541112")) {
                    ipChange.ipc$dispatch("-442541112", new Object[]{this, dVar});
                    return;
                }
                this.a.setImageResource(R$drawable.uikit_default_image_bg_gradient_v2);
            }
        }

        /* compiled from: Taobao */
        public class b implements DMImageCreator.DMImageSuccListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ ImageView a;

            b(a aVar, ImageView imageView) {
                this.a = imageView;
            }

            @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
            public void onSuccess(DMImageCreator.e eVar) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "762402653")) {
                    ipChange.ipc$dispatch("762402653", new Object[]{this, eVar});
                    return;
                }
                this.a.setImageDrawable(eVar.a);
            }
        }

        a() {
        }

        @Override // cn.damai.uikit.banner.sub.XBanner.BannerItemViewCreator
        public void bindItemView(BannerItem bannerItem, View view, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "339324634")) {
                ipChange.ipc$dispatch("339324634", new Object[]{this, bannerItem, view, Integer.valueOf(i)});
                return;
            }
            ((LoopViewPagerBannerContract.Presenter) LoopViewPagerBannerView.this.getPresenter()).exposeBanner(view, bannerItem, i);
            ImageView imageView = (ImageView) view.findViewById(R$id.x_spec_item_img);
            imageView.setScaleType(LoopViewPagerBannerView.this.scaleType);
            String bannerPicUrl = bannerItem.bannerPicUrl();
            imageView.setImageResource(R$drawable.uikit_default_image_bg_grey);
            cn.damai.common.image.a.b().c(bannerPicUrl).n(new b(this, imageView)).e(new C0048a(this, imageView)).f();
        }

        @Override // cn.damai.uikit.banner.sub.XBanner.BannerItemViewCreator
        public View inflateItemView(Context context, ViewGroup viewGroup) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1657047658")) {
                return LayoutInflater.from(context).inflate(R$layout.item_tetris_x_banner_item, viewGroup, false);
            }
            return (View) ipChange.ipc$dispatch("-1657047658", new Object[]{this, context, viewGroup});
        }
    }

    public LoopViewPagerBannerView(View view) {
        super(view);
        XBanner xBanner = (XBanner) view.findViewById(R$id.loop_banner);
        this.mXBanner = xBanner;
        int i = R$id.tetris_bannerdefault_title;
        if (view.findViewById(i) != null) {
            view.findViewById(i).setVisibility(0);
            this.titleView = (TextView) view.findViewById(R$id.tv_project_tip);
        }
        xBanner.setViewCreator(new a());
        xBanner.setBannerClickListener(this);
        xBanner.setListener((XIndicator) view.findViewById(R$id.loop_indicator));
    }

    @Override // cn.damai.tetris.component.drama.mvp.LoopViewPagerBannerContract.View
    public void clean() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1988664694")) {
            ipChange.ipc$dispatch("1988664694", new Object[]{this});
            return;
        }
        XBanner xBanner = this.mXBanner;
        if (xBanner != null) {
            xBanner.stopAnimation();
            this.mXBanner.setAdapter(null);
        }
    }

    @Override // cn.damai.tetris.component.drama.mvp.LoopViewPagerBannerContract.View
    public TextView getTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-475608099")) {
            return this.titleView;
        }
        return (TextView) ipChange.ipc$dispatch("-475608099", new Object[]{this});
    }

    @Override // cn.damai.uikit.banner.sub.XBanner.OnBannerClickListener
    public void onBannerClick(BannerItem bannerItem, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-57280069")) {
            ipChange.ipc$dispatch("-57280069", new Object[]{this, bannerItem, Integer.valueOf(i)});
            return;
        }
        ((LoopViewPagerBannerContract.Presenter) getPresenter()).itemClick(this, bannerItem, i);
    }

    @Override // cn.damai.tetris.component.drama.mvp.LoopViewPagerBannerContract.View
    public void onUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1489781572")) {
            ipChange.ipc$dispatch("1489781572", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        XBanner xBanner = this.mXBanner;
        if (xBanner == null) {
            return;
        }
        if (z) {
            xBanner.startAnimationIfNeed();
        } else {
            xBanner.stopAnimation();
        }
    }

    @Override // cn.damai.tetris.component.drama.mvp.LoopViewPagerBannerContract.View
    public void setData(List<XBannerBean> list, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1712266591")) {
            ipChange.ipc$dispatch("1712266591", new Object[]{this, list, Integer.valueOf(i)});
        } else if (list != null) {
            this.mXBanner.update(list);
            if (list.get(0) != null && list.get(0).width > 0 && list.get(0).height > 0) {
                int d = ((g70.d() - v50.a(getContext().getActivity(), 42.0f)) * list.get(0).height) / list.get(0).width;
                ViewGroup.LayoutParams layoutParams = this.mXBanner.getLayoutParams();
                layoutParams.width = g70.d();
                layoutParams.height = d;
                this.mXBanner.setLayoutParams(layoutParams);
                this.scaleType = ImageView.ScaleType.FIT_XY;
            }
        }
    }
}
