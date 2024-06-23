package com.google.common.base;

import java.io.Serializable;
import java.lang.Enum;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;

/* compiled from: Taobao */
final class Enums$StringConverter<T extends Enum<T>> extends Converter<String, T> implements Serializable {
    private static final long serialVersionUID = 0;
    private final Class<T> enumClass;

    Enums$StringConverter(Class<T> cls) {
        this.enumClass = (Class) ds1.p(cls);
    }

    @Override // com.google.common.base.Function, com.google.common.base.Converter
    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof Enums$StringConverter) {
            return this.enumClass.equals(((Enums$StringConverter) obj).enumClass);
        }
        return false;
    }

    public int hashCode() {
        return this.enumClass.hashCode();
    }

    public String toString() {
        return "Enums.stringConverter(" + this.enumClass.getName() + ".class)";
    }

    /* access modifiers changed from: protected */
    public String doBackward(T t) {
        return t.name();
    }

    /* access modifiers changed from: protected */
    public T doForward(String str) {
        return (T) Enum.valueOf(this.enumClass, str);
    }
}
