package cn.damai.homepage.util.window;

import android.app.Activity;
import android.app.Application;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import cn.damai.common.DamaiConstants;
import cn.damai.common.OrangeConfigCenter;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.commonbusiness.city.model.SitesBean;
import cn.damai.commonbusiness.city.util.CityLocationUtil;
import cn.damai.homepage.MainActivity;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$string;
import cn.damai.homepage.util.TickletBusinessUtil;
import cn.damai.login.LoginManager;
import cn.damai.uikit.view.DMThemeDialog;
import com.alibaba.pictures.picpermission.Permission;
import com.alibaba.pictures.picpermission.custom.IPermissionListener;
import com.alibaba.pictures.picpermission.manage.PermissionModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;
import kotlin.Result;
import kotlin.collections.m;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.br;
import tb.d20;
import tb.fp1;
import tb.g91;
import tb.hp1;
import tb.jp1;
import tb.jr1;
import tb.k12;
import tb.k21;
import tb.lp1;
import tb.lr1;
import tb.m40;
import tb.ol1;
import tb.p30;
import tb.pr1;
import tb.q32;
import tb.qc;
import tb.xs0;
import tb.yr;

/* compiled from: Taobao */
public final class TopPriortyHandle extends pr1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String NO_CITY_CHANGE = "no_city_change";
    @NotNull
    private Activity a;
    @Nullable
    private PopupCallback b;
    @Nullable
    private TickletBusinessUtil c;
    @Nullable
    private FrameLayout d;
    @Nullable
    private CityLocationUtil e;
    @NotNull
    private lr1<Boolean> f = new lr1<>();
    @NotNull
    private lr1<String> g = new lr1<>();
    @NotNull
    private lr1<String> h = new lr1<>();
    @NotNull
    private lr1<String> i = new lr1<>();
    @NotNull
    private final CityLocationUtil.LocaltionListener j = new b(this);

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* compiled from: Taobao */
    public static final class b implements CityLocationUtil.LocaltionListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TopPriortyHandle a;

        b(TopPriortyHandle topPriortyHandle) {
            this.a = topPriortyHandle;
        }

        @Override // cn.damai.commonbusiness.city.util.CityLocationUtil.LocaltionListener
        public void onGetLocalFinsih() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1123869857")) {
                ipChange.ipc$dispatch("-1123869857", new Object[]{this});
                return;
            }
            this.a.g().b(TopPriortyHandle.NO_CITY_CHANGE);
        }

        @Override // cn.damai.commonbusiness.city.util.CityLocationUtil.LocaltionListener
        public void onGetLocalSuccess(@NotNull SitesBean sitesBean) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "540364341")) {
                ipChange.ipc$dispatch("540364341", new Object[]{this, sitesBean});
                return;
            }
            k21.i(sitesBean, "sitesBean");
            if ((TextUtils.getTrimmedLength(sitesBean.getCityId()) <= 0 || k21.d(String.valueOf(xs0.b), sitesBean.getCityId())) && k21.d(d20.d(), sitesBean.getCityName())) {
                z = false;
            }
            String str = TopPriortyHandle.NO_CITY_CHANGE;
            if (z) {
                lr1<String> g = this.a.g();
                if (TextUtils.getTrimmedLength(sitesBean.getCityName()) > 0) {
                    str = sitesBean.getCityName();
                }
                k21.h(str, "if (TextUtils.getTrimmed…E else sitesBean.cityName");
                g.b(str);
                return;
            }
            this.a.g().b(str);
        }
    }

    /* compiled from: Taobao */
    public static final class c implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TopPriortyHandle a;
        final /* synthetic */ Continuation<jr1> b;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.coroutines.Continuation<? super tb.jr1> */
        /* JADX WARN: Multi-variable type inference failed */
        c(TopPriortyHandle topPriortyHandle, Continuation<? super jr1> continuation) {
            this.a = topPriortyHandle;
            this.b = continuation;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-574994564")) {
                ipChange.ipc$dispatch("-574994564", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            CityLocationUtil cityLocationUtil = this.a.e;
            if (cityLocationUtil != null) {
                cityLocationUtil.q();
            }
            dialogInterface.dismiss();
            br.c(DamaiConstants.CITY_CHANGED, "");
            PopupCallback popupCallback = this.a.b;
            if (popupCallback != null) {
                popupCallback.cityChangeRefresh();
            }
            Continuation<jr1> continuation = this.b;
            Result.a aVar = Result.Companion;
            continuation.resumeWith(Result.m913constructorimpl(jr1.c.INSTANCE));
        }
    }

    /* compiled from: Taobao */
    public static final class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Continuation<jr1> a;

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.coroutines.Continuation<? super tb.jr1> */
        /* JADX WARN: Multi-variable type inference failed */
        d(Continuation<? super jr1> continuation) {
            this.a = continuation;
        }

        public final void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1572076692")) {
                ipChange.ipc$dispatch("1572076692", new Object[]{this, view});
                return;
            }
            Continuation<jr1> continuation = this.a;
            Result.a aVar = Result.Companion;
            continuation.resumeWith(Result.m913constructorimpl(jr1.c.INSTANCE));
        }
    }

    /* compiled from: Taobao */
    public static final class e implements IPermissionListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Continuation<jr1> a;
        final /* synthetic */ TopPriortyHandle b;

        /* compiled from: Taobao */
        public static final class a implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ TopPriortyHandle a;
            final /* synthetic */ Continuation<jr1> b;

            /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.coroutines.Continuation<? super tb.jr1> */
            /* JADX WARN: Multi-variable type inference failed */
            a(TopPriortyHandle topPriortyHandle, Continuation<? super jr1> continuation) {
                this.a = topPriortyHandle;
                this.b = continuation;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1555187047")) {
                    ipChange.ipc$dispatch("-1555187047", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
                jp1.f(this.a.a);
                Continuation<jr1> continuation = this.b;
                Result.a aVar = Result.Companion;
                continuation.resumeWith(Result.m913constructorimpl(jr1.c.INSTANCE));
            }
        }

        /* compiled from: Taobao */
        public static final class b implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ Continuation<jr1> a;

            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.coroutines.Continuation<? super tb.jr1> */
            /* JADX WARN: Multi-variable type inference failed */
            b(Continuation<? super jr1> continuation) {
                this.a = continuation;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-585606024")) {
                    ipChange.ipc$dispatch("-585606024", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
                Continuation<jr1> continuation = this.a;
                Result.a aVar = Result.Companion;
                continuation.resumeWith(Result.m913constructorimpl(jr1.c.INSTANCE));
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.coroutines.Continuation<? super tb.jr1> */
        /* JADX WARN: Multi-variable type inference failed */
        e(Continuation<? super jr1> continuation, TopPriortyHandle topPriortyHandle) {
            this.a = continuation;
            this.b = topPriortyHandle;
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionDenied(@NotNull String[] strArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-115136793")) {
                ipChange.ipc$dispatch("-115136793", new Object[]{this, strArr});
                return;
            }
            k21.i(strArr, "permission");
            Continuation<jr1> continuation = this.a;
            Result.a aVar = Result.Companion;
            continuation.resumeWith(Result.m913constructorimpl(jr1.c.INSTANCE));
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-123068068")) {
                ipChange.ipc$dispatch("-123068068", new Object[]{this});
                return;
            }
            Continuation<jr1> continuation = this.a;
            Result.a aVar = Result.Companion;
            continuation.resumeWith(Result.m913constructorimpl(jr1.c.INSTANCE));
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onShowRationale(@NotNull String[] strArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2001414865")) {
                ipChange.ipc$dispatch("2001414865", new Object[]{this, strArr});
                return;
            }
            k21.i(strArr, "deniedPermissions");
            fp1.a(this.b.a, "获取你所在城市的演出赛事信息，帮助你找到附近的演出赛事", m.j(Arrays.copyOf(strArr, strArr.length)), false, new a(this.b, this.a), new b(this.a));
        }
    }

    /* compiled from: Taobao */
    public static final class f implements DialogInterface.OnDismissListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TopPriortyHandle a;
        final /* synthetic */ Continuation<jr1> b;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.coroutines.Continuation<? super tb.jr1> */
        /* JADX WARN: Multi-variable type inference failed */
        f(TopPriortyHandle topPriortyHandle, Continuation<? super jr1> continuation) {
            this.a = topPriortyHandle;
            this.b = continuation;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2026332385")) {
                ipChange.ipc$dispatch("-2026332385", new Object[]{this, dialogInterface});
                return;
            }
            this.a.i(this.b, jr1.b.INSTANCE);
        }
    }

    /* compiled from: Taobao */
    public static final class g implements TickletBusinessUtil.PopNoShow {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TopPriortyHandle a;
        final /* synthetic */ Continuation<jr1> b;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.coroutines.Continuation<? super tb.jr1> */
        /* JADX WARN: Multi-variable type inference failed */
        g(TopPriortyHandle topPriortyHandle, Continuation<? super jr1> continuation) {
            this.a = topPriortyHandle;
            this.b = continuation;
        }

        @Override // cn.damai.homepage.util.TickletBusinessUtil.PopNoShow
        public final void popNoShow() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "983297314")) {
                ipChange.ipc$dispatch("983297314", new Object[]{this});
                return;
            }
            this.a.i(this.b, jr1.c.INSTANCE);
        }
    }

    /* compiled from: Taobao */
    public static final class h implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TopPriortyHandle a;
        final /* synthetic */ String b;
        final /* synthetic */ Continuation<jr1> c;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.coroutines.Continuation<? super tb.jr1> */
        /* JADX WARN: Multi-variable type inference failed */
        h(TopPriortyHandle topPriortyHandle, String str, Continuation<? super jr1> continuation) {
            this.a = topPriortyHandle;
            this.b = str;
            this.c = continuation;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1574071298")) {
                ipChange.ipc$dispatch("-1574071298", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            yr.b(this.a.a, this.b);
            Continuation<jr1> continuation = this.c;
            Result.a aVar = Result.Companion;
            continuation.resumeWith(Result.m913constructorimpl(jr1.c.INSTANCE));
        }
    }

    public TopPriortyHandle(@NotNull Activity activity) {
        k21.i(activity, "mContext");
        this.a = activity;
    }

    private final void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "375311870")) {
            ipChange.ipc$dispatch("375311870", new Object[]{this});
            return;
        }
        boolean i2 = hp1.i(lp1.LOCATION);
        String B = d20.B(MainActivity.SP_KEY_LOCATION_DIALOG_SHOWED);
        if (i2 || !TextUtils.isEmpty(B)) {
            this.f.b(Boolean.FALSE);
        } else {
            this.f.b(Boolean.TRUE);
        }
    }

    private final void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "415606554")) {
            ipChange.ipc$dispatch("415606554", new Object[]{this});
            return;
        }
        try {
            List asList = Arrays.asList(Arrays.copyOf(new String[]{"Asia/Chongqing", "Asia/Harbin", "Asia/Hong_Kong", "Asia/Macau", "Asia/Shanghai", "Asia/Taipei", "Asia/Urumqi"}, 7));
            String id = TimeZone.getDefault().getID();
            if (asList.contains(id)) {
                this.g.b("false");
                return;
            }
            String b2 = OrangeConfigCenter.c().b(ol1.HOME_OTHER_TIME_ZONE_IN_CHINA, "otherzone", "");
            if (!TextUtils.isEmpty(b2)) {
                k21.h(b2, "otherTimeZone");
                k21.h(id, "currentId");
                if (StringsKt__StringsKt.Q(b2, id, false, 2, null)) {
                    this.g.b("false");
                    return;
                }
            }
            if (k21.d(yr.a(this.a), id)) {
                this.g.b("false");
                return;
            }
            lr1<String> lr1 = this.g;
            k21.h(id, "currentId");
            lr1.b(id);
        } catch (Exception e2) {
            this.g.b("false");
            g91.b("checkTimeZone", e2.getMessage());
        }
    }

    private final void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1626636498")) {
            ipChange.ipc$dispatch("-1626636498", new Object[]{this});
        } else if (hp1.i(lp1.LOCATION)) {
            CityLocationUtil cityLocationUtil = new CityLocationUtil(this.a, this.j);
            this.e = cityLocationUtil;
            cityLocationUtil.p(true);
            cityLocationUtil.n();
        } else {
            this.h.b(NO_CITY_CHANGE);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void i(Continuation<? super jr1> continuation, jr1 jr1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "957086718")) {
            ipChange.ipc$dispatch("957086718", new Object[]{this, continuation, jr1});
        } else if (continuation != null) {
            try {
                Result.a aVar = Result.Companion;
                continuation.resumeWith(Result.m913constructorimpl(jr1));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private final Object k(String str, Continuation<? super jr1> continuation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-386330553")) {
            return ipChange.ipc$dispatch("-386330553", new Object[]{this, str, continuation});
        }
        q32 q32 = new q32(IntrinsicsKt__IntrinsicsJvmKt.c(continuation));
        DMThemeDialog dMThemeDialog = new DMThemeDialog(this.a);
        dMThemeDialog.o("地理位置变更").r(DMThemeDialog.DMDialogTheme.THEME_LOCATION).k(this.a.getString(R$string.change_city_tip, new Object[]{str})).i(this.a.getString(R$string.change_city, new Object[]{str}), new c(this, q32)).g(true, new d(q32));
        if (!this.a.isFinishing()) {
            dMThemeDialog.show();
        } else {
            Result.a aVar = Result.Companion;
            q32.resumeWith(Result.m913constructorimpl(jr1.c.INSTANCE));
        }
        Object a2 = q32.a();
        if (a2 == kotlin.coroutines.intrinsics.b.d()) {
            p30.c(continuation);
        }
        return a2;
    }

    private final Object l(Continuation<? super jr1> continuation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1334666624")) {
            return ipChange.ipc$dispatch("-1334666624", new Object[]{this, continuation});
        }
        q32 q32 = new q32(IntrinsicsKt__IntrinsicsJvmKt.c(continuation));
        d20.T(MainActivity.SP_KEY_LOCATION_DIALOG_SHOWED, "locationExaDes");
        String[] strArr = lp1.LOCATION;
        k21.h(strArr, "LOCATION");
        PermissionModel permissionModel = new PermissionModel(strArr, "位置权限使用说明", qc.b(R$drawable.permission_location_icon), "用于为你提供所在城市演出和场馆信息及帮助你找到附近的演出");
        Application a2 = xs0.a();
        k21.h(a2, "getApplication()");
        new Permission(a2, permissionModel).a(new e(q32, this)).b();
        Object a3 = q32.a();
        if (a3 == kotlin.coroutines.intrinsics.b.d()) {
            p30.c(continuation);
        }
        return a3;
    }

    private final Object m(Continuation<? super jr1> continuation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "103995706")) {
            return ipChange.ipc$dispatch("103995706", new Object[]{this, continuation});
        }
        q32 q32 = new q32(IntrinsicsKt__IntrinsicsJvmKt.c(continuation));
        if (LoginManager.k().q()) {
            TickletBusinessUtil tickletBusinessUtil = this.c;
            if (tickletBusinessUtil != null) {
                tickletBusinessUtil.d(new f(this, q32), new g(this, q32));
                tickletBusinessUtil.g(this.d, true);
            }
        } else {
            i(q32, jr1.c.INSTANCE);
        }
        Object a2 = q32.a();
        if (a2 == kotlin.coroutines.intrinsics.b.d()) {
            p30.c(continuation);
        }
        return a2;
    }

    private final Object n(String str, Continuation<? super jr1> continuation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-803155016")) {
            return ipChange.ipc$dispatch("-803155016", new Object[]{this, str, continuation});
        }
        q32 q32 = new q32(IntrinsicsKt__IntrinsicsJvmKt.c(continuation));
        DMDialog dMDialog = new DMDialog(this.a);
        dMDialog.o(false);
        dMDialog.q("未特殊提示的，抢票和演出时间均为北京时间为准");
        dMDialog.n("知道了", new h(this, str, q32));
        if (!this.a.isFinishing()) {
            dMDialog.show();
        } else {
            Result.a aVar = Result.Companion;
            q32.resumeWith(Result.m913constructorimpl(jr1.c.INSTANCE));
        }
        Object a2 = q32.a();
        if (a2 == kotlin.coroutines.intrinsics.b.d()) {
            p30.c(continuation);
        }
        return a2;
    }

    @NotNull
    public final lr1<String> g() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1066033462")) {
            return this.h;
        }
        return (lr1) ipChange.ipc$dispatch("-1066033462", new Object[]{this});
    }

    public final void j(@Nullable TickletBusinessUtil tickletBusinessUtil, @Nullable FrameLayout frameLayout, @Nullable PopupCallback popupCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "197057835")) {
            ipChange.ipc$dispatch("197057835", new Object[]{this, tickletBusinessUtil, frameLayout, popupCallback});
            return;
        }
        this.b = popupCallback;
        this.c = tickletBusinessUtil;
        this.d = frameLayout;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c7 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0103 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x012e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x013c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x013d A[PHI: r10 
      PHI: (r10v2 java.lang.Object) = (r10v5 java.lang.Object), (r10v1 java.lang.Object) binds: [B:62:0x013a, B:14:0x0049] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    @Override // com.alibaba.yymidservice.popup.popupcenter.view.PopupViewHandleCallback
    @Nullable
    public <T, K> Object popHandle(@Nullable T t, @Nullable K k, @NotNull Continuation<? super jr1> continuation) {
        TopPriortyHandle$popHandle$1 topPriortyHandle$popHandle$1;
        TopPriortyHandle topPriortyHandle;
        lr1<String> lr1;
        String str;
        String str2;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "752889638")) {
            return ipChange.ipc$dispatch("752889638", new Object[]{this, t, k, continuation});
        }
        if (continuation instanceof TopPriortyHandle$popHandle$1) {
            topPriortyHandle$popHandle$1 = (TopPriortyHandle$popHandle$1) continuation;
            int i2 = topPriortyHandle$popHandle$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                topPriortyHandle$popHandle$1.label = i2 - Integer.MIN_VALUE;
                Object obj = topPriortyHandle$popHandle$1.result;
                Object obj2 = kotlin.coroutines.intrinsics.b.d();
                switch (topPriortyHandle$popHandle$1.label) {
                    case 0:
                        k12.b(obj);
                        e();
                        lr1<Boolean> lr12 = this.f;
                        topPriortyHandle$popHandle$1.L$0 = this;
                        topPriortyHandle$popHandle$1.label = 1;
                        obj = lr12.a(topPriortyHandle$popHandle$1);
                        if (obj == obj2) {
                            return obj2;
                        }
                        topPriortyHandle = this;
                        if (k21.d((Boolean) obj, qc.a(true))) {
                            topPriortyHandle$popHandle$1.L$0 = topPriortyHandle;
                            topPriortyHandle$popHandle$1.label = 2;
                            if (topPriortyHandle.l(topPriortyHandle$popHandle$1) == obj2) {
                                return obj2;
                            }
                        }
                        topPriortyHandle.h();
                        topPriortyHandle.f();
                        lr1<String> lr13 = topPriortyHandle.g;
                        topPriortyHandle$popHandle$1.L$0 = topPriortyHandle;
                        topPriortyHandle$popHandle$1.label = 3;
                        obj = lr13.a(topPriortyHandle$popHandle$1);
                        if (obj == obj2) {
                            return obj2;
                        }
                        str2 = (String) obj;
                        if (!k21.d("false", str2)) {
                            if (!(str2 == null || (o.y(str2)))) {
                                topPriortyHandle$popHandle$1.L$0 = topPriortyHandle;
                                topPriortyHandle$popHandle$1.label = 4;
                                if (topPriortyHandle.n(str2, topPriortyHandle$popHandle$1) == obj2) {
                                    return obj2;
                                }
                            }
                        }
                        lr1<String> lr14 = topPriortyHandle.h;
                        topPriortyHandle$popHandle$1.L$0 = topPriortyHandle;
                        topPriortyHandle$popHandle$1.label = 5;
                        obj = lr14.a(topPriortyHandle$popHandle$1);
                        if (obj == obj2) {
                            return obj2;
                        }
                        str = (String) obj;
                        if (!k21.d(NO_CITY_CHANGE, str)) {
                            if (str == null || (o.y(str))) {
                                z = true;
                            }
                            if (!z) {
                                topPriortyHandle$popHandle$1.L$0 = topPriortyHandle;
                                topPriortyHandle$popHandle$1.label = 6;
                                if (topPriortyHandle.k(str, topPriortyHandle$popHandle$1) == obj2) {
                                    return obj2;
                                }
                            }
                        }
                        topPriortyHandle.i.b("ticket");
                        lr1 = topPriortyHandle.i;
                        topPriortyHandle$popHandle$1.L$0 = topPriortyHandle;
                        topPriortyHandle$popHandle$1.label = 7;
                        if (lr1.a(topPriortyHandle$popHandle$1) == obj2) {
                            return obj2;
                        }
                        topPriortyHandle$popHandle$1.L$0 = null;
                        topPriortyHandle$popHandle$1.label = 8;
                        obj = topPriortyHandle.m(topPriortyHandle$popHandle$1);
                        return obj != obj2 ? obj2 : obj;
                    case 1:
                        topPriortyHandle = (TopPriortyHandle) topPriortyHandle$popHandle$1.L$0;
                        k12.b(obj);
                        if (k21.d((Boolean) obj, qc.a(true))) {
                        }
                        topPriortyHandle.h();
                        topPriortyHandle.f();
                        lr1<String> lr132 = topPriortyHandle.g;
                        topPriortyHandle$popHandle$1.L$0 = topPriortyHandle;
                        topPriortyHandle$popHandle$1.label = 3;
                        obj = lr132.a(topPriortyHandle$popHandle$1);
                        if (obj == obj2) {
                        }
                        str2 = (String) obj;
                        if (!k21.d("false", str2)) {
                        }
                        lr1<String> lr142 = topPriortyHandle.h;
                        topPriortyHandle$popHandle$1.L$0 = topPriortyHandle;
                        topPriortyHandle$popHandle$1.label = 5;
                        obj = lr142.a(topPriortyHandle$popHandle$1);
                        if (obj == obj2) {
                        }
                        str = (String) obj;
                        if (!k21.d(NO_CITY_CHANGE, str)) {
                        }
                        topPriortyHandle.i.b("ticket");
                        lr1 = topPriortyHandle.i;
                        topPriortyHandle$popHandle$1.L$0 = topPriortyHandle;
                        topPriortyHandle$popHandle$1.label = 7;
                        if (lr1.a(topPriortyHandle$popHandle$1) == obj2) {
                        }
                        topPriortyHandle$popHandle$1.L$0 = null;
                        topPriortyHandle$popHandle$1.label = 8;
                        obj = topPriortyHandle.m(topPriortyHandle$popHandle$1);
                        if (obj != obj2) {
                        }
                        break;
                    case 2:
                        topPriortyHandle = (TopPriortyHandle) topPriortyHandle$popHandle$1.L$0;
                        k12.b(obj);
                        topPriortyHandle.h();
                        topPriortyHandle.f();
                        lr1<String> lr1322 = topPriortyHandle.g;
                        topPriortyHandle$popHandle$1.L$0 = topPriortyHandle;
                        topPriortyHandle$popHandle$1.label = 3;
                        obj = lr1322.a(topPriortyHandle$popHandle$1);
                        if (obj == obj2) {
                        }
                        str2 = (String) obj;
                        if (!k21.d("false", str2)) {
                        }
                        lr1<String> lr1422 = topPriortyHandle.h;
                        topPriortyHandle$popHandle$1.L$0 = topPriortyHandle;
                        topPriortyHandle$popHandle$1.label = 5;
                        obj = lr1422.a(topPriortyHandle$popHandle$1);
                        if (obj == obj2) {
                        }
                        str = (String) obj;
                        if (!k21.d(NO_CITY_CHANGE, str)) {
                        }
                        topPriortyHandle.i.b("ticket");
                        lr1 = topPriortyHandle.i;
                        topPriortyHandle$popHandle$1.L$0 = topPriortyHandle;
                        topPriortyHandle$popHandle$1.label = 7;
                        if (lr1.a(topPriortyHandle$popHandle$1) == obj2) {
                        }
                        topPriortyHandle$popHandle$1.L$0 = null;
                        topPriortyHandle$popHandle$1.label = 8;
                        obj = topPriortyHandle.m(topPriortyHandle$popHandle$1);
                        if (obj != obj2) {
                        }
                        break;
                    case 3:
                        topPriortyHandle = (TopPriortyHandle) topPriortyHandle$popHandle$1.L$0;
                        k12.b(obj);
                        str2 = (String) obj;
                        if (!k21.d("false", str2)) {
                        }
                        lr1<String> lr14222 = topPriortyHandle.h;
                        topPriortyHandle$popHandle$1.L$0 = topPriortyHandle;
                        topPriortyHandle$popHandle$1.label = 5;
                        obj = lr14222.a(topPriortyHandle$popHandle$1);
                        if (obj == obj2) {
                        }
                        str = (String) obj;
                        if (!k21.d(NO_CITY_CHANGE, str)) {
                        }
                        topPriortyHandle.i.b("ticket");
                        lr1 = topPriortyHandle.i;
                        topPriortyHandle$popHandle$1.L$0 = topPriortyHandle;
                        topPriortyHandle$popHandle$1.label = 7;
                        if (lr1.a(topPriortyHandle$popHandle$1) == obj2) {
                        }
                        topPriortyHandle$popHandle$1.L$0 = null;
                        topPriortyHandle$popHandle$1.label = 8;
                        obj = topPriortyHandle.m(topPriortyHandle$popHandle$1);
                        if (obj != obj2) {
                        }
                        break;
                    case 4:
                        topPriortyHandle = (TopPriortyHandle) topPriortyHandle$popHandle$1.L$0;
                        k12.b(obj);
                        lr1<String> lr142222 = topPriortyHandle.h;
                        topPriortyHandle$popHandle$1.L$0 = topPriortyHandle;
                        topPriortyHandle$popHandle$1.label = 5;
                        obj = lr142222.a(topPriortyHandle$popHandle$1);
                        if (obj == obj2) {
                        }
                        str = (String) obj;
                        if (!k21.d(NO_CITY_CHANGE, str)) {
                        }
                        topPriortyHandle.i.b("ticket");
                        lr1 = topPriortyHandle.i;
                        topPriortyHandle$popHandle$1.L$0 = topPriortyHandle;
                        topPriortyHandle$popHandle$1.label = 7;
                        if (lr1.a(topPriortyHandle$popHandle$1) == obj2) {
                        }
                        topPriortyHandle$popHandle$1.L$0 = null;
                        topPriortyHandle$popHandle$1.label = 8;
                        obj = topPriortyHandle.m(topPriortyHandle$popHandle$1);
                        if (obj != obj2) {
                        }
                        break;
                    case 5:
                        topPriortyHandle = (TopPriortyHandle) topPriortyHandle$popHandle$1.L$0;
                        k12.b(obj);
                        str = (String) obj;
                        if (!k21.d(NO_CITY_CHANGE, str)) {
                        }
                        topPriortyHandle.i.b("ticket");
                        lr1 = topPriortyHandle.i;
                        topPriortyHandle$popHandle$1.L$0 = topPriortyHandle;
                        topPriortyHandle$popHandle$1.label = 7;
                        if (lr1.a(topPriortyHandle$popHandle$1) == obj2) {
                        }
                        topPriortyHandle$popHandle$1.L$0 = null;
                        topPriortyHandle$popHandle$1.label = 8;
                        obj = topPriortyHandle.m(topPriortyHandle$popHandle$1);
                        if (obj != obj2) {
                        }
                        break;
                    case 6:
                        topPriortyHandle = (TopPriortyHandle) topPriortyHandle$popHandle$1.L$0;
                        k12.b(obj);
                        topPriortyHandle.i.b("ticket");
                        lr1 = topPriortyHandle.i;
                        topPriortyHandle$popHandle$1.L$0 = topPriortyHandle;
                        topPriortyHandle$popHandle$1.label = 7;
                        if (lr1.a(topPriortyHandle$popHandle$1) == obj2) {
                        }
                        topPriortyHandle$popHandle$1.L$0 = null;
                        topPriortyHandle$popHandle$1.label = 8;
                        obj = topPriortyHandle.m(topPriortyHandle$popHandle$1);
                        if (obj != obj2) {
                        }
                        break;
                    case 7:
                        topPriortyHandle = (TopPriortyHandle) topPriortyHandle$popHandle$1.L$0;
                        k12.b(obj);
                        topPriortyHandle$popHandle$1.L$0 = null;
                        topPriortyHandle$popHandle$1.label = 8;
                        obj = topPriortyHandle.m(topPriortyHandle$popHandle$1);
                        if (obj != obj2) {
                        }
                        break;
                    case 8:
                        k12.b(obj);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        topPriortyHandle$popHandle$1 = new TopPriortyHandle$popHandle$1(this, continuation);
        Object obj3 = topPriortyHandle$popHandle$1.result;
        Object obj22 = kotlin.coroutines.intrinsics.b.d();
        switch (topPriortyHandle$popHandle$1.label) {
        }
    }
}
