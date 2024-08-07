package cn.damai.onearch.component.banner;

import android.view.View;
import cn.damai.onearch.component.banner.LoopBannerContract;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
public final class LoopBannerPresenter extends AbsPresenter<GenericItem<ItemValue>, LoopBannerModel, LoopBannerView> implements LoopBannerContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoopBannerPresenter(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }

    @Override // cn.damai.onearch.component.banner.LoopBannerContract.Presenter
    public void onPageChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1454901745")) {
            ipChange.ipc$dispatch("1454901745", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1832018606")) {
            ipChange.ipc$dispatch("1832018606", new Object[]{this, genericItem});
            return;
        }
        k21.i(genericItem, "item");
        super.init((IItem) genericItem);
        ((LoopBannerView) getView()).setAdapter(genericItem.getComponent().getInnerAdapter());
    }
}
