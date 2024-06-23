package androidx.activity;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;

/* compiled from: Taobao */
public interface OnBackPressedDispatcherOwner extends LifecycleOwner {
    @NonNull
    OnBackPressedDispatcher getOnBackPressedDispatcher();
}
