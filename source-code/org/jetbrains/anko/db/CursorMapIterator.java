package org.jetbrains.anko.db;

import android.database.Cursor;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u000bH\u0002J\u0017\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lorg/jetbrains/anko/db/CursorMapIterator;", "", "", "", "", "cursor", "Landroid/database/Cursor;", "(Landroid/database/Cursor;)V", "getCursor", "()Landroid/database/Cursor;", "hasNext", "", "next", "sqlite-base_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: SqlParsers.kt */
final class CursorMapIterator implements Iterator<Map<String, ? extends Object>>, KMappedMarker {
    private final Cursor cursor;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public CursorMapIterator(Cursor cursor2) {
        Intrinsics.checkParameterIsNotNull(cursor2, "cursor");
        this.cursor = cursor2;
    }

    public final Cursor getCursor() {
        return this.cursor;
    }

    public boolean hasNext() {
        return this.cursor.getPosition() < this.cursor.getCount() - 1;
    }

    /* Return type fixed from 'java.util.Map<java.lang.String, java.lang.Object>' to match base method */
    @Override // java.util.Iterator
    public Map<String, ? extends Object> next() {
        this.cursor.moveToNext();
        return SqlParsersKt.readColumnsMap(this.cursor);
    }
}
