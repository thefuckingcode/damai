package cn.damai.onearch.component.project;

import android.view.View;
import cn.damai.commonbusiness.search.viewholder.ProjectItemViewHolder;
import cn.damai.onearch.component.project.OneProject;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.xk1;

/* compiled from: Taobao */
public final class OneProjectPresent extends AbsPresenter<GenericItem<ItemValue>, OneProjectModel, OneProjectView> implements OneProject.Present {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OneProjectPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }

    /* access modifiers changed from: private */
    /* renamed from: init$lambda-2$lambda-1  reason: not valid java name */
    public static final void m55init$lambda2$lambda1(OneProjectPresent oneProjectPresent, View view) {
        TrackInfo trackInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "854741213")) {
            ipChange.ipc$dispatch("854741213", new Object[]{oneProjectPresent, view});
            return;
        }
        k21.i(oneProjectPresent, "this$0");
        Action itemAction = oneProjectPresent.getItemAction();
        if (itemAction != null && (trackInfo = itemAction.getTrackInfo()) != null) {
            UserTrackProviderProxy.click(view, trackInfo, true);
        }
    }

    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        TrackInfo trackInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "938410361")) {
            ipChange.ipc$dispatch("938410361", new Object[]{this, genericItem});
            return;
        }
        k21.i(genericItem, "item");
        super.init((IItem) genericItem);
        ProjectItemViewHolder viewHolder = ((OneProjectView) getView()).getViewHolder();
        viewHolder.n(((OneProjectModel) getModel()).getProject(), true);
        viewHolder.v(new xk1(this));
        Action itemAction = getItemAction();
        if (itemAction != null && (trackInfo = itemAction.getTrackInfo()) != null) {
            UserTrackProviderProxy.expose(((OneProjectView) getView()).getRenderView(), trackInfo);
        }
    }
}
