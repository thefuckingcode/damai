package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlinx.coroutines.internal.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.jh2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b`\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J)\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00028\u00002\u000e\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/channels/ReceiveOrClosed;", ExifInterface.LONGITUDE_EAST, "", "value", "Lkotlinx/coroutines/internal/b$d;", "Lkotlinx/coroutines/internal/PrepareOp;", "otherOp", "Ltb/jh2;", "tryResumeReceive", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/b$d;)Ltb/jh2;", "Ltb/ur2;", "completeResumeReceive", "(Ljava/lang/Object;)V", "getOfferResult", "()Ljava/lang/Object;", "offerResult", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public interface ReceiveOrClosed<E> {
    void completeResumeReceive(E e);

    @NotNull
    Object getOfferResult();

    @Nullable
    jh2 tryResumeReceive(E e, @Nullable b.d dVar);
}
