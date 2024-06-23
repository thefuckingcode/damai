package kotlinx.coroutines.flow;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
final class j implements SharingStarted {
    @Override // kotlinx.coroutines.flow.SharingStarted
    @NotNull
    public Flow<SharingCommand> command(@NotNull StateFlow<Integer> stateFlow) {
        return c.s(SharingCommand.START);
    }

    @NotNull
    public String toString() {
        return "SharingStarted.Eagerly";
    }
}
