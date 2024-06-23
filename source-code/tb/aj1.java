package tb;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class aj1 extends m60 {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public aj1(@NotNull StorageManager storageManager, @NotNull Function0<? extends List<? extends AnnotationDescriptor>> function0) {
        super(storageManager, function0);
        k21.i(storageManager, "storageManager");
        k21.i(function0, "compute");
    }

    @Override // tb.m60, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        return false;
    }
}
