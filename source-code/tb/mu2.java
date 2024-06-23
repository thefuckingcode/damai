package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LocationInfo;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.incremental.components.Position;
import kotlin.reflect.jvm.internal.impl.incremental.components.ScopeKind;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class mu2 {
    public static final void a(@NotNull LookupTracker lookupTracker, @NotNull LookupLocation lookupLocation, @NotNull ClassDescriptor classDescriptor, @NotNull og1 og1) {
        LocationInfo location;
        k21.i(lookupTracker, "<this>");
        k21.i(lookupLocation, "from");
        k21.i(classDescriptor, "scopeOwner");
        k21.i(og1, "name");
        if (lookupTracker != LookupTracker.a.INSTANCE && (location = lookupLocation.getLocation()) != null) {
            Position position = lookupTracker.getRequiresPosition() ? location.getPosition() : Position.Companion.a();
            String filePath = location.getFilePath();
            String b = f60.m(classDescriptor).b();
            k21.h(b, "getFqName(scopeOwner).asString()");
            ScopeKind scopeKind = ScopeKind.CLASSIFIER;
            String b2 = og1.b();
            k21.h(b2, "name.asString()");
            lookupTracker.record(filePath, position, b, scopeKind, b2);
        }
    }

    public static final void b(@NotNull LookupTracker lookupTracker, @NotNull LookupLocation lookupLocation, @NotNull PackageFragmentDescriptor packageFragmentDescriptor, @NotNull og1 og1) {
        k21.i(lookupTracker, "<this>");
        k21.i(lookupLocation, "from");
        k21.i(packageFragmentDescriptor, "scopeOwner");
        k21.i(og1, "name");
        String b = packageFragmentDescriptor.getFqName().b();
        k21.h(b, "scopeOwner.fqName.asString()");
        String b2 = og1.b();
        k21.h(b2, "name.asString()");
        c(lookupTracker, lookupLocation, b, b2);
    }

    public static final void c(@NotNull LookupTracker lookupTracker, @NotNull LookupLocation lookupLocation, @NotNull String str, @NotNull String str2) {
        LocationInfo location;
        k21.i(lookupTracker, "<this>");
        k21.i(lookupLocation, "from");
        k21.i(str, "packageFqName");
        k21.i(str2, "name");
        if (lookupTracker != LookupTracker.a.INSTANCE && (location = lookupLocation.getLocation()) != null) {
            lookupTracker.record(location.getFilePath(), lookupTracker.getRequiresPosition() ? location.getPosition() : Position.Companion.a(), str, ScopeKind.PACKAGE, str2);
        }
    }
}
