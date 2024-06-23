package org.jetbrains.anko.db;

import android.database.Cursor;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\t\u001a\u00020\nH\u0002J\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0002¢\u0006\u0002\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lorg/jetbrains/anko/db/CursorIterator;", "", "", "", "cursor", "Landroid/database/Cursor;", "(Landroid/database/Cursor;)V", "getCursor", "()Landroid/database/Cursor;", "hasNext", "", "next", "()[Ljava/lang/Object;", "sqlite-base_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: SqlParsers.kt */
final class CursorIterator implements Iterator<Object[]>, KMappedMarker {
    private final Cursor cursor;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public CursorIterator(Cursor cursor2) {
        Intrinsics.checkParameterIsNotNull(cursor2, "cursor");
        this.cursor = cursor2;
    }

    public final Cursor getCursor() {
        return this.cursor;
    }

    public boolean hasNext() {
        return this.cursor.getPosition() < this.cursor.getCount() - 1;
    }

    @Override // java.util.Iterator
    public Object[] next() {
        this.cursor.moveToNext();
        return SqlParsersKt.readColumnsArray(this.cursor);
    }
}
