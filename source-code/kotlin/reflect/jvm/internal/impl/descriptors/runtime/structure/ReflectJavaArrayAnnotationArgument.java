package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaAnnotationArguments.kt */
public final class ReflectJavaArrayAnnotationArgument extends ReflectJavaAnnotationArgument implements JavaArrayAnnotationArgument {
    private final Object[] values;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReflectJavaArrayAnnotationArgument(Name name, Object[] objArr) {
        super(name);
        Intrinsics.checkParameterIsNotNull(objArr, "values");
        this.values = objArr;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument
    public List<ReflectJavaAnnotationArgument> getElements() {
        Object[] objArr = this.values;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            ReflectJavaAnnotationArgument.Factory factory = ReflectJavaAnnotationArgument.Factory;
            if (obj == null) {
                Intrinsics.throwNpe();
            }
            arrayList.add(factory.create(obj, null));
        }
        return arrayList;
    }
}
