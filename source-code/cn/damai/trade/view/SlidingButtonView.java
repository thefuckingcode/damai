package cn.damai.trade.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import cn.damai.trade.R$id;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class SlidingButtonView extends HorizontalScrollView {
    private static transient /* synthetic */ IpChange $ipChange;
    private Boolean isOpen;
    private IonSlidingButtonListener mIonSlidingButtonListener;
    private int mScrollWidth;
    private TextView mTextView_Delete;
    private Boolean once;

    /* compiled from: Taobao */
    public interface IonSlidingButtonListener {
        void onDownOrMove(SlidingButtonView slidingButtonView);

        void onMenuIsClosed(SlidingButtonView slidingButtonView);

        void onMenuIsOpen(View view);
    }

    public SlidingButtonView(Context context) {
        this(context, null);
    }

    public void changeScrollx() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1801429265")) {
            ipChange.ipc$dispatch("1801429265", new Object[]{this});
            return;
        }
        int scrollX = getScrollX();
        int i = this.mScrollWidth;
        if (scrollX >= i / 2) {
            smoothScrollTo(i, 0);
            this.isOpen = Boolean.TRUE;
            this.mIonSlidingButtonListener.onMenuIsOpen(this);
            return;
        }
        smoothScrollTo(0, 0);
        this.isOpen = Boolean.FALSE;
        this.mIonSlidingButtonListener.onMenuIsClosed(this);
    }

    public void closeMenu() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1749030635")) {
            ipChange.ipc$dispatch("-1749030635", new Object[]{this});
        } else if (this.isOpen.booleanValue()) {
            smoothScrollTo(0, 0);
            this.isOpen = Boolean.FALSE;
        }
    }

    public void closeMenuNoAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "885793874")) {
            ipChange.ipc$dispatch("885793874", new Object[]{this});
        } else if (this.isOpen.booleanValue()) {
            scrollTo(0, 0);
            this.isOpen = Boolean.FALSE;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2139430175")) {
            ipChange.ipc$dispatch("2139430175", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            scrollTo(0, 0);
            this.mScrollWidth = this.mTextView_Delete.getWidth();
            Log.i("asd", "mScrollWidth:" + this.mScrollWidth);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1479213613")) {
            ipChange.ipc$dispatch("1479213613", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        if (!this.once.booleanValue()) {
            this.mTextView_Delete = (TextView) findViewById(R$id.tv_delete);
            this.once = Boolean.TRUE;
        }
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1002416356")) {
            ipChange.ipc$dispatch("1002416356", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onScrollChanged(i, i2, i3, i4);
        this.mTextView_Delete.setTranslationX((float) (i - this.mScrollWidth));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        if (r0 != 3) goto L_0x0035;
     */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "923146397")) {
            return ((Boolean) ipChange.ipc$dispatch("923146397", new Object[]{this, motionEvent})).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                }
            }
            changeScrollx();
            return true;
        }
        this.mIonSlidingButtonListener.onDownOrMove(this);
        return super.onTouchEvent(motionEvent);
    }

    public void openMenu() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-537127755")) {
            ipChange.ipc$dispatch("-537127755", new Object[]{this});
        } else if (!this.isOpen.booleanValue()) {
            smoothScrollTo(this.mScrollWidth, 0);
            this.isOpen = Boolean.TRUE;
            this.mIonSlidingButtonListener.onMenuIsOpen(this);
        }
    }

    public void setSlidingButtonListener(IonSlidingButtonListener ionSlidingButtonListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2070291092")) {
            ipChange.ipc$dispatch("-2070291092", new Object[]{this, ionSlidingButtonListener});
            return;
        }
        this.mIonSlidingButtonListener = ionSlidingButtonListener;
    }

    public SlidingButtonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Boolean bool = Boolean.FALSE;
        this.isOpen = bool;
        this.once = bool;
        setOverScrollMode(2);
    }
}
