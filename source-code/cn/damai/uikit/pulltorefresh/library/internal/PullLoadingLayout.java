package cn.damai.uikit.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.pulltorefresh.library.PullToRefreshBase;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class PullLoadingLayout extends LoadingLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    AnimationDrawable mHeaderImageAnimationDrawable;
    PullLoadingLayoutInferface pullLoadingLayoutInImp;

    public PullLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray, true);
        this.mHeaderImage.setBackgroundResource(R$drawable.uikit_pull_to_refresh_loading);
        AnimationDrawable animationDrawable = (AnimationDrawable) this.mHeaderImage.getBackground();
        this.mHeaderImageAnimationDrawable = animationDrawable;
        animationDrawable.setOneShot(false);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    public int getDefaultDrawableResId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1608054769")) {
            return R$drawable.uikit_pull_to_refresh_logo_0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1608054769", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    public void onLoadingDrawableSet(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1469446247")) {
            ipChange.ipc$dispatch("-1469446247", new Object[]{this, drawable});
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    public void onPullImpl(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1997673704")) {
            ipChange.ipc$dispatch("1997673704", new Object[]{this, Float.valueOf(f)});
            return;
        }
        Log.e("PullLoadingLayout", "onPullImpl scaleOfLayout = " + f);
        PullLoadingLayoutInferface pullLoadingLayoutInferface = this.pullLoadingLayoutInImp;
        if (pullLoadingLayoutInferface != null) {
            pullLoadingLayoutInferface.onPullImpl(f);
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    public void pullToRefreshImpl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-71238157")) {
            ipChange.ipc$dispatch("-71238157", new Object[]{this});
            return;
        }
        this.mHeaderImageAnimationDrawable.start();
        Log.e("PullLoadingLayout", "pullToRefreshImpl ");
        PullLoadingLayoutInferface pullLoadingLayoutInferface = this.pullLoadingLayoutInImp;
        if (pullLoadingLayoutInferface != null) {
            pullLoadingLayoutInferface.pullToRefreshImpl();
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    public void refreshingImpl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1197388437")) {
            ipChange.ipc$dispatch("1197388437", new Object[]{this});
            return;
        }
        this.mHeaderImage.setVisibility(0);
        this.mHeaderProgress.setVisibility(8);
        Log.e("PullLoadingLayout", "refreshingImpl ");
        PullLoadingLayoutInferface pullLoadingLayoutInferface = this.pullLoadingLayoutInImp;
        if (pullLoadingLayoutInferface != null) {
            pullLoadingLayoutInferface.refreshingImpl();
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    public void releaseToRefreshImpl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-958571357")) {
            ipChange.ipc$dispatch("-958571357", new Object[]{this});
            return;
        }
        this.mHeaderImageAnimationDrawable.stop();
        Log.e("PullLoadingLayout", "releaseToRefreshImpl ");
        PullLoadingLayoutInferface pullLoadingLayoutInferface = this.pullLoadingLayoutInImp;
        if (pullLoadingLayoutInferface != null) {
            pullLoadingLayoutInferface.releaseToRefreshImpl();
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout
    public void resetImpl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-706043329")) {
            ipChange.ipc$dispatch("-706043329", new Object[]{this});
            return;
        }
        this.mHeaderProgress.setVisibility(8);
        this.mHeaderImage.setVisibility(0);
        Log.e("PullLoadingLayout", "resetImpl ");
        PullLoadingLayoutInferface pullLoadingLayoutInferface = this.pullLoadingLayoutInImp;
        if (pullLoadingLayoutInferface != null) {
            pullLoadingLayoutInferface.resetImpl();
        }
    }

    public void setPullLoadingLayoutInImp(PullLoadingLayoutInferface pullLoadingLayoutInferface) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1683221737")) {
            ipChange.ipc$dispatch("1683221737", new Object[]{this, pullLoadingLayoutInferface});
            return;
        }
        this.pullLoadingLayoutInImp = pullLoadingLayoutInferface;
    }
}
