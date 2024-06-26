package cn.damai.ticklet.view;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.annotation.AnimatorRes;
import androidx.annotation.DrawableRes;
import androidx.viewpager.widget.ViewPager;
import cn.damai.member.R$animator;
import cn.damai.member.R$drawable;
import cn.damai.member.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Objects;

/* compiled from: Taobao */
public class CircleIndicator extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int DEFAULT_INDICATOR_WIDTH = 5;
    private Animator mAnimatorIn;
    private Animator mAnimatorOut;
    private int mAnimatorResId = R$animator.scale_with_alpha;
    private int mAnimatorReverseResId = 0;
    private Animator mImmediateAnimatorIn;
    private Animator mImmediateAnimatorOut;
    private int mIndicatorBackgroundResId;
    private int mIndicatorHeight = -1;
    private int mIndicatorMargin = -1;
    private int mIndicatorUnselectedBackgroundResId;
    private int mIndicatorWidth = -1;
    private DataSetObserver mInternalDataSetObserver;
    private final ViewPager.OnPageChangeListener mInternalPageChangeListener;
    private int mLastPosition;
    private ViewPager mViewpager;

    /* compiled from: Taobao */
    public class a extends DataSetObserver {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onChanged() {
            int count;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-778645751")) {
                ipChange.ipc$dispatch("-778645751", new Object[]{this});
                return;
            }
            super.onChanged();
            if (CircleIndicator.this.mViewpager != null && (count = CircleIndicator.this.mViewpager.getAdapter().getCount()) != CircleIndicator.this.getChildCount()) {
                if (CircleIndicator.this.mLastPosition < count) {
                    CircleIndicator circleIndicator = CircleIndicator.this;
                    circleIndicator.mLastPosition = circleIndicator.mViewpager.getCurrentItem();
                } else {
                    CircleIndicator.this.mLastPosition = -1;
                }
                CircleIndicator.this.createIndicators();
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements Interpolator {
        private static transient /* synthetic */ IpChange $ipChange;

        private b(CircleIndicator circleIndicator) {
        }

        public float getInterpolation(float f) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "801461307")) {
                return Math.abs(1.0f - f);
            }
            return ((Float) ipChange.ipc$dispatch("801461307", new Object[]{this, Float.valueOf(f)})).floatValue();
        }
    }

    public CircleIndicator(Context context) {
        super(context);
        int i = R$drawable.white_radius;
        this.mIndicatorBackgroundResId = i;
        this.mIndicatorUnselectedBackgroundResId = i;
        this.mLastPosition = -1;
        this.mInternalPageChangeListener = new ViewPager.OnPageChangeListener() {
            /* class cn.damai.ticklet.view.CircleIndicator.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1531349718")) {
                    ipChange.ipc$dispatch("1531349718", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "591940981")) {
                    ipChange.ipc$dispatch("591940981", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                CircleIndicator circleIndicator;
                View childAt;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-80224863")) {
                    ipChange.ipc$dispatch("-80224863", new Object[]{this, Integer.valueOf(i)});
                } else if (CircleIndicator.this.mViewpager.getAdapter() != null && CircleIndicator.this.mViewpager.getAdapter().getCount() > 0) {
                    if (CircleIndicator.this.mAnimatorIn.isRunning()) {
                        CircleIndicator.this.mAnimatorIn.end();
                        CircleIndicator.this.mAnimatorIn.cancel();
                    }
                    if (CircleIndicator.this.mAnimatorOut.isRunning()) {
                        CircleIndicator.this.mAnimatorOut.end();
                        CircleIndicator.this.mAnimatorOut.cancel();
                    }
                    if (CircleIndicator.this.mLastPosition >= 0 && (childAt = (circleIndicator = CircleIndicator.this).getChildAt(circleIndicator.mLastPosition)) != null) {
                        childAt.setBackgroundResource(CircleIndicator.this.mIndicatorUnselectedBackgroundResId);
                        CircleIndicator.this.mAnimatorIn.setTarget(childAt);
                    }
                    View childAt2 = CircleIndicator.this.getChildAt(i);
                    if (childAt2 != null) {
                        childAt2.setBackgroundResource(CircleIndicator.this.mIndicatorBackgroundResId);
                        CircleIndicator.this.mAnimatorOut.setTarget(childAt2);
                    }
                    CircleIndicator.this.mLastPosition = i;
                }
            }
        };
        this.mInternalDataSetObserver = new a();
        init(context, null);
    }

    private void addIndicator(int i, @DrawableRes int i2, Animator animator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2127336755")) {
            ipChange.ipc$dispatch("-2127336755", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), animator});
            return;
        }
        if (animator.isRunning()) {
            animator.end();
            animator.cancel();
        }
        View view = new View(getContext());
        view.setBackgroundResource(i2);
        addView(view, this.mIndicatorWidth, this.mIndicatorHeight);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (i == 0) {
            int i3 = this.mIndicatorMargin;
            layoutParams.leftMargin = i3;
            layoutParams.rightMargin = i3;
        } else {
            int i4 = this.mIndicatorMargin;
            layoutParams.topMargin = i4;
            layoutParams.bottomMargin = i4;
        }
        view.setLayoutParams(layoutParams);
        animator.setTarget(view);
    }

    private void checkIndicatorConfig(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1650369427")) {
            ipChange.ipc$dispatch("1650369427", new Object[]{this, context});
            return;
        }
        int i = this.mIndicatorWidth;
        if (i < 0) {
            i = dip2px(5.0f);
        }
        this.mIndicatorWidth = i;
        int i2 = this.mIndicatorHeight;
        if (i2 < 0) {
            i2 = dip2px(5.0f);
        }
        this.mIndicatorHeight = i2;
        int i3 = this.mIndicatorMargin;
        if (i3 < 0) {
            i3 = dip2px(5.0f);
        }
        this.mIndicatorMargin = i3;
        int i4 = this.mAnimatorResId;
        if (i4 == 0) {
            i4 = R$animator.scale_with_alpha;
        }
        this.mAnimatorResId = i4;
        this.mAnimatorOut = createAnimatorOut(context);
        Animator createAnimatorOut = createAnimatorOut(context);
        this.mImmediateAnimatorOut = createAnimatorOut;
        createAnimatorOut.setDuration(0);
        this.mAnimatorIn = createAnimatorIn(context);
        Animator createAnimatorIn = createAnimatorIn(context);
        this.mImmediateAnimatorIn = createAnimatorIn;
        createAnimatorIn.setDuration(0);
        int i5 = this.mIndicatorBackgroundResId;
        if (i5 == 0) {
            i5 = R$drawable.white_radius;
        }
        this.mIndicatorBackgroundResId = i5;
        int i6 = this.mIndicatorUnselectedBackgroundResId;
        if (i6 != 0) {
            i5 = i6;
        }
        this.mIndicatorUnselectedBackgroundResId = i5;
    }

    private Animator createAnimatorIn(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1918474657")) {
            return (Animator) ipChange.ipc$dispatch("1918474657", new Object[]{this, context});
        }
        int i = this.mAnimatorReverseResId;
        if (i != 0) {
            return AnimatorInflater.loadAnimator(context, i);
        }
        Animator loadAnimator = AnimatorInflater.loadAnimator(context, this.mAnimatorResId);
        loadAnimator.setInterpolator(new b());
        return loadAnimator;
    }

    private Animator createAnimatorOut(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "381845900")) {
            return AnimatorInflater.loadAnimator(context, this.mAnimatorResId);
        }
        return (Animator) ipChange.ipc$dispatch("381845900", new Object[]{this, context});
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void createIndicators() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-902972258")) {
            ipChange.ipc$dispatch("-902972258", new Object[]{this});
            return;
        }
        removeAllViews();
        int count = this.mViewpager.getAdapter().getCount();
        if (count > 0) {
            int currentItem = this.mViewpager.getCurrentItem();
            int orientation = getOrientation();
            for (int i = 0; i < count; i++) {
                if (currentItem == i) {
                    addIndicator(orientation, this.mIndicatorBackgroundResId, this.mImmediateAnimatorOut);
                } else {
                    addIndicator(orientation, this.mIndicatorUnselectedBackgroundResId, this.mImmediateAnimatorIn);
                }
            }
        }
    }

    private void handleTypedArray(Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        int i = 1;
        if (AndroidInstantRuntime.support(ipChange, "-1808553715")) {
            ipChange.ipc$dispatch("-1808553715", new Object[]{this, context, attributeSet});
        } else if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CircleIndicator);
            this.mIndicatorWidth = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CircleIndicator_ci_width, -1);
            this.mIndicatorHeight = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CircleIndicator_ci_height, -1);
            this.mIndicatorMargin = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CircleIndicator_ci_margin, -1);
            this.mAnimatorResId = obtainStyledAttributes.getResourceId(R$styleable.CircleIndicator_ci_animator, R$animator.scale_with_alpha);
            this.mAnimatorReverseResId = obtainStyledAttributes.getResourceId(R$styleable.CircleIndicator_ci_animator_reverse, 0);
            int resourceId = obtainStyledAttributes.getResourceId(R$styleable.CircleIndicator_ci_drawable, R$drawable.white_radius);
            this.mIndicatorBackgroundResId = resourceId;
            this.mIndicatorUnselectedBackgroundResId = obtainStyledAttributes.getResourceId(R$styleable.CircleIndicator_ci_drawable_unselected, resourceId);
            if (obtainStyledAttributes.getInt(R$styleable.CircleIndicator_ci_orientation, -1) != 1) {
                i = 0;
            }
            setOrientation(i);
            int i2 = obtainStyledAttributes.getInt(R$styleable.CircleIndicator_ci_gravity, -1);
            if (i2 < 0) {
                i2 = 17;
            }
            setGravity(i2);
            obtainStyledAttributes.recycle();
        }
    }

    private void init(Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2076328372")) {
            ipChange.ipc$dispatch("2076328372", new Object[]{this, context, attributeSet});
            return;
        }
        handleTypedArray(context, attributeSet);
        checkIndicatorConfig(context);
    }

    public void configureIndicator(int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "31264814")) {
            ipChange.ipc$dispatch("31264814", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        int i4 = R$animator.scale_with_alpha;
        int i5 = R$drawable.white_radius;
        configureIndicator(i, i2, i3, i4, 0, i5, i5);
    }

    public int dip2px(float f) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "863530756")) {
            return (int) ((f * getResources().getDisplayMetrics().density) + 0.5f);
        }
        return ((Integer) ipChange.ipc$dispatch("863530756", new Object[]{this, Float.valueOf(f)})).intValue();
    }

    public DataSetObserver getDataSetObserver() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2119967707")) {
            return this.mInternalDataSetObserver;
        }
        return (DataSetObserver) ipChange.ipc$dispatch("-2119967707", new Object[]{this});
    }

    @Deprecated
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "724308187")) {
            ipChange.ipc$dispatch("724308187", new Object[]{this, onPageChangeListener});
            return;
        }
        ViewPager viewPager = this.mViewpager;
        Objects.requireNonNull(viewPager, "can not find Viewpager , setViewPager first");
        viewPager.removeOnPageChangeListener(onPageChangeListener);
        this.mViewpager.addOnPageChangeListener(onPageChangeListener);
    }

    public void setViewPager(ViewPager viewPager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1490136427")) {
            ipChange.ipc$dispatch("-1490136427", new Object[]{this, viewPager});
            return;
        }
        this.mViewpager = viewPager;
        if (viewPager != null && viewPager.getAdapter() != null) {
            this.mLastPosition = -1;
            createIndicators();
            this.mViewpager.removeOnPageChangeListener(this.mInternalPageChangeListener);
            this.mViewpager.addOnPageChangeListener(this.mInternalPageChangeListener);
            this.mInternalPageChangeListener.onPageSelected(this.mViewpager.getCurrentItem());
        }
    }

    public void configureIndicator(int i, int i2, int i3, @AnimatorRes int i4, @AnimatorRes int i5, @DrawableRes int i6, @DrawableRes int i7) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-446467602")) {
            ipChange.ipc$dispatch("-446467602", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)});
            return;
        }
        this.mIndicatorWidth = i;
        this.mIndicatorHeight = i2;
        this.mIndicatorMargin = i3;
        this.mAnimatorResId = i4;
        this.mAnimatorReverseResId = i5;
        this.mIndicatorBackgroundResId = i6;
        this.mIndicatorUnselectedBackgroundResId = i7;
        checkIndicatorConfig(getContext());
    }

    public CircleIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i = R$drawable.white_radius;
        this.mIndicatorBackgroundResId = i;
        this.mIndicatorUnselectedBackgroundResId = i;
        this.mLastPosition = -1;
        this.mInternalPageChangeListener = new ViewPager.OnPageChangeListener() {
            /* class cn.damai.ticklet.view.CircleIndicator.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1531349718")) {
                    ipChange.ipc$dispatch("1531349718", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "591940981")) {
                    ipChange.ipc$dispatch("591940981", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                CircleIndicator circleIndicator;
                View childAt;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-80224863")) {
                    ipChange.ipc$dispatch("-80224863", new Object[]{this, Integer.valueOf(i)});
                } else if (CircleIndicator.this.mViewpager.getAdapter() != null && CircleIndicator.this.mViewpager.getAdapter().getCount() > 0) {
                    if (CircleIndicator.this.mAnimatorIn.isRunning()) {
                        CircleIndicator.this.mAnimatorIn.end();
                        CircleIndicator.this.mAnimatorIn.cancel();
                    }
                    if (CircleIndicator.this.mAnimatorOut.isRunning()) {
                        CircleIndicator.this.mAnimatorOut.end();
                        CircleIndicator.this.mAnimatorOut.cancel();
                    }
                    if (CircleIndicator.this.mLastPosition >= 0 && (childAt = (circleIndicator = CircleIndicator.this).getChildAt(circleIndicator.mLastPosition)) != null) {
                        childAt.setBackgroundResource(CircleIndicator.this.mIndicatorUnselectedBackgroundResId);
                        CircleIndicator.this.mAnimatorIn.setTarget(childAt);
                    }
                    View childAt2 = CircleIndicator.this.getChildAt(i);
                    if (childAt2 != null) {
                        childAt2.setBackgroundResource(CircleIndicator.this.mIndicatorBackgroundResId);
                        CircleIndicator.this.mAnimatorOut.setTarget(childAt2);
                    }
                    CircleIndicator.this.mLastPosition = i;
                }
            }
        };
        this.mInternalDataSetObserver = new a();
        init(context, attributeSet);
    }

    public CircleIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2 = R$drawable.white_radius;
        this.mIndicatorBackgroundResId = i2;
        this.mIndicatorUnselectedBackgroundResId = i2;
        this.mLastPosition = -1;
        this.mInternalPageChangeListener = new ViewPager.OnPageChangeListener() {
            /* class cn.damai.ticklet.view.CircleIndicator.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1531349718")) {
                    ipChange.ipc$dispatch("1531349718", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "591940981")) {
                    ipChange.ipc$dispatch("591940981", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                CircleIndicator circleIndicator;
                View childAt;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-80224863")) {
                    ipChange.ipc$dispatch("-80224863", new Object[]{this, Integer.valueOf(i)});
                } else if (CircleIndicator.this.mViewpager.getAdapter() != null && CircleIndicator.this.mViewpager.getAdapter().getCount() > 0) {
                    if (CircleIndicator.this.mAnimatorIn.isRunning()) {
                        CircleIndicator.this.mAnimatorIn.end();
                        CircleIndicator.this.mAnimatorIn.cancel();
                    }
                    if (CircleIndicator.this.mAnimatorOut.isRunning()) {
                        CircleIndicator.this.mAnimatorOut.end();
                        CircleIndicator.this.mAnimatorOut.cancel();
                    }
                    if (CircleIndicator.this.mLastPosition >= 0 && (childAt = (circleIndicator = CircleIndicator.this).getChildAt(circleIndicator.mLastPosition)) != null) {
                        childAt.setBackgroundResource(CircleIndicator.this.mIndicatorUnselectedBackgroundResId);
                        CircleIndicator.this.mAnimatorIn.setTarget(childAt);
                    }
                    View childAt2 = CircleIndicator.this.getChildAt(i);
                    if (childAt2 != null) {
                        childAt2.setBackgroundResource(CircleIndicator.this.mIndicatorBackgroundResId);
                        CircleIndicator.this.mAnimatorOut.setTarget(childAt2);
                    }
                    CircleIndicator.this.mLastPosition = i;
                }
            }
        };
        this.mInternalDataSetObserver = new a();
        init(context, attributeSet);
    }

    @TargetApi(21)
    public CircleIndicator(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        int i3 = R$drawable.white_radius;
        this.mIndicatorBackgroundResId = i3;
        this.mIndicatorUnselectedBackgroundResId = i3;
        this.mLastPosition = -1;
        this.mInternalPageChangeListener = new ViewPager.OnPageChangeListener() {
            /* class cn.damai.ticklet.view.CircleIndicator.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1531349718")) {
                    ipChange.ipc$dispatch("1531349718", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "591940981")) {
                    ipChange.ipc$dispatch("591940981", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                CircleIndicator circleIndicator;
                View childAt;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-80224863")) {
                    ipChange.ipc$dispatch("-80224863", new Object[]{this, Integer.valueOf(i)});
                } else if (CircleIndicator.this.mViewpager.getAdapter() != null && CircleIndicator.this.mViewpager.getAdapter().getCount() > 0) {
                    if (CircleIndicator.this.mAnimatorIn.isRunning()) {
                        CircleIndicator.this.mAnimatorIn.end();
                        CircleIndicator.this.mAnimatorIn.cancel();
                    }
                    if (CircleIndicator.this.mAnimatorOut.isRunning()) {
                        CircleIndicator.this.mAnimatorOut.end();
                        CircleIndicator.this.mAnimatorOut.cancel();
                    }
                    if (CircleIndicator.this.mLastPosition >= 0 && (childAt = (circleIndicator = CircleIndicator.this).getChildAt(circleIndicator.mLastPosition)) != null) {
                        childAt.setBackgroundResource(CircleIndicator.this.mIndicatorUnselectedBackgroundResId);
                        CircleIndicator.this.mAnimatorIn.setTarget(childAt);
                    }
                    View childAt2 = CircleIndicator.this.getChildAt(i);
                    if (childAt2 != null) {
                        childAt2.setBackgroundResource(CircleIndicator.this.mIndicatorBackgroundResId);
                        CircleIndicator.this.mAnimatorOut.setTarget(childAt2);
                    }
                    CircleIndicator.this.mLastPosition = i;
                }
            }
        };
        this.mInternalDataSetObserver = new a();
        init(context, attributeSet);
    }
}
