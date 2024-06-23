package com.youku.live.dago.liveplayback.widget;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.IConfigCenter;
import com.youku.alixplayer.opensdk.AXPParamsProvider;
import com.youku.alixplayer.opensdk.PlayerConfig;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.config.ConfigUtil;
import com.youku.alixplayer.opensdk.config.IConfigCenterFactory;
import com.youku.alixplayer.opensdk.drm.DrmConfig;
import com.youku.alixplayer.opensdk.utils.Callable;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.android.liveservice.bean.Quality;
import com.youku.arch.beast.apas.ApasConfigure;
import com.youku.kubus.Event;
import com.youku.live.dago.liveplayback.ApiConstants;
import com.youku.live.dago.liveplayback.widget.plugins.toptip.TopTipInfo;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.IRemoteLog;
import com.youku.live.livesdk.constants.CcodeConstants;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.media.arch.instruments.utils.RemoteLogger;
import com.youku.network.HttpIntent;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
public class Utils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String DATA_COME_IN_PLAYCONTROLLER_UNIQUEKEY = "intent.data.come.in.room.playcontroller.uniquekey";
    public static final String PLAYER_WIDGET_SP = "player_widget_dagoliveplayback";
    private static boolean mHasInitLogger = false;
    private static PlayerConfig sPlayerConfig = null;
    private static String s_DBGUID = "";

    public static String ToMD5(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1857217631")) {
            return (String) ipChange.ipc$dispatch("1857217631", new Object[]{str});
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.reset();
            instance.update(str.getBytes("UTF-8"));
            return toHexString(instance.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        return "";
    }

    public static boolean containPlayStream(YoukuVideoInfo youkuVideoInfo, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1930054281")) {
            return ((Boolean) ipChange.ipc$dispatch("-1930054281", new Object[]{youkuVideoInfo, Integer.valueOf(i)})).booleanValue();
        }
        if (!(youkuVideoInfo == null || youkuVideoInfo.getLivePlayControl() == null || youkuVideoInfo.getLivePlayControl().qualities == null)) {
            for (Quality quality : youkuVideoInfo.getLivePlayControl().qualities) {
                if (quality.quality == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public static float dp2px(Context context, float f) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "961657268")) {
            return (float) ((int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f));
        }
        return ((Float) ipChange.ipc$dispatch("961657268", new Object[]{context, Float.valueOf(f)})).floatValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e1  */
    public static String formatNum(String str, Boolean bool) {
        String str2;
        String str3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "452642504")) {
            return (String) ipChange.ipc$dispatch("452642504", new Object[]{str, bool});
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (bool == null) {
            bool = Boolean.FALSE;
        }
        BigDecimal bigDecimal = new BigDecimal("1000");
        BigDecimal bigDecimal2 = new BigDecimal("10000");
        BigDecimal bigDecimal3 = new BigDecimal("100000000");
        BigDecimal bigDecimal4 = new BigDecimal(str);
        if (bool.booleanValue()) {
            return (bigDecimal4.compareTo(bigDecimal) == 0 || bigDecimal4.compareTo(bigDecimal) == 1) ? "999+" : str;
        }
        if (bigDecimal4.compareTo(bigDecimal2) == -1) {
            stringBuffer.append(bigDecimal4.toString());
        } else if ((bigDecimal4.compareTo(bigDecimal2) == 0 && bigDecimal4.compareTo(bigDecimal2) == 1) || bigDecimal4.compareTo(bigDecimal3) == -1) {
            str2 = bigDecimal4.divide(bigDecimal2).toString();
            str3 = "万";
            if (!"".equals(str2)) {
            }
            if (stringBuffer.length() == 0) {
            }
        } else if (bigDecimal4.compareTo(bigDecimal3) == 0 || bigDecimal4.compareTo(bigDecimal3) == 1) {
            str2 = bigDecimal4.divide(bigDecimal3).toString();
            str3 = "亿";
            if (!"".equals(str2)) {
                int indexOf = str2.indexOf(".");
                if (indexOf == -1) {
                    stringBuffer.append(str2);
                    stringBuffer.append(".0");
                    stringBuffer.append(str3);
                } else {
                    int i = indexOf + 1;
                    int i2 = i + 1;
                    if (!str2.substring(i, i2).equals("0")) {
                        stringBuffer.append(str2.substring(0, i2));
                        stringBuffer.append(str3);
                    } else {
                        stringBuffer.append(str2.substring(0, i2));
                        stringBuffer.append(str3);
                    }
                }
            }
            if (stringBuffer.length() == 0) {
                return "0";
            }
            return stringBuffer.toString();
        }
        str2 = "";
        str3 = str2;
        if (!"".equals(str2)) {
        }
        if (stringBuffer.length() == 0) {
        }
    }

    public static String getAppkey(Context context) {
        ClientType clientType;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1654510594")) {
            return (String) ipChange.ipc$dispatch("-1654510594", new Object[]{context});
        }
        if (context == null || (clientType = getClientType(context)) == ClientType.YOUKU || clientType != ClientType.YOUKU_HWBAIPAI) {
            return "23570660";
        }
        return "24687976";
    }

    public static String getApsConfig(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-240453310")) {
            return ConfigFetcher.getInstance().getConfig(str, str2, str3);
        }
        return (String) ipChange.ipc$dispatch("-240453310", new Object[]{str, str2, str3});
    }

    public static ClientType getClientType(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "326233753")) {
            return (ClientType) ipChange.ipc$dispatch("326233753", new Object[]{context});
        }
        String str = context.getApplicationInfo().packageName;
        if (AXPParamsProvider.ClientType.YOUKU.equals(str)) {
            return ClientType.YOUKU;
        }
        if (AXPParamsProvider.ClientType.LAIFENG.equals(str)) {
            return ClientType.LAIFENG;
        }
        if (AXPParamsProvider.ClientType.YOUKU_HWBAIPAI.equals(str)) {
            return ClientType.YOUKU_HWBAIPAI;
        }
        if ("cn.damai".equals(str)) {
            return ClientType.DAMAI;
        }
        return ClientType.OTHER;
    }

    public static PlayerConfig getDefaultPlayerConfig(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1605749963")) {
            return (PlayerConfig) ipChange.ipc$dispatch("-1605749963", new Object[]{context});
        }
        if (sPlayerConfig == null) {
            PlayerConfig dynamicProperties = new PlayerConfig().setPlayerViewType(1).setAppKey(getAppkey(context)).setLiveCCode(getLiveCCode(context)).setCCode(getVodCCode(context)).setUseHardwareDecode(false).setDynamicProperties(new Callable<String>() {
                /* class com.youku.live.dago.liveplayback.widget.Utils.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                /* JADX WARNING: Code restructure failed: missing block: B:11:0x0038, code lost:
                    if (r7.equals(com.youku.vpm.constants.TableField.IS_VIP) == false) goto L_0x0025;
                 */
                @Override // com.youku.alixplayer.opensdk.utils.Callable
                public String call(String str) {
                    IpChange ipChange = $ipChange;
                    char c = 2;
                    if (AndroidInstantRuntime.support(ipChange, "366581303")) {
                        return (String) ipChange.ipc$dispatch("366581303", new Object[]{this, str});
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
            sPlayerConfig = dynamicProperties;
            dynamicProperties.setDrmConfig(new DrmConfig(getAppkey(context), ""));
        }
        if (isYoukuOrHuaweiBaipai(context)) {
            ConfigUtil.setConfigCenterFactory(new IConfigCenterFactory() {
                /* class com.youku.live.dago.liveplayback.widget.Utils.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.alixplayer.opensdk.config.IConfigCenterFactory
                public IConfigCenter getConfigCenter() {
                    IpChange ipChange = $ipChange;
                    if (!AndroidInstantRuntime.support(ipChange, "238836774")) {
                        return new ApasConfigure();
                    }
                    return (IConfigCenter) ipChange.ipc$dispatch("238836774", new Object[]{this});
                }
            });
        }
        return sPlayerConfig;
    }

    public static String getDiffTimeMillis(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1823239402")) {
            return (String) ipChange.ipc$dispatch("1823239402", new Object[]{str});
        }
        double d = 0.0d;
        try {
            d = Double.valueOf(str).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(d / 1000.0d);
    }

    public static String getDlnaCCode(Context context) {
        ClientType clientType;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "664667273")) {
            return (String) ipChange.ipc$dispatch("664667273", new Object[]{context});
        }
        if (context == null || (clientType = getClientType(context)) == ClientType.YOUKU || clientType != ClientType.YOUKU_HWBAIPAI) {
            return CcodeConstants.YOUKU_APP_OTT_CCODE;
        }
        return "live01060201";
    }

    public static String getFormatMinuteTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1961082296")) {
            return (String) ipChange.ipc$dispatch("-1961082296", new Object[]{Long.valueOf(j)});
        }
        long j2 = j / 1000;
        StringBuffer stringBuffer = new StringBuffer();
        long j3 = j2 / 60;
        long j4 = j2 - (60 * j3);
        if (j3 < 10) {
            stringBuffer.append("0");
        }
        stringBuffer.append(j3);
        stringBuffer.append(":");
        if (j4 < 10) {
            stringBuffer.append("0");
        }
        stringBuffer.append(j4);
        return stringBuffer.toString();
    }

    public static String getFormathourTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-119532904")) {
            return (String) ipChange.ipc$dispatch("-119532904", new Object[]{Long.valueOf(j)});
        }
        long j2 = j / 1000;
        StringBuffer stringBuffer = new StringBuffer();
        long j3 = j2 / 3600;
        long j4 = (j2 / 60) - (j3 * 60);
        long j5 = (j2 - (3600 * j3)) - (60 * j4);
        if (j3 > 0) {
            if (j3 < 10) {
                stringBuffer.append("0");
            }
            stringBuffer.append(j3);
            stringBuffer.append(":");
        }
        if (j4 < 10) {
            stringBuffer.append("0");
        }
        stringBuffer.append(j4);
        stringBuffer.append(":");
        if (j5 < 10) {
            stringBuffer.append("0");
        }
        stringBuffer.append(j5);
        return stringBuffer.toString();
    }

    public static String getGUID(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1400026157")) {
            return (String) ipChange.ipc$dispatch("-1400026157", new Object[]{context});
        } else if (!s_DBGUID.equals("")) {
            return s_DBGUID;
        } else {
            String ToMD5 = ToMD5(String.format("%s&%s&&", getLocalMacAddress(context), getIMEI(context)));
            s_DBGUID = ToMD5;
            return ToMD5;
        }
    }

    public static String getIMEI(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1497850892")) {
            return (String) ipChange.ipc$dispatch("-1497850892", new Object[]{context});
        }
        try {
            if (ContextCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") != 0) {
                return "";
            }
            return TelephonyManager.getDeviceId((android.telephony.TelephonyManager) context.getSystemService("phone"));
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getLiveCCode(Context context) {
        ClientType clientType;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-843370758")) {
            return (String) ipChange.ipc$dispatch("-843370758", new Object[]{context});
        }
        if (context == null || (clientType = getClientType(context)) == ClientType.YOUKU) {
            return CcodeConstants.YOUKU_APP_CCODE;
        }
        if (clientType == ClientType.LAIFENG) {
            return "live01010101laifeng";
        }
        if (clientType == ClientType.YOUKU_HWBAIPAI) {
            return "live01060101";
        }
        return CcodeConstants.YOUKU_APP_CCODE;
    }

    public static Quality getLiveControlQuality(YoukuVideoInfo youkuVideoInfo, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "750156052")) {
            return (Quality) ipChange.ipc$dispatch("750156052", new Object[]{youkuVideoInfo, Integer.valueOf(i)});
        } else if (youkuVideoInfo.getLivePlayControl() == null) {
            return null;
        } else {
            for (Quality quality : youkuVideoInfo.getLivePlayControl().qualities) {
                if (quality.quality == i) {
                    return quality;
                }
            }
            return null;
        }
    }

    public static final String getLocalMacAddress(Context context) {
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "187810734")) {
            return (String) ipChange.ipc$dispatch("187810734", new Object[]{context});
        }
        if (context == null || (wifiManager = (WifiManager) context.getSystemService("wifi")) == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return "";
        }
        return com.alibaba.wireless.security.aopsdk.replace.android.net.wifi.WifiInfo.getMacAddress(connectionInfo);
    }

    public static String getPlaySid(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1248487068")) {
            return (String) ipChange.ipc$dispatch("-1248487068", new Object[]{context});
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        String guid = getGUID(context);
        return ToMD5(valueOf + ((long) (((Math.random() * 9.0d) + 1.0d) * 100000.0d)) + guid);
    }

    public static String getVodCCode(Context context) {
        ClientType clientType;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1593268567")) {
            return (String) ipChange.ipc$dispatch("1593268567", new Object[]{context});
        }
        if (context == null || (clientType = getClientType(context)) == ClientType.YOUKU || clientType != ClientType.YOUKU_HWBAIPAI) {
            return "01010101";
        }
        return "0101011E";
    }

    public static void hideTopTips(AlixPlayerContext alixPlayerContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1756424056")) {
            ipChange.ipc$dispatch("1756424056", new Object[]{alixPlayerContext});
            return;
        }
        alixPlayerContext.getEventBus().post(new Event(ApiConstants.EventType.REQUEST_TOP_TIP_HIDE));
    }

    public static void initRemoteLogger() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1912687914")) {
            ipChange.ipc$dispatch("1912687914", new Object[0]);
        } else if (!mHasInitLogger) {
            mHasInitLogger = true;
            RemoteLogger.setRemoteAdapter(new RemoteLogger.IRemoteAdapter() {
                /* class com.youku.live.dago.liveplayback.widget.Utils.AnonymousClass3 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.media.arch.instruments.utils.RemoteLogger.IRemoteAdapter
                public void log(String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-70041765")) {
                        ipChange.ipc$dispatch("-70041765", new Object[]{this, str, str2});
                        return;
                    }
                    ((IRemoteLog) Dsl.getService(IRemoteLog.class)).e(str, str2);
                }
            });
        }
    }

    public static boolean isYoukuOrHuaweiBaipai(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-62657143")) {
            return getClientType(context) == ClientType.YOUKU || getClientType(context) == ClientType.YOUKU_HWBAIPAI;
        }
        return ((Boolean) ipChange.ipc$dispatch("-62657143", new Object[]{context})).booleanValue();
    }

    public static float px2sp(Context context, float f) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1054983931")) {
            return (float) ((int) ((f / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f));
        }
        return ((Float) ipChange.ipc$dispatch("1054983931", new Object[]{context, Float.valueOf(f)})).floatValue();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T reinterpretCast(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "872350325")) {
            return (T) ipChange.ipc$dispatch("872350325", new Object[]{obj});
        } else if (obj != 0) {
            return obj;
        } else {
            return null;
        }
    }

    public static void setPlayerConfig(PlayerConfig playerConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1530470506")) {
            ipChange.ipc$dispatch("1530470506", new Object[]{playerConfig});
            return;
        }
        sPlayerConfig = playerConfig;
    }

    public static void showCustomTopTips(AlixPlayerContext alixPlayerContext, TopTipInfo topTipInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1265210029")) {
            ipChange.ipc$dispatch("1265210029", new Object[]{alixPlayerContext, topTipInfo});
        } else if (topTipInfo != null) {
            Event event = new Event(ApiConstants.EventType.REQUEST_TOP_TIP_SHOW);
            HashMap hashMap = new HashMap();
            hashMap.put("object", topTipInfo);
            event.data = hashMap;
            alixPlayerContext.getEventBus().post(event);
        }
    }

    public static void showTopTips(AlixPlayerContext alixPlayerContext, String str, CharSequence charSequence, int i, int i2, int i3, boolean z, View.OnClickListener onClickListener, TopTipInfo.DismissCallback dismissCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-924893633")) {
            ipChange.ipc$dispatch("-924893633", new Object[]{alixPlayerContext, str, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), onClickListener, dismissCallback});
            return;
        }
        TopTipInfo topTipInfo = new TopTipInfo();
        topTipInfo.tipName = str;
        topTipInfo.style = 5;
        topTipInfo.rightIconRes = i2;
        topTipInfo.time = i3;
        topTipInfo.text = charSequence;
        topTipInfo.tipSeq = i;
        topTipInfo.needFullScreen = z;
        topTipInfo.onClickListener = onClickListener;
        topTipInfo.dismissCallback = dismissCallback;
        Event event = new Event(ApiConstants.EventType.REQUEST_TOP_TIP_SHOW);
        HashMap hashMap = new HashMap();
        hashMap.put("object", topTipInfo);
        event.data = hashMap;
        alixPlayerContext.getEventBus().post(event);
    }

    public static void showVipTopTips(AlixPlayerContext alixPlayerContext, String str, CharSequence charSequence, int i, int i2, int i3, boolean z, View.OnClickListener onClickListener, TopTipInfo.DismissCallback dismissCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1325652408")) {
            ipChange.ipc$dispatch("1325652408", new Object[]{alixPlayerContext, str, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), onClickListener, dismissCallback});
            return;
        }
        TopTipInfo topTipInfo = new TopTipInfo();
        topTipInfo.tipName = str;
        topTipInfo.rightIconRes = i2;
        topTipInfo.time = i3;
        topTipInfo.style = 4;
        topTipInfo.text = charSequence;
        topTipInfo.tipSeq = i;
        topTipInfo.needFullScreen = z;
        topTipInfo.onClickListener = onClickListener;
        topTipInfo.dismissCallback = dismissCallback;
        Event event = new Event(ApiConstants.EventType.REQUEST_TOP_TIP_SHOW);
        HashMap hashMap = new HashMap();
        hashMap.put("object", topTipInfo);
        event.data = hashMap;
        alixPlayerContext.getEventBus().post(event);
    }

    private static String toHexString(byte[] bArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1656835088")) {
            return (String) ipChange.ipc$dispatch("1656835088", new Object[]{bArr});
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            int i = b;
            if (b < 0) {
                i = b + 256;
            }
            if (Integer.valueOf(i == 1 ? 1 : 0).intValue() < 16) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(i));
        }
        return sb.toString();
    }

    public static String getApsConfig(Context context, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1630951162")) {
            return ConfigFetcher.getInstance().getConfig(str, str2, str3);
        }
        return (String) ipChange.ipc$dispatch("1630951162", new Object[]{context, str, str2, str3});
    }
}
