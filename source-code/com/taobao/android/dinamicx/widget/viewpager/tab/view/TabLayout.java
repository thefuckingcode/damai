package com.taobao.android.dinamicx.widget.viewpager.tab.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import tb.at;

/* compiled from: Taobao */
public class TabLayout extends HorizontalScrollView {
    private static final int ANIMATION_DURATION = 300;
    static final Interpolator DECELERATE_INTERPOLATOR = new DecelerateInterpolator();
    static final int DEFAULT_GAP_TEXT_ICON = 8;
    private static final int DEFAULT_HEIGHT = 48;
    private static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;
    public static final int DEFAULT_INDICATOR_Z_INDEX = 1;
    static final Interpolator FAST_OUT_LINEAR_IN_INTERPOLATOR = new FastOutLinearInInterpolator();
    static final Interpolator FAST_OUT_SLOW_IN_INTERPOLATOR = new FastOutSlowInInterpolator();
    static final int FIXED_WRAP_GUTTER_MIN = 16;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_FILL = 0;
    private static final int INVALID_WIDTH = -1;
    static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    static final Interpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR = new LinearOutSlowInInterpolator();
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    static final int MOTION_NON_ADJACENT_OFFSET = 24;
    private static final int TAB_MIN_WIDTH_MARGIN = 56;
    private static final Pools.Pool<d> sTabPool = new Pools.SynchronizedPool(16);
    private b mAdapterChangeListener;
    private int mContentInsetStart;
    private OnTabSelectedListener mCurrentVpSelectedListener;
    int mMode;
    private final ArrayList<OnTabClickListener> mOnTabClickListeners;
    private TabLayoutOnPageChangeListener mPageChangeListener;
    private PagerAdapter mPagerAdapter;
    private DataSetObserver mPagerAdapterObserver;
    private int mRequestedTabMaxWidth;
    private int mRequestedTabMinWidth;
    private ValueAnimator mScrollAnimator;
    private int mScrollableTabMinWidth;
    private OnTabSelectedListener mSelectedListener;
    private final ArrayList<OnTabSelectedListener> mSelectedListeners;
    private d mSelectedTab;
    private boolean mSetupViewPagerImplicitly;
    int mTabGravity;
    int mTabMaxWidth;
    int mTabPaddingBottom;
    int mTabPaddingEnd;
    int mTabPaddingStart;
    int mTabPaddingTop;
    private final SlidingTabStrip mTabStrip;
    int mTabTextAppearance;
    ColorStateList mTabTextColors;
    float mTabTextMultiLineSize;
    float mTabTextSize;
    private final Pools.Pool<TabView> mTabViewPool;
    private final ArrayList<d> mTabs;
    ViewPager mViewPager;
    boolean mViewPagerSmoothScroll;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* compiled from: Taobao */
    public @interface Mode {
    }

    /* compiled from: Taobao */
    public interface OnTabClickListener {
        void onTabClick(d dVar);
    }

    /* compiled from: Taobao */
    public interface OnTabSelectedListener {
        void onTabReselected(d dVar);

        void onTabSelected(d dVar);

        void onTabUnselected(d dVar);
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class SlidingTabStrip extends LinearLayout {
        private ValueAnimator mIndicatorAnimator;
        private int mIndicatorLeft = -1;
        private int mIndicatorRight = -1;
        private int mLayoutDirection = -1;
        private int mSelectedIndicatorBottomGap;
        private int mSelectedIndicatorHeight;
        private final Paint mSelectedIndicatorPaint;
        private int mSelectedIndicatorRadius;
        private int mSelectedIndicatorWidth;
        private int mSelectedIndicatorZIndex = 1;
        int mSelectedPosition = -1;
        float mSelectionOffset;

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            final /* synthetic */ int a;
            final /* synthetic */ int b;
            final /* synthetic */ int c;
            final /* synthetic */ int d;

            a(int i, int i2, int i3, int i4) {
                this.a = i;
                this.b = i2;
                this.c = i3;
                this.d = i4;
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                SlidingTabStrip.this.setIndicatorPosition(a.a(this.a, this.b, animatedFraction), a.a(this.c, this.d, animatedFraction));
            }
        }

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public class b extends AnimatorListenerAdapter {
            final /* synthetic */ int a;

            b(int i) {
                this.a = i;
            }

            public void onAnimationEnd(Animator animator) {
                SlidingTabStrip slidingTabStrip = SlidingTabStrip.this;
                slidingTabStrip.mSelectedPosition = this.a;
                slidingTabStrip.mSelectionOffset = 0.0f;
            }
        }

        SlidingTabStrip(Context context) {
            super(context);
            setWillNotDraw(false);
            this.mSelectedIndicatorPaint = new Paint();
        }

        private void updateIndicatorPosition() {
            int i;
            int i2;
            View childAt = getChildAt(this.mSelectedPosition);
            if (childAt == null || childAt.getWidth() <= 0) {
                i = -1;
                i2 = -1;
            } else {
                i = childAt.getLeft();
                i2 = childAt.getRight();
                if (this.mSelectionOffset > 0.0f && this.mSelectedPosition < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.mSelectedPosition + 1);
                    float left = this.mSelectionOffset * ((float) childAt2.getLeft());
                    float f = this.mSelectionOffset;
                    i = (int) (left + ((1.0f - f) * ((float) i)));
                    i2 = (int) ((f * ((float) childAt2.getRight())) + ((1.0f - this.mSelectionOffset) * ((float) i2)));
                }
            }
            setIndicatorPosition(i, i2);
        }

        /* access modifiers changed from: package-private */
        public void animateIndicatorToPosition(int i, int i2) {
            int i3;
            int i4;
            ValueAnimator valueAnimator = this.mIndicatorAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.mIndicatorAnimator.cancel();
            }
            boolean z = ViewCompat.getLayoutDirection(this) == 1;
            View childAt = getChildAt(i);
            if (childAt == null) {
                updateIndicatorPosition();
                return;
            }
            int left = childAt.getLeft();
            int right = childAt.getRight();
            if (Math.abs(i - this.mSelectedPosition) <= 1) {
                i4 = this.mIndicatorLeft;
                i3 = this.mIndicatorRight;
            } else {
                int dpToPx = TabLayout.this.dpToPx(24);
                i4 = (i >= this.mSelectedPosition ? !z : z) ? left - dpToPx : dpToPx + right;
                i3 = i4;
            }
            if (i4 != left || i3 != right) {
                ValueAnimator valueAnimator2 = new ValueAnimator();
                this.mIndicatorAnimator = valueAnimator2;
                valueAnimator2.setInterpolator(a.b);
                valueAnimator2.setDuration((long) i2);
                valueAnimator2.setFloatValues(0.0f, 1.0f);
                valueAnimator2.addUpdateListener(new a(i4, left, i3, right));
                valueAnimator2.addListener(new b(i));
                valueAnimator2.start();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean childrenNeedLayout() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        public void draw(Canvas canvas) {
            if (this.mSelectedIndicatorZIndex < 1) {
                drawIndicator(canvas);
            }
            super.draw(canvas);
            if (this.mSelectedIndicatorZIndex >= 1) {
                drawIndicator(canvas);
            }
        }

        /* access modifiers changed from: protected */
        public void drawIndicator(Canvas canvas) {
            int i;
            int i2 = this.mIndicatorLeft;
            if (i2 >= 0 && (i = this.mIndicatorRight) > i2) {
                int i3 = this.mSelectedIndicatorWidth;
                if (i3 > 0 && i - i2 > i3) {
                    int i4 = ((i - i2) - i3) / 2;
                    this.mIndicatorLeft = i2 + i4;
                    this.mIndicatorRight = i - i4;
                }
                RectF rectF = new RectF();
                rectF.left = (float) this.mIndicatorLeft;
                rectF.right = (float) this.mIndicatorRight;
                if (this.mSelectedIndicatorBottomGap > 0) {
                    rectF.top = (float) ((getHeight() - this.mSelectedIndicatorHeight) - this.mSelectedIndicatorBottomGap);
                    rectF.bottom = (float) (getHeight() - this.mSelectedIndicatorBottomGap);
                } else {
                    rectF.top = (float) (getHeight() - this.mSelectedIndicatorHeight);
                    rectF.bottom = (float) getHeight();
                }
                int i5 = this.mSelectedIndicatorRadius;
                if (i5 > 0) {
                    canvas.drawRoundRect(rectF, (float) i5, (float) i5, this.mSelectedIndicatorPaint);
                } else {
                    canvas.drawRect(rectF, this.mSelectedIndicatorPaint);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public float getIndicatorPosition() {
            return ((float) this.mSelectedPosition) + this.mSelectionOffset;
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            ValueAnimator valueAnimator = this.mIndicatorAnimator;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                updateIndicatorPosition();
                return;
            }
            this.mIndicatorAnimator.cancel();
            animateIndicatorToPosition(this.mSelectedPosition, Math.round((1.0f - this.mIndicatorAnimator.getAnimatedFraction()) * ((float) this.mIndicatorAnimator.getDuration())));
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) == 1073741824) {
                TabLayout tabLayout = TabLayout.this;
                boolean z = true;
                if (tabLayout.mMode == 1 && tabLayout.mTabGravity == 1) {
                    int childCount = getChildCount();
                    int i3 = 0;
                    for (int i4 = 0; i4 < childCount; i4++) {
                        View childAt = getChildAt(i4);
                        if (childAt.getVisibility() == 0) {
                            i3 = Math.max(i3, childAt.getMeasuredWidth());
                        }
                    }
                    if (i3 > 0) {
                        if (i3 * childCount <= getMeasuredWidth() - (TabLayout.this.dpToPx(16) * 2)) {
                            boolean z2 = false;
                            for (int i5 = 0; i5 < childCount; i5++) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i5).getLayoutParams();
                                if (layoutParams.width != i3 || layoutParams.weight != 0.0f) {
                                    layoutParams.width = i3;
                                    layoutParams.weight = 0.0f;
                                    z2 = true;
                                }
                            }
                            z = z2;
                        } else {
                            TabLayout tabLayout2 = TabLayout.this;
                            tabLayout2.mTabGravity = 0;
                            tabLayout2.updateTabViews(false);
                        }
                        if (z) {
                            super.onMeasure(i, i2);
                        }
                    }
                }
            }
        }

        public void onRtlPropertiesChanged(int i) {
            super.onRtlPropertiesChanged(i);
            if (Build.VERSION.SDK_INT < 23 && this.mLayoutDirection != i) {
                requestLayout();
                this.mLayoutDirection = i;
            }
        }

        /* access modifiers changed from: package-private */
        public void setIndicatorPosition(int i, int i2) {
            if (i != this.mIndicatorLeft || i2 != this.mIndicatorRight) {
                this.mIndicatorLeft = i;
                this.mIndicatorRight = i2;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void setIndicatorPositionFromTabPosition(int i, float f) {
            ValueAnimator valueAnimator = this.mIndicatorAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.mIndicatorAnimator.cancel();
            }
            this.mSelectedPosition = i;
            this.mSelectionOffset = f;
            updateIndicatorPosition();
        }

        /* access modifiers changed from: package-private */
        public void setSelectedIndicatorColor(int i) {
            if (this.mSelectedIndicatorPaint.getColor() != i) {
                this.mSelectedIndicatorPaint.setColor(i);
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void setSelectedIndicatorHeight(int i) {
            if (this.mSelectedIndicatorHeight != i) {
                this.mSelectedIndicatorHeight = i;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void setSelectedIndicatorWidth(int i) {
            if (this.mSelectedIndicatorWidth != i) {
                this.mSelectedIndicatorWidth = i;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void setSelectedTabIndicatorBottomGap(int i) {
            if (this.mSelectedIndicatorBottomGap != i) {
                this.mSelectedIndicatorBottomGap = i;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void setSelectedTabIndicatorRadius(int i) {
            if (this.mSelectedIndicatorRadius != i) {
                this.mSelectedIndicatorRadius = i;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void setSelectedTabIndicatorZIndex(int i) {
            this.mSelectedIndicatorZIndex = i;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* compiled from: Taobao */
    public @interface TabGravity {
    }

    /* compiled from: Taobao */
    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        private final WeakReference<TabLayout> a;
        private int b;
        private int c;

        public TabLayoutOnPageChangeListener(TabLayout tabLayout) {
            this.a = new WeakReference<>(tabLayout);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.c = 0;
            this.b = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.b = this.c;
            this.c = i;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            boolean z;
            boolean z2;
            TabLayout tabLayout = this.a.get();
            if (tabLayout != null) {
                int i3 = this.c;
                boolean z3 = false;
                boolean z4 = i3 != 2 || this.b == 1;
                boolean z5 = (i3 == 2 && this.b == 0) ? false : true;
                if (at.t0()) {
                    int i4 = this.c;
                    boolean z6 = i4 == 2;
                    if (this.b == 0 && i4 == 0) {
                        z = z6;
                        z2 = false;
                        tabLayout.setScrollPosition(i, f, z3, z2, z, !tabLayout.mViewPagerSmoothScroll);
                    }
                    z = z6;
                    z3 = z4;
                } else {
                    z3 = z4;
                    z = false;
                }
                z2 = z5;
                tabLayout.setScrollPosition(i, f, z3, z2, z, !tabLayout.mViewPagerSmoothScroll);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            TabLayout tabLayout = this.a.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i && i < tabLayout.getTabCount()) {
                int i2 = this.c;
                boolean z = i2 == 0 || (i2 == 2 && this.b == 0);
                d tabAt = tabLayout.getTabAt(i);
                if (tabAt != null) {
                    tabAt.p(false);
                }
                tabLayout.selectTab(tabAt, z);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class TabView extends LinearLayout {
        private ImageView mCustomIconView;
        private TextView mCustomTextView;
        private View mCustomView;
        private int mDefaultMaxLines = 2;
        private ImageView mIconView;
        private d mTab;
        private TextView mTextView;

        public TabView(Context context) {
            super(context);
            ViewCompat.setPaddingRelative(this, TabLayout.this.mTabPaddingStart, TabLayout.this.mTabPaddingTop, TabLayout.this.mTabPaddingEnd, TabLayout.this.mTabPaddingBottom);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        private float approximateLineWidth(Layout layout, int i, float f) {
            return layout.getLineWidth(i) * (f / layout.getPaint().getTextSize());
        }

        private void updateTextAndIcon(@Nullable TextView textView, @Nullable ImageView imageView) {
            d dVar = this.mTab;
            CharSequence charSequence = null;
            Drawable c = dVar != null ? dVar.c() : null;
            d dVar2 = this.mTab;
            CharSequence e = dVar2 != null ? dVar2.e() : null;
            d dVar3 = this.mTab;
            CharSequence a = dVar3 != null ? dVar3.a() : null;
            int i = 0;
            if (imageView != null) {
                if (c != null) {
                    imageView.setImageDrawable(c);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
                imageView.setContentDescription(a);
            }
            boolean z = !TextUtils.isEmpty(e);
            if (textView != null) {
                if (z) {
                    textView.setText(e);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
                textView.setContentDescription(a);
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                if (z && imageView.getVisibility() == 0) {
                    i = TabLayout.this.dpToPx(8);
                }
                if (i != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = i;
                    imageView.requestLayout();
                }
            }
            if (!z) {
                charSequence = a;
            }
            TooltipCompat.setTooltipText(this, charSequence);
        }

        public d getTab() {
            return this.mTab;
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ActionBar.Tab.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ActionBar.Tab.class.getName());
        }

        public void onMeasure(int i, int i2) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i = View.MeasureSpec.makeMeasureSpec(TabLayout.this.mTabMaxWidth, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.mTextView != null) {
                getResources();
                float f = TabLayout.this.mTabTextSize;
                int i3 = this.mDefaultMaxLines;
                ImageView imageView = this.mIconView;
                boolean z = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.mTextView;
                    if (textView != null && textView.getLineCount() > 1) {
                        f = TabLayout.this.mTabTextMultiLineSize;
                    }
                } else {
                    i3 = 1;
                }
                float textSize = this.mTextView.getTextSize();
                int lineCount = this.mTextView.getLineCount();
                int maxLines = TextViewCompat.getMaxLines(this.mTextView);
                int i4 = (f > textSize ? 1 : (f == textSize ? 0 : -1));
                if (i4 != 0 || (maxLines >= 0 && i3 != maxLines)) {
                    if (TabLayout.this.mMode == 1 && i4 > 0 && lineCount == 1 && ((layout = this.mTextView.getLayout()) == null || approximateLineWidth(layout, 0, f) > ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())))) {
                        z = false;
                    }
                    if (z) {
                        this.mTextView.setTextSize(0, f);
                        this.mTextView.setMaxLines(i3);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.mTab == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            this.mTab.h();
            this.mTab.j(true);
            return true;
        }

        /* access modifiers changed from: package-private */
        public void reset() {
            setTab(null);
            setSelected(false);
        }

        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z && Build.VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            TextView textView = this.mTextView;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.mIconView;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.mCustomView;
            if (view != null) {
                view.setSelected(z);
            }
        }

        /* access modifiers changed from: package-private */
        public void setTab(@Nullable d dVar) {
            if (dVar != this.mTab) {
                this.mTab = dVar;
                update();
            }
        }

        /* access modifiers changed from: package-private */
        public final void update() {
            d dVar = this.mTab;
            View b = dVar != null ? dVar.b() : null;
            if (b != null) {
                ViewParent parent = b.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(b);
                    }
                    addView(b);
                }
                this.mCustomView = b;
                TextView textView = this.mTextView;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.mIconView;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.mIconView.setImageDrawable(null);
                }
                TextView textView2 = (TextView) b.findViewById(16908308);
                this.mCustomTextView = textView2;
                if (textView2 != null) {
                    this.mDefaultMaxLines = TextViewCompat.getMaxLines(textView2);
                }
                this.mCustomIconView = (ImageView) b.findViewById(16908294);
            } else {
                View view = this.mCustomView;
                if (view != null) {
                    removeView(view);
                    this.mCustomView = null;
                }
                this.mCustomTextView = null;
                this.mCustomIconView = null;
            }
            boolean z = false;
            if (this.mCustomView == null) {
                if (this.mIconView == null) {
                    ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, (ViewGroup) this, false);
                    addView(imageView2, 0);
                    this.mIconView = imageView2;
                }
                if (this.mTextView == null) {
                    TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, (ViewGroup) this, false);
                    addView(textView3);
                    this.mTextView = textView3;
                    this.mDefaultMaxLines = TextViewCompat.getMaxLines(textView3);
                }
                TextViewCompat.setTextAppearance(this.mTextView, TabLayout.this.mTabTextAppearance);
                ColorStateList colorStateList = TabLayout.this.mTabTextColors;
                if (colorStateList != null) {
                    this.mTextView.setTextColor(colorStateList);
                }
                updateTextAndIcon(this.mTextView, this.mIconView);
            } else {
                TextView textView4 = this.mCustomTextView;
                if (!(textView4 == null && this.mCustomIconView == null)) {
                    updateTextAndIcon(textView4, this.mCustomIconView);
                }
            }
            if (dVar != null && dVar.f()) {
                z = true;
            }
            setSelected(z);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class b implements ViewPager.OnAdapterChangeListener {
        private boolean a;

        b() {
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z) {
            this.a = z;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.mViewPager == viewPager) {
                tabLayout.setPagerAdapter(pagerAdapter2, this.a);
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class c extends DataSetObserver {
        c() {
        }

        public void onChanged() {
            TabLayout.this.populateFromPagerAdapter();
        }

        public void onInvalidated() {
            TabLayout.this.populateFromPagerAdapter();
        }
    }

    /* compiled from: Taobao */
    public static final class d {
        public static final int INVALID_POSITION = -1;
        private Drawable a;
        private CharSequence b;
        private CharSequence c;
        private int d = -1;
        private View e;
        private boolean f;
        TabLayout g;
        TabView h;

        d() {
        }

        @Nullable
        public CharSequence a() {
            return this.c;
        }

        @Nullable
        public View b() {
            return this.e;
        }

        @Nullable
        public Drawable c() {
            return this.a;
        }

        public int d() {
            return this.d;
        }

        @Nullable
        public CharSequence e() {
            return this.b;
        }

        public boolean f() {
            TabLayout tabLayout = this.g;
            if (tabLayout != null) {
                return tabLayout.getSelectedTabPosition() == this.d;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public boolean g() {
            return this.f;
        }

        public void h() {
            TabLayout tabLayout = this.g;
            if (tabLayout != null) {
                tabLayout.onTabClick(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        /* access modifiers changed from: package-private */
        public void i() {
            this.g = null;
            this.h = null;
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = -1;
            this.e = null;
        }

        public void j(boolean z) {
            if (this.g != null) {
                p(z);
                this.g.selectTab(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public d k(@Nullable CharSequence charSequence) {
            this.c = charSequence;
            r();
            return this;
        }

        @NonNull
        public d l(@LayoutRes int i) {
            return m(LayoutInflater.from(this.h.getContext()).inflate(i, (ViewGroup) this.h, false));
        }

        @NonNull
        public d m(@Nullable View view) {
            this.e = view;
            r();
            return this;
        }

        @NonNull
        public d n(@Nullable Drawable drawable) {
            this.a = drawable;
            r();
            return this;
        }

        /* access modifiers changed from: package-private */
        public void o(int i) {
            this.d = i;
        }

        public void p(boolean z) {
            this.f = z;
        }

        @NonNull
        public d q(@Nullable CharSequence charSequence) {
            this.b = charSequence;
            r();
            return this;
        }

        /* access modifiers changed from: package-private */
        public void r() {
            TabView tabView = this.h;
            if (tabView != null) {
                tabView.update();
            }
        }
    }

    /* compiled from: Taobao */
    public static class e implements OnTabSelectedListener {
        private final ViewPager a;
        private final boolean b;

        public e(ViewPager viewPager, boolean z) {
            this.a = viewPager;
            this.b = z;
        }

        @Override // com.taobao.android.dinamicx.widget.viewpager.tab.view.TabLayout.OnTabSelectedListener
        public void onTabReselected(d dVar) {
        }

        @Override // com.taobao.android.dinamicx.widget.viewpager.tab.view.TabLayout.OnTabSelectedListener
        public void onTabSelected(d dVar) {
            if (this.b) {
                this.a.setCurrentItem(dVar.d());
            } else {
                this.a.setCurrentItem(dVar.d(), false);
            }
        }

        @Override // com.taobao.android.dinamicx.widget.viewpager.tab.view.TabLayout.OnTabSelectedListener
        public void onTabUnselected(d dVar) {
        }
    }

    public TabLayout(Context context) {
        this(context, null);
    }

    private void addTabFromItemView(@NonNull TabItem tabItem) {
        d newTab = newTab();
        CharSequence charSequence = tabItem.mText;
        if (charSequence != null) {
            newTab.q(charSequence);
        }
        Drawable drawable = tabItem.mIcon;
        if (drawable != null) {
            newTab.n(drawable);
        }
        int i = tabItem.mCustomLayout;
        if (i != 0) {
            newTab.l(i);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            newTab.k(tabItem.getContentDescription());
        }
        addTab(newTab);
    }

    private void addTabView(d dVar) {
        this.mTabStrip.addView(dVar.h, dVar.d(), createLayoutParamsForTabs());
    }

    private void addViewInternal(View view) {
        if (view instanceof TabItem) {
            addTabFromItemView((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void animateToTab(int i) {
        if (i != -1) {
            if (getWindowToken() == null || !ViewCompat.isLaidOut(this) || this.mTabStrip.childrenNeedLayout()) {
                setScrollPosition(i, 0.0f, true);
                return;
            }
            int scrollX = getScrollX();
            int calculateScrollXForTab = calculateScrollXForTab(i, 0.0f);
            if (scrollX != calculateScrollXForTab) {
                ensureScrollAnimator();
                this.mScrollAnimator.setIntValues(scrollX, calculateScrollXForTab);
                this.mScrollAnimator.start();
            }
            this.mTabStrip.animateIndicatorToPosition(i, 300);
        }
    }

    private void applyModeAndGravity() {
        ViewCompat.setPaddingRelative(this.mTabStrip, this.mMode == 0 ? Math.max(0, this.mContentInsetStart - this.mTabPaddingStart) : 0, 0, 0, 0);
        int i = this.mMode;
        if (i == 0) {
            this.mTabStrip.setGravity(GravityCompat.START);
        } else if (i == 1) {
            this.mTabStrip.setGravity(1);
        }
        updateTabViews(true);
    }

    private int calculateScrollXForTab(int i, float f) {
        int i2 = 0;
        if (this.mMode != 0) {
            return 0;
        }
        View childAt = this.mTabStrip.getChildAt(i);
        int i3 = i + 1;
        View childAt2 = i3 < this.mTabStrip.getChildCount() ? this.mTabStrip.getChildAt(i3) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        if (childAt2 != null) {
            i2 = childAt2.getWidth();
        }
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i4 = (int) (((float) (width + i2)) * 0.5f * f);
        return ViewCompat.getLayoutDirection(this) == 0 ? left + i4 : left - i4;
    }

    private void configureTab(d dVar, int i) {
        dVar.o(i);
        this.mTabs.add(i, dVar);
        int size = this.mTabs.size();
        while (true) {
            i++;
            if (i < size) {
                this.mTabs.get(i).o(i);
            } else {
                return;
            }
        }
    }

    private static ColorStateList createColorStateList(int i, int i2) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i2, i});
    }

    private LinearLayout.LayoutParams createLayoutParamsForTabs() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        updateTabViewLayoutParams(layoutParams);
        return layoutParams;
    }

    private TabView createTabView(@NonNull d dVar) {
        Pools.Pool<TabView> pool = this.mTabViewPool;
        TabView acquire = pool != null ? pool.acquire() : null;
        if (acquire == null) {
            acquire = new TabView(getContext());
        }
        acquire.setTab(dVar);
        acquire.setFocusable(true);
        return acquire;
    }

    private void dispatchTabReselected(@NonNull d dVar) {
        for (int size = this.mSelectedListeners.size() - 1; size >= 0; size--) {
            this.mSelectedListeners.get(size).onTabReselected(dVar);
        }
    }

    private void dispatchTabSelected(@NonNull d dVar) {
        for (int size = this.mSelectedListeners.size() - 1; size >= 0; size--) {
            this.mSelectedListeners.get(size).onTabSelected(dVar);
        }
    }

    private void dispatchTabUnselected(@NonNull d dVar) {
        for (int size = this.mSelectedListeners.size() - 1; size >= 0; size--) {
            this.mSelectedListeners.get(size).onTabUnselected(dVar);
        }
    }

    private void ensureScrollAnimator() {
        if (this.mScrollAnimator == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.mScrollAnimator = valueAnimator;
            valueAnimator.setInterpolator(a.a);
            this.mScrollAnimator.setDuration(300L);
            this.mScrollAnimator.addUpdateListener(new a());
        }
    }

    private int getDefaultHeight() {
        int size = this.mTabs.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i < size) {
                d dVar = this.mTabs.get(i);
                if (dVar != null && dVar.c() != null && !TextUtils.isEmpty(dVar.e())) {
                    z = true;
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        return z ? 72 : 48;
    }

    private float getScrollPosition() {
        return this.mTabStrip.getIndicatorPosition();
    }

    private int getTabMinWidth() {
        int i = this.mRequestedTabMinWidth;
        if (i != -1) {
            return i;
        }
        if (this.mMode == 0) {
            return this.mScrollableTabMinWidth;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.mTabStrip.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void removeTabViewAt(int i) {
        TabView tabView = (TabView) this.mTabStrip.getChildAt(i);
        this.mTabStrip.removeViewAt(i);
        if (tabView != null) {
            tabView.reset();
            this.mTabViewPool.release(tabView);
        }
        requestLayout();
    }

    private void setSelectedTabView(int i) {
        int childCount = this.mTabStrip.getChildCount();
        if (i < childCount) {
            int i2 = 0;
            while (i2 < childCount) {
                this.mTabStrip.getChildAt(i2).setSelected(i2 == i);
                i2++;
            }
        }
    }

    private void updateAllTabs() {
        int size = this.mTabs.size();
        for (int i = 0; i < size; i++) {
            this.mTabs.get(i).r();
        }
    }

    private void updateTabViewLayoutParams(LinearLayout.LayoutParams layoutParams) {
        if (this.mMode == 1 && this.mTabGravity == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    public void addOnTabClickListener(@NonNull OnTabClickListener onTabClickListener) {
        if (!this.mOnTabClickListeners.contains(onTabClickListener)) {
            this.mOnTabClickListeners.add(onTabClickListener);
        }
    }

    public void addOnTabSelectedListener(@NonNull OnTabSelectedListener onTabSelectedListener) {
        if (!this.mSelectedListeners.contains(onTabSelectedListener)) {
            this.mSelectedListeners.add(onTabSelectedListener);
        }
    }

    public void addTab(@NonNull d dVar) {
        addTab(dVar, this.mTabs.isEmpty());
    }

    public void addView(View view) {
        addViewInternal(view);
    }

    public void clearOnTabClickListeners() {
        this.mOnTabClickListeners.clear();
    }

    public void clearOnTabSelectedListeners() {
        this.mSelectedListeners.clear();
    }

    /* access modifiers changed from: package-private */
    public int dpToPx(int i) {
        return Math.round(getResources().getDisplayMetrics().density * ((float) i));
    }

    public int getSelectedTabPosition() {
        d dVar = this.mSelectedTab;
        if (dVar != null) {
            return dVar.d();
        }
        return -1;
    }

    @Nullable
    public d getTabAt(int i) {
        if (i < 0 || i >= getTabCount()) {
            return null;
        }
        return this.mTabs.get(i);
    }

    public int getTabCount() {
        return this.mTabs.size();
    }

    public int getTabGravity() {
        return this.mTabGravity;
    }

    /* access modifiers changed from: package-private */
    public int getTabMaxWidth() {
        return this.mTabMaxWidth;
    }

    public int getTabMode() {
        return this.mMode;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.mTabTextColors;
    }

    @NonNull
    public d newTab() {
        d acquire = sTabPool.acquire();
        if (acquire == null) {
            acquire = new d();
        }
        acquire.g = this;
        acquire.h = createTabView(acquire);
        return acquire;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mViewPager == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                setupWithViewPager((ViewPager) parent, true, true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mSetupViewPagerImplicitly) {
            setupWithViewPager(null);
            this.mSetupViewPagerImplicitly = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        d dVar;
        super.onLayout(z, i, i2, i3, i4);
        if (this.mMode == 0 && (dVar = this.mSelectedTab) != null && dVar.d() > 0) {
            selectTab(this.mSelectedTab);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0067, code lost:
        if (r1.getMeasuredWidth() != getMeasuredWidth()) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0072, code lost:
        if (r1.getMeasuredWidth() < getMeasuredWidth()) goto L_0x0076;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    public void onMeasure(int i, int i2) {
        int dpToPx = dpToPx(getDefaultHeight()) + getPaddingTop() + getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(dpToPx, View.MeasureSpec.getSize(i2)), 1073741824);
        } else if (mode == 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(dpToPx, 1073741824);
        }
        int size = View.MeasureSpec.getSize(i);
        if (View.MeasureSpec.getMode(i) != 0) {
            int i3 = this.mRequestedTabMaxWidth;
            if (i3 <= 0) {
                i3 = size - dpToPx(56);
            }
            this.mTabMaxWidth = i3;
        }
        super.onMeasure(i, i2);
        boolean z = true;
        if (getChildCount() == 1) {
            boolean z2 = false;
            View childAt = getChildAt(0);
            int i4 = this.mMode;
            if (i4 != 0) {
                if (i4 == 1) {
                }
                if (!z2) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), HorizontalScrollView.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
                    return;
                }
                return;
            }
            z = false;
            z2 = z;
            if (!z2) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void onTabClick(d dVar) {
        for (int i = 0; i < this.mOnTabClickListeners.size(); i++) {
            this.mOnTabClickListeners.get(i).onTabClick(dVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void populateFromPagerAdapter() {
        int currentItem;
        removeAllTabs();
        PagerAdapter pagerAdapter = this.mPagerAdapter;
        if (pagerAdapter != null) {
            int count = pagerAdapter.getCount();
            for (int i = 0; i < count; i++) {
                addTab(newTab().q(this.mPagerAdapter.getPageTitle(i)), false);
            }
            ViewPager viewPager = this.mViewPager;
            if (viewPager != null && count > 0 && (currentItem = viewPager.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                d tabAt = getTabAt(currentItem);
                if (tabAt != null) {
                    tabAt.p(false);
                }
                selectTab(tabAt);
            }
        }
    }

    public void removeAllTabs() {
        for (int childCount = this.mTabStrip.getChildCount() - 1; childCount >= 0; childCount--) {
            removeTabViewAt(childCount);
        }
        Iterator<d> it = this.mTabs.iterator();
        while (it.hasNext()) {
            d next = it.next();
            it.remove();
            next.i();
            sTabPool.release(next);
        }
        this.mSelectedTab = null;
    }

    public void removeOnTabClickListener(@NonNull OnTabClickListener onTabClickListener) {
        this.mOnTabClickListeners.remove(onTabClickListener);
    }

    public void removeOnTabSelectedListener(@NonNull OnTabSelectedListener onTabSelectedListener) {
        this.mSelectedListeners.remove(onTabSelectedListener);
    }

    public void removeTab(d dVar) {
        if (dVar.g == this) {
            removeTabAt(dVar.d());
            return;
        }
        throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
    }

    public void removeTabAt(int i) {
        d dVar = this.mSelectedTab;
        int d2 = dVar != null ? dVar.d() : 0;
        removeTabViewAt(i);
        d remove = this.mTabs.remove(i);
        if (remove != null) {
            remove.i();
            sTabPool.release(remove);
        }
        int size = this.mTabs.size();
        for (int i2 = i; i2 < size; i2++) {
            this.mTabs.get(i2).o(i2);
        }
        if (d2 == i) {
            d dVar2 = this.mTabs.isEmpty() ? null : this.mTabs.get(Math.max(0, i - 1));
            if (dVar2 != null) {
                dVar2.p(false);
            }
            selectTab(dVar2);
        }
    }

    public void selectTab(d dVar) {
        selectTab(dVar, true);
    }

    /* access modifiers changed from: package-private */
    public void setPagerAdapter(@Nullable PagerAdapter pagerAdapter, boolean z) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.mPagerAdapter;
        if (!(pagerAdapter2 == null || (dataSetObserver = this.mPagerAdapterObserver) == null)) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.mPagerAdapter = pagerAdapter;
        if (z && pagerAdapter != null) {
            if (this.mPagerAdapterObserver == null) {
                this.mPagerAdapterObserver = new c();
            }
            pagerAdapter.registerDataSetObserver(this.mPagerAdapterObserver);
        }
        populateFromPagerAdapter();
    }

    /* access modifiers changed from: package-private */
    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        ensureScrollAnimator();
        this.mScrollAnimator.addListener(animatorListener);
    }

    public void setScrollPosition(int i, float f, boolean z) {
        setScrollPosition(i, f, z, true);
    }

    public void setSelectedTab(d dVar) {
        this.mSelectedTab = dVar;
    }

    public void setSelectedTabIndicatorBottomGap(int i) {
        this.mTabStrip.setSelectedTabIndicatorBottomGap(i);
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i) {
        this.mTabStrip.setSelectedIndicatorColor(i);
    }

    public void setSelectedTabIndicatorHeight(int i) {
        this.mTabStrip.setSelectedIndicatorHeight(i);
    }

    public void setSelectedTabIndicatorRadius(int i) {
        this.mTabStrip.setSelectedTabIndicatorRadius(i);
    }

    public void setSelectedTabIndicatorWidth(int i) {
        this.mTabStrip.setSelectedIndicatorWidth(i);
    }

    public void setSelectedTabIndicatorZIndex(int i) {
        this.mTabStrip.setSelectedTabIndicatorZIndex(i);
    }

    public void setTabGravity(int i) {
        if (this.mTabGravity != i) {
            this.mTabGravity = i;
            applyModeAndGravity();
        }
    }

    public void setTabMode(int i) {
        if (i != this.mMode) {
            this.mMode = i;
            applyModeAndGravity();
        }
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.mTabTextColors != colorStateList) {
            this.mTabTextColors = colorStateList;
            updateAllTabs();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter) {
        setPagerAdapter(pagerAdapter, false);
    }

    public void setViewPagerSmoothScroll(boolean z) {
        this.mViewPagerSmoothScroll = z;
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        setupWithViewPager(viewPager, true);
    }

    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    /* access modifiers changed from: package-private */
    public void updateTabViews(boolean z) {
        for (int i = 0; i < this.mTabStrip.getChildCount(); i++) {
            View childAt = this.mTabStrip.getChildAt(i);
            childAt.setMinimumWidth(getTabMinWidth());
            updateTabViewLayoutParams((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void addTab(@NonNull d dVar, int i) {
        addTab(dVar, i, this.mTabs.isEmpty());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i) {
        addViewInternal(view);
    }

    @Override // android.widget.FrameLayout, android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    /* access modifiers changed from: package-private */
    public void selectTab(d dVar, boolean z) {
        d dVar2 = this.mSelectedTab;
        if (dVar2 != dVar) {
            int d2 = dVar != null ? dVar.d() : -1;
            if (z) {
                if ((dVar2 == null || dVar2.d() == -1) && d2 != -1) {
                    setScrollPosition(d2, 0.0f, true);
                } else {
                    animateToTab(d2);
                }
                if (d2 != -1) {
                    setSelectedTabView(d2);
                }
            }
            if (dVar2 != null) {
                dispatchTabUnselected(dVar2);
            }
            this.mSelectedTab = dVar;
            if (dVar != null) {
                dispatchTabSelected(dVar);
            }
        } else if (dVar2 != null) {
            dispatchTabReselected(dVar);
            animateToTab(dVar.d());
        }
    }

    /* access modifiers changed from: package-private */
    public void setScrollPosition(int i, float f, boolean z, boolean z2) {
        setScrollPosition(i, f, z, z2, false, false);
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager, boolean z) {
        setupWithViewPager(viewPager, z, false);
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTabs = new ArrayList<>();
        this.mTabMaxWidth = Integer.MAX_VALUE;
        this.mRequestedTabMinWidth = -1;
        this.mRequestedTabMaxWidth = -1;
        this.mTabGravity = 0;
        this.mMode = 1;
        this.mOnTabClickListeners = new ArrayList<>();
        this.mSelectedListeners = new ArrayList<>();
        this.mTabViewPool = new Pools.SimplePool(12);
        b.a(context);
        setHorizontalScrollBarEnabled(false);
        SlidingTabStrip slidingTabStrip = new SlidingTabStrip(context);
        this.mTabStrip = slidingTabStrip;
        super.addView(slidingTabStrip, 0, new FrameLayout.LayoutParams(-2, -1));
        Resources resources = getResources();
        this.mTabTextMultiLineSize = (float) resources.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
        this.mScrollableTabMinWidth = resources.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
        applyModeAndGravity();
    }

    private void setupWithViewPager(@Nullable ViewPager viewPager, boolean z, boolean z2) {
        ViewPager viewPager2 = this.mViewPager;
        if (viewPager2 != null) {
            TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener = this.mPageChangeListener;
            if (tabLayoutOnPageChangeListener != null) {
                viewPager2.removeOnPageChangeListener(tabLayoutOnPageChangeListener);
            }
            b bVar = this.mAdapterChangeListener;
            if (bVar != null) {
                this.mViewPager.removeOnAdapterChangeListener(bVar);
            }
        }
        OnTabSelectedListener onTabSelectedListener = this.mCurrentVpSelectedListener;
        if (onTabSelectedListener != null) {
            removeOnTabSelectedListener(onTabSelectedListener);
            this.mCurrentVpSelectedListener = null;
        }
        if (viewPager != null) {
            this.mViewPager = viewPager;
            if (this.mPageChangeListener == null) {
                this.mPageChangeListener = new TabLayoutOnPageChangeListener(this);
            }
            this.mPageChangeListener.a();
            viewPager.addOnPageChangeListener(this.mPageChangeListener);
            e eVar = new e(viewPager, this.mViewPagerSmoothScroll);
            this.mCurrentVpSelectedListener = eVar;
            addOnTabSelectedListener(eVar);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                setPagerAdapter(adapter, z);
            }
            if (this.mAdapterChangeListener == null) {
                this.mAdapterChangeListener = new b();
            }
            this.mAdapterChangeListener.a(z);
            viewPager.addOnAdapterChangeListener(this.mAdapterChangeListener);
            setScrollPosition(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.mViewPager = null;
            setPagerAdapter(null, false);
        }
        this.mSetupViewPagerImplicitly = z2;
    }

    public void addTab(@NonNull d dVar, boolean z) {
        addTab(dVar, this.mTabs.size(), z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    /* access modifiers changed from: package-private */
    public void setScrollPosition(int i, float f, boolean z, boolean z2, boolean z3, boolean z4) {
        int round = Math.round(((float) i) + f);
        if (z3 && round != getSelectedTabPosition()) {
            round = getSelectedTabPosition();
        }
        if (round >= 0 && round < this.mTabStrip.getChildCount()) {
            if (z2) {
                this.mTabStrip.setIndicatorPositionFromTabPosition(i, f);
            }
            ValueAnimator valueAnimator = this.mScrollAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.mScrollAnimator.cancel();
            }
            int scrollX = getScrollX();
            int calculateScrollXForTab = calculateScrollXForTab(i, f);
            if (!z4) {
                scrollTo(calculateScrollXForTab(i, f), 0);
            } else if (scrollX != calculateScrollXForTab) {
                ensureScrollAnimator();
                this.mScrollAnimator.setIntValues(scrollX, calculateScrollXForTab);
                this.mScrollAnimator.start();
            }
            if (z) {
                setSelectedTabView(round);
            }
        }
    }

    public void addTab(@NonNull d dVar, int i, boolean z) {
        if (dVar.g == this) {
            configureTab(dVar, i);
            addTabView(dVar);
            if (z) {
                dVar.j(false);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    public void setTabTextColors(int i, int i2) {
        setTabTextColors(createColorStateList(i, i2));
    }
}
