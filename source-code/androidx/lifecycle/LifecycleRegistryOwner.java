package androidx.lifecycle;

import androidx.annotation.NonNull;

@Deprecated
/* compiled from: Taobao */
public interface LifecycleRegistryOwner extends LifecycleOwner {
    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    LifecycleRegistry getLifecycle();
}
