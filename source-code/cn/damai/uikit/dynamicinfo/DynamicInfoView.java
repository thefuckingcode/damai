package cn.damai.uikit.dynamicinfo;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tb.up2;

/* compiled from: Taobao */
public class DynamicInfoView extends View {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int CACHE_COUNT = 1000;
    private static final int DRAW_INTERVAL = 20;
    private static final float MOVING_DISTANCE = 1.5f;
    private int childCount;
    private int dividerCount;
    private a mCurrentClick;
    private List<a> mCurrentClickList = new ArrayList();
    private Runnable mDrawingTask = new Runnable() {
        /* class cn.damai.uikit.dynamicinfo.DynamicInfoView.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "18804085")) {
                ipChange.ipc$dispatch("18804085", new Object[]{this});
            } else if (!DynamicInfoView.this.mWaitingList.isEmpty() || !DynamicInfoView.this.mRunningList.isEmpty()) {
                int height = DynamicInfoView.this.getHeight();
                int a = up2.a(DynamicInfoView.this.getContext(), 0.45000002f);
                ArrayList arrayList = new ArrayList();
                Iterator it = DynamicInfoView.this.mRunningList.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    int d = aVar.d(DynamicInfoView.this.getContext());
                    aVar.b -= a;
                    int i = d + aVar.b;
                    if (i <= 0) {
                        arrayList.add(aVar);
                    }
                    height = i;
                }
                DynamicInfoView.this.mRunningList.removeAll(arrayList);
                DynamicInfoView.this.mPastedList.addAll(arrayList);
                DynamicInfoView.this.mWaitingList.addAll(arrayList);
                if (DynamicInfoView.this.mPastedList.size() > 1000) {
                    DynamicInfoView.this.mPastedList.remove(0);
                }
                if (height <= DynamicInfoView.this.getBottom() && !DynamicInfoView.this.mWaitingList.isEmpty()) {
                    a aVar2 = (a) DynamicInfoView.this.mWaitingList.getFirst();
                    if (aVar2.d(DynamicInfoView.this.getContext()) + height < DynamicInfoView.this.getHeight()) {
                        height = DynamicInfoView.this.getHeight();
                    }
                    aVar2.b = height + 1;
                    DynamicInfoView.this.mWaitingList.remove(aVar2);
                    DynamicInfoView.this.mRunningList.add(aVar2);
                }
                if (DynamicInfoView.this.mListener != null && (!DynamicInfoView.this.mWaitingList.isEmpty() || !DynamicInfoView.this.mRunningList.isEmpty())) {
                    DynamicInfoView.this.mListener.onDisplayCountdown(DynamicInfoView.this.getDynamicInfoCount());
                }
                if (DynamicInfoView.this.mListener != null && DynamicInfoView.this.mWaitingList.isEmpty() && DynamicInfoView.this.mRunningList.isEmpty()) {
                    DynamicInfoView.this.mListener.onDisplayAll();
                }
                DynamicInfoView.this.invalidate();
                DynamicInfoView dynamicInfoView = DynamicInfoView.this;
                dynamicInfoView.postDelayed(dynamicInfoView.mDrawingTask, 20);
            } else {
                if (DynamicInfoView.this.mListener != null && System.currentTimeMillis() - DynamicInfoView.this.mLastNotifyTimestamp > 3000) {
                    DynamicInfoView.this.mLastNotifyTimestamp = System.currentTimeMillis();
                    DynamicInfoView.this.mListener.onDisplayAll();
                }
                DynamicInfoView dynamicInfoView2 = DynamicInfoView.this;
                dynamicInfoView2.postDelayed(dynamicInfoView2.mDrawingTask, 20);
            }
        }
    };
    private int mInfoIndex;
    private long mLastNotifyTimestamp;
    private DisplayListener mListener;
    private ArrayList<a> mPastedList = new ArrayList<>();
    private ArrayList<a> mRunningList = new ArrayList<>();
    private LinkedList<a> mWaitingList = new LinkedList<>();

    /* compiled from: Taobao */
    public interface DisplayListener {
        void onDisplayAll();

        void onDisplayCountdown(int i);
    }

    /* compiled from: Taobao */
    public static abstract class a<T> {
        private static transient /* synthetic */ IpChange $ipChange;
        protected int a;
        private int b;
        public boolean c;

        /* access modifiers changed from: protected */
        public abstract void c(Canvas canvas, int i);

        /* access modifiers changed from: protected */
        public abstract int d(Context context);
    }

    public DynamicInfoView(Context context) {
        super(context);
    }

    public void addDynamicInfo(a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-198093393")) {
            ipChange.ipc$dispatch("-198093393", new Object[]{this, aVar});
            return;
        }
        this.mWaitingList.add(aVar);
        int i = this.childCount + 1;
        this.childCount = i;
        int i2 = this.dividerCount;
        if (i2 > 0 && i % i2 == 0) {
            aVar.c = true;
        }
        int i3 = this.mInfoIndex;
        this.mInfoIndex = i3 + 1;
        aVar.a = i3;
    }

    public int getDynamicInfoCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "300719816")) {
            return this.mRunningList.size() + this.mWaitingList.size();
        }
        return ((Integer) ipChange.ipc$dispatch("300719816", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "258846799")) {
            ipChange.ipc$dispatch("258846799", new Object[]{this});
            return;
        }
        post(this.mDrawingTask);
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1265881166")) {
            ipChange.ipc$dispatch("-1265881166", new Object[]{this});
            return;
        }
        removeCallbacks(this.mDrawingTask);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-882562517")) {
            ipChange.ipc$dispatch("-882562517", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        Iterator<a> it = this.mRunningList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            next.c(canvas, next.b);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "722475214")) {
            ipChange.ipc$dispatch("722475214", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    }

    public void reset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1559019294")) {
            ipChange.ipc$dispatch("1559019294", new Object[]{this});
            return;
        }
        this.mPastedList.clear();
        this.mRunningList.clear();
        this.mWaitingList.clear();
        this.dividerCount = 0;
        this.childCount = 0;
    }

    public void setDividerCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1674243790")) {
            ipChange.ipc$dispatch("1674243790", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.dividerCount = i;
    }

    public void setOnDisplayListener(DisplayListener displayListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "969142429")) {
            ipChange.ipc$dispatch("969142429", new Object[]{this, displayListener});
            return;
        }
        this.mListener = displayListener;
        if (displayListener != null && getDynamicInfoCount() == 0) {
            this.mLastNotifyTimestamp = System.currentTimeMillis();
            this.mListener.onDisplayAll();
        }
    }

    public DynamicInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
