package cn.damai.onearch.component.banner.widget;

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
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: Taobao */
public class Banner extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
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

    /* compiled from: Taobao */
    public class BannerAdapterWrapper extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private static transient /* synthetic */ IpChange $ipChange;
        private RecyclerView.Adapter a;

        private BannerAdapterWrapper() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-56359710")) {
                return getRealCount() > 1 ? getRealCount() + Banner.this.needPage : getRealCount();
            }
            return ((Integer) ipChange.ipc$dispatch("-56359710", new Object[]{this})).intValue();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-654181146")) {
                return this.a.getItemId(Banner.this.toRealPosition(i));
            }
            return ((Long) ipChange.ipc$dispatch("-654181146", new Object[]{this, Integer.valueOf(i)})).longValue();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1852850551")) {
                return this.a.getItemViewType(Banner.this.toRealPosition(i));
            }
            return ((Integer) ipChange.ipc$dispatch("-1852850551", new Object[]{this, Integer.valueOf(i)})).intValue();
        }

        /* access modifiers changed from: package-private */
        public int getRealCount() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "588392557")) {
                return ((Integer) ipChange.ipc$dispatch("588392557", new Object[]{this})).intValue();
            }
            RecyclerView.Adapter adapter = this.a;
            if (adapter == null) {
                return 0;
            }
            return adapter.getItemCount();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "323988183")) {
                ipChange.ipc$dispatch("323988183", new Object[]{this, viewHolder, Integer.valueOf(i)});
                return;
            }
            this.a.onBindViewHolder(viewHolder, Banner.this.toRealPosition(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1670275327")) {
                return this.a.onCreateViewHolder(viewGroup, i);
            }
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("1670275327", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }

        /* access modifiers changed from: package-private */
        public void registerAdapter(RecyclerView.Adapter adapter) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1266421219")) {
                ipChange.ipc$dispatch("1266421219", new Object[]{this, adapter});
                return;
            }
            RecyclerView.Adapter adapter2 = this.a;
            if (adapter2 != null) {
                adapter2.unregisterAdapterDataObserver(Banner.this.itemDataSetChangeObserver);
            }
            this.a = adapter;
            if (adapter != null) {
                adapter.registerAdapterDataObserver(Banner.this.itemDataSetChangeObserver);
            }
        }
    }

    /* compiled from: Taobao */
    public class OnPageChangeCallback extends ViewPager2.OnPageChangeCallback {
        private static transient /* synthetic */ IpChange $ipChange;

        private OnPageChangeCallback() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1856798631")) {
                ipChange.ipc$dispatch("-1856798631", new Object[]{this, Integer.valueOf(i)});
                return;
            }
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
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2029549048")) {
                ipChange.ipc$dispatch("2029549048", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                return;
            }
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
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1557023460")) {
                ipChange.ipc$dispatch("1557023460", new Object[]{this, Integer.valueOf(i)});
                return;
            }
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

    /* compiled from: Taobao */
    public class ProxyLayoutManger extends LinearLayoutManager {
        private static transient /* synthetic */ IpChange $ipChange;
        private final RecyclerView.LayoutManager a;

        ProxyLayoutManger(Context context, LinearLayoutManager linearLayoutManager) {
            super(context, linearLayoutManager.getOrientation(), false);
            this.a = linearLayoutManager;
        }

        /* access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void calculateExtraLayoutSpace(@NonNull RecyclerView.State state, @NonNull int[] iArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1773482271")) {
                ipChange.ipc$dispatch("1773482271", new Object[]{this, state, iArr});
                return;
            }
            try {
                Method declaredMethod = this.a.getClass().getDeclaredMethod("calculateExtraLayoutSpace", state.getClass(), iArr.getClass());
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this.a, state, iArr);
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
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1205047560")) {
                ipChange.ipc$dispatch("1205047560", new Object[]{this, recycler, state, accessibilityNodeInfoCompat});
                return;
            }
            this.a.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean performAccessibilityAction(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, int i, @Nullable Bundle bundle) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1514916915")) {
                return this.a.performAccessibilityAction(recycler, state, i, bundle);
            }
            return ((Boolean) ipChange.ipc$dispatch("-1514916915", new Object[]{this, recycler, state, Integer.valueOf(i), bundle})).booleanValue();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z, boolean z2) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1924684444")) {
                return this.a.requestChildRectangleOnScreen(recyclerView, view, rect, z, z2);
            }
            return ((Boolean) ipChange.ipc$dispatch("-1924684444", new Object[]{this, recyclerView, view, rect, Boolean.valueOf(z), Boolean.valueOf(z2)})).booleanValue();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
        public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-173935280")) {
                ipChange.ipc$dispatch("-173935280", new Object[]{this, recyclerView, state, Integer.valueOf(i)});
                return;
            }
            AnonymousClass1 r6 = new LinearSmoothScroller(recyclerView.getContext()) {
                /* class cn.damai.onearch.component.banner.widget.Banner.ProxyLayoutManger.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                /* access modifiers changed from: protected */
                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                public int calculateTimeForDeceleration(int i) {
                    IpChange ipChange = $ipChange;
                    if (!AndroidInstantRuntime.support(ipChange, "1650954591")) {
                        return (int) (((double) Banner.this.pagerScrollDuration) * 0.6644d);
                    }
                    return ((Integer) ipChange.ipc$dispatch("1650954591", new Object[]{this, Integer.valueOf(i)})).intValue();
                }
            };
            r6.setTargetPosition(i);
            startSmoothScroll(r6);
        }
    }

    /* compiled from: Taobao */
    public class a extends ViewOutlineProvider {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ float a;

        a(Banner banner, float f) {
            this.a = f;
        }

        public void getOutline(View view, Outline outline) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "720482063")) {
                ipChange.ipc$dispatch("720482063", new Object[]{this, view, outline});
                return;
            }
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.a);
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
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-616128151")) {
            return this.adapterWrapper.getRealCount();
        }
        return ((Integer) ipChange.ipc$dispatch("-616128151", new Object[]{this})).intValue();
    }

    private void initViewPagerScrollProxy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "765443582")) {
            ipChange.ipc$dispatch("765443582", new Object[]{this});
            return;
        }
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
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1750110829")) {
            ipChange.ipc$dispatch("1750110829", new Object[]{this, context});
            return;
        }
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
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-110814349")) {
            ipChange.ipc$dispatch("-110814349", new Object[]{this, Integer.valueOf(i)});
            return;
        }
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
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "882008935")) {
            return ((Integer) ipChange.ipc$dispatch("882008935", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        if (getRealCount() > 1) {
            i2 = (i - this.sidePage) % getRealCount();
        }
        return i2 < 0 ? i2 + getRealCount() : i2;
    }

    public Banner addItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "803574596")) {
            return (Banner) ipChange.ipc$dispatch("803574596", new Object[]{this, itemDecoration});
        }
        this.viewPager2.addItemDecoration(itemDecoration);
        return this;
    }

    public Banner addPageTransformer(ViewPager2.PageTransformer pageTransformer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-566867354")) {
            return (Banner) ipChange.ipc$dispatch("-566867354", new Object[]{this, pageTransformer});
        }
        this.compositePageTransformer.addTransformer(pageTransformer);
        return this;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "569071093")) {
            return ((Boolean) ipChange.ipc$dispatch("569071093", new Object[]{this, motionEvent})).booleanValue();
        }
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
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1526315764")) {
            return this.adapterWrapper.a;
        }
        return (RecyclerView.Adapter) ipChange.ipc$dispatch("1526315764", new Object[]{this});
    }

    public int getCurrentPager() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-764252564")) {
            return Math.max(toRealPosition(this.tempPosition), 0);
        }
        return ((Integer) ipChange.ipc$dispatch("-764252564", new Object[]{this})).intValue();
    }

    public ViewPager2 getViewPager2() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "790024694")) {
            return this.viewPager2;
        }
        return (ViewPager2) ipChange.ipc$dispatch("790024694", new Object[]{this});
    }

    public boolean isAutoPlay() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1930417720")) {
            return this.isAutoPlay && getRealCount() > 1;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1930417720", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-47157533")) {
            ipChange.ipc$dispatch("-47157533", new Object[]{this});
            return;
        }
        super.onAttachedToWindow();
        if (isAutoPlay()) {
            startTurning();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1016699206")) {
            ipChange.ipc$dispatch("1016699206", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        if (isAutoPlay()) {
            stopTurning();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1863274676")) {
            return ((Boolean) ipChange.ipc$dispatch("1863274676", new Object[]{this, motionEvent})).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            float rawX = motionEvent.getRawX();
            this.lastX = rawX;
            this.startX = rawX;
            float rawY = motionEvent.getRawY();
            this.lastY = rawY;
            this.startY = rawY;
        } else if (action == 2) {
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
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1594869112")) {
            ipChange.ipc$dispatch("-1594869112", new Object[]{this, adapter});
            return;
        }
        setAdapter(adapter, 0);
    }

    public Banner setAutoPlay(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1649295939")) {
            return (Banner) ipChange.ipc$dispatch("-1649295939", new Object[]{this, Boolean.valueOf(z)});
        }
        this.isAutoPlay = z;
        if (z && getRealCount() > 1) {
            startTurning();
        }
        return this;
    }

    public Banner setAutoTurningTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1358125455")) {
            return (Banner) ipChange.ipc$dispatch("-1358125455", new Object[]{this, Long.valueOf(j)});
        }
        this.autoTurningTime = j;
        return this;
    }

    public void setCurrentItem(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "471668444")) {
            ipChange.ipc$dispatch("471668444", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        setCurrentItem(i, true);
    }

    public Banner setIndicator(Indicator indicator2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-813809655")) {
            return setIndicator(indicator2, true);
        }
        return (Banner) ipChange.ipc$dispatch("-813809655", new Object[]{this, indicator2});
    }

    public Banner setOffscreenPageLimit(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1331146746")) {
            return (Banner) ipChange.ipc$dispatch("1331146746", new Object[]{this, Integer.valueOf(i)});
        }
        this.viewPager2.setOffscreenPageLimit(i);
        return this;
    }

    public Banner setOrientation(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "335426941")) {
            return (Banner) ipChange.ipc$dispatch("335426941", new Object[]{this, Integer.valueOf(i)});
        }
        this.viewPager2.setOrientation(i);
        return this;
    }

    public Banner setOuterPageChangeListener(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "644567764")) {
            return (Banner) ipChange.ipc$dispatch("644567764", new Object[]{this, onPageChangeCallback});
        }
        this.changeCallback = onPageChangeCallback;
        return this;
    }

    public Banner setPageMargin(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1119144681")) {
            return setPageMargin(i, i, i2);
        }
        return (Banner) ipChange.ipc$dispatch("-1119144681", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public Banner setPagerScrollDuration(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-953360494")) {
            return (Banner) ipChange.ipc$dispatch("-953360494", new Object[]{this, Long.valueOf(j)});
        }
        this.pagerScrollDuration = j;
        return this;
    }

    @RequiresApi(api = 21)
    public Banner setRoundCorners(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1879337738")) {
            return (Banner) ipChange.ipc$dispatch("-1879337738", new Object[]{this, Float.valueOf(f)});
        }
        setOutlineProvider(new a(this, f));
        setClipToOutline(true);
        return this;
    }

    public void startTurning() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-519163826")) {
            ipChange.ipc$dispatch("-519163826", new Object[]{this});
            return;
        }
        stopTurning();
        postDelayed(this.flipTask, this.autoTurningTime);
        this.isTaskPostDelayed = true;
    }

    public void stopTurning() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2130669046")) {
            ipChange.ipc$dispatch("2130669046", new Object[]{this});
        } else if (this.isTaskPostDelayed) {
            removeCallbacks(this.flipTask);
            this.isTaskPostDelayed = false;
        }
    }

    public Banner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Banner addItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1455914137")) {
            return (Banner) ipChange.ipc$dispatch("1455914137", new Object[]{this, itemDecoration, Integer.valueOf(i)});
        }
        this.viewPager2.addItemDecoration(itemDecoration, i);
        return this;
    }

    public void setAdapter(@Nullable RecyclerView.Adapter adapter, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2098694523")) {
            ipChange.ipc$dispatch("2098694523", new Object[]{this, adapter, Integer.valueOf(i)});
            return;
        }
        this.adapterWrapper.registerAdapter(adapter);
        startPager(i);
    }

    public void setCurrentItem(int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1736865656")) {
            ipChange.ipc$dispatch("1736865656", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
            return;
        }
        int i2 = i + this.sidePage;
        this.tempPosition = i2;
        this.viewPager2.setCurrentItem(i2, z);
    }

    public Banner setIndicator(Indicator indicator2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "646013509")) {
            return (Banner) ipChange.ipc$dispatch("646013509", new Object[]{this, indicator2, Boolean.valueOf(z)});
        }
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
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1981158694")) {
            return (Banner) ipChange.ipc$dispatch("1981158694", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        }
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
            /* class cn.damai.onearch.component.banner.widget.Banner.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1348865633")) {
                    ipChange.ipc$dispatch("1348865633", new Object[]{this});
                } else if (Banner.this.isAutoPlay()) {
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
            /* class cn.damai.onearch.component.banner.widget.Banner.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1279678090")) {
                    ipChange.ipc$dispatch("-1279678090", new Object[]{this});
                    return;
                }
                Banner banner = Banner.this;
                banner.startPager(banner.getCurrentPager());
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i, int i2, @Nullable Object obj) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1935179122")) {
                    ipChange.ipc$dispatch("1935179122", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), obj});
                    return;
                }
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2027383912")) {
                    ipChange.ipc$dispatch("2027383912", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                } else if (i > 1) {
                    onChanged();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int i, int i2, int i3) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-285733332")) {
                    ipChange.ipc$dispatch("-285733332", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                    return;
                }
                onChanged();
            }
        };
        this.scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop() >> 1;
        initViews(context);
    }
}
