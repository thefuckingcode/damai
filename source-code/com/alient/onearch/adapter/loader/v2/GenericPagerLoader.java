package com.alient.onearch.adapter.loader.v2;

import android.app.Activity;
import android.util.SparseArray;
import com.alibaba.android.ultron.trade.event.OpenSimplePopupSubscriber;
import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.BaseFragment;
import com.alient.onearch.adapter.PageInfoBean;
import com.alient.onearch.adapter.decorate.ComponentDecorateItem;
import com.alient.onearch.adapter.decorate.ComponentDecorator;
import com.alient.onearch.adapter.loader.ComponentItemDisplayLimiter;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.adapter.ViewTypeConfig;
import com.youku.arch.v3.adapter.ViewTypeSupport;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.PageContainer;
import com.youku.arch.v3.creator.ComponentCreatorManager;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.loader.PageLoader;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.page.state.PageStateManager;
import com.youku.arch.v3.view.config.ComponentConfigBean;
import com.youku.arch.v3.view.config.ComponentConfigManager;
import com.youku.kubus.IdGenerator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.b;
import kotlin.collections.k;
import kotlin.text.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010+\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 L2\u00020\u0001:\u0001LB\u0015\u0012\f\u0010I\u001a\b\u0012\u0004\u0012\u00020H0G¢\u0006\u0004\bJ\u0010KJ\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J \u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bH\u0002J\u001e\u0010\u000e\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001e\u0010\u000f\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0002J&\u0010\u0014\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0016\u001a\u00020\u0011H\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u001e\u0010\u001f\u001a\u00020\u00052\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J\u001e\u0010 \u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001e\u0010#\u001a\u00020\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0006\u0010\"\u001a\u00020\u0007H\u0016J\u001e\u0010$\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001e\u0010'\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010(\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010*\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J\u0018\u0010+\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J&\u0010.\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010-\u001a\u00020,H\u0016J\u0018\u0010.\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010-\u001a\u00020,H\u0016J\u0018\u00100\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\tH\u0014J\u0016\u00103\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00172\u0006\u00102\u001a\u00020\u0017J\u0016\u00106\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u00020,J\u0016\u00107\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u00020,R\u001d\u0010=\u001a\u0002088B@\u0002X\u0002¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001d\u0010B\u001a\u00020>8B@\u0002X\u0002¢\u0006\f\n\u0004\b?\u0010:\u001a\u0004\b@\u0010AR\u001e\u0010E\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010C8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006M"}, d2 = {"Lcom/alient/onearch/adapter/loader/v2/GenericPagerLoader;", "Lcom/youku/arch/v3/loader/PageLoader;", "", "utPageName", "spmAB", "Ltb/ur2;", "handlePageUTParams", "Lcom/youku/arch/v3/core/Node;", "componentNode", "", "isFilterComponent", "", "componentIterator", "tryCreateDecorateComponentNode", "handleCreateBeforeDecorateComponentNode", "handleCreateAfterDecorateComponentNode", "source", "Lcom/alibaba/fastjson/JSONObject;", "top", "bottom", "handlePageBaseInfo", "Lcom/youku/arch/v3/io/IResponse;", "response", "", "index", "handleLoadSuccess", "parseNode", "node", "handleNode", "itemIterator", "itemNode", "handleItemNode", "handleComponentNode", "moduleIterator", "moduleNode", "handleModuleNode", "handleCreateFooterComponentNode", "handleCreateFooterComponentNodeType", "handleCreateFooterItemNodeType", "handleCreateHeaderComponentNode", "handleCreateHeaderComponentNodeType", "handleCreateHeaderItemNodeType", "handleFooterItemProperty", "handleHeaderItemProperty", "Lcom/alient/onearch/adapter/decorate/ComponentDecorateItem;", "componentDecorateItemNode", "createDecorateComponent", "hasItem", "setLoadingViewState", OpenSimplePopupSubscriber.KEY_COMPONENT_TYPE, "limitSize", "addComponentDisplayLimit", "componentId", "decorate", "addComponentDecorate", "removeComponentDecorate", "Lcom/alient/onearch/adapter/loader/ComponentItemDisplayLimiter;", "componentItemDisplayLimiter$delegate", "Lkotlin/Lazy;", "getComponentItemDisplayLimiter", "()Lcom/alient/onearch/adapter/loader/ComponentItemDisplayLimiter;", "componentItemDisplayLimiter", "Lcom/alient/onearch/adapter/decorate/ComponentDecorator;", "componentDecorator$delegate", "getComponentDecorator", "()Lcom/alient/onearch/adapter/decorate/ComponentDecorator;", "componentDecorator", "Landroid/util/SparseArray;", "Lcom/youku/arch/v3/view/config/ComponentConfigBean$ComponentBean;", "componentConfigs", "Landroid/util/SparseArray;", "Lcom/youku/arch/v3/core/PageContainer;", "Lcom/youku/arch/v3/core/ModelValue;", "pageContainer", "<init>", "(Lcom/youku/arch/v3/core/PageContainer;)V", "Companion", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public class GenericPagerLoader extends PageLoader {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PAGE_BOTTOM_DATA = "bottom";
    @NotNull
    public static final String PAGE_TOP_DATA = "top";
    @NotNull
    public static final String UT_PAGE_NAME = "pageName";
    @NotNull
    public static final String UT_SPM_AB = "spmab";
    private SparseArray<ComponentConfigBean.ComponentBean> componentConfigs;
    private final Lazy componentDecorator$delegate;
    private final Lazy componentItemDisplayLimiter$delegate;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/alient/onearch/adapter/loader/v2/GenericPagerLoader$Companion;", "", "", "PAGE_BOTTOM_DATA", "Ljava/lang/String;", "PAGE_TOP_DATA", "UT_PAGE_NAME", "UT_SPM_AB", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenericPagerLoader(@NotNull PageContainer<ModelValue> pageContainer) {
        super(pageContainer);
        ConfigManager configManager;
        String pathConfig;
        k21.i(pageContainer, "pageContainer");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        this.componentItemDisplayLimiter$delegate = b.a(lazyThreadSafetyMode, GenericPagerLoader$componentItemDisplayLimiter$2.INSTANCE);
        this.componentDecorator$delegate = b.a(lazyThreadSafetyMode, GenericPagerLoader$componentDecorator$2.INSTANCE);
        Activity activity = ((IContainer) getHost()).getPageContext().getActivity();
        if (activity != null && (configManager = ((IContainer) getHost()).getPageContext().getConfigManager()) != null && (pathConfig = configManager.getPathConfig(ConfigManager.COMPONENT_CONFIG_FILE)) != null) {
            this.componentConfigs = ComponentConfigManager.Companion.getInstance().getComponentConfigs(activity, pathConfig);
        }
    }

    private final ComponentDecorator getComponentDecorator() {
        return (ComponentDecorator) this.componentDecorator$delegate.getValue();
    }

    private final ComponentItemDisplayLimiter getComponentItemDisplayLimiter() {
        return (ComponentItemDisplayLimiter) this.componentItemDisplayLimiter$delegate.getValue();
    }

    private final void handleCreateAfterDecorateComponentNode(ListIterator<Node> listIterator, Node node) {
        ComponentDecorateItem componentDecorate = getComponentDecorator().getComponentDecorate(node.getType(), ComponentDecorateItem.Indexer.After);
        if (componentDecorate != null) {
            createDecorateComponent(listIterator, node, componentDecorate);
        }
    }

    private final void handleCreateBeforeDecorateComponentNode(ListIterator<Node> listIterator, Node node) {
        ComponentDecorateItem componentDecorate = getComponentDecorator().getComponentDecorate(node.getType(), ComponentDecorateItem.Indexer.Before);
        if (componentDecorate != null) {
            createDecorateComponent(listIterator, node, componentDecorate);
        }
    }

    private final void handlePageUTParams(String str, String str2) {
        GenericFragment fragment = ((IContainer) getHost()).getPageContext().getFragment();
        if (!(fragment instanceof BaseFragment)) {
            fragment = null;
        }
        BaseFragment baseFragment = (BaseFragment) fragment;
        if (baseFragment != null) {
            boolean z = false;
            if (!(str2 == null || str2.length() == 0)) {
                List z0 = g.z0(str2, new String[]{"."}, false, 0, 6, null);
                if (!(z0 == null || z0.isEmpty()) && z0.size() > 1) {
                    baseFragment.getTrackInfo().setSpma((String) z0.get(0));
                    baseFragment.getTrackInfo().setSpmb((String) z0.get(1));
                }
            }
            if (!(str == null || str.length() == 0)) {
                String spmb = baseFragment.getTrackInfo().getSpmb();
                if (spmb == null || spmb.length() == 0) {
                    z = true;
                }
                if (!z) {
                    String spmb2 = baseFragment.getTrackInfo().getSpmb();
                    k21.h(spmb2, "it.trackInfo.spmb");
                    baseFragment.updateUTPageNameFromRemote(str, spmb2);
                }
            }
        }
    }

    private final boolean isFilterComponent(Node node) {
        JSONObject data = node.getData();
        if (!k21.d(data != null ? data.get("isFilterEmpty") : null, "false")) {
            List<Node> children = node.getChildren();
            if (children == null || children.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00d0  */
    private final void tryCreateDecorateComponentNode(Node node, ListIterator<Node> listIterator) {
        boolean z;
        boolean z2;
        Node node2;
        ComponentCreatorManager componentCreatorManager;
        JSONObject data = node.getData();
        if (data != null) {
            List<Node> children = node.getChildren();
            boolean z3 = false;
            if (children == null || (node2 = (Node) k.P(children)) == null || node2.getLevel() != 2) {
                z2 = false;
            } else {
                List<Node> children2 = node.getChildren();
                if (children2 != null) {
                    z = false;
                    for (T t : children2) {
                        if (t.getLevel() == 2) {
                            SparseArray<ComponentConfigBean.ComponentBean> sparseArray = this.componentConfigs;
                            if (!(sparseArray == null || sparseArray.get(t.getType()) == null)) {
                                z = true;
                            }
                            if (!z && (componentCreatorManager = ((IContainer) getHost()).getPageContext().getComponentCreatorManager()) != null) {
                                z = componentCreatorManager.isSupport(t.getType());
                            }
                        }
                    }
                    z2 = true;
                    if (!z2) {
                        z = true;
                    }
                    if (listIterator != null) {
                        boolean z4 = getComponentDecorator().getComponentDecorate(node.getType(), ComponentDecorateItem.Indexer.Before) != null;
                        if (z) {
                            String string = data.getString("title");
                            if (!(string == null || string.length() == 0) && (!k21.d(data.getString("hiddenTitle"), "true"))) {
                                z3 = true;
                            }
                        }
                        if (z4 || z3) {
                            listIterator.remove();
                        }
                        if (z4) {
                            handleCreateBeforeDecorateComponentNode(listIterator, node);
                        }
                        if (z3) {
                            handleCreateHeaderComponentNode(listIterator, node);
                        }
                        if (z4 || z3) {
                            listIterator.add(node);
                        }
                    }
                    if (!k21.d(data.getString("hiddenFooter"), "true")) {
                        Object obj = data.get(Constants.DISPLAY_NUM);
                        String str = null;
                        if (!(obj instanceof String)) {
                            obj = null;
                        }
                        String str2 = (String) obj;
                        if (str2 != null) {
                            int intValue = Integer.valueOf(Integer.parseInt(str2)).intValue();
                            List<Node> children3 = node.getChildren();
                            Integer valueOf = children3 != null ? Integer.valueOf(children3.size()) : null;
                            Object obj2 = data.get(Constants.TOTAL_NUM);
                            if (obj2 instanceof String) {
                                str = obj2;
                            }
                            String str3 = (String) str;
                            if (str3 != null) {
                                valueOf = Integer.valueOf(Integer.parseInt(str3));
                            }
                            if (!(valueOf == null || intValue >= valueOf.intValue() || listIterator == null)) {
                                handleCreateFooterComponentNode(listIterator, node);
                            }
                        } else {
                            Integer geComponentLimitSize = getComponentItemDisplayLimiter().geComponentLimitSize(node.getType());
                            if (geComponentLimitSize != null) {
                                int intValue2 = geComponentLimitSize.intValue();
                                List<Node> children4 = node.getChildren();
                                Integer valueOf2 = children4 != null ? Integer.valueOf(children4.size()) : null;
                                Object obj3 = data.get(Constants.TOTAL_NUM);
                                if (obj3 instanceof String) {
                                    str = obj3;
                                }
                                String str4 = str;
                                if (str4 != null) {
                                    valueOf2 = Integer.valueOf(Integer.parseInt(str4));
                                }
                                if (!(valueOf2 == null || intValue2 >= valueOf2.intValue() || listIterator == null)) {
                                    data.put((Object) Constants.DISPLAY_NUM, (Object) Integer.valueOf(intValue2));
                                    handleCreateFooterComponentNode(listIterator, node);
                                }
                            }
                        }
                    }
                    if (!(getComponentDecorator().getComponentDecorate(node.getType(), ComponentDecorateItem.Indexer.After) == null || listIterator == null)) {
                        handleCreateAfterDecorateComponentNode(listIterator, node);
                        return;
                    }
                }
                z2 = true;
            }
            z = false;
            if (!z2) {
            }
            if (listIterator != null) {
            }
            if (!k21.d(data.getString("hiddenFooter"), "true")) {
            }
            if (getComponentDecorator().getComponentDecorate(node.getType(), ComponentDecorateItem.Indexer.After) == null) {
            }
        }
    }

    public final void addComponentDecorate(int i, @NotNull ComponentDecorateItem componentDecorateItem) {
        k21.i(componentDecorateItem, "decorate");
        getComponentDecorator().addComponentDecorate(i, componentDecorateItem);
    }

    public final void addComponentDisplayLimit(int i, int i2) {
        getComponentItemDisplayLimiter().addComponentLimitSize(i, i2);
    }

    public void createDecorateComponent(@NotNull ListIterator<Node> listIterator, @NotNull Node node, @NotNull ComponentDecorateItem componentDecorateItem) {
        k21.i(listIterator, "componentIterator");
        k21.i(node, "componentNode");
        k21.i(componentDecorateItem, "componentDecorateItemNode");
        Node node2 = new Node();
        node2.setId(IdGenerator.getId());
        node2.setType(componentDecorateItem.getComponentType());
        node2.setLevel(2);
        node2.setParent(node.getParent());
        ArrayList arrayList = new ArrayList();
        Node node3 = new Node();
        node3.setId(IdGenerator.getId());
        node3.setType(componentDecorateItem.getItemType());
        node3.setLevel(3);
        node3.setData(componentDecorateItem.getData());
        node3.setParent(node2);
        ur2 ur2 = ur2.INSTANCE;
        arrayList.add(node3);
        node2.setChildren(arrayList);
        listIterator.add(node2);
    }

    public void handleComponentNode(@NotNull ListIterator<Node> listIterator, @NotNull Node node) {
        ComponentCreatorManager componentCreatorManager;
        ComponentCreatorManager componentCreatorManager2;
        k21.i(listIterator, "componentIterator");
        k21.i(node, "componentNode");
        if (isFilterComponent(node)) {
            listIterator.remove();
            return;
        }
        SparseArray<ComponentConfigBean.ComponentBean> sparseArray = this.componentConfigs;
        boolean z = true;
        boolean z2 = (sparseArray == null || sparseArray.get(node.getType()) == null) ? false : true;
        if (!z2 && (componentCreatorManager2 = ((IContainer) getHost()).getPageContext().getComponentCreatorManager()) != null) {
            z2 = componentCreatorManager2.isSupport(node.getType());
        }
        if (z2) {
            List<Node> children = node.getChildren();
            if (children != null) {
                ListIterator<Node> listIterator2 = children.listIterator();
                while (listIterator2.hasNext()) {
                    Node next = listIterator2.next();
                    if (next.getLevel() == 2) {
                        List<Node> children2 = next.getChildren();
                        if (children2 == null || children2.isEmpty()) {
                            listIterator2.remove();
                        } else {
                            SparseArray<ComponentConfigBean.ComponentBean> sparseArray2 = this.componentConfigs;
                            boolean z3 = (sparseArray2 == null || sparseArray2.get(next.getType()) == null) ? false : true;
                            if (!z3 && (componentCreatorManager = ((IContainer) getHost()).getPageContext().getComponentCreatorManager()) != null) {
                                z3 = componentCreatorManager.isSupport(next.getType());
                            }
                            if (!z3) {
                                listIterator2.remove();
                            }
                        }
                    }
                }
            }
            if (isFilterComponent(node)) {
                listIterator.remove();
                return;
            }
            Node parent = node.getParent();
            if (parent != null && parent.getLevel() != 2) {
                List<Node> children3 = node.getChildren();
                if (children3 != null && !children3.isEmpty()) {
                    z = false;
                }
                if (!z) {
                    tryCreateDecorateComponentNode(node, listIterator);
                    return;
                }
                return;
            }
            return;
        }
        listIterator.remove();
    }

    public void handleCreateFooterComponentNode(@NotNull ListIterator<Node> listIterator, @NotNull Node node) {
        k21.i(listIterator, "componentIterator");
        k21.i(node, "componentNode");
        Node node2 = new Node();
        node2.setId(IdGenerator.getId());
        node2.setLevel(2);
        node2.setType(handleCreateFooterComponentNodeType(node));
        node2.setParent(node.getParent());
        node2.setData(node.getData());
        node2.setRawJson(node.getRawJson());
        ArrayList arrayList = new ArrayList();
        Node node3 = new Node();
        node3.setId(IdGenerator.getId());
        node3.setLevel(3);
        node3.setType(handleCreateFooterItemNodeType(node));
        node3.setData(node.getData());
        node3.setRawJson(node.getRawJson());
        handleFooterItemProperty(node, node3);
        node3.setParent(node2);
        ur2 ur2 = ur2.INSTANCE;
        arrayList.add(node3);
        node2.setChildren(arrayList);
        listIterator.add(node2);
    }

    public int handleCreateFooterComponentNodeType(@NotNull Node node) {
        k21.i(node, "componentNode");
        return 9995;
    }

    public int handleCreateFooterItemNodeType(@NotNull Node node) {
        k21.i(node, "componentNode");
        return 9995;
    }

    public void handleCreateHeaderComponentNode(@NotNull ListIterator<Node> listIterator, @NotNull Node node) {
        k21.i(listIterator, "componentIterator");
        k21.i(node, "componentNode");
        Node node2 = new Node();
        node2.setId(IdGenerator.getId());
        node2.setType(handleCreateHeaderComponentNodeType(node));
        node2.setLevel(2);
        node2.setParent(node.getParent());
        node2.setData(node.getData());
        node2.setRawJson(node.getRawJson());
        node2.setStyle(node.getStyle());
        ArrayList arrayList = new ArrayList();
        Node node3 = new Node();
        node3.setId(IdGenerator.getId());
        node3.setLevel(3);
        node3.setType(handleCreateHeaderItemNodeType(node));
        node3.setData(node.getData());
        node3.setRawJson(node.getRawJson());
        node3.setStyle(node.getStyle());
        handleHeaderItemProperty(node, node3);
        node3.setParent(node2);
        ur2 ur2 = ur2.INSTANCE;
        arrayList.add(node3);
        node2.setChildren(arrayList);
        listIterator.add(node2);
    }

    public int handleCreateHeaderComponentNodeType(@NotNull Node node) {
        k21.i(node, "componentNode");
        return 9999;
    }

    public int handleCreateHeaderItemNodeType(@NotNull Node node) {
        k21.i(node, "componentNode");
        return 9999;
    }

    public void handleFooterItemProperty(@NotNull Node node, @NotNull Node node2) {
        k21.i(node, "componentNode");
        k21.i(node2, "itemNode");
    }

    public void handleHeaderItemProperty(@NotNull Node node, @NotNull Node node2) {
        k21.i(node, "componentNode");
        k21.i(node2, "itemNode");
    }

    public void handleItemNode(@NotNull ListIterator<Node> listIterator, @NotNull Node node) {
        ViewTypeConfig viewTypeConfig;
        HashMap<String, Object> params;
        Object obj;
        k21.i(listIterator, "itemIterator");
        k21.i(node, "itemNode");
        JSONObject data = node.getData();
        if (data == null || data.isEmpty()) {
            listIterator.remove();
            return;
        }
        if (node.getConfig() == null) {
            node.setConfig(new JSONObject());
        }
        ViewTypeSupport viewTypeSupport = ((IContainer) getHost()).getPageContext().getViewTypeSupport();
        if (viewTypeSupport != null && (viewTypeConfig = viewTypeSupport.getViewTypeConfig(node.getType())) != null && (params = viewTypeConfig.getParams()) != null && (obj = params.get("bean")) != null) {
            JSONObject config = node.getConfig();
            k21.f(config);
            config.put((Object) "bean", obj);
        }
    }

    @Override // com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.PageLoader, com.youku.arch.v3.loader.AbsLoader
    public void handleLoadSuccess(@NotNull IResponse iResponse, int i) {
        JSONObject jSONObject;
        k21.i(iResponse, "response");
        JSONObject jsonObject = iResponse.getJsonObject();
        if (jsonObject != null) {
            JSONObject jSONObject2 = null;
            if (findRootDataNode(jsonObject).containsKey("data")) {
                jSONObject2 = jsonObject.getJSONObject("data");
            }
            if (!(jSONObject2 == null || (jSONObject = jSONObject2.getJSONObject("data")) == null)) {
                handlePageBaseInfo(iResponse.getSource(), jSONObject.getJSONObject("top"), jSONObject.getJSONObject("bottom"));
                if (k21.d(iResponse.getSource(), "remote") || k21.d(iResponse.getSource(), Constants.ResponseSource.REMOTE_FILE)) {
                    handlePageUTParams(jSONObject.getString("pageName"), jSONObject.getString(UT_SPM_AB));
                }
            }
        }
        super.handleLoadSuccess(iResponse, i);
    }

    public void handleModuleNode(@NotNull ListIterator<Node> listIterator, @NotNull Node node) {
        k21.i(listIterator, "moduleIterator");
        k21.i(node, "moduleNode");
        List<Node> children = node.getChildren();
        boolean z = false;
        if (children == null || children.isEmpty()) {
            listIterator.remove();
            return;
        }
        List<Node> children2 = node.getChildren();
        if (children2 != null) {
            ListIterator<Node> listIterator2 = children2.listIterator();
            while (listIterator2.hasNext()) {
                if (isFilterComponent(listIterator2.next())) {
                    listIterator2.remove();
                }
            }
        }
        List<Node> children3 = node.getChildren();
        if (children3 == null || children3.isEmpty()) {
            z = true;
        }
        if (z) {
            listIterator.remove();
        }
    }

    public void handleNode(@NotNull Node node) {
        k21.i(node, "node");
        List<Node> children = node.getChildren();
        if (!(!(children == null || children.isEmpty()))) {
            children = null;
        }
        if (children != null) {
            ListIterator<Node> listIterator = children.listIterator();
            while (listIterator.hasNext()) {
                Node next = listIterator.next();
                int level = next.getLevel();
                if (level == 1) {
                    handleModuleNode(listIterator, next);
                } else if (level == 2) {
                    handleComponentNode(listIterator, next);
                } else if (level == 3) {
                    handleItemNode(listIterator, next);
                }
                handleNode(next);
            }
        }
    }

    public void handlePageBaseInfo(@Nullable String str, @Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        GenericFragment fragment = ((IContainer) getHost()).getPageContext().getFragment();
        PageInfoBean pageInfoBean = null;
        if (!(fragment instanceof BaseFragment)) {
            fragment = null;
        }
        BaseFragment baseFragment = (BaseFragment) fragment;
        if (baseFragment != null) {
            baseFragment.setTopBasePageInfo(jSONObject != null ? (PageInfoBean) jSONObject.toJavaObject(PageInfoBean.class) : null);
            if (jSONObject2 != null) {
                pageInfoBean = (PageInfoBean) jSONObject2.toJavaObject(PageInfoBean.class);
            }
            baseFragment.setBottomBasePageInfo(pageInfoBean);
        }
    }

    @Override // com.youku.arch.v3.loader.PageLoader
    @Nullable
    public Node parseNode(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "response");
        Node parseNode = super.parseNode(jSONObject);
        BaseFragment baseFragment = null;
        if (parseNode == null) {
            return null;
        }
        handleNode(parseNode);
        GenericFragment fragment = ((IContainer) getHost()).getPageContext().getFragment();
        if (fragment instanceof BaseFragment) {
            baseFragment = fragment;
        }
        BaseFragment baseFragment2 = baseFragment;
        if (baseFragment2 == null) {
            return parseNode;
        }
        baseFragment2.updateABBucket(parseNode);
        return parseNode;
    }

    public final void removeComponentDecorate(int i, @NotNull ComponentDecorateItem componentDecorateItem) {
        k21.i(componentDecorateItem, "decorate");
        getComponentDecorator().removeComponentDecorate(i, componentDecorateItem);
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.loader.PageLoader
    public void setLoadingViewState(@NotNull IResponse iResponse, boolean z) {
        PageStateManager pageStateManager;
        k21.i(iResponse, "response");
        super.setLoadingViewState(iResponse, z);
        GenericFragment fragment = ((IContainer) getHost()).getPageContext().getFragment();
        if (fragment != null && (pageStateManager = fragment.getPageStateManager()) != null && pageStateManager.isStateViewEnable()) {
            ((IContainer) getHost()).getPageContext().runOnUIThread(new GenericPagerLoader$setLoadingViewState$$inlined$apply$lambda$1(pageStateManager, this, iResponse));
        }
    }

    public void createDecorateComponent(@NotNull Node node, @NotNull ComponentDecorateItem componentDecorateItem) {
        k21.i(node, "moduleNode");
        k21.i(componentDecorateItem, "componentDecorateItemNode");
        List<Node> children = node.getChildren();
        if (children != null) {
            Node node2 = new Node();
            node2.setId(IdGenerator.getId());
            node2.setType(componentDecorateItem.getComponentType());
            node2.setLevel(2);
            node2.setParent(node);
            ArrayList arrayList = new ArrayList();
            Node node3 = new Node();
            node3.setId(IdGenerator.getId());
            node3.setType(componentDecorateItem.getItemType());
            node3.setLevel(3);
            node3.setData(componentDecorateItem.getData());
            node3.setParent(node2);
            ur2 ur2 = ur2.INSTANCE;
            arrayList.add(node3);
            node2.setChildren(arrayList);
            children.add(node2);
        }
    }
}
