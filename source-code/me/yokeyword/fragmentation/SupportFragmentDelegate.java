package me.yokeyword.fragmentation;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import me.yokeyword.fragmentation.ExtraTransaction;
import me.yokeyword.fragmentation.anim.FragmentAnimator;
import me.yokeyword.fragmentation.helper.internal.AnimatorHelper;
import me.yokeyword.fragmentation.helper.internal.ResultRecord;
import me.yokeyword.fragmentation.helper.internal.TransactionRecord;
import me.yokeyword.fragmentation.helper.internal.VisibleDelegate;

public class SupportFragmentDelegate {
    static final int STATUS_ROOT_ANIM_DISABLE = 1;
    static final int STATUS_ROOT_ANIM_ENABLE = 2;
    static final int STATUS_UN_ROOT = 0;
    protected FragmentActivity _mActivity;
    boolean mAnimByActivity = true;
    AnimatorHelper mAnimHelper;
    int mContainerId;
    private int mCustomEnterAnim = Integer.MIN_VALUE;
    EnterAnimListener mEnterAnimListener;
    private boolean mFirstCreateView = true;
    private Fragment mFragment;
    FragmentAnimator mFragmentAnimator;
    private Handler mHandler;
    private boolean mIsHidden = true;
    boolean mIsSharedElement;
    boolean mLockAnim;
    Bundle mNewBundle;
    private Runnable mNotifyEnterAnimEndRunnable = new Runnable() {
        /* class me.yokeyword.fragmentation.SupportFragmentDelegate.AnonymousClass2 */

        public void run() {
            SupportFragmentDelegate.this.notifyEnterAnimEnd();
        }
    };
    private boolean mReplaceMode;
    private int mRootStatus = 0;
    private Bundle mSaveInstanceState;
    private ISupportActivity mSupport;
    private ISupportFragment mSupportF;
    private TransactionDelegate mTransactionDelegate;
    TransactionRecord mTransactionRecord;
    private VisibleDelegate mVisibleDelegate;

    /* access modifiers changed from: package-private */
    public interface EnterAnimListener {
        void onEnterAnimStart();
    }

    public boolean onBackPressedSupport() {
        return false;
    }

    public void onEnterAnimationEnd(Bundle bundle) {
    }

    public void onFragmentResult(int i, int i2, Bundle bundle) {
    }

    public void onLazyInitView(Bundle bundle) {
    }

    public void onNewBundle(Bundle bundle) {
    }

    public void onSupportInvisible() {
    }

    public void onSupportVisible() {
    }

    public SupportFragmentDelegate(ISupportFragment iSupportFragment) {
        if (iSupportFragment instanceof Fragment) {
            this.mSupportF = iSupportFragment;
            this.mFragment = (Fragment) iSupportFragment;
            return;
        }
        throw new RuntimeException("Must extends Fragment");
    }

    public ExtraTransaction extraTransaction() {
        TransactionDelegate transactionDelegate = this.mTransactionDelegate;
        if (transactionDelegate != null) {
            return new ExtraTransaction.ExtraTransactionImpl(this.mSupportF, transactionDelegate, false);
        }
        throw new RuntimeException(this.mFragment.getClass().getSimpleName() + " not attach!");
    }

    public void onAttach(Activity activity) {
        if (activity instanceof ISupportActivity) {
            ISupportActivity iSupportActivity = (ISupportActivity) activity;
            this.mSupport = iSupportActivity;
            this._mActivity = (FragmentActivity) activity;
            this.mTransactionDelegate = iSupportActivity.getSupportDelegate().getTransactionDelegate();
            return;
        }
        throw new RuntimeException(activity.getClass().getSimpleName() + " must impl ISupportActivity!");
    }

    public void onCreate(Bundle bundle) {
        getVisibleDelegate().onCreate(bundle);
        Bundle arguments = this.mFragment.getArguments();
        if (arguments != null) {
            this.mRootStatus = arguments.getInt("fragmentation_arg_root_status", 0);
            this.mIsSharedElement = arguments.getBoolean("fragmentation_arg_is_shared_element", false);
            this.mContainerId = arguments.getInt("fragmentation_arg_container");
            this.mReplaceMode = arguments.getBoolean("fragmentation_arg_replace", false);
            this.mCustomEnterAnim = arguments.getInt("fragmentation_arg_custom_end_anim", Integer.MIN_VALUE);
        }
        if (bundle == null) {
            getFragmentAnimator();
        } else {
            this.mSaveInstanceState = bundle;
            this.mFragmentAnimator = (FragmentAnimator) bundle.getParcelable("fragmentation_state_save_animator");
            this.mIsHidden = bundle.getBoolean("fragmentation_state_save_status");
            this.mContainerId = bundle.getInt("fragmentation_arg_container");
        }
        processRestoreInstanceState(bundle);
        this.mAnimHelper = new AnimatorHelper(this._mActivity.getApplicationContext(), this.mFragmentAnimator);
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        if (this.mSupport.getSupportDelegate().mPopMultipleNoAnim || this.mLockAnim) {
            if (i != 8194 || !z) {
                return this.mAnimHelper.getNoneAnim();
            }
            return this.mAnimHelper.getNoneAnimFixed();
        } else if (i == 4097) {
            if (!z) {
                return this.mAnimHelper.popExitAnim;
            }
            if (this.mRootStatus == 1) {
                return this.mAnimHelper.getNoneAnim();
            }
            Animation animation = this.mAnimHelper.enterAnim;
            fixAnimationListener(animation);
            return animation;
        } else if (i == 8194) {
            AnimatorHelper animatorHelper = this.mAnimHelper;
            return z ? animatorHelper.popEnterAnim : animatorHelper.exitAnim;
        } else {
            if (this.mIsSharedElement && z) {
                compatSharedElements();
            }
            if (!z) {
                return this.mAnimHelper.compatChildFragmentExitAnim(this.mFragment);
            }
            return null;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        getVisibleDelegate().onSaveInstanceState(bundle);
        bundle.putParcelable("fragmentation_state_save_animator", this.mFragmentAnimator);
        bundle.putBoolean("fragmentation_state_save_status", this.mFragment.isHidden());
        bundle.putInt("fragmentation_arg_container", this.mContainerId);
    }

    public void onActivityCreated(Bundle bundle) {
        getVisibleDelegate().onActivityCreated(bundle);
        View view = this.mFragment.getView();
        if (view != null) {
            view.setClickable(true);
            setBackground(view);
        }
        if (bundle != null || this.mRootStatus == 1 || ((this.mFragment.getTag() != null && this.mFragment.getTag().startsWith("android:switcher:")) || (this.mReplaceMode && !this.mFirstCreateView))) {
            notifyEnterAnimEnd();
        } else {
            int i = this.mCustomEnterAnim;
            if (i != Integer.MIN_VALUE) {
                fixAnimationListener(i == 0 ? this.mAnimHelper.getNoneAnim() : AnimationUtils.loadAnimation(this._mActivity, i));
            }
        }
        if (this.mFirstCreateView) {
            this.mFirstCreateView = false;
        }
    }

    public void onResume() {
        getVisibleDelegate().onResume();
    }

    public void onPause() {
        getVisibleDelegate().onPause();
    }

    public void onDestroyView() {
        this.mSupport.getSupportDelegate().mFragmentClickable = true;
        getVisibleDelegate().onDestroyView();
        getHandler().removeCallbacks(this.mNotifyEnterAnimEndRunnable);
    }

    public void onDestroy() {
        this.mTransactionDelegate.handleResultRecord(this.mFragment);
    }

    public void onHiddenChanged(boolean z) {
        getVisibleDelegate().onHiddenChanged(z);
    }

    public void setUserVisibleHint(boolean z) {
        getVisibleDelegate().setUserVisibleHint(z);
    }

    public void enqueueAction(Runnable runnable) {
        Handler handler = getHandler();
        AnimatorHelper animatorHelper = this.mAnimHelper;
        handler.postDelayed(runnable, animatorHelper == null ? 0 : animatorHelper.enterAnim.getDuration());
    }

    public final boolean isSupportVisible() {
        return getVisibleDelegate().isSupportVisible();
    }

    public FragmentAnimator onCreateFragmentAnimator() {
        return this.mSupport.getFragmentAnimator();
    }

    public FragmentAnimator getFragmentAnimator() {
        if (this.mSupport != null) {
            if (this.mFragmentAnimator == null) {
                FragmentAnimator onCreateFragmentAnimator = this.mSupportF.onCreateFragmentAnimator();
                this.mFragmentAnimator = onCreateFragmentAnimator;
                if (onCreateFragmentAnimator == null) {
                    this.mFragmentAnimator = this.mSupport.getFragmentAnimator();
                }
            }
            return this.mFragmentAnimator;
        }
        throw new RuntimeException("Fragment has not been attached to Activity!");
    }

    public void setFragmentAnimator(FragmentAnimator fragmentAnimator) {
        this.mFragmentAnimator = fragmentAnimator;
        AnimatorHelper animatorHelper = this.mAnimHelper;
        if (animatorHelper != null) {
            animatorHelper.notifyChanged(fragmentAnimator);
        }
        this.mAnimByActivity = false;
    }

    public void setFragmentResult(int i, Bundle bundle) {
        ResultRecord resultRecord;
        Bundle arguments = this.mFragment.getArguments();
        if (arguments != null && arguments.containsKey("fragment_arg_result_record") && (resultRecord = (ResultRecord) arguments.getParcelable("fragment_arg_result_record")) != null) {
            resultRecord.resultCode = i;
            resultRecord.resultBundle = bundle;
        }
    }

    public void putNewBundle(Bundle bundle) {
        this.mNewBundle = bundle;
    }

    public void hideSoftInput() {
        FragmentActivity activity = this.mFragment.getActivity();
        if (activity != null) {
            SupportHelper.hideSoftInput(activity.getWindow().getDecorView());
        }
    }

    public void showSoftInput(View view) {
        SupportHelper.showSoftInput(view);
    }

    public void loadRootFragment(int i, ISupportFragment iSupportFragment) {
        loadRootFragment(i, iSupportFragment, true, false);
    }

    public void loadRootFragment(int i, ISupportFragment iSupportFragment, boolean z, boolean z2) {
        this.mTransactionDelegate.loadRootTransaction(getChildFragmentManager(), i, iSupportFragment, z, z2);
    }

    public void loadMultipleRootFragment(int i, int i2, ISupportFragment... iSupportFragmentArr) {
        this.mTransactionDelegate.loadMultipleRootTransaction(getChildFragmentManager(), i, i2, iSupportFragmentArr);
    }

    public void showHideFragment(ISupportFragment iSupportFragment) {
        showHideFragment(iSupportFragment, null);
    }

    public void showHideFragment(ISupportFragment iSupportFragment, ISupportFragment iSupportFragment2) {
        this.mTransactionDelegate.showHideFragment(getChildFragmentManager(), iSupportFragment, iSupportFragment2);
    }

    public void start(ISupportFragment iSupportFragment) {
        start(iSupportFragment, 0);
    }

    public void start(ISupportFragment iSupportFragment, int i) {
        this.mTransactionDelegate.dispatchStartTransaction(this.mFragment.getFragmentManager(), this.mSupportF, iSupportFragment, 0, i, 0);
    }

    public void startForResult(ISupportFragment iSupportFragment, int i) {
        this.mTransactionDelegate.dispatchStartTransaction(this.mFragment.getFragmentManager(), this.mSupportF, iSupportFragment, i, 0, 2);
    }

    public void startWithPop(ISupportFragment iSupportFragment) {
        this.mTransactionDelegate.dispatchStartTransaction(this.mFragment.getFragmentManager(), this.mSupportF, iSupportFragment, 0, 0, 1);
    }

    public void replaceFragment(ISupportFragment iSupportFragment, boolean z) {
        this.mTransactionDelegate.dispatchStartTransaction(this.mFragment.getFragmentManager(), this.mSupportF, iSupportFragment, 0, 0, z ? 10 : 14);
    }

    public void startChild(ISupportFragment iSupportFragment) {
        startChild(iSupportFragment, 0);
    }

    public void startChild(ISupportFragment iSupportFragment, int i) {
        this.mTransactionDelegate.dispatchStartTransaction(getChildFragmentManager(), getTopFragment(), iSupportFragment, 0, i, 0);
    }

    public void startChildForResult(ISupportFragment iSupportFragment, int i) {
        this.mTransactionDelegate.dispatchStartTransaction(getChildFragmentManager(), getTopFragment(), iSupportFragment, i, 0, 2);
    }

    public void startChildWithPop(ISupportFragment iSupportFragment) {
        this.mTransactionDelegate.dispatchStartTransaction(getChildFragmentManager(), getTopFragment(), iSupportFragment, 0, 0, 1);
    }

    public void replaceChildFragment(ISupportFragment iSupportFragment, boolean z) {
        this.mTransactionDelegate.dispatchStartTransaction(getChildFragmentManager(), getTopFragment(), iSupportFragment, 0, 0, z ? 10 : 14);
    }

    public void pop() {
        this.mTransactionDelegate.back(this.mFragment.getFragmentManager());
    }

    public void popChild() {
        this.mTransactionDelegate.back(getChildFragmentManager());
    }

    public void popTo(Class<?> cls, boolean z) {
        getChildFragmentManager().popBackStack();
        popTo(cls, z, null);
    }

    public void popTo(Class<?> cls, boolean z, Runnable runnable) {
        popTo(cls, z, runnable, Integer.MAX_VALUE);
    }

    public void popTo(Class<?> cls, boolean z, Runnable runnable, int i) {
        this.mTransactionDelegate.popTo(cls.getName(), z, runnable, this.mFragment.getFragmentManager(), i);
    }

    public void popToChild(Class<?> cls, boolean z) {
        popToChild(cls, z, null);
    }

    public void popToChild(Class<?> cls, boolean z, Runnable runnable) {
        popToChild(cls, z, runnable, Integer.MAX_VALUE);
    }

    public void popToChild(Class<?> cls, boolean z, Runnable runnable, int i) {
        this.mTransactionDelegate.popTo(cls.getName(), z, runnable, getChildFragmentManager(), i);
    }

    private FragmentManager getChildFragmentManager() {
        return this.mFragment.getChildFragmentManager();
    }

    private ISupportFragment getTopFragment() {
        return SupportHelper.getTopFragment(getChildFragmentManager());
    }

    private void processRestoreInstanceState(Bundle bundle) {
        if (bundle != null) {
            FragmentTransaction beginTransaction = this.mFragment.getFragmentManager().beginTransaction();
            if (this.mIsHidden) {
                beginTransaction.hide(this.mFragment);
            } else {
                beginTransaction.show(this.mFragment);
            }
            beginTransaction.commitAllowingStateLoss();
        }
    }

    private void fixAnimationListener(Animation animation) {
        this.mSupport.getSupportDelegate().mFragmentClickable = false;
        getHandler().postDelayed(this.mNotifyEnterAnimEndRunnable, animation.getDuration());
        if (this.mEnterAnimListener != null) {
            getHandler().post(new Runnable() {
                /* class me.yokeyword.fragmentation.SupportFragmentDelegate.AnonymousClass1 */

                public void run() {
                    SupportFragmentDelegate.this.mEnterAnimListener.onEnterAnimStart();
                    SupportFragmentDelegate.this.mEnterAnimListener = null;
                }
            });
        }
    }

    private void compatSharedElements() {
        notifyEnterAnimEnd();
    }

    public void setBackground(View view) {
        if ((this.mFragment.getTag() == null || !this.mFragment.getTag().startsWith("android:switcher:")) && this.mRootStatus == 0 && view.getBackground() == null) {
            int defaultFragmentBackground = this.mSupport.getSupportDelegate().getDefaultFragmentBackground();
            if (defaultFragmentBackground == 0) {
                view.setBackgroundResource(getWindowBackground());
            } else {
                view.setBackgroundResource(defaultFragmentBackground);
            }
        }
    }

    private int getWindowBackground() {
        TypedArray obtainStyledAttributes = this._mActivity.getTheme().obtainStyledAttributes(new int[]{16842836});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void notifyEnterAnimEnd() {
        getHandler().post(new Runnable() {
            /* class me.yokeyword.fragmentation.SupportFragmentDelegate.AnonymousClass3 */

            public void run() {
                if (SupportFragmentDelegate.this.mFragment != null) {
                    SupportFragmentDelegate.this.mSupportF.onEnterAnimationEnd(SupportFragmentDelegate.this.mSaveInstanceState);
                }
            }
        });
        this.mSupport.getSupportDelegate().mFragmentClickable = true;
    }

    private Handler getHandler() {
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
        return this.mHandler;
    }

    public VisibleDelegate getVisibleDelegate() {
        if (this.mVisibleDelegate == null) {
            this.mVisibleDelegate = new VisibleDelegate(this.mSupportF);
        }
        return this.mVisibleDelegate;
    }

    public FragmentActivity getActivity() {
        return this._mActivity;
    }
}
