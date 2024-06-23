package kotlin.reflect;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.r51;

/* compiled from: Taobao */
public interface KType extends KAnnotatedElement {
    @NotNull
    List<r51> getArguments();

    @Nullable
    KClassifier getClassifier();

    boolean isMarkedNullable();
}
