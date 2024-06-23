package me.yokeyword.fragmentation;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentationHack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.yokeyword.fragmentation.SupportFragmentDelegate;
import me.yokeyword.fragmentation.helper.internal.ResultRecord;
import me.yokeyword.fragmentation.helper.internal.TransactionRecord;

/* access modifiers changed from: package-private */
public class TransactionDelegate {
    private static final long BUFFER_TIME = 50;
    static final int DEFAULT_POPTO_ANIM = Integer.MAX_VALUE;
    static final String FRAGMENTATION_ARG_CONTAINER = "fragmentation_arg_container";
    static final String FRAGMENTATION_ARG_CUSTOM_END_ANIM = "fragmentation_arg_custom_end_anim";
    static final String FRAGMENTATION_ARG_IS_SHARED_ELEMENT = "fragmentation_arg_is_shared_element";
    static final String FRAGMENTATION_ARG_REPLACE = "fragmentation_arg_replace";
    static final String FRAGMENTATION_ARG_RESULT_RECORD = "fragment_arg_result_record";
    static final String FRAGMENTATION_ARG_ROOT_STATUS = "fragmentation_arg_root_status";
    static final String FRAGMENTATION_STATE_SAVE_ANIMATOR = "fragmentation_state_save_animator";
    static final String FRAGMENTATION_STATE_SAVE_IS_HIDDEN = "fragmentation_state_save_status";
    private static final String TAG = "Fragmentation";
    static final int TYPE_ADD = 0;
    static final int TYPE_ADD_RESULT = 2;
    static final int TYPE_ADD_RESULT_WITHOUT_HIDE = 4;
    static final int TYPE_ADD_WITHOUT_HIDE = 3;
    static final int TYPE_ADD_WITH_POP = 1;
    static final int TYPE_REPLACE = 10;
    static final int TYPE_REPLACE_DONT_BACK = 14;
    private FragmentActivity mActivity;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private FragmentManager mPopToTempFragmentManager;
    private long mShareElementDebounceTime;
    private ISupportActivity mSupport;

    /* access modifiers changed from: private */
    public interface Callback {
        void call();
    }

    TransactionDelegate(ISupportActivity iSupportActivity) {
        this.mSupport = iSupportActivity;
        this.mActivity = (FragmentActivity) iSupportActivity;
    }

    /* access modifiers changed from: package-private */
    public void loadRootTransaction(FragmentManager fragmentManager, int i, ISupportFragment iSupportFragment, boolean z, boolean z2) {
        FragmentManager checkFragmentManager = checkFragmentManager(fragmentManager, null);
        if (checkFragmentManager != null) {
            bindContainerId(i, iSupportFragment);
            start(checkFragmentManager, null, iSupportFragment, iSupportFragment.getClass().getName(), !z, null, z2, 10);
        }
    }

    /* access modifiers changed from: package-private */
    public void loadMultipleRootTransaction(FragmentManager fragmentManager, int i, int i2, ISupportFragment... iSupportFragmentArr) {
        FragmentManager checkFragmentManager = checkFragmentManager(fragmentManager, null);
        if (checkFragmentManager != null) {
            FragmentTransaction beginTransaction = checkFragmentManager.beginTransaction();
            for (int i3 = 0; i3 < iSupportFragmentArr.length; i3++) {
                Fragment fragment = (Fragment) iSupportFragmentArr[i3];
                getArguments(fragment).putInt(FRAGMENTATION_ARG_ROOT_STATUS, 1);
                bindContainerId(i, iSupportFragmentArr[i3]);
                beginTransaction.add(i, fragment, fragment.getClass().getName());
                if (i3 != i2) {
                    beginTransaction.hide(fragment);
                }
            }
            supportCommit(checkFragmentManager, beginTransaction);
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchStartTransaction(FragmentManager fragmentManager, ISupportFragment iSupportFragment, ISupportFragment iSupportFragment2, int i, int i2, int i3) {
        ArrayList<TransactionRecord.SharedElement> arrayList;
        boolean z;
        String str;
        FragmentManager checkFragmentManager = checkFragmentManager(fragmentManager, iSupportFragment);
        if (checkFragmentManager != null) {
            checkNotNull(iSupportFragment2, "toFragment == null");
            if (iSupportFragment != null) {
                if (iSupportFragment.getSupportDelegate().mContainerId == 0) {
                    Fragment fragment = (Fragment) iSupportFragment;
                    if (fragment.getTag() != null && !fragment.getTag().startsWith("android:switcher:")) {
                        throw new RuntimeException("Can't find container, please call loadRootFragment() first!");
                    }
                }
                bindContainerId(iSupportFragment.getSupportDelegate().mContainerId, iSupportFragment2);
                iSupportFragment = SupportHelper.getTopFragment(checkFragmentManager, iSupportFragment.getSupportDelegate().mContainerId);
            }
            String name = iSupportFragment2.getClass().getName();
            ArrayList<TransactionRecord.SharedElement> arrayList2 = null;
            TransactionRecord transactionRecord = iSupportFragment2.getSupportDelegate().mTransactionRecord;
            if (transactionRecord != null) {
                if (transactionRecord.tag != null) {
                    name = transactionRecord.tag;
                }
                boolean z2 = transactionRecord.dontAddToBackStack;
                if (transactionRecord.sharedElementList != null) {
                    arrayList2 = transactionRecord.sharedElementList;
                    FragmentationHack.reorderIndices(checkFragmentManager);
                }
                str = name;
                z = z2;
                arrayList = arrayList2;
            } else {
                str = name;
                arrayList = null;
                z = false;
            }
            if (i3 == 2 || i3 == 4) {
                saveRequestCode((Fragment) iSupportFragment2, i);
            }
            if (!handleLaunchMode(checkFragmentManager, iSupportFragment, iSupportFragment2, str, i2)) {
                if (i3 == 1) {
                    startWithPop(checkFragmentManager, iSupportFragment, iSupportFragment2);
                } else {
                    start(checkFragmentManager, iSupportFragment, iSupportFragment2, str, z, arrayList, false, i3);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void showHideFragment(FragmentManager fragmentManager, ISupportFragment iSupportFragment, ISupportFragment iSupportFragment2) {
        FragmentManager checkFragmentManager = checkFragmentManager(fragmentManager, null);
        if (!(checkFragmentManager == null || iSupportFragment == iSupportFragment2)) {
            FragmentTransaction show = checkFragmentManager.beginTransaction().show((Fragment) iSupportFragment);
            if (iSupportFragment2 == null) {
                List<Fragment> activeFragments = FragmentationHack.getActiveFragments(checkFragmentManager);
                if (activeFragments != null) {
                    for (Fragment fragment : activeFragments) {
                        if (!(fragment == null || fragment == iSupportFragment)) {
                            show.hide(fragment);
                        }
                    }
                }
            } else {
                show.hide((Fragment) iSupportFragment2);
            }
            supportCommit(checkFragmentManager, show);
        }
    }

    private void start(FragmentManager fragmentManager, ISupportFragment iSupportFragment, ISupportFragment iSupportFragment2, String str, boolean z, ArrayList<TransactionRecord.SharedElement> arrayList, boolean z2, int i) {
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        boolean z3 = i == 0 || i == 2 || i == 3;
        Fragment fragment = (Fragment) iSupportFragment;
        Fragment fragment2 = (Fragment) iSupportFragment2;
        Bundle arguments = getArguments(fragment2);
        arguments.putBoolean(FRAGMENTATION_ARG_REPLACE, !z3);
        if (arrayList != null) {
            arguments.putBoolean(FRAGMENTATION_ARG_IS_SHARED_ELEMENT, true);
            Iterator<TransactionRecord.SharedElement> it = arrayList.iterator();
            while (it.hasNext()) {
                TransactionRecord.SharedElement next = it.next();
                beginTransaction.addSharedElement(next.sharedElement, next.sharedName);
            }
        } else if (z3) {
            TransactionRecord transactionRecord = iSupportFragment2.getSupportDelegate().mTransactionRecord;
            if (transactionRecord == null || transactionRecord.targetFragmentEnter == Integer.MIN_VALUE) {
                beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            } else {
                beginTransaction.setCustomAnimations(transactionRecord.targetFragmentEnter, transactionRecord.currentFragmentPopExit, transactionRecord.currentFragmentPopEnter, transactionRecord.targetFragmentExit);
                arguments.putInt(FRAGMENTATION_ARG_CUSTOM_END_ANIM, transactionRecord.targetFragmentEnter);
            }
        } else {
            arguments.putInt(FRAGMENTATION_ARG_ROOT_STATUS, 1);
        }
        if (iSupportFragment == null) {
            beginTransaction.replace(arguments.getInt(FRAGMENTATION_ARG_CONTAINER), fragment2, str);
            if (!z3) {
                beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                arguments.putInt(FRAGMENTATION_ARG_ROOT_STATUS, z2 ? 2 : 1);
            }
        } else if (z3) {
            beginTransaction.add(iSupportFragment.getSupportDelegate().mContainerId, fragment2, str);
            if (i != 3) {
                beginTransaction.hide(fragment);
            }
        } else {
            beginTransaction.replace(iSupportFragment.getSupportDelegate().mContainerId, fragment2, str);
        }
        if (!z && i != 14) {
            beginTransaction.addToBackStack(str);
        }
        supportCommit(fragmentManager, beginTransaction);
    }

    private void bindContainerId(int i, ISupportFragment iSupportFragment) {
        getArguments((Fragment) iSupportFragment).putInt(FRAGMENTATION_ARG_CONTAINER, i);
    }

    private Bundle getArguments(Fragment fragment) {
        Bundle arguments = fragment.getArguments();
        if (arguments != null) {
            return arguments;
        }
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return bundle;
    }

    private void startWithPop(final FragmentManager fragmentManager, final ISupportFragment iSupportFragment, final ISupportFragment iSupportFragment2) {
        if (FragmentationHack.isExecutingActions(fragmentManager)) {
            this.mHandler.post(new Runnable() {
                /* class me.yokeyword.fragmentation.TransactionDelegate.AnonymousClass1 */

                public void run() {
                    TransactionDelegate.this.executeStartWithPop(fragmentManager, iSupportFragment, iSupportFragment2);
                }
            });
        } else {
            executeStartWithPop(fragmentManager, iSupportFragment, iSupportFragment2);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void executeStartWithPop(final FragmentManager fragmentManager, final ISupportFragment iSupportFragment, final ISupportFragment iSupportFragment2) {
        fragmentManager.executePendingTransactions();
        final ISupportFragment preFragment = getPreFragment((Fragment) iSupportFragment);
        final int i = iSupportFragment.getSupportDelegate().mContainerId;
        mockStartWithPopAnim(iSupportFragment, iSupportFragment2, iSupportFragment.getSupportDelegate().mAnimHelper.popExitAnim);
        fragmentManager.popBackStackImmediate();
        this.mHandler.post(new Runnable() {
            /* class me.yokeyword.fragmentation.TransactionDelegate.AnonymousClass2 */

            public void run() {
                TransactionDelegate.this.mHandler.post(new Runnable() {
                    /* class me.yokeyword.fragmentation.TransactionDelegate.AnonymousClass2.AnonymousClass1 */

                    public void run() {
                        fragmentManager.executePendingTransactions();
                        FragmentationHack.reorderIndices(fragmentManager);
                        if (preFragment == null || preFragment.getSupportDelegate().mContainerId != i) {
                            TransactionDelegate.this.dispatchStartTransaction(fragmentManager, iSupportFragment, iSupportFragment2, 0, 0, 0);
                        } else {
                            preFragment.getSupportDelegate().start(iSupportFragment2);
                        }
                    }
                });
            }
        });
    }

    private void supportCommit(FragmentManager fragmentManager, FragmentTransaction fragmentTransaction) {
        if (Fragmentation.getDefault().isDebug()) {
            fragmentTransaction.commit();
            return;
        }
        if (FragmentationHack.isStateSaved(fragmentManager)) {
            Log.e(TAG, "Please beginTransaction in onPostResume() after the Activity returns!");
            IllegalStateException illegalStateException = new IllegalStateException("Can not perform this action after onSaveInstanceState!");
            illegalStateException.printStackTrace();
            if (Fragmentation.getDefault().getHandler() != null) {
                Fragmentation.getDefault().getHandler().onException(illegalStateException);
            }
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    private ISupportFragment getTopFragment(FragmentManager fragmentManager) {
        return SupportHelper.getTopFragment(fragmentManager);
    }

    private ISupportFragment getPreFragment(Fragment fragment) {
        return SupportHelper.getPreFragment(fragment);
    }

    /* access modifiers changed from: package-private */
    public boolean dispatchBackPressedEvent(ISupportFragment iSupportFragment) {
        if (iSupportFragment == null) {
            return false;
        }
        if (!iSupportFragment.onBackPressedSupport() && !dispatchBackPressedEvent((ISupportFragment) ((Fragment) iSupportFragment).getParentFragment())) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
        r1 = me.yokeyword.fragmentation.SupportHelper.findStackFragment(r12.getClass(), r13, r10);
     */
    private boolean handleLaunchMode(FragmentManager fragmentManager, ISupportFragment iSupportFragment, final ISupportFragment iSupportFragment2, String str, int i) {
        final ISupportFragment findStackFragment;
        if (iSupportFragment == null || findStackFragment == null) {
            return false;
        }
        if (i == 1) {
            if (iSupportFragment2 == iSupportFragment || iSupportFragment2.getClass().getName().equals(iSupportFragment.getClass().getName())) {
                handleNewBundle(iSupportFragment2, findStackFragment);
                return true;
            }
        } else if (i == 2) {
            popTo(str, false, null, fragmentManager, Integer.MAX_VALUE);
            this.mHandler.post(new Runnable() {
                /* class me.yokeyword.fragmentation.TransactionDelegate.AnonymousClass3 */

                public void run() {
                    TransactionDelegate.this.handleNewBundle(iSupportFragment2, findStackFragment);
                }
            });
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void handleNewBundle(ISupportFragment iSupportFragment, ISupportFragment iSupportFragment2) {
        Bundle bundle = iSupportFragment.getSupportDelegate().mNewBundle;
        Bundle arguments = getArguments((Fragment) iSupportFragment);
        if (arguments.containsKey(FRAGMENTATION_ARG_CONTAINER)) {
            arguments.remove(FRAGMENTATION_ARG_CONTAINER);
        }
        if (bundle != null) {
            arguments.putAll(bundle);
        }
        iSupportFragment2.onNewBundle(arguments);
    }

    private void saveRequestCode(Fragment fragment, int i) {
        Bundle arguments = getArguments(fragment);
        ResultRecord resultRecord = new ResultRecord();
        resultRecord.requestCode = i;
        arguments.putParcelable(FRAGMENTATION_ARG_RESULT_RECORD, resultRecord);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0016, code lost:
        r4 = (me.yokeyword.fragmentation.helper.internal.ResultRecord) r4.getParcelable(me.yokeyword.fragmentation.TransactionDelegate.FRAGMENTATION_ARG_RESULT_RECORD);
     */
    public void handleResultRecord(Fragment fragment) {
        Bundle arguments;
        final ResultRecord resultRecord;
        final ISupportFragment preFragment = getPreFragment(fragment);
        if (preFragment != null && (arguments = fragment.getArguments()) != null && arguments.containsKey(FRAGMENTATION_ARG_RESULT_RECORD) && resultRecord != null) {
            this.mHandler.post(new Runnable() {
                /* class me.yokeyword.fragmentation.TransactionDelegate.AnonymousClass4 */

                public void run() {
                    preFragment.onFragmentResult(resultRecord.requestCode, resultRecord.resultCode, resultRecord.resultBundle);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void remove(FragmentManager fragmentManager, Fragment fragment, boolean z) {
        FragmentTransaction remove = fragmentManager.beginTransaction().setTransition(8194).remove(fragment);
        if (z) {
            ISupportFragment preFragment = SupportHelper.getPreFragment(fragment);
            if (preFragment instanceof Fragment) {
                remove.show((Fragment) preFragment);
            }
        }
        supportCommit(fragmentManager, remove);
    }

    /* access modifiers changed from: package-private */
    public void back(FragmentManager fragmentManager) {
        FragmentManager checkFragmentManager = checkFragmentManager(fragmentManager, null);
        if (checkFragmentManager != null && checkFragmentManager.getBackStackEntryCount() > 0) {
            executeDebouncePop(checkFragmentManager);
        }
    }

    private void executeDebouncePop(FragmentManager fragmentManager) {
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName());
        if (findFragmentByTag instanceof ISupportFragment) {
            ISupportFragment iSupportFragment = (ISupportFragment) findFragmentByTag;
            if (!iSupportFragment.getSupportDelegate().mIsSharedElement || System.currentTimeMillis() >= this.mShareElementDebounceTime) {
                this.mShareElementDebounceTime = System.currentTimeMillis() + iSupportFragment.getSupportDelegate().mAnimHelper.exitAnim.getDuration();
            } else {
                this.mShareElementDebounceTime = System.currentTimeMillis() + iSupportFragment.getSupportDelegate().mAnimHelper.exitAnim.getDuration();
                return;
            }
        }
        fragmentManager.popBackStack();
    }

    /* access modifiers changed from: package-private */
    public void popTo(final String str, final boolean z, final Runnable runnable, FragmentManager fragmentManager, final int i) {
        final FragmentManager checkFragmentManager = checkFragmentManager(fragmentManager, null);
        if (checkFragmentManager != null) {
            if (FragmentationHack.isExecutingActions(checkFragmentManager)) {
                this.mHandler.post(new Runnable() {
                    /* class me.yokeyword.fragmentation.TransactionDelegate.AnonymousClass5 */

                    public void run() {
                        TransactionDelegate.this.executePopTo(str, z, runnable, checkFragmentManager, i);
                    }
                });
            } else {
                executePopTo(str, z, runnable, checkFragmentManager, i);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void executePopTo(final String str, boolean z, final Runnable runnable, final FragmentManager fragmentManager, int i) {
        final int i2;
        Animation animation;
        fragmentManager.executePendingTransactions();
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(str);
        if (findFragmentByTag == null) {
            Log.e(TAG, "Pop failure! Can't find FragmentTag:" + str + " in the FragmentManager's Stack.");
            return;
        }
        if (z) {
            findFragmentByTag = (Fragment) getPreFragment(findFragmentByTag);
            i2 = 1;
        } else {
            i2 = 0;
        }
        ISupportFragment topFragment = getTopFragment(fragmentManager);
        if (runnable == null && i == Integer.MAX_VALUE) {
            animation = topFragment.getSupportDelegate().mAnimHelper.exitAnim;
        } else if (i == Integer.MAX_VALUE) {
            animation = new Animation() {
                /* class me.yokeyword.fragmentation.TransactionDelegate.AnonymousClass6 */
            };
            animation.setDuration(topFragment.getSupportDelegate().mAnimHelper.exitAnim.getDuration());
        } else if (i == 0) {
            animation = new Animation() {
                /* class me.yokeyword.fragmentation.TransactionDelegate.AnonymousClass7 */
            };
        } else {
            animation = AnimationUtils.loadAnimation(this.mActivity, i);
        }
        mockPopAnim(topFragment, (ISupportFragment) findFragmentByTag, animation, runnable != null, new Callback() {
            /* class me.yokeyword.fragmentation.TransactionDelegate.AnonymousClass8 */

            @Override // me.yokeyword.fragmentation.TransactionDelegate.Callback
            public void call() {
                TransactionDelegate.this.popToFix(str, i2, fragmentManager);
                if (runnable != null) {
                    TransactionDelegate.this.mHandler.post(new Runnable() {
                        /* class me.yokeyword.fragmentation.TransactionDelegate.AnonymousClass8.AnonymousClass1 */

                        public void run() {
                            TransactionDelegate.this.mHandler.post(new Runnable() {
                                /* class me.yokeyword.fragmentation.TransactionDelegate.AnonymousClass8.AnonymousClass1.AnonymousClass1 */

                                public void run() {
                                    TransactionDelegate.this.mPopToTempFragmentManager = fragmentManager;
                                    runnable.run();
                                    TransactionDelegate.this.mPopToTempFragmentManager = null;
                                }
                            });
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void popToFix(String str, int i, final FragmentManager fragmentManager) {
        if (FragmentationHack.getActiveFragments(fragmentManager) != null) {
            this.mSupport.getSupportDelegate().mPopMultipleNoAnim = true;
            fragmentManager.popBackStackImmediate(str, i);
            fragmentManager.executePendingTransactions();
            this.mSupport.getSupportDelegate().mPopMultipleNoAnim = false;
            this.mHandler.post(new Runnable() {
                /* class me.yokeyword.fragmentation.TransactionDelegate.AnonymousClass9 */

                public void run() {
                    FragmentationHack.reorderIndices(fragmentManager);
                }
            });
        }
    }

    private void mockStartWithPopAnim(ISupportFragment iSupportFragment, ISupportFragment iSupportFragment2, final Animation animation) {
        Fragment fragment = (Fragment) iSupportFragment;
        final ViewGroup findContainerById = findContainerById(fragment, iSupportFragment.getSupportDelegate().mContainerId);
        if (findContainerById != null) {
            iSupportFragment.getSupportDelegate().mLockAnim = true;
            View view = fragment.getView();
            findContainerById.removeViewInLayout(view);
            final ViewGroup addMockView = addMockView(view, findContainerById);
            iSupportFragment2.getSupportDelegate().mEnterAnimListener = new SupportFragmentDelegate.EnterAnimListener() {
                /* class me.yokeyword.fragmentation.TransactionDelegate.AnonymousClass10 */

                @Override // me.yokeyword.fragmentation.SupportFragmentDelegate.EnterAnimListener
                public void onEnterAnimStart() {
                    addMockView.startAnimation(animation);
                    TransactionDelegate.this.mHandler.postDelayed(new Runnable() {
                        /* class me.yokeyword.fragmentation.TransactionDelegate.AnonymousClass10.AnonymousClass1 */

                        public void run() {
                            findContainerById.removeView(addMockView);
                        }
                    }, animation.getDuration() + TransactionDelegate.BUFFER_TIME);
                }
            };
        }
    }

    private void mockPopAnim(ISupportFragment iSupportFragment, ISupportFragment iSupportFragment2, Animation animation, boolean z, Callback callback) {
        if (iSupportFragment != iSupportFragment2) {
            Fragment fragment = (Fragment) iSupportFragment;
            ViewGroup findContainerById = findContainerById(fragment, iSupportFragment.getSupportDelegate().mContainerId);
            if (findContainerById != null) {
                View view = fragment.getView();
                Fragment fragment2 = (Fragment) getPreFragment(fragment);
                ViewGroup viewGroup = null;
                iSupportFragment.getSupportDelegate().mLockAnim = true;
                if (Build.VERSION.SDK_INT < 21 && fragment2 != iSupportFragment2 && fragment2 != null && (fragment2.getView() instanceof ViewGroup)) {
                    viewGroup = (ViewGroup) fragment2.getView();
                }
                if (viewGroup != null) {
                    hideChildView(viewGroup);
                    findContainerById.removeViewInLayout(view);
                    viewGroup.addView(view);
                    if (callback != null) {
                        callback.call();
                    }
                    viewGroup.removeViewInLayout(view);
                    handleMock(animation, z, null, view, findContainerById);
                    return;
                }
                findContainerById.removeViewInLayout(view);
                handleMock(animation, z, callback, view, findContainerById);
            }
        } else if (callback != null) {
            callback.call();
        }
    }

    private void handleMock(Animation animation, boolean z, Callback callback, final View view, final ViewGroup viewGroup) {
        long j;
        final ViewGroup addMockView = addMockView(view, viewGroup);
        if (callback != null) {
            callback.call();
        }
        long duration = animation.getDuration();
        if (z) {
            long duration2 = animation.getDuration();
            if (Build.VERSION.SDK_INT < 21) {
                j = duration2 + 100;
                duration = BUFFER_TIME + j;
            } else {
                j = duration2 + BUFFER_TIME;
                duration = j;
            }
            animation.setDuration(j);
        }
        animation.setAnimationListener(new Animation.AnimationListener() {
            /* class me.yokeyword.fragmentation.TransactionDelegate.AnonymousClass11 */

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                addMockView.setVisibility(4);
            }
        });
        addMockView.startAnimation(animation);
        this.mHandler.postDelayed(new Runnable() {
            /* class me.yokeyword.fragmentation.TransactionDelegate.AnonymousClass12 */

            public void run() {
                addMockView.removeViewInLayout(view);
                viewGroup.removeViewInLayout(addMockView);
            }
        }, duration);
    }

    private ViewGroup addMockView(View view, ViewGroup viewGroup) {
        AnonymousClass13 r0 = new ViewGroup(this.mActivity) {
            /* class me.yokeyword.fragmentation.TransactionDelegate.AnonymousClass13 */

            /* access modifiers changed from: protected */
            public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            }
        };
        r0.addView(view);
        viewGroup.addView(r0);
        return r0;
    }

    private ViewGroup findContainerById(Fragment fragment, int i) {
        View view;
        if (fragment.getView() == null) {
            return null;
        }
        Fragment parentFragment = fragment.getParentFragment();
        if (parentFragment == null) {
            view = this.mActivity.findViewById(i);
        } else if (parentFragment.getView() != null) {
            view = parentFragment.getView().findViewById(i);
        } else {
            view = findContainerById(parentFragment, i);
        }
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    private void hideChildView(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            viewGroup.getChildAt(i).setVisibility(8);
        }
    }

    private static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    private FragmentManager checkFragmentManager(FragmentManager fragmentManager, ISupportFragment iSupportFragment) {
        String str;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        FragmentManager fragmentManager2 = this.mPopToTempFragmentManager;
        if (fragmentManager2 != null) {
            return fragmentManager2;
        }
        if (iSupportFragment == null) {
            str = "Fragment";
        } else {
            str = iSupportFragment.getClass().getSimpleName();
        }
        Log.e(TAG, str + "'s FragmentManager is null,  Please check if " + str + " is destroyed!");
        return null;
    }
}
