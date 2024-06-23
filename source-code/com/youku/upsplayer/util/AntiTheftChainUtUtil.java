package com.youku.upsplayer.util;

import com.youku.antitheftchain.interfaces.AntiTheftChainClientType;
import com.youku.upsplayer.module.AntiTheftChainUtLogType;
import com.youku.upsplayer.module.UtAntiTheaftBean;
import com.youku.vpm.constants.TableField;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class AntiTheftChainUtUtil {

    /* access modifiers changed from: package-private */
    /* renamed from: com.youku.upsplayer.util.AntiTheftChainUtUtil$1  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$upsplayer$module$AntiTheftChainUtLogType;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[AntiTheftChainUtLogType.values().length];
            $SwitchMap$com$youku$upsplayer$module$AntiTheftChainUtLogType = iArr;
            iArr[AntiTheftChainUtLogType.ADSTART.ordinal()] = 1;
            $SwitchMap$com$youku$upsplayer$module$AntiTheftChainUtLogType[AntiTheftChainUtLogType.ADEND.ordinal()] = 2;
            $SwitchMap$com$youku$upsplayer$module$AntiTheftChainUtLogType[AntiTheftChainUtLogType.VODSTART.ordinal()] = 3;
            $SwitchMap$com$youku$upsplayer$module$AntiTheftChainUtLogType[AntiTheftChainUtLogType.DOWNLOADSTART.ordinal()] = 4;
            $SwitchMap$com$youku$upsplayer$module$AntiTheftChainUtLogType[AntiTheftChainUtLogType.UNKNOWN.ordinal()] = 5;
            try {
                $SwitchMap$com$youku$upsplayer$module$AntiTheftChainUtLogType[AntiTheftChainUtLogType.CKEYERROR.ordinal()] = 6;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private static void formMap(Map<String, String> map, UtAntiTheaftBean utAntiTheaftBean) {
        String str;
        String str2;
        map.put("utdid", "" + utAntiTheaftBean.utid);
        map.put(TableField.PS_ID, "" + utAntiTheaftBean.psid);
        map.put("ups_client_netip", "" + utAntiTheaftBean.upsClientNetip);
        map.put("ckey", "" + utAntiTheaftBean.ckey);
        map.put("vid", "" + utAntiTheaftBean.vid);
        map.put("title", "" + utAntiTheaftBean.title);
        map.put(WPKFactory.INSTANCE_KEY_LOG_TYPE, "" + utAntiTheaftBean.log_type);
        map.put("ccode", "" + utAntiTheaftBean.ccode);
        map.put("uid", "" + utAntiTheaftBean.uid);
        map.put("vip", "" + utAntiTheaftBean.vip);
        map.put("curent_time", System.currentTimeMillis() + "");
        map.put("curent_thread", Thread.currentThread().getId() + "");
        if (utAntiTheaftBean.isCkeyError && (str2 = utAntiTheaftBean.ckeyErrorMsg) != null) {
            map.put("error_msg", str2);
        }
        if (utAntiTheaftBean.clientid != null) {
            str = "" + utAntiTheaftBean.clientid;
        } else {
            str = "null";
        }
        map.put("client_id", str);
    }

    public static void utlog(AntiTheftChainClientType antiTheftChainClientType, AntiTheftChainUtLogType antiTheftChainUtLogType, UtAntiTheaftBean utAntiTheaftBean) {
        utlogbyAppKey(antiTheftChainClientType, antiTheftChainUtLogType, utAntiTheaftBean, "23640594");
    }

    private static void utlogExternal(UtAntiTheaftBean utAntiTheaftBean, String str) {
        HashMap hashMap = new HashMap();
        formMap(hashMap, utAntiTheaftBean);
        UtHelperProxy.getInstance().sendCustomEvent(str, "PAGE_ATC", "EVENT_ATC_LOG", null, 2341, hashMap);
    }

    private static void utlogInternal(UtAntiTheaftBean utAntiTheaftBean) {
        HashMap hashMap = new HashMap();
        formMap(hashMap, utAntiTheaftBean);
        UtHelperProxy.getInstance().sendCustomEvent(null, "PAGE_ATC", "EVENT_ATC_LOG", null, 2341, hashMap);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0024  */
    public static void utlogbyAppKey(AntiTheftChainClientType antiTheftChainClientType, AntiTheftChainUtLogType antiTheftChainUtLogType, UtAntiTheaftBean utAntiTheaftBean, String str) {
        int i;
        if (utAntiTheaftBean != null) {
            switch (AnonymousClass1.$SwitchMap$com$youku$upsplayer$module$AntiTheftChainUtLogType[antiTheftChainUtLogType.ordinal()]) {
                case 1:
                    i = 1;
                    break;
                case 2:
                    i = 2;
                    break;
                case 3:
                    i = 3;
                    break;
                case 4:
                    i = 4;
                    break;
                case 5:
                    i = 5;
                    break;
                case 6:
                    i = 6;
                    break;
                default:
                    if (antiTheftChainClientType != AntiTheftChainClientType.Internal) {
                        utlogInternal(utAntiTheaftBean);
                        return;
                    } else if (antiTheftChainClientType == AntiTheftChainClientType.External) {
                        utlogExternal(utAntiTheaftBean, str);
                        return;
                    } else {
                        return;
                    }
            }
            utAntiTheaftBean.log_type = i;
            if (antiTheftChainClientType != AntiTheftChainClientType.Internal) {
            }
        }
    }
}
