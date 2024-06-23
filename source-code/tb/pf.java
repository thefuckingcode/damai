package tb;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.taobao.monitor.impl.data.calculator.ICalculator;
import com.taobao.monitor.procedure.ViewToken;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
public class pf implements ICalculator {
    private final View a;
    private View b;
    private View c;
    private final HashSet<Drawable> d = new HashSet<>();
    private boolean e = false;
    private boolean f = false;

    public pf(View view, View view2) {
        this.a = view;
        this.b = view2;
    }

    private float a(View view, List<zv2> list, View view2) {
        View view3;
        float f2 = 0.0f;
        if (!aw2.a(view, view2)) {
            return 0.0f;
        }
        if (view.getHeight() < nw2.screenHeight / 20) {
            return 1.0f;
        }
        if (view instanceof ViewStub) {
            return 0.0f;
        }
        try {
            if (aw2.i(view, view2)) {
                this.b = view;
                this.f = true;
                return 0.0f;
            } else if (aw2.h(view, view2)) {
                this.c = view;
                return 0.0f;
            } else {
                Object tag = view.getTag(ViewToken.APM_VIEW_TOKEN);
                if (tag instanceof String) {
                    if (ViewToken.APM_VIEW_VALID.equals(tag)) {
                        return 1.0f;
                    }
                    if (ViewToken.APM_VIEW_IGNORE.equals(tag) || ViewToken.APM_VIEW_INVALID.equals(tag)) {
                        return 0.0f;
                    }
                }
                int i = 0;
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    if (!aw2.l(viewGroup)) {
                        View[] c2 = nw2.c(viewGroup);
                        int length = c2.length;
                        int i2 = 0;
                        int i3 = 0;
                        while (i < length && (view3 = c2[i]) != null) {
                            i2++;
                            ArrayList arrayList = new ArrayList();
                            if (a(view3, arrayList, view2) > 0.8f) {
                                i3++;
                                list.add(zv2.a(view3, view2));
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    ((zv2) it.next()).c();
                                }
                            } else {
                                list.addAll(arrayList);
                            }
                            i++;
                        }
                        if (view.getHeight() < nw2.screenHeight / 8 && (((viewGroup instanceof LinearLayout) || (viewGroup instanceof RelativeLayout)) && i2 == i3 && i2 != 0)) {
                            return 1.0f;
                        }
                        float a2 = new i71(f70.a(30)).a(viewGroup, list, view2);
                        if (a2 > 0.8f) {
                            return 1.0f;
                        }
                        return a2;
                    } else if (aw2.m(viewGroup)) {
                        return 1.0f;
                    } else {
                        return 0.0f;
                    }
                } else {
                    boolean[] zArr = new boolean[1];
                    if (aw2.k(view, true, this.d, zArr)) {
                        f2 = 1.0f;
                    }
                    this.e = zArr[0];
                    return f2;
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.taobao.monitor.impl.data.calculator.ICalculator
    public ne calculate() {
        ArrayList arrayList = new ArrayList();
        float a2 = a(this.a, arrayList, this.b);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((zv2) it.next()).c();
        }
        this.d.clear();
        return new ne(pf.class, a2, this.e, this.c, this.f ? this.b : null);
    }
}
