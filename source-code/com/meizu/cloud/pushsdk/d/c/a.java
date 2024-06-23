package com.meizu.cloud.pushsdk.d.c;

import com.meizu.cloud.pushsdk.d.a.b;
import com.meizu.cloud.pushsdk.d.a.c;
import com.meizu.cloud.pushsdk.d.f.d;
import com.meizu.cloud.pushsdk.d.f.e;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Taobao */
public class a {
    private final List<b> a;
    private final long b;
    private final String c;

    /* renamed from: com.meizu.cloud.pushsdk.d.c.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static abstract class AbstractC0188a<T extends AbstractC0188a<T>> {
        private List<b> a = new LinkedList();
        private long b = System.currentTimeMillis();
        private String c = e.b();

        /* access modifiers changed from: protected */
        public abstract T a();

        public T a(long j) {
            this.b = j;
            return a();
        }
    }

    protected a(AbstractC0188a<?> aVar) {
        d.a(((AbstractC0188a) aVar).a);
        d.a(((AbstractC0188a) aVar).c);
        d.a(!((AbstractC0188a) aVar).c.isEmpty(), "eventId cannot be empty");
        this.a = ((AbstractC0188a) aVar).a;
        this.b = ((AbstractC0188a) aVar).b;
        this.c = ((AbstractC0188a) aVar).c;
    }

    /* access modifiers changed from: protected */
    public c a(c cVar) {
        cVar.a(NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        cVar.a("ts", Long.toString(b()));
        return cVar;
    }

    public List<b> a() {
        return new ArrayList(this.a);
    }

    public long b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }
}
