package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Modifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner;
import org.jetbrains.annotations.NotNull;
import tb.c41;
import tb.d41;
import tb.e41;
import tb.k21;
import tb.pw2;
import tb.qw2;

/* compiled from: Taobao */
public interface ReflectJavaModifierListOwner extends JavaModifierListOwner {

    /* compiled from: Taobao */
    public static final class a {
        @NotNull
        public static qw2 a(@NotNull ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            k21.i(reflectJavaModifierListOwner, "this");
            int modifiers = reflectJavaModifierListOwner.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                return pw2.h.INSTANCE;
            }
            if (Modifier.isPrivate(modifiers)) {
                return pw2.e.INSTANCE;
            }
            if (!Modifier.isProtected(modifiers)) {
                return c41.INSTANCE;
            }
            if (Modifier.isStatic(modifiers)) {
                return e41.INSTANCE;
            }
            return d41.INSTANCE;
        }

        public static boolean b(@NotNull ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            k21.i(reflectJavaModifierListOwner, "this");
            return Modifier.isAbstract(reflectJavaModifierListOwner.getModifiers());
        }

        public static boolean c(@NotNull ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            k21.i(reflectJavaModifierListOwner, "this");
            return Modifier.isFinal(reflectJavaModifierListOwner.getModifiers());
        }

        public static boolean d(@NotNull ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            k21.i(reflectJavaModifierListOwner, "this");
            return Modifier.isStatic(reflectJavaModifierListOwner.getModifiers());
        }
    }

    int getModifiers();
}
