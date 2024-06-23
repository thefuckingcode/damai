package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b60;
import tb.k21;
import tb.og1;

public interface ResolutionScope {

    public static final class a {
        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Collection a(ResolutionScope resolutionScope, b60 b60, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    b60 = b60.ALL;
                }
                Function1<og1, Boolean> function12 = function1;
                if ((i & 2) != 0) {
                    function12 = MemberScope.Companion.a();
                }
                return resolutionScope.getContributedDescriptors(b60, function12);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContributedDescriptors");
        }

        public static void b(ResolutionScope resolutionScope, og1 og1, LookupLocation lookupLocation) {
            k21.i(resolutionScope, "this");
            k21.i(og1, "name");
            k21.i(lookupLocation, "location");
            resolutionScope.getContributedFunctions(og1, lookupLocation);
        }
    }

    @Nullable
    ClassifierDescriptor getContributedClassifier(@NotNull og1 og1, @NotNull LookupLocation lookupLocation);

    @NotNull
    Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull b60 b60, @NotNull Function1<? super og1, Boolean> function1);

    @NotNull
    Collection<? extends FunctionDescriptor> getContributedFunctions(@NotNull og1 og1, @NotNull LookupLocation lookupLocation);

    void recordLookup(@NotNull og1 og1, @NotNull LookupLocation lookupLocation);
}
