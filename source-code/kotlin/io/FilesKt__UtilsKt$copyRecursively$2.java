package kotlin.io;

import java.io.File;
import java.io.IOException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.ur2;

/* compiled from: Taobao */
final class FilesKt__UtilsKt$copyRecursively$2 extends Lambda implements Function2<File, IOException, ur2> {
    final /* synthetic */ Function2<File, IOException, OnErrorAction> $onError;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.jvm.functions.Function2<? super java.io.File, ? super java.io.IOException, ? extends kotlin.io.OnErrorAction> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FilesKt__UtilsKt$copyRecursively$2(Function2<? super File, ? super IOException, ? extends OnErrorAction> function2) {
        super(2);
        this.$onError = function2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ ur2 invoke(File file, IOException iOException) {
        invoke(file, iOException);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull File file, @NotNull IOException iOException) {
        k21.i(file, "f");
        k21.i(iOException, "e");
        if (this.$onError.invoke(file, iOException) == OnErrorAction.TERMINATE) {
            throw new TerminateException(file);
        }
    }
}
