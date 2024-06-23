package cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: Taobao */
public class e {
    private static transient /* synthetic */ IpChange $ipChange;
    private static LruCache<String, Bitmap> a = new a(((int) Runtime.getRuntime().maxMemory()) / 6);

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
            if (!AndroidInstantRuntime.support(ipChange, "1028607314")) {
                return bitmap.getByteCount();
            }
            return ((Integer) ipChange.ipc$dispatch("1028607314", new Object[]{this, str, bitmap})).intValue();
        }
    }

    public OutputStream a(String str) throws IOException {
        throw null;
    }

    public void b(String str, Bitmap bitmap) {
        throw null;
    }
}
