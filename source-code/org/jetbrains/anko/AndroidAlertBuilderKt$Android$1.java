package org.jetbrains.anko;

import android.content.Context;
import com.lzy.okgo.cookie.SerializableCookie;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lorg/jetbrains/anko/AndroidAlertBuilder;", "p1", "Landroid/content/Context;", "Lkotlin/ParameterName;", SerializableCookie.NAME, "ctx", "invoke"}, k = 3, mv = {1, 1, 11})
/* compiled from: AndroidAlertBuilder.kt */
final class AndroidAlertBuilderKt$Android$1 extends FunctionReference implements Function1<Context, AndroidAlertBuilder> {
    public static final AndroidAlertBuilderKt$Android$1 INSTANCE = new AndroidAlertBuilderKt$Android$1();

    AndroidAlertBuilderKt$Android$1() {
        super(1);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "<init>";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(AndroidAlertBuilder.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "<init>(Landroid/content/Context;)V";
    }

    public final AndroidAlertBuilder invoke(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "p1");
        return new AndroidAlertBuilder(context);
    }
}
