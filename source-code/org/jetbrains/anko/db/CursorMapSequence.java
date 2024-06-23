package org.jetbrains.anko.db;

import android.database.Cursor;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u000bH\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lorg/jetbrains/anko/db/CursorMapSequence;", "Lkotlin/sequences/Sequence;", "", "", "", "cursor", "Landroid/database/Cursor;", "(Landroid/database/Cursor;)V", "getCursor", "()Landroid/database/Cursor;", "iterator", "Lorg/jetbrains/anko/db/CursorMapIterator;", "sqlite-base_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: SqlParsers.kt */
final class CursorMapSequence implements Sequence<Map<String, ? extends Object>> {
    private final Cursor cursor;

    public CursorMapSequence(Cursor cursor2) {
        Intrinsics.checkParameterIsNotNull(cursor2, "cursor");
        this.cursor = cursor2;
    }

    public final Cursor getCursor() {
        return this.cursor;
    }

    /* Return type fixed from 'org.jetbrains.anko.db.CursorMapIterator' to match base method */
    @Override // kotlin.sequences.Sequence
    public Iterator<Map<String, ? extends Object>> iterator() {
        return new CursorMapIterator(this.cursor);
    }
}
