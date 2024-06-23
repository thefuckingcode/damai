package cn.damai.commonbusiness.update;

import android.content.Context;
import cn.damai.common.AppConfig;
import cn.damai.commonbusiness.R$drawable;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.update.datasource.UpdateDataSource;
import com.taobao.update.datasource.local.a;
import com.taobao.update.framework.UpdateRuntime;
import com.taobao.updatecenter.hotpatch.HotPatchManager;
import java.lang.reflect.Field;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import tb.fw1;
import tb.k6;
import tb.np2;
import tb.q6;
import tb.ul;
import tb.uo1;
import tb.xs0;

/* compiled from: Taobao */
public class UpdateUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1918462999")) {
            ipChange.ipc$dispatch("1918462999", new Object[]{str});
            return;
        }
        UpdateDataSource.getInstance().addUpdateInfo(str);
    }

    public static void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-687698540")) {
            ipChange.ipc$dispatch("-687698540", new Object[0]);
            return;
        }
        k6 k6Var = new k6();
        try {
            Field declaredField = DMUpdateManager.g().h().getClass().getDeclaredField("updateLifeCycles");
            declaredField.setAccessible(true);
            ((List) declaredField.get(DMUpdateManager.g().h())).add(k6Var);
        } catch (Exception e) {
            e.printStackTrace();
        }
        UpdateRuntime.execute(new Runnable() {
            /* class cn.damai.commonbusiness.update.UpdateUtil.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "216621517")) {
                    ipChange.ipc$dispatch("216621517", new Object[]{this});
                    return;
                }
                UpdateDataSource.getInstance().startUpdate(false, true);
            }
        });
    }

    public static void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1864040782")) {
            ipChange.ipc$dispatch("-1864040782", new Object[0]);
            return;
        }
        k6 k6Var = new k6();
        try {
            Field declaredField = DMUpdateManager.g().h().getClass().getDeclaredField("updateLifeCycles");
            declaredField.setAccessible(true);
            ((List) declaredField.get(DMUpdateManager.g().h())).add(k6Var);
        } catch (Exception e) {
            e.printStackTrace();
        }
        UpdateRuntime.execute(new Runnable() {
            /* class cn.damai.commonbusiness.update.UpdateUtil.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "20108012")) {
                    ipChange.ipc$dispatch("20108012", new Object[]{this});
                    return;
                }
                UpdateDataSource.getInstance().startUpdate(true, true);
            }
        });
    }

    public static void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "551755123")) {
            ipChange.ipc$dispatch("551755123", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public static String g(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1620406252")) {
            return (String) ipChange.ipc$dispatch("-1620406252", new Object[]{str});
        }
        JSONObject parseObject = JSON.parseObject(str);
        String string = parseObject.getJSONObject("dynamicdeploy") != null ? parseObject.getJSONObject("dynamicdeploy").getString("url") : null;
        if (string == null) {
            return null;
        }
        try {
            HttpResponse execute = new DefaultHttpClient().execute(new HttpGet(string));
            if (execute.getStatusLine().getStatusCode() == 200) {
                return EntityUtils.toString(execute.getEntity(), "utf-8").toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void h(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2119608653")) {
            ipChange.ipc$dispatch("-2119608653", new Object[]{context});
            return;
        }
        a.getInstance(context).clearCache();
        UpdateRuntime.execute(new Runnable() {
            /* class cn.damai.commonbusiness.update.UpdateUtil.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-176405493")) {
                    ipChange.ipc$dispatch("-176405493", new Object[]{this});
                    return;
                }
                UpdateUtil.i();
            }
        });
    }

    /* access modifiers changed from: private */
    public static void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "832573740")) {
            ipChange.ipc$dispatch("832573740", new Object[0]);
            return;
        }
        ul ulVar = new ul(xs0.a());
        ulVar.ttid = AppConfig.p();
        ulVar.group = AppConfig.j();
        ulVar.appName = AppConfig.j();
        ulVar.isOutApk = false;
        ulVar.appName = "大麦";
        ulVar.logoResourceId = R$drawable.logo;
        ulVar.popDialogBeforeInstall = true;
        ulVar.threadExecutorImpl = new q6();
        ulVar.uiConfirmClass = np2.class;
        DMUpdateManager.g().i(ulVar, false);
    }

    public static void j(final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1234335278")) {
            ipChange.ipc$dispatch("1234335278", new Object[]{str});
            return;
        }
        new Thread(new Runnable() {
            /* class cn.damai.commonbusiness.update.UpdateUtil.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-372918998")) {
                    ipChange.ipc$dispatch("-372918998", new Object[]{this});
                    return;
                }
                try {
                    String str = str;
                    if (str != null) {
                        if (str.contains("apatch.json")) {
                            String g = UpdateUtil.g(str);
                            if (g != null) {
                                JSONObject jSONObject = (JSONObject) JSON.parse(g);
                                if (jSONObject.containsKey("data")) {
                                    HotPatchManager.getInstance().dealPatchInfo(uo1.a(jSONObject.getJSONObject("data").getJSONObject("hotpatch")), fw1.HOME_SCAN_PAGE, new String[0]);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        org.json.JSONObject jSONObject2 = new org.json.JSONObject(str);
                        if (jSONObject2.has("dynamicdeploy")) {
                            org.json.JSONObject jSONObject3 = jSONObject2.getJSONObject("dynamicdeploy");
                            if (jSONObject3.has("url")) {
                                UpdateUtil.c(jSONObject3.getString("url"));
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
