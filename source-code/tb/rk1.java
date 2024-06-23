package tb;

import com.google.common.annotations.GwtCompatible;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
/* compiled from: Taobao */
public final class rk1 extends ig0 {
    public static boolean a(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int b(@NullableDecl Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
