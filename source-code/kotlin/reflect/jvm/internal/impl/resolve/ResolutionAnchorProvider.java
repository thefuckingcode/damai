package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
public interface ResolutionAnchorProvider {
    @NotNull
    public static final a Companion = a.a;

    /* compiled from: Taobao */
    public static final class a {
        static final /* synthetic */ a a = new a();

        /* renamed from: kotlin.reflect.jvm.internal.impl.resolve.ResolutionAnchorProvider$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public static final class C0284a implements ResolutionAnchorProvider {
            C0284a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.resolve.ResolutionAnchorProvider
            @Nullable
            public ModuleDescriptor getResolutionAnchor(@NotNull ModuleDescriptor moduleDescriptor) {
                k21.i(moduleDescriptor, "moduleDescriptor");
                return null;
            }
        }

        static {
            new C0284a();
        }

        private a() {
        }
    }

    @Nullable
    ModuleDescriptor getResolutionAnchor(@NotNull ModuleDescriptor moduleDescriptor);
}
