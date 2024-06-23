package tb;

import com.alibaba.pictures.dolores.DoloresKernel;
import com.alibaba.pictures.dolores.business.AsyncResult;
import com.alibaba.pictures.dolores.preload.IPreloadRequest;
import com.alibaba.pictures.dolores.preload.PreloadState;
import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class hs1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final hs1 INSTANCE = new hs1();
    public static final int PRELOAD_CAPACITY = 50;
    @NotNull
    public static final String TAG = "PreloadManager";
    @NotNull
    private static Map<String, is1<?>> a = new LinkedHashMap();

    private hs1() {
    }

    private final <BizResponse> boolean a(DoloresRequest<BizResponse> doloresRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1285339258")) {
            return ((Boolean) ipChange.ipc$dispatch("1285339258", new Object[]{this, doloresRequest})).booleanValue();
        } else if (doloresRequest == null) {
            vp.c(TAG, "preload:checkRequestValid:[false],request == null");
            return false;
        } else if (!(doloresRequest instanceof IPreloadRequest)) {
            vp.c(TAG, "preload:checkRequestValid:[false],request !is IPreloadRequest" + doloresRequest.getClass().getName());
            return false;
        } else {
            String preLoadCacheKey = ((IPreloadRequest) doloresRequest).preLoadCacheKey();
            if (!(preLoadCacheKey == null || preLoadCacheKey.length() == 0)) {
                return true;
            }
            vp.c(TAG, "preload:checkRequestValid:[false],request.preLoadCacheKey().isNullOrEmpty()");
            return false;
        }
    }

    @Nullable
    public final <BizResponse> is1<BizResponse> b(@Nullable DoloresKernel<BizResponse> doloresKernel) {
        String preLoadCacheKey;
        DoloresKernel f;
        Map.Entry<String, is1<?>> next;
        DoloresRequest<BizResponse> m;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-515656342")) {
            return (is1) ipChange.ipc$dispatch("-515656342", new Object[]{this, doloresKernel});
        }
        String str = null;
        if (!a(doloresKernel != null ? doloresKernel.m() : null)) {
            StringBuilder sb = new StringBuilder();
            sb.append("preload:markPreload:当前request不满足要求，，不执行预加载！");
            sb.append((doloresKernel == null || (m = doloresKernel.m()) == null) ? null : m.getClass().getSimpleName());
            vp.c(TAG, sb.toString());
            return null;
        }
        DoloresRequest<BizResponse> m2 = doloresKernel != null ? doloresKernel.m() : null;
        if (!(m2 instanceof IPreloadRequest)) {
            m2 = null;
        }
        IPreloadRequest iPreloadRequest = (IPreloadRequest) m2;
        if (iPreloadRequest == null || (preLoadCacheKey = iPreloadRequest.preLoadCacheKey()) == null) {
            return null;
        }
        is1<BizResponse> is1 = new is1<>(doloresKernel);
        a.put(preLoadCacheKey, is1);
        try {
            if (a.size() > 50) {
                Iterator<Map.Entry<String, is1<?>>> it = a.entrySet().iterator();
                String key = (!it.hasNext() || (next = it.next()) == null) ? null : next.getKey();
                Map<String, is1<?>> map = a;
                if (map != null) {
                    is1 is12 = (is1) po2.c(map).remove(key);
                    if (!(is12 == null || (f = is12.f()) == null)) {
                        if (!(f.n() == 3 || f.n() == 2)) {
                            z = true;
                        }
                        if (!z) {
                            f = null;
                        }
                        if (f != null) {
                            f.d(true);
                        }
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
                }
            }
        } catch (Exception e) {
            vp.c(TAG, "preload:限制预加载数量50，处理移除时报错：" + e);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("preload:当前request");
        DoloresRequest<BizResponse> m3 = doloresKernel.m();
        if (m3 != null) {
            str = m3.getClass().getSimpleName();
        }
        sb2.append(str);
        sb2.append("支持预加载！cachekey满足，记录完成");
        vp.a(TAG, sb2.toString());
        return is1;
    }

    @Nullable
    public final <BizResponse> is1<BizResponse> c(@Nullable DoloresRequest<BizResponse> doloresRequest) {
        String preLoadCacheKey;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1642580474")) {
            return (is1) ipChange.ipc$dispatch("1642580474", new Object[]{this, doloresRequest});
        }
        IPreloadRequest iPreloadRequest = (IPreloadRequest) (!(doloresRequest instanceof IPreloadRequest) ? null : doloresRequest);
        if (!(iPreloadRequest == null || (preLoadCacheKey = iPreloadRequest.preLoadCacheKey()) == null)) {
            is1<BizResponse> is1 = (is1<BizResponse>) a.remove(preLoadCacheKey);
            if (is1 == null) {
                try {
                    vp.c(TAG, "preload:obtainAndRemove=null " + doloresRequest.getClass().getSimpleName());
                } catch (Exception unused) {
                    vp.c(TAG, "preload:强转失败，请检查");
                }
            }
            if (!(is1 instanceof is1)) {
                return null;
            }
            return is1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("preload:obtainAndRemove:检查request:");
        sb.append(doloresRequest != null ? doloresRequest.getClass().getSimpleName() : null);
        sb.append(" 是否实现IPreloadRequest接口，且preLoadCacheKey()返回值非空");
        vp.c(TAG, sb.toString());
        return null;
    }

    public final <BizResponse> void d(@Nullable DoloresRequest<BizResponse> doloresRequest) {
        String preLoadCacheKey;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1776889749")) {
            ipChange.ipc$dispatch("1776889749", new Object[]{this, doloresRequest});
            return;
        }
        if (!(doloresRequest instanceof IPreloadRequest)) {
            doloresRequest = null;
        }
        IPreloadRequest iPreloadRequest = (IPreloadRequest) doloresRequest;
        if (iPreloadRequest != null && (preLoadCacheKey = iPreloadRequest.preLoadCacheKey()) != null) {
            try {
                a.remove(preLoadCacheKey);
            } catch (Exception e) {
                vp.c(TAG, "preload: remove " + e);
                ur2 ur2 = ur2.INSTANCE;
            }
        }
    }

    @NotNull
    public final <BizResponse> gs1<BizResponse> e(@Nullable AsyncResult<BizResponse> asyncResult, @Nullable DoloresKernel<BizResponse> doloresKernel) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1751713532")) {
            return (gs1) ipChange.ipc$dispatch("-1751713532", new Object[]{this, asyncResult, doloresKernel});
        }
        gs1<BizResponse> gs1 = new gs1<>();
        Boolean bool = Boolean.FALSE;
        gs1.c(bool);
        if (doloresKernel != null && asyncResult != null && a(doloresKernel.m()) && !doloresKernel.x()) {
            StringBuilder sb = new StringBuilder();
            sb.append("preload:handlePreloadData，----尝试读取预加载数据:");
            DoloresRequest<BizResponse> m = doloresKernel.m();
            String str = null;
            sb.append(m != null ? m.getClass().getSimpleName() : null);
            vp.a(TAG, sb.toString());
            is1<BizResponse> c = INSTANCE.c(doloresKernel.m());
            if (c != null) {
                if (c.h() == PreloadState.STATE_START || c.h() == PreloadState.STATE_HIT_CACHE) {
                    vp.a(TAG, "preload:handlePreloadData，----尝试读取预加载数据，预加载已经开始没有返回，记录本次回调-return");
                    c.a(doloresKernel, asyncResult);
                    if (c.h() == PreloadState.STATE_HIT_CACHE) {
                        asyncResult.onHitCache(true, c.d());
                    }
                    gs1.c(Boolean.TRUE);
                } else if (c.h() == PreloadState.STATE_FINISH) {
                    if (c.e() > System.currentTimeMillis()) {
                        z = true;
                    }
                    if (c.g() == null || !z) {
                        vp.a(TAG, "preload:handlePreloadData: 预加载已完成，但结果无效（超出有效期或者为null）！");
                    } else {
                        vp.a(TAG, "preload:handlePreloadData，----预加载已经完成且有效，直接使用返回值");
                        gs1.d(c.g());
                    }
                    gs1.c(bool);
                } else {
                    gs1.c(bool);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("preload:handlePreloadData: processRealRequest[");
                    DoloresRequest<BizResponse> m2 = doloresKernel.m();
                    if (m2 != null) {
                        str = m2.getClass().getSimpleName();
                    }
                    sb2.append(str);
                    sb2.append("]: 无预加载！state=");
                    sb2.append(c.h());
                    vp.a(TAG, sb2.toString());
                }
            }
        }
        return gs1;
    }
}
