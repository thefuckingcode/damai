package androidx.core.graphics;

import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import com.taobao.weex.ui.component.AbstractEditComponent;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import tb.wj2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0004\u001a\u00020\u0003H\u0002J\t\u0010\u0005\u001a\u00020\u0002H\u0002R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"androidx/core/graphics/RegionKt$iterator$1", "", "Landroid/graphics/Rect;", "", wj2.HAS_NEXT, AbstractEditComponent.ReturnTypes.NEXT, "Landroid/graphics/RegionIterator;", "iterator", "Landroid/graphics/RegionIterator;", "rect", "Landroid/graphics/Rect;", "hasMore", "Z", "core-ktx_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class RegionKt$iterator$1 implements Iterator<Rect>, KMappedMarker {
    final /* synthetic */ Region $this_iterator;
    private boolean hasMore;
    private final RegionIterator iterator;
    private final Rect rect;

    RegionKt$iterator$1(Region region) {
        this.$this_iterator = region;
        RegionIterator regionIterator = new RegionIterator(region);
        this.iterator = regionIterator;
        Rect rect2 = new Rect();
        this.rect = rect2;
        this.hasMore = regionIterator.next(rect2);
    }

    public boolean hasNext() {
        return this.hasMore;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    @NotNull
    public Rect next() {
        if (this.hasMore) {
            Rect rect2 = new Rect(this.rect);
            this.hasMore = this.iterator.next(this.rect);
            return rect2;
        }
        throw new IndexOutOfBoundsException();
    }
}
