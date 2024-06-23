package com.youku.live.dago.widgets;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.sdk.m.s.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.remotebusiness.js.MtopJSBridge;
import com.taobao.weex.bridge.JSCallback;
import com.youku.live.dago.model.LiveInfoGetInfoModel;
import com.youku.live.dago.model.data.LiveInfoGetAnchorInfoDataModel;
import com.youku.live.dago.widgetlib.component.DagoUserCardDialog;
import com.youku.live.dago.widgetlib.view.anchor.DagoAnchorInfoView;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.account.ILogin;
import com.youku.live.dsl.account.ILoginChangedListener;
import com.youku.live.dsl.account.IUser;
import com.youku.live.dsl.json.IDeserialize;
import com.youku.live.dsl.log.ILog;
import com.youku.live.dsl.network.INetCallback;
import com.youku.live.dsl.network.INetClient;
import com.youku.live.dsl.network.INetResponse;
import com.youku.live.livesdk.model.mtop.data.LiveFullInfoData;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.SimpleWidgetDTO;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.WidgetInitDTO;
import com.youku.live.livesdk.widgets.container.pager.model.LiveInfoModel;
import com.youku.live.livesdk.widgets.container.pager.model.SwitchItemModel;
import com.youku.live.livesdk.widgets.plugin.DagoChannelPlugin;
import com.youku.live.widgets.ActivityLifecycleState;
import com.youku.live.widgets.dom.CSSLayout;
import com.youku.live.widgets.impl.BaseWidget;
import com.youku.live.widgets.protocol.ICall;
import com.youku.live.widgets.protocol.IDataHandler;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.protocol.IPlugin;
import com.youku.live.widgets.protocol.IResult;
import com.youku.live.widgets.protocol.IWidget;
import com.youku.live.widgets.protocol.IWidgetData;
import com.youku.live.widgets.protocol.activity.IActivityLifecycleStateChangedListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class AnchorInfoWidget extends BaseWidget implements ILoginChangedListener, DagoChannelPlugin.Receiver, ICall, IDataHandler, IActivityLifecycleStateChangedListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String DAGO_LIVE_START_OR_STOP_PROP = "dagoLiveStartOrStopProp";
    public static final int DATA_TYPE_ANCHOR_FANS = 1;
    public static final int DATA_TYPE_ANCHOR_INCOME = 2;
    public static final int DATA_TYPE_DISMISS = 0;
    public static final int DATA_TYPE_UNKOWN = -1;
    public static final String DEVICE_TYPE_ANDROID_PHONE = "6";
    public static final String DEVICE_TYPE_IPAD_APP = "5";
    public static final String DEVICE_TYPE_IPHONE_APP = "4";
    public static final String DEVICE_TYPE_MOBILE_WEB = "3";
    public static final String DEVICE_TYPE_PC_APP = "2";
    public static final String DEVICE_TYPE_PC_WEB = "1";
    public static final String IS_FOLLOW = "1";
    private static final String MC_MSG_TYPE_ATTENTION = "attention";
    private static final String MC_MSG_TYPE_ROOM_HOT = "room_hot";
    private static final String MC_MSG_TYPE_USER_COUNT = "usercount";
    private static final String MC_MSG_TYPE_YKLIVE_PLATFORM_GIFT = "yklive_platform_gift";
    public static final String METHOD_HIDE_LANDSCAPE = "hideOnLandscape";
    public static final String METHOD_HIDE_PORTRAIT = "hide";
    public static final String METHOD_SHOW_LANDSCAPE = "showOnLandscape";
    public static final String METHOD_SHOW_PORTRAIT = "show";
    public static final String MTOP_GET_INFO_API = "mtop.youku.live.widget.liveInfo.getInfo";
    public static final String MTOP_GET_INFO_VER = "1.0";
    public static final String MTOP_RET_CODE_RELATION_EXISTS = "-302";
    public static final String MTOP_RET_CODE_SUCCESS = "SUCCESS";
    public static final String MTOP_TUDOU_SUBSCRIBE_API = "mtop.tudou.subscribe.relation.RelationServiceMTOP.create";
    public static final String MTOP_TUDOU_SUBSCRIBE_VER = "1.1";
    public static final String PARAM_KEY_ANCHOR_INFO_CALLBACK = "anchorInfoCallback";
    public static final String PARAM_KEY_AVATAR_URL = "avatarUrl";
    public static final String PARAM_KEY_FANS_COUNT = "fansCount";
    public static final String PARAM_KEY_FOLLOWED = "followed";
    public static final String PARAM_KEY_INCOME = "income";
    public static final String PARAM_KEY_INCOME_ICON = "incomeIcon";
    public static final String PARAM_KEY_NICK_NAME = "nickName";
    public static final String PARAM_KEY_TITLE = "title";
    public static final long ROOM_ID_UNKNOWN = -1;
    public static final String TAG = "AnchorInfoWidget";
    public static final int TITLE_TYPE_ANCHOR_NICK_NAME = 1;
    public static final int TITLE_TYPE_ANCHOR_REAL_NAME = 3;
    public static final int TITLE_TYPE_ANCHOR_TITLE = 2;
    public static final int TITLE_TYPE_UNKNOWN = -1;
    public static final String WIDGET_NAME = "AnchorInfo";
    public static final int YK_SOURCE_LAIFENG = 0;
    public static final int YK_SOURCE_UNKNOWN = -1;
    public static final int YK_SOURCE_YOUKU = 1;
    private int dataTypeInt = -1;
    private String mAnchorId;
    private LiveInfoGetAnchorInfoDataModel mAnchorInfoData;
    private DagoAnchorInfoView mAnchorInfoView;
    private boolean mIsInit = false;
    private boolean mIsLogin;
    private boolean mIsWeexMakeLandscapeThisVisible = true;
    private boolean mIsWeexMakePortraitThisVisible = true;
    private LiveFullInfoData mLiveFullInfo;
    private String mRoomId;
    private FrameLayout mRoot;
    private SwitchItemModel mSwitchItemModel;
    private DagoUserCardDialog mUserCardDialog;
    private long roomIdInt = -1;
    private boolean supportAnchorInfo = true;
    private boolean supportAnchorInfoFolllowAction = false;
    private int titleTypeInt = -1;
    private int ykSourceInt = 1;

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void attentionYouku(final long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2008693784")) {
            ipChange.ipc$dispatch("2008693784", new Object[]{this, Long.valueOf(j)});
        } else if (isLoginOtherDoLogin()) {
            INetClient iNetClient = (INetClient) Dsl.getService(INetClient.class);
            HashMap hashMap = new HashMap(2);
            hashMap.put("target_id", this.mAnchorId);
            hashMap.put("guid", "0");
            hashMap.put("is_utdid", "true");
            hashMap.put("platform", "0");
            hashMap.put("did", "6");
            iNetClient.createRequestWithMTop("mtop.tudou.subscribe.relation.RelationServiceMTOP.create", "1.1", hashMap, false, false).async(new INetCallback() {
                /* class com.youku.live.dago.widgets.AnchorInfoWidget.AnonymousClass3 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.INetCallback
                public void onFinish(INetResponse iNetResponse) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1180028438")) {
                        ipChange.ipc$dispatch("1180028438", new Object[]{this, iNetResponse});
                    } else if (iNetResponse != null && iNetResponse.getRetCode() != null) {
                        String retCode = iNetResponse.getRetCode();
                        if (!AnchorInfoWidget.notUnmount(j, AnchorInfoWidget.this.roomIdInt)) {
                            return;
                        }
                        if ("-302".equals(retCode)) {
                            AnchorInfoWidget.this.updateAttentionStatus(j, true);
                        } else if ("SUCCESS".equals(retCode)) {
                            AnchorInfoWidget.this.updateAttentionStatus(j, true);
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void forceOnMainThread(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "945489348")) {
            ipChange.ipc$dispatch("945489348", new Object[]{this, runnable});
        } else if (runnable == null) {
        } else {
            if (Looper.getMainLooper().equals(Looper.myLooper())) {
                runnable.run();
            } else {
                getEngineInstance().runOnMainThread(runnable);
            }
        }
    }

    private static String formatFansCount(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-366342281")) {
            return (String) ipChange.ipc$dispatch("-366342281", new Object[]{Long.valueOf(j)});
        }
        return formatNumber(j) + " 粉丝";
    }

    private static String formatIncome(long j) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-98503181")) {
            return formatNumber(j);
        }
        return (String) ipChange.ipc$dispatch("-98503181", new Object[]{Long.valueOf(j)});
    }

    private static String formatNumber(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "112459859")) {
            return (String) ipChange.ipc$dispatch("112459859", new Object[]{Long.valueOf(j)});
        }
        double d = (double) j;
        if (d < 100000.0d) {
            return String.valueOf(j);
        }
        if (d < 100000.0d || d >= 1.0E8d) {
            return formatNumber(String.valueOf(d / 1.0E8d), String.valueOf((d / 10000.0d) % 10000.0d)) + "亿";
        }
        return formatNumber(String.valueOf(d / 10000.0d), String.valueOf(d % 10000.0d)) + "万";
    }

    private void initDagoChannelListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "627597265")) {
            ipChange.ipc$dispatch("627597265", new Object[]{this});
            return;
        }
        IEngineInstance engineInstance = getEngineInstance();
        if (engineInstance != null) {
            IPlugin findPluginByName = engineInstance.findPluginByName("DagoChannel");
            if (findPluginByName instanceof DagoChannelPlugin) {
                ((DagoChannelPlugin) findPluginByName).addListener(this);
            }
        }
    }

    private void initDataCenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2076367656")) {
            ipChange.ipc$dispatch("2076367656", new Object[]{this});
            return;
        }
        getEngineInstance().addDataHandler("mtop.youku.live.com.livefullinfo", this);
        getEngineInstance().addDataHandler("mtop.youku.live.widget.liveInfo.getInfo", this);
    }

    private void initLoginListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1931315494")) {
            ipChange.ipc$dispatch("1931315494", new Object[]{this});
            return;
        }
        ILogin iLogin = (ILogin) Dsl.getService(ILogin.class);
        if (iLogin == null) {
            this.mIsLogin = false;
        } else {
            iLogin.registerLoginChangedListener(this);
            this.mIsLogin = iLogin.isLogined();
        }
        if (this.mIsLogin) {
            refreshYoukuAnchorInfo(this.roomIdInt, this.ykSourceInt);
        }
    }

    private boolean isLinkLiving() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1072025774")) {
            return ((Boolean) ipChange.ipc$dispatch("1072025774", new Object[]{this})).booleanValue();
        }
        IEngineInstance engineInstance = getEngineInstance();
        if (engineInstance != null) {
            Object data = engineInstance.getData("dagoLiveStartOrStopProp");
            if (!(data instanceof Boolean) || ((Boolean) data).booleanValue()) {
                return false;
            }
            return true;
        }
        return false;
    }

    private boolean isLoginOtherDoLogin() {
        ILogin iLogin;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-501850294")) {
            return ((Boolean) ipChange.ipc$dispatch("-501850294", new Object[]{this})).booleanValue();
        }
        if (((IUser) Dsl.getService(IUser.class)) == null || (iLogin = (ILogin) Dsl.getService(ILogin.class)) == null) {
            return false;
        }
        if (iLogin.isLogined()) {
            return true;
        }
        iLogin.login();
        return false;
    }

    /* access modifiers changed from: private */
    public static boolean notUnmount(long j, long j2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1736943506")) {
            return j == j2 && j2 != -1;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1736943506", new Object[]{Long.valueOf(j), Long.valueOf(j2)})).booleanValue();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void openUserCardDialog(final long j) {
        long j2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1558342746")) {
            ipChange.ipc$dispatch("1558342746", new Object[]{this, Long.valueOf(j)});
            return;
        }
        String str = this.mAnchorId;
        if (!TextUtils.isEmpty(str)) {
            try {
                j2 = Long.parseLong(str);
            } catch (Exception unused) {
                j2 = 0;
            }
            if (j2 > 0) {
                DagoUserCardDialog dagoUserCardDialog = new DagoUserCardDialog(getEngineInstance().getContext(), isLinkLiving());
                dagoUserCardDialog.setTargetUserId(str);
                dagoUserCardDialog.setJSCallback(new JSCallback() {
                    /* class com.youku.live.dago.widgets.AnchorInfoWidget.AnonymousClass6 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // com.taobao.weex.bridge.JSCallback
                    public void invoke(Object obj) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1731338867")) {
                            ipChange.ipc$dispatch("-1731338867", new Object[]{this, obj});
                        } else if (AnchorInfoWidget.notUnmount(j, AnchorInfoWidget.this.roomIdInt) && (obj instanceof Map)) {
                            Object obj2 = ((Map) obj).get("isFollow");
                            if ((obj2 instanceof String) && "1".equals((String) obj2)) {
                                AnchorInfoWidget.this.updateAttentionStatus(j, true);
                            }
                        }
                    }

                    @Override // com.taobao.weex.bridge.JSCallback
                    public void invokeAndKeepAlive(Object obj) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-2002646052")) {
                            ipChange.ipc$dispatch("-2002646052", new Object[]{this, obj});
                        }
                    }
                });
                dagoUserCardDialog.showDialog();
            }
        }
    }

    private void refreshYoukuAnchorInfo(final long j, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "259677093")) {
            ipChange.ipc$dispatch("259677093", new Object[]{this, Long.valueOf(j), Integer.valueOf(i)});
        } else if (j != -1 && i != -1 && this.mIsInit) {
            INetClient iNetClient = (INetClient) Dsl.getService(INetClient.class);
            HashMap hashMap = new HashMap(2);
            hashMap.put("liveId", String.valueOf(j));
            hashMap.put("ykSoucre", String.valueOf(i));
            iNetClient.createRequestWithMTop("mtop.youku.live.widget.liveInfo.getInfo", "1.0", hashMap, false, false).async(new INetCallback() {
                /* class com.youku.live.dago.widgets.AnchorInfoWidget.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.INetCallback
                public void onFinish(INetResponse iNetResponse) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1159691063")) {
                        ipChange.ipc$dispatch("1159691063", new Object[]{this, iNetResponse});
                    } else if (iNetResponse != null && iNetResponse.getRetCode() != null && iNetResponse.getRetCode().startsWith("SUCCESS")) {
                        ((ILog) Dsl.getService(ILog.class)).e(AnchorInfoWidget.TAG, "mtop.youku.live.widget.liveInfo.getInfo => " + iNetResponse.getSource());
                        final LiveInfoGetInfoModel liveInfoGetInfoModel = (LiveInfoGetInfoModel) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize(iNetResponse.getSource(), LiveInfoGetInfoModel.class);
                        if (liveInfoGetInfoModel != null) {
                            AnchorInfoWidget.this.forceOnMainThread(new Runnable() {
                                /* class com.youku.live.dago.widgets.AnchorInfoWidget.AnonymousClass2.AnonymousClass1 */
                                private static transient /* synthetic */ IpChange $ipChange;

                                public void run() {
                                    IpChange ipChange = $ipChange;
                                    if (AndroidInstantRuntime.support(ipChange, "-94024147")) {
                                        ipChange.ipc$dispatch("-94024147", new Object[]{this});
                                        return;
                                    }
                                    AnonymousClass2 r0 = AnonymousClass2.this;
                                    if (AnchorInfoWidget.notUnmount(j, AnchorInfoWidget.this.roomIdInt)) {
                                        AnonymousClass2 r02 = AnonymousClass2.this;
                                        AnchorInfoWidget.this.updateWithliveInfo((AnchorInfoWidget) liveInfoGetInfoModel, (LiveInfoGetInfoModel) j);
                                    }
                                }
                            });
                        }
                    }
                }
            });
        }
    }

    private void releaseDagoChannelListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1195776500")) {
            ipChange.ipc$dispatch("-1195776500", new Object[]{this});
            return;
        }
        IEngineInstance engineInstance = getEngineInstance();
        if (engineInstance != null) {
            IPlugin findPluginByName = engineInstance.findPluginByName("DagoChannel");
            if (findPluginByName instanceof DagoChannelPlugin) {
                ((DagoChannelPlugin) findPluginByName).removeListener(this);
            }
        }
    }

    private void releaseDataCenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-586852723")) {
            ipChange.ipc$dispatch("-586852723", new Object[]{this});
            return;
        }
        getEngineInstance().removeDataHandler("mtop.youku.live.com.livefullinfo", this);
        getEngineInstance().removeDataHandler("mtop.youku.live.widget.liveInfo.getInfo", this);
    }

    private void releaseLoginListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1431103583")) {
            ipChange.ipc$dispatch("-1431103583", new Object[]{this});
            return;
        }
        ILogin iLogin = (ILogin) Dsl.getService(ILogin.class);
        if (iLogin != null) {
            iLogin.unregisterLoginChangedListener(this);
        }
        this.mIsLogin = false;
    }

    private void updateAnchorId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "588055656")) {
            ipChange.ipc$dispatch("588055656", new Object[]{this, str});
            return;
        }
        this.mAnchorId = str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    private void updateAnchorInfo(final long j, Map<String, Object> map) {
        boolean z;
        Object obj;
        int i;
        String str;
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "216135404")) {
            ipChange.ipc$dispatch("216135404", new Object[]{this, Long.valueOf(j), map});
            return;
        }
        DagoAnchorInfoView dagoAnchorInfoView = this.mAnchorInfoView;
        if (dagoAnchorInfoView != null && notUnmount(j, this.roomIdInt)) {
            if (this.supportAnchorInfo) {
                if (dagoAnchorInfoView.getVisibility() != 0) {
                    dagoAnchorInfoView.setVisibility(0);
                }
                if (map != null) {
                    if (map.containsKey("avatarUrl")) {
                        Object obj2 = map.get("avatarUrl");
                        if (obj2 instanceof String) {
                            str2 = (String) obj2;
                        } else {
                            str2 = "";
                        }
                        dagoAnchorInfoView.updateAnchorAvatar(str2);
                    }
                    int i2 = this.titleTypeInt;
                    if (i2 != 1) {
                        if (i2 == 2) {
                            z = map.containsKey("title");
                            obj = map.get("title");
                        } else if (i2 != 3) {
                            obj = null;
                            z = false;
                        }
                        if (z) {
                            if (obj instanceof String) {
                                str = (String) obj;
                            } else {
                                str = "";
                            }
                            dagoAnchorInfoView.updateAnchorName(str);
                        }
                        i = this.dataTypeInt;
                        long j2 = 0;
                        if (i == 1) {
                            if (i != 2) {
                                dagoAnchorInfoView.updateAnchorDesc("");
                            } else if (map.containsKey("income")) {
                                Object obj3 = map.get("income");
                                if (obj3 instanceof Long) {
                                    j2 = ((Long) obj3).longValue();
                                }
                                dagoAnchorInfoView.updateAnchorDesc(formatIncome(j2));
                            }
                        } else if (map.containsKey("fansCount")) {
                            Object obj4 = map.get("fansCount");
                            if (obj4 instanceof Long) {
                                j2 = ((Long) obj4).longValue();
                            }
                            dagoAnchorInfoView.updateAnchorDesc(formatFansCount(j2));
                        }
                        if (map.containsKey("followed")) {
                            Object obj5 = map.get("followed");
                            boolean booleanValue = obj5 instanceof Boolean ? ((Boolean) obj5).booleanValue() : false;
                            if (booleanValue) {
                                dagoAnchorInfoView.setAttentionVisibility(false, false);
                            } else {
                                dagoAnchorInfoView.setAttentionVisibility(this.supportAnchorInfoFolllowAction, false);
                            }
                            LiveInfoGetAnchorInfoDataModel liveInfoGetAnchorInfoDataModel = this.mAnchorInfoData;
                            if (liveInfoGetAnchorInfoDataModel != null) {
                                liveInfoGetAnchorInfoDataModel.followed = booleanValue;
                                getEngineInstance().asyncPutData("mtop.youku.live.widget.liveInfo.getInfo", liveInfoGetAnchorInfoDataModel);
                            }
                        }
                        if (map.containsKey("anchorInfoCallback")) {
                            dagoAnchorInfoView.setAnchorCallback(new DagoAnchorInfoView.AnchorCallback() {
                                /* class com.youku.live.dago.widgets.AnchorInfoWidget.AnonymousClass1 */
                                private static transient /* synthetic */ IpChange $ipChange;

                                @Override // com.youku.live.dago.widgetlib.view.anchor.DagoAnchorInfoView.AnchorCallback
                                public void onAttentionClick() {
                                    IpChange ipChange = $ipChange;
                                    if (AndroidInstantRuntime.support(ipChange, "1756086459")) {
                                        ipChange.ipc$dispatch("1756086459", new Object[]{this});
                                        return;
                                    }
                                    AnchorInfoWidget.this.attentionYouku(j);
                                }

                                @Override // com.youku.live.dago.widgetlib.view.anchor.DagoAnchorInfoView.AnchorCallback
                                public void onAvatarClick() {
                                    IpChange ipChange = $ipChange;
                                    if (AndroidInstantRuntime.support(ipChange, "-2034377002")) {
                                        ipChange.ipc$dispatch("-2034377002", new Object[]{this});
                                        return;
                                    }
                                    AnchorInfoWidget.this.openUserCardDialog(j);
                                }
                            });
                        }
                        if (!map.containsKey("incomeIcon")) {
                            Object obj6 = map.get("incomeIcon");
                            if (obj6 instanceof String) {
                                dagoAnchorInfoView.setSubtitleIcon((String) obj6);
                                return;
                            } else {
                                dagoAnchorInfoView.setSubtitleIcon(null);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    z = map.containsKey("nickName");
                    obj = map.get("nickName");
                    if (z) {
                    }
                    i = this.dataTypeInt;
                    long j22 = 0;
                    if (i == 1) {
                    }
                    if (map.containsKey("followed")) {
                    }
                    if (map.containsKey("anchorInfoCallback")) {
                    }
                    if (!map.containsKey("incomeIcon")) {
                    }
                }
            } else if (dagoAnchorInfoView.getVisibility() != 8) {
                dagoAnchorInfoView.setVisibility(8);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0095  */
    private void updateAnchorInfoWidgetAttribute(LiveFullInfoData liveFullInfoData, JSONObject jSONObject) {
        boolean z;
        int i;
        int i2;
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        boolean z3 = false;
        if (AndroidInstantRuntime.support(ipChange, "-452493763")) {
            ipChange.ipc$dispatch("-452493763", new Object[]{this, liveFullInfoData, jSONObject});
            return;
        }
        try {
            jSONObject.getInteger("ykSource").intValue();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            jSONObject.getInteger("bizType").intValue();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        try {
            if (jSONObject.getInteger("attentionSwitch").intValue() == 1) {
                z = true;
                if (jSONObject.getInteger("widgetSwitch").intValue() != 1) {
                    z2 = false;
                }
                z3 = z2;
                i = -1;
                i2 = jSONObject.getInteger("titleType").intValue();
                i = jSONObject.getInteger(MtopJSBridge.MtopJSParam.DATA_TYPE).intValue();
                this.dataTypeInt = i;
                this.titleTypeInt = i2;
                this.supportAnchorInfo = z3;
                this.supportAnchorInfoFolllowAction = z;
                HashMap hashMap = new HashMap(2);
                if (i != 2) {
                    hashMap.put("incomeIcon", "https://gw.alicdn.com/tfs/TB1XmX6HW61gK0jSZFlXXXDKFXa-42-42.png");
                } else {
                    hashMap.put("incomeIcon", null);
                }
                hashMap.put("anchorInfoCallback", null);
                updateAnchorInfo(this.roomIdInt, hashMap);
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
        z = false;
        try {
            if (jSONObject.getInteger("widgetSwitch").intValue() != 1) {
            }
            z3 = z2;
        } catch (Throwable th4) {
            th4.printStackTrace();
        }
        i = -1;
        try {
            i2 = jSONObject.getInteger("titleType").intValue();
        } catch (Throwable th5) {
            th5.printStackTrace();
            i2 = -1;
        }
        try {
            i = jSONObject.getInteger(MtopJSBridge.MtopJSParam.DATA_TYPE).intValue();
        } catch (Throwable th6) {
            th6.printStackTrace();
        }
        this.dataTypeInt = i;
        this.titleTypeInt = i2;
        this.supportAnchorInfo = z3;
        this.supportAnchorInfoFolllowAction = z;
        HashMap hashMap2 = new HashMap(2);
        if (i != 2) {
        }
        hashMap2.put("anchorInfoCallback", null);
        updateAnchorInfo(this.roomIdInt, hashMap2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateAttentionStatus(long j, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1865974052")) {
            ipChange.ipc$dispatch("-1865974052", new Object[]{this, Long.valueOf(j), Boolean.valueOf(z)});
        } else if (notUnmount(j, this.roomIdInt)) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("followed", Boolean.valueOf(z));
            updateAnchorInfo(j, hashMap);
        }
    }

    private void updateLandscapeVisibility() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1787269329")) {
            ipChange.ipc$dispatch("-1787269329", new Object[]{this});
            return;
        }
        FrameLayout frameLayout = this.mRoot;
        CSSLayout.LayoutParams layoutParams = null;
        ViewGroup.LayoutParams layoutParams2 = frameLayout != null ? frameLayout.getLayoutParams() : null;
        if (layoutParams2 instanceof CSSLayout.LayoutParams) {
            layoutParams = (CSSLayout.LayoutParams) layoutParams2;
        }
        if (layoutParams != null) {
            if (this.mIsWeexMakeLandscapeThisVisible) {
                layoutParams.landscapeModel.visible = Boolean.TRUE;
            } else {
                layoutParams.landscapeModel.visible = Boolean.FALSE;
            }
            frameLayout.setLayoutParams(layoutParams);
            if (layoutParams.landscapeModel.visible.booleanValue()) {
                if (frameLayout.getVisibility() != 0) {
                    frameLayout.setVisibility(0);
                }
            } else if (frameLayout.getVisibility() != 4) {
                frameLayout.setVisibility(4);
            }
        }
    }

    private void updatePortraitVisibility() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1537749151")) {
            ipChange.ipc$dispatch("-1537749151", new Object[]{this});
            return;
        }
        FrameLayout frameLayout = this.mRoot;
        CSSLayout.LayoutParams layoutParams = null;
        ViewGroup.LayoutParams layoutParams2 = frameLayout != null ? frameLayout.getLayoutParams() : null;
        if (layoutParams2 instanceof CSSLayout.LayoutParams) {
            layoutParams = (CSSLayout.LayoutParams) layoutParams2;
        }
        if (layoutParams != null) {
            if (this.mIsWeexMakePortraitThisVisible) {
                layoutParams.portraitModel.visible = Boolean.TRUE;
            } else {
                layoutParams.portraitModel.visible = Boolean.FALSE;
            }
            frameLayout.setLayoutParams(layoutParams);
            if (layoutParams.portraitModel.visible.booleanValue()) {
                if (frameLayout.getVisibility() != 0) {
                    frameLayout.setVisibility(0);
                }
            } else if (frameLayout.getVisibility() != 4) {
                frameLayout.setVisibility(4);
            }
        }
    }

    private void updateWithLiveFullInfo(LiveFullInfoData liveFullInfoData) {
        LiveInfoModel liveInfoModel;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "418657115")) {
            ipChange.ipc$dispatch("418657115", new Object[]{this, liveFullInfoData});
            return;
        }
        long j = -1;
        this.mLiveFullInfo = liveFullInfoData;
        if (liveFullInfoData != null) {
            Long l = liveFullInfoData.liveId;
            String str = "";
            if (l != null) {
                j = l.longValue();
                if (notUnmount(j, this.roomIdInt)) {
                    str = str + liveFullInfoData.anchorYtid;
                }
            }
            if (!TextUtils.isEmpty(str) && !str.equals(this.mAnchorId)) {
                updateAnchorId(str);
                z = true;
            }
            WidgetInitDTO widgetInitDTO = liveFullInfoData.widgets;
            JSON json = null;
            List<SimpleWidgetDTO> list = widgetInitDTO != null ? widgetInitDTO.widgetList : null;
            if (list != null) {
                Iterator<SimpleWidgetDTO> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SimpleWidgetDTO next = it.next();
                    if (!TextUtils.isEmpty(next.name) && next.name.equals("liveinfo")) {
                        json = next.trustData;
                        break;
                    }
                }
            }
            if (json instanceof JSONObject) {
                updateAnchorInfoWidgetAttribute(liveFullInfoData, (JSONObject) json);
                this.mIsInit = true;
            }
        }
        if (z && notUnmount(j, this.roomIdInt)) {
            SwitchItemModel switchItemModel = this.mSwitchItemModel;
            if (!(switchItemModel == null || (liveInfoModel = switchItemModel.liveInfo) == null)) {
                updateYoukuAnchorInfoWithSwitchItem(j, liveInfoModel);
            }
            refreshYoukuAnchorInfo(j, this.ykSourceInt);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateWithliveInfo(LiveInfoGetInfoModel liveInfoGetInfoModel, long j) {
        T t;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "960615751")) {
            ipChange.ipc$dispatch("960615751", new Object[]{this, liveInfoGetInfoModel, Long.valueOf(j)});
        } else if (liveInfoGetInfoModel != null && (t = liveInfoGetInfoModel.data) != null && t.data != null) {
            updateWithliveInfo((LiveInfoGetAnchorInfoDataModel) t.data, j);
        }
    }

    private void updateYoukuAnchorInfoWithSwitchItem(long j, LiveInfoModel liveInfoModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "814396977")) {
            ipChange.ipc$dispatch("814396977", new Object[]{this, Long.valueOf(j), liveInfoModel});
            return;
        }
        HashMap hashMap = new HashMap(7);
        hashMap.put("avatarUrl", liveInfoModel.avatarUrl);
        hashMap.put("nickName", liveInfoModel.nickName);
        hashMap.put("title", liveInfoModel.title);
        updateAnchorInfo(j, hashMap);
    }

    @Override // com.youku.live.widgets.protocol.ICall
    public void call(IEngineInstance iEngineInstance, String str, Map<String, Object> map, IResult iResult, IResult iResult2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "111543531")) {
            ipChange.ipc$dispatch("111543531", new Object[]{this, iEngineInstance, str, map, iResult, iResult2});
            return;
        }
        if ("showOnLandscape".equals(str)) {
            this.mIsWeexMakeLandscapeThisVisible = true;
            updateLandscapeVisibility();
        } else if ("hideOnLandscape".equals(str)) {
            this.mIsWeexMakeLandscapeThisVisible = false;
            updateLandscapeVisibility();
        }
        if ("show".equals(str)) {
            this.mIsWeexMakePortraitThisVisible = true;
            updatePortraitVisibility();
        } else if ("hide".equals(str)) {
            this.mIsWeexMakePortraitThisVisible = false;
            updatePortraitVisibility();
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener, com.youku.live.widgets.impl.BaseWidget
    public void didDisappear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1631386483")) {
            ipChange.ipc$dispatch("1631386483", new Object[]{this});
            return;
        }
        releaseDagoChannelListener();
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IMountStateChangedListener, com.youku.live.widgets.impl.BaseWidget
    public void didMount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1648067651")) {
            ipChange.ipc$dispatch("-1648067651", new Object[]{this});
            return;
        }
        DagoAnchorInfoView dagoAnchorInfoView = this.mAnchorInfoView;
        if (dagoAnchorInfoView != null) {
            dagoAnchorInfoView.setVisibility(0);
        }
        initDataCenter();
        initLoginListener();
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IMountStateChangedListener, com.youku.live.widgets.impl.BaseWidget
    public void didUnmount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1210656022")) {
            ipChange.ipc$dispatch("1210656022", new Object[]{this});
            return;
        }
        releaseLoginListener();
        releaseDataCenter();
        DagoAnchorInfoView dagoAnchorInfoView = this.mAnchorInfoView;
        if (dagoAnchorInfoView != null) {
            dagoAnchorInfoView.clearAnimation();
            dagoAnchorInfoView.reset();
            dagoAnchorInfoView.setVisibility(4);
        }
        this.mRoomId = null;
        this.mAnchorId = null;
        this.mSwitchItemModel = null;
        this.mLiveFullInfo = null;
        this.mAnchorInfoData = null;
        this.mIsInit = false;
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IWidgetViewInitInterface
    public View initHostView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-176979792")) {
            return (View) ipChange.ipc$dispatch("-176979792", new Object[]{this, context});
        }
        this.mRoot = new FrameLayout(context);
        DagoAnchorInfoView dagoAnchorInfoView = new DagoAnchorInfoView(context);
        this.mAnchorInfoView = dagoAnchorInfoView;
        dagoAnchorInfoView.setAttentionVisibility(false, false);
        this.mRoot.addView(this.mAnchorInfoView);
        return this.mRoot;
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IWidgetViewInitInterface
    public void initWithData(IEngineInstance iEngineInstance, IWidget iWidget, IWidgetData iWidgetData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1590246520")) {
            ipChange.ipc$dispatch("-1590246520", new Object[]{this, iEngineInstance, iWidget, iWidgetData});
            return;
        }
        super.initWithData(iEngineInstance, iWidget, iWidgetData);
        this.mIsInit = false;
        String string = getEngineInstance().getOptions().getString("liveid", "");
        this.mRoomId = string;
        try {
            this.roomIdInt = Long.valueOf(string).longValue();
        } catch (Throwable unused) {
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityLifecycleStateChangedListener
    public void onActivityLifecycleStateChanged(ActivityLifecycleState activityLifecycleState) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1888754936")) {
            ipChange.ipc$dispatch("-1888754936", new Object[]{this, activityLifecycleState});
        } else if (ActivityLifecycleState.RESUMED.equals(activityLifecycleState)) {
            refreshYoukuAnchorInfo(this.roomIdInt, this.ykSourceInt);
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataHandler
    public void onDataChanged(String str, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-735069526")) {
            ipChange.ipc$dispatch("-735069526", new Object[]{this, str, obj, obj2});
        } else if ("mtop.youku.live.com.livefullinfo".equals(str)) {
            if (obj instanceof LiveFullInfoData) {
                updateWithLiveFullInfo((LiveFullInfoData) obj);
            }
        } else if (!"mtop.youku.live.widget.liveInfo.getInfo".equals(str)) {
        } else {
            if (obj instanceof LiveInfoGetAnchorInfoDataModel) {
                ((ILog) Dsl.getService(ILog.class)).e(TAG, "onDataChanged:" + obj);
            } else if (obj instanceof String) {
                LiveInfoGetAnchorInfoDataModel liveInfoGetAnchorInfoDataModel = (LiveInfoGetAnchorInfoDataModel) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize((String) obj, LiveInfoGetAnchorInfoDataModel.class);
                if (liveInfoGetAnchorInfoDataModel != null) {
                    updateWithliveInfo(liveInfoGetAnchorInfoDataModel, this.roomIdInt);
                }
                ((ILog) Dsl.getService(ILog.class)).e(TAG, "onDataChanged:" + obj);
            } else {
                ((ILog) Dsl.getService(ILog.class)).e(TAG, "onDataChanged:" + obj);
            }
        }
    }

    @Override // com.youku.live.dsl.account.ILoginChangedListener
    public void onLoginChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1254004711")) {
            ipChange.ipc$dispatch("1254004711", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mIsLogin = z;
        refreshYoukuAnchorInfo(this.roomIdInt, this.ykSourceInt);
    }

    @Override // com.youku.live.livesdk.widgets.plugin.DagoChannelPlugin.Receiver
    public void onMessage(DagoChannelPlugin.Message message) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "683475406")) {
            ipChange.ipc$dispatch("683475406", new Object[]{this, message});
        } else if (message != null && (str = message.msgType) != null) {
            long j = 0;
            if (MC_MSG_TYPE_ATTENTION.equals(str)) {
                if (this.dataTypeInt == 1) {
                    try {
                        j = JSON.parseObject(message.data).getJSONArray("args").getJSONObject(0).getJSONObject("body").getLongValue(a.u);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    final HashMap hashMap = new HashMap(1);
                    hashMap.put("fansCount", Long.valueOf(j));
                    try {
                        final long longValue = Long.valueOf(message.channelId).longValue();
                        getEngineInstance().runOnMainThread(new Runnable() {
                            /* class com.youku.live.dago.widgets.AnchorInfoWidget.AnonymousClass4 */
                            private static transient /* synthetic */ IpChange $ipChange;

                            public void run() {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "-578072744")) {
                                    ipChange.ipc$dispatch("-578072744", new Object[]{this});
                                    return;
                                }
                                AnchorInfoWidget.this.updateAnchorInfo(longValue, hashMap);
                            }
                        });
                    } catch (Throwable unused) {
                    }
                }
                ((ILog) Dsl.getService(ILog.class)).e(TAG, message.data);
            } else if (MC_MSG_TYPE_YKLIVE_PLATFORM_GIFT.equals(message.msgType) && this.dataTypeInt == 2) {
                try {
                    j = JSON.parseObject(message.data).getJSONArray("args").getJSONObject(0).getJSONObject("body").getLongValue("popularity");
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                final HashMap hashMap2 = new HashMap(1);
                hashMap2.put("income", Long.valueOf(j));
                try {
                    final long longValue2 = Long.valueOf(message.channelId).longValue();
                    getEngineInstance().runOnMainThread(new Runnable() {
                        /* class com.youku.live.dago.widgets.AnchorInfoWidget.AnonymousClass5 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        public void run() {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-774586249")) {
                                ipChange.ipc$dispatch("-774586249", new Object[]{this});
                                return;
                            }
                            AnchorInfoWidget.this.updateAnchorInfo(longValue2, hashMap2);
                        }
                    });
                } catch (Throwable unused2) {
                }
                ((ILog) Dsl.getService(ILog.class)).e(TAG, message.data);
            }
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener, com.youku.live.widgets.impl.BaseWidget
    public void willAppear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-702678288")) {
            ipChange.ipc$dispatch("-702678288", new Object[]{this});
            return;
        }
        refreshYoukuAnchorInfo(this.roomIdInt, this.ykSourceInt);
        initDagoChannelListener();
    }

    private void updateWithliveInfo(LiveInfoGetAnchorInfoDataModel liveInfoGetAnchorInfoDataModel, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1101772469")) {
            ipChange.ipc$dispatch("1101772469", new Object[]{this, liveInfoGetAnchorInfoDataModel, Long.valueOf(j)});
        } else if (liveInfoGetAnchorInfoDataModel != null) {
            this.mAnchorInfoData = liveInfoGetAnchorInfoDataModel;
            HashMap hashMap = new HashMap(7);
            hashMap.put("avatarUrl", liveInfoGetAnchorInfoDataModel.avatarUrl);
            hashMap.put("nickName", liveInfoGetAnchorInfoDataModel.nickName);
            hashMap.put("title", liveInfoGetAnchorInfoDataModel.title);
            hashMap.put("income", Long.valueOf(liveInfoGetAnchorInfoDataModel.income));
            hashMap.put("fansCount", Long.valueOf(liveInfoGetAnchorInfoDataModel.fansCount));
            hashMap.put("followed", Boolean.valueOf(liveInfoGetAnchorInfoDataModel.followed));
            hashMap.put("anchorInfoCallback", null);
            updateAnchorInfo(j, hashMap);
        }
    }

    private static String formatNumber(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-879612747")) {
            return (String) ipChange.ipc$dispatch("-879612747", new Object[]{str, str2});
        } else if (str.length() >= 4) {
            return str;
        } else {
            while (str2.length() < 4) {
                str2 = "0" + str2;
            }
            return (str + "." + str2).substring(0, 5);
        }
    }
}
