package tb;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import com.airbnb.lottie.a;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* compiled from: Taobao */
public class la1 {
    private static final la1 b = new la1();
    private final LruCache<String, a> a = new LruCache<>(20);

    @VisibleForTesting
    la1() {
    }

    public static la1 b() {
        return b;
    }

    @Nullable
    public a a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.a.get(str);
    }

    public void c(@Nullable String str, a aVar) {
        if (str != null) {
            this.a.put(str, aVar);
        }
    }
}
