package cn.damai.commonbusiness.scriptmurder.shopdetail;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.common.user.a;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.view.StopAbleViewFlipper;
import com.alibaba.pictures.bricks.bean.OrderItem;
import com.alibaba.pictures.bricks.bean.ShareInfoBean;
import com.alibaba.pictures.bricks.bean.ShopInfoBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.Node;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.d20;
import tb.ea2;
import tb.f92;
import tb.fa2;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
public class ShopDetailActivity extends CommonNavbarActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String STORE_ID = "storeId";
    @NotNull
    public static final String TAG = "ShopDetailActivity";
    public StopAbleViewFlipper flipper;
    private boolean hasBanner;
    @NotNull
    private final AtomicBoolean mHasPaused = new AtomicBoolean(false);
    private boolean playFinished;
    public ShopDetailFragment shopDetailFragment;
    @Nullable
    private ShopInfoBean shopInfoBean;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    private final void initFlipper() {
        ArrayList<OrderItem> orders;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1343934795")) {
            ipChange.ipc$dispatch("1343934795", new Object[]{this});
            return;
        }
        ShopInfoBean shopInfoBean2 = this.shopInfoBean;
        if (shopInfoBean2 != null) {
            if (!(f92.d(shopInfoBean2 != null ? shopInfoBean2.getOrders() : null) || this.playFinished)) {
                getFlipper().removeAllViews();
                getFlipper().setChangeListener(new ea2(this));
                StopAbleViewFlipper flipper2 = getFlipper();
                flipper2.setVisibility(8);
                ShopInfoBean shopInfoBean3 = this.shopInfoBean;
                if (!(shopInfoBean3 == null || (orders = shopInfoBean3.getOrders()) == null)) {
                    for (T t : orders) {
                        View inflate = LayoutInflater.from(flipper2.getContext()).inflate(R$layout.item_info_shopdetail_order_info, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R$id.common_navbar_info_title)).setText(t.getNickName() + ' ' + t.getText());
                        ((TextView) inflate.findViewById(R$id.common_navbar_info_desc)).setText(t.getTime());
                        flipper2.addView(inflate);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initFlipper$lambda-10  reason: not valid java name */
    public static final void m10initFlipper$lambda10(ShopDetailActivity shopDetailActivity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "355881583")) {
            ipChange.ipc$dispatch("355881583", new Object[]{shopDetailActivity});
            return;
        }
        k21.i(shopDetailActivity, "this$0");
        StopAbleViewFlipper flipper2 = shopDetailActivity.getFlipper();
        flipper2.stopFlipping();
        flipper2.removeAllViews();
        flipper2.setVisibility(8);
        shopDetailActivity.playFinished = true;
    }

    /* access modifiers changed from: private */
    /* renamed from: onRefresh$lambda-13  reason: not valid java name */
    public static final void m11onRefresh$lambda13(ShopDetailActivity shopDetailActivity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1917303920")) {
            ipChange.ipc$dispatch("1917303920", new Object[]{shopDetailActivity});
            return;
        }
        k21.i(shopDetailActivity, "this$0");
        shopDetailActivity.initFlipper();
    }

    private final void startFlipAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1459843979")) {
            ipChange.ipc$dispatch("1459843979", new Object[]{this});
            return;
        }
        getFlipper().setVisibility(0);
        getFlipper().startFlipping();
    }

    @Override // cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity
    public void addFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "628226042")) {
            ipChange.ipc$dispatch("628226042", new Object[]{this});
            return;
        }
        String stringExtra = getIntent().getStringExtra("storeId");
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        setShopDetailFragment(new ShopDetailFragment());
        ShopDetailFragment shopDetailFragment2 = getShopDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("storeId", stringExtra);
        shopDetailFragment2.setArguments(bundle);
        beginTransaction.add(R$id.container, getShopDetailFragment());
        beginTransaction.commit();
    }

    @Override // cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity
    public void addUtPage() {
        String stringExtra;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1654715644")) {
            ipChange.ipc$dispatch("1654715644", new Object[]{this});
            return;
        }
        HashMap hashMap = new HashMap();
        Intent intent = getIntent();
        if (!(intent == null || (stringExtra = intent.getStringExtra("storeId")) == null)) {
            hashMap.put("store_id", stringExtra);
        }
        setDamaiUTKeyBuilder(new a.b().i("scriptkill_store").a(d20.d()).j(hashMap));
    }

    @NotNull
    public final StopAbleViewFlipper getFlipper() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-467576046")) {
            return (StopAbleViewFlipper) ipChange.ipc$dispatch("-467576046", new Object[]{this});
        }
        StopAbleViewFlipper stopAbleViewFlipper = this.flipper;
        if (stopAbleViewFlipper != null) {
            return stopAbleViewFlipper;
        }
        k21.A("flipper");
        return null;
    }

    public final boolean getHasBanner() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1448165459")) {
            return this.hasBanner;
        }
        return ((Boolean) ipChange.ipc$dispatch("1448165459", new Object[]{this})).booleanValue();
    }

    public final boolean getPlayFinished() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "168376563")) {
            return this.playFinished;
        }
        return ((Boolean) ipChange.ipc$dispatch("168376563", new Object[]{this})).booleanValue();
    }

    @NotNull
    public final ShopDetailFragment getShopDetailFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-62014020")) {
            return (ShopDetailFragment) ipChange.ipc$dispatch("-62014020", new Object[]{this});
        }
        ShopDetailFragment shopDetailFragment2 = this.shopDetailFragment;
        if (shopDetailFragment2 != null) {
            return shopDetailFragment2;
        }
        k21.A("shopDetailFragment");
        return null;
    }

    @Nullable
    public final ShopInfoBean getShopInfoBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1058144867")) {
            return this.shopInfoBean;
        }
        return (ShopInfoBean) ipChange.ipc$dispatch("1058144867", new Object[]{this});
    }

    @Override // cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity
    public void initBaseInfo(@NotNull Object obj) {
        Node node;
        List<Node> children;
        boolean z;
        Object obj2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1298690260")) {
            ipChange.ipc$dispatch("-1298690260", new Object[]{this, obj});
            return;
        }
        k21.i(obj, "bean");
        List<Node> list = null;
        HashMap hashMap = obj instanceof HashMap ? (HashMap) obj : null;
        if (!(hashMap == null || (obj2 = hashMap.get("value")) == null)) {
            this.shopInfoBean = obj2 instanceof ShopInfoBean ? (ShopInfoBean) obj2 : null;
        }
        ModelValue property = getShopDetailFragment().getPageContainer().getProperty();
        k21.g(property, "null cannot be cast to non-null type com.youku.arch.v3.core.Node");
        List<Node> children2 = property.getChildren();
        if (children2 != null) {
            if (children2.isEmpty()) {
                children2 = null;
            }
            if (!(children2 == null || (node = children2.get(0)) == null || (children = node.getChildren()) == null)) {
                if (!children.isEmpty()) {
                    list = children;
                }
                if (list != null) {
                    for (T t : list) {
                        if (t.getType() == 9994 && t.getChildren() != null) {
                            List<Node> children3 = t.getChildren();
                            k21.f(children3);
                            if (children3.size() > 0) {
                                z = true;
                                this.hasBanner = z;
                            }
                        }
                        z = false;
                        this.hasBanner = z;
                    }
                }
            }
        }
        if (!this.hasBanner) {
            starAnim();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-140914448")) {
            ipChange.ipc$dispatch("-140914448", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        View findViewById = findViewById(R$id.common_navbar_info_flipper);
        k21.g(findViewById, "null cannot be cast to non-null type cn.damai.commonbusiness.view.StopAbleViewFlipper");
        setFlipper((StopAbleViewFlipper) findViewById);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2141510096")) {
            ipChange.ipc$dispatch("-2141510096", new Object[]{this});
            return;
        }
        super.onDestroy();
        getFlipper().stopFlipping();
        getFlipper().removeAllViews();
        getFlipper().setChangeListener(null);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1471006708")) {
            ipChange.ipc$dispatch("1471006708", new Object[]{this});
            return;
        }
        super.onPause();
        if (getFlipper().isFlipping()) {
            this.mHasPaused.compareAndSet(false, true);
            stopAnim();
        }
    }

    public final void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "371538863")) {
            ipChange.ipc$dispatch("371538863", new Object[]{this});
            return;
        }
        this.playFinished = false;
        runOnUiThread(new fa2(this));
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "4354195")) {
            ipChange.ipc$dispatch("4354195", new Object[]{this});
            return;
        }
        super.onResume();
        if (this.mHasPaused.get()) {
            this.mHasPaused.compareAndSet(true, false);
            starAnim();
        }
    }

    @Override // cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity
    public void onShareClick() {
        ShareInfoBean shareDO;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-8132393")) {
            ipChange.ipc$dispatch("-8132393", new Object[]{this});
            return;
        }
        ShopInfoBean shopInfoBean2 = this.shopInfoBean;
        if (shopInfoBean2 != null) {
            k21.f(shopInfoBean2);
            if (shopInfoBean2.getShareDO() != null) {
                Bundle bundle = new Bundle();
                ShopInfoBean shopInfoBean3 = this.shopInfoBean;
                if (!(shopInfoBean3 == null || (shareDO = shopInfoBean3.getShareDO()) == null)) {
                    bundle.putString("title", shareDO.getShareTitle());
                    bundle.putString("message", shareDO.getShareSubTitle());
                    bundle.putString("imageurl", shareDO.getShareImage());
                    bundle.putString("producturl", shareDO.getShareUrl());
                }
                ShareManager.E().T(this, bundle, getWindow().getDecorView());
                ShareManager.E().l0();
            }
        }
    }

    public final void setFlipper(@NotNull StopAbleViewFlipper stopAbleViewFlipper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1330477426")) {
            ipChange.ipc$dispatch("1330477426", new Object[]{this, stopAbleViewFlipper});
            return;
        }
        k21.i(stopAbleViewFlipper, "<set-?>");
        this.flipper = stopAbleViewFlipper;
    }

    public final void setHasBanner(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "112059097")) {
            ipChange.ipc$dispatch("112059097", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.hasBanner = z;
    }

    public final void setPlayFinished(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-618976047")) {
            ipChange.ipc$dispatch("-618976047", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.playFinished = z;
    }

    public final void setShopDetailFragment(@NotNull ShopDetailFragment shopDetailFragment2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2091110102")) {
            ipChange.ipc$dispatch("2091110102", new Object[]{this, shopDetailFragment2});
            return;
        }
        k21.i(shopDetailFragment2, "<set-?>");
        this.shopDetailFragment = shopDetailFragment2;
    }

    public final void setShopInfoBean(@Nullable ShopInfoBean shopInfoBean2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-315436707")) {
            ipChange.ipc$dispatch("-315436707", new Object[]{this, shopInfoBean2});
            return;
        }
        this.shopInfoBean = shopInfoBean2;
    }

    public final void starAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1562283876")) {
            ipChange.ipc$dispatch("-1562283876", new Object[]{this});
            return;
        }
        if (getFlipper().getChildCount() == 0) {
            initFlipper();
        }
        startFlipAnim();
    }

    public void startWithCheck() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1247258145")) {
            ipChange.ipc$dispatch("-1247258145", new Object[]{this});
        } else if (this.flipper == null || (this.hasBanner && !getFlipper().isFlipping())) {
            starAnim();
        }
    }

    public final void stopAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-287495956")) {
            ipChange.ipc$dispatch("-287495956", new Object[]{this});
            return;
        }
        View currentView = getFlipper().getCurrentView();
        if (currentView != null) {
            currentView.setVisibility(8);
        }
        getFlipper().stopFlipping();
    }

    public void stopWithCheck() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "454511659")) {
            ipChange.ipc$dispatch("454511659", new Object[]{this});
        } else if (this.hasBanner) {
            stopAnim();
        }
    }
}
