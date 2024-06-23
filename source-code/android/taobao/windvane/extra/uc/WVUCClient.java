package android.taobao.windvane.extra.uc;

import android.net.Uri;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.config.WVCommonConfigData;
import android.taobao.windvane.embed.BaseEmbedView;
import android.taobao.windvane.embed.Empty;
import android.taobao.windvane.embed.WVEVManager;
import android.taobao.windvane.extra.config.WindVaneUrlCacheManager;
import android.taobao.windvane.extra.performance2.UCTracker;
import android.taobao.windvane.extra.performance2.WVWPData;
import android.taobao.windvane.ha.UCHAReporter;
import android.taobao.windvane.monitor.AppMonitorUtil;
import android.taobao.windvane.monitor.WVMonitorService;
import android.taobao.windvane.util.FullTraceUtils;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.utils.TimeUtils;
import android.taobao.windvane.webview.IFullTrace;
import android.taobao.windvane.webview.IWVWebView;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import com.taobao.monitor.procedure.IProcedure;
import com.uc.webview.export.WebView;
import com.uc.webview.export.extension.EmbedViewConfig;
import com.uc.webview.export.extension.IEmbedView;
import com.uc.webview.export.extension.IEmbedViewContainer;
import com.uc.webview.export.extension.UCClient;
import java.util.Map;
import org.json.JSONObject;
import tb.jl1;
import tb.ws1;
import tb.zn1;

/* compiled from: Taobao */
public class WVUCClient extends UCClient {
    private static final String TAG = "WVUCClient";
    String tStart = "0";
    IWVWebView webView = null;

    public WVUCClient() {
    }

    @Override // com.uc.webview.export.extension.UCClient
    public String getCachedFilePath(String str) {
        return WindVaneUrlCacheManager.getCacheFilePath(str);
    }

    @Override // com.uc.webview.export.extension.UCClient
    public IEmbedView getEmbedView(EmbedViewConfig embedViewConfig, IEmbedViewContainer iEmbedViewContainer) {
        String str;
        Map map = embedViewConfig.mObjectParam;
        if (map.containsKey("viewType")) {
            String str2 = (String) map.get("viewType");
            if (map.containsKey("bridgeId")) {
                str = (String) map.get("bridgeId");
            } else {
                str = "";
            }
            BaseEmbedView createEV = WVEVManager.createEV(str, str2, this.webView, embedViewConfig);
            if (createEV == null) {
                TaoLog.e("EmbedView", "failed to create embedView");
            } else {
                iEmbedViewContainer.setOnParamChangedListener(createEV);
                iEmbedViewContainer.setOnStateChangedListener(createEV);
                iEmbedViewContainer.setOnVisibilityChangedListener(createEV);
                return createEV;
            }
        } else {
            TaoLog.e("EmbedView", "viewType should not be lost");
        }
        Empty empty = new Empty();
        empty.init("", DXRecyclerLayout.LOAD_MORE_EMPTY, this.webView, null);
        return empty;
    }

    @Override // com.uc.webview.export.extension.UCClient
    public void onGpuProcessGone(String str) {
        TaoLog.i("sandbox", "onGpuProcessGone");
        if (str.contains("hasWebGl")) {
            Uri parse = Uri.parse(this.webView.getUrl());
            String str2 = parse.getHost() + parse.getPath();
            if (!GlobalConfig.isBackground) {
                TaoLog.e("GPU", "gpu process is killed, url = [" + str2 + "] , upload information!");
                AppMonitorUtil.commitFail(AppMonitorUtil.MONITOR_POINT_GPU_PROCESS_GONE_TYPE, 1, null, str2);
            }
            WVCommonConfigData wVCommonConfigData = WVCommonConfig.commonConfig;
            if (wVCommonConfigData.ucParam.glLostUnreloadList.contains(str2)) {
                TaoLog.e("GPU", "gpu process error, need not reload page, url = [" + str2 + jl1.ARRAY_END_STR);
                return;
            }
            WVCommonConfig.getInstance();
            if (wVCommonConfigData.enableGpuGoneReload) {
                this.webView.refresh();
                TaoLog.e("GPU", "gpu process error, reload page, url = [" + str2 + jl1.ARRAY_END_STR);
            }
        }
    }

    @Override // com.uc.webview.export.extension.UCClient
    public void onWebViewEvent(final WebView webView2, int i, Object obj) {
        String str;
        String str2;
        String str3;
        WVWPData wVWPData;
        Integer num;
        if (i == 9) {
            try {
                if (obj instanceof String) {
                    num = Integer.valueOf((String) obj);
                } else {
                    num = (Integer) obj;
                }
                String url = webView2.getUrl();
                if (!TextUtils.isEmpty(url)) {
                    AppMonitorUtil.commitEmptyPage(url, "TYPEB_" + num.toString());
                } else if (webView2 instanceof WVUCWebView) {
                    String currentUrl = ((WVUCWebView) webView2).getCurrentUrl();
                    if (!TextUtils.isEmpty(currentUrl)) {
                        AppMonitorUtil.commitEmptyPage(currentUrl, "TYPEA_" + num.toString());
                    }
                }
            } catch (Throwable unused) {
            }
        } else if (i == 107) {
            TaoLog.i("sandbox", "onRenderProcessReady");
            if ((webView2 instanceof WVUCWebView) && webView2.getUCExtension() != null) {
                webView2.getUCExtension().getCoreStatus(1, new ValueCallback<Object>() {
                    /* class android.taobao.windvane.extra.uc.WVUCClient.AnonymousClass1 */

                    @Override // android.webkit.ValueCallback
                    public void onReceiveValue(Object obj) {
                        String str;
                        WVUCWebViewClient wVUCWebViewClient = ((WVUCWebView) webView2).webViewClient;
                        if (wVUCWebViewClient == null) {
                            str = "unknow";
                        } else {
                            str = wVUCWebViewClient.crashCount != 0 ? "Recover_Success" : "R_Success";
                        }
                        if (obj instanceof Integer) {
                            int intValue = ((Integer) obj).intValue();
                            if (WVMonitorService.getWvMonitorInterface() != null) {
                                WVMonitorService.getWvMonitorInterface().commitRenderType(webView2.getUrl(), str, intValue);
                            }
                            TaoLog.i("sandbox", "process mode: " + intValue);
                        }
                    }
                });
            }
        } else if (i == 108) {
            TaoLog.i("sandbox", "WEBVIEW_EVENT_TYPE_DESTORY_NON_ISOLATE_STATIC_WEBVIEW");
            if (webView2 instanceof WVUCWebView) {
                WVUCWebView.destroyStaticWebViewIfNeeded();
            }
        } else if (i == 109) {
            TaoLog.i("sandbox", "WEBVIEW_EVENT_TYPE_CREATE_ISOLATE_STATIC_WEBVIEW");
            if ((webView2 instanceof WVUCWebView) && webView2.getContext() != null) {
                WVUCWebView.createStaticWebViewIfNeeded(webView2.getContext());
            }
        } else if (i != 4) {
            String str4 = "0";
            if (i == 6) {
                if (obj instanceof Map) {
                    Map map = (Map) obj;
                    if (map.containsKey("ts")) {
                        str4 = (String) map.get("ts");
                    }
                }
                long parseLong = Long.parseLong(str4);
                try {
                    ((WVUCWebView) webView2).wvh5PPManager.recordUCT1(parseLong);
                    ((WVUCWebView) webView2).pageTracker.onPageReceivedT1(parseLong);
                } catch (Throwable unused2) {
                }
                TaoLog.i("AIT", "UC_T1: " + parseLong);
            } else {
                String str5 = "";
                if (i == 14) {
                    if (obj instanceof Map) {
                        Map map2 = (Map) obj;
                        String str6 = map2.containsKey("ts") ? (String) map2.get("ts") : str4;
                        if (map2.containsKey("time")) {
                            str4 = (String) map2.get("time");
                            if ((webView2 instanceof WVUCWebView) && (wVWPData = ((WVUCWebView) webView2).wpData) != null) {
                                wVWPData.t2 = str4;
                            }
                        }
                        if (map2.containsKey("url")) {
                            str5 = (String) map2.get("url");
                        }
                        str3 = str4;
                        str4 = str6;
                    } else {
                        str3 = str4;
                    }
                    long parseLong2 = Long.parseLong(str4);
                    try {
                        if (webView2 instanceof IFullTrace) {
                            FullTraceUtils.addStage(((IFullTrace) webView2).getSpanWrapper(), "UC_T2");
                            FullTraceUtils.addProperty(((IFullTrace) webView2).getSpanWrapper(), "UC_T2", str3);
                        }
                        ((WVUCWebView) webView2).wvh5PPManager.recordUCT2(parseLong2);
                        if (str3 != null) {
                            UCTracker.commitUCT2(str5, (long) Double.parseDouble(str3));
                        }
                        Long valueOf = Long.valueOf(TimeUtils.generateUptimeFromCurrentTime(parseLong2));
                        IProcedure launcherProcedure = ws1.b.getLauncherProcedure();
                        if (launcherProcedure == null || !launcherProcedure.isAlive()) {
                            TaoLog.v(TAG, "LauncherProcedure is not Alive");
                        } else {
                            launcherProcedure.stage("H5_UC_T2", valueOf.longValue());
                        }
                        IProcedure currentActivityProcedure = ws1.b.getCurrentActivityProcedure();
                        if (currentActivityProcedure == null || !currentActivityProcedure.isAlive()) {
                            TaoLog.v(TAG, "CurrentActivityProcedure is not Alive");
                        } else {
                            currentActivityProcedure.stage("H5_UC_T2", valueOf.longValue());
                        }
                        IProcedure procedure = ws1.b.getProcedure(webView2);
                        if (procedure == null || !procedure.isAlive()) {
                            TaoLog.v(TAG, "LauncherProcedure is not Alive");
                        } else {
                            procedure.stage("H5_UC_T2", valueOf.longValue());
                        }
                        TaoLog.e(TAG, "H5_UC_T2 time:" + valueOf);
                        zn1.a.getPageGroup(webView2).getPageRenderStandard().onPageVisible(TimeUtils.generateUptimeFromCurrentTime(parseLong2));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    TaoLog.i("AIT", "UC_T2: " + str4);
                } else if (i == 20) {
                    if (obj instanceof String) {
                        try {
                            JSONObject jSONObject = new JSONObject(String.valueOf(obj));
                            str2 = jSONObject.optString("url");
                            try {
                                str5 = jSONObject.optString("linkId");
                            } catch (Throwable unused3) {
                            }
                        } catch (Throwable unused4) {
                            str2 = str5;
                        }
                    } else if (obj instanceof Map) {
                        Map map3 = (Map) obj;
                        str2 = map3.containsKey("url") ? (String) map3.get("url") : str5;
                        if (map3.containsKey("linkId")) {
                            str5 = (String) map3.get("linkId");
                        }
                    } else {
                        str = str5;
                        if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str)) {
                            UCHAReporter.getInstance().putLinkIdWithUrl(str, str5);
                        }
                        TaoLog.i("UCHA", "linkId: " + str + ", url: " + str5);
                    }
                    str = str5;
                    str5 = str2;
                    UCHAReporter.getInstance().putLinkIdWithUrl(str, str5);
                    TaoLog.i("UCHA", "linkId: " + str + ", url: " + str5);
                } else if (i == 106) {
                    TaoLog.e("GPU", "page use webgl, url = [" + webView2.getUrl() + jl1.ARRAY_END_STR);
                    if (WVMonitorService.getWvMonitorInterface() != null) {
                        WVMonitorService.getWvMonitorInterface().commitUseWebgl(webView2.getUrl());
                    }
                }
            }
        } else if (obj instanceof Map) {
            Map map4 = (Map) obj;
            if (map4.containsKey("time")) {
                this.tStart = (String) map4.get("time");
            }
        }
        super.onWebViewEvent(webView2, i, obj);
    }

    public WVUCClient(IWVWebView iWVWebView) {
        this.webView = iWVWebView;
    }
}
