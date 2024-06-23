package cn.damai.seat.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ExpandTextView extends AppCompatTextView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int STATE_COLLAPSE = 18;
    public static final int STATE_MULTI_LINE = 19;
    public static final int STATE_SINGLE_LINE = 17;
    private CharSequence mLastDrawText;
    private int mLastShowCount;
    private OnLineChangedListener mListener;

    /* compiled from: Taobao */
    public interface OnLineChangedListener {
        void onState(int i);
    }

    public ExpandTextView(Context context) {
        super(context);
    }

    public int getLineCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "582342354")) {
            return ((Integer) ipChange.ipc$dispatch("582342354", new Object[]{this})).intValue();
        }
        int lineCount = super.getLineCount();
        int i = -1;
        if (Build.VERSION.SDK_INT >= 16) {
            i = getMaxLines();
        }
        return i >= 0 ? Math.min(i, lineCount) : lineCount;
    }

    public boolean isExpand() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-323639196")) {
            return getLineCount() > 1;
        }
        return ((Boolean) ipChange.ipc$dispatch("-323639196", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1088557020")) {
            ipChange.ipc$dispatch("-1088557020", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        CharSequence text = getText();
        int lineCount = getLineCount();
        if (!TextUtils.equals(text, this.mLastDrawText) || this.mLastShowCount != lineCount) {
            OnLineChangedListener onLineChangedListener = this.mListener;
            if (onLineChangedListener != null) {
                if (lineCount == 0) {
                    onLineChangedListener.onState(17);
                } else if (lineCount == 1) {
                    if (lineCount == new StaticLayout(text == null ? "" : text, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true).getLineCount()) {
                        this.mListener.onState(17);
                    } else {
                        this.mListener.onState(18);
                    }
                } else {
                    onLineChangedListener.onState(19);
                }
            }
            this.mLastShowCount = lineCount;
            this.mLastDrawText = text;
        }
    }

    public void setExpand(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1135689130")) {
            ipChange.ipc$dispatch("1135689130", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            setMaxHeight(Integer.MAX_VALUE);
        } else {
            setLines(1);
            setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    public void setListener(OnLineChangedListener onLineChangedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "156053849")) {
            ipChange.ipc$dispatch("156053849", new Object[]{this, onLineChangedListener});
            return;
        }
        this.mListener = onLineChangedListener;
    }

    public ExpandTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ExpandTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
