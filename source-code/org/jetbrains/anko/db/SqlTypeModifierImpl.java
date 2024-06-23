package org.jetbrains.anko.db;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0012\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lorg/jetbrains/anko/db/SqlTypeModifierImpl;", "Lorg/jetbrains/anko/db/SqlTypeModifier;", "modifier", "", "(Ljava/lang/String;)V", "getModifier", "()Ljava/lang/String;", "sqlite-base_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: sqlTypes.kt */
class SqlTypeModifierImpl implements SqlTypeModifier {
    private final String modifier;

    public SqlTypeModifierImpl(String str) {
        Intrinsics.checkParameterIsNotNull(str, "modifier");
        this.modifier = str;
    }

    @Override // org.jetbrains.anko.db.SqlTypeModifier
    public String getModifier() {
        return this.modifier;
    }
}
