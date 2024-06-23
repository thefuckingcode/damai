package okhttp3;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

public final class MediaType {
    public static final Companion Companion = new Companion(null);
    private static final Pattern PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    private static final String QUOTED;
    private static final String TOKEN;
    private static final Pattern TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private final String charset;
    private final String mediaType;
    private final String subtype;
    private final String type;

    public static final MediaType get(String str) {
        return Companion.get(str);
    }

    public static final MediaType parse(String str) {
        return Companion.parse(str);
    }

    public final Charset charset() {
        return charset$default(this, null, 1, null);
    }

    private MediaType(String str, String str2, String str3, String str4) {
        this.mediaType = str;
        this.type = str2;
        this.subtype = str3;
        this.charset = str4;
    }

    public /* synthetic */ MediaType(String str, String str2, String str3, String str4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4);
    }

    public final String type() {
        return this.type;
    }

    public final String subtype() {
        return this.subtype;
    }

    public static /* synthetic */ Charset charset$default(MediaType mediaType2, Charset charset2, int i, Object obj) {
        if ((i & 1) != 0) {
            charset2 = null;
        }
        return mediaType2.charset(charset2);
    }

    public final Charset charset(Charset charset2) {
        try {
            String str = this.charset;
            return str != null ? Charset.forName(str) : charset2;
        } catch (IllegalArgumentException unused) {
            return charset2;
        }
    }

    /* renamed from: -deprecated_type */
    public final String m1087deprecated_type() {
        return this.type;
    }

    /* renamed from: -deprecated_subtype */
    public final String m1086deprecated_subtype() {
        return this.subtype;
    }

    public String toString() {
        return this.mediaType;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MediaType) && Intrinsics.areEqual(((MediaType) obj).mediaType, this.mediaType);
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MediaType get(String str) {
            Intrinsics.checkParameterIsNotNull(str, "$this$toMediaType");
            String str2 = str;
            Matcher matcher = MediaType.TYPE_SUBTYPE.matcher(str2);
            if (matcher.lookingAt()) {
                String group = matcher.group(1);
                Intrinsics.checkExpressionValueIsNotNull(group, "typeSubtype.group(1)");
                Locale locale = Locale.US;
                Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.US");
                if (group != null) {
                    String lowerCase = group.toLowerCase(locale);
                    Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    String group2 = matcher.group(2);
                    Intrinsics.checkExpressionValueIsNotNull(group2, "typeSubtype.group(2)");
                    Locale locale2 = Locale.US;
                    Intrinsics.checkExpressionValueIsNotNull(locale2, "Locale.US");
                    if (group2 != null) {
                        String lowerCase2 = group2.toLowerCase(locale2);
                        Intrinsics.checkExpressionValueIsNotNull(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                        Matcher matcher2 = MediaType.PARAMETER.matcher(str2);
                        int end = matcher.end();
                        String str3 = null;
                        while (end < str.length()) {
                            matcher2.region(end, str.length());
                            if (matcher2.lookingAt()) {
                                String group3 = matcher2.group(1);
                                if (group3 == null || !StringsKt.equals(group3, "charset", true)) {
                                    end = matcher2.end();
                                } else {
                                    String group4 = matcher2.group(2);
                                    boolean z = false;
                                    if (group4 == null) {
                                        group4 = matcher2.group(3);
                                        Intrinsics.checkExpressionValueIsNotNull(group4, "parameter.group(3)");
                                    } else if (StringsKt.startsWith$default(group4, "'", false, 2, (Object) null) && StringsKt.endsWith$default(group4, "'", false, 2, (Object) null) && group4.length() > 2) {
                                        group4 = group4.substring(1, group4.length() - 1);
                                        Intrinsics.checkExpressionValueIsNotNull(group4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    }
                                    if (str3 == null || StringsKt.equals(group4, str3, true)) {
                                        z = true;
                                    }
                                    if (z) {
                                        str3 = group4;
                                        end = matcher2.end();
                                    } else {
                                        throw new IllegalArgumentException(("Multiple charsets defined: \"" + str3 + "\" and: \"" + group4 + "\" for: \"" + str + Typography.quote).toString());
                                    }
                                }
                            } else {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Parameter is not formatted correctly: \"");
                                String substring = str.substring(end);
                                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
                                sb.append(substring);
                                sb.append("\" for: \"");
                                sb.append(str);
                                sb.append(Typography.quote);
                                throw new IllegalArgumentException(sb.toString().toString());
                            }
                        }
                        return new MediaType(str, lowerCase, lowerCase2, str3, null);
                    }
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            throw new IllegalArgumentException(("No subtype found for: \"" + str + Typography.quote).toString());
        }

        public final MediaType parse(String str) {
            Intrinsics.checkParameterIsNotNull(str, "$this$toMediaTypeOrNull");
            try {
                return get(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        /* renamed from: -deprecated_get */
        public final MediaType m1088deprecated_get(String str) {
            Intrinsics.checkParameterIsNotNull(str, "mediaType");
            return get(str);
        }

        /* renamed from: -deprecated_parse */
        public final MediaType m1089deprecated_parse(String str) {
            Intrinsics.checkParameterIsNotNull(str, "mediaType");
            return parse(str);
        }
    }
}
