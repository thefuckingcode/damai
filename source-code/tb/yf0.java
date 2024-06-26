package tb;

import android.graphics.Rect;
import android.view.View;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;

/* compiled from: Taobao */
public class yf0 {
    public static boolean a(View view, float f) {
        if (view == null || !view.isShown()) {
            return false;
        }
        Rect rect = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
        int height = globalVisibleRect ? com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect) : 0;
        int width = globalVisibleRect ? com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect) : 0;
        int measuredHeight = view.getMeasuredHeight();
        int measuredWidth = view.getMeasuredWidth();
        if ((measuredHeight == 0 ? (float) measuredHeight : ((float) height) / ((float) measuredHeight)) > f) {
            return false;
        }
        if ((measuredWidth == 0 ? (float) measuredWidth : ((float) width) / ((float) measuredWidth)) <= f) {
            return true;
        }
        return false;
    }

    public static boolean b(View view, float f) {
        if (view == null || !view.isShown()) {
            return false;
        }
        Rect rect = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
        int height = globalVisibleRect ? com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect) : 0;
        int width = globalVisibleRect ? com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect) : 0;
        int measuredHeight = view.getMeasuredHeight();
        int measuredWidth = view.getMeasuredWidth();
        if ((measuredHeight == 0 ? (float) measuredHeight : ((float) height) / ((float) measuredHeight)) < f) {
            return false;
        }
        if ((measuredWidth == 0 ? (float) measuredWidth : ((float) width) / ((float) measuredWidth)) >= f) {
            return true;
        }
        return false;
    }

    public static void c(String str) {
        DXAppMonitor.q(ry.TAG, null, "native", "native_crash", e.DX_NATIVE_CRASH_6, str);
    }
}
