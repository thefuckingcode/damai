package tb;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.alibaba.android.bindingx.core.BindingXEventType;
import com.alibaba.android.bindingx.plugin.android.NativeCallback;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.DXRootView;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.b;
import com.taobao.android.dinamicx.bindingx.DXBindingXViewUpdateManager;
import com.taobao.android.dinamicx.d;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.expression.event.bindingx.DXBindingXStateChangeEvent;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.monitor.DXTraceUtil;
import com.taobao.android.dinamicx.widget.DXTextViewWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.weex.ui.component.richtext.node.RichTextNode;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class os extends b {
    vg1 d;
    qs e;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements NativeCallback {
        final /* synthetic */ rs a;
        final /* synthetic */ DXRootView b;
        final /* synthetic */ DXWidgetNode c;

        a(rs rsVar, DXRootView dXRootView, DXWidgetNode dXWidgetNode) {
            this.a = rsVar;
            this.b = dXRootView;
            this.c = dXWidgetNode;
        }

        @Override // com.alibaba.android.bindingx.plugin.android.NativeCallback
        public void callback(Map<String, Object> map) {
            if (map != null) {
                String str = null;
                try {
                    if (DinamicXEngine.x()) {
                        ry.s(map.toString());
                    }
                    String str2 = (String) map.get("state");
                    String str3 = (String) map.get("token");
                    if ("exit".equals(str2)) {
                        if (DinamicXEngine.x()) {
                            ry.m("动画 " + this.a.a + "正常退出，收到bindingX  STATE_EXIT回调");
                        }
                        Map<String, Object> map2 = this.a.b;
                        if (map2 != null && ((String) map2.get("token")).equalsIgnoreCase(str3)) {
                            os.this.B(null, this.a);
                            rs rsVar = this.a;
                            if (!rsVar.i || !rsVar.c.equalsIgnoreCase(BindingXEventType.TYPE_TIMING)) {
                                rs rsVar2 = this.a;
                                if (rsVar2.d) {
                                    os.this.y(this.c, rsVar2, 2, rsVar2.g);
                                } else {
                                    os.this.y(this.c, rsVar2, 1, rsVar2.g);
                                }
                                os.this.s(this.b, this.c, this.a);
                                os.this.l(this.c, DXBindingXStateChangeEvent.DXVIEWWIDGETNODE_ONBINDINGXFINISH, this.a.a);
                                return;
                            }
                            os.this.f(this.b, this.a, this.c);
                        }
                    } else if ("start".equalsIgnoreCase(str2)) {
                        if (DinamicXEngine.x()) {
                            ry.m("step3 -->  动画 " + this.a.a + "启动成功，收到bindingX  STATE_START回调");
                        }
                        if (this.a.c.equalsIgnoreCase(BindingXEventType.TYPE_TIMING)) {
                            os.this.l(this.c, DXBindingXStateChangeEvent.DXVIEWWIDGETNODE_ONBINDINGXSTART, this.a.a);
                        }
                    } else if ("end".equalsIgnoreCase(str2)) {
                        if (DinamicXEngine.x()) {
                            ry.m("动画 " + this.a.a + "手动退出，收到bindingX  STATE_END回调");
                        }
                    } else if ("scrollStart".equalsIgnoreCase(str2)) {
                        os.this.l(this.c, DXBindingXStateChangeEvent.DXVIEWWIDGETNODE_ONBINDINGXSTART, this.a.a);
                    } else if ("scrollEnd".equalsIgnoreCase(str2)) {
                        JSONObject jSONObject = this.a.l;
                        if (jSONObject == null || jSONObject.isEmpty()) {
                            rs rsVar3 = this.a;
                            if (rsVar3.d) {
                                os.this.y(this.c, rsVar3, 2, rsVar3.g);
                            } else {
                                os.this.y(this.c, rsVar3, 1, rsVar3.g);
                            }
                        }
                        os.this.l(this.c, DXBindingXStateChangeEvent.DXVIEWWIDGETNODE_ONBINDINGXSTOP, this.a.a);
                    }
                } catch (Throwable th) {
                    vx.b(th);
                    DXWidgetNode dXWidgetNode = this.c;
                    if (!(dXWidgetNode == null || dXWidgetNode.getDXRuntimeContext() == null)) {
                        str = this.c.getDXRuntimeContext().getBizType();
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = v00.DB_NAME;
                    }
                    DXAppMonitor.q(str, null, "DX_BindingX", "DX_BindingX_Crash", e.BINDINGX_BINDINGX_CALL_BACK_CRASH, vx.a(th));
                }
            }
        }
    }

    public os(@NonNull d dVar) {
        super(dVar);
        ps psVar = new ps();
        DXBindingXViewUpdateManager dXBindingXViewUpdateManager = new DXBindingXViewUpdateManager();
        qs qsVar = new qs();
        this.e = qsVar;
        this.d = vg1.b(psVar, null, dXBindingXViewUpdateManager, qsVar);
    }

    private void A(DXRootView dXRootView, DXWidgetNode dXWidgetNode, rs rsVar, boolean z, boolean z2, boolean z3) {
        Map<String, Object> map;
        if (rsVar != null && (map = rsVar.b) != null) {
            this.d.e(map);
            B(null, rsVar);
            if (z2) {
                y(dXWidgetNode, rsVar, 2, z3);
            } else {
                y(dXWidgetNode, rsVar, 1, z3);
            }
            if (z) {
                s(dXRootView, dXWidgetNode, rsVar);
            }
            if (BindingXEventType.TYPE_TIMING.equalsIgnoreCase(rsVar.c)) {
                l(dXWidgetNode, DXBindingXStateChangeEvent.DXVIEWWIDGETNODE_ONBINDINGXSTOP, rsVar.a);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void B(Map<String, Object> map, rs rsVar) {
        rsVar.b = map;
    }

    private DXWidgetNode h(DXWidgetNode dXWidgetNode) {
        if (dXWidgetNode == null) {
            return null;
        }
        if (dXWidgetNode.isFlatten()) {
            return dXWidgetNode;
        }
        return dXWidgetNode.getReferenceNode();
    }

    private String i(String str, JSONArray jSONArray) {
        if (("msg :action: " + str + "  spec: " + jSONArray) == null) {
            return " spec is null";
        }
        return JSON.toJSONString(jSONArray);
    }

    private boolean j(JSONObject jSONObject) {
        String string = jSONObject.getString("property");
        return "transform.translate".equals(string) || "transform.translateX".equals(string) || "transform.translateY".equals(string) || "width".equals(string) || "height".equals(string);
    }

    private Object n(Map<String, Object> map, String str, String str2) {
        if (str.length() < 2) {
            return str;
        }
        String substring = str.substring(1);
        if (map == null || !map.containsKey(substring)) {
            return "";
        }
        Object obj = map.get(substring);
        if (!"StringLiteral".equals(str2) || str.startsWith("'")) {
            return obj;
        }
        return "'" + obj + "'";
    }

    private void o(DXWidgetNode dXWidgetNode, JSONObject jSONObject, int i, boolean z) {
        DXWidgetNode dXWidgetNode2;
        ViewGroup.LayoutParams layoutParams;
        View nativeView;
        ViewGroup.LayoutParams layoutParams2;
        ViewGroup.LayoutParams layoutParams3;
        View nativeView2;
        ViewGroup.LayoutParams layoutParams4;
        View nativeView3;
        Drawable background;
        View nativeView4;
        View nativeView5;
        View nativeView6;
        View nativeView7;
        View nativeView8;
        View nativeView9;
        View nativeView10;
        View nativeView11;
        View nativeView12;
        View nativeView13;
        View nativeView14;
        String string = jSONObject.getString("property");
        if (!TextUtils.isEmpty(string)) {
            DXWidgetNode dXWidgetNode3 = null;
            WeakReference weakReference = (WeakReference) jSONObject.get("element_widgetnode");
            if (weakReference == null || weakReference.get() == null) {
                String u = u(jSONObject.getString("element"));
                if ("this".equalsIgnoreCase(u)) {
                    dXWidgetNode3 = dXWidgetNode;
                } else if (!at.P0(dXWidgetNode.getDXRuntimeContext())) {
                    dXWidgetNode3 = dXWidgetNode.queryWTByUserId(u);
                }
                dXWidgetNode2 = dXWidgetNode3 == null ? dXWidgetNode.queryWidgetNodeByUserId(u) : dXWidgetNode3;
                if (dXWidgetNode2 != null) {
                    jSONObject.put("element_widgetnode", (Object) new WeakReference(dXWidgetNode2));
                } else {
                    return;
                }
            } else {
                dXWidgetNode2 = (DXWidgetNode) weakReference.get();
            }
            if ("opacity".equals(string)) {
                if (i == 1) {
                    View nativeView15 = dXWidgetNode2.getDXRuntimeContext().getNativeView();
                    if (nativeView15 != null) {
                        if (!z) {
                            dXWidgetNode2.setAlpha(nativeView15.getAlpha());
                        }
                        DXWidgetNode h = h(dXWidgetNode2);
                        if (h != null) {
                            h.setAlpha(nativeView15.getAlpha());
                        }
                    }
                } else if (i == 2 && (nativeView14 = dXWidgetNode2.getDXRuntimeContext().getNativeView()) != null) {
                    nativeView14.setAlpha(dXWidgetNode2.getAlpha());
                }
            } else if ("transform.translate".equals(string)) {
                if (i == 1) {
                    View nativeView16 = dXWidgetNode2.getDXRuntimeContext().getNativeView();
                    if (nativeView16 != null) {
                        float translationX = nativeView16.getTranslationX();
                        float translationY = nativeView16.getTranslationY();
                        if (!z) {
                            dXWidgetNode2.setTranslateX(translationX);
                            dXWidgetNode2.setTranslateY(translationY);
                        }
                        DXWidgetNode h2 = h(dXWidgetNode2);
                        if (h2 != null) {
                            h2.setTranslateX(translationX);
                            h2.setTranslateY(translationY);
                        }
                    }
                } else if (i == 2 && (nativeView13 = dXWidgetNode2.getDXRuntimeContext().getNativeView()) != null) {
                    nativeView13.setTranslationX(dXWidgetNode2.getTranslateX());
                    nativeView13.setTranslationY(dXWidgetNode2.getTranslateY());
                }
            } else if ("transform.translateX".equals(string)) {
                if (i == 1) {
                    View nativeView17 = dXWidgetNode2.getDXRuntimeContext().getNativeView();
                    if (nativeView17 != null) {
                        float translationX2 = nativeView17.getTranslationX();
                        if (!z) {
                            dXWidgetNode2.setTranslateX(translationX2);
                        }
                        DXWidgetNode h3 = h(dXWidgetNode2);
                        if (h3 != null) {
                            h3.setTranslateX(translationX2);
                        }
                    }
                } else if (i == 2 && (nativeView12 = dXWidgetNode2.getDXRuntimeContext().getNativeView()) != null) {
                    nativeView12.setTranslationX(dXWidgetNode2.getTranslateX());
                }
            } else if ("transform.translateY".equals(string)) {
                if (i == 1) {
                    View nativeView18 = dXWidgetNode2.getDXRuntimeContext().getNativeView();
                    if (nativeView18 != null) {
                        float translationY2 = nativeView18.getTranslationY();
                        if (!z) {
                            dXWidgetNode2.setTranslateY(translationY2);
                        }
                        DXWidgetNode h4 = h(dXWidgetNode2);
                        if (h4 != null) {
                            h4.setTranslateY(translationY2);
                        }
                    }
                } else if (i == 2 && (nativeView11 = dXWidgetNode2.getDXRuntimeContext().getNativeView()) != null) {
                    nativeView11.setTranslationY(dXWidgetNode2.getTranslateY());
                }
            } else if ("transform.scale".equals(string)) {
                if (i == 1) {
                    View nativeView19 = dXWidgetNode2.getDXRuntimeContext().getNativeView();
                    if (nativeView19 != null) {
                        float scaleX = nativeView19.getScaleX();
                        float scaleY = nativeView19.getScaleY();
                        if (!z) {
                            dXWidgetNode2.setScaleX(scaleX);
                            dXWidgetNode2.setScaleY(scaleY);
                        }
                        DXWidgetNode h5 = h(dXWidgetNode2);
                        if (h5 != null) {
                            h5.setScaleX(scaleX);
                            h5.setScaleY(scaleY);
                        }
                    }
                } else if (i == 2 && (nativeView10 = dXWidgetNode2.getDXRuntimeContext().getNativeView()) != null) {
                    nativeView10.setScaleX(dXWidgetNode2.getScaleX());
                    nativeView10.setScaleY(dXWidgetNode2.getScaleY());
                }
            } else if ("transform.scaleX".equals(string)) {
                if (i == 1) {
                    View nativeView20 = dXWidgetNode2.getDXRuntimeContext().getNativeView();
                    if (nativeView20 != null) {
                        float scaleX2 = nativeView20.getScaleX();
                        if (!z) {
                            dXWidgetNode2.setScaleX(scaleX2);
                        }
                        DXWidgetNode h6 = h(dXWidgetNode2);
                        if (h6 != null) {
                            h6.setScaleX(scaleX2);
                        }
                    }
                } else if (i == 2 && (nativeView9 = dXWidgetNode2.getDXRuntimeContext().getNativeView()) != null) {
                    nativeView9.setScaleX(dXWidgetNode2.getScaleX());
                }
            } else if ("transform.scaleY".equals(string)) {
                if (i == 1) {
                    View nativeView21 = dXWidgetNode2.getDXRuntimeContext().getNativeView();
                    if (nativeView21 != null) {
                        float scaleY2 = nativeView21.getScaleY();
                        if (!z) {
                            dXWidgetNode2.setScaleY(scaleY2);
                        }
                        DXWidgetNode h7 = h(dXWidgetNode2);
                        if (h7 != null) {
                            h7.setScaleY(scaleY2);
                        }
                    }
                } else if (i == 2 && (nativeView8 = dXWidgetNode2.getDXRuntimeContext().getNativeView()) != null) {
                    nativeView8.setScaleY(dXWidgetNode2.getScaleY());
                }
            } else if ("transform.rotateX".equals(string)) {
                if (i == 1) {
                    View nativeView22 = dXWidgetNode2.getDXRuntimeContext().getNativeView();
                    if (nativeView22 != null) {
                        float rotationX = nativeView22.getRotationX();
                        if (!z) {
                            dXWidgetNode2.setRotationX(rotationX);
                        }
                        DXWidgetNode h8 = h(dXWidgetNode2);
                        if (h8 != null) {
                            h8.setRotationX(rotationX);
                        }
                    }
                } else if (i == 2 && (nativeView7 = dXWidgetNode2.getDXRuntimeContext().getNativeView()) != null) {
                    nativeView7.setRotationX(dXWidgetNode2.getRotationX());
                }
            } else if ("transform.rotateY".equals(string)) {
                if (i == 1) {
                    View nativeView23 = dXWidgetNode2.getDXRuntimeContext().getNativeView();
                    if (nativeView23 != null) {
                        float rotationY = nativeView23.getRotationY();
                        if (!z) {
                            dXWidgetNode2.setRotationY(rotationY);
                        }
                        DXWidgetNode h9 = h(dXWidgetNode2);
                        if (h9 != null) {
                            h9.setRotationY(rotationY);
                        }
                    }
                } else if (i == 2 && (nativeView6 = dXWidgetNode2.getDXRuntimeContext().getNativeView()) != null) {
                    nativeView6.setRotationY(dXWidgetNode2.getRotationY());
                }
            } else if ("transform.rotateZ".equals(string)) {
                if (i == 1) {
                    View nativeView24 = dXWidgetNode2.getDXRuntimeContext().getNativeView();
                    if (nativeView24 != null) {
                        float rotation = nativeView24.getRotation();
                        if (!z) {
                            dXWidgetNode2.setRotationZ(rotation);
                        }
                        DXWidgetNode h10 = h(dXWidgetNode2);
                        if (h10 != null) {
                            h10.setRotationZ(rotation);
                        }
                    }
                } else if (i == 2 && (nativeView5 = dXWidgetNode2.getDXRuntimeContext().getNativeView()) != null) {
                    nativeView5.setRotation(dXWidgetNode2.getRotationZ());
                }
            } else if ("background-color".equals(string)) {
                if (i == 1) {
                    View nativeView25 = dXWidgetNode2.getDXRuntimeContext().getNativeView();
                    if (nativeView25 != null && (background = nativeView25.getBackground()) != null && (background instanceof ColorDrawable)) {
                        if (!z) {
                            dXWidgetNode2.setBackGroundColor(((ColorDrawable) background).getColor());
                        }
                        DXWidgetNode h11 = h(dXWidgetNode2);
                        if (h11 != null) {
                            h11.setBackGroundColor(((ColorDrawable) background).getColor());
                        }
                    }
                } else if (i == 2 && (nativeView4 = dXWidgetNode2.getDXRuntimeContext().getNativeView()) != null) {
                    nativeView4.setBackgroundColor(dXWidgetNode2.getBackGroundColor());
                }
            } else if ("color".equals(string)) {
                if (dXWidgetNode2 instanceof DXTextViewWidgetNode) {
                    if (i == 1) {
                        View nativeView26 = dXWidgetNode2.getDXRuntimeContext().getNativeView();
                        if (nativeView26 != null && (nativeView26 instanceof TextView)) {
                            int currentTextColor = ((TextView) nativeView26).getCurrentTextColor();
                            if (!z) {
                                ((DXTextViewWidgetNode) dXWidgetNode2).u(currentTextColor);
                            }
                            DXWidgetNode h12 = h(dXWidgetNode2);
                            if (h12 != null && (h12 instanceof DXTextViewWidgetNode)) {
                                ((DXTextViewWidgetNode) h12).u(currentTextColor);
                            }
                        }
                    } else if (i == 2 && (nativeView3 = dXWidgetNode2.getDXRuntimeContext().getNativeView()) != null && (nativeView3 instanceof TextView)) {
                        ((TextView) nativeView3).setTextColor(((DXTextViewWidgetNode) dXWidgetNode2).g());
                    }
                }
            } else if ("width".equals(string)) {
                if (i == 1) {
                    View nativeView27 = dXWidgetNode2.getDXRuntimeContext().getNativeView();
                    if (nativeView27 != null && (layoutParams3 = nativeView27.getLayoutParams()) != null) {
                        int i2 = layoutParams3.width;
                        if (!z) {
                            dXWidgetNode2.setMeasuredDimension(i2, dXWidgetNode2.getMeasuredHeight());
                        }
                        DXWidgetNode h13 = h(dXWidgetNode2);
                        if (h13 != null) {
                            h13.setMeasuredDimension(i2, h13.getMeasuredHeight());
                        }
                    }
                } else if (i == 2 && (nativeView2 = dXWidgetNode2.getDXRuntimeContext().getNativeView()) != null && (layoutParams4 = nativeView2.getLayoutParams()) != null) {
                    layoutParams4.width = dXWidgetNode2.getMeasuredWidth();
                    nativeView2.setLayoutParams(layoutParams4);
                }
            } else if (!"height".equals(string)) {
            } else {
                if (i == 1) {
                    View nativeView28 = dXWidgetNode2.getDXRuntimeContext().getNativeView();
                    if (nativeView28 != null && (layoutParams = nativeView28.getLayoutParams()) != null) {
                        int i3 = layoutParams.height;
                        if (!z) {
                            dXWidgetNode2.setMeasuredDimension(dXWidgetNode2.getMeasuredWidth(), i3);
                        }
                        DXWidgetNode h14 = h(dXWidgetNode2);
                        if (h14 != null) {
                            h14.setMeasuredDimension(h14.getMeasuredWidth(), i3);
                        }
                    }
                } else if (i == 2 && (nativeView = dXWidgetNode2.getDXRuntimeContext().getNativeView()) != null && (layoutParams2 = nativeView.getLayoutParams()) != null) {
                    layoutParams2.height = dXWidgetNode2.getMeasuredHeight();
                    nativeView.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    private void p(JSONObject jSONObject, String str) {
        if (jSONObject != null && this.e != null) {
            String string = jSONObject.getString("sourceId");
            int i = 0;
            if (DinamicXEngine.x()) {
                ry.m("step1--> 收到scroller bindingx消息:  action " + str + " sourceId " + string);
            }
            int intValue = jSONObject.containsKey("offsetX") ? jSONObject.getInteger("offsetX").intValue() : 0;
            if (jSONObject.containsKey("offsetY")) {
                i = jSONObject.getInteger("offsetY").intValue();
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("args");
            if ("scroll_beigin".equalsIgnoreCase(str)) {
                this.e.c(string, intValue, i, jSONObject2);
            } else if ("scrolling".equalsIgnoreCase(str)) {
                this.e.d(string, intValue, i, jSONObject2);
            } else if ("scroll_end".equalsIgnoreCase(str)) {
                this.e.b(string, intValue, i, jSONObject2);
            }
        }
    }

    private void q(rs rsVar, Map<String, Object> map) {
        JSONArray jSONArray = rsVar.j;
        if (jSONArray != null) {
            int size = jSONArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                z(jSONObject.getJSONObject(DXTraceUtil.TYPE_EXPRESSION_STRING).getJSONObject("transformed"), map, j(jSONObject));
            }
        }
        JSONObject jSONObject2 = rsVar.l;
        if (jSONObject2 != null) {
            z(jSONObject2.getJSONObject("transformed"), map, false);
        }
    }

    private void r(DXRootView dXRootView, DXWidgetNode dXWidgetNode, rs rsVar) {
        if (dXRootView != null && dXWidgetNode != null && rsVar != null) {
            dXWidgetNode.putBindingXExecutingSpec(rsVar);
            dXRootView._addAnimationWidget(dXWidgetNode);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void s(DXRootView dXRootView, DXWidgetNode dXWidgetNode, rs rsVar) {
        if (dXRootView != null && dXWidgetNode != null && rsVar != null) {
            dXWidgetNode.removeBindingXSpec(rsVar);
            if (!dXWidgetNode.hasExecutingAnimationSpec()) {
                dXRootView._removeAnimationWidget(dXWidgetNode);
            }
        }
    }

    public static String u(String str) {
        return (TextUtils.isEmpty(str) || !str.startsWith(o70.DINAMIC_PREFIX_AT)) ? str : str.substring(1);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void y(DXWidgetNode dXWidgetNode, rs rsVar, int i, boolean z) {
        JSONArray jSONArray = rsVar.j;
        int size = jSONArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            o(dXWidgetNode, jSONArray.getJSONObject(i2), i, z);
        }
    }

    private void z(JSONObject jSONObject, Map<String, Object> map, boolean z) {
        int i;
        if (jSONObject != null) {
            String string = jSONObject.getString("type");
            Object obj = jSONObject.get("value");
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.startsWith("$")) {
                    obj = n(map, str, string);
                }
            }
            if (z) {
                try {
                    if ("NumericLiteral".equals(string) && (obj instanceof String)) {
                        String str2 = (String) obj;
                        if (str2.endsWith("ap")) {
                            obj = Integer.valueOf(d00.b(DinamicXEngine.i(), Float.parseFloat(str2.substring(0, str2.length() - 2))));
                        } else if (((String) obj).endsWith(f80.DIMEN_SUFFIX_NP)) {
                            obj = Integer.valueOf(d00.c(DinamicXEngine.i(), Float.parseFloat(str2.substring(0, str2.length() - 2))));
                        }
                    }
                } catch (Throwable th) {
                    vx.b(th);
                    i = 0;
                }
            }
            i = obj;
            jSONObject.put("value", i);
            JSONArray jSONArray = jSONObject.getJSONArray(RichTextNode.CHILDREN);
            if (jSONArray != null && jSONArray.size() > 0) {
                for (int i2 = 0; i2 < jSONArray.size(); i2++) {
                    z(jSONArray.getJSONObject(i2), map, z);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f(DXRootView dXRootView, rs rsVar, DXWidgetNode dXWidgetNode) {
        View nativeView = dXWidgetNode.getDXRuntimeContext().getNativeView();
        if (nativeView != null) {
            nativeView.setTag(kz.b, dXWidgetNode);
        }
        if (DinamicXEngine.x()) {
            ry.m("step2.1 -->  开始进入启动动画 " + rsVar.a + "的bindAnimation阶段");
        }
        Map<String, Object> a2 = this.d.a(nativeView, rsVar.k, new a(rsVar, dXRootView, dXWidgetNode));
        if (a2 != null && !a2.isEmpty()) {
            B(a2, rsVar);
            r(dXRootView, dXWidgetNode, rsVar);
        }
    }

    public vg1 g() {
        return this.d;
    }

    public rs k(String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (jSONObject = JSON.parseObject(str2).getJSONObject(str)) == null) {
            return null;
        }
        rs rsVar = new rs();
        rsVar.a = str;
        rsVar.c = jSONObject.getString("eventType");
        rsVar.k = jSONObject;
        rsVar.h = "true".equalsIgnoreCase(jSONObject.getString("useConstantArgs"));
        if (map == null || !map.containsKey("resetOnStop")) {
            str3 = jSONObject.getString("resetOnStop");
        } else {
            str3 = (String) map.get("resetOnStop");
        }
        if (!TextUtils.isEmpty(str3)) {
            rsVar.e = !str3.equalsIgnoreCase("false");
        }
        if (map == null || !map.containsKey("resetOnFinish")) {
            str4 = jSONObject.getString("resetOnFinish");
        } else {
            str4 = (String) map.get("resetOnFinish");
        }
        if (!TextUtils.isEmpty(str4)) {
            rsVar.d = !str4.equalsIgnoreCase("false");
        }
        if (!rsVar.e) {
            if (map == null || !map.containsKey("updateFlattenOnlyOnStop")) {
                str7 = jSONObject.getString("updateFlattenOnlyOnStop");
            } else {
                str7 = (String) map.get("updateFlattenOnlyOnStop");
            }
            if (!TextUtils.isEmpty(str7)) {
                rsVar.f = "true".equalsIgnoreCase(str7);
            }
        }
        if (!rsVar.d) {
            if (map == null || !map.containsKey("updateFlattenOnlyOnFinish")) {
                str6 = jSONObject.getString("updateFlattenOnlyOnFinish");
            } else {
                str6 = (String) map.get("updateFlattenOnlyOnFinish");
            }
            if (!TextUtils.isEmpty(str6)) {
                rsVar.g = "true".equalsIgnoreCase(str6);
            }
        }
        if (map == null || !map.containsKey("repeat")) {
            str5 = jSONObject.getString("repeat");
        } else {
            str5 = (String) map.get("repeat");
        }
        if (!TextUtils.isEmpty(str5)) {
            rsVar.i = str5.equals("true");
        }
        rsVar.j = jSONObject.getJSONArray("props");
        rsVar.l = jSONObject.getJSONObject("exitExpression");
        q(rsVar, map);
        return rsVar;
    }

    /* access modifiers changed from: package-private */
    public void l(DXWidgetNode dXWidgetNode, long j, String str) {
        if (dXWidgetNode != null) {
            dXWidgetNode.postEvent(new DXBindingXStateChangeEvent(j, str));
        }
    }

    public void m(DXRootView dXRootView, JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (this.d != null && jSONObject != null && (jSONObject2 = jSONObject.getJSONObject("params")) != null) {
            String string = jSONObject2.getString("action");
            if ("scrolling".equalsIgnoreCase(string) || "scroll_beigin".equalsIgnoreCase(string) || "scroll_end".equalsIgnoreCase(string)) {
                p(jSONObject2, string);
            } else if (dXRootView == null) {
                ry.o("processDXMsg timing动画，必须要有rootview");
            } else {
                JSONArray jSONArray = jSONObject2.getJSONArray("spec");
                if (DinamicXEngine.x()) {
                    ry.m("step1--> 收到bindingx消息: " + i(string, jSONArray));
                }
                Object obj = jSONObject2.get("widget");
                if (obj instanceof DXWidgetNode) {
                    DXWidgetNode dXWidgetNode = (DXWidgetNode) obj;
                    if (ss.b(dXWidgetNode) == dXRootView.getExpandWidgetNode()) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("args");
                        if ("start".equalsIgnoreCase(string)) {
                            v(dXRootView, dXWidgetNode, jSONArray, jSONObject3);
                        } else if ("stop".equalsIgnoreCase(string)) {
                            x(dXRootView, dXWidgetNode, jSONArray);
                        }
                    } else if (DinamicXEngine.x()) {
                        ry.o("rootView 被复用 动画操作失败" + i(string, jSONArray));
                    }
                }
            }
        }
    }

    public void t(DXRootView dXRootView) {
        List<DXWidgetNode> _getAnimationWidgets;
        if (!(dXRootView == null || (_getAnimationWidgets = dXRootView._getAnimationWidgets()) == null || _getAnimationWidgets.isEmpty())) {
            for (DXWidgetNode dXWidgetNode : _getAnimationWidgets) {
                Map<String, rs> bindingXExecutingMap = dXWidgetNode.getBindingXExecutingMap();
                if (bindingXExecutingMap != null && bindingXExecutingMap.size() > 0) {
                    for (rs rsVar : bindingXExecutingMap.values()) {
                        A(dXRootView, dXWidgetNode, rsVar, false, true, false);
                    }
                    bindingXExecutingMap.clear();
                }
            }
            dXRootView._clearAnimationWidgets();
        }
    }

    public void v(DXRootView dXRootView, DXWidgetNode dXWidgetNode, JSONArray jSONArray, Map<String, Object> map) {
        if (!(jSONArray == null || jSONArray.isEmpty())) {
            for (int i = 0; i < jSONArray.size(); i++) {
                String string = jSONArray.getString(i);
                if (DinamicXEngine.x()) {
                    ry.m("step2---> 开始启动" + string + "动画");
                }
                w(dXRootView, dXWidgetNode, string, map);
            }
        }
    }

    public void w(DXRootView dXRootView, DXWidgetNode dXWidgetNode, String str, Map<String, Object> map) {
        rs rsVar;
        if (dXWidgetNode == null) {
            ry.o("启动" + str + "动画失败 原因为animationWidget == null");
            return;
        }
        DXWidgetNode queryRootWidgetNode = dXWidgetNode.queryRootWidgetNode();
        if (dXRootView == null || this.d == null || TextUtils.isEmpty(queryRootWidgetNode.getAnimation()) || queryRootWidgetNode.getDXRuntimeContext() == null || TextUtils.isEmpty(str)) {
            if (DinamicXEngine.x()) {
                ry.o("启动" + str + "动画失败 原因为rootView == null || animationWidget == null || bindingX == null\n                || TextUtils.isEmpty(rootWidget.getAnimation())\n                || rootWidget.getDXRuntimeContext() == null\n                || TextUtils.isEmpty(specName)");
            }
        } else if (!dXWidgetNode.containsExecutingAnimationSpec(str)) {
            rs rsVar2 = null;
            Map<String, rs> bindingXSpecMap = dXWidgetNode.getBindingXSpecMap();
            if (!(bindingXSpecMap == null || (rsVar = bindingXSpecMap.get(str)) == null || (!rsVar.h && map != null && !map.isEmpty()))) {
                rsVar2 = rsVar;
            }
            if (rsVar2 == null) {
                rsVar2 = k(str, queryRootWidgetNode.getAnimation(), map);
            }
            if (rsVar2 != null) {
                if (bindingXSpecMap == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(str, rsVar2);
                    dXWidgetNode.setBindingXSpecMap(hashMap);
                } else {
                    bindingXSpecMap.put(str, rsVar2);
                }
                if (rsVar2.b == null) {
                    f(dXRootView, rsVar2, dXWidgetNode);
                } else if (DinamicXEngine.x()) {
                    ry.o("启动" + str + "动画失败  当前动画已经在运行");
                }
            } else if (DinamicXEngine.x()) {
                ry.o("启动" + str + "动画失败 原因为对应的动画描述是空 请检查对应的bindingx.json是否有误");
            }
        } else if (DinamicXEngine.x()) {
            ry.o("启动" + str + "动画失败 原因为animationWidget.containsExecutingAnimationSpec(specName)");
        }
    }

    public void x(DXRootView dXRootView, DXWidgetNode dXWidgetNode, JSONArray jSONArray) {
        Map<String, rs> bindingXExecutingMap;
        if (!(this.d == null || dXWidgetNode.getDXRuntimeContext() == null || dXRootView == null || !dXRootView._containAnimationWidget(dXWidgetNode) || (bindingXExecutingMap = dXWidgetNode.getBindingXExecutingMap()) == null || bindingXExecutingMap.isEmpty())) {
            if (jSONArray == null || jSONArray.isEmpty()) {
                for (rs rsVar : bindingXExecutingMap.values()) {
                    if (rsVar != null) {
                        A(dXRootView, dXWidgetNode, rsVar, false, rsVar.e, rsVar.f);
                    }
                }
                bindingXExecutingMap.clear();
                dXRootView._removeAnimationWidget(dXWidgetNode);
                return;
            }
            for (int i = 0; i < jSONArray.size(); i++) {
                rs rsVar2 = bindingXExecutingMap.get(jSONArray.getString(i));
                if (rsVar2 != null) {
                    A(dXRootView, dXWidgetNode, rsVar2, true, rsVar2.e, rsVar2.f);
                }
            }
        }
    }
}
