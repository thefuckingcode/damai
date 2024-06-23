package kotlin.reflect;

import java.util.List;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.1")
/* compiled from: Taobao */
public interface KTypeParameter extends KClassifier {
    @NotNull
    String getName();

    @NotNull
    List<KType> getUpperBounds();

    @NotNull
    KVariance getVariance();

    boolean isReified();
}
