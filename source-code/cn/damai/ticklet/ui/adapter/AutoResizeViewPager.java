package cn.damai.ticklet.ui.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import cn.damai.ticklet.view.TickletTicketItemDigitalTicketsView;
import cn.damai.ticklet.view.TickletTicketItemView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.LinkedHashMap;
import tb.s50;

/* compiled from: Taobao */
public class AutoResizeViewPager extends ViewPager {
    private static transient /* synthetic */ IpChange $ipChange;
    private int current;
    private int height = 0;
    private HashMap<Integer, View> mChildrenViews = new LinkedHashMap();
    private boolean scrollble = true;
    private HashMap<Integer, HashMap<Integer, Integer>> textHeightMap = new LinkedHashMap();
    private TextView textView;

    public AutoResizeViewPager(Context context) {
        super(context);
    }

    private int getOffset(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-830351842")) {
            return s50.a(getContext(), (float) (i * 15));
        }
        return ((Integer) ipChange.ipc$dispatch("-830351842", new Object[]{this, Integer.valueOf(i)})).intValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00e4, code lost:
        if (r8.textHeightMap.get(java.lang.Integer.valueOf(r8.current)).get(java.lang.Integer.valueOf(r6)).intValue() == r10) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0102, code lost:
        if (r8.textHeightMap.get(java.lang.Integer.valueOf(r8.current)).get(java.lang.Integer.valueOf(r0)).intValue() != r10) goto L_0x0106;
     */
    private int heightMeasure(TextView textView2, int i) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-971164388")) {
            return ((Integer) ipChange.ipc$dispatch("-971164388", new Object[]{this, textView2, Integer.valueOf(i)})).intValue();
        }
        int lineCount = textView2.getLineCount();
        int lineHeight = textView2.getLineHeight();
        int height2 = textView2.getHeight();
        int measuredHeight = textView2.getMeasuredHeight();
        if (lineCount > 0 && this.textHeightMap.containsKey(Integer.valueOf(this.current))) {
            if (!this.textHeightMap.get(Integer.valueOf(this.current)).containsKey(Integer.valueOf(lineCount))) {
                this.textHeightMap.get(Integer.valueOf(this.current)).put(Integer.valueOf(lineCount), Integer.valueOf(i));
            } else if (this.textHeightMap.get(Integer.valueOf(this.current)).get(Integer.valueOf(lineCount)).intValue() == 0) {
                this.textHeightMap.get(Integer.valueOf(this.current)).put(Integer.valueOf(lineCount), Integer.valueOf(i));
            }
            int i3 = lineCount - 1;
            if (this.textHeightMap.get(Integer.valueOf(this.current)).containsKey(Integer.valueOf(i3))) {
            }
        }
        z = false;
        if (!(height2 == 0 || measuredHeight == 0 || height2 == measuredHeight)) {
            i2 = Math.abs(height2 - measuredHeight);
        }
        return z ? lineHeight : i2;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        int i3 = 2;
        int i4 = 0;
        int i5 = 1;
        if (AndroidInstantRuntime.support(ipChange, "985607426")) {
            ipChange.ipc$dispatch("985607426", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        if (this.mChildrenViews.get(Integer.valueOf(this.current)) != null) {
            View view = this.mChildrenViews.get(Integer.valueOf(this.current));
            view.measure(i, View.MeasureSpec.makeMeasureSpec(0, 0));
            int measuredHeight = view.getMeasuredHeight();
            if (view instanceof TickletTicketItemView) {
                TextView tipTv = ((TickletTicketItemView) view).getTipTv();
                this.textView = tipTv;
                if (tipTv.getLineCount() <= 1) {
                    i3 = 1;
                }
                i4 = heightMeasure(this.textView, measuredHeight);
            } else {
                if (view instanceof TickletTicketItemDigitalTicketsView) {
                    TextView tipTv2 = ((TickletTicketItemDigitalTicketsView) view).getTipTv();
                    this.textView = tipTv2;
                    if (tipTv2.getLineCount() <= 1) {
                        i3 = 1;
                    }
                    i4 = heightMeasure(this.textView, measuredHeight);
                }
                this.height = measuredHeight + getOffset(i5) + i4;
            }
            i5 = i3;
            this.height = measuredHeight + getOffset(i5) + i4;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.height, 1073741824));
    }

    @Override // androidx.viewpager.widget.ViewPager
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "18010280")) {
            return ((Boolean) ipChange.ipc$dispatch("18010280", new Object[]{this, motionEvent})).booleanValue();
        } else if (!this.scrollble) {
            return true;
        } else {
            return super.onTouchEvent(motionEvent);
        }
    }

    public void resetHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1809623432")) {
            ipChange.ipc$dispatch("-1809623432", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.current = i;
        if (!this.textHeightMap.containsKey(Integer.valueOf(i))) {
            this.textHeightMap.put(Integer.valueOf(i), new HashMap<>());
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, this.height);
        } else {
            layoutParams.height = this.height;
        }
        setLayoutParams(layoutParams);
    }

    public void setObjectForPosition(View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1184421417")) {
            ipChange.ipc$dispatch("1184421417", new Object[]{this, view, Integer.valueOf(i)});
            return;
        }
        this.mChildrenViews.put(Integer.valueOf(i), view);
    }

    public AutoResizeViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
