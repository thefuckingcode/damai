package kotlin.coroutines;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
final class CombinedContext$toString$1 extends Lambda implements Function2<String, CoroutineContext.Element, String> {
    public static final CombinedContext$toString$1 INSTANCE = new CombinedContext$toString$1();

    CombinedContext$toString$1() {
        super(2);
    }

    @NotNull
    public final String invoke(@NotNull String str, @NotNull CoroutineContext.Element element) {
        k21.i(str, "acc");
        k21.i(element, "element");
        if (str.length() == 0) {
            return element.toString();
        }
        return str + AVFSCacheConstants.COMMA_SEP + element;
    }
}
