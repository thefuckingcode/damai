package com.alibaba.poplayerconsole.lib;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.alibaba.poplayerconsole.R$drawable;
import com.alibaba.poplayerconsole.R$id;
import com.alibaba.poplayerconsole.R$layout;
import com.alibaba.poplayerconsole.lib.StandOutWindow;
import java.util.LinkedList;
import tb.an2;
import tb.gu2;
import tb.vd2;

@SuppressLint({"ClickableViewAccessibility"})
/* compiled from: Taobao */
public class Window extends FrameLayout {
    static final String TAG = "Window";
    public static final int VISIBILITY_GONE = 0;
    public static final int VISIBILITY_TRANSITION = 2;
    public static final int VISIBILITY_VISIBLE = 1;
    public Class<? extends StandOutWindow> cls;
    public Bundle data;
    int displayHeight;
    int displayWidth;
    public int flags;
    public boolean focused;
    public int id;
    private final StandOutWindow mContext;
    private LayoutInflater mLayoutInflater;
    public StandOutWindow.StandOutLayoutParams originalParams;
    public an2 touchInfo;
    public int visibility;

    /* compiled from: Taobao */
    class a implements View.OnTouchListener {
        final /* synthetic */ StandOutWindow a;
        final /* synthetic */ int b;

        a(StandOutWindow standOutWindow, int i) {
            this.a = standOutWindow;
            this.b = i;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.a.z(this.b, Window.this, view, motionEvent);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        final /* synthetic */ TextView a;

        b(TextView textView) {
            this.a = textView;
        }

        public void onClick(View view) {
            PopupWindow i = Window.this.mContext.i(Window.this.id);
            if (i != null) {
                i.showAsDropDown(this.a);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View view) {
            Window.this.mContext.s(Window.this.id);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class d implements View.OnClickListener {
        d() {
        }

        public void onClick(View view) {
            StandOutWindow.StandOutLayoutParams layoutParams = Window.this.getLayoutParams();
            if (Window.this.data.getBoolean("isMaximized")) {
                int i = ((WindowManager.LayoutParams) layoutParams).width;
                Window window = Window.this;
                if (i == window.displayWidth && ((WindowManager.LayoutParams) layoutParams).height == window.displayHeight && ((WindowManager.LayoutParams) layoutParams).x == 0 && ((WindowManager.LayoutParams) layoutParams).y == 0) {
                    window.data.putBoolean("isMaximized", false);
                    int i2 = Window.this.data.getInt("widthBeforeMaximize", -1);
                    int i3 = Window.this.data.getInt("heightBeforeMaximize", -1);
                    Window.this.edit().f(i2, i3).c(Window.this.data.getInt("xBeforeMaximize", -1), Window.this.data.getInt("yBeforeMaximize", -1)).a();
                    return;
                }
            }
            Window.this.data.putBoolean("isMaximized", true);
            Window.this.data.putInt("widthBeforeMaximize", ((WindowManager.LayoutParams) layoutParams).width);
            Window.this.data.putInt("heightBeforeMaximize", ((WindowManager.LayoutParams) layoutParams).height);
            Window.this.data.putInt("xBeforeMaximize", ((WindowManager.LayoutParams) layoutParams).x);
            Window.this.data.putInt("yBeforeMaximize", ((WindowManager.LayoutParams) layoutParams).y);
            Window.this.edit().e(1.0f, 1.0f).c(0, 0).a();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class e implements View.OnClickListener {
        e() {
        }

        public void onClick(View view) {
            Window.this.mContext.c(Window.this.id);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class f implements View.OnTouchListener {
        f() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            StandOutWindow standOutWindow = Window.this.mContext;
            Window window = Window.this;
            return standOutWindow.z(window.id, window, view, motionEvent);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class g implements View.OnTouchListener {
        g() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            StandOutWindow standOutWindow = Window.this.mContext;
            Window window = Window.this;
            return standOutWindow.A(window.id, window, view, motionEvent);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class h implements View.OnTouchListener {
        h() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            StandOutWindow standOutWindow = Window.this.mContext;
            Window window = Window.this;
            return standOutWindow.A(window.id, window, view, motionEvent);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class i implements View.OnClickListener {
        final /* synthetic */ View a;

        i(View view) {
            this.a = view;
        }

        public void onClick(View view) {
            PopupWindow i = Window.this.mContext.i(Window.this.id);
            if (i != null) {
                i.showAsDropDown(this.a);
            }
        }
    }

    /* compiled from: Taobao */
    public class j {
        public static final int UNCHANGED = Integer.MIN_VALUE;
        StandOutWindow.StandOutLayoutParams a;
        float b = 0.0f;
        float c = 0.0f;

        public j() {
            this.a = Window.this.getLayoutParams();
        }

        private j d(int i, int i2, boolean z) {
            StandOutWindow.StandOutLayoutParams standOutLayoutParams = this.a;
            if (standOutLayoutParams != null) {
                float f = this.b;
                if (f >= 0.0f && f <= 1.0f) {
                    float f2 = this.c;
                    if (f2 >= 0.0f && f2 <= 1.0f) {
                        if (i != Integer.MIN_VALUE) {
                            ((WindowManager.LayoutParams) standOutLayoutParams).x = (int) (((float) i) - (((float) ((WindowManager.LayoutParams) standOutLayoutParams).width) * f));
                        }
                        if (i2 != Integer.MIN_VALUE) {
                            ((WindowManager.LayoutParams) standOutLayoutParams).y = (int) (((float) i2) - (((float) ((WindowManager.LayoutParams) standOutLayoutParams).height) * f2));
                        }
                        if (gu2.a(Window.this.flags, vd2.FLAG_WINDOW_EDGE_LIMITS_ENABLE)) {
                            StandOutWindow.StandOutLayoutParams standOutLayoutParams2 = this.a;
                            if (((WindowManager.LayoutParams) standOutLayoutParams2).gravity == 51) {
                                ((WindowManager.LayoutParams) standOutLayoutParams2).x = Math.min(Math.max(((WindowManager.LayoutParams) standOutLayoutParams2).x, 0), Window.this.displayWidth - ((WindowManager.LayoutParams) this.a).width);
                                StandOutWindow.StandOutLayoutParams standOutLayoutParams3 = this.a;
                                ((WindowManager.LayoutParams) standOutLayoutParams3).y = Math.min(Math.max(((WindowManager.LayoutParams) standOutLayoutParams3).y, 0), Window.this.displayHeight - ((WindowManager.LayoutParams) this.a).height);
                            } else {
                                throw new IllegalStateException("The window " + Window.this.id + " gravity must be TOP|LEFT if FLAG_WINDOW_EDGE_LIMITS_ENABLE or FLAG_WINDOW_EDGE_TILE_ENABLE is set.");
                            }
                        }
                    }
                }
                throw new IllegalStateException("Anchor point must be between 0 and 1, inclusive.");
            }
            return this;
        }

        private j g(int i, int i2, boolean z) {
            StandOutWindow.StandOutLayoutParams standOutLayoutParams = this.a;
            if (standOutLayoutParams != null) {
                float f = this.b;
                if (f >= 0.0f && f <= 1.0f) {
                    float f2 = this.c;
                    if (f2 >= 0.0f && f2 <= 1.0f) {
                        int i3 = ((WindowManager.LayoutParams) standOutLayoutParams).width;
                        int i4 = ((WindowManager.LayoutParams) standOutLayoutParams).height;
                        if (i != Integer.MIN_VALUE) {
                            ((WindowManager.LayoutParams) standOutLayoutParams).width = i;
                        }
                        if (i2 != Integer.MIN_VALUE) {
                            ((WindowManager.LayoutParams) standOutLayoutParams).height = i2;
                        }
                        int i5 = standOutLayoutParams.maxWidth;
                        int i6 = standOutLayoutParams.maxHeight;
                        if (gu2.a(Window.this.flags, vd2.FLAG_WINDOW_EDGE_LIMITS_ENABLE)) {
                            i5 = Math.min(i5, Window.this.displayWidth);
                            i6 = Math.min(i6, Window.this.displayHeight);
                        }
                        StandOutWindow.StandOutLayoutParams standOutLayoutParams2 = this.a;
                        ((WindowManager.LayoutParams) standOutLayoutParams2).width = Math.min(Math.max(((WindowManager.LayoutParams) standOutLayoutParams2).width, standOutLayoutParams2.minWidth), i5);
                        StandOutWindow.StandOutLayoutParams standOutLayoutParams3 = this.a;
                        ((WindowManager.LayoutParams) standOutLayoutParams3).height = Math.min(Math.max(((WindowManager.LayoutParams) standOutLayoutParams3).height, standOutLayoutParams3.minHeight), i6);
                        if (gu2.a(Window.this.flags, vd2.FLAG_WINDOW_ASPECT_RATIO_ENABLE)) {
                            StandOutWindow.StandOutLayoutParams standOutLayoutParams4 = this.a;
                            float f3 = Window.this.touchInfo.i;
                            int i7 = (int) (((float) ((WindowManager.LayoutParams) standOutLayoutParams4).height) * f3);
                            int i8 = (int) (((float) ((WindowManager.LayoutParams) standOutLayoutParams4).width) / f3);
                            if (i8 < standOutLayoutParams4.minHeight || i8 > standOutLayoutParams4.maxHeight) {
                                ((WindowManager.LayoutParams) standOutLayoutParams4).width = i7;
                            } else {
                                ((WindowManager.LayoutParams) standOutLayoutParams4).height = i8;
                            }
                        }
                        if (!z) {
                            StandOutWindow.StandOutLayoutParams standOutLayoutParams5 = this.a;
                            c((int) (((float) ((WindowManager.LayoutParams) standOutLayoutParams5).x) + (((float) i3) * this.b)), (int) (((float) ((WindowManager.LayoutParams) standOutLayoutParams5).y) + (((float) i4) * this.c)));
                        }
                    }
                }
                throw new IllegalStateException("Anchor point must be between 0 and 1, inclusive.");
            }
            return this;
        }

        public void a() {
            if (this.a != null) {
                Window.this.mContext.G(Window.this.id, this.a);
                this.a = null;
            }
        }

        public j b(float f, float f2) {
            if (f < 0.0f || f > 1.0f || f2 < 0.0f || f2 > 1.0f) {
                throw new IllegalArgumentException("Anchor point must be between 0 and 1, inclusive.");
            }
            this.b = f;
            this.c = f2;
            return this;
        }

        public j c(int i, int i2) {
            return d(i, i2, false);
        }

        public j e(float f, float f2) {
            Window window = Window.this;
            return f((int) (((float) window.displayWidth) * f), (int) (((float) window.displayHeight) * f2));
        }

        public j f(int i, int i2) {
            return g(i, i2, false);
        }
    }

    public Window(Context context) {
        super(context);
        this.mContext = null;
    }

    @SuppressLint({"InflateParams"})
    private View getSystemDecorations() {
        View inflate = this.mLayoutInflater.inflate(R$layout.console_window, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R$id.window_icon);
        textView.setOnClickListener(new b(textView));
        ((TextView) inflate.findViewById(R$id.title)).setText(this.mContext.a);
        View findViewById = inflate.findViewById(R$id.min_window);
        findViewById.setOnClickListener(new c());
        findViewById.setVisibility(8);
        View findViewById2 = inflate.findViewById(R$id.max_window);
        findViewById2.setOnClickListener(new d());
        View findViewById3 = inflate.findViewById(R$id.close_window);
        findViewById3.setOnClickListener(new e());
        View findViewById4 = inflate.findViewById(R$id.ll_console_windowbar);
        findViewById4.setOnTouchListener(new f());
        View findViewById5 = inflate.findViewById(R$id.corner);
        findViewById5.setOnTouchListener(new g());
        if (gu2.a(this.flags, vd2.FLAG_WINDOW_HIDE_ENABLE)) {
            findViewById.setVisibility(0);
        }
        if (gu2.a(this.flags, vd2.FLAG_DECORATION_MAXIMIZE_DISABLE)) {
            findViewById2.setVisibility(8);
        }
        if (gu2.a(this.flags, vd2.FLAG_DECORATION_CLOSE_DISABLE)) {
            findViewById3.setVisibility(8);
        }
        if (gu2.a(this.flags, vd2.FLAG_DECORATION_MOVE_DISABLE)) {
            findViewById4.setOnTouchListener(null);
        }
        if (gu2.a(this.flags, vd2.FLAG_DECORATION_RESIZE_DISABLE)) {
            findViewById5.setVisibility(8);
        }
        return inflate;
    }

    /* access modifiers changed from: package-private */
    public void addFunctionality(View view) {
        View findViewById;
        View findViewById2;
        if (!gu2.a(this.flags, vd2.FLAG_ADD_FUNCTIONALITY_RESIZE_DISABLE) && (findViewById2 = view.findViewById(R$id.corner)) != null) {
            findViewById2.setOnTouchListener(new h());
        }
        if (!gu2.a(this.flags, vd2.FLAG_ADD_FUNCTIONALITY_DROP_DOWN_DISABLE) && (findViewById = view.findViewById(R$id.window_icon)) != null) {
            findViewById.setOnClickListener(new i(findViewById));
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.mContext.F(this);
        return true;
    }

    public j edit() {
        return new j();
    }

    /* access modifiers changed from: package-private */
    public void fixCompatibility(View view) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(view);
        while (true) {
            View view2 = (View) linkedList.poll();
            if (view2 == null) {
                return;
            }
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    linkedList.add(viewGroup.getChildAt(i2));
                }
            }
        }
    }

    public boolean onFocus(boolean z) {
        if (gu2.a(this.flags, vd2.FLAG_WINDOW_FOCUSABLE_DISABLE) || z == this.focused) {
            return false;
        }
        this.focused = z;
        if (!gu2.a(this.flags, vd2.FLAG_WINDOW_FOCUS_INDICATOR_DISABLE)) {
            View findViewById = findViewById(R$id.content);
            if (z) {
                findViewById.setBackgroundResource(R$drawable.border_focused);
            } else if (gu2.a(this.flags, vd2.FLAG_DECORATION_SYSTEM)) {
                findViewById.setBackgroundResource(R$drawable.border);
            } else {
                findViewById.setBackgroundResource(0);
            }
        }
        StandOutWindow.StandOutLayoutParams layoutParams = getLayoutParams();
        layoutParams.setFocusFlag(z);
        this.mContext.G(this.id, layoutParams);
        if (z) {
            this.mContext.C(this);
            return true;
        } else if (this.mContext.l() != this) {
            return true;
        } else {
            this.mContext.C(null);
            return true;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        StandOutWindow.StandOutLayoutParams layoutParams = getLayoutParams();
        if (motionEvent.getAction() == 0 && this.mContext.l() != this) {
            this.mContext.g(this.id);
        }
        if (motionEvent.getPointerCount() < 2 || !gu2.a(this.flags, vd2.FLAG_WINDOW_PINCH_RESIZE_ENABLE) || (motionEvent.getAction() & 255) != 5) {
            return false;
        }
        an2 an2 = this.touchInfo;
        an2.f = 1.0d;
        an2.e = -1.0d;
        an2.g = (double) ((WindowManager.LayoutParams) layoutParams).width;
        an2.h = (double) ((WindowManager.LayoutParams) layoutParams).height;
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 4 && this.mContext.l() == this) {
            this.mContext.F(this);
        }
        if (motionEvent.getPointerCount() >= 2 && gu2.a(this.flags, vd2.FLAG_WINDOW_PINCH_RESIZE_ENABLE)) {
            double sqrt = Math.sqrt(Math.pow((double) (motionEvent.getX(0) - motionEvent.getX(1)), 2.0d) + Math.pow((double) (motionEvent.getY(0) - motionEvent.getY(1)), 2.0d));
            if ((motionEvent.getAction() & 255) == 2) {
                an2 an2 = this.touchInfo;
                if (an2.e == -1.0d) {
                    an2.e = sqrt;
                }
                an2.f *= sqrt / an2.e;
                an2.e = sqrt;
                j b2 = edit().b(0.5f, 0.5f);
                an2 an22 = this.touchInfo;
                double d2 = an22.g;
                double d3 = an22.f;
                b2.f((int) (d2 * d3), (int) (an22.h * d3)).a();
            }
        }
        return true;
    }

    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof StandOutWindow.StandOutLayoutParams) {
            super.setLayoutParams(layoutParams);
            return;
        }
        throw new IllegalArgumentException(TAG + this.id + ": LayoutParams must be an instance of StandOutLayoutParams.");
    }

    public StandOutWindow.StandOutLayoutParams getLayoutParams() {
        StandOutWindow.StandOutLayoutParams standOutLayoutParams = (StandOutWindow.StandOutLayoutParams) super.getLayoutParams();
        return standOutLayoutParams == null ? this.originalParams : standOutLayoutParams;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<? extends com.alibaba.poplayerconsole.lib.StandOutWindow> */
    public Window(StandOutWindow standOutWindow, int i2) {
        super(standOutWindow);
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        standOutWindow.setTheme(0);
        this.mContext = standOutWindow;
        this.mLayoutInflater = LayoutInflater.from(standOutWindow);
        this.cls = standOutWindow.getClass();
        this.id = i2;
        this.originalParams = standOutWindow.n(i2, this);
        this.flags = standOutWindow.c;
        an2 an2 = new an2();
        this.touchInfo = an2;
        StandOutWindow.StandOutLayoutParams standOutLayoutParams = this.originalParams;
        an2.i = ((float) ((WindowManager.LayoutParams) standOutLayoutParams).width) / ((float) ((WindowManager.LayoutParams) standOutLayoutParams).height);
        this.data = new Bundle();
        DisplayMetrics displayMetrics = standOutWindow.getResources().getDisplayMetrics();
        this.displayWidth = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        this.displayHeight = (int) (((float) com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics)) - (displayMetrics.density * 25.0f));
        if (gu2.a(this.flags, vd2.FLAG_DECORATION_SYSTEM)) {
            View systemDecorations = getSystemDecorations();
            frameLayout = (FrameLayout) systemDecorations.findViewById(R$id.body);
            frameLayout2 = systemDecorations;
        } else {
            FrameLayout frameLayout3 = new FrameLayout(standOutWindow);
            frameLayout3.setId(R$id.content);
            frameLayout = frameLayout3;
            frameLayout2 = frameLayout3;
        }
        addView(frameLayout2);
        frameLayout.setOnTouchListener(new a(standOutWindow, i2));
        standOutWindow.f(i2, frameLayout);
        if (frameLayout.getChildCount() != 0) {
            if (!gu2.a(this.flags, vd2.FLAG_FIX_COMPATIBILITY_ALL_DISABLE)) {
                fixCompatibility(frameLayout);
            }
            if (!gu2.a(this.flags, vd2.FLAG_ADD_FUNCTIONALITY_ALL_DISABLE)) {
                addFunctionality(frameLayout);
            }
            setTag(frameLayout.getTag());
            return;
        }
        throw new RuntimeException("You must attach your view to the given frame in createAndAttachView()");
    }
}
