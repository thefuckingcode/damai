package tb;

import android.taobao.windvane.cache.WVFileInfoParser;
import com.ali.alihadeviceevaluator.old.CalScore;
import com.ali.alihadeviceevaluator.old.HardWareInfo;
import java.io.File;

/* compiled from: Taobao */
public class ku0 implements CalScore {
    @Override // com.ali.alihadeviceevaluator.old.CalScore
    public int getScore(HardWareInfo hardWareInfo) {
        float f = 5.0f;
        float f2 = 7.0f;
        try {
            File file = new File("/sdcard/Android/");
            if (file.exists()) {
                long abs = Math.abs(System.currentTimeMillis() - file.lastModified()) / WVFileInfoParser.DEFAULT_MAX_AGE;
                f2 = abs > 100 ? 5.0f : abs > 50 ? 0.0f : (float) Math.round(10.0f - (((float) abs) * 0.2f));
            }
        } catch (Throwable unused) {
        }
        if (f2 >= 0.0f) {
            f = f2;
        }
        return (int) f;
    }
}
