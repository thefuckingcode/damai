package org.jetbrains.anko.db;

import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.AnkoException;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001d\u0010\u0007\u001a\u00028\u00002\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0003H\u0016¢\u0006\u0002\u0010\nRF\u0010\u0002\u001a8\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u0004 \u0005*\u001c\u0012\u0016\b\u0001\u0012\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u000b"}, d2 = {"org/jetbrains/anko/db/ClassParserKt$classParser$1", "Lorg/jetbrains/anko/db/RowParser;", "parameterTypes", "", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "[Ljava/lang/Class;", "parseRow", "columns", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "sqlite-base_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: ClassParser.kt */
public final class ClassParserKt$classParser$1 implements RowParser<T> {
    final /* synthetic */ Constructor $preferredConstructor;
    private final Class<?>[] parameterTypes;

    ClassParserKt$classParser$1(Constructor constructor) {
        this.$preferredConstructor = constructor;
        Intrinsics.checkExpressionValueIsNotNull(constructor, "preferredConstructor");
        this.parameterTypes = constructor.getParameterTypes();
    }

    @Override // org.jetbrains.anko.db.RowParser
    public T parseRow(Object[] objArr) {
        Intrinsics.checkParameterIsNotNull(objArr, "columns");
        Class<?>[] clsArr = this.parameterTypes;
        if (clsArr.length == objArr.length) {
            int i = 0;
            int length = clsArr.length - 1;
            if (length >= 0) {
                while (true) {
                    Class<?> cls = this.parameterTypes[i];
                    Object obj = objArr[i];
                    if (!cls.isInstance(obj)) {
                        Intrinsics.checkExpressionValueIsNotNull(cls, "type");
                        objArr[i] = ClassParserKt.access$castValue(obj, cls);
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
            return (T) JavaSqliteUtils.newInstance(this.$preferredConstructor, objArr);
        }
        String joinToString$default = ArraysKt.joinToString$default(objArr, (CharSequence) null, "[", "]", 0, (CharSequence) null, (Function1) null, 57, (Object) null);
        Class<?>[] clsArr2 = this.parameterTypes;
        Intrinsics.checkExpressionValueIsNotNull(clsArr2, "parameterTypes");
        String joinToString$default2 = ArraysKt.joinToString$default(clsArr2, (CharSequence) null, "[", "]", 0, (CharSequence) null, ClassParserKt$classParser$1$parseRow$parameterTypesRendered$1.INSTANCE, 25, (Object) null);
        StringBuilder sb = new StringBuilder();
        sb.append("Class parser for ");
        Constructor constructor = this.$preferredConstructor;
        Intrinsics.checkExpressionValueIsNotNull(constructor, "preferredConstructor");
        sb.append(constructor.getName());
        sb.append(' ');
        sb.append("failed to parse the row: ");
        sb.append(joinToString$default);
        sb.append(" (constructor parameter types: ");
        sb.append(joinToString$default2);
        sb.append(')');
        throw new AnkoException(sb.toString());
    }
}
