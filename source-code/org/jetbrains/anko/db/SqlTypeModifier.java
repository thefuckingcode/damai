package org.jetbrains.anko.db;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lorg/jetbrains/anko/db/SqlTypeModifier;", "", "modifier", "", "getModifier", "()Ljava/lang/String;", "Companion", "sqlite-base_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: sqlTypes.kt */
public interface SqlTypeModifier {
    public static final Companion Companion = Companion.$$INSTANCE;

    String getModifier();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lorg/jetbrains/anko/db/SqlTypeModifier$Companion;", "", "()V", "create", "Lorg/jetbrains/anko/db/SqlTypeModifier;", "modifier", "", "sqlite-base_release"}, k = 1, mv = {1, 1, 11})
    /* compiled from: sqlTypes.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final SqlTypeModifier create(String str) {
            Intrinsics.checkParameterIsNotNull(str, "modifier");
            return new SqlTypeModifierImpl(str);
        }
    }
}
