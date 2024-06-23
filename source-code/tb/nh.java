package tb;

import java.util.Arrays;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class nh extends b21<Character> {
    public nh(char c) {
        super(Character.valueOf(c));
    }

    private final String c(char c) {
        if (c == '\b') {
            return "\\b";
        }
        if (c == '\t') {
            return "\\t";
        }
        if (c == '\n') {
            return "\\n";
        }
        if (c == '\f') {
            return "\\f";
        }
        if (c == '\r') {
            return "\\r";
        }
        return e(c) ? String.valueOf(c) : "?";
    }

    private final boolean e(char c) {
        byte type = (byte) Character.getType(c);
        return (type == 0 || type == 13 || type == 14 || type == 15 || type == 16 || type == 18 || type == 19) ? false : true;
    }

    @NotNull
    /* renamed from: d */
    public ib2 a(@NotNull ModuleDescriptor moduleDescriptor) {
        k21.i(moduleDescriptor, "module");
        ib2 u = moduleDescriptor.getBuiltIns().u();
        k21.h(u, "module.builtIns.charType");
        return u;
    }

    @Override // tb.om
    @NotNull
    public String toString() {
        String format = String.format("\\u%04X ('%s')", Arrays.copyOf(new Object[]{Integer.valueOf(((Character) b()).charValue()), c(((Character) b()).charValue())}, 2));
        k21.h(format, "java.lang.String.format(this, *args)");
        return format;
    }
}
