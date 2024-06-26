package com.taobao.tlog.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.taobao.orange.OrangeConfig;
import com.taobao.orange.OrangeConfigListener;
import com.taobao.tao.log.ITLogController;
import com.taobao.tao.log.TLogConstant;
import com.taobao.tao.log.TLogInitializer;
import com.taobao.tao.log.TLogUtils;
import com.taobao.tao.log.TaskManager;
import java.util.Map;

/* compiled from: Taobao */
public class TLogConfigSwitchReceiver {
    private static final String TAG = "TLogConfigSwitchReceiver";

    public static void init(final Context context) {
        OrangeConfig.getInstance().registerListener(new String[]{"remote_debuger_android"}, new OrangeConfigListener() {
            /* class com.taobao.tlog.adapter.TLogConfigSwitchReceiver.AnonymousClass1 */

            @Override // com.taobao.orange.OrangeConfigListener
            public void onConfigUpdate(String str) {
                long j;
                Map<String, String> configs = OrangeConfig.getInstance().getConfigs(str);
                if (configs != null) {
                    SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
                    String str2 = configs.get(TLogConstant.REMOTE_DEBUGER_LOG_DESTROY);
                    String str3 = configs.get("tlog_switch");
                    String str4 = configs.get(TLogConstant.REMOTE_DEBUGER_LOG_LEVEL);
                    String str5 = configs.get(TLogConstant.REMOTE_DEBUGER_LOG_MODULE);
                    String str6 = configs.get(TLogConstant.REMOTE_DEBUGER_LOG_ENDTIME);
                    String str7 = configs.get("tlog_pull");
                    ITLogController tLogControler = TLogInitializer.getTLogControler();
                    if (tLogControler != null) {
                        Log.i(TLogConfigSwitchReceiver.TAG, "The tlogDestroy is : " + str2 + "  tlogSwitch is : " + str3 + "  tlogLevel is : " + str4 + "  tlogModule is : " + str5);
                        if (TextUtils.isEmpty(str2)) {
                            Log.i(TLogConfigSwitchReceiver.TAG, "The tlogDestroy is null");
                        } else if ("true".equalsIgnoreCase(str2)) {
                            TLogInitializer.delete();
                            tLogControler.openLog(false);
                            tLogControler.destroyLog(true);
                            edit.putBoolean("tlog_switch", false);
                        } else {
                            tLogControler.destroyLog(false);
                            if (!TextUtils.isEmpty(str3)) {
                                if ("true".equalsIgnoreCase(str3)) {
                                    tLogControler.openLog(true);
                                    edit.putBoolean("tlog_switch", true);
                                } else if ("false".equalsIgnoreCase(str3)) {
                                    tLogControler.openLog(false);
                                    edit.putBoolean("tlog_switch", false);
                                }
                                if (!TextUtils.isEmpty(str4)) {
                                    tLogControler.setLogLevel(str4);
                                    edit.putString(TLogConstant.REMOTE_DEBUGER_LOG_LEVEL, str4);
                                    if (!TextUtils.isEmpty(str5)) {
                                        tLogControler.setModuleFilter(TLogUtils.makeModule(str5));
                                        edit.putString(TLogConstant.REMOTE_DEBUGER_LOG_MODULE, str5);
                                        if (!TextUtils.isEmpty(str6)) {
                                            try {
                                                j = System.currentTimeMillis() + ((long) (Integer.parseInt(str6) * 1000));
                                            } catch (NumberFormatException unused) {
                                                j = System.currentTimeMillis();
                                            }
                                            long currentTimeMillis = System.currentTimeMillis() + 86400000;
                                            if (j > System.currentTimeMillis() && j < currentTimeMillis) {
                                                tLogControler.setEndTime(j);
                                                edit.putLong(TLogConstant.REMOTE_DEBUGER_LOG_ENDTIME, j);
                                            } else if (j >= currentTimeMillis) {
                                                tLogControler.setEndTime(currentTimeMillis);
                                                edit.putLong(TLogConstant.REMOTE_DEBUGER_LOG_ENDTIME, currentTimeMillis);
                                            } else {
                                                tLogControler.setEndTime(System.currentTimeMillis());
                                                edit.putLong(TLogConstant.REMOTE_DEBUGER_LOG_ENDTIME, System.currentTimeMillis());
                                            }
                                        } else {
                                            tLogControler.setEndTime(System.currentTimeMillis());
                                            edit.putLong(TLogConstant.REMOTE_DEBUGER_LOG_ENDTIME, System.currentTimeMillis());
                                        }
                                        if (!TextUtils.isEmpty(str7)) {
                                            if (str7.equals("true")) {
                                                TaskManager.getInstance().queryTraceStatus(context);
                                            }
                                            edit.putString("tlog_pull", str7);
                                        }
                                        edit.putString(TLogConstant.REMOTE_DEBUGER_LOG_VERSION, TLogUtils.getAppBuildVersion(context));
                                        edit.apply();
                                        return;
                                    }
                                    Log.i(TLogConfigSwitchReceiver.TAG, "The tlogModule is null");
                                    return;
                                }
                                Log.i(TLogConfigSwitchReceiver.TAG, "The tlogLevel is null");
                                return;
                            }
                            Log.i(TLogConfigSwitchReceiver.TAG, "The tlogSwitch is null");
                        }
                    }
                } else {
                    Log.i(TLogConfigSwitchReceiver.TAG, "TLogConfigSwitchReceiver --> the config is null!");
                }
            }
        });
    }
}
