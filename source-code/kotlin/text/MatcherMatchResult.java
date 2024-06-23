package kotlin.text;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.text.MatchResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.s1;
import tb.w11;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class MatcherMatchResult implements MatchResult {
    @NotNull
    private final Matcher a;
    @NotNull
    private final CharSequence b;
    @NotNull
    private final MatchGroupCollection c = new MatcherMatchResult$groups$1(this);
    @Nullable
    private List<String> d;

    /* compiled from: Taobao */
    public static final class a extends s1<String> {
        final /* synthetic */ MatcherMatchResult a;

        a(MatcherMatchResult matcherMatchResult) {
            this.a = matcherMatchResult;
        }

        @Override // kotlin.collections.AbstractCollection
        public int a() {
            return MatcherMatchResult.a(this.a).groupCount() + 1;
        }

        public /* bridge */ boolean b(String str) {
            return super.contains(str);
        }

        @NotNull
        /* renamed from: c */
        public String get(int i) {
            String group = MatcherMatchResult.a(this.a).group(i);
            return group == null ? "" : group;
        }

        @Override // kotlin.collections.AbstractCollection
        public final /* bridge */ boolean contains(Object obj) {
            if (!(obj instanceof String)) {
                return false;
            }
            return b((String) obj);
        }

        public /* bridge */ int d(String str) {
            return super.indexOf(str);
        }

        public /* bridge */ int e(String str) {
            return super.lastIndexOf(str);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // tb.s1
        public final /* bridge */ int indexOf(String str) {
            if (!(str instanceof String)) {
                return -1;
            }
            return d(str);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // tb.s1
        public final /* bridge */ int lastIndexOf(String str) {
            if (!(str instanceof String)) {
                return -1;
            }
            return e(str);
        }
    }

    public MatcherMatchResult(@NotNull Matcher matcher, @NotNull CharSequence charSequence) {
        k21.i(matcher, "matcher");
        k21.i(charSequence, "input");
        this.a = matcher;
        this.b = charSequence;
    }

    public static final /* synthetic */ MatchResult a(MatcherMatchResult matcherMatchResult) {
        return matcherMatchResult.b();
    }

    private final MatchResult b() {
        return this.a;
    }

    @Override // kotlin.text.MatchResult
    @NotNull
    public MatchResult.b getDestructured() {
        return MatchResult.a.a(this);
    }

    @Override // kotlin.text.MatchResult
    @NotNull
    public List<String> getGroupValues() {
        if (this.d == null) {
            this.d = new a(this);
        }
        List<String> list = this.d;
        k21.f(list);
        return list;
    }

    @Override // kotlin.text.MatchResult
    @NotNull
    public MatchGroupCollection getGroups() {
        return this.c;
    }

    @Override // kotlin.text.MatchResult
    @NotNull
    public w11 getRange() {
        return e.h(b());
    }

    @Override // kotlin.text.MatchResult
    @NotNull
    public String getValue() {
        String group = b().group();
        k21.h(group, "matchResult.group()");
        return group;
    }

    @Override // kotlin.text.MatchResult
    @Nullable
    public MatchResult next() {
        int end = b().end() + (b().end() == b().start() ? 1 : 0);
        if (end > this.b.length()) {
            return null;
        }
        Matcher matcher = this.a.pattern().matcher(this.b);
        k21.h(matcher, "matcher.pattern().matcher(input)");
        return e.f(matcher, end, this.b);
    }
}
