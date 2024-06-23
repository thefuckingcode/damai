package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class li {
    @NotNull
    private final NameResolver a;
    @NotNull
    private final ProtoBuf$Class b;
    @NotNull
    private final nb c;
    @NotNull
    private final SourceElement d;

    public li(@NotNull NameResolver nameResolver, @NotNull ProtoBuf$Class protoBuf$Class, @NotNull nb nbVar, @NotNull SourceElement sourceElement) {
        k21.i(nameResolver, "nameResolver");
        k21.i(protoBuf$Class, "classProto");
        k21.i(nbVar, "metadataVersion");
        k21.i(sourceElement, "sourceElement");
        this.a = nameResolver;
        this.b = protoBuf$Class;
        this.c = nbVar;
        this.d = sourceElement;
    }

    @NotNull
    public final NameResolver a() {
        return this.a;
    }

    @NotNull
    public final ProtoBuf$Class b() {
        return this.b;
    }

    @NotNull
    public final nb c() {
        return this.c;
    }

    @NotNull
    public final SourceElement d() {
        return this.d;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof li)) {
            return false;
        }
        li liVar = (li) obj;
        return k21.d(this.a, liVar.a) && k21.d(this.b, liVar.b) && k21.d(this.c, liVar.c) && k21.d(this.d, liVar.d);
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    @NotNull
    public String toString() {
        return "ClassData(nameResolver=" + this.a + ", classProto=" + this.b + ", metadataVersion=" + this.c + ", sourceElement=" + this.d + ')';
    }
}
