package tb;

import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: Taobao */
public abstract class uo2 implements TypeProjection {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TypeProjection)) {
            return false;
        }
        TypeProjection typeProjection = (TypeProjection) obj;
        return isStarProjection() == typeProjection.isStarProjection() && getProjectionKind() == typeProjection.getProjectionKind() && getType().equals(typeProjection.getType());
    }

    public int hashCode() {
        int hashCode = getProjectionKind().hashCode();
        if (bp2.v(getType())) {
            return (hashCode * 31) + 19;
        }
        return (hashCode * 31) + (isStarProjection() ? 17 : getType().hashCode());
    }

    public String toString() {
        if (isStarProjection()) {
            return jl1.MUL;
        }
        if (getProjectionKind() == Variance.INVARIANT) {
            return getType().toString();
        }
        return getProjectionKind() + " " + getType();
    }
}
