package tb;

import com.youku.vpm.track.OnePlayTrack;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.e0;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.collections.w;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class f51 implements NameResolver {
    @NotNull
    public static final a Companion;
    @NotNull
    private static final String e;
    @NotNull
    private static final List<String> f;
    @NotNull
    private final JvmProtoBuf.StringTableTypes a;
    @NotNull
    private final String[] b;
    @NotNull
    private final Set<Integer> c;
    @NotNull
    private final List<JvmProtoBuf.StringTableTypes.Record> d;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final List<String> a() {
            return f51.f;
        }
    }

    /* compiled from: Taobao */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JvmProtoBuf.StringTableTypes.Record.Operation.values().length];
            iArr[JvmProtoBuf.StringTableTypes.Record.Operation.NONE.ordinal()] = 1;
            iArr[JvmProtoBuf.StringTableTypes.Record.Operation.INTERNAL_TO_CLASS_ID.ordinal()] = 2;
            iArr[JvmProtoBuf.StringTableTypes.Record.Operation.DESC_TO_CLASS_ID.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        a aVar = new a(null);
        Companion = aVar;
        String str = CollectionsKt___CollectionsKt.Z(m.j('k', 'o', 't', 'l', 'i', 'n'), "", null, null, 0, null, null, 62, null);
        e = str;
        f = m.j(k21.r(str, "/Any"), k21.r(str, "/Nothing"), k21.r(str, "/Unit"), k21.r(str, "/Throwable"), k21.r(str, "/Number"), k21.r(str, "/Byte"), k21.r(str, "/Double"), k21.r(str, "/Float"), k21.r(str, "/Int"), k21.r(str, "/Long"), k21.r(str, "/Short"), k21.r(str, "/Boolean"), k21.r(str, "/Char"), k21.r(str, "/CharSequence"), k21.r(str, "/String"), k21.r(str, "/Comparable"), k21.r(str, "/Enum"), k21.r(str, "/Array"), k21.r(str, "/ByteArray"), k21.r(str, "/DoubleArray"), k21.r(str, "/FloatArray"), k21.r(str, "/IntArray"), k21.r(str, "/LongArray"), k21.r(str, "/ShortArray"), k21.r(str, "/BooleanArray"), k21.r(str, "/CharArray"), k21.r(str, "/Cloneable"), k21.r(str, "/Annotation"), k21.r(str, "/collections/Iterable"), k21.r(str, "/collections/MutableIterable"), k21.r(str, "/collections/Collection"), k21.r(str, "/collections/MutableCollection"), k21.r(str, "/collections/List"), k21.r(str, "/collections/MutableList"), k21.r(str, "/collections/Set"), k21.r(str, "/collections/MutableSet"), k21.r(str, "/collections/Map"), k21.r(str, "/collections/MutableMap"), k21.r(str, "/collections/Map.Entry"), k21.r(str, "/collections/MutableMap.MutableEntry"), k21.r(str, "/collections/Iterator"), k21.r(str, "/collections/MutableIterator"), k21.r(str, "/collections/ListIterator"), k21.r(str, "/collections/MutableListIterator"));
        Iterable<s01> iterable = CollectionsKt___CollectionsKt.E0(aVar.a());
        LinkedHashMap linkedHashMap = new LinkedHashMap(ww1.a(w.e(n.q(iterable, 10)), 16));
        for (s01 s01 : iterable) {
            linkedHashMap.put((String) s01.d(), Integer.valueOf(s01.c()));
        }
    }

    public f51(@NotNull JvmProtoBuf.StringTableTypes stringTableTypes, @NotNull String[] strArr) {
        Set<Integer> set;
        k21.i(stringTableTypes, "types");
        k21.i(strArr, "strings");
        this.a = stringTableTypes;
        this.b = strArr;
        List<Integer> localNameList = stringTableTypes.getLocalNameList();
        if (localNameList.isEmpty()) {
            set = e0.d();
        } else {
            k21.h(localNameList, "");
            set = CollectionsKt___CollectionsKt.C0(localNameList);
        }
        this.c = set;
        ArrayList arrayList = new ArrayList();
        List<JvmProtoBuf.StringTableTypes.Record> recordList = b().getRecordList();
        arrayList.ensureCapacity(recordList.size());
        for (JvmProtoBuf.StringTableTypes.Record record : recordList) {
            int range = record.getRange();
            for (int i = 0; i < range; i++) {
                arrayList.add(record);
            }
        }
        arrayList.trimToSize();
        ur2 ur2 = ur2.INSTANCE;
        this.d = arrayList;
    }

    @NotNull
    public final JvmProtoBuf.StringTableTypes b() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    @NotNull
    public String getQualifiedClassName(int i) {
        return getString(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    @NotNull
    public String getString(int i) {
        String str;
        JvmProtoBuf.StringTableTypes.Record record = this.d.get(i);
        if (record.hasString()) {
            str = record.getString();
        } else {
            if (record.hasPredefinedIndex()) {
                a aVar = Companion;
                int size = aVar.a().size() - 1;
                int predefinedIndex = record.getPredefinedIndex();
                if (predefinedIndex >= 0 && predefinedIndex <= size) {
                    str = aVar.a().get(record.getPredefinedIndex());
                }
            }
            str = this.b[i];
        }
        if (record.getSubstringIndexCount() >= 2) {
            List<Integer> substringIndexList = record.getSubstringIndexList();
            k21.h(substringIndexList, "substringIndexList");
            Integer num = substringIndexList.get(0);
            Integer num2 = substringIndexList.get(1);
            k21.h(num, OnePlayTrack.PlayType.BEGIN);
            if (num.intValue() >= 0) {
                int intValue = num.intValue();
                k21.h(num2, "end");
                if (intValue <= num2.intValue() && num2.intValue() <= str.length()) {
                    k21.h(str, "string");
                    str = str.substring(num.intValue(), num2.intValue());
                    k21.h(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
            }
        }
        String str2 = str;
        if (record.getReplaceCharCount() >= 2) {
            List<Integer> replaceCharList = record.getReplaceCharList();
            k21.h(replaceCharList, "replaceCharList");
            k21.h(str2, "string");
            str2 = o.E(str2, (char) replaceCharList.get(0).intValue(), (char) replaceCharList.get(1).intValue(), false, 4, null);
        }
        String str3 = str2;
        JvmProtoBuf.StringTableTypes.Record.Operation operation = record.getOperation();
        if (operation == null) {
            operation = JvmProtoBuf.StringTableTypes.Record.Operation.NONE;
        }
        int i2 = b.$EnumSwitchMapping$0[operation.ordinal()];
        if (i2 == 2) {
            k21.h(str3, "string");
            str3 = o.E(str3, '$', '.', false, 4, null);
        } else if (i2 == 3) {
            if (str3.length() >= 2) {
                k21.h(str3, "string");
                str3 = str3.substring(1, str3.length() - 1);
                k21.h(str3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            k21.h(str3, "string");
            str3 = o.E(str3, '$', '.', false, 4, null);
        }
        k21.h(str3, "string");
        return str3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public boolean isLocalClassName(int i) {
        return this.c.contains(Integer.valueOf(i));
    }
}
