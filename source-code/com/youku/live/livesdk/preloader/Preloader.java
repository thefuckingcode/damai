package com.youku.live.livesdk.preloader;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.net.mtop.netfit.ERROR;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.Constants;
import com.youku.live.arch.theadpool.LiveWorkerThreadPool;
import com.youku.live.arch.theadpool.PriorityRunnable;
import com.youku.live.arch.utils.CDNHelper;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.app.IAppInfo;
import com.youku.live.dsl.config.IRemoteConfig;
import com.youku.live.dsl.config.OptConfigUtils;
import com.youku.live.dsl.json.IDeserialize;
import com.youku.live.dsl.log.ILog;
import com.youku.live.dsl.log.IRemoteLog;
import com.youku.live.dsl.log.PerfLogUtils;
import com.youku.live.dsl.network.IRequest;
import com.youku.live.dsl.network.IRequestCallback;
import com.youku.live.dsl.network.IRequestFactory;
import com.youku.live.dsl.network.IResponse;
import com.youku.live.dsl.oss.IXOSSProcessFormaterImp;
import com.youku.live.dsl.pages.ILaifengManagerInterface;
import com.youku.live.dsl.preloader.IPreloader;
import com.youku.live.dsl.preloader.IPreloaderMananger;
import com.youku.live.livesdk.LiveActivity;
import com.youku.live.livesdk.LiveRoomConstants;
import com.youku.live.livesdk.R;
import com.youku.live.livesdk.ailp.AilpSDK;
import com.youku.live.livesdk.constants.ImageConstants;
import com.youku.live.livesdk.constants.SDKConstants;
import com.youku.live.livesdk.constants.SchemaConstants;
import com.youku.live.livesdk.dago.DagoSDK;
import com.youku.live.livesdk.laifeng.LaifengSDK;
import com.youku.live.livesdk.model.mtop.LiveFullInfoV4;
import com.youku.live.livesdk.model.mtop.data.LiveFullInfoData;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.LiveBundleLayout;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.TemplateDTO;
import com.youku.live.livesdk.monitor.AbsYoukuLiveAlarm;
import com.youku.live.livesdk.monitor.PreloaderTemplateCacheAlarm;
import com.youku.live.livesdk.monitor.performance.YoukuLivePerformance;
import com.youku.live.livesdk.monitor.performance.YoukuLivePerformanceConstants;
import com.youku.live.livesdk.monitor.performance.YoukuLivePerformanceManager;
import com.youku.live.livesdk.preloader.PlayInfoModel;
import com.youku.live.livesdk.preloader.templates.TemplateCacheMananger;
import com.youku.live.livesdk.pretch.LiveSdkPreloader;
import com.youku.live.livesdk.util.DebugHelp;
import com.youku.live.livesdk.util.DebugViewHelper;
import com.youku.live.livesdk.util.LivePerfUtils;
import com.youku.live.livesdk.widgets.helper.MtopDataHelper;
import com.youku.live.livesdk.wkit.utils.BlackUtil;
import com.youku.live.livesdk.wkit.utils.DpUtil;
import com.youku.live.messagechannel.utils.MyLog;
import com.youku.live.widgets.WidgetSDKEngine;
import com.youku.live.widgets.monitor.IPerfMonitor;
import com.youku.live.widgets.monitor.PerfMonitorImp;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import tb.tp1;
import tb.ug2;

/* compiled from: Taobao */
public class Preloader {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String KEY_JSON = "json";
    public static final String KEY_MODEL = "model";
    public static final String KEY_RESULT = "result";
    public static final String KEY_SESSION = "session";
    public static final String KEY_SUCCESS = "success";
    private static final String OGC_TEMPLATE_ID = "13";
    private static final String ORANGE_NAMESPACE_YKLIVEROOM_ABTEST = "YKLiveRoom_ABTest";
    private static final String TAG = "LivePreloader";
    private static final String TYPE_LANDSCAPE = "landScape";
    private static final String TYPE_PORTRAIT = "vertical";
    private static final String VALUE_LIVEIDS_TOTAL = "*";
    private static Preloader sPreloader;
    private volatile boolean isFromAppColdStart = false;
    private Map<String, AbsData> mCache;
    private Map<String, Drawable> mPreloadDrawables = new HashMap();
    private volatile Map<String, String> paramsFromAppColdStart;
    private IPerfMonitor perfMonitor = PerfMonitorImp.createInstance("LiveSdkPreloader", this);

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class AbsData implements IData, IDataController {
        private boolean isFinish;
        private boolean isSuccess;
        private JSONObject json;
        private Object model;
        private IResult result;
        private String sessionId;

        public AbsData() {
        }

        @Override // com.youku.live.livesdk.preloader.Preloader.IData
        public JSONObject getJson() {
            return this.json;
        }

        @Override // com.youku.live.livesdk.preloader.Preloader.IData
        public Object getModel() {
            return this.model;
        }

        @Override // com.youku.live.livesdk.preloader.Preloader.IData
        public IResult getResultCallback() {
            return this.result;
        }

        @Override // com.youku.live.livesdk.preloader.Preloader.IData
        public String getSessionId() {
            return this.sessionId;
        }

        @Override // com.youku.live.livesdk.preloader.Preloader.IData
        public boolean isFinish() {
            return this.isFinish;
        }

        @Override // com.youku.live.livesdk.preloader.Preloader.IData
        public boolean isSuccess() {
            return this.isSuccess;
        }

        @Override // com.youku.live.livesdk.preloader.Preloader.IDataController
        public IDataController setFinish(boolean z) {
            this.isFinish = z;
            return this;
        }

        @Override // com.youku.live.livesdk.preloader.Preloader.IDataController
        public IDataController setJson(JSONObject jSONObject) {
            this.json = jSONObject;
            return this;
        }

        @Override // com.youku.live.livesdk.preloader.Preloader.IDataController
        public IDataController setModel(Object obj) {
            this.model = obj;
            return this;
        }

        @Override // com.youku.live.livesdk.preloader.Preloader.IDataController
        public IDataController setResultCallback(IResult iResult) {
            this.result = iResult;
            return this;
        }

        @Override // com.youku.live.livesdk.preloader.Preloader.IDataController
        public IDataController setSessionId(String str) {
            this.sessionId = str;
            return this;
        }

        @Override // com.youku.live.livesdk.preloader.Preloader.IDataController
        public IDataController setSuccess(boolean z) {
            this.isSuccess = z;
            return this;
        }

        public AbsData(IData iData) {
            if (iData != null) {
                setFinish(iData.isFinish());
                setSuccess(iData.isSuccess());
                setModel(iData.getModel());
                setJson(iData.getJson());
                setSessionId(iData.getSessionId());
                setResultCallback(iData.getResultCallback());
            }
        }
    }

    /* compiled from: Taobao */
    public interface IData {
        JSONObject getJson();

        Object getModel();

        IResult getResultCallback();

        String getSessionId();

        boolean isFinish();

        boolean isSuccess();
    }

    /* compiled from: Taobao */
    public interface IDataController {
        IDataController setFinish(boolean z);

        IDataController setJson(JSONObject jSONObject);

        IDataController setModel(Object obj);

        IDataController setResultCallback(IResult iResult);

        IDataController setSessionId(String str);

        IDataController setSuccess(boolean z);
    }

    /* compiled from: Taobao */
    public interface IResult {
        void onResult(IData iData);
    }

    private boolean abtestTrimNavigatorUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1423774535")) {
            return OptConfigUtils.getConfig("trimNavigatorUrl", true);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1423774535", new Object[]{this})).booleanValue();
    }

    public static String genSessionId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "163778559")) {
            return (String) ipChange.ipc$dispatch("163778559", new Object[0]);
        }
        return "" + System.currentTimeMillis() + "" + Math.floor(Math.random() * 10.0d);
    }

    private Map<String, AbsData> getCache() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "97001515")) {
            return (Map) ipChange.ipc$dispatch("97001515", new Object[]{this});
        }
        if (this.mCache == null) {
            synchronized (this) {
                if (this.mCache == null) {
                    this.mCache = new ConcurrentHashMap();
                }
            }
        }
        return this.mCache;
    }

    @Nullable
    private Drawable getDefaultPreViewDrawable(Context context, boolean z, boolean z2) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1042573183")) {
            return (Drawable) ipChange.ipc$dispatch("1042573183", new Object[]{this, context, Boolean.valueOf(z), Boolean.valueOf(z2)});
        }
        if (!z2) {
            try {
                i = ((ILaifengManagerInterface) Dsl.getService(ILaifengManagerInterface.class)).getDefaultCoverDrawable(z);
            } catch (Exception unused) {
                i = -1;
            }
        } else {
            i = R.drawable.dago_yklive_back_cover_place_holder;
        }
        if (context == null || i == -1) {
            return null;
        }
        return context.getResources().getDrawable(i);
    }

    public static Preloader getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-48772997")) {
            return (Preloader) ipChange.ipc$dispatch("-48772997", new Object[0]);
        }
        if (sPreloader == null) {
            synchronized (Preloader.class) {
                if (sPreloader == null) {
                    sPreloader = new Preloader();
                }
            }
            sPreloader.getCache();
        }
        return sPreloader;
    }

    private static String getPlayInfoForLiveId(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1595404738")) {
            return (String) ipChange.ipc$dispatch("1595404738", new Object[]{str, str2});
        }
        return ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getString("YKLiveRoom_ABTest", "playInfo_" + "liveId_" + str + JSMethod.NOT_SET + "sdkVersion_" + str2.replace(".", JSMethod.NOT_SET), null);
    }

    private boolean hasPlayInfo(Intent intent) {
        Uri data;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-960406131")) {
            return ((Boolean) ipChange.ipc$dispatch("-960406131", new Object[]{this, intent})).booleanValue();
        }
        return (intent == null || (data = intent.getData()) == null || TextUtils.isEmpty(data.getQueryParameter(DebugViewHelper.PLAY_INFO_TAG))) ? false : true;
    }

    public static Map<String, String> parseUri(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1120507429")) {
            return (Map) ipChange.ipc$dispatch("-1120507429", new Object[]{intent});
        }
        HashMap hashMap = new HashMap(16);
        Uri data = intent.getData();
        if (data != null) {
            return parseUri(data);
        }
        Log.e(TAG, "error : intent has no uri");
        return hashMap;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void perfMonitor(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2127780811")) {
            ipChange.ipc$dispatch("2127780811", new Object[]{this, str, str2});
            return;
        }
        Log.e("LiveMonitorPreloader", str + ":" + str2);
        IPerfMonitor iPerfMonitor = this.perfMonitor;
        if (iPerfMonitor != null) {
            iPerfMonitor.point(str, str2);
        }
    }

    private void preloadCoverAndAvatar(final String str, Intent intent, boolean z, final String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1536591375")) {
            ipChange.ipc$dispatch("-1536591375", new Object[]{this, str, intent, Boolean.valueOf(z), str2});
        } else if (!TextUtils.isEmpty(str)) {
            if (!z) {
                str = CDNHelper.getInstance().blurWithSize(decodeString(str), 15, 15, 60, 60);
                if (TextUtils.isEmpty(str) || !str.contains(IXOSSProcessFormaterImp.X_OSS_PROCESS)) {
                    return;
                }
            }
            this.mPreloadDrawables.clear();
            LiveWorkerThreadPool.getInstance().execute(new PriorityRunnable() {
                /* class com.youku.live.livesdk.preloader.Preloader.AnonymousClass4 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-747797939")) {
                        ipChange.ipc$dispatch("-747797939", new Object[]{this});
                        return;
                    }
                    tp1.o().s(str).Q(new IPhenixListener<ug2>() {
                        /* class com.youku.live.livesdk.preloader.Preloader.AnonymousClass4.AnonymousClass1 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        public boolean onHappen(ug2 ug2) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-1397997910")) {
                                return ((Boolean) ipChange.ipc$dispatch("-1397997910", new Object[]{this, ug2})).booleanValue();
                            }
                            if (!TextUtils.isEmpty(str2)) {
                                int dip2px = DpUtil.dip2px(1.0f) * 30;
                                tp1.o().s(CDNHelper.getInstance().decideUrl(str2, dip2px, dip2px)).n();
                            }
                            BitmapDrawable f = ug2.f();
                            if (!Preloader.this.mPreloadDrawables.containsKey(str)) {
                                Preloader.this.mPreloadDrawables.put(str, f);
                            }
                            if (DebugHelp.isDebugBuild()) {
                                Log.d("Preloader", "preloadCoverImage success!!!");
                            }
                            return false;
                        }
                    }).n();
                }
            });
            intent.putExtra(z ? "audio_bg" : "cover_url", str);
        }
    }

    private void preloadData(@NonNull Map<String, String> map, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-246231347")) {
            ipChange.ipc$dispatch("-246231347", new Object[]{this, map, intent});
            return;
        }
        boolean z = "1".equals(map.get("hasAudioRtcInfo")) || "44".equals(map.get("templateId"));
        SchemeData schemeData = null;
        if (z) {
            preloadCoverAndAvatar(ImageConstants.LAIFENG_AUDIO_ROOM_BACKGROUND_URL, intent, true, null);
        }
        String str = map.get("page_info");
        if (!TextUtils.isEmpty(str)) {
            try {
                schemeData = (SchemeData) JSON.parseObject(decodeString(decodeString(str)), SchemeData.class);
            } catch (Exception e) {
                if (DebugHelp.isDebugBuild()) {
                    e.printStackTrace();
                }
            }
            if (schemeData != null) {
                String str2 = schemeData.anchorPicture;
                if (!z) {
                    preloadCoverAndAvatar(schemeData.coverW9H16, intent, false, str2);
                }
                intent.putExtra("nick_name", schemeData.anchorName);
                intent.putExtra("anchor_avatar", str2);
                intent.putExtra("online_count", String.valueOf(schemeData.userCount));
            }
        }
    }

    private void registerLiveComponent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-838892550")) {
            ipChange.ipc$dispatch("-838892550", new Object[]{this});
            return;
        }
        try {
            Application application = ((IAppInfo) Dsl.getService(IAppInfo.class)).getApplication();
            if (application != null) {
                AilpSDK.registerAll(application);
                DagoSDK.registerAll(application);
                LaifengSDK.registerAll(application);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void requestLiveFullInfoV4Imp(final Map<String, String> map, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2095136317")) {
            ipChange.ipc$dispatch("-2095136317", new Object[]{this, map, str});
            return;
        }
        PerfLogUtils.log("Preloader.requestLiveFullInfoV4Imp start...");
        final String str2 = map.get("liveRequestSessionId");
        final String str3 = map.get("onePlayId");
        perfMonitor(str2, "requestLiveFullInfoV4Imp");
        YKPrefReporter.getInstance().getPlayBySessionId(str3).setFullInfoStartTime(System.currentTimeMillis());
        final YoukuLivePerformance perfBySessionId = YoukuLivePerformanceManager.getInstance().getPerfBySessionId(str);
        perfBySessionId.setFullInfoStart();
        createData(str2);
        WidgetSDKEngine.getInstance().getRenderMananger().postOnWorkerThread(new Runnable() {
            /* class com.youku.live.livesdk.preloader.Preloader.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-158257424")) {
                    ipChange.ipc$dispatch("-158257424", new Object[]{this});
                    return;
                }
                IRequestFactory iRequestFactory = (IRequestFactory) Dsl.getService(IRequestFactory.class);
                HashMap hashMap = new HashMap();
                hashMap.put("sdkVersion", map.get("sdkVersion"));
                hashMap.put("liveId", map.get("liveId"));
                hashMap.put("app", "Android");
                String str = (String) map.get(SchemaConstants.SCHEMA_QUERY_TPL_TAG);
                if (!TextUtils.isEmpty(str)) {
                    hashMap.put("tplTag", str);
                }
                IRequest createRequestWithMtop = iRequestFactory.createRequestWithMtop("mtop.youku.live.com.livefullinfo", "4.0", hashMap, false, false);
                if (Preloader.this.perfMonitor != null) {
                    IPerfMonitor iPerfMonitor = Preloader.this.perfMonitor;
                    iPerfMonitor.point("LiveFullInfoCost", Thread.currentThread().getName() + "::Preloader requestLiveFullInfoV4Imp:" + Preloader.this + ",mLiveId：" + ", 1 before reqLiveFullInfo;" + "4.0");
                }
                Preloader.this.perfMonitor(str2, "createRequestWithMTop");
                if (createRequestWithMtop != null) {
                    createRequestWithMtop.async(new IRequestCallback() {
                        /* class com.youku.live.livesdk.preloader.Preloader.AnonymousClass1.AnonymousClass1 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // com.youku.live.dsl.network.IRequestCallback
                        public void onCallback(IResponse iResponse) {
                            TemplateDTO templateDTO;
                            LiveBundleLayout liveBundleLayout;
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-1338726049")) {
                                ipChange.ipc$dispatch("-1338726049", new Object[]{this, iResponse});
                                return;
                            }
                            perfBySessionId.setFullInfoMtopEnd();
                            AnonymousClass1 r0 = AnonymousClass1.this;
                            Preloader.this.perfMonitor(str2, "async.onFinish");
                            YKPrefReporter.getInstance().getPlayBySessionId(str3).setFullInfoEndTime(System.currentTimeMillis());
                            AbsData absData = new AbsData();
                            absData.setFinish(true).setSessionId(str2);
                            if (Preloader.this.perfMonitor != null) {
                                Preloader.this.perfMonitor.point("LiveFullInfoCost", Thread.currentThread().getName() + "::Preloader requestLiveFullInfoV4Imp:" + Preloader.this + ",mLiveId：" + ", 2 after reqLiveFullInfo;" + "4.0");
                            }
                            AnonymousClass1 r1 = AnonymousClass1.this;
                            Preloader.this.perfMonitor(str2, "async.onFinish.success");
                            String source = iResponse.getSource();
                            LiveFullInfoData liveFullInfoData = (LiveFullInfoData) MtopDataHelper.getDataDataWithModel(source, LiveFullInfoV4.class);
                            if (Preloader.this.perfMonitor != null) {
                                Preloader.this.perfMonitor.point("LiveFullInfoCost", Thread.currentThread().getName() + "::Preloader requestLiveFullInfoV4Imp parse:" + Preloader.this + ",mLiveId：" + ", 3 after reqLiveFullInfo;" + "4.0");
                            }
                            absData.setSuccess(true).setModel(liveFullInfoData).setJson(MtopDataHelper.getDataDataWithJson(source, LiveFullInfoV4.class));
                            if (Preloader.this.perfMonitor != null) {
                                Preloader.this.perfMonitor.point("LiveFullInfoCost", Thread.currentThread().getName() + "::Preloader requestLiveFullInfoV4Imp parse:" + Preloader.this + ",mLiveId：" + ", 4 after reqLiveFullInfo;" + "4.0");
                            }
                            perfBySessionId.setFullInfoEnd();
                            AnonymousClass1 r12 = AnonymousClass1.this;
                            Preloader.this.updateData((Preloader) str2, (String) absData);
                            if (!(liveFullInfoData == null || (templateDTO = liveFullInfoData.template) == null)) {
                                List<LiveBundleLayout> list = templateDTO.layoutList;
                                LiveBundleLayout liveBundleLayout2 = null;
                                if (list != null) {
                                    LiveBundleLayout liveBundleLayout3 = null;
                                    for (LiveBundleLayout liveBundleLayout4 : list) {
                                        if (liveBundleLayout4 != null) {
                                            if ("vertical".equals(liveBundleLayout4.type)) {
                                                liveBundleLayout3 = liveBundleLayout4;
                                            } else if ("landScape".equals(liveBundleLayout4.type)) {
                                                liveBundleLayout2 = liveBundleLayout4;
                                            }
                                        }
                                    }
                                    liveBundleLayout = liveBundleLayout2;
                                    liveBundleLayout2 = liveBundleLayout3;
                                } else {
                                    liveBundleLayout = null;
                                }
                                if (!(liveBundleLayout2 == null || liveBundleLayout == null || templateDTO.templateId == null || liveFullInfoData.sdkVersion == null)) {
                                    PerfLogUtils.log("Preloaer.TemplateCacheMananger.updateTemplate ...");
                                    TemplateCacheMananger.getInstance().updateTemplate(templateDTO.templateId, liveFullInfoData.sdkVersion, liveBundleLayout.layoutSource, liveBundleLayout2.layoutSource, liveBundleLayout.layoutModel, liveBundleLayout2.layoutModel);
                                }
                            }
                        }
                    }, new IRequestCallback() {
                        /* class com.youku.live.livesdk.preloader.Preloader.AnonymousClass1.AnonymousClass2 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // com.youku.live.dsl.network.IRequestCallback
                        public void onCallback(IResponse iResponse) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-645333344")) {
                                ipChange.ipc$dispatch("-645333344", new Object[]{this, iResponse});
                                return;
                            }
                            perfBySessionId.setFullInfoMtopEnd();
                            AnonymousClass1 r6 = AnonymousClass1.this;
                            Preloader.this.perfMonitor(str2, "async.onFinish");
                            YKPrefReporter.getInstance().getPlayBySessionId(str3).setFullInfoEndTime(System.currentTimeMillis());
                            AbsData absData = new AbsData();
                            absData.setFinish(true).setSessionId(str2);
                            AnonymousClass1 r0 = AnonymousClass1.this;
                            Preloader.this.perfMonitor(str2, "async.onFinish.failure");
                            absData.setSuccess(false);
                            AnonymousClass1 r02 = AnonymousClass1.this;
                            Preloader.this.updateData((Preloader) str2, (String) absData);
                            perfBySessionId.setFullInfoError(Constants.Name.UNDEFINED);
                        }
                    });
                }
            }
        });
    }

    private boolean requirePlayControl(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1751187072")) {
            return ((Boolean) ipChange.ipc$dispatch("-1751187072", new Object[]{this, str, str2, str3})).booleanValue();
        } else if ("13".equals(str3)) {
            return false;
        } else {
            return requirePlayControl(str, str2);
        }
    }

    private synchronized void updateData(final String str, final IResult iResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-375209383")) {
            ipChange.ipc$dispatch("-375209383", new Object[]{this, str, iResult});
            return;
        }
        PerfLogUtils.log("Preloader.updateData 1 ...");
        perfMonitor(str, "setCallback");
        if (iResult != null) {
            final AbsData absData = getCache().get(str);
            if (absData == null) {
                absData = new AbsData();
                getCache().put(str, absData);
            }
            absData.setResultCallback(iResult);
            perfMonitor(str, "setCallback.isFinish");
            if (absData.isFinish()) {
                WidgetSDKEngine.getInstance().getRenderMananger().postOnUiThread(new Runnable() {
                    /* class com.youku.live.livesdk.preloader.Preloader.AnonymousClass2 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-354770929")) {
                            ipChange.ipc$dispatch("-354770929", new Object[]{this});
                            return;
                        }
                        Preloader.this.perfMonitor(str, "setCallback.callback.begin");
                        iResult.onResult(absData);
                        Preloader.this.perfMonitor(str, "setCallback.callback.end");
                    }
                });
            } else {
                perfMonitor(str, "updateData(key, callback) no finish");
            }
        }
    }

    public void addTaskCallback(String str, IResult iResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-969485625")) {
            ipChange.ipc$dispatch("-969485625", new Object[]{this, str, iResult});
            return;
        }
        updateData(str, iResult);
    }

    public void clearColdStartStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2018227199")) {
            ipChange.ipc$dispatch("2018227199", new Object[]{this});
            return;
        }
        this.isFromAppColdStart = false;
        this.paramsFromAppColdStart = null;
    }

    public boolean contains(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1565020591")) {
            return ((Boolean) ipChange.ipc$dispatch("-1565020591", new Object[]{this, str})).booleanValue();
        } else if (TextUtils.isEmpty(str)) {
            return false;
        } else {
            return getCache().containsKey(str);
        }
    }

    public synchronized IData createData(String str) {
        AbsData absData;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1440391453")) {
            return (IData) ipChange.ipc$dispatch("-1440391453", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
            return null;
        } else {
            if (!getCache().containsKey(str)) {
                absData = new AbsData();
                absData.setSessionId(str);
                getCache().put(str, absData);
            } else {
                absData = getCache().get(str);
            }
            return absData;
        }
    }

    public String decodeString(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-62183949")) {
            return (String) ipChange.ipc$dispatch("-62183949", new Object[]{this, str});
        }
        try {
            return URLDecoder.decode(str.replaceAll("%(?![0-9a-fA-F]{2})", "%25"), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    public Map<String, String> getColdStartParams() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "232726825")) {
            return this.paramsFromAppColdStart;
        }
        return (Map) ipChange.ipc$dispatch("232726825", new Object[]{this});
    }

    public synchronized IData getData(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-257777161")) {
            return (IData) ipChange.ipc$dispatch("-257777161", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
            return null;
        } else {
            return new AbsData(getCache().get(str));
        }
    }

    @Nullable
    public synchronized Drawable getPreloadDrawable(String str, Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1304411725")) {
            return (Drawable) ipChange.ipc$dispatch("1304411725", new Object[]{this, str, context});
        } else if (!this.mPreloadDrawables.containsKey(str)) {
            return getDefaultPreViewDrawable(context, false, true);
        } else {
            return this.mPreloadDrawables.remove(str);
        }
    }

    public boolean isFromAppColdStart() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1717777643")) {
            return this.isFromAppColdStart;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1717777643", new Object[]{this})).booleanValue();
    }

    public synchronized void loadFromAppStart(Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "178812630")) {
            ipChange.ipc$dispatch("178812630", new Object[]{this, uri});
            return;
        }
        ILog iLog = (ILog) Dsl.getService(IRemoteLog.class);
        try {
            iLog.e(TAG, "loadFromAppStart:" + uri.toString());
            String string = ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getString("LivePlatformPreloader", "PreloaderOpenLoadFromAppStart", "1");
            if (!TextUtils.isEmpty(string) && string.equals("1")) {
                iLog.e(TAG, "preloaderOpen:" + string);
                String genOnePlayId = YKPrefReporter.genOnePlayId(System.currentTimeMillis());
                Map<String, String> parseUri = parseUri(uri);
                if (parseUri != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    String genSessionId = genSessionId(currentTimeMillis);
                    parseUri.put("liveRequestSessionId", genSessionId);
                    parseUri.put(LiveRoomConstants.PLAY_CLICK_TIME, String.valueOf(currentTimeMillis));
                    parseUri.put("onePlayId", genOnePlayId);
                    requestLiveFullInfoV4Imp(parseUri, genSessionId);
                    if (requirePlayControl(genSessionId, parseUri.get("liveId"))) {
                        parseUri.put("playControlRequireId", genSessionId);
                    }
                    this.paramsFromAppColdStart = parseUri;
                    iLog.e(TAG, "preloader params:" + parseUri);
                }
                registerLiveComponent();
                iLog.e(TAG, "registerLiveComponent");
            }
            this.isFromAppColdStart = true;
            iLog.e(TAG, "isFromAppColdStart:" + this.isFromAppColdStart);
        } catch (Throwable th) {
            iLog.e(TAG, "loadFromAppStart:Error:\n" + th.getMessage());
        }
    }

    public synchronized void loadFromNav(Intent intent) {
        String str;
        String str2;
        String str3;
        String str4;
        boolean z;
        boolean z2;
        String str5;
        IpChange ipChange = $ipChange;
        boolean z3 = true;
        if (AndroidInstantRuntime.support(ipChange, "-725698414")) {
            ipChange.ipc$dispatch("-725698414", new Object[]{this, intent});
            return;
        }
        MyLog.i(TAG, "load from nav internal : " + System.currentTimeMillis());
        Log.e(TAG, "loadFromNav");
        LiveSdkPreloader.preRegisterAll(((IAppInfo) Dsl.getService(IAppInfo.class)).getApplication());
        BlackUtil.prefetchIsBlack();
        long currentTimeMillis = System.currentTimeMillis();
        String valueOf = String.valueOf(currentTimeMillis);
        String genOnePlayId = YKPrefReporter.genOnePlayId(System.currentTimeMillis());
        Uri.Builder builder = null;
        if (intent != null) {
            str = intent.getDataString();
            intent.putExtra(LiveRoomConstants.PLAY_CLICK_TIME, String.valueOf(currentTimeMillis));
            intent.putExtra("onePlayId", genOnePlayId);
            intent.putExtra(LiveActivity.JUMP_SOURCE_KEY, LiveActivity.JUMP_FROM_NAV);
        } else {
            str = null;
        }
        YoukuLivePerformance navigateStart = YoukuLivePerformanceManager.getInstance().getPerfBySessionId(valueOf).setNavigateStart(currentTimeMillis);
        Map<String, String> parseUri = parseUri(intent);
        if (parseUri != null) {
            Log.e(TAG, "parseUri.end");
            preloadData(parseUri, intent);
            YKPrefReporter.getInstance().getPlayBySessionId(genOnePlayId).setPreloadStartTime(currentTimeMillis);
            str4 = parseUri.get("liveId");
            parseUri.put("liveRequestSessionId", valueOf);
            parseUri.put(LiveRoomConstants.PLAY_CLICK_TIME, String.valueOf(currentTimeMillis));
            parseUri.put("onePlayId", genOnePlayId);
            if (hasPlayInfo(intent)) {
                YKPrefReporter.getInstance().getPlayBySessionId(genOnePlayId).setHasPlayinfo("1");
            }
            YKPrefReporter.getInstance().getPlayBySessionId(genOnePlayId).setClickTime(currentTimeMillis);
            YKPrefReporter.getInstance().getPlayBySessionId(genOnePlayId).setNav("1");
            intent.putExtra("liveRequestSessionId", valueOf);
            intent.putExtra(LiveRoomConstants.DATA_COME_IN_ROOM_START_TIME, currentTimeMillis);
            if (parseUri.containsKey("templateId")) {
                intent.putExtra("templateId", parseUri.get("templateId"));
            }
            str5 = parseUri.get("templateId");
            if (parseUri.containsKey("roomLayout")) {
                intent.putExtra("roomLayout", parseUri.get("roomLayout"));
                YKPrefReporter.getInstance().getPlayBySessionId(genOnePlayId).setHasTmpId("1");
                z2 = true;
            } else {
                z2 = false;
            }
            if (parseUri.containsKey("roomLayoutLandscape")) {
                intent.putExtra("landscape", parseUri.get("roomLayoutLandscape"));
                YKPrefReporter.getInstance().getPlayBySessionId(genOnePlayId).setHasTmpId("1");
            }
            if (parseUri.containsKey("format")) {
                str3 = parseUri.get("format");
                YKPrefReporter.getInstance().getPlayBySessionId(genOnePlayId).setFlowType(parseUri.get("format"));
            } else {
                str3 = null;
            }
            str2 = parseUri.containsKey("playInfoUrl") ? parseUri.get("playInfoUrl") : null;
            perfMonitor(valueOf, "loadFromNav");
            requestLiveFullInfoV4Imp(parseUri, valueOf);
            if (requirePlayControl(valueOf, str4)) {
                intent.putExtra("playControlRequireId", valueOf);
                parseUri.put("playControlRequireId", valueOf);
            }
            boolean equals = parseUri.containsKey("hasAudioRtcInfo") ? "1".equals(parseUri.get("hasAudioRtcInfo")) : false;
            YKPrefReporter.getInstance().getPlayBySessionId(genOnePlayId).setPreloadEndTime(System.currentTimeMillis());
            z = equals;
        } else {
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            z2 = false;
            z = false;
        }
        if (abtestTrimNavigatorUrl()) {
            try {
                Uri data = intent.getData();
                if (data != null) {
                    builder = data.buildUpon();
                }
                if (builder != null) {
                    builder.clearQuery();
                    Set<String> queryParameterNames = data.getQueryParameterNames();
                    if (queryParameterNames != null) {
                        for (String str6 : queryParameterNames) {
                            if (!"page_info".equals(str6) && !DebugViewHelper.PLAY_INFO_TAG.equals(str6)) {
                                builder.appendQueryParameter(str6, data.getQueryParameter(str6));
                            }
                        }
                    }
                    str = builder.build().toString();
                }
            } catch (Throwable unused) {
            }
        }
        navigateStart.setNavigateEnd(YoukuLivePerformanceManager.currentTimeMillis()).setPreprocess(true).setLiveId(str4).setNavigatorUrl(str);
        if (!TextUtils.isEmpty(str5)) {
            navigateStart.setTemplateId(str5);
        }
        if (!TextUtils.isEmpty(str3)) {
            navigateStart.setPlayInfoFormat(str3);
        }
        if (TextUtils.isEmpty(str2)) {
            z3 = false;
        }
        navigateStart.setHasPlayInfoUrl(z3);
        navigateStart.setHitTemplateCache(z2);
        navigateStart.setHasRtcInfo(z);
        if (parseUri != null) {
            if (parseUri.containsKey(YoukuLivePerformanceConstants.DIM_HAS_PAGEINFO)) {
                navigateStart.setHasPageInfo(parseUri.get(YoukuLivePerformanceConstants.DIM_HAS_PAGEINFO));
            }
            if (parseUri.containsKey(YoukuLivePerformanceConstants.DIM_HAS_PLAYINFO)) {
                navigateStart.setHasPlayInfo(parseUri.get(YoukuLivePerformanceConstants.DIM_HAS_PLAYINFO));
            }
            if (parseUri.containsKey(YoukuLivePerformanceConstants.DIM_PLAYINFO_REFETCH)) {
                navigateStart.setPlayInfoRefetch(parseUri.get(YoukuLivePerformanceConstants.DIM_PLAYINFO_REFETCH));
            }
            if (parseUri.containsKey(YoukuLivePerformanceConstants.DIM_PLAYINFO_REFETCH_PAGENAME)) {
                navigateStart.setPlayInfoRefetchPageName(parseUri.get(YoukuLivePerformanceConstants.DIM_PLAYINFO_REFETCH_PAGENAME));
            }
            if (parseUri.containsKey(YoukuLivePerformanceConstants.DIM_PLAYINFO_STATUS)) {
                navigateStart.setPlayInfoStatus(parseUri.get(YoukuLivePerformanceConstants.DIM_PLAYINFO_STATUS));
            }
            if (parseUri.containsKey(YoukuLivePerformanceConstants.DIM_PLAYINFO_ERRORCODE)) {
                navigateStart.setPlayInfoErrorCode(parseUri.get(YoukuLivePerformanceConstants.DIM_PLAYINFO_ERRORCODE));
            }
            if (parseUri.containsKey("playinfo_ext")) {
                navigateStart.setDimString("playinfo_ext", parseUri.get("playinfo_ext"));
            }
        }
    }

    public synchronized void loadFromRoom(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-124787852")) {
            ipChange.ipc$dispatch("-124787852", new Object[]{this, intent});
        } else if (!intent.hasExtra("liveRequestSessionId") || !getInstance().contains(intent.getStringExtra("liveRequestSessionId"))) {
            long currentTimeMillis = System.currentTimeMillis();
            String valueOf = String.valueOf(currentTimeMillis);
            String genOnePlayId = YKPrefReporter.genOnePlayId(System.currentTimeMillis());
            String str = null;
            String dataString = intent.getDataString();
            intent.putExtra(LiveRoomConstants.PLAY_CLICK_TIME, String.valueOf(currentTimeMillis));
            intent.putExtra("onePlayId", genOnePlayId);
            intent.putExtra(LiveActivity.JUMP_SOURCE_KEY, LiveActivity.JUMP_FROM_NAV);
            Map<String, String> parseUri = parseUri(intent);
            if (parseUri != null) {
                preloadData(parseUri, intent);
                YKPrefReporter.getInstance().getPlayBySessionId(genOnePlayId).setPreloadStartTime(currentTimeMillis);
                str = parseUri.get("liveId");
                parseUri.put("liveRequestSessionId", valueOf);
                parseUri.put(LiveRoomConstants.PLAY_CLICK_TIME, String.valueOf(currentTimeMillis));
                parseUri.put("onePlayId", genOnePlayId);
                if (hasPlayInfo(intent)) {
                    YKPrefReporter.getInstance().getPlayBySessionId(genOnePlayId).setHasPlayinfo("1");
                }
                YKPrefReporter.getInstance().getPlayBySessionId(genOnePlayId).setClickTime(currentTimeMillis);
                intent.putExtra("liveRequestSessionId", valueOf);
                intent.putExtra(LiveRoomConstants.DATA_COME_IN_ROOM_START_TIME, currentTimeMillis);
                if (parseUri.containsKey("roomLayout")) {
                    intent.putExtra("roomLayout", parseUri.get("roomLayout"));
                    YKPrefReporter.getInstance().getPlayBySessionId(genOnePlayId).setHasTmpId("1");
                }
                if (parseUri.containsKey("roomLayoutLandscape")) {
                    intent.putExtra("landscape", parseUri.get("roomLayoutLandscape"));
                    YKPrefReporter.getInstance().getPlayBySessionId(genOnePlayId).setHasTmpId("1");
                }
                if (parseUri.containsKey("format")) {
                    YKPrefReporter.getInstance().getPlayBySessionId(genOnePlayId).setFlowType(parseUri.get("format"));
                }
                perfMonitor(valueOf, "loadFromNav");
                requestLiveFullInfoV4Imp(parseUri, valueOf);
                if (dataString != null && dataString.contains("v.laifeng.com") && requirePlayControl(valueOf, str)) {
                    intent.putExtra("playControlRequireId", valueOf);
                    parseUri.put("playControlRequireId", valueOf);
                }
                YKPrefReporter.getInstance().getPlayBySessionId(genOnePlayId).setPreloadEndTime(System.currentTimeMillis());
            }
            YoukuLivePerformanceManager.getInstance().getPerfBySessionId(valueOf).setNavigateStart(currentTimeMillis).setNavigateEnd(YoukuLivePerformanceManager.currentTimeMillis()).setPreprocess(false).setLiveId(str).setNavigatorUrl(dataString);
        }
    }

    @Nullable
    public Drawable preparePreViewDrawable(String str, Context context, boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1039061183")) {
            return (Drawable) ipChange.ipc$dispatch("1039061183", new Object[]{this, str, context, Boolean.valueOf(z), Boolean.valueOf(z2)});
        } else if (TextUtils.isEmpty(str)) {
            return getDefaultPreViewDrawable(context, z, z2);
        } else {
            Drawable drawable = this.mPreloadDrawables.get(str);
            if (drawable != null) {
                return drawable;
            }
            if (DebugHelp.isDebugBuild()) {
                Log.d("Preloader", "preView use default drawable");
            }
            Drawable defaultPreViewDrawable = getDefaultPreViewDrawable(context, z, z2);
            this.mPreloadDrawables.put(str, defaultPreViewDrawable);
            return defaultPreViewDrawable;
        }
    }

    public void remove(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1575031736")) {
            ipChange.ipc$dispatch("-1575031736", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            try {
                getCache().remove(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static String genSessionId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1472179933")) {
            return (String) ipChange.ipc$dispatch("1472179933", new Object[]{Long.valueOf(j)});
        }
        return "" + j + "" + Math.floor(Math.random() * 10.0d);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x007d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007e  */
    private boolean requirePlayControl(String str, String str2) {
        boolean z;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "214089782")) {
            return ((Boolean) ipChange.ipc$dispatch("214089782", new Object[]{this, str, str2})).booleanValue();
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        } else {
            IRemoteConfig iRemoteConfig = (IRemoteConfig) Dsl.getService(IRemoteConfig.class);
            IPreloader iPreloader = null;
            if (iRemoteConfig != null) {
                if (!LivePerfUtils.usePrefetchPlayControl()) {
                    String string = iRemoteConfig.getString("YKLiveRoom_ABTest", "use_prefetch_playcontrol_liveIds", null);
                    if (!TextUtils.isEmpty(string)) {
                        if (!"*".equals(string)) {
                            String[] split = string.split(",");
                            if (split != null && split.length > 0) {
                                int length = split.length;
                                int i = 0;
                                while (true) {
                                    if (i >= length) {
                                        break;
                                    }
                                    String str3 = split[i];
                                    if (!TextUtils.isEmpty(str3) && str3.equals(str2)) {
                                        break;
                                    }
                                    i++;
                                }
                            }
                        }
                    }
                }
                z = true;
                if (z) {
                    return false;
                }
                IAppInfo iAppInfo = (IAppInfo) Dsl.getService(IAppInfo.class);
                Context applicationContext = iAppInfo != null ? iAppInfo.getApplicationContext() : null;
                if (applicationContext == null) {
                    return false;
                }
                IPreloaderMananger iPreloaderMananger = (IPreloaderMananger) Dsl.getService(IPreloaderMananger.class);
                if (iPreloaderMananger != null) {
                    iPreloader = iPreloaderMananger.createLivePlayControlPreloader(str, str2, applicationContext);
                }
                if (iPreloader != null) {
                    return true;
                }
                return false;
            }
            z = false;
            if (z) {
            }
        }
    }

    public static Map<String, String> parseUri(Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1042875213")) {
            return (Map) ipChange.ipc$dispatch("-1042875213", new Object[]{uri});
        }
        HashMap hashMap = new HashMap(16);
        if (uri != null) {
            for (String str : uri.getQueryParameterNames()) {
                String queryParameter = uri.getQueryParameter(str);
                if (!TextUtils.isEmpty(queryParameter)) {
                    Log.e(TAG, "parseUri uri \"" + str + "\" = \"" + queryParameter + "\"");
                    hashMap.put(str, queryParameter);
                }
            }
        }
        try {
            for (String str2 : hashMap.keySet()) {
                String str3 = (String) hashMap.get(str2);
                if (str2.compareToIgnoreCase("liveid") == 0) {
                    hashMap.put("id", str3);
                } else if (str2.compareToIgnoreCase("spm") == 0) {
                    hashMap.put("spm-url", str3);
                }
            }
        } catch (Exception unused) {
        }
        String host = uri.getHost();
        String path = uri.getPath();
        if (!TextUtils.isEmpty(host) && !TextUtils.isEmpty(path) && ("v.laifeng.com".equals(host) || "room".equals(host))) {
            String replace = path.replace("/", "");
            if ("recommend".equals(replace)) {
                return null;
            }
            hashMap.put("id", replace);
            Log.e(TAG, "parseUri laifeng \"id\" = \"" + replace + "\", " + "recommend".equals(replace));
        }
        return parseUri(hashMap);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void updateData(final String str, final AbsData absData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1643178307")) {
            ipChange.ipc$dispatch("1643178307", new Object[]{this, str, absData});
            return;
        }
        PerfLogUtils.log("Preloader.updateData 2 ...");
        perfMonitor(str, "updateData");
        AbsData absData2 = getCache().get(str);
        if (absData2 == null) {
            perfMonitor(str, "updateData.create");
            getCache().put(str, absData);
        } else {
            perfMonitor(str, "updateData.set");
            absData2.setJson(absData.getJson()).setModel(absData.getModel()).setSuccess(absData.isSuccess());
            absData = absData2;
        }
        absData.setFinish(true);
        final IResult resultCallback = absData.getResultCallback();
        if (resultCallback != null) {
            WidgetSDKEngine.getInstance().getRenderMananger().postOnUiThread(new Runnable() {
                /* class com.youku.live.livesdk.preloader.Preloader.AnonymousClass3 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-551284434")) {
                        ipChange.ipc$dispatch("-551284434", new Object[]{this});
                        return;
                    }
                    Preloader.this.perfMonitor(str, "updateData.callback.begin");
                    resultCallback.onResult(absData);
                    Preloader.this.perfMonitor(str, "updateData.callback.end");
                }
            });
        } else {
            perfMonitor(str, "updateData(key, data) no callback");
        }
    }

    public static Map<String, String> parseUri(Map<String, String> map) {
        String str;
        String str2;
        String str3;
        PlayInfoModel playInfoModel;
        Boolean bool;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1084526543")) {
            return (Map) ipChange.ipc$dispatch("-1084526543", new Object[]{map});
        }
        PreloaderTemplateCacheAlarm preloaderTemplateCacheAlarm = new PreloaderTemplateCacheAlarm();
        String str13 = null;
        if (!map.containsKey("id")) {
            Log.e(TAG, "error : parseUri no id");
            preloaderTemplateCacheAlarm.setErrorCode("1000").setErrorMessage("no room id").commitFailure();
            return null;
        }
        String str14 = map.get("id");
        HashMap hashMap = new HashMap(16);
        if (!map.containsKey("sdkversion")) {
            str = SDKConstants.SDK_VERSION_NUMBER;
        } else {
            str = map.get("sdkversion");
        }
        hashMap.put("sdkVersion", str);
        hashMap.put("liveId", map.get("id"));
        hashMap.put("app", "Android");
        hashMap.put("page_info", map.get("page_info"));
        if (map.containsKey(SchemaConstants.SCHEMA_QUERY_TPL_TAG)) {
            hashMap.put(SchemaConstants.SCHEMA_QUERY_TPL_TAG, map.get(SchemaConstants.SCHEMA_QUERY_TPL_TAG));
        }
        boolean containsKey = map.containsKey(DebugViewHelper.PLAY_INFO_TAG);
        String str15 = "0";
        hashMap.put(YoukuLivePerformanceConstants.DIM_HAS_PLAYINFO, containsKey ? "1" : str15);
        if (map.containsKey("page_info")) {
            str2 = "1";
        } else {
            str2 = str15;
        }
        hashMap.put(YoukuLivePerformanceConstants.DIM_HAS_PAGEINFO, str2);
        if (map.containsKey(YoukuLivePerformanceConstants.DIM_PLAYINFO_REFETCH)) {
            hashMap.put(YoukuLivePerformanceConstants.DIM_PLAYINFO_REFETCH, map.get(YoukuLivePerformanceConstants.DIM_PLAYINFO_REFETCH));
        }
        if (map.containsKey(YoukuLivePerformanceConstants.DIM_PLAYINFO_REFETCH_PAGENAME)) {
            hashMap.put(YoukuLivePerformanceConstants.DIM_PLAYINFO_REFETCH_PAGENAME, map.get(YoukuLivePerformanceConstants.DIM_PLAYINFO_REFETCH_PAGENAME));
        }
        if (containsKey) {
            try {
                str3 = URLDecoder.decode(URLDecoder.decode(map.get(DebugViewHelper.PLAY_INFO_TAG)));
            } catch (Throwable unused) {
            }
        } else {
            Log.e(TAG, "error : parseUri no play_info");
            str3 = null;
        }
        if (!TextUtils.isEmpty(str3)) {
            try {
                playInfoModel = (PlayInfoModel) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize(str3, PlayInfoModel.class);
            } catch (Throwable unused2) {
            }
        } else {
            Log.e(TAG, "error : parseUri no play_info string");
            playInfoModel = null;
        }
        if (playInfoModel != null) {
            String str16 = playInfoModel.templateId;
            bool = playInfoModel.landScape;
            if (!TextUtils.isEmpty(str16)) {
                hashMap.put("templateId", str16);
            }
            if (bool != null) {
                str11 = str16;
                if (bool.booleanValue()) {
                    str12 = "1";
                } else {
                    str12 = str15;
                }
                hashMap.put("roomLayoutLandscape", str12);
            } else {
                str11 = str16;
            }
            if (playInfoModel.rtcInfo != null) {
                hashMap.put("hasAudioRtcInfo", "1");
            }
            String str17 = playInfoModel.status;
            if (str17 != null) {
                hashMap.put(YoukuLivePerformanceConstants.DIM_PLAYINFO_STATUS, str17);
            }
            String str18 = playInfoModel.errCode;
            if (str18 != null) {
                hashMap.put(YoukuLivePerformanceConstants.DIM_PLAYINFO_ERRORCODE, str18);
            }
            String str19 = playInfoModel.ext;
            if (str19 != null) {
                hashMap.put("playinfo_ext", str19);
            }
            str13 = str11;
        } else {
            Log.e(TAG, "error : parseUri no play_info model");
            bool = null;
        }
        if (!hashMap.containsKey("templateId")) {
            String str20 = map.get("tId");
            if (!TextUtils.isEmpty(str20)) {
                hashMap.put("templateId", str20);
            }
        }
        boolean z = !TextUtils.isEmpty(str13) && bool != null;
        if (containsKey) {
            str4 = "1";
        } else {
            str4 = str15;
        }
        preloaderTemplateCacheAlarm.addArg("queriesPlayInfoExists", str4);
        if (playInfoModel == null) {
            str5 = str15;
        } else {
            str5 = "1";
        }
        preloaderTemplateCacheAlarm.addArg("queriesPlayInfoDeserialization", str5);
        if (str3 == null) {
            str6 = str15;
        } else {
            str6 = "1";
        }
        preloaderTemplateCacheAlarm.addArg("queriesPlayInfoDecoded", str6);
        if (z) {
            str7 = "1";
        } else {
            str7 = str15;
        }
        preloaderTemplateCacheAlarm.addArg("queriesPlayInfoSuccess", str7);
        if (!z) {
            String playInfoForLiveId = getPlayInfoForLiveId(str14, str);
            if (!TextUtils.isEmpty(playInfoForLiveId)) {
                try {
                    playInfoModel = (PlayInfoModel) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize(playInfoForLiveId, PlayInfoModel.class);
                } catch (Throwable unused3) {
                }
            }
            if (playInfoModel != null) {
                str13 = playInfoModel.templateId;
                bool = playInfoModel.landScape;
            }
            boolean z2 = !TextUtils.isEmpty(str13) && bool != null;
            if (playInfoForLiveId == null) {
                str8 = str15;
            } else {
                str8 = "1";
            }
            preloaderTemplateCacheAlarm.addArg("orangePlayInfoExists", str8);
            if (playInfoModel == null) {
                str9 = str15;
            } else {
                str9 = "1";
            }
            preloaderTemplateCacheAlarm.addArg("orangePlayInfoDeserialization", str9);
            if (z2) {
                str10 = "1";
            } else {
                str10 = str15;
            }
            preloaderTemplateCacheAlarm.addArg("orangePlayInfoSuccess", str10);
        }
        if (TextUtils.isEmpty(str13) || bool == null) {
            Log.e(TAG, "error : parseUri no templateId");
            preloaderTemplateCacheAlarm.addArgs(hashMap).setErrorCode(ERROR.MTOP_XFLUSH_SUCCESS_CODE).setErrorMessage("no templateId cache").commitFailure();
        } else {
            boolean booleanValue = bool.booleanValue();
            String layout = TemplateCacheMananger.getInstance().getLayout(str13, str, booleanValue);
            if (!TextUtils.isEmpty(layout)) {
                hashMap.put("roomLayout", layout);
            } else {
                Log.e(TAG, "error : parseUri no roomLayout cache");
                AbsYoukuLiveAlarm addArg = preloaderTemplateCacheAlarm.addArgs(hashMap).addArg("templateId", str13);
                if (booleanValue) {
                    str15 = "1";
                }
                addArg.addArg("landscape", str15).setErrorCode("2001").setErrorMessage("no templateId cache").commitFailure();
            }
        }
        if (playInfoModel != null) {
            PlayInfoModel.PlayInfoBean playInfoBean = playInfoModel.playInfo;
            if (playInfoBean != null) {
                if (!TextUtils.isEmpty(playInfoBean.format)) {
                    hashMap.put("format", playInfoModel.playInfo.format);
                } else {
                    Log.e(TAG, "error : parseUri no playInfoModel.playInfo.format");
                }
                if (!TextUtils.isEmpty(playInfoModel.playInfo.url)) {
                    hashMap.put("playInfoUrl", playInfoModel.playInfo.url);
                } else {
                    Log.e(TAG, "error : parseUri no playInfoModel.playInfo.url");
                }
            } else {
                Log.e(TAG, "error : parseUri no playInfoModel.playInfo");
            }
        } else {
            Log.e(TAG, "error : parseUri no playInfoModel");
        }
        return hashMap;
    }
}
