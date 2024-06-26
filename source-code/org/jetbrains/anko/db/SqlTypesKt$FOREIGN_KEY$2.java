package org.jetbrains.anko.db;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "it", "invoke"}, k = 3, mv = {1, 1, 11})
/* compiled from: sqlTypes.kt */
final class SqlTypesKt$FOREIGN_KEY$2 extends Lambda implements Function1<String, String> {
    public static final SqlTypesKt$FOREIGN_KEY$2 INSTANCE = new SqlTypesKt$FOREIGN_KEY$2();

    SqlTypesKt$FOREIGN_KEY$2() {
        super(1);
    }

    public final String invoke(String str) {
        Intrinsics.checkParameterIsNotNull(str, "it");
        return ' ' + str;
    }
}
