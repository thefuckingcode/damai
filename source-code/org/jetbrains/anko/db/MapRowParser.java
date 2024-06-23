package org.jetbrains.anko.db;

import java.util.Map;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J#\u0010\u0003\u001a\u00028\u00002\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005H&¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lorg/jetbrains/anko/db/MapRowParser;", "T", "", "parseRow", "columns", "", "", "(Ljava/util/Map;)Ljava/lang/Object;", "sqlite-base_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: SqlParsers.kt */
public interface MapRowParser<T> {
    T parseRow(Map<String, ? extends Object> map);
}
