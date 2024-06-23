package cn.damai.commonbusiness.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Locale;
import tb.n42;

/* compiled from: Taobao */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final int[] ATTRS = {16842901, 16842904};
    private boolean checkedTabWidths;
    private int currentPosition;
    private float currentPositionOffset;
    private LinearLayout.LayoutParams defaultTabLayoutParams;
    public ViewPager.OnPageChangeListener delegatePageListener;
    private int dividerColor;
    private int dividerPadding;
    private Paint dividerPaint;
    private int dividerWidth;
    private LinearLayout.LayoutParams expandedTabLayoutParams;
    private int indicatorHeight;
    private int lastPosition;
    private int lastScrollX;
    private int lineWidth;
    private Locale locale;
    private Context mContext;
    private int mTextTypedValue;
    private final PageListener pageListener;
    private ViewPager pager;
    private Paint rectPaint;
    private Paint rectPaintL;
    private int scrollOffset;
    private boolean shouldExpand;
    private int tabBackgroundResId;
    private int tabChooseTextColor;
    private int tabCount;
    private int tabLeftPadding;
    private int tabPadding;
    private int tabRightPadding;
    private int tabSpaceLeftAndRight;
    private int tabTextColor;
    private int tabTextSize;
    private Typeface tabTypeface;
    private int tabTypefaceStyle;
    private LinearLayout tabsContainer;
    private boolean textAllCaps;
    private int underlineColor;
    private int underlineHeight;

    /* compiled from: Taobao */
    public interface IconTabProvider {
        int getPageIconResId(int i);
    }

    /* compiled from: Taobao */
    public class PageListener implements ViewPager.OnPageChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        private PageListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1078650988")) {
                ipChange.ipc$dispatch("-1078650988", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            if (i == 0) {
                PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip.scrollToChild(pagerSlidingTabStrip.pager.getCurrentItem(), 0);
            }
            ViewPager.OnPageChangeListener onPageChangeListener = PagerSlidingTabStrip.this.delegatePageListener;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1867089869")) {
                ipChange.ipc$dispatch("-1867089869", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                return;
            }
            PagerSlidingTabStrip.this.currentPosition = i;
            PagerSlidingTabStrip.this.currentPositionOffset = f;
            PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
            pagerSlidingTabStrip.scrollToChild(i, (int) (((float) pagerSlidingTabStrip.tabsContainer.getChildAt(i).getWidth()) * f));
            PagerSlidingTabStrip.this.invalidate();
            ViewPager.OnPageChangeListener onPageChangeListener = PagerSlidingTabStrip.this.delegatePageListener;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i, f, i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "118333407")) {
                ipChange.ipc$dispatch("118333407", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            PagerSlidingTabStrip.this.setTextStatus(i);
            ViewPager.OnPageChangeListener onPageChangeListener = PagerSlidingTabStrip.this.delegatePageListener;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageSelected(i);
            }
        }

        /* synthetic */ PageListener(PagerSlidingTabStrip pagerSlidingTabStrip, a aVar) {
            this();
        }
    }

    /* compiled from: Taobao */
    public static class SavedState extends View.BaseSavedState {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int currentPosition;

        /* compiled from: Taobao */
        public class a implements Parcelable.Creator<SavedState> {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "1427435819")) {
                    return new SavedState(parcel, null);
                }
                return (SavedState) ipChange.ipc$dispatch("1427435819", new Object[]{this, parcel});
            }

            /* renamed from: b */
            public SavedState[] newArray(int i) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "188122992")) {
                    return new SavedState[i];
                }
                return (SavedState[]) ipChange.ipc$dispatch("188122992", new Object[]{this, Integer.valueOf(i)});
            }
        }

        /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        public void writeToParcel(Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1109189815")) {
                ipChange.ipc$dispatch("-1109189815", new Object[]{this, parcel, Integer.valueOf(i)});
                return;
            }
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.currentPosition);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.currentPosition = parcel.readInt();
        }
    }

    /* compiled from: Taobao */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @SuppressLint({"NewApi"})
        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1100655405")) {
                ipChange.ipc$dispatch("1100655405", new Object[]{this});
                return;
            }
            if (Build.VERSION.SDK_INT < 16) {
                PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            } else {
                PagerSlidingTabStrip.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
            pagerSlidingTabStrip.currentPosition = pagerSlidingTabStrip.pager.getCurrentItem();
            PagerSlidingTabStrip pagerSlidingTabStrip2 = PagerSlidingTabStrip.this;
            pagerSlidingTabStrip2.scrollToChild(pagerSlidingTabStrip2.currentPosition, 0);
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;

        b(int i) {
            this.a = i;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "610439883")) {
                ipChange.ipc$dispatch("610439883", new Object[]{this, view});
                return;
            }
            PagerSlidingTabStrip.this.pager.setCurrentItem(this.a);
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;

        c(int i) {
            this.a = i;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1573237044")) {
                ipChange.ipc$dispatch("-1573237044", new Object[]{this, view});
                return;
            }
            PagerSlidingTabStrip.this.pager.setCurrentItem(this.a);
        }
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
        this.mContext = context;
    }

    private void addIconTab(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-691084079")) {
            ipChange.ipc$dispatch("-691084079", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setFocusable(true);
        imageButton.setImageResource(i2);
        imageButton.setOnClickListener(new c(i));
        this.tabsContainer.addView(imageButton);
    }

    private void addTextTab(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1427294328")) {
            ipChange.ipc$dispatch("-1427294328", new Object[]{this, Integer.valueOf(i), str});
            return;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setGravity(17);
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setFocusable(true);
        textView.setGravity(17);
        textView.setSingleLine();
        linearLayout.addView(textView);
        linearLayout.setOnClickListener(new b(i));
        this.tabsContainer.addView(linearLayout);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void scrollToChild(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1486251530")) {
            ipChange.ipc$dispatch("1486251530", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (this.tabCount != 0) {
            int left = this.tabsContainer.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.scrollOffset;
            }
            if (left != this.lastScrollX) {
                this.lastScrollX = left;
                scrollTo(left, 0);
            }
        }
    }

    private void setTabTextColor(int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-441681620")) {
            ipChange.ipc$dispatch("-441681620", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
            return;
        }
        TextView textView = (TextView) ((LinearLayout) this.tabsContainer.getChildAt(i)).getChildAt(0);
        if (z) {
            if (textView != null) {
                textView.setTextColor(this.tabChooseTextColor);
            }
        } else if (textView != null) {
            textView.setTextColor(this.tabTextColor);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setTextStatus(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2068613306")) {
            ipChange.ipc$dispatch("-2068613306", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        int i2 = this.lastPosition;
        if (i != i2) {
            if (i2 != -1) {
                setTabTextColor(i2, false);
            }
            setTabTextColor(i, true);
            this.lastPosition = i;
            return;
        }
        setTabTextColor(i, true);
    }

    private void updateTabStyles() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1041082000")) {
            ipChange.ipc$dispatch("-1041082000", new Object[]{this});
            return;
        }
        int i = this.tabPadding;
        if (!this.shouldExpand) {
            i += this.tabSpaceLeftAndRight;
        }
        for (int i2 = 0; i2 < this.tabCount; i2++) {
            View childAt = this.tabsContainer.getChildAt(i2);
            childAt.setLayoutParams(this.defaultTabLayoutParams);
            childAt.setBackgroundResource(this.tabBackgroundResId);
            if (this.shouldExpand) {
                childAt.setPadding(0, 0, 0, 0);
            } else if (i2 == 0) {
                childAt.setPadding(this.tabPadding + this.tabLeftPadding, 0, i, 0);
            } else if (i2 == this.tabCount - 1) {
                childAt.setPadding(i, 0, this.tabPadding + this.tabRightPadding, 0);
            } else {
                childAt.setPadding(i, 0, i, 0);
            }
            if (childAt instanceof LinearLayout) {
                TextView textView = (TextView) ((LinearLayout) childAt).getChildAt(0);
                if (this.mTextTypedValue == 0) {
                    textView.setTextSize(0, (float) this.tabTextSize);
                } else {
                    textView.setTextSize(1, (float) this.tabTextSize);
                }
                textView.setTypeface(this.tabTypeface, this.tabTypefaceStyle);
                textView.setTextColor(this.tabTextColor);
                textView.setText(textView.getText().toString());
            }
        }
    }

    public int getDividerColor() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-688584719")) {
            return this.dividerColor;
        }
        return ((Integer) ipChange.ipc$dispatch("-688584719", new Object[]{this})).intValue();
    }

    public int getDividerPadding() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1451486845")) {
            return this.dividerPadding;
        }
        return ((Integer) ipChange.ipc$dispatch("-1451486845", new Object[]{this})).intValue();
    }

    public int getIndicatorHeight() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-325153249")) {
            return this.indicatorHeight;
        }
        return ((Integer) ipChange.ipc$dispatch("-325153249", new Object[]{this})).intValue();
    }

    public int getLineWidth() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "205325379")) {
            return this.lineWidth;
        }
        return ((Integer) ipChange.ipc$dispatch("205325379", new Object[]{this})).intValue();
    }

    public int getScrollOffset() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1231108549")) {
            return this.scrollOffset;
        }
        return ((Integer) ipChange.ipc$dispatch("-1231108549", new Object[]{this})).intValue();
    }

    public boolean getShouldExpand() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1446014655")) {
            return this.shouldExpand;
        }
        return ((Boolean) ipChange.ipc$dispatch("1446014655", new Object[]{this})).booleanValue();
    }

    public int getTabBackground() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "567943090")) {
            return this.tabBackgroundResId;
        }
        return ((Integer) ipChange.ipc$dispatch("567943090", new Object[]{this})).intValue();
    }

    public int getTabPaddingLeftRight() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "129066460")) {
            return this.tabPadding;
        }
        return ((Integer) ipChange.ipc$dispatch("129066460", new Object[]{this})).intValue();
    }

    public int getTextColor() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1581977023")) {
            return this.tabTextColor;
        }
        return ((Integer) ipChange.ipc$dispatch("1581977023", new Object[]{this})).intValue();
    }

    public int getTextSize() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "652784621")) {
            return this.tabTextSize;
        }
        return ((Integer) ipChange.ipc$dispatch("652784621", new Object[]{this})).intValue();
    }

    public int getUnderlineColor() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1903198180")) {
            return this.underlineColor;
        }
        return ((Integer) ipChange.ipc$dispatch("1903198180", new Object[]{this})).intValue();
    }

    public int getUnderlineHeight() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-429520382")) {
            return this.underlineHeight;
        }
        return ((Integer) ipChange.ipc$dispatch("-429520382", new Object[]{this})).intValue();
    }

    public boolean isTextAllCaps() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1036266999")) {
            return this.textAllCaps;
        }
        return ((Boolean) ipChange.ipc$dispatch("1036266999", new Object[]{this})).booleanValue();
    }

    public void notifyDataSetChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2099107143")) {
            ipChange.ipc$dispatch("2099107143", new Object[]{this});
            return;
        }
        this.tabsContainer.removeAllViews();
        if (this.pager.getAdapter() != null) {
            this.tabCount = this.pager.getAdapter().getCount();
            for (int i = 0; i < this.tabCount; i++) {
                if (this.pager.getAdapter() instanceof IconTabProvider) {
                    addIconTab(i, ((IconTabProvider) this.pager.getAdapter()).getPageIconResId(i));
                } else {
                    addTextTab(i, this.pager.getAdapter().getPageTitle(i).toString());
                }
            }
            updateTabStyles();
            setTextStatus(this.pager.getCurrentItem());
            this.checkedTabWidths = false;
            getViewTreeObserver().addOnGlobalLayoutListener(new a());
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x013d  */
    public void onDraw(Canvas canvas) {
        float f;
        float f2;
        int i;
        float f3;
        float f4;
        LinearGradient linearGradient;
        float f5;
        float f6;
        int i2;
        float f7;
        float f8;
        int i3;
        int i4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-577316452")) {
            ipChange.ipc$dispatch("-577316452", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        if (!isInEditMode() && this.tabCount != 0) {
            int height = getHeight();
            View childAt = this.tabsContainer.getChildAt(this.currentPosition);
            if (!this.shouldExpand) {
                float left = (float) (childAt.getLeft() + getPaddingLeft());
                float right = (float) (childAt.getRight() + getPaddingRight());
                int i5 = this.currentPosition;
                if (i5 == 0) {
                    f2 = right - ((float) this.tabSpaceLeftAndRight);
                    f = left + ((float) this.tabLeftPadding);
                } else {
                    if (i5 == this.tabCount - 1) {
                        f = left + ((float) this.tabSpaceLeftAndRight);
                        i4 = this.tabRightPadding;
                    } else {
                        i4 = this.tabSpaceLeftAndRight;
                        f = left + ((float) i4);
                    }
                    f2 = right - ((float) i4);
                }
                if (this.currentPositionOffset > -1.0f && i5 < this.tabCount - 1) {
                    int i6 = i5 + 1;
                    View childAt2 = this.tabsContainer.getChildAt(i6);
                    float left2 = (float) (childAt2.getLeft() + getPaddingLeft());
                    float right2 = (float) (childAt2.getRight() + getPaddingRight());
                    if (i6 == 0) {
                        f8 = right2 - ((float) this.tabSpaceLeftAndRight);
                        f7 = left2 + ((float) this.tabLeftPadding);
                    } else {
                        if (i6 == this.tabCount - 1) {
                            f7 = left2 + ((float) this.tabSpaceLeftAndRight);
                            i3 = this.tabRightPadding;
                        } else {
                            i3 = this.tabSpaceLeftAndRight;
                            f7 = left2 + ((float) i3);
                        }
                        f8 = right2 - ((float) i3);
                    }
                    float f9 = this.currentPositionOffset;
                    f = (f7 * f9) + ((1.0f - f9) * f);
                    f5 = f8 * f9;
                    f6 = 1.0f - f9;
                }
                i = this.indicatorHeight;
                if (i <= 0 || i >= height) {
                    i = n42.a(this.mContext, 1.0f);
                }
                if (getLineWidth() > 0) {
                    float f10 = f2 - f;
                    if (f10 > ((float) getLineWidth())) {
                        float lineWidth2 = (f + (f10 / 2.0f)) - ((float) (getLineWidth() / 2));
                        f4 = lineWidth2;
                        f3 = ((float) getLineWidth()) + lineWidth2;
                        linearGradient = new LinearGradient(f4, (float) (height - i), f3, (float) height, -46418, -65298, Shader.TileMode.MIRROR);
                        this.rectPaintL.setShader(linearGradient);
                        float f11 = (float) height;
                        canvas.drawRect(f4, (float) (height - i), f3, f11, this.rectPaintL);
                        this.rectPaint.setColor(this.underlineColor);
                        canvas.drawRect(0.0f, (float) (height - 1), (float) this.tabsContainer.getWidth(), f11, this.rectPaint);
                    }
                }
                linearGradient = new LinearGradient(f, (float) (height - i), f2, (float) height, -46418, 16711918, Shader.TileMode.MIRROR);
                f3 = f2;
                f4 = f;
                this.rectPaintL.setShader(linearGradient);
                float f112 = (float) height;
                canvas.drawRect(f4, (float) (height - i), f3, f112, this.rectPaintL);
                this.rectPaint.setColor(this.underlineColor);
                canvas.drawRect(0.0f, (float) (height - 1), (float) this.tabsContainer.getWidth(), f112, this.rectPaint);
            }
            if (childAt instanceof LinearLayout) {
                int width = (childAt.getWidth() - ((LinearLayout) childAt).getChildAt(0).getWidth()) / 2;
                f2 = (float) (childAt.getRight() - width);
                f = (float) (childAt.getLeft() + width);
            } else {
                f2 = 0.0f;
                f = 0.0f;
            }
            if (this.currentPositionOffset > -1.0f && (i2 = this.currentPosition) < this.tabCount - 1) {
                View childAt3 = this.tabsContainer.getChildAt(i2 + 1);
                int width2 = (childAt3.getWidth() - ((LinearLayout) childAt3).getChildAt(0).getWidth()) / 2;
                float f12 = this.currentPositionOffset;
                f = (((float) (childAt3.getLeft() + width2)) * f12) + ((1.0f - f12) * f);
                f5 = ((float) (childAt3.getRight() - width2)) * f12;
                f6 = 1.0f - f12;
            }
            i = this.indicatorHeight;
            i = n42.a(this.mContext, 1.0f);
            if (getLineWidth() > 0) {
            }
            linearGradient = new LinearGradient(f, (float) (height - i), f2, (float) height, -46418, 16711918, Shader.TileMode.MIRROR);
            f3 = f2;
            f4 = f;
            this.rectPaintL.setShader(linearGradient);
            float f1122 = (float) height;
            canvas.drawRect(f4, (float) (height - i), f3, f1122, this.rectPaintL);
            this.rectPaint.setColor(this.underlineColor);
            canvas.drawRect(0.0f, (float) (height - 1), (float) this.tabsContainer.getWidth(), f1122, this.rectPaint);
            f2 = f5 + (f6 * f2);
            i = this.indicatorHeight;
            i = n42.a(this.mContext, 1.0f);
            if (getLineWidth() > 0) {
            }
            linearGradient = new LinearGradient(f, (float) (height - i), f2, (float) height, -46418, 16711918, Shader.TileMode.MIRROR);
            f3 = f2;
            f4 = f;
            this.rectPaintL.setShader(linearGradient);
            float f11222 = (float) height;
            canvas.drawRect(f4, (float) (height - i), f3, f11222, this.rectPaintL);
            this.rectPaint.setColor(this.underlineColor);
            canvas.drawRect(0.0f, (float) (height - 1), (float) this.tabsContainer.getWidth(), f11222, this.rectPaint);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1567959743")) {
            ipChange.ipc$dispatch("1567959743", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        if (this.shouldExpand && View.MeasureSpec.getMode(i) != 0) {
            int measuredWidth = getMeasuredWidth();
            int i3 = 0;
            for (int i4 = 0; i4 < this.tabCount; i4++) {
                i3 += this.tabsContainer.getChildAt(i4).getMeasuredWidth();
            }
            if (!this.checkedTabWidths && i3 > 0 && measuredWidth > 0) {
                if (i3 <= measuredWidth) {
                    for (int i5 = 0; i5 < this.tabCount; i5++) {
                        this.tabsContainer.getChildAt(i5).setLayoutParams(this.expandedTabLayoutParams);
                    }
                }
                this.checkedTabWidths = true;
            }
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1071280916")) {
            ipChange.ipc$dispatch("1071280916", new Object[]{this, parcelable});
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.currentPosition = savedState.currentPosition;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1687485471")) {
            return (Parcelable) ipChange.ipc$dispatch("-1687485471", new Object[]{this});
        }
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.currentPosition = this.currentPosition;
        return savedState;
    }

    public void setAllCaps(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2031335080")) {
            ipChange.ipc$dispatch("2031335080", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.textAllCaps = z;
    }

    public void setDividerColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1414987823")) {
            ipChange.ipc$dispatch("-1414987823", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.dividerColor = i;
        invalidate();
    }

    public void setDividerColorResource(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "355274239")) {
            ipChange.ipc$dispatch("355274239", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.dividerColor = getResources().getColor(i);
        invalidate();
    }

    public void setDividerPadding(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "489821567")) {
            ipChange.ipc$dispatch("489821567", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.dividerPadding = i;
        invalidate();
    }

    public void setDpTextSize(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1719403842")) {
            ipChange.ipc$dispatch("1719403842", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        this.tabTextColor = i;
        this.tabChooseTextColor = i2;
        this.tabTextSize = i3;
        this.mTextTypedValue = i4;
        updateTabStyles();
    }

    public void setIndicatorHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-176657973")) {
            ipChange.ipc$dispatch("-176657973", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.indicatorHeight = i;
        invalidate();
    }

    public void setLineWidth(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "238706471")) {
            ipChange.ipc$dispatch("238706471", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.lineWidth = i;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "113971149")) {
            ipChange.ipc$dispatch("113971149", new Object[]{this, onPageChangeListener});
            return;
        }
        this.delegatePageListener = onPageChangeListener;
    }

    public void setScrollOffset(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1053357369")) {
            ipChange.ipc$dispatch("-1053357369", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.scrollOffset = i;
        invalidate();
    }

    public void setShouldExpand(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "333099141")) {
            ipChange.ipc$dispatch("333099141", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.shouldExpand = z;
        requestLayout();
    }

    public void setTabBackground(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-184526952")) {
            ipChange.ipc$dispatch("-184526952", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.tabBackgroundResId = i;
    }

    public void setTabPaddingLeftRight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "78360494")) {
            ipChange.ipc$dispatch("78360494", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.tabPadding = i;
        updateTabStyles();
    }

    public void setTextColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-34765525")) {
            ipChange.ipc$dispatch("-34765525", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.tabTextColor = i;
        updateTabStyles();
    }

    public void setTextColorResource(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1859413671")) {
            ipChange.ipc$dispatch("-1859413671", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.tabTextColor = getResources().getColor(i);
        updateTabStyles();
    }

    public void setTextSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-327730859")) {
            ipChange.ipc$dispatch("-327730859", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.tabTextSize = i;
        updateTabStyles();
    }

    public void setTypeface(Typeface typeface, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "485102274")) {
            ipChange.ipc$dispatch("485102274", new Object[]{this, typeface, Integer.valueOf(i)});
            return;
        }
        this.tabTypeface = typeface;
        this.tabTypefaceStyle = i;
        updateTabStyles();
    }

    public void setUnderlineColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1405842238")) {
            ipChange.ipc$dispatch("1405842238", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.underlineColor = i;
        invalidate();
    }

    public void setUnderlineColorResource(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1515177068")) {
            ipChange.ipc$dispatch("1515177068", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.underlineColor = getResources().getColor(i);
        invalidate();
    }

    public void setUnderlineHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "882928200")) {
            ipChange.ipc$dispatch("882928200", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.underlineHeight = i;
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1802869127")) {
            ipChange.ipc$dispatch("1802869127", new Object[]{this, viewPager});
            return;
        }
        this.pager = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.pageListener);
            notifyDataSetChanged();
            return;
        }
        throw new IllegalStateException("ViewPager does not have adapter instance.");
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.mContext = context;
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lastPosition = -1;
        this.lineWidth = -1;
        this.pageListener = new PageListener(this, null);
        this.currentPosition = 0;
        this.currentPositionOffset = 0.0f;
        this.checkedTabWidths = false;
        this.underlineColor = 436207616;
        this.dividerColor = 436207616;
        this.shouldExpand = false;
        this.textAllCaps = true;
        this.scrollOffset = 52;
        this.indicatorHeight = 3;
        this.underlineHeight = 1;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.tabSpaceLeftAndRight = 0;
        this.tabLeftPadding = 0;
        this.tabRightPadding = 0;
        this.dividerWidth = 1;
        this.tabTextSize = 16;
        this.tabTextColor = -7829368;
        this.tabChooseTextColor = -15658735;
        this.tabTypeface = null;
        this.tabTypefaceStyle = 0;
        this.lastScrollX = 0;
        this.tabBackgroundResId = R$color.transparent;
        this.mTextTypedValue = 0;
        this.mContext = context;
        setFillViewport(true);
        setWillNotDraw(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.tabsContainer = linearLayout;
        linearLayout.setOrientation(0);
        this.tabsContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.tabsContainer);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.scrollOffset = (int) TypedValue.applyDimension(1, (float) this.scrollOffset, displayMetrics);
        this.indicatorHeight = (int) TypedValue.applyDimension(1, (float) this.indicatorHeight, displayMetrics);
        this.underlineHeight = (int) TypedValue.applyDimension(1, (float) this.underlineHeight, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, (float) this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, (float) this.tabPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, (float) this.dividerWidth, displayMetrics);
        this.tabTextSize = (int) TypedValue.applyDimension(2, (float) this.tabTextSize, displayMetrics);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
        this.tabTextSize = obtainStyledAttributes.getDimensionPixelSize(0, this.tabTextSize);
        this.tabTextColor = obtainStyledAttributes.getColor(1, this.tabTextColor);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.PagerSlidingTabStrip);
        this.underlineColor = obtainStyledAttributes2.getColor(R$styleable.PagerSlidingTabStrip_underlineColor, this.underlineColor);
        this.dividerColor = obtainStyledAttributes2.getColor(R$styleable.PagerSlidingTabStrip_dividerColor, this.dividerColor);
        this.tabChooseTextColor = obtainStyledAttributes2.getColor(R$styleable.PagerSlidingTabStrip_tabTextChooseColor, this.tabChooseTextColor);
        this.indicatorHeight = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.PagerSlidingTabStrip_indicatorHeight, this.indicatorHeight);
        this.underlineHeight = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.PagerSlidingTabStrip_underlineHeight, this.underlineHeight);
        this.dividerPadding = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.PagerSlidingTabStrip_dividerPaddingTabStrip, this.dividerPadding);
        this.tabPadding = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.PagerSlidingTabStrip_tabStripPaddingLeftRight, this.tabPadding);
        this.tabLeftPadding = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.PagerSlidingTabStrip_leftPadding, this.tabLeftPadding);
        this.tabRightPadding = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.PagerSlidingTabStrip_rightPadding, this.tabRightPadding);
        this.tabSpaceLeftAndRight = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.PagerSlidingTabStrip_tabSpaceLeftAndRight, this.tabSpaceLeftAndRight);
        this.tabBackgroundResId = obtainStyledAttributes2.getResourceId(R$styleable.PagerSlidingTabStrip_tabStripBackground, this.tabBackgroundResId);
        this.shouldExpand = obtainStyledAttributes2.getBoolean(R$styleable.PagerSlidingTabStrip_shouldExpand, this.shouldExpand);
        this.scrollOffset = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.PagerSlidingTabStrip_scrollOffset, this.scrollOffset);
        this.textAllCaps = obtainStyledAttributes2.getBoolean(R$styleable.PagerSlidingTabStrip_textAllCapstabStrip, this.textAllCaps);
        obtainStyledAttributes2.recycle();
        Paint paint = new Paint();
        this.rectPaint = paint;
        paint.setAntiAlias(true);
        this.rectPaint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.rectPaintL = paint2;
        paint2.setAntiAlias(true);
        this.rectPaintL.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint();
        this.dividerPaint = paint3;
        paint3.setAntiAlias(true);
        this.dividerPaint.setStrokeWidth((float) this.dividerWidth);
        this.defaultTabLayoutParams = new LinearLayout.LayoutParams(-2, -1);
        this.expandedTabLayoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }
}
