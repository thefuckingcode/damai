package com.youku.arch.v3.loader;

import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.core.ActivityValue;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.style.Style;
import com.youku.arch.v3.style.StyleManager;
import com.youku.arch.v3.util.ArchMontior;
import com.youku.arch.v3.util.ArchMontiorManager;
import com.youku.kubus.Event;
import com.youku.kubus.EventBus;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"Lcom/alibaba/fastjson/JSONObject;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class PageLoader$handleLoadSuccess$1 extends Lambda implements Function0<JSONObject> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ int $index;
    final /* synthetic */ IResponse $response;
    final /* synthetic */ PageLoader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PageLoader$handleLoadSuccess$1(IResponse iResponse, PageLoader pageLoader, int i) {
        super(0);
        this.$response = iResponse;
        this.this$0 = pageLoader;
        this.$index = i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v3, resolved type: com.youku.arch.v3.core.Node */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final JSONObject invoke() {
        String pageName;
        ArchMontior archMontior;
        String pageName2;
        ArchMontior archMontior2;
        EventBus eventBus;
        StyleManager styleManager;
        String pageName3;
        ArchMontior archMontior3;
        String pageName4;
        ArchMontior archMontior4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-258596588")) {
            return (JSONObject) ipChange.ipc$dispatch("-258596588", new Object[]{this});
        }
        JSONObject jsonObject = this.$response.getJsonObject();
        ActivityValue activityValue = null;
        if (jsonObject == null) {
            return null;
        }
        IResponse iResponse = this.$response;
        PageLoader pageLoader = this.this$0;
        int i = this.$index;
        if (!(!k21.d(iResponse.getSource(), "remote") || (pageName4 = ((IContainer) pageLoader.getHost()).getPageContext().getPageName()) == null || (archMontior4 = ArchMontiorManager.Companion.get(pageName4)) == null)) {
            archMontior4.setNodeTime(System.currentTimeMillis());
        }
        Node parseNode = pageLoader.parseNode(pageLoader.findRootDataNode(jsonObject));
        if (!(!k21.d(iResponse.getSource(), "remote") || (pageName3 = ((IContainer) pageLoader.getHost()).getPageContext().getPageName()) == null || (archMontior3 = ArchMontiorManager.Companion.get(pageName3)) == null)) {
            archMontior3.setNodeTime(System.currentTimeMillis() - archMontior3.getNodeTime());
        }
        if (parseNode != null) {
            IContext pageContext = ((IContainer) pageLoader.getHost()).getPageContext();
            ActivityValue parseActivityValue = pageLoader.parseActivityValue(parseNode.getData());
            if (parseActivityValue != null) {
                Style style = parseActivityValue.getStyle();
                if (!(style == null || (styleManager = ((IContainer) pageLoader.getHost()).getPageContext().getStyleManager()) == null)) {
                    styleManager.updateStyle(style);
                }
                ur2 ur2 = ur2.INSTANCE;
                activityValue = parseActivityValue;
            }
            pageContext.setActivityValue(activityValue);
            pageLoader.checkDuplicateModule(parseNode, i);
            if (i == 1 && (eventBus = ((IContainer) pageLoader.getHost()).getPageContext().getEventBus()) != null) {
                eventBus.post(new Event("CHANNEL_FIRST_PAGE_LOADED"));
            }
            if (!(!k21.d(iResponse.getSource(), "remote") || (pageName2 = ((IContainer) pageLoader.getHost()).getPageContext().getPageName()) == null || (archMontior2 = ArchMontiorManager.Companion.get(pageName2)) == null)) {
                archMontior2.setParseTime(System.currentTimeMillis());
            }
            pageLoader.tryCreateModules(parseNode, i);
            if (!(!k21.d(iResponse.getSource(), "remote") || (pageName = ((IContainer) pageLoader.getHost()).getPageContext().getPageName()) == null || (archMontior = ArchMontiorManager.Companion.get(pageName)) == null)) {
                archMontior.setParseTime(System.currentTimeMillis() - archMontior.getParseTime());
                archMontior.getUploadPageMonitor().invoke();
            }
            pageLoader.setLoadingState(0);
            pageLoader.handleLoadFinish(iResponse, true, i);
            activityValue = parseNode;
        }
        if (activityValue != null) {
            return jsonObject;
        }
        pageLoader.handleLoadFinish(iResponse, false, i);
        return jsonObject;
    }
}
