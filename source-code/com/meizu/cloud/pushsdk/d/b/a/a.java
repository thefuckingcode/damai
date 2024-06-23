package com.meizu.cloud.pushsdk.d.b.a;

import com.meizu.cloud.pushsdk.c.c.i;
import com.meizu.cloud.pushsdk.d.b.a;
import com.meizu.cloud.pushsdk.d.b.e;
import com.meizu.cloud.pushsdk.d.b.f;
import com.meizu.cloud.pushsdk.d.b.g;
import com.meizu.cloud.pushsdk.d.d.c;
import com.meizu.cloud.pushsdk.d.d.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: Taobao */
public class a extends com.meizu.cloud.pushsdk.d.b.a {
    private final String h;
    private d i;
    private int j;

    public a(a.C0187a aVar) {
        super(aVar);
        String simpleName = a.class.getSimpleName();
        this.h = simpleName;
        com.meizu.cloud.pushsdk.d.d.a aVar2 = new com.meizu.cloud.pushsdk.d.d.a(this.a, this.e);
        this.i = aVar2;
        if (!aVar2.a()) {
            this.i = new c(this.e);
            com.meizu.cloud.pushsdk.d.f.c.a(simpleName, "init memory store", new Object[0]);
        }
    }

    private LinkedList<g> a(LinkedList<e> linkedList) {
        LinkedList<g> linkedList2 = new LinkedList<>();
        LinkedList linkedList3 = new LinkedList();
        Iterator<e> it = linkedList.iterator();
        while (it.hasNext()) {
            linkedList3.add(b.a(b(it.next().a())));
        }
        com.meizu.cloud.pushsdk.d.f.c.b(this.h, "Request Futures: %s", Integer.valueOf(linkedList3.size()));
        for (int i2 = 0; i2 < linkedList3.size(); i2++) {
            int i3 = -1;
            try {
                i3 = ((Integer) ((Future) linkedList3.get(i2)).get(5, TimeUnit.SECONDS)).intValue();
            } catch (InterruptedException e) {
                com.meizu.cloud.pushsdk.d.f.c.a(this.h, "Request Future was interrupted: %s", e.getMessage());
            } catch (ExecutionException e2) {
                com.meizu.cloud.pushsdk.d.f.c.a(this.h, "Request Future failed: %s", e2.getMessage());
            } catch (TimeoutException e3) {
                com.meizu.cloud.pushsdk.d.f.c.a(this.h, "Request Future had a timeout: %s", e3.getMessage());
            }
            if (linkedList.get(i2).c()) {
                linkedList2.add(new g(true, linkedList.get(i2).b()));
            } else {
                linkedList2.add(new g(a(i3), linkedList.get(i2).b()));
            }
        }
        return linkedList2;
    }

    private Callable<Boolean> a(final Long l) {
        return new Callable<Boolean>() {
            /* class com.meizu.cloud.pushsdk.d.b.a.a.AnonymousClass3 */

            /* renamed from: a */
            public Boolean call() {
                return Boolean.valueOf(a.this.i.a(l.longValue()));
            }
        };
    }

    private LinkedList<Boolean> b(LinkedList<Long> linkedList) {
        boolean z;
        LinkedList<Boolean> linkedList2 = new LinkedList<>();
        LinkedList linkedList3 = new LinkedList();
        Iterator<Long> it = linkedList.iterator();
        while (it.hasNext()) {
            linkedList3.add(b.a(a(it.next())));
        }
        com.meizu.cloud.pushsdk.d.f.c.b(this.h, "Removal Futures: %s", Integer.valueOf(linkedList3.size()));
        for (int i2 = 0; i2 < linkedList3.size(); i2++) {
            try {
                z = ((Boolean) ((Future) linkedList3.get(i2)).get(5, TimeUnit.SECONDS)).booleanValue();
            } catch (InterruptedException e) {
                com.meizu.cloud.pushsdk.d.f.c.a(this.h, "Removal Future was interrupted: %s", e.getMessage());
            } catch (ExecutionException e2) {
                com.meizu.cloud.pushsdk.d.f.c.a(this.h, "Removal Future failed: %s", e2.getMessage());
            } catch (TimeoutException e3) {
                com.meizu.cloud.pushsdk.d.f.c.a(this.h, "Removal Future had a timeout: %s", e3.getMessage());
            }
            linkedList2.add(Boolean.valueOf(z));
        }
        return linkedList2;
        z = false;
        linkedList2.add(Boolean.valueOf(z));
    }

    private Callable<Integer> b(final i iVar) {
        return new Callable<Integer>() {
            /* class com.meizu.cloud.pushsdk.d.b.a.a.AnonymousClass2 */

            /* renamed from: a */
            public Integer call() {
                return Integer.valueOf(a.this.a((a) iVar));
            }
        };
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c() {
        if (com.meizu.cloud.pushsdk.d.f.e.a(this.a)) {
            if (this.i.c() > 0) {
                this.j = 0;
                LinkedList<g> a = a(a(this.i.d()));
                com.meizu.cloud.pushsdk.d.f.c.c(this.h, "Processing emitter results.", new Object[0]);
                LinkedList<Long> linkedList = new LinkedList<>();
                Iterator<g> it = a.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    g next = it.next();
                    if (next.a()) {
                        linkedList.addAll(next.b());
                        i2 += next.b().size();
                    } else {
                        i3 += next.b().size();
                        com.meizu.cloud.pushsdk.d.f.c.a(this.h, "Request sending failed but we will retry later.", new Object[0]);
                    }
                }
                b(linkedList);
                com.meizu.cloud.pushsdk.d.f.c.b(this.h, "Success Count: %s", Integer.valueOf(i2));
                com.meizu.cloud.pushsdk.d.f.c.b(this.h, "Failure Count: %s", Integer.valueOf(i3));
                f fVar = this.b;
                if (fVar != null) {
                    if (i3 != 0) {
                        fVar.a(i2, i3);
                    } else {
                        fVar.a(i2);
                    }
                }
                if (i3 > 0 && i2 == 0) {
                    if (com.meizu.cloud.pushsdk.d.f.e.a(this.a)) {
                        com.meizu.cloud.pushsdk.d.f.c.a(this.h, "Ensure collector path is valid: %s", b());
                    }
                    com.meizu.cloud.pushsdk.d.f.c.a(this.h, "Emitter loop stopping: failures.", new Object[0]);
                }
            } else {
                int i4 = this.j;
                if (i4 >= this.d) {
                    com.meizu.cloud.pushsdk.d.f.c.a(this.h, "Emitter loop stopping: empty limit reached.", new Object[0]);
                    this.g.compareAndSet(true, false);
                    f fVar2 = this.b;
                    if (fVar2 != null) {
                        fVar2.a(true);
                        return;
                    }
                    return;
                }
                this.j = i4 + 1;
                String str = this.h;
                com.meizu.cloud.pushsdk.d.f.c.a(str, "Emitter database empty: " + this.j, new Object[0]);
                try {
                    this.f.sleep((long) this.c);
                } catch (InterruptedException e) {
                    String str2 = this.h;
                    com.meizu.cloud.pushsdk.d.f.c.a(str2, "Emitter thread sleep interrupted: " + e.toString(), new Object[0]);
                }
            }
            c();
            return;
        }
        com.meizu.cloud.pushsdk.d.f.c.a(this.h, "Emitter loop stopping: emitter offline.", new Object[0]);
        this.g.compareAndSet(true, false);
    }

    @Override // com.meizu.cloud.pushsdk.d.b.a
    public void a() {
        b.a(new Runnable() {
            /* class com.meizu.cloud.pushsdk.d.b.a.a.AnonymousClass1 */

            public void run() {
                if (((com.meizu.cloud.pushsdk.d.b.a) a.this).g.compareAndSet(false, true)) {
                    a.this.c();
                }
            }
        });
    }

    @Override // com.meizu.cloud.pushsdk.d.b.a
    public void a(com.meizu.cloud.pushsdk.d.a.a aVar, boolean z) {
        this.i.a(aVar);
        String str = this.h;
        com.meizu.cloud.pushsdk.d.f.c.a(str, "isRunning " + this.g + " attemptEmit " + z, new Object[0]);
        if (!z) {
            try {
                this.f.sleep(1);
            } catch (InterruptedException e) {
                String str2 = this.h;
                com.meizu.cloud.pushsdk.d.f.c.a(str2, "Emitter add thread sleep interrupted: " + e.toString(), new Object[0]);
            }
        }
        if (this.g.compareAndSet(false, true)) {
            c();
        }
    }
}
