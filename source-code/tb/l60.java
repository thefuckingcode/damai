package tb;

import com.youku.arch.v3.data.Constants;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

public final class l60 {
    private final j60 a;
    private final NameResolver b;
    private final DeclarationDescriptor c;
    private final ap2 d;
    private final fv2 e;
    private final nb f;
    private final DeserializedContainerSource g;
    private final TypeDeserializer h;
    private final MemberDeserializer i;

    public l60(j60 j60, NameResolver nameResolver, DeclarationDescriptor declarationDescriptor, ap2 ap2, fv2 fv2, nb nbVar, DeserializedContainerSource deserializedContainerSource, TypeDeserializer typeDeserializer, List<ProtoBuf$TypeParameter> list) {
        String str;
        String presentableString;
        k21.i(j60, Constants.COMPONENT);
        k21.i(nameResolver, "nameResolver");
        k21.i(declarationDescriptor, "containingDeclaration");
        k21.i(ap2, "typeTable");
        k21.i(fv2, "versionRequirementTable");
        k21.i(nbVar, "metadataVersion");
        k21.i(list, "typeParameters");
        this.a = j60;
        this.b = nameResolver;
        this.c = declarationDescriptor;
        this.d = ap2;
        this.e = fv2;
        this.f = nbVar;
        this.g = deserializedContainerSource;
        String str2 = "Deserializer for \"" + declarationDescriptor.getName() + jl1.QUOTE;
        if (deserializedContainerSource == null || (presentableString = deserializedContainerSource.getPresentableString()) == null) {
            str = "[container not found]";
        } else {
            str = presentableString;
        }
        this.h = new TypeDeserializer(this, typeDeserializer, list, str2, str, false, 32, null);
        this.i = new MemberDeserializer(this);
    }

    public static /* synthetic */ l60 b(l60 l60, DeclarationDescriptor declarationDescriptor, List list, NameResolver nameResolver, ap2 ap2, fv2 fv2, nb nbVar, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            nameResolver = l60.b;
        }
        if ((i2 & 8) != 0) {
            ap2 = l60.d;
        }
        if ((i2 & 16) != 0) {
            fv2 = l60.e;
        }
        if ((i2 & 32) != 0) {
            nbVar = l60.f;
        }
        return l60.a(declarationDescriptor, list, nameResolver, ap2, fv2, nbVar);
    }

    public final l60 a(DeclarationDescriptor declarationDescriptor, List<ProtoBuf$TypeParameter> list, NameResolver nameResolver, ap2 ap2, fv2 fv2, nb nbVar) {
        k21.i(declarationDescriptor, "descriptor");
        k21.i(list, "typeParameterProtos");
        k21.i(nameResolver, "nameResolver");
        k21.i(ap2, "typeTable");
        fv2 fv22 = fv2;
        k21.i(fv22, "versionRequirementTable");
        k21.i(nbVar, "metadataVersion");
        j60 j60 = this.a;
        if (!gv2.b(nbVar)) {
            fv22 = this.e;
        }
        return new l60(j60, nameResolver, declarationDescriptor, ap2, fv22, nbVar, this.g, this.h, list);
    }

    public final j60 c() {
        return this.a;
    }

    public final DeserializedContainerSource d() {
        return this.g;
    }

    public final DeclarationDescriptor e() {
        return this.c;
    }

    public final MemberDeserializer f() {
        return this.i;
    }

    public final NameResolver g() {
        return this.b;
    }

    public final StorageManager h() {
        return this.a.u();
    }

    public final TypeDeserializer i() {
        return this.h;
    }

    public final ap2 j() {
        return this.d;
    }

    public final fv2 k() {
        return this.e;
    }
}
