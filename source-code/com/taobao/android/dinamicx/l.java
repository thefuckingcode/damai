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
import tb.lx;
import tb.ry;
import tb.vx;
import tb.wz;

/* compiled from: Taobao */
public class l {
    private void a(Context context, DXWidgetNode dXWidgetNode, long j, Object obj) {
        dXWidgetNode.setIntAttribute(j, d00.j(context, String.valueOf(obj), dXWidgetNode.getDefaultValueForIntAttr(j)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:199:0x04f1  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x04f9  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x052c A[LOOP:1: B:211:0x0526->B:213:0x052c, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a9 A[Catch:{ Exception -> 0x00fb }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00f3 A[Catch:{ Exception -> 0x00fb }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0199  */
    private void c(DXWidgetNode dXWidgetNode, DXRuntimeContext dXRuntimeContext) {
        boolean z;
        int i;
        int i2;
        boolean z2;
        lx lxVar;
        int i3;
        String str;
        String str2;
        Object obj;
        short c;
        int i4;
        Exception e;
        Object obj2;
        Exception e2;
        long j = 5802348655878590802L;
        if (at.h0()) {
            if (dXWidgetNode.getVisibility() == 2 && dXWidgetNode.getDataParsersExprNode() != null && dXWidgetNode.getDataParsersExprNode().get(5802348655878590802L) == null) {
                return;
            }
        } else if (dXWidgetNode.getVisibility() == 2) {
            return;
        }
        short s = 1;
        boolean z3 = dXRuntimeContext == null || !dXRuntimeContext.isRefreshPart() ? dXWidgetNode.getDataParsersExprNode() != null : !(dXWidgetNode.getDataParsersExprNode() == null || !dXWidgetNode.getStatInPrivateFlags(1) || dXWidgetNode.getStatInPrivateFlags(2));
        dXWidgetNode.beginParser(z3);
        if (z3) {
            ay ayVar = dXWidgetNode.getDataParsersExprNode().get(5802348655878590802L);
            int i5 = e.DXERROR_PIPELINE_PARSE_WT_EXPR_EVALUEATE_EXCEPTION;
            String str3 = "Pipeline_Stage_Load_Binary";
            lx lxVar2 = null;
            String str4 = "Pipeline";
            if (ayVar != null) {
                ay ayVar2 = dXWidgetNode.getDataParsersExprNode().get(5802348655878590802L);
                try {
                    by.a().doBeforeExecuteASTWithEventAndContext(ayVar2, null, dXRuntimeContext);
                    obj2 = ayVar2.b(null, dXRuntimeContext);
                    try {
                        by.a().doAfterExecuteASTWithEventAndContext(ayVar2, null, dXRuntimeContext);
                    } catch (Exception e3) {
                        e2 = e3;
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    obj2 = null;
                    if (DinamicXEngine.x()) {
                        e2.printStackTrace();
                    }
                    dXRuntimeContext.getDxError().c.add(new e.a(str4, str3, e.DXERROR_PIPELINE_PARSE_WT_EXPR_EVALUEATE_EXCEPTION));
                    if (!(obj2 instanceof String)) {
                    }
                    i2 = 0;
                    while (i2 < dXWidgetNode.getDataParsersExprNode().size()) {
                    }
                    z = z3;
                    dXWidgetNode.setStatFlag(4);
                    dXWidgetNode.unsetStatFlag(1);
                    dXWidgetNode.setStatFlag(2);
                    if (!(dXWidgetNode instanceof DXTemplateWidgetNode)) {
                    }
                    if (dXWidgetNode.getDXRuntimeContext() != null) {
                    }
                    dXWidgetNode.setStatFlag(4096);
                    dXWidgetNode.onBeforeBindChildData();
                    int direction = dXWidgetNode.getDirection();
                    while (i < dXWidgetNode.getChildrenCount()) {
                    }
                    dXWidgetNode.endParser(z);
                }
                try {
                    if (!(obj2 instanceof String)) {
                        String valueOf = String.valueOf(obj2);
                        if (dXWidgetNode.getEnumMap() == null || dXWidgetNode.getEnumMap().get(5802348655878590802L) == null || dXWidgetNode.getEnumMap().get(5802348655878590802L).get(valueOf) == null) {
                            dXWidgetNode.setIntAttribute(5802348655878590802L, dXWidgetNode.getDefaultValueForIntAttr(5802348655878590802L));
                        } else {
                            dXWidgetNode.setIntAttribute(5802348655878590802L, dXWidgetNode.getEnumMap().get(5802348655878590802L).get(valueOf).intValue());
                            if (dXWidgetNode.getVisibility() == 2) {
                                return;
                            }
                        }
                    } else {
                        dXWidgetNode.setIntAttribute(5802348655878590802L, dXWidgetNode.getDefaultValueForIntAttr(5802348655878590802L));
                    }
                } catch (Exception e5) {
                    if (DinamicXEngine.x()) {
                        e5.printStackTrace();
                    }
                    dXRuntimeContext.getDxError().c.add(new e.a(str4, str3, e.DXERROR_PIPELINE_PARSE_WT_EXPR_SET_VALUE));
                }
            }
            i2 = 0;
            while (i2 < dXWidgetNode.getDataParsersExprNode().size()) {
                long keyAt = dXWidgetNode.getDataParsersExprNode().keyAt(i2);
                if (keyAt == j) {
                    i3 = i2;
                    str2 = str4;
                    str = str3;
                    lxVar = lxVar2;
                    z2 = z3;
                } else {
                    ay valueAt = dXWidgetNode.getDataParsersExprNode().valueAt(i2);
                    try {
                        by.a().doBeforeExecuteASTWithEventAndContext(valueAt, lxVar2, dXRuntimeContext);
                        obj = valueAt.b(lxVar2, dXRuntimeContext);
                        try {
                            by.a().doAfterExecuteASTWithEventAndContext(valueAt, lxVar2, dXRuntimeContext);
                        } catch (Exception e6) {
                            e = e6;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        obj = lxVar2;
                        if (DinamicXEngine.x()) {
                            e.printStackTrace();
                        }
                        dXRuntimeContext.getDxError().c.add(new e.a(str4, str3, i5));
                        c = valueAt.c();
                        if (c != 96) {
                        }
                        z2 = z3;
                        i2 = i3 + 1;
                        str4 = str2;
                        str3 = str;
                        lxVar2 = lxVar;
                        z3 = z2;
                        i5 = e.DXERROR_PIPELINE_PARSE_WT_EXPR_EVALUEATE_EXCEPTION;
                        j = 5802348655878590802L;
                        s = 1;
                    }
                    c = valueAt.c();
                    if (c != 96) {
                        i3 = i2;
                        str2 = str4;
                        str = str3;
                        lxVar = null;
                        a(dXRuntimeContext.getContext(), dXWidgetNode, keyAt, obj);
                    } else {
                        i3 = i2;
                        str = str3;
                        lxVar = null;
                        if (c == 608) {
                            String valueOf2 = String.valueOf(obj);
                            if (dXWidgetNode.getEnumMap() == null || dXWidgetNode.getEnumMap().get(keyAt) == null || dXWidgetNode.getEnumMap().get(keyAt).get(valueOf2) == null) {
                                str2 = str4;
                                a(dXRuntimeContext.getContext(), dXWidgetNode, keyAt, obj);
                            } else {
                                dXWidgetNode.setIntAttribute(keyAt, dXWidgetNode.getEnumMap().get(keyAt).get(valueOf2).intValue());
                                str2 = str4;
                            }
                        } else {
                            boolean z4 = obj != null;
                            if (c != s) {
                                z2 = z3;
                                if (c == 2) {
                                    str2 = str4;
                                    if (!z4) {
                                        g(dXWidgetNode, keyAt);
                                    } else {
                                        try {
                                            dXWidgetNode.setLongAttribute(keyAt, Long.parseLong(String.valueOf(obj)));
                                        } catch (Exception unused) {
                                            dXRuntimeContext.getDxError().c.add(new e.a(str2, "Pipeline_Stage_Parse_Widget", e.DXERROR_PIPELINE_PARSE_WT_LONG_EXCEPTION));
                                            Log.i("DXTemplateParser", jl1.ARRAY_START_STR + keyAt + "=" + obj + "] parse Long failed, use default value.");
                                            g(dXWidgetNode, keyAt);
                                        }
                                    }
                                } else if (c == 4) {
                                    str2 = str4;
                                    if (!z4) {
                                        d(dXWidgetNode, keyAt);
                                    } else {
                                        try {
                                            dXWidgetNode.setDoubleAttribute(keyAt, Double.parseDouble(String.valueOf(obj)));
                                        } catch (Exception unused2) {
                                            dXRuntimeContext.getDxError().c.add(new e.a(str2, "Pipeline_Stage_Parse_Widget", e.DXERROR_PIPELINE_PARSE_WT_DOUBLE_EXCEPTION));
                                            Log.i("DXTemplateParser", jl1.ARRAY_START_STR + keyAt + "=" + obj + "] parse Double failed, use default value.");
                                            d(dXWidgetNode, keyAt);
                                        }
                                    }
                                } else if (c == 8) {
                                    str2 = str4;
                                    if (!z4 || !(obj instanceof String)) {
                                        dXWidgetNode.setStringAttribute(keyAt, dXWidgetNode.getDefaultValueForStringAttr(keyAt));
                                    } else {
                                        dXWidgetNode.setStringAttribute(keyAt, (String) obj);
                                    }
                                } else if (c == 16) {
                                    str2 = str4;
                                    if (z4) {
                                        try {
                                            i4 = Color.parseColor(String.valueOf(obj));
                                        } catch (Exception unused3) {
                                            String str5 = "DXTemplateParser [" + keyAt + "=" + obj + "] parse Color failed, use default value.exprNode.toString()" + valueAt.toString();
                                            ry.t(str5);
                                            wz.b(str5);
                                            dXRuntimeContext.getDxError().c.add(new e.a(str2, "Pipeline_Stage_Parse_Widget", e.DXERROR_PIPELINE_PARSE_WT_COLOR_EXCEPTION, " color obj " + obj + "  log " + str5));
                                            i4 = dXWidgetNode.getDefaultValueForIntAttr(keyAt);
                                        }
                                    } else {
                                        i4 = dXWidgetNode.getDefaultValueForIntAttr(keyAt);
                                    }
                                    dXWidgetNode.setIntAttribute(keyAt, i4);
                                } else if (c == 32 || c == 64) {
                                    str2 = str4;
                                    a(dXRuntimeContext.getContext(), dXWidgetNode, keyAt, obj);
                                } else {
                                    if (c != 128) {
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
                                                String valueOf3 = String.valueOf(obj);
                                                if (dXWidgetNode.getEnumMap() == null || dXWidgetNode.getEnumMap().get(keyAt) == null || dXWidgetNode.getEnumMap().get(keyAt).get(valueOf3) == null) {
                                                    dXWidgetNode.setIntAttribute(keyAt, dXWidgetNode.getDefaultValueForIntAttr(keyAt));
                                                } else {
                                                    dXWidgetNode.setIntAttribute(keyAt, dXWidgetNode.getEnumMap().get(keyAt).get(valueOf3).intValue());
                                                }
                                            } else {
                                                dXWidgetNode.setIntAttribute(keyAt, dXWidgetNode.getDefaultValueForIntAttr(keyAt));
                                            }
                                        } else if (z4 && gx.b(dXRuntimeContext, obj)) {
                                            dXWidgetNode.setObjAttribute(keyAt, obj);
                                        } else if (!z4 || !(obj instanceof JSONObject)) {
                                            h(dXWidgetNode, keyAt);
                                        } else {
                                            try {
                                                dXWidgetNode.setMapAttribute(keyAt, (JSONObject) obj);
                                            } catch (Exception unused4) {
                                                dXRuntimeContext.getDxError().c.add(new e.a(str4, "Pipeline_Stage_Parse_Widget", e.DXERROR_PIPELINE_PARSE_WT_MAP_EXCEPTION));
                                                Log.i("DXTemplateParser", jl1.ARRAY_START_STR + keyAt + "=" + obj + "] parse JsonObject&Map failed, use default value.");
                                                h(dXWidgetNode, keyAt);
                                            }
                                        }
                                    } else if (z4 && gx.b(dXRuntimeContext, obj)) {
                                        dXWidgetNode.setUserDefinedListAttribute(keyAt, (List) obj);
                                    } else if (!z4 || !(obj instanceof JSONArray)) {
                                        f(dXWidgetNode, keyAt);
                                    } else {
                                        try {
                                            dXWidgetNode.setListAttribute(keyAt, (JSONArray) obj);
                                        } catch (Exception unused5) {
                                            dXRuntimeContext.getDxError().c.add(new e.a(str4, "Pipeline_Stage_Parse_Widget", e.DXERROR_PIPELINE_PARSE_WT_LIST_EXCEPTION));
                                            Log.i("DXTemplateParser", jl1.ARRAY_START_STR + keyAt + "=" + obj + "] parse JsonArray&List failed, use default value.");
                                            f(dXWidgetNode, keyAt);
                                        }
                                    }
                                    str2 = str4;
                                }
                            } else {
                                z2 = z3;
                                str2 = str4;
                                if (!z4) {
                                    e(dXWidgetNode, keyAt);
                                } else {
                                    try {
                                        dXWidgetNode.setIntAttribute(keyAt, Integer.parseInt(String.valueOf(obj)));
                                    } catch (Exception e8) {
                                        String str6 = "DXTemplateParser [" + keyAt + "=" + obj + "] parse Integer failed, use default value." + valueAt.toString();
                                        ry.t(str6);
                                        wz.b(str6);
                                        dXRuntimeContext.getDxError().c.add(new e.a(str2, "Pipeline_Stage_Parse_Widget", e.DXERROR_PIPELINE_PARSE_WT_INT_EXCEPTION, "recursiveParseWT log:" + str6 + " stack: " + vx.a(e8)));
                                        e(dXWidgetNode, keyAt);
                                    }
                                }
                            }
                        }
                    }
                    z2 = z3;
                }
                i2 = i3 + 1;
                str4 = str2;
                str3 = str;
                lxVar2 = lxVar;
                z3 = z2;
                i5 = e.DXERROR_PIPELINE_PARSE_WT_EXPR_EVALUEATE_EXCEPTION;
                j = 5802348655878590802L;
                s = 1;
            }
            z = z3;
            dXWidgetNode.setStatFlag(4);
        } else {
            z = z3;
        }
        dXWidgetNode.unsetStatFlag(1);
        dXWidgetNode.setStatFlag(2);
        if (!(dXWidgetNode instanceof DXTemplateWidgetNode)) {
            ((DXTemplateWidgetNode) dXWidgetNode).onProcessRemoteTemplate(0);
        }
        if (dXWidgetNode.getDXRuntimeContext() != null || !dXWidgetNode.getDXRuntimeContext().isRefreshPart()) {
            dXWidgetNode.setStatFlag(4096);
            dXWidgetNode.onBeforeBindChildData();
        } else if (z && !dXWidgetNode.getStatInPrivateFlags(4096)) {
            dXWidgetNode.setStatFlag(4096);
            dXWidgetNode.onBeforeBindChildData();
        }
        int direction2 = dXWidgetNode.getDirection();
        for (i = 0; i < dXWidgetNode.getChildrenCount(); i++) {
            DXWidgetNode childAt = dXWidgetNode.getChildAt(i);
            childAt.getDXRuntimeContext().setParentDirectionSpec(direction2);
            c(childAt, childAt.getDXRuntimeContext());
        }
        dXWidgetNode.endParser(z);
    }

    private void d(DXWidgetNode dXWidgetNode, long j) {
        dXWidgetNode.setDoubleAttribute(j, dXWidgetNode.getDefaultValueForDoubleAttr(j));
    }

    private void e(DXWidgetNode dXWidgetNode, long j) {
        dXWidgetNode.setIntAttribute(j, dXWidgetNode.getDefaultValueForIntAttr(j));
    }

    private void f(DXWidgetNode dXWidgetNode, long j) {
        dXWidgetNode.setListAttribute(j, dXWidgetNode.getDefaultValueForListAttr(j));
    }

    private void g(DXWidgetNode dXWidgetNode, long j) {
        dXWidgetNode.setLongAttribute(j, dXWidgetNode.getDefaultValueForLongAttr(j));
    }

    private void h(DXWidgetNode dXWidgetNode, long j) {
        dXWidgetNode.setMapAttribute(j, dXWidgetNode.getDefaultValueForMapAttr(j));
    }

    @Deprecated
    public DXWidgetNode b(DXWidgetNode dXWidgetNode, DXRuntimeContext dXRuntimeContext) {
        try {
            c(dXWidgetNode, dXRuntimeContext);
            return dXWidgetNode;
        } catch (Exception e) {
            vx.b(e);
            dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", e.DXERROR_PIPELINE_PARSE_WT_EXCEPTION, vx.a(e)));
            return null;
        }
    }
}
