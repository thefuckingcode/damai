package com.alibaba.pictures.bricks.component.home;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.bean.HeadAtmosphereBean;
import com.alibaba.pictures.bricks.component.home.NewHeadAtmosphereContract;
import com.alibaba.pictures.bricks.view.SafeLottieAnimationView;
import com.alient.onearch.adapter.view.AbsView;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.image.SuccessEvent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.kubus.Event;
import com.youku.kubus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ci1;
import tb.di1;
import tb.ei1;
import tb.f8;
import tb.fi1;
import tb.g8;
import tb.gi1;
import tb.k21;

/* compiled from: Taobao */
public final class NewHeadAtmosphereView extends AbsView<GenericItem<ItemValue>, NewHeadAtmosphereModel, NewHeadAtmospherePresent> implements NewHeadAtmosphereContract.View, View.OnAttachStateChangeListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isHasClickArea;
    @NotNull
    private final View itemView;
    @Nullable
    private Activity mActivity;
    private View mClickView;
    @Nullable
    private HeadAtmosphereBean mCurBean;
    @Nullable
    private State mCurState;
    @Nullable
    private EventBus mEventBus;
    private View mHeadLayout;
    private ImageView mImgView;
    @Nullable
    private Boolean mIsLargeScreen;
    private final int mLayoutRid = R$layout.bricks_new_component_head_atmosphere;
    private SafeLottieAnimationView mLottieView;
    @Nullable
    private RecyclerView mRecyclerView;
    @NotNull
    private final NewHeadAtmosphereView$mScrollListener$1 mScrollListener;

    /* compiled from: Taobao */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            iArr[State.LOTTIE_SUCCESS.ordinal()] = 1;
            iArr[State.PIC_SUCCESS.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewHeadAtmosphereView(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
        this.itemView = view;
        this.mLottieView = (SafeLottieAnimationView) view.findViewById(R$id.bricks_head_atmosphere_lottie);
        this.mImgView = (ImageView) view.findViewById(R$id.bricks_head_atmosphere_pic);
        this.mClickView = view.findViewById(R$id.bricks_head_atmosphere_click_area);
        this.mHeadLayout = view.findViewById(R$id.bricks_head_layout);
        SafeLottieAnimationView safeLottieAnimationView = this.mLottieView;
        safeLottieAnimationView.addLottieOnCompositionLoadedListener(new di1(this));
        safeLottieAnimationView.setFailureListener(new ci1(this));
        safeLottieAnimationView.setDrawFailListener(new ei1(this));
        view.addOnAttachStateChangeListener(this);
        this.mScrollListener = new NewHeadAtmosphereView$mScrollListener$1(this);
    }

    private final void dispatchStateEvent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2003043937")) {
            ipChange.ipc$dispatch("-2003043937", new Object[]{this});
            return;
        }
        EventBus eventBus = this.mEventBus;
        if (eventBus != null) {
            Event event = new Event(f8.KEY_EVENT_ATMOSPHERE_STATE);
            event.data = new StateAtmo(this.mCurState, this.mCurBean);
            eventBus.post(event);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-4$lambda-0  reason: not valid java name */
    public static final void m110lambda4$lambda0(NewHeadAtmosphereView newHeadAtmosphereView, com.airbnb.lottie.a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "414205287")) {
            ipChange.ipc$dispatch("414205287", new Object[]{newHeadAtmosphereView, aVar});
            return;
        }
        k21.i(newHeadAtmosphereView, "this$0");
        newHeadAtmosphereView.showViewHeight(State.LOTTIE_SUCCESS);
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-4$lambda-2  reason: not valid java name */
    public static final void m111lambda4$lambda2(NewHeadAtmosphereView newHeadAtmosphereView, Throwable th) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1995368531")) {
            ipChange.ipc$dispatch("-1995368531", new Object[]{newHeadAtmosphereView, th});
            return;
        }
        k21.i(newHeadAtmosphereView, "this$0");
        th.printStackTrace();
        f8 f8Var = f8.INSTANCE;
        HeadAtmosphereBean headAtmosphereBean = newHeadAtmosphereView.mCurBean;
        f8Var.f(headAtmosphereBean, "2", "Atmosphere Fail setAnimationFromUrl :" + th.getMessage());
        newHeadAtmosphereView.showViewHeight(State.INIT);
        HeadAtmosphereBean headAtmosphereBean2 = newHeadAtmosphereView.mCurBean;
        if (headAtmosphereBean2 != null && (str = headAtmosphereBean2.backgroundPic) != null) {
            newHeadAtmosphereView.loadStaticPicAtmosphere(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-4$lambda-3  reason: not valid java name */
    public static final void m112lambda4$lambda3(NewHeadAtmosphereView newHeadAtmosphereView, Throwable th, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1741103019")) {
            ipChange.ipc$dispatch("-1741103019", new Object[]{newHeadAtmosphereView, th, Integer.valueOf(i)});
            return;
        }
        k21.i(newHeadAtmosphereView, "this$0");
        if (i < 4) {
            th.printStackTrace();
            f8 f8Var = f8.INSTANCE;
            HeadAtmosphereBean headAtmosphereBean = newHeadAtmosphereView.mCurBean;
            f8Var.f(headAtmosphereBean, "1", "Atmosphere Fail Lottie onDraw :" + th.getMessage());
        }
    }

    private final void loadStaticPicAtmosphere(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1461275398")) {
            ipChange.ipc$dispatch("-1461275398", new Object[]{this, str});
            return;
        }
        ImageLoaderProviderProxy.load(str, new gi1(this), new fi1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: loadStaticPicAtmosphere$lambda-7  reason: not valid java name */
    public static final void m113loadStaticPicAtmosphere$lambda7(NewHeadAtmosphereView newHeadAtmosphereView, SuccessEvent successEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1548878719")) {
            ipChange.ipc$dispatch("1548878719", new Object[]{newHeadAtmosphereView, successEvent});
            return;
        }
        k21.i(newHeadAtmosphereView, "this$0");
        Drawable drawable = successEvent.drawable;
        if (drawable != null) {
            newHeadAtmosphereView.mImgView.setImageDrawable(drawable);
            newHeadAtmosphereView.showViewHeight(State.PIC_SUCCESS);
            return;
        }
        newHeadAtmosphereView.showViewHeight(State.INIT);
        f8.INSTANCE.f(newHeadAtmosphereView.mCurBean, "3", "Atmosphere Fail pic load none drawable");
    }

    /* access modifiers changed from: private */
    /* renamed from: loadStaticPicAtmosphere$lambda-8  reason: not valid java name */
    public static final void m114loadStaticPicAtmosphere$lambda8(NewHeadAtmosphereView newHeadAtmosphereView, FailEvent failEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1832996863")) {
            ipChange.ipc$dispatch("1832996863", new Object[]{newHeadAtmosphereView, failEvent});
            return;
        }
        k21.i(newHeadAtmosphereView, "this$0");
        newHeadAtmosphereView.showViewHeight(State.INIT);
        f8 f8Var = f8.INSTANCE;
        HeadAtmosphereBean headAtmosphereBean = newHeadAtmosphereView.mCurBean;
        f8Var.f(headAtmosphereBean, "3", "Atmosphere Fail pic load code=: " + failEvent.resultCode);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    private final void showViewHeight(State state) {
        int a2;
        int i;
        int i2;
        IpChange ipChange = $ipChange;
        int i3 = 1;
        if (AndroidInstantRuntime.support(ipChange, "-665378479")) {
            ipChange.ipc$dispatch("-665378479", new Object[]{this, state});
            return;
        }
        this.mCurState = state;
        dispatchStateEvent();
        int i4 = a.$EnumSwitchMapping$0[state.ordinal()];
        if (i4 == 1) {
            this.mLottieView.setVisibility(0);
            this.mImgView.setVisibility(8);
        } else if (i4 != 2) {
            this.mLottieView.setVisibility(8);
            this.mImgView.setVisibility(8);
        } else {
            this.mLottieView.setVisibility(8);
            this.mImgView.setVisibility(0);
        }
        Activity activity = this.mActivity;
        if (activity != null) {
            g8 a3 = f8.INSTANCE.a(activity);
            ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
            if (layoutParams != null) {
                k21.h(layoutParams, "layoutParams");
                int i5 = layoutParams.height;
                if (state != State.INIT) {
                    if (state == State.LOTTIE_SUCCESS || state == State.PIC_SUCCESS) {
                        i = a3.b();
                        i2 = a3.c();
                    }
                    a2 = (a3.a() - a3.d()) - i3;
                    double c = ((double) a3.c()) * 0.2d;
                    if (a2 < 0) {
                    }
                    this.mHeadLayout.scrollTo(0, 0);
                    if (i5 != i3) {
                    }
                } else if (this.isHasClickArea) {
                    i3 = a3.b();
                    a2 = (a3.a() - a3.d()) - i3;
                    double c2 = ((double) a3.c()) * 0.2d;
                    if (a2 < 0 || ((double) Math.abs(a2)) > c2) {
                        this.mHeadLayout.scrollTo(0, 0);
                    } else {
                        this.mHeadLayout.scrollTo(0, -a2);
                    }
                    if (i5 != i3) {
                        layoutParams.height = i3;
                        this.itemView.requestLayout();
                        return;
                    }
                    return;
                } else {
                    i = a3.b();
                    i2 = a3.c();
                }
                i3 = i + i2;
                a2 = (a3.a() - a3.d()) - i3;
                double c22 = ((double) a3.c()) * 0.2d;
                if (a2 < 0) {
                }
                this.mHeadLayout.scrollTo(0, 0);
                if (i5 != i3) {
                }
            }
        }
    }

    @Override // com.alibaba.pictures.bricks.component.home.NewHeadAtmosphereContract.View
    public void bindView(@Nullable RecyclerView recyclerView, boolean z, @NotNull Activity activity, @Nullable EventBus eventBus, @Nullable HeadAtmosphereBean headAtmosphereBean) {
        State state;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2000485353")) {
            ipChange.ipc$dispatch("2000485353", new Object[]{this, recyclerView, Boolean.valueOf(z), activity, eventBus, headAtmosphereBean});
            return;
        }
        k21.i(activity, "activity");
        Boolean bool = this.mIsLargeScreen;
        this.mIsLargeScreen = Boolean.valueOf(z);
        this.mActivity = activity;
        this.mEventBus = eventBus;
        this.mRecyclerView = recyclerView;
        f8.INSTANCE.e(this.itemView);
        if (headAtmosphereBean == null || !headAtmosphereBean.isValid()) {
            showViewHeight(State.INVALID);
            this.mCurBean = null;
            dispatchStateEvent();
        } else if (!State.Companion.a(this.mCurState) || !k21.d(headAtmosphereBean, this.mCurBean)) {
            this.mCurBean = headAtmosphereBean;
            this.isHasClickArea = headAtmosphereBean.isShowPlaceholderHeight();
            showViewHeight(State.INIT);
            if (headAtmosphereBean.isLottieAtmosphere()) {
                this.mLottieView.setAnimationFromUrl(headAtmosphereBean.lottie);
            } else if (headAtmosphereBean.isPicAtmosphere()) {
                loadStaticPicAtmosphere(headAtmosphereBean.backgroundPic);
            }
        } else {
            this.mCurBean = headAtmosphereBean;
            if (!k21.d(Boolean.valueOf(z), bool) && (state = this.mCurState) != null) {
                showViewHeight(state);
            }
            dispatchStateEvent();
        }
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1904272284")) {
            return this.itemView;
        }
        return (View) ipChange.ipc$dispatch("1904272284", new Object[]{this});
    }

    public void onViewAttachedToWindow(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1669362685")) {
            ipChange.ipc$dispatch("-1669362685", new Object[]{this, view});
            return;
        }
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(this.mScrollListener);
        }
    }

    public void onViewDetachedFromWindow(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2111235136")) {
            ipChange.ipc$dispatch("-2111235136", new Object[]{this, view});
            return;
        }
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.removeOnScrollListener(this.mScrollListener);
        }
    }

    @Override // com.alibaba.pictures.bricks.component.home.NewHeadAtmosphereContract.View
    public void scrollChanged(@NotNull RecyclerView recyclerView, int i) {
        SafeLottieAnimationView safeLottieAnimationView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1509825267")) {
            ipChange.ipc$dispatch("-1509825267", new Object[]{this, recyclerView, Integer.valueOf(i)});
            return;
        }
        k21.i(recyclerView, "recyclerView");
        if (State.LOTTIE_SUCCESS == this.mCurState && (safeLottieAnimationView = this.mLottieView) != null) {
            try {
                if (!safeLottieAnimationView.isAttachedToWindow() || safeLottieAnimationView.getVisibility() != 0) {
                    return;
                }
                if (i == 0) {
                    if (!safeLottieAnimationView.isAnimating()) {
                        safeLottieAnimationView.resumeAnimation();
                    }
                } else if (safeLottieAnimationView.isAnimating()) {
                    safeLottieAnimationView.pauseAnimation();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
