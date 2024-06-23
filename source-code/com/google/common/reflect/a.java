package com.google.common.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class a extends AccessibleObject implements Member {
    private final AccessibleObject a;
    private final Member b;

    <M extends AccessibleObject & Member> a(M m) {
        ds1.p(m);
        this.a = m;
        this.b = m;
    }

    public TypeToken<?> a() {
        return TypeToken.of((Class) getDeclaringClass());
    }

    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!a().equals(aVar.a()) || !this.b.equals(aVar.b)) {
            return false;
        }
        return true;
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final <A extends Annotation> A getAnnotation(Class<A> cls) {
        return (A) this.a.getAnnotation(cls);
    }

    public final Annotation[] getAnnotations() {
        return this.a.getAnnotations();
    }

    public final Annotation[] getDeclaredAnnotations() {
        return this.a.getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.Member
    public Class<?> getDeclaringClass() {
        return this.b.getDeclaringClass();
    }

    public final int getModifiers() {
        return this.b.getModifiers();
    }

    public final String getName() {
        return this.b.getName();
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public final boolean isAccessible() {
        return this.a.isAccessible();
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        return this.a.isAnnotationPresent(cls);
    }

    public final boolean isSynthetic() {
        return this.b.isSynthetic();
    }

    @Override // java.lang.reflect.AccessibleObject
    public final void setAccessible(boolean z) throws SecurityException {
        this.a.setAccessible(z);
    }

    public String toString() {
        return this.b.toString();
    }
}
