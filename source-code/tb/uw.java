package tb;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.model.DXLongSparseArray;
import com.taobao.android.dinamicx.widget.DXTemplateWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.Map;

/* compiled from: Taobao */
public class uw extends gy {
    public static final long DX_PARSER_TEMPLATEDATA = -1464634009013122078L;
    public static final int TYPE_CONSTANT = 0;
    public static final int TYPE_EXPR = 1;

    public static DXLongSparseArray<ay> d(DXWidgetNode dXWidgetNode) {
        DXWidgetNode queryRootWidgetNode = dXWidgetNode.queryRootWidgetNode();
        if (queryRootWidgetNode == null) {
            return null;
        }
        if (queryRootWidgetNode.getCodeMap() != null) {
            DXWidgetNode parentWidget = queryRootWidgetNode.getParentWidget();
            if (!(parentWidget instanceof DXTemplateWidgetNode)) {
                return queryRootWidgetNode.getCodeMap();
            }
            DXTemplateWidgetNode dXTemplateWidgetNode = (DXTemplateWidgetNode) parentWidget;
            if (!dXTemplateWidgetNode.getHasSlot() && TextUtils.isEmpty(dXTemplateWidgetNode.getSlotId())) {
                return queryRootWidgetNode.getCodeMap();
            }
        }
        if (queryRootWidgetNode.getParentWidget() instanceof DXTemplateWidgetNode) {
            return d(queryRootWidgetNode.getParentWidget());
        }
        return null;
    }

    private JSONObject e(DXRuntimeContext dXRuntimeContext) {
        DXWidgetNode queryRootWidgetNode = dXRuntimeContext.getWidgetNode().queryRootWidgetNode();
        if (queryRootWidgetNode == null) {
            return null;
        }
        DXWidgetNode parentWidget = queryRootWidgetNode.getParentWidget();
        if (!(parentWidget instanceof DXTemplateWidgetNode)) {
            return null;
        }
        DXTemplateWidgetNode dXTemplateWidgetNode = (DXTemplateWidgetNode) parentWidget;
        JSONObject parsedTemplateData = dXTemplateWidgetNode.getParsedTemplateData();
        if (parsedTemplateData != null && !parsedTemplateData.isEmpty()) {
            return parsedTemplateData;
        }
        JSONObject jSONObject = dXTemplateWidgetNode.get_templateData();
        if (jSONObject == null) {
            return null;
        }
        JSONObject f = f(jSONObject, parentWidget.getDXRuntimeContext());
        ((DXTemplateWidgetNode) parentWidget).setParsedTemplateData(f);
        return f;
    }

    private JSONObject f(JSONObject jSONObject, DXRuntimeContext dXRuntimeContext) {
        if (jSONObject == null || jSONObject.isEmpty()) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof JSONObject) {
                JSONObject jSONObject3 = (JSONObject) value;
                if (1 == jSONObject3.getInteger("t").intValue()) {
                    long longValue = jSONObject3.getLongValue("v");
                    DXLongSparseArray<ay> d = d(dXRuntimeContext.getWidgetNode());
                    String key = entry.getKey();
                    if (d == null) {
                        ry.c("key " + key + " mCodeMap 是null");
                    } else {
                        ay ayVar = d.get(longValue);
                        if (ayVar == null) {
                            ry.c("key " + key + " exprNode 是null");
                        } else {
                            jSONObject2.put(entry.getKey(), ayVar.b(null, dXRuntimeContext));
                        }
                    }
                } else {
                    jSONObject2.put(entry.getKey(), jSONObject3.get("v"));
                }
            }
        }
        return jSONObject2;
    }

    /* access modifiers changed from: protected */
    @Override // tb.gy
    public Object a(DXRuntimeContext dXRuntimeContext) {
        return e(dXRuntimeContext);
    }

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, tb.gy, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        return super.evalWithArgs(objArr, dXRuntimeContext);
    }
}
