package cn.damai.trade.newtradeorder.ui.orderdetail.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.common.user.a;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.trade.R$color;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import com.alibaba.pictures.bricks.orderresult.CouponPayResultFragment;
import com.alibaba.pictures.bricks.orderresult.couponpayresult.PayResultUtListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.d20;
import tb.k21;
import tb.m40;
import tb.ne2;
import tb.ur2;

/* compiled from: Taobao */
public final class CouponPayResultActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    public static final int DM_REQUEST_CODE_PAY_SUCCESS = 100001;
    @Nullable
    private final String mOrderId;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* compiled from: Taobao */
    public static final class b implements PayResultUtListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ CouponPayResultActivity a;

        b(CouponPayResultActivity couponPayResultActivity) {
            this.a = couponPayResultActivity;
        }

        @Override // com.alibaba.pictures.bricks.orderresult.couponpayresult.PayResultUtListener
        public void updateUTParam(@NotNull String str, @NotNull String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1795900741")) {
                ipChange.ipc$dispatch("1795900741", new Object[]{this, str, str2});
                return;
            }
            k21.i(str, "isPaid");
            k21.i(str2, SocialConstants.PARAM_APP_DESC);
            this.a.addUtPage(str, str2);
        }
    }

    private final void addFragment() {
        Bundle extras;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1568807821")) {
            ipChange.ipc$dispatch("-1568807821", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        String string = (intent == null || (extras = intent.getExtras()) == null) ? null : extras.getString("orderId");
        b bVar = new b(this);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        int i = R$id.coupon_result_container;
        CouponPayResultFragment couponPayResultFragment = new CouponPayResultFragment();
        Bundle bundle = new Bundle();
        if (string != null) {
            bundle.putString("orderId", string);
            bundle.putString("cityId", d20.c());
        }
        couponPayResultFragment.setArguments(bundle);
        couponPayResultFragment.setUtListener(bVar);
        ur2 ur2 = ur2.INSTANCE;
        beginTransaction.add(i, couponPayResultFragment);
        beginTransaction.commit();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void addUtPage(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "424798793")) {
            ipChange.ipc$dispatch("424798793", new Object[]{this, str, str2});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("orderid", this.mOrderId);
        hashMap.put("titlelable", str);
        hashMap.put("contentlabel", str2);
        setDamaiUTKeyBuilder(new a.b().i("scriptkill_payresult").j(hashMap));
    }

    private final void fixStatusBar(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-490213480")) {
            ipChange.ipc$dispatch("-490213480", new Object[]{this, view});
        } else if (Build.VERSION.SDK_INT >= 23) {
            if (view != null) {
                view.getLayoutParams().height = ne2.a(this);
                view.setVisibility(0);
            }
            ne2.f(this, true, R$color.black);
            ne2.d(true, this);
        } else {
            ne2.f(this, false, R$color.black);
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    private final void setImmersionStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1097316444")) {
            ipChange.ipc$dispatch("1097316444", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.coupon_title_bar_space_view);
        k21.h(findViewById, "statusBar");
        fixStatusBar(findViewById);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2146916060")) {
            return R$layout.coupon_pay_result_layout;
        }
        return ((Integer) ipChange.ipc$dispatch("2146916060", new Object[]{this})).intValue();
    }

    @Nullable
    public final String getMOrderId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1703063218")) {
            return this.mOrderId;
        }
        return (String) ipChange.ipc$dispatch("-1703063218", new Object[]{this});
    }

    @Override // androidx.activity.ComponentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1443046664")) {
            ipChange.ipc$dispatch("1443046664", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1214796951")) {
            ipChange.ipc$dispatch("-1214796951", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setContentView(getLayoutId());
        setImmersionStyle();
        addFragment();
        c.e().K(this);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    @NotNull
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-492172208")) {
            return "";
        }
        return (String) ipChange.ipc$dispatch("-492172208", new Object[]{this});
    }
}
