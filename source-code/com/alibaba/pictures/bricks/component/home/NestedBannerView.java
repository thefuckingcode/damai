package com.alibaba.pictures.bricks.component.home;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.bean.NestedBannerBean;
import com.alibaba.pictures.bricks.component.home.NestedBannerContract;
import com.alibaba.pictures.bricks.view.BannerAttachedAutoPlayCondition;
import com.alibaba.pictures.bricks.view.NestedBanner;
import com.alibaba.pictures.bricks.view.NestedBannerIndicatorView;
import com.alibaba.pictures.bricks.view.NestedListener;
import com.alibaba.pictures.bricks.view.NestedRecyclerView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.alient.onearch.adapter.view.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.uplayer.AliMediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.lh1;
import tb.mh1;
import tb.u50;
import tb.ur2;
import tb.vc;
import tb.wm2;
import tb.ww1;

/* compiled from: Taobao */
public final class NestedBannerView extends AbsView<GenericItem<ItemValue>, NestedBannerModel, NestedBannerPresent> implements NestedBannerContract.View, NestedListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isInSuperFrameState;
    private boolean isLargeScreen;
    @NotNull
    private final View itemView;
    private final NestedBanner mBanner;
    private final ViewGroup mBannerContainer;
    @Nullable
    private OnBannerListener mBannerListener;
    @Nullable
    private ValueAnimator mCollapseAnimator;
    @NotNull
    private final Context mContext;
    @Nullable
    private ArrayList<NestedBannerBean> mCurList;
    private final float mHeightShouldFold;
    private final NestedBannerIndicatorView mIndicator;
    @Nullable
    private Integer mLastMove;
    private final int mMaxHeight;
    private final int mMinHeight;
    @Nullable
    private NestedRecyclerView mNestedRecyclerView;
    @NotNull
    private final ArrayList<NestedBannerBean> mSuperList = new ArrayList<>();
    @NotNull
    private final ArrayList<NestedBannerBean> mTotalList = new ArrayList<>();

    /* compiled from: Taobao */
    public static final class a implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ NestedBannerView a;

        a(NestedBannerView nestedBannerView) {
            this.a = nestedBannerView;
        }

        public void onViewAttachedToWindow(@Nullable View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "663754937")) {
                ipChange.ipc$dispatch("663754937", new Object[]{this, view});
                return;
            }
            if (this.a.mNestedRecyclerView == null) {
                this.a.mNestedRecyclerView = NestedRecyclerView.Companion.a(view);
            }
            NestedRecyclerView nestedRecyclerView = this.a.mNestedRecyclerView;
            if (nestedRecyclerView != null) {
                NestedBannerView nestedBannerView = this.a;
                vc vcVar = vc.INSTANCE;
                vc.b(vcVar, "Banner " + nestedBannerView.mBanner.hashCode() + " add listener into RecyclerView", null, 2, null);
                nestedRecyclerView.addListener(nestedBannerView);
            }
        }

        public void onViewDetachedFromWindow(@Nullable View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1958128906")) {
                ipChange.ipc$dispatch("-1958128906", new Object[]{this, view});
                return;
            }
            NestedRecyclerView nestedRecyclerView = this.a.mNestedRecyclerView;
            if (nestedRecyclerView != null) {
                NestedBannerView nestedBannerView = this.a;
                vc vcVar = vc.INSTANCE;
                vc.b(vcVar, "Banner " + nestedBannerView.mBanner.hashCode() + " remove listener form RecyclerView", null, 2, null);
                nestedRecyclerView.removeListener(nestedBannerView);
            }
        }
    }

    /* compiled from: Taobao */
    public static final class b implements OnBannerListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ NestedBannerView a;

        b(NestedBannerView nestedBannerView) {
            this.a = nestedBannerView;
        }

        @Override // com.alibaba.pictures.bricks.component.home.OnBannerListener
        public void onBannerItemClick(@NotNull View view, @NotNull NestedBannerBean nestedBannerBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "882291759")) {
                ipChange.ipc$dispatch("882291759", new Object[]{this, view, nestedBannerBean, Integer.valueOf(i)});
                return;
            }
            k21.i(view, "view");
            k21.i(nestedBannerBean, "bean");
            OnBannerListener mBannerListener = this.a.getMBannerListener();
            if (mBannerListener != null) {
                mBannerListener.onBannerItemClick(view, nestedBannerBean, i);
            }
        }

        @Override // com.alibaba.pictures.bricks.component.home.OnBannerListener
        public void onBannerViewExpose(@NotNull View view, @NotNull NestedBannerBean nestedBannerBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1050695625")) {
                ipChange.ipc$dispatch("1050695625", new Object[]{this, view, nestedBannerBean, Integer.valueOf(i)});
                return;
            }
            k21.i(view, "view");
            k21.i(nestedBannerBean, "bean");
            OnBannerListener mBannerListener = this.a.getMBannerListener();
            if (mBannerListener != null) {
                mBannerListener.onBannerViewExpose(view, nestedBannerBean, i);
            }
        }
    }

    /* compiled from: Taobao */
    public static final class c implements BannerAttachedAutoPlayCondition {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ NestedBannerView a;

        c(NestedBannerView nestedBannerView) {
            this.a = nestedBannerView;
        }

        @Override // com.alibaba.pictures.bricks.view.BannerAttachedAutoPlayCondition
        public boolean isCanAutoPlay() {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "-520392297")) {
                return ((Boolean) ipChange.ipc$dispatch("-520392297", new Object[]{this})).booleanValue();
            }
            NestedRecyclerView nestedRecyclerView = this.a.mNestedRecyclerView;
            if (nestedRecyclerView == null) {
                return false;
            }
            if (nestedRecyclerView.getScrollState() != 0) {
                z = false;
            }
            return z;
        }
    }

    /* compiled from: Taobao */
    public static final class d extends AnimatorListenerAdapter {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Function1<Boolean, ur2> a;

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Boolean, tb.ur2> */
        /* JADX WARN: Multi-variable type inference failed */
        d(Function1<? super Boolean, ur2> function1) {
            this.a = function1;
        }

        public void onAnimationEnd(@Nullable Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "860218077")) {
                ipChange.ipc$dispatch("860218077", new Object[]{this, animator});
                return;
            }
            this.a.invoke(Boolean.TRUE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NestedBannerView(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
        this.itemView = view;
        this.mBannerContainer = (ViewGroup) view.findViewById(R$id.id_bricks_banner_container);
        NestedBanner nestedBanner = (NestedBanner) view.findViewById(R$id.id_bricks_nested_banner_view);
        this.mBanner = nestedBanner;
        NestedBannerIndicatorView nestedBannerIndicatorView = (NestedBannerIndicatorView) view.findViewById(R$id.id_bricks_banner_indicator_view);
        this.mIndicator = nestedBannerIndicatorView;
        u50 u50 = u50.INSTANCE;
        Context context = view.getContext();
        k21.h(context, "itemView.context");
        this.mMaxHeight = u50.b(context, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_HD_UPGEAR_NEED_BUFFER);
        Context context2 = view.getContext();
        k21.h(context2, "itemView.context");
        this.mMinHeight = u50.b(context2, 70);
        Context context3 = view.getContext();
        k21.h(context3, "itemView.context");
        this.mHeightShouldFold = ((float) DisplayMetrics.getheightPixels(u50.f(context3))) / 5.0f;
        Context context4 = view.getContext();
        k21.h(context4, "itemView.context");
        this.mContext = context4;
        view.addOnAttachStateChangeListener(new a(this));
        nestedBanner.setViewBinder(new mh1(new b(this)));
        nestedBanner.setAutoPlayCondition(new c(this));
        k21.h(nestedBannerIndicatorView, "mIndicator");
        nestedBanner.setViewIndicator(nestedBannerIndicatorView);
    }

    private final void ensureCancelLastAnimator() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1169068394")) {
            ipChange.ipc$dispatch("1169068394", new Object[]{this});
            return;
        }
        ValueAnimator valueAnimator = this.mCollapseAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            valueAnimator.cancel();
        }
        this.mCollapseAnimator = null;
    }

    private final void expandBannerView(boolean z, boolean z2, Function1<? super Boolean, ur2> function1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1427132198")) {
            ipChange.ipc$dispatch("-1427132198", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2), function1});
            return;
        }
        ensureCancelLastAnimator();
        ViewGroup viewGroup = this.mBannerContainer;
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        if (layoutParams != null) {
            k21.h(layoutParams, "layoutParams");
            int i = z ? this.mMaxHeight : this.mMinHeight;
            int i2 = layoutParams.height;
            if (i == i2) {
                function1.invoke(Boolean.FALSE);
            } else if (!z2) {
                viewGroup.getLayoutParams().height = i;
                function1.invoke(Boolean.TRUE);
                viewGroup.requestLayout();
            } else {
                ValueAnimator ofInt = ValueAnimator.ofInt(i2, i);
                this.mCollapseAnimator = ofInt;
                ofInt.setDuration(150L);
                ofInt.addListener(new d(function1));
                ofInt.addUpdateListener(new lh1(layoutParams, this, viewGroup));
                ofInt.start();
            }
        }
    }

    static /* synthetic */ void expandBannerView$default(NestedBannerView nestedBannerView, boolean z, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        nestedBannerView.expandBannerView(z, z2, function1);
    }

    /* access modifiers changed from: private */
    /* renamed from: expandBannerView$lambda-3$lambda-2$lambda-1$lambda-0  reason: not valid java name */
    public static final void m109expandBannerView$lambda3$lambda2$lambda1$lambda0(ViewGroup.LayoutParams layoutParams, NestedBannerView nestedBannerView, ViewGroup viewGroup, ValueAnimator valueAnimator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1508543709")) {
            ipChange.ipc$dispatch("1508543709", new Object[]{layoutParams, nestedBannerView, viewGroup, valueAnimator});
            return;
        }
        k21.i(layoutParams, "$this_layoutP");
        k21.i(nestedBannerView, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        k21.g(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        int i = layoutParams.height - intValue;
        layoutParams.height = intValue;
        NestedRecyclerView nestedRecyclerView = nestedBannerView.mNestedRecyclerView;
        if (nestedRecyclerView != null) {
            nestedRecyclerView.scrollBy(0, -i);
        }
        viewGroup.requestLayout();
    }

    private final boolean isBannerViewSupportExpand() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-646829695")) {
            return ((Boolean) ipChange.ipc$dispatch("-646829695", new Object[]{this})).booleanValue();
        } else if (this.isLargeScreen || this.mSuperList.isEmpty()) {
            return false;
        } else {
            Object c2 = wm2.INSTANCE.c(this.mCurList, this.mBanner.getCurrentItem());
            if (c2 instanceof NestedBannerBean) {
                return ((NestedBannerBean) c2).isSuperFrameBanner();
            }
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0049 A[Catch:{ Exception -> 0x0029 }] */
    private final boolean isNeedUpdateBanner(List<? extends NestedBannerBean> list) {
        boolean z;
        Iterator<NestedBannerBean> it;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "503022495")) {
            return ((Boolean) ipChange.ipc$dispatch("503022495", new Object[]{this, list})).booleanValue();
        }
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    z = false;
                    if (!z || this.mTotalList.size() != list.size()) {
                        return true;
                    }
                    it = this.mTotalList.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        int i2 = i + 1;
                        if (!k21.d(it.next(), list.get(i))) {
                            return true;
                        }
                        i = i2;
                    }
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }
        z = true;
        if (!z) {
            return true;
        }
        it = this.mTotalList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void showBannerView(boolean z) {
        Object c2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2107844509")) {
            ipChange.ipc$dispatch("-2107844509", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isInSuperFrameState = z;
        ArrayList<NestedBannerBean> arrayList = this.mCurList;
        int currentItem = this.mBanner.getCurrentItem();
        ArrayList<NestedBannerBean> arrayList2 = z ? this.mSuperList : this.mTotalList;
        this.mCurList = arrayList2;
        this.mBanner.forceUpdate(arrayList2);
        if (arrayList != null && this.mCurList != null && (c2 = wm2.INSTANCE.c(arrayList, currentItem)) != null) {
            ArrayList<NestedBannerBean> arrayList3 = this.mCurList;
            k21.f(arrayList3);
            int i = CollectionsKt___CollectionsKt.U(arrayList3, c2);
            if (i >= 0) {
                this.mBanner.setCurrentItem(i, false);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void showFirstInitItem() {
        IpChange ipChange = $ipChange;
        int i = 1;
        if (AndroidInstantRuntime.support(ipChange, "2090374581")) {
            ipChange.ipc$dispatch("2090374581", new Object[]{this});
            return;
        }
        int size = this.mTotalList.size();
        if (size <= 0) {
            return;
        }
        if (this.isLargeScreen) {
            if (size < 3) {
                i = 0;
            }
            this.mBanner.setCurrentItem(i, false);
            return;
        }
        this.mBanner.setCurrentItem(0, false);
    }

    @Override // com.alibaba.pictures.bricks.component.home.NestedBannerContract.View
    public void bind(@Nullable List<? extends NestedBannerBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "629566003")) {
            ipChange.ipc$dispatch("629566003", new Object[]{this, list});
        } else if (!isNeedUpdateBanner(list)) {
            vc vcVar = vc.INSTANCE;
            vc.b(vcVar, "Banner " + this.mBanner.hashCode() + " same data return", null, 2, null);
        } else {
            vc vcVar2 = vc.INSTANCE;
            vc.b(vcVar2, "Banner " + this.mBanner.hashCode() + " bind new data", null, 2, null);
            this.mBanner.stopAnimation();
            ensureCancelLastAnimator();
            this.mTotalList.clear();
            this.mSuperList.clear();
            if (list != null) {
                for (NestedBannerBean nestedBannerBean : list) {
                    this.mTotalList.add(nestedBannerBean);
                    if (nestedBannerBean.isSuperFrameBanner()) {
                        this.mSuperList.add(nestedBannerBean);
                    }
                }
            }
            showBannerView(false);
            showFirstInitItem();
            expandBannerView(false, false, new NestedBannerView$bind$2(this));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // com.alibaba.pictures.bricks.view.NestedListener
    public void dispatchNestedPreScroll(int i, int i2, @Nullable int[] iArr) {
        ViewGroup.LayoutParams layoutParams;
        int i3;
        IpChange ipChange = $ipChange;
        int i4 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-260306726")) {
            ipChange.ipc$dispatch("-260306726", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), iArr});
        } else if (i2 != 0 && this.mBanner.isSelfAttachedToWindow() && isBannerViewSupportExpand() && (layoutParams = this.mBannerContainer.getLayoutParams()) != null) {
            this.mLastMove = Integer.valueOf(i2);
            int i5 = layoutParams.height;
            if (i2 > 0) {
                if (i5 < this.mMaxHeight) {
                    if (!this.isInSuperFrameState) {
                        showBannerView(true);
                    }
                    i3 = ww1.d(this.mMaxHeight, i2 + i5);
                    layoutParams.height = i3;
                    this.mBannerContainer.requestLayout();
                }
                if (iArr == null && iArr.length == 2) {
                    iArr[1] = i4;
                    return;
                }
                return;
            } else if (((float) this.itemView.getTop()) > this.mHeightShouldFold) {
                int i6 = this.mMinHeight;
                if (i5 > i6) {
                    i3 = ww1.a(i6, i2 + i5);
                    layoutParams.height = i3;
                    this.mBannerContainer.requestLayout();
                }
                if (iArr == null) {
                    return;
                }
                return;
            } else {
                return;
            }
            i4 = i3 - i5;
            if (iArr == null) {
            }
        }
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1502043007")) {
            return this.itemView;
        }
        return (View) ipChange.ipc$dispatch("1502043007", new Object[]{this});
    }

    @Nullable
    public final OnBannerListener getMBannerListener() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1544438240")) {
            return this.mBannerListener;
        }
        return (OnBannerListener) ipChange.ipc$dispatch("1544438240", new Object[]{this});
    }

    @Override // com.alibaba.pictures.bricks.component.home.NestedBannerContract.View
    public boolean isLargeScreenMode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "178947407")) {
            return this.isLargeScreen;
        }
        return ((Boolean) ipChange.ipc$dispatch("178947407", new Object[]{this})).booleanValue();
    }

    public final void setMBannerListener(@Nullable OnBannerListener onBannerListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2105326764")) {
            ipChange.ipc$dispatch("-2105326764", new Object[]{this, onBannerListener});
            return;
        }
        this.mBannerListener = onBannerListener;
    }

    @Override // com.alibaba.pictures.bricks.component.home.NestedBannerContract.View
    public void setScreenMode(boolean z) {
        IpChange ipChange = $ipChange;
        int i = 0;
        int i2 = 2;
        if (AndroidInstantRuntime.support(ipChange, "-1796086182")) {
            ipChange.ipc$dispatch("-1796086182", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mBanner.stopAnimation();
        ensureCancelLastAnimator();
        this.isLargeScreen = z;
        ViewGroup viewGroup = this.mBannerContainer;
        if (viewGroup != null) {
            viewGroup.setClipChildren(!z);
        }
        NestedBanner nestedBanner = this.mBanner;
        if (nestedBanner != null) {
            nestedBanner.setClipChildren(!z);
            if (!z) {
                i2 = 1;
            }
            nestedBanner.setOffscreenPageLimit(i2);
            if (z) {
                i = u50.INSTANCE.b(this.mContext, 6);
            }
            nestedBanner.setPageMargin(i);
            ViewGroup.LayoutParams layoutParams = nestedBanner.getLayoutParams();
            if (layoutParams != null) {
                k21.h(layoutParams, "layoutParams");
                int i3 = -1;
                if (z) {
                    int i4 = (int) (((float) this.mMinHeight) * 5.1f);
                    u50 u50 = u50.INSTANCE;
                    if (DisplayMetrics.getwidthPixels(u50.f(this.mContext)) - u50.b(this.mContext, 36) > i4) {
                        i3 = i4;
                    }
                    layoutParams.width = i3;
                    nestedBanner.requestLayout();
                } else {
                    layoutParams.width = -1;
                    nestedBanner.requestLayout();
                }
            }
        }
        expandBannerView$default(this, false, false, new NestedBannerView$setScreenMode$3(this), 2, null);
    }

    @Override // com.alibaba.pictures.bricks.view.NestedListener
    public void startNestedScroll() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-299830619")) {
            ipChange.ipc$dispatch("-299830619", new Object[]{this});
            return;
        }
        this.mBanner.stopAnimation();
        ensureCancelLastAnimator();
        this.mLastMove = null;
    }

    @Override // com.alibaba.pictures.bricks.view.NestedListener
    public void stopNestedScroll() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2025261543")) {
            ipChange.ipc$dispatch("-2025261543", new Object[]{this});
            return;
        }
        if (isBannerViewSupportExpand()) {
            Integer num = this.mLastMove;
            if (num != null) {
                boolean z = num.intValue() >= 0;
                expandBannerView$default(this, z, false, new NestedBannerView$stopNestedScroll$1$1(z, this), 2, null);
            } else {
                num = null;
            }
            if (num == null) {
                this.mBanner.startAnimation();
            }
        } else {
            expandBannerView$default(this, false, false, new NestedBannerView$stopNestedScroll$3(this), 2, null);
        }
        this.mLastMove = null;
    }
}
