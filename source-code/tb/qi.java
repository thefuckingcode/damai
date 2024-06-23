package tb;

import androidx.exifinterface.media.ExifInterface;
import com.ali.user.mobile.app.constant.UTConstant;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.m;
import kotlin.jvm.JvmStatic;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class qi {
    @NotNull
    public static final qi INSTANCE = new qi();
    @NotNull
    private static final String a = CollectionsKt___CollectionsKt.Z(m.j('k', 'o', 't', 'l', 'i', 'n'), "", null, null, 0, null, null, 62, null);
    @NotNull
    private static final Map<String, String> b;

    static {
        int i = 0;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List list = m.j("Boolean", "Z", "Char", "C", "Byte", "B", "Short", ExifInterface.LATITUDE_SOUTH, "Int", "I", "Float", UTConstant.Args.UT_SUCCESS_F, "Long", "J", "Double", "D");
        int c = ht1.c(0, list.size() - 1, 2);
        if (c >= 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 2;
                StringBuilder sb = new StringBuilder();
                String str = a;
                sb.append(str);
                sb.append(v00.DIR);
                sb.append((String) list.get(i2));
                int i4 = i2 + 1;
                linkedHashMap.put(sb.toString(), list.get(i4));
                linkedHashMap.put(str + v00.DIR + ((String) list.get(i2)) + "Array", k21.r(jl1.ARRAY_START_STR, list.get(i4)));
                if (i2 == c) {
                    break;
                }
                i2 = i3;
            }
        }
        linkedHashMap.put(k21.r(a, "/Unit"), "V");
        a(linkedHashMap, "Any", "java/lang/Object");
        a(linkedHashMap, "Nothing", "java/lang/Void");
        a(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        for (String str2 : m.j("String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum")) {
            a(linkedHashMap, str2, k21.r("java/lang/", str2));
        }
        for (String str3 : m.j("Iterator", "Collection", "List", "Set", "Map", "ListIterator")) {
            a(linkedHashMap, k21.r("collections/", str3), k21.r("java/util/", str3));
            a(linkedHashMap, k21.r("collections/Mutable", str3), k21.r("java/util/", str3));
        }
        a(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        a(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        while (true) {
            int i5 = i + 1;
            String r = k21.r("Function", Integer.valueOf(i));
            StringBuilder sb2 = new StringBuilder();
            String str4 = a;
            sb2.append(str4);
            sb2.append("/jvm/functions/Function");
            sb2.append(i);
            a(linkedHashMap, r, sb2.toString());
            a(linkedHashMap, k21.r("reflect/KFunction", Integer.valueOf(i)), k21.r(str4, "/reflect/KFunction"));
            if (i5 > 22) {
                break;
            }
            i = i5;
        }
        for (String str5 : m.j("Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum")) {
            String r2 = k21.r(str5, ".Companion");
            a(linkedHashMap, r2, a + "/jvm/internal/" + str5 + "CompanionObject");
        }
        b = linkedHashMap;
    }

    private qi() {
    }

    private static final void a(Map<String, String> map, String str, String str2) {
        map.put(a + v00.DIR + str, u91.LEVEL_L + str2 + d80.TokenSEM);
    }

    @JvmStatic
    @NotNull
    public static final String b(@NotNull String str) {
        k21.i(str, "classId");
        String str2 = b.get(str);
        if (str2 != null) {
            return str2;
        }
        return u91.LEVEL_L + o.E(str, '.', '$', false, 4, null) + d80.TokenSEM;
    }
}
