package com.alibaba.gaiax.render.view;

import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.render.view.basic.GXIImageView;
import com.alibaba.gaiax.render.view.basic.GXIconFont;
import com.alibaba.gaiax.render.view.basic.GXShadowLayout;
import com.alibaba.gaiax.render.view.basic.GXText;
import com.alibaba.gaiax.render.view.basic.GXView;
import com.alibaba.gaiax.render.view.container.GXContainer;
import com.alibaba.gaiax.render.view.container.GXContainerViewAdapter;
import com.alibaba.gaiax.render.view.container.slider.GXSliderView;
import com.alibaba.gaiax.template.GXStyleConvert;
import com.taobao.weex.common.Constants;
import com.youku.arch.v3.core.Constants;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.cr0;
import tb.fp0;
import tb.ip0;
import tb.jq0;
import tb.k21;
import tb.ko0;
import tb.kp0;
import tb.lo0;
import tb.nq0;
import tb.ox1;
import tb.r61;
import tb.uq0;
import tb.ur2;
import tb.wq0;

/* compiled from: Taobao */
public final class GXViewExtKt {
    public static final void A(@NotNull View view) {
        k21.i(view, "<this>");
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                int itemCount = adapter == null ? 1 : adapter.getItemCount();
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
                int spanCount = ((GridLayoutManager) layoutManager).getSpanCount();
                RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
                Objects.requireNonNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
                ((GridLayoutManager) layoutManager2).setSpanSizeLookup(new GXViewExtKt$setSpanSizeLookup$1(itemCount, spanCount));
            }
        }
    }

    public static final void B(@NotNull GXText gXText, int i) {
        k21.i(gXText, "<this>");
        gXText.setGravity(i);
    }

    public static final void C(@NotNull GXText gXText, @Nullable Typeface typeface) {
        k21.i(gXText, "<this>");
        gXText.setTypeface(typeface);
    }

    public static final void D(@NotNull GXText gXText, float f) {
        k21.i(gXText, "<this>");
        int fontMetricsInt = gXText.getPaint().getFontMetricsInt(null);
        if (((int) f) != fontMetricsInt) {
            gXText.setLineSpacing(f - ((float) fontMetricsInt), 1.0f);
        }
    }

    public static final void E(@NotNull View view, int i) {
        k21.i(view, "<this>");
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getItemDecorationCount() <= 0) {
                recyclerView.addItemDecoration(new GXViewExtKt$setVerticalScrollContainerLineSpacing$decoration$1(i));
            }
        }
    }

    private static final boolean b(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        if (childCount >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (viewGroup.getChildAt(i) instanceof GXShadowLayout) {
                    return true;
                }
                if (i == childCount) {
                    break;
                }
                i = i2;
            }
        }
        return false;
    }

    private static final void c(View view, boolean z) {
        ViewParent parent = view.getParent();
        if (parent != null) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).setClipChildren(z);
            }
            if ((parent instanceof View) && !(parent instanceof RecyclerView)) {
                c((View) parent, z);
            }
        }
    }

    public static final void d(@NotNull View view, @Nullable uq0 uq0) {
        jq0 e;
        ko0 ko0;
        k21.i(view, "<this>");
        float[] fArr = null;
        if ((uq0 == null ? null : uq0.c()) == null) {
            if (uq0 == null) {
                ko0 = null;
            } else {
                ko0 = uq0.b();
            }
            if (ko0 != null) {
                view.setBackground(new lo0(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{uq0.b().b(view.getContext()), uq0.b().b(view.getContext())}));
            } else {
                view.getBackground();
                view.setBackground(null);
            }
        } else if (!(view instanceof GXText)) {
            view.setBackground(uq0.c().a());
        }
        if ((view.getBackground() instanceof lo0) || (view.getBackground() instanceof kp0)) {
            Drawable background = view.getBackground();
            Objects.requireNonNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            GradientDrawable gradientDrawable = (GradientDrawable) background;
            if (!(uq0 == null || (e = uq0.e()) == null)) {
                fArr = e.e();
            }
            gradientDrawable.setCornerRadii(fArr);
        }
    }

    public static final void e(@NotNull View view, @Nullable Integer num) {
        k21.i(view, "<this>");
        if (num != null) {
            view.setVisibility(num.intValue());
        }
    }

    public static final void f(@NotNull GXText gXText, @Nullable ip0 ip0) {
        k21.i(gXText, "<this>");
        if (ip0 != null) {
            gXText.setTextColor(-16777216);
            gXText.getPaint().setShader(ip0.b(gXText));
        }
    }

    public static final void g(@NotNull GXText gXText, @NotNull uq0 uq0) {
        k21.i(gXText, "<this>");
        k21.i(uq0, "style");
        if (uq0.j() != null) {
            gXText.setTextColor(uq0.j().b(gXText.getContext()));
        } else {
            gXText.setTextColor(-16777216);
        }
    }

    public static final void h(@NotNull GXText gXText, @NotNull uq0 uq0) {
        k21.i(gXText, "<this>");
        k21.i(uq0, "style");
        if (uq0.k() != null) {
            gXText.setTypeface(uq0.k());
        } else if (uq0.r() != null) {
            gXText.setTypeface(uq0.r());
        } else {
            gXText.setTypeface(null);
        }
        if ((gXText instanceof GXIconFont) && uq0.k() == null) {
            GXRegisterCenter.GXIExtensionCompatibility d = GXRegisterCenter.Companion.a().d();
            boolean z = false;
            if (d != null && d.isPreventIconFontTypefaceThrowException()) {
                z = true;
            }
            if (z) {
                ((GXIconFont) gXText).setTypeface(GXStyleConvert.Companion.a().o("iconfont"));
                return;
            }
            throw new IllegalArgumentException("GXIconFont view must have font family property");
        }
    }

    public static final void i(@NotNull GXText gXText, @Nullable Integer num) {
        k21.i(gXText, "<this>");
        if (num == null || num.intValue() == 1) {
            gXText.setSingleLine(true);
        } else if (num.intValue() == 0) {
            gXText.setMaxLines(Integer.MAX_VALUE);
        } else {
            gXText.setMaxLines(num.intValue());
        }
    }

    public static final void j(@NotNull GXText gXText, @Nullable ox1<nq0> ox1) {
        int i;
        int i2;
        nq0 a;
        nq0 b;
        nq0 d;
        nq0 c;
        k21.i(gXText, "<this>");
        int i3 = 0;
        int d2 = (ox1 == null || (c = ox1.c()) == null) ? 0 : c.d();
        if (ox1 == null || (d = ox1.d()) == null) {
            i = 0;
        } else {
            i = d.d();
        }
        if (ox1 == null || (b = ox1.b()) == null) {
            i2 = 0;
        } else {
            i2 = b.d();
        }
        if (!(ox1 == null || (a = ox1.a()) == null)) {
            i3 = a.d();
        }
        gXText.setPadding(d2, i, i2, i3);
    }

    public static final void k(@NotNull GXText gXText, @Nullable Float f) {
        k21.i(gXText, "<this>");
        if (f != null && f.floatValue() >= 0.0f) {
            gXText.setTextSize(0, f.floatValue());
        }
    }

    public static final void l(@NotNull GXText gXText, @NotNull uq0 uq0) {
        k21.i(gXText, "<this>");
        k21.i(uq0, "style");
        if (uq0.o() != null) {
            B(gXText, uq0.o().intValue() | 16);
        } else {
            B(gXText, 19);
        }
    }

    public static final void m(@NotNull GXText gXText, @Nullable Integer num) {
        k21.i(gXText, "<this>");
        if (num != null) {
            gXText.getPaint().setFlags(num.intValue());
        }
    }

    public static final void n(@NotNull GXText gXText, @NotNull uq0 uq0) {
        k21.i(gXText, "<this>");
        k21.i(uq0, "style");
        if (uq0.l() != null) {
            float c = uq0.l().c();
            GXRegisterCenter.GXIExtensionDynamicProperty h = GXRegisterCenter.Companion.a().h();
            if (h != null) {
                GXRegisterCenter.GXIExtensionDynamicProperty.a aVar = new GXRegisterCenter.GXIExtensionDynamicProperty.a("line-height", Float.valueOf(c));
                aVar.e(uq0);
                ur2 ur2 = ur2.INSTANCE;
                Object convert = h.convert(aVar);
                if (convert != null) {
                    D(gXText, ((Float) convert).floatValue());
                    return;
                }
            }
            D(gXText, c);
        }
    }

    public static final void o(@NotNull GXText gXText, @NotNull uq0 uq0) {
        k21.i(gXText, "<this>");
        k21.i(uq0, "style");
        if (uq0.q() == null) {
            gXText.setEllipsize(null);
        } else {
            gXText.setEllipsize(uq0.q());
        }
    }

    public static final void p(@NotNull View view, @NotNull wq0 wq0, @NotNull fp0 fp0, @Nullable r61 r61) {
        boolean z;
        k21.i(view, "<this>");
        k21.i(wq0, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(fp0, Constants.CONFIG);
        int d = fp0.d();
        int a = fp0.a(wq0);
        boolean h = fp0.h();
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            GXContainerViewAdapter gXContainerViewAdapter = adapter instanceof GXContainerViewAdapter ? (GXContainerViewAdapter) adapter : null;
            if (gXContainerViewAdapter == null) {
                z = false;
            } else {
                z = gXContainerViewAdapter.n(r61 == null ? 0.0f : r61.e());
            }
            if (recyclerView.getLayoutManager() == null || z) {
                recyclerView.setLayoutManager(null);
                recyclerView.setLayoutManager(new GXViewExtKt$setGridContainerDirection$target$1(d, h, a, recyclerView.getContext()));
                return;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
            ((GridLayoutManager) layoutManager).setSpanCount(a);
        }
    }

    public static final void q(@NotNull View view, @NotNull Rect rect, int i, int i2) {
        k21.i(view, "<this>");
        k21.i(rect, Constants.Name.PADDING);
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getItemDecorationCount() > 0) {
                recyclerView.removeItemDecorationAt(0);
            }
            recyclerView.addItemDecoration(new GXViewExtKt$setGridContainerItemSpacingAndRowSpacing$decoration$1(rect, i, i2));
        }
    }

    public static final void r(@NotNull View view, @Nullable Integer num, @Nullable Integer num2) {
        k21.i(view, "<this>");
        if (num != null) {
            if (num.intValue() == 0 && num2 != null && num2.intValue() == 4) {
                view.setVisibility(num2.intValue());
            } else if (num.intValue() == 0 && num2 != null && num2.intValue() == 0) {
                view.setVisibility(num2.intValue());
            } else {
                view.setVisibility(num.intValue());
            }
        } else if (num2 != null) {
            view.setVisibility(num2.intValue());
        }
    }

    public static final void s(@NotNull View view, int i) {
        k21.i(view, "<this>");
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getItemDecorationCount() <= 0) {
                recyclerView.addItemDecoration(new GXViewExtKt$setHorizontalScrollContainerLineSpacing$decoration$1(i));
            }
        }
    }

    public static final void t(@NotNull View view, int i, int i2, int i3) {
        k21.i(view, "<this>");
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getItemDecorationCount() <= 0) {
                recyclerView.addItemDecoration(new GXViewExtKt$setHorizontalScrollContainerLineSpacing$decoration$2(i, i3, i2));
            }
        }
    }

    public static final void u(@NotNull View view, @Nullable Float f) {
        k21.i(view, "<this>");
        if (f != null) {
            f.floatValue();
            view.setAlpha(f.floatValue());
        }
    }

    public static final void v(@NotNull View view, @Nullable Boolean bool) {
        k21.i(view, "<this>");
        boolean booleanValue = bool == null ? true : bool.booleanValue();
        if (!(view instanceof ViewGroup)) {
            return;
        }
        if (!booleanValue) {
            ((ViewGroup) view).setClipChildren(false);
            view.post(new cr0(view, booleanValue));
            return;
        }
        ((ViewGroup) view).setClipChildren(booleanValue);
    }

    /* access modifiers changed from: private */
    public static final void w(View view, boolean z) {
        k21.i(view, "$view");
        ViewGroup viewGroup = (ViewGroup) view;
        ViewParent parent = viewGroup.getParent();
        ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup2 != null) {
            viewGroup2.setClipChildren(z);
        }
        if ((view instanceof GXIRootView) && b(viewGroup)) {
            c(view, z);
        }
    }

    public static final void x(@NotNull View view, @Nullable uq0 uq0) {
        Float f;
        Integer num;
        jq0 e;
        ko0 d;
        nq0 f2;
        jq0 e2;
        k21.i(view, "<this>");
        float[] fArr = null;
        float[] e3 = (uq0 == null || (e2 = uq0.e()) == null) ? null : e2.e();
        if (uq0 == null || (f2 = uq0.f()) == null) {
            f = null;
        } else {
            f = Float.valueOf(f2.c());
        }
        if (uq0 == null || (d = uq0.d()) == null) {
            num = null;
        } else {
            num = Integer.valueOf(d.b(view.getContext()));
        }
        if (!(uq0 == null || (e = uq0.e()) == null)) {
            fArr = e.e();
        }
        if (view instanceof GXIRoundCorner) {
            int i = 0;
            if (view instanceof GXView) {
                if (fArr != null) {
                    ((GXIRoundCorner) view).setRoundCornerRadius(fArr);
                }
                if (num != null && f != null) {
                    GXIRoundCorner gXIRoundCorner = (GXIRoundCorner) view;
                    int intValue = num.intValue();
                    float floatValue = f.floatValue();
                    if (e3 == null) {
                        e3 = new float[8];
                        while (i < 8) {
                            e3[i] = 0.0f;
                            i++;
                        }
                    }
                    gXIRoundCorner.setRoundCornerBorder(intValue, floatValue, e3);
                }
            } else if (view instanceof GXText) {
                if (fArr != null) {
                    ((GXIRoundCorner) view).setRoundCornerRadius(fArr);
                }
                if (num != null && f != null) {
                    GXIRoundCorner gXIRoundCorner2 = (GXIRoundCorner) view;
                    int intValue2 = num.intValue();
                    float floatValue2 = f.floatValue();
                    if (e3 == null) {
                        e3 = new float[8];
                        while (i < 8) {
                            e3[i] = 0.0f;
                            i++;
                        }
                    }
                    gXIRoundCorner2.setRoundCornerBorder(intValue2, floatValue2, e3);
                }
            } else if (view instanceof GXIImageView) {
                if (fArr != null) {
                    ((GXIRoundCorner) view).setRoundCornerRadius(fArr);
                }
                if (num != null && f != null) {
                    GXIRoundCorner gXIRoundCorner3 = (GXIRoundCorner) view;
                    int intValue3 = num.intValue();
                    float floatValue3 = f.floatValue();
                    if (e3 == null) {
                        e3 = new float[8];
                        while (i < 8) {
                            e3[i] = 0.0f;
                            i++;
                        }
                    }
                    gXIRoundCorner3.setRoundCornerBorder(intValue3, floatValue3, e3);
                }
            } else if (view instanceof GXContainer) {
                if (fArr != null) {
                    ((GXIRoundCorner) view).setRoundCornerRadius(fArr);
                }
                if (num != null && f != null) {
                    GXIRoundCorner gXIRoundCorner4 = (GXIRoundCorner) view;
                    int intValue4 = num.intValue();
                    float floatValue4 = f.floatValue();
                    if (e3 == null) {
                        e3 = new float[8];
                        while (i < 8) {
                            e3[i] = 0.0f;
                            i++;
                        }
                    }
                    gXIRoundCorner4.setRoundCornerBorder(intValue4, floatValue4, e3);
                }
            } else if (view instanceof GXSliderView) {
                if (fArr != null) {
                    ((GXIRoundCorner) view).setRoundCornerRadius(fArr);
                }
                if (num != null && f != null) {
                    GXIRoundCorner gXIRoundCorner5 = (GXIRoundCorner) view;
                    int intValue5 = num.intValue();
                    float floatValue5 = f.floatValue();
                    if (e3 == null) {
                        e3 = new float[8];
                        while (i < 8) {
                            e3[i] = 0.0f;
                            i++;
                        }
                    }
                    gXIRoundCorner5.setRoundCornerBorder(intValue5, floatValue5, e3);
                }
            }
        }
    }

    public static final void y(@NotNull View view, int i, @Nullable r61 r61) {
        boolean z;
        k21.i(view, "<this>");
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            GXContainerViewAdapter gXContainerViewAdapter = adapter instanceof GXContainerViewAdapter ? (GXContainerViewAdapter) adapter : null;
            if (gXContainerViewAdapter == null) {
                z = false;
            } else {
                z = gXContainerViewAdapter.n(r61 == null ? 0.0f : r61.e());
            }
            if (recyclerView.getLayoutManager() == null || z) {
                recyclerView.setLayoutManager(null);
                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), i, false));
            }
        }
    }

    public static final void z(@NotNull View view, @NotNull Rect rect) {
        k21.i(view, "<this>");
        k21.i(rect, Constants.Name.PADDING);
        if (view instanceof RecyclerView) {
            view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        }
    }
}
