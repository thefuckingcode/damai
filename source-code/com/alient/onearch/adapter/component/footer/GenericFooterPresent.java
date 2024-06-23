package com.alient.onearch.adapter.component.footer;

import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import com.alient.onearch.adapter.BaseFragment;
import com.alient.onearch.adapter.ComponentTypeMapper;
import com.alient.onearch.adapter.Constant;
import com.alient.onearch.adapter.component.footer.GenericFooterContract;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.alient.oneservice.nav.Action;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.page.GenericFragment;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public class GenericFooterPresent extends AbsPresenter<GenericItem<ItemValue>, GenericFooterModel, GenericFooterView> implements GenericFooterContract.Presenter {
    private int componentId;
    private SparseArray<ComponentFooterDelegate> sectionFooterDelegates;

    public GenericFooterPresent(String str, String str2, View view, EventHandler eventHandler, String str3) {
        super(str, str2, view, eventHandler, str3);
    }

    private void initTrackInfo() {
        Action action;
        Map<String, Action> actions = getActions();
        if (actions != null && !actions.isEmpty()) {
            GenericFragment fragment = ((GenericItem) getItem()).getPageContext().getFragment();
            Iterator<String> it = actions.keySet().iterator();
            while (it.hasNext() && (action = actions.get(it.next())) != null) {
                if (action.getTrackInfo().getArgs() == null) {
                    action.getTrackInfo().setArgs(new HashMap<>());
                }
                action.getTrackInfo().getArgs().putAll(((BaseFragment) fragment).getTrackInfo().getArgs());
                action.getTrackInfo().getArgs().remove(Constant.UT.UT_PAG_NAME);
            }
        }
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoAction() {
        return false;
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoClickTrack() {
        return false;
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoExposeTrack() {
        return false;
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public void onItemClick(@NotNull View view) {
        SparseArray<ComponentFooterDelegate> sparseArray = this.sectionFooterDelegates;
        if (sparseArray != null && sparseArray.get(this.componentId) != null) {
            this.sectionFooterDelegates.get(this.componentId).onClick(getItem(), (GenericFooterModel) getModel(), getEventHandler());
        }
    }

    public void init(@NonNull GenericItem<ItemValue> genericItem) {
        super.init((IItem) genericItem);
        initTrackInfo();
        this.componentId = ComponentTypeMapper.INSTANCE.convertComponentTypeToInt(((GenericFooterModel) getModel()).getComponentId());
        SparseArray<ComponentFooterDelegate> componentFooterDelegates = ComponentFooterDelegateManager.Companion.getInstance().getComponentFooterDelegates(genericItem.getPageContext().toString());
        this.sectionFooterDelegates = componentFooterDelegates;
        if (componentFooterDelegates != null && componentFooterDelegates.get(this.componentId) != null) {
            this.sectionFooterDelegates.get(this.componentId).onBindView((GenericFooterView) getView(), (GenericFooterModel) getModel());
        }
    }
}
