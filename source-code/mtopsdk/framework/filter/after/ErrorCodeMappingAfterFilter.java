package mtopsdk.framework.filter.after;

import androidx.annotation.NonNull;
import java.util.HashMap;
import mtopsdk.common.util.MtopUtils;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.framework.filter.IAfterFilter;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.global.SwitchConfig;
import mtopsdk.mtop.stat.IMtopMonitor;
import mtopsdk.mtop.stat.MtopMonitor;
import mtopsdk.mtop.util.ErrorConstant;

/* compiled from: Taobao */
public class ErrorCodeMappingAfterFilter implements IAfterFilter {
    private static final String TAG = "mtopsdk.ErrorCodeMappingAfterFilter";

    /* JADX WARNING: Removed duplicated region for block: B:148:0x042f  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x04ec  */
    @Override // mtopsdk.framework.filter.IAfterFilter
    public String doAfter(MtopContext mtopContext) {
        String str;
        String str2;
        Throwable th;
        Exception e;
        String str3 = IMtopMonitor.MtopMonitorType.TYPE_ERROR_RESPONSE;
        String str4 = mtopContext.seqNo;
        if (!SwitchConfig.getInstance().isGlobalErrorCodeMappingOpen()) {
            TBSdkLog.i(TAG, str4, "GlobalErrorCodeMappingOpen=false,Don't do ErrorCode Mapping.");
            return "CONTINUE";
        }
        MtopResponse mtopResponse = mtopContext.mtopResponse;
        if (mtopResponse.isApiSuccess()) {
            return "CONTINUE";
        }
        try {
            if (mtopResponse.isNoNetwork()) {
                mtopContext.stats.isNoNetwork = true;
            }
            if (mtopResponse.isNetworkError()) {
                mtopResponse.mappingCodeSuffix = ErrorConstant.getMappingCodeByErrorCode(mtopResponse.getRetCode());
                mtopResponse.mappingCode = ErrorConstant.appendMappingCode(mtopResponse.getResponseCode(), mtopResponse.mappingCodeSuffix);
                String str5 = SwitchConfig.errorMappingMsgMap.get(ErrorConstant.ErrorMappingType.NETWORK_ERROR_MAPPING);
                if (str5 == null) {
                    str5 = "网络竟然崩溃了";
                }
                mtopResponse.setRetMsg(str5);
                mtopContext.stats.retType = 1;
                TBSdkLog.e(TAG, str4, mtopResponse.getResponseLog());
                TBSdkLog.e(TAG, str4, mtopContext.mtopRequest.getRequestLog());
                if (MtopMonitor.getInstance() != null) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put(IMtopMonitor.DATA_REQUEST, mtopContext.mtopRequest.getRequestLog());
                    hashMap.put(IMtopMonitor.DATA_RESPONSE, mtopResponse.getResponseLog());
                    hashMap.put(IMtopMonitor.DATA_SEQ, mtopContext.seqNo);
                    IMtopMonitor instance = MtopMonitor.getInstance();
                    if (mtopResponse.getHeaderFields() == null) {
                        str3 = IMtopMonitor.MtopMonitorType.TYPE_ERROR_REQUEST;
                    }
                    instance.onCommit(str3, hashMap);
                }
                return "CONTINUE";
            }
            mtopContext.stats.retType = 2;
            boolean is41XResult = mtopResponse.is41XResult();
            String str6 = ErrorConstant.UNKNOWN_SERVER_MAPPING_CODE_SUFFIX;
            if (is41XResult || mtopResponse.isApiLockedResult()) {
                String mappingCodeByErrorCode = ErrorConstant.getMappingCodeByErrorCode(mtopResponse.getRetCode());
                if (StringUtils.isNotBlank(mappingCodeByErrorCode)) {
                    str6 = mappingCodeByErrorCode;
                }
                mtopResponse.mappingCodeSuffix = str6;
                mtopResponse.mappingCode = ErrorConstant.appendMappingCode(mtopResponse.getResponseCode(), mtopResponse.mappingCodeSuffix);
                String str7 = SwitchConfig.errorMappingMsgMap.get(ErrorConstant.ErrorMappingType.FLOW_LIMIT_ERROR_MAPPING);
                if (str7 == null) {
                    str7 = "前方拥挤，亲稍等再试试";
                }
                mtopResponse.setRetMsg(str7);
                TBSdkLog.e(TAG, str4, mtopResponse.getResponseLog());
                TBSdkLog.e(TAG, str4, mtopContext.mtopRequest.getRequestLog());
                if (MtopMonitor.getInstance() != null) {
                    HashMap<String, String> hashMap2 = new HashMap<>();
                    hashMap2.put(IMtopMonitor.DATA_REQUEST, mtopContext.mtopRequest.getRequestLog());
                    hashMap2.put(IMtopMonitor.DATA_RESPONSE, mtopResponse.getResponseLog());
                    hashMap2.put(IMtopMonitor.DATA_SEQ, mtopContext.seqNo);
                    MtopMonitor.getInstance().onCommit(mtopResponse.getHeaderFields() != null ? str3 : IMtopMonitor.MtopMonitorType.TYPE_ERROR_REQUEST, hashMap2);
                }
                return "CONTINUE";
            }
            String str8 = "服务竟然出错了";
            if (mtopResponse.isMtopServerError()) {
                if (StringUtils.isBlank(mtopResponse.mappingCodeSuffix)) {
                    String mappingCodeByErrorCode2 = ErrorConstant.getMappingCodeByErrorCode(mtopResponse.getRetCode());
                    if (StringUtils.isNotBlank(mappingCodeByErrorCode2)) {
                        str6 = mappingCodeByErrorCode2;
                    }
                    mtopResponse.mappingCodeSuffix = str6;
                }
                mtopResponse.mappingCode = ErrorConstant.appendMappingCode(mtopResponse.getResponseCode(), mtopResponse.mappingCodeSuffix);
                String str9 = SwitchConfig.errorMappingMsgMap.get(ErrorConstant.ErrorMappingType.SERVICE_ERROR_MAPPING);
                if (str9 != null) {
                    str8 = str9;
                }
                mtopResponse.setRetMsg(str8);
                TBSdkLog.e(TAG, str4, mtopResponse.getResponseLog());
                TBSdkLog.e(TAG, str4, mtopContext.mtopRequest.getRequestLog());
                if (MtopMonitor.getInstance() != null) {
                    HashMap<String, String> hashMap3 = new HashMap<>();
                    hashMap3.put(IMtopMonitor.DATA_REQUEST, mtopContext.mtopRequest.getRequestLog());
                    hashMap3.put(IMtopMonitor.DATA_RESPONSE, mtopResponse.getResponseLog());
                    hashMap3.put(IMtopMonitor.DATA_SEQ, mtopContext.seqNo);
                    IMtopMonitor instance2 = MtopMonitor.getInstance();
                    if (mtopResponse.getHeaderFields() == null) {
                        str3 = IMtopMonitor.MtopMonitorType.TYPE_ERROR_REQUEST;
                    }
                    instance2.onCommit(str3, hashMap3);
                }
                return "CONTINUE";
            } else if (mtopResponse.isMtopSdkError()) {
                String retCode = mtopResponse.getRetCode();
                String mappingCodeByErrorCode3 = ErrorConstant.getMappingCodeByErrorCode(retCode);
                if (retCode != null && retCode.startsWith(ErrorConstant.ERRCODE_GENERATE_MTOP_SIGN_ERROR)) {
                    mappingCodeByErrorCode3 = ErrorConstant.MAPPING_CODE_GENERATE_MTOP_SIGN_ERROR;
                }
                if (!StringUtils.isNotBlank(mappingCodeByErrorCode3)) {
                    mappingCodeByErrorCode3 = ErrorConstant.UNKNOWN_CLIENT_MAPPING_CODE_SUFFIX;
                }
                mtopResponse.mappingCodeSuffix = mappingCodeByErrorCode3;
                mtopResponse.mappingCode = ErrorConstant.appendMappingCode(mtopResponse.getResponseCode(), mtopResponse.mappingCodeSuffix);
                String str10 = SwitchConfig.errorMappingMsgMap.get(ErrorConstant.ErrorMappingType.SERVICE_ERROR_MAPPING);
                if (str10 != null) {
                    str8 = str10;
                }
                mtopResponse.setRetMsg(str8);
                TBSdkLog.e(TAG, str4, mtopResponse.getResponseLog());
                TBSdkLog.e(TAG, str4, mtopContext.mtopRequest.getRequestLog());
                if (MtopMonitor.getInstance() != null) {
                    HashMap<String, String> hashMap4 = new HashMap<>();
                    hashMap4.put(IMtopMonitor.DATA_REQUEST, mtopContext.mtopRequest.getRequestLog());
                    hashMap4.put(IMtopMonitor.DATA_RESPONSE, mtopResponse.getResponseLog());
                    hashMap4.put(IMtopMonitor.DATA_SEQ, mtopContext.seqNo);
                    IMtopMonitor instance3 = MtopMonitor.getInstance();
                    if (mtopResponse.getHeaderFields() == null) {
                        str3 = IMtopMonitor.MtopMonitorType.TYPE_ERROR_REQUEST;
                    }
                    instance3.onCommit(str3, hashMap4);
                }
                return "CONTINUE";
            } else {
                mtopContext.stats.retType = 3;
                if (StringUtils.isNotBlank(mtopResponse.mappingCodeSuffix)) {
                    mtopResponse.mappingCode = mtopResponse.mappingCodeSuffix;
                    TBSdkLog.e(TAG, str4, mtopResponse.getResponseLog());
                    TBSdkLog.e(TAG, str4, mtopContext.mtopRequest.getRequestLog());
                    if (MtopMonitor.getInstance() != null) {
                        HashMap<String, String> hashMap5 = new HashMap<>();
                        hashMap5.put(IMtopMonitor.DATA_REQUEST, mtopContext.mtopRequest.getRequestLog());
                        hashMap5.put(IMtopMonitor.DATA_RESPONSE, mtopResponse.getResponseLog());
                        hashMap5.put(IMtopMonitor.DATA_SEQ, mtopContext.seqNo);
                        IMtopMonitor instance4 = MtopMonitor.getInstance();
                        if (mtopResponse.getHeaderFields() == null) {
                            str3 = IMtopMonitor.MtopMonitorType.TYPE_ERROR_REQUEST;
                        }
                        instance4.onCommit(str3, hashMap5);
                    }
                    return "CONTINUE";
                }
                String retCode2 = mtopResponse.getRetCode();
                mtopResponse.mappingCode = retCode2;
                if (StringUtils.isBlank(retCode2)) {
                    TBSdkLog.e(TAG, str4, mtopResponse.getResponseLog());
                    TBSdkLog.e(TAG, str4, mtopContext.mtopRequest.getRequestLog());
                    if (MtopMonitor.getInstance() != null) {
                        HashMap<String, String> hashMap6 = new HashMap<>();
                        hashMap6.put(IMtopMonitor.DATA_REQUEST, mtopContext.mtopRequest.getRequestLog());
                        hashMap6.put(IMtopMonitor.DATA_RESPONSE, mtopResponse.getResponseLog());
                        hashMap6.put(IMtopMonitor.DATA_SEQ, mtopContext.seqNo);
                        IMtopMonitor instance5 = MtopMonitor.getInstance();
                        if (mtopResponse.getHeaderFields() == null) {
                            str3 = IMtopMonitor.MtopMonitorType.TYPE_ERROR_REQUEST;
                        }
                        instance5.onCommit(str3, hashMap6);
                    }
                    return "CONTINUE";
                } else if (!SwitchConfig.getInstance().isBizErrorCodeMappingOpen()) {
                    TBSdkLog.i(TAG, str4, "BizErrorCodeMappingOpen=false,Don't do BizErrorCode Mapping.");
                    TBSdkLog.e(TAG, str4, mtopResponse.getResponseLog());
                    TBSdkLog.e(TAG, str4, mtopContext.mtopRequest.getRequestLog());
                    if (MtopMonitor.getInstance() != null) {
                        HashMap<String, String> hashMap7 = new HashMap<>();
                        hashMap7.put(IMtopMonitor.DATA_REQUEST, mtopContext.mtopRequest.getRequestLog());
                        hashMap7.put(IMtopMonitor.DATA_RESPONSE, mtopResponse.getResponseLog());
                        hashMap7.put(IMtopMonitor.DATA_SEQ, mtopContext.seqNo);
                        IMtopMonitor instance6 = MtopMonitor.getInstance();
                        if (mtopResponse.getHeaderFields() == null) {
                            str3 = IMtopMonitor.MtopMonitorType.TYPE_ERROR_REQUEST;
                        }
                        instance6.onCommit(str3, hashMap7);
                    }
                    return "CONTINUE";
                } else if (retCode2.length() == 17 && retCode2.charAt(1) == '-') {
                    TBSdkLog.e(TAG, str4, mtopResponse.getResponseLog());
                    TBSdkLog.e(TAG, str4, mtopContext.mtopRequest.getRequestLog());
                    if (MtopMonitor.getInstance() != null) {
                        HashMap<String, String> hashMap8 = new HashMap<>();
                        hashMap8.put(IMtopMonitor.DATA_REQUEST, mtopContext.mtopRequest.getRequestLog());
                        hashMap8.put(IMtopMonitor.DATA_RESPONSE, mtopResponse.getResponseLog());
                        hashMap8.put(IMtopMonitor.DATA_SEQ, mtopContext.seqNo);
                        IMtopMonitor instance7 = MtopMonitor.getInstance();
                        if (mtopResponse.getHeaderFields() == null) {
                            str3 = IMtopMonitor.MtopMonitorType.TYPE_ERROR_REQUEST;
                        }
                        instance7.onCommit(str3, hashMap8);
                    }
                    return "CONTINUE";
                } else {
                    if (SwitchConfig.getInstance().degradeBizErrorMappingApiSet != null) {
                        String key = mtopContext.mtopRequest.getKey();
                        if (SwitchConfig.getInstance().degradeBizErrorMappingApiSet.contains(key)) {
                            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                                TBSdkLog.i(TAG, str4, "apiKey in degradeBizErrorMappingApiSet,apiKey=" + key);
                            }
                            TBSdkLog.e(TAG, str4, mtopResponse.getResponseLog());
                            TBSdkLog.e(TAG, str4, mtopContext.mtopRequest.getRequestLog());
                            if (MtopMonitor.getInstance() != null) {
                                HashMap<String, String> hashMap9 = new HashMap<>();
                                hashMap9.put(IMtopMonitor.DATA_REQUEST, mtopContext.mtopRequest.getRequestLog());
                                hashMap9.put(IMtopMonitor.DATA_RESPONSE, mtopResponse.getResponseLog());
                                hashMap9.put(IMtopMonitor.DATA_SEQ, mtopContext.seqNo);
                                IMtopMonitor instance8 = MtopMonitor.getInstance();
                                if (mtopResponse.getHeaderFields() == null) {
                                    str3 = IMtopMonitor.MtopMonitorType.TYPE_ERROR_REQUEST;
                                }
                                instance8.onCommit(str3, hashMap9);
                            }
                            return "CONTINUE";
                        }
                    }
                    try {
                        if (MtopUtils.isContainChineseCharacter(retCode2)) {
                            mtopResponse.mappingCode = ErrorConstant.UNKNOWN_SERVICE_PROVIDER_MAPPING_CODE_SUFFIX;
                            TBSdkLog.e(TAG, str4, "retCode contain chinese character,retCode=" + retCode2);
                            TBSdkLog.e(TAG, str4, mtopResponse.getResponseLog());
                            TBSdkLog.e(TAG, str4, mtopContext.mtopRequest.getRequestLog());
                            if (MtopMonitor.getInstance() != null) {
                                HashMap<String, String> hashMap10 = new HashMap<>();
                                hashMap10.put(IMtopMonitor.DATA_REQUEST, mtopContext.mtopRequest.getRequestLog());
                                hashMap10.put(IMtopMonitor.DATA_RESPONSE, mtopResponse.getResponseLog());
                                hashMap10.put(IMtopMonitor.DATA_SEQ, mtopContext.seqNo);
                                IMtopMonitor instance9 = MtopMonitor.getInstance();
                                if (mtopResponse.getHeaderFields() == null) {
                                    str3 = IMtopMonitor.MtopMonitorType.TYPE_ERROR_REQUEST;
                                }
                                instance9.onCommit(str3, hashMap10);
                            }
                            return "CONTINUE";
                        }
                        String caesarEncrypt = MtopUtils.caesarEncrypt(retCode2);
                        if (StringUtils.isNotBlank(caesarEncrypt)) {
                            long globalBizErrorMappingCodeLength = SwitchConfig.getInstance().getGlobalBizErrorMappingCodeLength();
                            int length = caesarEncrypt.length();
                            str2 = str3;
                            str = IMtopMonitor.MtopMonitorType.TYPE_ERROR_REQUEST;
                            if (((long) length) <= globalBizErrorMappingCodeLength || globalBizErrorMappingCodeLength <= 0) {
                                mtopResponse.mappingCode = caesarEncrypt;
                            } else {
                                try {
                                    mtopResponse.mappingCode = caesarEncrypt.substring(0, (int) globalBizErrorMappingCodeLength);
                                } catch (Exception e2) {
                                    e = e2;
                                    try {
                                        TBSdkLog.e(TAG, str4, "Mapping biz retCode to mappingCode error.retCode=" + retCode2, e);
                                        TBSdkLog.e(TAG, str4, mtopResponse.getResponseLog());
                                        TBSdkLog.e(TAG, str4, mtopContext.mtopRequest.getRequestLog());
                                        if (MtopMonitor.getInstance() != null) {
                                        }
                                        return "CONTINUE";
                                    } catch (Throwable th2) {
                                        th = th2;
                                        TBSdkLog.e(TAG, str4, mtopResponse.getResponseLog());
                                        TBSdkLog.e(TAG, str4, mtopContext.mtopRequest.getRequestLog());
                                        if (MtopMonitor.getInstance() != null) {
                                            HashMap<String, String> hashMap11 = new HashMap<>();
                                            hashMap11.put(IMtopMonitor.DATA_REQUEST, mtopContext.mtopRequest.getRequestLog());
                                            hashMap11.put(IMtopMonitor.DATA_RESPONSE, mtopResponse.getResponseLog());
                                            hashMap11.put(IMtopMonitor.DATA_SEQ, mtopContext.seqNo);
                                            IMtopMonitor instance10 = MtopMonitor.getInstance();
                                            if (mtopResponse.getHeaderFields() == null) {
                                                str2 = str;
                                            }
                                            instance10.onCommit(str2, hashMap11);
                                        }
                                        throw th;
                                    }
                                }
                            }
                        } else {
                            str2 = str3;
                            str = IMtopMonitor.MtopMonitorType.TYPE_ERROR_REQUEST;
                        }
                        TBSdkLog.e(TAG, str4, mtopResponse.getResponseLog());
                        TBSdkLog.e(TAG, str4, mtopContext.mtopRequest.getRequestLog());
                        if (MtopMonitor.getInstance() != null) {
                            HashMap<String, String> hashMap12 = new HashMap<>();
                            hashMap12.put(IMtopMonitor.DATA_REQUEST, mtopContext.mtopRequest.getRequestLog());
                            hashMap12.put(IMtopMonitor.DATA_RESPONSE, mtopResponse.getResponseLog());
                            hashMap12.put(IMtopMonitor.DATA_SEQ, mtopContext.seqNo);
                            MtopMonitor.getInstance().onCommit(mtopResponse.getHeaderFields() != null ? str2 : str, hashMap12);
                        }
                        return "CONTINUE";
                    } catch (Exception e3) {
                        e = e3;
                        str2 = str3;
                        str = IMtopMonitor.MtopMonitorType.TYPE_ERROR_REQUEST;
                        TBSdkLog.e(TAG, str4, "Mapping biz retCode to mappingCode error.retCode=" + retCode2, e);
                        TBSdkLog.e(TAG, str4, mtopResponse.getResponseLog());
                        TBSdkLog.e(TAG, str4, mtopContext.mtopRequest.getRequestLog());
                        if (MtopMonitor.getInstance() != null) {
                        }
                        return "CONTINUE";
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            str2 = str3;
            str = IMtopMonitor.MtopMonitorType.TYPE_ERROR_REQUEST;
            TBSdkLog.e(TAG, str4, mtopResponse.getResponseLog());
            TBSdkLog.e(TAG, str4, mtopContext.mtopRequest.getRequestLog());
            if (MtopMonitor.getInstance() != null) {
            }
            throw th;
        }
    }

    @Override // mtopsdk.framework.filter.IMtopFilter
    @NonNull
    public String getName() {
        return TAG;
    }
}
