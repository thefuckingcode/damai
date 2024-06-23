package com.youku.arch.v3.loader;

import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.util.ArchMontior;
import com.youku.arch.v3.util.ArchMontiorManager;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.k;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0010\u0000\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class ComponentLoader$handleLoadSuccess$1 extends Lambda implements Function0<Object> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ int $index;
    final /* synthetic */ IResponse $response;
    final /* synthetic */ ComponentLoader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ComponentLoader$handleLoadSuccess$1(IResponse iResponse, ComponentLoader componentLoader, int i) {
        super(0);
        this.$response = iResponse;
        this.this$0 = componentLoader;
        this.$index = i;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:11:0x0025 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00d5, code lost:
        if (r7.getLevel() == 2) goto L_0x00d7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008e A[Catch:{ Exception -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008f A[Catch:{ Exception -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0094 A[Catch:{ Exception -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a3 A[Catch:{ Exception -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00af A[Catch:{ Exception -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00b0 A[Catch:{ Exception -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b3 A[Catch:{ Exception -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b5 A[Catch:{ Exception -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x016e A[Catch:{ Exception -> 0x018e }] */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Object invoke() {
        List<Node> list;
        boolean z;
        List<Node> list2;
        boolean z2;
        ArchMontior archMontior;
        IpChange ipChange = $ipChange;
        boolean z3 = true;
        if (AndroidInstantRuntime.support(ipChange, "-245004810")) {
            return ipChange.ipc$dispatch("-245004810", new Object[]{this});
        }
        JSONObject jsonObject = this.$response.getJsonObject();
        Node node = 0;
        if (!(jsonObject != null)) {
            jsonObject = null;
        }
        if (jsonObject != null) {
            ComponentLoader componentLoader = this.this$0;
            int i = this.$index;
            String pageName = ((IComponent) componentLoader.getHost()).getPageContext().getPageName();
            if (!(pageName == null || (archMontior = ArchMontiorManager.Companion.get(pageName)) == null)) {
                archMontior.setNodeTime(System.currentTimeMillis());
            }
            try {
                Node parseNode = componentLoader.parseNode(jsonObject);
                String pageName2 = ((IComponent) componentLoader.getHost()).getPageContext().getPageName();
                if (pageName2 != null) {
                    ArchMontior archMontior2 = ArchMontiorManager.Companion.get(pageName2);
                    if (archMontior2 != null) {
                        archMontior2.setNodeTime(System.currentTimeMillis() - archMontior2.getNodeTime());
                    }
                }
                if (parseNode == null) {
                    list = null;
                } else {
                    list = parseNode.getChildren();
                }
                if (list != null) {
                    if (!list.isEmpty()) {
                        z = false;
                        if (!z) {
                            list = null;
                        }
                        if (list != null) {
                            Node node2 = (Node) k.P(list);
                            if (node2 != null) {
                                list2 = node2.getChildren();
                                if (list2 != null) {
                                    if (!list2.isEmpty()) {
                                        z2 = false;
                                        if (!z2) {
                                            list2 = null;
                                        }
                                        if (list2 == null) {
                                            Node node3 = (Node) k.P(list2);
                                            if (node3 != null) {
                                                List<Node> children = node3.getChildren();
                                                if (children != null) {
                                                    Node node4 = (Node) k.P(children);
                                                    if (node4 == null) {
                                                    }
                                                }
                                                z3 = false;
                                                if (z3) {
                                                    List<Node> children2 = node3.getChildren();
                                                    if (children2 != null) {
                                                        node = (Node) k.P(children2);
                                                    }
                                                } else {
                                                    node = node3;
                                                }
                                                if (node == null || node.getType() != ((IComponent) componentLoader.getHost()).getType()) {
                                                    ((IComponent) componentLoader.getHost()).getProperty().setMore(false);
                                                    ((IComponent) componentLoader.getHost()).getPageContext().runOnUIThread(new ComponentLoader$handleLoadSuccess$1$2$5$3(componentLoader));
                                                } else {
                                                    String pageName3 = ((IComponent) componentLoader.getHost()).getPageContext().getPageName();
                                                    if (pageName3 != null) {
                                                        ArchMontior archMontior3 = ArchMontiorManager.Companion.get(pageName3);
                                                        if (archMontior3 != null) {
                                                            archMontior3.setParseTime(System.currentTimeMillis());
                                                        }
                                                    }
                                                    componentLoader.createItems(node, i);
                                                    String pageName4 = ((IComponent) componentLoader.getHost()).getPageContext().getPageName();
                                                    if (pageName4 != null) {
                                                        ArchMontior archMontior4 = ArchMontiorManager.Companion.get(pageName4);
                                                        if (archMontior4 != null) {
                                                            archMontior4.setParseTime(System.currentTimeMillis() - archMontior4.getParseTime());
                                                            archMontior4.getUploadPageMonitor().invoke();
                                                        }
                                                    }
                                                }
                                                node = node3;
                                            }
                                        }
                                        if (node == null) {
                                            ((IComponent) componentLoader.getHost()).getProperty().setMore(false);
                                            ((IComponent) componentLoader.getHost()).getPageContext().runOnUIThread(new ComponentLoader$handleLoadSuccess$1$2$6$1(componentLoader));
                                        }
                                        node = jsonObject;
                                    }
                                }
                                z2 = true;
                                if (!z2) {
                                }
                                if (list2 == null) {
                                }
                                if (node == null) {
                                }
                                node = jsonObject;
                            }
                        }
                        list2 = null;
                        if (list2 != null) {
                        }
                        z2 = true;
                        if (!z2) {
                        }
                        if (list2 == null) {
                        }
                        if (node == null) {
                        }
                        node = jsonObject;
                    }
                }
                z = true;
                if (!z) {
                }
                if (list != null) {
                }
                list2 = null;
                if (list2 != null) {
                }
                z2 = true;
                if (!z2) {
                }
                if (list2 == null) {
                }
                if (node == null) {
                }
            } catch (Exception e) {
                ((IComponent) componentLoader.getHost()).getPageContext().runOnUIThread(new ComponentLoader$handleLoadSuccess$1$2$7(componentLoader));
                if (AppInfoProviderProxy.isDebuggable()) {
                    throw new RuntimeException(e);
                }
            }
            node = jsonObject;
        }
        if (node != 0) {
            return node;
        }
        ComponentLoader componentLoader2 = this.this$0;
        ((IComponent) componentLoader2.getHost()).getPageContext().runOnUIThread(new ComponentLoader$handleLoadSuccess$1$3$1(componentLoader2));
        return ur2.INSTANCE;
    }
}
