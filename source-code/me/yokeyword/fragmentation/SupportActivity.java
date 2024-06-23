package me.yokeyword.fragmentation;

import android.os.Bundle;
import android.view.MotionEvent;
import androidx.appcompat.app.AppCompatActivity;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

public class SupportActivity extends AppCompatActivity implements ISupportActivity {
    final SupportActivityDelegate mDelegate = new SupportActivityDelegate(this);

    @Override // me.yokeyword.fragmentation.ISupportActivity
    public SupportActivityDelegate getSupportDelegate() {
        return this.mDelegate;
    }

    @Override // me.yokeyword.fragmentation.ISupportActivity
    public ExtraTransaction extraTransaction() {
        return this.mDelegate.extraTransaction();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mDelegate.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.mDelegate.onPostCreate(bundle);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        this.mDelegate.onDestroy();
        super.onDestroy();
    }

    @Override // me.yokeyword.fragmentation.ISupportActivity
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.mDelegate.dispatchTouchEvent(motionEvent) || super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.activity.ComponentActivity, me.yokeyword.fragmentation.ISupportActivity
    public final void onBackPressed() {
        this.mDelegate.onBackPressed();
    }

    @Override // me.yokeyword.fragmentation.ISupportActivity
    public void onBackPressedSupport() {
        this.mDelegate.onBackPressedSupport();
    }

    @Override // me.yokeyword.fragmentation.ISupportActivity
    public FragmentAnimator getFragmentAnimator() {
        return this.mDelegate.getFragmentAnimator();
    }

    @Override // me.yokeyword.fragmentation.ISupportActivity
    public void setFragmentAnimator(FragmentAnimator fragmentAnimator) {
        this.mDelegate.setFragmentAnimator(fragmentAnimator);
    }

    @Override // me.yokeyword.fragmentation.ISupportActivity
    public FragmentAnimator onCreateFragmentAnimator() {
        return this.mDelegate.onCreateFragmentAnimator();
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

    public void popTo(Class<?> cls, boolean z) {
        this.mDelegate.popTo(cls, z);
    }

    public void popTo(Class<?> cls, boolean z, Runnable runnable) {
        this.mDelegate.popTo(cls, z, runnable);
    }

    public void popTo(Class<?> cls, boolean z, Runnable runnable, int i) {
        this.mDelegate.popTo(cls, z, runnable, i);
    }

    public void setDefaultFragmentBackground(int i) {
        this.mDelegate.setDefaultFragmentBackground(i);
    }

    public ISupportFragment getTopFragment() {
        return SupportHelper.getTopFragment(getSupportFragmentManager());
    }

    public <T extends ISupportFragment> T findFragment(Class<T> cls) {
        return (T) SupportHelper.findFragment(getSupportFragmentManager(), cls);
    }
}
