package kotlin.text;

import com.taobao.weex.bridge.WXBridgeManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.ExperimentalStdlibApi;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.collections.l;
import kotlin.collections.r;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.ww1;

/* compiled from: Taobao */
public final class Regex implements Serializable {
    @NotNull
    public static final a Companion = new a(null);
    @Nullable
    private Set<? extends RegexOption> _options;
    @NotNull
    private final Pattern nativePattern;

    /* compiled from: Taobao */
    private static final class Serialized implements Serializable {
        @NotNull
        public static final a Companion = new a(null);
        private static final long serialVersionUID = 0;
        private final int flags;
        @NotNull
        private final String pattern;

        /* compiled from: Taobao */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(m40 m40) {
                this();
            }
        }

        public Serialized(@NotNull String str, int i) {
            k21.i(str, "pattern");
            this.pattern = str;
            this.flags = i;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.pattern, this.flags);
            k21.h(compile, "compile(pattern, flags)");
            return new Regex(compile);
        }

        public final int getFlags() {
            return this.flags;
        }

        @NotNull
        public final String getPattern() {
            return this.pattern;
        }
    }

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final int b(int i) {
            return (i & 2) != 0 ? i | 64 : i;
        }
    }

    @PublishedApi
    public Regex(@NotNull Pattern pattern) {
        k21.i(pattern, "nativePattern");
        this.nativePattern = pattern;
    }

    public static /* synthetic */ MatchResult find$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.find(charSequence, i);
    }

    public static /* synthetic */ Sequence findAll$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.findAll(charSequence, i);
    }

    public static /* synthetic */ List split$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.split(charSequence, i);
    }

    public static /* synthetic */ Sequence splitToSequence$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.splitToSequence(charSequence, i);
    }

    private final Object writeReplace() {
        String pattern = this.nativePattern.pattern();
        k21.h(pattern, "nativePattern.pattern()");
        return new Serialized(pattern, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(@NotNull CharSequence charSequence) {
        k21.i(charSequence, "input");
        return this.nativePattern.matcher(charSequence).find();
    }

    @Nullable
    public final MatchResult find(@NotNull CharSequence charSequence, int i) {
        k21.i(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        k21.h(matcher, "nativePattern.matcher(input)");
        return e.a(matcher, i, charSequence);
    }

    @NotNull
    public final Sequence<MatchResult> findAll(@NotNull CharSequence charSequence, int i) {
        k21.i(charSequence, "input");
        if (i >= 0 && i <= charSequence.length()) {
            return SequencesKt__SequencesKt.j(new Regex$findAll$1(this, charSequence, i), Regex$findAll$2.INSTANCE);
        }
        throw new IndexOutOfBoundsException("Start index out of bounds: " + i + ", input length: " + charSequence.length());
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.Set<? extends kotlin.text.RegexOption>, java.util.Set<kotlin.text.RegexOption> */
    @NotNull
    public final Set<RegexOption> getOptions() {
        Set set = this._options;
        if (set != null) {
            return set;
        }
        int flags = this.nativePattern.flags();
        EnumSet allOf = EnumSet.allOf(RegexOption.class);
        k21.h(allOf, "");
        boolean unused = r.z(allOf, new Regex$special$$inlined$fromInt$1(flags));
        Set<RegexOption> unmodifiableSet = Collections.unmodifiableSet(allOf);
        k21.h(unmodifiableSet, "unmodifiableSet(EnumSet.…mask == it.value }\n    })");
        this._options = unmodifiableSet;
        return unmodifiableSet;
    }

    @NotNull
    public final String getPattern() {
        String pattern = this.nativePattern.pattern();
        k21.h(pattern, "nativePattern.pattern()");
        return pattern;
    }

    @SinceKotlin(version = "1.7")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public final MatchResult matchAt(@NotNull CharSequence charSequence, int i) {
        k21.i(charSequence, "input");
        Matcher region = this.nativePattern.matcher(charSequence).useAnchoringBounds(false).useTransparentBounds(true).region(i, charSequence.length());
        if (!region.lookingAt()) {
            return null;
        }
        k21.h(region, "this");
        return new MatcherMatchResult(region, charSequence);
    }

    @Nullable
    public final MatchResult matchEntire(@NotNull CharSequence charSequence) {
        k21.i(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        k21.h(matcher, "nativePattern.matcher(input)");
        return e.b(matcher, charSequence);
    }

    public final boolean matches(@NotNull CharSequence charSequence) {
        k21.i(charSequence, "input");
        return this.nativePattern.matcher(charSequence).matches();
    }

    @SinceKotlin(version = "1.7")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public final boolean matchesAt(@NotNull CharSequence charSequence, int i) {
        k21.i(charSequence, "input");
        return this.nativePattern.matcher(charSequence).useAnchoringBounds(false).useTransparentBounds(true).region(i, charSequence.length()).lookingAt();
    }

    @NotNull
    public final String replace(@NotNull CharSequence charSequence, @NotNull String str) {
        k21.i(charSequence, "input");
        k21.i(str, "replacement");
        String replaceAll = this.nativePattern.matcher(charSequence).replaceAll(str);
        k21.h(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    @NotNull
    public final String replaceFirst(@NotNull CharSequence charSequence, @NotNull String str) {
        k21.i(charSequence, "input");
        k21.i(str, "replacement");
        String replaceFirst = this.nativePattern.matcher(charSequence).replaceFirst(str);
        k21.h(replaceFirst, "nativePattern.matcher(in…replaceFirst(replacement)");
        return replaceFirst;
    }

    @NotNull
    public final List<String> split(@NotNull CharSequence charSequence, int i) {
        k21.i(charSequence, "input");
        StringsKt__StringsKt.w0(i);
        Matcher matcher = this.nativePattern.matcher(charSequence);
        if (i == 1 || !matcher.find()) {
            return l.e(charSequence.toString());
        }
        int i2 = 10;
        if (i > 0) {
            i2 = ww1.d(i, 10);
        }
        ArrayList arrayList = new ArrayList(i2);
        int i3 = 0;
        int i4 = i - 1;
        do {
            arrayList.add(charSequence.subSequence(i3, matcher.start()).toString());
            i3 = matcher.end();
            if (i4 >= 0 && arrayList.size() == i4) {
                break;
            }
        } while (matcher.find());
        arrayList.add(charSequence.subSequence(i3, charSequence.length()).toString());
        return arrayList;
    }

    @SinceKotlin(version = "1.6")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public final Sequence<String> splitToSequence(@NotNull CharSequence charSequence, int i) {
        k21.i(charSequence, "input");
        StringsKt__StringsKt.w0(i);
        return e.b(new Regex$splitToSequence$1(this, charSequence, i, null));
    }

    @NotNull
    public final Pattern toPattern() {
        return this.nativePattern;
    }

    @NotNull
    public String toString() {
        String pattern = this.nativePattern.toString();
        k21.h(pattern, "nativePattern.toString()");
        return pattern;
    }

    @NotNull
    public final String replace(@NotNull CharSequence charSequence, @NotNull Function1<? super MatchResult, ? extends CharSequence> function1) {
        k21.i(charSequence, "input");
        k21.i(function1, "transform");
        int i = 0;
        MatchResult find$default = find$default(this, charSequence, 0, 2, null);
        if (find$default == null) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            sb.append(charSequence, i, find$default.getRange().getStart().intValue());
            sb.append((CharSequence) function1.invoke(find$default));
            i = find$default.getRange().getEndInclusive().intValue() + 1;
            find$default = find$default.next();
            if (i >= length) {
                break;
            }
        } while (find$default != null);
        if (i < length) {
            sb.append(charSequence, i, length);
        }
        String sb2 = sb.toString();
        k21.h(sb2, "sb.toString()");
        return sb2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public Regex(@NotNull String str) {
        this(r2);
        k21.i(str, "pattern");
        Pattern compile = Pattern.compile(str);
        k21.h(compile, "compile(pattern)");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public Regex(@NotNull String str, @NotNull RegexOption regexOption) {
        this(r2);
        k21.i(str, "pattern");
        k21.i(regexOption, "option");
        Pattern compile = Pattern.compile(str, Companion.b(regexOption.getValue()));
        k21.h(compile, "compile(pattern, ensureUnicodeCase(option.value))");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public Regex(@NotNull String str, @NotNull Set<? extends RegexOption> set) {
        this(r2);
        k21.i(str, "pattern");
        k21.i(set, WXBridgeManager.OPTIONS);
        Pattern compile = Pattern.compile(str, Companion.b(e.e(set)));
        k21.h(compile, "compile(pattern, ensureU…odeCase(options.toInt()))");
    }
}
