package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* access modifiers changed from: package-private */
/* compiled from: typeEnhancement.kt */
public class Result {
    private final int subtreeSize;
    private final KotlinType type;
    private final boolean wereChanges;

    public Result(KotlinType kotlinType, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "type");
        this.type = kotlinType;
        this.subtreeSize = i;
        this.wereChanges = z;
    }

    public final int getSubtreeSize() {
        return this.subtreeSize;
    }

    public KotlinType getType() {
        return this.type;
    }

    public final boolean getWereChanges() {
        return this.wereChanges;
    }

    public final KotlinType getTypeIfChanged() {
        KotlinType type2 = getType();
        if (this.wereChanges) {
            return type2;
        }
        return null;
    }
}
