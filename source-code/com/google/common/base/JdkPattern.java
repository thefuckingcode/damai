package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tb.ds1;

@GwtIncompatible
/* compiled from: Taobao */
final class JdkPattern extends b implements Serializable {
    private static final long serialVersionUID = 0;
    private final Pattern pattern;

    /* compiled from: Taobao */
    private static final class a extends a {
        final Matcher a;

        a(Matcher matcher) {
            this.a = (Matcher) ds1.p(matcher);
        }

        @Override // com.google.common.base.a
        public boolean a() {
            return this.a.find();
        }
    }

    JdkPattern(Pattern pattern2) {
        this.pattern = (Pattern) ds1.p(pattern2);
    }

    @Override // com.google.common.base.b
    public int flags() {
        return this.pattern.flags();
    }

    @Override // com.google.common.base.b
    public a matcher(CharSequence charSequence) {
        return new a(this.pattern.matcher(charSequence));
    }

    @Override // com.google.common.base.b
    public String pattern() {
        return this.pattern.pattern();
    }

    @Override // com.google.common.base.b
    public String toString() {
        return this.pattern.toString();
    }
}
