package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.n;
import kotlin.collections.w;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import tb.a41;
import tb.do2;
import tb.es1;
import tb.k21;
import tb.no2;
import tb.s01;
import tb.ur2;
import tb.ww1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class a {
    @NotNull
    private final Map<String, es1> a = new LinkedHashMap();

    /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public final class C0273a {
        @NotNull
        private final String a;
        final /* synthetic */ a b;

        /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.a$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public final class C0274a {
            @NotNull
            private final String a;
            @NotNull
            private final List<Pair<String, no2>> b = new ArrayList();
            @NotNull
            private Pair<String, no2> c = do2.a("V", null);
            final /* synthetic */ C0273a d;

            public C0274a(@NotNull C0273a aVar, String str) {
                k21.i(aVar, "this$0");
                k21.i(str, "functionName");
                this.d = aVar;
                this.a = str;
            }

            @NotNull
            public final Pair<String, es1> a() {
                SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
                String b2 = this.d.b();
                String b3 = b();
                List<Pair<String, no2>> list = this.b;
                ArrayList arrayList = new ArrayList(n.q(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) it.next().getFirst());
                }
                String k = signatureBuildingComponents.k(b2, signatureBuildingComponents.j(b3, arrayList, this.c.getFirst()));
                no2 second = this.c.getSecond();
                List<Pair<String, no2>> list2 = this.b;
                ArrayList arrayList2 = new ArrayList(n.q(list2, 10));
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((no2) it2.next().getSecond());
                }
                return do2.a(k, new es1(second, arrayList2));
            }

            @NotNull
            public final String b() {
                return this.a;
            }

            public final void c(@NotNull String str, @NotNull a41... a41Arr) {
                no2 no2;
                k21.i(str, "type");
                k21.i(a41Arr, "qualifiers");
                List<Pair<String, no2>> list = this.b;
                if (a41Arr.length == 0) {
                    no2 = null;
                } else {
                    Iterable<s01> iterable = ArraysKt___ArraysKt.k0(a41Arr);
                    LinkedHashMap linkedHashMap = new LinkedHashMap(ww1.a(w.e(n.q(iterable, 10)), 16));
                    for (s01 s01 : iterable) {
                        linkedHashMap.put(Integer.valueOf(s01.c()), (a41) s01.d());
                    }
                    no2 = new no2(linkedHashMap);
                }
                list.add(do2.a(str, no2));
            }

            public final void d(@NotNull String str, @NotNull a41... a41Arr) {
                k21.i(str, "type");
                k21.i(a41Arr, "qualifiers");
                Iterable<s01> iterable = ArraysKt___ArraysKt.k0(a41Arr);
                LinkedHashMap linkedHashMap = new LinkedHashMap(ww1.a(w.e(n.q(iterable, 10)), 16));
                for (s01 s01 : iterable) {
                    linkedHashMap.put(Integer.valueOf(s01.c()), (a41) s01.d());
                }
                this.c = do2.a(str, new no2(linkedHashMap));
            }

            public final void e(@NotNull JvmPrimitiveType jvmPrimitiveType) {
                k21.i(jvmPrimitiveType, "type");
                String desc = jvmPrimitiveType.getDesc();
                k21.h(desc, "type.desc");
                this.c = do2.a(desc, null);
            }
        }

        public C0273a(@NotNull a aVar, String str) {
            k21.i(aVar, "this$0");
            k21.i(str, PushClientConstants.TAG_CLASS_NAME);
            this.b = aVar;
            this.a = str;
        }

        public final void a(@NotNull String str, @NotNull Function1<? super C0274a, ur2> function1) {
            k21.i(str, "name");
            k21.i(function1, "block");
            Map map = this.b.a;
            C0274a aVar = new C0274a(this, str);
            function1.invoke(aVar);
            Pair<String, es1> a2 = aVar.a();
            map.put(a2.getFirst(), a2.getSecond());
        }

        @NotNull
        public final String b() {
            return this.a;
        }
    }

    @NotNull
    public final Map<String, es1> b() {
        return this.a;
    }
}
