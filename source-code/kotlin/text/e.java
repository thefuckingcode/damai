package kotlin.text;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import tb.w11;
import tb.ww1;

public final class e {
    public static final MatchResult f(Matcher matcher, int i, CharSequence charSequence) {
        if (!matcher.find(i)) {
            return null;
        }
        return new MatcherMatchResult(matcher, charSequence);
    }

    public static final MatchResult g(Matcher matcher, CharSequence charSequence) {
        if (!matcher.matches()) {
            return null;
        }
        return new MatcherMatchResult(matcher, charSequence);
    }

    public static final w11 h(MatchResult matchResult) {
        return ww1.h(matchResult.start(), matchResult.end());
    }

    public static final w11 i(MatchResult matchResult, int i) {
        return ww1.h(matchResult.start(i), matchResult.end(i));
    }

    public static final int j(Iterable<? extends FlagEnum> iterable) {
        int i = 0;
        for (FlagEnum flagEnum : iterable) {
            i |= flagEnum.getValue();
        }
        return i;
    }
}
