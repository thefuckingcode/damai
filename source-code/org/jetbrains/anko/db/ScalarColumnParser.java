package org.jetbrains.anko.db;

import android.database.sqlite.SQLiteException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0006\b\u0001\u0010\u0002 \u00012\b\u0012\u0004\u0012\u0002H\u00020\u0003B\u001d\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001d\u0010\t\u001a\u00028\u00012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0016¢\u0006\u0002\u0010\rR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lorg/jetbrains/anko/db/ScalarColumnParser;", "R", "T", "Lorg/jetbrains/anko/db/RowParser;", "modifier", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)V", "getModifier", "()Lkotlin/jvm/functions/Function1;", "parseRow", "columns", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "sqlite-base_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: SqlParsers.kt */
final class ScalarColumnParser<R, T> implements RowParser<T> {
    private final Function1<R, T> modifier;

    public ScalarColumnParser() {
        this(null, 1, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.jvm.functions.Function1<? super R, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public ScalarColumnParser(Function1<? super R, ? extends T> function1) {
        this.modifier = function1;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScalarColumnParser(Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function1);
    }

    public final Function1<R, T> getModifier() {
        return this.modifier;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: kotlin.jvm.functions.Function1<R, T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jetbrains.anko.db.RowParser
    public T parseRow(Object[] objArr) {
        Intrinsics.checkParameterIsNotNull(objArr, "columns");
        if (objArr.length == 1) {
            Function1<R, T> function1 = this.modifier;
            if (function1 == 0) {
                return (T) objArr[0];
            }
            if (function1 == 0) {
                Intrinsics.throwNpe();
            }
            return (T) function1.invoke(objArr[0]);
        }
        throw new SQLiteException("Invalid row: row for SingleColumnParser must contain exactly one column");
    }
}
