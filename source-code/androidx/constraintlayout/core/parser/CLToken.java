package androidx.constraintlayout.core.parser;

import tb.jl1;

/* compiled from: Taobao */
public class CLToken extends CLElement {
    int index = 0;
    char[] tokenFalse = "false".toCharArray();
    char[] tokenNull = "null".toCharArray();
    char[] tokenTrue = "true".toCharArray();
    Type type = Type.UNKNOWN;

    /* access modifiers changed from: package-private */
    /* renamed from: androidx.constraintlayout.core.parser.CLToken$1  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type = iArr;
            iArr[Type.TRUE.ordinal()] = 1;
            $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type[Type.FALSE.ordinal()] = 2;
            $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type[Type.NULL.ordinal()] = 3;
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type[Type.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public enum Type {
        UNKNOWN,
        TRUE,
        FALSE,
        NULL
    }

    public CLToken(char[] cArr) {
        super(cArr);
    }

    public static CLElement allocate(char[] cArr) {
        return new CLToken(cArr);
    }

    public boolean getBoolean() throws CLParsingException {
        Type type2 = this.type;
        if (type2 == Type.TRUE) {
            return true;
        }
        if (type2 == Type.FALSE) {
            return false;
        }
        throw new CLParsingException("this token is not a boolean: <" + content() + jl1.G, this);
    }

    public Type getType() {
        return this.type;
    }

    public boolean isNull() throws CLParsingException {
        if (this.type == Type.NULL) {
            return true;
        }
        throw new CLParsingException("this token is not a null: <" + content() + jl1.G, this);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        addIndent(sb, i);
        sb.append(content());
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        if (!CLParser.DEBUG) {
            return content();
        }
        return jl1.L + content() + jl1.G;
    }

    public boolean validate(char c, long j) {
        int i = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type[this.type.ordinal()];
        boolean z = false;
        if (i == 1) {
            char[] cArr = this.tokenTrue;
            int i2 = this.index;
            if (cArr[i2] == c) {
                z = true;
            }
            if (z && i2 + 1 == cArr.length) {
                setEnd(j);
            }
        } else if (i == 2) {
            char[] cArr2 = this.tokenFalse;
            int i3 = this.index;
            if (cArr2[i3] == c) {
                z = true;
            }
            if (z && i3 + 1 == cArr2.length) {
                setEnd(j);
            }
        } else if (i == 3) {
            char[] cArr3 = this.tokenNull;
            int i4 = this.index;
            if (cArr3[i4] == c) {
                z = true;
            }
            if (z && i4 + 1 == cArr3.length) {
                setEnd(j);
            }
        } else if (i == 4) {
            char[] cArr4 = this.tokenTrue;
            int i5 = this.index;
            if (cArr4[i5] == c) {
                this.type = Type.TRUE;
            } else if (this.tokenFalse[i5] == c) {
                this.type = Type.FALSE;
            } else if (this.tokenNull[i5] == c) {
                this.type = Type.NULL;
            }
            z = true;
        }
        this.index++;
        return z;
    }
}
