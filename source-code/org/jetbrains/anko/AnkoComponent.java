package org.jetbrains.anko;

import android.view.View;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H&¨\u0006\u0007"}, d2 = {"Lorg/jetbrains/anko/AnkoComponent;", "T", "", "createView", "Landroid/view/View;", "ui", "Lorg/jetbrains/anko/AnkoContext;", "commons-base_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: AnkoContext.kt */
public interface AnkoComponent<T> {
    View createView(AnkoContext<? extends T> ankoContext);
}
