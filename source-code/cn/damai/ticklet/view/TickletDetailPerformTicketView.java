package cn.damai.ticklet.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import cn.damai.member.R$color;
import cn.damai.member.R$drawable;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$raw;
import cn.damai.member.R$string;
import cn.damai.message.observer.Action;
import cn.damai.ticklet.bean.AnnouncementVO;
import cn.damai.ticklet.bean.SubCouponNumBean;
import cn.damai.ticklet.bean.TicketDeatilResult;
import cn.damai.ticklet.bean.TickletStatusNotice;
import cn.damai.ticklet.bean.UserTicketTable;
import cn.damai.ticklet.inteface.TickletPerformCallBack;
import cn.damai.ticklet.inteface.TickletTicketCallback;
import cn.damai.uikit.view.NoticeEllipsisTextView;
import com.airbnb.lottie.LottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.br;
import tb.g91;
import tb.gl2;
import tb.lw2;
import tb.sl2;
import tb.v50;

/* compiled from: Taobao */
public class TickletDetailPerformTicketView extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private TickletPerformCallBack callBack;
    private Context context;
    NoticeEllipsisTextView ellipsisTextView;
    private boolean isShowNftBgAnim;
    private br mDMMessage;
    private TicketDeatilResult mDetailResult;
    ImageView nftDiamondView;
    ImageView normalDiamondView;
    private int paddintTop;
    View partent;
    TickletDetailPerformInfo performInfo;
    RelativeLayout rlEmergency;
    private boolean showAll;
    LottieAnimationView splashView;
    TickletDetailViewPager viewPager;
    View vpBottpmLine;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TicketDeatilResult a;

        a(TicketDeatilResult ticketDeatilResult) {
            this.a = ticketDeatilResult;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-298863628")) {
                ipChange.ipc$dispatch("-298863628", new Object[]{this, view});
                return;
            }
            TickletDetailPerformTicketView tickletDetailPerformTicketView = TickletDetailPerformTicketView.this;
            tickletDetailPerformTicketView.showAll = !tickletDetailPerformTicketView.showAll;
            TickletDetailPerformTicketView tickletDetailPerformTicketView2 = TickletDetailPerformTicketView.this;
            tickletDetailPerformTicketView2.updateCouponCodeList(tickletDetailPerformTicketView2.viewPager.getCurrentItem(), this.a, true);
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onViewAttachedToWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1453468736")) {
                ipChange.ipc$dispatch("-1453468736", new Object[]{this, view});
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("动画播放开启 visibity=");
            sb.append(TickletDetailPerformTicketView.this.splashView.getVisibility() == 0 ? "显示" : " 未显示");
            sb.append(" 动画是否ing+ ");
            sb.append(TickletDetailPerformTicketView.this.splashView.isAnimating() ? " 是 " : " 否");
            g91.b("splashView", sb.toString());
            if (TickletDetailPerformTicketView.this.splashView.getVisibility() == 0 && !TickletDetailPerformTicketView.this.splashView.isAnimating()) {
                TickletDetailPerformTicketView.this.splashView.playAnimation();
            }
        }

        public void onViewDetachedFromWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-795580355")) {
                ipChange.ipc$dispatch("-795580355", new Object[]{this, view});
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("动画播放detached visibity=");
            sb.append(TickletDetailPerformTicketView.this.splashView.getVisibility() == 0 ? "显示" : " 未显示");
            sb.append(" 动画是否ing+ ");
            sb.append(TickletDetailPerformTicketView.this.splashView.isAnimating() ? " 是 " : " 否");
            g91.b("splashView", sb.toString());
            if (TickletDetailPerformTicketView.this.splashView.getVisibility() == 0 && TickletDetailPerformTicketView.this.splashView.isAnimating()) {
                TickletDetailPerformTicketView.this.splashView.pauseAnimation();
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ AnnouncementVO a;

        c(AnnouncementVO announcementVO) {
            this.a = announcementVO;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1740040183")) {
                ipChange.ipc$dispatch("1740040183", new Object[]{this, view});
                return;
            }
            TickletDetailPerformTicketView.this.showProjectNoticeFragment(this.a.getAnnouncementText(), this.a.getAnnouncementImageUrl(), this.a.announcementSkipURL);
        }
    }

    /* compiled from: Taobao */
    public class d implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1233013755")) {
                ipChange.ipc$dispatch("-1233013755", new Object[]{this, obj});
            } else if (obj != null) {
                TickletDetailPerformTicketView tickletDetailPerformTicketView = TickletDetailPerformTicketView.this;
                tickletDetailPerformTicketView.updateCouponCodeList(tickletDetailPerformTicketView.viewPager.getCurrentItem(), TickletDetailPerformTicketView.this.mDetailResult, false);
            }
        }
    }

    public TickletDetailPerformTicketView(Context context2) {
        this(context2, null);
    }

    private void bindItemView(LinearLayout linearLayout, SubCouponNumBean subCouponNumBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1374813998")) {
            ipChange.ipc$dispatch("-1374813998", new Object[]{this, linearLayout, subCouponNumBean});
            return;
        }
        setText(linearLayout.findViewById(R$id.tv_coupon_list_view_item_code), subCouponNumBean.subTicketNo);
        int i = R$id.tv_coupon_list_view_item_state;
        setText(linearLayout.findViewById(i), subCouponNumBean.subTicketStateDesc);
        int parseColor = Color.parseColor("#999999");
        if ("1".equals(subCouponNumBean.subTicketState)) {
            parseColor = Color.parseColor("#000000");
        } else if ("22".equals(subCouponNumBean.subTicketState)) {
            parseColor = Color.parseColor("#FE2757");
        }
        ((TextView) linearLayout.findViewById(i)).setTextColor(parseColor);
        SubCouponNumBean.ExtAttr extAttr = subCouponNumBean.extAttr;
        if (extAttr == null || TextUtils.isEmpty(extAttr.subTicketUserPoint)) {
            linearLayout.findViewById(R$id.tv_coupon_list_view_item_tip).setVisibility(4);
            return;
        }
        int i2 = R$id.tv_coupon_list_view_item_tip;
        linearLayout.findViewById(i2).setVisibility(0);
        ((TextView) linearLayout.findViewById(i2)).setText("(+" + subCouponNumBean.extAttr.subTicketUserPoint + " 淘麦积分)");
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "241557249")) {
            ipChange.ipc$dispatch("241557249", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.ticklet_detail_perform_ticklet_layout, this);
        this.partent = inflate;
        this.performInfo = (TickletDetailPerformInfo) inflate.findViewById(R$id.td_perfrom_info);
        this.vpBottpmLine = this.partent.findViewById(R$id.vp_detail_tikets_bottom_line);
        this.viewPager = (TickletDetailViewPager) this.partent.findViewById(R$id.vp_detail_tikets);
        this.rlEmergency = (RelativeLayout) this.partent.findViewById(R$id.ticket_rl_emergency_notification);
        this.nftDiamondView = (ImageView) this.partent.findViewById(R$id.tickelt_detail_nft_diamond_icon);
        this.normalDiamondView = (ImageView) this.partent.findViewById(R$id.tickelt_detail_normal_diamond_icon);
        this.splashView = (LottieAnimationView) this.partent.findViewById(R$id.tickelt_detail_splash_lottie);
        NoticeEllipsisTextView noticeEllipsisTextView = (NoticeEllipsisTextView) this.rlEmergency.findViewById(R$id.tikclet_header_notice_content);
        this.ellipsisTextView = noticeEllipsisTextView;
        noticeEllipsisTextView.setColor(Color.parseColor("#ffffff"));
    }

    private void onListenerCouponStateAccsSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1609948989")) {
            ipChange.ipc$dispatch("1609948989", new Object[]{this});
            return;
        }
        this.mDMMessage.b(gl2.COUPON_NUM_STATE_UPDATE, new d());
    }

    private void setNftBgLottie(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1792546027")) {
            ipChange.ipc$dispatch("1792546027", new Object[]{this, Integer.valueOf(i)});
        } else if (!this.isShowNftBgAnim) {
            lw2.F(this.splashView);
            this.splashView.setAnimation(i);
            this.splashView.setRepeatMode(1);
            this.splashView.setRepeatCount(-1);
            if (!this.splashView.isAnimating()) {
                this.splashView.playAnimation();
            }
            this.isShowNftBgAnim = true;
            StringBuilder sb = new StringBuilder();
            sb.append("setNftBgLottie 播放 visibity=");
            sb.append(this.splashView.getVisibility() == 0 ? "显示" : " 未显示");
            sb.append(" 动画是否ing+ ");
            sb.append(this.splashView.isAnimating() ? " 是 " : " 否");
            g91.b("splashView", sb.toString());
            try {
                if (Build.VERSION.SDK_INT >= 12) {
                    if (this.splashView.getTag() != null) {
                        LottieAnimationView lottieAnimationView = this.splashView;
                        lottieAnimationView.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener) lottieAnimationView.getTag());
                    }
                    b bVar = new b();
                    this.splashView.addOnAttachStateChangeListener(bVar);
                    this.splashView.setTag(bVar);
                }
            } catch (Exception unused) {
            }
        }
    }

    private void setText(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2050018185")) {
            ipChange.ipc$dispatch("-2050018185", new Object[]{this, view, str});
        } else if ((view instanceof TextView) || !TextUtils.isEmpty(str)) {
            view.setVisibility(0);
            ((TextView) view).setText(str);
        } else {
            view.setVisibility(4);
        }
    }

    private void setmEmergencyNoticeTv(AnnouncementVO announcementVO) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1934002160")) {
            ipChange.ipc$dispatch("-1934002160", new Object[]{this, announcementVO});
        } else if (announcementVO == null || TextUtils.isEmpty(announcementVO.getAnnouncementText())) {
            this.rlEmergency.setVisibility(8);
        } else {
            this.ellipsisTextView.setText(announcementVO.getAnnouncementText());
            this.rlEmergency.setVisibility(0);
            this.rlEmergency.setOnClickListener(new c(announcementVO));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showProjectNoticeFragment(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2125500498")) {
            ipChange.ipc$dispatch("-2125500498", new Object[]{this, str, str2, str3});
            return;
        }
        TickletStatusNotice tickletStatusNotice = new TickletStatusNotice();
        tickletStatusNotice.setPopupTitle(getResources().getString(R$string.ticklet_notice_tip));
        tickletStatusNotice.setPopupContent(str);
        tickletStatusNotice.setAnnouncementSkipURL(str3);
        tickletStatusNotice.imageUrl = str2;
        this.callBack.showNotice(tickletStatusNotice);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateCouponCodeList(int i, TicketDeatilResult ticketDeatilResult, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2045625585")) {
            ipChange.ipc$dispatch("2045625585", new Object[]{this, Integer.valueOf(i), ticketDeatilResult, Boolean.valueOf(z)});
        } else if (ticketDeatilResult.getTicketInfoList() == null || i >= ticketDeatilResult.getTicketInfoList().size() || ticketDeatilResult.getTicketInfoList().get(i) == null || ticketDeatilResult.getTicketInfoList().get(i).getSubTicketList() == null || ticketDeatilResult.getTicketInfoList().get(i).getSubTicketList().size() <= 0) {
            this.partent.findViewById(R$id.ll_coupon_list_view).setVisibility(8);
            this.partent.findViewById(R$id.perform_divider).setVisibility(8);
            this.partent.findViewById(R$id.ticket_coupon_line).setVisibility(8);
        } else {
            ArrayList<SubCouponNumBean> subTicketList = ticketDeatilResult.getTicketInfoList().get(i).getSubTicketList();
            this.partent.findViewById(R$id.ll_coupon_list_view).setVisibility(0);
            this.partent.findViewById(R$id.perform_divider).setVisibility(0);
            this.partent.findViewById(R$id.ticket_coupon_line).setVisibility(0);
            View view = this.partent;
            int i2 = R$id.tv_coupon_list_view_showall_line;
            view.findViewById(i2).setVisibility(0);
            ((LinearLayout) this.partent.findViewById(R$id.ll_coupon_list_container)).removeAllViews();
            UserTicketTable userTicketTable = ticketDeatilResult.getTicketInfoList().get(i);
            int size = subTicketList.size();
            if (size <= 5) {
                this.partent.findViewById(i2).setVisibility(8);
                this.partent.findViewById(R$id.tv_coupon_list_view_showall).setVisibility(8);
            } else {
                View findViewById = this.partent.findViewById(R$id.tv_coupon_list_view_showall);
                if (!this.showAll) {
                    setText(findViewById, "展开全部" + subTicketList.size() + "个券码");
                    sl2.j().f(findViewById, i, userTicketTable.getPerformId(), userTicketTable.tradeOrderId, "expand");
                    size = 5;
                } else {
                    setText(findViewById, "收起券码");
                    sl2.j().f(findViewById, i, userTicketTable.getPerformId(), userTicketTable.tradeOrderId, "collapse");
                }
            }
            for (int i3 = 0; i3 < size; i3++) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R$layout.tv_coupon_list_view_item, (ViewGroup) null);
                bindItemView(linearLayout, subTicketList.get(i3));
                ((LinearLayout) this.partent.findViewById(R$id.ll_coupon_list_container)).addView(linearLayout);
            }
            sl2.j().f(this.partent.findViewById(R$id.ll_coupon_list_container), i, userTicketTable.getPerformId(), userTicketTable.tradeOrderId, "couponlist");
            if (!z) {
                return;
            }
            if (this.showAll) {
                cn.damai.common.user.c e = cn.damai.common.user.c.e();
                cn.damai.common.user.b instance = cn.damai.common.user.b.getInstance();
                e.x(instance.e(sl2.TICKLET_DETAIL_PAGE, "center_" + i, "expand", sl2.j().t(userTicketTable.tradeOrderId, userTicketTable.getPerformId()), Boolean.FALSE));
                return;
            }
            cn.damai.common.user.c e2 = cn.damai.common.user.c.e();
            cn.damai.common.user.b instance2 = cn.damai.common.user.b.getInstance();
            e2.x(instance2.e(sl2.TICKLET_DETAIL_PAGE, "center_" + i, "collapse", sl2.j().t(userTicketTable.tradeOrderId, userTicketTable.getPerformId()), Boolean.FALSE));
        }
    }

    public TickletDetailViewPager getViewPager() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1957398358")) {
            return this.viewPager;
        }
        return (TickletDetailViewPager) ipChange.ipc$dispatch("-1957398358", new Object[]{this});
    }

    public void setCallback(TickletTicketCallback tickletTicketCallback, TickletPerformCallBack tickletPerformCallBack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1339904364")) {
            ipChange.ipc$dispatch("1339904364", new Object[]{this, tickletTicketCallback, tickletPerformCallBack});
            return;
        }
        this.viewPager.setCallback(tickletTicketCallback);
        this.callBack = tickletPerformCallBack;
        tickletPerformCallBack.setDetailViewPager(this.viewPager);
    }

    public void update(final TicketDeatilResult ticketDeatilResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-246776407")) {
            ipChange.ipc$dispatch("-246776407", new Object[]{this, ticketDeatilResult});
            return;
        }
        this.mDetailResult = ticketDeatilResult;
        if (ticketDeatilResult == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.performInfo.update(ticketDeatilResult);
        if (ticketDeatilResult.isNftPerform()) {
            this.viewPager.setBackgroundResource(R$color.transparent);
            this.viewPager.setPadding(v50.a(this.context, 15.0f), 0, v50.a(this.context, 15.0f), 0);
            lw2.v(this.vpBottpmLine);
            lw2.v(this.normalDiamondView);
            if ("1".equals(ticketDeatilResult.getMemberLevel())) {
                setNftBgLottie(R$raw.member_splash_tm);
                lw2.F(this.nftDiamondView);
                this.nftDiamondView.setImageResource(R$drawable.ticklet_nft_tm_diamond_icon);
            } else if ("10".equals(ticketDeatilResult.getMemberLevel())) {
                setNftBgLottie(R$raw.member_splash_tm_vip);
                lw2.F(this.nftDiamondView);
                this.nftDiamondView.setImageResource(R$drawable.ticklet_nft_tm_vip_diamond_icon);
            } else {
                lw2.v(this.splashView);
                lw2.v(this.nftDiamondView);
            }
        } else {
            this.viewPager.setBackgroundResource(R$drawable.bg_ticket_top_shadow);
            this.viewPager.setPadding(v50.a(this.context, 15.0f), v50.a(this.context, 15.0f), v50.a(this.context, 15.0f), 0);
            lw2.F(this.vpBottpmLine);
            lw2.v(this.splashView);
            lw2.v(this.nftDiamondView);
            if ("1".equals(ticketDeatilResult.getMemberLevel())) {
                lw2.F(this.normalDiamondView);
                this.normalDiamondView.setImageResource(R$drawable.ticklet_normal_tm_diamond_icon);
            } else if ("10".equals(ticketDeatilResult.getMemberLevel())) {
                lw2.F(this.normalDiamondView);
                this.normalDiamondView.setImageResource(R$drawable.ticklet_normal_tm_vip_diamond_icon);
            } else {
                lw2.v(this.normalDiamondView);
            }
        }
        this.viewPager.update(ticketDeatilResult);
        this.showAll = false;
        updateCouponCodeList(0, ticketDeatilResult, false);
        this.partent.findViewById(R$id.tv_coupon_list_view_showall).setOnClickListener(new a(ticketDeatilResult));
        this.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class cn.damai.ticklet.view.TickletDetailPerformTicketView.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "859023549")) {
                    ipChange.ipc$dispatch("859023549", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1470710364")) {
                    ipChange.ipc$dispatch("1470710364", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1498341448")) {
                    ipChange.ipc$dispatch("1498341448", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                TickletDetailPerformTicketView.this.showAll = false;
                TickletDetailPerformTicketView.this.updateCouponCodeList(i, ticketDeatilResult, false);
            }
        });
        setmEmergencyNoticeTv(ticketDeatilResult.getAnnouncement());
    }

    public TickletDetailPerformTicketView(Context context2, @Nullable AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public TickletDetailPerformTicketView(Context context2, @Nullable AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.paddintTop = 0;
        this.mDMMessage = new br();
        this.isShowNftBgAnim = false;
        this.showAll = false;
        this.context = context2;
        int a2 = v50.a(context2, 18.0f);
        this.paddintTop = a2;
        setPadding(0, a2, 0, 0);
        initView();
        onListenerCouponStateAccsSuccess();
    }
}
