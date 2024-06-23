package android.taobao.windvane.util;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.file.FileAccesser;
import android.taobao.windvane.file.FileManager;
import android.text.TextUtils;
import java.io.File;
import java.nio.ByteBuffer;

/* compiled from: Taobao */
public class ConfigStorage {
    public static final long DEFAULT_MAX_AGE = 21600000;
    public static final long DEFAULT_SMALL_MAX_AGE = 1800000;
    public static final String KEY_DATA = "wv-data";
    public static final String KEY_TIME = "wv-time";
    public static final String ROOT_WINDVANE_CONFIG_DIR = "windvane/config";
    private static String TAG = "ConfigStorage";

    /* access modifiers changed from: private */
    public static String getConfigKey(String str, String str2) {
        return "WindVane_" + str + str2;
    }

    /* access modifiers changed from: private */
    public static String getFileAbsolutePath(String str) {
        String str2 = "";
        if (GlobalConfig.context == null) {
            return str2;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append(GlobalConfig.context.getFilesDir().getAbsolutePath());
        String str3 = File.separator;
        sb.append(str3);
        sb.append(ROOT_WINDVANE_CONFIG_DIR);
        if (str != null) {
            str2 = str3 + str;
        }
        sb.append(str2);
        return sb.toString();
    }

    public static long getLongVal(String str, String str2) {
        String configKey = getConfigKey(str, str2);
        try {
            File file = new File(getFileAbsolutePath(configKey));
            if (file.exists()) {
                byte[] read = FileAccesser.read(file);
                ByteBuffer allocate = ByteBuffer.allocate(8);
                allocate.put(read);
                allocate.flip();
                long j = allocate.getLong();
                String str3 = TAG;
                TaoLog.d(str3, "read " + configKey + " by file : " + j);
                return j;
            }
            SharedPreferences sharedPreference = getSharedPreference();
            if (sharedPreference == null) {
                return 0;
            }
            long j2 = sharedPreference.getLong(configKey, 0);
            putLongVal(str, str2, j2);
            SharedPreferences.Editor edit = sharedPreference.edit();
            edit.remove(configKey);
            edit.commit();
            String str4 = TAG;
            TaoLog.i(str4, "read " + configKey + " by sp : " + j2);
            return j2;
        } catch (Exception unused) {
            String str5 = TAG;
            TaoLog.e(str5, "can not read file : " + configKey);
            return 0;
        }
    }

    private static SharedPreferences getSharedPreference() {
        Application application = GlobalConfig.context;
        if (application == null) {
            return null;
        }
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    public static String getStringVal(String str, String str2) {
        String str3 = "";
        String configKey = getConfigKey(str, str2);
        try {
            if (new File(getFileAbsolutePath(configKey)).exists()) {
                String str4 = new String(FileAccesser.read(new File(getFileAbsolutePath(configKey))));
                try {
                    String str5 = TAG;
                    TaoLog.d(str5, "read " + configKey + " by file : " + str4);
                    return str4;
                } catch (Exception unused) {
                    str3 = str4;
                }
            } else {
                SharedPreferences sharedPreference = getSharedPreference();
                if (sharedPreference == null) {
                    return str3;
                }
                str3 = sharedPreference.getString(configKey, str3);
                putStringVal(str, str2, str3);
                SharedPreferences.Editor edit = sharedPreference.edit();
                edit.remove(configKey);
                edit.commit();
                String str6 = TAG;
                TaoLog.i(str6, "read " + configKey + " by sp : " + str3);
                return str3;
            }
        } catch (Exception unused2) {
            String str7 = TAG;
            TaoLog.e(str7, "can not read file : " + configKey);
            return str3;
        }
    }

    public static synchronized boolean initDirs() {
        synchronized (ConfigStorage.class) {
            Application application = GlobalConfig.context;
            if (application == null) {
                return false;
            }
            File createFolder = FileManager.createFolder(application, ROOT_WINDVANE_CONFIG_DIR);
            String str = TAG;
            TaoLog.d(str, "createDir: dir[" + createFolder.getAbsolutePath() + "]:" + createFolder.exists());
            return createFolder.exists();
        }
    }

    @TargetApi(11)
    public static synchronized void putLongVal(final String str, final String str2, final long j) {
        synchronized (ConfigStorage.class) {
            if (str != null && str2 != null) {
                AsyncTask.execute(new Runnable() {
                    /* class android.taobao.windvane.util.ConfigStorage.AnonymousClass2 */

                    public void run() {
                        String configKey = ConfigStorage.getConfigKey(str, str2);
                        String fileAbsolutePath = ConfigStorage.getFileAbsolutePath(configKey);
                        try {
                            ByteBuffer allocate = ByteBuffer.allocate(8);
                            allocate.putLong(j);
                            FileAccesser.write(fileAbsolutePath, allocate);
                        } catch (Exception unused) {
                            String str = ConfigStorage.TAG;
                            TaoLog.e(str, "can not sava file : " + configKey + " value : " + j);
                        }
                    }
                });
            }
        }
    }

    @TargetApi(11)
    public static synchronized void putStringVal(final String str, final String str2, final String str3) {
        synchronized (ConfigStorage.class) {
            if (str != null && str2 != null) {
                AsyncTask.execute(new Runnable() {
                    /* class android.taobao.windvane.util.ConfigStorage.AnonymousClass1 */

                    public void run() {
                        String configKey = ConfigStorage.getConfigKey(str, str2);
                        try {
                            FileAccesser.write(ConfigStorage.getFileAbsolutePath(configKey), ByteBuffer.wrap(str3.getBytes()));
                        } catch (Exception unused) {
                            String str = ConfigStorage.TAG;
                            TaoLog.e(str, "can not sava file : " + configKey + " value : " + str3);
                        }
                    }
                });
            }
        }
    }

    public static String getStringVal(String str, String str2, String str3) {
        try {
            String stringVal = getStringVal(str, str2);
            return TextUtils.isEmpty(stringVal) ? str3 : stringVal;
        } catch (ClassCastException e) {
            e.printStackTrace();
            return str3;
        }
    }

    public static long getLongVal(String str, String str2, long j) {
        try {
            Long valueOf = Long.valueOf(getLongVal(str, str2));
            if (valueOf.longValue() == 0) {
                return j;
            }
            return valueOf.longValue();
        } catch (ClassCastException e) {
            e.printStackTrace();
            return j;
        }
    }
}
