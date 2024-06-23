package kotlin.text;

import tb.m40;

/* compiled from: Taobao */
public enum RegexOption implements FlagEnum {
    IGNORE_CASE(2, 0, 2, null),
    MULTILINE(8, 0, 2, null),
    LITERAL(16, 0, 2, null),
    UNIX_LINES(1, 0, 2, null),
    COMMENTS(4, 0, 2, null),
    DOT_MATCHES_ALL(32, 0, 2, null),
    CANON_EQ(128, 0, 2, null);
    
    private final int mask;
    private final int value;

    private RegexOption(int i, int i2) {
        this.value = i;
        this.mask = i2;
    }

    @Override // kotlin.text.FlagEnum
    public int getMask() {
        return this.mask;
    }

    @Override // kotlin.text.FlagEnum
    public int getValue() {
        return this.value;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ RegexOption(int i, int i2, int i3, m40 m40) {
        this(i, (i3 & 2) != 0 ? i : i2);
    }
}
