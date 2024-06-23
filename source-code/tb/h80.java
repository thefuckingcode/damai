package tb;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.taobao.android.dinamic.b;
import com.taobao.android.dinamic.log.DinamicLog;

/* compiled from: Taobao */
public class h80 {
    public static void a(View view, Canvas canvas) {
        int i;
        float[] fArr;
        if (canvas != null && canvas.getWidth() > 0 && (i = Build.VERSION.SDK_INT) >= 16 && (fArr = (float[]) view.getTag(c80.LAYOUT_RADII)) != null) {
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            if (i >= 11 && canvas.isHardwareAccelerated() && i < 18) {
                view.setLayerType(1, null);
            }
            Path path = new Path();
            path.addRoundRect(new RectF(0.0f, 0.0f, (float) width, (float) height), fArr, Path.Direction.CW);
            canvas.clipPath(path);
        }
    }

    public static Pair<String, String> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf(jl1.BRACKET_START_STR);
        int indexOf2 = str.indexOf(jl1.BRACKET_END_STR);
        if (indexOf < 0 || indexOf2 < 0) {
            if (b.e()) {
                DinamicLog.e(b.TAG, String.format("事件属性:%s语法出错,没有包含\"（）\"", str));
            }
            return null;
        }
        String trim = str.trim();
        String substring = trim.substring(0, indexOf);
        String substring2 = trim.substring(indexOf + 1, indexOf2);
        if (!TextUtils.isEmpty(substring)) {
            return new Pair<>(substring, substring2);
        }
        return null;
    }

    public static z70 c(View view) {
        if (view == null) {
            return new z70();
        }
        Object tag = view.getTag(c80.PROPERTY_KEY);
        return tag == null ? new z70() : (z70) tag;
    }
}
