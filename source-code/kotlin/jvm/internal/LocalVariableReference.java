package kotlin.jvm.internal;

import kotlin.KotlinNothingValueException;
import kotlin.SinceKotlin;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k81;

@SinceKotlin(version = "1.1")
/* compiled from: Taobao */
public class LocalVariableReference extends PropertyReference0 {
    @Override // kotlin.reflect.KProperty0
    @Nullable
    public Object get() {
        Void unused = k81.b();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.internal.CallableReference
    @NotNull
    public KDeclarationContainer getOwner() {
        Void unused = k81.b();
        throw new KotlinNothingValueException();
    }
}
