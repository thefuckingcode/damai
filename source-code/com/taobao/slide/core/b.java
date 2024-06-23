package com.taobao.slide.core;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsException;
import com.taobao.accs.common.Constants;
import com.taobao.orange.OConstant;
import com.taobao.slide.api.SlideConfig;
import com.taobao.slide.api.SlideSubscriber;
import com.taobao.slide.control.a;
import com.taobao.slide.model.AppDO;
import com.taobao.slide.model.PeaDO;
import com.taobao.slide.model.PodDO;
import com.taobao.slide.model.TraceDO;
import com.taobao.slide.task.DispatchTask;
import com.taobao.slide.task.PushTask;
import com.uc.webview.export.extension.UCCore;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import tb.cc;
import tb.d11;
import tb.gl1;
import tb.hj2;
import tb.if1;
import tb.j81;
import tb.kg2;
import tb.nf1;
import tb.o22;
import tb.uk;

/* compiled from: Taobao */
public class b {
    private Context a;
    private SlideConfig b;
    private a<AppDO> c;
    private AppDO d;
    private Map<kg2, SlideSubscriber> e = new ConcurrentHashMap();

    public b(Context context, SlideConfig slideConfig) {
        this.a = context;
        this.b = slideConfig;
        this.c = new a<>(new File(this.a.getFilesDir(), String.format("Slide_%s", slideConfig.getEnv().name())));
    }

    private String a(String str, String str2) {
        return String.format("%s[%s]", str, str2);
    }

    private int g(String str) {
        int i = 0;
        for (Map.Entry<kg2, SlideSubscriber> entry : this.e.entrySet()) {
            if (k(str, entry.getKey().a, entry.getValue().e())) {
                i++;
            }
        }
        return i;
    }

    private void i(List<PodDO> list, Map<kg2, SlideSubscriber> map, boolean z) {
        if (list == null || list.isEmpty()) {
            o22.k("Engine", "match not any update pods", new Object[0]);
            return;
        }
        o22.g("Engine", "match start", "check", Boolean.valueOf(z));
        for (PodDO podDO : list) {
            j(podDO, map, z);
        }
        for (Map.Entry<kg2, SlideSubscriber> entry : map.entrySet()) {
            SlideSubscriber value = entry.getValue();
            if (!(value.d() == null || value.d().size() == 0)) {
                HashMap hashMap = new HashMap(value.d());
                value.b();
                DispatchTask dispatchTask = new DispatchTask(value, hashMap);
                Handler c2 = value.c();
                if (c2 != null) {
                    c2.post(dispatchTask);
                } else {
                    hj2.a(dispatchTask);
                }
            }
        }
        o22.g("Engine", "match end", new Object[0]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x017d, code lost:
        tb.o22.i("Engine", a("pea success", r29.name), new java.lang.Object[0]);
        r17 = r8;
        r3 = new com.taobao.slide.model.ResultDO(r29.name, r29.ver, r29.extra, r15.extra, r15.resources, r15.etag);
        r3.statData.d = f();
        r3.statData.e = r29.stat;
        tb.o22.g("Engine", a("pea match", r29.name), "subscriber", java.lang.String.format("%s->%s", java.util.Arrays.toString(r14), r6));
        r13.a(r29.name, r3);
        r29.latestPeaIndex = r12 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x01f2, code lost:
        if (r29.isNotified(r15.etag) != false) goto L_0x0222;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x01f4, code lost:
        tb.o22.g("Engine", "pea notify", "pod", r29.name);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0206, code lost:
        if (r29.stat == 0) goto L_0x0216;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0208, code lost:
        tb.d11.b(f(), r29.name, r29.ver, 0, r15.etag);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0216, code lost:
        tb.o22.e("Engine", "match stat closed!!", new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x021d, code lost:
        r29.addNotify(r15.etag);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0222, code lost:
        if (r2 == null) goto L_0x0239;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0228, code lost:
        if (r2.b == false) goto L_0x0239;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x022a, code lost:
        tb.d11.a(f(), r29.name, r29.ver, 1042, r15.etag);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0239, code lost:
        r11 = true;
     */
    private boolean j(PodDO podDO, Map<kg2, SlideSubscriber> map, boolean z) {
        a aVar;
        a aVar2;
        String str;
        Iterator<Map.Entry<kg2, SlideSubscriber>> it;
        boolean z2;
        a aVar3;
        int i = 2;
        o22.i("Engine", "match start", "pod", podDO);
        if (!podDO.isValid()) {
            o22.k("Engine", a("pod invalid", podDO.name), "pod", podDO);
            return false;
        }
        boolean isEmpty = TextUtils.isEmpty(podDO.control);
        String str2 = Constants.KEY_CONTROL;
        if (!isEmpty) {
            aVar = a.b(podDO.control);
            if (aVar.e()) {
                o22.k("Engine", a("pod fail", podDO.name), str2, podDO.control);
                return false;
            }
        } else {
            aVar = null;
        }
        Iterator<Map.Entry<kg2, SlideSubscriber>> it2 = map.entrySet().iterator();
        boolean z3 = false;
        int i2 = 0;
        while (it2.hasNext()) {
            Map.Entry<kg2, SlideSubscriber> next = it2.next();
            String[] strArr = next.getKey().a;
            SlideSubscriber value = next.getValue();
            SlideSubscriber.Type e2 = value.e();
            if (!k(podDO.name, strArr, e2)) {
                Object[] objArr = new Object[i];
                objArr[0] = "pod";
                objArr[1] = podDO;
                o22.i("Engine", "match end", objArr);
            } else {
                Iterator<PeaDO> it3 = podDO.peas.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        aVar2 = aVar;
                        str = str2;
                        it = it2;
                        break;
                    }
                    PeaDO next2 = it3.next();
                    it = it2;
                    o22.i("Engine", a("pea start", podDO.name), "pea", next2);
                    i2++;
                    if (!next2.isValid()) {
                        z2 = z3;
                        aVar2 = aVar;
                        d11.a(f(), podDO.name, podDO.ver, 1041, next2.etag);
                        o22.e("Engine", a("pea invalid", next2.etag), "pea", next2);
                    } else {
                        aVar2 = aVar;
                        z2 = z3;
                        if (!z || !podDO.isNotified(next2.etag)) {
                            if (!TextUtils.isEmpty(next2.control)) {
                                aVar3 = a.b(next2.control);
                                if (aVar3.e()) {
                                    o22.k("Engine", a("pea fail", podDO.name), str2, next2.control);
                                    it3 = it3;
                                    it2 = it;
                                    z3 = z2;
                                    aVar = aVar2;
                                }
                            } else {
                                aVar3 = null;
                            }
                            if (TextUtils.isEmpty(next2.condition)) {
                                break;
                            }
                            aVar3 = a.b(next2.condition);
                            if (aVar3.e()) {
                                break;
                            }
                            o22.k("Engine", a("pea fail", podDO.name), "condition", next2.condition);
                            it3 = it3;
                            it2 = it;
                            z3 = z2;
                            aVar = aVar2;
                        } else {
                            o22.g("Engine", a("pea already notified", next2.etag), "pea", next2);
                        }
                    }
                    it3 = it3;
                    it2 = it;
                    z3 = z2;
                    aVar = aVar2;
                }
                str2 = str;
                it2 = it;
                aVar = aVar2;
                i = 2;
            }
        }
        if (aVar != null && aVar.b) {
            d11.a(f(), podDO.name, podDO.ver, 1042, "pea");
        }
        o22.i("Engine", "match end", "pod", podDO);
        return z3;
    }

    private boolean k(String str, String[] strArr, SlideSubscriber.Type type) {
        if (strArr == null) {
            return false;
        }
        for (String str2 : strArr) {
            if (type == SlideSubscriber.Type.EXACT) {
                if (!str.equals(str2)) {
                }
            } else if (type == SlideSubscriber.Type.PREFIX) {
                if (!str.startsWith(str2)) {
                }
            } else if (!Pattern.matches(str2, str)) {
            }
            return true;
        }
        return false;
    }

    private void q(List<PodDO> list, PodDO podDO) {
        PodDO podDO2 = this.d.getPodMap().get(podDO.name);
        if (podDO2 == null) {
            this.d.pods.add(podDO);
            list.add(podDO);
            o22.g("Engine", "process add", "name", podDO.name, "version", podDO.ver);
        } else if (uk.h(podDO.ver, podDO2.ver)) {
            Set<String> set = podDO2.notified;
            if (set != null && set.size() > 0) {
                podDO.notified = new HashSet(podDO2.notified);
            }
            this.d.pods.remove(podDO2);
            this.d.pods.add(podDO);
            list.add(podDO);
            o22.g("Engine", "process update", "name", podDO.name, "version", podDO.ver, "oldversion", podDO2.ver);
        }
        this.d.buildPodMap();
    }

    public SlideConfig b() {
        return this.b;
    }

    public Context c() {
        return this.a;
    }

    public AppDO d() {
        return this.d;
    }

    public String e() {
        AppDO appDO = this.d;
        return appDO == null ? "" : appDO.dig;
    }

    public String f() {
        AppDO appDO = this.d;
        return appDO == null ? "0" : appDO.version;
    }

    public void h() {
        try {
            AppDO b2 = this.c.b("ALIBABA.SLIDE");
            this.d = b2;
            if (b2 == null) {
                o22.k("Engine", "init no local index file", new Object[0]);
                return;
            }
            o22.g("Engine", UCCore.LEGACY_EVENT_INIT, "curAppDO", b2);
            this.d.buildPodMap();
            nf1.a(new cc());
            i(this.d.pods, this.e, false);
            o();
        } catch (Throwable th) {
            if (this.d == null) {
                if1.a(if1.POINT_CACHE, gl1.TYPE_OPEN_URL_METHOD_GET);
            }
            o22.d("Engine", UCCore.LEGACY_EVENT_INIT, th, new Object[0]);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0071 A[Catch:{ all -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0081 A[Catch:{ all -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    public void l(AppDO appDO, boolean z) {
        boolean z2;
        o22.g("Engine", "process", "newAppDO", appDO, "fromGateway", Boolean.valueOf(z));
        try {
            appDO.buildPodMap();
            ArrayList arrayList = new ArrayList();
            AppDO appDO2 = this.d;
            if (appDO2 != null) {
                if (appDO2.pods != null) {
                    for (PodDO podDO : appDO.pods) {
                        q(arrayList, podDO);
                    }
                    AppDO appDO3 = this.d;
                    appDO3.version = appDO.version;
                    appDO3.dig = appDO.dig;
                    z2 = false;
                    i(arrayList, this.e, true);
                    if (!this.c.c("ALIBABA.SLIDE", this.d)) {
                        o22.k("Engine", "process save local fail", new Object[0]);
                        if1.a(if1.POINT_CACHE, "save");
                    }
                    if (!z2) {
                        o();
                        return;
                    }
                    return;
                }
            }
            o22.g("Engine", "process not exist before", new Object[0]);
            this.d = appDO;
            arrayList.addAll(appDO.pods);
            z2 = true;
            i(arrayList, this.e, true);
            if (!this.c.c("ALIBABA.SLIDE", this.d)) {
            }
            if (!z2) {
            }
        } catch (Throwable th) {
            o22.d("Engine", "process", th, new Object[0]);
        }
    }

    public void m(PodDO podDO) {
        o22.g("Engine", "process", "pushPod", podDO);
        if (this.d == null) {
            o22.e("Engine", "process receive push befeore init", "pushPod", podDO);
            return;
        }
        ArrayList arrayList = new ArrayList(1);
        q(arrayList, podDO);
        i(arrayList, this.e, false);
        if (!this.c.c("ALIBABA.SLIDE", this.d)) {
            o22.k("Engine", "process save local fail", new Object[0]);
            if1.a(if1.POINT_CACHE, "save");
        }
    }

    public void n(List<String> list) throws AccsException {
        TraceDO traceDO = new TraceDO();
        TraceDO.Device device = new TraceDO.Device();
        device.app_key = b().getAppKey();
        device.app_ver = a.d("app_ver");
        device.did_hash = a.d("did_hash");
        device.m_brand = a.d(OConstant.CANDIDATE_BRAND);
        device.m_model = a.d(OConstant.CANDIDATE_MODEL);
        device.m_vendor = a.d("m_vendor");
        device.os_ver = a.d(OConstant.CANDIDATE_OSVER);
        traceDO.device = device;
        AppDO d2 = d();
        if (d2.isValid()) {
            traceDO.ver = d2.version;
            traceDO.pods = new ArrayList();
            for (String str : list) {
                PodDO podDO = d2.getPodMap().get(str);
                TraceDO.PodData podData = new TraceDO.PodData();
                if (podDO == null) {
                    o22.e("Engine", "PushTask trace pod not exist", "name", str);
                } else {
                    String str2 = podDO.name;
                    podData.name = str2;
                    podData.byPush = podDO.pushType;
                    podData.ver = podDO.ver;
                    podData.selectedPea = podDO.latestPeaIndex;
                    podData.subs = g(str2);
                    traceDO.pods.add(podData);
                }
            }
        } else {
            o22.e("Engine", "PushTask trace appdo invalid", new Object[0]);
        }
        JSONObject jSONObject = (JSONObject) ((JSONObject) JSON.toJSON(traceDO)).get("device");
        for (j81 j81 : a.c()) {
            jSONObject.put(j81.b(), (Object) j81.c());
            o22.g("Engine", "PushTask trace add custom prop", "key", j81.b(), "value", j81.c());
        }
        String jSONString = JSON.toJSONString(traceDO);
        o22.g("Engine", "PushTask trace", "data", jSONString);
        ACCSClient.getAccsClient().sendData(new ACCSManager.AccsRequest(null, "slider", jSONString.getBytes(), null));
    }

    public void o() throws AccsException {
        Set<PodDO> set = PushTask.waitingPods;
        if (set != null && set.size() > 0) {
            o22.g("Engine", "processWaitingPush", "pushPods", set.toString());
            for (PodDO podDO : set) {
                m(podDO);
            }
            set.clear();
        }
        Set<String> set2 = PushTask.waitingTracePod;
        if (set2 != null && set2.size() > 0) {
            o22.g("Engine", "processWaitingPush", "push trace", set2.toString());
            n(new ArrayList(set2));
            set2.clear();
        }
    }

    public void p(kg2 kg2, SlideSubscriber slideSubscriber) {
        if (kg2 == null || this.e.containsKey(kg2)) {
            o22.k("Engine", "subscribe already exist", new Object[0]);
            return;
        }
        o22.c("Engine", "subscribe", "subKey", kg2.toString(), "subscriber", slideSubscriber.e());
        this.e.put(kg2, slideSubscriber);
        ArrayList arrayList = new ArrayList(kg2.a.length);
        AppDO appDO = this.d;
        if (!(appDO == null || appDO.getPodMap() == null)) {
            for (String str : kg2.a) {
                PodDO podDO = this.d.getPodMap().get(str);
                if (podDO != null) {
                    arrayList.add(podDO);
                }
            }
        }
        if (arrayList.size() != 0) {
            HashMap hashMap = new HashMap(1);
            hashMap.put(kg2, slideSubscriber);
            i(arrayList, hashMap, false);
        }
    }
}
