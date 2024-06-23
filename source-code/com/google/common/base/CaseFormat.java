package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.taobao.weex.annotation.JSMethod;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.jh;
import tb.jl1;
import tb.z7;

@GwtCompatible
/* compiled from: Taobao */
public enum CaseFormat {
    LOWER_HYPHEN(jh.e('-'), "-") {
        /* access modifiers changed from: package-private */
        @Override // com.google.common.base.CaseFormat
        public String convert(CaseFormat caseFormat, String str) {
            if (caseFormat == CaseFormat.LOWER_UNDERSCORE) {
                return str.replace('-', '_');
            }
            if (caseFormat == CaseFormat.UPPER_UNDERSCORE) {
                return z7.e(str.replace('-', '_'));
            }
            return CaseFormat.super.convert(caseFormat, str);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.base.CaseFormat
        public String normalizeWord(String str) {
            return z7.c(str);
        }
    },
    LOWER_UNDERSCORE(jh.e('_'), JSMethod.NOT_SET) {
        /* access modifiers changed from: package-private */
        @Override // com.google.common.base.CaseFormat
        public String convert(CaseFormat caseFormat, String str) {
            if (caseFormat == CaseFormat.LOWER_HYPHEN) {
                return str.replace('_', '-');
            }
            if (caseFormat == CaseFormat.UPPER_UNDERSCORE) {
                return z7.e(str);
            }
            return CaseFormat.super.convert(caseFormat, str);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.base.CaseFormat
        public String normalizeWord(String str) {
            return z7.c(str);
        }
    },
    LOWER_CAMEL(jh.c(YKUpsConvert.CHAR_A, 'Z'), "") {
        /* access modifiers changed from: package-private */
        @Override // com.google.common.base.CaseFormat
        public String normalizeFirstWord(String str) {
            return z7.c(str);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.base.CaseFormat
        public String normalizeWord(String str) {
            return CaseFormat.firstCharOnlyToUpper(str);
        }
    },
    UPPER_CAMEL(jh.c(YKUpsConvert.CHAR_A, 'Z'), "") {
        /* access modifiers changed from: package-private */
        @Override // com.google.common.base.CaseFormat
        public String normalizeWord(String str) {
            return CaseFormat.firstCharOnlyToUpper(str);
        }
    },
    UPPER_UNDERSCORE(jh.e('_'), JSMethod.NOT_SET) {
        /* access modifiers changed from: package-private */
        @Override // com.google.common.base.CaseFormat
        public String convert(CaseFormat caseFormat, String str) {
            if (caseFormat == CaseFormat.LOWER_HYPHEN) {
                return z7.c(str.replace('_', '-'));
            }
            if (caseFormat == CaseFormat.LOWER_UNDERSCORE) {
                return z7.c(str);
            }
            return CaseFormat.super.convert(caseFormat, str);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.base.CaseFormat
        public String normalizeWord(String str) {
            return z7.e(str);
        }
    };
    
    private final jh wordBoundary;
    private final String wordSeparator;

    /* compiled from: Taobao */
    private static final class StringConverter extends Converter<String, String> implements Serializable {
        private static final long serialVersionUID = 0;
        private final CaseFormat sourceFormat;
        private final CaseFormat targetFormat;

        StringConverter(CaseFormat caseFormat, CaseFormat caseFormat2) {
            this.sourceFormat = (CaseFormat) ds1.p(caseFormat);
            this.targetFormat = (CaseFormat) ds1.p(caseFormat2);
        }

        @Override // com.google.common.base.Function, com.google.common.base.Converter
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof StringConverter)) {
                return false;
            }
            StringConverter stringConverter = (StringConverter) obj;
            if (!this.sourceFormat.equals(stringConverter.sourceFormat) || !this.targetFormat.equals(stringConverter.targetFormat)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.sourceFormat.hashCode() ^ this.targetFormat.hashCode();
        }

        public String toString() {
            return this.sourceFormat + ".converterTo(" + this.targetFormat + jl1.BRACKET_END_STR;
        }

        /* access modifiers changed from: protected */
        public String doBackward(String str) {
            return this.targetFormat.to(this.sourceFormat, str);
        }

        /* access modifiers changed from: protected */
        public String doForward(String str) {
            return this.sourceFormat.to(this.targetFormat, str);
        }
    }

    /* access modifiers changed from: private */
    public static String firstCharOnlyToUpper(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return z7.d(str.charAt(0)) + z7.c(str.substring(1));
    }

    /* access modifiers changed from: package-private */
    public String convert(CaseFormat caseFormat, String str) {
        StringBuilder sb = null;
        int i = 0;
        int i2 = -1;
        while (true) {
            i2 = this.wordBoundary.d(str, i2 + 1);
            if (i2 == -1) {
                break;
            }
            if (i == 0) {
                sb = new StringBuilder(str.length() + (this.wordSeparator.length() * 4));
                sb.append(caseFormat.normalizeFirstWord(str.substring(i, i2)));
            } else {
                sb.append(caseFormat.normalizeWord(str.substring(i, i2)));
            }
            sb.append(caseFormat.wordSeparator);
            i = this.wordSeparator.length() + i2;
        }
        if (i == 0) {
            return caseFormat.normalizeFirstWord(str);
        }
        sb.append(caseFormat.normalizeWord(str.substring(i)));
        return sb.toString();
    }

    public Converter<String, String> converterTo(CaseFormat caseFormat) {
        return new StringConverter(this, caseFormat);
    }

    /* access modifiers changed from: package-private */
    public String normalizeFirstWord(String str) {
        return normalizeWord(str);
    }

    /* access modifiers changed from: package-private */
    public abstract String normalizeWord(String str);

    public final String to(CaseFormat caseFormat, String str) {
        ds1.p(caseFormat);
        ds1.p(str);
        return caseFormat == this ? str : convert(caseFormat, str);
    }

    private CaseFormat(jh jhVar, String str) {
        this.wordBoundary = jhVar;
        this.wordSeparator = str;
    }
}
