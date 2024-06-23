package com.taobao.android.dinamicx;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.widget.DXTemplateWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.List;
import tb.at;
import tb.ay;
import tb.by;
import tb.d00;
import tb.gx;
import tb.jl1;
import tb.vx;

/* compiled from: Taobao */
public class m {
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0092 A[Catch:{ Exception -> 0x00de }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d6 A[Catch:{ Exception -> 0x00de }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0107 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    public static boolean a(DXWidgetNode dXWidgetNode) {
        Object obj;
        Exception e;
        if (at.h0()) {
            if (dXWidgetNode.getVisibility() == 2 && dXWidgetNode.getDataParsersExprNode() != null && dXWidgetNode.getDataParsersExprNode().get(5802348655878590802L) == null) {
                return true;
            }
        } else if (dXWidgetNode.getVisibility() == 2) {
            return true;
        }
        if (dXWidgetNode.getDataParsersExprNode() == null) {
            return false;
        }
        if (!dXWidgetNode.getStatInPrivateFlags(2048)) {
            if (dXWidgetNode.getDataParsersExprNode().get(5802348655878590802L) != null) {
                ay ayVar = dXWidgetNode.getDataParsersExprNode().get(5802348655878590802L);
                Object obj2 = null;
                try {
                    DXRuntimeContext dXRuntimeContext = dXWidgetNode.getDXRuntimeContext();
                    by.a().doBeforeExecuteASTWithEventAndContext(ayVar, null, dXRuntimeContext);
                    obj = ayVar.b(null, dXRuntimeContext);
                    try {
                        by.a().doAfterExecuteASTWithEventAndContext(ayVar, null, dXRuntimeContext);
                    } catch (Exception e2) {
                        e = e2;
                        obj2 = obj;
                    }
                } catch (Exception e3) {
                    e = e3;
                    if (DinamicXEngine.x()) {
                        e.printStackTrace();
                    }
                    dXWidgetNode.getDXRuntimeContext().getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", e.DXERROR_PIPELINE_PARSE_WT_EXPR_EVALUEATE_EXCEPTION));
                    obj = obj2;
                    if (!(obj instanceof String)) {
                    }
                    dXWidgetNode.setStatFlag(2048);
                    if (dXWidgetNode.getVisibility() != 2) {
                    }
                }
                try {
                    if (!(obj instanceof String)) {
                        String valueOf = String.valueOf(obj);
                        if (dXWidgetNode.getEnumMap() == null || dXWidgetNode.getEnumMap().get(5802348655878590802L) == null || dXWidgetNode.getEnumMap().get(5802348655878590802L).get(valueOf) == null) {
                            dXWidgetNode.setIntAttribute(5802348655878590802L, dXWidgetNode.getDefaultValueForIntAttr(5802348655878590802L));
                        } else {
                            dXWidgetNode.setIntAttribute(5802348655878590802L, dXWidgetNode.getEnumMap().get(5802348655878590802L).get(valueOf).intValue());
                        }
                    } else {
                        dXWidgetNode.setIntAttribute(5802348655878590802L, dXWidgetNode.getDefaultValueForIntAttr(5802348655878590802L));
                    }
                } catch (Exception e4) {
                    if (DinamicXEngine.x()) {
                        e4.printStackTrace();
                    }
                    dXWidgetNode.getDXRuntimeContext().getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", e.DXERROR_PIPELINE_PARSE_WT_EXPR_SET_VALUE));
                }
            }
            dXWidgetNode.setStatFlag(2048);
        }
        if (dXWidgetNode.getVisibility() != 2) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0086  */
    private void b(DXWidgetNode dXWidgetNode) {
        DXRuntimeContext dXRuntimeContext;
        Object obj;
        short c;
        int i;
        Exception e;
        if (dXWidgetNode.getDataParsersExprNode() != null) {
            DXRuntimeContext dXRuntimeContext2 = dXWidgetNode.getDXRuntimeContext();
            int i2 = 0;
            while (i2 < dXWidgetNode.getDataParsersExprNode().size()) {
                long keyAt = dXWidgetNode.getDataParsersExprNode().keyAt(i2);
                if (keyAt != 5802348655878590802L) {
                    ay valueAt = dXWidgetNode.getDataParsersExprNode().valueAt(i2);
                    Object obj2 = null;
                    try {
                        by.a().doBeforeExecuteASTWithEventAndContext(valueAt, null, dXRuntimeContext2);
                        Object b = valueAt.b(null, dXRuntimeContext2);
                        try {
                            by.a().doAfterExecuteASTWithEventAndContext(valueAt, null, dXRuntimeContext2);
                            obj = b;
                        } catch (Exception e2) {
                            e = e2;
                            obj2 = b;
                            if (DinamicXEngine.x()) {
                                e.printStackTrace();
                            }
                            dXRuntimeContext2.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", e.DXERROR_PIPELINE_PARSE_WT_EXPR_EVALUEATE_EXCEPTION));
                            obj = obj2;
                            c = valueAt.c();
                            if (c == 96) {
                            }
                            dXRuntimeContext = dXRuntimeContext2;
                            i2++;
                            dXRuntimeContext2 = dXRuntimeContext;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        if (DinamicXEngine.x()) {
                        }
                        dXRuntimeContext2.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", e.DXERROR_PIPELINE_PARSE_WT_EXPR_EVALUEATE_EXCEPTION));
                        obj = obj2;
                        c = valueAt.c();
                        if (c == 96) {
                        }
                        dXRuntimeContext = dXRuntimeContext2;
                        i2++;
                        dXRuntimeContext2 = dXRuntimeContext;
                    }
                    c = valueAt.c();
                    if (c == 96) {
                        e(dXRuntimeContext2.getContext(), dXWidgetNode, keyAt, obj);
                    } else if (c == 608) {
                        String valueOf = String.valueOf(obj);
                        if (dXWidgetNode.getEnumMap() == null || dXWidgetNode.getEnumMap().get(keyAt) == null || dXWidgetNode.getEnumMap().get(keyAt).get(valueOf) == null) {
                            e(dXRuntimeContext2.getContext(), dXWidgetNode, keyAt, obj);
                        } else {
                            dXWidgetNode.setIntAttribute(keyAt, dXWidgetNode.getEnumMap().get(keyAt).get(valueOf).intValue());
                        }
                    } else {
                        boolean z = obj != null;
                        if (c != 1) {
                            if (c != 2) {
                                if (c != 4) {
                                    if (c != 8) {
                                        if (c == 16) {
                                            if (z) {
                                                try {
                                                    i = Color.parseColor(String.valueOf(obj));
                                                } catch (Exception unused) {
                                                    dXRuntimeContext2.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Parse_Widget", e.DXERROR_PIPELINE_PARSE_WT_COLOR_EXCEPTION));
                                                    Log.i("DXTemplateParser", jl1.ARRAY_START_STR + keyAt + "=" + obj + "] parse Color failed, use default value.");
                                                    i = dXWidgetNode.getDefaultValueForIntAttr(keyAt);
                                                }
                                            } else {
                                                i = dXWidgetNode.getDefaultValueForIntAttr(keyAt);
                                            }
                                            dXWidgetNode.setIntAttribute(keyAt, i);
                                        } else if (c == 32 || c == 64) {
                                            e(dXRuntimeContext2.getContext(), dXWidgetNode, keyAt, obj);
                                        } else if (c != 128) {
                                            if (c != 256) {
                                                if (c != 512) {
                                                    if (c == 1024) {
                                                        if (obj != null) {
                                                            dXWidgetNode.setObjAttribute(keyAt, obj);
                                                        } else {
                                                            dXWidgetNode.setObjAttribute(keyAt, dXWidgetNode.getDefaultValueForObjectAttr(keyAt));
                                                        }
                                                    }
                                                } else if (obj instanceof String) {
                                                    String valueOf2 = String.valueOf(obj);
                                                    if (dXWidgetNode.getEnumMap() == null || dXWidgetNode.getEnumMap().get(keyAt) == null || dXWidgetNode.getEnumMap().get(keyAt).get(valueOf2) == null) {
                                                        dXWidgetNode.setIntAttribute(keyAt, dXWidgetNode.getDefaultValueForIntAttr(keyAt));
                                                    } else {
                                                        dXWidgetNode.setIntAttribute(keyAt, dXWidgetNode.getEnumMap().get(keyAt).get(valueOf2).intValue());
                                                    }
                                                } else {
                                                    dXWidgetNode.setIntAttribute(keyAt, dXWidgetNode.getDefaultValueForIntAttr(keyAt));
                                                }
                                            } else if (!z || !(obj instanceof JSONObject)) {
                                                n(dXWidgetNode, keyAt);
                                            } else {
                                                try {
                                                    dXWidgetNode.setMapAttribute(keyAt, (JSONObject) obj);
                                                } catch (Exception unused2) {
                                                    dXRuntimeContext2.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Parse_Widget", e.DXERROR_PIPELINE_PARSE_WT_MAP_EXCEPTION));
                                                    Log.i("DXTemplateParser", jl1.ARRAY_START_STR + keyAt + "=" + obj + "] parse JsonObject&Map failed, use default value.");
                                                    n(dXWidgetNode, keyAt);
                                                }
                                            }
                                        } else if (z && gx.b(dXRuntimeContext2, obj)) {
                                            dXWidgetNode.setUserDefinedListAttribute(keyAt, (List) obj);
                                        } else if (!z || !(obj instanceof JSONArray)) {
                                            l(dXWidgetNode, keyAt);
                                        } else {
                                            try {
                                                dXWidgetNode.setListAttribute(keyAt, (JSONArray) obj);
                                            } catch (Exception unused3) {
                                                dXRuntimeContext2.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Parse_Widget", e.DXERROR_PIPELINE_PARSE_WT_LIST_EXCEPTION));
                                                Log.i("DXTemplateParser", jl1.ARRAY_START_STR + keyAt + "=" + obj + "] parse JsonArray&List failed, use default value.");
                                                l(dXWidgetNode, keyAt);
                                            }
                                        }
                                    } else if (!z || !(obj instanceof String)) {
                                        dXWidgetNode.setStringAttribute(keyAt, dXWidgetNode.getDefaultValueForStringAttr(keyAt));
                                    } else {
                                        dXWidgetNode.setStringAttribute(keyAt, (String) obj);
                                    }
                                } else if (!z) {
                                    j(dXWidgetNode, keyAt);
                                } else {
                                    try {
                                        dXWidgetNode.setDoubleAttribute(keyAt, Double.parseDouble(String.valueOf(obj)));
                                    } catch (Exception unused4) {
                                        dXRuntimeContext2.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Parse_Widget", e.DXERROR_PIPELINE_PARSE_WT_DOUBLE_EXCEPTION));
                                        Log.i("DXTemplateParser", jl1.ARRAY_START_STR + keyAt + "=" + obj + "] parse Double failed, use default value.");
                                        j(dXWidgetNode, keyAt);
                                    }
                                }
                            } else if (!z) {
                                m(dXWidgetNode, keyAt);
                            } else {
                                try {
                                    dXWidgetNode.setLongAttribute(keyAt, Long.parseLong(String.valueOf(obj)));
                                } catch (Exception unused5) {
                                    dXRuntimeContext2.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Parse_Widget", e.DXERROR_PIPELINE_PARSE_WT_LONG_EXCEPTION));
                                    Log.i("DXTemplateParser", jl1.ARRAY_START_STR + keyAt + "=" + obj + "] parse Long failed, use default value.");
                                    m(dXWidgetNode, keyAt);
                                }
                            }
                        } else if (!z) {
                            k(dXWidgetNode, keyAt);
                        } else {
                            try {
                                dXWidgetNode.setIntAttribute(keyAt, Integer.parseInt(String.valueOf(obj)));
                            } catch (Exception e4) {
                                List<e.a> list = dXRuntimeContext2.getDxError().c;
                                StringBuilder sb = new StringBuilder();
                                dXRuntimeContext = dXRuntimeContext2;
                                sb.append("parseAttrsInWidgetNode");
                                sb.append(vx.a(e4));
                                list.add(new e.a("Pipeline", "Pipeline_Stage_Parse_Widget", e.DXERROR_PIPELINE_PARSE_WT_INT_EXCEPTION, sb.toString()));
                                Log.i("DXTemplateParser", jl1.ARRAY_START_STR + keyAt + "=" + obj + "] parse Integer failed, use default value.");
                                k(dXWidgetNode, keyAt);
                            }
                        }
                    }
                }
                dXRuntimeContext = dXRuntimeContext2;
                i2++;
                dXRuntimeContext2 = dXRuntimeContext;
            }
        }
    }

    private void c(DXWidgetNode dXWidgetNode) {
        if (!dXWidgetNode.getStatInPrivateFlags(2) || dXWidgetNode.getStatInPrivateFlags(1)) {
            b(dXWidgetNode);
            dXWidgetNode.setStatFlag(2);
        }
    }

    private void e(Context context, DXWidgetNode dXWidgetNode, long j, Object obj) {
        dXWidgetNode.setIntAttribute(j, d00.j(context, String.valueOf(obj), dXWidgetNode.getDefaultValueForIntAttr(j)));
    }

    private boolean g(DXWidgetNode dXWidgetNode) {
        if (a(dXWidgetNode)) {
            return false;
        }
        if (dXWidgetNode.getStatInPrivateFlags(1024)) {
            if (dXWidgetNode.getLayoutWidth() == 0 || dXWidgetNode.getLayoutHeight() == 0) {
                b(dXWidgetNode);
                dXWidgetNode.setStatFlag(2);
            }
            if (!(dXWidgetNode.getLayoutWidth() == -2 || dXWidgetNode.getLayoutHeight() == -2)) {
                return false;
            }
        }
        c(dXWidgetNode);
        if (dXWidgetNode instanceof DXTemplateWidgetNode) {
            ((DXTemplateWidgetNode) dXWidgetNode).onProcessRemoteTemplate(1);
        }
        if (!dXWidgetNode.getStatInPrivateFlags(4096)) {
            dXWidgetNode.setStatFlag(4096);
            if (dXWidgetNode.getChildrenCount() > 0) {
                dXWidgetNode.onBeforeBindChildData();
            }
        }
        return true;
    }

    private void i(DXWidgetNode dXWidgetNode) {
        dXWidgetNode.beginParser(true);
        dXWidgetNode.unsetStatFlag(1024);
        if (g(dXWidgetNode)) {
            int direction = dXWidgetNode.getDirection();
            for (int i = 0; i < dXWidgetNode.getChildrenCount(); i++) {
                DXWidgetNode childAt = dXWidgetNode.getChildAt(i);
                childAt.getDXRuntimeContext().setParentDirectionSpec(direction);
                i(childAt);
            }
            o(dXWidgetNode);
            dXWidgetNode.endParser(true);
        }
    }

    private void j(DXWidgetNode dXWidgetNode, long j) {
        dXWidgetNode.setDoubleAttribute(j, dXWidgetNode.getDefaultValueForDoubleAttr(j));
    }

    private void k(DXWidgetNode dXWidgetNode, long j) {
        dXWidgetNode.setIntAttribute(j, dXWidgetNode.getDefaultValueForIntAttr(j));
    }

    private void l(DXWidgetNode dXWidgetNode, long j) {
        dXWidgetNode.setListAttribute(j, dXWidgetNode.getDefaultValueForListAttr(j));
    }

    private void m(DXWidgetNode dXWidgetNode, long j) {
        dXWidgetNode.setLongAttribute(j, dXWidgetNode.getDefaultValueForLongAttr(j));
    }

    private void n(DXWidgetNode dXWidgetNode, long j) {
        dXWidgetNode.setMapAttribute(j, dXWidgetNode.getDefaultValueForMapAttr(j));
    }

    private void o(DXWidgetNode dXWidgetNode) {
        dXWidgetNode.unsetStatFlag(1);
        dXWidgetNode.setStatFlag(32768);
        dXWidgetNode.setStatFlag(4);
    }

    public void d(DXWidgetNode dXWidgetNode) {
        dXWidgetNode.setStatFlag(1024);
        if (g(dXWidgetNode)) {
            int direction = dXWidgetNode.getDirection();
            for (int i = 0; i < dXWidgetNode.getChildrenCount(); i++) {
                DXWidgetNode childAt = dXWidgetNode.getChildAt(i);
                childAt.getDXRuntimeContext().setParentDirectionSpec(direction);
                d(childAt);
            }
        }
    }

    public DXWidgetNode f(DXWidgetNode dXWidgetNode) {
        try {
            i(dXWidgetNode);
            return dXWidgetNode;
        } catch (Exception e) {
            vx.b(e);
            if (dXWidgetNode == null || dXWidgetNode.getDXRuntimeContext() == null) {
                return null;
            }
            dXWidgetNode.getDXRuntimeContext().getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", e.DXERROR_WIDGETNODE_PARSE_WT_EXCEPTION));
            return null;
        }
    }

    public void h(DXWidgetNode dXWidgetNode, boolean z) {
        if (dXWidgetNode != null && !a(dXWidgetNode)) {
            c(dXWidgetNode);
            if (z) {
                o(dXWidgetNode);
            }
        }
    }
}
