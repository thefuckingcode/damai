package com.alient.onearch.adapter.widget;

import com.google.android.material.tabs.TabLayout;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"com/alient/onearch/adapter/widget/OneTabLayout$init$1", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tab", "Ltb/ur2;", "onTabSelected", "onTabUnselected", "onTabReselected", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class OneTabLayout$init$1 implements TabLayout.OnTabSelectedListener {
    final /* synthetic */ OneTabLayout this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    OneTabLayout$init$1(OneTabLayout oneTabLayout) {
        this.this$0 = oneTabLayout;
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(@NotNull TabLayout.Tab tab) {
        k21.i(tab, "tab");
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(@NotNull TabLayout.Tab tab) {
        k21.i(tab, "tab");
        int tabCount = this.this$0.getTabCount();
        for (int i = 0; i < tabCount; i++) {
            if (i == tab.getPosition()) {
                TabLayout.Tab tabAt = this.this$0.getTabAt(i);
                if (tabAt != null) {
                    OneTabLayout oneTabLayout = this.this$0;
                    k21.h(tabAt, "this");
                    oneTabLayout.setSelectedTab(tabAt, false);
                }
            } else {
                TabLayout.Tab tabAt2 = this.this$0.getTabAt(i);
                if (tabAt2 != null) {
                    OneTabLayout oneTabLayout2 = this.this$0;
                    k21.h(tabAt2, "this");
                    oneTabLayout2.setUnSelectedTab(tabAt2, false);
                }
            }
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabUnselected(@NotNull TabLayout.Tab tab) {
        k21.i(tab, "tab");
        this.this$0.setUnSelectedTab(tab, false);
    }
}
