package tb;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.poplayer.layermanager.ILayerMgrAdapter;
import com.alibaba.poplayer.layermanager.config.ConfigItem;
import com.alibaba.poplayer.layermanager.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class xl {
    public static final String CONFIG_SET_KEY = "layer_manager_config";
    public static final String DEFAULT_KEY = "default";
    public static final String TAG = "xl";
    Map<String, ac> a;
    private ILayerMgrAdapter b;
    private b c;
    private boolean d = false;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class b extends AsyncTask<Void, Void, Map<String, ac>> {
        private b() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Map<String, ac> doInBackground(Void... voidArr) {
            Throwable th;
            char c = 1;
            String str = xl.TAG;
            char c2 = 0;
            cr1.b("%s. begin update Config.", str);
            new ArrayList();
            String configByKey = xl.this.b.getConfigByKey(xl.CONFIG_SET_KEY);
            int i = 2;
            if (TextUtils.isEmpty(configByKey)) {
                cr1.b("%s. %s is empty.", str, xl.CONFIG_SET_KEY);
                return new HashMap();
            }
            cr1.b("%s. %s: {%s}.", str, xl.CONFIG_SET_KEY, configByKey);
            HashMap hashMap = new HashMap();
            String[] split = configByKey.split("\\,");
            int length = split.length;
            int i2 = 0;
            while (i2 < length) {
                String trim = split[i2].trim();
                Object[] objArr = new Object[i];
                objArr[c2] = xl.TAG;
                objArr[c] = trim;
                cr1.b("%s. ==> update bizConfig: bizId:{%s}.", objArr);
                String configByKey2 = xl.this.b.getConfigByKey(trim);
                try {
                    ac acVar = new ac();
                    Map<String, String> b = eu2.b(configByKey2);
                    for (String str2 : b.keySet()) {
                        try {
                            ConfigItem configItem = (ConfigItem) JSON.parseObject(b.get(str2), ConfigItem.class);
                            acVar.a.put(str2, configItem);
                            cr1.b("%s. ==> put tpye:{%s},val:{%s}.", xl.TAG, str2, configItem.toString());
                        } catch (Throwable th2) {
                            cr1.c("" + xl.TAG + ".update key:" + trim + ",,error.", th2);
                        }
                    }
                    if (!acVar.a.isEmpty()) {
                        hashMap.put(trim, acVar);
                        Object[] objArr2 = new Object[3];
                        try {
                            objArr2[0] = xl.TAG;
                            try {
                                objArr2[1] = xl.CONFIG_SET_KEY;
                                try {
                                    objArr2[2] = trim;
                                    cr1.b("%s. --> complete bizId:{%s}. update", objArr2);
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                cr1.c("" + xl.TAG + ".update key:" + trim + ",error.", th);
                                i2++;
                                c = 1;
                                c2 = 0;
                                i = 2;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            cr1.c("" + xl.TAG + ".update key:" + trim + ",error.", th);
                            i2++;
                            c = 1;
                            c2 = 0;
                            i = 2;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    cr1.c("" + xl.TAG + ".update key:" + trim + ",error.", th);
                    i2++;
                    c = 1;
                    c2 = 0;
                    i = 2;
                }
                i2++;
                c = 1;
                c2 = 0;
                i = 2;
            }
            return hashMap;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(Map<String, ac> map) {
            try {
                xl xlVar = xl.this;
                xlVar.a = map;
                xlVar.d(map);
            } catch (Throwable th) {
                cr1.c("" + xl.TAG + ".onPostExecute.error.", th);
            }
        }
    }

    public xl(ILayerMgrAdapter iLayerMgrAdapter) {
        this.b = iLayerMgrAdapter;
    }

    public ac b(String str) {
        Map<String, ac> map = this.a;
        if (map == null || map.isEmpty()) {
            return null;
        }
        for (String str2 : this.a.keySet()) {
            if (str2.equals(str)) {
                return this.a.get(str2);
            }
        }
        return this.a.get("default");
    }

    public boolean c() {
        return this.d;
    }

    /* access modifiers changed from: protected */
    public void d(Map<String, ac> map) {
        e.f().o();
        this.d = true;
    }

    public void e() {
        b bVar = this.c;
        if (!(bVar == null || AsyncTask.Status.FINISHED == bVar.getStatus())) {
            this.c.cancel(true);
        }
        b bVar2 = new b();
        this.c = bVar2;
        bVar2.execute(new Void[0]);
    }
}
