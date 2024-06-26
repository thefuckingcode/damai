package cn.damai.ultron.payresult.view;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.banner.bean.PageBanner;
import cn.damai.commonbusiness.banner.bean.PayAdvertBean;
import cn.damai.commonbusiness.search.bean.BaccountInfo;
import cn.damai.commonbusiness.yymember.view.MemberAuthPopWindow;
import cn.damai.tetris.component.brand.bean.BrandInfoBean;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.view.MarqueTextView;
import cn.damai.uikit.view.RoundImageView;
import cn.damai.ultron.R$color;
import cn.damai.ultron.R$drawable;
import cn.damai.ultron.R$id;
import cn.damai.ultron.R$layout;
import cn.damai.ultron.R$string;
import cn.damai.ultron.payresult.bean.DmPayButtonBean;
import cn.damai.ultron.payresult.bean.DmPaySuccessBean;
import cn.damai.ultron.payresult.bean.DmPaySuccessDataHolder;
import cn.damai.user.userprofile.FeedsViewModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.gaiaxholder.NativeGaiaXViewHolder;
import com.alibaba.pictures.bricks.orderresult.couponpayresult.viewholder.RecommendTitleViewHolder;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.info.DeviceInfoProviderProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.d20;
import tb.h03;
import tb.nx1;
import tb.v50;
import tb.vv2;
import tb.xf2;
import tb.z90;

/* compiled from: Taobao */
public class DmPaySuccessAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<DmPaySuccessDataHolder> a;
    private Context b;
    private vv2 c;
    public HashMap<String, String> d = null;

    /* compiled from: Taobao */
    public class BannerViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private Context a;
        private ImageView b;
        private RelativeLayout c;
        private ImageView d;
        private TextView e;
        private TextView f;
        private TextView g;
        private String h = "-1";

        /* compiled from: Taobao */
        public class a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1056155823")) {
                    ipChange.ipc$dispatch("-1056155823", new Object[]{this, view});
                    return;
                }
                cn.damai.common.user.c.e().x(z90.h().k(BannerViewHolder.this.h));
                DMNav.from(DmPaySuccessAdapter.this.b).toUri(h03.j());
            }
        }

        /* compiled from: Taobao */
        public class b implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ PayAdvertBean a;

            /* compiled from: Taobao */
            public class a implements MemberAuthPopWindow.ICustomDialogEventListener {
                private static transient /* synthetic */ IpChange $ipChange;
                final /* synthetic */ DmPayResultActivity a;

                a(b bVar, DmPayResultActivity dmPayResultActivity) {
                    this.a = dmPayResultActivity;
                }

                @Override // cn.damai.commonbusiness.yymember.view.MemberAuthPopWindow.ICustomDialogEventListener
                public void dialogItemEvent(String str) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1990318567")) {
                        ipChange.ipc$dispatch("1990318567", new Object[]{this, str});
                        return;
                    }
                    DmPayResultActivity dmPayResultActivity = this.a;
                    if (dmPayResultActivity != null && !dmPayResultActivity.isFinishing() && "success".equals(str)) {
                        this.a.onRefreshBanner();
                    }
                }
            }

            b(PayAdvertBean payAdvertBean) {
                this.a = payAdvertBean;
            }

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1055134546")) {
                    ipChange.ipc$dispatch("1055134546", new Object[]{this, view});
                    return;
                }
                cn.damai.common.user.c.e().x(z90.h().k(BannerViewHolder.this.h));
                if (!this.a.vipScore.memberThreshold) {
                    DMNav.from(DmPaySuccessAdapter.this.b).toUri(h03.j());
                } else if (DmPaySuccessAdapter.this.b != null && (DmPaySuccessAdapter.this.b instanceof DmPayResultActivity)) {
                    DmPayResultActivity dmPayResultActivity = (DmPayResultActivity) DmPaySuccessAdapter.this.b;
                    h03.g(DmPaySuccessAdapter.this.b, dmPayResultActivity, z90.DM_PAY_SUCCESS, new a(this, dmPayResultActivity));
                }
            }
        }

        /* compiled from: Taobao */
        public class c implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ String a;
            final /* synthetic */ String b;
            final /* synthetic */ PayAdvertBean c;

            c(String str, String str2, PayAdvertBean payAdvertBean) {
                this.a = str;
                this.b = str2;
                this.c = payAdvertBean;
            }

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1128542381")) {
                    ipChange.ipc$dispatch("-1128542381", new Object[]{this, view});
                    return;
                }
                cn.damai.common.user.c.e().x(z90.h().l(this.a, this.b, String.valueOf(this.c.vipScore.memberFlag)));
                DMNav.from(DmPaySuccessAdapter.this.b).toUri(h03.j());
            }
        }

        /* compiled from: Taobao */
        public class d implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ String a;

            d(String str) {
                this.a = str;
            }

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "982747988")) {
                    ipChange.ipc$dispatch("982747988", new Object[]{this, view});
                    return;
                }
                String str = (String) view.getTag();
                if (!TextUtils.isEmpty(str)) {
                    cn.damai.common.user.c.e().x(z90.h().i(str, this.a));
                    DMNav.from(BannerViewHolder.this.a).toUri(str);
                }
            }
        }

        public BannerViewHolder(Context context) {
            super(LayoutInflater.from(context).inflate(R$layout.dm_pay_success_banner, (ViewGroup) null));
            this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            this.a = context;
            this.b = (ImageView) this.itemView.findViewById(R$id.iv_banner);
            int i2 = DisplayMetrics.getwidthPixels(v50.b(context));
            this.b.setLayoutParams(new LinearLayout.LayoutParams(i2, (i2 * 95) / 375));
            RelativeLayout relativeLayout = (RelativeLayout) this.itemView.findViewById(R$id.payresult_score_info);
            this.c = relativeLayout;
            this.d = (ImageView) relativeLayout.findViewById(R$id.payresult_score_icon);
            this.e = (TextView) this.c.findViewById(R$id.tv_score_title);
            this.f = (TextView) this.c.findViewById(R$id.tv_score_sub_title);
            this.g = (TextView) this.c.findViewById(R$id.tv_score_btn);
            this.c.setVisibility(8);
            RoundImageView roundImageView = (RoundImageView) this.c.findViewById(R$id.iv_score);
            roundImageView.setType(1);
            roundImageView.setBorderRadius(12);
            roundImageView.setImageResource(R$drawable.score_bg);
        }

        public void c(PayAdvertBean payAdvertBean, String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-476761080")) {
                ipChange.ipc$dispatch("-476761080", new Object[]{this, payAdvertBean, str, str2});
            } else if (payAdvertBean != null) {
                if (payAdvertBean.vipScore != null) {
                    this.c.setVisibility(0);
                    z90.h().n(this.c, str, str2, String.valueOf(payAdvertBean.vipScore.memberFlag));
                    if (payAdvertBean.vipScore.isUnbind()) {
                        this.h = "3";
                        z90.h().m(this.c, this.h);
                        this.e.setText(payAdvertBean.vipScore.primaryContent);
                        this.f.setText(payAdvertBean.vipScore.secondaryContent);
                        this.g.setText("升级会员");
                        this.d.setImageResource(R$drawable.score_upgrade_icon);
                        this.c.setOnClickListener(new a());
                    } else if (payAdvertBean.vipScore.isbindNotAuth()) {
                        if (payAdvertBean.vipScore.memberThreshold) {
                            this.h = "1";
                        } else {
                            this.h = "3";
                        }
                        z90.h().m(this.c, this.h);
                        this.e.setText(payAdvertBean.vipScore.primaryContent);
                        this.f.setText(payAdvertBean.vipScore.secondaryContent);
                        this.g.setText("升级会员");
                        this.d.setImageResource(R$drawable.score_upgrade_icon);
                        this.c.setOnClickListener(new b(payAdvertBean));
                    } else if (!payAdvertBean.vipScore.isEmpty()) {
                        this.d.setImageResource(R$drawable.score_icon);
                        this.e.setText(Html.fromHtml("恭喜购票获得<font color= '#FF1268'>" + payAdvertBean.vipScore.oriScore + "</font>" + "会员积分"));
                        if (payAdvertBean.isVipMember()) {
                            this.f.setText("积分可免费兑换代金券哦~");
                            this.g.setText("去兑换");
                        } else {
                            this.f.setText("升级会员可免费兑换代金券哦~");
                            this.g.setText("去看看");
                        }
                        this.c.setOnClickListener(new c(str, str2, payAdvertBean));
                    } else {
                        this.c.setVisibility(8);
                    }
                } else {
                    this.c.setVisibility(8);
                }
                PageBanner pageBanner = payAdvertBean.advertisement;
                if (pageBanner == null || TextUtils.isEmpty(pageBanner.picUrl) || TextUtils.isEmpty(pageBanner.schema)) {
                    this.b.setVisibility(8);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("titlelabel", pageBanner.schema);
                hashMap.put("item_id", str2);
                hashMap.put("city", d20.d());
                hashMap.put(FeedsViewModel.ARG_USERID, d20.i());
                hashMap.put("usercode", d20.E());
                cn.damai.common.user.c.e().G(this.b, "bannerimg", "banners", z90.DM_PAY_SUCCESS, hashMap);
                this.b.setVisibility(0);
                DMImageCreator c2 = cn.damai.common.image.a.b().c(pageBanner.picUrl);
                int i2 = R$drawable.uikit_default_image_bg_gradient;
                c2.i(i2).c(i2).g(this.b);
                this.b.setTag(pageBanner.schema);
                this.b.setOnClickListener(new d(str2));
            }
        }
    }

    /* compiled from: Taobao */
    public class PayStateViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private Context a;
        private MarqueTextView b;
        private DMIconFontTextView c;
        private TextView d;
        private TextView e;
        private TextView f;
        private TextView g;
        private TextView h;
        private String i;
        private String j;

        /* compiled from: Taobao */
        public class a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ String a;
            final /* synthetic */ String b;

            a(String str, String str2) {
                this.a = str;
                this.b = str2;
            }

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1741861330")) {
                    ipChange.ipc$dispatch("-1741861330", new Object[]{this, view});
                    return;
                }
                c.e().x(z90.h().j(PayStateViewHolder.this.j, PayStateViewHolder.this.i, this.a));
                String str = this.b;
                if (str != null && str.contains("HNOrderDetailPage")) {
                    str = this.b + "&HNCreateOrderPage=true";
                }
                DMNav.from(PayStateViewHolder.this.a).toUri(str);
                ((Activity) PayStateViewHolder.this.a).finish();
            }
        }

        public PayStateViewHolder(DmPaySuccessAdapter dmPaySuccessAdapter, Context context) {
            super(LayoutInflater.from(context).inflate(R$layout.dm_pay_success_info, (ViewGroup) null));
            this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            this.a = context;
            e(this.itemView);
        }

        private void e(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1270974135")) {
                ipChange.ipc$dispatch("1270974135", new Object[]{this, view});
                return;
            }
            this.b = (MarqueTextView) view.findViewById(R$id.tv_tip);
            this.c = (DMIconFontTextView) view.findViewById(R$id.icon_pay_result);
            this.d = (TextView) view.findViewById(R$id.tv_pay_result);
            this.e = (TextView) view.findViewById(R$id.tv_order_money);
            this.f = (TextView) view.findViewById(R$id.tv_delivery_tip);
            this.g = (TextView) view.findViewById(R$id.tv_left);
            this.h = (TextView) view.findViewById(R$id.tv_right);
        }

        public void d(DmPaySuccessBean dmPaySuccessBean) {
            IpChange ipChange = $ipChange;
            int i2 = 2;
            if (AndroidInstantRuntime.support(ipChange, "-1925361003")) {
                ipChange.ipc$dispatch("-1925361003", new Object[]{this, dmPaySuccessBean});
            } else if (dmPaySuccessBean != null) {
                this.i = dmPaySuccessBean.orderId;
                this.j = dmPaySuccessBean.projectId;
                if (TextUtils.isEmpty(dmPaySuccessBean.reservedDesc)) {
                    this.b.setVisibility(8);
                } else {
                    this.b.setText(dmPaySuccessBean.reservedDesc);
                    this.b.setVisibility(0);
                }
                this.d.setText(dmPaySuccessBean.resultDesc);
                if (dmPaySuccessBean.isPayState()) {
                    this.c.setText(this.a.getString(R$string.iconfont_Successfulpayment));
                    this.c.setTextColor(ContextCompat.getColor(this.a, R$color.pay_state_success));
                    this.d.setTextColor(ContextCompat.getColor(this.a, R$color.pay_state_fail));
                } else {
                    this.c.setText(this.a.getString(R$string.iconfont_Inprocessing));
                    DMIconFontTextView dMIconFontTextView = this.c;
                    Context context = this.a;
                    int i3 = R$color.color_ffaa00;
                    dMIconFontTextView.setTextColor(ContextCompat.getColor(context, i3));
                    this.d.setTextColor(ContextCompat.getColor(this.a, i3));
                }
                this.e.setVisibility(TextUtils.isEmpty(dmPaySuccessBean.paymentInfo) ? 8 : 0);
                TextView textView = this.e;
                String str = dmPaySuccessBean.paymentInfo;
                String str2 = "";
                if (str == null) {
                    str = str2;
                }
                textView.setText(str);
                this.f.setVisibility(TextUtils.isEmpty(dmPaySuccessBean.tip) ? 8 : 0);
                TextView textView2 = this.f;
                String str3 = dmPaySuccessBean.tip;
                if (str3 != null) {
                    str2 = str3;
                }
                textView2.setText(str2);
                this.g.setVisibility(8);
                this.h.setVisibility(8);
                int e2 = xf2.e(dmPaySuccessBean.buttons);
                if (e2 == 1) {
                    DmPayButtonBean dmPayButtonBean = dmPaySuccessBean.buttons.get(0);
                    if (dmPayButtonBean != null) {
                        this.g.setVisibility(0);
                        this.h.setVisibility(8);
                        this.g.setText(dmPayButtonBean.buttonText);
                        h(this.g, dmPayButtonBean.nativeUrl, dmPayButtonBean.buttonText);
                        g(this.g, dmPayButtonBean.nativeUrl);
                        return;
                    }
                    return;
                }
                if (e2 <= 1) {
                    i2 = e2;
                }
                for (int i4 = 0; i4 < i2; i4++) {
                    DmPayButtonBean dmPayButtonBean2 = dmPaySuccessBean.buttons.get(i4);
                    if (dmPayButtonBean2 != null) {
                        if (i4 == 0) {
                            this.g.setVisibility(0);
                            this.g.setText(dmPayButtonBean2.buttonText);
                            h(this.g, dmPayButtonBean2.nativeUrl, dmPayButtonBean2.buttonText);
                            g(this.g, dmPayButtonBean2.nativeUrl);
                        } else {
                            this.h.setVisibility(0);
                            this.h.setText(dmPayButtonBean2.buttonText);
                            h(this.h, dmPayButtonBean2.nativeUrl, dmPayButtonBean2.buttonText);
                            g(this.h, dmPayButtonBean2.nativeUrl);
                        }
                    }
                }
            }
        }

        public boolean f(String str) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-234796328")) {
                return !TextUtils.isEmpty(str) && str.contains("HomePage");
            }
            return ((Boolean) ipChange.ipc$dispatch("-234796328", new Object[]{this, str})).booleanValue();
        }

        public void g(TextView textView, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-478690019")) {
                ipChange.ipc$dispatch("-478690019", new Object[]{this, textView, str});
            } else if (textView != null) {
                if (f(str)) {
                    textView.setBackgroundResource(R$drawable.bg_pay_success_home);
                    textView.setTextColor(ContextCompat.getColor(this.a, R$color.color_FF2D79));
                    return;
                }
                textView.setBackgroundResource(R$drawable.bg_pay_success_detail);
                textView.setTextColor(ContextCompat.getColor(this.a, R$color.white));
            }
        }

        public void h(View view, String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-446991664")) {
                ipChange.ipc$dispatch("-446991664", new Object[]{this, view, str, str2});
            } else if (view != null && str != null) {
                view.setOnClickListener(new a(str2, str));
            }
        }
    }

    /* compiled from: Taobao */
    public class a extends nx1 {
        private static transient /* synthetic */ IpChange $ipChange;

        a(Context context) {
            super(context);
        }

        @Override // tb.nx1, tb.yg1
        public void f(@NonNull View view, @NonNull JSONObject jSONObject, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2031600045")) {
                ipChange.ipc$dispatch("-2031600045", new Object[]{this, view, jSONObject, Integer.valueOf(i)});
                return;
            }
            super.f(view, jSONObject, i);
            c e2 = c.e();
            e2.G(view, "item_" + i, "otherperform", z90.DM_PAY_SUCCESS, DmPaySuccessAdapter.this.d);
        }
    }

    public DmPaySuccessAdapter(Context context, List<DmPaySuccessDataHolder> list) {
        this.a = list;
        this.b = context;
    }

    private ArrayList<BaseLayer> c(DmPaySuccessDataHolder dmPaySuccessDataHolder) {
        BaccountInfo baccountInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-310700899")) {
            return (ArrayList) ipChange.ipc$dispatch("-310700899", new Object[]{this, dmPaySuccessDataHolder});
        }
        ArrayList<BaseLayer> arrayList = new ArrayList<>();
        BaseLayer baseLayer = new BaseLayer();
        ArrayList arrayList2 = new ArrayList();
        BaseSection baseSection = new BaseSection();
        baseSection.setComponentId("dm_card_ip_brand");
        JSONObject jSONObject = new JSONObject();
        if (!(dmPaySuccessDataHolder == null || dmPaySuccessDataHolder.mAdvertBean.baccount == null)) {
            BrandInfoBean brandInfoBean = new BrandInfoBean();
            BaccountInfo baccountInfo2 = dmPaySuccessDataHolder.mAdvertBean.baccount;
            brandInfoBean.id = baccountInfo2.id;
            brandInfoBean.name = baccountInfo2.name;
            brandInfoBean.subTitle = baccountInfo2.subTitle;
            brandInfoBean.followStatus = baccountInfo2.followStatus;
            brandInfoBean.pic = baccountInfo2.headPic;
            brandInfoBean.backgroundPic = baccountInfo2.backgroundPic;
            brandInfoBean.activityDO = baccountInfo2.activityDO;
            jSONObject.put("brand", (Object) brandInfoBean);
            JSON.parseObject(JSON.toJSONString(jSONObject));
            baseSection.setItem(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("brandId", (Object) dmPaySuccessDataHolder.mAdvertBean.baccount.id);
            jSONObject2.put("orderid", (Object) dmPaySuccessDataHolder.mOrderId);
            PayAdvertBean payAdvertBean = dmPaySuccessDataHolder.mAdvertBean;
            if (!(payAdvertBean == null || (baccountInfo = payAdvertBean.baccount) == null || TextUtils.isEmpty(baccountInfo.followStatus))) {
                jSONObject2.put("status", (Object) dmPaySuccessDataHolder.mAdvertBean.baccount.followStatus);
            }
            baseSection.setTrackInfoBeta(jSONObject2);
            baseSection.getTrackInfo().trackB = z90.DM_PAY_SUCCESS;
            baseSection.getTrackInfo().trackC = "brand";
            arrayList2.add(baseSection);
            baseLayer.setSections(arrayList2);
            arrayList.add(baseLayer);
        }
        return arrayList;
    }

    public void b(vv2 vv2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "884751780")) {
            ipChange.ipc$dispatch("884751780", new Object[]{this, vv2});
            return;
        }
        this.c = vv2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "607643853")) {
            return xf2.e(this.a);
        }
        return ((Integer) ipChange.ipc$dispatch("607643853", new Object[]{this})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1131001076")) {
            return this.a.get(i).type;
        }
        return ((Integer) ipChange.ipc$dispatch("1131001076", new Object[]{this, Integer.valueOf(i)})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "917346316")) {
            ipChange.ipc$dispatch("917346316", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        DmPaySuccessDataHolder dmPaySuccessDataHolder = this.a.get(i);
        if (dmPaySuccessDataHolder != null) {
            int i2 = dmPaySuccessDataHolder.type;
            if (i2 == 0) {
                ((PayStateViewHolder) viewHolder).d(dmPaySuccessDataHolder.mPayResponse);
            } else if (i2 != 1) {
                if (i2 == 3) {
                    ((NativeGaiaXViewHolder) viewHolder).d("damai", nx1.TEMPLATE_ID, "4", (float) DeviceInfoProviderProxy.getWindowWidth(), i, dmPaySuccessDataHolder.recommendMo);
                }
            } else if (dmPaySuccessDataHolder.mAdvertBean != null) {
                LinearLayout c2 = this.c.c(c(dmPaySuccessDataHolder), (ViewGroup) viewHolder.itemView);
                ViewGroup viewGroup = (ViewGroup) viewHolder.itemView.findViewById(R$id.payresult_brand_area);
                viewGroup.removeAllViews();
                viewGroup.addView(c2);
                View findViewById = viewGroup.findViewById(cn.damai.commonbusiness.R$id.ip_brand_title);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
                ((BannerViewHolder) viewHolder).c(dmPaySuccessDataHolder.mAdvertBean, dmPaySuccessDataHolder.mOrderId, dmPaySuccessDataHolder.mProjectId);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1724074346")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("1724074346", new Object[]{this, viewGroup, Integer.valueOf(i)});
        } else if (i == 0) {
            return new PayStateViewHolder(this, viewGroup.getContext());
        } else {
            if (i == 1) {
                return new BannerViewHolder(viewGroup.getContext());
            }
            if (i == 2) {
                return new RecommendTitleViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.bricks_coupon_order_result_recommend_title, viewGroup, false));
            }
            if (i != 3) {
                return null;
            }
            return new NativeGaiaXViewHolder(viewGroup.getContext(), new a(viewGroup.getContext()));
        }
    }
}
