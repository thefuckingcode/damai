package me.ele.altriax.launcher.real.time.data.utils;

import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import java.util.Map;
import tb.td2;
import tb.te0;

/* compiled from: Taobao */
public class Apm {
    private static final String EMPTY_STRING = "";

    public static String processApmEvents(@NonNull Gson gson, @NonNull List<te0> list) {
        try {
            return gson.toJson(list, new TypeToken<List<te0>>() {
                /* class me.ele.altriax.launcher.real.time.data.utils.Apm.AnonymousClass3 */
            }.getType());
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String processApmProperties(@NonNull Gson gson, @NonNull Map<String, Object> map) {
        try {
            return gson.toJson(map, new TypeToken<Map<String, Object>>() {
                /* class me.ele.altriax.launcher.real.time.data.utils.Apm.AnonymousClass1 */
            }.getType());
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String processApmStages(@NonNull Gson gson, @NonNull List<td2> list) {
        try {
            return gson.toJson(list, new TypeToken<List<td2>>() {
                /* class me.ele.altriax.launcher.real.time.data.utils.Apm.AnonymousClass4 */
            }.getType());
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String processApmStats(@NonNull Gson gson, @NonNull Map<String, Object> map) {
        try {
            return gson.toJson(map, new TypeToken<Map<String, Object>>() {
                /* class me.ele.altriax.launcher.real.time.data.utils.Apm.AnonymousClass2 */
            }.getType());
        } catch (Throwable unused) {
            return "";
        }
    }
}
