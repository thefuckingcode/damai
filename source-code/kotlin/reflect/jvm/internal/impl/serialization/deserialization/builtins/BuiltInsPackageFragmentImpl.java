package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.io.InputStream;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: BuiltInsPackageFragmentImpl.kt */
public final class BuiltInsPackageFragmentImpl extends DeserializedPackageFragmentImpl implements BuiltInsPackageFragment {
    public static final Companion Companion = new Companion(null);
    private final boolean isFallback;

    public /* synthetic */ BuiltInsPackageFragmentImpl(FqName fqName, StorageManager storageManager, ModuleDescriptor moduleDescriptor, ProtoBuf.PackageFragment packageFragment, BuiltInsBinaryVersion builtInsBinaryVersion, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(fqName, storageManager, moduleDescriptor, packageFragment, builtInsBinaryVersion, z);
    }

    private BuiltInsPackageFragmentImpl(FqName fqName, StorageManager storageManager, ModuleDescriptor moduleDescriptor, ProtoBuf.PackageFragment packageFragment, BuiltInsBinaryVersion builtInsBinaryVersion, boolean z) {
        super(fqName, storageManager, moduleDescriptor, packageFragment, builtInsBinaryVersion, null);
        this.isFallback = z;
    }

    /* compiled from: BuiltInsPackageFragmentImpl.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0083, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0084, code lost:
            kotlin.io.CloseableKt.closeFinally(r1, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0088, code lost:
            throw r0;
         */
        public final BuiltInsPackageFragmentImpl create(FqName fqName, StorageManager storageManager, ModuleDescriptor moduleDescriptor, InputStream inputStream, boolean z) {
            Intrinsics.checkParameterIsNotNull(fqName, "fqName");
            Intrinsics.checkParameterIsNotNull(storageManager, "storageManager");
            Intrinsics.checkParameterIsNotNull(moduleDescriptor, "module");
            Intrinsics.checkParameterIsNotNull(inputStream, "inputStream");
            InputStream inputStream2 = inputStream;
            Throwable th = null;
            InputStream inputStream3 = inputStream2;
            BuiltInsBinaryVersion readFrom = BuiltInsBinaryVersion.Companion.readFrom(inputStream3);
            if (readFrom == null) {
                Intrinsics.throwUninitializedPropertyAccessException("version");
            }
            if (readFrom.isCompatible()) {
                ProtoBuf.PackageFragment parseFrom = ProtoBuf.PackageFragment.parseFrom(inputStream3, BuiltInSerializerProtocol.INSTANCE.getExtensionRegistry());
                CloseableKt.closeFinally(inputStream2, th);
                Intrinsics.checkExpressionValueIsNotNull(parseFrom, "proto");
                return new BuiltInsPackageFragmentImpl(fqName, storageManager, moduleDescriptor, parseFrom, readFrom, z, null);
            }
            throw new UnsupportedOperationException("Kotlin built-in definition format version is not supported: " + "expected " + BuiltInsBinaryVersion.INSTANCE + ", actual " + readFrom + ". " + "Please update Kotlin");
        }
    }
}
