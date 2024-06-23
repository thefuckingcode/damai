package tb;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.alivfssdk.cache.IAVFSCache;
import com.taobao.alivfssdk.cache.a;
import com.taobao.alivfssdk.cache.b;
import com.taobao.phenix.cache.disk.DiskCache;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

/* compiled from: Taobao */
public class v4 implements DiskCache {
    private final int a;
    private final String b;
    private IAVFSCache c;
    private volatile int d;

    public v4(int i, String str) {
        cs1.b(!TextUtils.isEmpty(str), "name cannot be empty when constructing AlivfsDiskCache");
        this.a = i;
        this.b = "phximgs_" + str;
    }

    private synchronized boolean a() {
        a a2;
        if (this.c == null && (a2 = b.d().a(this.b)) != null) {
            g0 g0Var = new g0();
            g0Var.a = Long.valueOf((long) this.d);
            a2.f(g0Var);
            this.c = a2.c();
        }
        return this.c != null;
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public synchronized void clear() {
        b.d().g(this.b);
        vr2.f("DiskCache", "remove alivfs cache module(%s)", this.b);
        this.c = null;
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public boolean close() {
        return false;
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public r02 get(String str, int i) {
        int lengthForKey;
        InputStream inputStreamForKey;
        if (!a() || (lengthForKey = (int) this.c.lengthForKey(str, String.valueOf(i))) <= 0 || (inputStreamForKey = this.c.inputStreamForKey(str, String.valueOf(i))) == null) {
            return null;
        }
        return new r02(inputStreamForKey, lengthForKey);
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public int[] getCatalogs(String str) {
        List<String> extendsKeysForKey;
        if (!a() || (extendsKeysForKey = this.c.extendsKeysForKey(str)) == null || extendsKeysForKey.size() <= 0) {
            return new int[0];
        }
        int[] iArr = new int[extendsKeysForKey.size()];
        for (int i = 0; i < extendsKeysForKey.size(); i++) {
            try {
                iArr[i] = Integer.parseInt(extendsKeysForKey.get(i));
            } catch (NumberFormatException unused) {
            }
        }
        return iArr;
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public long getLength(String str, int i) {
        if (!a()) {
            return -1;
        }
        long lengthForKey = (long) ((int) this.c.lengthForKey(str, String.valueOf(i)));
        if (lengthForKey > 0) {
            return lengthForKey;
        }
        return -1;
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public int getPriority() {
        return this.a;
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public boolean isSupportCatalogs() {
        return true;
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public void maxSize(int i) {
        this.d = i;
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public boolean open(Context context) {
        return a();
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public boolean put(String str, int i, InputStream inputStream) {
        return a() && inputStream != null && this.c.setStreamForKey(str, String.valueOf(i), inputStream);
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public boolean remove(String str, int i) {
        return a() && this.c.removeObjectForKey(str, String.valueOf(i));
    }

    public String toString() {
        return "AlivfsDiskCache(" + Integer.toHexString(hashCode()) + ", name@" + this.b + jl1.BRACKET_END_STR;
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public boolean put(String str, int i, byte[] bArr, int i2, int i3) {
        return put(str, i, (bArr == null || i3 <= 0) ? null : new ByteArrayInputStream(bArr, i2, i3));
    }
}
