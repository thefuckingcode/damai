package tb;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public abstract class p2 extends o2 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int DEFAULT_TEXT_COLOR = -10987432;
    public static final int DEFAULT_TEXT_SIZE = 18;
    public static final int LABEL_COLOR = -9437072;
    public static final int TEXT_VIEW_ITEM_RESOURCE = -1;
    private int b;
    private int c;
    protected Context d;
    protected LayoutInflater e;
    protected int f;
    protected int g;
    protected int h;

    protected p2(Context context) {
        this(context, -1);
    }

    private TextView c(View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "825371130")) {
            return (TextView) ipChange.ipc$dispatch("825371130", new Object[]{this, view, Integer.valueOf(i)});
        }
        if (i == 0) {
            try {
                if (view instanceof TextView) {
                    return (TextView) view;
                }
            } catch (ClassCastException e2) {
                Log.e("AbstractWheelAdapter", "You must supply a resource ID for a TextView");
                throw new IllegalStateException("AbstractWheelAdapter requires the resource ID to be a TextView", e2);
            }
        }
        if (i != 0) {
            return (TextView) view.findViewById(i);
        }
        return null;
    }

    private View d(int i, ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-648448446")) {
            return (View) ipChange.ipc$dispatch("-648448446", new Object[]{this, Integer.valueOf(i), viewGroup});
        } else if (i == -1) {
            return new TextView(this.d);
        } else {
            if (i != 0) {
                return this.e.inflate(i, viewGroup, false);
            }
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void a(TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1024467489")) {
            ipChange.ipc$dispatch("-1024467489", new Object[]{this, textView});
            return;
        }
        textView.setTextColor(this.b);
        textView.setGravity(17);
        textView.setTextSize((float) this.c);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setLines(1);
        textView.setPadding(5, 28, 5, 28);
    }

    /* access modifiers changed from: protected */
    public abstract CharSequence b(int i);

    public void e(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-362437078")) {
            ipChange.ipc$dispatch("-362437078", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.b = i;
    }

    public void f(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1308132234")) {
            ipChange.ipc$dispatch("-1308132234", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.c = i;
    }

    @Override // cn.damai.uikit.wheel.adapters.WheelViewAdapter
    public View getEmptyItem(View view, ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-545426672")) {
            return (View) ipChange.ipc$dispatch("-545426672", new Object[]{this, view, viewGroup});
        }
        if (view == null) {
            view = d(this.h, viewGroup);
        }
        if (this.h == -1 && (view instanceof TextView)) {
            a((TextView) view);
        }
        return view;
    }

    @Override // cn.damai.uikit.wheel.adapters.WheelViewAdapter
    public View getItem(int i, View view, ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1346951868")) {
            return (View) ipChange.ipc$dispatch("-1346951868", new Object[]{this, Integer.valueOf(i), view, viewGroup});
        } else if (i < 0 || i >= getItemsCount()) {
            return null;
        } else {
            if (view == null) {
                view = d(this.f, viewGroup);
            }
            TextView c2 = c(view, this.g);
            if (c2 != null) {
                CharSequence b2 = b(i);
                if (b2 == null) {
                    b2 = "";
                }
                c2.setText(b2);
                if (this.f == -1) {
                    a(c2);
                }
            }
            return view;
        }
    }

    protected p2(Context context, int i) {
        this(context, i, 0);
    }

    protected p2(Context context, int i, int i2) {
        this.b = DEFAULT_TEXT_COLOR;
        this.c = 18;
        this.d = context;
        this.f = i;
        this.g = i2;
        this.e = (LayoutInflater) context.getSystemService("layout_inflater");
    }
}
