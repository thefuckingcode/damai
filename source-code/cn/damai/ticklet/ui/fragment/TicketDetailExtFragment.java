package cn.damai.ticklet.ui.fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$raw;
import cn.damai.ticklet.bean.TicketDeatilResult;
import cn.damai.ticklet.ui.activity.TicketDeatilActivity;
import cn.damai.ticklet.ui.detailholder.TicketDetailPerformViewHolder;
import cn.damai.uikit.refresh.footer.SimpleHeader;
import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.BaseFragment;
import com.alient.onearch.adapter.GenericPageContainer;
import com.alient.onearch.adapter.loader.v2.GenericPagerLoader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.PageContainer;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.data.Request;
import com.youku.arch.v3.event.RefreshEvent;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.kubus.Event;
import com.youku.kubus.IdGenerator;
import com.youku.kubus.Subscribe;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.collections.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.gl2;
import tb.k21;
import tb.m40;
import tb.v00;

/* compiled from: Taobao */
public final class TicketDetailExtFragment extends BaseFragment {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final String API_NAME = "mtop.damai.wireless.ticklet2.extension.list2";
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String LOAD_TICKET_EXT = "loadTicketExt";
    public static final boolean NEED_ENCODE = false;
    public static final boolean NEED_SESSION = false;
    @NotNull
    public static final String ORDER_ID = "orderId";
    @NotNull
    public static final String PERFORM_ID = "performId";
    @NotNull
    public static final String PRODUCT_SYSTEM_ID = "productSystemId";
    @NotNull
    public static final String PROJECT_ID = "projectId";
    @NotNull
    public static final String VERSION = "1.0";
    @NotNull
    private final String configPath = "://member/raw/ticket_detail_ext_component_config";
    @Nullable
    private String orderId;
    @NotNull
    private final String pageName = "TicketDetailExt";
    @Nullable
    private String performId;
    @Nullable
    private String productSystemId;
    @Nullable
    private String projectId;
    @Nullable
    private TicketDeatilResult ticketDetailResult;

    /* compiled from: Taobao */
    public final class TicketDetailExtLoader extends GenericPagerLoader {
        private static transient /* synthetic */ IpChange $ipChange;
        @Nullable
        private Node performModuleNode;
        @Nullable
        private String source = Constants.ResponseSource.LOCAL_FILE;
        final /* synthetic */ TicketDetailExtFragment this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TicketDetailExtLoader(@NotNull TicketDetailExtFragment ticketDetailExtFragment, PageContainer<ModelValue> pageContainer) {
            super(pageContainer);
            k21.i(pageContainer, "pageContainer");
            this.this$0 = ticketDetailExtFragment;
        }

        private final void appendBottomShadowNode(Node node) {
            IpChange ipChange = $ipChange;
            boolean z = false;
            if (AndroidInstantRuntime.support(ipChange, "2145400983")) {
                ipChange.ipc$dispatch("2145400983", new Object[]{this, node});
                return;
            }
            List<Node> children = node.getChildren();
            if (children == null || children.isEmpty()) {
                z = true;
            }
            if (!(!z)) {
                children = null;
            }
            if (children != null) {
                children.add(createBottomShadowModuleNode(node));
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(createBottomShadowModuleNode(node));
            node.setChildren(arrayList);
        }

        private final Node createBottomShadowModuleNode(Node node) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1813198831")) {
                return (Node) ipChange.ipc$dispatch("-1813198831", new Object[]{this, node});
            }
            Node node2 = new Node();
            node2.setId(IdGenerator.getId());
            node2.setLevel(1);
            node2.setParent(node);
            node2.setData(new JSONObject());
            ArrayList arrayList = new ArrayList();
            Node node3 = new Node();
            node3.setId(IdGenerator.getId());
            node3.setType(7539);
            node3.setLevel(2);
            node3.setParent(node2);
            node3.setData(new JSONObject());
            ArrayList arrayList2 = new ArrayList();
            Node node4 = new Node();
            node4.setId(IdGenerator.getId());
            node4.setLevel(3);
            node4.setType(7528);
            node4.setData(new JSONObject());
            node4.setParent(node3);
            arrayList2.add(node4);
            node3.setChildren(arrayList2);
            arrayList.add(node3);
            node2.setChildren(arrayList);
            return node2;
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader
        public void handleComponentNode(@NotNull ListIterator<Node> listIterator, @NotNull Node node) {
            Node parent;
            Node node2;
            List<Node> children;
            Node node3;
            List<Node> children2;
            Node node4;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1931835570")) {
                ipChange.ipc$dispatch("1931835570", new Object[]{this, listIterator, node});
                return;
            }
            k21.i(listIterator, "componentIterator");
            k21.i(node, "componentNode");
            if (node.getType() == 7538) {
                this.performModuleNode = node.getParent();
            }
            super.handleComponentNode(listIterator, node);
            Bundle bundle = this.this$0.getPageContext().getBundle();
            Node node5 = null;
            Serializable serializable = bundle != null ? bundle.getSerializable(TicketDetailPerformViewHolder.PERFORM_TICKET_DATA) : null;
            TicketDeatilResult ticketDeatilResult = serializable instanceof TicketDeatilResult ? (TicketDeatilResult) serializable : null;
            if (ticketDeatilResult != null && ticketDeatilResult.isNftPerform() && (parent = node.getParent()) != null && -10000 != parent.getType()) {
                List<Node> children3 = parent.getChildren();
                Integer valueOf = (children3 == null || (node3 = (Node) k.P(children3)) == null || (children2 = node3.getChildren()) == null || (node4 = (Node) k.P(children2)) == null) ? null : Integer.valueOf(node4.getType());
                if (valueOf != null && 7526 == valueOf.intValue()) {
                    List<Node> children4 = parent.getChildren();
                    if (!(children4 == null || (node2 = (Node) k.P(children4)) == null || (children = node2.getChildren()) == null)) {
                        node5 = (Node) k.P(children);
                    }
                    if (node5 != null) {
                        node5.setType(7529);
                    }
                }
            }
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader
        public void handleCreateHeaderComponentNode(@NotNull ListIterator<Node> listIterator, @NotNull Node node) {
            Node node2;
            IpChange ipChange = $ipChange;
            boolean z = false;
            if (AndroidInstantRuntime.support(ipChange, "-1519464183")) {
                ipChange.ipc$dispatch("-1519464183", new Object[]{this, listIterator, node});
                return;
            }
            k21.i(listIterator, "componentIterator");
            k21.i(node, "componentNode");
            List<Node> children = node.getChildren();
            JSONObject jSONObject = null;
            JSONObject data = (children == null || (node2 = (Node) k.P(children)) == null) ? null : node2.getData();
            if (data == null || data.isEmpty()) {
                z = true;
            }
            if (!z) {
                jSONObject = data;
            }
            if (jSONObject != null) {
                Node node3 = new Node();
                node3.setId(IdGenerator.getId());
                node3.setType(7537);
                node3.setLevel(2);
                node3.setParent(node.getParent());
                node3.setData(node.getData());
                node3.setRawJson(node.getRawJson());
                node3.setStyle(node.getStyle());
                ArrayList arrayList = new ArrayList();
                Node node4 = new Node();
                node4.setId(IdGenerator.getId());
                node4.setLevel(3);
                node4.setType(7526);
                node4.setData(node.getData());
                node4.setRawJson(node.getRawJson());
                node4.setStyle(node.getStyle());
                handleHeaderItemProperty(node, node4);
                node4.setParent(node3);
                arrayList.add(node4);
                node3.setChildren(arrayList);
                listIterator.add(node3);
            }
        }

        @Override // com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.PageLoader, com.youku.arch.v3.loader.AbsLoader
        public void handleLoadFailure(@NotNull IResponse iResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "330175299")) {
                ipChange.ipc$dispatch("330175299", new Object[]{this, iResponse});
                return;
            }
            k21.i(iResponse, "response");
            super.handleLoadFailure(iResponse);
            this.this$0.getPageContext().runOnUIThread(new TicketDetailExtFragment$TicketDetailExtLoader$handleLoadFailure$1(this.this$0));
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader, com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.PageLoader, com.youku.arch.v3.loader.AbsLoader
        public void handleLoadSuccess(@NotNull IResponse iResponse, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "586272281")) {
                ipChange.ipc$dispatch("586272281", new Object[]{this, iResponse, Integer.valueOf(i)});
                return;
            }
            k21.i(iResponse, "response");
            this.this$0.getPageContext().runOnUIThread(new TicketDetailExtFragment$TicketDetailExtLoader$handleLoadSuccess$1(this.this$0));
            this.source = iResponse.getSource();
            super.handleLoadSuccess(iResponse, i);
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader, com.youku.arch.v3.loader.PageLoader
        @Nullable
        public Node parseNode(@NotNull JSONObject jSONObject) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "-1741810989")) {
                return (Node) ipChange.ipc$dispatch("-1741810989", new Object[]{this, jSONObject});
            }
            k21.i(jSONObject, "response");
            Node parseNode = super.parseNode(jSONObject);
            if (parseNode != null && k21.d(this.source, "remote")) {
                List<Node> children = parseNode.getChildren();
                if (children == null) {
                    z = false;
                }
                if (!z) {
                    children = null;
                }
                if (children != null) {
                    Node node = this.performModuleNode;
                    if (node != null) {
                        children.add(0, node);
                    }
                } else {
                    Node node2 = this.performModuleNode;
                    if (node2 != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(node2);
                        parseNode.setChildren(arrayList);
                    }
                }
                appendBottomShadowNode(parseNode);
            }
            return parseNode;
        }
    }

    /* compiled from: Taobao */
    public final class TicketDetailExtRequestBuilder implements RequestBuilder {
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public TicketDetailExtRequestBuilder() {
        }

        @Override // com.youku.arch.v3.io.RequestBuilder
        @NotNull
        public IRequest build(@NotNull Map<String, ? extends Object> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1778910941")) {
                return (IRequest) ipChange.ipc$dispatch("1778910941", new Object[]{this, map});
            }
            k21.i(map, com.youku.arch.v3.core.Constants.CONFIG);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            long j = Constants.RequestStrategy.LOCAL_FILE;
            linkedHashMap.put("patternName", "ticket2_extension");
            linkedHashMap.put("patternVersion", "1.0");
            StringBuilder sb = new StringBuilder();
            sb.append("android.resource://");
            Context context = TicketDetailExtFragment.this.getContext();
            sb.append(context != null ? context.getPackageName() : null);
            sb.append(v00.DIR);
            sb.append(R$raw.ticket_wallet_ext_perform_data);
            Uri parse = Uri.parse(sb.toString());
            k21.h(parse, "parse(\n                \"…erform_data\n            )");
            Bundle bundle = new Bundle();
            bundle.putParcelable("uri", parse);
            long j2 = 2;
            if (map.get(TicketDetailExtFragment.LOAD_TICKET_EXT) != null) {
                j = 2;
            }
            if (map.get("reload") == null) {
                j2 = j;
            }
            linkedHashMap.put("subChannelId", "damai@damaiapp_h5");
            linkedHashMap.put("comboChannel", "1");
            linkedHashMap.put("funcVersion", "1.0");
            String str = TicketDetailExtFragment.this.productSystemId;
            if (str != null) {
                linkedHashMap.put(TicketDetailExtFragment.PRODUCT_SYSTEM_ID, str);
            }
            String str2 = TicketDetailExtFragment.this.orderId;
            if (str2 != null) {
                linkedHashMap.put("orderId", str2);
            }
            String str3 = TicketDetailExtFragment.this.performId;
            if (str3 != null) {
                linkedHashMap.put(TicketDetailExtFragment.PERFORM_ID, str3);
            }
            Request build = new Request.Builder().setApiName(TicketDetailExtFragment.API_NAME).setVersion("1.0").setNeedECode(false).setNeedSession(false).setTimeout(10000).setStrategy(j2).setRequestId(com.youku.arch.v3.util.IdGenerator.getId()).setDataParams(new HashMap(linkedHashMap)).build();
            build.setBundle(bundle);
            return build;
        }
    }

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    private final void refreshBackColor(Integer num, Integer num2) {
        SimpleHeader simpleHeader;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "483729752")) {
            ipChange.ipc$dispatch("483729752", new Object[]{this, num, num2});
            return;
        }
        View realView = getRealView();
        if (!(realView == null || (simpleHeader = (SimpleHeader) realView.findViewById(R$id.one_arch_header)) == null)) {
            if (num == null || num.intValue() == 0) {
                simpleHeader.setBackgroundColor(Color.parseColor("#965BBD"));
            } else {
                simpleHeader.setBackgroundColor(num.intValue());
            }
        }
        if (num2 == null || num2.intValue() == 0) {
            RecyclerView recyclerView = getRecyclerView();
            if (recyclerView != null) {
                recyclerView.setBackgroundColor(Color.parseColor(gl2.DETAIL_PAGE_DEFAULT_COLOR));
                return;
            }
            return;
        }
        RecyclerView recyclerView2 = getRecyclerView();
        if (recyclerView2 != null) {
            recyclerView2.setBackgroundColor(num2.intValue());
        }
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    @NotNull
    public GenericPagerLoader createPageLoader(@NotNull GenericPageContainer genericPageContainer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "805195672")) {
            return (GenericPagerLoader) ipChange.ipc$dispatch("805195672", new Object[]{this, genericPageContainer});
        }
        k21.i(genericPageContainer, "container");
        return new TicketDetailExtLoader(this, genericPageContainer);
    }

    /* access modifiers changed from: protected */
    @Override // com.alient.onearch.adapter.BaseFragment
    @Nullable
    public RequestBuilder createRequestBuilder(@Nullable Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "739398749")) {
            return new TicketDetailExtRequestBuilder();
        }
        return (RequestBuilder) ipChange.ipc$dispatch("739398749", new Object[]{this, map});
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment
    @NotNull
    public String getConfigPath() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-819205172")) {
            return this.configPath;
        }
        return (String) ipChange.ipc$dispatch("-819205172", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment, com.alient.onearch.adapter.BaseFragment
    public int getLayoutResId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2038673905")) {
            return R$layout.fragment_ticket_detail_ext;
        }
        return ((Integer) ipChange.ipc$dispatch("2038673905", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment
    @NotNull
    public String getPageName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1012739585")) {
            return this.pageName;
        }
        return (String) ipChange.ipc$dispatch("-1012739585", new Object[]{this});
    }

    @Override // com.youku.arch.v3.page.GenericFragment, com.alient.onearch.adapter.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "928994102")) {
            ipChange.ipc$dispatch("928994102", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        String str = null;
        Serializable serializable = arguments != null ? arguments.getSerializable(TicketDetailPerformViewHolder.PERFORM_TICKET_DATA) : null;
        TicketDeatilResult ticketDeatilResult = serializable instanceof TicketDeatilResult ? (TicketDeatilResult) serializable : null;
        if (ticketDeatilResult != null) {
            this.ticketDetailResult = ticketDeatilResult;
            ticketDeatilResult.isLocalData = Boolean.TRUE;
            Bundle bundle2 = getPageContext().getBundle();
            if (bundle2 != null) {
                bundle2.putSerializable(TicketDetailPerformViewHolder.PERFORM_TICKET_DATA, this.ticketDetailResult);
            }
        }
        Bundle arguments2 = getArguments();
        this.productSystemId = arguments2 != null ? arguments2.getString(PRODUCT_SYSTEM_ID) : null;
        Bundle arguments3 = getArguments();
        this.orderId = arguments3 != null ? arguments3.getString("orderId") : null;
        Bundle arguments4 = getArguments();
        this.performId = arguments4 != null ? arguments4.getString(PERFORM_ID) : null;
        Bundle arguments5 = getArguments();
        if (arguments5 != null) {
            str = arguments5.getString("projectId");
        }
        this.projectId = str;
    }

    @Subscribe(eventType = {"EventBus://business/notification/LoadTicketExt"})
    public final void onLoadTicketExt(@NotNull Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-184042829")) {
            ipChange.ipc$dispatch("-184042829", new Object[]{this, event});
            return;
        }
        k21.i(event, "event");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(LOAD_TICKET_EXT, Boolean.TRUE);
        load(linkedHashMap);
    }

    @Override // com.youku.arch.v3.page.GenericFragment
    @Subscribe(eventType = {RefreshEvent.ON_REFRESH})
    public void onRefresh(@NotNull Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1918080287")) {
            ipChange.ipc$dispatch("1918080287", new Object[]{this, event});
            return;
        }
        k21.i(event, "event");
        super.onRefresh(event);
        FragmentActivity activity = getActivity();
        TicketDeatilActivity ticketDeatilActivity = activity instanceof TicketDeatilActivity ? (TicketDeatilActivity) activity : null;
        if (ticketDeatilActivity != null) {
            ticketDeatilActivity.onRefresh();
        }
    }

    @Override // com.youku.arch.v3.page.GenericFragment, com.alient.onearch.adapter.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-384631729")) {
            ipChange.ipc$dispatch("-384631729", new Object[]{this, view, bundle});
            return;
        }
        k21.i(view, "view");
        super.onViewCreated(view, bundle);
        TicketDeatilResult ticketDeatilResult = this.ticketDetailResult;
        if (ticketDeatilResult != null) {
            refreshBackColor(Integer.valueOf(ticketDeatilResult.getColor()), Integer.valueOf(ticketDeatilResult.getPageBgColor()));
        }
        RefreshLayout refreshLayout = getRefreshLayout();
        if (refreshLayout != null) {
            refreshLayout.setEnableLoadMore(false);
        }
        RefreshLayout refreshLayout2 = getRefreshLayout();
        if (refreshLayout2 != null) {
            refreshLayout2.setEnableRefresh(true);
        }
        load(new LinkedHashMap());
    }

    public final void updateTicketDetailResult(@NotNull TicketDeatilResult ticketDeatilResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1502388882")) {
            ipChange.ipc$dispatch("1502388882", new Object[]{this, ticketDeatilResult});
            return;
        }
        k21.i(ticketDeatilResult, "detailResult");
        Bundle bundle = getPageContext().getBundle();
        if (bundle != null) {
            bundle.putSerializable(TicketDetailPerformViewHolder.PERFORM_TICKET_DATA, ticketDeatilResult);
        }
        refreshBackColor(Integer.valueOf(ticketDeatilResult.getColor()), Integer.valueOf(ticketDeatilResult.getPageBgColor()));
        fireComponentEvent("EventBus://business/notification/RefreshPerform", new LinkedHashMap());
    }
}
