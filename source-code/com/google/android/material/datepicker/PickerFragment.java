package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public abstract class PickerFragment<S> extends Fragment {
    protected final LinkedHashSet<OnSelectionChangedListener<S>> onSelectionChangedListeners = new LinkedHashSet<>();

    PickerFragment() {
    }

    /* access modifiers changed from: package-private */
    public boolean addOnSelectionChangedListener(OnSelectionChangedListener<S> onSelectionChangedListener) {
        return this.onSelectionChangedListeners.add(onSelectionChangedListener);
    }

    /* access modifiers changed from: package-private */
    public void clearOnSelectionChangedListeners() {
        this.onSelectionChangedListeners.clear();
    }

    /* access modifiers changed from: package-private */
    public abstract DateSelector<S> getDateSelector();

    /* access modifiers changed from: package-private */
    public boolean removeOnSelectionChangedListener(OnSelectionChangedListener<S> onSelectionChangedListener) {
        return this.onSelectionChangedListeners.remove(onSelectionChangedListener);
    }
}
