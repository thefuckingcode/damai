package com.taobao.weex.devtools.inspector.protocol.module;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import com.taobao.uikit.feature.features.FeatureFactory;
import com.taobao.weex.devtools.common.Accumulator;
import com.taobao.weex.devtools.common.ArrayListAccumulator;
import com.taobao.weex.devtools.common.LogUtil;
import com.taobao.weex.devtools.common.UncheckedCallable;
import com.taobao.weex.devtools.common.Util;
import com.taobao.weex.devtools.inspector.elements.Document;
import com.taobao.weex.devtools.inspector.elements.DocumentView;
import com.taobao.weex.devtools.inspector.elements.ElementInfo;
import com.taobao.weex.devtools.inspector.elements.NodeDescriptor;
import com.taobao.weex.devtools.inspector.elements.NodeType;
import com.taobao.weex.devtools.inspector.elements.StyleAccumulator;
import com.taobao.weex.devtools.inspector.helper.ChromePeerManager;
import com.taobao.weex.devtools.inspector.helper.PeersRegisteredListener;
import com.taobao.weex.devtools.inspector.jsonrpc.JsonRpcException;
import com.taobao.weex.devtools.inspector.jsonrpc.JsonRpcPeer;
import com.taobao.weex.devtools.inspector.jsonrpc.JsonRpcResult;
import com.taobao.weex.devtools.inspector.jsonrpc.protocol.JsonRpcError;
import com.taobao.weex.devtools.inspector.protocol.ChromeDevtoolsDomain;
import com.taobao.weex.devtools.inspector.protocol.ChromeDevtoolsMethod;
import com.taobao.weex.devtools.inspector.protocol.module.Runtime;
import com.taobao.weex.devtools.inspector.screencast.ScreencastDispatcher;
import com.taobao.weex.devtools.json.ObjectMapper;
import com.taobao.weex.devtools.json.annotation.JsonProperty;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.utils.WXViewUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import org.json.JSONObject;

/* compiled from: Taobao */
public class DOM implements ChromeDevtoolsDomain {
    private static boolean sNativeMode = true;
    private ChildNodeInsertedEvent mCachedChildNodeInsertedEvent;
    private ChildNodeRemovedEvent mCachedChildNodeRemovedEvent;
    private final Document mDocument;
    private final DocumentUpdateListener mListener;
    private final ObjectMapper mObjectMapper = new ObjectMapper();
    private final ChromePeerManager mPeerManager;
    private final AtomicInteger mResultCounter;
    private final Map<String, List<Integer>> mSearchResults;

    /* compiled from: Taobao */
    private static class AttributeModifiedEvent {
        @JsonProperty(required = true)
        public String name;
        @JsonProperty(required = true)
        public int nodeId;
        @JsonProperty(required = true)
        public String value;

        private AttributeModifiedEvent() {
        }
    }

    /* compiled from: Taobao */
    private static class AttributeRemovedEvent {
        @JsonProperty(required = true)
        public String name;
        @JsonProperty(required = true)
        public int nodeId;

        private AttributeRemovedEvent() {
        }
    }

    /* compiled from: Taobao */
    private static class BoxModel {
        @JsonProperty(required = true)
        public List<Double> border;
        @JsonProperty(required = true)
        public List<Double> content;
        @JsonProperty(required = true)
        public Integer height;
        @JsonProperty(required = true)
        public List<Double> margin;
        @JsonProperty(required = true)
        public List<Double> padding;
        @JsonProperty(required = true)
        public Integer width;

        private BoxModel() {
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class ChildNodeInsertedEvent {
        @JsonProperty(required = true)
        public Node node;
        @JsonProperty(required = true)
        public int parentNodeId;
        @JsonProperty(required = true)
        public int previousNodeId;

        private ChildNodeInsertedEvent() {
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class ChildNodeRemovedEvent {
        @JsonProperty(required = true)
        public int nodeId;
        @JsonProperty(required = true)
        public int parentNodeId;

        private ChildNodeRemovedEvent() {
        }
    }

    /* compiled from: Taobao */
    private static class DiscardSearchResultsRequest {
        @JsonProperty(required = true)
        public String searchId;

        private DiscardSearchResultsRequest() {
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class DocumentUpdateListener implements Document.UpdateListener {
        private DocumentUpdateListener() {
        }

        @Override // com.taobao.weex.devtools.inspector.elements.Document.UpdateListener
        public void onAttributeModified(Object obj, String str, String str2) {
            AttributeModifiedEvent attributeModifiedEvent = new AttributeModifiedEvent();
            attributeModifiedEvent.nodeId = DOM.this.mDocument.getNodeIdForElement(obj).intValue();
            attributeModifiedEvent.name = str;
            attributeModifiedEvent.value = str2;
            DOM.this.mPeerManager.sendNotificationToPeers("DOM.onAttributeModified", attributeModifiedEvent);
        }

        @Override // com.taobao.weex.devtools.inspector.elements.Document.UpdateListener
        public void onAttributeRemoved(Object obj, String str) {
            AttributeRemovedEvent attributeRemovedEvent = new AttributeRemovedEvent();
            attributeRemovedEvent.nodeId = DOM.this.mDocument.getNodeIdForElement(obj).intValue();
            attributeRemovedEvent.name = str;
            DOM.this.mPeerManager.sendNotificationToPeers("DOM.attributeRemoved", attributeRemovedEvent);
        }

        @Override // com.taobao.weex.devtools.inspector.elements.Document.UpdateListener
        public void onChildNodeInserted(DocumentView documentView, Object obj, int i, int i2, Accumulator<Object> accumulator) {
            ChildNodeInsertedEvent acquireChildNodeInsertedEvent = DOM.this.acquireChildNodeInsertedEvent();
            acquireChildNodeInsertedEvent.parentNodeId = i;
            acquireChildNodeInsertedEvent.previousNodeId = i2;
            acquireChildNodeInsertedEvent.node = DOM.this.createNodeForElement(obj, documentView, accumulator);
            DOM.this.mPeerManager.sendNotificationToPeers("DOM.childNodeInserted", acquireChildNodeInsertedEvent);
            DOM.this.releaseChildNodeInsertedEvent(acquireChildNodeInsertedEvent);
        }

        @Override // com.taobao.weex.devtools.inspector.elements.Document.UpdateListener
        public void onChildNodeRemoved(int i, int i2) {
            ChildNodeRemovedEvent acquireChildNodeRemovedEvent = DOM.this.acquireChildNodeRemovedEvent();
            acquireChildNodeRemovedEvent.parentNodeId = i;
            acquireChildNodeRemovedEvent.nodeId = i2;
            DOM.this.mPeerManager.sendNotificationToPeers("DOM.childNodeRemoved", acquireChildNodeRemovedEvent);
            DOM.this.releaseChildNodeRemovedEvent(acquireChildNodeRemovedEvent);
        }

        @Override // com.taobao.weex.devtools.inspector.elements.Document.UpdateListener
        public void onInspectRequested(Object obj) {
            Integer nodeIdForElement = DOM.this.mDocument.getNodeIdForElement(obj);
            if (nodeIdForElement == null) {
                LogUtil.d("DocumentProvider.Listener.onInspectRequested() called for a non-mapped node: element=%s", obj);
                return;
            }
            InspectNodeRequestedEvent inspectNodeRequestedEvent = new InspectNodeRequestedEvent();
            inspectNodeRequestedEvent.nodeId = nodeIdForElement.intValue();
            DOM.this.mPeerManager.sendNotificationToPeers("DOM.inspectNodeRequested", inspectNodeRequestedEvent);
        }
    }

    /* compiled from: Taobao */
    private static class GetBoxModelRequest {
        @JsonProperty
        public Integer nodeId;

        private GetBoxModelRequest() {
        }
    }

    /* compiled from: Taobao */
    public static final class GetBoxModelResponse implements JsonRpcResult {
        @JsonProperty(required = true)
        public BoxModel model;
    }

    /* compiled from: Taobao */
    private static class GetDocumentResponse implements JsonRpcResult {
        @JsonProperty(required = true)
        public Node root;

        private GetDocumentResponse() {
        }
    }

    /* compiled from: Taobao */
    private static class GetNodeForLocationRequest {
        @JsonProperty(required = true)
        public int x;
        @JsonProperty(required = true)
        public int y;

        private GetNodeForLocationRequest() {
        }
    }

    /* compiled from: Taobao */
    private static class GetNodeForLocationResponse implements JsonRpcResult {
        @JsonProperty(required = true)
        public Integer nodeId;

        private GetNodeForLocationResponse() {
        }
    }

    /* compiled from: Taobao */
    private static class GetSearchResultsRequest {
        @JsonProperty(required = true)
        public int fromIndex;
        @JsonProperty(required = true)
        public String searchId;
        @JsonProperty(required = true)
        public int toIndex;

        private GetSearchResultsRequest() {
        }
    }

    /* compiled from: Taobao */
    private static class GetSearchResultsResponse implements JsonRpcResult {
        @JsonProperty(required = true)
        public List<Integer> nodeIds;

        private GetSearchResultsResponse() {
        }
    }

    /* compiled from: Taobao */
    private static class HighlightConfig {
        @JsonProperty
        public RGBAColor contentColor;

        private HighlightConfig() {
        }
    }

    /* compiled from: Taobao */
    private static class HighlightNodeRequest {
        @JsonProperty(required = true)
        public HighlightConfig highlightConfig;
        @JsonProperty
        public Integer nodeId;
        @JsonProperty
        public String objectId;

        private HighlightNodeRequest() {
        }
    }

    /* compiled from: Taobao */
    private static class InspectNodeRequestedEvent {
        @JsonProperty
        public int nodeId;

        private InspectNodeRequestedEvent() {
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class Node implements JsonRpcResult {
        @JsonProperty
        public List<String> attributes;
        @JsonProperty
        public Integer childNodeCount;
        @JsonProperty
        public List<Node> children;
        @JsonProperty(required = true)
        public String localName;
        @JsonProperty(required = true)
        public int nodeId;
        @JsonProperty(required = true)
        public String nodeName;
        @JsonProperty(required = true)
        public NodeType nodeType;
        @JsonProperty(required = true)
        public String nodeValue;

        private Node() {
        }
    }

    /* compiled from: Taobao */
    private final class PeerManagerListener extends PeersRegisteredListener {
        private PeerManagerListener() {
        }

        /* access modifiers changed from: protected */
        @Override // com.taobao.weex.devtools.inspector.helper.PeersRegisteredListener
        public synchronized void onFirstPeerRegistered() {
            DOM.this.mDocument.addRef();
            DOM.this.mDocument.addUpdateListener(DOM.this.mListener);
        }

        /* access modifiers changed from: protected */
        @Override // com.taobao.weex.devtools.inspector.helper.PeersRegisteredListener
        public synchronized void onLastPeerUnregistered() {
            DOM.this.mSearchResults.clear();
            DOM.this.mDocument.removeUpdateListener(DOM.this.mListener);
            DOM.this.mDocument.release();
        }
    }

    /* compiled from: Taobao */
    private static class PerformSearchRequest {
        @JsonProperty
        public Boolean includeUserAgentShadowDOM;
        @JsonProperty(required = true)
        public String query;

        private PerformSearchRequest() {
        }
    }

    /* compiled from: Taobao */
    private static class PerformSearchResponse implements JsonRpcResult {
        @JsonProperty(required = true)
        public int resultCount;
        @JsonProperty(required = true)
        public String searchId;

        private PerformSearchResponse() {
        }
    }

    /* compiled from: Taobao */
    private static class RGBAColor {
        @JsonProperty
        public Double a;
        @JsonProperty(required = true)
        public int b;
        @JsonProperty(required = true)
        public int g;
        @JsonProperty(required = true)
        public int r;

        private RGBAColor() {
        }

        public int getColor() {
            Double d = this.a;
            byte b2 = -1;
            if (d != null) {
                long round = Math.round(d.doubleValue() * 255.0d);
                if (round < 0) {
                    b2 = 0;
                } else if (round < 255) {
                    b2 = (byte) ((int) round);
                }
            }
            return Color.argb((int) b2, this.r, this.g, this.b);
        }
    }

    /* compiled from: Taobao */
    private static class ResolveNodeRequest {
        @JsonProperty(required = true)
        public int nodeId;
        @JsonProperty
        public String objectGroup;

        private ResolveNodeRequest() {
        }
    }

    /* compiled from: Taobao */
    private static class ResolveNodeResponse implements JsonRpcResult {
        @JsonProperty(required = true)
        public Runtime.RemoteObject object;

        private ResolveNodeResponse() {
        }
    }

    /* compiled from: Taobao */
    private static class SetAttributesAsTextRequest {
        @JsonProperty(required = true)
        public int nodeId;
        @JsonProperty(required = true)
        public String text;

        private SetAttributesAsTextRequest() {
        }
    }

    /* compiled from: Taobao */
    private static class SetInspectModeEnabledRequest {
        @JsonProperty(required = true)
        public boolean enabled;
        @JsonProperty
        public HighlightConfig highlightConfig;
        @JsonProperty
        public Boolean inspectShadowDOM;

        private SetInspectModeEnabledRequest() {
        }
    }

    public DOM(Document document) {
        this.mDocument = (Document) Util.throwIfNull(document);
        this.mSearchResults = Collections.synchronizedMap(new HashMap());
        this.mResultCounter = new AtomicInteger(0);
        ChromePeerManager chromePeerManager = new ChromePeerManager();
        this.mPeerManager = chromePeerManager;
        chromePeerManager.setListener(new PeerManagerListener());
        this.mListener = new DocumentUpdateListener();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ChildNodeInsertedEvent acquireChildNodeInsertedEvent() {
        ChildNodeInsertedEvent childNodeInsertedEvent = this.mCachedChildNodeInsertedEvent;
        if (childNodeInsertedEvent == null) {
            childNodeInsertedEvent = new ChildNodeInsertedEvent();
        }
        this.mCachedChildNodeInsertedEvent = null;
        return childNodeInsertedEvent;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ChildNodeRemovedEvent acquireChildNodeRemovedEvent() {
        ChildNodeRemovedEvent childNodeRemovedEvent = this.mCachedChildNodeRemovedEvent;
        if (childNodeRemovedEvent == null) {
            childNodeRemovedEvent = new ChildNodeRemovedEvent();
        }
        this.mCachedChildNodeRemovedEvent = null;
        return childNodeRemovedEvent;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Node createNodeForElement(Object obj, DocumentView documentView, @Nullable Accumulator<Object> accumulator) {
        List<Node> list;
        if (accumulator != null) {
            accumulator.store(obj);
        }
        NodeDescriptor nodeDescriptor = this.mDocument.getNodeDescriptor(obj);
        Node node = new Node();
        node.nodeId = this.mDocument.getNodeIdForElement(obj).intValue();
        node.nodeType = nodeDescriptor.getNodeType(obj);
        node.nodeName = nodeDescriptor.getNodeName(obj);
        node.localName = nodeDescriptor.getLocalName(obj);
        node.nodeValue = nodeDescriptor.getNodeValue(obj);
        Document.AttributeListAccumulator attributeListAccumulator = new Document.AttributeListAccumulator();
        nodeDescriptor.getAttributes(obj, attributeListAccumulator);
        node.attributes = attributeListAccumulator;
        ElementInfo elementInfo = documentView.getElementInfo(obj);
        if (elementInfo.children.size() == 0) {
            list = Collections.emptyList();
        } else {
            list = new ArrayList<>(elementInfo.children.size());
        }
        int size = elementInfo.children.size();
        for (int i = 0; i < size; i++) {
            list.add(createNodeForElement(elementInfo.children.get(i), documentView, accumulator));
        }
        node.children = list;
        node.childNodeCount = Integer.valueOf(list.size());
        return node;
    }

    public static boolean isNativeMode() {
        return sNativeMode;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void releaseChildNodeInsertedEvent(ChildNodeInsertedEvent childNodeInsertedEvent) {
        childNodeInsertedEvent.parentNodeId = -1;
        childNodeInsertedEvent.previousNodeId = -1;
        childNodeInsertedEvent.node = null;
        if (this.mCachedChildNodeInsertedEvent == null) {
            this.mCachedChildNodeInsertedEvent = childNodeInsertedEvent;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void releaseChildNodeRemovedEvent(ChildNodeRemovedEvent childNodeRemovedEvent) {
        childNodeRemovedEvent.parentNodeId = -1;
        childNodeRemovedEvent.nodeId = -1;
        if (this.mCachedChildNodeRemovedEvent == null) {
            this.mCachedChildNodeRemovedEvent = childNodeRemovedEvent;
        }
    }

    public static void setNativeMode(boolean z) {
        sNativeMode = z;
    }

    @ChromeDevtoolsMethod
    public void disable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        this.mPeerManager.removePeer(jsonRpcPeer);
    }

    @ChromeDevtoolsMethod
    public void discardSearchResults(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        String str = ((DiscardSearchResultsRequest) this.mObjectMapper.convertValue(jSONObject, DiscardSearchResultsRequest.class)).searchId;
        if (str != null) {
            this.mSearchResults.remove(str);
        }
    }

    @ChromeDevtoolsMethod
    public void enable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        this.mPeerManager.addPeer(jsonRpcPeer);
    }

    public int findViewByLocation(final int i, final int i2) {
        final ArrayListAccumulator arrayListAccumulator = new ArrayListAccumulator();
        this.mDocument.postAndWait(new Runnable() {
            /* class com.taobao.weex.devtools.inspector.protocol.module.DOM.AnonymousClass8 */

            public void run() {
                DOM.this.mDocument.findMatchingElements(i, i2, arrayListAccumulator);
            }
        });
        if (arrayListAccumulator.size() > 0) {
            return ((Integer) arrayListAccumulator.get(arrayListAccumulator.size() - 1)).intValue();
        }
        return 0;
    }

    @ChromeDevtoolsMethod
    public GetBoxModelResponse getBoxModel(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        GetBoxModelResponse getBoxModelResponse = new GetBoxModelResponse();
        final BoxModel boxModel = new BoxModel();
        final GetBoxModelRequest getBoxModelRequest = (GetBoxModelRequest) this.mObjectMapper.convertValue(jSONObject, GetBoxModelRequest.class);
        if (getBoxModelRequest.nodeId == null) {
            return null;
        }
        getBoxModelResponse.model = boxModel;
        this.mDocument.postAndWait(new Runnable() {
            /* class com.taobao.weex.devtools.inspector.protocol.module.DOM.AnonymousClass9 */

            public void run() {
                final Object elementForNodeId = DOM.this.mDocument.getElementForNodeId(getBoxModelRequest.nodeId.intValue());
                if (elementForNodeId == null) {
                    LogUtil.w("Failed to get style of an element that does not exist, nodeid=" + getBoxModelRequest.nodeId);
                    return;
                }
                DOM.this.mDocument.getElementStyles(elementForNodeId, new StyleAccumulator() {
                    /* class com.taobao.weex.devtools.inspector.protocol.module.DOM.AnonymousClass9.AnonymousClass1 */

                    /* JADX WARNING: Removed duplicated region for block: B:10:0x0021  */
                    @Override // com.taobao.weex.devtools.inspector.elements.StyleAccumulator
                    public void store(String str, String str2, boolean z) {
                        View view;
                        double d;
                        double d2;
                        double d3;
                        double d4;
                        double d5;
                        double d6;
                        double d7;
                        double d8;
                        double d9;
                        double d10;
                        double d11;
                        double d12;
                        ViewGroup.LayoutParams layoutParams;
                        if (DOM.isNativeMode()) {
                            Object obj = elementForNodeId;
                            if (obj instanceof View) {
                                view = (View) obj;
                                if (view != null || !view.isShown()) {
                                    d12 = 0.0d;
                                    d11 = 0.0d;
                                    d10 = 0.0d;
                                    d9 = 0.0d;
                                    d8 = 0.0d;
                                    d7 = 0.0d;
                                    d6 = 0.0d;
                                    d5 = 0.0d;
                                    d4 = 0.0d;
                                    d3 = 0.0d;
                                    d2 = 0.0d;
                                    d = 0.0d;
                                } else {
                                    float f = ScreencastDispatcher.getsBitmapScale();
                                    boxModel.width = Integer.valueOf(view.getWidth());
                                    boxModel.height = Integer.valueOf(view.getHeight());
                                    if (!DOM.isNativeMode()) {
                                        BoxModel boxModel = boxModel;
                                        boxModel.width = Integer.valueOf((int) (((double) ((boxModel.width.intValue() * FeatureFactory.PRIORITY_ABOVE_NORMAL) / WXViewUtils.getScreenWidth())) + 0.5d));
                                        BoxModel boxModel2 = boxModel;
                                        boxModel2.height = Integer.valueOf((int) (((double) ((boxModel2.height.intValue() * FeatureFactory.PRIORITY_ABOVE_NORMAL) / WXViewUtils.getScreenWidth())) + 0.5d));
                                    }
                                    int[] iArr = new int[2];
                                    view.getLocationOnScreen(iArr);
                                    double d13 = (double) (((float) iArr[0]) * f);
                                    double d14 = (double) (((float) iArr[1]) * f);
                                    double width = ((double) (((float) view.getWidth()) * f)) + d13;
                                    double height = ((double) (((float) view.getHeight()) * f)) + d14;
                                    double paddingLeft = (double) (((float) view.getPaddingLeft()) * f);
                                    double paddingTop = (double) (((float) view.getPaddingTop()) * f);
                                    d4 = (double) (((float) view.getPaddingRight()) * f);
                                    double paddingBottom = (double) (((float) view.getPaddingBottom()) * f);
                                    if (!(view instanceof ViewGroup) || (layoutParams = view.getLayoutParams()) == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                                        d3 = paddingBottom;
                                        d12 = paddingTop;
                                        d11 = 0.0d;
                                        d2 = 0.0d;
                                        d = 0.0d;
                                        d5 = paddingLeft;
                                        d6 = height;
                                        d7 = width;
                                        d8 = d14;
                                        d9 = d13;
                                        d10 = 0.0d;
                                    } else {
                                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                                        d3 = paddingBottom;
                                        d2 = (double) (((float) marginLayoutParams.leftMargin) * f);
                                        d = (double) (((float) marginLayoutParams.topMargin) * f);
                                        d12 = paddingTop;
                                        d5 = paddingLeft;
                                        d6 = height;
                                        d7 = width;
                                        d8 = d14;
                                        d9 = d13;
                                        d10 = (double) (((float) marginLayoutParams.bottomMargin) * f);
                                        d11 = (double) (((float) marginLayoutParams.rightMargin) * f);
                                    }
                                }
                                ArrayList arrayList = new ArrayList(8);
                                double d15 = d9 + 0.0d;
                                arrayList.add(Double.valueOf(d15));
                                double d16 = d8 + 0.0d;
                                arrayList.add(Double.valueOf(d16));
                                double d17 = d7 - 0.0d;
                                arrayList.add(Double.valueOf(d17));
                                arrayList.add(Double.valueOf(d16));
                                arrayList.add(Double.valueOf(d17));
                                double d18 = d6 - 0.0d;
                                arrayList.add(Double.valueOf(d18));
                                arrayList.add(Double.valueOf(d15));
                                arrayList.add(Double.valueOf(d18));
                                boxModel.padding = arrayList;
                                ArrayList arrayList2 = new ArrayList(8);
                                double d19 = d15 + d5;
                                arrayList2.add(Double.valueOf(d19));
                                double d20 = d16 + d12;
                                arrayList2.add(Double.valueOf(d20));
                                double d21 = d17 - d4;
                                arrayList2.add(Double.valueOf(d21));
                                arrayList2.add(Double.valueOf(d20));
                                arrayList2.add(Double.valueOf(d21));
                                double d22 = d18 - d3;
                                arrayList2.add(Double.valueOf(d22));
                                arrayList2.add(Double.valueOf(d19));
                                arrayList2.add(Double.valueOf(d22));
                                boxModel.content = arrayList2;
                                ArrayList arrayList3 = new ArrayList(8);
                                arrayList3.add(Double.valueOf(d9));
                                arrayList3.add(Double.valueOf(d8));
                                arrayList3.add(Double.valueOf(d7));
                                arrayList3.add(Double.valueOf(d8));
                                arrayList3.add(Double.valueOf(d7));
                                arrayList3.add(Double.valueOf(d6));
                                arrayList3.add(Double.valueOf(d9));
                                arrayList3.add(Double.valueOf(d6));
                                boxModel.border = arrayList3;
                                ArrayList arrayList4 = new ArrayList(8);
                                double d23 = d9 - d2;
                                arrayList4.add(Double.valueOf(d23));
                                double d24 = d8 - d;
                                arrayList4.add(Double.valueOf(d24));
                                double d25 = d7 + d11;
                                arrayList4.add(Double.valueOf(d25));
                                arrayList4.add(Double.valueOf(d24));
                                arrayList4.add(Double.valueOf(d25));
                                double d26 = d6 + d10;
                                arrayList4.add(Double.valueOf(d26));
                                arrayList4.add(Double.valueOf(d23));
                                arrayList4.add(Double.valueOf(d26));
                                boxModel.margin = arrayList4;
                            }
                        } else {
                            Object obj2 = elementForNodeId;
                            if (obj2 instanceof WXComponent) {
                                view = ((WXComponent) obj2).getHostView();
                                if (view != null) {
                                }
                                d12 = 0.0d;
                                d11 = 0.0d;
                                d10 = 0.0d;
                                d9 = 0.0d;
                                d8 = 0.0d;
                                d7 = 0.0d;
                                d6 = 0.0d;
                                d5 = 0.0d;
                                d4 = 0.0d;
                                d3 = 0.0d;
                                d2 = 0.0d;
                                d = 0.0d;
                                ArrayList arrayList5 = new ArrayList(8);
                                double d152 = d9 + 0.0d;
                                arrayList5.add(Double.valueOf(d152));
                                double d162 = d8 + 0.0d;
                                arrayList5.add(Double.valueOf(d162));
                                double d172 = d7 - 0.0d;
                                arrayList5.add(Double.valueOf(d172));
                                arrayList5.add(Double.valueOf(d162));
                                arrayList5.add(Double.valueOf(d172));
                                double d182 = d6 - 0.0d;
                                arrayList5.add(Double.valueOf(d182));
                                arrayList5.add(Double.valueOf(d152));
                                arrayList5.add(Double.valueOf(d182));
                                boxModel.padding = arrayList5;
                                ArrayList arrayList22 = new ArrayList(8);
                                double d192 = d152 + d5;
                                arrayList22.add(Double.valueOf(d192));
                                double d202 = d162 + d12;
                                arrayList22.add(Double.valueOf(d202));
                                double d212 = d172 - d4;
                                arrayList22.add(Double.valueOf(d212));
                                arrayList22.add(Double.valueOf(d202));
                                arrayList22.add(Double.valueOf(d212));
                                double d222 = d182 - d3;
                                arrayList22.add(Double.valueOf(d222));
                                arrayList22.add(Double.valueOf(d192));
                                arrayList22.add(Double.valueOf(d222));
                                boxModel.content = arrayList22;
                                ArrayList arrayList32 = new ArrayList(8);
                                arrayList32.add(Double.valueOf(d9));
                                arrayList32.add(Double.valueOf(d8));
                                arrayList32.add(Double.valueOf(d7));
                                arrayList32.add(Double.valueOf(d8));
                                arrayList32.add(Double.valueOf(d7));
                                arrayList32.add(Double.valueOf(d6));
                                arrayList32.add(Double.valueOf(d9));
                                arrayList32.add(Double.valueOf(d6));
                                boxModel.border = arrayList32;
                                ArrayList arrayList42 = new ArrayList(8);
                                double d232 = d9 - d2;
                                arrayList42.add(Double.valueOf(d232));
                                double d242 = d8 - d;
                                arrayList42.add(Double.valueOf(d242));
                                double d252 = d7 + d11;
                                arrayList42.add(Double.valueOf(d252));
                                arrayList42.add(Double.valueOf(d242));
                                arrayList42.add(Double.valueOf(d252));
                                double d262 = d6 + d10;
                                arrayList42.add(Double.valueOf(d262));
                                arrayList42.add(Double.valueOf(d232));
                                arrayList42.add(Double.valueOf(d262));
                                boxModel.margin = arrayList42;
                            }
                        }
                        view = null;
                        if (view != null) {
                        }
                        d12 = 0.0d;
                        d11 = 0.0d;
                        d10 = 0.0d;
                        d9 = 0.0d;
                        d8 = 0.0d;
                        d7 = 0.0d;
                        d6 = 0.0d;
                        d5 = 0.0d;
                        d4 = 0.0d;
                        d3 = 0.0d;
                        d2 = 0.0d;
                        d = 0.0d;
                        ArrayList arrayList52 = new ArrayList(8);
                        double d1522 = d9 + 0.0d;
                        arrayList52.add(Double.valueOf(d1522));
                        double d1622 = d8 + 0.0d;
                        arrayList52.add(Double.valueOf(d1622));
                        double d1722 = d7 - 0.0d;
                        arrayList52.add(Double.valueOf(d1722));
                        arrayList52.add(Double.valueOf(d1622));
                        arrayList52.add(Double.valueOf(d1722));
                        double d1822 = d6 - 0.0d;
                        arrayList52.add(Double.valueOf(d1822));
                        arrayList52.add(Double.valueOf(d1522));
                        arrayList52.add(Double.valueOf(d1822));
                        boxModel.padding = arrayList52;
                        ArrayList arrayList222 = new ArrayList(8);
                        double d1922 = d1522 + d5;
                        arrayList222.add(Double.valueOf(d1922));
                        double d2022 = d1622 + d12;
                        arrayList222.add(Double.valueOf(d2022));
                        double d2122 = d1722 - d4;
                        arrayList222.add(Double.valueOf(d2122));
                        arrayList222.add(Double.valueOf(d2022));
                        arrayList222.add(Double.valueOf(d2122));
                        double d2222 = d1822 - d3;
                        arrayList222.add(Double.valueOf(d2222));
                        arrayList222.add(Double.valueOf(d1922));
                        arrayList222.add(Double.valueOf(d2222));
                        boxModel.content = arrayList222;
                        ArrayList arrayList322 = new ArrayList(8);
                        arrayList322.add(Double.valueOf(d9));
                        arrayList322.add(Double.valueOf(d8));
                        arrayList322.add(Double.valueOf(d7));
                        arrayList322.add(Double.valueOf(d8));
                        arrayList322.add(Double.valueOf(d7));
                        arrayList322.add(Double.valueOf(d6));
                        arrayList322.add(Double.valueOf(d9));
                        arrayList322.add(Double.valueOf(d6));
                        boxModel.border = arrayList322;
                        ArrayList arrayList422 = new ArrayList(8);
                        double d2322 = d9 - d2;
                        arrayList422.add(Double.valueOf(d2322));
                        double d2422 = d8 - d;
                        arrayList422.add(Double.valueOf(d2422));
                        double d2522 = d7 + d11;
                        arrayList422.add(Double.valueOf(d2522));
                        arrayList422.add(Double.valueOf(d2422));
                        arrayList422.add(Double.valueOf(d2522));
                        double d2622 = d6 + d10;
                        arrayList422.add(Double.valueOf(d2622));
                        arrayList422.add(Double.valueOf(d2322));
                        arrayList422.add(Double.valueOf(d2622));
                        boxModel.margin = arrayList422;
                    }
                });
            }
        });
        return getBoxModelResponse;
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult getDocument(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        GetDocumentResponse getDocumentResponse = new GetDocumentResponse();
        getDocumentResponse.root = (Node) this.mDocument.postAndWait(new UncheckedCallable<Node>() {
            /* class com.taobao.weex.devtools.inspector.protocol.module.DOM.AnonymousClass1 */

            @Override // com.taobao.weex.devtools.common.UncheckedCallable
            public Node call() {
                Object rootElement = DOM.this.mDocument.getRootElement();
                DOM dom = DOM.this;
                return dom.createNodeForElement(rootElement, dom.mDocument.getDocumentView(), null);
            }
        });
        return getDocumentResponse;
    }

    @ChromeDevtoolsMethod
    public GetNodeForLocationResponse getNodeForLocation(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        int i;
        GetNodeForLocationResponse getNodeForLocationResponse = new GetNodeForLocationResponse();
        GetNodeForLocationRequest getNodeForLocationRequest = (GetNodeForLocationRequest) this.mObjectMapper.convertValue(jSONObject, GetNodeForLocationRequest.class);
        int i2 = getNodeForLocationRequest.x;
        if (i2 > 0 && (i = getNodeForLocationRequest.y) > 0) {
            getNodeForLocationResponse.nodeId = Integer.valueOf(findViewByLocation(i2, i));
        }
        return getNodeForLocationResponse;
    }

    @ChromeDevtoolsMethod
    public GetSearchResultsResponse getSearchResults(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        GetSearchResultsRequest getSearchResultsRequest = (GetSearchResultsRequest) this.mObjectMapper.convertValue(jSONObject, GetSearchResultsRequest.class);
        String str = getSearchResultsRequest.searchId;
        if (str == null) {
            LogUtil.w("searchId may not be null");
            return null;
        }
        List<Integer> list = this.mSearchResults.get(str);
        if (list == null) {
            LogUtil.w("\"" + getSearchResultsRequest.searchId + "\" is not a valid reference to a search result");
            return null;
        }
        List<Integer> subList = list.subList(getSearchResultsRequest.fromIndex, getSearchResultsRequest.toIndex);
        GetSearchResultsResponse getSearchResultsResponse = new GetSearchResultsResponse();
        getSearchResultsResponse.nodeIds = subList;
        return getSearchResultsResponse;
    }

    @ChromeDevtoolsMethod
    public void hideHighlight(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        this.mDocument.postAndWait(new Runnable() {
            /* class com.taobao.weex.devtools.inspector.protocol.module.DOM.AnonymousClass3 */

            public void run() {
                DOM.this.mDocument.hideHighlight();
            }
        });
    }

    @ChromeDevtoolsMethod
    public void highlightNode(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        final HighlightNodeRequest highlightNodeRequest = (HighlightNodeRequest) this.mObjectMapper.convertValue(jSONObject, HighlightNodeRequest.class);
        if (highlightNodeRequest.nodeId == null) {
            LogUtil.w("DOM.highlightNode was not given a nodeId; JS objectId is not supported");
            return;
        }
        final RGBAColor rGBAColor = highlightNodeRequest.highlightConfig.contentColor;
        if (rGBAColor == null) {
            LogUtil.w("DOM.highlightNode was not given a color to highlight with");
        } else {
            this.mDocument.postAndWait(new Runnable() {
                /* class com.taobao.weex.devtools.inspector.protocol.module.DOM.AnonymousClass2 */

                public void run() {
                    Object elementForNodeId = DOM.this.mDocument.getElementForNodeId(highlightNodeRequest.nodeId.intValue());
                    if (elementForNodeId != null) {
                        DOM.this.mDocument.highlightElement(elementForNodeId, rGBAColor.getColor());
                    }
                }
            });
        }
    }

    @ChromeDevtoolsMethod
    public PerformSearchResponse performSearch(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        final PerformSearchRequest performSearchRequest = (PerformSearchRequest) this.mObjectMapper.convertValue(jSONObject, PerformSearchRequest.class);
        final ArrayListAccumulator arrayListAccumulator = new ArrayListAccumulator();
        this.mDocument.postAndWait(new Runnable() {
            /* class com.taobao.weex.devtools.inspector.protocol.module.DOM.AnonymousClass7 */

            public void run() {
                DOM.this.mDocument.findMatchingElements(performSearchRequest.query, arrayListAccumulator);
            }
        });
        String valueOf = String.valueOf(this.mResultCounter.getAndIncrement());
        this.mSearchResults.put(valueOf, arrayListAccumulator);
        PerformSearchResponse performSearchResponse = new PerformSearchResponse();
        performSearchResponse.searchId = valueOf;
        performSearchResponse.resultCount = arrayListAccumulator.size();
        return performSearchResponse;
    }

    @ChromeDevtoolsMethod
    public ResolveNodeResponse resolveNode(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) throws JsonRpcException {
        final ResolveNodeRequest resolveNodeRequest = (ResolveNodeRequest) this.mObjectMapper.convertValue(jSONObject, ResolveNodeRequest.class);
        Object postAndWait = this.mDocument.postAndWait(new UncheckedCallable<Object>() {
            /* class com.taobao.weex.devtools.inspector.protocol.module.DOM.AnonymousClass4 */

            @Override // com.taobao.weex.devtools.common.UncheckedCallable
            public Object call() {
                return DOM.this.mDocument.getElementForNodeId(resolveNodeRequest.nodeId);
            }
        });
        if (postAndWait != null) {
            int mapObject = Runtime.mapObject(jsonRpcPeer, postAndWait);
            Runtime.RemoteObject remoteObject = new Runtime.RemoteObject();
            remoteObject.type = Runtime.ObjectType.OBJECT;
            remoteObject.subtype = Runtime.ObjectSubType.NODE;
            remoteObject.className = postAndWait.getClass().getName();
            remoteObject.value = null;
            remoteObject.description = null;
            remoteObject.objectId = String.valueOf(mapObject);
            ResolveNodeResponse resolveNodeResponse = new ResolveNodeResponse();
            resolveNodeResponse.object = remoteObject;
            return resolveNodeResponse;
        }
        JsonRpcError.ErrorCode errorCode = JsonRpcError.ErrorCode.INVALID_PARAMS;
        throw new JsonRpcException(new JsonRpcError(errorCode, "No known nodeId=" + resolveNodeRequest.nodeId, null));
    }

    @ChromeDevtoolsMethod
    public void setAttributesAsText(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        final SetAttributesAsTextRequest setAttributesAsTextRequest = (SetAttributesAsTextRequest) this.mObjectMapper.convertValue(jSONObject, SetAttributesAsTextRequest.class);
        this.mDocument.postAndWait(new Runnable() {
            /* class com.taobao.weex.devtools.inspector.protocol.module.DOM.AnonymousClass5 */

            public void run() {
                Object elementForNodeId = DOM.this.mDocument.getElementForNodeId(setAttributesAsTextRequest.nodeId);
                if (elementForNodeId != null) {
                    DOM.this.mDocument.setAttributesAsText(elementForNodeId, setAttributesAsTextRequest.text);
                }
            }
        });
    }

    @ChromeDevtoolsMethod
    public void setInspectModeEnabled(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        final SetInspectModeEnabledRequest setInspectModeEnabledRequest = (SetInspectModeEnabledRequest) this.mObjectMapper.convertValue(jSONObject, SetInspectModeEnabledRequest.class);
        this.mDocument.postAndWait(new Runnable() {
            /* class com.taobao.weex.devtools.inspector.protocol.module.DOM.AnonymousClass6 */

            public void run() {
                DOM.this.mDocument.setInspectModeEnabled(setInspectModeEnabledRequest.enabled);
            }
        });
    }
}
