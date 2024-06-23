package org.jetbrains.anko.db;

import com.lzy.okgo.cookie.SerializableCookie;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u0003H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\r"}, d2 = {"Lorg/jetbrains/anko/db/SqlTypeImpl;", "Lorg/jetbrains/anko/db/SqlType;", SerializableCookie.NAME, "", "modifiers", "(Ljava/lang/String;Ljava/lang/String;)V", "getModifiers", "()Ljava/lang/String;", "getName", "plus", "m", "Lorg/jetbrains/anko/db/SqlTypeModifier;", "render", "sqlite-base_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: sqlTypes.kt */
class SqlTypeImpl implements SqlType {
    private final String modifiers;
    private final String name;

    public SqlTypeImpl(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, SerializableCookie.NAME);
        this.name = str;
        this.modifiers = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SqlTypeImpl(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2);
    }

    public final String getModifiers() {
        return this.modifiers;
    }

    @Override // org.jetbrains.anko.db.SqlType
    public String getName() {
        return this.name;
    }

    @Override // org.jetbrains.anko.db.SqlType
    public String render() {
        if (this.modifiers == null) {
            return getName();
        }
        return getName() + ' ' + this.modifiers;
    }

    @Override // org.jetbrains.anko.db.SqlType
    public SqlType plus(SqlTypeModifier sqlTypeModifier) {
        String str;
        Intrinsics.checkParameterIsNotNull(sqlTypeModifier, "m");
        String name2 = getName();
        if (this.modifiers == null) {
            str = sqlTypeModifier.getModifier();
        } else {
            str = this.modifiers + ' ' + sqlTypeModifier.getModifier();
        }
        return new SqlTypeImpl(name2, str);
    }
}
