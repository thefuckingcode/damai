package com.alibaba.pictures.dolores;

import android.content.Context;
import android.os.SystemClock;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.alibaba.pictures.dolores.business.AsyncRequestFuture;
import com.alibaba.pictures.dolores.business.AsyncResult;
import com.alibaba.pictures.dolores.business.IRequestInterceptor;
import com.alibaba.pictures.dolores.business.Result;
import com.alibaba.pictures.dolores.config.IGlobalConfig;
import com.alibaba.pictures.dolores.convert.IJSONConverter;
import com.alibaba.pictures.dolores.lifecycle.DoloresClearStoreProvider;
import com.alibaba.pictures.dolores.lifecycle.DoloresViewModel;
import com.alibaba.pictures.dolores.login.DoloresLoginHandler;
import com.alibaba.pictures.dolores.preload.IPreloadListener;
import com.alibaba.pictures.dolores.preload.PreloadState;
import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.alibaba.pictures.dolores.response.BizResponseType;
import com.alibaba.pictures.dolores.time.TimeSyncer;
import com.alibaba.pictures.dolores.transfer.IRemoteDataTransformer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import java.io.Closeable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.b;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.util.ErrorConstant;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a02;
import tb.ah0;
import tb.bb0;
import tb.fb0;
import tb.gb0;
import tb.hs1;
import tb.is1;
import tb.je;
import tb.jl1;
import tb.k21;
import tb.m40;
import tb.ua0;
import tb.vp;
import tb.wa0;
import tb.zl2;

/* compiled from: Taobao */
public abstract class DoloresKernel<BizResponse> implements Closeable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    public static final int NODE_REQUEST_COMPLETE = 4;
    public static final int NODE_REQUEST_PREPARE = 1;
    public static final int NODE_REQUEST_REQUEST = 2;
    public static final int NODE_REQUEST_RESPONSE = 3;
    public static final int NODE_REQUEST_START = 0;
    public static final int STATE_CANCEL = 2;
    public static final int STATE_FINISH = 3;
    public static final int STATE_ING = 1;
    public static final int STATE_INIT = 0;
    public static final int STATE_RECYCLED = -1;
    @NotNull
    private static final String s;
    @NotNull
    private final Lazy a = b.b(DoloresKernel$timeMonitor$2.INSTANCE);
    @Nullable
    private Object b;
    private int c;
    @Nullable
    private Type d;
    @Nullable
    private IRequestInterceptor e;
    private boolean f;
    private DoloresClearStoreProvider g;
    @Nullable
    private a02 h;
    @Nullable
    private je i;
    @Nullable
    private Boolean j;
    @Nullable
    private Boolean k;
    @Nullable
    private Boolean l;
    @Nullable
    private String m;
    @NotNull
    private IJSONConverter n;
    @Nullable
    private String o;
    @Nullable
    private String p;
    @Nullable
    private AsyncRequestFuture<BizResponse> q;
    private boolean r;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        @NotNull
        public final String a() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "285095566")) {
                return DoloresKernel.s;
            }
            return (String) ipChange.ipc$dispatch("285095566", new Object[]{this});
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    static {
        String simpleName = DoloresKernel.class.getSimpleName();
        k21.h(simpleName, "DoloresKernel::class.java.simpleName");
        s = simpleName;
    }

    public DoloresKernel() {
        String str;
        String str2;
        String str3;
        ua0.a aVar = ua0.Companion;
        IJSONConverter c2 = aVar.c();
        this.n = c2 == null ? ah0.INSTANCE : c2;
        if (this.j == null) {
            String k2 = aVar.g().k(IGlobalConfig.Key.WUA_SWITCH, "off");
            if (k2 != null) {
                Locale locale = Locale.ROOT;
                k21.h(locale, "Locale.ROOT");
                str3 = k2.toLowerCase(locale);
                k21.h(str3, "(this as java.lang.String).toLowerCase(locale)");
            } else {
                str3 = null;
            }
            this.j = Boolean.valueOf(k21.d(str3, "on"));
        }
        if (this.k == null) {
            String k3 = aVar.g().k(IGlobalConfig.Key.IS_USE_HTTPS, "true");
            if (k3 != null) {
                Locale locale2 = Locale.ROOT;
                k21.h(locale2, "Locale.ROOT");
                str2 = k3.toLowerCase(locale2);
                k21.h(str2, "(this as java.lang.String).toLowerCase(locale)");
            } else {
                str2 = null;
            }
            this.k = Boolean.valueOf(k21.d(str2, "true"));
        }
        if (this.l == null) {
            String k4 = aVar.g().k(IGlobalConfig.Key.IS_GET, "false");
            if (k4 != null) {
                Locale locale3 = Locale.ROOT;
                k21.h(locale3, "Locale.ROOT");
                str = k4.toLowerCase(locale3);
                k21.h(str, "(this as java.lang.String).toLowerCase(locale)");
            } else {
                str = null;
            }
            this.l = Boolean.valueOf(k21.d(str, "true"));
        }
        if (this.m == null) {
            this.m = aVar.g().k(IGlobalConfig.Key.PROJECT_NAME, null);
        }
    }

    private final void L() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1309718061")) {
            ipChange.ipc$dispatch("-1309718061", new Object[]{this});
            return;
        }
        TimeSyncer.INSTANCE.j();
    }

    private final void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1015947792")) {
            ipChange.ipc$dispatch("1015947792", new Object[]{this});
            return;
        }
        try {
            C("commitLoginCancel");
            bb0.i(this.o, this.p);
        } catch (Exception e2) {
            String str = s;
            vp.c(str, "commitLoginCancel:" + e2.getMessage());
        }
    }

    private final void t(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-284144235")) {
            ipChange.ipc$dispatch("-284144235", new Object[]{this, obj});
            return;
        }
        if (this.d == null && obj != null) {
            Type genericSuperclass = obj.getClass().getGenericSuperclass();
            if (genericSuperclass instanceof ParameterizedType) {
                this.d = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("initBizClass bizTypeClass=");
        Type type = this.d;
        sb.append(type != null ? type.toString() : null);
        C(sb.toString());
    }

    public final void A(long j2, @Nullable IPreloadListener<BizResponse> iPreloadListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1996293088")) {
            ipChange.ipc$dispatch("1996293088", new Object[]{this, Long.valueOf(j2), iPreloadListener});
            return;
        }
        is1<BizResponse> b2 = hs1.INSTANCE.b(this);
        if (b2 == null) {
            vp.c(s, "preload:预加载失败，request 不满足需求！");
            if (iPreloadListener != null) {
                iPreloadListener.onFail();
                return;
            }
            return;
        }
        String str = s;
        StringBuilder sb = new StringBuilder();
        sb.append("preload:开始预加载：request:");
        DoloresRequest<BizResponse> m2 = m();
        sb.append(m2 != null ? m2.getClass().getSimpleName() : null);
        sb.append('-');
        sb.append(this);
        vp.a(str, sb.toString());
        b2.m(Long.valueOf(j2));
        b2.l(PreloadState.STATE_START);
        this.r = true;
        AsyncResult dispatchOnOri$default = AsyncResult.dispatchOnOri$default(b(false), null, 1, null);
        dispatchOnOri$default.doOnKTStart(DoloresKernel$preload$1.INSTANCE).doOnKTHitCache(new DoloresKernel$preload$2(this, b2, iPreloadListener)).doOnKTFinish(new DoloresKernel$preload$3(this, dispatchOnOri$default, b2, j2, iPreloadListener));
    }

    public final void B(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1516941311")) {
            ipChange.ipc$dispatch("1516941311", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.c = 0;
        t(m());
        if (z) {
            L();
        }
        this.c = 1;
    }

    public final void C(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2002241")) {
            ipChange.ipc$dispatch("2002241", new Object[]{this, str});
            return;
        }
        k21.i(str, "msg");
        String str2 = s;
        StringBuilder sb = new StringBuilder();
        sb.append(jl1.ARRAY_START);
        sb.append(this);
        sb.append("]@[");
        DoloresRequest<BizResponse> m2 = m();
        sb.append(m2 != null ? m2.getClass().getSimpleName() : null);
        sb.append('-');
        sb.append(this.o);
        sb.append("]:: ");
        sb.append(str);
        vp.a(str2, sb.toString());
    }

    @NotNull
    public abstract fb0<BizResponse> D(@NotNull Result<BizResponse> result);

    public void E() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "966807657")) {
            ipChange.ipc$dispatch("966807657", new Object[]{this});
            return;
        }
        C(Constants.Name.RECYCLE);
        this.c = -1;
        this.i = null;
        this.j = null;
        this.l = null;
        this.m = null;
        this.h = null;
        this.g = null;
        H(null);
        this.o = null;
        this.p = null;
        this.f = false;
        this.d = null;
        this.q = null;
        this.r = false;
    }

    public final void F(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2005750059")) {
            ipChange.ipc$dispatch("-2005750059", new Object[]{this, str});
            return;
        }
        this.o = str;
    }

    public final void G(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-122745338")) {
            ipChange.ipc$dispatch("-122745338", new Object[]{this, str});
            return;
        }
        this.p = str;
    }

    public abstract void H(@Nullable DoloresRequest<BizResponse> doloresRequest);

    public abstract void I(@Nullable IRemoteDataTransformer<BizResponse> iRemoteDataTransformer);

    public final void J(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1144347880")) {
            ipChange.ipc$dispatch("1144347880", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.f = z;
    }

    public final void K(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-641762364")) {
            ipChange.ipc$dispatch("-641762364", new Object[]{this, Boolean.valueOf(z)});
        }
    }

    @NotNull
    public final AsyncResult<BizResponse> b(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1500722870")) {
            return (AsyncResult) ipChange.ipc$dispatch("-1500722870", new Object[]{this, Boolean.valueOf(z)});
        }
        y(0);
        C("asyncRequest");
        B(z);
        AsyncResult<BizResponse> asyncResult = new AsyncResult<>();
        asyncResult.setTag(this.b);
        AsyncRequestFuture<BizResponse> asyncRequestFuture = new AsyncRequestFuture<>(asyncResult, this);
        this.q = asyncRequestFuture;
        gb0.INSTANCE.b(asyncRequestFuture);
        return asyncResult;
    }

    public final void c(@Nullable Context context) {
        wa0 doloresClearStore;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "237792058")) {
            ipChange.ipc$dispatch("237792058", new Object[]{this, context});
            return;
        }
        C("attachTo context");
        if (context instanceof ViewModelStoreOwner) {
            DoloresClearStoreProvider doloresClearStoreProvider = (DoloresClearStoreProvider) new ViewModelProvider((ViewModelStoreOwner) context).get(DoloresViewModel.class);
            this.g = doloresClearStoreProvider;
            if (doloresClearStoreProvider != null && (doloresClearStore = doloresClearStoreProvider.getDoloresClearStore()) != null) {
                doloresClearStore.a(String.valueOf(hashCode()), this);
                return;
            }
            return;
        }
        vp.d(s, "attachTo(context),context==null||context is not ViewModelStoreOwner,生命周期无绑定");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-193995612")) {
            ipChange.ipc$dispatch("-193995612", new Object[]{this});
            return;
        }
        C("页面生命周期结束 触发 close");
        d(false);
    }

    public boolean d(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2039251996")) {
            return ((Boolean) ipChange.ipc$dispatch("-2039251996", new Object[]{this, Boolean.valueOf(z)})).booleanValue();
        }
        C("cancel by user = " + z);
        this.c = 2;
        AsyncRequestFuture<BizResponse> asyncRequestFuture = this.q;
        if (asyncRequestFuture != null) {
            asyncRequestFuture.cancel(true);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final fb0<BizResponse> e(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1679081604")) {
            return (fb0) ipChange.ipc$dispatch("-1679081604", new Object[]{this, Boolean.valueOf(z)});
        }
        C("checkSessionValid[checkLocal=" + z + jl1.ARRAY_END);
        if (!this.f && (!k21.d(ua0.Companion.g().k(IGlobalConfig.Key.NEED_LOGIN_FOR_ALL_REQ, "false"), "true"))) {
            C("not needEcode && not isNeedLoginForAllRequest");
            return null;
        } else if (!z || !DoloresLoginHandler.Companion.a().c()) {
            DoloresLoginHandler.a aVar = DoloresLoginHandler.Companion;
            int b2 = aVar.a().b();
            if (b2 == 3) {
                f();
            }
            if (!this.f || aVar.a().c()) {
                return null;
            }
            C("isSessionValid = false,Session过期");
            fb0<BizResponse> fb0 = new fb0<>();
            fb0.l(new MtopResponse("FAIL_SYS_SESSION_EXPIRED", ErrorConstant.ERRMSG_FAIL_SYS_SESSION_EXPIRED));
            fb0.h((b2 == 3 ? BizResponseType.RESULT_CODE_SESSION_EXPIRED : BizResponseType.RESULT_CODE_LOGIN_CANCELED).getCode());
            fb0.j(BizResponseType.RESULT_CODE_SESSION_EXPIRED.getDesc());
            return fb0;
        } else {
            C("isSessionValid = true");
            return null;
        }
    }

    @Nullable
    public final String g() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-428206399")) {
            return this.o;
        }
        return (String) ipChange.ipc$dispatch("-428206399", new Object[]{this});
    }

    @Nullable
    public final String j() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-628635432")) {
            return this.p;
        }
        return (String) ipChange.ipc$dispatch("-628635432", new Object[]{this});
    }

    @Nullable
    public final Type k() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-681429137")) {
            return this.d;
        }
        return (Type) ipChange.ipc$dispatch("-681429137", new Object[]{this});
    }

    @Nullable
    public final je l() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1535957948")) {
            return this.i;
        }
        return (je) ipChange.ipc$dispatch("-1535957948", new Object[]{this});
    }

    @Nullable
    public abstract DoloresRequest<BizResponse> m();

    public final int n() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "515044343")) {
            return this.c;
        }
        return ((Integer) ipChange.ipc$dispatch("515044343", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String o() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "516250176")) {
            return this.m;
        }
        return (String) ipChange.ipc$dispatch("516250176", new Object[]{this});
    }

    @Nullable
    public final a02 p() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "209186938")) {
            return this.h;
        }
        return (a02) ipChange.ipc$dispatch("209186938", new Object[]{this});
    }

    @Nullable
    public final IRequestInterceptor q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1723801957")) {
            return (IRequestInterceptor) ipChange.ipc$dispatch("-1723801957", new Object[]{this});
        }
        if (this.e == null) {
            this.e = ua0.Companion.b();
        }
        return this.e;
    }

    @NotNull
    public final zl2 r() {
        Object value;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2078869332")) {
            value = ipChange.ipc$dispatch("-2078869332", new Object[]{this});
        } else {
            value = this.a.getValue();
        }
        return (zl2) value;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final Boolean s() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-950625174")) {
            return this.j;
        }
        return (Boolean) ipChange.ipc$dispatch("-950625174", new Object[]{this});
    }

    public final boolean u() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1141604625")) {
            return this.c == 2;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1141604625", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final Boolean v() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1357155951")) {
            return this.l;
        }
        return (Boolean) ipChange.ipc$dispatch("1357155951", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final Boolean w() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1508772666")) {
            return this.k;
        }
        return (Boolean) ipChange.ipc$dispatch("1508772666", new Object[]{this});
    }

    public final boolean x() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-422668223")) {
            return this.r;
        }
        return ((Boolean) ipChange.ipc$dispatch("-422668223", new Object[]{this})).booleanValue();
    }

    public final void y(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-251447159")) {
            ipChange.ipc$dispatch("-251447159", new Object[]{this, Integer.valueOf(i2)});
        } else if (i2 == 0) {
            r().e(SystemClock.elapsedRealtime());
        } else if (i2 == 1) {
            r().b(SystemClock.elapsedRealtime());
        } else if (i2 == 2) {
            r().c(SystemClock.elapsedRealtime());
        } else if (i2 == 3) {
            r().d(SystemClock.elapsedRealtime());
        } else if (i2 == 4) {
            r().a(SystemClock.elapsedRealtime());
            String str = this.o;
            if (str == null) {
                str = toString();
            }
            String str2 = this.p;
            if (str2 == null) {
                str2 = "unknown";
            }
            bb0.g(str, str2, r());
        }
    }

    public final void z() {
        wa0 doloresClearStore;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1627826775")) {
            ipChange.ipc$dispatch("1627826775", new Object[]{this});
            return;
        }
        C("onTaskFinish");
        y(4);
        DoloresClearStoreProvider doloresClearStoreProvider = this.g;
        if (!(doloresClearStoreProvider == null || (doloresClearStore = doloresClearStoreProvider.getDoloresClearStore()) == null)) {
            doloresClearStore.d(String.valueOf(hashCode()));
        }
        this.c = 3;
        m();
        E();
    }
}
