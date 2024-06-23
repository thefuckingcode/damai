package me.yokeyword.fragmentation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

public class SupportFragment extends Fragment implements ISupportFragment {
    protected FragmentActivity _mActivity;
    final SupportFragmentDelegate mDelegate = new SupportFragmentDelegate(this);

    @Override // me.yokeyword.fragmentation.ISupportFragment
    public SupportFragmentDelegate getSupportDelegate() {
        return this.mDelegate;
    }

    @Override // me.yokeyword.fragmentation.ISupportFragment
    public ExtraTransaction extraTransaction() {
        return this.mDelegate.extraTransaction();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mDelegate.onAttach(activity);
        this._mActivity = this.mDelegate.getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mDelegate.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return this.mDelegate.onCreateAnimation(i, z, i2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mDelegate.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.mDelegate.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mDelegate.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mDelegate.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.mDelegate.onDestroyView();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.mDelegate.onDestroy();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        this.mDelegate.onHiddenChanged(z);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.mDelegate.setUserVisibleHint(z);
    }

    @Override // me.yokeyword.fragmentation.ISupportFragment
    public void enqueueAction(Runnable runnable) {
        this.mDelegate.enqueueAction(runnable);
    }

    @Override // me.yokeyword.fragmentation.ISupportFragment
    public void onEnterAnimationEnd(Bundle bundle) {
        this.mDelegate.onEnterAnimationEnd(bundle);
    }

    @Override // me.yokeyword.fragmentation.ISupportFragment
    public void onLazyInitView(Bundle bundle) {
        this.mDelegate.onLazyInitView(bundle);
    }

    @Override // me.yokeyword.fragmentation.ISupportFragment
    public void onSupportVisible() {
        this.mDelegate.onSupportVisible();
    }

    @Override // me.yokeyword.fragmentation.ISupportFragment
    public void onSupportInvisible() {
        this.mDelegate.onSupportInvisible();
    }

    @Override // me.yokeyword.fragmentation.ISupportFragment
    public final boolean isSupportVisible() {
        return this.mDelegate.isSupportVisible();
    }

    @Override // me.yokeyword.fragmentation.ISupportFragment
    public FragmentAnimator onCreateFragmentAnimator() {
        return this.mDelegate.onCreateFragmentAnimator();
    }

    @Override // me.yokeyword.fragmentation.ISupportFragment
    public FragmentAnimator getFragmentAnimator() {
        return this.mDelegate.getFragmentAnimator();
    }

    @Override // me.yokeyword.fragmentation.ISupportFragment
    public void setFragmentAnimator(FragmentAnimator fragmentAnimator) {
        this.mDelegate.setFragmentAnimator(fragmentAnimator);
    }

    @Override // me.yokeyword.fragmentation.ISupportFragment
    public boolean onBackPressedSupport() {
        return this.mDelegate.onBackPressedSupport();
    }

    @Override // me.yokeyword.fragmentation.ISupportFragment
    public void setFragmentResult(int i, Bundle bundle) {
        this.mDelegate.setFragmentResult(i, bundle);
    }

    @Override // me.yokeyword.fragmentation.ISupportFragment
    public void onFragmentResult(int i, int i2, Bundle bundle) {
        this.mDelegate.onFragmentResult(i, i2, bundle);
    }

    @Override // me.yokeyword.fragmentation.ISupportFragment
    public void onNewBundle(Bundle bundle) {
        this.mDelegate.onNewBundle(bundle);
    }

    @Override // me.yokeyword.fragmentation.ISupportFragment
    public void putNewBundle(Bundle bundle) {
        this.mDelegate.putNewBundle(bundle);
    }

    /* access modifiers changed from: protected */
    public void hideSoftInput() {
        this.mDelegate.hideSoftInput();
    }

    /* access modifiers changed from: protected */
    public void showSoftInput(View view) {
        this.mDelegate.showSoftInput(view);
    }

    public void loadRootFragment(int i, ISupportFragment iSupportFragment) {
        this.mDelegate.loadRootFragment(i, iSupportFragment);
    }

    public void loadRootFragment(int i, ISupportFragment iSupportFragment, boolean z, boolean z2) {
        this.mDelegate.loadRootFragment(i, iSupportFragment, z, z2);
    }

    public void loadMultipleRootFragment(int i, int i2, ISupportFragment... iSupportFragmentArr) {
        this.mDelegate.loadMultipleRootFragment(i, i2, iSupportFragmentArr);
    }

    public void showHideFragment(ISupportFragment iSupportFragment) {
        this.mDelegate.showHideFragment(iSupportFragment);
    }

    public void showHideFragment(ISupportFragment iSupportFragment, ISupportFragment iSupportFragment2) {
        this.mDelegate.showHideFragment(iSupportFragment, iSupportFragment2);
    }

    public void start(ISupportFragment iSupportFragment) {
        this.mDelegate.start(iSupportFragment);
    }

    public void start(ISupportFragment iSupportFragment, int i) {
        this.mDelegate.start(iSupportFragment, i);
    }

    public void startForResult(ISupportFragment iSupportFragment, int i) {
        this.mDelegate.startForResult(iSupportFragment, i);
    }

    public void startWithPop(ISupportFragment iSupportFragment) {
        this.mDelegate.startWithPop(iSupportFragment);
    }

    public void replaceFragment(ISupportFragment iSupportFragment, boolean z) {
        this.mDelegate.replaceFragment(iSupportFragment, z);
    }

    public void pop() {
        this.mDelegate.pop();
    }

    public void popChild() {
        this.mDelegate.popChild();
    }

    public void popTo(Class<?> cls, boolean z) {
        this.mDelegate.popTo(cls, z);
    }

    public void popTo(Class<?> cls, boolean z, Runnable runnable) {
        this.mDelegate.popTo(cls, z, runnable);
    }

    public void popTo(Class<?> cls, boolean z, Runnable runnable, int i) {
        this.mDelegate.popTo(cls, z, runnable, i);
    }

    public void popToChild(Class<?> cls, boolean z) {
        this.mDelegate.popToChild(cls, z);
    }

    public void popToChild(Class<?> cls, boolean z, Runnable runnable) {
        this.mDelegate.popToChild(cls, z, runnable);
    }

    public void popToChild(Class<?> cls, boolean z, Runnable runnable, int i) {
        this.mDelegate.popToChild(cls, z, runnable, i);
    }

    public ISupportFragment getTopFragment() {
        return SupportHelper.getTopFragment(getFragmentManager());
    }

    public ISupportFragment getTopChildFragment() {
        return SupportHelper.getTopFragment(getChildFragmentManager());
    }

    public ISupportFragment getPreFragment() {
        return SupportHelper.getPreFragment(this);
    }

    public <T extends ISupportFragment> T findFragment(Class<T> cls) {
        return (T) SupportHelper.findFragment(getFragmentManager(), cls);
    }

    public <T extends ISupportFragment> T findChildFragment(Class<T> cls) {
        return (T) SupportHelper.findFragment(getChildFragmentManager(), cls);
    }
}
