package org.jetbrains.anko.db;

import com.lzy.okgo.cookie.SerializableCookie;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\u0011\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bH¦\u0002J\b\u0010\t\u001a\u00020\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000b"}, d2 = {"Lorg/jetbrains/anko/db/SqlType;", "", SerializableCookie.NAME, "", "getName", "()Ljava/lang/String;", "plus", "m", "Lorg/jetbrains/anko/db/SqlTypeModifier;", "render", "Companion", "sqlite-base_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: sqlTypes.kt */
public interface SqlType {
    public static final Companion Companion = Companion.$$INSTANCE;

    String getName();

    SqlType plus(SqlTypeModifier sqlTypeModifier);

    String render();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lorg/jetbrains/anko/db/SqlType$Companion;", "", "()V", "create", "Lorg/jetbrains/anko/db/SqlType;", SerializableCookie.NAME, "", "sqlite-base_release"}, k = 1, mv = {1, 1, 11})
    /* compiled from: sqlTypes.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final SqlType create(String str) {
            Intrinsics.checkParameterIsNotNull(str, SerializableCookie.NAME);
            return new SqlTypeImpl(str, null, 2, null);
        }
    }
}
