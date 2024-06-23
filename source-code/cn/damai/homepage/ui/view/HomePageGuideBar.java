package cn.damai.homepage.ui.view;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import cn.damai.common.DamaiConstants;
import cn.damai.common.badge.DMBadgeListener;
import cn.damai.common.badge.bean.BadgeNodeItem;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$dimen;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.bean.KeyWord;
import cn.damai.login.LoginManager;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.tag.DMCertInfoTagView;
import com.alibaba.fastjson.JSON;
import com.alibaba.pictures.bricks.view.DMUpMarqueeView;
import com.alibaba.pictures.picpermission.Permission;
import com.alibaba.pictures.picpermission.custom.IPermissionListener;
import com.alient.onearch.adapter.pom.OneArchConstants;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.alimm.xadsdk.base.expose.MonitorType;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import com.youku.resource.widget.YKActionSheet;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.m;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ax0;
import tb.br;
import tb.d20;
import tb.fp1;
import tb.fw1;
import tb.gr;
import tb.hp1;
import tb.i92;
import tb.k21;
import tb.kr1;
import tb.lp1;
import tb.m40;
import tb.mt0;
import tb.mw0;
import tb.ne2;
import tb.nw0;
import tb.ow0;
import tb.pw0;
import tb.qw0;
import tb.rw0;
import tb.sw0;
import tb.tw0;
import tb.uw0;
import tb.yp;

/* compiled from: Taobao */
public final class HomePageGuideBar extends LinearLayout implements LifecycleObserver {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final String DM_MSGBOX = "DM_MSGBOX";
    private static final int REQUEST_CODE_OPEN_MESSAGE_CENTER = 111;
    @NotNull
    private static List<String> SEARCH_TEXT_LIST = new ArrayList();
    @NotNull
    private static final HashMap<String, KeyWord> TEXT_MAPPING = new HashMap<>();
    @Nullable
    private Boolean isInTransBgState;
    @Nullable
    private yp mBadgManager;
    @NotNull
    private final DMBadgeListener mBadgeListener;
    @NotNull
    private final DMCertInfoTagView mCertInfoView;
    @NotNull
    private String mCurrentCity;
    @NotNull
    private br mDMMessage;
    @NotNull
    private final FrameLayout mMessage;
    @NotNull
    private final DMIconFontTextView mMessageIcon;
    @NotNull
    private final TextView mMessageTip;
    @NotNull
    private final DMIconFontTextView mScan;
    @NotNull
    private TextView mSearchBtn;
    @NotNull
    private DMUpMarqueeView mSearchText;
    @NotNull
    private LinearLayout mSearchView;
    @NotNull
    private final TextView mSelectCity;
    @NotNull
    private final DMIconFontTextView mSelectCityIcon;
    @NotNull
    private final LinearLayout mSelectCityLayout;
    @NotNull
    private final LinearLayout mTitleBar;
    @Nullable
    private Map<String, ? extends Action> mTrackInfo;
    @NotNull
    private final View statusBarSpace;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final List<String> a() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1872014659")) {
                return HomePageGuideBar.SEARCH_TEXT_LIST;
            }
            return (List) ipChange.ipc$dispatch("1872014659", new Object[]{this});
        }
    }

    /* compiled from: Taobao */
    public static final class b implements IPermissionListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ HomePageGuideBar a;
        final /* synthetic */ List<String> b;
        final /* synthetic */ Activity c;

        b(HomePageGuideBar homePageGuideBar, List<String> list, Activity activity) {
            this.a = homePageGuideBar;
            this.b = list;
            this.c = activity;
        }

        /* access modifiers changed from: private */
        public static final void c(Activity activity, DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "726884229")) {
                ipChange.ipc$dispatch("726884229", new Object[]{activity, dialogInterface, Integer.valueOf(i)});
                return;
            }
            k21.i(activity, "$activity");
            dialogInterface.dismiss();
            i92.e(activity);
        }

        /* access modifiers changed from: private */
        public static final void d(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1932721618")) {
                ipChange.ipc$dispatch("1932721618", new Object[]{dialogInterface, Integer.valueOf(i)});
                return;
            }
            dialogInterface.dismiss();
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionDenied(@NotNull String[] strArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2112456575")) {
                ipChange.ipc$dispatch("2112456575", new Object[]{this, strArr});
                return;
            }
            k21.i(strArr, "permission");
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "298842100")) {
                ipChange.ipc$dispatch("298842100", new Object[]{this});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean(MonitorType.SKIP, true);
            DMNav.from(this.a.getContext()).withExtras(bundle).toUri(NavUri.b("home_scan"));
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onShowRationale(@NotNull String[] strArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "765088057")) {
                ipChange.ipc$dispatch("765088057", new Object[]{this, strArr});
                return;
            }
            k21.i(strArr, "deniedPermissions");
            fp1.a(this.a.getContext(), hp1.d(this.b), this.b, false, new tw0(this.c), uw0.a);
        }
    }

    /* compiled from: Taobao */
    public static final class c implements DMBadgeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ HomePageGuideBar a;

        c(HomePageGuideBar homePageGuideBar) {
            this.a = homePageGuideBar;
        }

        @Override // cn.damai.common.badge.DMBadgeListener
        public void badgeChanged(@NotNull String str, @NotNull BadgeNodeItem badgeNodeItem) {
            IpChange ipChange = $ipChange;
            int i = 0;
            if (AndroidInstantRuntime.support(ipChange, "-937534920")) {
                ipChange.ipc$dispatch("-937534920", new Object[]{this, str, badgeNodeItem});
                return;
            }
            k21.i(str, "nodeId");
            k21.i(badgeNodeItem, "badgeNodeItem");
            yp ypVar = this.a.mBadgManager;
            if (ypVar != null) {
                ypVar.i(str, this);
            }
            int count = badgeNodeItem.getCount();
            this.a.mMessageTip.setText(count > 9 ? "9+" : String.valueOf(count));
            TextView textView = this.a.mMessageTip;
            if (count <= 0) {
                i = 8;
            }
            textView.setVisibility(i);
        }

        @Override // cn.damai.common.badge.DMBadgeListener
        public void badgeQueryFail(@NotNull List<String> list, @NotNull String str, @NotNull String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-55190272")) {
                ipChange.ipc$dispatch("-55190272", new Object[]{this, list, str, str2});
                return;
            }
            k21.i(list, "list");
            k21.i(str, "s");
            k21.i(str2, "s1");
            yp ypVar = this.a.mBadgManager;
            if (ypVar != null) {
                ypVar.j(list, this);
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HomePageGuideBar(@NotNull Context context) {
        this(context, null, 2, null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomePageGuideBar(Context context, AttributeSet attributeSet, int i, m40 m40) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    private final View createView(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-948476998")) {
            return (View) ipChange.ipc$dispatch("-948476998", new Object[]{this, str});
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.channel_page_bar_text, (ViewGroup) null);
        k21.h(inflate, "from(context)\n          …nnel_page_bar_text, null)");
        View findViewById = inflate.findViewById(R$id.channel_search_text);
        k21.h(findViewById, "view.findViewById(R.id.channel_search_text)");
        ((TextView) findViewById).setText(str);
        inflate.setTag(str);
        return inflate;
    }

    private final void initClickByActivity(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1533293935")) {
            ipChange.ipc$dispatch("1533293935", new Object[]{this, activity});
            return;
        }
        this.mCertInfoView.setOnClickListener(new mw0(activity, this));
        this.mSelectCityLayout.setOnClickListener(new qw0(this, activity));
        this.mSearchText.setOnItemClickListener(new sw0(this));
        this.mSearchBtn.setOnClickListener(new nw0(this));
        this.mMessage.setOnClickListener(new pw0(this, activity));
        this.mScan.setOnClickListener(new ow0(this, activity));
    }

    /* access modifiers changed from: private */
    /* renamed from: initClickByActivity$lambda-11  reason: not valid java name */
    public static final void m32initClickByActivity$lambda11(HomePageGuideBar homePageGuideBar, Activity activity, View view) {
        Action action;
        TrackInfo trackInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-922055184")) {
            ipChange.ipc$dispatch("-922055184", new Object[]{homePageGuideBar, activity, view});
            return;
        }
        k21.i(homePageGuideBar, "this$0");
        k21.i(activity, "$activity");
        Map<String, ? extends Action> map = homePageGuideBar.mTrackInfo;
        if (!(map == null || (action = (Action) map.get("message")) == null || (trackInfo = action.getTrackInfo()) == null)) {
            UserTrackProviderProxy.click(trackInfo, true);
        }
        if (LoginManager.k().q()) {
            DMNav.from(activity).toUri(NavUri.b(gr.x));
        } else {
            LoginManager.k().x(activity, new Intent(), 111);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initClickByActivity$lambda-13  reason: not valid java name */
    public static final void m33initClickByActivity$lambda13(HomePageGuideBar homePageGuideBar, Activity activity, View view) {
        Action action;
        TrackInfo trackInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1692788750")) {
            ipChange.ipc$dispatch("-1692788750", new Object[]{homePageGuideBar, activity, view});
            return;
        }
        k21.i(homePageGuideBar, "this$0");
        k21.i(activity, "$activity");
        Map<String, ? extends Action> map = homePageGuideBar.mTrackInfo;
        if (!(map == null || (action = (Action) map.get(fw1.HOME_SCAN_PAGE)) == null || (trackInfo = action.getTrackInfo()) == null)) {
            UserTrackProviderProxy.click(trackInfo, true);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.CAMERA");
        Application application = AppInfoProviderProxy.getApplication();
        k21.h(application, "getApplication()");
        String[] strArr = lp1.CAMERA;
        k21.h(strArr, "CAMERA");
        new Permission(application, strArr).a(new b(homePageGuideBar, arrayList, activity)).b();
    }

    /* access modifiers changed from: private */
    /* renamed from: initClickByActivity$lambda-5  reason: not valid java name */
    public static final void m34initClickByActivity$lambda5(Activity activity, HomePageGuideBar homePageGuideBar, View view) {
        Action action;
        TrackInfo trackInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1570570641")) {
            ipChange.ipc$dispatch("1570570641", new Object[]{activity, homePageGuideBar, view});
            return;
        }
        k21.i(activity, "$activity");
        k21.i(homePageGuideBar, "this$0");
        DMNav.from(activity).toUri("https://p.damai.cn/wow/act/act/license");
        Map<String, ? extends Action> map = homePageGuideBar.mTrackInfo;
        if (map != null && (action = (Action) map.get(IRequestConst.LICENSE)) != null && (trackInfo = action.getTrackInfo()) != null) {
            UserTrackProviderProxy.click(trackInfo, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initClickByActivity$lambda-7  reason: not valid java name */
    public static final void m35initClickByActivity$lambda7(HomePageGuideBar homePageGuideBar, Activity activity, View view) {
        Action action;
        TrackInfo trackInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-406436269")) {
            ipChange.ipc$dispatch("-406436269", new Object[]{homePageGuideBar, activity, view});
            return;
        }
        k21.i(homePageGuideBar, "this$0");
        k21.i(activity, "$activity");
        Map<String, ? extends Action> map = homePageGuideBar.mTrackInfo;
        if (!(map == null || (action = (Action) map.get("city")) == null || (trackInfo = action.getTrackInfo()) == null)) {
            UserTrackProviderProxy.click(trackInfo, true);
        }
        Bundle bundle = new Bundle();
        bundle.putString("data", "home");
        bundle.putBoolean(MonitorType.SKIP, true);
        DMNav.from(activity).withExtras(bundle).forResult(78).toUri(NavUri.b("home_cityselect"));
    }

    /* access modifiers changed from: private */
    /* renamed from: initClickByActivity$lambda-8  reason: not valid java name */
    public static final void m36initClickByActivity$lambda8(HomePageGuideBar homePageGuideBar, int i, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1453761883")) {
            ipChange.ipc$dispatch("1453761883", new Object[]{homePageGuideBar, Integer.valueOf(i), view});
            return;
        }
        k21.i(homePageGuideBar, "this$0");
        homePageGuideBar.jumpSearch(false);
    }

    /* access modifiers changed from: private */
    /* renamed from: initClickByActivity$lambda-9  reason: not valid java name */
    public static final void m37initClickByActivity$lambda9(HomePageGuideBar homePageGuideBar, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "405486247")) {
            ipChange.ipc$dispatch("405486247", new Object[]{homePageGuideBar, view});
            return;
        }
        k21.i(homePageGuideBar, "this$0");
        k21.h(homePageGuideBar.mSearchText.getCurrentView(), "mSearchText.currentView");
        homePageGuideBar.jumpSearch(true);
    }

    private final void initStateBar(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "573774191")) {
            ipChange.ipc$dispatch("573774191", new Object[]{this, activity});
            return;
        }
        int a2 = mt0.INSTANCE.a(activity);
        if (Build.VERSION.SDK_INT >= 23) {
            this.statusBarSpace.getLayoutParams().height = ne2.a(activity);
            this.statusBarSpace.setVisibility(0);
            ne2.f(activity, true, R$color.black);
            ne2.d(true, activity);
        } else {
            ne2.f(activity, false, R$color.black);
            this.statusBarSpace.setVisibility(8);
        }
        this.mTitleBar.getLayoutParams().height = a2;
        invalidate();
    }

    private final void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1993540838")) {
            ipChange.ipc$dispatch("-1993540838", new Object[]{this});
            return;
        }
        this.mCertInfoView.setPosition(1);
        this.mSearchText.setFlipInterval(5000);
        this.mSearchText.setAnimationDuration(500);
    }

    private final void jumpSearch(boolean z) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "239071387")) {
            ipChange.ipc$dispatch("239071387", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        try {
            Object tag = this.mSearchText.getCurrentView().getTag();
            k21.g(tag, "null cannot be cast to non-null type kotlin.String");
            str = (String) tag;
        } catch (Exception e) {
            e.printStackTrace();
            str = "";
        }
        KeyWord keyWord = TEXT_MAPPING.get(str);
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putString("autowords", str);
            cn.damai.common.user.c.e().x(ax0.I().E(str));
        } else {
            cn.damai.common.user.c.e().x(ax0.I().F(str, keyWord));
        }
        bundle.putString(OneArchConstants.LayoutKey.KEY_WORDS, str);
        bundle.putString(YKActionSheet.ACTION_STYLE_DESCRIBE, str);
        DMNav.from(getContext()).withExtras(bundle).toUri(NavUri.b(gr.o));
    }

    private final void listenDMMessage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1503618588")) {
            ipChange.ipc$dispatch("-1503618588", new Object[]{this});
            return;
        }
        this.mDMMessage.b(DamaiConstants.CITY_CHANGED, new rw0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: listenDMMessage$lambda-14  reason: not valid java name */
    public static final void m38listenDMMessage$lambda14(HomePageGuideBar homePageGuideBar, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1434032752")) {
            ipChange.ipc$dispatch("-1434032752", new Object[]{homePageGuideBar, obj});
            return;
        }
        k21.i(homePageGuideBar, "this$0");
        kr1 a2 = kr1.Companion.a();
        String c2 = d20.c();
        k21.h(c2, "getCityId()");
        a2.p(c2);
        homePageGuideBar.updateShowCity();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private final void loadUnReadMsgCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "892989996")) {
            ipChange.ipc$dispatch("892989996", new Object[]{this});
        } else if (LoginManager.k().q()) {
            if (this.mBadgManager == null) {
                this.mBadgManager = yp.a();
            }
            yp ypVar = this.mBadgManager;
            if (ypVar != null) {
                ypVar.g(DM_MSGBOX, this.mBadgeListener);
            }
            List<String> list = m.j(DM_MSGBOX, yp.f);
            yp ypVar2 = this.mBadgManager;
            if (ypVar2 != null) {
                ypVar2.d(list);
            }
        }
    }

    private final void updateSearchText() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-352177231")) {
            ipChange.ipc$dispatch("-352177231", new Object[]{this});
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = SEARCH_TEXT_LIST.iterator();
        while (it.hasNext()) {
            arrayList.add(createView(it.next()));
        }
        this.mSearchText.setItems(arrayList);
    }

    private final void updateShowCity() {
        int i;
        Resources resources;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1199898626")) {
            ipChange.ipc$dispatch("-1199898626", new Object[]{this});
            return;
        }
        String d = d20.d();
        k21.h(d, "getCityName()");
        this.mCurrentCity = d;
        this.mSelectCity.setText(d);
        TextView textView = this.mSelectCity;
        if (TextUtils.getTrimmedLength(this.mCurrentCity) >= 3) {
            resources = getResources();
            i = R$dimen.font_Subhead1_M;
        } else {
            resources = getResources();
            i = R$dimen.font_Headline2_M;
        }
        textView.setTextSize(0, resources.getDimension(i));
    }

    public final int getGuideLayoutHeight() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-387089589")) {
            return this.mTitleBar.getLayoutParams().height;
        }
        return ((Integer) ipChange.ipc$dispatch("-387089589", new Object[]{this})).intValue();
    }

    public final void initDefault(@Nullable FragmentActivity fragmentActivity, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "13247201")) {
            ipChange.ipc$dispatch("13247201", new Object[]{this, fragmentActivity, Boolean.valueOf(z)});
            return;
        }
        SEARCH_TEXT_LIST.add("搜索明星 演出 赛事 场馆");
        updateSearchText();
        this.mSelectCity.setText(this.mCurrentCity);
        this.mCertInfoView.setWhiteMode(z);
        if (fragmentActivity != null) {
            initClickByActivity(fragmentActivity);
            initStateBar(fragmentActivity);
            fragmentActivity.getLifecycle().addObserver(this);
        }
        ax0.I().a0(this.mSearchView, JSON.toJSONString(SEARCH_TEXT_LIST), "home");
    }

    @Nullable
    public final Boolean isInTransBgState() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "344949145")) {
            return this.isInTransBgState;
        }
        return (Boolean) ipChange.ipc$dispatch("344949145", new Object[]{this});
    }

    public final void logoutUpdateUI() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1640819048")) {
            ipChange.ipc$dispatch("1640819048", new Object[]{this});
            return;
        }
        TextView textView = this.mMessageTip;
        if (textView.getVisibility() == 0) {
            textView.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1178084004")) {
            ipChange.ipc$dispatch("1178084004", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.mDMMessage.a();
    }

    public final void setInTransBgState(@Nullable Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1530374749")) {
            ipChange.ipc$dispatch("1530374749", new Object[]{this, bool});
            return;
        }
        this.isInTransBgState = bool;
    }

    public final void setSearchText(@NotNull List<String> list, @NotNull List<? extends KeyWord> list2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2027285594")) {
            ipChange.ipc$dispatch("-2027285594", new Object[]{this, list, list2});
            return;
        }
        k21.i(list, "keyword");
        k21.i(list2, "orgList");
        TEXT_MAPPING.clear();
        for (T t : list2) {
            HashMap<String, KeyWord> hashMap = TEXT_MAPPING;
            String keyword = t.getKeyword();
            k21.h(keyword, "it.keyword");
            hashMap.put(keyword, t);
        }
        SEARCH_TEXT_LIST.clear();
        SEARCH_TEXT_LIST.addAll(list);
        updateSearchText();
    }

    public final void setTrackInfo(@Nullable Map<String, ? extends Action> map, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1665084233")) {
            ipChange.ipc$dispatch("-1665084233", new Object[]{this, map, str});
        } else if (map != null) {
            for (Map.Entry<String, ? extends Action> entry : map.entrySet()) {
                ((Action) entry.getValue()).getTrackInfo().setSpmb(str);
            }
            this.mTrackInfo = map;
        }
    }

    public final void setWhiteStyle(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "868771363")) {
            ipChange.ipc$dispatch("868771363", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mCertInfoView.setWhiteMode(z);
        if (z) {
            TextView textView = this.mSelectCity;
            Resources resources = getResources();
            int i = R$color.cg_7;
            textView.setTextColor(ResourcesCompat.getColor(resources, i, null));
            this.mSelectCityIcon.setTextColor(ResourcesCompat.getColor(getResources(), i, null));
            this.mMessageIcon.setTextColor(-1);
            return;
        }
        TextView textView2 = this.mSelectCity;
        Resources resources2 = getResources();
        int i2 = R$color.cg_0;
        textView2.setTextColor(ResourcesCompat.getColor(resources2, i2, null));
        this.mSelectCityIcon.setTextColor(ResourcesCompat.getColor(getResources(), i2, null));
        this.mMessageIcon.setTextColor(ResourcesCompat.getColor(getResources(), R$color.color_3C3F44, null));
    }

    public final void showTransBg(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-350535703")) {
            ipChange.ipc$dispatch("-350535703", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isInTransBgState = Boolean.valueOf(z);
        if (z) {
            this.mTitleBar.setBackground(ResourcesCompat.getDrawable(getResources(), R$drawable.transparent_bg, null));
            this.mSearchView.setBackground(ResourcesCompat.getDrawable(getResources(), R$drawable.home_guide_search_white_bg, null));
            setWhiteStyle(true);
            return;
        }
        setWhiteStyle(false);
        this.mSearchView.setBackground(ResourcesCompat.getDrawable(getResources(), R$drawable.home_guide_search_bg, null));
        this.mTitleBar.setBackground(ResourcesCompat.getDrawable(getResources(), R$drawable.home_guide_bar, null));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HomePageGuideBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        LayoutInflater.from(context).inflate(R$layout.homepage_guide_bar, (ViewGroup) this, true);
        View findViewById = findViewById(R$id.homepage_header_bar);
        k21.h(findViewById, "findViewById(R.id.homepage_header_bar)");
        this.mTitleBar = (LinearLayout) findViewById;
        View findViewById2 = findViewById(R$id.status_bar_space);
        k21.h(findViewById2, "findViewById(R.id.status_bar_space)");
        this.statusBarSpace = findViewById2;
        View findViewById3 = findViewById(R$id.homepage_header_cert_info);
        k21.h(findViewById3, "findViewById(R.id.homepage_header_cert_info)");
        this.mCertInfoView = (DMCertInfoTagView) findViewById3;
        View findViewById4 = findViewById(R$id.homepage_header_select_city_layout);
        k21.h(findViewById4, "findViewById(R.id.homepa…eader_select_city_layout)");
        this.mSelectCityLayout = (LinearLayout) findViewById4;
        View findViewById5 = findViewById(R$id.homepage_header_select_city);
        k21.h(findViewById5, "findViewById(R.id.homepage_header_select_city)");
        this.mSelectCity = (TextView) findViewById5;
        View findViewById6 = findViewById(R$id.homepage_header_select_city_icon);
        k21.h(findViewById6, "findViewById(R.id.homepa…_header_select_city_icon)");
        this.mSelectCityIcon = (DMIconFontTextView) findViewById6;
        String d = d20.d();
        k21.h(d, "getCityName()");
        this.mCurrentCity = d;
        this.mDMMessage = new br();
        View findViewById7 = findViewById(R$id.homepage_header_search_layout);
        k21.h(findViewById7, "findViewById(R.id.homepage_header_search_layout)");
        this.mSearchView = (LinearLayout) findViewById7;
        View findViewById8 = findViewById(R$id.homepage_header_scan);
        k21.h(findViewById8, "findViewById(R.id.homepage_header_scan)");
        this.mScan = (DMIconFontTextView) findViewById8;
        View findViewById9 = findViewById(R$id.homepage_header_search);
        k21.h(findViewById9, "findViewById(R.id.homepage_header_search)");
        this.mSearchText = (DMUpMarqueeView) findViewById9;
        View findViewById10 = findViewById(R$id.homepage_header_search_btn);
        k21.h(findViewById10, "findViewById(R.id.homepage_header_search_btn)");
        this.mSearchBtn = (TextView) findViewById10;
        View findViewById11 = findViewById(R$id.homepage_header_message_layout);
        k21.h(findViewById11, "findViewById(R.id.homepage_header_message_layout)");
        this.mMessage = (FrameLayout) findViewById11;
        View findViewById12 = findViewById(R$id.homepage_header_message);
        k21.h(findViewById12, "findViewById(R.id.homepage_header_message)");
        this.mMessageIcon = (DMIconFontTextView) findViewById12;
        View findViewById13 = findViewById(R$id.homepage_header_message_tip_point);
        k21.h(findViewById13, "findViewById(R.id.homepa…header_message_tip_point)");
        this.mMessageTip = (TextView) findViewById13;
        initView();
        listenDMMessage();
        this.mBadgeListener = new c(this);
    }
}
