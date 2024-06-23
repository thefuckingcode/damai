package me.yokeyword.fragmentation;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentationHack;
import java.util.List;

public class SupportHelper {
    private static final long SHOW_SPACE = 200;

    private SupportHelper() {
    }

    public static void showSoftInput(final View view) {
        if (view != null && view.getContext() != null) {
            final InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
            view.requestFocus();
            view.postDelayed(new Runnable() {
                /* class me.yokeyword.fragmentation.SupportHelper.AnonymousClass1 */

                public void run() {
                    inputMethodManager.showSoftInput(view, 2);
                }
            }, SHOW_SPACE);
        }
    }

    public static void hideSoftInput(View view) {
        if (view != null && view.getContext() != null) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void showFragmentStackHierarchyView(ISupportActivity iSupportActivity) {
        iSupportActivity.getSupportDelegate().showFragmentStackHierarchyView();
    }

    public static void logFragmentStackHierarchy(ISupportActivity iSupportActivity, String str) {
        iSupportActivity.getSupportDelegate().logFragmentStackHierarchy(str);
    }

    public static ISupportFragment getTopFragment(FragmentManager fragmentManager) {
        return getTopFragment(fragmentManager, 0);
    }

    public static ISupportFragment getTopFragment(FragmentManager fragmentManager, int i) {
        List<Fragment> activeFragments = FragmentationHack.getActiveFragments(fragmentManager);
        if (activeFragments == null) {
            return null;
        }
        for (int size = activeFragments.size() - 1; size >= 0; size--) {
            Fragment fragment = activeFragments.get(size);
            if (fragment instanceof ISupportFragment) {
                ISupportFragment iSupportFragment = (ISupportFragment) fragment;
                if (i == 0 || i == iSupportFragment.getSupportDelegate().mContainerId) {
                    return iSupportFragment;
                }
            }
        }
        return null;
    }

    public static ISupportFragment getPreFragment(Fragment fragment) {
        List<Fragment> activeFragments;
        FragmentManager fragmentManager = fragment.getFragmentManager();
        if (fragmentManager == null || (activeFragments = FragmentationHack.getActiveFragments(fragmentManager)) == null) {
            return null;
        }
        for (int indexOf = activeFragments.indexOf(fragment) - 1; indexOf >= 0; indexOf--) {
            Fragment fragment2 = activeFragments.get(indexOf);
            if (fragment2 instanceof ISupportFragment) {
                return (ISupportFragment) fragment2;
            }
        }
        return null;
    }

    public static <T extends ISupportFragment> T findFragment(FragmentManager fragmentManager, Class<T> cls) {
        return (T) findStackFragment(cls, null, fragmentManager);
    }

    public static <T extends ISupportFragment> T findFragment(FragmentManager fragmentManager, String str) {
        return (T) findStackFragment(null, str, fragmentManager);
    }

    public static ISupportFragment getActiveFragment(FragmentManager fragmentManager) {
        return getActiveFragment(fragmentManager, null);
    }

    static <T extends ISupportFragment> T findStackFragment(Class<T> cls, String str, FragmentManager fragmentManager) {
        Fragment fragment = null;
        if (str == null) {
            List<Fragment> activeFragments = FragmentationHack.getActiveFragments(fragmentManager);
            if (activeFragments != null) {
                int size = activeFragments.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    Fragment fragment2 = activeFragments.get(size);
                    if ((fragment2 instanceof ISupportFragment) && fragment2.getClass().getName().equals(cls.getName())) {
                        fragment = fragment2;
                        break;
                    }
                    size--;
                }
            } else {
                return null;
            }
        } else {
            Fragment findFragmentByTag = fragmentManager.findFragmentByTag(str);
            if (findFragmentByTag == null) {
                return null;
            }
            fragment = findFragmentByTag;
        }
        return (T) ((ISupportFragment) fragment);
    }

    private static ISupportFragment getActiveFragment(FragmentManager fragmentManager, ISupportFragment iSupportFragment) {
        List<Fragment> activeFragments = FragmentationHack.getActiveFragments(fragmentManager);
        if (activeFragments == null) {
            return iSupportFragment;
        }
        for (int size = activeFragments.size() - 1; size >= 0; size--) {
            Fragment fragment = activeFragments.get(size);
            if ((fragment instanceof ISupportFragment) && fragment.isResumed() && !fragment.isHidden() && fragment.getUserVisibleHint()) {
                return getActiveFragment(fragment.getChildFragmentManager(), (ISupportFragment) fragment);
            }
        }
        return iSupportFragment;
    }
}
