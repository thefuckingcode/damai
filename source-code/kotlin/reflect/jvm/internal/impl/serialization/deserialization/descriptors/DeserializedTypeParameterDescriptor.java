package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.huawei.hms.opendevice.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.l;
import kotlin.collections.n;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import tb.g61;
import tb.hv1;
import tb.jv1;
import tb.k21;
import tb.l60;
import tb.m60;
import tb.og1;
import tb.qg1;
import tb.r1;

/* compiled from: Taobao */
public final class DeserializedTypeParameterDescriptor extends r1 {
    @NotNull
    private final l60 k;
    @NotNull
    private final ProtoBuf$TypeParameter l;
    @NotNull
    private final m60 m;

    /* JADX WARNING: Illegal instructions before constructor call */
    public DeserializedTypeParameterDescriptor(@NotNull l60 l60, @NotNull ProtoBuf$TypeParameter protoBuf$TypeParameter, int i) {
        super(r2, r3, r4, r0.d(r1), protoBuf$TypeParameter.getReified(), i, SourceElement.NO_SOURCE, SupertypeLoopChecker.a.INSTANCE);
        k21.i(l60, c.a);
        k21.i(protoBuf$TypeParameter, "proto");
        StorageManager h = l60.h();
        DeclarationDescriptor e = l60.e();
        og1 b = qg1.b(l60.g(), protoBuf$TypeParameter.getName());
        hv1 hv1 = hv1.INSTANCE;
        ProtoBuf$TypeParameter.Variance variance = protoBuf$TypeParameter.getVariance();
        k21.h(variance, "proto.variance");
        this.k = l60;
        this.l = protoBuf$TypeParameter;
        this.m = new m60(l60.h(), new DeserializedTypeParameterDescriptor$annotations$1(this));
    }

    /* access modifiers changed from: protected */
    @Override // tb.n2
    @NotNull
    public List<g61> f() {
        List<ProtoBuf$Type> o = jv1.o(this.l, this.k.j());
        if (o.isEmpty()) {
            return l.e(DescriptorUtilsKt.g(this).y());
        }
        TypeDeserializer i = this.k.i();
        ArrayList arrayList = new ArrayList(n.q(o, 10));
        Iterator<T> it = o.iterator();
        while (it.hasNext()) {
            arrayList.add(i.p(it.next()));
        }
        return arrayList;
    }

    @NotNull
    /* renamed from: h */
    public m60 getAnnotations() {
        return this.m;
    }

    @NotNull
    public final ProtoBuf$TypeParameter i() {
        return this.l;
    }

    /* access modifiers changed from: protected */
    @NotNull
    /* renamed from: j */
    public Void e(@NotNull g61 g61) {
        k21.i(g61, "type");
        throw new IllegalStateException(k21.r("There should be no cycles for deserialized type parameters, but found for: ", this));
    }
}
