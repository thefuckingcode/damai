package androidx.core.util;

import android.util.SparseIntArray;
import kotlin.Metadata;
import tb.r11;
import tb.wj2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"androidx/core/util/SparseIntArrayKt$keyIterator$1", "Ltb/r11;", "", wj2.HAS_NEXT, "", "nextInt", "index", "I", "getIndex", "()I", "setIndex", "(I)V", "core-ktx_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class SparseIntArrayKt$keyIterator$1 extends r11 {
    final /* synthetic */ SparseIntArray $this_keyIterator;
    private int index;

    SparseIntArrayKt$keyIterator$1(SparseIntArray sparseIntArray) {
        this.$this_keyIterator = sparseIntArray;
    }

    public final int getIndex() {
        return this.index;
    }

    public boolean hasNext() {
        return this.index < this.$this_keyIterator.size();
    }

    @Override // tb.r11
    public int nextInt() {
        SparseIntArray sparseIntArray = this.$this_keyIterator;
        int i = this.index;
        this.index = i + 1;
        return sparseIntArray.keyAt(i);
    }

    public final void setIndex(int i) {
        this.index = i;
    }
}
