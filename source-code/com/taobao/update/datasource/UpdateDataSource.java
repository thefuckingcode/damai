package com.taobao.update.datasource;

import android.app.Application;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.alibaba.emas.publish.EmasPublishService;
import com.alibaba.emas.publish.channel.mtop.PublishMtopResponse;
import com.alibaba.emas.publish.channel.mtop.PublishMtopUpdateInfo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.update.datasource.data.UpdateDataListener;
import com.taobao.update.datasource.local.UpdateInfo;
import com.taobao.update.datasource.logger.Log;
import com.taobao.update.datasource.mtop.MtopUpdater;
import com.taobao.update.types.PatchType;
import com.youku.alixplayer.opensdk.AXPParamsProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.cd0;
import tb.dd0;
import tb.fs2;
import tb.js2;
import tb.ms2;
import tb.ns2;
import tb.qs1;
import tb.u2;
import tb.uo;
import tb.xy0;
import tb.y91;
import tb.yc0;
import tb.zc0;

/* compiled from: Taobao */
public class UpdateDataSource implements UpdateDataListener {
    public static boolean inited;
    private static UpdateDataSource k = new UpdateDataSource();
    public static Map<String, UpdateListener> listenerMap = new HashMap();
    public static Application sContext;
    public static String sGroup;
    public static fs2 sUpdateAdapter;
    private ms2 a;
    private dd0 b = zc0.INSTANCE();
    private dd0 c = yc0.INSTANCE();
    private dd0 d = cd0.INSTANCE();
    private Map<String, IUpdater> e = new HashMap();
    private HandlerThread f = null;
    private AddUpdateCallback g;
    private Handler h;
    private Log i = y91.getLog(UpdateDataSource.class, (Log) null);
    volatile boolean j = false;

    /* compiled from: Taobao */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 0) {
                UpdateDataSource updateDataSource = UpdateDataSource.this;
                updateDataSource.i((UpdateInfo) message.obj, true, updateDataSource.g, js2.ACCS_SOURCE);
                try {
                    TaskManager.instance().run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (i == 1) {
                Bundle data = message.getData();
                UpdateDataSource.this.i((UpdateInfo) message.obj, data.getBoolean("background"), UpdateDataSource.this.g, js2.MTOP_SOURCE);
                try {
                    TaskManager.instance().run();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            } else if (i == 2) {
                Object obj = message.obj;
                if (obj != null) {
                    UpdateDataSource updateDataSource2 = UpdateDataSource.this;
                    updateDataSource2.i((UpdateInfo) obj, false, updateDataSource2.g, js2.SCAN);
                }
                try {
                    TaskManager.instance().run();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            } else if (i == 4) {
                Object obj2 = message.obj;
                if (obj2 != null) {
                    UpdateDataSource updateDataSource3 = UpdateDataSource.this;
                    updateDataSource3.i((UpdateInfo) obj2, true, updateDataSource3.g, js2.SAFE_MODE);
                }
                try {
                    TaskManager.instance().run();
                } catch (InterruptedException e4) {
                    e4.printStackTrace();
                }
            } else if (i == 5) {
                Bundle data2 = message.getData();
                UpdateDataSource.this.i((UpdateInfo) message.obj, data2.getBoolean("background"), UpdateDataSource.this.g, "NOTICE");
                try {
                    TaskManager.instance().run();
                } catch (InterruptedException e5) {
                    e5.printStackTrace();
                }
            } else if (i == 6) {
                Bundle data3 = message.getData();
                UpdateDataSource.this.i((UpdateInfo) message.obj, data3.getBoolean("background"), UpdateDataSource.this.g, js2.EMAS_PUBLISH);
                try {
                    TaskManager.instance().run();
                } catch (InterruptedException e6) {
                    e6.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements MtopUpdater.MtopDataListener {
        final /* synthetic */ boolean a;

        b(boolean z) {
            this.a = z;
        }

        @Override // com.taobao.update.datasource.mtop.MtopUpdater.MtopDataListener
        public void hasUpdate(String str) {
        }

        @Override // com.taobao.update.datasource.mtop.MtopUpdater.MtopDataListener
        public void noUpdate() {
            UpdateDataSource.this.i.e("invoke mtop no update!");
            if (this.a) {
                UpdateDataSource.getInstance().toast("您使用的版本已是最新的了哦!");
            }
        }
    }

    private UpdateDataSource() {
        HandlerThread handlerThread = new HandlerThread(UpdateDataSource.class.getName());
        this.f = handlerThread;
        handlerThread.start();
        this.h = new a(this.f.getLooper());
    }

    public static UpdateDataSource getInstance() {
        return k;
    }

    private Task h(final PatchType patchType, final UpdateInfo.UpdateData updateData, String str, final boolean z) {
        final UpdateListener updateListener = listenerMap.get(patchType.getKey());
        return new qs1(patchType, new PatchRunnable(updateListener) {
            /* class com.taobao.update.datasource.UpdateDataSource.AnonymousClass2 */

            public void run() {
                UpdateListener updateListener = updateListener;
                if (updateListener != null) {
                    try {
                        boolean z = js2.HOTPATCH.equals(patchType.getKey()) ? true : z;
                        UpdateInfo.UpdateData updateData = updateData;
                        updateListener.onUpdate(z, updateData.value, updateData.from);
                    } catch (Throwable th) {
                        th.printStackTrace();
                        UpdateDataSource.this.m(updateData, patchType);
                    }
                }
            }
        }, str, z);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void i(UpdateInfo updateInfo, boolean z, AddUpdateCallback addUpdateCallback, String str) {
        ArrayList arrayList = new ArrayList();
        if (updateInfo.updateList.containsKey(js2.SOPATCH)) {
            arrayList.add(js2.SOPATCH);
            TaskManager.instance().add(h(PatchType.SOPATCH, updateInfo.updateList.get(js2.SOPATCH), str, z));
        }
        if (updateInfo.updateList.containsKey(js2.DYNAMIC) && Build.VERSION.SDK_INT < 28) {
            arrayList.add(js2.DYNAMIC);
            TaskManager.instance().add(h(PatchType.DYNAMIC, updateInfo.updateList.get(js2.DYNAMIC), str, z));
        }
        if (updateInfo.updateList.containsKey(js2.HOTPATCH)) {
            arrayList.add(js2.HOTPATCH);
            TaskManager.instance().add(h(PatchType.INSTANTPATCH, updateInfo.updateList.get(js2.HOTPATCH), str, z));
        }
        if (updateInfo.updateList.containsKey(js2.MAIN)) {
            arrayList.add(js2.MAIN);
            TaskManager.instance().add(h(PatchType.MAIN, updateInfo.updateList.get(js2.MAIN), str, z));
        }
        if (updateInfo.updateList.containsKey(js2.DEXPATCH) && Build.VERSION.SDK_INT < 28) {
            arrayList.add(js2.DEXPATCH);
            TaskManager.instance().add(h(PatchType.DEXPATCH, updateInfo.updateList.get(js2.DEXPATCH), str, z));
        }
        if (updateInfo.updateList.containsKey("bundle")) {
            arrayList.add("bundle");
            TaskManager.instance().add(h(PatchType.BUNDLES, updateInfo.updateList.get("bundle"), str, z));
        }
        if (addUpdateCallback != null) {
            addUpdateCallback.onAdded(arrayList);
        }
        if (!arrayList.contains(js2.MAIN) && !z && !str.equals(js2.SCAN) && listenerMap.containsKey(js2.MAIN)) {
            listenerMap.get(js2.MAIN).onUpdate(false, null, "");
        }
    }

    private UpdateInfo j(String str, String str2, String str3) {
        JSONObject parseObject = JSON.parseObject(str3);
        if (!TextUtils.isEmpty(str2) && str2.equals(js2.CACHE_SOURCE)) {
            return (UpdateInfo) JSON.parseObject(str3, UpdateInfo.class);
        }
        if (str.equals(js2.ACCS_SOURCE) || str.equals(js2.SAFE_MODE) || str.equals(js2.SCAN)) {
            if (parseObject != null && parseObject.containsKey("data")) {
                JSONObject jSONObject = parseObject.getJSONObject("data");
                boolean booleanValue = jSONObject.containsKey("hasUpdate") ? jSONObject.getBoolean("hasUpdate").booleanValue() : false;
                UpdateInfo convert2UpdateInfo = ns2.convert2UpdateInfo(jSONObject, str);
                if (!booleanValue || !n(convert2UpdateInfo)) {
                    return null;
                }
                return convert2UpdateInfo;
            }
        } else if (str.equalsIgnoreCase(js2.EMAS_PUBLISH)) {
            UpdateInfo convert2EmasUpdateInfo = ns2.convert2EmasUpdateInfo(parseObject, str);
            if (n(convert2EmasUpdateInfo)) {
                return convert2EmasUpdateInfo;
            }
        } else if (parseObject != null && parseObject.containsKey("hasUpdate") && parseObject.getBoolean("hasUpdate").booleanValue()) {
            UpdateInfo convert2UpdateInfo2 = ns2.convert2UpdateInfo(parseObject, str);
            if (n(convert2UpdateInfo2)) {
                return convert2UpdateInfo2;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean k() {
        return this.h.hasMessages(0) || this.h.hasMessages(1) || this.h.hasMessages(2) || this.h.hasMessages(3);
    }

    private void l(boolean z) {
        if (sUpdateAdapter.hasEmasPublish() && sUpdateAdapter.openEmasPublish()) {
            this.i.e("UpdateSDK use emas publish update");
            final String versionName = ns2.getVersionName();
            final HashMap hashMap = new HashMap();
            hashMap.put("cpuArch", String.valueOf(uo.getCpuArch()));
            if (!z) {
                boolean registerEmasPublishApi = sUpdateAdapter.registerEmasPublishApi(versionName, this.b, hashMap);
                Log log = this.i;
                log.e("regist emas apk update success ? " + registerEmasPublishApi);
            } else {
                new Thread(new Runnable() {
                    /* class com.taobao.update.datasource.UpdateDataSource.AnonymousClass3 */

                    public void run() {
                        List<PublishMtopUpdateInfo> list;
                        PublishMtopResponse pullEmasPublishApi = UpdateDataSource.sUpdateAdapter.pullEmasPublishApi(versionName, UpdateDataSource.this.b, hashMap);
                        if (pullEmasPublishApi == null || !pullEmasPublishApi.hasUpdate || (list = pullEmasPublishApi.updateInfo) == null || list.size() == 0) {
                            UpdateDataSource.getInstance().toast("您使用的版本已是最新的了哦!");
                            return;
                        }
                        PublishMtopUpdateInfo publishMtopUpdateInfo = pullEmasPublishApi.updateInfo.get(0);
                        if (publishMtopUpdateInfo != null && publishMtopUpdateInfo.payload != null) {
                            UpdateDataSource.this.b.dispatchUpdate(UpdateDataSource.this.b.from(), false, JSON.toJSONString(publishMtopUpdateInfo), new String[0]);
                        }
                    }
                }).start();
            }
            boolean registerEmasPublishApi2 = sUpdateAdapter.registerEmasPublishApi(versionName, this.c, null);
            Log log2 = this.i;
            log2.e("regist emas instantpatch update success?" + registerEmasPublishApi2);
            boolean registerEmasPublishApi3 = sUpdateAdapter.registerEmasPublishApi(versionName, this.d, null);
            Log log3 = this.i;
            log3.e("regist emas sopatch update success?" + registerEmasPublishApi3);
        }
        MtopUpdater mtopUpdater = (MtopUpdater) this.e.get(js2.MTOP_SOURCE);
        if (mtopUpdater != null) {
            mtopUpdater.setMtopDataListener(new b(z)).startUpdate(!z);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void m(UpdateInfo.UpdateData updateData, PatchType patchType) {
        Map<String, UpdateInfo.UpdateData> map;
        if (!TextUtils.isEmpty(updateData.subFrom) && updateData.subFrom.equals(js2.CACHE_SOURCE)) {
            UpdateInfo data = com.taobao.update.datasource.local.a.getInstance(sContext).getData();
            if (!(data == null || (map = data.updateList) == null)) {
                map.remove(patchType.getKey());
            }
            com.taobao.update.datasource.local.a.getInstance(sContext).resetData(data);
        }
    }

    private boolean n(UpdateInfo updateInfo) {
        Map<String, UpdateInfo.UpdateData> map;
        return (updateInfo == null || (map = updateInfo.updateList) == null || map.size() == 0) ? false : true;
    }

    public void addUpdateInfo(final String str) {
        new AsyncTask<Void, Void, Void>() {
            /* class com.taobao.update.datasource.UpdateDataSource.AnonymousClass6 */

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public Void doInBackground(Void... voidArr) {
                if (str.contains("get_bundle_install_data")) {
                    final UpdateListener updateListener = UpdateDataSource.listenerMap.get(js2.TEST_URL);
                    if (updateListener != null) {
                        TaskManager.instance().add(new qs1(PatchType.TESTURL, new PatchRunnable(updateListener) {
                            /* class com.taobao.update.datasource.UpdateDataSource.AnonymousClass6.AnonymousClass1 */

                            public void run() {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("url", (Object) str);
                                updateListener.onUpdate(false, jSONObject, js2.SCAN);
                            }
                        }, js2.SCAN, false));
                    }
                    if (UpdateDataSource.this.k()) {
                        UpdateDataSource.this.toast("已经有更新正在运行中");
                    } else {
                        UpdateDataSource.this.h.obtainMessage(2).sendToTarget();
                    }
                    return null;
                }
                String response = new xy0().getResponse(str);
                if (!TextUtils.isEmpty(response)) {
                    UpdateDataSource.this.onUpdate(js2.SCAN, null, false, response, new String[0]);
                }
                return null;
            }
        }.execute(new Void[0]);
    }

    public void clearCache() {
        com.taobao.update.datasource.local.a.getInstance(sContext).clearCache();
    }

    public Application getApplication() {
        return sContext;
    }

    public void getRecentData(boolean z) {
        Map<String, UpdateInfo.UpdateData> map;
        if (ns2.getProcessName(sContext) != null && ns2.getProcessName(sContext).contains(AXPParamsProvider.ClientType.YOUKU)) {
            l(true);
        }
        if (!z || sUpdateAdapter.subscribed) {
            UpdateInfo data = com.taobao.update.datasource.local.a.getInstance(sContext).getData();
            if (this.a.isLocalDataValid(data)) {
                String str = null;
                if (!(data == null || (map = data.updateList) == null)) {
                    for (UpdateInfo.UpdateData updateData : map.values()) {
                        updateData.subFrom = js2.CACHE_SOURCE;
                        str = updateData.from;
                    }
                }
                onUpdate(str, js2.CACHE_SOURCE, !z, JSON.toJSONString(data), new String[0]);
                return;
            }
            clearCache();
            l(z);
            return;
        }
        l(true);
    }

    public IUpdater getUpdater(String str) {
        return this.e.get(str);
    }

    public synchronized void init(Application application, String str, String str2, boolean z, fs2 fs2) {
        if (!inited) {
            inited = true;
            sGroup = str;
            sContext = application;
            sUpdateAdapter = fs2;
            this.a = new ms2();
            if (fs2.hasEmasPublish() && sUpdateAdapter.openEmasPublish()) {
                this.i.e("UpdateSDK use emas publish update init");
                EmasPublishService.getInstance().init(application, Boolean.valueOf(z), str, str2);
                this.b.registerDataListener(this);
                this.c.registerDataListener(this);
                this.d.registerDataListener(this);
            }
            MtopUpdater mtopUpdater = new MtopUpdater(application, str2, str, z);
            mtopUpdater.registerDataListener(this);
            this.e.put(js2.MTOP_SOURCE, mtopUpdater);
            if (fs2.hasAccs()) {
                u2 u2Var = new u2(sUpdateAdapter);
                u2Var.registerDataListener(this);
                this.e.put(js2.ACCS_SOURCE, u2Var);
                sUpdateAdapter.registerPushApi(application, u2Var);
            }
            this.i.d(" inited ");
        }
    }

    public void invalidUpdateInfo(String str) {
        UpdateInfo.UpdateData updateData;
        UpdateInfo data = com.taobao.update.datasource.local.a.getInstance(sContext).getData();
        if (data != null && (updateData = data.updateList.get(str)) != null) {
            updateData.valid = false;
            com.taobao.update.datasource.local.a.getInstance(sContext).updateData(data);
        }
    }

    @Override // com.taobao.update.datasource.data.UpdateDataListener
    public synchronized void onUpdate(String str, String str2, boolean z, String str3, String... strArr) {
        ms2 ms2;
        ms2 ms22 = this.a;
        if (ms22 == null) {
            this.i.e("no inited");
            return;
        }
        try {
            if (ms22.isUpdating()) {
                Log log = this.i;
                log.d("is updating ... discard data from:" + str);
                this.a.finishUpdate();
                return;
            }
            Log log2 = this.i;
            log2.d(" >>>>>> on " + str + " update info <<<<<<   " + str3);
            if (TextUtils.isEmpty(str3) || !inited) {
                this.a.finishUpdate();
                return;
            }
            UpdateInfo j2 = j(str, str2, str3);
            if (j2 == null) {
                this.i.e("updateInfo invalid!");
                if (!z && listenerMap.containsKey(js2.MAIN)) {
                    listenerMap.get(js2.MAIN).onUpdate(false, null, "");
                }
                this.a.finishUpdate();
                return;
            }
            this.a.startUpdate();
            if (str.equals(js2.SLIDE)) {
                com.taobao.update.datasource.local.a.getInstance(sContext).resetMemoryData(j2);
            } else if ((str.equals(js2.ACCS_SOURCE) || str.equals(js2.MTOP_SOURCE)) && TextUtils.isEmpty(str2)) {
                com.taobao.update.datasource.local.a.getInstance(sContext).resetData(j2);
            } else if (str.equals(js2.EMAS_PUBLISH) && TextUtils.isEmpty(str2)) {
                com.taobao.update.datasource.local.a.getInstance(sContext).resetData(j2);
            }
            if (k()) {
                this.i.e("handling msg......");
                if (str.equals(js2.SCAN)) {
                    toast("已经有更新正在运行中");
                } else {
                    this.a.finishUpdate();
                    return;
                }
            }
            Message obtainMessage = this.h.obtainMessage();
            if (str.equals(js2.SCAN)) {
                obtainMessage.what = 2;
            } else if (str.equals(js2.ACCS_SOURCE)) {
                obtainMessage.what = 0;
                sUpdateAdapter.commitSuccess("update_center_accs", "dispatch_message", "");
                if (strArr != null && strArr.length >= 1) {
                    sUpdateAdapter.commitSuccess("update_center_accs", "dispatch_message", strArr[0]);
                }
            } else if (str.equals(js2.SLIDE)) {
                obtainMessage.what = 3;
            } else if (str.equals(js2.SAFE_MODE)) {
                obtainMessage.what = 4;
            } else if (str.equals(js2.MTOP_SOURCE)) {
                sUpdateAdapter.commitSuccess("update_center_mtop", "mtop_dispatch_message", "");
                obtainMessage.what = 1;
            } else if (str.equals("NOTICE")) {
                obtainMessage.what = 5;
            } else if (str.equals(js2.EMAS_PUBLISH)) {
                obtainMessage.what = 6;
            }
            obtainMessage.obj = j2;
            Bundle bundle = new Bundle();
            bundle.putBoolean("background", z);
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
            ms2 = this.a;
            ms2.finishUpdate();
        } catch (Exception e2) {
            e2.printStackTrace();
            ms2 = this.a;
        } catch (Throwable th) {
            this.a.finishUpdate();
            throw th;
        }
    }

    public void registerListener(String str, UpdateListener updateListener) {
        listenerMap.put(str, updateListener);
    }

    public void setAddUpdateCallback(AddUpdateCallback addUpdateCallback) {
        this.g = addUpdateCallback;
    }

    public void startUpdate(final boolean z, boolean z2) {
        if (inited) {
            if (!this.j) {
                this.j = true;
                AnonymousClass5 r0 = new Runnable() {
                    /* class com.taobao.update.datasource.UpdateDataSource.AnonymousClass5 */

                    public void run() {
                        UpdateDataSource.this.getRecentData(!z);
                        UpdateDataSource.this.j = false;
                    }
                };
                if (z2) {
                    r0.run();
                } else {
                    sUpdateAdapter.executeThread(r0);
                }
            } else if (!z) {
                toast("已经有更新正在运行中");
            }
        }
    }

    public void toast(final String str) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.taobao.update.datasource.UpdateDataSource.AnonymousClass7 */

            public void run() {
                Toast.makeText(UpdateDataSource.sContext, str, 1).show();
            }
        });
    }
}
