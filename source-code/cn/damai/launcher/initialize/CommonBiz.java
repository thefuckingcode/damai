package cn.damai.launcher.initialize;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import anetwork.channel.monitor.Monitor;
import anetwork.channel.monitor.speed.NetworkSpeed;
import cn.damai.common.AppConfig;
import cn.damai.common.DamaiConstants;
import cn.damai.common.OrangeConfigCenter;
import cn.damai.common.app.ShareperfenceConstants;
import cn.damai.common.image.b;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.uploader.AusConfigCenter;
import cn.damai.common.user.a;
import cn.damai.common.user.c;
import cn.damai.common.util.CompliantUtUtils;
import cn.damai.commonbusiness.poplayer.DMPopLayer;
import cn.damai.commonbusiness.share.ShareInit;
import cn.damai.h5container.UniH5ContainerSwitcher;
import cn.damai.h5container.WindvaneAgent;
import cn.damai.homepage.R$drawable;
import cn.damai.launcher.LauncherApplication;
import cn.damai.launcher.PrivacyDoubleListDelegate;
import cn.damai.launcher.splash.api.GuideRequest;
import cn.damai.launcher.splash.api.GuideResponse;
import cn.damai.launcher.utils.PictureGaiaxProviderImp;
import cn.damai.launcher.utils.SplashXFlushHelper;
import cn.damai.launcher.utils.WifiInfoUtil;
import cn.damai.login.LoginManager;
import cn.damai.net.NetConstants;
import cn.damai.onearch.token.DMTokenManager;
import cn.damai.push.DaMaiPushAgent;
import cn.damai.security.AliSecurityHelper;
import cn.damai.tetris.core.ut.TrackProxy;
import cn.damai.tetris.core.ut.TrackType;
import cn.damai.uikit.image.IImageLoader;
import cn.damai.wantsee.GeoDeBackList;
import cn.damai.wantsee.StartConfig;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.callback.InitResultCallback;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.config.Environment;
import com.ali.user.open.jsbridge.UccJsBridge;
import com.ali.user.open.ucc.UccService;
import com.alibaba.pictures.cornerstone.APPClient;
import com.alibaba.pictures.cornerstone.EnvMode;
import com.alibaba.pictures.cornerstone.IAppBaseInfoProvider;
import com.alibaba.pictures.moimage.IImageUrlFixer;
import com.alibaba.pictures.moimage.IMoImageConfig;
import com.alibaba.pictures.piclocation.LocationErrorReporter;
import com.alibaba.pictures.piclocation.listener.GetBlackListInterface;
import com.alibaba.pictures.piclocation.listener.GetLocationInfoInterface;
import com.alibaba.pictures.piclocation.mtop.LocationRequestDelegate;
import com.alibaba.pictures.piclocation.mtop.RegionRequestHandler;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.umid.IUMIDComponent;
import com.alibaba.wireless.security.open.umid.IUMIDInitListenerEx;
import com.alient.onearch.adapter.ComponentTypeMapper;
import com.alient.onearch.adapter.request.RemoteDataLoader;
import com.alient.onearch.adapter.state.StateViewManager;
import com.alient.oneservice.provider.impl.OneConfig;
import com.alient.oneservice.provider.impl.OneContext;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.amap.api.location.AMapLocation;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.login4android.Login;
import com.taobao.login4android.constants.LoginEnvType;
import com.taobao.pexode.Pexode;
import com.taobao.tao.image.IImageStrategySupport;
import com.taobao.tao.remotebusiness.login.RemoteLogin;
import com.uc.webview.export.extension.UCCore;
import com.youku.alixplayer.opensdk.PlayerConfig;
import com.youku.alixplayer.opensdk.drm.DrmConfig;
import com.youku.alixplayer.opensdk.ups.request.service.URLConnectionTask;
import com.youku.alixplayer.opensdk.utils.Callable;
import com.youku.android.liveservice.utils.MTopHelper;
import com.youku.arch.v3.data.Repository;
import com.youku.arch.v3.view.config.ComponentConfigManager;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.IStable;
import com.youku.gaiax.provider.module.proxy.PictureGaiaXProviderProxy;
import com.youku.live.dago.liveplayback.widget.Utils;
import com.youku.media.arch.instruments.utils.RemoteLogger;
import com.youku.middlewareservice.provider.info.DeviceInfoProviderProxy;
import com.youku.network.HttpIntent;
import com.youku.usercenter.passport.Domain;
import com.youku.usercenter.passport.PassportConfig;
import com.youku.usercenter.passport.PassportManager;
import com.youku.usercenter.passport.listener.IRefreshTokenListener;
import com.youku.usercenter.passport.mtop.LoginImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.intf.IDeviceInfo;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopSetting;
import mtopsdk.xstate.util.PhoneInfo;
import tb.d20;
import tb.g70;
import tb.g91;
import tb.gp1;
import tb.hi2;
import tb.ht0;
import tb.i3;
import tb.ji2;
import tb.ke2;
import tb.m81;
import tb.ne1;
import tb.o81;
import tb.ol;
import tb.ol1;
import tb.pn;
import tb.pw1;
import tb.py2;
import tb.qu0;
import tb.s41;
import tb.sh1;
import tb.vf1;
import tb.xj2;
import tb.xs0;
import tb.xz0;

/* compiled from: Taobao */
public class CommonBiz {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String ORANGE_CONFIT_IMAGE_PHENIX = "damai_image_android_phenix";
    public static final String TAG = (LauncherApplication.class.getSimpleName() + "_xxx");
    private static CommonBiz c;
    public Application a;
    Handler b = new Handler(Looper.getMainLooper()) {
        /* class cn.damai.launcher.initialize.CommonBiz.AnonymousClass18 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1328202541")) {
                ipChange.ipc$dispatch("-1328202541", new Object[]{this, message});
                return;
            }
            super.handleMessage(message);
            int i = message.what;
            if (i != 0) {
                if (i == 1) {
                    CommonBiz.this.e();
                } else if (i == 2) {
                    CommonBiz.this.f();
                } else if (i == 3) {
                    MTopHelper.setMtop(Mtop.instance(NetConstants.YOUKU_MTOP_INSTANCE_ID, CommonBiz.this.a, AppConfig.p()));
                    PlayerConfig dynamicProperties = new PlayerConfig().setPlayerViewType(1).setAppKey(AppConfig.c()).setLiveCCode("live01010101damai").setAppVersion(AppConfig.q()).setUserAgent(CommonBiz.getDamaiUserAgent()).setCCode("01010121").setUseHardwareDecode(false).setDynamicProperties(new Callable<String>(this) {
                        /* class cn.damai.launcher.initialize.CommonBiz.AnonymousClass18.AnonymousClass1 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0038, code lost:
                            if (r7.equals(com.youku.vpm.constants.TableField.IS_VIP) == false) goto L_0x0025;
                         */
                        /* renamed from: a */
                        public String call(String str) {
                            IpChange ipChange = $ipChange;
                            char c = 2;
                            if (AndroidInstantRuntime.support(ipChange, "471400988")) {
                                return (String) ipChange.ipc$dispatch("471400988", new Object[]{this, str});
                            }
                            str.hashCode();
                            switch (str.hashCode()) {
                                case -1354757532:
                                    if (str.equals(HttpIntent.COOKIE)) {
                                        c = 0;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -892073626:
                                    if (str.equals(IRequestConst.STOKEN)) {
                                        c = 1;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 100481683:
                                    break;
                                case 2064555103:
                                    if (str.equals("isLogin")) {
                                        c = 3;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                default:
                                    c = 65535;
                                    break;
                            }
                            switch (c) {
                                case 0:
                                case 1:
                                    return "";
                                case 2:
                                case 3:
                                    return "false";
                                default:
                                    return null;
                            }
                        }
                    });
                    dynamicProperties.setDrmConfig(new DrmConfig("DM-Android", ""));
                    dynamicProperties.setNetworkTask(new URLConnectionTask());
                    Utils.setPlayerConfig(dynamicProperties);
                    RemoteLogger.setRemoteAdapter(new RemoteLogger.IRemoteAdapter(this) {
                        /* class cn.damai.launcher.initialize.CommonBiz.AnonymousClass18.AnonymousClass2 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // com.youku.media.arch.instruments.utils.RemoteLogger.IRemoteAdapter
                        public void log(String str, String str2) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "1218125217")) {
                                ipChange.ipc$dispatch("1218125217", new Object[]{this, str, str2});
                                return;
                            }
                            ji2.a().d(str, str2);
                        }
                    });
                }
            } else if (AppConfig.v()) {
                String str = CommonBiz.TAG;
                g91.c(str, "set env: " + message.obj);
            }
        }
    };

    /* compiled from: Taobao */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|5|6|7|8|9|10|11|12|13|14|15|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|5|6|7|8|9|10|11|12|13|14|15|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0028 */
        static {
            int[] iArr = new int[TrackType.values().length];
            b = iArr;
            try {
                iArr[TrackType.page.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            b[TrackType.click.ordinal()] = 2;
            b[TrackType.expose.ordinal()] = 3;
            b[TrackType.custom.ordinal()] = 4;
            b[TrackType.custom_1999.ordinal()] = 5;
            try {
                b[TrackType.warning.ordinal()] = 6;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[AppConfig.EnvMode.values().length];
            a = iArr2;
            iArr2[AppConfig.EnvMode.test.ordinal()] = 1;
            try {
                a[AppConfig.EnvMode.prepare.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private CommonBiz() {
    }

    private void A(Context context, Application application, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "732384435")) {
            ipChange.ipc$dispatch("732384435", new Object[]{this, context, application, str});
            return;
        }
        hi2.a(context, application, str);
    }

    private void C(Context context) {
        IpChange ipChange = $ipChange;
        int i = 1;
        if (AndroidInstantRuntime.support(ipChange, "-552498823")) {
            ipChange.ipc$dispatch("-552498823", new Object[]{this, context});
            return;
        }
        try {
            IUMIDComponent uMIDComp = SecurityGuardManager.getInstance(context).getUMIDComp();
            if (uMIDComp != null) {
                try {
                    if (AppConfig.g() != AppConfig.EnvMode.prepare) {
                        i = AppConfig.g() == AppConfig.EnvMode.test ? 2 : 0;
                    }
                    uMIDComp.initUMID(i, new IUMIDInitListenerEx(this) {
                        /* class cn.damai.launcher.initialize.CommonBiz.AnonymousClass19 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // com.alibaba.wireless.security.open.umid.IUMIDInitListenerEx
                        public void onUMIDInitFinishedEx(String str, int i) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "78645908")) {
                                ipChange.ipc$dispatch("78645908", new Object[]{this, str, Integer.valueOf(i)});
                            } else if (i == 200) {
                                g91.b(BizTime.SECURITY_GUARD_MANAGER, "token=" + str);
                            } else {
                                g91.b(BizTime.SECURITY_GUARD_MANAGER, "initUMID error resultCode : " + i);
                            }
                        }
                    });
                } catch (SecException e) {
                    g91.c(BizTime.SECURITY_GUARD_MANAGER, "umidComponent.registerInitListener Error: " + e.getErrorCode());
                }
            }
        } catch (SecException e2) {
            g91.c(BizTime.SECURITY_GUARD_MANAGER, "SecurityGuardManager.getInstance(context) Error: " + e2.getErrorCode());
        }
    }

    private void D() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1961926976")) {
            ipChange.ipc$dispatch("-1961926976", new Object[]{this});
            return;
        }
        AppConfig.v();
    }

    private void E() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1319322424")) {
            ipChange.ipc$dispatch("1319322424", new Object[]{this});
            return;
        }
        WindvaneAgent.initWindVane(this.a);
    }

    private void F(Context context) {
        EnvModeEnum envModeEnum;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-867881647")) {
            ipChange.ipc$dispatch("-867881647", new Object[]{this, context});
            return;
        }
        if (AppConfig.g() == AppConfig.EnvMode.test) {
            envModeEnum = EnvModeEnum.TEST;
        } else if (AppConfig.g() == AppConfig.EnvMode.prepare) {
            envModeEnum = EnvModeEnum.PREPARE;
        } else {
            envModeEnum = EnvModeEnum.ONLINE;
        }
        MtopSetting.setMtopDomain(NetConstants.YOUKU_MTOP_INSTANCE_ID, "acs.youku.com", "pre-acs.youku.com", "daily-acs.youku.com");
        Mtop.instance(NetConstants.YOUKU_MTOP_INSTANCE_ID, context, "", 0).switchEnvMode(envModeEnum);
    }

    private void G() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1268268663")) {
            ipChange.ipc$dispatch("1268268663", new Object[]{this});
            return;
        }
        EnvModeEnum envModeEnum = EnvModeEnum.ONLINE;
        if (AppConfig.g() == AppConfig.EnvMode.test) {
            envModeEnum = EnvModeEnum.TEST;
            g91.b(TAG, "EnvModeEnum Init TEST ");
        } else if (AppConfig.g() == AppConfig.EnvMode.prepare) {
            envModeEnum = EnvModeEnum.PREPARE;
            g91.b(TAG, "EnvModeEnum Init PREPARE ");
        } else {
            g91.b(TAG, "EnvModeEnum Init ONLINE ");
        }
        TBSdkLog.setTLogEnabled(true);
        TBSdkLog.setPrintLog(false);
        TBSdkLog.setLogEnable(TBSdkLog.LogEnable.DebugEnable);
        Message message = new Message();
        message.obj = envModeEnum;
        this.b.sendMessage(message);
        F(this.a);
        if (ProcessUtils.b(this.a)) {
            s(this.a);
        }
    }

    private boolean H() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "810949005")) {
            return ((Boolean) ipChange.ipc$dispatch("810949005", new Object[]{this})).booleanValue();
        }
        try {
            Class.forName("cn.damai.appinfo.PopcornApplication");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void I(final Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1422737905")) {
            ipChange.ipc$dispatch("1422737905", new Object[]{this, context});
            return;
        }
        MtopSetting.setDeviceInfo(new IDeviceInfo(this) {
            /* class cn.damai.launcher.initialize.CommonBiz.AnonymousClass17 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // mtopsdk.mtop.intf.IDeviceInfo
            public String getAndroidId() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "494681546")) {
                    return DeviceInfoProviderProxy.getAndroidId();
                }
                return (String) ipChange.ipc$dispatch("494681546", new Object[]{this});
            }

            @Override // mtopsdk.mtop.intf.IDeviceInfo
            public String getBssId() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "1408722909")) {
                    return WifiInfoUtil.a(context);
                }
                return (String) ipChange.ipc$dispatch("1408722909", new Object[]{this});
            }

            @Override // mtopsdk.mtop.intf.IDeviceInfo
            public String getDeviceId() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-972952153")) {
                    return DeviceInfoProviderProxy.getImei();
                }
                return (String) ipChange.ipc$dispatch("-972952153", new Object[]{this});
            }

            @Override // mtopsdk.mtop.intf.IDeviceInfo
            public String getImei() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-1600995234")) {
                    return DeviceInfoProviderProxy.getImei();
                }
                return (String) ipChange.ipc$dispatch("-1600995234", new Object[]{this});
            }

            @Override // mtopsdk.mtop.intf.IDeviceInfo
            public String getMacAddress() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-868068741")) {
                    return PhoneInfo.getLocalMacAddress(context);
                }
                return (String) ipChange.ipc$dispatch("-868068741", new Object[]{this});
            }

            @Override // mtopsdk.mtop.intf.IDeviceInfo
            public String getSerialNum() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-1996092718")) {
                    return PhoneInfo.getSerialNum();
                }
                return (String) ipChange.ipc$dispatch("-1996092718", new Object[]{this});
            }

            @Override // mtopsdk.mtop.intf.IDeviceInfo
            public String getSsId() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "1076803505")) {
                    return WifiInfoUtil.b(context);
                }
                return (String) ipChange.ipc$dispatch("1076803505", new Object[]{this});
            }

            @Override // mtopsdk.mtop.intf.IDeviceInfo
            public String getSubscriberId() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "716686521")) {
                    return DeviceInfoProviderProxy.getImsi();
                }
                return (String) ipChange.ipc$dispatch("716686521", new Object[]{this});
            }
        });
        MtopSetting.setAppKeyIndex(Mtop.Id.INNER, 0, 2);
        MtopSetting.setAppKeyIndex(Mtop.Id.OPEN, 0, 2);
        MtopSetting.setAppVersion(Mtop.Id.INNER, AppConfig.q());
        EnvModeEnum envModeEnum = EnvModeEnum.ONLINE;
        if (AppConfig.g() == AppConfig.EnvMode.test) {
            envModeEnum = EnvModeEnum.TEST;
            g91.b(TAG, "EnvModeEnum Init TEST ");
        } else if (AppConfig.g() == AppConfig.EnvMode.prepare) {
            envModeEnum = EnvModeEnum.PREPARE;
            g91.b(TAG, "EnvModeEnum Init PREPARE ");
        } else {
            g91.b(TAG, "EnvModeEnum Init ONLINE ");
        }
        Mtop.instance(Mtop.Id.INNER, context, AppConfig.p()).switchEnvMode(envModeEnum);
        Mtop.instance(Mtop.Id.OPEN, context, AppConfig.p()).switchEnvMode(envModeEnum);
    }

    private void J() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1002411403")) {
            ipChange.ipc$dispatch("-1002411403", new Object[]{this});
            return;
        }
        gp1.a();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void K() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "798652315")) {
            ipChange.ipc$dispatch("798652315", new Object[]{this});
            return;
        }
        g91.c("qiguaia", "requestGuideData !");
        g91.b("requestGuideData", "requestGuideData: requestGuideData start ");
        if (!LoginManager.k().q()) {
            g91.b("requestGuideData", "requestGuideData: requestGuideData not login ");
            ((LauncherApplication) this.a).getRequestFinished().compareAndSet(false, true);
            return;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.a);
        if (defaultSharedPreferences != null) {
            if (defaultSharedPreferences.getBoolean("KEY_SAVED_USERPREFER" + d20.i(), false)) {
                g91.b("requestGuideData", "1 requestGuideData: all ready showd ");
                ((LauncherApplication) this.a).getRequestFinished().compareAndSet(false, true);
                return;
            }
        }
        GuideRequest guideRequest = new GuideRequest();
        guideRequest.cityId = d20.c();
        guideRequest.showLoginUI(false);
        guideRequest.request(new DMMtopRequestListener<GuideResponse>(GuideResponse.class) {
            /* class cn.damai.launcher.initialize.CommonBiz.AnonymousClass12 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1639752924")) {
                    ipChange.ipc$dispatch("1639752924", new Object[]{this, str, str2});
                    return;
                }
                g91.b("requestGuideData", "requestGuideData error:" + str2);
                ((LauncherApplication) CommonBiz.this.a).setGuideData(null);
                g91.c("qiguaia", "requestGuideData onFail!");
                ((LauncherApplication) CommonBiz.this.a).getRequestFinished().compareAndSet(false, true);
            }

            public void onSuccess(GuideResponse guideResponse) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1659648316")) {
                    ipChange.ipc$dispatch("1659648316", new Object[]{this, guideResponse});
                    return;
                }
                ((LauncherApplication) CommonBiz.this.a).setGuideData(guideResponse);
                g91.b("requestGuideData", "2 requestGuideData: requestGuideData onSuccess ");
                g91.c("qiguaia", "requestGuideData onSuccess!");
                ((LauncherApplication) CommonBiz.this.a).getRequestFinished().compareAndSet(false, true);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void N() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1130245948")) {
            ipChange.ipc$dispatch("-1130245948", new Object[]{this});
        } else if (UccJsBridge.getInstance() != null && ((UccService) AliMemberSDK.getService(UccService.class)) != null) {
            UccJsBridge.getInstance().setUccDataProvider();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "297697669")) {
            ipChange.ipc$dispatch("297697669", new Object[]{this});
        } else if (ProcessUtils.b(this.a)) {
            D();
            p();
            w();
            C(this.a);
            J();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1824532667")) {
            ipChange.ipc$dispatch("1824532667", new Object[]{this});
        } else if (ProcessUtils.b(this.a)) {
            E();
            g91.b("delayInit", "delayInitfor3 initWindVane");
        }
    }

    public static String getDamaiUserAgent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1762509088")) {
            return (String) ipChange.ipc$dispatch("1762509088", new Object[0]);
        }
        return "Damai;" + AppConfig.q() + ";Android;" + g70.e() + ";" + g70.b();
    }

    public static CommonBiz getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "565408507")) {
            return (CommonBiz) ipChange.ipc$dispatch("565408507", new Object[0]);
        }
        if (c == null) {
            synchronized (CommonBiz.class) {
                if (c == null) {
                    c = new CommonBiz();
                }
            }
        }
        return c;
    }

    private void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-597302444")) {
            ipChange.ipc$dispatch("-597302444", new Object[]{this});
        } else if (ProcessUtils.b(this.a)) {
            Environment environment = Environment.ONLINE;
            if (AppConfig.g() == AppConfig.EnvMode.test) {
                environment = Environment.TEST;
            } else if (AppConfig.g() == AppConfig.EnvMode.prepare) {
                environment = Environment.PRE;
            }
            AliMemberSDK.setEnvironment(environment);
            ConfigManager.setAppKeyIndex(0, 2);
            AliMemberSDK.init(this.a, "damai", new InitResultCallback() {
                /* class cn.damai.launcher.initialize.CommonBiz.AnonymousClass11 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.ali.user.open.core.callback.FailureCallback
                public void onFailure(int i, String str) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1115279410")) {
                        ipChange.ipc$dispatch("1115279410", new Object[]{this, Integer.valueOf(i), str});
                        return;
                    }
                    g91.c(CommonBiz.TAG, "havana: AliMemberSDK init failed");
                }

                @Override // com.ali.user.open.core.callback.InitResultCallback
                public void onSuccess() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "2107307234")) {
                        ipChange.ipc$dispatch("2107307234", new Object[]{this});
                        return;
                    }
                    CommonBiz.this.N();
                    CommonBiz.this.K();
                }
            });
            LoginManager.k().z(this.a);
            N();
        }
    }

    private void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "759699049")) {
            ipChange.ipc$dispatch("759699049", new Object[]{this});
            return;
        }
        AusConfigCenter.initUploader(this.a);
    }

    private void l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1868575346")) {
            ipChange.ipc$dispatch("-1868575346", new Object[]{this});
        } else if (ProcessUtils.b(this.a)) {
            g91.b("GaiaXSDK", UCCore.LEGACY_EVENT_INIT);
            GaiaX.Companion companion = GaiaX.Companion;
            companion.init(this.a);
            IStable stable = companion.getInstance().stable();
            if (stable != null) {
                stable.launchDB();
                g91.b("GaiaXSDK", "launchDB");
                String B = d20.B("gaiax_cache_app_version");
                String q = AppConfig.q();
                if (q != B) {
                    stable.cleanRemoteTemplates();
                    d20.T("gaiax_cache_app_version", q);
                }
            }
            if (stable != null) {
                stable.launchRemote();
                g91.b("GaiaXSDK", "launchRemote");
            }
            PictureGaiaXProviderProxy.Companion.initProxyImpl(new PictureGaiaxProviderImp());
        }
    }

    private void p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1448469448")) {
            ipChange.ipc$dispatch("1448469448", new Object[]{this});
            return;
        }
        vf1.a();
    }

    private void q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-857862484")) {
            ipChange.ipc$dispatch("-857862484", new Object[]{this});
            return;
        }
        OneContext.setApplication(this.a);
        OneConfig.setTtid(AppConfig.p());
        OneConfig.setEnvType(AppConfig.g().ordinal());
        OneConfig.appkey = AppConfig.c();
        OneConfig.CHECK_UPDATE_BACKGROUND = false;
        OneConfig.CHECK_UPDATE_SYNC = true;
        Repository.Companion.setRemoteDataLoader(new RemoteDataLoader());
        ComponentTypeMapper.INSTANCE.register(new ol());
        StateViewManager.Companion.getInstance().register(new ke2());
        ComponentConfigManager.Companion.getInstance().setUniversallyComponentConfigPath("android.resource://bricks/raw/universally_component_config");
        DMTokenManager.Companion.a().b(this.a);
    }

    private void r() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "515284884")) {
            ipChange.ipc$dispatch("515284884", new Object[]{this});
        } else if (ProcessUtils.b(this.a) || ProcessUtils.a(this.a)) {
            OrangeConfigCenter.c();
            OrangeConfigCenter.d(this.a);
            ol1.c();
            if (ProcessUtils.b(this.a)) {
                OrangeConfigCenter.c().f(DamaiConstants.BLACK_WHITE_VIEW_CONFIG, new OrangeConfigCenter.DMOrangeConfigListener(this) {
                    /* class cn.damai.launcher.initialize.CommonBiz.AnonymousClass8 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // cn.damai.common.OrangeConfigCenter.DMOrangeConfigListener
                    public void onConfigUpdate(String str, boolean z) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "691548590")) {
                            ipChange.ipc$dispatch("691548590", new Object[]{this, str, Boolean.valueOf(z)});
                            return;
                        }
                        String str2 = CommonBiz.TAG;
                        g91.c(str2, "orange: 开始初始化");
                        ht0.b();
                        g91.c(str2, "orange: grayViewOrangeConfig完成");
                    }
                });
                OrangeConfigCenter.c().f("app_startup_config", new OrangeConfigCenter.DMOrangeConfigListener(this, "app_startup_config") {
                    /* class cn.damai.launcher.initialize.CommonBiz.AnonymousClass9 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // cn.damai.common.OrangeConfigCenter.DMOrangeConfigListener
                    public void onConfigUpdate(String str, boolean z) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-2141838707")) {
                            ipChange.ipc$dispatch("-2141838707", new Object[]{this, str, Boolean.valueOf(z)});
                            return;
                        }
                        String customConfig = pn.d().getCustomConfig("app_startup_config", "");
                        if (!TextUtils.isEmpty(customConfig)) {
                            d20.M(customConfig);
                            String str2 = CommonBiz.TAG;
                            g91.c(str2, "app_startup_config: config= " + customConfig);
                        }
                    }
                });
                OrangeConfigCenter.c().f("request_cdn_config", new OrangeConfigCenter.DMOrangeConfigListener(this) {
                    /* class cn.damai.launcher.initialize.CommonBiz.AnonymousClass10 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // cn.damai.common.OrangeConfigCenter.DMOrangeConfigListener
                    public void onConfigUpdate(String str, boolean z) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1029953391")) {
                            ipChange.ipc$dispatch("-1029953391", new Object[]{this, str, Boolean.valueOf(z)});
                            return;
                        }
                        String str2 = CommonBiz.TAG;
                        g91.c(str2, "orange: 开始初始化");
                        Map<String, String> allConfig = pn.d().getAllConfig("request_cdn_config");
                        if (allConfig != null) {
                            d20.O(allConfig.get("homepage_request_cdn"));
                            d20.Q(allConfig.get("newhomepage_request_cdn"));
                            d20.N(allConfig.get("drama_channel_request_cdn"));
                            d20.U(allConfig.get("tablive_request_cdn"));
                            d20.P(allConfig.get(ShareperfenceConstants.NEW_CHANNEL_PAGE_CDN_REQUEST));
                        } else {
                            d20.O("0");
                            d20.Q("0");
                            d20.N("0");
                            d20.U("0");
                            d20.P("0");
                        }
                        g91.c(str2, "orange: grayViewOrangeConfig完成");
                    }
                });
                UniH5ContainerSwitcher.getInstance().registerOrangeConfig();
            }
        }
    }

    private void s(Context context) {
        EnvModeEnum envModeEnum;
        Domain domain;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "115058920")) {
            ipChange.ipc$dispatch("115058920", new Object[]{this, context});
            return;
        }
        if (AppConfig.g() == AppConfig.EnvMode.test) {
            domain = Domain.DOMAIN_TEST;
            envModeEnum = EnvModeEnum.TEST;
        } else if (AppConfig.g() == AppConfig.EnvMode.prepare) {
            domain = Domain.DOMAIN_PRE;
            envModeEnum = EnvModeEnum.PREPARE;
        } else {
            domain = Domain.DOMAIN_ONLINE;
            envModeEnum = EnvModeEnum.ONLINE;
        }
        Mtop instance = Mtop.instance(NetConstants.YOUKU_MTOP_INSTANCE_ID, context, "", 0);
        instance.switchEnvMode(envModeEnum);
        RemoteLogin.setLoginImpl(instance, new LoginImpl(context));
        PassportManager.getInstance().init(new PassportConfig.Builder(context).setProductLineInfo(AppConfig.l(), AppConfig.m()).setUseMtop(true).setSessionMtop(instance).setDomain(domain).setRefreshTokenListener(new IRefreshTokenListener(this) {
            /* class cn.damai.launcher.initialize.CommonBiz.AnonymousClass13 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.usercenter.passport.listener.IRefreshTokenListener
            public void onTokenRefreshed(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1647465872")) {
                    ipChange.ipc$dispatch("1647465872", new Object[]{this, str});
                }
            }
        }).build());
    }

    private void t() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "160095198")) {
            ipChange.ipc$dispatch("160095198", new Object[]{this});
            return;
        }
        OrangeConfigCenter.c().f("damai_image_android_phenix", new OrangeConfigCenter.DMOrangeConfigListener(this) {
            /* class cn.damai.launcher.initialize.CommonBiz.AnonymousClass16 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.OrangeConfigCenter.DMOrangeConfigListener
            public void onConfigUpdate(String str, boolean z) {
                IpChange ipChange = $ipChange;
                final boolean z2 = true;
                if (AndroidInstantRuntime.support(ipChange, "-850407989")) {
                    ipChange.ipc$dispatch("-850407989", new Object[]{this, str, Boolean.valueOf(z)});
                    return;
                }
                if (!Pexode.a(com.taobao.pexode.mimetype.a.WEBP) || !Pexode.a(com.taobao.pexode.mimetype.a.WEBP_A)) {
                    z2 = false;
                }
                xz0.e(xs0.a(), new IImageStrategySupport(this) {
                    /* class cn.damai.launcher.initialize.CommonBiz.AnonymousClass16.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // com.taobao.tao.image.IImageStrategySupport
                    public String getConfigString(String str, String str2, String str3) {
                        IpChange ipChange = $ipChange;
                        if (!AndroidInstantRuntime.support(ipChange, "-1411985737")) {
                            return pn.d().getString("damai_image_android_phenix", str2, str3);
                        }
                        return (String) ipChange.ipc$dispatch("-1411985737", new Object[]{this, str, str2, str3});
                    }

                    @Override // com.taobao.tao.image.IImageStrategySupport
                    public boolean isNetworkSlow() {
                        IpChange ipChange = $ipChange;
                        if (!AndroidInstantRuntime.support(ipChange, "721606227")) {
                            return Monitor.getNetworkSpeed() == NetworkSpeed.Slow;
                        }
                        return ((Boolean) ipChange.ipc$dispatch("721606227", new Object[]{this})).booleanValue();
                    }

                    @Override // com.taobao.tao.image.IImageStrategySupport
                    public boolean isSupportWebP() {
                        IpChange ipChange = $ipChange;
                        if (!AndroidInstantRuntime.support(ipChange, "-1186374089")) {
                            return z2;
                        }
                        return ((Boolean) ipChange.ipc$dispatch("-1186374089", new Object[]{this})).booleanValue();
                    }
                });
                xz0.c().f();
            }
        });
    }

    private void u() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-806903870")) {
            ipChange.ipc$dispatch("-806903870", new Object[]{this});
        } else if (ProcessUtils.b(this.a)) {
            try {
                new DMPopLayer().setup(this.a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void v() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1472975978")) {
            ipChange.ipc$dispatch("-1472975978", new Object[]{this});
            return;
        }
        String n = AppConfig.n(this.a);
        if (ProcessUtils.b(this.a) || ProcessUtils.a(this.a)) {
            try {
                DaMaiPushAgent.h(this.a);
                i();
                Application application = this.a;
                A(application, application, n);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void w() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "122148364")) {
            ipChange.ipc$dispatch("122148364", new Object[]{this});
            return;
        }
        pw1.a(this.a);
    }

    private void y() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2011116030")) {
            ipChange.ipc$dispatch("-2011116030", new Object[]{this});
        } else if (ProcessUtils.b(this.a) || ProcessUtils.a(this.a)) {
            AliSecurityHelper.a();
        }
    }

    private void z() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "63445565")) {
            ipChange.ipc$dispatch("63445565", new Object[]{this});
        } else if (ProcessUtils.b(xs0.a())) {
            cn.damai.solid.a.d().g(xs0.a(), LauncherApplication.sAppCreateTimeMillis);
        }
    }

    public void B() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1422635373")) {
            ipChange.ipc$dispatch("-1422635373", new Object[]{this});
            return;
        }
        xj2.b(new IImageLoader(this) {
            /* class cn.damai.launcher.initialize.CommonBiz.AnonymousClass6 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.uikit.image.IImageLoader
            public void load(String str, int i, int i2, int i3, IImageLoader.IImageSuccListener iImageSuccListener, IImageLoader.IImageFailListener iImageFailListener) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "886430823")) {
                    ipChange.ipc$dispatch("886430823", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), iImageSuccListener, iImageFailListener});
                    return;
                }
                cn.damai.common.image.a.b().load(str, i, i2, i3, iImageSuccListener, iImageFailListener);
            }

            @Override // cn.damai.uikit.image.IImageLoader
            public IImageLoader.ImageTicket loadinto(String str, ImageView imageView) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-1064802065")) {
                    return cn.damai.common.image.a.b().loadinto(str, imageView);
                }
                return (IImageLoader.ImageTicket) ipChange.ipc$dispatch("-1064802065", new Object[]{this, str, imageView});
            }

            @Override // cn.damai.uikit.image.IImageLoader
            public void load(String str, int i, IImageLoader.IImageSuccListener iImageSuccListener, IImageLoader.IImageFailListener iImageFailListener) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1113573063")) {
                    ipChange.ipc$dispatch("1113573063", new Object[]{this, str, Integer.valueOf(i), iImageSuccListener, iImageFailListener});
                    return;
                }
                cn.damai.common.image.a.b().load(str, i, iImageSuccListener, iImageFailListener);
            }

            @Override // cn.damai.uikit.image.IImageLoader
            public IImageLoader.ImageTicket loadinto(String str, ImageView imageView, int i, int i2) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-1391060785")) {
                    return cn.damai.common.image.a.b().loadinto(str, imageView, i, i2);
                }
                return (IImageLoader.ImageTicket) ipChange.ipc$dispatch("-1391060785", new Object[]{this, str, imageView, Integer.valueOf(i), Integer.valueOf(i2)});
            }

            @Override // cn.damai.uikit.image.IImageLoader
            public IImageLoader.ImageTicket load(String str, int i, int i2, IImageLoader.IImageSuccListener iImageSuccListener, IImageLoader.IImageFailListener iImageFailListener) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-875145951")) {
                    return cn.damai.common.image.a.b().load(str, i, i2, iImageSuccListener, iImageFailListener);
                }
                return (IImageLoader.ImageTicket) ipChange.ipc$dispatch("-875145951", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), iImageSuccListener, iImageFailListener});
            }

            @Override // cn.damai.uikit.image.IImageLoader
            public IImageLoader.ImageTicket load(String str, int i, int i2, int i3, int i4, IImageLoader.IImageSuccListener iImageSuccListener, IImageLoader.IImageFailListener iImageFailListener) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-192099455")) {
                    return cn.damai.common.image.a.b().load(str, i, i2, i3, i4, iImageSuccListener, iImageFailListener);
                }
                return (IImageLoader.ImageTicket) ipChange.ipc$dispatch("-192099455", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iImageSuccListener, iImageFailListener});
            }
        }, new TrackProxy.ITrack() {
            /* class cn.damai.launcher.initialize.CommonBiz.AnonymousClass7 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.tetris.core.ut.TrackProxy.ITrack
            public void userTrack(TrackType trackType, View view, String str, String str2, String str3, Map<String, String> map, boolean z) {
                IpChange ipChange = $ipChange;
                int i = 0;
                if (AndroidInstantRuntime.support(ipChange, "-2083521267")) {
                    ipChange.ipc$dispatch("-2083521267", new Object[]{this, trackType, view, str, str2, str3, map, Boolean.valueOf(z)});
                    return;
                }
                switch (a.b[trackType.ordinal()]) {
                    case 1:
                        c.e().x(CommonBiz.this.g(str, str2, str3, map, Boolean.valueOf(z)));
                        return;
                    case 2:
                        c.e().x(CommonBiz.this.g(str, str2, str3, map, Boolean.valueOf(z)));
                        return;
                    case 3:
                        c.e().G(view, str3, str2, str, map);
                        return;
                    case 4:
                        String str4 = map.get("arg1");
                        String str5 = map.get("arg2");
                        if (map.get("eventId") != null) {
                            i = Integer.parseInt(map.get("eventId"));
                        }
                        c.e().D(str, str2, str4, str5, map, i);
                        return;
                    case 5:
                        c.e().A(map, str2, str);
                        return;
                    case 6:
                        try {
                            py2.c(str2, str3, str2, str3, s41.e(map));
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    default:
                        return;
                }
            }
        });
    }

    public void L() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1674124839")) {
            ipChange.ipc$dispatch("-1674124839", new Object[]{this});
        } else if (AppConfig.v() || H()) {
            Intent intent = new Intent();
            intent.setPackage("cn.damai");
            intent.setAction("popcorn_monitor_app_start");
            this.a.sendBroadcast(intent);
        }
    }

    public void M() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1595512693")) {
            ipChange.ipc$dispatch("1595512693", new Object[]{this});
        } else if (AppConfig.v()) {
            boolean u = d20.u();
            sh1.l0(!u);
            sh1.k0(!u);
        }
    }

    public a.b g(String str, String str2, String str3, Map<String, String> map, Boolean bool) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-345139164")) {
            return new a.b().i(str).f(str2).l(str3).g(bool.booleanValue()).j(map);
        }
        return (a.b) ipChange.ipc$dispatch("-345139164", new Object[]{this, str, str2, str3, map, bool});
    }

    public void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-784893608")) {
            ipChange.ipc$dispatch("-784893608", new Object[]{this});
            return;
        }
        pn pnVar = pn.INSTANCE;
        pnVar.g(this.a, APPClient.DM.getClientName());
        pn.d().h("android_dm_config");
        pn.f().h("dm_local_kv_data");
        pnVar.h(new IAppBaseInfoProvider(this) {
            /* class cn.damai.launcher.initialize.CommonBiz.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.alibaba.pictures.cornerstone.IAppBaseInfoProvider
            @Nullable
            public String getAppKey() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "153654217")) {
                    return AppConfig.c();
                }
                return (String) ipChange.ipc$dispatch("153654217", new Object[]{this});
            }

            @Override // com.alibaba.pictures.cornerstone.IAppBaseInfoProvider
            @Nullable
            public String getChannelId() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-1436702775")) {
                    return "";
                }
                return (String) ipChange.ipc$dispatch("-1436702775", new Object[]{this});
            }

            @Override // com.alibaba.pictures.cornerstone.IAppBaseInfoProvider
            @Nullable
            public EnvMode getEnv() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1741980379")) {
                    return (EnvMode) ipChange.ipc$dispatch("-1741980379", new Object[]{this});
                }
                EnvMode envMode = EnvMode.ONLINE;
                int i = a.a[AppConfig.g().ordinal()];
                if (i == 1) {
                    return EnvMode.TEST;
                }
                if (i != 2) {
                    return envMode;
                }
                EnvMode envMode2 = EnvMode.PREPARE;
                return envMode;
            }

            @Override // com.alibaba.pictures.cornerstone.IAppBaseInfoProvider
            @Nullable
            public String getExtraInfo(@Nullable String str) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "1103560287")) {
                    return null;
                }
                return (String) ipChange.ipc$dispatch("1103560287", new Object[]{this, str});
            }

            @Override // com.alibaba.pictures.cornerstone.IAppBaseInfoProvider
            @Nullable
            public String getTTID() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-994187706")) {
                    return AppConfig.p();
                }
                return (String) ipChange.ipc$dispatch("-994187706", new Object[]{this});
            }
        });
    }

    public void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2137681539")) {
            ipChange.ipc$dispatch("2137681539", new Object[]{this});
        } else if (ProcessUtils.b(this.a)) {
            cn.damai.common.image.a.b().h(this.a);
            ne1 ne1 = ne1.INSTANCE;
            ne1.k(pn.d().isExpected(DamaiConstants.CONFIG_KEY_MOIMAGE_XCDN_SWITCH, "on", false));
            ne1.j(pn.d().isExpected(DamaiConstants.CONFIG_KEY_MOIMAGE_DOMAIN_CONVERGE_SWITCH, "on", true));
            ne1.h(this.a, new IMoImageConfig(this) {
                /* class cn.damai.launcher.initialize.CommonBiz.AnonymousClass14 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.alibaba.pictures.moimage.IMoImageConfig
                @Nullable
                public Boolean debugAble() {
                    IpChange ipChange = $ipChange;
                    if (!AndroidInstantRuntime.support(ipChange, "1710793907")) {
                        return Boolean.valueOf(AppConfig.v());
                    }
                    return (Boolean) ipChange.ipc$dispatch("1710793907", new Object[]{this});
                }

                @Override // com.alibaba.pictures.moimage.IMoImageConfig
                @Nullable
                public Integer defaultDrawable() {
                    IpChange ipChange = $ipChange;
                    if (!AndroidInstantRuntime.support(ipChange, "319590251")) {
                        return Integer.valueOf(R$drawable.uikit_default_image_bg_gradient);
                    }
                    return (Integer) ipChange.ipc$dispatch("319590251", new Object[]{this});
                }

                @Override // com.alibaba.pictures.moimage.IMoImageConfig
                @Nullable
                public Integer defaultErrorDrawable() {
                    IpChange ipChange = $ipChange;
                    if (!AndroidInstantRuntime.support(ipChange, "-1248689527")) {
                        return Integer.valueOf(R$drawable.uikit_default_image_bg_gradient);
                    }
                    return (Integer) ipChange.ipc$dispatch("-1248689527", new Object[]{this});
                }

                @Override // com.alibaba.pictures.moimage.IMoImageConfig
                @Nullable
                public Boolean disableFadeIn() {
                    IpChange ipChange = $ipChange;
                    if (!AndroidInstantRuntime.support(ipChange, "-1944817737")) {
                        return Boolean.FALSE;
                    }
                    return (Boolean) ipChange.ipc$dispatch("-1944817737", new Object[]{this});
                }

                @Override // com.alibaba.pictures.moimage.IMoImageConfig
                @Nullable
                public Boolean showImageOff() {
                    IpChange ipChange = $ipChange;
                    if (!AndroidInstantRuntime.support(ipChange, "-140593101")) {
                        return Boolean.TRUE;
                    }
                    return (Boolean) ipChange.ipc$dispatch("-140593101", new Object[]{this});
                }
            });
            ne1.i(new IImageUrlFixer(this) {
                /* class cn.damai.launcher.initialize.CommonBiz.AnonymousClass15 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.alibaba.pictures.moimage.IImageUrlFixer
                @Nullable
                public String addPrefixIfNeeded(@Nullable String str) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1899514631")) {
                        return (String) ipChange.ipc$dispatch("-1899514631", new Object[]{this, str});
                    } else if (str == null || str.startsWith("http")) {
                        return str;
                    } else {
                        return "https://" + str;
                    }
                }

                @Override // com.alibaba.pictures.moimage.IImageUrlFixer
                @Nullable
                public String autoFix(@Nullable String str, int i, int i2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-2068310502")) {
                        return (String) ipChange.ipc$dispatch("-2068310502", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2)});
                    }
                    try {
                        return b.c(str, b.b(str, i, i2));
                    } catch (Exception unused) {
                        return str;
                    }
                }
            });
            t();
        }
    }

    public void m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-908718045")) {
            ipChange.ipc$dispatch("-908718045", new Object[]{this});
            return;
        }
        try {
            o81 o81 = o81.INSTANCE;
            o81.d(xs0.a(), new LocationRequestDelegate(this) {
                /* class cn.damai.launcher.initialize.CommonBiz.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.alibaba.pictures.piclocation.mtop.LocationRequestDelegate
                public void requestRegionData(@NonNull m81 m81, @NonNull RegionRequestHandler regionRequestHandler) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1641620912")) {
                        ipChange.ipc$dispatch("-1641620912", new Object[]{this, m81, regionRequestHandler});
                    }
                }
            }, new LocationErrorReporter(this) {
                /* class cn.damai.launcher.initialize.CommonBiz.AnonymousClass3 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.alibaba.pictures.piclocation.LocationErrorReporter
                public void reportGpsLocateFailed(int i) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1514525279")) {
                        ipChange.ipc$dispatch("1514525279", new Object[]{this, Integer.valueOf(i)});
                        return;
                    }
                    SplashXFlushHelper.d(i);
                }
            });
            o81.h(new GetBlackListInterface(this) {
                /* class cn.damai.launcher.initialize.CommonBiz.AnonymousClass4 */
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX DEBUG: Type inference failed for r1v9. Raw type applied. Possible types: java.util.List<java.lang.String> */
                @Override // com.alibaba.pictures.piclocation.listener.GetBlackListInterface
                @NonNull
                public List<String> getBlackList() {
                    GeoDeBackList geoDeBackList;
                    List list;
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "189071884")) {
                        return (List) ipChange.ipc$dispatch("189071884", new Object[]{this});
                    }
                    List list2 = null;
                    try {
                        StartConfig configFromSp = StartConfig.getConfigFromSp();
                        if (!(configFromSp == null || (geoDeBackList = configFromSp.geoBackList) == null || (list = geoDeBackList.backList) == null)) {
                            list2 = list;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (list2 == null) {
                        list2 = new ArrayList();
                    }
                    if (AppConfig.v()) {
                        g91.c("GeoBackList", "current device model:" + Build.getMODEL());
                        g91.c("GeoBackList", "orange backList:" + s41.e(list2));
                    }
                    return list2;
                }
            });
            o81.i(new GetLocationInfoInterface(this) {
                /* class cn.damai.launcher.initialize.CommonBiz.AnonymousClass5 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.alibaba.pictures.piclocation.listener.GetLocationInfoInterface
                public void getLocationInfoSuccess(AMapLocation aMapLocation, long j) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-51181877")) {
                        ipChange.ipc$dispatch("-51181877", new Object[]{this, aMapLocation, Long.valueOf(j)});
                    } else if (aMapLocation != null) {
                        CompliantUtUtils.b(String.valueOf(aMapLocation.getLatitude()), String.valueOf(aMapLocation.getLongitude()));
                    }
                }
            });
            o81.g(300000);
        } catch (Exception e) {
            g91.c(TAG, "LocationSDK init failed");
            e.printStackTrace();
        }
    }

    public void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2003114897")) {
            ipChange.ipc$dispatch("2003114897", new Object[]{this});
        } else if (ProcessUtils.b(this.a)) {
            qu0 qu0 = new qu0();
            LoginEnvType loginEnvType = LoginEnvType.ONLINE;
            if (AppConfig.g() == AppConfig.EnvMode.test) {
                loginEnvType = LoginEnvType.DEV;
            } else if (AppConfig.g() == AppConfig.EnvMode.prepare) {
                loginEnvType = LoginEnvType.PRE;
            }
            String p = AppConfig.p();
            Login.init(this.a, p, "damai_android_" + AppConfig.q(), loginEnvType, qu0);
        }
    }

    public void o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-189204230")) {
            ipChange.ipc$dispatch("-189204230", new Object[]{this});
            return;
        }
        I(this.a);
    }

    public void x() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1228579598")) {
            ipChange.ipc$dispatch("1228579598", new Object[]{this});
            return;
        }
        Application a2 = xs0.a();
        this.a = a2;
        if (ProcessUtils.b(a2) || ProcessUtils.a(this.a)) {
            G();
            M();
        }
        v();
        r();
        u();
        y();
        i3.b();
        h();
        q();
        l();
        z();
        ShareInit.INSTANCE.b(xs0.a());
        cn.damai.im.a.a();
        PrivacyDoubleListDelegate.INSTANCE.a(this.a);
        this.b.sendEmptyMessageDelayed(1, 2000);
        this.b.sendEmptyMessageDelayed(2, 3000);
        this.b.sendEmptyMessageDelayed(3, 0);
    }
}
