package com.taobao.android.dinamic;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.taobao.android.dinamic.log.DinamicLog;
import com.taobao.android.dinamic.parser.DinamicParser;
import com.taobao.android.dinamic.tempate.DinamicTemplate;
import com.taobao.android.dinamic.view.CompatibleView;
import com.taobao.android.dinamic.view.DFrameLayout;
import com.taobao.android.dinamic.view.DLinearLayout;
import com.taobao.android.dinamic.view.DLoopLinearLayout;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import tb.c80;
import tb.ew2;
import tb.g80;
import tb.o70;
import tb.r70;
import tb.sp;
import tb.x70;
import tb.z70;

/* compiled from: Taobao */
public class DViewGenerator {
    public static final String TAG = "DViewGenerator";
    private String a = "default";

    public DViewGenerator(String str) {
        new ArrayDeque(16);
        this.a = str;
    }

    private void b(DinamicTemplate dinamicTemplate) {
        a.h().c();
    }

    private void c(DinamicTemplate dinamicTemplate) {
        a.h().c();
    }

    private ew2 e(x70 x70) {
        long nanoTime = System.nanoTime();
        ew2 e = x70.e();
        Iterator<View> it = e.a().iterator();
        while (it.hasNext()) {
            View next = it.next();
            try {
                c.a(next, x70);
            } catch (Throwable unused) {
                r70 b = e.b();
                b.a("other", next.getClass() + "bind data failed;");
            }
        }
        m(e, System.nanoTime() - nanoTime);
        return e;
    }

    private ew2 g(View view, Object obj, boolean z, Object obj2) {
        if (view == null || obj == null) {
            ew2 ew2 = new ew2(this.a);
            ew2.b().a("other", "binddata rootView or data is null");
            return ew2;
        }
        int i = c80.TAG_ROOT_VIEW_RESULT;
        ew2 ew22 = (ew2) view.getTag(i);
        if (ew22 == null) {
            View findViewWithTag = view.findViewWithTag("dinamicRootView");
            if (findViewWithTag == null) {
                ew2 ew23 = new ew2(this.a);
                ew23.b().a("other", "binddata rootView or data is null");
                return ew23;
            }
            ew22 = (ew2) findViewWithTag.getTag(i);
            if (ew22 == null) {
                ew2 ew24 = new ew2(this.a);
                ew24.b().a("other", "binddata rootView or data is null");
                return ew24;
            }
        }
        b(ew22.c());
        x70.b bVar = new x70.b();
        bVar.h(obj2);
        bVar.i(this.a);
        bVar.k(ew22);
        bVar.j(obj);
        bVar.g(obj);
        return e(bVar.f());
    }

    private void h(Context context, View view, View view2, ew2 ew2, x70 x70) {
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            View a2 = g80.a(context, childAt, ew2, x70);
            if (a2 != null) {
                ((ViewGroup) view2).addView(a2, childAt.getLayoutParams());
                if (l(childAt)) {
                    h(context, childAt, a2, ew2, x70);
                }
            }
        }
    }

    private boolean l(View view) {
        if (o70.DONOT_NEED_BIND_CHILD.equals(view.getTag()) || (view instanceof DLoopLinearLayout)) {
            return false;
        }
        if ((view instanceof DLinearLayout) || (view instanceof DFrameLayout)) {
            return true;
        }
        return false;
    }

    private void m(ew2 ew2, long j) {
        a.h().d();
    }

    private void n(ew2 ew2, long j) {
        a.h().d();
    }

    public static DViewGenerator o(String str) {
        if (TextUtils.isEmpty(str)) {
            return b.c("default").a;
        }
        return b.c(str).a;
    }

    public ew2 d(View view, Object obj, Object obj2) {
        return g(view, obj, false, obj2);
    }

    public void f(ArrayList<View> arrayList, x70 x70) {
        Iterator<View> it = arrayList.iterator();
        while (it.hasNext()) {
            View next = it.next();
            try {
                c.a(next, x70);
            } catch (Throwable unused) {
                r70 b = x70.e().b();
                b.a("other", next.getClass() + "bind data failed;");
            }
        }
    }

    public ew2 i(View view, Context context, x70 x70) {
        ew2 ew2 = new ew2(this.a);
        ew2.g(new ArrayList<>(20));
        View a2 = g80.a(context, view, ew2, x70);
        if (a2 == null) {
            ew2.i(null);
            return ew2;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            a2.setLayoutParams(layoutParams);
        }
        if (!(view instanceof ViewGroup)) {
            ew2.i(a2);
            return ew2;
        }
        h(context, view, a2, ew2, x70);
        ew2.i(a2);
        return ew2;
    }

    public ew2 j(Context context, ViewGroup viewGroup, DinamicTemplate dinamicTemplate) {
        return k(context, viewGroup, dinamicTemplate, null);
    }

    public ew2 k(Context context, ViewGroup viewGroup, DinamicTemplate dinamicTemplate, Object obj) {
        long nanoTime = System.nanoTime();
        if (context == null || dinamicTemplate == null || !dinamicTemplate.checkValid()) {
            ew2 ew2 = new ew2(this.a);
            ew2.i(null);
            ew2.h(dinamicTemplate);
            ew2.b().a(r70.ERROR_CODE_TEMPLATE_INFO_ERROR, dinamicTemplate != null ? dinamicTemplate.toString() : "context=null or exactTemplate=null");
            n(ew2, System.nanoTime() - nanoTime);
            return ew2;
        }
        c(dinamicTemplate);
        ew2 ew22 = new ew2(this.a);
        XmlPullParser a2 = DinamicParser.a(this.a, dinamicTemplate, ew22);
        long nanoTime2 = System.nanoTime();
        if (a2 != null) {
            try {
                ew22.h(dinamicTemplate);
                ew22.g(new ArrayList<>(20));
                x70.b bVar = new x70.b();
                bVar.k(ew22);
                bVar.i(this.a);
                bVar.h(obj);
                View inflate = d.b(context, bVar.f()).inflate(a2, (ViewGroup) null);
                if (inflate instanceof CompatibleView) {
                    n(ew22, System.nanoTime() - nanoTime2);
                    return ew22;
                }
                sp.c(inflate, viewGroup);
                z70 z70 = (z70) inflate.getTag(c80.PROPERTY_KEY);
                Object obj2 = z70.b.get(o70.c);
                Object obj3 = z70.b.get(o70.d);
                if (obj2 != null) {
                    dinamicTemplate.setCompilerVersion(String.valueOf(obj2));
                } else {
                    dinamicTemplate.setCompilerVersion(o70.b);
                }
                if (obj3 != null) {
                    dinamicTemplate.setInterpreterVersion(String.valueOf(obj3));
                } else {
                    dinamicTemplate.setInterpreterVersion(o70.b);
                }
                inflate.setTag("dinamicRootView");
                inflate.setTag(c80.TAG_ROOT_VIEW_RESULT, ew22);
                ew22.i(inflate);
                n(ew22, System.nanoTime() - nanoTime2);
                return ew22;
            } catch (Throwable th) {
                ew22.h(dinamicTemplate);
                ew22.b().a("other", "inflateViewFailed");
                DinamicLog.b(TAG, this.a + "infalte dinamic view failed", th);
                n(ew22, System.nanoTime() - nanoTime2);
                return ew22;
            }
        } else {
            ew22.h(dinamicTemplate);
            ew22.b().a(r70.ERROR_CODE_TEMPLATE_NOT_FOUND, dinamicTemplate.toString());
            n(ew22, System.nanoTime() - nanoTime2);
            return ew22;
        }
    }
}
