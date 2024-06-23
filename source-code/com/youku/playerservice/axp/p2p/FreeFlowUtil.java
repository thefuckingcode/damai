package com.youku.playerservice.axp.p2p;

import android.content.Context;
import com.youku.alixplayer.config.FeatureManager;
import com.youku.phone.freeflow.YKFreeFlowResult;
import com.youku.phone.freeflow.YoukuFreeFlowApi;
import com.youku.phone.freeflow.model.CarrierType;
import com.youku.playerservice.axp.utils.NetworkUtil;

/* compiled from: Taobao */
public class FreeFlowUtil {
    public static final String FREEFLOWCALLER_DOWNLOAD = "download";
    public static final String FREEFLOWCALLER_FEED = "feed";
    public static final String FREEFLOWCALLER_LIVE = "live";
    public static final String FREEFLOWCALLER_ONDEMAND = "onDemand";
    public static final String FREEFLOWCALLER_P2P = "p2p";
    public static final String FREEFLOWCALLER_SHORTVIDEO = "shortVideo";
    public static boolean isShow4GToast;

    /* renamed from: com.youku.playerservice.axp.p2p.FreeFlowUtil$1  reason: invalid class name */
    /* compiled from: Taobao */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$phone$freeflow$model$CarrierType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            int[] iArr = new int[CarrierType.values().length];
            $SwitchMap$com$youku$phone$freeflow$model$CarrierType = iArr;
            iArr[CarrierType.MOBILE.ordinal()] = 1;
            $SwitchMap$com$youku$phone$freeflow$model$CarrierType[CarrierType.UNICOM.ordinal()] = 2;
            try {
                $SwitchMap$com$youku$phone$freeflow$model$CarrierType[CarrierType.TELECOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static String getFreeFlowType(Context context, String str) {
        YKFreeFlowResult freeFlowResult;
        try {
            if (!NetworkUtil.isConnectedWifi(context) && FeatureManager.getInstance().hasFreeFlow() && (freeFlowResult = YoukuFreeFlowApi.getFreeFlowResult(str)) != null && freeFlowResult.isFreeFlow()) {
                int i = AnonymousClass1.$SwitchMap$com$youku$phone$freeflow$model$CarrierType[freeFlowResult.getCarrierType().ordinal()];
                return i != 1 ? i != 2 ? i != 3 ? "0" : "3" : "2" : "1";
            }
        } catch (Throwable unused) {
        }
        return "0";
    }

    public static boolean isFreeFlow(Context context, String str) {
        if (!FeatureManager.getInstance().hasFreeFlow()) {
            return false;
        }
        return YoukuFreeFlowApi.getFreeFlowResult(str).isFreeFlow();
    }
}
