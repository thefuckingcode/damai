package androidx.core.util;

import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u00012\b\u0010\u0007\u001a\u0004\u0018\u00018\u0001H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", "K", "V", "", "<anonymous parameter 0>", "<anonymous parameter 1>", "<anonymous parameter 2>", "<anonymous parameter 3>", "Ltb/ur2;", "invoke", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class LruCacheKt$lruCache$3 extends Lambda implements Function4<Boolean, K, V, V, ur2> {
    public static final LruCacheKt$lruCache$3 INSTANCE = new LruCacheKt$lruCache$3();

    public LruCacheKt$lruCache$3() {
        super(4);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ ur2 invoke(Boolean bool, Object obj, Object obj2, Object obj3) {
        invoke(bool.booleanValue(), obj, obj2, obj3);
        return ur2.INSTANCE;
    }

    public final void invoke(boolean z, @NotNull K k, @NotNull V v, @Nullable V v2) {
        k21.i(k, "<anonymous parameter 1>");
        k21.i(v, "<anonymous parameter 2>");
    }
}
