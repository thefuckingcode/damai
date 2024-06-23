package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.autofittext;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.Editable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import cn.damai.trade.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Taobao */
public class AutoFitHelper {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;
    private TextPaint b;
    private float c;
    private int d;
    private float e;
    private float f;
    private float g;
    private boolean h;
    private boolean i;
    private ArrayList<OnTextSizeChangeListener> j;
    private TextWatcher k = new c();
    private View.OnLayoutChangeListener l = new b();

    /* compiled from: Taobao */
    public interface OnTextSizeChangeListener {
        void onTextSizeChange(float f, float f2);
    }

    /* compiled from: Taobao */
    public class b implements View.OnLayoutChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        private b() {
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1540421399")) {
                ipChange.ipc$dispatch("-1540421399", new Object[]{this, view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)});
                return;
            }
            AutoFitHelper.this.c();
        }
    }

    /* compiled from: Taobao */
    public class c implements TextWatcher {
        private static transient /* synthetic */ IpChange $ipChange;

        private c() {
        }

        public void afterTextChanged(Editable editable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "84324666")) {
                ipChange.ipc$dispatch("84324666", new Object[]{this, editable});
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2018426697")) {
                ipChange.ipc$dispatch("2018426697", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-645562263")) {
                ipChange.ipc$dispatch("-645562263", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                return;
            }
            AutoFitHelper.this.c();
        }
    }

    private AutoFitHelper(TextView textView) {
        float f2 = textView.getContext().getResources().getDisplayMetrics().scaledDensity;
        this.a = textView;
        this.b = new TextPaint();
        w(textView.getTextSize());
        this.d = i(textView);
        this.e = f2 * 8.0f;
        this.f = this.c;
        this.g = 0.5f;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1876203057")) {
            ipChange.ipc$dispatch("1876203057", new Object[]{this});
            return;
        }
        float textSize = this.a.getTextSize();
        this.i = true;
        d(this.a, this.b, this.e, this.f, this.d, this.g);
        this.i = false;
        float textSize2 = this.a.getTextSize();
        if (textSize2 != textSize) {
            n(textSize2, textSize);
        }
    }

    private static void d(TextView textView, TextPaint textPaint, float f2, float f3, int i2, float f4) {
        int width;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1992291632")) {
            ipChange.ipc$dispatch("-1992291632", new Object[]{textView, textPaint, Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i2), Float.valueOf(f4)});
        } else if (i2 > 0 && i2 != Integer.MAX_VALUE && (width = (textView.getWidth() - textView.getPaddingLeft()) - textView.getPaddingRight()) > 0) {
            CharSequence text = textView.getText();
            TransformationMethod transformationMethod = textView.getTransformationMethod();
            if (transformationMethod != null) {
                text = transformationMethod.getTransformation(text, textView);
            }
            Context context = textView.getContext();
            Resources system = Resources.getSystem();
            if (context != null) {
                system = context.getResources();
            }
            DisplayMetrics displayMetrics = system.getDisplayMetrics();
            textPaint.set(textView.getPaint());
            textPaint.setTextSize(f3);
            float g2 = ((i2 != 1 || textPaint.measureText(text, 0, text.length()) <= ((float) width)) && h(text, textPaint, f3, (float) width, displayMetrics) <= i2) ? f3 : g(text, textPaint, (float) width, i2, 0.0f, f3, f4, displayMetrics);
            if (g2 < f2) {
                g2 = f2;
            }
            textView.setTextSize(0, g2);
        }
    }

    public static AutoFitHelper e(TextView textView) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1884247200")) {
            return f(textView, null, 0);
        }
        return (AutoFitHelper) ipChange.ipc$dispatch("-1884247200", new Object[]{textView});
    }

    public static AutoFitHelper f(TextView textView, AttributeSet attributeSet, int i2) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-119745707")) {
            return (AutoFitHelper) ipChange.ipc$dispatch("-119745707", new Object[]{textView, attributeSet, Integer.valueOf(i2)});
        }
        AutoFitHelper autoFitHelper = new AutoFitHelper(textView);
        if (attributeSet != null) {
            Context context = textView.getContext();
            float l2 = autoFitHelper.l();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AutoFitTextView, i2, 0);
            z = obtainStyledAttributes.getBoolean(R$styleable.AutoFitTextView_sizeToFit, true);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.AutoFitTextView_minTextSize, (int) autoFitHelper.k());
            float f2 = obtainStyledAttributes.getFloat(R$styleable.AutoFitTextView_precision, l2);
            obtainStyledAttributes.recycle();
            autoFitHelper.s(0, (float) dimensionPixelSize).t(f2);
        }
        autoFitHelper.o(z);
        return autoFitHelper;
    }

    private static float g(CharSequence charSequence, TextPaint textPaint, float f2, int i2, float f3, float f4, float f5, DisplayMetrics displayMetrics) {
        StaticLayout staticLayout;
        int i3;
        float f6;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-990201785")) {
            return ((Float) ipChange.ipc$dispatch("-990201785", new Object[]{charSequence, textPaint, Float.valueOf(f2), Integer.valueOf(i2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), displayMetrics})).floatValue();
        }
        float f7 = (f3 + f4) / 2.0f;
        textPaint.setTextSize(TypedValue.applyDimension(0, f7, displayMetrics));
        if (i2 != 1) {
            StaticLayout staticLayout2 = new StaticLayout(charSequence, textPaint, (int) f2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            i3 = staticLayout2.getLineCount();
            staticLayout = staticLayout2;
        } else {
            staticLayout = null;
            i3 = 1;
        }
        if (i3 > i2) {
            if (f4 - f3 < f5) {
                return f3;
            }
            return g(charSequence, textPaint, f2, i2, f3, f7, f5, displayMetrics);
        } else if (i3 < i2) {
            return g(charSequence, textPaint, f2, i2, f7, f4, f5, displayMetrics);
        } else {
            float f8 = 0.0f;
            if (i2 == 1) {
                f6 = textPaint.measureText(charSequence, 0, charSequence.length());
            } else {
                for (int i4 = 0; i4 < i3; i4++) {
                    if (staticLayout.getLineWidth(i4) > f8) {
                        f8 = staticLayout.getLineWidth(i4);
                    }
                }
                f6 = f8;
            }
            if (f4 - f3 < f5) {
                return f3;
            }
            if (f6 > f2) {
                return g(charSequence, textPaint, f2, i2, f3, f7, f5, displayMetrics);
            }
            return f6 < f2 ? g(charSequence, textPaint, f2, i2, f7, f4, f5, displayMetrics) : f7;
        }
    }

    private static int h(CharSequence charSequence, TextPaint textPaint, float f2, float f3, DisplayMetrics displayMetrics) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-742977552")) {
            return ((Integer) ipChange.ipc$dispatch("-742977552", new Object[]{charSequence, textPaint, Float.valueOf(f2), Float.valueOf(f3), displayMetrics})).intValue();
        }
        textPaint.setTextSize(TypedValue.applyDimension(0, f2, displayMetrics));
        return new StaticLayout(charSequence, textPaint, (int) f3, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true).getLineCount();
    }

    private static int i(TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1125053717")) {
            return ((Integer) ipChange.ipc$dispatch("1125053717", new Object[]{textView})).intValue();
        }
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (transformationMethod != null && (transformationMethod instanceof SingleLineTransformationMethod)) {
            return 1;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return textView.getMaxLines();
        }
        return -1;
    }

    private void n(float f2, float f3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1942389007")) {
            ipChange.ipc$dispatch("-1942389007", new Object[]{this, Float.valueOf(f2), Float.valueOf(f3)});
            return;
        }
        ArrayList<OnTextSizeChangeListener> arrayList = this.j;
        if (arrayList != null) {
            Iterator<OnTextSizeChangeListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onTextSizeChange(f2, f3);
            }
        }
    }

    private void u(float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1698969657")) {
            ipChange.ipc$dispatch("1698969657", new Object[]{this, Float.valueOf(f2)});
        } else if (f2 != this.f) {
            this.f = f2;
            c();
        }
    }

    private void v(float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "588530727")) {
            ipChange.ipc$dispatch("588530727", new Object[]{this, Float.valueOf(f2)});
        } else if (f2 != this.e) {
            this.e = f2;
            c();
        }
    }

    private void w(float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1898927555")) {
            ipChange.ipc$dispatch("-1898927555", new Object[]{this, Float.valueOf(f2)});
        } else if (this.c != f2) {
            this.c = f2;
        }
    }

    public AutoFitHelper b(OnTextSizeChangeListener onTextSizeChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1023863796")) {
            return (AutoFitHelper) ipChange.ipc$dispatch("-1023863796", new Object[]{this, onTextSizeChangeListener});
        }
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.add(onTextSizeChangeListener);
        return this;
    }

    public float j() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1451931893")) {
            return this.f;
        }
        return ((Float) ipChange.ipc$dispatch("-1451931893", new Object[]{this})).floatValue();
    }

    public float k() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-795015843")) {
            return this.e;
        }
        return ((Float) ipChange.ipc$dispatch("-795015843", new Object[]{this})).floatValue();
    }

    public float l() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-797499041")) {
            return this.g;
        }
        return ((Float) ipChange.ipc$dispatch("-797499041", new Object[]{this})).floatValue();
    }

    public boolean m() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-282533920")) {
            return this.h;
        }
        return ((Boolean) ipChange.ipc$dispatch("-282533920", new Object[]{this})).booleanValue();
    }

    public AutoFitHelper o(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "76424499")) {
            return (AutoFitHelper) ipChange.ipc$dispatch("76424499", new Object[]{this, Boolean.valueOf(z)});
        }
        if (this.h != z) {
            this.h = z;
            if (z) {
                this.a.addTextChangedListener(this.k);
                this.a.addOnLayoutChangeListener(this.l);
                c();
            } else {
                this.a.removeTextChangedListener(this.k);
                this.a.removeOnLayoutChangeListener(this.l);
                this.a.setTextSize(0, this.c);
            }
        }
        return this;
    }

    public AutoFitHelper p(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "139072996")) {
            return (AutoFitHelper) ipChange.ipc$dispatch("139072996", new Object[]{this, Integer.valueOf(i2)});
        }
        if (this.d != i2) {
            this.d = i2;
            c();
        }
        return this;
    }

    public AutoFitHelper q(float f2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "17987952")) {
            return r(2, f2);
        }
        return (AutoFitHelper) ipChange.ipc$dispatch("17987952", new Object[]{this, Float.valueOf(f2)});
    }

    public AutoFitHelper r(int i2, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2101553221")) {
            return (AutoFitHelper) ipChange.ipc$dispatch("-2101553221", new Object[]{this, Integer.valueOf(i2), Float.valueOf(f2)});
        }
        Context context = this.a.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        u(TypedValue.applyDimension(i2, f2, system.getDisplayMetrics()));
        return this;
    }

    public AutoFitHelper s(int i2, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1844722419")) {
            return (AutoFitHelper) ipChange.ipc$dispatch("-1844722419", new Object[]{this, Integer.valueOf(i2), Float.valueOf(f2)});
        }
        Context context = this.a.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        v(TypedValue.applyDimension(i2, f2, system.getDisplayMetrics()));
        return this;
    }

    public AutoFitHelper t(float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-413791332")) {
            return (AutoFitHelper) ipChange.ipc$dispatch("-413791332", new Object[]{this, Float.valueOf(f2)});
        }
        if (this.g != f2) {
            this.g = f2;
            c();
        }
        return this;
    }

    public void x(int i2, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "249894784")) {
            ipChange.ipc$dispatch("249894784", new Object[]{this, Integer.valueOf(i2), Float.valueOf(f2)});
        } else if (!this.i) {
            Context context = this.a.getContext();
            Resources system = Resources.getSystem();
            if (context != null) {
                system = context.getResources();
            }
            w(TypedValue.applyDimension(i2, f2, system.getDisplayMetrics()));
        }
    }
}
