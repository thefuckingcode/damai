package tb;

import java.io.InputStream;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class kd extends DeserializedPackageFragmentImpl implements BuiltInsPackageFragment {
    @NotNull
    public static final a Companion = new a(null);

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x006f, code lost:
            r11 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0070, code lost:
            tb.dj.a(r13, r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0073, code lost:
            throw r11;
         */
        @NotNull
        public final kd a(@NotNull en0 en0, @NotNull StorageManager storageManager, @NotNull ModuleDescriptor moduleDescriptor, @NotNull InputStream inputStream, boolean z) {
            k21.i(en0, "fqName");
            k21.i(storageManager, "storageManager");
            k21.i(moduleDescriptor, "module");
            k21.i(inputStream, "inputStream");
            jd a = jd.Companion.a(inputStream);
            if (a == null) {
                k21.A("version");
                throw null;
            } else if (a.h()) {
                ProtoBuf$PackageFragment parseFrom = ProtoBuf$PackageFragment.parseFrom(inputStream, id.INSTANCE.e());
                dj.a(inputStream, null);
                k21.h(parseFrom, "proto");
                return new kd(en0, storageManager, moduleDescriptor, parseFrom, a, z, null);
            } else {
                throw new UnsupportedOperationException("Kotlin built-in definition format version is not supported: expected " + jd.INSTANCE + ", actual " + a + ". Please update Kotlin");
            }
        }
    }

    private kd(en0 en0, StorageManager storageManager, ModuleDescriptor moduleDescriptor, ProtoBuf$PackageFragment protoBuf$PackageFragment, jd jdVar, boolean z) {
        super(en0, storageManager, moduleDescriptor, protoBuf$PackageFragment, jdVar, null);
    }

    public /* synthetic */ kd(en0 en0, StorageManager storageManager, ModuleDescriptor moduleDescriptor, ProtoBuf$PackageFragment protoBuf$PackageFragment, jd jdVar, boolean z, m40 m40) {
        this(en0, storageManager, moduleDescriptor, protoBuf$PackageFragment, jdVar, z);
    }
}
