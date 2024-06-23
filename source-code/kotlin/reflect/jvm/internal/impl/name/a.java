package kotlin.reflect.jvm.internal.impl.name;

import com.taobao.weex.common.Constants;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.en0;
import tb.k21;

/* compiled from: Taobao */
public final class a {

    /* renamed from: kotlin.reflect.jvm.internal.impl.name.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public /* synthetic */ class C0279a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            iArr[State.BEGINNING.ordinal()] = 1;
            iArr[State.AFTER_DOT.ordinal()] = 2;
            iArr[State.MIDDLE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final boolean a(String str, String str2) {
        return (o.L(str, str2, false, 2, null)) && str.charAt(str2.length()) == '.';
    }

    public static final boolean b(@NotNull en0 en0, @NotNull en0 en02) {
        k21.i(en0, "<this>");
        k21.i(en02, "packageName");
        if (k21.d(en0, en02) || en02.d()) {
            return true;
        }
        String b = en0.b();
        k21.h(b, "this.asString()");
        String b2 = en02.b();
        k21.h(b2, "packageName.asString()");
        return a(b, b2);
    }

    public static final boolean c(@Nullable String str) {
        if (str == null) {
            return false;
        }
        State state = State.BEGINNING;
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            i++;
            int i2 = C0279a.$EnumSwitchMapping$0[state.ordinal()];
            if (i2 == 1 || i2 == 2) {
                if (!Character.isJavaIdentifierPart(charAt)) {
                    return false;
                }
                state = State.MIDDLE;
            } else if (i2 != 3) {
                continue;
            } else if (charAt == '.') {
                state = State.AFTER_DOT;
            } else if (!Character.isJavaIdentifierPart(charAt)) {
                return false;
            }
        }
        if (state != State.AFTER_DOT) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final en0 d(@NotNull en0 en0, @NotNull en0 en02) {
        k21.i(en0, "<this>");
        k21.i(en02, Constants.Name.PREFIX);
        if (!b(en0, en02) || en02.d()) {
            return en0;
        }
        if (k21.d(en0, en02)) {
            en0 en03 = en0.ROOT;
            k21.h(en03, "ROOT");
            return en03;
        }
        String b = en0.b();
        k21.h(b, "asString()");
        String substring = b.substring(en02.b().length() + 1);
        k21.h(substring, "(this as java.lang.String).substring(startIndex)");
        return new en0(substring);
    }
}
