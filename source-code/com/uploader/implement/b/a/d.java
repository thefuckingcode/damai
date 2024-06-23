package com.uploader.implement.b.a;

import com.uploader.implement.b.a.c;
import com.uploader.implement.b.b;
import com.uploader.implement.c;
import java.lang.ref.WeakReference;
import org.android.agoo.message.MessageService;
import tb.h13;
import tb.m53;

/* compiled from: Taobao */
public class d extends a {
    final c d;

    d(c cVar, f fVar) {
        super(cVar, fVar);
        c cVar2 = new c(cVar, fVar);
        this.d = cVar2;
        cVar2.e(new a(this));
    }

    @Override // com.uploader.implement.b.e
    public void a(m53 m53, int i) {
        byte[] bArr;
        int i2 = m53.d;
        int i3 = m53.c;
        if (i3 != 0) {
            bArr = new byte[i2];
            System.arraycopy(m53.b, i3, bArr, 0, i2);
        } else {
            bArr = m53.b;
        }
        b e = e();
        if (e != null) {
            e.a(this, i);
        }
        this.d.d(i, bArr, i2);
    }

    @Override // com.uploader.implement.b.e
    public boolean b() {
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "LongLivedConnection", this.c + " connectAsync");
        }
        this.d.b();
        return true;
    }

    @Override // com.uploader.implement.b.e
    public boolean c() {
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "LongLivedConnection", this.c + " closeAsync");
        }
        this.d.h();
        return true;
    }

    @Override // com.uploader.implement.b.e
    public boolean d() {
        return this.d.i();
    }

    /* compiled from: Taobao */
    static class a implements c.a {
        private final WeakReference<d> a;

        a(d dVar) {
            this.a = new WeakReference<>(dVar);
        }

        @Override // com.uploader.implement.b.a.c.a
        public void a(int i) {
            b e;
            h13 h13;
            d dVar = this.a.get();
            if (dVar != null && (e = dVar.e()) != null) {
                if (i == -2032) {
                    String num = Integer.toString(i);
                    h13 = new h13("300", num, "error=" + i, true);
                } else {
                    String num2 = (i == -2601 || i == -2613 || i == -2413) ? "-1" : Integer.toString(i);
                    h13 = new h13(MessageService.MSG_DB_COMPLETE, num2, "error=" + i, true);
                }
                e.a(dVar, h13);
            }
        }

        @Override // com.uploader.implement.b.a.c.a
        public void b(int i) {
            b e;
            d dVar = this.a.get();
            if (dVar != null && (e = dVar.e()) != null) {
                e.b(dVar, i);
            }
        }

        @Override // com.uploader.implement.b.a.c.a
        public void a() {
            b e;
            d dVar = this.a.get();
            if (dVar != null && (e = dVar.e()) != null) {
                e.a(dVar);
            }
        }

        @Override // com.uploader.implement.b.a.c.a
        public void a(int i, int i2) {
            b e;
            d dVar = this.a.get();
            if (dVar != null && (e = dVar.e()) != null) {
                String num = Integer.toString(i2);
                e.a(dVar, new h13(MessageService.MSG_DB_COMPLETE, num, "onSendFailed" + i2, false));
            }
        }

        @Override // com.uploader.implement.b.a.c.a
        public void a(byte[] bArr, int i) {
            b e;
            d dVar = this.a.get();
            if (dVar != null && (e = dVar.e()) != null) {
                m53 m53 = new m53();
                m53.b = bArr;
                m53.c = 0;
                m53.d = i;
                e.a(dVar, m53);
            }
        }
    }
}
