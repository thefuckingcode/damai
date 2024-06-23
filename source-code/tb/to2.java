package tb;

import kotlin.SinceKotlin;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.4")
/* compiled from: Taobao */
public final class to2 implements KTypeParameter {
    @NotNull
    public static final a Companion = new a(null);

    /* compiled from: Taobao */
    public static final class a {

        /* renamed from: tb.to2$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public /* synthetic */ class C0310a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[KVariance.values().length];
                iArr[KVariance.INVARIANT.ordinal()] = 1;
                iArr[KVariance.IN.ordinal()] = 2;
                iArr[KVariance.OUT.ordinal()] = 3;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final String a(@NotNull KTypeParameter kTypeParameter) {
            k21.i(kTypeParameter, "typeParameter");
            StringBuilder sb = new StringBuilder();
            int i = C0310a.$EnumSwitchMapping$0[kTypeParameter.getVariance().ordinal()];
            if (i == 2) {
                sb.append("in ");
            } else if (i == 3) {
                sb.append("out ");
            }
            sb.append(kTypeParameter.getName());
            String sb2 = sb.toString();
            k21.h(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
    }
}
