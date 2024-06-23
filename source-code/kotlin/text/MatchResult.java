package kotlin.text;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.w11;

/* compiled from: Taobao */
public interface MatchResult {

    /* compiled from: Taobao */
    public static final class a {
        @NotNull
        public static b a(@NotNull MatchResult matchResult) {
            return new b(matchResult);
        }
    }

    /* compiled from: Taobao */
    public static final class b {
        @NotNull
        private final MatchResult a;

        public b(@NotNull MatchResult matchResult) {
            k21.i(matchResult, "match");
            this.a = matchResult;
        }

        @NotNull
        public final MatchResult a() {
            return this.a;
        }
    }

    @NotNull
    b getDestructured();

    @NotNull
    List<String> getGroupValues();

    @NotNull
    MatchGroupCollection getGroups();

    @NotNull
    w11 getRange();

    @NotNull
    String getValue();

    @Nullable
    MatchResult next();
}
