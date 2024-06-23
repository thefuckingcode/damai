package kotlin.reflect.jvm.internal.impl.resolve;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.collections.k;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.bc2;
import tb.k21;

/* compiled from: Taobao */
public final class OverridingUtilsKt {
    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.Collection<? extends H> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <H> Collection<H> a(@NotNull Collection<? extends H> collection, @NotNull Function1<? super H, ? extends CallableDescriptor> function1) {
        k21.i(collection, "<this>");
        k21.i(function1, "descriptorByHandle");
        if (collection.size() <= 1) {
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        bc2 a = bc2.Companion.a();
        while (!linkedList.isEmpty()) {
            Object P = k.P(linkedList);
            bc2 a2 = bc2.Companion.a();
            Collection<? super H> s = OverridingUtil.s(P, linkedList, function1, new OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1(a2));
            k21.h(s, "val conflictedHandles = SmartSet.create<H>()\n\n        val overridableGroup =\n            OverridingUtil.extractMembersOverridableInBothWays(nextHandle, queue, descriptorByHandle) { conflictedHandles.add(it) }");
            if (s.size() != 1 || !a2.isEmpty()) {
                Object obj = (Object) OverridingUtil.O(s, function1);
                k21.h(obj, "selectMostSpecificMember(overridableGroup, descriptorByHandle)");
                CallableDescriptor callableDescriptor = (CallableDescriptor) function1.invoke(obj);
                for (Object obj2 : s) {
                    k21.h(obj2, AdvanceSetting.NETWORK_TYPE);
                    if (!OverridingUtil.E(callableDescriptor, (CallableDescriptor) function1.invoke(obj2))) {
                        a2.add(obj2);
                    }
                }
                if (!a2.isEmpty()) {
                    a.addAll(a2);
                }
                a.add(obj);
            } else {
                Object n0 = k.n0(s);
                k21.h(n0, "overridableGroup.single()");
                a.add(n0);
            }
        }
        return a;
    }
}
