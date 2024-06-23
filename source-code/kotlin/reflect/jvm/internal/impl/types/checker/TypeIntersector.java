package kotlin.reflect.jvm.internal.impl.types.checker;

import com.alibaba.gaiax.GXTemplateEngine;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.k;
import kotlin.collections.n;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import org.jetbrains.annotations.NotNull;
import tb.ai1;
import tb.ed2;
import tb.es2;
import tb.g61;
import tb.gj0;
import tb.gk1;
import tb.ib2;
import tb.ii1;
import tb.k21;
import tb.m40;

public final class TypeIntersector {
    public static final TypeIntersector INSTANCE = new TypeIntersector();

    public static final class ResultNullability extends Enum<ResultNullability> {
        private static final /* synthetic */ ResultNullability[] $VALUES;
        public static final ResultNullability ACCEPT_NULL;
        public static final ResultNullability NOT_NULL;
        public static final ResultNullability START;
        public static final ResultNullability UNKNOWN;

        static final class ACCEPT_NULL extends ResultNullability {
            ACCEPT_NULL(String str, int i) {
                super(str, i, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public ResultNullability combine(es2 es2) {
                k21.i(es2, "nextType");
                return getResultNullability(es2);
            }
        }

        static final class NOT_NULL extends ResultNullability {
            NOT_NULL(String str, int i) {
                super(str, i, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public NOT_NULL combine(es2 es2) {
                k21.i(es2, "nextType");
                return this;
            }
        }

        static final class START extends ResultNullability {
            START(String str, int i) {
                super(str, i, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public ResultNullability combine(es2 es2) {
                k21.i(es2, "nextType");
                return getResultNullability(es2);
            }
        }

        static final class UNKNOWN extends ResultNullability {
            UNKNOWN(String str, int i) {
                super(str, i, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public ResultNullability combine(es2 es2) {
                k21.i(es2, "nextType");
                ResultNullability resultNullability = getResultNullability(es2);
                return resultNullability == ResultNullability.ACCEPT_NULL ? this : resultNullability;
            }
        }

        static {
            START start = new START(GXTemplateEngine.b.STATE_START, 0);
            START = start;
            ACCEPT_NULL accept_null = new ACCEPT_NULL("ACCEPT_NULL", 1);
            ACCEPT_NULL = accept_null;
            UNKNOWN unknown = new UNKNOWN("UNKNOWN", 2);
            UNKNOWN = unknown;
            NOT_NULL not_null = new NOT_NULL("NOT_NULL", 3);
            NOT_NULL = not_null;
            $VALUES = new ResultNullability[]{start, accept_null, unknown, not_null};
        }

        private ResultNullability(String str, int i) {
            super(str, i);
        }

        public /* synthetic */ ResultNullability(String str, int i, m40 m40) {
            this(str, i);
        }

        public static ResultNullability valueOf(String str) {
            k21.i(str, "value");
            return (ResultNullability) Enum.valueOf(ResultNullability.class, str);
        }

        public static ResultNullability[] values() {
            ResultNullability[] resultNullabilityArr = $VALUES;
            ResultNullability[] resultNullabilityArr2 = new ResultNullability[resultNullabilityArr.length];
            System.arraycopy(resultNullabilityArr, 0, resultNullabilityArr2, 0, resultNullabilityArr.length);
            return resultNullabilityArr2;
        }

        @NotNull
        public abstract ResultNullability combine(@NotNull es2 es2);

        public final ResultNullability getResultNullability(es2 es2) {
            k21.i(es2, "<this>");
            if (es2.d()) {
                return ACCEPT_NULL;
            }
            if (gk1.INSTANCE.a(es2)) {
                return NOT_NULL;
            }
            return UNKNOWN;
        }
    }

    private TypeIntersector() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x000e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0051 A[EDGE_INSN: B:24:0x0051->B:16:0x0051 ?: BREAK  , SYNTHETIC] */
    private final Collection<ib2> b(Collection<? extends ib2> collection, Function2<? super ib2, ? super ib2, Boolean> function2) {
        boolean z;
        ArrayList arrayList = new ArrayList(collection);
        Iterator it = arrayList.iterator();
        k21.h(it, "filteredTypes.iterator()");
        while (it.hasNext()) {
            ib2 ib2 = (ib2) it.next();
            boolean z2 = true;
            if (!arrayList.isEmpty()) {
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    ib2 ib22 = (ib2) it2.next();
                    if (ib22 != ib2) {
                        k21.h(ib22, "lower");
                        k21.h(ib2, "upper");
                        if (function2.invoke(ib22, ib2).booleanValue()) {
                            z = true;
                            continue;
                            if (z) {
                                break;
                            }
                        }
                    }
                    z = false;
                    continue;
                    if (z) {
                    }
                }
                if (!z2) {
                    it.remove();
                }
            }
            z2 = false;
            if (!z2) {
            }
        }
        return arrayList;
    }

    private final ib2 d(Set<? extends ib2> set) {
        if (set.size() == 1) {
            return (ib2) k.n0(set);
        }
        new TypeIntersector$intersectTypesWithoutIntersectionType$errorMessage$1(set);
        Collection<ib2> b = b(set, new TypeIntersector$intersectTypesWithoutIntersectionType$filteredEqualTypes$1(this));
        b.isEmpty();
        ib2 b2 = IntegerLiteralTypeConstructor.Companion.b(b);
        if (b2 != null) {
            return b2;
        }
        Collection<ib2> b3 = b(b, new TypeIntersector$intersectTypesWithoutIntersectionType$filteredSuperAndEqualTypes$1(NewKotlinTypeChecker.Companion.a()));
        b3.isEmpty();
        if (b3.size() < 2) {
            return (ib2) k.n0(b3);
        }
        return new IntersectionTypeConstructor(set).b();
    }

    /* access modifiers changed from: public */
    private final boolean e(g61 g61, g61 g612) {
        ii1 a = NewKotlinTypeChecker.Companion.a();
        return a.isSubtypeOf(g61, g612) && !a.isSubtypeOf(g612, g61);
    }

    public final ib2 c(List<? extends ib2> list) {
        k21.i(list, "types");
        list.size();
        ArrayList<es2> arrayList = new ArrayList();
        for (ib2 ib2 : list) {
            if (ib2.c() instanceof IntersectionTypeConstructor) {
                Collection<g61> supertypes = ib2.c().getSupertypes();
                k21.h(supertypes, "type.constructor.supertypes");
                ArrayList arrayList2 = new ArrayList(n.q(supertypes, 10));
                for (T t : supertypes) {
                    k21.h(t, AdvanceSetting.NETWORK_TYPE);
                    ib2 d = gj0.d(t);
                    if (ib2.d()) {
                        d = d.j(true);
                    }
                    arrayList2.add(d);
                }
                arrayList.addAll(arrayList2);
            } else {
                arrayList.add(ib2);
            }
        }
        ResultNullability resultNullability = ResultNullability.START;
        for (es2 es2 : arrayList) {
            resultNullability = resultNullability.combine(es2);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ib2 ib22 = (ib2) it.next();
            if (resultNullability == ResultNullability.NOT_NULL) {
                if (ib22 instanceof ai1) {
                    ib22 = ed2.k((ai1) ib22);
                }
                ib22 = ed2.i(ib22, false, 1, null);
            }
            linkedHashSet.add(ib22);
        }
        return d(linkedHashSet);
    }
}
