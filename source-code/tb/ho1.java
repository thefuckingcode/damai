package tb;

import android.net.Uri;
import com.taobao.alivfssdk.fresco.cache.common.CacheKey;

/* compiled from: Taobao */
public class ho1 implements CacheKey {
    final String a;
    public final String b;

    public ho1(String str, String str2) {
        this.a = (String) bs1.a(str);
        this.b = str2;
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheKey
    public boolean containsUri(Uri uri) {
        return this.a.contains(uri.toString());
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheKey
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ho1 ho1 = (ho1) obj;
        String str = this.a;
        if (str == null ? ho1.a != null : !str.equals(ho1.a)) {
            return false;
        }
        String str2 = this.b;
        String str3 = ho1.b;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheKey
    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheKey
    public String toString() {
        return this.a;
    }
}
