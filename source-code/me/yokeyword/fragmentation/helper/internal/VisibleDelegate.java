package me.yokeyword.fragmentation.helper.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentationHack;
import java.util.List;
import me.yokeyword.fragmentation.ISupportFragment;

public class VisibleDelegate {
    private static final String FRAGMENTATION_STATE_SAVE_COMPAT_REPLACE = "fragmentation_compat_replace";
    private static final String FRAGMENTATION_STATE_SAVE_IS_INVISIBLE_WHEN_LEAVE = "fragmentation_invisible_when_leave";
    private boolean mFirstCreateViewCompatReplace = true;
    private boolean mFixStatePagerAdapter;
    private Fragment mFragment;
    private Handler mHandler;
    private boolean mInvisibleWhenLeave;
    private boolean mIsFirstVisible = true;
    private boolean mIsSupportVisible;
    private boolean mNeedDispatch = true;
    private Bundle mSaveInstanceState;
    private ISupportFragment mSupportF;

    public VisibleDelegate(ISupportFragment iSupportFragment) {
        this.mSupportF = iSupportFragment;
        this.mFragment = (Fragment) iSupportFragment;
    }

    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            this.mSaveInstanceState = bundle;
            if (!this.mFixStatePagerAdapter) {
                this.mInvisibleWhenLeave = bundle.getBoolean(FRAGMENTATION_STATE_SAVE_IS_INVISIBLE_WHEN_LEAVE);
                this.mFirstCreateViewCompatReplace = bundle.getBoolean(FRAGMENTATION_STATE_SAVE_COMPAT_REPLACE);
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(FRAGMENTATION_STATE_SAVE_IS_INVISIBLE_WHEN_LEAVE, this.mInvisibleWhenLeave);
        bundle.putBoolean(FRAGMENTATION_STATE_SAVE_COMPAT_REPLACE, this.mFirstCreateViewCompatReplace);
    }

    public void onActivityCreated(Bundle bundle) {
        if (this.mFirstCreateViewCompatReplace || this.mFragment.getTag() == null || !this.mFragment.getTag().startsWith("android:switcher:")) {
            if (this.mFirstCreateViewCompatReplace) {
                this.mFirstCreateViewCompatReplace = false;
            }
            if (!this.mInvisibleWhenLeave && !this.mFragment.isHidden()) {
                if (!this.mFragment.getUserVisibleHint() && !this.mFixStatePagerAdapter) {
                    return;
                }
                if ((this.mFragment.getParentFragment() != null && isFragmentVisible(this.mFragment.getParentFragment())) || this.mFragment.getParentFragment() == null) {
                    this.mNeedDispatch = false;
                    safeDispatchUserVisibleHint(true);
                }
            }
        }
    }

    public void onResume() {
        if (!this.mIsFirstVisible && !this.mIsSupportVisible && !this.mInvisibleWhenLeave && isFragmentVisible(this.mFragment)) {
            this.mNeedDispatch = false;
            dispatchSupportVisible(true);
        }
    }

    public void onPause() {
        if (!this.mIsSupportVisible || !isFragmentVisible(this.mFragment)) {
            this.mInvisibleWhenLeave = true;
            return;
        }
        this.mNeedDispatch = false;
        this.mInvisibleWhenLeave = false;
        dispatchSupportVisible(false);
    }

    public void onHiddenChanged(boolean z) {
        if (!z && !this.mFragment.isResumed()) {
            this.mInvisibleWhenLeave = false;
        } else if (z) {
            safeDispatchUserVisibleHint(false);
        } else {
            enqueueDispatchVisible();
        }
    }

    public void onDestroyView() {
        this.mIsFirstVisible = true;
        this.mFixStatePagerAdapter = false;
    }

    public void setUserVisibleHint(boolean z) {
        if (this.mFragment.isResumed() || (this.mFragment.isDetached() && z)) {
            boolean z2 = this.mIsSupportVisible;
            if (!z2 && z) {
                safeDispatchUserVisibleHint(true);
            } else if (z2 && !z) {
                dispatchSupportVisible(false);
            }
        } else if (z) {
            this.mInvisibleWhenLeave = false;
            this.mFixStatePagerAdapter = true;
        }
    }

    private void safeDispatchUserVisibleHint(boolean z) {
        if (!this.mIsFirstVisible) {
            dispatchSupportVisible(z);
        } else if (z) {
            enqueueDispatchVisible();
        }
    }

    private void enqueueDispatchVisible() {
        getHandler().post(new Runnable() {
            /* class me.yokeyword.fragmentation.helper.internal.VisibleDelegate.AnonymousClass1 */

            public void run() {
                VisibleDelegate.this.dispatchSupportVisible(true);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void dispatchSupportVisible(boolean z) {
        List<Fragment> activeFragments;
        if (this.mIsSupportVisible == z) {
            this.mNeedDispatch = true;
            return;
        }
        this.mIsSupportVisible = z;
        if (!this.mNeedDispatch) {
            this.mNeedDispatch = true;
        } else if (!checkAddState()) {
            FragmentManager childFragmentManager = this.mFragment.getChildFragmentManager();
            if (!(childFragmentManager == null || (activeFragments = FragmentationHack.getActiveFragments(childFragmentManager)) == null)) {
                for (Fragment fragment : activeFragments) {
                    if ((fragment instanceof ISupportFragment) && !fragment.isHidden() && fragment.getUserVisibleHint()) {
                        ((ISupportFragment) fragment).getSupportDelegate().getVisibleDelegate().dispatchSupportVisible(z);
                    }
                }
            }
        } else {
            return;
        }
        if (!z) {
            this.mSupportF.onSupportInvisible();
        } else if (!checkAddState()) {
            this.mSupportF.onSupportVisible();
            if (this.mIsFirstVisible) {
                this.mIsFirstVisible = false;
                this.mSupportF.onLazyInitView(this.mSaveInstanceState);
            }
        }
    }

    private boolean checkAddState() {
        if (this.mFragment.isAdded()) {
            return false;
        }
        this.mIsSupportVisible = !this.mIsSupportVisible;
        return true;
    }

    private boolean isFragmentVisible(Fragment fragment) {
        return !fragment.isHidden() && fragment.getUserVisibleHint();
    }

    public boolean isSupportVisible() {
        return this.mIsSupportVisible;
    }

    private Handler getHandler() {
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
        return this.mHandler;
    }
}
