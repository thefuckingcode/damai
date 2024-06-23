package com.youku.arch.v3.view;

import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.uc.webview.export.extension.UCCore;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.component.GenericComponent;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.event.FragmentEvent;
import com.youku.arch.v3.util.LogUtil;
import com.youku.arch.v3.view.IContract;
import com.youku.arch.v3.view.IContract.Model;
import com.youku.arch.v3.view.IContract.View;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joor.a;
import tb.k21;
import tb.m40;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001f\b&\u0018\u0000 I*\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00020\u00020\u0001*\u000e\b\u0001\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u0004*\b\b\u0002\u0010\u0007*\u00020\u00062\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b:\u0001IB7\b\u0016\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010'\u001a\u00020&\u0012\b\u0010$\u001a\u0004\u0018\u00010+¢\u0006\u0004\bD\u0010EB7\b\u0016\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010'\u001a\u00020&\u0012\b\u0010$\u001a\u0004\u0018\u00010\t¢\u0006\u0004\bD\u0010FB?\b\u0016\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010'\u001a\u00020&\u0012\u0010\u0010$\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u001f¢\u0006\u0004\bD\u0010GB+\b\u0016\u0012\u0006\u0010.\u001a\u00028\u0001\u0012\u0006\u0010)\u001a\u00028\u0002\u0012\u0006\u0010'\u001a\u00020&\u0012\b\u0010$\u001a\u0004\u0018\u00010\t¢\u0006\u0004\bD\u0010HJ!\u0010\r\u001a\u00028\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J!\u0010\u0015\u001a\u00028\u00012\u0006\u0010\u0013\u001a\u00028\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00028\u0000¢\u0006\u0004\b\u001a\u0010\u0019J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\u0017H\u0016J&\u0010#\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\t2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020 \u0018\u00010\u001fH\u0016J\u001c\u0010%\u001a\u00020\u00172\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020 \u0018\u00010\u001fJ\u000e\u0010(\u001a\u00020\u00172\u0006\u0010'\u001a\u00020&J\u0018\u0010*\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010\u000bR\u0018\u0010$\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010,R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010-R\"\u0010.\u001a\u00028\u00018\u0006@\u0006X.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u0010)\u001a\u00028\u00028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b)\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010\u0013\u001a\u00028\u00008\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0013\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010\u0019R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b'\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010C¨\u0006J"}, d2 = {"Lcom/youku/arch/v3/view/AbsPresenter;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "DATA", "Lcom/youku/arch/v3/view/IContract$Model;", "MODEL", "Lcom/youku/arch/v3/view/IContract$View;", "VIEW", "Lcom/youku/arch/v3/view/IContract$Presenter;", "", "vClassName", "Landroid/view/View;", "renderView", "createView", "(Ljava/lang/String;Landroid/view/View;)Lcom/youku/arch/v3/view/IContract$View;", "Landroid/view/ViewGroup;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "findInnerRecyclerView", "item", "mClassName", "createModel", "(Lcom/youku/arch/v3/IItem;Ljava/lang/String;)Lcom/youku/arch/v3/view/IContract$Model;", "Ltb/ur2;", UCCore.LEGACY_EVENT_INIT, "(Lcom/youku/arch/v3/IItem;)V", "preAsyncInit", "saveState", "onCreate", "onDestroy", "type", "", "", "params", "", "onMessage", Constants.CONFIG, "updateConfig", "Lcom/youku/arch/v3/event/EventHandler;", "eventHandler", "updateEventHandler", "view", "updateView", "Lcom/alibaba/fastjson/JSONObject;", "Lcom/alibaba/fastjson/JSONObject;", "Ljava/lang/String;", "model", "Lcom/youku/arch/v3/view/IContract$Model;", "getModel", "()Lcom/youku/arch/v3/view/IContract$Model;", "setModel", "(Lcom/youku/arch/v3/view/IContract$Model;)V", "Lcom/youku/arch/v3/view/IContract$View;", "getView", "()Lcom/youku/arch/v3/view/IContract$View;", "setView", "(Lcom/youku/arch/v3/view/IContract$View;)V", "Lcom/youku/arch/v3/IItem;", "getItem", "()Lcom/youku/arch/v3/IItem;", "setItem", "Lcom/youku/arch/v3/event/EventHandler;", "getEventHandler", "()Lcom/youku/arch/v3/event/EventHandler;", "setEventHandler", "(Lcom/youku/arch/v3/event/EventHandler;)V", "isInited", "Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View;Lcom/youku/arch/v3/event/EventHandler;Lcom/alibaba/fastjson/JSONObject;)V", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View;Lcom/youku/arch/v3/event/EventHandler;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View;Lcom/youku/arch/v3/event/EventHandler;Ljava/util/Map;)V", "(Lcom/youku/arch/v3/view/IContract$Model;Lcom/youku/arch/v3/view/IContract$View;Lcom/youku/arch/v3/event/EventHandler;Ljava/lang/String;)V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public abstract class AbsPresenter<DATA extends IItem<ItemValue>, MODEL extends IContract.Model<DATA>, VIEW extends IContract.View> implements IContract.Presenter<DATA, MODEL> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "OneArch.AbsPresenter";
    @Nullable
    private JSONObject config;
    @NotNull
    private EventHandler eventHandler;
    private volatile boolean isInited;
    public DATA item;
    @Nullable
    private String mClassName;
    public MODEL model;
    public VIEW view;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/youku/arch/v3/view/AbsPresenter$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0025, code lost:
        if (tb.k21.d(r2 instanceof java.lang.Boolean ? (java.lang.Boolean) r2 : null, java.lang.Boolean.TRUE) == false) goto L_0x0027;
     */
    public AbsPresenter(@Nullable String str, @NotNull String str2, @Nullable android.view.View view2, @NotNull EventHandler eventHandler2, @Nullable JSONObject jSONObject) {
        k21.i(str2, "vClassName");
        k21.i(eventHandler2, "eventHandler");
        this.mClassName = str;
        if (jSONObject != null) {
            Object obj = jSONObject.get("PresenterCreator.inAdvance");
        }
        try {
            setView(createView(str2, view2));
            getView().bindPresenter(this);
        } catch (Throwable th) {
            if (AppInfoProviderProxy.isDebuggable()) {
                LogUtil.e(TAG, k21.r("createView occur exception ", th.getMessage()));
            }
        }
        this.eventHandler = eventHandler2;
        this.config = jSONObject;
        if (jSONObject == null) {
            this.config = new JSONObject();
        }
    }

    private final VIEW createView(String str, android.view.View view2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1831543711")) {
            return (VIEW) ((IContract.View) ipChange.ipc$dispatch("1831543711", new Object[]{this, str, view2}));
        }
        Object f = a.k(str, getClass().getClassLoader()).c(view2).f();
        k21.h(f, "on(vClassName, this.java….create(renderView).get()");
        return (VIEW) ((IContract.View) f);
    }

    private final RecyclerView findInnerRecyclerView(ViewGroup viewGroup) {
        RecyclerView findInnerRecyclerView;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-256440769")) {
            return (RecyclerView) ipChange.ipc$dispatch("-256440769", new Object[]{this, viewGroup});
        }
        int childCount = viewGroup.getChildCount();
        if (childCount <= 0) {
            return null;
        }
        while (true) {
            int i2 = i + 1;
            android.view.View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof RecyclerView) {
                return (RecyclerView) childAt;
            }
            if ((childAt instanceof ViewGroup) && (findInnerRecyclerView = findInnerRecyclerView((ViewGroup) childAt)) != null) {
                return findInnerRecyclerView;
            }
            if (i2 >= childCount) {
                return null;
            }
            i = i2;
        }
    }

    @Override // com.youku.arch.v3.view.IContract.Presenter
    @NotNull
    public MODEL createModel(@NotNull DATA data, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-189951661")) {
            return (MODEL) ((IContract.Model) ipChange.ipc$dispatch("-189951661", new Object[]{this, data, str}));
        }
        k21.i(data, "item");
        Object f = a.k(str, getClass().getClassLoader()).b().f();
        k21.h(f, "on(mClassName, this.java…assLoader).create().get()");
        return (MODEL) ((IContract.Model) f);
    }

    @NotNull
    public final EventHandler getEventHandler() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1981846623")) {
            return this.eventHandler;
        }
        return (EventHandler) ipChange.ipc$dispatch("1981846623", new Object[]{this});
    }

    @NotNull
    public final DATA getItem() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "506553139")) {
            return (DATA) ((IItem) ipChange.ipc$dispatch("506553139", new Object[]{this}));
        }
        DATA data = this.item;
        if (data != null) {
            return data;
        }
        k21.A("item");
        return null;
    }

    @NotNull
    public final MODEL getModel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1848211483")) {
            return (MODEL) ((IContract.Model) ipChange.ipc$dispatch("-1848211483", new Object[]{this}));
        }
        MODEL model2 = this.model;
        if (model2 != null) {
            return model2;
        }
        k21.A("model");
        return null;
    }

    @NotNull
    public final VIEW getView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "20642149")) {
            return (VIEW) ((IContract.View) ipChange.ipc$dispatch("20642149", new Object[]{this}));
        }
        VIEW view2 = this.view;
        if (view2 != null) {
            return view2;
        }
        k21.A("view");
        return null;
    }

    @Override // com.youku.arch.v3.view.IContract.Presenter
    public synchronized void init(@NotNull DATA data) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1256935758")) {
            ipChange.ipc$dispatch("-1256935758", new Object[]{this, data});
            return;
        }
        k21.i(data, "item");
        setItem(data);
        if (!this.isInited) {
            this.isInited = true;
            try {
                setModel(createModel(data, this.mClassName));
            } catch (Throwable th) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    LogUtil.e(TAG, k21.r("createModel occur exception ", th.getMessage()));
                }
            }
        }
        getModel().parseModel(data);
        if (data.getComponent() instanceof GenericComponent) {
            ((GenericComponent) data.getComponent()).setDataBound(true);
        }
    }

    @Override // com.youku.arch.v3.view.IContract.Presenter
    public void onCreate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "420967541")) {
            ipChange.ipc$dispatch("420967541", new Object[]{this});
        }
    }

    @Override // com.youku.arch.v3.view.IContract.Presenter
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "257279295")) {
            ipChange.ipc$dispatch("257279295", new Object[]{this});
        }
    }

    @Override // com.youku.arch.v3.view.IContract.Presenter
    public boolean onMessage(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        int findFirstVisibleItemPosition;
        int findLastVisibleItemPosition;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1006378835")) {
            return ((Boolean) ipChange.ipc$dispatch("-1006378835", new Object[]{this, str, map})).booleanValue();
        }
        k21.i(str, "type");
        if (!k21.d(FragmentEvent.ON_FRAGMENT_RECYCLERVIEW_SCROLL_IDLE, str) || getItem().getComponent().getInnerAdapter() == null || getView().getRenderView() == null) {
            return false;
        }
        android.view.View renderView = getView().getRenderView();
        if (!(renderView instanceof RecyclerView)) {
            renderView = renderView instanceof ViewGroup ? findInnerRecyclerView((ViewGroup) renderView) : null;
        }
        RecyclerView recyclerView = (RecyclerView) renderView;
        RecyclerView.LayoutManager layoutManager = recyclerView == null ? null : recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null || (findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition()) > (findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition())) {
            return false;
        }
        boolean z = false;
        while (true) {
            int i = findFirstVisibleItemPosition + 1;
            android.view.View findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
            if (findViewByPosition != null) {
                RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(findViewByPosition);
                VBaseHolder vBaseHolder = childViewHolder instanceof VBaseHolder ? (VBaseHolder) childViewHolder : null;
                z = vBaseHolder != null && vBaseHolder.onMessage(str, map);
            }
            if (findFirstVisibleItemPosition == findLastVisibleItemPosition) {
                return z;
            }
            findFirstVisibleItemPosition = i;
        }
    }

    public final synchronized void preAsyncInit(@NotNull DATA data) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-183007381")) {
            ipChange.ipc$dispatch("-183007381", new Object[]{this, data});
            return;
        }
        k21.i(data, "item");
        if (!this.isInited) {
            this.isInited = true;
            try {
                setModel(createModel(data, this.mClassName));
            } catch (Throwable th) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    LogUtil.e(TAG, k21.r("createModel occur exception ", th.getMessage()));
                }
            }
        }
        getModel().parseModel(data);
    }

    @Override // com.youku.arch.v3.view.IContract.Presenter
    public void saveState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1005371046")) {
            ipChange.ipc$dispatch("1005371046", new Object[]{this});
        }
    }

    public final void setEventHandler(@NotNull EventHandler eventHandler2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-512322267")) {
            ipChange.ipc$dispatch("-512322267", new Object[]{this, eventHandler2});
            return;
        }
        k21.i(eventHandler2, "<set-?>");
        this.eventHandler = eventHandler2;
    }

    public final void setItem(@NotNull DATA data) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1028495347")) {
            ipChange.ipc$dispatch("-1028495347", new Object[]{this, data});
            return;
        }
        k21.i(data, "<set-?>");
        this.item = data;
    }

    public final void setModel(@NotNull MODEL model2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-305416459")) {
            ipChange.ipc$dispatch("-305416459", new Object[]{this, model2});
            return;
        }
        k21.i(model2, "<set-?>");
        this.model = model2;
    }

    public final void setView(@NotNull VIEW view2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-463905053")) {
            ipChange.ipc$dispatch("-463905053", new Object[]{this, view2});
            return;
        }
        k21.i(view2, "<set-?>");
        this.view = view2;
    }

    public final void updateConfig(@Nullable Map<String, ? extends Object> map) {
        JSONObject jSONObject;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2145742240")) {
            ipChange.ipc$dispatch("2145742240", new Object[]{this, map});
            return;
        }
        JSONObject jSONObject2 = this.config;
        if (jSONObject2 != null) {
            jSONObject2.clear();
        }
        if (map != null && (jSONObject = this.config) != null) {
            jSONObject.putAll(map);
        }
    }

    public final void updateEventHandler(@NotNull EventHandler eventHandler2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "630957684")) {
            ipChange.ipc$dispatch("630957684", new Object[]{this, eventHandler2});
            return;
        }
        k21.i(eventHandler2, "eventHandler");
        this.eventHandler = eventHandler2;
    }

    public final void updateView(@NotNull String str, @Nullable android.view.View view2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-921301370")) {
            ipChange.ipc$dispatch("-921301370", new Object[]{this, str, view2});
            return;
        }
        k21.i(str, "vClassName");
        if (view2 != null) {
            setView(createView(str, view2));
            if (getView() != null) {
                getView().bindPresenter(this);
                return;
            }
            throw new IllegalStateException(k21.r("createView null ", str).toString());
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AbsPresenter(@Nullable String str, @NotNull String str2, @Nullable android.view.View view2, @NotNull EventHandler eventHandler2, @Nullable String str3) {
        this(str, str2, view2, eventHandler2, JSON.parseObject(str3));
        k21.i(str2, "vClassName");
        k21.i(eventHandler2, "eventHandler");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public AbsPresenter(@Nullable String str, @NotNull String str2, @Nullable android.view.View view2, @NotNull EventHandler eventHandler2, @Nullable Map<?, ?> map) {
        this(str, str2, view2, eventHandler2, (JSONObject) r12);
        k21.i(str2, "vClassName");
        k21.i(eventHandler2, "eventHandler");
        Object json = JSON.toJSON(map);
        Objects.requireNonNull(json, "null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
    }

    public AbsPresenter(@NotNull MODEL model2, @NotNull VIEW view2, @NotNull EventHandler eventHandler2, @Nullable String str) {
        k21.i(model2, "model");
        k21.i(view2, "view");
        k21.i(eventHandler2, "eventHandler");
        this.mClassName = null;
        setModel(model2);
        setView(view2);
        getView().bindPresenter(this);
        this.eventHandler = eventHandler2;
        if (str == null || str.length() == 0) {
            this.config = new JSONObject();
        } else {
            this.config = JSON.parseObject(str);
        }
    }
}
