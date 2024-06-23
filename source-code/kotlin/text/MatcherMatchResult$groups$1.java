package kotlin.text;

import java.util.Iterator;
import kotlin.collections.AbstractCollection;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.m;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.pb1;
import tb.sq1;
import tb.w11;

/* compiled from: Taobao */
public final class MatcherMatchResult$groups$1 extends AbstractCollection<pb1> implements MatchNamedGroupCollection {
    final /* synthetic */ MatcherMatchResult a;

    MatcherMatchResult$groups$1(MatcherMatchResult matcherMatchResult) {
        this.a = matcherMatchResult;
    }

    @Override // kotlin.collections.AbstractCollection
    public int a() {
        return MatcherMatchResult.a(this.a).groupCount() + 1;
    }

    public /* bridge */ boolean b(pb1 pb1) {
        return super.contains(pb1);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.collections.AbstractCollection
    public final /* bridge */ boolean contains(pb1 pb1) {
        if (!(pb1 == null ? true : pb1 instanceof pb1)) {
            return false;
        }
        return b(pb1);
    }

    @Override // kotlin.text.MatchGroupCollection
    @Nullable
    public pb1 get(int i) {
        w11 d = e.d(MatcherMatchResult.a(this.a), i);
        if (d.getStart().intValue() < 0) {
            return null;
        }
        String group = MatcherMatchResult.a(this.a).group(i);
        k21.h(group, "matchResult.group(index)");
        return new pb1(group, d);
    }

    @Override // kotlin.collections.AbstractCollection
    public boolean isEmpty() {
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<pb1> iterator() {
        return SequencesKt___SequencesKt.v(CollectionsKt___CollectionsKt.I(m.h(this)), new MatcherMatchResult$groups$1$iterator$1(this)).iterator();
    }

    @Override // kotlin.text.MatchNamedGroupCollection
    @Nullable
    public pb1 get(@NotNull String str) {
        k21.i(str, "name");
        return sq1.IMPLEMENTATIONS.c(MatcherMatchResult.a(this.a), str);
    }
}
