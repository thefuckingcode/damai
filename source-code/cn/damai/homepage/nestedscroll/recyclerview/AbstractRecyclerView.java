package cn.damai.homepage.nestedscroll.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollChild;
import cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollParent;
import cn.damai.homepage.nestedscroll.overscroll.IOverScroll;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Field;

/* compiled from: Taobao */
public abstract class AbstractRecyclerView extends RecyclerView implements NestedScrollChild, NestedScrollParent, IOverScroll {
    private static transient /* synthetic */ IpChange $ipChange = null;
    protected static final float EPSILON = 2.0E-5f;
    protected int mDisabledDirection;
    protected boolean mEatInterceptTouch = true;
    protected boolean mEatTouchEvent = true;
    protected boolean mInterceptTouch = true;
    protected float mLastMotionX;
    protected float mLastMotionY;
    protected int mVelocityY;

    public AbstractRecyclerView(Context context) {
        super(context);
    }

    private Field getFieldRecursively(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "201377333")) {
            return (Field) ipChange.ipc$dispatch("201377333", new Object[]{this, str});
        }
        for (Class<? super Object> superclass = getClass().getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                if (declaredField != null) {
                    return declaredField;
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    @Override // cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollParent, cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollChild
    public boolean acceptNestedFling(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-510133509")) {
            return isAccepted(i);
        }
        return ((Boolean) ipChange.ipc$dispatch("-510133509", new Object[]{this, Integer.valueOf(i)})).booleanValue();
    }

    @Override // cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollParent, cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollChild
    public boolean acceptNestedScroll(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1791162034")) {
            return isAccepted(i);
        }
        return ((Boolean) ipChange.ipc$dispatch("1791162034", new Object[]{this, Integer.valueOf(i)})).booleanValue();
    }

    @Override // cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollParent, cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollChild
    public boolean dispatchNestedFling(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1428608585")) {
            return ((Boolean) ipChange.ipc$dispatch("1428608585", new Object[]{this, Integer.valueOf(i)})).booleanValue();
        } else if (!isAttachedToWindow()) {
            return false;
        } else {
            this.mInterceptTouch = true;
            fling(0, i);
            return acceptNestedFling(i);
        }
    }

    @Override // cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollParent, cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollChild
    public boolean dispatchNestedScroll(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1762624804")) {
            return ((Boolean) ipChange.ipc$dispatch("1762624804", new Object[]{this, Integer.valueOf(i)})).booleanValue();
        } else if (!isAttachedToWindow()) {
            return false;
        } else {
            this.mInterceptTouch = true;
            scrollBy(0, i);
            return acceptNestedScroll(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean fling(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-66738319")) {
            return ((Boolean) ipChange.ipc$dispatch("-66738319", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).booleanValue();
        }
        boolean fling = super.fling(i, i2);
        this.mVelocityY = i2;
        return fling;
    }

    public int getDisabledDirection() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1812683879")) {
            return this.mDisabledDirection;
        }
        return ((Integer) ipChange.ipc$dispatch("1812683879", new Object[]{this})).intValue();
    }

    @Override // cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollChild
    public int getNestedScrollChildHeight() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2064320939")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("2064320939", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    public float invokeCurrentVelocity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "666344059")) {
            return ((Float) ipChange.ipc$dispatch("666344059", new Object[]{this})).floatValue();
        }
        try {
            Field fieldRecursively = getFieldRecursively("mViewFlinger");
            if (fieldRecursively == null) {
                return 0.0f;
            }
            fieldRecursively.setAccessible(true);
            Object obj = fieldRecursively.get(this);
            Field declaredField = obj.getClass().getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            Field declaredField2 = obj2.getClass().getDeclaredField("mScrollerY");
            declaredField2.setAccessible(true);
            Object obj3 = declaredField2.get(obj2);
            Field declaredField3 = obj3.getClass().getDeclaredField("mCurrVelocity");
            declaredField3.setAccessible(true);
            return ((Float) declaredField3.get(obj3)).floatValue();
        } catch (Throwable unused) {
            return 0.0f;
        }
    }

    /* access modifiers changed from: protected */
    public boolean isAccepted(int i) {
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-623838377")) {
            return ((Boolean) ipChange.ipc$dispatch("-623838377", new Object[]{this, Integer.valueOf(i)})).booleanValue();
        }
        return isAttachedToWindow() && ((i2 = this.mDisabledDirection) == 0 || i2 * i < 0);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView
    public void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-236980365")) {
            ipChange.ipc$dispatch("-236980365", new Object[]{this});
            return;
        }
        super.onAttachedToWindow();
        resetScroll();
    }

    @Override // cn.damai.homepage.nestedscroll.overscroll.IOverScroll
    public void onDisabledDirection(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "941114430")) {
            ipChange.ipc$dispatch("941114430", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mDisabledDirection = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        if (r0 != 3) goto L_0x0075;
     */
    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1762480676")) {
            return ((Boolean) ipChange.ipc$dispatch("1762480676", new Object[]{this, motionEvent})).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float rawY = this.mLastMotionY - motionEvent.getRawY();
                    float rawX = this.mLastMotionX - motionEvent.getRawX();
                    float abs = Math.abs(rawY);
                    this.mLastMotionY = motionEvent.getRawY();
                    this.mLastMotionX = motionEvent.getRawX();
                    if (abs > EPSILON && abs > Math.abs(rawX) && !this.mInterceptTouch && this.mDisabledDirection != 0) {
                        this.mEatInterceptTouch = false;
                    }
                }
            }
            this.mEatInterceptTouch = true;
        } else {
            this.mEatInterceptTouch = true;
            this.mLastMotionY = motionEvent.getRawY();
            this.mLastMotionX = motionEvent.getRawX();
        }
        if (!this.mEatInterceptTouch) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollChild
    public void onScrolledByNestedParent(NestedScrollParent nestedScrollParent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-294297757")) {
            ipChange.ipc$dispatch("-294297757", new Object[]{this, nestedScrollParent});
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        if (r0 != 3) goto L_0x0098;
     */
    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1910230400")) {
            return ((Boolean) ipChange.ipc$dispatch("-1910230400", new Object[]{this, motionEvent})).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float rawY = this.mLastMotionY - motionEvent.getRawY();
                    float rawX = this.mLastMotionX - motionEvent.getRawX();
                    float abs = Math.abs(rawY);
                    this.mLastMotionY = motionEvent.getRawY();
                    this.mLastMotionX = motionEvent.getRawX();
                    if (abs > EPSILON && abs - Math.abs(rawX) > EPSILON) {
                        if (!this.mInterceptTouch && (i = this.mDisabledDirection) != 0) {
                            if (this.mEatTouchEvent && ((float) i) * rawY > EPSILON) {
                                this.mEatTouchEvent = false;
                            }
                            if (!this.mEatTouchEvent) {
                                onReachedEdge(Math.round(rawY), 0);
                            }
                        } else if (!this.mEatTouchEvent) {
                            dispatchNestedScroll(Math.round(rawY));
                        }
                    }
                }
            }
            this.mEatTouchEvent = true;
        } else {
            this.mEatTouchEvent = true;
            this.mLastMotionY = motionEvent.getRawY();
            this.mLastMotionX = motionEvent.getRawX();
        }
        if (!this.mEatTouchEvent) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void resetScroll() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1738342483")) {
            ipChange.ipc$dispatch("-1738342483", new Object[]{this});
            return;
        }
        this.mInterceptTouch = true;
        this.mDisabledDirection = 0;
    }

    @Override // cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollParent
    public void setNestedScrollChild(NestedScrollChild nestedScrollChild) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "399739348")) {
            ipChange.ipc$dispatch("399739348", new Object[]{this, nestedScrollChild});
        }
    }

    @Override // cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollChild
    public void setNestedScrollParent(NestedScrollParent nestedScrollParent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1934178984")) {
            ipChange.ipc$dispatch("1934178984", new Object[]{this, nestedScrollParent});
        }
    }

    public AbstractRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AbstractRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
