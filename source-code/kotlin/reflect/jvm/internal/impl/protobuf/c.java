package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;

/* compiled from: Taobao */
public class c {
    private static final c b = new c(true);
    private final Map<a, GeneratedMessageLite.c<?, ?>> a;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class a {
        private final Object a;
        private final int b;

        a(Object obj, int i) {
            this.a = obj;
            this.b = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.a == aVar.a && this.b == aVar.b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (System.identityHashCode(this.a) * 65535) + this.b;
        }
    }

    c() {
        this.a = new HashMap();
    }

    public static c c() {
        return b;
    }

    public static c d() {
        return new c();
    }

    public final void a(GeneratedMessageLite.c<?, ?> cVar) {
        this.a.put(new a(cVar.b(), cVar.d()), cVar);
    }

    public <ContainingType extends MessageLite> GeneratedMessageLite.c<ContainingType, ?> b(ContainingType containingtype, int i) {
        return (GeneratedMessageLite.c<ContainingType, ?>) this.a.get(new a(containingtype, i));
    }

    private c(boolean z) {
        this.a = Collections.emptyMap();
    }
}
