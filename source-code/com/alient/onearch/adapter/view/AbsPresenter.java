package com.alient.onearch.adapter.view;

import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.BaseFragment;
import com.alient.oneservice.nav.Action;
import com.uc.webview.export.extension.UCCore;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.event.ViewHolderEvent;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.view.IContract;
import com.youku.arch.v3.view.IContract.Model;
import com.youku.arch.v3.view.IContract.View;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00020\u00020\u0001*\u000e\b\u0001\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u0004*\b\b\u0002\u0010\u0007*\u00020\u00062\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b2\u00020\tB5\b\u0016\u0012\u0006\u0010I\u001a\u00020\u0018\u0012\u0006\u0010J\u001a\u00020\u0018\u0012\b\u0010K\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010M\u001a\u00020L\u0012\b\u0010O\u001a\u0004\u0018\u00010N¢\u0006\u0004\bP\u0010QB5\b\u0016\u0012\u0006\u0010I\u001a\u00020\u0018\u0012\u0006\u0010J\u001a\u00020\u0018\u0012\b\u0010K\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010M\u001a\u00020L\u0012\b\u0010O\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\bP\u0010RB=\b\u0016\u0012\u0006\u0010I\u001a\u00020\u0018\u0012\u0006\u0010J\u001a\u00020\u0018\u0012\b\u0010K\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010M\u001a\u00020L\u0012\u0010\u0010O\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010 ¢\u0006\u0004\bP\u0010SB+\b\u0016\u0012\u0006\u0010T\u001a\u00028\u0001\u0012\u0006\u0010\u0010\u001a\u00028\u0002\u0012\u0006\u0010M\u001a\u00020L\u0012\b\u0010O\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\bP\u0010UJ\b\u0010\u000b\u001a\u00020\nH\u0002J\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016J&\u0010#\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00182\u0014\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0016J\u0010\u0010%\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u0013H\u0016R\"\u0010'\u001a\u00020&8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010-\u001a\u00020\u00138\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b-\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b3\u0010\u0003\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001a\u0018\u00010 8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R$\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001a\u0018\u00010 8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b;\u00109R\u0018\u0010?\u001a\u0004\u0018\u00010\u001a8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0016\u0010A\u001a\u0002028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b@\u00105R\u0016\u0010C\u001a\u0002028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bB\u00105R\u0016\u0010E\u001a\u0002028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bD\u00105R\u0016\u0010F\u001a\u00020\u00138V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bF\u0010/R\u0016\u0010G\u001a\u00020\u00138V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bG\u0010/R\u0016\u0010H\u001a\u00020\u00138V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bH\u0010/¨\u0006V"}, d2 = {"Lcom/alient/onearch/adapter/view/AbsPresenter;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "I", "Lcom/youku/arch/v3/view/IContract$Model;", "M", "Lcom/youku/arch/v3/view/IContract$View;", "V", "Lcom/youku/arch/v3/view/AbsPresenter;", "Lcom/alient/onearch/adapter/view/ViewCard;", "Ltb/ur2;", "initResponsiveLayoutState", "item", UCCore.LEGACY_EVENT_INIT, "(Lcom/youku/arch/v3/IItem;)V", "Landroid/view/View;", "view", "itemClick", "itemLongClick", "", "enableRankInAll", "enableAutoExposeTrack", "enableAutoClickTrack", "enableAutoAction", "", "key", "Lcom/alient/oneservice/nav/Action;", "getAction", "onItemClick", "onItemLongClick", "isDegrade", "type", "", "", "params", "onMessage", "changed", "responsiveLayoutStateChanged", "Lcom/alient/onearch/adapter/view/GenericViewCard;", "viewCard", "Lcom/alient/onearch/adapter/view/GenericViewCard;", "getViewCard", "()Lcom/alient/onearch/adapter/view/GenericViewCard;", "setViewCard", "(Lcom/alient/onearch/adapter/view/GenericViewCard;)V", "isSelected", "Z", "()Z", "setSelected", "(Z)V", "", "currentResponsiveLayoutState", "getCurrentResponsiveLayoutState", "()I", "setCurrentResponsiveLayoutState", "(I)V", "getActions", "()Ljava/util/Map;", "actions", "getComponentActions", "componentActions", "getItemAction", "()Lcom/alient/oneservice/nav/Action;", "itemAction", "getModuleRank", "moduleRank", "getRankInModule", "rankInModule", "getRankInAll", "rankInAll", "isOnlyChild", "isFirstChild", "isLastChild", "mClassName", "vClassName", "renderView", "Lcom/youku/arch/v3/event/EventHandler;", "eventHandler", "Lcom/alibaba/fastjson/JSONObject;", Constants.CONFIG, "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View;Lcom/youku/arch/v3/event/EventHandler;Lcom/alibaba/fastjson/JSONObject;)V", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View;Lcom/youku/arch/v3/event/EventHandler;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View;Lcom/youku/arch/v3/event/EventHandler;Ljava/util/Map;)V", "model", "(Lcom/youku/arch/v3/view/IContract$Model;Lcom/youku/arch/v3/view/IContract$View;Lcom/youku/arch/v3/event/EventHandler;Ljava/lang/String;)V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public abstract class AbsPresenter<I extends IItem<ItemValue>, M extends IContract.Model<I>, V extends IContract.View> extends com.youku.arch.v3.view.AbsPresenter<I, M, V> implements ViewCard {
    private int currentResponsiveLayoutState;
    private boolean isSelected;
    public GenericViewCard viewCard;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbsPresenter(@NotNull String str, @NotNull String str2, @Nullable android.view.View view, @NotNull EventHandler eventHandler, @Nullable JSONObject jSONObject) {
        super(str, str2, view, eventHandler, jSONObject);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }

    private final void initResponsiveLayoutState() {
        GenericFragment fragment = getItem().getPageContext().getFragment();
        if (!(fragment instanceof BaseFragment)) {
            fragment = null;
        }
        BaseFragment baseFragment = (BaseFragment) fragment;
        if (baseFragment == null) {
            return;
        }
        if (this.currentResponsiveLayoutState != baseFragment.getResponsiveFragmentStateManager().a()) {
            this.currentResponsiveLayoutState = baseFragment.getResponsiveFragmentStateManager().a();
            responsiveLayoutStateChanged(true);
            return;
        }
        responsiveLayoutStateChanged(false);
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoAction() {
        return true;
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoClickTrack() {
        return true;
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoExposeTrack() {
        return true;
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public boolean enableRankInAll() {
        return false;
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    @Nullable
    public Action getAction(@Nullable String str) {
        GenericViewCard genericViewCard = this.viewCard;
        if (genericViewCard == null) {
            k21.A("viewCard");
        }
        return genericViewCard.getAction(str);
    }

    @Nullable
    public Map<String, Action> getActions() {
        if (!(getModel() instanceof AbsModel)) {
            return new HashMap();
        }
        IContract.Model model = getModel();
        Objects.requireNonNull(model, "null cannot be cast to non-null type com.alient.onearch.adapter.view.AbsModel<*, *>");
        return ((AbsModel) model).getActions();
    }

    @Nullable
    public Map<String, Action> getComponentActions() {
        if (!(getModel() instanceof AbsModel)) {
            return new HashMap();
        }
        IContract.Model model = getModel();
        Objects.requireNonNull(model, "null cannot be cast to non-null type com.alient.onearch.adapter.view.AbsModel<*, *>");
        return ((AbsModel) model).getComponentActions();
    }

    public final int getCurrentResponsiveLayoutState() {
        return this.currentResponsiveLayoutState;
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    @Nullable
    public Action getItemAction() {
        GenericViewCard genericViewCard = this.viewCard;
        if (genericViewCard == null) {
            k21.A("viewCard");
        }
        return genericViewCard.getItemAction();
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public int getModuleRank() {
        GenericViewCard genericViewCard = this.viewCard;
        if (genericViewCard == null) {
            k21.A("viewCard");
        }
        return genericViewCard.getModuleRank();
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public int getRankInAll() {
        GenericViewCard genericViewCard = this.viewCard;
        if (genericViewCard == null) {
            k21.A("viewCard");
        }
        return genericViewCard.getRankInAll();
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public int getRankInModule() {
        GenericViewCard genericViewCard = this.viewCard;
        if (genericViewCard == null) {
            k21.A("viewCard");
        }
        return genericViewCard.getRankInModule();
    }

    @NotNull
    public final GenericViewCard getViewCard() {
        GenericViewCard genericViewCard = this.viewCard;
        if (genericViewCard == null) {
            k21.A("viewCard");
        }
        return genericViewCard;
    }

    @Override // com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull I i) {
        k21.i(i, "item");
        super.init(i);
        initResponsiveLayoutState();
        this.viewCard = new GenericViewCard(this, i, getActions(), getView().getRenderView());
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public boolean isDegrade() {
        ModelValue property;
        JSONObject data;
        String string;
        IContainer<ModelValue> container = getItem().getContainer();
        if (!(container == null || (property = container.getProperty()) == null || (data = property.getData()) == null || (string = data.getString("comboDegrade")) == null)) {
            try {
                if (!(string.length() == 0)) {
                    return Boolean.parseBoolean(string);
                }
            } catch (Exception e) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    throw e;
                }
            }
        }
        return false;
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public boolean isFirstChild() {
        GenericViewCard genericViewCard = this.viewCard;
        if (genericViewCard == null) {
            k21.A("viewCard");
        }
        return genericViewCard.isFirstChild();
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public boolean isLastChild() {
        GenericViewCard genericViewCard = this.viewCard;
        if (genericViewCard == null) {
            k21.A("viewCard");
        }
        return genericViewCard.isLastChild();
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public boolean isOnlyChild() {
        GenericViewCard genericViewCard = this.viewCard;
        if (genericViewCard == null) {
            k21.A("viewCard");
        }
        return genericViewCard.isOnlyChild();
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void itemClick(@NotNull android.view.View view) {
        k21.i(view, "view");
        GenericViewCard genericViewCard = this.viewCard;
        if (genericViewCard == null) {
            k21.A("viewCard");
        }
        genericViewCard.onItemClick(view);
    }

    public final void itemLongClick(@NotNull android.view.View view) {
        k21.i(view, "view");
        GenericViewCard genericViewCard = this.viewCard;
        if (genericViewCard == null) {
            k21.A("viewCard");
        }
        genericViewCard.onItemLongClick(view);
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public void onItemClick(@NotNull android.view.View view) {
        k21.i(view, "view");
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public void onItemLongClick(@NotNull android.view.View view) {
        k21.i(view, "view");
    }

    @Override // com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public boolean onMessage(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        Boolean bool;
        k21.i(str, "type");
        if (!k21.d(ViewHolderEvent.ON_VIEW_SELECTED, str) || map == null || (bool = (Boolean) map.get("selected")) == null) {
            return super.onMessage(str, map);
        }
        this.isSelected = bool.booleanValue();
        return true;
    }

    public void responsiveLayoutStateChanged(boolean z) {
    }

    public final void setCurrentResponsiveLayoutState(int i) {
        this.currentResponsiveLayoutState = i;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final void setViewCard(@NotNull GenericViewCard genericViewCard) {
        k21.i(genericViewCard, "<set-?>");
        this.viewCard = genericViewCard;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbsPresenter(@NotNull String str, @NotNull String str2, @Nullable android.view.View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbsPresenter(@NotNull String str, @NotNull String str2, @Nullable android.view.View view, @NotNull EventHandler eventHandler, @Nullable Map<?, ?> map) {
        super(str, str2, view, eventHandler, map);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbsPresenter(@NotNull M m, @NotNull V v, @NotNull EventHandler eventHandler, @Nullable String str) {
        super(m, v, eventHandler, str);
        k21.i(m, "model");
        k21.i(v, "view");
        k21.i(eventHandler, "eventHandler");
    }
}
