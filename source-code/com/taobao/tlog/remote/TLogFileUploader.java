package com.taobao.tlog.remote;

import android.content.Context;
import android.util.Log;
import com.taobao.tao.log.upload.FileUploadListener;
import com.taobao.tao.log.upload.LogFileUploadManager;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class TLogFileUploader {
    private static boolean isValid = true;

    @Deprecated
    public static void uploadLogFile(Context context, String str) {
    }

    public static void uploadLogFile(Context context, String str, String str2, Map<String, String> map) {
        new LogFileUploadManager(context).uploadWithFilePrefix(str, str2, map, new FileUploadListener() {
            /* class com.taobao.tlog.remote.TLogFileUploader.AnonymousClass1 */

            @Override // com.taobao.tao.log.upload.FileUploadListener
            public void onError(String str, String str2, String str3) {
                Log.w("TlogAdapter", "uploadWithFilePrefix failure!" + str2 + " msg:" + str3);
            }

            @Override // com.taobao.tao.log.upload.FileUploadListener
            public void onSucessed(String str, String str2) {
                Log.w("TlogAdapter", "uploadWithFilePrefix success!");
            }
        });
    }

    @Deprecated
    public static void uploadLogFile(Context context, Map<String, Object> map) {
    }

    @Deprecated
    public static void uploadLogFile(Context context, Map<String, Object> map, String str) {
        if (isValid) {
            HashMap hashMap = new HashMap();
            if (map != null) {
                Object obj = map.get("type");
                if (!(obj instanceof String) || !"exception".equalsIgnoreCase((String) obj)) {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        String key = entry.getKey();
                        if (entry.getValue() instanceof String) {
                            hashMap.put(key, (String) entry.getValue());
                        }
                    }
                } else {
                    return;
                }
            }
            new LogFileUploadManager(context).uploadWithFilePrefix("FEEDBACK", "taobao4android_feedback_21646297", hashMap, new FileUploadListener() {
                /* class com.taobao.tlog.remote.TLogFileUploader.AnonymousClass2 */

                @Override // com.taobao.tao.log.upload.FileUploadListener
                public void onError(String str, String str2, String str3) {
                    Log.w("TlogAdapter", "uploadWithFilePrefix failure! " + str2 + " msg:" + str3);
                }

                @Override // com.taobao.tao.log.upload.FileUploadListener
                public void onSucessed(String str, String str2) {
                    Log.w("TlogAdapter", "uploadWithFilePrefix success!");
                }
            });
        }
    }
}
