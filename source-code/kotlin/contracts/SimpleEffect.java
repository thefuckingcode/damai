package kotlin.contracts;

import kotlin.SinceKotlin;
import kotlin.internal.ContractsDsl;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.3")
@ContractsDsl
@ExperimentalContracts
/* compiled from: Taobao */
public interface SimpleEffect extends Effect {
    @ContractsDsl
    @ExperimentalContracts
    @NotNull
    ConditionalEffect implies(boolean z);
}
