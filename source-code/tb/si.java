package tb;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public class si extends k1 {
    private final ClassDescriptor d;
    private final List<TypeParameterDescriptor> e;
    private final Collection<g61> f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public si(@NotNull ClassDescriptor classDescriptor, @NotNull List<? extends TypeParameterDescriptor> list, @NotNull Collection<g61> collection, @NotNull StorageManager storageManager) {
        super(storageManager);
        if (classDescriptor == null) {
            l(0);
        }
        if (list == null) {
            l(1);
        }
        if (collection == null) {
            l(2);
        }
        if (storageManager == null) {
            l(3);
        }
        this.d = classDescriptor;
        this.e = Collections.unmodifiableList(new ArrayList(list));
        this.f = Collections.unmodifiableCollection(collection);
    }

    private static /* synthetic */ void l(int i) {
        String str = (i == 4 || i == 5 || i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 4 || i == 5 || i == 6 || i == 7) ? 2 : 3)];
        switch (i) {
            case 1:
                objArr[0] = PushConstants.PARAMS;
                break;
            case 2:
                objArr[0] = "supertypes";
                break;
            case 3:
                objArr[0] = "storageManager";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
                break;
            default:
                objArr[0] = "classDescriptor";
                break;
        }
        if (i == 4) {
            objArr[1] = "getParameters";
        } else if (i == 5) {
            objArr[1] = "getDeclarationDescriptor";
        } else if (i == 6) {
            objArr[1] = "computeSupertypes";
        } else if (i != 7) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
        } else {
            objArr[1] = "getSupertypeLoopChecker";
        }
        if (!(i == 4 || i == 5 || i == 6 || i == 7)) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i == 4 || i == 5 || i == 6 || i == 7) {
            throw new IllegalStateException(format);
        }
        throw new IllegalArgumentException(format);
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
    @NotNull
    public Collection<g61> c() {
        Collection<g61> collection = this.f;
        if (collection == null) {
            l(6);
        }
        return collection;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
    @NotNull
    public SupertypeLoopChecker g() {
        SupertypeLoopChecker.a aVar = SupertypeLoopChecker.a.INSTANCE;
        if (aVar == null) {
            l(7);
        }
        return aVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public List<TypeParameterDescriptor> getParameters() {
        List<TypeParameterDescriptor> list = this.e;
        if (list == null) {
            l(4);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return true;
    }

    @Override // tb.k1
    @NotNull
    /* renamed from: n */
    public ClassDescriptor getDeclarationDescriptor() {
        ClassDescriptor classDescriptor = this.d;
        if (classDescriptor == null) {
            l(5);
        }
        return classDescriptor;
    }

    public String toString() {
        return f60.m(this.d).b();
    }
}
