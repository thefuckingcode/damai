package org.jetbrains.anko.appcompat.v7;

import android.content.Context;
import androidx.appcompat.app.AlertDialog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.anko.AlertBuilder;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"-\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Appcompat", "Lkotlin/Function1;", "Landroid/content/Context;", "Lorg/jetbrains/anko/AlertBuilder;", "Landroidx/appcompat/app/AlertDialog;", "Lorg/jetbrains/anko/AlertBuilderFactory;", "getAppcompat", "()Lkotlin/jvm/functions/Function1;", "appcompatV7-base_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: SupportAlertBuilder.kt */
public final class SupportAlertBuilderKt {
    private static final Function1<Context, AlertBuilder<AlertDialog>> Appcompat = SupportAlertBuilderKt$Appcompat$1.INSTANCE;

    public static final Function1<Context, AlertBuilder<AlertDialog>> getAppcompat() {
        return Appcompat;
    }
}
