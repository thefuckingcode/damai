package tb;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.emas.publish.EmasPublishRequest;
import com.alibaba.emas.publish.EmasPublishService;
import com.alibaba.emas.publish.channel.mtop.PublishMtopResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.orange.OrangeConfig;
import com.taobao.update.datasource.mtop.MtopUpdater;
import java.io.Serializable;
import java.util.Map;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopBuilder;

/* compiled from: Taobao */
public class fs2 {
    private static boolean f;
    private Boolean a;
    private Boolean b;
    private Boolean c;
    private Boolean d;
    private Boolean e;
    public boolean subscribed = false;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ Runnable a;

        a(fs2 fs2, Runnable runnable) {
            this.a = runnable;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            this.a.run();
            return null;
        }
    }

    private boolean a() {
        if (this.b == null) {
            try {
                Class.forName(OrangeConfig.class.getName());
                this.b = Boolean.TRUE;
            } catch (Throwable unused) {
                this.b = Boolean.FALSE;
            }
        }
        return this.b.booleanValue();
    }

    public void commitSuccess(String str, String str2, String str3) {
        if (hasAppMonitor()) {
            AppMonitor.Alarm.commitSuccess(str, str2, str3);
        }
    }

    public void executeThread(Runnable runnable) {
        new a(this, runnable).execute(new Void[0]);
    }

    public String getConfig(String str, String str2, String str3) {
        return a() ? OrangeConfig.getInstance().getConfig(str, str2, str3) : str3;
    }

    public boolean hasAccs() {
        if (this.d == null) {
            try {
                Class.forName(AccsAbstractDataListener.class.getName());
                this.d = Boolean.TRUE;
            } catch (Throwable unused) {
                this.d = Boolean.FALSE;
            }
        }
        return this.d.booleanValue();
    }

    public boolean hasAppMonitor() {
        if (this.e == null) {
            try {
                Class.forName(AppMonitor.class.getName());
                this.e = Boolean.TRUE;
            } catch (Throwable unused) {
                this.e = Boolean.FALSE;
            }
        }
        return this.e.booleanValue();
    }

    public boolean hasEmasPublish() {
        if (this.a == null) {
            try {
                Class.forName(EmasPublishService.class.getName());
                this.a = Boolean.TRUE;
            } catch (Throwable unused) {
                this.a = Boolean.FALSE;
            }
        }
        return this.a.booleanValue();
    }

    public boolean hasMtop() {
        if (this.c == null) {
            try {
                Class.forName(Mtop.class.getName());
                this.c = Boolean.TRUE;
            } catch (Throwable unused) {
                this.c = Boolean.FALSE;
            }
        }
        return this.c.booleanValue();
    }

    public JSONObject invokePullApi(Serializable serializable, Context context, String str, boolean z) {
        if (!hasMtop()) {
            Log.e("UpdateAdapter", "mtop is not found");
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            str = "600000";
        }
        MtopBuilder build = Mtop.instance(z ? Mtop.Id.OPEN : Mtop.Id.INNER, context).build(serializable, str);
        build.reqMethod(MethodEnum.GET);
        MtopResponse syncRequest = build.syncRequest();
        if (syncRequest.isApiSuccess()) {
            try {
                String str2 = new String(syncRequest.getBytedata());
                if (!TextUtils.isEmpty(str2)) {
                    JSONObject parseObject = JSON.parseObject(str2);
                    if (parseObject.containsKey("data")) {
                        return parseObject.getJSONObject("data");
                    }
                }
            } catch (Exception e2) {
                Log.e("UpdateAdapter", "get mtop data exception", e2);
            }
        } else if (TextUtils.isEmpty(syncRequest.getRetCode()) || TextUtils.isEmpty(syncRequest.getRetMsg()) || !syncRequest.getRetCode().equals("USE_ALTER_SYSTEM_DATA") || !syncRequest.getRetMsg().equals("走变更sdk")) {
            Log.e("UpdateAdapter", "invoke mtop api error, " + syncRequest.getRetMsg());
        } else {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MtopUpdater.DEGRADE, (Object) Boolean.TRUE);
            return jSONObject;
        }
        return null;
    }

    public boolean openEmasPublish() {
        return getConfig(js2.UPDATE_EMAS_CONFIG_GROUP, js2.UPDATE_MTOP_OPEN, "false").equals("false");
    }

    public PublishMtopResponse pullEmasPatchPublishApi(String str, dd0 dd0, Map<String, String> map) {
        EmasPublishRequest emasPublishRequest = new EmasPublishRequest();
        emasPublishRequest.bizName = dd0.biz();
        emasPublishRequest.appVersion = str;
        emasPublishRequest.currentVersion = dd0.requestVersion();
        emasPublishRequest.mtopApiName = dd0.apiName();
        emasPublishRequest.args = map;
        return EmasPublishService.getInstance().sendActiveMtop(emasPublishRequest);
    }

    public PublishMtopResponse pullEmasPublishApi(String str, dd0 dd0, Map<String, String> map) {
        EmasPublishRequest emasPublishRequest = new EmasPublishRequest();
        emasPublishRequest.bizName = dd0.biz();
        emasPublishRequest.appVersion = str;
        emasPublishRequest.currentVersion = dd0.requestVersion();
        emasPublishRequest.mtopApiName = dd0.apiName();
        emasPublishRequest.args = map;
        return EmasPublishService.getInstance().sendActiveMtop(emasPublishRequest);
    }

    public boolean registerEmasPublishApi(String str, dd0 dd0, Map<String, String> map) {
        EmasPublishRequest emasPublishRequest = new EmasPublishRequest();
        emasPublishRequest.bizName = dd0.biz();
        emasPublishRequest.appVersion = str;
        emasPublishRequest.currentVersion = dd0.requestVersion();
        emasPublishRequest.callback = dd0.callback();
        emasPublishRequest.args = map;
        return EmasPublishService.getInstance().registEmasPublish(emasPublishRequest).booleanValue();
    }

    public synchronized void registerPushApi(Context context, AccsAbstractDataListener accsAbstractDataListener) {
        if (hasAccs()) {
            if (!f) {
                f = true;
                ACCSManager.registerDataListener(context, u2.SERVICE_ID, accsAbstractDataListener);
            }
        }
    }
}
