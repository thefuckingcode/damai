package tb;

import androidx.annotation.NonNull;
import com.alibaba.android.ultron.vfw.event.ViewRenderErrorListener;
import com.alibaba.android.umbrella.trace.UmbrellaTracker;
import com.taobao.android.dinamic.exception.DinamicException;
import com.taobao.android.dinamicx.DXEngineConfig;
import com.taobao.android.dinamicx.n;
import com.taobao.android.dinamicx.notification.IDXNotificationListener;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.weex.annotation.JSMethod;
import java.util.List;

/* compiled from: Taobao */
public class k80 {
    private wv2 a = null;
    private n b = null;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements IDXNotificationListener {
        a() {
        }

        @Override // com.taobao.android.dinamicx.notification.IDXNotificationListener
        public void onNotificationListener(vy vyVar) {
            int i;
            List<w00> list = vyVar.c;
            if (list != null) {
                for (w00 w00 : list) {
                    if (w00 != null && (i = w00.c) == 1000) {
                        k80 k80 = k80.this;
                        DXTemplateItem dXTemplateItem = w00.a;
                        k80.b(dXTemplateItem != null ? dXTemplateItem.name : "", "componentRenderError", String.valueOf(i));
                    }
                }
            }
        }
    }

    private k80(wv2 wv2) {
        this.a = wv2;
        e();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b(String str, String str2, String str3) {
        tr2.b("DinamicXEngineManager", "componenet render error, name: ", str, "reason", str3);
        ViewRenderErrorListener viewRenderErrorListener = (ViewRenderErrorListener) this.a.getService(ViewRenderErrorListener.class);
        if (viewRenderErrorListener != null) {
            viewRenderErrorListener.onError(str, str2, str3);
            UmbrellaTracker.commitFailureStability(p80.KEY_FESTRUE_COMPONT, "renderError", "1.0", this.a.k(), null, null, "renderError$" + str, str2 + JSMethod.NOT_SET + str3);
        }
    }

    public static k80 c(@NonNull wv2 wv2) {
        if (wv2 != null) {
            return new k80(wv2);
        }
        throw new IllegalArgumentException("params viewEngine can not be null");
    }

    private void e() {
        if (this.b == null) {
            n nVar = new n(new DXEngineConfig.b(this.a.p()).x(false).u(1).t());
            this.b = nVar;
            nVar.l(new a());
        }
    }

    @NonNull
    public n d() {
        return this.b;
    }

    public void f(long j, com.taobao.android.dinamicx.a aVar) {
        this.b.k(j, aVar);
    }

    public void g(String str, w0 w0Var) throws DinamicException {
        this.b.s(str, w0Var);
    }
}
