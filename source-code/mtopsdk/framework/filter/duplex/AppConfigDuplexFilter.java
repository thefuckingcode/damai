package mtopsdk.framework.filter.duplex;

import java.io.File;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import mtopsdk.common.util.HeaderHandlerUtil;
import mtopsdk.common.util.HttpHeaderConstant;
import mtopsdk.common.util.MtopUtils;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.config.AppConfigManager;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.framework.filter.IAfterFilter;
import mtopsdk.framework.filter.IBeforeFilter;
import mtopsdk.mtop.cache.domain.AppConfigDo;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.global.MtopConfig;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopUnitStrategy;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import mtopsdk.mtop.util.MtopStatistics;
import mtopsdk.mtop.xcommand.XcmdEventMgr;
import org.json.JSONObject;

/* compiled from: Taobao */
public class AppConfigDuplexFilter implements IAfterFilter, IBeforeFilter {
    private static final String TAG = "mtopsdk.AppConfigDuplexFilter";

    /* renamed from: mtopsdk.framework.filter.duplex.AppConfigDuplexFilter$2  reason: invalid class name */
    /* compiled from: Taobao */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            int[] iArr = new int[EnvModeEnum.values().length];
            $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum = iArr;
            iArr[EnvModeEnum.ONLINE.ordinal()] = 1;
            $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum[EnvModeEnum.PREPARE.ordinal()] = 2;
            $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum[EnvModeEnum.TEST.ordinal()] = 3;
            try {
                $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum[EnvModeEnum.TEST_SANDBOX.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private void updateAppConf(final long j, final MtopContext mtopContext) {
        final MtopConfig mtopConfig = mtopContext.mtopInstance.getMtopConfig();
        MtopSDKThreadPoolExecutorFactory.submit(new Runnable() {
            /* class mtopsdk.framework.filter.duplex.AppConfigDuplexFilter.AnonymousClass1 */

            /* JADX WARNING: Removed duplicated region for block: B:28:0x008d A[SYNTHETIC, Splitter:B:28:0x008d] */
            /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
            public void run() {
                String str;
                Exception e;
                synchronized (mtopConfig.lock) {
                    if (j > mtopConfig.xAppConfigVersion) {
                        byte[] bytedata = mtopContext.mtopResponse.getBytedata();
                        if (bytedata != null) {
                            boolean z = false;
                            try {
                                str = new JSONObject(new String(bytedata, "utf-8")).optString("appConf");
                                try {
                                    if (StringUtils.isNotBlank(str)) {
                                        z = AppConfigManager.getInstance().parseAppConfig(str, mtopContext.seqNo);
                                    }
                                    if (z) {
                                        mtopConfig.xAppConfigVersion = j;
                                        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                                            StringBuilder sb = new StringBuilder(64);
                                            sb.append("[updateAppConf]update AppConf succeed!appConfVersion=");
                                            sb.append(j);
                                            sb.append(", appConf=");
                                            sb.append(str);
                                            TBSdkLog.i(AppConfigDuplexFilter.TAG, mtopContext.seqNo, sb.toString());
                                        }
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    TBSdkLog.e(AppConfigDuplexFilter.TAG, mtopContext.seqNo, "[updateAppConf]parse and persist AppConf in data error", e);
                                    if (!z) {
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                                str = null;
                                TBSdkLog.e(AppConfigDuplexFilter.TAG, mtopContext.seqNo, "[updateAppConf]parse and persist AppConf in data error", e);
                                if (!z) {
                                    try {
                                        MtopUtils.writeObject(new AppConfigDo(str, j), new File(mtopConfig.context.getExternalFilesDir(null).getAbsoluteFile() + "/mtop"), "appConf");
                                        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                                            TBSdkLog.i(AppConfigDuplexFilter.TAG, mtopContext.seqNo, "[updateAppConf] store appConf succeed. appConfVersion=" + j);
                                        }
                                    } catch (Exception e4) {
                                        TBSdkLog.e(AppConfigDuplexFilter.TAG, mtopContext.seqNo, "[updateAppConf] store appConf error. appConfVersion=" + j, e4);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
    }

    @Override // mtopsdk.framework.filter.IAfterFilter
    public String doAfter(MtopContext mtopContext) {
        Map<String, List<String>> headerFields = mtopContext.mtopResponse.getHeaderFields();
        MtopConfig mtopConfig = mtopContext.mtopInstance.getMtopConfig();
        String singleHeaderFieldByKey = HeaderHandlerUtil.getSingleHeaderFieldByKey(headerFields, HttpHeaderConstant.X_COMMAND_ORANGE);
        if (StringUtils.isNotBlank(singleHeaderFieldByKey) && StringUtils.isNotBlank(singleHeaderFieldByKey)) {
            try {
                XcmdEventMgr.getInstance().onOrangeEvent(URLDecoder.decode(singleHeaderFieldByKey, "utf-8"));
            } catch (Exception e) {
                String str = mtopContext.seqNo;
                TBSdkLog.w(TAG, str, "parse XCommand header field x-orange-p error,xcmdOrange=" + singleHeaderFieldByKey, e);
            }
        }
        String singleHeaderFieldByKey2 = HeaderHandlerUtil.getSingleHeaderFieldByKey(headerFields, HttpHeaderConstant.X_APP_CONF_V);
        if (StringUtils.isBlank(singleHeaderFieldByKey2)) {
            return "CONTINUE";
        }
        long j = 0;
        try {
            j = Long.parseLong(singleHeaderFieldByKey2);
        } catch (NumberFormatException e2) {
            String str2 = mtopContext.seqNo;
            TBSdkLog.e(TAG, str2, "parse remoteAppConfigVersion error.appConfigVersion=" + singleHeaderFieldByKey2, e2);
        }
        if (j > mtopConfig.xAppConfigVersion) {
            updateAppConf(j, mtopContext);
        }
        return "CONTINUE";
    }

    @Override // mtopsdk.framework.filter.IBeforeFilter
    public String doBefore(MtopContext mtopContext) {
        EnvModeEnum envModeEnum;
        Mtop mtop = mtopContext.mtopInstance;
        MtopStatistics mtopStatistics = mtopContext.stats;
        MtopNetworkProp mtopNetworkProp = mtopContext.property;
        try {
            StringBuilder sb = new StringBuilder(64);
            sb.append(mtop.getMtopConfig().utdid);
            sb.append(System.currentTimeMillis());
            sb.append(new DecimalFormat("0000").format((long) (mtopStatistics.intSeqNo % 10000)));
            sb.append("1");
            sb.append(mtop.getMtopConfig().processId);
            String sb2 = sb.toString();
            mtopNetworkProp.clientTraceId = sb2;
            mtopStatistics.clientTraceId = sb2;
        } catch (Exception e) {
            TBSdkLog.e(TAG, mtopContext.seqNo, "generate client-trace-id failed.", e);
        }
        try {
            if (!AppConfigManager.getInstance().isTradeUnitApi(mtopContext.mtopRequest.getKey()) || (envModeEnum = mtop.getMtopConfig().envMode) == null) {
                return "CONTINUE";
            }
            int i = AnonymousClass2.$SwitchMap$mtopsdk$mtop$domain$EnvModeEnum[envModeEnum.ordinal()];
            if (i == 1) {
                mtopNetworkProp.customOnlineDomain = MtopUnitStrategy.TRADE_ONLINE_DOMAIN;
                return "CONTINUE";
            } else if (i == 2) {
                mtopNetworkProp.customPreDomain = MtopUnitStrategy.TRADE_PRE_DOMAIN;
                return "CONTINUE";
            } else if (i != 3 && i != 4) {
                return "CONTINUE";
            } else {
                mtopNetworkProp.customDailyDomain = MtopUnitStrategy.TRADE_DAILY_DOMAIN;
                return "CONTINUE";
            }
        } catch (Exception e2) {
            TBSdkLog.e(TAG, mtopContext.seqNo, "setCustomDomain for trade unit api error", e2);
            return "CONTINUE";
        }
    }

    @Override // mtopsdk.framework.filter.IMtopFilter
    public String getName() {
        return TAG;
    }
}
