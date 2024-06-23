package cn.damai.ticklet.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import cn.damai.member.R$drawable;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$string;
import cn.damai.uikit.banner.Banner;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.view.DMActionButtonBgView;
import cn.damai.uikit.view.NoticeEllipsisTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.lw2;
import tb.on2;
import tb.rr;
import tb.v50;

/* compiled from: Taobao */
public class TickletPerformBannerLoginView extends RelativeLayout implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String LIST_DATA_EMPTY = "list_data_empty";
    public static final String LIST_NO_LOGIN = "list_no_login";
    public static final int marginTop = 12;
    Activity activity;
    private LinearLayout bannerLoginShadow;
    private TickletBannerLoginCallBack callBack;
    Context context;
    private NoticeEllipsisTextView ellipsisTextView;
    private List<Integer> imagesEmpty;
    private List<Integer> imagesNoLogin;
    private List<ImageView> indicators;
    private LinearLayout jiadeTransferMessageLayout;
    private Banner mBanner;
    private LinearLayout mBannerloginLayout;
    private LinearLayout mIndicatorLayout;
    private DMActionButtonBgView mLoginBtnText;
    private TextView mMainTitle;
    private TextView mSubTitle;
    private DMIconFontTextView noticeArrow;
    private RelativeLayout rlEmergency;
    private ImageView ticklet_list_top_bg;
    private TextView transferMessage;
    private String type;
    View view;

    /* compiled from: Taobao */
    public interface TickletBannerLoginCallBack {
        void gotoLogin();

        void gotoTransferAccept();

        void gotoVerifyTicket();

        void setNoticeHeight(int i);
    }

    /* compiled from: Taobao */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "976791039")) {
                ipChange.ipc$dispatch("976791039", new Object[]{this});
                return;
            }
            TickletPerformBannerLoginView.this.ellipsisTextView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            if (1 == TickletPerformBannerLoginView.this.ellipsisTextView.getLineCount()) {
                TickletPerformBannerLoginView.this.callBack.setNoticeHeight(v50.a(TickletPerformBannerLoginView.this.context, 97.0f));
            } else if (2 == TickletPerformBannerLoginView.this.ellipsisTextView.getLineCount()) {
                TickletPerformBannerLoginView.this.callBack.setNoticeHeight(v50.a(TickletPerformBannerLoginView.this.context, 120.0f));
            } else {
                TickletPerformBannerLoginView.this.callBack.setNoticeHeight(1);
            }
        }
    }

    public TickletPerformBannerLoginView(Context context2, Activity activity2, String str) {
        this(context2);
        this.activity = activity2;
        initView();
    }

    private void addViewNoticeLister() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-421897149")) {
            ipChange.ipc$dispatch("-421897149", new Object[]{this});
            return;
        }
        this.ellipsisTextView.setColor(Color.parseColor("#EB7609"));
        this.ellipsisTextView.getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    private void initBanner() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1924724098")) {
            ipChange.ipc$dispatch("1924724098", new Object[]{this});
            return;
        }
        this.imagesEmpty = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.imagesNoLogin = arrayList;
        arrayList.add(Integer.valueOf(R$drawable.ticklet_list_nologin_perform));
        this.imagesNoLogin.add(Integer.valueOf(R$drawable.ticklet_list_nologin_venue));
        this.imagesEmpty.add(Integer.valueOf(R$drawable.ticklet_list_nologin_star));
        this.mBanner.setBannerStyle(0);
        this.mBanner.setImageLoader(new TickletImageLoader());
        this.mBanner.setImages(this.imagesNoLogin);
        this.mBanner.setBannerAnimation(on2.a);
        this.mBanner.isAutoPlay(true);
        this.mBanner.setDelayTime(3000);
        this.mBanner.setIndicatorGravity(6);
        this.mBanner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class cn.damai.ticklet.view.TickletPerformBannerLoginView.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1452884245")) {
                    ipChange.ipc$dispatch("1452884245", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1375253172")) {
                    ipChange.ipc$dispatch("1375253172", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1125218656")) {
                    ipChange.ipc$dispatch("-1125218656", new Object[]{this, Integer.valueOf(i)});
                } else if (TickletPerformBannerLoginView.this.type == TickletPerformBannerLoginView.LIST_NO_LOGIN) {
                    TickletPerformBannerLoginView.this.refreshTitleAndIndicator(i);
                }
            }
        });
    }

    private void initIndicator() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-374222931")) {
            ipChange.ipc$dispatch("-374222931", new Object[]{this});
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.indicators = arrayList;
        arrayList.clear();
        for (int i = 0; i < this.imagesNoLogin.size(); i++) {
            ImageView imageView = new ImageView(this.context);
            if (i == 0) {
                imageView.setImageResource(R$drawable.ticklet_viewpager_circleindicator_selected);
            } else {
                imageView.setImageResource(R$drawable.ticklet_viewpager_circleindicator_unselected);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(v50.a(getContext(), 6.0f), v50.a(getContext(), 6.0f));
            layoutParams.setMargins(v50.a(getContext(), 4.5f), 0, v50.a(getContext(), 4.5f), 0);
            this.mIndicatorLayout.addView(imageView, layoutParams);
            this.indicators.add(imageView);
        }
    }

    private void initListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1825708218")) {
            ipChange.ipc$dispatch("1825708218", new Object[]{this});
            return;
        }
        this.mLoginBtnText.setOnClickListener(this);
        this.jiadeTransferMessageLayout.setOnClickListener(this);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "676935081")) {
            ipChange.ipc$dispatch("676935081", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.ticklet_list_nologin_layout, this);
        this.view = inflate;
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R$id.ticklet_list_jiade_transfer_message_layout);
        this.jiadeTransferMessageLayout = linearLayout;
        this.transferMessage = (TextView) linearLayout.findViewById(R$id.ticklet_transfer_message_content_tv);
        this.bannerLoginShadow = (LinearLayout) this.view.findViewById(R$id.ticklet_perform_banner_login_shadow);
        this.mBannerloginLayout = (LinearLayout) this.view.findViewById(R$id.ticklet_perform_banner_login);
        this.ticklet_list_top_bg = (ImageView) this.view.findViewById(R$id.ticklet_list_top_bg);
        RelativeLayout relativeLayout = (RelativeLayout) this.view.findViewById(R$id.ticket_list_rl_emergency_notification);
        this.rlEmergency = relativeLayout;
        this.ellipsisTextView = (NoticeEllipsisTextView) relativeLayout.findViewById(R$id.tikclet_header_notice_content);
        DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) this.rlEmergency.findViewById(R$id.project_header_notice_arrow);
        this.noticeArrow = dMIconFontTextView;
        dMIconFontTextView.setVisibility(8);
        this.mMainTitle = (TextView) this.view.findViewById(R$id.ticklet_nologin_main_tips);
        this.mSubTitle = (TextView) this.view.findViewById(R$id.ticklet_nologin_sub_tips);
        this.mLoginBtnText = (DMActionButtonBgView) this.view.findViewById(R$id.ticklet_list_nologin_btn_text);
        this.mIndicatorLayout = (LinearLayout) this.view.findViewById(R$id.indicator_container);
        this.mBanner = (Banner) this.view.findViewById(R$id.ticklet_banner);
        this.jiadeTransferMessageLayout.setVisibility(8);
        this.mLoginBtnText.update("登录");
        initBanner();
        initIndicator();
        initListener();
        addViewNoticeLister();
        rr.b(this.bannerLoginShadow, Color.parseColor("#00ffffff"), v50.a(this.context, 15.0f), Color.parseColor("#1A000000"), v50.a(this.context, 17.0f), 0, v50.a(this.context, 5.0f));
        rr.b(this.jiadeTransferMessageLayout, Color.parseColor("#00ffffff"), v50.a(getContext(), 9.0f), Color.parseColor("#266a7a99"), v50.a(getContext(), 9.0f), 0, v50.a(getContext(), 6.0f));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void refreshTitleAndIndicator(int i) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1488072570")) {
            ipChange.ipc$dispatch("1488072570", new Object[]{this, Integer.valueOf(i)});
        } else if (this.context != null && getResources() != null) {
            String str2 = "";
            if (i == 0) {
                str2 = this.context.getResources().getString(R$string.ticklet_list_nologin_perform_title_tips);
                str = this.context.getResources().getString(R$string.ticklet_list_nologin_perform_subtitle_tips);
            } else if (i != 1) {
                str = str2;
            } else {
                str2 = this.context.getResources().getString(R$string.ticklet_list_nologin_venue_title_tips);
                str = "场馆地图、交通停车和周边服务全知道(>▽<)";
            }
            this.mMainTitle.setText(str2);
            this.mSubTitle.setText(str);
            for (int i2 = 0; i2 < this.imagesNoLogin.size(); i2++) {
                if (i % this.imagesNoLogin.size() == i2) {
                    this.indicators.get(i2).setImageResource(R$drawable.ticklet_viewpager_circleindicator_selected);
                } else {
                    this.indicators.get(i2).setImageResource(R$drawable.ticklet_viewpager_circleindicator_unselected);
                }
            }
        }
    }

    public LinearLayout getBannerLoginView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-108328055")) {
            return this.mBannerloginLayout;
        }
        return (LinearLayout) ipChange.ipc$dispatch("-108328055", new Object[]{this});
    }

    public TextView getJaiTransferMessageView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1531532251")) {
            return this.transferMessage;
        }
        return (TextView) ipChange.ipc$dispatch("1531532251", new Object[]{this});
    }

    public LinearLayout getJaiTransferView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1903308023")) {
            return this.jiadeTransferMessageLayout;
        }
        return (LinearLayout) ipChange.ipc$dispatch("-1903308023", new Object[]{this});
    }

    public Banner getmBanner() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1150318173")) {
            return this.mBanner;
        }
        return (Banner) ipChange.ipc$dispatch("-1150318173", new Object[]{this});
    }

    public void getmBannerStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1585587257")) {
            ipChange.ipc$dispatch("1585587257", new Object[]{this});
            return;
        }
        Banner banner = this.mBanner;
        if (banner != null) {
            banner.stopAutoPlay();
        }
    }

    public DMActionButtonBgView getmLoginBtnText() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-218775935")) {
            return this.mLoginBtnText;
        }
        return (DMActionButtonBgView) ipChange.ipc$dispatch("-218775935", new Object[]{this});
    }

    public void isShowBannerLoginView(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-355609469")) {
            ipChange.ipc$dispatch("-355609469", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.bannerLoginShadow.setVisibility(0);
        } else {
            this.bannerLoginShadow.setVisibility(8);
        }
    }

    public void notEmptyListUI() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "298783954")) {
            ipChange.ipc$dispatch("298783954", new Object[]{this});
            return;
        }
        isShowBannerLoginView(false);
        getmBannerStop();
    }

    public void onClick(View view2) {
        TickletBannerLoginCallBack tickletBannerLoginCallBack;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1323018063")) {
            ipChange.ipc$dispatch("1323018063", new Object[]{this, view2});
            return;
        }
        int id = view2.getId();
        if (id == R$id.ticklet_list_nologin_btn_text) {
            TickletBannerLoginCallBack tickletBannerLoginCallBack2 = this.callBack;
            if (tickletBannerLoginCallBack2 != null) {
                tickletBannerLoginCallBack2.gotoLogin();
            }
        } else if (id == R$id.ticklet_list_jiade_transfer_message_layout && (tickletBannerLoginCallBack = this.callBack) != null) {
            tickletBannerLoginCallBack.gotoTransferAccept();
        }
    }

    public void setBannerLoginCallback(TickletBannerLoginCallBack tickletBannerLoginCallBack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1549618630")) {
            ipChange.ipc$dispatch("1549618630", new Object[]{this, tickletBannerLoginCallBack});
            return;
        }
        this.callBack = tickletBannerLoginCallBack;
    }

    public void setHeadTips(String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1892525480")) {
            ipChange.ipc$dispatch("-1892525480", new Object[]{this, str, Boolean.valueOf(z)});
        } else if (!z && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.trim())) {
            this.ellipsisTextView.setText(str);
            lw2.F(this.rlEmergency);
            addViewNoticeLister();
        }
    }

    public void update(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "315572479")) {
            ipChange.ipc$dispatch("315572479", new Object[]{this, str});
            return;
        }
        try {
            this.type = str;
            if (!LIST_DATA_EMPTY.equals(str)) {
                this.mBanner.setImages(this.imagesNoLogin);
                this.mIndicatorLayout.setVisibility(0);
                getmLoginBtnText().setVisibility(0);
                this.jiadeTransferMessageLayout.setVisibility(8);
                this.rlEmergency.setVisibility(8);
            } else if (this.context == null) {
                return;
            } else {
                if (getResources() != null) {
                    this.mBanner.setImages(this.imagesEmpty);
                    this.mMainTitle.setText(this.context.getResources().getString(R$string.ticklet_list_nologin_stars_title_tips));
                    this.mSubTitle.setText(this.context.getResources().getString(R$string.ticklet_list_nologin_stars_subtitle_tips));
                    this.mIndicatorLayout.setVisibility(4);
                    getmLoginBtnText().setVisibility(4);
                } else {
                    return;
                }
            }
            isShowBannerLoginView(true);
            Banner banner = this.mBanner;
            if (banner != null) {
                banner.start();
                this.mBanner.startAutoPlay();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TickletPerformBannerLoginView(Context context2) {
        this(context2, null);
    }

    public TickletPerformBannerLoginView(Context context2, @Nullable AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public TickletPerformBannerLoginView(Context context2, @Nullable AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.type = LIST_NO_LOGIN;
        this.context = context2;
    }
}
