package com.youku.live.dago.widgetlib.interactive.gift.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: Taobao */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int[] ATTRS = {16842901, 16842904};
    private static final int GOING_LEFT = 1;
    private static final int GOING_RIGHT = 2;
    private static final int IDLE = 0;
    private static final String TAG = "PagerSlidingTabStrip";
    private int currentPosition;
    private float currentPositionOffset;
    private LinearLayout.LayoutParams defaultTabLayoutParams;
    public ViewPager.OnPageChangeListener delegatePageListener;
    private int dividerColor;
    private int dividerPadding;
    private Paint dividerPaint;
    private int dividerWidth;
    private LinearLayout.LayoutParams expandedTabLayoutParams;
    private boolean indicatorCircle;
    private int indicatorCircleRadius;
    private int indicatorColor;
    private int indicatorHeight;
    private boolean indicatorWrap;
    private boolean isIndicatorTop;
    private int lastScrollX;
    private Locale locale;
    private boolean mFadeEnabled;
    private OnPagerTitleItemClickListener mOnPagerTitleItemClickListener;
    private int mPagePosition;
    private String mPageTitle;
    private Paint mPaintTabText;
    private Rect mRectTabText;
    private int mState;
    private int mTabsTextWidth;
    private LinearLayout.LayoutParams matchparentTabLayoutParams;
    private int oldPage;
    private int oldPosition;
    private final PageListener pageListener;
    private ViewPager pager;
    private Paint rectPaint;
    private int scrollOffset;
    private int selectedPosition;
    private boolean selectedTabTextBold;
    private int selectedTabTextColor;
    private boolean shouldExpand;
    private int tabBackgroundResId;
    private int tabCount;
    private int tabPadding;
    private int tabTextColor;
    private int tabTextSize;
    private Typeface tabTypeface;
    private int tabTypefaceStyle;
    private List<Map<String, View>> tabViews;
    private LinearLayout tabsContainer;
    private boolean textAllCaps;
    private int underlineColor;
    private int underlineHeight;
    private float zoomMax;

    /* compiled from: Taobao */
    public interface IconTabProvider {
        int getPageIconResId(int i);
    }

    /* compiled from: Taobao */
    public interface OnPagerTitleItemClickListener {
        void onDoubleClickItem(int i);

        void onSingleClickItem(int i);
    }

    /* compiled from: Taobao */
    public class PageListener implements ViewPager.OnPageChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        private PageListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-858225844")) {
                ipChange.ipc$dispatch("-858225844", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            if (i == 0) {
                PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip.scrollToChild(pagerSlidingTabStrip.pager.getCurrentItem(), 0);
                PagerSlidingTabStrip.this.mFadeEnabled = true;
            }
            ViewPager.OnPageChangeListener onPageChangeListener = PagerSlidingTabStrip.this.delegatePageListener;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "536681451")) {
                ipChange.ipc$dispatch("536681451", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                return;
            }
            PagerSlidingTabStrip.this.currentPosition = i;
            PagerSlidingTabStrip.this.currentPositionOffset = f;
            if (!(PagerSlidingTabStrip.this.tabsContainer == null || PagerSlidingTabStrip.this.tabsContainer.getChildAt(i) == null)) {
                PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip.scrollToChild(i, (int) (((float) pagerSlidingTabStrip.tabsContainer.getChildAt(i).getWidth()) * f));
            }
            PagerSlidingTabStrip.this.invalidate();
            ViewPager.OnPageChangeListener onPageChangeListener = PagerSlidingTabStrip.this.delegatePageListener;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i, f, i2);
            }
            if (PagerSlidingTabStrip.this.mState == 0 && f > 0.0f) {
                PagerSlidingTabStrip pagerSlidingTabStrip2 = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip2.oldPage = pagerSlidingTabStrip2.pager.getCurrentItem();
                PagerSlidingTabStrip pagerSlidingTabStrip3 = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip3.mState = i == pagerSlidingTabStrip3.oldPage ? 2 : 1;
            }
            boolean z = i == PagerSlidingTabStrip.this.oldPage;
            if (PagerSlidingTabStrip.this.mState == 2 && !z) {
                PagerSlidingTabStrip.this.mState = 1;
            } else if (PagerSlidingTabStrip.this.mState == 1 && z) {
                PagerSlidingTabStrip.this.mState = 2;
            }
            if (PagerSlidingTabStrip.this.isSmall(f)) {
                f = 0.0f;
            }
            if (PagerSlidingTabStrip.this.tabsContainer != null) {
                View childAt = PagerSlidingTabStrip.this.tabsContainer.getChildAt(i);
                View childAt2 = PagerSlidingTabStrip.this.tabsContainer.getChildAt(i + 1);
                if (f == 0.0f) {
                    PagerSlidingTabStrip.this.mState = 0;
                }
                if (PagerSlidingTabStrip.this.mFadeEnabled) {
                    PagerSlidingTabStrip.this.animateFadeScale(childAt, childAt2, f, i);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-929443433")) {
                ipChange.ipc$dispatch("-929443433", new Object[]{this, Integer.valueOf(i)});
            } else if (PagerSlidingTabStrip.this.selectedPosition != i) {
                PagerSlidingTabStrip.this.tabSelected(i);
            }
        }
    }

    /* compiled from: Taobao */
    public static class SavedState extends View.BaseSavedState {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class com.youku.live.dago.widgetlib.interactive.gift.view.PagerSlidingTabStrip.SavedState.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "859573317")) {
                    return new SavedState(parcel);
                }
                return (SavedState) ipChange.ipc$dispatch("859573317", new Object[]{this, parcel});
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-1958361616")) {
                    return new SavedState[i];
                }
                return (SavedState[]) ipChange.ipc$dispatch("-1958361616", new Object[]{this, Integer.valueOf(i)});
            }
        };
        int currentPosition;

        public void writeToParcel(Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1694817537")) {
                ipChange.ipc$dispatch("1694817537", new Object[]{this, parcel, Integer.valueOf(i)});
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

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    private void addIconTab(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "900040329")) {
            ipChange.ipc$dispatch("900040329", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        new ImageButton(getContext()).setImageResource(i2);
    }

    private void addTab(final int i, View view, View view2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-232597773")) {
            ipChange.ipc$dispatch("-232597773", new Object[]{this, Integer.valueOf(i), view, view2});
            return;
        }
        view.setFocusable(true);
        view2.setFocusable(true);
        int i2 = this.tabPadding;
        view.setPadding(i2, 0, i2, 0);
        int i3 = this.tabPadding;
        view2.setPadding(i3, 0, i3, 0);
        TitleClickView titleClickView = new TitleClickView(getContext());
        titleClickView.addView(view, 0, this.matchparentTabLayoutParams);
        titleClickView.addView(view2, 1, this.matchparentTabLayoutParams);
        this.tabsContainer.addView(titleClickView, i, this.shouldExpand ? this.expandedTabLayoutParams : this.defaultTabLayoutParams);
        titleClickView.setOnClickListener(new View.OnClickListener() {
            /* class com.youku.live.dago.widgetlib.interactive.gift.view.PagerSlidingTabStrip.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1673953412")) {
                    ipChange.ipc$dispatch("1673953412", new Object[]{this, view});
                    return;
                }
                PagerSlidingTabStrip.this.tabSelected(i);
                PagerSlidingTabStrip.this.mFadeEnabled = false;
                PagerSlidingTabStrip.this.pager.setCurrentItem(i, false);
                PagerSlidingTabStrip.this.currentPosition = i;
                PagerSlidingTabStrip.this.scrollToChild(i, 0);
                if (PagerSlidingTabStrip.this.mOnPagerTitleItemClickListener != null) {
                    PagerSlidingTabStrip.this.mOnPagerTitleItemClickListener.onSingleClickItem(i);
                }
            }
        });
        HashMap hashMap = new HashMap();
        view.setAlpha(1.0f);
        hashMap.put("normal", view);
        view2.setAlpha(0.0f);
        hashMap.put("selected", view2);
        this.tabViews.add(i, hashMap);
    }

    private void addTextTab(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "451362000")) {
            ipChange.ipc$dispatch("451362000", new Object[]{this, Integer.valueOf(i), str});
            return;
        }
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setIncludeFontPadding(false);
        textView.setGravity(17);
        textView.setSingleLine();
        TextView textView2 = new TextView(getContext());
        textView2.setText(str);
        textView2.setIncludeFontPadding(false);
        textView2.setGravity(17);
        textView2.setSingleLine();
        addTab(i, textView, textView2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isSmall(float f) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1024050821")) {
            return ((double) Math.abs(f)) < 1.0E-4d;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1024050821", new Object[]{this, Float.valueOf(f)})).booleanValue();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void scrollToChild(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-880555694")) {
            ipChange.ipc$dispatch("-880555694", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (this.tabCount != 0) {
            int left = this.tabsContainer.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.scrollOffset;
            }
            if (left != this.lastScrollX) {
                this.lastScrollX = left;
                smoothScrollTo(((this.tabsContainer.getChildAt(i).getLeft() + i2) + (this.tabsContainer.getChildAt(i).getMeasuredWidth() / 2)) - (getMeasuredWidth() / 2), 0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void tabSelected(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-848710899")) {
            ipChange.ipc$dispatch("-848710899", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.selectedPosition = i;
        ViewPager.OnPageChangeListener onPageChangeListener = this.delegatePageListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i);
        }
        this.tabViews.get(this.oldPosition).get("normal").setAlpha(1.0f);
        this.tabViews.get(this.oldPosition).get("selected").setAlpha(0.0f);
        View childAt = this.tabsContainer.getChildAt(this.oldPosition);
        childAt.setPivotX(((float) childAt.getMeasuredWidth()) * 0.5f);
        childAt.setPivotY(((float) childAt.getMeasuredHeight()) * 0.5f);
        childAt.setScaleX(1.0f);
        childAt.setScaleY(1.0f);
        if (this.selectedTabTextBold) {
            ((TextView) this.tabViews.get(this.oldPosition).get("normal")).setTypeface(Typeface.defaultFromStyle(0));
            ((TextView) this.tabViews.get(this.oldPosition).get("selected")).setTypeface(Typeface.defaultFromStyle(0));
        }
        this.tabViews.get(i).get("normal").setAlpha(0.0f);
        this.tabViews.get(i).get("selected").setAlpha(1.0f);
        View childAt2 = this.tabsContainer.getChildAt(i);
        childAt2.setPivotX(((float) childAt2.getMeasuredWidth()) * 0.5f);
        childAt2.setPivotY(((float) childAt2.getMeasuredHeight()) * 0.5f);
        childAt2.setScaleX(this.zoomMax + 1.0f);
        childAt2.setScaleY(this.zoomMax + 1.0f);
        if (this.selectedTabTextBold) {
            ((TextView) this.tabViews.get(i).get("normal")).setTypeface(Typeface.defaultFromStyle(0));
            ((TextView) this.tabViews.get(i).get("selected")).setTypeface(Typeface.defaultFromStyle(1));
        }
        this.oldPosition = this.selectedPosition;
    }

    /* access modifiers changed from: protected */
    public void animateFadeScale(View view, View view2, float f, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "931225882")) {
            ipChange.ipc$dispatch("931225882", new Object[]{this, view, view2, Float.valueOf(f), Integer.valueOf(i)});
        } else if (this.mState != 0) {
            if (view != null) {
                this.tabViews.get(i).get("normal").setAlpha(f);
                this.tabViews.get(i).get("selected").setAlpha(1.0f - f);
                float f2 = this.zoomMax;
                float f3 = (f2 + 1.0f) - (f2 * f);
                view.setPivotX(((float) view.getMeasuredWidth()) * 0.5f);
                view.setPivotY(((float) view.getMeasuredHeight()) * 0.5f);
                view.setScaleX(f3);
                view.setScaleY(f3);
            }
            if (view2 != null) {
                int i2 = i + 1;
                this.tabViews.get(i2).get("normal").setAlpha(1.0f - f);
                this.tabViews.get(i2).get("selected").setAlpha(f);
                float f4 = (this.zoomMax * f) + 1.0f;
                view2.setPivotX(((float) view2.getMeasuredWidth()) * 0.5f);
                view2.setPivotY(((float) view2.getMeasuredHeight()) * 0.5f);
                view2.setScaleX(f4);
                view2.setScaleY(f4);
            }
        }
    }

    public int getDividerColor() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1239575353")) {
            return this.dividerColor;
        }
        return ((Integer) ipChange.ipc$dispatch("1239575353", new Object[]{this})).intValue();
    }

    public int getDividerPadding() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "379437771")) {
            return this.dividerPadding;
        }
        return ((Integer) ipChange.ipc$dispatch("379437771", new Object[]{this})).intValue();
    }

    public int getDividerWidth() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "481275382")) {
            return this.dividerWidth;
        }
        return ((Integer) ipChange.ipc$dispatch("481275382", new Object[]{this})).intValue();
    }

    public int getIndicatorColor() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "827995503")) {
            return this.indicatorColor;
        }
        return ((Integer) ipChange.ipc$dispatch("827995503", new Object[]{this})).intValue();
    }

    public int getIndicatorHeight() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "598934999")) {
            return this.indicatorHeight;
        }
        return ((Integer) ipChange.ipc$dispatch("598934999", new Object[]{this})).intValue();
    }

    public int getScrollOffset() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "697051523")) {
            return this.scrollOffset;
        }
        return ((Integer) ipChange.ipc$dispatch("697051523", new Object[]{this})).intValue();
    }

    public int getSelectedTextColor() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "711790770")) {
            return this.selectedTabTextColor;
        }
        return ((Integer) ipChange.ipc$dispatch("711790770", new Object[]{this})).intValue();
    }

    public boolean getShouldExpand() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-920792569")) {
            return this.shouldExpand;
        }
        return ((Boolean) ipChange.ipc$dispatch("-920792569", new Object[]{this})).booleanValue();
    }

    public int getTabBackground() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "211363178")) {
            return this.tabBackgroundResId;
        }
        return ((Integer) ipChange.ipc$dispatch("211363178", new Object[]{this})).intValue();
    }

    public int getTabPaddingLeftRight() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "735265172")) {
            return this.tabPadding;
        }
        return ((Integer) ipChange.ipc$dispatch("735265172", new Object[]{this})).intValue();
    }

    public LinearLayout getTabsContainer() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-661241266")) {
            return this.tabsContainer;
        }
        return (LinearLayout) ipChange.ipc$dispatch("-661241266", new Object[]{this});
    }

    public int getTextColor() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1121865865")) {
            return this.tabTextColor;
        }
        return ((Integer) ipChange.ipc$dispatch("-1121865865", new Object[]{this})).intValue();
    }

    public int getTextSize() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1235551435")) {
            return this.tabTextSize;
        }
        return ((Integer) ipChange.ipc$dispatch("-1235551435", new Object[]{this})).intValue();
    }

    public int getTextWidth(Paint paint, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "485574547")) {
            return ((Integer) ipChange.ipc$dispatch("485574547", new Object[]{this, paint, str})).intValue();
        } else if (str == null || str.length() <= 0) {
            return 0;
        } else {
            int length = str.length();
            float[] fArr = new float[length];
            paint.getTextWidths(str, fArr);
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                i += (int) Math.ceil((double) fArr[i2]);
            }
            return i;
        }
    }

    public int getUnderlineColor() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-560844500")) {
            return this.underlineColor;
        }
        return ((Integer) ipChange.ipc$dispatch("-560844500", new Object[]{this})).intValue();
    }

    public int getUnderlineHeight() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "494567866")) {
            return this.underlineHeight;
        }
        return ((Integer) ipChange.ipc$dispatch("494567866", new Object[]{this})).intValue();
    }

    public boolean isIndicatorTop() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1284493768")) {
            return this.isIndicatorTop;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1284493768", new Object[]{this})).booleanValue();
    }

    public boolean isTextAllCaps() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1178483905")) {
            return this.textAllCaps;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1178483905", new Object[]{this})).booleanValue();
    }

    public void notifyDataSetChanged() {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1089683199")) {
            ipChange.ipc$dispatch("1089683199", new Object[]{this});
            return;
        }
        this.tabsContainer.removeAllViews();
        this.mTabsTextWidth = 10;
        this.tabCount = this.pager.getAdapter().getCount();
        if (this.indicatorWrap) {
            int i2 = 0;
            while (true) {
                i = this.tabCount;
                if (i2 >= i) {
                    break;
                }
                String charSequence = this.pager.getAdapter().getPageTitle(i2).toString();
                this.mPaintTabText.setTextSize((float) this.tabTextSize);
                this.mPaintTabText.getTextBounds(charSequence, 0, charSequence.length(), this.mRectTabText);
                this.mTabsTextWidth += com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.mRectTabText);
                i2++;
            }
            int i3 = this.mTabsTextWidth + (i * 5 * 2);
            this.mTabsTextWidth = i3;
            if (i3 > 0) {
                this.tabPadding = ((DisplayMetrics.getwidthPixels(getResources().getDisplayMetrics()) - this.mTabsTextWidth) / this.tabCount) / 2;
            }
        }
        for (int i4 = 0; i4 < this.tabCount; i4++) {
            if (this.pager.getAdapter() instanceof IconTabProvider) {
                addIconTab(i4, ((IconTabProvider) this.pager.getAdapter()).getPageIconResId(i4));
            } else {
                int i5 = this.mPagePosition;
                if (i5 < 0 || i4 != i5) {
                    addTextTab(i4, this.pager.getAdapter().getPageTitle(i4).toString());
                } else {
                    String str = this.mPageTitle;
                    if (str == null || "".equals(str)) {
                        addTextTab(i4, this.pager.getAdapter().getPageTitle(i4).toString());
                    } else {
                        addTextTab(i4, this.mPageTitle);
                    }
                }
            }
        }
        updateTabStyles();
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.youku.live.dago.widgetlib.interactive.gift.view.PagerSlidingTabStrip.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onGlobalLayout() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "744075493")) {
                    ipChange.ipc$dispatch("744075493", new Object[]{this});
                    return;
                }
                PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip.currentPosition = pagerSlidingTabStrip.pager.getCurrentItem();
                PagerSlidingTabStrip pagerSlidingTabStrip2 = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip2.scrollToChild(pagerSlidingTabStrip2.currentPosition, 0);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "21178009")) {
            ipChange.ipc$dispatch("21178009", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "925150436")) {
            ipChange.ipc$dispatch("925150436", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        if (!(isInEditMode() || this.tabCount == 0)) {
            int height = getHeight();
            this.rectPaint.setColor(this.underlineColor);
            float f = (float) height;
            canvas.drawRect(0.0f, (float) (height - this.underlineHeight), (float) this.tabsContainer.getWidth(), f, this.rectPaint);
            this.rectPaint.setColor(this.indicatorColor);
            View childAt = this.tabsContainer.getChildAt(this.currentPosition);
            float left = (float) childAt.getLeft();
            float right = (float) childAt.getRight();
            float width = (float) childAt.getWidth();
            if (this.currentPositionOffset > 0.0f && (i = this.currentPosition) < this.tabCount - 1) {
                View childAt2 = this.tabsContainer.getChildAt(i + 1);
                float f2 = this.currentPositionOffset;
                left = (((float) childAt2.getLeft()) * f2) + ((1.0f - f2) * left);
                right = (((float) childAt2.getRight()) * f2) + ((1.0f - f2) * right);
            }
            if (this.isIndicatorTop) {
                if (this.indicatorCircle) {
                    int i2 = this.indicatorCircleRadius;
                    canvas.drawCircle(left + (width / 2.0f), (float) (height - i2), (float) i2, this.rectPaint);
                } else {
                    canvas.drawRect(((left + ((float) this.tabPadding)) - 5.0f) + ((float) getPaddingLeft()), (float) childAt.getTop(), (right - ((float) this.tabPadding)) + 5.0f + ((float) getPaddingLeft()), (float) this.indicatorHeight, this.rectPaint);
                }
            } else if (this.indicatorCircle) {
                int i3 = this.indicatorCircleRadius;
                canvas.drawCircle(left + (width / 2.0f), (float) (height - i3), (float) i3, this.rectPaint);
            } else {
                canvas.drawRect(((left + ((float) this.tabPadding)) - 5.0f) + ((float) getPaddingLeft()), (float) (height - this.indicatorHeight), (right - ((float) this.tabPadding)) + 5.0f + ((float) getPaddingLeft()), f, this.rectPaint);
            }
            this.dividerPaint.setColor(this.dividerColor);
            for (int i4 = 0; i4 < this.tabCount - 1; i4++) {
                View childAt3 = this.tabsContainer.getChildAt(i4);
                canvas.drawLine((float) childAt3.getRight(), (float) this.dividerPadding, (float) childAt3.getRight(), (float) (height - this.dividerPadding), this.dividerPaint);
            }
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2096162908")) {
            ipChange.ipc$dispatch("2096162908", new Object[]{this, parcelable});
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.currentPosition = savedState.currentPosition;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2007016151")) {
            return (Parcelable) ipChange.ipc$dispatch("-2007016151", new Object[]{this});
        }
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.currentPosition = this.currentPosition;
        return savedState;
    }

    public void scrollToCurrent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1022343605")) {
            ipChange.ipc$dispatch("1022343605", new Object[]{this});
            return;
        }
        tabSelected(this.currentPosition);
        this.pager.setCurrentItem(this.currentPosition, false);
        scrollToChild(this.currentPosition, 0);
    }

    public void setAllCaps(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "142999024")) {
            ipChange.ipc$dispatch("142999024", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.textAllCaps = z;
    }

    public void setDividerColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1771567735")) {
            ipChange.ipc$dispatch("-1771567735", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.dividerColor = i;
        invalidate();
    }

    public void setDividerColorResource(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1203315785")) {
            ipChange.ipc$dispatch("-1203315785", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.dividerColor = getResources().getColor(i);
        invalidate();
    }

    public void setDividerPadding(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1413909815")) {
            ipChange.ipc$dispatch("1413909815", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.dividerPadding = i;
        invalidate();
    }

    public void setDividerWidth(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "490936940")) {
            ipChange.ipc$dispatch("490936940", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.dividerWidth = i;
    }

    public void setFadeEnabled(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-524263949")) {
            ipChange.ipc$dispatch("-524263949", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mFadeEnabled = z;
    }

    public void setIndicatorColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1860669677")) {
            ipChange.ipc$dispatch("-1860669677", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.indicatorColor = i;
        invalidate();
    }

    public void setIndicatorColorResource(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "23206721")) {
            ipChange.ipc$dispatch("23206721", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.indicatorColor = getResources().getColor(i);
        invalidate();
    }

    public void setIndicatorHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1594693357")) {
            ipChange.ipc$dispatch("-1594693357", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.indicatorHeight = i;
        invalidate();
    }

    public void setIndicatorLineWrap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "876078809")) {
            ipChange.ipc$dispatch("876078809", new Object[]{this});
        }
    }

    public void setIsIndicatorTop(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1883286880")) {
            ipChange.ipc$dispatch("1883286880", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isIndicatorTop = z;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "733905173")) {
            ipChange.ipc$dispatch("733905173", new Object[]{this, onPageChangeListener});
            return;
        }
        this.delegatePageListener = onPageChangeListener;
    }

    public void setOnPagerTitleItemClickListener(OnPagerTitleItemClickListener onPagerTitleItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1600279488")) {
            ipChange.ipc$dispatch("-1600279488", new Object[]{this, onPagerTitleItemClickListener});
            return;
        }
        this.mOnPagerTitleItemClickListener = onPagerTitleItemClickListener;
    }

    public void setPageTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "903249767")) {
            ipChange.ipc$dispatch("903249767", new Object[]{this, str});
            return;
        }
        this.mPageTitle = str;
    }

    public void setScrollOffset(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1409937281")) {
            ipChange.ipc$dispatch("-1409937281", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.scrollOffset = i;
        invalidate();
    }

    public void setSelectedTextColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-213373800")) {
            ipChange.ipc$dispatch("-213373800", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.selectedTabTextColor = i;
    }

    public void setSelectedTextColorResource(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1376945094")) {
            ipChange.ipc$dispatch("1376945094", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.selectedTabTextColor = getResources().getColor(i);
    }

    public void setShouldExpand(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-23480771")) {
            ipChange.ipc$dispatch("-23480771", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.shouldExpand = z;
        notifyDataSetChanged();
    }

    public void setShouldExpand_2(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "447453424")) {
            ipChange.ipc$dispatch("447453424", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.shouldExpand = z;
    }

    public void setTabBackground(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1646397664")) {
            ipChange.ipc$dispatch("1646397664", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.tabBackgroundResId = i;
    }

    public void setTabPaddingLeftRight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1690651382")) {
            ipChange.ipc$dispatch("1690651382", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.tabPadding = i;
    }

    public void setTextColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2045450867")) {
            ipChange.ipc$dispatch("2045450867", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void setTextColorResource(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1208182433")) {
            ipChange.ipc$dispatch("1208182433", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.tabTextColor = getResources().getColor(i);
    }

    public void setTextSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1263393549")) {
            ipChange.ipc$dispatch("1263393549", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.tabTextSize = i;
    }

    public void setTypeface(Typeface typeface, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1271652854")) {
            ipChange.ipc$dispatch("-1271652854", new Object[]{this, typeface, Integer.valueOf(i)});
            return;
        }
        this.tabTypeface = typeface;
        this.tabTypefaceStyle = i;
    }

    public void setUnderlineColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1965036810")) {
            ipChange.ipc$dispatch("-1965036810", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.underlineColor = i;
        invalidate();
    }

    public void setUnderlineColorResource(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1641216988")) {
            ipChange.ipc$dispatch("-1641216988", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.underlineColor = getResources().getColor(i);
        invalidate();
    }

    public void setUnderlineHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-535107184")) {
            ipChange.ipc$dispatch("-535107184", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.underlineHeight = i;
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1572853041")) {
            ipChange.ipc$dispatch("-1572853041", new Object[]{this, viewPager});
            return;
        }
        this.pager = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.addOnPageChangeListener(this.pageListener);
            notifyDataSetChanged();
            return;
        }
        throw new IllegalStateException("ViewPager does not have adapter instance.");
    }

    public void setViewPagerAndTitles(ViewPager viewPager, ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1429978691")) {
            ipChange.ipc$dispatch("1429978691", new Object[]{this, viewPager, arrayList});
            return;
        }
        this.pager = viewPager;
        if (viewPager.getAdapter() != null) {
            this.pager.addOnPageChangeListener(this.pageListener);
            notifyDataSetChanged(arrayList);
            return;
        }
        throw new IllegalStateException("ViewPager does not have adapter instance.");
    }

    public void setmPagePosition(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-627992766")) {
            ipChange.ipc$dispatch("-627992766", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mPagePosition = i;
    }

    public void unSelectedAll() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1800034809")) {
            ipChange.ipc$dispatch("1800034809", new Object[]{this});
            return;
        }
        int size = this.tabViews.size();
        int i = this.selectedPosition;
        if (size > i) {
            this.tabViews.get(i).get("normal").setAlpha(1.0f);
            this.tabViews.get(this.selectedPosition).get("selected").setAlpha(0.0f);
            View childAt = this.tabsContainer.getChildAt(this.selectedPosition);
            childAt.setPivotX(((float) childAt.getMeasuredWidth()) * 0.5f);
            childAt.setPivotY(((float) childAt.getMeasuredHeight()) * 0.5f);
            childAt.setScaleX(1.0f);
            childAt.setScaleY(1.0f);
            if (this.selectedTabTextBold) {
                ((TextView) this.tabViews.get(this.selectedPosition).get("normal")).setTypeface(Typeface.defaultFromStyle(0));
                ((TextView) this.tabViews.get(this.selectedPosition).get("selected")).setTypeface(Typeface.defaultFromStyle(0));
            }
        }
    }

    public void updateTabStyles() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "887078072")) {
            ipChange.ipc$dispatch("887078072", new Object[]{this});
            return;
        }
        for (int i = 0; i < this.tabCount; i++) {
            FrameLayout frameLayout = (FrameLayout) this.tabsContainer.getChildAt(i);
            frameLayout.setBackgroundResource(this.tabBackgroundResId);
            for (int i2 = 0; i2 < frameLayout.getChildCount(); i2++) {
                View childAt = frameLayout.getChildAt(i2);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, (float) this.tabTextSize);
                    textView.setTypeface(this.tabTypeface, this.tabTypefaceStyle);
                    int i3 = this.tabPadding;
                    textView.setPadding(i3, 0, i3, 0);
                    if (i2 == 0) {
                        textView.setTextColor(this.tabTextColor);
                    } else {
                        textView.setTextColor(this.selectedTabTextColor);
                    }
                    this.tabViews.get(i).get("normal").setAlpha(1.0f);
                    this.tabViews.get(i).get("selected").setAlpha(0.0f);
                    frameLayout.setPivotX(((float) frameLayout.getMeasuredWidth()) * 0.5f);
                    frameLayout.setPivotY(((float) frameLayout.getMeasuredHeight()) * 0.5f);
                    frameLayout.setScaleX(1.0f);
                    frameLayout.setScaleY(1.0f);
                    if (this.textAllCaps) {
                        if (Build.VERSION.SDK_INT >= 14) {
                            textView.setAllCaps(true);
                        } else {
                            textView.setText(textView.getText().toString().toUpperCase(this.locale));
                        }
                    }
                    if (i == this.selectedPosition) {
                        this.tabViews.get(i).get("normal").setAlpha(0.0f);
                        this.tabViews.get(i).get("selected").setAlpha(1.0f);
                        frameLayout.setPivotX(((float) frameLayout.getMeasuredWidth()) * 0.5f);
                        frameLayout.setPivotY(((float) frameLayout.getMeasuredHeight()) * 0.5f);
                        frameLayout.setScaleX(this.zoomMax + 1.0f);
                        frameLayout.setScaleY(this.zoomMax + 1.0f);
                        if (this.selectedTabTextBold) {
                            ((TextView) this.tabViews.get(i).get("normal")).setTypeface(Typeface.defaultFromStyle(0));
                            ((TextView) this.tabViews.get(i).get("selected")).setTypeface(Typeface.defaultFromStyle(1));
                        }
                    }
                }
            }
        }
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.selectedPosition = 0;
        this.currentPosition = 0;
        this.currentPositionOffset = 0.0f;
        this.indicatorColor = -10066330;
        this.underlineColor = 436207616;
        this.dividerColor = 436207616;
        this.shouldExpand = false;
        this.textAllCaps = true;
        this.indicatorWrap = false;
        this.indicatorCircleRadius = 3;
        this.scrollOffset = 52;
        this.isIndicatorTop = false;
        this.indicatorHeight = 8;
        this.underlineHeight = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.dividerWidth = 1;
        this.tabTextSize = 12;
        this.tabTextColor = -10066330;
        this.selectedTabTextColor = -12206054;
        this.tabTypeface = null;
        this.tabTypefaceStyle = 0;
        this.lastScrollX = 0;
        this.tabBackgroundResId = 0;
        this.zoomMax = 0.0f;
        this.mFadeEnabled = false;
        this.tabViews = new ArrayList();
        this.mRectTabText = new Rect();
        this.mPaintTabText = new Paint();
        this.mPagePosition = -1;
        this.oldPosition = 0;
        setFillViewport(true);
        setWillNotDraw(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.tabsContainer = linearLayout;
        linearLayout.setOrientation(0);
        this.tabsContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.tabsContainer);
        android.util.DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.scrollOffset = (int) TypedValue.applyDimension(1, (float) this.scrollOffset, displayMetrics);
        this.indicatorHeight = (int) TypedValue.applyDimension(1, (float) this.indicatorHeight, displayMetrics);
        this.underlineHeight = (int) TypedValue.applyDimension(1, (float) this.underlineHeight, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, (float) this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, (float) this.tabPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, (float) this.dividerWidth, displayMetrics);
        this.tabTextSize = (int) TypedValue.applyDimension(2, (float) this.tabTextSize, displayMetrics);
        this.indicatorCircleRadius = (int) TypedValue.applyDimension(1, (float) this.indicatorCircleRadius, displayMetrics);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
        this.tabTextSize = obtainStyledAttributes.getDimensionPixelSize(0, this.tabTextSize);
        this.tabTextColor = obtainStyledAttributes.getColor(1, this.tabTextColor);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.dago_pgc_pager_sliding_tabstrip);
        this.indicatorColor = obtainStyledAttributes2.getColor(R.styleable.dago_pgc_pager_sliding_tabstrip_indicator_color, this.indicatorColor);
        this.underlineColor = obtainStyledAttributes2.getColor(R.styleable.dago_pgc_pager_sliding_tabstrip_underline_color, this.underlineColor);
        this.dividerColor = obtainStyledAttributes2.getColor(R.styleable.dago_pgc_pager_sliding_tabstrip_divider_color, this.dividerColor);
        this.indicatorHeight = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.dago_pgc_pager_sliding_tabstrip_indicator_height, this.indicatorHeight);
        this.underlineHeight = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.dago_pgc_pager_sliding_tabstrip_underline_height, this.underlineHeight);
        this.dividerWidth = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.dago_pgc_pager_sliding_tabstrip_divider_width, this.dividerWidth);
        this.dividerPadding = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.dago_pgc_pager_sliding_tabstrip_divider_padding, this.dividerPadding);
        this.tabPadding = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.dago_pgc_pager_sliding_tabstrip_tab_padding_leftright, this.tabPadding);
        this.tabBackgroundResId = obtainStyledAttributes2.getResourceId(R.styleable.dago_pgc_pager_sliding_tabstrip_tab_background, this.tabBackgroundResId);
        this.shouldExpand = obtainStyledAttributes2.getBoolean(R.styleable.dago_pgc_pager_sliding_tabstrip_should_expand, this.shouldExpand);
        this.scrollOffset = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.dago_pgc_pager_sliding_tabstrip_scroll_offset, this.scrollOffset);
        this.textAllCaps = obtainStyledAttributes2.getBoolean(R.styleable.dago_pgc_pager_sliding_tabstrip_text_all_caps, this.textAllCaps);
        this.selectedTabTextColor = obtainStyledAttributes2.getColor(R.styleable.dago_pgc_pager_sliding_tabstrip_selected_text_color, this.selectedTabTextColor);
        this.tabTextColor = obtainStyledAttributes2.getColor(R.styleable.dago_pgc_pager_sliding_tabstrip_defalut_text_color, this.tabTextColor);
        this.tabTextSize = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.dago_pgc_pager_sliding_tabstrip_text_size, this.tabTextSize);
        this.zoomMax = obtainStyledAttributes2.getFloat(R.styleable.dago_pgc_pager_sliding_tabstrip_scale_zoom_max, this.zoomMax);
        this.indicatorWrap = obtainStyledAttributes2.getBoolean(R.styleable.dago_pgc_pager_sliding_tabstrip_indicator_wrap, this.indicatorWrap);
        this.selectedTabTextBold = obtainStyledAttributes2.getBoolean(R.styleable.dago_pgc_pager_sliding_tabstrip_selected_textbold, this.selectedTabTextBold);
        this.indicatorCircle = obtainStyledAttributes2.getBoolean(R.styleable.dago_pgc_pager_sliding_tabstrip_indicator_circle, this.indicatorCircle);
        this.indicatorCircleRadius = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.dago_pgc_pager_sliding_tabstrip_indicator_circle_radius, this.indicatorCircleRadius);
        obtainStyledAttributes2.recycle();
        Paint paint = new Paint();
        this.rectPaint = paint;
        paint.setAntiAlias(true);
        this.rectPaint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.dividerPaint = paint2;
        paint2.setAntiAlias(true);
        this.dividerPaint.setStrokeWidth((float) this.dividerWidth);
        this.defaultTabLayoutParams = new LinearLayout.LayoutParams(-2, -1);
        this.matchparentTabLayoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.expandedTabLayoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        this.pageListener = new PageListener();
        this.mPaintTabText.setAntiAlias(true);
    }

    public void notifyDataSetChanged(ArrayList<String> arrayList) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1071710219")) {
            ipChange.ipc$dispatch("1071710219", new Object[]{this, arrayList});
            return;
        }
        this.mTabsTextWidth = 10;
        this.tabsContainer.removeAllViews();
        this.tabCount = this.pager.getAdapter().getCount();
        if (this.indicatorWrap) {
            int i2 = 0;
            while (true) {
                i = this.tabCount;
                if (i2 >= i) {
                    break;
                }
                String charSequence = this.pager.getAdapter().getPageTitle(i2).toString();
                this.mPaintTabText.setTextSize((float) this.tabTextSize);
                this.mPaintTabText.getTextBounds(charSequence, 0, charSequence.length(), this.mRectTabText);
                this.mTabsTextWidth += com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.mRectTabText);
                i2++;
            }
            int i3 = this.mTabsTextWidth + (i * 5 * 2);
            this.mTabsTextWidth = i3;
            if (i3 > 0) {
                this.tabPadding = ((DisplayMetrics.getwidthPixels(getResources().getDisplayMetrics()) - this.mTabsTextWidth) / this.tabCount) / 2;
            }
        }
        for (int i4 = 0; i4 < this.tabCount; i4++) {
            if (this.pager.getAdapter() instanceof IconTabProvider) {
                addIconTab(i4, ((IconTabProvider) this.pager.getAdapter()).getPageIconResId(i4));
            } else {
                addTextTab(i4, arrayList.get(i4));
            }
        }
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.youku.live.dago.widgetlib.interactive.gift.view.PagerSlidingTabStrip.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onGlobalLayout() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "955426406")) {
                    ipChange.ipc$dispatch("955426406", new Object[]{this});
                    return;
                }
                PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip.currentPosition = pagerSlidingTabStrip.pager.getCurrentItem();
                PagerSlidingTabStrip pagerSlidingTabStrip2 = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip2.scrollToChild(pagerSlidingTabStrip2.currentPosition, 0);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
    }
}
