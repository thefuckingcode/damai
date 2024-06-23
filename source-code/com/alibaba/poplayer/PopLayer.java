package com.alibaba.poplayer;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.poplayer.factory.view.base.PopLayerBaseView;
import com.alibaba.poplayer.layermanager.ILayerMgrAdapter;
import com.alibaba.poplayer.layermanager.PopRequest;
import com.alibaba.poplayer.layermanager.e;
import com.alibaba.poplayer.norm.IConfigAdapter;
import com.alibaba.poplayer.norm.IFaceAdapter;
import com.alibaba.poplayer.norm.ILogAdapter;
import com.alibaba.poplayer.trigger.BaseConfigItem;
import com.alibaba.poplayer.trigger.InternalTriggerController;
import com.alibaba.poplayer.trigger.view.d;
import com.alibaba.poplayer.utils.Monitor;
import com.youku.css.constraint.CssConst;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import tb.c7;
import tb.cr1;
import tb.dz0;
import tb.fo1;
import tb.hn1;
import tb.q61;

/* compiled from: Taobao */
public class PopLayer<K extends BaseConfigItem> {
    public static final String ACTION_FRAGMENT_SWITCH = "com.alibaba.poplayer.PopLayer.action.FRAGMENT_SWITCH";
    public static final String ACTION_NOTIFY_TRACKS_NAME = "PopLayer.TrackingView.Event";
    public static final String ACTION_OUT_DISMISS = "com.alibaba.poplayer.PopLayer.action.out.CLOSE";
    public static final String ACTION_OUT_DISPLAY = "com.alibaba.poplayer.PopLayer.action.out.DISPLAY";
    public static final String ACTION_POP = "com.alibaba.poplayer.PopLayer.action.POP";
    public static final String ACTION_TRACK_INFO_KEY_EVENT_NAME = "eventName";
    public static final String ACTION_TRACK_INFO_KEY_GROUPID = "groupId";
    public static final String ACTION_TRACK_INFO_KEY_OPERATION_NAME = "operationName";
    public static final String ACTION_TRACK_INFO_KEY_PARAMS = "params";
    public static final String EXTRA_KEY_EVENT = "event";
    public static final String EXTRA_KEY_EXTRA_PARAMS = "extra_params";
    public static final String EXTRA_KEY_FRAGMENT_NAME = "fragment_name";
    public static final String EXTRA_KEY_FRAGMENT_NEED_ACTIVITY_PARAM = "fragment_need_activity_param";
    public static final String EXTRA_KEY_FRAGMENT_PARAM = "fragment_param";
    public static final String EXTRA_KEY_PARAM = "param";
    public static final String SCHEMA = "poplayer";
    private static PopLayer sPoplayer;
    private static boolean sSetup;
    public boolean isLogOutputMode = false;
    final CopyOnWriteArraySet<String> mActivitiesMustBroadcastPop = new CopyOnWriteArraySet<>();
    @Monitor.TargetField(name = hn1.MONITOR_ADAPTER_VERSION)
    private String mAdapterVersion;
    @Monitor.TargetField(prefix = "App")
    private c7 mAppTriggerService;
    protected Map<Integer, IConfigAdapter> mConfigContainers;
    private Application mContext;
    @Monitor.TargetField(name = hn1.MONITOR_NATIVE_URL)
    private String mCurrentNativeUrl;
    protected final IFaceAdapter mFaceAdapter;
    private ArrayList<ILogAdapter> mILogAdapters;
    @Monitor.TargetField
    private ILayerMgrAdapter mLayerMgrAdapter;
    @Monitor.TargetField(prefix = "Page")
    private fo1 mPageTriggerService;
    @Monitor.TargetField
    private InternalTriggerController mTriggleController;
    @Monitor.TargetField(name = "version")
    private String mVersion;
    @Monitor.TargetField(prefix = CssConst.CssScenes.VIEW)
    private d mViewTriggerService;

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    /* compiled from: Taobao */
    public @interface PopupAllowedFromFragment {
        String tag() default "";
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    /* compiled from: Taobao */
    public @interface PopupOnlyManually {
        String tag() default "";
    }

    public PopLayer(IFaceAdapter iFaceAdapter, IConfigAdapter iConfigAdapter, IConfigAdapter iConfigAdapter2, IConfigAdapter iConfigAdapter3, ILayerMgrAdapter iLayerMgrAdapter) {
        HashMap hashMap = new HashMap(3);
        this.mConfigContainers = hashMap;
        this.mILogAdapters = null;
        this.mFaceAdapter = iFaceAdapter;
        hashMap.put(1, iConfigAdapter2);
        this.mConfigContainers.put(2, iConfigAdapter);
        this.mConfigContainers.put(3, iConfigAdapter3);
        this.mLayerMgrAdapter = iLayerMgrAdapter;
        if (sPoplayer == null) {
            sPoplayer = this;
        }
    }

    public static PopLayer getReference() {
        return sPoplayer;
    }

    public static boolean isSetup() {
        return sSetup;
    }

    public void acceptMsg(String str, Map<String, String> map, View view) {
        d.M().y(view, str, map);
    }

    public String getActivityInfo(Activity activity) {
        if (activity.getIntent() == null) {
            return null;
        }
        return activity.getIntent().getDataString();
    }

    public Application getApp() {
        return this.mContext;
    }

    public IConfigAdapter getConfigAdapter(int i) {
        return this.mConfigContainers.get(Integer.valueOf(i));
    }

    public long getCurrentTimeStamp() {
        return this.mFaceAdapter.getCurrentTimeStamp(this.mContext);
    }

    public IFaceAdapter getFaceAdapter() {
        return this.mFaceAdapter;
    }

    public Application.ActivityLifecycleCallbacks getLifecycleManager() {
        InternalTriggerController internalTriggerController = this.mTriggleController;
        if (internalTriggerController == null) {
            return null;
        }
        return internalTriggerController;
    }

    public ArrayList<ILogAdapter> getLogAdapters() {
        return this.mILogAdapters;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public Activity internalGetCurrentActivity() {
        return this.mTriggleController.c();
    }

    public void internalNotifyDismissedIfPopLayerView(PopLayerBaseView popLayerBaseView) {
        Intent intent = new Intent(ACTION_OUT_DISMISS);
        intent.putExtra("event", popLayerBaseView.getInfo());
        LocalBroadcastManager.getInstance(this.mContext).sendBroadcast(intent);
        cr1.b("PopLayer.dismiss.notify", new Object[0]);
        onDismissed(popLayerBaseView.getContext(), popLayerBaseView);
    }

    public void internalNotifyDisplayedIfPopLayerView(PopLayerBaseView popLayerBaseView) {
        Intent intent = new Intent(ACTION_OUT_DISPLAY);
        intent.putExtra("event", popLayerBaseView.getInfo());
        LocalBroadcastManager.getInstance(popLayerBaseView.getContext()).sendBroadcast(intent);
        cr1.b("PopLayer.display.notify", new Object[0]);
        onDisplayed(popLayerBaseView.getContext(), popLayerBaseView);
    }

    public void internalNotifyNativeUrlChanged(String str) {
        this.mCurrentNativeUrl = str;
        cr1.b("PopLayer.internalNotifyNativeUrlChanged.mCurrentNativeUrl{%s}", str);
    }

    public boolean isMunualPopPageContains(String str) {
        return this.mActivitiesMustBroadcastPop.contains(str);
    }

    public boolean isSamePage(Activity activity, Activity activity2) {
        boolean z;
        if (activity == null || activity2 == null || activity2 != activity) {
            return false;
        }
        Intent intent = activity2.getIntent();
        Intent intent2 = activity.getIntent();
        if (intent == null && intent2 == null) {
            cr1.b("PopLayer.isSamePage.curActivity: no intent ", new Object[0]);
        } else {
            if (!(intent == null || intent2 == null)) {
                String dataString = intent.getDataString();
                String dataString2 = intent2.getDataString();
                if (dataString == null && dataString2 == null) {
                    cr1.b("PopLayer.isSamePage.curActivity: no intent.dataString ", new Object[0]);
                } else if (!(dataString == null || dataString2 == null)) {
                    z = dataString.equals(dataString2);
                    cr1.b("PopLayer.isSamePage.curActivity: intent.dataString equal:%s", Boolean.valueOf(z));
                    cr1.b("PopLayer.isSamePage.curActivity == preActivity {%s}", Boolean.valueOf(z));
                    return z;
                }
            }
            z = false;
            cr1.b("PopLayer.isSamePage.curActivity == preActivity {%s}", Boolean.valueOf(z));
            return z;
        }
        z = true;
        cr1.b("PopLayer.isSamePage.curActivity == preActivity {%s}", Boolean.valueOf(z));
        return z;
    }

    public boolean isValidActivity(Activity activity) {
        return true;
    }

    public boolean isValidConfig(BaseConfigItem baseConfigItem) {
        return true;
    }

    public void onCurActivityInited() {
    }

    /* access modifiers changed from: protected */
    public void onDismissed(Context context, PopLayerBaseView popLayerBaseView) {
        cr1.b("PopLayer.onDismissed", new Object[0]);
    }

    /* access modifiers changed from: protected */
    public void onDisplayed(Context context, PopLayerBaseView popLayerBaseView) {
        cr1.b("PopLayer.onDisplayed", new Object[0]);
    }

    /* access modifiers changed from: protected */
    public String onGenarateAdapterVersion() {
        return "";
    }

    public void onPopped(int i, Context context, View view) {
        cr1.b("PopLayer.onPopped", new Object[0]);
    }

    public void registerLogAdapter(ILogAdapter iLogAdapter) {
        if (this.mILogAdapters == null) {
            this.mILogAdapters = new ArrayList<>();
        }
        if (!this.mILogAdapters.contains(iLogAdapter)) {
            this.mILogAdapters.add(iLogAdapter);
        }
        cr1.b("PopLayer.registerLogAdapter.", new Object[0]);
    }

    public boolean registerManualPopPage(Class<Activity> cls) {
        String name = cls.getName();
        boolean add = this.mActivitiesMustBroadcastPop.add(name);
        cr1.b("PopLayer.registerManualPopPage?activityClazz=%s.return?add=%s", name, Boolean.valueOf(add));
        return add;
    }

    public final void registerViewType(Class<? extends PopLayerBaseView> cls) {
        try {
            q61.b().c(cls);
            cr1.b("PopLayerAction.registerViewType success!", new Object[0]);
        } catch (Throwable th) {
            cr1.c("PopLayerAction.registerViewType fail!", th);
        }
    }

    public void removeMsg(String str, View view) {
        d.M().P(str, view);
    }

    public void removeRequest(PopRequest popRequest) {
        int b = popRequest.b();
        if (b == 1) {
            c7.A().q(popRequest);
        } else if (b == 2) {
            fo1.A().q(popRequest);
        } else if (b == 3) {
            d.M().q(popRequest);
        }
    }

    public void setup(Application application) {
        try {
            if (sSetup) {
                cr1.a("PopLayer.setup.alreadySetup");
                return;
            }
            this.mContext = application;
            this.mTriggleController = new InternalTriggerController(application);
            this.mAppTriggerService = c7.A();
            this.mPageTriggerService = fo1.A();
            this.mViewTriggerService = d.M();
            new e(this.mLayerMgrAdapter).e(application);
            this.mFaceAdapter.registerNavPreprocessor(application, this);
            this.mFaceAdapter.registerTrackViewTypes(application, this);
            for (Integer num : this.mConfigContainers.keySet()) {
                IConfigAdapter iConfigAdapter = this.mConfigContainers.get(num);
                iConfigAdapter.initializeConfigContainer(application, this);
                iConfigAdapter.addConfigObserver(application, this);
            }
            try {
                this.mVersion = getApp().getResources().getString(getApp().getResources().getIdentifier("poplayer_version", "string", getApp().getPackageName()));
            } catch (Throwable th) {
                this.mVersion = "";
                cr1.c("PopLayer.setup.version.error", th);
            }
            try {
                this.mAdapterVersion = onGenarateAdapterVersion();
            } catch (Throwable th2) {
                this.mAdapterVersion = "";
                cr1.c("PopLayer.setup.adapter_version.error", th2);
            }
            try {
                cr1.a = (this.mContext.getApplicationInfo().flags & 2) != 0;
            } catch (Exception unused) {
                cr1.a = false;
            }
            cr1.b("PopLayer.version{%s}.setup.success.debug{%s}", this.mVersion, Boolean.valueOf(cr1.a));
            sSetup = true;
        } catch (Throwable th3) {
            cr1.c("PopLayer.setup.fail" + th3.toString(), th3);
        }
    }

    public void switchLogMode(boolean z) {
        this.isLogOutputMode = z;
        cr1.b("PopLayer.switchLogMode:{%s}.", Boolean.valueOf(z));
    }

    public ArrayList<dz0<K>> tryOpenRequestControl(ArrayList<dz0<K>> arrayList) {
        return arrayList;
    }

    public boolean unregisterManualPopPage(Class<Activity> cls) {
        String name = cls.getName();
        boolean remove = this.mActivitiesMustBroadcastPop.remove(name);
        cr1.b("PopLayer.unregisterManualPopPage?activityClazz=%s.return?remove=%s", name, Boolean.valueOf(remove));
        return remove;
    }

    public void updateCacheConfigAsync(int i) {
        try {
            cr1.b("PopLayer.updateCacheConfigAsync Domain :" + Domain.toString(i), new Object[0]);
            if (i == 1) {
                c7.A().v(false, this.mContext);
            } else if (i == 2) {
                fo1.A().v(false, this.mContext);
            } else if (i == 3) {
                d.M().v(false, this.mContext);
            }
        } catch (Throwable th) {
            cr1.c("PopLayer.updateCacheConfigAsync.fail." + th.toString(), th);
        }
    }
}
