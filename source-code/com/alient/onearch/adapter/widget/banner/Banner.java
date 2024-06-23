package com.alient.onearch.adapter.widget.banner;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: Taobao */
public class Banner extends RelativeLayout {
    private static final long DEFAULT_AUTO_TIME = 2500;
    private static final long DEFAULT_PAGER_DURATION = 800;
    private static final int NORMAL_COUNT = 2;
    private BannerAdapterWrapper adapterWrapper;
    private long autoTurningTime;
    private ViewPager2.OnPageChangeCallback changeCallback;
    private CompositePageTransformer compositePageTransformer;
    private final Runnable flipTask;
    private Indicator indicator;
    private boolean isAutoPlay;
    private boolean isBeginPagerChange;
    private boolean isTaskPostDelayed;
    private final RecyclerView.AdapterDataObserver itemDataSetChangeObserver;
    private float lastX;
    private float lastY;
    private int needPage;
    private long pagerScrollDuration;
    private final int scaledTouchSlop;
    private int sidePage;
    private float startX;
    private float startY;
    private int tempPosition;
    private ViewPager2 viewPager2;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class BannerAdapterWrapper extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private RecyclerView.Adapter adapter;

        private BannerAdapterWrapper() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return getRealCount() > 1 ? getRealCount() + Banner.this.needPage : getRealCount();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return this.adapter.getItemId(Banner.this.toRealPosition(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return this.adapter.getItemViewType(Banner.this.toRealPosition(i));
        }

        /* access modifiers changed from: package-private */
        public int getRealCount() {
            RecyclerView.Adapter adapter2 = this.adapter;
            if (adapter2 == null) {
                return 0;
            }
            return adapter2.getItemCount();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            this.adapter.onBindViewHolder(viewHolder, Banner.this.toRealPosition(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return this.adapter.onCreateViewHolder(viewGroup, i);
        }

        /* access modifiers changed from: package-private */
        public void registerAdapter(RecyclerView.Adapter adapter2) {
            RecyclerView.Adapter adapter3 = this.adapter;
            if (adapter3 != null) {
                adapter3.unregisterAdapterDataObserver(Banner.this.itemDataSetChangeObserver);
            }
            this.adapter = adapter2;
            if (adapter2 != null) {
                adapter2.registerAdapterDataObserver(Banner.this.itemDataSetChangeObserver);
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class OnPageChangeCallback extends ViewPager2.OnPageChangeCallback {
        private OnPageChangeCallback() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i) {
            if (i == 1) {
                if (Banner.this.tempPosition == Banner.this.sidePage - 1) {
                    Banner.this.isBeginPagerChange = false;
                    Banner.this.viewPager2.setCurrentItem(Banner.this.getRealCount() + Banner.this.tempPosition, false);
                } else if (Banner.this.tempPosition == Banner.this.getRealCount() + Banner.this.sidePage) {
                    Banner.this.isBeginPagerChange = false;
                    Banner.this.viewPager2.setCurrentItem(Banner.this.sidePage, false);
                } else {
                    Banner.this.isBeginPagerChange = true;
                }
            }
            if (Banner.this.changeCallback != null) {
                Banner.this.changeCallback.onPageScrollStateChanged(i);
            }
            if (Banner.this.indicator != null) {
                Banner.this.indicator.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i, float f, int i2) {
            int realPosition = Banner.this.toRealPosition(i);
            if (Banner.this.changeCallback != null) {
                Banner.this.changeCallback.onPageScrolled(realPosition, f, i2);
            }
            if (Banner.this.indicator != null) {
                Banner.this.indicator.onPageScrolled(realPosition, f, i2);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i) {
            if (Banner.this.getRealCount() > 1) {
                Banner.this.tempPosition = i;
            }
            if (Banner.this.isBeginPagerChange) {
                int realPosition = Banner.this.toRealPosition(i);
                if (Banner.this.changeCallback != null) {
                    Banner.this.changeCallback.onPageSelected(realPosition);
                }
                if (Banner.this.indicator != null) {
                    Banner.this.indicator.onPageSelected(realPosition);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class ProxyLayoutManger extends LinearLayoutManager {
        private final RecyclerView.LayoutManager layoutManager;

        ProxyLayoutManger(Context context, LinearLayoutManager linearLayoutManager) {
            super(context, linearLayoutManager.getOrientation(), false);
            this.layoutManager = linearLayoutManager;
        }

        /* access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void calculateExtraLayoutSpace(@NonNull RecyclerView.State state, @NonNull int[] iArr) {
            try {
                Method declaredMethod = this.layoutManager.getClass().getDeclaredMethod("calculateExtraLayoutSpace", state.getClass(), iArr.getClass());
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this.layoutManager, state, iArr);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onInitializeAccessibilityNodeInfo(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            this.layoutManager.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean performAccessibilityAction(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, int i, @Nullable Bundle bundle) {
            return this.layoutManager.performAccessibilityAction(recycler, state, i, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z, boolean z2) {
            return this.layoutManager.requestChildRectangleOnScreen(recyclerView, view, rect, z, z2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
        public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
            AnonymousClass1 r2 = new LinearSmoothScroller(recyclerView.getContext()) {
                /* class com.alient.onearch.adapter.widget.banner.Banner.ProxyLayoutManger.AnonymousClass1 */

                /* access modifiers changed from: protected */
                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                public int calculateTimeForDeceleration(int i) {
                    return (int) (((double) Banner.this.pagerScrollDuration) * 0.6644d);
                }
            };
            r2.setTargetPosition(i);
            startSmoothScroll(r2);
        }
    }

    public Banner(Context context) {
        this(context, null);
    }

    static /* synthetic */ int access$208(Banner banner) {
        int i = banner.tempPosition;
        banner.tempPosition = i + 1;
        return i;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int getRealCount() {
        return this.adapterWrapper.getRealCount();
    }

    private void initViewPagerScrollProxy() {
        try {
            RecyclerView recyclerView = (RecyclerView) this.viewPager2.getChildAt(0);
            recyclerView.setOverScrollMode(2);
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            ProxyLayoutManger proxyLayoutManger = new ProxyLayoutManger(getContext(), linearLayoutManager);
            recyclerView.setLayoutManager(proxyLayoutManger);
            Field declaredField = RecyclerView.LayoutManager.class.getDeclaredField("mRecyclerView");
            declaredField.setAccessible(true);
            declaredField.set(linearLayoutManager, recyclerView);
            Field declaredField2 = ViewPager2.class.getDeclaredField("mLayoutManager");
            declaredField2.setAccessible(true);
            declaredField2.set(this.viewPager2, proxyLayoutManger);
            Field declaredField3 = ViewPager2.class.getDeclaredField("mPageTransformerAdapter");
            declaredField3.setAccessible(true);
            Object obj = declaredField3.get(this.viewPager2);
            if (obj != null) {
                Field declaredField4 = obj.getClass().getDeclaredField("mLayoutManager");
                declaredField4.setAccessible(true);
                declaredField4.set(obj, proxyLayoutManger);
            }
            Field declaredField5 = ViewPager2.class.getDeclaredField("mScrollEventAdapter");
            declaredField5.setAccessible(true);
            Object obj2 = declaredField5.get(this.viewPager2);
            if (obj2 != null) {
                Field declaredField6 = obj2.getClass().getDeclaredField("mLayoutManager");
                declaredField6.setAccessible(true);
                declaredField6.set(obj2, proxyLayoutManger);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    private void initViews(Context context) {
        ViewPager2 viewPager22 = new ViewPager2(context);
        this.viewPager2 = viewPager22;
        viewPager22.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        ViewPager2 viewPager23 = this.viewPager2;
        CompositePageTransformer compositePageTransformer2 = new CompositePageTransformer();
        this.compositePageTransformer = compositePageTransformer2;
        viewPager23.setPageTransformer(compositePageTransformer2);
        this.viewPager2.registerOnPageChangeCallback(new OnPageChangeCallback());
        ViewPager2 viewPager24 = this.viewPager2;
        BannerAdapterWrapper bannerAdapterWrapper = new BannerAdapterWrapper();
        this.adapterWrapper = bannerAdapterWrapper;
        viewPager24.setAdapter(bannerAdapterWrapper);
        setOffscreenPageLimit(1);
        initViewPagerScrollProxy();
        addView(this.viewPager2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void startPager(int i) {
        if (this.sidePage == 2) {
            this.viewPager2.setAdapter(this.adapterWrapper);
        } else {
            this.adapterWrapper.notifyDataSetChanged();
        }
        setCurrentItem(i, false);
        Indicator indicator2 = this.indicator;
        if (indicator2 != null) {
            indicator2.initIndicatorCount(getRealCount(), getCurrentPager());
        }
        if (isAutoPlay()) {
            startTurning();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int toRealPosition(int i) {
        int realCount = getRealCount() > 1 ? (i - this.sidePage) % getRealCount() : 0;
        return realCount < 0 ? realCount + getRealCount() : realCount;
    }

    public Banner addItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration) {
        this.viewPager2.addItemDecoration(itemDecoration);
        return this;
    }

    public Banner addPageTransformer(ViewPager2.PageTransformer pageTransformer) {
        this.compositePageTransformer.addTransformer(pageTransformer);
        return this;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isAutoPlay() && this.viewPager2.isUserInputEnabled()) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 3 || action == 4) {
                startTurning();
            } else if (action == 0) {
                stopTurning();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public RecyclerView.Adapter getAdapter() {
        return this.adapterWrapper.adapter;
    }

    public int getCurrentPager() {
        return Math.max(toRealPosition(this.tempPosition), 0);
    }

    public ViewPager2 getViewPager2() {
        return this.viewPager2;
    }

    public boolean isAutoPlay() {
        return this.isAutoPlay && getRealCount() > 1;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isAutoPlay()) {
            startTurning();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (isAutoPlay()) {
            stopTurning();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            float rawX = motionEvent.getRawX();
            this.lastX = rawX;
            this.startX = rawX;
            float rawY = motionEvent.getRawY();
            this.lastY = rawY;
            this.startY = rawY;
        } else {
            boolean z = false;
            if (action == 2) {
                this.lastX = motionEvent.getRawX();
                this.lastY = motionEvent.getRawY();
                if (this.viewPager2.isUserInputEnabled()) {
                    float abs = Math.abs(this.lastX - this.startX);
                    float abs2 = Math.abs(this.lastY - this.startY);
                    if (this.viewPager2.getOrientation() != 0 ? !(abs2 <= ((float) this.scaledTouchSlop) || abs2 <= abs) : !(abs <= ((float) this.scaledTouchSlop) || abs <= abs2)) {
                        z = true;
                    }
                    getParent().requestDisallowInterceptTouchEvent(z);
                }
            } else if (action == 3 || action == 1) {
                if (Math.abs(this.lastX - this.startX) > ((float) this.scaledTouchSlop) || Math.abs(this.lastY - this.startY) > ((float) this.scaledTouchSlop)) {
                    return true;
                }
                return false;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        setAdapter(adapter, 0);
    }

    public Banner setAutoPlay(boolean z) {
        this.isAutoPlay = z;
        if (z && getRealCount() > 1) {
            startTurning();
        }
        return this;
    }

    public Banner setAutoTurningTime(long j) {
        this.autoTurningTime = j;
        return this;
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, true);
    }

    public Banner setIndicator(Indicator indicator2) {
        return setIndicator(indicator2, true);
    }

    public Banner setOffscreenPageLimit(int i) {
        this.viewPager2.setOffscreenPageLimit(i);
        return this;
    }

    public Banner setOrientation(int i) {
        this.viewPager2.setOrientation(i);
        return this;
    }

    public Banner setOuterPageChangeListener(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.changeCallback = onPageChangeCallback;
        return this;
    }

    public Banner setPageMargin(int i, int i2) {
        return setPageMargin(i, i, i2);
    }

    public Banner setPagerScrollDuration(long j) {
        this.pagerScrollDuration = j;
        return this;
    }

    @RequiresApi(api = 21)
    public Banner setRoundCorners(final float f) {
        setOutlineProvider(new ViewOutlineProvider() {
            /* class com.alient.onearch.adapter.widget.banner.Banner.AnonymousClass3 */

            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), f);
            }
        });
        setClipToOutline(true);
        return this;
    }

    public void startTurning() {
        stopTurning();
        postDelayed(this.flipTask, this.autoTurningTime);
        this.isTaskPostDelayed = true;
    }

    public void stopTurning() {
        if (this.isTaskPostDelayed) {
            removeCallbacks(this.flipTask);
            this.isTaskPostDelayed = false;
        }
    }

    public Banner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Banner addItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration, int i) {
        this.viewPager2.addItemDecoration(itemDecoration, i);
        return this;
    }

    public void setAdapter(@Nullable RecyclerView.Adapter adapter, int i) {
        this.adapterWrapper.registerAdapter(adapter);
        startPager(i);
    }

    public void setCurrentItem(int i, boolean z) {
        int i2 = i + this.sidePage;
        this.tempPosition = i2;
        this.viewPager2.setCurrentItem(i2, z);
    }

    public Banner setIndicator(Indicator indicator2, boolean z) {
        Indicator indicator3 = this.indicator;
        if (indicator3 != null) {
            removeView(indicator3.getView());
        }
        if (indicator2 != null) {
            this.indicator = indicator2;
            if (z) {
                addView(indicator2.getView(), this.indicator.getParams());
            }
        }
        return this;
    }

    public Banner setPageMargin(int i, int i2, int i3) {
        if (i3 < 0) {
            i3 = 0;
        }
        addPageTransformer(new MarginPageTransformer(i3));
        RecyclerView recyclerView = (RecyclerView) this.viewPager2.getChildAt(0);
        if (this.viewPager2.getOrientation() == 1) {
            recyclerView.setPadding(this.viewPager2.getPaddingLeft(), i + Math.abs(i3), this.viewPager2.getPaddingRight(), i2 + Math.abs(i3));
        } else {
            recyclerView.setPadding(i + Math.abs(i3), this.viewPager2.getPaddingTop(), i2 + Math.abs(i3), this.viewPager2.getPaddingBottom());
        }
        recyclerView.setClipToPadding(false);
        this.needPage = 4;
        this.sidePage = 2;
        return this;
    }

    public Banner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isAutoPlay = true;
        this.isBeginPagerChange = true;
        this.autoTurningTime = 2500;
        this.pagerScrollDuration = DEFAULT_PAGER_DURATION;
        this.needPage = 2;
        this.sidePage = 2 / 2;
        this.flipTask = new Runnable() {
            /* class com.alient.onearch.adapter.widget.banner.Banner.AnonymousClass1 */

            public void run() {
                if (Banner.this.isAutoPlay()) {
                    Banner.access$208(Banner.this);
                    if (Banner.this.tempPosition == Banner.this.getRealCount() + Banner.this.sidePage + 1) {
                        Banner.this.isBeginPagerChange = false;
                        Banner.this.viewPager2.setCurrentItem(Banner.this.sidePage, false);
                        Banner banner = Banner.this;
                        banner.post(banner.flipTask);
                        return;
                    }
                    Banner.this.isBeginPagerChange = true;
                    Banner.this.viewPager2.setCurrentItem(Banner.this.tempPosition);
                    Banner banner2 = Banner.this;
                    banner2.postDelayed(banner2.flipTask, Banner.this.autoTurningTime);
                }
            }
        };
        this.itemDataSetChangeObserver = new RecyclerView.AdapterDataObserver() {
            /* class com.alient.onearch.adapter.widget.banner.Banner.AnonymousClass2 */

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                Banner banner = Banner.this;
                banner.startPager(banner.getCurrentPager());
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i, int i2, @Nullable Object obj) {
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i, int i2) {
                if (i > 1) {
                    onChanged();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int i, int i2, int i3) {
                onChanged();
            }
        };
        this.scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop() >> 1;
        initViews(context);
    }
}
