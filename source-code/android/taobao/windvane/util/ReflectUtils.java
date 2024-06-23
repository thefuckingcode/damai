package android.taobao.windvane.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Field;

/* compiled from: Taobao */
public class ReflectUtils {
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:0:0x0000 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.reflect.Field] */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|5) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001b, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0009 */
    @Nullable
    public static Object getField(@NonNull Object obj, @NonNull String str) {
        str = obj.getClass().getDeclaredField(str);
        Field field = str;
        field = obj.getClass().getField(str);
        field.setAccessible(true);
        return field.get(obj);
    }
}
