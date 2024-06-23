package androidx.transition;

import android.util.SparseArray;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class TransitionValuesMaps {
    final SparseArray<View> mIdValues = new SparseArray<>();
    final LongSparseArray<View> mItemIdValues = new LongSparseArray<>();
    final ArrayMap<String, View> mNameValues = new ArrayMap<>();
    final ArrayMap<View, TransitionValues> mViewValues = new ArrayMap<>();

    TransitionValuesMaps() {
    }
}
