package kotlinx.coroutines;

import kotlin.jvm.functions.Function1;
import tb.hf;
import tb.k21;
import tb.m40;
import tb.ur2;

public final class h {
    public final Object a;
    public final hf b;
    public final Function1<Throwable, ur2> c;
    public final Object d;
    public final Throwable e;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Throwable, tb.ur2> */
    /* JADX WARN: Multi-variable type inference failed */
    public h(Object obj, hf hfVar, Function1<? super Throwable, ur2> function1, Object obj2, Throwable th) {
        this.a = obj;
        this.b = hfVar;
        this.c = function1;
        this.d = obj2;
        this.e = th;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlinx.coroutines.h */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ h b(h hVar, Object obj, hf hfVar, Function1 function1, Object obj2, Throwable th, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = hVar.a;
        }
        if ((i & 2) != 0) {
            hfVar = hVar.b;
        }
        if ((i & 4) != 0) {
            function1 = hVar.c;
        }
        if ((i & 8) != 0) {
            obj2 = hVar.d;
        }
        if ((i & 16) != 0) {
            th = hVar.e;
        }
        return hVar.a(obj, hfVar, function1, obj2, th);
    }

    public final h a(Object obj, hf hfVar, Function1<? super Throwable, ur2> function1, Object obj2, Throwable th) {
        return new h(obj, hfVar, function1, obj2, th);
    }

    public final boolean c() {
        return this.e != null;
    }

    public final void d(CancellableContinuationImpl<?> cancellableContinuationImpl, Throwable th) {
        hf hfVar = this.b;
        if (hfVar != null) {
            cancellableContinuationImpl.callCancelHandler(hfVar, th);
        }
        Function1<Throwable, ur2> function1 = this.c;
        if (function1 != null) {
            cancellableContinuationImpl.callOnCancellation(function1, th);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return k21.d(this.a, hVar.a) && k21.d(this.b, hVar.b) && k21.d(this.c, hVar.c) && k21.d(this.d, hVar.d) && k21.d(this.e, hVar.e);
    }

    public int hashCode() {
        Object obj = this.a;
        int i = 0;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        hf hfVar = this.b;
        int hashCode2 = (hashCode + (hfVar == null ? 0 : hfVar.hashCode())) * 31;
        Function1<Throwable, ur2> function1 = this.c;
        int hashCode3 = (hashCode2 + (function1 == null ? 0 : function1.hashCode())) * 31;
        Object obj2 = this.d;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.e;
        if (th != null) {
            i = th.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.a + ", cancelHandler=" + this.b + ", onCancellation=" + this.c + ", idempotentResume=" + this.d + ", cancelCause=" + this.e + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(Object obj, hf hfVar, Function1 function1, Object obj2, Throwable th, int i, m40 m40) {
        this(obj, (i & 2) != 0 ? null : hfVar, (i & 4) != 0 ? null : function1, (i & 8) != 0 ? null : obj2, (i & 16) != 0 ? null : th);
    }
}
