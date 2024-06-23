package cn.damai.common.app.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import cn.damai.common.app.widget.BubbleLayout;
import cn.damai.uikit.R$style;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.s50;

/* compiled from: Taobao */
public class BubbleDialog extends Dialog {
    private static transient /* synthetic */ IpChange $ipChange;
    private BubbleLayout a;
    private int b;
    private int c;
    private int d;
    private View e;
    private Rect f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private Position m = Position.TOP;
    private Position[] n = new Position[4];
    private Auto o;
    private boolean p = false;
    private boolean q;
    private int[] r = new int[2];
    private Activity s;
    private ViewTreeObserver.OnGlobalLayoutListener t;

    /* compiled from: Taobao */
    public enum Auto {
        AROUND,
        UP_AND_DOWN,
        LEFT_AND_RIGHT
    }

    /* compiled from: Taobao */
    public enum Position {
        LEFT,
        TOP,
        RIGHT,
        BOTTOM
    }

    /* compiled from: Taobao */
    public class a implements View.OnTouchListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ WindowManager.LayoutParams a;
        final /* synthetic */ int b;

        a(WindowManager.LayoutParams layoutParams, int i) {
            this.a = layoutParams;
            this.b = i;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1806723117")) {
                return ((Boolean) ipChange.ipc$dispatch("-1806723117", new Object[]{this, view, motionEvent})).booleanValue();
            } else if (!BubbleDialog.this.p) {
                return false;
            } else {
                int i = this.a.x;
                float f = i < 0 ? 0.0f : (float) i;
                int i2 = this.b;
                if (((float) view.getWidth()) + f > ((float) i2)) {
                    f = (float) (i2 - view.getWidth());
                }
                motionEvent.setLocation(f + motionEvent.getX(), ((float) this.a.y) + motionEvent.getY());
                BubbleDialog.this.s.getWindow().getDecorView().dispatchTouchEvent(motionEvent);
                return true;
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;
        int a;
        int b;

        b() {
        }

        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1954128679")) {
                ipChange.ipc$dispatch("1954128679", new Object[]{this});
            } else if (this.a != BubbleDialog.this.a.getMeasuredWidth() || this.b != BubbleDialog.this.a.getMeasuredHeight()) {
                BubbleDialog.this.f();
                this.a = BubbleDialog.this.a.getMeasuredWidth();
                this.b = BubbleDialog.this.a.getMeasuredHeight();
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements BubbleLayout.OnClickEdgeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.common.app.widget.BubbleLayout.OnClickEdgeListener
        public void edge() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1534681033")) {
                ipChange.ipc$dispatch("-1534681033", new Object[]{this});
            } else if (BubbleDialog.this.q) {
                BubbleDialog.this.dismiss();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class d {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        static {
            int[] iArr = new int[Auto.values().length];
            b = iArr;
            try {
                iArr[Auto.AROUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[Auto.UP_AND_DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[Auto.LEFT_AND_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[Position.values().length];
            a = iArr2;
            iArr2[Position.LEFT.ordinal()] = 1;
            a[Position.TOP.ordinal()] = 2;
            a[Position.RIGHT.ordinal()] = 3;
            try {
                a[Position.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public BubbleDialog(Context context) {
        super(context, R$style.bubble_dialog);
        setCancelable(true);
        this.s = (Activity) context;
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            int i2 = DisplayMetrics.getwidthPixels(s50.b(getContext()));
            this.i = s50.c(getContext());
            getWindow().getDecorView().setOnTouchListener(new a(attributes, i2));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0072, code lost:
        if (r2 != 4) goto L_0x0263;
     */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0267  */
    private void f() {
        Window window;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "898795540")) {
            ipChange.ipc$dispatch("898795540", new Object[]{this});
        } else if (this.f != null && (window = getWindow()) != null) {
            window.setGravity(51);
            WindowManager.LayoutParams attributes = window.getAttributes();
            int i3 = this.b;
            if (i3 != 0) {
                attributes.width = i3;
            }
            int i4 = this.c;
            if (i4 != 0) {
                attributes.height = i4;
            }
            if (this.d != 0) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.getLayoutParams();
                Position position = this.m;
                if (position == Position.TOP || position == Position.BOTTOM) {
                    int i5 = this.d;
                    layoutParams.leftMargin = i5;
                    layoutParams.rightMargin = i5;
                } else {
                    int i6 = this.d;
                    layoutParams.topMargin = i6;
                    layoutParams.bottomMargin = i6;
                }
                this.a.setLayoutParams(layoutParams);
            }
            int i7 = d.a[this.m.ordinal()];
            if (i7 != 1) {
                if (i7 != 2) {
                    if (i7 != 3) {
                    }
                }
                int width = ((this.r[0] + (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.f) / 2)) - (this.a.getMeasuredWidth() / 2)) + this.g;
                attributes.x = width;
                int i8 = this.d;
                if (i8 != 0 && this.b == -1) {
                    this.a.setLookPosition(((this.r[0] - i8) + (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.f) / 2)) - (this.a.getLookWidth() / 2));
                } else if (width <= 0) {
                    this.a.setLookPosition((this.r[0] + (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.f) / 2)) - (this.a.getLookWidth() / 2));
                } else if (width + this.a.getMeasuredWidth() > DisplayMetrics.getwidthPixels(s50.b(getContext()))) {
                    this.a.setLookPosition(((this.r[0] - (DisplayMetrics.getwidthPixels(s50.b(getContext())) - this.a.getMeasuredWidth())) + (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.f) / 2)) - (this.a.getLookWidth() / 2));
                } else {
                    this.a.setLookPosition(((this.r[0] - attributes.x) + (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.f) / 2)) - (this.a.getLookWidth() / 2));
                }
                if (this.m == Position.BOTTOM) {
                    int i9 = this.j;
                    if (i9 != 0) {
                        this.h = i9;
                    }
                    attributes.y = ((this.r[1] + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.f)) + this.h) - this.i;
                } else {
                    int i10 = this.j;
                    if (i10 != 0) {
                        this.h = -i10;
                    }
                    attributes.y = ((this.r[1] - this.a.getMeasuredHeight()) + this.h) - this.i;
                }
                i2 = this.k;
                if (i2 != 0) {
                    this.a.setLookPosition(i2);
                }
                this.a.invalidate();
                window.setAttributes(attributes);
            }
            int height = (((this.r[1] + this.h) + (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.f) / 2)) - (this.a.getMeasuredHeight() / 2)) - this.i;
            attributes.y = height;
            int i11 = this.d;
            if (i11 != 0 && this.c == -1) {
                this.a.setLookPosition((((this.r[1] - i11) + (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.f) / 2)) - (this.a.getLookWidth() / 2)) - this.i);
            } else if (height <= 0) {
                this.a.setLookPosition(((this.r[1] + (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.f) / 2)) - (this.a.getLookWidth() / 2)) - this.i);
            } else if (height + this.a.getMeasuredHeight() > DisplayMetrics.getheightPixels(s50.b(getContext()))) {
                this.a.setLookPosition(((this.r[1] - (DisplayMetrics.getheightPixels(s50.b(getContext())) - this.a.getMeasuredHeight())) + (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.f) / 2)) - (this.a.getLookWidth() / 2));
            } else {
                this.a.setLookPosition((((this.r[1] - attributes.y) + (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.f) / 2)) - (this.a.getLookWidth() / 2)) - this.i);
            }
            if (this.m == Position.RIGHT) {
                int i12 = this.j;
                if (i12 != 0) {
                    this.g = i12;
                }
                attributes.x = this.r[0] + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.f) + this.g;
            } else {
                int i13 = this.j;
                if (i13 != 0) {
                    this.g = -i13;
                }
                attributes.x = (this.r[0] - this.a.getMeasuredWidth()) + this.g;
            }
            i2 = this.k;
            if (i2 != 0) {
            }
            this.a.invalidate();
            window.setAttributes(attributes);
        }
    }

    private void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "915368156")) {
            ipChange.ipc$dispatch("915368156", new Object[]{this});
            return;
        }
        i();
        if (this.t != null) {
            m();
            f();
        }
    }

    private boolean h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-805721721")) {
            return ((Boolean) ipChange.ipc$dispatch("-805721721", new Object[]{this})).booleanValue();
        }
        int i2 = 0;
        for (Position position : this.n) {
            if (position != null) {
                i2++;
            }
        }
        return i2 > 0;
    }

    private void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1338801810")) {
            ipChange.ipc$dispatch("-1338801810", new Object[]{this});
        } else if (this.f != null) {
            if (this.o != null || h()) {
                int[] iArr = this.r;
                int[] iArr2 = {iArr[0], iArr[1], (DisplayMetrics.getwidthPixels(s50.b(getContext())) - this.r[0]) - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.f), (DisplayMetrics.getheightPixels(s50.b(getContext())) - this.r[1]) - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.f)};
                if (h()) {
                    this.e.measure(0, 0);
                    Position[] positionArr = this.n;
                    for (Position position : positionArr) {
                        if (position != null) {
                            int i2 = d.a[position.ordinal()];
                            if (i2 != 1) {
                                if (i2 != 2) {
                                    if (i2 != 3) {
                                        if (iArr2[3] > this.e.getMeasuredHeight()) {
                                            this.m = Position.BOTTOM;
                                            return;
                                        }
                                    } else if (iArr2[2] > this.e.getMeasuredWidth()) {
                                        this.m = Position.RIGHT;
                                        return;
                                    }
                                } else if (iArr2[1] > this.e.getMeasuredHeight()) {
                                    this.m = Position.TOP;
                                    return;
                                }
                            } else if (iArr2[0] > this.e.getMeasuredWidth()) {
                                this.m = Position.LEFT;
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    this.m = this.n[0];
                    return;
                }
                Auto auto = this.o;
                if (auto != null) {
                    int i3 = d.b[auto.ordinal()];
                    if (i3 == 2) {
                        this.m = iArr2[1] > iArr2[3] ? Position.TOP : Position.BOTTOM;
                        return;
                    } else if (i3 == 3) {
                        this.m = iArr2[0] > iArr2[2] ? Position.LEFT : Position.RIGHT;
                        return;
                    }
                }
                int i4 = 0;
                for (int i5 = 0; i5 < 4; i5++) {
                    int i6 = iArr2[i5];
                    if (i6 > i4) {
                        i4 = i6;
                    }
                }
                if (i4 == iArr2[0]) {
                    this.m = Position.LEFT;
                } else if (i4 == iArr2[1]) {
                    this.m = Position.TOP;
                } else if (i4 == iArr2[2]) {
                    this.m = Position.RIGHT;
                } else if (i4 == iArr2[3]) {
                    this.m = Position.BOTTOM;
                }
            }
        }
    }

    private void m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2080848612")) {
            ipChange.ipc$dispatch("2080848612", new Object[]{this});
            return;
        }
        int i2 = d.a[this.m.ordinal()];
        if (i2 == 1) {
            this.a.setLook(BubbleLayout.Look.RIGHT);
        } else if (i2 == 2) {
            this.a.setLook(BubbleLayout.Look.BOTTOM);
        } else if (i2 == 3) {
            this.a.setLook(BubbleLayout.Look.LEFT);
        } else if (i2 == 4) {
            this.a.setLook(BubbleLayout.Look.TOP);
        }
        this.a.initPadding();
    }

    public void dismiss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-594101797")) {
            ipChange.ipc$dispatch("-594101797", new Object[]{this});
            return;
        }
        BubbleLayout bubbleLayout = this.a;
        if (bubbleLayout != null && Build.VERSION.SDK_INT >= 16) {
            bubbleLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this.t);
        }
        super.dismiss();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: cn.damai.common.app.widget.BubbleDialog */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends BubbleDialog> T j(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1156174502")) {
            return (T) ((BubbleDialog) ipChange.ipc$dispatch("1156174502", new Object[]{this, view}));
        }
        this.e = view;
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: cn.damai.common.app.widget.BubbleDialog */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends BubbleDialog> T k(View view, int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1958138930")) {
            return (T) ((BubbleDialog) ipChange.ipc$dispatch("-1958138930", new Object[]{this, view, iArr}));
        }
        this.f = new Rect(iArr[0], iArr[1], iArr[2], iArr[3]);
        view.getLocationOnScreen(this.r);
        g();
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: cn.damai.common.app.widget.BubbleDialog */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends BubbleDialog> T l(int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1625249779")) {
            return (T) ((BubbleDialog) ipChange.ipc$dispatch("1625249779", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}));
        }
        this.b = i2;
        this.c = i3;
        this.d = i4;
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: cn.damai.common.app.widget.BubbleDialog */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends BubbleDialog> T n(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-257593861")) {
            return (T) ((BubbleDialog) ipChange.ipc$dispatch("-257593861", new Object[]{this, Integer.valueOf(i2)}));
        }
        this.k = s50.a(getContext(), (float) i2);
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: cn.damai.common.app.widget.BubbleDialog */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends BubbleDialog> T o(Position... positionArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2016341874")) {
            return (T) ((BubbleDialog) ipChange.ipc$dispatch("-2016341874", new Object[]{this, positionArr}));
        } else if (positionArr.length != 1 || positionArr[0] == null) {
            this.n = positionArr;
            return this;
        } else {
            this.m = positionArr[0];
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-581309974")) {
            ipChange.ipc$dispatch("-581309974", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        if (this.a == null) {
            this.a = new BubbleLayout(getContext());
        }
        View view = this.e;
        if (view != null) {
            this.a.addView(view);
        }
        setContentView(this.a);
        Window window = getWindow();
        if (window != null) {
            if (this.l) {
                window.setSoftInputMode(18);
            }
            window.setLayout(-2, -2);
            i();
            m();
            this.a.measure(0, 0);
            f();
            this.t = new b();
            this.a.getViewTreeObserver().addOnGlobalLayoutListener(this.t);
            this.a.setOnClickEdgeListener(new c());
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-459851264")) {
            return ((Boolean) ipChange.ipc$dispatch("-459851264", new Object[]{this, Integer.valueOf(i2), keyEvent})).booleanValue();
        } else if (!this.p || i2 != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i2, keyEvent);
        } else {
            dismiss();
            this.s.onBackPressed();
            this.s = null;
            return true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "910366340")) {
            return ((Boolean) ipChange.ipc$dispatch("910366340", new Object[]{this, motionEvent})).booleanValue();
        }
        Window window = getWindow();
        if (window == null) {
            return false;
        }
        View decorView = window.getDecorView();
        if (!this.q || !isShowing() || !s(motionEvent, decorView)) {
            return false;
        }
        cancel();
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: cn.damai.common.app.widget.BubbleDialog */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends BubbleDialog> T p(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "19244008")) {
            return (T) ((BubbleDialog) ipChange.ipc$dispatch("19244008", new Object[]{this, Integer.valueOf(i2)}));
        }
        this.j = s50.a(getContext(), (float) i2);
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: cn.damai.common.app.widget.BubbleDialog */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends BubbleDialog> T q(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-755166505")) {
            return (T) ((BubbleDialog) ipChange.ipc$dispatch("-755166505", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)}));
        }
        this.p = z;
        if (z) {
            setCancelable(false);
        } else {
            setCancelable(z2);
        }
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: cn.damai.common.app.widget.BubbleDialog */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends BubbleDialog> T r() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1918534768")) {
            return (T) ((BubbleDialog) ipChange.ipc$dispatch("1918534768", new Object[]{this}));
        } else if (getWindow() == null) {
            return this;
        } else {
            getWindow().clearFlags(2);
            return this;
        }
    }

    public boolean s(MotionEvent motionEvent, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "724636503")) {
            return ((Boolean) ipChange.ipc$dispatch("724636503", new Object[]{this, motionEvent, view})).booleanValue();
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (x <= 0 || y <= 0 || x > view.getWidth() || y > view.getHeight()) {
            return true;
        }
        return false;
    }

    public void setCancelable(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1809277787")) {
            ipChange.ipc$dispatch("-1809277787", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setCancelable(z);
        this.q = z;
    }
}
