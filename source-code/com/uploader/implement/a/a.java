package com.uploader.implement.a;

import android.content.Context;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.uploader.implement.d.b;
import java.lang.ref.WeakReference;
import org.android.agoo.message.MessageService;
import tb.f13;
import tb.h13;
import tb.i13;

/* compiled from: Taobao */
public abstract class a implements g, com.uploader.implement.d.a {
    final int a;
    final Context b;
    WeakReference<d> c;
    private volatile int d = 0;

    a(Context context) {
        this.b = context;
        this.a = hashCode();
    }

    private void j(@Nullable b bVar, h13 h13, int i) {
        int i2 = this.d;
        if (com.uploader.implement.a.d(8)) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append(" stop, session:");
            sb.append(bVar == null ? "null" : Integer.valueOf(bVar.hashCode()));
            sb.append(" oldState:");
            sb.append(i2);
            sb.append(" error:");
            sb.append(h13);
            sb.append(" reason:");
            sb.append(i);
            com.uploader.implement.a.a(8, "AbstractUploaderAction", sb.toString());
        }
        if (bVar != null) {
            f();
            bVar.a((com.uploader.implement.d.a) null);
            bVar.a();
        }
        int i3 = 4;
        if (i == 2) {
            k(this.d == 2 ? 5 : 4);
        } else {
            k(3);
            d t = t();
            if (t != null) {
                t.a(this);
            }
            i3 = i == 0 ? 1 : 2;
        }
        g(i3, h13);
    }

    private boolean k(int i) {
        if (this.d == i) {
            return false;
        }
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "AbstractUploaderAction", this.a + " setState, oldState:" + this.d + " state:" + i);
        }
        this.d = i;
        return true;
    }

    private void q(b bVar, e eVar, h13 h13) {
        if (h13 != null) {
            if (!h13.d) {
                j(bVar, h13, 1);
                return;
            }
            h13 d2 = d(bVar, eVar, h13);
            if (d2 != null) {
                j(bVar, d2, 1);
            }
        }
    }

    private void s(b bVar) {
        boolean n = n();
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "AbstractUploaderAction", this.a + " begin, session:" + bVar.hashCode() + " state:" + this.d + " stepUp:" + n);
        }
        if (n) {
            k(2);
        }
        h13 e = e(bVar, null, true);
        if (e != null) {
            j(bVar, e, 1);
        }
    }

    private d t() {
        WeakReference<d> weakReference = this.c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* access modifiers changed from: package-private */
    public abstract Pair<Integer, Integer> a(@NonNull b bVar, @NonNull e eVar);

    @Override // com.uploader.implement.d.a
    public final void a(b bVar, e eVar, f fVar) {
        f13 f13 = (f13) fVar;
        int a2 = f13.a();
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "AbstractUploaderAction", this.a + " onReceive, session:" + bVar.hashCode() + " request:" + eVar.hashCode() + " response:" + f13.hashCode() + " state:" + this.d + " type:" + a2 + " content:" + f13.c().toString());
        }
        if (this.d != 3) {
            Pair<h13, ? extends Object> b2 = b(bVar, eVar, f13);
            h13 h13 = (h13) b2.first;
            switch (a2) {
                case 1:
                    if (h13 == null) {
                        if (!n()) {
                            k(3);
                            bVar.a(eVar, true);
                            d t = t();
                            if (t != null) {
                                t.a(this);
                                break;
                            }
                        } else {
                            k(2);
                            h13 = e(bVar, eVar, true);
                            break;
                        }
                    }
                    break;
                case 2:
                    Object obj = b2.second;
                    if (obj != null) {
                        g(3, obj);
                        break;
                    }
                    break;
                case 3:
                    Object obj2 = b2.second;
                    if (obj2 != null) {
                        h13 = c(bVar, eVar, (Pair) obj2);
                        break;
                    }
                    break;
                case 4:
                    k(3);
                    bVar.a((com.uploader.implement.d.a) null);
                    bVar.a(eVar, true);
                    g(0, b2.second);
                    d t2 = t();
                    if (t2 != null) {
                        t2.a(this);
                        break;
                    }
                    break;
                case 5:
                    if (h13 != null && "300".equals(h13.a) && "2".equals(h13.b)) {
                        k(1);
                        h13 = e(bVar, null, true);
                        break;
                    }
                case 6:
                    Object obj3 = b2.second;
                    h13 = new h13("300", "3", obj3 == null ? "" : obj3.toString(), true);
                    break;
            }
            q(bVar, eVar, h13);
        } else if (com.uploader.implement.a.d(8)) {
            com.uploader.implement.a.a(8, "AbstractUploaderAction", this.a + " onReceive, state is finish");
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public abstract Pair<h13, ? extends Object> b(@NonNull b bVar, e eVar, @NonNull f13 f13);

    @Override // com.uploader.implement.d.a
    public final void b(b bVar, e eVar) {
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "AbstractUploaderAction", this.a + " onSend, session:" + bVar.hashCode() + " request:" + eVar.hashCode());
        }
        if (this.d != 3) {
            Pair<Integer, Integer> a2 = a(bVar, eVar);
            if (a2 != null) {
                q(bVar, eVar, c(bVar, eVar, a2));
            }
        } else if (com.uploader.implement.a.d(8)) {
            com.uploader.implement.a.a(8, "AbstractUploaderAction", this.a + " onSend, state is finish");
        }
    }

    /* access modifiers changed from: package-private */
    public abstract h13 c(@NonNull b bVar, e eVar, Pair<Integer, Integer> pair);

    /* access modifiers changed from: package-private */
    public abstract h13 d(@NonNull b bVar, e eVar, h13 h13);

    /* access modifiers changed from: package-private */
    public abstract h13 e(@NonNull b bVar, e eVar, boolean z);

    /* access modifiers changed from: package-private */
    public abstract void f();

    /* access modifiers changed from: package-private */
    public abstract void g(int i, Object obj);

    public final void h(d dVar) {
        this.c = new WeakReference<>(dVar);
    }

    /* access modifiers changed from: package-private */
    public final void i(b bVar, h13 h13) {
        if (this.d == 3) {
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.a(8, "AbstractUploaderAction", this.a + " begin, state is finish");
            }
        } else if (h13 != null) {
            j(bVar, h13, 1);
        } else {
            s(bVar);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract boolean l(b bVar);

    public final void m(@NonNull b bVar) {
        int i = this.d == 0 ? 5 : 6;
        if (com.uploader.implement.a.d(8)) {
            com.uploader.implement.a.a(8, "AbstractUploaderAction", this.a + " onStart, state:" + this.d + " notifyType:" + i + " session:" + bVar.hashCode());
        }
        int i2 = this.d;
        if (!(i2 == 0 || i2 == 1)) {
            if (i2 != 2) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        if (com.uploader.implement.a.d(8)) {
                            com.uploader.implement.a.a(8, "AbstractUploaderAction", this.a + " no need to begin, " + " state:" + this.d);
                        }
                        g(i, null);
                    }
                }
            }
            if (!k(2)) {
                f();
                bVar.a((com.uploader.implement.d.a) null);
                bVar.a();
            }
            bVar.a(this);
            h13 e = e(bVar, null, true);
            if (e != null) {
                j(bVar, e, 1);
            }
            g(i, null);
        }
        if (!k(1)) {
            f();
            bVar.a((com.uploader.implement.d.a) null);
            bVar.a();
        }
        bVar.a(this);
        if (!l(bVar)) {
            s(bVar);
        }
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "AbstractUploaderAction", this.a + " submit timeConsuming, session:" + bVar.hashCode() + " state:" + this.d);
        }
        g(i, null);
    }

    /* access modifiers changed from: package-private */
    public abstract boolean n();

    public final int o() {
        return this.d;
    }

    public final void p(@Nullable b bVar) {
        if (this.d != 3) {
            j(bVar, null, 0);
        } else if (com.uploader.implement.a.d(8)) {
            com.uploader.implement.a.a(8, "AbstractUploaderAction", this.a + " onCancel, state is finish");
        }
    }

    public void r() {
        g(7, null);
    }

    @Override // com.uploader.implement.d.a
    public final void b(b bVar, e eVar, h13 h13) {
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "AbstractUploaderAction", this.a + " onError, session:" + bVar.hashCode() + " request:" + eVar.hashCode() + " error:" + h13.toString());
        }
        if (this.d != 3) {
            if (MessageService.MSG_DB_COMPLETE.equals(h13.a)) {
                boolean a2 = i13.a(this.b);
                if (com.uploader.implement.a.d(2)) {
                    com.uploader.implement.a.a(2, "AbstractUploaderAction", this.a + " onError, connection error, isConnected:" + a2 + " error:" + h13.toString());
                }
                if (!a2 || "-1".equals(h13.b)) {
                    j(bVar, h13, 2);
                    return;
                }
            }
            q(bVar, eVar, h13);
        } else if (com.uploader.implement.a.d(8)) {
            com.uploader.implement.a.a(8, "AbstractUploaderAction", this.a + " onError, state is finish");
        }
    }
}
