package com.youku.live.widgets.impl;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.dsl.log.IRemoteLog;
import com.youku.live.widgets.WidgetSDKEngine;
import com.youku.live.widgets.monitor.IPerfMonitor;
import com.youku.live.widgets.monitor.PerfMonitorImp;
import com.youku.live.widgets.protocol.IDataBridgeHandler;
import com.youku.live.widgets.protocol.IDataCenter;
import com.youku.live.widgets.protocol.IDataCenterController;
import com.youku.live.widgets.protocol.IDataHandler;
import com.youku.live.widgets.protocol.IDataPlugin;
import com.youku.live.widgets.protocol.IResult;
import com.youku.live.widgets.render.WorkerThread;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
public class BaseDataCenter implements IDataCenter, IDataCenterController {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TAG = "DataCenter";
    private static int mode = 1;
    private String instHashTag = ("BaseDataCenter@" + Integer.toHexString(hashCode()));
    private Map<String, Object> mDataMap;
    private Map<String, Object> mDataMapExtra;
    private Map<String, IDataPlugin> mDataPluginExtra;
    private Map<String, List<IDataHandler>> mHandlerMap;
    private Map<String, List<IDataHandler>> mHandlerMapExtra;
    private boolean mIsDestroying = false;
    private ILog mLogInstance;
    private Handler mMainHandler;

    private static void asyncMainThread(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-143946204")) {
            ipChange.ipc$dispatch("-143946204", new Object[]{runnable});
            return;
        }
        WidgetSDKEngine.getInstance().getRenderMananger().postOnUiThread(WorkerThread.secure(runnable));
    }

    private static void asyncWorkerThread(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "93386111")) {
            ipChange.ipc$dispatch("93386111", new Object[]{runnable});
            return;
        }
        WidgetSDKEngine.getInstance().getRenderMananger().postOnWorkerThread(WorkerThread.secure(runnable));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void broadcastOnceDataChanged(IDataHandler iDataHandler, String str, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-654453265")) {
            ipChange.ipc$dispatch("-654453265", new Object[]{this, iDataHandler, str, obj, obj2});
            return;
        }
        ILog logInstance = getLogInstance();
        if (logInstance != null) {
            logInstance.e(TAG, "broadcast: handler:" + iDataHandler + "; key:" + str + "; newData:" + obj + "; oldData:" + obj2 + ";");
        }
        if (iDataHandler != null) {
            try {
                iDataHandler.onDataChanged(str, obj, obj2);
            } catch (Throwable th) {
                logInstance.e(TAG, th.getMessage());
            }
        }
    }

    private static void executeRunnable(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-930101295")) {
            ipChange.ipc$dispatch("-930101295", new Object[]{runnable});
            return;
        }
        int i = mode;
        if (i == 0) {
            asyncWorkerThread(runnable);
        } else if (i == 1) {
            asyncMainThread(runnable);
        } else if (i == 2) {
            syncMainThread(runnable);
        }
    }

    private static void forceOnMainThread(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1461904438")) {
            ipChange.ipc$dispatch("1461904438", new Object[]{runnable});
        } else if (WorkerThread.isInMainThread()) {
            Runnable secure = WorkerThread.secure(runnable);
            if (secure != null) {
                secure.run();
            }
        } else {
            asyncWorkerThread(runnable);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private List<IDataHandler> getDataHandlerOfKey(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1165157066")) {
            return (List) ipChange.ipc$dispatch("-1165157066", new Object[]{this, str});
        }
        Map<String, List<IDataHandler>> handlerMap = getHandlerMap();
        List<IDataHandler> list = null;
        if (handlerMap.containsKey(str)) {
            list = handlerMap.get(str);
        }
        if (list != null) {
            return list;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        handlerMap.put(str, copyOnWriteArrayList);
        return copyOnWriteArrayList;
    }

    private List<IDataHandler> getDataHandlerOfKeyExtra(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1704270774")) {
            return (List) ipChange.ipc$dispatch("-1704270774", new Object[]{this, str});
        }
        Map<String, List<IDataHandler>> handlerMapExtra = getHandlerMapExtra();
        List<IDataHandler> list = null;
        if (handlerMapExtra.containsKey(str)) {
            list = handlerMapExtra.get(str);
        }
        if (list != null) {
            return list;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        handlerMapExtra.put(str, copyOnWriteArrayList);
        return copyOnWriteArrayList;
    }

    private Map<String, Object> getDataMap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "112019710")) {
            return (Map) ipChange.ipc$dispatch("112019710", new Object[]{this});
        }
        if (this.mDataMap == null) {
            synchronized (this) {
                if (this.mDataMap == null) {
                    this.mDataMap = new ConcurrentHashMap();
                }
            }
        }
        return this.mDataMap;
    }

    private Map<String, Object> getDataMapExtra() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "123393894")) {
            return (Map) ipChange.ipc$dispatch("123393894", new Object[]{this});
        }
        if (this.mDataMapExtra == null) {
            synchronized (this) {
                if (this.mDataMapExtra == null) {
                    this.mDataMapExtra = new ConcurrentHashMap();
                }
            }
        }
        return this.mDataMapExtra;
    }

    private Map<String, IDataPlugin> getDataPluginExtra() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1631351843")) {
            return (Map) ipChange.ipc$dispatch("-1631351843", new Object[]{this});
        }
        if (this.mDataPluginExtra == null) {
            synchronized (this) {
                if (this.mDataPluginExtra == null) {
                    this.mDataPluginExtra = new ConcurrentHashMap();
                }
            }
        }
        return this.mDataPluginExtra;
    }

    private Map<String, List<IDataHandler>> getHandlerMap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1615282322")) {
            return (Map) ipChange.ipc$dispatch("1615282322", new Object[]{this});
        }
        if (this.mHandlerMap == null) {
            synchronized (this) {
                if (this.mHandlerMap == null) {
                    this.mHandlerMap = new ConcurrentHashMap();
                }
            }
        }
        return this.mHandlerMap;
    }

    private Map<String, List<IDataHandler>> getHandlerMapExtra() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1055947858")) {
            return (Map) ipChange.ipc$dispatch("1055947858", new Object[]{this});
        }
        if (this.mHandlerMapExtra == null) {
            synchronized (this) {
                if (this.mHandlerMapExtra == null) {
                    this.mHandlerMapExtra = new ConcurrentHashMap();
                }
            }
        }
        return this.mHandlerMapExtra;
    }

    private ILog getLogInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1913314156")) {
            return (ILog) ipChange.ipc$dispatch("1913314156", new Object[]{this});
        }
        if (this.mLogInstance == null) {
            synchronized (this) {
                if (this.mLogInstance == null) {
                    this.mLogInstance = (ILog) Dsl.getService(IRemoteLog.class);
                }
            }
        }
        return this.mLogInstance;
    }

    private Handler getMainHandler() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1486165668")) {
            return (Handler) ipChange.ipc$dispatch("-1486165668", new Object[]{this});
        } else if (this.mIsDestroying) {
            return null;
        } else {
            if (this.mMainHandler == null) {
                this.mMainHandler = new Handler(Looper.getMainLooper());
            }
            return this.mMainHandler;
        }
    }

    private static void syncMainThread(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-392271035")) {
            ipChange.ipc$dispatch("-392271035", new Object[]{runnable});
            return;
        }
        Runnable secure = WorkerThread.secure(runnable);
        if (secure != null) {
            secure.run();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void syncPutDataImp(String str, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-856760483")) {
            ipChange.ipc$dispatch("-856760483", new Object[]{this, str, obj});
            return;
        }
        syncPutDataImp(str, obj, true);
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void addDataHandler(final String str, final IDataHandler iDataHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2124924320")) {
            ipChange.ipc$dispatch("-2124924320", new Object[]{this, str, iDataHandler});
            return;
        }
        final IPerfMonitor createInstance = PerfMonitorImp.createInstance(TAG, this.instHashTag);
        final String str2 = "addDataHandler: key:" + str + "; handler:" + iDataHandler + ";";
        forceOnMainThread(new Runnable() {
            /* class com.youku.live.widgets.impl.BaseDataCenter.AnonymousClass11 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "263369166")) {
                    ipChange.ipc$dispatch("263369166", new Object[]{this});
                } else if (iDataHandler != null) {
                    String str = str;
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                    BaseDataCenter.this.getDataHandlerOfKey(str).add(iDataHandler);
                    Object data = BaseDataCenter.this.getData(str);
                    if (data != null) {
                        BaseDataCenter.this.broadcastOnceDataChanged(iDataHandler, str, data, null);
                    }
                    IPerfMonitor iPerfMonitor = createInstance;
                    if (iPerfMonitor != null) {
                        iPerfMonitor.point(BaseDataCenter.TAG, str2).destroy();
                    }
                }
            }
        });
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void addDataHandlers(final String[] strArr, final IDataHandler iDataHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-862032034")) {
            ipChange.ipc$dispatch("-862032034", new Object[]{this, strArr, iDataHandler});
            return;
        }
        final IPerfMonitor createInstance = PerfMonitorImp.createInstance(TAG, this.instHashTag);
        final String str = "addDataHandlers: keyArray:" + strArr + "; handler:" + iDataHandler + ";";
        forceOnMainThread(new Runnable() {
            /* class com.youku.live.widgets.impl.BaseDataCenter.AnonymousClass9 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                String[] strArr;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1774758757")) {
                    ipChange.ipc$dispatch("1774758757", new Object[]{this});
                } else if (iDataHandler != null && (strArr = strArr) != null) {
                    for (String str : strArr) {
                        if (TextUtils.isEmpty(str)) {
                            str = "";
                        }
                        BaseDataCenter.this.getDataHandlerOfKey(str).add(iDataHandler);
                        Object data = BaseDataCenter.this.getData(str);
                        if (data != null) {
                            BaseDataCenter.this.broadcastOnceDataChanged(iDataHandler, str, data, null);
                        }
                    }
                    IPerfMonitor iPerfMonitor = createInstance;
                    if (iPerfMonitor != null) {
                        iPerfMonitor.point(BaseDataCenter.TAG, str).destroy();
                    }
                }
            }
        });
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void asyncPutData(final String str, final Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1038335470")) {
            ipChange.ipc$dispatch("1038335470", new Object[]{this, str, obj});
            return;
        }
        final IPerfMonitor createInstance = PerfMonitorImp.createInstance(TAG, this.instHashTag);
        final String str2 = "asyncPutData: key:" + str + "; newData:" + obj + ";";
        executeRunnable(new Runnable() {
            /* class com.youku.live.widgets.impl.BaseDataCenter.AnonymousClass7 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2127181529")) {
                    ipChange.ipc$dispatch("-2127181529", new Object[]{this});
                    return;
                }
                BaseDataCenter.this.syncPutDataImp(str, obj);
                IPerfMonitor iPerfMonitor = createInstance;
                if (iPerfMonitor != null) {
                    iPerfMonitor.point(BaseDataCenter.TAG, str2).destroy();
                }
            }
        });
    }

    @Override // com.youku.live.widgets.protocol.IDataCenterController
    public void clearDataCache() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "849664794")) {
            ipChange.ipc$dispatch("849664794", new Object[]{this});
            return;
        }
        IPerfMonitor createInstance = PerfMonitorImp.createInstance(TAG, this.instHashTag);
        getDataMap().clear();
        getDataMapExtra().clear();
        if (createInstance != null) {
            createInstance.point(TAG, "clearDataCache;").destroy();
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataCenterController
    public void clearDataHandler() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1798586222")) {
            ipChange.ipc$dispatch("-1798586222", new Object[]{this});
            return;
        }
        IPerfMonitor createInstance = PerfMonitorImp.createInstance(TAG, this.instHashTag);
        Map<String, List<IDataHandler>> handlerMap = getHandlerMap();
        if (handlerMap != null) {
            for (Map.Entry<String, List<IDataHandler>> entry : handlerMap.entrySet()) {
                List<IDataHandler> value = entry.getValue();
                if (value != null) {
                    value.clear();
                }
            }
            handlerMap.clear();
        }
        if (createInstance != null) {
            createInstance.point(TAG, "clearDataHandler;").destroy();
        }
    }

    @Override // com.youku.live.widgets.protocol.IDestroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "981080459")) {
            ipChange.ipc$dispatch("981080459", new Object[]{this});
            return;
        }
        this.mIsDestroying = true;
        clearDataCache();
        clearDataHandler();
        Handler handler = this.mMainHandler;
        this.mMainHandler = null;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public Object getData(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "331729123")) {
            return ipChange.ipc$dispatch("331729123", new Object[]{this, str});
        }
        IPerfMonitor createInstance = PerfMonitorImp.createInstance(TAG, this.instHashTag);
        String str2 = "getData: key:" + str + ";";
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        Object obj = getDataMap().get(str);
        if (createInstance != null) {
            createInstance.point(TAG, str2).destroy();
        }
        return obj;
    }

    public Object getDataExtra(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-732491981")) {
            return ipChange.ipc$dispatch("-732491981", new Object[]{this, str});
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return getDataMapExtra().get(str);
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void putData(final String str, final Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1359714034")) {
            ipChange.ipc$dispatch("1359714034", new Object[]{this, str, obj});
            return;
        }
        final IPerfMonitor createInstance = PerfMonitorImp.createInstance(TAG, this.instHashTag);
        final String str2 = "putData: key:" + str + "; newData:" + obj + ";";
        if (WorkerThread.isInMainThread()) {
            syncPutDataImp(str, obj);
            if (createInstance != null) {
                createInstance.point(TAG, str2).destroy();
                return;
            }
            return;
        }
        asyncMainThread(new Runnable() {
            /* class com.youku.live.widgets.impl.BaseDataCenter.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1144614004")) {
                    ipChange.ipc$dispatch("-1144614004", new Object[]{this});
                    return;
                }
                BaseDataCenter.this.syncPutDataImp(str, obj);
                IPerfMonitor iPerfMonitor = createInstance;
                if (iPerfMonitor != null) {
                    iPerfMonitor.point(BaseDataCenter.TAG, str2).destroy();
                }
            }
        });
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void putDataOnly(final String str, final Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1861046822")) {
            ipChange.ipc$dispatch("1861046822", new Object[]{this, str, obj});
            return;
        }
        final IPerfMonitor createInstance = PerfMonitorImp.createInstance(TAG, this.instHashTag);
        final String str2 = "putDataOnly: key:" + str + "; newData:" + obj + ";";
        if (WorkerThread.isInMainThread()) {
            syncPutDataImp(str, obj, false);
            if (createInstance != null) {
                createInstance.point(TAG, str2).destroy();
                return;
            }
            return;
        }
        asyncMainThread(new Runnable() {
            /* class com.youku.live.widgets.impl.BaseDataCenter.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1341127509")) {
                    ipChange.ipc$dispatch("-1341127509", new Object[]{this});
                    return;
                }
                BaseDataCenter.this.syncPutDataImp((BaseDataCenter) str, (String) obj, (Object) false);
                IPerfMonitor iPerfMonitor = createInstance;
                if (iPerfMonitor != null) {
                    iPerfMonitor.point(BaseDataCenter.TAG, str2).destroy();
                }
            }
        });
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void removeData(final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1218235937")) {
            ipChange.ipc$dispatch("1218235937", new Object[]{this, str});
            return;
        }
        final IPerfMonitor createInstance = PerfMonitorImp.createInstance(TAG, this.instHashTag);
        final String str2 = "removeData: key:" + str + ";";
        executeRunnable(new Runnable() {
            /* class com.youku.live.widgets.impl.BaseDataCenter.AnonymousClass6 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1930668024")) {
                    ipChange.ipc$dispatch("-1930668024", new Object[]{this});
                    return;
                }
                BaseDataCenter.this.syncPutDataImp((BaseDataCenter) str, (String) null, (Object) false);
                IPerfMonitor iPerfMonitor = createInstance;
                if (iPerfMonitor != null) {
                    iPerfMonitor.point(BaseDataCenter.TAG, str2).destroy();
                }
            }
        });
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void removeDataHandler(final String str, final IDataHandler iDataHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "611426211")) {
            ipChange.ipc$dispatch("611426211", new Object[]{this, str, iDataHandler});
            return;
        }
        final IPerfMonitor createInstance = PerfMonitorImp.createInstance(TAG, this.instHashTag);
        final String str2 = "removeDataHandler: key:" + str + "; handler:" + iDataHandler + ";";
        forceOnMainThread(new Runnable() {
            /* class com.youku.live.widgets.impl.BaseDataCenter.AnonymousClass12 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "66855661")) {
                    ipChange.ipc$dispatch("66855661", new Object[]{this});
                } else if (iDataHandler != null) {
                    String str = str;
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                    List dataHandlerOfKey = BaseDataCenter.this.getDataHandlerOfKey(str);
                    if (dataHandlerOfKey != null && dataHandlerOfKey.contains(iDataHandler)) {
                        dataHandlerOfKey.remove(iDataHandler);
                    }
                    IPerfMonitor iPerfMonitor = createInstance;
                    if (iPerfMonitor != null) {
                        iPerfMonitor.point(BaseDataCenter.TAG, str2).destroy();
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void syncPutDataImp(String str, Object obj, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-789725417")) {
            ipChange.ipc$dispatch("-789725417", new Object[]{this, str, obj, Boolean.valueOf(z)});
            return;
        }
        IPerfMonitor createInstance = PerfMonitorImp.createInstance(TAG, this.instHashTag);
        String str2 = "syncPutDataImp: key:" + str + "; value:" + obj + "; broadcast:" + z + ";";
        String str3 = TextUtils.isEmpty(str) ? "" : str;
        Object obj2 = getDataMap().get(str);
        if (obj != null) {
            getDataMap().put(str3, obj);
            getDataMapExtra().put(str3, obj);
        } else {
            getDataMap().remove(str3);
            getDataMapExtra().remove(str3);
        }
        if (z) {
            for (IDataHandler iDataHandler : getDataHandlerOfKey(str3)) {
                if (iDataHandler != null) {
                    broadcastOnceDataChanged(iDataHandler, str3, obj, obj2);
                }
            }
        }
        if (createInstance != null) {
            createInstance.point(TAG, str2).destroy();
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void addDataHandler(final String str, final IDataBridgeHandler iDataBridgeHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-840416951")) {
            ipChange.ipc$dispatch("-840416951", new Object[]{this, str, iDataBridgeHandler});
            return;
        }
        final IPerfMonitor createInstance = PerfMonitorImp.createInstance(TAG, this.instHashTag);
        final String str2 = "addDataHandler: key:" + str + "; handler:" + iDataBridgeHandler + ";";
        executeRunnable(new Runnable() {
            /* class com.youku.live.widgets.impl.BaseDataCenter.AnonymousClass15 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-522684854")) {
                    ipChange.ipc$dispatch("-522684854", new Object[]{this});
                } else if (iDataBridgeHandler != null) {
                    String str = str;
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                    BaseDataCenter.this.getDataHandlerOfKey(str).add(iDataBridgeHandler);
                    Object dataExtra = BaseDataCenter.this.getDataExtra(str);
                    if (dataExtra != null) {
                        BaseDataCenter.this.broadcastOnceDataChanged(iDataBridgeHandler, str, dataExtra, null);
                    }
                    IPerfMonitor iPerfMonitor = createInstance;
                    if (iPerfMonitor != null) {
                        iPerfMonitor.point(BaseDataCenter.TAG, str2).destroy();
                    }
                }
            }
        });
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void addDataHandlers(final List<String> list, final IDataHandler iDataHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "448105842")) {
            ipChange.ipc$dispatch("448105842", new Object[]{this, list, iDataHandler});
            return;
        }
        final IPerfMonitor createInstance = PerfMonitorImp.createInstance(TAG, this.instHashTag);
        final String str = "addDataHandlers: keyList:" + list + "; handler:" + iDataHandler + ";";
        forceOnMainThread(new Runnable() {
            /* class com.youku.live.widgets.impl.BaseDataCenter.AnonymousClass10 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                List<String> list;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "459882671")) {
                    ipChange.ipc$dispatch("459882671", new Object[]{this});
                } else if (iDataHandler != null && (list = list) != null) {
                    for (String str : list) {
                        if (TextUtils.isEmpty(str)) {
                            str = "";
                        }
                        BaseDataCenter.this.getDataHandlerOfKey(str).add(iDataHandler);
                        Object data = BaseDataCenter.this.getData(str);
                        if (data != null) {
                            BaseDataCenter.this.broadcastOnceDataChanged(iDataHandler, str, data, null);
                        }
                    }
                    IPerfMonitor iPerfMonitor = createInstance;
                    if (iPerfMonitor != null) {
                        iPerfMonitor.point(BaseDataCenter.TAG, str).destroy();
                    }
                }
            }
        });
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void asyncPutData(final String str, final Object obj, final Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-554086838")) {
            ipChange.ipc$dispatch("-554086838", new Object[]{this, str, obj, obj2});
            return;
        }
        final IPerfMonitor createInstance = PerfMonitorImp.createInstance(TAG, this.instHashTag);
        final String str2 = "asyncPutData: key:" + str + "; newData:" + obj + "; bridgeData:" + obj2 + ";";
        executeRunnable(new Runnable() {
            /* class com.youku.live.widgets.impl.BaseDataCenter.AnonymousClass8 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1971272262")) {
                    ipChange.ipc$dispatch("1971272262", new Object[]{this});
                    return;
                }
                BaseDataCenter.this.syncPutDataImp((BaseDataCenter) str, (String) obj, obj2);
                IPerfMonitor iPerfMonitor = createInstance;
                if (iPerfMonitor != null) {
                    iPerfMonitor.point(BaseDataCenter.TAG, str2).destroy();
                }
            }
        });
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void getData(final String str, final IResult iResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1008511084")) {
            ipChange.ipc$dispatch("-1008511084", new Object[]{this, str, iResult});
            return;
        }
        final IPerfMonitor createInstance = PerfMonitorImp.createInstance(TAG, this.instHashTag);
        final String str2 = "getData: key:" + str + "; callback:" + iResult + ";";
        if (iResult != null) {
            executeRunnable(new Runnable() {
                /* class com.youku.live.widgets.impl.BaseDataCenter.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-948100499")) {
                        ipChange.ipc$dispatch("-948100499", new Object[]{this});
                        return;
                    }
                    Object data = BaseDataCenter.this.getData(str);
                    HashMap hashMap = new HashMap();
                    hashMap.put(str, data);
                    iResult.onResult(hashMap);
                    IPerfMonitor iPerfMonitor = createInstance;
                    if (iPerfMonitor != null) {
                        iPerfMonitor.point(BaseDataCenter.TAG, str2).destroy();
                    }
                }
            });
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void addDataHandlers(final String[] strArr, final IDataBridgeHandler iDataBridgeHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1294352327")) {
            ipChange.ipc$dispatch("1294352327", new Object[]{this, strArr, iDataBridgeHandler});
            return;
        }
        final IPerfMonitor createInstance = PerfMonitorImp.createInstance(TAG, this.instHashTag);
        final String str = "addDataHandlers: keyArray:" + strArr + "; handler:" + iDataBridgeHandler + ";";
        executeRunnable(new Runnable() {
            /* class com.youku.live.widgets.impl.BaseDataCenter.AnonymousClass13 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                String[] strArr;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-129657844")) {
                    ipChange.ipc$dispatch("-129657844", new Object[]{this});
                } else if (iDataBridgeHandler != null && (strArr = strArr) != null) {
                    for (String str : strArr) {
                        if (TextUtils.isEmpty(str)) {
                            str = "";
                        }
                        BaseDataCenter.this.getDataHandlerOfKey(str).add(iDataBridgeHandler);
                        Object dataExtra = BaseDataCenter.this.getDataExtra(str);
                        if (dataExtra != null) {
                            BaseDataCenter.this.broadcastOnceDataChanged(iDataBridgeHandler, str, dataExtra, null);
                        }
                    }
                    IPerfMonitor iPerfMonitor = createInstance;
                    if (iPerfMonitor != null) {
                        iPerfMonitor.point(BaseDataCenter.TAG, str).destroy();
                    }
                }
            }
        });
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void putData(final String str, final Object obj, final Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1176080818")) {
            ipChange.ipc$dispatch("-1176080818", new Object[]{this, str, obj, obj2});
            return;
        }
        final IPerfMonitor createInstance = PerfMonitorImp.createInstance(TAG, this.instHashTag);
        final String str2 = "putData: key:" + str + "; newData:" + obj + "; bridgeData:" + obj2 + ";";
        if (WorkerThread.isInMainThread()) {
            syncPutDataImp(str, obj, obj2);
            if (createInstance != null) {
                createInstance.point(TAG, str2).destroy();
                return;
            }
            return;
        }
        asyncMainThread(new Runnable() {
            /* class com.youku.live.widgets.impl.BaseDataCenter.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1537641014")) {
                    ipChange.ipc$dispatch("-1537641014", new Object[]{this});
                    return;
                }
                BaseDataCenter.this.syncPutDataImp((BaseDataCenter) str, (String) obj, obj2);
                IPerfMonitor iPerfMonitor = createInstance;
                if (iPerfMonitor != null) {
                    iPerfMonitor.point(BaseDataCenter.TAG, str2).destroy();
                }
            }
        });
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void putDataOnly(final String str, final Object obj, final Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1114946430")) {
            ipChange.ipc$dispatch("-1114946430", new Object[]{this, str, obj, obj2});
            return;
        }
        final IPerfMonitor createInstance = PerfMonitorImp.createInstance(TAG, this.instHashTag);
        final String str2 = "putDataOnly: key:" + str + "; newData:" + obj + ";";
        if (WorkerThread.isInMainThread()) {
            syncPutDataImp(str, obj, obj2, false);
            if (createInstance != null) {
                createInstance.point(TAG, str2).destroy();
                return;
            }
            return;
        }
        asyncMainThread(new Runnable() {
            /* class com.youku.live.widgets.impl.BaseDataCenter.AnonymousClass5 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1734154519")) {
                    ipChange.ipc$dispatch("-1734154519", new Object[]{this});
                    return;
                }
                BaseDataCenter.this.syncPutDataImp(str, obj, obj2, false);
                IPerfMonitor iPerfMonitor = createInstance;
                if (iPerfMonitor != null) {
                    iPerfMonitor.point(BaseDataCenter.TAG, str2).destroy();
                }
            }
        });
    }

    @Override // com.youku.live.widgets.protocol.IDataCenter
    public void addDataHandlers(final List<String> list, final IDataBridgeHandler iDataBridgeHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1964278053")) {
            ipChange.ipc$dispatch("-1964278053", new Object[]{this, list, iDataBridgeHandler});
            return;
        }
        final IPerfMonitor createInstance = PerfMonitorImp.createInstance(TAG, this.instHashTag);
        final String str = "addDataHandlers: keyList:" + list + "; handler:" + iDataBridgeHandler + ";";
        executeRunnable(new Runnable() {
            /* class com.youku.live.widgets.impl.BaseDataCenter.AnonymousClass14 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                List<String> list;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-326171349")) {
                    ipChange.ipc$dispatch("-326171349", new Object[]{this});
                } else if (iDataBridgeHandler != null && (list = list) != null) {
                    for (String str : list) {
                        if (TextUtils.isEmpty(str)) {
                            str = "";
                        }
                        BaseDataCenter.this.getDataHandlerOfKey(str).add(iDataBridgeHandler);
                        Object dataExtra = BaseDataCenter.this.getDataExtra(str);
                        if (dataExtra != null) {
                            BaseDataCenter.this.broadcastOnceDataChanged(iDataBridgeHandler, str, dataExtra, null);
                        }
                    }
                    IPerfMonitor iPerfMonitor = createInstance;
                    if (iPerfMonitor != null) {
                        iPerfMonitor.point(BaseDataCenter.TAG, str).destroy();
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Object syncPutDataImp(String str, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2020709977")) {
            return syncPutDataImp(str, obj, obj2, true);
        }
        return ipChange.ipc$dispatch("2020709977", new Object[]{this, str, obj, obj2});
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Object syncPutDataImp(String str, Object obj, Object obj2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1412084585")) {
            return ipChange.ipc$dispatch("-1412084585", new Object[]{this, str, obj, obj2, Boolean.valueOf(z)});
        }
        IPerfMonitor createInstance = PerfMonitorImp.createInstance(TAG, this.instHashTag);
        String str2 = "syncPutDataImp: key:" + str + "; value:" + obj + "; value:" + obj2 + "; broadcast:" + z + ";";
        String str3 = TextUtils.isEmpty(str) ? "" : str;
        Object obj3 = getDataMap().get(str);
        if (obj != null) {
            getDataMap().put(str3, obj);
        } else {
            getDataMap().remove(str3);
        }
        if (obj2 != null) {
            getDataMapExtra().put(str3, obj2);
        } else {
            getDataMapExtra().remove(str3);
        }
        if (z) {
            for (IDataHandler iDataHandler : getDataHandlerOfKey(str3)) {
                if (iDataHandler instanceof IDataBridgeHandler) {
                    broadcastOnceDataChanged(iDataHandler, str3, obj2, obj3);
                } else {
                    broadcastOnceDataChanged(iDataHandler, str3, obj, obj3);
                }
            }
        }
        if (createInstance != null) {
            createInstance.point(TAG, str2).destroy();
        }
        return obj3;
    }
}
