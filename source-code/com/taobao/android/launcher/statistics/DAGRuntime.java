package com.taobao.android.launcher.statistics;

import android.content.Context;
import anet.channel.request.ByteArrayEntry;
import anetwork.channel.Request;
import anetwork.channel.Response;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.android.job.core.DAGStage;
import com.taobao.android.job.core.base.Log;
import com.taobao.android.job.core.helper.ThreadPoolHelpers;
import com.taobao.android.job.core.task.ExecutionSummary;
import com.taobao.android.launcher.common.Constants;
import com.taobao.android.launcher.common.LauncherParam;
import com.taobao.android.launcher.common.LauncherRuntime;
import com.taobao.android.launcher.statistics.LazyExecutor;
import com.taobao.android.launcher.statistics.TaoTrace;
import com.taobao.application.common.IAppPreferences;
import com.taobao.application.common.b;
import com.taobao.weex.adapter.URIAdapter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import tb.e02;
import tb.m50;

/* compiled from: Taobao */
public class DAGRuntime {
    private static final String CONTENT_TPYE = "application/json";
    private static final String TAG = "DAGRuntime";
    private static final String URL_OFFLINE = "http://tmq-service.taobao.org/task_exec/reportPerformance";

    public static void commitPoints(final Context context) {
        LazyExecutor.Startup.EXECUTOR.submit(new Runnable() {
            /* class com.taobao.android.launcher.statistics.DAGRuntime.AnonymousClass2 */

            /* JADX WARNING: Code restructure failed: missing block: B:13:0x0085, code lost:
                if (r8 == 0) goto L_0x008a;
             */
            public void run() {
                Map<String, Set<TaoTrace.Point>> map = TaoTrace.sCustomPoints;
                if (map != null) {
                    for (String str : map.keySet()) {
                        Set<TaoTrace.Point> set = TaoTrace.sCustomPoints.get(str);
                        StringBuilder sb = new StringBuilder();
                        int size = set.size();
                        long j = 0;
                        long j2 = 0;
                        for (TaoTrace.Point point : set) {
                            if (point.isValid()) {
                                sb.append(String.format(Locale.ENGLISH, "%s#ExecutionSummary{startTime=%d, endTime=%d, duration=%d, total=1, executed=1, isMainThread=0}[]", point.name, Long.valueOf(point.startTime), Long.valueOf(point.endTime), Long.valueOf(point.endTime - point.startTime)));
                                sb.append("|");
                                long j3 = point.startTime;
                                if (j <= j3) {
                                }
                                j = j3;
                                long j4 = point.endTime;
                                if (j2 < j4) {
                                    j2 = j4;
                                }
                            }
                        }
                        DAGRuntime.report(context, str, ExecutionSummary.create(size, size, j, j2), sb.toString());
                    }
                    TaoTrace.sCustomPoints.clear();
                }
            }
        });
    }

    public static boolean isCustomPointEnabled() {
        return TaoTrace.isSwitchOn();
    }

    /* access modifiers changed from: private */
    public static void report(Context context, String str, ExecutionSummary executionSummary, String str2) {
        HashMap hashMap = new HashMap(4);
        HashMap hashMap2 = new HashMap(28);
        m50 m50 = new m50(context);
        Request e02 = new e02(URL_OFFLINE);
        e02.setMethod("POST");
        e02.setCharset("UTF-8");
        e02.setFollowRedirects(true);
        e02.setRetryTime(3);
        e02.addHeader("Content-Type", CONTENT_TPYE);
        hashMap2.put("stage_name", str);
        hashMap2.put("stage_execution_start", Long.valueOf(executionSummary.startTime));
        hashMap2.put("stage_execution_end", Long.valueOf(executionSummary.endTime));
        hashMap2.put("stage_execution_node_count_total", Integer.valueOf(executionSummary.total));
        hashMap2.put("stage_execution_node_count_executed", Integer.valueOf(executionSummary.executed));
        hashMap2.put("scene", TAG);
        hashMap2.put("stage_summary", str2);
        hashMap2.put("app_process", LauncherRuntime.sProcessName);
        hashMap2.put("app_version", LauncherRuntime.sAppVersion);
        hashMap2.put("app_device_model", Build.getMODEL());
        hashMap2.put("app_device_brand", Build.getBRAND());
        hashMap2.put("app_device_core_size", Integer.valueOf(ThreadPoolHelpers.poolSize(0.0d)));
        IAppPreferences d = b.d();
        hashMap2.put("app_device_score", Integer.valueOf(d.getInt("oldDeviceScore", 60)));
        hashMap2.put("app_status_is_full_new_install", Boolean.valueOf(d.getBoolean("isFullNewInstall", false)));
        hashMap2.put("app_status_is_first_launch", Boolean.valueOf(d.getBoolean("isFirstLaunch", false)));
        hashMap2.put("app_device_manufacturer", Build.getMANUFACTURER());
        hashMap2.put("app_device_os", "android");
        hashMap2.put("app_package_debug", Boolean.valueOf(LauncherRuntime.sDebuggable));
        hashMap2.put("app_package_tag", LauncherRuntime.sPackageTag);
        hashMap.put("data_type", "launch_stage_summary");
        hashMap.put(com.alipay.sdk.m.l.b.h, LauncherParam.getParam(Constants.PARAMETER_CONSTANT_APPKEY, ""));
        hashMap.put("data", hashMap2);
        hashMap.put("exec_id", Long.valueOf(LauncherRuntime.sStartTime));
        int i = LauncherRuntime.sLaunchType;
        hashMap.put("launch_type", i == 1 ? URIAdapter.LINK : i == 2 ? "link-h5" : "normal");
        ByteArrayEntry byteArrayEntry = new ByteArrayEntry(JSON.toJSONBytes(hashMap, new SerializerFeature[0]));
        byteArrayEntry.setContentType(CONTENT_TPYE);
        e02.setBodyEntry(byteArrayEntry);
        Log.e(TAG, "[stage:%s][getResponse] exec_id=%d", str, Long.valueOf(LauncherRuntime.sStartTime));
        try {
            Response syncSend = m50.syncSend(e02, null);
            if (syncSend.getStatusCode() == 200) {
                Log.e(TAG, "[stage:%s][getResponse] id=%d", str, Long.valueOf(((JSONObject) JSON.parse(syncSend.getBytedata(), new Feature[0])).getJSONObject("resultData").getLongValue("id")));
            }
        } catch (Throwable th) {
            Log.e(TAG, "[stage:%s][getResponse] failed:", str, th);
        }
    }

    public static void reportDAGStage(final Context context, final DAGStage<String, Void> dAGStage, final ExecutionSummary executionSummary) {
        LazyExecutor.Startup.EXECUTOR.submit(new Runnable() {
            /* class com.taobao.android.launcher.statistics.DAGRuntime.AnonymousClass1 */

            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                DAGRuntime.reportDAGStageInternal(context, dAGStage, executionSummary);
            }
        });
    }

    /* access modifiers changed from: private */
    public static void reportDAGStageInternal(Context context, DAGStage<String, Void> dAGStage, ExecutionSummary executionSummary) {
        StringBuilder sb = new StringBuilder();
        Startups.addStage(dAGStage.getName(), executionSummary, dAGStage.print(sb));
        report(context, dAGStage.getName(), executionSummary, sb.toString());
    }

    public static void reportPoint(String str, String str2, long j, long j2) {
        TaoTrace.duration(str, str2, j, j2);
    }
}
