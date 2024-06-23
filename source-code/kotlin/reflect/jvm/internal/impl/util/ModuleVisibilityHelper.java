package kotlin.reflect.jvm.internal.impl.util;

import com.youku.live.dago.liveplayback.ApiConstants;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public interface ModuleVisibilityHelper {

    /* compiled from: Taobao */
    public static final class a implements ModuleVisibilityHelper {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper
        public boolean isInFriendModule(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull DeclarationDescriptor declarationDescriptor2) {
            k21.i(declarationDescriptor, ApiConstants.EventParams.WHAT);
            k21.i(declarationDescriptor2, "from");
            return true;
        }
    }

    boolean isInFriendModule(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull DeclarationDescriptor declarationDescriptor2);
}
