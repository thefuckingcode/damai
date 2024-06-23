package com.taobao.weex.utils;

import androidx.annotation.NonNull;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import tb.jl1;

/* compiled from: Taobao */
public class FunctionParser<K, V> {
    public static final char SPACE = ' ';
    private Mapper<K, V> a;
    private Lexer b;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class Lexer {
        private String a;
        private Token b;
        private String c;
        private int d;

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private Token e() {
            return this.b;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private String f() {
            return this.c;
        }

        private boolean g(char c2) {
            return ('0' <= c2 && c2 <= '9') || ('a' <= c2 && c2 <= 'z') || ('A' <= c2 && c2 <= 'Z');
        }

        private boolean h(CharSequence charSequence) {
            for (int i = 0; i < charSequence.length(); i++) {
                char charAt = charSequence.charAt(i);
                if (('a' > charAt || charAt > 'z') && (('A' > charAt || charAt > 'Z') && charAt != '-')) {
                    return false;
                }
            }
            return true;
        }

        private void i(String str) {
            if (jl1.BRACKET_START_STR.equals(str)) {
                this.b = Token.LEFT_PARENT;
                this.c = jl1.BRACKET_START_STR;
            } else if (jl1.BRACKET_END_STR.equals(str)) {
                this.b = Token.RIGHT_PARENT;
                this.c = jl1.BRACKET_END_STR;
            } else if (",".equals(str)) {
                this.b = Token.COMMA;
                this.c = ",";
            } else if (h(str)) {
                this.b = Token.FUNC_NAME;
                this.c = str;
            } else {
                this.b = Token.PARAM_VALUE;
                this.c = str;
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private boolean j() {
            int i = this.d;
            while (true) {
                if (this.d >= this.a.length()) {
                    break;
                }
                char charAt = this.a.charAt(this.d);
                if (charAt == ' ') {
                    int i2 = this.d;
                    this.d = i2 + 1;
                    if (i != i2) {
                        break;
                    }
                    i++;
                } else if (g(charAt) || charAt == '.' || charAt == '%' || charAt == '-' || charAt == '+') {
                    this.d++;
                } else {
                    int i3 = this.d;
                    if (i == i3) {
                        this.d = i3 + 1;
                    }
                }
            }
            int i4 = this.d;
            if (i != i4) {
                i(this.a.substring(i, i4));
                return true;
            }
            this.b = null;
            this.c = null;
            return false;
        }

        private Lexer(String str) {
            this.d = 0;
            this.a = str;
        }
    }

    /* compiled from: Taobao */
    public interface Mapper<K, V> {
        Map<K, V> map(String str, List<String> list);
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public enum Token {
        FUNC_NAME,
        PARAM_VALUE,
        LEFT_PARENT,
        RIGHT_PARENT,
        COMMA
    }

    /* compiled from: Taobao */
    private static class WXInterpretationException extends RuntimeException {
        private WXInterpretationException(String str) {
            super(str);
        }
    }

    public FunctionParser(@NonNull String str, @NonNull Mapper<K, V> mapper) {
        this.b = new Lexer(str);
        this.a = mapper;
    }

    private LinkedHashMap<K, V> a() {
        LinkedHashMap<K, V> linkedHashMap = new LinkedHashMap<>();
        do {
            linkedHashMap.putAll(b());
        } while (this.b.e() == Token.FUNC_NAME);
        return linkedHashMap;
    }

    private Map<K, V> b() {
        LinkedList linkedList = new LinkedList();
        String c = c(Token.FUNC_NAME);
        c(Token.LEFT_PARENT);
        linkedList.add(c(Token.PARAM_VALUE));
        while (true) {
            Token e = this.b.e();
            Token token = Token.COMMA;
            if (e == token) {
                c(token);
                linkedList.add(c(Token.PARAM_VALUE));
            } else {
                c(Token.RIGHT_PARENT);
                return this.a.map(c, linkedList);
            }
        }
    }

    private String c(Token token) {
        try {
            if (token != this.b.e()) {
                return "";
            }
            String f = this.b.f();
            this.b.j();
            return f;
        } catch (Exception unused) {
            WXLogUtils.e(token + "Token doesn't match" + this.b.a);
            return "";
        }
    }

    public LinkedHashMap<K, V> parse() {
        this.b.j();
        return a();
    }
}
