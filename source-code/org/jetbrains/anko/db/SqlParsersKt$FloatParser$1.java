package org.jetbrains.anko.db;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 1, 11})
/* compiled from: SqlParsers.kt */
final class SqlParsersKt$FloatParser$1 extends FunctionReference implements Function1<Double, Float> {
    public static final SqlParsersKt$FloatParser$1 INSTANCE = new SqlParsersKt$FloatParser$1();

    SqlParsersKt$FloatParser$1() {
        super(1);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "toFloat";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(Double.TYPE);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "floatValue()F";
    }

    public final float invoke(double d) {
        return (float) d;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Float invoke(Double d) {
        return Float.valueOf(invoke(d.doubleValue()));
    }
}
