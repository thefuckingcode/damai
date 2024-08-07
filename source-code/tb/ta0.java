package tb;

import android.content.Context;
import com.alibaba.pictures.dolores.DoloresKernel;
import com.alibaba.pictures.dolores.business.AsyncResult;
import com.alibaba.pictures.dolores.business.IDoloresRequestRouter;
import com.alibaba.pictures.dolores.expection.DoloresException;
import com.alibaba.pictures.dolores.preload.IPreloadListener;
import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.alibaba.pictures.dolores.transfer.IDataTransformerFactory;
import com.alibaba.pictures.dolores.transfer.IRemoteDataTransformer;
import com.alibaba.pictures.request.BaseRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ta0<BizResponse> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    public static final long PRELOAD_CACHE_DEFAULT_VALID_TIME = 500;
    private DoloresKernel<BizResponse> a;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        @JvmStatic
        @NotNull
        public final <BizResponseT> ta0<BizResponseT> a(@NotNull DoloresRequest<BizResponseT> doloresRequest) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "440204590")) {
                return (ta0) ipChange.ipc$dispatch("440204590", new Object[]{this, doloresRequest});
            }
            k21.i(doloresRequest, "request");
            return new ta0<>(doloresRequest, (m40) null);
        }

        @JvmStatic
        @NotNull
        public final <BizResponseT> ta0<BizResponseT> b(@NotNull BaseRequest<BizResponseT> baseRequest) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "384806892")) {
                return (ta0) ipChange.ipc$dispatch("384806892", new Object[]{this, baseRequest});
            }
            k21.i(baseRequest, "request");
            return new ta0<>((BaseRequest) baseRequest, (m40) null);
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    public /* synthetic */ ta0(DoloresRequest doloresRequest, m40 m40) {
        this(doloresRequest);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: tb.ta0 */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void e(ta0 ta0, long j, IPreloadListener iPreloadListener, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 500;
        }
        if ((i & 2) != 0) {
            iPreloadListener = null;
        }
        ta0.d(j, iPreloadListener);
    }

    private final void f(DoloresRequest<BizResponse> doloresRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1730695975")) {
            ipChange.ipc$dispatch("-1730695975", new Object[]{this, doloresRequest});
            return;
        }
        DoloresKernel<BizResponse> a2 = za0.INSTANCE.a(doloresRequest);
        this.a = a2;
        if (a2 != null) {
            if (a2 != null) {
                a2.H(doloresRequest);
            }
            IDataTransformerFactory j = ua0.Companion.g().j();
            g(j != null ? j.createDataTransformer(doloresRequest) : null);
            return;
        }
        throw new DoloresException("DoloresKernel prepare fail,mDoloresKernel = null, you need check it!!");
    }

    @JvmStatic
    @NotNull
    public static final <BizResponseT> ta0<BizResponseT> h(@NotNull BaseRequest<BizResponseT> baseRequest) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1261400012")) {
            return Companion.b(baseRequest);
        }
        return (ta0) ipChange.ipc$dispatch("-1261400012", new Object[]{baseRequest});
    }

    @NotNull
    public final AsyncResult<BizResponse> a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1461035281")) {
            return b(true);
        }
        return (AsyncResult) ipChange.ipc$dispatch("-1461035281", new Object[]{this});
    }

    @NotNull
    public final AsyncResult<BizResponse> b(boolean z) {
        AsyncResult<BizResponse> b;
        AsyncResult<BizResponse> onAsyncRequestIntercept;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1087463815")) {
            return (AsyncResult) ipChange.ipc$dispatch("1087463815", new Object[]{this, Boolean.valueOf(z)});
        }
        IDoloresRequestRouter m = ua0.Companion.g().m();
        if (m != null && (onAsyncRequestIntercept = m.onAsyncRequestIntercept(this.a, z)) != null) {
            return onAsyncRequestIntercept;
        }
        DoloresKernel<BizResponse> doloresKernel = this.a;
        return (doloresKernel == null || (b = doloresKernel.b(z)) == null) ? new AsyncResult<>() : b;
    }

    @NotNull
    public final ta0<BizResponse> c(@Nullable Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-85062542")) {
            return (ta0) ipChange.ipc$dispatch("-85062542", new Object[]{this, context});
        }
        DoloresKernel<BizResponse> doloresKernel = this.a;
        if (doloresKernel != null) {
            doloresKernel.c(context);
        }
        return this;
    }

    public final void d(long j, @Nullable IPreloadListener<BizResponse> iPreloadListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "289512477")) {
            ipChange.ipc$dispatch("289512477", new Object[]{this, Long.valueOf(j), iPreloadListener});
            return;
        }
        DoloresKernel<BizResponse> doloresKernel = this.a;
        if (doloresKernel != null) {
            doloresKernel.A(j, iPreloadListener);
        }
    }

    @NotNull
    public final ta0<BizResponse> g(@Nullable IRemoteDataTransformer<BizResponse> iRemoteDataTransformer) {
        DoloresKernel<BizResponse> doloresKernel;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-364563650")) {
            return (ta0) ipChange.ipc$dispatch("-364563650", new Object[]{this, iRemoteDataTransformer});
        }
        if (!(iRemoteDataTransformer == null || (doloresKernel = this.a) == null)) {
            doloresKernel.I(iRemoteDataTransformer);
        }
        return this;
    }

    public /* synthetic */ ta0(BaseRequest baseRequest, m40 m40) {
        this(baseRequest);
    }

    private ta0(BaseRequest<BizResponse> baseRequest) {
        f(baseRequest);
    }

    private ta0(DoloresRequest<BizResponse> doloresRequest) {
        f(doloresRequest);
    }
}
