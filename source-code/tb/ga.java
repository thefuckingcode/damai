package tb;

import android.app.Activity;
import com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager;
import com.alibaba.yymidservice.popup.request.PopupListener;
import com.alibaba.yymidservice.popup.request.PopupRequest;
import com.alibaba.yymidservice.popup.request.bean.PopupResponseBean;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.kr1;

/* compiled from: Taobao */
public abstract class ga {
    @Nullable
    private WeakReference<Activity> a;
    @Nullable
    private PopupPriorityManager b;

    /* compiled from: Taobao */
    public static final class a implements PopupListener {
        final /* synthetic */ ga a;

        a(ga gaVar) {
            this.a = gaVar;
        }

        @Override // com.alibaba.yymidservice.popup.request.PopupListener
        public void clickUpReport() {
        }

        @Override // com.alibaba.yymidservice.popup.request.PopupListener
        public void onFail(@Nullable String str, @Nullable String str2) {
            PopupPriorityManager b = this.a.b();
            if (b != null) {
                b.k(null);
            }
        }

        @Override // com.alibaba.yymidservice.popup.request.PopupListener
        public void onSuccess(@NotNull PopupResponseBean popupResponseBean) {
            k21.i(popupResponseBean, "bean");
            PopupPriorityManager b = this.a.b();
            if (b != null) {
                b.k(popupResponseBean);
            }
        }
    }

    @Nullable
    public Activity a() {
        return (Activity) or1.b(this.a);
    }

    @Nullable
    public final PopupPriorityManager b() {
        return this.b;
    }

    public final void c(@Nullable WeakReference<Activity> weakReference) {
        this.a = weakReference;
    }

    public final void d(@Nullable PopupPriorityManager popupPriorityManager) {
        this.b = popupPriorityManager;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    public final void e() {
        ur2 ur2;
        Activity a2 = a();
        if (a2 != null) {
            kr1.a aVar = kr1.Companion;
            boolean m = aVar.a().m(a2);
            PopupResponseBean d = aVar.a().d(a2);
            HashMap hashMap = new HashMap();
            hashMap.put("isShowCache", m ? "true" : "false");
            if (d != null) {
                hashMap.put("data", bh0.INSTANCE.e(d));
            }
            String simpleName = a2.getClass().getSimpleName();
            k21.h(simpleName, "it::class.java.simpleName");
            or1.g(simpleName, AgooConstants.MESSAGE_POPUP, "tryPopupRequest", hashMap);
            if (m) {
                PopupPriorityManager b2 = b();
                if (b2 != null) {
                    b2.k(d);
                    ur2 = ur2.INSTANCE;
                }
            } else {
                PopupRequest popupRequest = PopupRequest.INSTANCE;
                String e = aVar.a().e();
                String simpleName2 = a2.getClass().getSimpleName();
                k21.h(simpleName2, "it::class.java.simpleName");
                popupRequest.b(a2, e, simpleName2, "", null, new a(this));
                ur2 = ur2.INSTANCE;
            }
            if (ur2 != null) {
                or1.g("mCurrentActivity_null", AgooConstants.MESSAGE_POPUP, "tryPopupRequest", null);
                return;
            }
            return;
        }
        ur2 = null;
        if (ur2 != null) {
        }
    }
}
