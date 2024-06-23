package com.youku.arch.v3.page;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.uc.webview.export.media.MessageID;
import com.youku.arch.R;
import com.youku.arch.v3.core.ActivityContext;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.event.ActivityEventPoster;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.arch.v3.loader.ActivityLoader;
import com.youku.arch.v3.page.DelegateConfigure;
import com.youku.arch.v3.recyclerview.GenericRecycledViewPool;
import com.youku.kubus.EventBus;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joor.a;
import tb.k21;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b{\u0010|J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0004H\u0014J\b\u0010\b\u001a\u00020\u0004H\u0014J\b\u0010\t\u001a\u00020\u0004H\u0014J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0014J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H$J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H$J\u0016\u0010 \u001a\u0006\u0012\u0002\b\u00030\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH$J\b\u0010!\u001a\u00020\u0004H\u0014J\b\u0010\"\u001a\u00020\u0004H\u0014J\b\u0010#\u001a\u00020\u0004H\u0014J\u001c\u0010'\u001a\u00020\u00042\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020%0$H\u0016J\u0012\u0010(\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010)\u001a\u00020\u0004H\u0014J\u0016\u0010,\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000+\u0018\u00010*H\u0016J \u0010.\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000+\u0018\u00010*2\b\u0010-\u001a\u0004\u0018\u00010\u0017H\u0016J,\u00100\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000+\u0018\u00010*2\u0014\u0010/\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000+\u0018\u00010*H\u0016R\u001b\u00102\u001a\u0004\u0018\u0001018\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0018\u00107\u001a\u0004\u0018\u0001068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108R$\u0010/\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000+\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00109R$\u0010;\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010A\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR$\u0010H\u001a\u0004\u0018\u00010G8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010N\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR:\u0010V\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010T2\u000e\u0010U\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010T8\u0006@DX\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R.\u0010]\u001a\u0004\u0018\u00010\\2\b\u0010U\u001a\u0004\u0018\u00010\\8F@DX\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR$\u0010d\u001a\u0004\u0018\u00010c8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR$\u0010j\u001a\u00020\u00142\u0006\u0010U\u001a\u00020\u00148\u0006@BX\u000e¢\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bj\u0010lR\u0016\u0010p\u001a\u00020m8$@$X¤\u0004¢\u0006\u0006\u001a\u0004\bn\u0010oR\u0016\u0010r\u001a\u00020m8$@$X¤\u0004¢\u0006\u0006\u001a\u0004\bq\u0010oR\u0016\u0010v\u001a\u00020s8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bt\u0010uR\u0015\u0010z\u001a\u0004\u0018\u00010w8F@\u0006¢\u0006\u0006\u001a\u0004\bx\u0010y¨\u0006}"}, d2 = {"Lcom/youku/arch/v3/page/GenericActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/os/Bundle;", "savedInstanceState", "Ltb/ur2;", "onCreate", "onStart", "onResume", MessageID.onPause, MessageID.onStop, "onBackPressed", "onDestroy", "Landroid/content/Intent;", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "onNewIntent", "onAttachedToWindow", "onDetachedFromWindow", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "", "isInMultiWindowMode", "onMultiWindowModeChanged", "", "getPageName", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/youku/arch/v3/page/BaseViewPagerAdapter;", "initViewPageAdapter", "Lcom/alibaba/fastjson/JSONObject;", "jsonObject", "", "parseTabData", "initViewPager", "refreshViewPager", "initLoader", "", "", Constants.CONFIG, "load", "onTabDataLoaded", "setResumeOrientation", "", "Lcom/youku/arch/v3/page/IDelegate;", "getDelegates", "pathPrefix", "initDelegates", "delegateList", "wrapperDelegates", "Lcom/youku/arch/v3/core/ActivityContext;", "activityContext", "Lcom/youku/arch/v3/core/ActivityContext;", "getActivityContext", "()Lcom/youku/arch/v3/core/ActivityContext;", "Lcom/youku/arch/v3/page/ActivityInterceptor;", "activityInterceptor", "Lcom/youku/arch/v3/page/ActivityInterceptor;", "Ljava/util/List;", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "getViewPager", "()Landroidx/viewpager/widget/ViewPager;", "setViewPager", "(Landroidx/viewpager/widget/ViewPager;)V", "viewPagerAdapter", "Lcom/youku/arch/v3/page/BaseViewPagerAdapter;", "getViewPagerAdapter", "()Lcom/youku/arch/v3/page/BaseViewPagerAdapter;", "setViewPagerAdapter", "(Lcom/youku/arch/v3/page/BaseViewPagerAdapter;)V", "Lcom/youku/arch/v3/page/GenericOnPagerChangeListener;", "onPageChangeListener", "Lcom/youku/arch/v3/page/GenericOnPagerChangeListener;", "getOnPageChangeListener", "()Lcom/youku/arch/v3/page/GenericOnPagerChangeListener;", "setOnPageChangeListener", "(Lcom/youku/arch/v3/page/GenericOnPagerChangeListener;)V", "delegatePathPrefix", "Ljava/lang/String;", "getDelegatePathPrefix", "()Ljava/lang/String;", "setDelegatePathPrefix", "(Ljava/lang/String;)V", "Lcom/youku/arch/v3/loader/ActivityLoader;", "<set-?>", "activityLoader", "Lcom/youku/arch/v3/loader/ActivityLoader;", "getActivityLoader", "()Lcom/youku/arch/v3/loader/ActivityLoader;", "setActivityLoader", "(Lcom/youku/arch/v3/loader/ActivityLoader;)V", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "recycledViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "getRecycledViewPool", "()Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "setRecycledViewPool", "(Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;)V", "Landroid/view/LayoutInflater$Factory2;", "customInflater", "Landroid/view/LayoutInflater$Factory2;", "getCustomInflater", "()Landroid/view/LayoutInflater$Factory2;", "setCustomInflater", "(Landroid/view/LayoutInflater$Factory2;)V", "isFront", "Z", "()Z", "", "getLayoutResId", "()I", "layoutResId", "getViewPagerResId", "viewPagerResId", "Lcom/youku/arch/v3/io/RequestBuilder;", "getRequestBuilder", "()Lcom/youku/arch/v3/io/RequestBuilder;", "requestBuilder", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "rootView", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public abstract class GenericActivity extends AppCompatActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private final ActivityContext activityContext;
    @Nullable
    private ActivityInterceptor activityInterceptor;
    @Nullable
    private ActivityLoader<GenericActivity> activityLoader;
    @Nullable
    private LayoutInflater.Factory2 customInflater;
    @Nullable
    private List<IDelegate<GenericActivity>> delegateList;
    @Nullable
    private String delegatePathPrefix;
    private boolean isFront;
    @Nullable
    private GenericOnPagerChangeListener onPageChangeListener;
    @Nullable
    private RecyclerView.RecycledViewPool recycledViewPool;
    @Nullable
    private ViewPager viewPager;
    @Nullable
    private BaseViewPagerAdapter viewPagerAdapter;

    public GenericActivity() {
        ActivityContext activityContext2 = new ActivityContext();
        this.activityContext = activityContext2;
        activityContext2.setPageName(getPageName());
        EventBus eventBus = activityContext2.getEventBus();
        if (eventBus != null) {
            this.activityInterceptor = new ActivityEventPoster(eventBus);
        }
    }

    @Nullable
    public final ActivityContext getActivityContext() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-804384086")) {
            return this.activityContext;
        }
        return (ActivityContext) ipChange.ipc$dispatch("-804384086", new Object[]{this});
    }

    @Nullable
    public final ActivityLoader<GenericActivity> getActivityLoader() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "321207082")) {
            return this.activityLoader;
        }
        return (ActivityLoader) ipChange.ipc$dispatch("321207082", new Object[]{this});
    }

    @Nullable
    public final LayoutInflater.Factory2 getCustomInflater() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1885449400")) {
            return this.customInflater;
        }
        return (LayoutInflater.Factory2) ipChange.ipc$dispatch("-1885449400", new Object[]{this});
    }

    @Nullable
    public final String getDelegatePathPrefix() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1001521616")) {
            return this.delegatePathPrefix;
        }
        return (String) ipChange.ipc$dispatch("-1001521616", new Object[]{this});
    }

    @Nullable
    public List<IDelegate<GenericActivity>> getDelegates() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-935310857")) {
            return null;
        }
        return (List) ipChange.ipc$dispatch("-935310857", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    public abstract int getLayoutResId();

    @Nullable
    public final GenericOnPagerChangeListener getOnPageChangeListener() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "796857959")) {
            return this.onPageChangeListener;
        }
        return (GenericOnPagerChangeListener) ipChange.ipc$dispatch("796857959", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Nullable
    public abstract String getPageName();

    @Nullable
    public final RecyclerView.RecycledViewPool getRecycledViewPool() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1774641889")) {
            return (RecyclerView.RecycledViewPool) ipChange.ipc$dispatch("-1774641889", new Object[]{this});
        }
        if (this.recycledViewPool == null) {
            this.recycledViewPool = new GenericRecycledViewPool();
        }
        return this.recycledViewPool;
    }

    @NotNull
    public abstract RequestBuilder getRequestBuilder();

    @Nullable
    public final View getRootView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "667639335")) {
            return (View) ipChange.ipc$dispatch("667639335", new Object[]{this});
        }
        View findViewById = findViewById(R.id.content);
        if (findViewById == null) {
            return null;
        }
        return findViewById.getRootView();
    }

    @Nullable
    public final ViewPager getViewPager() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1574482087")) {
            return this.viewPager;
        }
        return (ViewPager) ipChange.ipc$dispatch("1574482087", new Object[]{this});
    }

    @Nullable
    public final BaseViewPagerAdapter getViewPagerAdapter() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1640837641")) {
            return this.viewPagerAdapter;
        }
        return (BaseViewPagerAdapter) ipChange.ipc$dispatch("-1640837641", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    public abstract int getViewPagerResId();

    @Nullable
    public List<IDelegate<GenericActivity>> initDelegates(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1469082183")) {
            return (List) ipChange.ipc$dispatch("-1469082183", new Object[]{this, str});
        }
        List<IDelegate<GenericActivity>> delegates = getDelegates();
        if ((delegates != null && delegates.size() > 0) || TextUtils.isEmpty(str)) {
            return delegates;
        }
        k21.f(str);
        DelegateConfigure delegateConfigure = new DelegateManager(str, this).getDelegateConfigure();
        if (delegateConfigure == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (DelegateConfigure.DelegatesBean delegatesBean : delegateConfigure.getDelegates()) {
            if (delegatesBean.isEnable()) {
                Object f = a.j(delegatesBean.getClassX()).b().f();
                IDelegate iDelegate = f instanceof IDelegate ? (IDelegate) f : null;
                if (iDelegate != null) {
                    arrayList.add(iDelegate);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public void initLoader() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1645060805")) {
            ipChange.ipc$dispatch("1645060805", new Object[]{this});
            return;
        }
        this.activityLoader = new ActivityLoader<>(this);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public abstract BaseViewPagerAdapter initViewPageAdapter(@Nullable FragmentManager fragmentManager);

    /* access modifiers changed from: protected */
    public void initViewPager() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1732740236")) {
            ipChange.ipc$dispatch("-1732740236", new Object[]{this});
            return;
        }
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            refreshViewPager();
            GenericOnPagerChangeListener genericOnPagerChangeListener = new GenericOnPagerChangeListener(this.activityInterceptor);
            viewPager2.addOnPageChangeListener(genericOnPagerChangeListener);
            ur2 ur2 = ur2.INSTANCE;
            setOnPageChangeListener(genericOnPagerChangeListener);
        }
    }

    public final boolean isFront() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "71601511")) {
            return this.isFront;
        }
        return ((Boolean) ipChange.ipc$dispatch("71601511", new Object[]{this})).booleanValue();
    }

    public void load(@NotNull Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-442799933")) {
            ipChange.ipc$dispatch("-442799933", new Object[]{this, map});
            return;
        }
        k21.i(map, Constants.CONFIG);
        ActivityLoader<GenericActivity> activityLoader2 = this.activityLoader;
        if (activityLoader2 != null) {
            activityLoader2.load(map);
        }
    }

    public void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1478787814")) {
            ipChange.ipc$dispatch("-1478787814", new Object[]{this});
            return;
        }
        super.onAttachedToWindow();
        ActivityInterceptor activityInterceptor2 = this.activityInterceptor;
        if (activityInterceptor2 != null) {
            activityInterceptor2.onAttachedToWindow();
        }
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1238403130")) {
            ipChange.ipc$dispatch("-1238403130", new Object[]{this});
            return;
        }
        super.onBackPressed();
        ActivityInterceptor activityInterceptor2 = this.activityInterceptor;
        if (activityInterceptor2 != null) {
            activityInterceptor2.onBackPressed();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onConfigurationChanged(@NotNull Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-988830171")) {
            ipChange.ipc$dispatch("-988830171", new Object[]{this, configuration});
            return;
        }
        k21.i(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        ActivityInterceptor activityInterceptor2 = this.activityInterceptor;
        if (activityInterceptor2 != null) {
            activityInterceptor2.onConfigurationChanged(configuration);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1403345319")) {
            ipChange.ipc$dispatch("1403345319", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        ActivityInterceptor activityInterceptor2 = this.activityInterceptor;
        if (activityInterceptor2 != null) {
            activityInterceptor2.onCreate(bundle);
        }
        setContentView(getLayoutResId());
        int viewPagerResId = getViewPagerResId();
        if (!(viewPagerResId == 0 || viewPagerResId == -1)) {
            this.viewPager = (ViewPager) findViewById(viewPagerResId);
            initViewPager();
        }
        initLoader();
        List<IDelegate<GenericActivity>> initDelegates = initDelegates(this.delegatePathPrefix);
        this.delegateList = initDelegates;
        wrapperDelegates(initDelegates);
        List<IDelegate<GenericActivity>> list = this.delegateList;
        if (list != null) {
            for (IDelegate<GenericActivity> iDelegate : list) {
                iDelegate.setDelegatedContainer(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        EventBus eventBus;
        EventBus eventBus2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1198965081")) {
            ipChange.ipc$dispatch("-1198965081", new Object[]{this});
            return;
        }
        super.onDestroy();
        ActivityInterceptor activityInterceptor2 = this.activityInterceptor;
        if (activityInterceptor2 != null) {
            activityInterceptor2.onDestroy();
        }
        ActivityContext activityContext2 = this.activityContext;
        if (!(activityContext2 == null || (eventBus2 = activityContext2.getEventBus()) == null)) {
            eventBus2.unregister(this);
        }
        List<IDelegate<GenericActivity>> list = this.delegateList;
        if (list != null) {
            for (IDelegate<GenericActivity> iDelegate : list) {
                ActivityContext activityContext3 = getActivityContext();
                if (!(activityContext3 == null || (eventBus = activityContext3.getEventBus()) == null)) {
                    eventBus.unregister(iDelegate);
                }
            }
        }
        ActivityContext activityContext4 = this.activityContext;
        if (activityContext4 != null) {
            activityContext4.release();
        }
    }

    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-390466115")) {
            ipChange.ipc$dispatch("-390466115", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        ActivityInterceptor activityInterceptor2 = this.activityInterceptor;
        if (activityInterceptor2 != null) {
            activityInterceptor2.onDetachedFromWindow();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onMultiWindowModeChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-963914573")) {
            ipChange.ipc$dispatch("-963914573", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.onMultiWindowModeChanged(z);
        ActivityInterceptor activityInterceptor2 = this.activityInterceptor;
        if (activityInterceptor2 != null) {
            activityInterceptor2.onMultiWindowModeChanged(z);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onNewIntent(@NotNull Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-833997630")) {
            ipChange.ipc$dispatch("-833997630", new Object[]{this, intent});
            return;
        }
        k21.i(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        super.onNewIntent(intent);
        ActivityInterceptor activityInterceptor2 = this.activityInterceptor;
        if (activityInterceptor2 != null) {
            activityInterceptor2.onNewIntent(intent);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1856344619")) {
            ipChange.ipc$dispatch("1856344619", new Object[]{this});
            return;
        }
        this.isFront = false;
        super.onPause();
        ActivityInterceptor activityInterceptor2 = this.activityInterceptor;
        if (activityInterceptor2 != null) {
            activityInterceptor2.onPause();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-935072452")) {
            ipChange.ipc$dispatch("-935072452", new Object[]{this});
            return;
        }
        this.isFront = true;
        super.onResume();
        setResumeOrientation();
        ActivityInterceptor activityInterceptor2 = this.activityInterceptor;
        if (activityInterceptor2 != null) {
            activityInterceptor2.onResume();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1899449407")) {
            ipChange.ipc$dispatch("1899449407", new Object[]{this});
            return;
        }
        super.onStart();
        ActivityInterceptor activityInterceptor2 = this.activityInterceptor;
        if (activityInterceptor2 != null) {
            activityInterceptor2.onStart();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "351163975")) {
            ipChange.ipc$dispatch("351163975", new Object[]{this});
            return;
        }
        super.onStop();
        ActivityInterceptor activityInterceptor2 = this.activityInterceptor;
        if (activityInterceptor2 != null) {
            activityInterceptor2.onStop();
        }
    }

    public void onTabDataLoaded(@Nullable JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1001724659")) {
            ipChange.ipc$dispatch("1001724659", new Object[]{this, jSONObject});
            return;
        }
        List<?> parseTabData = parseTabData(jSONObject);
        ActivityContext activityContext2 = this.activityContext;
        if (activityContext2 != null) {
            activityContext2.runOnUIThreadLocked(new GenericActivity$onTabDataLoaded$1(this, parseTabData));
        }
    }

    /* access modifiers changed from: protected */
    @NotNull
    public abstract List<?> parseTabData(@Nullable JSONObject jSONObject);

    /* access modifiers changed from: protected */
    public void refreshViewPager() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-886761915")) {
            ipChange.ipc$dispatch("-886761915", new Object[]{this});
            return;
        }
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            viewPager2.setPageMargin((int) viewPager2.getResources().getDimension(R.dimen.page_margin));
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(viewPager2.getResources().getColor(R.color.page_margin_background));
            viewPager2.setPageMarginDrawable(gradientDrawable);
            BaseViewPagerAdapter initViewPageAdapter = initViewPageAdapter(getSupportFragmentManager());
            if (initViewPageAdapter == null) {
                initViewPageAdapter = null;
            } else {
                this.activityInterceptor = initViewPageAdapter.getActivityEventPoster();
                viewPager2.setAdapter(initViewPageAdapter);
                ur2 ur2 = ur2.INSTANCE;
            }
            setViewPagerAdapter(initViewPageAdapter);
        }
    }

    /* access modifiers changed from: protected */
    public final void setActivityLoader(@Nullable ActivityLoader<GenericActivity> activityLoader2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2105062898")) {
            ipChange.ipc$dispatch("2105062898", new Object[]{this, activityLoader2});
            return;
        }
        this.activityLoader = activityLoader2;
    }

    public final void setCustomInflater(@Nullable LayoutInflater.Factory2 factory2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "482159238")) {
            ipChange.ipc$dispatch("482159238", new Object[]{this, factory2});
            return;
        }
        this.customInflater = factory2;
    }

    public final void setDelegatePathPrefix(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1024405586")) {
            ipChange.ipc$dispatch("-1024405586", new Object[]{this, str});
            return;
        }
        this.delegatePathPrefix = str;
    }

    public final void setOnPageChangeListener(@Nullable GenericOnPagerChangeListener genericOnPagerChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1888404303")) {
            ipChange.ipc$dispatch("1888404303", new Object[]{this, genericOnPagerChangeListener});
            return;
        }
        this.onPageChangeListener = genericOnPagerChangeListener;
    }

    /* access modifiers changed from: protected */
    public final void setRecycledViewPool(@Nullable RecyclerView.RecycledViewPool recycledViewPool2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2074824463")) {
            ipChange.ipc$dispatch("-2074824463", new Object[]{this, recycledViewPool2});
            return;
        }
        this.recycledViewPool = recycledViewPool2;
    }

    /* access modifiers changed from: protected */
    public void setResumeOrientation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2087127961")) {
            ipChange.ipc$dispatch("-2087127961", new Object[]{this});
            return;
        }
        try {
            if (Build.VERSION.SDK_INT == 26) {
                setRequestedOrientation(-1);
            } else if (getRequestedOrientation() != 1) {
                setRequestedOrientation(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void setViewPager(@Nullable ViewPager viewPager2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-308814293")) {
            ipChange.ipc$dispatch("-308814293", new Object[]{this, viewPager2});
            return;
        }
        this.viewPager = viewPager2;
    }

    public final void setViewPagerAdapter(@Nullable BaseViewPagerAdapter baseViewPagerAdapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1387159869")) {
            ipChange.ipc$dispatch("1387159869", new Object[]{this, baseViewPagerAdapter});
            return;
        }
        this.viewPagerAdapter = baseViewPagerAdapter;
    }

    @Nullable
    public List<IDelegate<GenericActivity>> wrapperDelegates(@Nullable List<IDelegate<GenericActivity>> list) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1589478665")) {
            return list;
        }
        return (List) ipChange.ipc$dispatch("1589478665", new Object[]{this, list});
    }
}
