package com.alibaba.gaiax.studio;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.studio.third.socket.java_websocket.framing.Framedata;
import com.alibaba.gaiax.studio.third.socket.websocket.SocketListener;
import com.alibaba.gaiax.studio.third.socket.websocket.b;
import com.taobao.orange.OConstant;
import java.nio.ByteBuffer;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ez2;
import tb.ie0;
import tb.jl1;
import tb.k21;
import tb.m40;
import tb.rq0;

/* compiled from: Taobao */
public final class GXSocket implements SocketListener {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String TAG = "[GaiaX][FastPreview]";
    private boolean a;
    @Nullable
    private GXSocketListener b;
    @Nullable
    private Runnable c;
    @Nullable
    private String d;
    private int e;
    @Nullable
    private String f;
    @Nullable
    private JSONObject g;
    @Nullable
    private b h;
    @Nullable
    private ez2 i;
    @Nullable
    private String j;
    @NotNull
    private final Handler k = new Handler(Looper.getMainLooper());

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bH&¨\u0006\r"}, d2 = {"Lcom/alibaba/gaiax/studio/GXSocket$GXSocketListener;", "", "Ltb/ur2;", "onSocketDisconnected", "onSocketConnected", "onStudioConnected", "", "templateId", "Lcom/alibaba/fastjson/JSONObject;", "templateData", "onStudioAddData", "templateJson", "onStudioUpdate", "GaiaXAndroidClientToStudio_release"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface GXSocketListener {
        void onSocketConnected();

        void onSocketDisconnected();

        void onStudioAddData(@NotNull String str, @NotNull JSONObject jSONObject);

        void onStudioConnected();

        void onStudioUpdate(@NotNull String str, @NotNull JSONObject jSONObject);
    }

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    private final JSONObject c(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        String string = jSONObject.getString("index.json");
        String string2 = jSONObject.getString("index.css");
        String string3 = jSONObject.getString("index.js");
        String string4 = jSONObject.getString("index.databinding");
        String string5 = jSONObject.getString("index.mock");
        String string6 = jSONObject.getString("index.data");
        if (string5 != null) {
            jSONObject2.put((Object) "index.mock", (Object) JSON.parseObject(string5));
        }
        if (!k21.d("{}", string4) && string5 != null) {
            jSONObject2.put((Object) "index.databinding", (Object) string4);
        } else if (string6 != null) {
            JSONObject parseObject = JSON.parseObject(string);
            JSONObject jSONObject3 = new JSONObject();
            if (parseObject.containsKey("sub-type")) {
                String string7 = parseObject.getString("id");
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put((Object) string7, (Object) "${nodes}");
                jSONObject3.put((Object) "data", (Object) jSONObject4);
                jSONObject2.put((Object) "index.databinding", (Object) jSONObject3);
                JSONObject jSONObject5 = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                jSONArray.add(new JSONObject());
                jSONArray.add(new JSONObject());
                jSONArray.add(new JSONObject());
                jSONArray.add(new JSONObject());
                jSONArray.add(new JSONObject());
                jSONObject5.put((Object) "nodes", (Object) jSONArray);
                jSONObject2.put((Object) "index.mock", (Object) jSONObject5);
            } else {
                jSONObject3.put((Object) "data", (Object) string6);
                jSONObject2.put((Object) "index.databinding", (Object) jSONObject3);
            }
        }
        jSONObject2.put((Object) "index.json", (Object) JSON.parseObject(string));
        jSONObject2.put((Object) "index.css", (Object) string2);
        jSONObject2.put((Object) "index.js", (Object) string3);
        return jSONObject2;
    }

    /* access modifiers changed from: private */
    public static final void i(GXSocket gXSocket, String str, JSONObject jSONObject) {
        k21.i(gXSocket, "this$0");
        k21.i(jSONObject, "$templateJson");
        GXSocketListener f2 = gXSocket.f();
        if (f2 != null) {
            k21.h(str, "templateId");
            f2.onStudioUpdate(str, jSONObject);
        }
    }

    private final void k(String str) {
        Log.e(TAG, k21.r("sendGetTemplateData104() called with: templateId = ", str));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((Object) "jsonrpc", (Object) "2.0");
        jSONObject.put((Object) "method", (Object) "template/getTemplateData");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put((Object) "id", (Object) str);
        jSONObject.put((Object) "params", (Object) jSONObject2);
        jSONObject.put((Object) "id", (Object) 104);
        com.alibaba.gaiax.studio.third.socket.websocket.a.f("GaiaXSocket").q(jSONObject.toJSONString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0019  */
    public final void b(@Nullable String str) {
        boolean z;
        this.j = str;
        if (str != null) {
            if (str != null) {
                if (str.length() == 0) {
                    z = true;
                    if (!z) {
                        this.a = true;
                        ez2 ez2 = new ez2();
                        this.i = ez2;
                        ez2.m(this.j);
                        ez2 ez22 = this.i;
                        if (ez22 != null) {
                            ez22.l(15000);
                        }
                        ez2 ez23 = this.i;
                        if (ez23 != null) {
                            ez23.n(0);
                        }
                        ez2 ez24 = this.i;
                        if (ez24 != null) {
                            ez24.o(1);
                        }
                        ez2 ez25 = this.i;
                        if (ez25 != null) {
                            ez25.p(true);
                        }
                        com.alibaba.gaiax.studio.third.socket.websocket.a.h(GXClientToStudio.Companion.a().j());
                        b g2 = com.alibaba.gaiax.studio.third.socket.websocket.a.g("GaiaXSocket", this.i);
                        this.h = g2;
                        if (g2 != null) {
                            g2.h(this);
                            return;
                        }
                        return;
                    }
                }
            }
            z = false;
            if (!z) {
            }
        }
        this.a = false;
    }

    public final void d() {
        if (this.a) {
            b bVar = this.h;
            if (bVar != null) {
                bVar.p(this);
            }
            b bVar2 = this.h;
            if (bVar2 != null) {
                bVar2.j();
            }
            this.h = null;
        }
    }

    public final boolean e() {
        return this.a;
    }

    @Nullable
    public final GXSocketListener f() {
        return this.b;
    }

    public final boolean g(@NotNull String str) {
        k21.i(str, "type");
        return k21.d("auto", str);
    }

    public final boolean h(@NotNull String str) {
        k21.i(str, "type");
        return k21.d("manual", str);
    }

    public final void j(@Nullable String str) {
        Log.e(TAG, k21.r("sendGetTemplateData103() called with: templateId = ", str));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((Object) "jsonrpc", (Object) "2.0");
        jSONObject.put((Object) "method", (Object) "template/getTemplateData");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put((Object) "id", (Object) str);
        jSONObject.put((Object) "params", (Object) jSONObject2);
        jSONObject.put((Object) "id", (Object) 103);
        com.alibaba.gaiax.studio.third.socket.websocket.a.f("GaiaXSocket").q(jSONObject.toJSONString());
    }

    public final void l() {
        Log.e(TAG, "sendMsgWithFastPreviewInit() called");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((Object) "jsonrpc", (Object) "2.0");
        jSONObject.put((Object) "method", (Object) "initialize");
        jSONObject.put((Object) "id", (Object) 102);
        com.alibaba.gaiax.studio.third.socket.websocket.a.f("GaiaXSocket").q(jSONObject.toJSONString());
    }

    public final void m() {
        Log.e(TAG, "sendMsgWithManualPushInit() called");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((Object) "jsonrpc", (Object) "2.0");
        jSONObject.put((Object) "method", (Object) "initializeManual");
        jSONObject.put((Object) "id", (Object) 101);
        com.alibaba.gaiax.studio.third.socket.websocket.a.f("GaiaXSocket").q(jSONObject.toJSONString());
    }

    public final void n(@Nullable GXSocketListener gXSocketListener) {
        this.b = gXSocketListener;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketListener
    public void onConnectFailed(@NotNull Throwable th) {
        k21.i(th, "e");
        Log.e(TAG, "onConnectFailed() called with: e = [" + th + jl1.ARRAY_END);
        this.a = false;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketListener
    public void onConnected() {
        Log.e(TAG, "onConnected() called");
        this.a = true;
        GXSocketListener gXSocketListener = this.b;
        if (gXSocketListener != null) {
            gXSocketListener.onSocketConnected();
        }
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketListener
    public void onDisconnect() {
        Log.e(TAG, "onDisconnect() called");
        b bVar = this.h;
        if (bVar != null) {
            bVar.i();
        }
        this.h = null;
        com.alibaba.gaiax.studio.third.socket.websocket.a.i("GaiaXSocket");
        this.j = null;
        this.i = null;
        this.a = false;
        GXSocketListener gXSocketListener = this.b;
        if (gXSocketListener != null) {
            gXSocketListener.onSocketDisconnected();
        }
        this.b = null;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketListener
    public <T> void onMessage(@Nullable String str, T t) {
        GXSocketListener gXSocketListener;
        GXSocketListener gXSocketListener2;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        GXSocketListener gXSocketListener3;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        if (str != null) {
            if (!(str.length() == 0)) {
                JSONObject parseObject = JSON.parseObject(str);
                String string = parseObject.getString("id");
                String string2 = parseObject.getString("method");
                Log.e(TAG, "onMessage() called with: socketId = [" + ((Object) string) + "], method = [" + ((Object) string2) + jl1.ARRAY_END);
                if (k21.d("template/didChangedNotification", string2) || k21.d("template/didManualChangedNotification", string2)) {
                    JSONObject jSONObject5 = parseObject.getJSONObject("params");
                    String string3 = jSONObject5.getString("templateId");
                    JSONObject jSONObject6 = jSONObject5.getJSONObject("data");
                    if (!(string3 == null || jSONObject6 == null)) {
                        Log.e(TAG, "onMessage() called with: templateId = [" + ((Object) string3) + jl1.ARRAY_END);
                        JSONObject c2 = c(jSONObject6);
                        if (k21.d("template/didChangedNotification", string2)) {
                            GXSocketListener gXSocketListener4 = this.b;
                            if (gXSocketListener4 != null) {
                                gXSocketListener4.onStudioAddData(string3, c2);
                            }
                            this.d = string3;
                            Runnable runnable = this.c;
                            if (runnable != null) {
                                this.k.removeCallbacks(runnable);
                            }
                            rq0 rq0 = new rq0(this, string3, c2);
                            this.c = rq0;
                            this.k.postDelayed(rq0, 200);
                        }
                        if (k21.d("template/didManualChangedNotification", string2) && (gXSocketListener = this.b) != null) {
                            gXSocketListener.onStudioAddData(string3, c2);
                        }
                    }
                } else if (k21.d(OConstant.CODE_POINT_EXP_GET_TARGET_DIR, string)) {
                    JSONObject jSONObject7 = parseObject.getJSONObject("result");
                    String string4 = jSONObject7.getString("id");
                    JSONObject jSONObject8 = jSONObject7.getJSONObject("data");
                    k21.h(jSONObject8, "templateDataSrc");
                    JSONObject c3 = c(jSONObject8);
                    GXSocketListener gXSocketListener5 = this.b;
                    if (gXSocketListener5 != null) {
                        k21.h(string4, "templateId");
                        gXSocketListener5.onStudioAddData(string4, c3);
                    }
                    JSONObject jSONObject9 = c3.getJSONObject("index.json");
                    if (!(jSONObject9 == null || (jSONObject3 = jSONObject9.getJSONObject("package")) == null || (jSONObject4 = jSONObject3.getJSONObject("dependencies")) == null)) {
                        for (Map.Entry entry : jSONObject4.entrySet()) {
                            this.e++;
                            k((String) entry.getKey());
                        }
                    }
                    this.f = string4;
                    this.g = c3;
                    if (this.e == 0) {
                        if (!(string4 == null || (gXSocketListener3 = this.b) == null)) {
                            k21.f(string4);
                            JSONObject jSONObject10 = this.g;
                            k21.f(jSONObject10);
                            gXSocketListener3.onStudioUpdate(string4, jSONObject10);
                        }
                        this.f = "";
                        this.g = null;
                    }
                } else if (k21.d(OConstant.CODE_POINT_EXP_CREATE_TARGET_DIR, string)) {
                    this.e--;
                    JSONObject jSONObject11 = parseObject.getJSONObject("result");
                    String string5 = jSONObject11.getString("id");
                    JSONObject jSONObject12 = jSONObject11.getJSONObject("data");
                    k21.h(jSONObject12, "templateDataSrc");
                    JSONObject c4 = c(jSONObject12);
                    GXSocketListener gXSocketListener6 = this.b;
                    if (gXSocketListener6 != null) {
                        k21.h(string5, "templateId");
                        gXSocketListener6.onStudioAddData(string5, c4);
                    }
                    JSONObject jSONObject13 = c4.getJSONObject("index.json");
                    if (!(jSONObject13 == null || (jSONObject = jSONObject13.getJSONObject("package")) == null || (jSONObject2 = jSONObject.getJSONObject("dependencies")) == null)) {
                        for (Map.Entry entry2 : jSONObject2.entrySet()) {
                            this.e++;
                            k((String) entry2.getKey());
                        }
                    }
                    if (this.e == 0) {
                        String str2 = this.f;
                        if (!(str2 == null || this.g == null || (gXSocketListener2 = this.b) == null)) {
                            k21.f(str2);
                            JSONObject jSONObject14 = this.g;
                            k21.f(jSONObject14);
                            gXSocketListener2.onStudioUpdate(str2, jSONObject14);
                        }
                        this.f = "";
                        this.g = null;
                    }
                } else if (k21.d(OConstant.CODE_POINT_EXP_LOAD_CACHE, string)) {
                    GXSocketListener gXSocketListener7 = this.b;
                    if (gXSocketListener7 != null) {
                        gXSocketListener7.onStudioConnected();
                    }
                } else if (!k21.d("", this.d)) {
                    j(this.d);
                }
            }
        }
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketListener
    public <T> void onMessage(@Nullable ByteBuffer byteBuffer, T t) {
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketListener
    public void onPing(@Nullable Framedata framedata) {
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketListener
    public void onPong(@Nullable Framedata framedata) {
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketListener
    public void onSendDataError(@Nullable ie0 ie0) {
    }
}
