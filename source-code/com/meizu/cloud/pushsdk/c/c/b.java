package com.meizu.cloud.pushsdk.c.c;

import com.alimm.xadsdk.request.builder.IRequestConst;
import com.meizu.cloud.pushsdk.c.g.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class b extends j {
    private static final g a = g.a(IRequestConst.CONTENT_TYPE_POST);
    private final List<String> b;
    private final List<String> c;

    /* compiled from: Taobao */
    public static final class a {
        private final List<String> a = new ArrayList();
        private final List<String> b = new ArrayList();

        public a a(String str, String str2) {
            this.a.add(f.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            this.b.add(f.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            return this;
        }

        public b a() {
            return new b(this.a, this.b);
        }

        public a b(String str, String str2) {
            this.a.add(f.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            this.b.add(f.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            return this;
        }
    }

    private b(List<String> list, List<String> list2) {
        this.b = m.a(list);
        this.c = m.a(list2);
    }

    private long a(c cVar, boolean z) {
        com.meizu.cloud.pushsdk.c.g.b bVar = z ? new com.meizu.cloud.pushsdk.c.g.b() : cVar.b();
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                bVar.b(38);
            }
            bVar.b(this.b.get(i));
            bVar.b(61);
            bVar.b(this.c.get(i));
        }
        if (!z) {
            return 0;
        }
        long a2 = bVar.a();
        bVar.j();
        return a2;
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public g a() {
        return a;
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public void a(c cVar) {
        a(cVar, false);
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public long b() {
        return a((c) null, true);
    }
}
