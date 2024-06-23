package cn.damai.onearch.component.scripttag;

import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.io.IResponse;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.List;
import kotlin.collections.k;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ScriptTagPresent$handleLoadSuccess$1 extends Lambda implements Function0<JSONObject> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ IResponse $response;
    final /* synthetic */ ScriptTagPresent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScriptTagPresent$handleLoadSuccess$1(IResponse iResponse, ScriptTagPresent scriptTagPresent) {
        super(0);
        this.$response = iResponse;
        this.this$0 = scriptTagPresent;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final JSONObject invoke() {
        Node node;
        List<Node> children;
        Node node2;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "102865743")) {
            return (JSONObject) ipChange.ipc$dispatch("102865743", new Object[]{this});
        }
        JSONObject jsonObject = this.$response.getJsonObject();
        List<Node> list = null;
        if (!(jsonObject != null)) {
            jsonObject = null;
        }
        if (jsonObject == null) {
            return null;
        }
        ScriptTagPresent scriptTagPresent = this.this$0;
        try {
            Node access$parseNode = ScriptTagPresent.access$parseNode(scriptTagPresent, jsonObject);
            if (access$parseNode != null) {
                List<Node> children2 = access$parseNode.getChildren();
                if (children2 == null || children2.isEmpty()) {
                    z = true;
                }
                if (z) {
                    children2 = null;
                }
                if (!(children2 == null || (node = (Node) k.b0(children2)) == null || (children = node.getChildren()) == null)) {
                    if (!children.isEmpty()) {
                        list = children;
                    }
                    if (!(list == null || (node2 = (Node) k.b0(list)) == null)) {
                        ScriptTagPresent.access$createItems(scriptTagPresent, node2);
                    }
                }
            }
        } catch (Exception e) {
            if (AppInfoProviderProxy.isDebuggable()) {
                throw e;
            }
        }
        return jsonObject;
    }
}
