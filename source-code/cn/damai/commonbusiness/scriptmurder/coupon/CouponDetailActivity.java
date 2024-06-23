package cn.damai.commonbusiness.scriptmurder.coupon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.a;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.im.AliMeUtil;
import cn.damai.login.LoginManager;
import com.alibaba.pictures.bricks.bean.BuyBtnVO;
import com.alibaba.pictures.bricks.bean.CouponInfoBean;
import com.alibaba.pictures.bricks.bean.ShareInfoBean;
import com.alibaba.pictures.bricks.bean.SkuInfoBean;
import com.alibaba.pictures.bricks.orderconfirm.CouponOrderConfirmFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.bo;
import tb.d20;
import tb.gr;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
public final class CouponDetailActivity extends CommonNavbarActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String TAG = "CouponDetailActivity";
    @Nullable
    private CouponInfoBean couponInfoBean;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    private final void createOrder() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "647774632")) {
            ipChange.ipc$dispatch("647774632", new Object[]{this});
        } else if (!LoginManager.k().q()) {
            LoginManager.k().v(this);
        } else {
            Bundle bundle = new Bundle();
            HashMap hashMap = new HashMap();
            CouponInfoBean couponInfoBean2 = this.couponInfoBean;
            if (couponInfoBean2 != null) {
                bundle.putString("itemId", couponInfoBean2.getItemId());
                hashMap.put("itemId", couponInfoBean2.getItemId() + "");
                ArrayList<SkuInfoBean> skuList = couponInfoBean2.getSkuList();
                if (skuList != null && skuList.size() > 0) {
                    bundle.putString(CouponOrderConfirmFragment.SKU_ID, skuList.get(0).skuId);
                }
            }
            DMNav.from(this).withExtras(bundle).toUri(NavUri.b(gr.COUPON_ORDER_CONFIRM));
            c.e().x(new a.b().i("scriptkill_coupon").f("bottom").l("buy").g(true).j(hashMap));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initBaseInfo$lambda-7$lambda-5$lambda-4  reason: not valid java name */
    public static final void m8initBaseInfo$lambda7$lambda5$lambda4(CouponDetailActivity couponDetailActivity, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1496935607")) {
            ipChange.ipc$dispatch("-1496935607", new Object[]{couponDetailActivity, view});
            return;
        }
        k21.i(couponDetailActivity, "this$0");
        couponDetailActivity.createOrder();
    }

    private final void launchAliMe(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1898086501")) {
            ipChange.ipc$dispatch("-1898086501", new Object[]{this, view});
            return;
        }
        CouponInfoBean couponInfoBean2 = this.couponInfoBean;
        AliMeUtil.m(this, AliMeUtil.SESSION_COUPON_DETAIL, couponInfoBean2 != null ? couponInfoBean2.getItemId() : null, "");
    }

    @Override // cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity
    public void addFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "420665065")) {
            ipChange.ipc$dispatch("420665065", new Object[]{this});
            return;
        }
        String stringExtra = getIntent().getStringExtra(CouponDetailFragment.COUPON_ID);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        CouponDetailFragment couponDetailFragment = new CouponDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(CouponDetailFragment.COUPON_ID, stringExtra);
        couponDetailFragment.setArguments(bundle);
        beginTransaction.add(R$id.container, couponDetailFragment);
        beginTransaction.commit();
    }

    @Override // cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity
    public void addUtPage() {
        String stringExtra;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1518681173")) {
            ipChange.ipc$dispatch("-1518681173", new Object[]{this});
            return;
        }
        HashMap hashMap = new HashMap();
        Intent intent = getIntent();
        if (!(intent == null || (stringExtra = intent.getStringExtra(CouponDetailFragment.COUPON_ID)) == null)) {
            hashMap.put("coupon_id", stringExtra);
        }
        setDamaiUTKeyBuilder(new a.b().i("scriptkill_coupon").a(d20.d()).j(hashMap));
    }

    @Nullable
    public final CouponInfoBean getCouponInfoBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1175488846")) {
            return this.couponInfoBean;
        }
        return (CouponInfoBean) ipChange.ipc$dispatch("-1175488846", new Object[]{this});
    }

    @Override // cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity, cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-158578350")) {
            return R$layout.activity_script_murder_coupon_detail;
        }
        return ((Integer) ipChange.ipc$dispatch("-158578350", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity
    public void initBaseInfo(@NotNull Object obj) {
        BuyBtnVO buyBtnVO;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1928664029")) {
            ipChange.ipc$dispatch("1928664029", new Object[]{this, obj});
            return;
        }
        k21.i(obj, "bean");
        CouponInfoBean couponInfoBean2 = null;
        HashMap hashMap = obj instanceof HashMap ? (HashMap) obj : null;
        Object obj2 = hashMap != null ? hashMap.get("value") : null;
        if (obj2 instanceof CouponInfoBean) {
            couponInfoBean2 = (CouponInfoBean) obj2;
        }
        if (couponInfoBean2 != null) {
            this.couponInfoBean = couponInfoBean2;
        }
        CouponInfoBean couponInfoBean3 = this.couponInfoBean;
        if (couponInfoBean3 != null && (buyBtnVO = couponInfoBean3.getBuyBtnVO()) != null) {
            if ("1".equals(buyBtnVO.getBtnStatus())) {
                View findViewById = findViewById(R$id.coupon_bottom_buy_btn_tv);
                if (findViewById != null) {
                    k21.h(findViewById, "findViewById<TextView>(R…coupon_bottom_buy_btn_tv)");
                    TextView textView = (TextView) findViewById;
                    textView.setText(buyBtnVO.getBtnText());
                    textView.setClickable(true);
                    findViewById.setOnClickListener(new bo(this));
                    return;
                }
                return;
            }
            View findViewById2 = findViewById(R$id.coupon_bottom_buy_btn_tv);
            if (findViewById2 != null) {
                k21.h(findViewById2, "findViewById<TextView>(R…coupon_bottom_buy_btn_tv)");
                TextView textView2 = (TextView) findViewById2;
                textView2.setText(buyBtnVO.getBtnText());
                textView2.setBackground(findViewById2.getResources().getDrawable(R$drawable.coupon_buy_btn_unusable_bg));
                textView2.setClickable(false);
            }
        }
    }

    @Override // cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity
    public void onShareClick() {
        ShareInfoBean shareDO;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2147411912")) {
            ipChange.ipc$dispatch("2147411912", new Object[]{this});
            return;
        }
        CouponInfoBean couponInfoBean2 = this.couponInfoBean;
        if (couponInfoBean2 != null && (shareDO = couponInfoBean2.getShareDO()) != null) {
            Bundle bundle = new Bundle();
            bundle.putString("title", shareDO.getShareTitle());
            bundle.putString("message", shareDO.getShareSubTitle());
            bundle.putString("imageurl", shareDO.getShareImage());
            bundle.putString("producturl", shareDO.getShareUrl());
            ShareManager.E().T(this, bundle, getWindow().getDecorView());
            ShareManager.E().l0();
        }
    }

    public final void setCouponInfoBean(@Nullable CouponInfoBean couponInfoBean2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1548291506")) {
            ipChange.ipc$dispatch("-1548291506", new Object[]{this, couponInfoBean2});
            return;
        }
        this.couponInfoBean = couponInfoBean2;
    }
}
