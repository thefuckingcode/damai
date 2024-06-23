package androidx.activity.contextaware;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
public interface ContextAware {
    void addOnContextAvailableListener(@NonNull OnContextAvailableListener onContextAvailableListener);

    @Nullable
    Context peekAvailableContext();

    void removeOnContextAvailableListener(@NonNull OnContextAvailableListener onContextAvailableListener);
}
