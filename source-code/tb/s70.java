package tb;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.taobao.android.dinamic.dinamic.DinamicEventHandler;
import com.taobao.android.dinamic.expressionv2.g;
import com.taobao.android.dinamic.log.DinamicLog;
import com.taobao.android.dinamic.property.DAttrConstant;
import java.util.Map;

/* compiled from: Taobao */
public class s70 {

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        final /* synthetic */ DinamicEventHandler a;
        final /* synthetic */ x70 b;
        final /* synthetic */ Object c;
        final /* synthetic */ z70 d;

        a(s70 s70, DinamicEventHandler dinamicEventHandler, x70 x70, Object obj, z70 z70) {
            this.a = dinamicEventHandler;
            this.b = x70;
            this.c = obj;
            this.d = z70;
        }

        public void onClick(View view) {
            long nanoTime = System.nanoTime();
            try {
                this.a.handleEvent(view, this.b.c(), this.c, this.b.d(), this.b.b());
                DinamicLog.g(this.b.c(), this.d.a, System.nanoTime() - nanoTime);
            } catch (Throwable th) {
                this.b.e().b().a(r70.ERROR_CODE_EVENT_HANDLER_EXCEPTION, this.d.a);
                DinamicLog.c("DinamicEventHandler", th, "handle onclick event failed, handler=", this.a.getClass().getName());
                DinamicLog.g(this.b.c(), this.d.a, System.nanoTime() - nanoTime);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements View.OnLongClickListener {
        final /* synthetic */ DinamicEventHandler a;
        final /* synthetic */ x70 b;
        final /* synthetic */ Object c;
        final /* synthetic */ z70 d;

        b(s70 s70, DinamicEventHandler dinamicEventHandler, x70 x70, Object obj, z70 z70) {
            this.a = dinamicEventHandler;
            this.b = x70;
            this.c = obj;
            this.d = z70;
        }

        public boolean onLongClick(View view) {
            long nanoTime = System.nanoTime();
            try {
                this.a.handleEvent(view, this.b.c(), this.c, this.b.d(), this.b.b());
                DinamicLog.g(this.b.c(), this.d.a, System.nanoTime() - nanoTime);
            } catch (Throwable th) {
                this.b.e().b().a(r70.ERROR_CODE_EVENT_HANDLER_EXCEPTION, this.d.a);
                DinamicLog.c("DinamicEventHandler", th, "handle onlongclick event failed, handler=", this.a.getClass().getName());
                DinamicLog.g(this.b.c(), this.d.a, System.nanoTime() - nanoTime);
            }
            return true;
        }
    }

    private void c(View view, x70 x70, z70 z70, String str, String str2) {
        Pair<String, String> b2 = h80.b(str2);
        if (b2 == null) {
            x70.e().b().a(r70.ERROR_CODE_EVENT_HANDLER_NOT_FOUND, z70.a);
            if (com.taobao.android.dinamic.b.e()) {
                DinamicLog.e(com.taobao.android.dinamic.b.TAG, String.format("事件表达式 %s=%s 解析出错", str, str2));
                return;
            }
            return;
        }
        DinamicEventHandler b3 = com.taobao.android.dinamic.b.b((String) b2.first);
        if (b3 == null) {
            x70.e().b().a(r70.ERROR_CODE_EVENT_HANDLER_NOT_FOUND, z70.a);
            if (com.taobao.android.dinamic.b.e()) {
                DinamicLog.e(com.taobao.android.dinamic.b.TAG, String.format("%s=%s，没有找到%s对应的DinamicEventHandler", str, str2, b2.first));
                return;
            }
            return;
        }
        Object a2 = u70.a((String) b2.second, z70.a, x70);
        if (TextUtils.equals(str, DAttrConstant.VIEW_EVENT_TAP)) {
            view.setOnClickListener(new a(this, b3, x70, a2, z70));
            try {
                b3.prepareBindEvent(view, a2, x70.d());
            } catch (Throwable th) {
                x70.e().b().a(r70.ERROR_CODE_EVENT_HANDLER_EXCEPTION, z70.a);
                DinamicLog.c("DinamicEventHandler", th, "handler prepareBindEvent failed, handler=", b3.getClass().getName());
            }
        } else if (TextUtils.equals(str, DAttrConstant.VIEW_EVENT_LONGTAP)) {
            view.setOnLongClickListener(new b(this, b3, x70, a2, z70));
            try {
                b3.prepareBindEvent(view, a2, x70.d());
            } catch (Throwable th2) {
                x70.e().b().a(r70.ERROR_CODE_EVENT_HANDLER_EXCEPTION, z70.a);
                DinamicLog.c("DinamicEventHandler", th2, "handler prepareBindEvent failed, handler=", b3.getClass().getName());
            }
        }
    }

    public static void d(View view, x70 x70, z70 z70, String str) {
        long nanoTime = System.nanoTime();
        try {
            x70.f(view.getTag(c80.SUBDATA));
            g.d(view, str, x70);
            DinamicLog.g(x70.c(), z70.a, System.nanoTime() - nanoTime);
        } catch (Throwable unused) {
            x70.e().b().a(r70.ERROR_CODE_EVENT_HANDLER_EXCEPTION, z70.a);
            DinamicLog.g(x70.c(), z70.a, System.nanoTime() - nanoTime);
        }
    }

    public void a(View view, x70 x70, z70 z70, String str, String str2) {
        if (TextUtils.equals(str, DAttrConstant.VIEW_EVENT_TAP)) {
            view.setOnClickListener(new t70(x70, str2, z70));
            g.f(view, str2, x70, z70);
        } else if (TextUtils.equals(str, DAttrConstant.VIEW_EVENT_LONGTAP)) {
            view.setOnLongClickListener(new t70(x70, str2, z70));
            g.f(view, str2, x70, z70);
        }
    }

    public void b(View view, x70 x70) {
        z70 z70 = (z70) view.getTag(c80.PROPERTY_KEY);
        if (z70 != null) {
            Map<String, String> map = z70.d;
            if (!map.isEmpty()) {
                for (String str : map.keySet()) {
                    String str2 = map.get(str);
                    if (str2.startsWith(o70.DINAMIC_PREFIX_AT)) {
                        a(view, x70, z70, str, str2);
                    } else {
                        c(view, x70, z70, str, str2);
                    }
                }
            }
        }
    }
}
