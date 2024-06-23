package tb;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import org.jetbrains.annotations.NotNull;
import tb.ry1;

/* compiled from: Taobao */
public final class ly1 extends ny1 implements JavaField {
    @NotNull
    private final Field a;

    public ly1(@NotNull Field field) {
        k21.i(field, "member");
        this.a = field;
    }

    @NotNull
    /* renamed from: f */
    public Field d() {
        return this.a;
    }

    @NotNull
    /* renamed from: g */
    public ry1 getType() {
        ry1.a aVar = ry1.Factory;
        Type genericType = d().getGenericType();
        k21.h(genericType, "member.genericType");
        return aVar.a(genericType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField
    public boolean getHasConstantNotNullInitializer() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField
    public boolean isEnumEntry() {
        return d().isEnumConstant();
    }
}
