package mtopsdk.mtop.protocol.builder.impl;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import mtopsdk.common.util.HttpHeaderConstant;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.features.MtopFeatureManager;
import mtopsdk.mtop.global.MtopConfig;
import mtopsdk.mtop.global.SDKUtils;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.protocol.builder.ProtocolParamBuilder;
import mtopsdk.security.ISign;
import mtopsdk.xstate.XState;
import mtopsdk.xstate.util.XStateConstants;
import tb.jl1;

/* compiled from: Taobao */
public class OpenProtocolParamBuilderImpl implements ProtocolParamBuilder {
    private static final String TAG = "mtopsdk.OpenProtocolParamBuilderImpl";

    private void buildExtParams(MtopContext mtopContext, Map<String, String> map) {
        MtopNetworkProp mtopNetworkProp = mtopContext.property;
        String str = mtopContext.mtopInstance.getMtopConfig().appVersion;
        if (StringUtils.isNotBlank(str)) {
            map.put(HttpHeaderConstant.X_APP_VER, str);
        }
        String value = XState.getValue("ua");
        if (value != null) {
            map.put("user-agent", value);
        }
        String value2 = XState.getValue("lat");
        if (StringUtils.isNotBlank(value2)) {
            String value3 = XState.getValue("lng");
            if (StringUtils.isNotBlank(value3)) {
                map.put("lat", value2);
                map.put("lng", value3);
            }
        }
    }

    @Override // mtopsdk.mtop.protocol.builder.ProtocolParamBuilder
    public Map<String, String> buildParams(MtopContext mtopContext) {
        String str;
        String str2;
        long j;
        ISign iSign;
        String str3;
        String str4;
        int i;
        long currentTimeMillis = System.currentTimeMillis();
        String instanceId = mtopContext.mtopInstance.getInstanceId();
        MtopConfig mtopConfig = mtopContext.mtopInstance.getMtopConfig();
        if (mtopConfig.sign == null) {
            String str5 = mtopContext.seqNo;
            TBSdkLog.e(TAG, str5, instanceId + " [buildParams] ISign in mtopConfig of mtopInstance  is null");
            return null;
        }
        MtopRequest mtopRequest = mtopContext.mtopRequest;
        MtopNetworkProp mtopNetworkProp = mtopContext.property;
        Mtop mtop = mtopContext.mtopInstance;
        HashMap<String, String> hashMap = new HashMap<>();
        String apiName = mtopRequest.getApiName();
        Locale locale = Locale.US;
        hashMap.put("api", apiName.toLowerCase(locale));
        hashMap.put("v", mtopRequest.getVersion().toLowerCase(locale));
        hashMap.put("data", mtopRequest.getData());
        if (StringUtils.isBlank(mtopNetworkProp.reqAppKey)) {
            mtopNetworkProp.reqAppKey = mtopConfig.appKey;
            mtopNetworkProp.authCode = mtopConfig.authCode;
        }
        String str6 = mtopNetworkProp.reqAppKey;
        String str7 = mtopNetworkProp.authCode;
        hashMap.put("appKey", str6);
        hashMap.put(XStateConstants.KEY_ACCESS_TOKEN, XState.getValue(StringUtils.concatStr(mtop.getInstanceId(), mtopNetworkProp.openAppKey), XStateConstants.KEY_ACCESS_TOKEN));
        String valueOf = String.valueOf(SDKUtils.getCorrectionTime());
        hashMap.put("t", valueOf);
        hashMap.put("utdid", mtopContext.mtopInstance.getUtdid());
        hashMap.put(XStateConstants.KEY_PV, "1.2");
        hashMap.put("x-features", String.valueOf(MtopFeatureManager.getMtopTotalFeatures(mtop)));
        hashMap.put("ttid", mtopNetworkProp.ttid);
        hashMap.put("sid", mtop.getMultiAccountSid(mtopNetworkProp.userInfo));
        ISign iSign2 = mtopConfig.sign;
        if (mtopNetworkProp.wuaFlag >= 0) {
            long currentTimeMillis2 = System.currentTimeMillis();
            String str8 = mtopConfig.wuaAuthCode;
            int i2 = mtopNetworkProp.wuaFlag;
            j = currentTimeMillis;
            str2 = XStateConstants.KEY_ACCESS_TOKEN;
            str4 = "apiKey=";
            iSign = iSign2;
            i = 128;
            str = str7;
            String secBodyDataEx = iSign2.getSecBodyDataEx(valueOf, str6, str8, null, i2);
            mtopContext.stats.computeWuaTime = System.currentTimeMillis() - currentTimeMillis2;
            hashMap.put("wua", secBodyDataEx);
            if (!StringUtils.isBlank(secBodyDataEx) || !TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                str3 = jl1.ARRAY_END_STR;
            } else {
                StringBuilder sb = new StringBuilder(128);
                sb.append(str4);
                sb.append(mtopRequest.getKey());
                sb.append(" call getSecurityBodyDataEx fail, wua is null.[appKey=");
                sb.append(str6);
                sb.append(", wuaAuthCode=");
                sb.append(str8);
                str3 = jl1.ARRAY_END_STR;
                sb.append(str3);
                TBSdkLog.e(TAG, mtopContext.seqNo, sb.toString());
            }
        } else {
            j = currentTimeMillis;
            str3 = jl1.ARRAY_END_STR;
            str = str7;
            str2 = XStateConstants.KEY_ACCESS_TOKEN;
            str4 = "apiKey=";
            i = 128;
            iSign = iSign2;
        }
        if (!TextUtils.isEmpty(mtopNetworkProp.openBiz)) {
            hashMap.put(XStateConstants.KEY_OPEN_BIZ, mtopNetworkProp.openBiz);
            if (!TextUtils.isEmpty(mtopNetworkProp.miniAppKey)) {
                hashMap.put(XStateConstants.KEY_MINI_APPKEY, mtopNetworkProp.miniAppKey);
            }
            if (!TextUtils.isEmpty(mtopNetworkProp.reqAppKey)) {
                hashMap.put(XStateConstants.KEY_REQ_APPKEY, mtopNetworkProp.requestSourceAppKey);
            }
            if (!TextUtils.isEmpty(mtopNetworkProp.openBizData)) {
                hashMap.put(XStateConstants.KEY_OPEN_BIZ_DATA, mtopNetworkProp.openBizData);
            }
            String value = XState.getValue(StringUtils.concatStr(mtop.getInstanceId(), mtopNetworkProp.miniAppKey), str2);
            mtopNetworkProp.accessToken = value;
            if (!TextUtils.isEmpty(value)) {
                hashMap.put(str2, mtopNetworkProp.accessToken);
            }
        } else {
            mtopNetworkProp.openBiz = "baichuan";
            hashMap.put(XStateConstants.KEY_OPEN_BIZ, "baichuan");
        }
        long currentTimeMillis3 = System.currentTimeMillis();
        String mtopApiSign = iSign.getMtopApiSign(hashMap, str6, str);
        mtopContext.stats.computeSignTime = System.currentTimeMillis() - currentTimeMillis3;
        if (StringUtils.isBlank(mtopApiSign)) {
            StringBuilder sb2 = new StringBuilder(i);
            sb2.append(str4);
            sb2.append(mtopRequest.getKey());
            sb2.append(" call getMtopApiSign failed.[appKey=");
            sb2.append(str6);
            sb2.append(", authCode=");
            sb2.append(str);
            sb2.append(str3);
            TBSdkLog.e(TAG, mtopContext.seqNo, sb2.toString());
            return hashMap;
        }
        hashMap.put("sign", mtopApiSign);
        buildExtParams(mtopContext, hashMap);
        mtopContext.stats.buildParamsTime = System.currentTimeMillis() - j;
        return hashMap;
    }
}
