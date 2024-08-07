package tb;

import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference2;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference2;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.jvm.ReflectLambdaKt;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.KMutableProperty0Impl;
import kotlin.reflect.jvm.internal.KMutableProperty1Impl;
import kotlin.reflect.jvm.internal.KMutableProperty2Impl;
import kotlin.reflect.jvm.internal.KPackageImpl;
import kotlin.reflect.jvm.internal.KProperty0Impl;
import kotlin.reflect.jvm.internal.KProperty1Impl;
import kotlin.reflect.jvm.internal.KProperty2Impl;
import kotlin.reflect.jvm.internal.ReflectionObjectRenderer;
import kotlin.reflect.jvm.internal.a;

/* compiled from: Taobao */
public class gz1 extends fz1 {
    private static KDeclarationContainerImpl l(CallableReference callableReference) {
        KDeclarationContainer owner = callableReference.getOwner();
        return owner instanceof KDeclarationContainerImpl ? (KDeclarationContainerImpl) owner : a.INSTANCE;
    }

    @Override // tb.fz1
    public KFunction a(FunctionReference functionReference) {
        return new KFunctionImpl(l(functionReference), functionReference.getName(), functionReference.getSignature(), functionReference.getBoundReceiver());
    }

    @Override // tb.fz1
    public KClass b(Class cls) {
        return l51.a(cls);
    }

    @Override // tb.fz1
    public KDeclarationContainer c(Class cls, String str) {
        return new KPackageImpl(cls, str);
    }

    @Override // tb.fz1
    public KMutableProperty0 d(MutablePropertyReference0 mutablePropertyReference0) {
        return new KMutableProperty0Impl(l(mutablePropertyReference0), mutablePropertyReference0.getName(), mutablePropertyReference0.getSignature(), mutablePropertyReference0.getBoundReceiver());
    }

    @Override // tb.fz1
    public KMutableProperty1 e(MutablePropertyReference1 mutablePropertyReference1) {
        return new KMutableProperty1Impl(l(mutablePropertyReference1), mutablePropertyReference1.getName(), mutablePropertyReference1.getSignature(), mutablePropertyReference1.getBoundReceiver());
    }

    @Override // tb.fz1
    public KMutableProperty2 f(MutablePropertyReference2 mutablePropertyReference2) {
        return new KMutableProperty2Impl(l(mutablePropertyReference2), mutablePropertyReference2.getName(), mutablePropertyReference2.getSignature());
    }

    @Override // tb.fz1
    public KProperty0 g(PropertyReference0 propertyReference0) {
        return new KProperty0Impl(l(propertyReference0), propertyReference0.getName(), propertyReference0.getSignature(), propertyReference0.getBoundReceiver());
    }

    @Override // tb.fz1
    public KProperty1 h(PropertyReference1 propertyReference1) {
        return new KProperty1Impl(l(propertyReference1), propertyReference1.getName(), propertyReference1.getSignature(), propertyReference1.getBoundReceiver());
    }

    @Override // tb.fz1
    public KProperty2 i(PropertyReference2 propertyReference2) {
        return new KProperty2Impl(l(propertyReference2), propertyReference2.getName(), propertyReference2.getSignature());
    }

    @Override // tb.fz1
    public String j(FunctionBase functionBase) {
        KFunctionImpl b;
        KFunction a = ReflectLambdaKt.a(functionBase);
        if (a == null || (b = wt2.b(a)) == null) {
            return super.j(functionBase);
        }
        return ReflectionObjectRenderer.INSTANCE.e(b.i());
    }

    @Override // tb.fz1
    public String k(Lambda lambda) {
        return j(lambda);
    }
}
