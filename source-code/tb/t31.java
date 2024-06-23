package tb;

import kotlin.collections.k;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class t31 {
    private static final boolean a(JavaMethod javaMethod) {
        en0 fqName;
        JavaValueParameter javaValueParameter = (JavaValueParameter) k.q0(javaMethod.getValueParameters());
        JavaClassifierType javaClassifierType = null;
        JavaType type = javaValueParameter == null ? null : javaValueParameter.getType();
        if (type instanceof JavaClassifierType) {
            javaClassifierType = (JavaClassifierType) type;
        }
        if (javaClassifierType == null) {
            return false;
        }
        JavaClassifier classifier = javaClassifierType.getClassifier();
        if (!(classifier instanceof JavaClass) || (fqName = ((JavaClass) classifier).getFqName()) == null || !k21.d(fqName.b(), "java.lang.Object")) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0039, code lost:
        if (r0.equals("toString") == false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return r3.getValueParameters().isEmpty();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0022, code lost:
        if (r0.equals("hashCode") == false) goto L_0x003b;
     */
    private static final boolean b(JavaMethod javaMethod) {
        String b = javaMethod.getName().b();
        int hashCode = b.hashCode();
        if (hashCode != -1776922004) {
            if (hashCode != -1295482945) {
                if (hashCode == 147696667) {
                }
            } else if (b.equals("equals")) {
                return a(javaMethod);
            }
        }
        return false;
    }

    public static final boolean c(@NotNull JavaMember javaMember) {
        k21.i(javaMember, "<this>");
        return javaMember.getContainingClass().isInterface() && (javaMember instanceof JavaMethod) && b((JavaMethod) javaMember);
    }
}
