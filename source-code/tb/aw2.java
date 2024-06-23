package tb;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.PictureDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.taobao.monitor.procedure.ViewToken;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: Taobao */
public class aw2 {
    private final View a;
    private View b;
    private View c;
    private final HashSet<Drawable> d = new HashSet<>();
    private boolean e = false;

    public aw2(View view, View view2) {
        this.a = view;
        this.b = view2;
    }

    public static boolean a(View view, View view2) {
        if (nw2.d(view, view2) && view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    private void d(View view, View view2, List<zv2> list, List<zv2> list2) {
        if (a(view, view2)) {
            try {
                if (i(view, view2)) {
                    this.b = view;
                } else if (h(view, view2)) {
                    this.c = view;
                } else {
                    Object tag = view.getTag(ViewToken.APM_VIEW_TOKEN);
                    if (tag instanceof String) {
                        if (ViewToken.APM_VIEW_IGNORE.equals(tag)) {
                            return;
                        }
                        if (ViewToken.APM_VIEW_VALID.equals(tag)) {
                            o(list, zv2.b(view, view2));
                            return;
                        } else if (ViewToken.APM_VIEW_INVALID.equals(tag)) {
                            o(list2, zv2.b(view, view2));
                            return;
                        }
                    }
                    if (view instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view;
                        if (!l(viewGroup) || !m(viewGroup)) {
                            View[] c2 = nw2.c(viewGroup);
                            for (View view3 : c2) {
                                if (view3 != null) {
                                    d(view3, view2, list, list2);
                                } else {
                                    return;
                                }
                            }
                            return;
                        }
                        o(list, zv2.b(view, view2));
                        return;
                    }
                    boolean[] zArr = new boolean[1];
                    if (k(view, false, this.d, zArr)) {
                        o(list, zv2.b(view, view2));
                    }
                    this.e = zArr[0];
                }
            } catch (Exception unused) {
            }
        }
    }

    public static boolean h(View view, View view2) {
        if (!lc0.u) {
            return false;
        }
        if (Boolean.TRUE.equals(view.getTag(ViewToken.VIEW_MANUAL_CALCULATE))) {
            return nw2.e(view, view2, 0.7f);
        }
        return false;
    }

    public static boolean i(View view, View view2) {
        return Boolean.TRUE.equals(view.getTag(ViewToken.APM_PAGE_ROOT_VIEW)) && view2 != view;
    }

    public static boolean j(Drawable drawable) {
        return (drawable instanceof BitmapDrawable) || (drawable instanceof NinePatchDrawable) || (drawable instanceof AnimationDrawable) || (drawable instanceof ShapeDrawable) || (drawable instanceof PictureDrawable);
    }

    public static boolean k(View view, boolean z, HashSet<Drawable> hashSet, boolean[] zArr) {
        if (zArr == null) {
            zArr = new boolean[1];
        }
        if (view instanceof ImageView) {
            Drawable drawable = ((ImageView) view).getDrawable();
            int i = Build.VERSION.SDK_INT;
            if (i >= 23 && (drawable instanceof DrawableWrapper)) {
                drawable = ((DrawableWrapper) drawable).getDrawable();
            }
            if (!j(drawable) || hashSet.contains(drawable)) {
                Drawable background = view.getBackground();
                if (i >= 23 && !z && (background instanceof DrawableWrapper)) {
                    background = ((DrawableWrapper) background).getDrawable();
                }
                if (!j(background) || hashSet.contains(background)) {
                    return false;
                }
                hashSet.add(background);
                return true;
            }
            hashSet.add(drawable);
            return true;
        } else if (view instanceof TextView) {
            if (view instanceof EditText) {
                zArr[0] = view.isFocusable();
                return true;
            } else if (z || !(view instanceof Button)) {
                return !TextUtils.isEmpty(((TextView) view).getText().toString());
            } else {
                return true;
            }
        } else if (z || !"com.taobao.android.dinamicx.view.DXNativeFastText".equals(view.getClass().getName())) {
            return z;
        } else {
            return true;
        }
    }

    public static boolean l(ViewGroup viewGroup) {
        return (viewGroup instanceof WebView) || hz2.INSTANCE.isWebView(viewGroup);
    }

    public static boolean m(ViewGroup viewGroup) {
        if (!(viewGroup instanceof WebView)) {
            hz2 hz2 = hz2.INSTANCE;
            if (!hz2.isWebView(viewGroup) || hz2.webViewProgress(viewGroup) != 100) {
                return false;
            }
            return true;
        } else if (k50.INSTANCE.webViewProgress((WebView) viewGroup) == 100) {
            return true;
        } else {
            return false;
        }
    }

    private void o(List<zv2> list, zv2 zv2) {
        if (list != null) {
            list.add(zv2);
        }
    }

    public void b(List<zv2> list, List<zv2> list2) {
        this.d.clear();
        this.e = false;
        d(this.a, this.b, list, list2);
    }

    public List<zv2> c() {
        this.d.clear();
        this.e = false;
        ArrayList arrayList = new ArrayList();
        d(this.a, this.b, arrayList, null);
        return arrayList;
    }

    public View e() {
        return this.c;
    }

    public View f() {
        return this.b;
    }

    public boolean g() {
        return this.e;
    }

    public void n() {
        this.d.clear();
    }
}
