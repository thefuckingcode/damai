package com.youku.arch.v3.page;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GenericActivity$onTabDataLoaded$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ List<?> $dataSet;
    final /* synthetic */ GenericActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GenericActivity$onTabDataLoaded$1(GenericActivity genericActivity, List<?> list) {
        super(0);
        this.this$0 = genericActivity;
        this.$dataSet = list;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final ur2 invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1710396803")) {
            return (ur2) ipChange.ipc$dispatch("-1710396803", new Object[]{this});
        }
        BaseViewPagerAdapter viewPagerAdapter = this.this$0.getViewPagerAdapter();
        if (viewPagerAdapter != null) {
            viewPagerAdapter.setDataset(this.$dataSet);
        }
        BaseViewPagerAdapter viewPagerAdapter2 = this.this$0.getViewPagerAdapter();
        if (viewPagerAdapter2 == null) {
            return null;
        }
        viewPagerAdapter2.notifyDataSetChanged();
        return ur2.INSTANCE;
    }
}
