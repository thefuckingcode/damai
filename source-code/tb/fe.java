package tb;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.LruCache;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class fe {
    public static LruCache<String, Bitmap> a = new a(((int) Runtime.getRuntime().maxMemory()) / 6);

    /* compiled from: Taobao */
    public class a extends LruCache<String, Bitmap> {
        private static transient /* synthetic */ IpChange $ipChange;

        a(int i) {
            super(i);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int sizeOf(String str, Bitmap bitmap) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-784553130")) {
                return bitmap.getByteCount();
            }
            return ((Integer) ipChange.ipc$dispatch("-784553130", new Object[]{this, str, bitmap})).intValue();
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 12) {
        }
    }
}
