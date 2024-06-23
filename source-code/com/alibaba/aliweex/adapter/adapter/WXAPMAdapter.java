package com.alibaba.aliweex.adapter.adapter;

import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.alibaba.aliweex.IConfigAdapter;
import com.alibaba.aliweex.adapter.module.WXPerformanceModule;
import com.taobao.monitor.performance.IWXApmAdapter;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.performance.IWXApmMonitorAdapter;
import com.taobao.weex.performance.WXInstanceApm;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tb.a0;
import tb.gl1;
import tb.i4;
import tb.kx2;
import tb.tx2;

/* compiled from: Taobao */
public class WXAPMAdapter implements IWXApmMonitorAdapter {
    private static int f = -2;
    private static boolean g = true;
    public static boolean h;
    public String a;
    private IWXApmAdapter b;
    private TextView c;
    private Map<String, Double> d = new ConcurrentHashMap();
    private String e;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class a {
        String a;
        long b;
        long c;
        long d;

        private a(WXAPMAdapter wXAPMAdapter) {
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private JSONObject b() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("stageName", this.a);
            jSONObject.put("beginTime", this.c);
            jSONObject.put("endTime", this.d);
            jSONObject.put("cost", this.b);
            return jSONObject;
        }
    }

    private a d(String str, String str2, String str3) {
        long j;
        WXSDKInstance wXSDKInstance = WXSDKManager.v().i().get(this.a);
        if (wXSDKInstance == null) {
            return null;
        }
        a aVar = new a();
        aVar.a = str;
        Long l = wXSDKInstance.getApmForInstance().d.get(str3);
        Long l2 = wXSDKInstance.getApmForInstance().d.get(str2);
        long j2 = -1;
        if (l2 == null) {
            j = -1;
        } else {
            j = l2.longValue();
        }
        aVar.c = j;
        if (l != null) {
            j2 = l.longValue();
        }
        aVar.d = j2;
        aVar.b = j2 - aVar.c;
        return aVar;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String e() {
        Object obj;
        String str = "";
        if (WXSDKManager.v().i().get(this.a) == null) {
            return str;
        }
        a d2 = d("downLoad", WXInstanceApm.KEY_PAGE_STAGES_DOWN_BUNDLE_START, WXInstanceApm.KEY_PAGE_STAGES_DOWN_BUNDLE_END);
        a d3 = d("interactive", WXInstanceApm.KEY_PAGE_STAGES_RENDER_ORGIGIN, WXInstanceApm.KEY_PAGE_STAGES_INTERACTION);
        a d4 = d(WXInstanceApm.KEY_PAGE_STAGES_END_EXCUTE_BUNDLE, WXInstanceApm.KEY_PAGE_STAGES_LOAD_BUNDLE_END, WXInstanceApm.KEY_PAGE_STAGES_END_EXCUTE_BUNDLE);
        StringBuilder sb = new StringBuilder();
        sb.append("dowlnLoad:");
        sb.append(d2 == null ? str : Long.valueOf(d2.b));
        sb.append("\n evalJsBundle:");
        if (d4 == null) {
            obj = str;
        } else {
            obj = Long.valueOf(d4.b);
        }
        sb.append(obj);
        sb.append("\n interaction:");
        Object obj2 = str;
        if (d3 != null) {
            obj2 = Long.valueOf(d3.b);
        }
        sb.append(obj2);
        return sb.toString();
    }

    private void f() {
        int i;
        IConfigAdapter c2 = com.alibaba.aliweex.a.l().c();
        if (c2 != null && Boolean.valueOf(c2.getConfig(kx2.WXAPM_CONFIG_GROUP, "collectDeviceLevel", "true")).booleanValue()) {
            if (f == -2) {
                if (g) {
                    try {
                        i4.e f2 = i4.d().f();
                        if (f2 == null) {
                            i = -1;
                        } else {
                            i = f2.a;
                        }
                        f = i;
                    } catch (Throwable unused) {
                        g = false;
                        f = -1;
                    }
                } else {
                    f = -1;
                }
            }
            addProperty("wxDeviceLevel", Integer.valueOf(f + 1));
        }
    }

    private void g() {
        WXSDKInstance wXSDKInstance;
        if (h && (wXSDKInstance = WXSDKManager.v().i().get(this.a)) != null) {
            final View containerView = wXSDKInstance.getContainerView();
            if (containerView instanceof FrameLayout) {
                containerView.post(new Runnable() {
                    /* class com.alibaba.aliweex.adapter.adapter.WXAPMAdapter.AnonymousClass1 */

                    public void run() {
                        FrameLayout frameLayout = (FrameLayout) containerView;
                        if (WXAPMAdapter.this.c == null) {
                            WXAPMAdapter.this.c = new TextView(frameLayout.getContext());
                            WXAPMAdapter.this.c.setClickable(false);
                            WXAPMAdapter.this.c.setFocusable(false);
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 21;
                            WXAPMAdapter.this.c.setLayoutParams(layoutParams);
                            frameLayout.addView(WXAPMAdapter.this.c);
                        }
                        WXAPMAdapter.this.c.setText(WXAPMAdapter.this.e());
                        WXAPMAdapter.this.c.setTextSize(10.0f);
                        if (frameLayout.getChildAt(frameLayout.getChildCount() - 1) != WXAPMAdapter.this.c) {
                            ViewParent parent = WXAPMAdapter.this.c.getParent();
                            if (parent instanceof ViewGroup) {
                                ((ViewGroup) parent).removeView(WXAPMAdapter.this.c);
                            }
                            frameLayout.addView(WXAPMAdapter.this.c);
                        }
                    }
                });
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0134 A[SYNTHETIC, Splitter:B:47:0x0134] */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    private void h() {
        Throwable th;
        Exception e2;
        try {
            BufferedWriter bufferedWriter = null;
            File externalStorageDirectory = Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory() : null;
            if (externalStorageDirectory != null) {
                File absoluteFile = externalStorageDirectory.getAbsoluteFile();
                externalStorageDirectory = new File(absoluteFile, WXEnvironment.getApplication().getPackageName() + "/APM_ONLINE");
            }
            if (externalStorageDirectory == null || !externalStorageDirectory.exists()) {
                externalStorageDirectory.createNewFile();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", gl1.TYPE_OPEN_URL_WEEX);
            jSONObject.put("url", this.e);
            jSONObject.put("pageName", this.e);
            JSONArray jSONArray = new JSONArray();
            jSONObject.put("stages", jSONArray);
            a d2 = d("downLoad", WXInstanceApm.KEY_PAGE_STAGES_DOWN_BUNDLE_START, WXInstanceApm.KEY_PAGE_STAGES_DOWN_BUNDLE_END);
            if (d2 != null) {
                jSONArray.put(d2.b());
            }
            a d3 = d("prePareBundle", WXInstanceApm.KEY_PAGE_STAGES_LOAD_BUNDLE_START, WXInstanceApm.KEY_PAGE_STAGES_LOAD_BUNDLE_END);
            if (d3 != null) {
                jSONArray.put(d3.b());
            }
            a d4 = d("evalJsBundle", WXInstanceApm.KEY_PAGE_STAGES_LOAD_BUNDLE_END, WXInstanceApm.KEY_PAGE_STAGES_END_EXCUTE_BUNDLE);
            if (d4 != null) {
                jSONArray.put(d4.b());
            }
            a d5 = d("interactive", WXInstanceApm.KEY_PAGE_STAGES_END_EXCUTE_BUNDLE, WXInstanceApm.KEY_PAGE_STAGES_INTERACTION);
            if (d5 != null && d5.b > 0) {
                jSONArray.put(d5.b());
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("extra", jSONObject2);
            a d6 = d("mtopRequest", WXPerformanceModule.KEY_STAGE_JS_ASYNC_DATA_START, WXPerformanceModule.KEY_STAGE_JS_ASYNC_DATA_END);
            if (d6 != null) {
                jSONObject2.put("mtopRequest", d6.b());
            }
            jSONObject2.put(WXInstanceApm.KEY_PAGE_STATS_LAYOUT_TIME, this.d.get(WXInstanceApm.KEY_PAGE_STATS_LAYOUT_TIME));
            jSONObject2.put(WXInstanceApm.KEY_PAGE_STATS_VIEW_CREATE_COST, this.d.get(WXInstanceApm.KEY_PAGE_STATS_VIEW_CREATE_COST));
            jSONObject2.put(WXInstanceApm.KEY_PAGE_STATS_COMPONENT_CREATE_COST, this.d.get(WXInstanceApm.KEY_PAGE_STATS_COMPONENT_CREATE_COST));
            jSONObject2.put(WXInstanceApm.KEY_PAGE_STATS_EXECUTE_JS_CALLBACK_COST, this.d.get(WXInstanceApm.KEY_PAGE_STATS_EXECUTE_JS_CALLBACK_COST));
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(externalStorageDirectory, true)));
                try {
                    bufferedWriter2.write(jSONObject.toString());
                    bufferedWriter2.write(10);
                    try {
                        bufferedWriter2.close();
                    } catch (Exception unused) {
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    bufferedWriter = bufferedWriter2;
                    try {
                        e2.printStackTrace();
                        if (bufferedWriter == null) {
                            bufferedWriter.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e2 = e4;
                e2.printStackTrace();
                if (bufferedWriter == null) {
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    @Override // com.taobao.weex.performance.IWXApmMonitorAdapter
    public void addProperty(String str, Object obj) {
        IWXApmAdapter iWXApmAdapter = this.b;
        if (iWXApmAdapter != null) {
            iWXApmAdapter.addProperty(str, obj);
            if (h && WXInstanceApm.KEY_PAGE_PROPERTIES_BIZ_ID.equals(str)) {
                this.e = obj.toString();
            }
        }
    }

    @Override // com.taobao.weex.performance.IWXApmMonitorAdapter
    public void addStats(String str, double d2) {
        IWXApmAdapter iWXApmAdapter = this.b;
        if (iWXApmAdapter != null) {
            iWXApmAdapter.addStatistic(str, d2);
            if (h) {
                this.d.put(str, Double.valueOf(d2));
                if (WXInstanceApm.KEY_PAGE_STATS_LAYOUT_TIME.equals(str)) {
                    h();
                }
            }
        }
    }

    @Override // com.taobao.weex.performance.IWXApmMonitorAdapter
    public void onAppear() {
        IWXApmAdapter iWXApmAdapter = this.b;
        if (iWXApmAdapter != null) {
            iWXApmAdapter.onStart();
        }
    }

    @Override // com.taobao.weex.performance.IWXApmMonitorAdapter
    public void onDisappear() {
        IWXApmAdapter iWXApmAdapter = this.b;
        if (iWXApmAdapter != null) {
            iWXApmAdapter.onStop();
        }
    }

    @Override // com.taobao.weex.performance.IWXApmMonitorAdapter
    public void onEnd() {
        IWXApmAdapter iWXApmAdapter = this.b;
        if (iWXApmAdapter != null) {
            iWXApmAdapter.onEnd();
        }
    }

    @Override // com.taobao.weex.performance.IWXApmMonitorAdapter
    public void onEvent(String str, Object obj) {
        IWXApmAdapter iWXApmAdapter = this.b;
        if (iWXApmAdapter != null) {
            iWXApmAdapter.onEvent(str, obj);
        }
    }

    @Override // com.taobao.weex.performance.IWXApmMonitorAdapter
    public void onStage(String str, long j) {
        IWXApmAdapter iWXApmAdapter = this.b;
        if (iWXApmAdapter != null) {
            iWXApmAdapter.onStage(str, j);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("weexInstanceId", TextUtils.isEmpty(this.a) ? "nullId" : this.a);
        if (!TextUtils.isEmpty(this.e)) {
            hashMap.put("mPageName", this.e);
        }
        com.alibaba.aliweex.a.l().s(str, hashMap);
        if (h) {
            g();
        }
    }

    @Override // com.taobao.weex.performance.IWXApmMonitorAdapter
    public void onStart(String str) {
        this.a = str;
        IWXApmAdapter createApmAdapter = a0.a().createApmAdapter();
        this.b = createApmAdapter;
        if (createApmAdapter != null) {
            createApmAdapter.onStart(str);
            f();
        }
    }

    @Override // com.taobao.weex.performance.IWXApmMonitorAdapter
    public void onSubProcedureEvent(String str, String str2) {
    }

    @Override // com.taobao.weex.performance.IWXApmMonitorAdapter
    public void onSubProcedureStage(String str, String str2) {
    }

    @Override // com.taobao.weex.performance.IWXApmMonitorAdapter
    public String parseReportUrl(String str) {
        String b2 = tx2.b(str, false);
        return TextUtils.isEmpty(b2) ? "emptyParseUrl" : b2;
    }

    @Override // com.taobao.weex.performance.IWXApmMonitorAdapter
    public void setSubProcedureProperties(String str, String str2, Object obj) {
    }

    @Override // com.taobao.weex.performance.IWXApmMonitorAdapter
    public void setSubProcedureStats(String str, String str2, double d2) {
    }
}
