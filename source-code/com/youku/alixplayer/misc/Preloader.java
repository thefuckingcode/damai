package com.youku.alixplayer.misc;

import android.util.Log;
import androidx.annotation.Keep;
import com.youku.alixplayer.model.Playlist;
import com.youku.alixplayer.util.SystemSoLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Keep
/* compiled from: Taobao */
public class Preloader {
    private static Map<String, List<PreloadListener>> sListeners = new HashMap();

    /* compiled from: Taobao */
    public interface PreloadListener {
        void onPreloadStatusUpdated(String str, PreloadStatus preloadStatus);
    }

    /* compiled from: Taobao */
    public enum PreloadStatus {
        IDLE,
        STARTED,
        COMPLETED,
        FAILED
    }

    static {
        SystemSoLoader.load("alixplayer");
    }

    public static native int cancelPreload(String str);

    public static PreloadStatus checkPreloadStatus(String str) {
        return PreloadStatus.values()[checkPreloadStatusNative(str)];
    }

    private static native int checkPreloadStatusNative(String str);

    public static native void preDemux(Playlist playlist, String str);

    private static native void preload(String str, String str2);

    public static void preload(String str, String str2, PreloadListener preloadListener) {
        List<PreloadListener> list;
        if (preloadListener != null) {
            if (sListeners.containsKey(str)) {
                list = sListeners.get(str);
            } else {
                list = new ArrayList<>();
                sListeners.put(str, list);
            }
            list.add(preloadListener);
        }
        preload(str, str2);
    }

    private static void preloadCallback(String str, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("preloadCallback with url:");
        sb.append(str);
        sb.append(", preload status:");
        sb.append(i);
        sb.append(", contains key:");
        sb.append(sListeners.containsKey(str) ? "true" : "false");
        sb.append(", listener size:");
        sb.append(sListeners.get(str) != null ? Integer.valueOf(sListeners.get(str).size()) : "0");
        Log.d("Preloader", sb.toString());
        if (sListeners.containsKey(str) && i < PreloadStatus.values().length) {
            PreloadStatus preloadStatus = PreloadStatus.values()[i];
            for (PreloadListener preloadListener : sListeners.get(str)) {
                preloadListener.onPreloadStatusUpdated(str, preloadStatus);
            }
            if (preloadStatus == PreloadStatus.COMPLETED || preloadStatus == PreloadStatus.FAILED) {
                sListeners.remove(str);
            }
        }
    }
}
