package cn.damai.tetris.component.home.viewholder;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.home.bean.HeadLottieStyleBean;
import cn.damai.tetris.component.home.bean.BannerItem;
import cn.damai.tetris.component.home.bean.BannerResultBean;
import cn.damai.tetris.component.home.widget.banner.Banner;
import cn.damai.tetris.component.home.widget.banner.BannerViewLoader;
import cn.damai.tetris.component.home.widget.banner.listener.OnBannerListener;
import cn.damai.tetris.component.home.widget.banner.listener.OnTagListener;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.mvp.CommonBean;
import cn.damai.tetris.mvp.CommonViewHolder;
import com.alimm.xadsdk.base.expose.MonitorType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.br;
import tb.g70;
import tb.ne2;
import tb.pn2;
import tb.qx0;
import tb.s71;
import tb.v50;
import tb.xf2;
import tb.yy2;
import tb.zw0;

/* compiled from: Taobao */
public class BannerViewHolder extends CommonViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<BannerItem> banners;
    private int index = 0;
    private Banner mBanner;
    private int mBannerHeight;
    private Context mContext;
    private String mLeftUrl;
    private View mNullView;
    private OnBannerListener mOnBannerListener = new c();
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() {
        /* class cn.damai.tetris.component.home.viewholder.BannerViewHolder.AnonymousClass3 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "371054885")) {
                ipChange.ipc$dispatch("371054885", new Object[]{this, Integer.valueOf(i)});
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "425614020")) {
                ipChange.ipc$dispatch("425614020", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1229000016")) {
                ipChange.ipc$dispatch("-1229000016", new Object[]{this, Integer.valueOf(i)});
            } else if (BannerViewHolder.this.banners != null && BannerViewHolder.this.banners.size() > i && BannerViewHolder.this.banners.get(i) != null && BannerViewHolder.this.onPageSelectedPos != i) {
                zw0.B().D(BannerViewHolder.this.mTrackInfo, BannerViewHolder.this.mBanner, ((BannerItem) BannerViewHolder.this.banners.get(i)).title, ((BannerItem) BannerViewHolder.this.banners.get(i)).schema, i);
                BannerViewHolder.this.onPageSelectedPos = i;
            }
        }
    };
    private OnTagListener mOnTagListener = new d();
    private String mRightUrl;
    private TrackInfo mTrackInfo;
    private View mViewBtn1;
    private View mViewBtn2;
    private int onPageSelectedPos;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-357313397")) {
                ipChange.ipc$dispatch("-357313397", new Object[]{this, view});
            } else if (!TextUtils.isEmpty(BannerViewHolder.this.mLeftUrl)) {
                DMNav.from(BannerViewHolder.this.mContext).toUri(BannerViewHolder.this.mLeftUrl);
                zw0.B().g(BannerViewHolder.this.mLeftUrl, BannerViewHolder.this.index, 0);
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1753976972")) {
                ipChange.ipc$dispatch("1753976972", new Object[]{this, view});
            } else if (!TextUtils.isEmpty(BannerViewHolder.this.mRightUrl)) {
                DMNav.from(BannerViewHolder.this.mContext).toUri(BannerViewHolder.this.mRightUrl);
                zw0.B().g(BannerViewHolder.this.mRightUrl, BannerViewHolder.this.index, 1);
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements OnBannerListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.tetris.component.home.widget.banner.listener.OnBannerListener
        public void OnBannerClick(int i) {
            BannerItem bannerItem;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1818476269")) {
                ipChange.ipc$dispatch("-1818476269", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            try {
                if (xf2.e(BannerViewHolder.this.banners) > 0 && i < xf2.e(BannerViewHolder.this.banners) && (bannerItem = (BannerItem) BannerViewHolder.this.banners.get(i)) != null) {
                    if (!TextUtils.isEmpty(bannerItem.schema)) {
                        zw0.B().h(BannerViewHolder.this.mTrackInfo, bannerItem.title, bannerItem.schema, bannerItem.scm, i);
                        Bundle bundle = new Bundle();
                        bundle.putBoolean(MonitorType.SKIP, true);
                        bundle.putString("from_page", "homepage");
                        DMNav.from(BannerViewHolder.this.mContext).withExtras(bundle).toUri(bannerItem.schema);
                        return;
                    }
                    qx0.a();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: Taobao */
    public class d implements OnTagListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.tetris.component.home.widget.banner.listener.OnTagListener
        public void OnTagClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1037734993")) {
                ipChange.ipc$dispatch("1037734993", new Object[]{this});
                return;
            }
            DMNav.from(BannerViewHolder.this.mContext).toUri("https://p.damai.cn/wow/act/act/license");
        }
    }

    public BannerViewHolder(View view) {
        super(view);
        ViewGroup.LayoutParams layoutParams;
        this.mContext = view.getContext();
        int d2 = g70.d();
        this.mBanner = (Banner) this.itemView.findViewById(R$id.homepage_banner);
        this.mNullView = this.itemView.findViewById(R$id.view_null);
        this.mViewBtn1 = this.itemView.findViewById(R$id.view_btn1);
        this.mViewBtn2 = this.itemView.findViewById(R$id.view_btn2);
        this.mBannerHeight = ((d2 - v50.a(this.mContext, 42.0f)) * 125) / 333;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, this.mBannerHeight);
        layoutParams2.topMargin = v50.a(this.mContext, 9.0f);
        layoutParams2.bottomMargin = v50.a(this.mContext, 9.0f);
        this.mBanner.setLayoutParams(layoutParams2);
        bannerSetting(this.mBanner);
        this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mViewBtn1.setOnClickListener(new a());
        this.mViewBtn2.setOnClickListener(new b());
        new br().b("showNullView", new yy2(this));
        int homeLottieViewHeight = LottieHeight.getHomeLottieViewHeight();
        int a2 = this.mBannerHeight + v50.a(this.mContext, 18.0f);
        int a3 = v50.a(this.mContext, 45.0f);
        if (Build.VERSION.SDK_INT >= 23) {
            Context context = this.mContext;
            if (context instanceof Activity) {
                a3 += ne2.a((Activity) context);
            }
        }
        int a4 = ((homeLottieViewHeight - a2) - a3) - v50.a(this.mContext, 44.0f);
        if (a4 > 0 && (layoutParams = this.mNullView.getLayoutParams()) != null) {
            layoutParams.height = a4;
        }
    }

    private void bannerSetting(Banner banner) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-906266079")) {
            ipChange.ipc$dispatch("-906266079", new Object[]{this, banner});
            return;
        }
        banner.setBannerStyle(1);
        banner.setImageLoader(new BannerViewLoader());
        banner.setImages(new ArrayList());
        banner.setBannerAnimation(pn2.a);
        banner.isAutoPlay(true);
        banner.setDelayTime(3000);
        banner.setIndicatorGravity(6);
        banner.setOnBannerListener(this.mOnBannerListener);
        banner.setOnPageChangeListener(this.mOnPageChangeListener);
        banner.start();
    }

    private List<String> splitBannerUrl(List<BannerItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "547910386")) {
            return (List) ipChange.ipc$dispatch("547910386", new Object[]{this, list});
        }
        ArrayList arrayList = new ArrayList();
        int e = xf2.e(list);
        for (int i = 0; i < e; i++) {
            BannerItem bannerItem = list.get(i);
            if (bannerItem != null && !TextUtils.isEmpty(bannerItem.pic)) {
                arrayList.add(bannerItem.pic);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.tetris.mvp.CommonViewHolder
    public void setData(CommonBean commonBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1295244962")) {
            ipChange.ipc$dispatch("1295244962", new Object[]{this, commonBean});
        } else if (commonBean != null && (commonBean instanceof BannerResultBean)) {
            this.mTrackInfo = commonBean.trackInfo;
            BannerResultBean bannerResultBean = (BannerResultBean) commonBean;
            if (!s71.a(bannerResultBean.result)) {
                List<BannerItem> list = bannerResultBean.result;
                this.banners = list;
                List<String> splitBannerUrl = splitBannerUrl(list);
                if (!this.mBanner.isSameImageList(splitBannerUrl)) {
                    this.mBanner.update(splitBannerUrl);
                }
            }
        }
    }

    public void setData(List<BannerItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1564780322")) {
            ipChange.ipc$dispatch("1564780322", new Object[]{this, list});
        }
    }

    @Override // cn.damai.tetris.mvp.CommonViewHolder
    public void setMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1930502281")) {
            ipChange.ipc$dispatch("-1930502281", new Object[]{this, Integer.valueOf(i), obj});
        } else if (i != 11001 || this.mBanner == null || !(obj instanceof Boolean)) {
        } else {
            if (((Boolean) obj).booleanValue()) {
                this.mBanner.startAutoPlay();
            } else {
                this.mBanner.stopAutoPlay();
            }
        }
    }

    public void updateUiByHeadLottieStyle(HeadLottieStyleBean headLottieStyleBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-3357448")) {
            ipChange.ipc$dispatch("-3357448", new Object[]{this, headLottieStyleBean});
            return;
        }
        View view = this.mNullView;
        if (view == null) {
            return;
        }
        if (headLottieStyleBean != null) {
            this.index = headLottieStyleBean.index;
            view.setVisibility(0);
            String str = headLottieStyleBean.schemaLeft;
            this.mLeftUrl = str;
            this.mRightUrl = headLottieStyleBean.schemaRight;
            if (TextUtils.isEmpty(str)) {
                this.mViewBtn1.setVisibility(8);
            } else {
                zw0.B().I(this.mViewBtn1, this.mLeftUrl, headLottieStyleBean.index, 0);
                this.mViewBtn1.setVisibility(0);
            }
            if (TextUtils.isEmpty(this.mRightUrl)) {
                this.mViewBtn2.setVisibility(8);
                return;
            }
            zw0.B().I(this.mViewBtn2, this.mRightUrl, headLottieStyleBean.index, 1);
            this.mViewBtn2.setVisibility(0);
            return;
        }
        view.setVisibility(8);
    }
}
