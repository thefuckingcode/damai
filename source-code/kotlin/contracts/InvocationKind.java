package kotlin.contracts;

import kotlin.SinceKotlin;
import kotlin.internal.ContractsDsl;

@SinceKotlin(version = "1.3")
@ContractsDsl
@ExperimentalContracts
/* compiled from: Taobao */
public enum InvocationKind {
    AT_MOST_ONCE,
    AT_LEAST_ONCE,
    EXACTLY_ONCE,
    UNKNOWN
}
