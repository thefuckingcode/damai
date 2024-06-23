package kotlin.text.jdk8;

import com.lzy.okgo.cookie.SerializableCookie;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchNamedGroupCollection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0005"}, d2 = {"get", "Lkotlin/text/MatchGroup;", "Lkotlin/text/MatchGroupCollection;", SerializableCookie.NAME, "", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 1, 16}, pn = "kotlin.text")
/* compiled from: RegexExtensions.kt */
public final class RegexExtensionsJDK8Kt {
    public static final MatchGroup get(MatchGroupCollection matchGroupCollection, String str) {
        Intrinsics.checkParameterIsNotNull(matchGroupCollection, "$this$get");
        Intrinsics.checkParameterIsNotNull(str, SerializableCookie.NAME);
        if (!(matchGroupCollection instanceof MatchNamedGroupCollection)) {
            matchGroupCollection = null;
        }
        MatchNamedGroupCollection matchNamedGroupCollection = (MatchNamedGroupCollection) matchGroupCollection;
        if (matchNamedGroupCollection != null) {
            return matchNamedGroupCollection.get(str);
        }
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }
}
