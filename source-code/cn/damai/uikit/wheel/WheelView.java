package cn.damai.uikit.wheel;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import cn.damai.uikit.R$color;
import cn.damai.uikit.wheel.WheelScroller;
import cn.damai.uikit.wheel.adapters.WheelViewAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.LinkedList;
import java.util.List;
import tb.mz2;
import tb.y21;

/* compiled from: Taobao */
public class WheelView extends View {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int DEF_VISIBLE_ITEMS = 5;
    private static final int ITEM_OFFSET_PERCENT = 0;
    private static final int PADDING = 10;
    private int[] SHADOWS_COLORS = {-269882903, -806753815, 1072294377};
    private GradientDrawable bottomShadow;
    private Drawable centerDrawable;
    private List<OnWheelChangedListener> changingListeners;
    private List<OnWheelClickedListener> clickingListeners;
    private int currentItem = 0;
    private DataSetObserver dataObserver;
    private boolean drawShadows;
    private int firstItem;
    boolean isCyclic;
    private boolean isScrollingPerformed;
    private int itemHeight = 0;
    private LinearLayout itemsLayout;
    private mz2 recycle;
    private WheelScroller scroller;
    WheelScroller.ScrollingListener scrollingListener;
    private List<OnWheelScrollListener> scrollingListeners;
    private int scrollingOffset;
    private GradientDrawable topShadow;
    private WheelViewAdapter viewAdapter;
    private int visibleItems = 5;
    private int wheelBackground;
    private int wheelForeground;

    /* compiled from: Taobao */
    public class a implements WheelScroller.ScrollingListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.uikit.wheel.WheelScroller.ScrollingListener
        public void onFinished() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "68268117")) {
                ipChange.ipc$dispatch("68268117", new Object[]{this});
                return;
            }
            if (WheelView.this.isScrollingPerformed) {
                WheelView.this.notifyScrollingListenersAboutEnd();
                WheelView.this.isScrollingPerformed = false;
            }
            WheelView.this.scrollingOffset = 0;
            WheelView.this.invalidate();
        }

        @Override // cn.damai.uikit.wheel.WheelScroller.ScrollingListener
        public void onJustify() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1651914221")) {
                ipChange.ipc$dispatch("-1651914221", new Object[]{this});
            } else if (Math.abs(WheelView.this.scrollingOffset) > 1) {
                WheelView.this.scroller.l(WheelView.this.scrollingOffset, 0);
            }
        }

        @Override // cn.damai.uikit.wheel.WheelScroller.ScrollingListener
        public void onScroll(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1547526569")) {
                ipChange.ipc$dispatch("1547526569", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            WheelView.this.doScroll(i);
            int height = WheelView.this.getHeight();
            if (WheelView.this.scrollingOffset > height) {
                WheelView.this.scrollingOffset = height;
                WheelView.this.scroller.p();
                return;
            }
            int i2 = -height;
            if (WheelView.this.scrollingOffset < i2) {
                WheelView.this.scrollingOffset = i2;
                WheelView.this.scroller.p();
            }
        }

        @Override // cn.damai.uikit.wheel.WheelScroller.ScrollingListener
        public void onStarted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-85564798")) {
                ipChange.ipc$dispatch("-85564798", new Object[]{this});
                return;
            }
            WheelView.this.isScrollingPerformed = true;
            WheelView.this.notifyScrollingListenersAboutStart();
        }
    }

    /* compiled from: Taobao */
    public class b extends DataSetObserver {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onChanged() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1159459506")) {
                ipChange.ipc$dispatch("-1159459506", new Object[]{this});
                return;
            }
            WheelView.this.invalidateWheel(false);
        }

        public void onInvalidated() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1218699559")) {
                ipChange.ipc$dispatch("-1218699559", new Object[]{this});
                return;
            }
            WheelView.this.invalidateWheel(true);
        }
    }

    public WheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2 = R$color.white;
        this.wheelBackground = i2;
        this.wheelForeground = i2;
        this.drawShadows = true;
        this.isCyclic = false;
        this.recycle = new mz2(this);
        this.changingListeners = new LinkedList();
        this.scrollingListeners = new LinkedList();
        this.clickingListeners = new LinkedList();
        this.scrollingListener = new a();
        this.dataObserver = new b();
        initData(context);
    }

    private boolean addViewItem(int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1964957427")) {
            return ((Boolean) ipChange.ipc$dispatch("-1964957427", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)})).booleanValue();
        }
        View itemView = getItemView(i);
        if (itemView == null) {
            return false;
        }
        if (z) {
            this.itemsLayout.addView(itemView, 0);
        } else {
            this.itemsLayout.addView(itemView);
        }
        return true;
    }

    private void buildViewForMeasuring() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1008766412")) {
            ipChange.ipc$dispatch("1008766412", new Object[]{this});
            return;
        }
        LinearLayout linearLayout = this.itemsLayout;
        if (linearLayout != null) {
            this.recycle.f(linearLayout, this.firstItem, new y21());
        } else {
            createItemsLayout();
        }
        int i = this.visibleItems / 2;
        for (int i2 = this.currentItem + i; i2 >= this.currentItem - i; i2--) {
            if (addViewItem(i2, true)) {
                this.firstItem = i2;
            }
        }
    }

    private int calculateLayoutWidth(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "165893174")) {
            return ((Integer) ipChange.ipc$dispatch("165893174", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).intValue();
        }
        initResourcesIfNecessary();
        this.itemsLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.itemsLayout.measure(View.MeasureSpec.makeMeasureSpec(i, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = this.itemsLayout.getMeasuredWidth();
        if (i2 != 1073741824) {
            int max = Math.max(measuredWidth + 20, getSuggestedMinimumWidth());
            if (i2 != Integer.MIN_VALUE || i >= max) {
                i = max;
            }
        }
        this.itemsLayout.measure(View.MeasureSpec.makeMeasureSpec(i - 20, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        return i;
    }

    private void createItemsLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-550027165")) {
            ipChange.ipc$dispatch("-550027165", new Object[]{this});
        } else if (this.itemsLayout == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.itemsLayout = linearLayout;
            linearLayout.setOrientation(1);
            this.itemsLayout.setBackgroundResource(this.wheelBackground);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void doScroll(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1666628222")) {
            ipChange.ipc$dispatch("-1666628222", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.scrollingOffset += i;
        int itemHeight2 = getItemHeight();
        int i2 = this.scrollingOffset / itemHeight2;
        int i3 = this.currentItem - i2;
        int itemsCount = this.viewAdapter.getItemsCount();
        int i4 = this.scrollingOffset % itemHeight2;
        if (Math.abs(i4) <= itemHeight2 / 2) {
            i4 = 0;
        }
        if (this.isCyclic && itemsCount > 0) {
            if (i4 > 0) {
                i3--;
                i2++;
            } else if (i4 < 0) {
                i3++;
                i2--;
            }
            while (i3 < 0) {
                i3 += itemsCount;
            }
            i3 %= itemsCount;
        } else if (i3 < 0) {
            i2 = this.currentItem;
            i3 = 0;
        } else if (i3 >= itemsCount) {
            i2 = (this.currentItem - itemsCount) + 1;
            i3 = itemsCount - 1;
        } else if (i3 > 0 && i4 > 0) {
            i3--;
            i2++;
        } else if (i3 < itemsCount - 1 && i4 < 0) {
            i3++;
            i2--;
        }
        int i5 = this.scrollingOffset;
        if (i3 != this.currentItem) {
            setCurrentItem(i3, false);
        } else {
            invalidate();
        }
        int i6 = i5 - (i2 * itemHeight2);
        this.scrollingOffset = i6;
        if (i6 > getHeight()) {
            this.scrollingOffset = (this.scrollingOffset % getHeight()) + getHeight();
        }
    }

    private void drawCenterRect(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1478700695")) {
            ipChange.ipc$dispatch("-1478700695", new Object[]{this, canvas});
            return;
        }
        int height = getHeight() / 2;
        int itemHeight2 = getItemHeight() / 2;
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R$color.color_e7e7e7));
        paint.setStrokeWidth(3.0f);
        float f = (float) (height - itemHeight2);
        canvas.drawLine(0.0f, f, (float) getWidth(), f, paint);
        float f2 = (float) (height + itemHeight2);
        canvas.drawLine(0.0f, f2, (float) getWidth(), f2, paint);
    }

    private void drawItems(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1040443952")) {
            ipChange.ipc$dispatch("-1040443952", new Object[]{this, canvas});
            return;
        }
        canvas.save();
        canvas.translate(10.0f, (float) ((-(((this.currentItem - this.firstItem) * getItemHeight()) + ((getItemHeight() - getHeight()) / 2))) + this.scrollingOffset));
        this.itemsLayout.draw(canvas);
        canvas.restore();
    }

    private int getDesiredHeight(LinearLayout linearLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "950485068")) {
            return ((Integer) ipChange.ipc$dispatch("950485068", new Object[]{this, linearLayout})).intValue();
        }
        if (!(linearLayout == null || linearLayout.getChildAt(0) == null)) {
            this.itemHeight = linearLayout.getChildAt(0).getMeasuredHeight();
        }
        int i = this.itemHeight;
        return Math.max((this.visibleItems * i) - ((i * 0) / 50), getSuggestedMinimumHeight());
    }

    private int getItemHeight() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "463416692")) {
            return ((Integer) ipChange.ipc$dispatch("463416692", new Object[]{this})).intValue();
        }
        int i = this.itemHeight;
        if (i != 0) {
            return i;
        }
        LinearLayout linearLayout = this.itemsLayout;
        if (linearLayout == null || linearLayout.getChildAt(0) == null) {
            return getHeight() / this.visibleItems;
        }
        int height = this.itemsLayout.getChildAt(0).getHeight();
        this.itemHeight = height;
        return height;
    }

    private View getItemView(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "892092322")) {
            return (View) ipChange.ipc$dispatch("892092322", new Object[]{this, Integer.valueOf(i)});
        }
        WheelViewAdapter wheelViewAdapter = this.viewAdapter;
        if (wheelViewAdapter == null || wheelViewAdapter.getItemsCount() == 0) {
            return null;
        }
        int itemsCount = this.viewAdapter.getItemsCount();
        if (!isValidItemIndex(i)) {
            return this.viewAdapter.getEmptyItem(this.recycle.d(), this.itemsLayout);
        }
        while (i < 0) {
            i += itemsCount;
        }
        return this.viewAdapter.getItem(i % itemsCount, this.recycle.e(), this.itemsLayout);
    }

    private y21 getItemsRange() {
        IpChange ipChange = $ipChange;
        int i = 1;
        if (AndroidInstantRuntime.support(ipChange, "1132627958")) {
            return (y21) ipChange.ipc$dispatch("1132627958", new Object[]{this});
        } else if (getItemHeight() == 0) {
            return null;
        } else {
            int i2 = this.currentItem;
            while (getItemHeight() * i < getHeight()) {
                i2--;
                i += 2;
            }
            int i3 = this.scrollingOffset;
            if (i3 != 0) {
                if (i3 > 0) {
                    i2--;
                }
                int itemHeight2 = i3 / getItemHeight();
                i2 -= itemHeight2;
                i = (int) (((double) (i + 1)) + Math.asin((double) itemHeight2));
            }
            return new y21(i2, i);
        }
    }

    private void initData(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-159817751")) {
            ipChange.ipc$dispatch("-159817751", new Object[]{this, context});
            return;
        }
        this.scroller = new WheelScroller(getContext(), this.scrollingListener);
    }

    private void initResourcesIfNecessary() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1061304772")) {
            ipChange.ipc$dispatch("-1061304772", new Object[]{this});
            return;
        }
        if (this.centerDrawable == null) {
            this.centerDrawable = getContext().getResources().getDrawable(this.wheelForeground);
        }
        if (this.topShadow == null) {
            this.topShadow = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.SHADOWS_COLORS);
        }
        if (this.bottomShadow == null) {
            this.bottomShadow = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, this.SHADOWS_COLORS);
        }
        setBackgroundResource(this.wheelBackground);
    }

    private boolean isValidItemIndex(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-408772485")) {
            return ((Boolean) ipChange.ipc$dispatch("-408772485", new Object[]{this, Integer.valueOf(i)})).booleanValue();
        }
        WheelViewAdapter wheelViewAdapter = this.viewAdapter;
        if (wheelViewAdapter != null && wheelViewAdapter.getItemsCount() > 0) {
            if (this.isCyclic) {
                return true;
            }
            if (i < 0 || i >= this.viewAdapter.getItemsCount()) {
                return false;
            }
            return true;
        }
        return false;
    }

    private void layout(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1425498609")) {
            ipChange.ipc$dispatch("-1425498609", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.itemsLayout.layout(0, 0, i - 20, i2);
    }

    private boolean rebuildItems() {
        boolean z;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1793769304")) {
            return ((Boolean) ipChange.ipc$dispatch("1793769304", new Object[]{this})).booleanValue();
        }
        y21 itemsRange = getItemsRange();
        LinearLayout linearLayout = this.itemsLayout;
        if (linearLayout != null) {
            int f = this.recycle.f(linearLayout, this.firstItem, itemsRange);
            z = this.firstItem != f;
            this.firstItem = f;
        } else {
            createItemsLayout();
            z = true;
        }
        if (!z) {
            z = (this.firstItem == itemsRange.c() && this.itemsLayout.getChildCount() == itemsRange.b()) ? false : true;
        }
        if (this.firstItem <= itemsRange.c() || this.firstItem > itemsRange.d()) {
            this.firstItem = itemsRange.c();
        } else {
            int i = this.firstItem - 1;
            while (i >= itemsRange.c() && addViewItem(i, true)) {
                this.firstItem = i;
                i--;
            }
        }
        int i2 = this.firstItem;
        for (int childCount = this.itemsLayout.getChildCount(); childCount < itemsRange.b(); childCount++) {
            if (!addViewItem(this.firstItem + childCount, false) && this.itemsLayout.getChildCount() == 0) {
                i2++;
            }
        }
        this.firstItem = i2;
        return z;
    }

    private void updateView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1573351691")) {
            ipChange.ipc$dispatch("1573351691", new Object[]{this});
        } else if (rebuildItems()) {
            calculateLayoutWidth(getWidth(), 1073741824);
            layout(getWidth(), getHeight());
        }
    }

    public void addChangingListener(OnWheelChangedListener onWheelChangedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1733552330")) {
            ipChange.ipc$dispatch("1733552330", new Object[]{this, onWheelChangedListener});
            return;
        }
        this.changingListeners.add(onWheelChangedListener);
    }

    public void addClickingListener(OnWheelClickedListener onWheelClickedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-423183516")) {
            ipChange.ipc$dispatch("-423183516", new Object[]{this, onWheelClickedListener});
            return;
        }
        this.clickingListeners.add(onWheelClickedListener);
    }

    public void addScrollingListener(OnWheelScrollListener onWheelScrollListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-961763041")) {
            ipChange.ipc$dispatch("-961763041", new Object[]{this, onWheelScrollListener});
            return;
        }
        this.scrollingListeners.add(onWheelScrollListener);
    }

    public boolean drawShadows() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1413822266")) {
            return this.drawShadows;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1413822266", new Object[]{this})).booleanValue();
    }

    public int getCurrentItem() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2109373930")) {
            return this.currentItem;
        }
        return ((Integer) ipChange.ipc$dispatch("-2109373930", new Object[]{this})).intValue();
    }

    public WheelViewAdapter getViewAdapter() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1320009630")) {
            return this.viewAdapter;
        }
        return (WheelViewAdapter) ipChange.ipc$dispatch("-1320009630", new Object[]{this});
    }

    public int getVisibleItems() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "762379040")) {
            return this.visibleItems;
        }
        return ((Integer) ipChange.ipc$dispatch("762379040", new Object[]{this})).intValue();
    }

    public void invalidateWheel(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1196370621")) {
            ipChange.ipc$dispatch("-1196370621", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (z) {
            this.recycle.b();
            LinearLayout linearLayout = this.itemsLayout;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
            this.scrollingOffset = 0;
        } else {
            LinearLayout linearLayout2 = this.itemsLayout;
            if (linearLayout2 != null) {
                this.recycle.f(linearLayout2, this.firstItem, new y21());
            }
        }
        invalidate();
    }

    public boolean isCyclic() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "531181178")) {
            return this.isCyclic;
        }
        return ((Boolean) ipChange.ipc$dispatch("531181178", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: protected */
    public void notifyChangingListeners(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "772017224")) {
            ipChange.ipc$dispatch("772017224", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        for (OnWheelChangedListener onWheelChangedListener : this.changingListeners) {
            onWheelChangedListener.onChanged(this, i, i2);
        }
    }

    /* access modifiers changed from: protected */
    public void notifyClickListenersAboutClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "72070949")) {
            ipChange.ipc$dispatch("72070949", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        for (OnWheelClickedListener onWheelClickedListener : this.clickingListeners) {
            onWheelClickedListener.onItemClicked(this, i);
        }
    }

    /* access modifiers changed from: protected */
    public void notifyScrollingListenersAboutEnd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-546922984")) {
            ipChange.ipc$dispatch("-546922984", new Object[]{this});
            return;
        }
        for (OnWheelScrollListener onWheelScrollListener : this.scrollingListeners) {
            onWheelScrollListener.onScrollingFinished(this);
        }
    }

    /* access modifiers changed from: protected */
    public void notifyScrollingListenersAboutStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1962737231")) {
            ipChange.ipc$dispatch("-1962737231", new Object[]{this});
            return;
        }
        for (OnWheelScrollListener onWheelScrollListener : this.scrollingListeners) {
            onWheelScrollListener.onScrollingStarted(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1897282577")) {
            ipChange.ipc$dispatch("-1897282577", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        WheelViewAdapter wheelViewAdapter = this.viewAdapter;
        if (wheelViewAdapter != null && wheelViewAdapter.getItemsCount() > 0) {
            updateView();
            drawItems(canvas);
            drawCenterRect(canvas);
        }
        if (this.drawShadows) {
            drawShadows(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1759334980")) {
            ipChange.ipc$dispatch("1759334980", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        layout(i3 - i, i4 - i2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1005075602")) {
            ipChange.ipc$dispatch("1005075602", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        buildViewForMeasuring();
        int calculateLayoutWidth = calculateLayoutWidth(size, mode);
        if (mode2 != 1073741824) {
            int desiredHeight = getDesiredHeight(this.itemsLayout);
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(desiredHeight, size2) : desiredHeight;
        }
        setMeasuredDimension(calculateLayoutWidth, size2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1129088792")) {
            return ((Boolean) ipChange.ipc$dispatch("1129088792", new Object[]{this, motionEvent})).booleanValue();
        } else if (!isEnabled() || getViewAdapter() == null) {
            return true;
        } else {
            int action = motionEvent.getAction();
            if (action != 1) {
                if (action == 2 && getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
            } else if (!this.isScrollingPerformed) {
                int y = ((int) motionEvent.getY()) - (getHeight() / 2);
                if (y > 0) {
                    i = y + (getItemHeight() / 2);
                } else {
                    i = y - (getItemHeight() / 2);
                }
                int itemHeight2 = i / getItemHeight();
                if (itemHeight2 != 0 && isValidItemIndex(this.currentItem + itemHeight2)) {
                    notifyClickListenersAboutClick(this.currentItem + itemHeight2);
                }
            }
            return this.scroller.k(motionEvent);
        }
    }

    public void removeChangingListener(OnWheelChangedListener onWheelChangedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1451804005")) {
            ipChange.ipc$dispatch("1451804005", new Object[]{this, onWheelChangedListener});
            return;
        }
        this.changingListeners.remove(onWheelChangedListener);
    }

    public void removeClickingListener(OnWheelClickedListener onWheelClickedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-704931841")) {
            ipChange.ipc$dispatch("-704931841", new Object[]{this, onWheelClickedListener});
            return;
        }
        this.clickingListeners.remove(onWheelClickedListener);
    }

    public void removeScrollingListener(OnWheelScrollListener onWheelScrollListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1243511366")) {
            ipChange.ipc$dispatch("-1243511366", new Object[]{this, onWheelScrollListener});
            return;
        }
        this.scrollingListeners.remove(onWheelScrollListener);
    }

    public void scroll(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1371635636")) {
            ipChange.ipc$dispatch("-1371635636", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.scroller.l((i * getItemHeight()) - this.scrollingOffset, i2);
    }

    public void setCurrentItem(int i, boolean z) {
        int min;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1426539872")) {
            ipChange.ipc$dispatch("-1426539872", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
            return;
        }
        WheelViewAdapter wheelViewAdapter = this.viewAdapter;
        if (wheelViewAdapter != null && wheelViewAdapter.getItemsCount() != 0) {
            int itemsCount = this.viewAdapter.getItemsCount();
            if (i < 0 || i >= itemsCount) {
                if (this.isCyclic) {
                    while (i < 0) {
                        i += itemsCount;
                    }
                    i %= itemsCount;
                } else {
                    return;
                }
            }
            int i2 = this.currentItem;
            if (i == i2) {
                return;
            }
            if (z) {
                int i3 = i - i2;
                if (this.isCyclic && (min = (itemsCount + Math.min(i, i2)) - Math.max(i, this.currentItem)) < Math.abs(i3)) {
                    i3 = i3 < 0 ? min : -min;
                }
                scroll(i3, 0);
                return;
            }
            this.scrollingOffset = 0;
            this.currentItem = i;
            notifyChangingListeners(i2, i);
            invalidate();
        }
    }

    public void setCyclic(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2062335902")) {
            ipChange.ipc$dispatch("2062335902", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isCyclic = z;
        invalidateWheel(false);
    }

    public void setDrawShadows(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-642527672")) {
            ipChange.ipc$dispatch("-642527672", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.drawShadows = z;
    }

    public void setInterpolator(Interpolator interpolator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-542197123")) {
            ipChange.ipc$dispatch("-542197123", new Object[]{this, interpolator});
            return;
        }
        this.scroller.m(interpolator);
    }

    public void setShadowColor(int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-952176949")) {
            ipChange.ipc$dispatch("-952176949", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        this.SHADOWS_COLORS = new int[]{i, i2, i3};
    }

    public void setViewAdapter(WheelViewAdapter wheelViewAdapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "313423106")) {
            ipChange.ipc$dispatch("313423106", new Object[]{this, wheelViewAdapter});
            return;
        }
        WheelViewAdapter wheelViewAdapter2 = this.viewAdapter;
        if (wheelViewAdapter2 != null) {
            wheelViewAdapter2.unregisterDataSetObserver(this.dataObserver);
        }
        this.viewAdapter = wheelViewAdapter;
        if (wheelViewAdapter != null) {
            wheelViewAdapter.registerDataSetObserver(this.dataObserver);
        }
        invalidateWheel(true);
    }

    public void setVisibleItems(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "615215746")) {
            ipChange.ipc$dispatch("615215746", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.visibleItems = i;
    }

    public void setWheelBackground(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "85973489")) {
            ipChange.ipc$dispatch("85973489", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.wheelBackground = i;
        setBackgroundResource(i);
    }

    public void setWheelForeground(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1915888762")) {
            ipChange.ipc$dispatch("-1915888762", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.wheelForeground = i;
        this.centerDrawable = getContext().getResources().getDrawable(this.wheelForeground);
    }

    public void stopScrolling() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1934523234")) {
            ipChange.ipc$dispatch("-1934523234", new Object[]{this});
            return;
        }
        this.scroller.p();
    }

    private void drawShadows(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "28045027")) {
            ipChange.ipc$dispatch("28045027", new Object[]{this, canvas});
            return;
        }
        this.topShadow.setBounds(0, 0, getWidth(), ((getHeight() / 2) - (getItemHeight() / 2)) - 3);
        this.topShadow.draw(canvas);
        this.bottomShadow.setBounds(0, (getHeight() / 2) + (getItemHeight() / 2) + 3, getWidth(), getHeight());
        this.bottomShadow.draw(canvas);
    }

    public void setCurrentItem(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-46018892")) {
            ipChange.ipc$dispatch("-46018892", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        setCurrentItem(i, false);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i = R$color.white;
        this.wheelBackground = i;
        this.wheelForeground = i;
        this.drawShadows = true;
        this.isCyclic = false;
        this.recycle = new mz2(this);
        this.changingListeners = new LinkedList();
        this.scrollingListeners = new LinkedList();
        this.clickingListeners = new LinkedList();
        this.scrollingListener = new a();
        this.dataObserver = new b();
        initData(context);
    }

    public WheelView(Context context) {
        super(context);
        int i = R$color.white;
        this.wheelBackground = i;
        this.wheelForeground = i;
        this.drawShadows = true;
        this.isCyclic = false;
        this.recycle = new mz2(this);
        this.changingListeners = new LinkedList();
        this.scrollingListeners = new LinkedList();
        this.clickingListeners = new LinkedList();
        this.scrollingListener = new a();
        this.dataObserver = new b();
        initData(context);
    }
}
