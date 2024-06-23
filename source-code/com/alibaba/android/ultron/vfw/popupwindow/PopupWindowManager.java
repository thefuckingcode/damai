package com.alibaba.android.ultron.vfw.popupwindow;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.ultron.vfw.R$id;
import com.alibaba.android.ultron.vfw.R$layout;
import com.alibaba.android.ultron.vfw.adapter.RecyclerViewAdapter;
import com.alibaba.android.ultron.vfw.viewholder.RecyclerViewHolder;
import com.taobao.android.ultron.common.model.IDMComponent;
import java.util.List;
import tb.jw2;
import tb.l20;
import tb.wv2;
import tb.yv2;

/* compiled from: Taobao */
public class PopupWindowManager {
    private static float s = 0.6f;
    private l20 a;
    private PopupWindow b;
    private wv2 c;
    private FrameLayout d;
    private LinearLayout e;
    private RecyclerView f;
    private LinearLayout g;
    private ImageView h;
    private RecyclerViewAdapter i;
    private View j;
    private AlphaAnimation k;
    private AlphaAnimation l;
    private TranslateAnimation m;
    private TranslateAnimation n;
    private RelativeLayout o;
    private OnCancelListener p;
    private PopupRecyclerViewLayoutManager q;
    private boolean r = false;

    /* compiled from: Taobao */
    public interface OnCancelListener {
        void onCancel();
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements Animation.AnimationListener {
        a() {
        }

        public void onAnimationEnd(Animation animation) {
            PopupWindowManager.this.b.dismiss();
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            PopupWindowManager.this.j.setEnabled(false);
            PopupWindowManager.this.g(false);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class c implements View.OnKeyListener {
        c() {
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && PopupWindowManager.this.b.isShowing() && !PopupWindowManager.this.l.hasStarted()) {
                PopupWindowManager.this.g(false);
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class d implements View.OnClickListener {
        d() {
        }

        public void onClick(View view) {
            PopupWindowManager.this.g(false);
        }
    }

    /* compiled from: Taobao */
    public static class e {
        public static final String KEY_BOTTOM_RADIUS = "popupWindowBottomRadius";
        public static final String KEY_TOP_RADIUS = "popupWindowTopRadius";
        private float a;
        private int b = 0;
        private int c;
        private int d = 0;
        private Drawable e;
        private float f;
        private float g;

        public void h(Drawable drawable) {
            this.e = drawable;
        }

        public void i(int i) {
            this.c = i;
        }

        public void j(@ColorInt int i) {
            this.d = i;
        }

        public void k(float f2, float f3) {
            this.f = f2;
            this.g = f3;
        }

        public void l(float f2) {
            this.a = f2;
        }
    }

    public PopupWindowManager(wv2 wv2) {
        this.c = wv2;
        i();
        f();
        h();
    }

    private void f() {
        this.j.setOnClickListener(new b());
        this.d.setOnKeyListener(new c());
    }

    private void h() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.k = alphaAnimation;
        alphaAnimation.setDuration(200);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        this.l = alphaAnimation2;
        alphaAnimation2.setDuration(200);
        this.l.setAnimationListener(new a());
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        this.m = translateAnimation;
        translateAnimation.setDuration(200);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        this.n = translateAnimation2;
        translateAnimation2.setDuration(200);
    }

    private void i() {
        this.d = new FrameLayout(this.c.l());
        View view = new View(this.c.l());
        this.j = view;
        view.setBackgroundColor(Color.parseColor("#7F000000"));
        this.d.addView(this.j);
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.c.l()).inflate(R$layout.ultron_popop_window, (ViewGroup) this.d, false);
        this.o = relativeLayout;
        relativeLayout.setClickable(true);
        this.e = (LinearLayout) this.o.findViewById(R$id.ultron_popup_header_view);
        this.f = (RecyclerView) this.o.findViewById(R$id.ultron_popup_recycler_view);
        this.g = (LinearLayout) this.o.findViewById(R$id.ultron_popup_footer_view);
        this.h = (ImageView) this.o.findViewById(R$id.ultron_popup_close_button);
        this.d.addView(this.o, new FrameLayout.LayoutParams(-1, (int) (((float) jw2.c(this.c.l())) * s), 80));
        this.d.setFocusable(true);
        this.d.setFocusableInTouchMode(true);
        this.i = new RecyclerViewAdapter(this.c);
        PopupRecyclerViewLayoutManager popupRecyclerViewLayoutManager = new PopupRecyclerViewLayoutManager(this.c.l());
        this.q = popupRecyclerViewLayoutManager;
        popupRecyclerViewLayoutManager.setOrientation(1);
        this.f.setLayoutManager(this.q);
        this.f.setAdapter(this.i);
    }

    private void k() {
        List<IDMComponent> a2 = this.a.a();
        if (a2 == null || a2.size() > 1) {
            this.q.a(true);
        } else {
            this.q.a(false);
        }
        this.i.setData(a2);
        this.i.notifyDataSetChanged();
    }

    private void l() {
        LinearLayout linearLayout = this.g;
        if (linearLayout != null) {
            if (linearLayout.getChildCount() > 0) {
                this.g.removeAllViews();
            }
            List<IDMComponent> c2 = this.a.c();
            yv2 yv2 = (yv2) this.c.getService(yv2.class);
            if (c2 != null && c2.size() > 0) {
                for (IDMComponent iDMComponent : c2) {
                    RecyclerViewHolder c3 = yv2.c(this.g, yv2.f(iDMComponent));
                    View view = c3.itemView;
                    if (view != null) {
                        this.g.addView(view);
                    }
                    yv2.b(c3, iDMComponent);
                }
            }
        }
    }

    private void m() {
        LinearLayout linearLayout = this.e;
        if (linearLayout != null) {
            if (linearLayout.getChildCount() > 0) {
                this.e.removeAllViews();
            }
            yv2 yv2 = (yv2) this.c.getService(yv2.class);
            List<IDMComponent> d2 = this.a.d();
            if (d2 != null && d2.size() > 0) {
                for (IDMComponent iDMComponent : d2) {
                    RecyclerViewHolder c2 = yv2.c(this.e, yv2.f(iDMComponent));
                    View view = c2.itemView;
                    if (view != null) {
                        this.e.addView(view);
                    }
                    yv2.b(c2, iDMComponent);
                }
            }
        }
    }

    public void g(boolean z) {
        this.r = z;
        this.j.startAnimation(this.l);
        this.o.startAnimation(this.n);
    }

    public boolean j() {
        PopupWindow popupWindow = this.b;
        return popupWindow != null && popupWindow.isShowing();
    }

    public void n() {
        this.i.notifyDataSetChanged();
    }

    public void o(l20 l20) {
        this.a = l20;
    }

    public void p(OnCancelListener onCancelListener) {
        this.p = onCancelListener;
    }

    public void q(e eVar) {
        if (this.b == null) {
            PopupWindow popupWindow = new PopupWindow(this.c.l());
            this.b = popupWindow;
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
            this.b.setWidth(-1);
            this.b.setHeight(-1);
            this.b.setSoftInputMode(16);
            this.b.setOutsideTouchable(true);
            this.b.setFocusable(true);
        }
        if (eVar != null) {
            if (eVar.b < 0) {
                this.j.setBackgroundColor(eVar.b);
            }
            if (eVar.a > 0.0f && eVar.a != s) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.o.getLayoutParams();
                layoutParams.height = (int) (((float) jw2.c(this.c.l())) * eVar.a);
                this.o.setLayoutParams(layoutParams);
            }
            if (eVar.e != null) {
                this.h.setVisibility(0);
                this.h.setContentDescription("关闭");
                this.h.setImageDrawable(eVar.e);
                this.h.setOnClickListener(new d());
            } else {
                this.h.setVisibility(8);
            }
            if (eVar.d < 0) {
                this.o.setBackgroundDrawable(jw2.b(eVar.d, eVar.f, eVar.g));
            }
        }
        this.j.setEnabled(true);
        this.b.setContentView(this.d);
        this.b.setOnDismissListener(new PopupWindow.OnDismissListener() {
            /* class com.alibaba.android.ultron.vfw.popupwindow.PopupWindowManager.AnonymousClass5 */

            public void onDismiss() {
                if (PopupWindowManager.this.p != null && !PopupWindowManager.this.r) {
                    PopupWindowManager.this.p.onCancel();
                }
            }
        });
        m();
        k();
        l();
        this.j.startAnimation(this.k);
        this.o.startAnimation(this.m);
        this.b.showAtLocation(this.d, eVar.c, 0, 0);
    }
}
