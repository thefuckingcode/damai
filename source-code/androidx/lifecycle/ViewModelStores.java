package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

@Deprecated
/* compiled from: Taobao */
public class ViewModelStores {
    private ViewModelStores() {
    }

    @NonNull
    @MainThread
    @Deprecated
    public static ViewModelStore of(@NonNull FragmentActivity fragmentActivity) {
        return fragmentActivity.getViewModelStore();
    }

    @NonNull
    @MainThread
    @Deprecated
    public static ViewModelStore of(@NonNull Fragment fragment) {
        return fragment.getViewModelStore();
    }
}
