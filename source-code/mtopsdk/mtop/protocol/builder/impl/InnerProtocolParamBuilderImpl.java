package mtopsdk.mtop.protocol.builder.impl;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.wireless.security.open.securitybodysdk.ISecurityBodyPageTrack;
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
import mtopsdk.mtop.global.SwitchConfig;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.network.NetParam;
import mtopsdk.mtop.protocol.builder.ProtocolParamBuilder;
import mtopsdk.mtop.util.MtopStatistics;
import mtopsdk.security.ISign;
import mtopsdk.security.LocalInnerSignImpl;
import mtopsdk.security.util.SignConstants;
import mtopsdk.xstate.XState;
import mtopsdk.xstate.network.NetworkStateReceiver;
import mtopsdk.xstate.util.XStateConstants;
import org.json.JSONException;
import org.json.JSONObject;
import tb.jl1;

/* compiled from: Taobao */
public class InnerProtocolParamBuilderImpl implements ProtocolParamBuilder {
    private static final String TAG = "mtopsdk.InnerProtocolParamBuilderImpl";
    private MtopConfig mtopConfig = null;

    private void buildExtParams(MtopContext mtopContext, Map<String, String> map) {
        MtopNetworkProp mtopNetworkProp = mtopContext.property;
        map.put("netType", XState.getValue("netType"));
        map.put(XStateConstants.KEY_NQ, XState.getValue(XStateConstants.KEY_NQ));
        if (map.get(XStateConstants.KEY_UMID_TOKEN) == null) {
            map.put(XStateConstants.KEY_UMID_TOKEN, XState.getValue(mtopContext.mtopInstance.getInstanceId(), XStateConstants.KEY_UMID_TOKEN));
        }
        String str = this.mtopConfig.appVersion;
        if (StringUtils.isNotBlank(str)) {
            map.put(HttpHeaderConstant.X_APP_VER, str);
        }
        String str2 = this.mtopConfig.xOrangeQ;
        if (StringUtils.isNotBlank(str2)) {
            map.put(HttpHeaderConstant.X_ORANGE_Q, str2);
        }
        map.put(HttpHeaderConstant.X_APP_CONF_V, String.valueOf(this.mtopConfig.xAppConfigVersion));
        String value = XState.getValue("ua");
        if (value != null) {
            map.put("user-agent", value);
        }
        map.put(HttpHeaderConstant.CLIENT_TRACE_ID, mtopNetworkProp.clientTraceId);
        map.put(HttpHeaderConstant.F_REFER, "mtop");
        if (mtopNetworkProp.netParam > 0) {
            JSONObject jSONObject = new JSONObject();
            if ((mtopNetworkProp.netParam & 1) != 0) {
                String str3 = NetworkStateReceiver.ssid;
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        jSONObject.put(NetParam.NetParamKey.SSID, str3);
                    } catch (JSONException e) {
                        TBSdkLog.w(TAG, "set wifi ssid error.", e);
                    }
                }
            }
            if ((mtopNetworkProp.netParam & 2) != 0) {
                String str4 = NetworkStateReceiver.bssid;
                if (!TextUtils.isEmpty(str4)) {
                    try {
                        jSONObject.put(NetParam.NetParamKey.BSSID, str4);
                    } catch (JSONException e2) {
                        TBSdkLog.w(TAG, "set wifi bssid error.", e2);
                    }
                }
            }
            if (jSONObject.length() > 0) {
                map.put(HttpHeaderConstant.X_NETINFO, jSONObject.toString());
            }
        }
        String str5 = mtopNetworkProp.pageName;
        if (str5 != null) {
            map.put(HttpHeaderConstant.X_PAGE_NAME, str5);
        }
        String str6 = mtopNetworkProp.pageUrl;
        if (str6 != null) {
            map.put(HttpHeaderConstant.X_PAGE_URL, str6);
            String str7 = this.mtopConfig.mtopGlobalABTestParams.get(mtopNetworkProp.pageUrl);
            if (str7 != null) {
                map.put(HttpHeaderConstant.X_PAGE_MAB, str7);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:113:0x03bc  */
    @Override // mtopsdk.mtop.protocol.builder.ProtocolParamBuilder
    public Map<String, String> buildParams(MtopContext mtopContext) {
        Object obj;
        Object obj2;
        Object obj3;
        MtopNetworkProp mtopNetworkProp;
        HashMap<String, String> hashMap;
        String str;
        String str2;
        String str3;
        boolean z;
        String str4;
        int i;
        HashMap<String, String> hashMap2;
        MtopStatistics mtopStatistics = mtopContext.stats;
        mtopStatistics.buildParamsStartTime = mtopStatistics.currentTimeMillis();
        Mtop mtop = mtopContext.mtopInstance;
        MtopConfig mtopConfig2 = mtop.getMtopConfig();
        this.mtopConfig = mtopConfig2;
        ISign iSign = mtopConfig2.sign;
        if (iSign == null) {
            TBSdkLog.e(TAG, mtopContext.seqNo, "ISign of mtopConfig in mtopInstance is null");
            return null;
        }
        MtopRequest mtopRequest = mtopContext.mtopRequest;
        MtopNetworkProp mtopNetworkProp2 = mtopContext.property;
        HashMap<String, String> hashMap3 = new HashMap<>(64);
        hashMap3.put("utdid", mtop.getUtdid());
        hashMap3.put("uid", StringUtils.isNotBlank(mtopNetworkProp2.reqUserId) ? mtopNetworkProp2.reqUserId : mtop.getMultiAccountUserId(mtopNetworkProp2.userInfo));
        if (StringUtils.isNotBlank(mtopNetworkProp2.reqBizExt)) {
            hashMap3.put(XStateConstants.KEY_REQBIZ_EXT, mtopNetworkProp2.reqBizExt);
        }
        if (StringUtils.isBlank(mtopNetworkProp2.reqAppKey)) {
            MtopConfig mtopConfig3 = this.mtopConfig;
            mtopNetworkProp2.reqAppKey = mtopConfig3.appKey;
            mtopNetworkProp2.authCode = mtopConfig3.authCode;
        }
        String str5 = mtopNetworkProp2.reqAppKey;
        String str6 = mtopNetworkProp2.authCode;
        if (StringUtils.isNotBlank(this.mtopConfig.routerId)) {
            hashMap3.put(XStateConstants.KEY_ROUTER_ID, this.mtopConfig.routerId);
        }
        if (StringUtils.isNotBlank(mtopNetworkProp2.routerId)) {
            hashMap3.put(XStateConstants.KEY_ROUTER_ID, mtopNetworkProp2.routerId);
        }
        if (StringUtils.isNotBlank(this.mtopConfig.placeId)) {
            hashMap3.put(XStateConstants.KEY_PLACE_ID, this.mtopConfig.placeId);
        }
        if (StringUtils.isNotBlank(mtopNetworkProp2.placeId)) {
            hashMap3.put(XStateConstants.KEY_PLACE_ID, mtopNetworkProp2.placeId);
        }
        hashMap3.put("appKey", str5);
        String data = mtopRequest.getData();
        if (mtopNetworkProp2.priorityFlag && mtopNetworkProp2.priorityData != null) {
            try {
                JSONObject jSONObject = new JSONObject(data);
                jSONObject.putOpt(HttpHeaderConstant.X_PRIORITY_DATA, JSON.toJSONString(mtopNetworkProp2.priorityData));
                data = jSONObject.toString();
            } catch (Exception e) {
                String str7 = mtopContext.seqNo;
                TBSdkLog.e(TAG, str7, "set api priority data error, priorityData:" + mtopNetworkProp2.priorityData, e);
            }
        }
        hashMap3.put("data", data);
        String valueOf = String.valueOf(SDKUtils.getCorrectionTime());
        hashMap3.put("t", valueOf);
        String apiName = mtopRequest.getApiName();
        Locale locale = Locale.US;
        hashMap3.put("api", apiName.toLowerCase(locale));
        hashMap3.put("v", mtopRequest.getVersion().toLowerCase(locale));
        hashMap3.put("sid", mtop.getMultiAccountSid(mtopNetworkProp2.userInfo));
        hashMap3.put("ttid", mtopNetworkProp2.ttid);
        hashMap3.put("deviceId", mtop.getDeviceId());
        String value = XState.getValue("lat");
        if (StringUtils.isNotBlank(value)) {
            String value2 = XState.getValue("lng");
            if (StringUtils.isNotBlank(value2)) {
                hashMap3.put("lat", value);
                hashMap3.put("lng", value2);
            }
        }
        long mtopTotalFeatures = MtopFeatureManager.getMtopTotalFeatures(mtop);
        if (mtopNetworkProp2.reqSource == 1) {
            mtopTotalFeatures |= MtopFeatureManager.getMtopFeatureValue(11);
        }
        if (mtopNetworkProp2.priorityFlag) {
            mtopTotalFeatures |= MtopFeatureManager.getMtopFeatureValue(12);
        }
        hashMap3.put("x-features", String.valueOf(mtopTotalFeatures));
        if (mtopNetworkProp2.apiType != null) {
            if (mtopNetworkProp2.isInnerOpen) {
                mtopNetworkProp2.accessToken = XState.getValue(StringUtils.concatStr(mtop.getInstanceId(), mtopNetworkProp2.openAppKey), XStateConstants.KEY_ACCESS_TOKEN);
            }
            hashMap3.put(HttpHeaderConstant.KEY_EXTTYPE, mtopNetworkProp2.apiType.getApiType());
            StringBuilder sb = new StringBuilder(64);
            boolean isNotBlank = StringUtils.isNotBlank(mtopNetworkProp2.openAppKey);
            obj = HttpHeaderConstant.KEY_EXTTYPE;
            if (isNotBlank) {
                sb.append(HttpHeaderConstant.KEY_EXTDATA_OPENAPPKEY);
                sb.append("=");
                sb.append(mtopNetworkProp2.openAppKey);
            }
            if (StringUtils.isNotBlank(mtopNetworkProp2.accessToken)) {
                sb.append(";");
                sb.append(HttpHeaderConstant.KEY_EXTDATA_ACCESSTOKEN);
                sb.append("=");
                sb.append(mtopNetworkProp2.accessToken);
            }
            hashMap3.put("extdata", sb.toString());
        } else {
            obj = HttpHeaderConstant.KEY_EXTTYPE;
        }
        if (!TextUtils.isEmpty(mtopNetworkProp2.openBiz)) {
            hashMap3.put(XStateConstants.KEY_OPEN_BIZ, mtopNetworkProp2.openBiz);
            if (!TextUtils.isEmpty(mtopNetworkProp2.miniAppKey)) {
                hashMap3.put(XStateConstants.KEY_MINI_APPKEY, mtopNetworkProp2.miniAppKey);
            }
            if (!TextUtils.isEmpty(mtopNetworkProp2.reqAppKey)) {
                hashMap3.put(XStateConstants.KEY_REQ_APPKEY, mtopNetworkProp2.requestSourceAppKey);
            }
            if (!TextUtils.isEmpty(mtopNetworkProp2.openBizData)) {
                hashMap3.put(XStateConstants.KEY_OPEN_BIZ_DATA, mtopNetworkProp2.openBizData);
            }
            String value3 = XState.getValue(StringUtils.concatStr(mtop.getInstanceId(), mtopNetworkProp2.miniAppKey), XStateConstants.KEY_ACCESS_TOKEN);
            mtopNetworkProp2.accessToken = value3;
            if (!TextUtils.isEmpty(value3)) {
                hashMap3.put(XStateConstants.KEY_ACCESS_TOKEN, mtopNetworkProp2.accessToken);
            }
        }
        HashMap<String, String> hashMap4 = new HashMap<>();
        String str8 = "";
        hashMap4.put(ISecurityBodyPageTrack.PAGE_ID_KEY, TextUtils.isEmpty(mtopNetworkProp2.pageUrl) ? str8 : mtopNetworkProp2.pageUrl);
        hashMap4.put("pageName", TextUtils.isEmpty(mtopNetworkProp2.pageName) ? str8 : mtopNetworkProp2.pageName);
        if ((SwitchConfig.getInstance().getUseSecurityAdapter() & 4) == 4) {
            boolean z2 = mtopNetworkProp2.wuaFlag >= 0 || mtopNetworkProp2.wuaRetry;
            long currentTimeMillis = mtopContext.stats.currentTimeMillis();
            mtopNetworkProp = mtopNetworkProp2;
            obj3 = obj;
            str3 = XStateConstants.KEY_PV;
            hashMap = hashMap4;
            str = str5;
            str2 = "sign";
            obj2 = "extdata";
            str4 = str6;
            HashMap<String, String> unifiedSign = iSign.getUnifiedSign(hashMap3, hashMap4, str5, str6, z2);
            MtopStatistics mtopStatistics2 = mtopContext.stats;
            mtopStatistics2.computeSignTime = mtopStatistics2.currentTimeMillis() - currentTimeMillis;
            if (unifiedSign != null) {
                String str9 = unifiedSign.get("x-sign");
                if (StringUtils.isBlank(str9)) {
                    String str10 = mtopContext.seqNo;
                    TBSdkLog.e(TAG, str10, "[buildParams]get sign failed empty output , apiKey=" + mtopRequest.getKey() + ",authCode=" + str4);
                    return hashMap3;
                }
                hashMap3.put(str2, str9);
                if (!(iSign instanceof LocalInnerSignImpl)) {
                    if (z2) {
                        String str11 = unifiedSign.get("wua");
                        hashMap3.put("wua", str11);
                        if (StringUtils.isBlank(str11)) {
                            String str12 = mtopContext.seqNo;
                            TBSdkLog.e(TAG, str12, "[buildParams]get wua failed empty output , apiKey=" + mtopRequest.getKey() + ",authCode=" + str4);
                        }
                    }
                    String str13 = unifiedSign.get(HttpHeaderConstant.X_MINI_WUA);
                    hashMap3.put(HttpHeaderConstant.X_MINI_WUA, str13);
                    if (StringUtils.isBlank(str13)) {
                        String str14 = mtopContext.seqNo;
                        TBSdkLog.e(TAG, str14, "[buildParams]get mini wua failed empty output , apiKey=" + mtopRequest.getKey() + ",authCode=" + str4);
                    }
                }
                String str15 = unifiedSign.get("x-umt");
                hashMap3.put(XStateConstants.KEY_UMID_TOKEN, str15);
                if (StringUtils.isBlank(str15)) {
                    String str16 = mtopContext.seqNo;
                    TBSdkLog.e(TAG, str16, "[buildParams]get umt failed empty output , apiKey=" + mtopRequest.getKey() + ",authCode=" + str4);
                }
                String str17 = unifiedSign.get(SignConstants.MIDDLE_OUTPUT_X_SG_EXT);
                if (StringUtils.isNotBlank(str17)) {
                    hashMap3.put(SignConstants.MIDDLE_OUTPUT_X_SG_EXT, str17);
                }
                hashMap3.put(str3, XStateConstants.VALUE_INNER_PV);
                z = true;
                if (!z) {
                    hashMap3.remove(obj3);
                    hashMap3.remove(obj2);
                    hashMap3.put(str3, "6.2");
                    long currentTimeMillis2 = mtopContext.stats.currentTimeMillis();
                    String mtopApiSign = iSign.getMtopApiSign(hashMap3, str, str4);
                    MtopStatistics mtopStatistics3 = mtopContext.stats;
                    mtopStatistics3.computeSignTime = mtopStatistics3.currentTimeMillis() - currentTimeMillis2;
                    if (StringUtils.isBlank(mtopApiSign)) {
                        StringBuilder sb2 = new StringBuilder(128);
                        sb2.append("apiKey=");
                        sb2.append(mtopRequest.getKey());
                        sb2.append(" call getMtopApiSign failed.[appKey=");
                        sb2.append(str);
                        sb2.append(", authCode=");
                        sb2.append(str4);
                        sb2.append(jl1.ARRAY_END_STR);
                        TBSdkLog.e(TAG, mtopContext.seqNo, sb2.toString());
                        return hashMap3;
                    }
                    hashMap3.put(str2, mtopApiSign);
                    if (!(iSign instanceof LocalInnerSignImpl)) {
                        if (mtopNetworkProp.wuaFlag >= 0 || mtopNetworkProp.wuaRetry) {
                            long currentTimeMillis3 = mtopContext.stats.currentTimeMillis();
                            i = 1;
                            String wua = (SwitchConfig.getInstance().getUseSecurityAdapter() & 1) == 1 ? iSign.getWua(hashMap3, str) : str8;
                            if (StringUtils.isBlank(wua)) {
                                wua = iSign.getAvmpSign(mtopApiSign, str4, mtopNetworkProp.wuaFlag);
                            }
                            MtopStatistics mtopStatistics4 = mtopContext.stats;
                            mtopStatistics4.computeWuaTime = mtopStatistics4.currentTimeMillis() - currentTimeMillis3;
                            if (!StringUtils.isBlank(wua)) {
                                hashMap3.put("wua", wua);
                            } else {
                                String str18 = mtopContext.seqNo;
                                TBSdkLog.e(TAG, str18, mtopRequest.getKey() + " call getAvmpSign for wua fail.");
                            }
                        } else {
                            i = 1;
                        }
                        long currentTimeMillis4 = mtopContext.stats.currentTimeMillis();
                        if ((SwitchConfig.getInstance().getUseSecurityAdapter() & i) == i) {
                            hashMap2 = hashMap;
                            str8 = iSign.getMiniWua(hashMap3, hashMap2);
                        } else {
                            hashMap2 = hashMap;
                        }
                        if (StringUtils.isBlank(str8)) {
                            str8 = iSign.getSecBodyDataEx(valueOf, str, str4, hashMap2, 8);
                        }
                        MtopStatistics mtopStatistics5 = mtopContext.stats;
                        mtopStatistics5.computeMiniWuaTime = mtopStatistics5.currentTimeMillis() - currentTimeMillis4;
                        hashMap3.put(HttpHeaderConstant.X_MINI_WUA, str8);
                        if (StringUtils.isBlank(str8)) {
                            String str19 = mtopContext.seqNo;
                            TBSdkLog.e(TAG, str19, mtopRequest.getKey() + " call getSecurityBodyDataEx for mini_wua failed.");
                        }
                    }
                }
                buildExtParams(mtopContext, hashMap3);
                MtopStatistics mtopStatistics6 = mtopContext.stats;
                mtopStatistics6.buildParamsEndTime = mtopStatistics6.currentTimeMillis();
                MtopStatistics mtopStatistics7 = mtopContext.stats;
                mtopStatistics7.buildParamsTime = mtopStatistics7.buildParamsEndTime - mtopStatistics7.buildParamsStartTime;
                return hashMap3;
            }
        } else {
            obj2 = "extdata";
            mtopNetworkProp = mtopNetworkProp2;
            str = str5;
            obj3 = obj;
            hashMap = hashMap4;
            str3 = XStateConstants.KEY_PV;
            str2 = "sign";
            str4 = str6;
        }
        z = false;
        if (!z) {
        }
        buildExtParams(mtopContext, hashMap3);
        MtopStatistics mtopStatistics62 = mtopContext.stats;
        mtopStatistics62.buildParamsEndTime = mtopStatistics62.currentTimeMillis();
        MtopStatistics mtopStatistics72 = mtopContext.stats;
        mtopStatistics72.buildParamsTime = mtopStatistics72.buildParamsEndTime - mtopStatistics72.buildParamsStartTime;
        return hashMap3;
    }
}
