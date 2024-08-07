package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Iterator;
import java.util.Map;
import tb.v61;

/* compiled from: Taobao */
public class d extends v61 {
    private final MessageLite e;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class b<K> implements Map.Entry<K, Object> {
        private Map.Entry<K, d> a;

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.a.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            d value = this.a.getValue();
            if (value == null) {
                return null;
            }
            return value.e();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof MessageLite) {
                return this.a.getValue().d((MessageLite) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }

        private b(Map.Entry<K, d> entry) {
            this.a = entry;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class c<K> implements Iterator<Map.Entry<K, Object>> {
        private Iterator<Map.Entry<K, Object>> a;

        public c(Iterator<Map.Entry<K, Object>> it) {
            this.a = it;
        }

        /* renamed from: a */
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.a.next();
            return next.getValue() instanceof d ? new b(next) : next;
        }

        public boolean hasNext() {
            return this.a.hasNext();
        }

        public void remove() {
            this.a.remove();
        }
    }

    public MessageLite e() {
        return c(this.e);
    }

    public boolean equals(Object obj) {
        return e().equals(obj);
    }

    public int hashCode() {
        return e().hashCode();
    }

    public String toString() {
        return e().toString();
    }
}
