package com.scwang.smartrefresh.layout.util;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.listener.CoordinatorLayoutListener;

public class DesignUtil {
    public static void checkCoordinatorLayout(View view, RefreshKernel refreshKernel, final CoordinatorLayoutListener coordinatorLayoutListener) {
        try {
            if (view instanceof CoordinatorLayout) {
                refreshKernel.getRefreshLayout().setEnableNestedScroll(false);
                ViewGroup viewGroup = (ViewGroup) view;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt = viewGroup.getChildAt(childCount);
                    if (childAt instanceof AppBarLayout) {
                        ((AppBarLayout) childAt).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new AppBarLayout.OnOffsetChangedListener() {
                            /* class com.scwang.smartrefresh.layout.util.DesignUtil.AnonymousClass1 */

                            @Override // com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener
                            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                                CoordinatorLayoutListener coordinatorLayoutListener = coordinatorLayoutListener;
                                boolean z = true;
                                boolean z2 = i >= 0;
                                if (appBarLayout.getTotalScrollRange() + i > 0) {
                                    z = false;
                                }
                                coordinatorLayoutListener.onCoordinatorUpdate(z2, z);
                            }
                        });
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
