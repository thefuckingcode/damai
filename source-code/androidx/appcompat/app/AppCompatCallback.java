package androidx.appcompat.app;

import androidx.annotation.Nullable;
import androidx.appcompat.view.ActionMode;

/* compiled from: Taobao */
public interface AppCompatCallback {
    void onSupportActionModeFinished(ActionMode actionMode);

    void onSupportActionModeStarted(ActionMode actionMode);

    @Nullable
    ActionMode onWindowStartingSupportActionMode(ActionMode.Callback callback);
}
