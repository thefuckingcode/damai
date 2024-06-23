package tb;

import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.utils.JavaTypeEnhancementState;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class v31 {
    @NotNull
    private final StorageManager a;
    @NotNull
    private final JavaClassFinder b;
    @NotNull
    private final KotlinClassFinder c;
    @NotNull
    private final DeserializedDescriptorResolver d;
    @NotNull
    private final SignaturePropagator e;
    @NotNull
    private final ErrorReporter f;
    @NotNull
    private final JavaResolverCache g;
    @NotNull
    private final JavaPropertyInitializerEvaluator h;
    @NotNull
    private final SamConversionResolver i;
    @NotNull
    private final JavaSourceElementFactory j;
    @NotNull
    private final ModuleClassResolver k;
    @NotNull
    private final PackagePartProvider l;
    @NotNull
    private final SupertypeLoopChecker m;
    @NotNull
    private final LookupTracker n;
    @NotNull
    private final ModuleDescriptor o;
    @NotNull
    private final ReflectionTypes p;
    @NotNull
    private final AnnotationTypeQualifierResolver q;
    @NotNull
    private final SignatureEnhancement r;
    @NotNull
    private final JavaClassesTracker s;
    @NotNull
    private final JavaResolverSettings t;
    @NotNull
    private final NewKotlinTypeChecker u;
    @NotNull
    private final JavaTypeEnhancementState v;

    public v31(@NotNull StorageManager storageManager, @NotNull JavaClassFinder javaClassFinder, @NotNull KotlinClassFinder kotlinClassFinder, @NotNull DeserializedDescriptorResolver deserializedDescriptorResolver, @NotNull SignaturePropagator signaturePropagator, @NotNull ErrorReporter errorReporter, @NotNull JavaResolverCache javaResolverCache, @NotNull JavaPropertyInitializerEvaluator javaPropertyInitializerEvaluator, @NotNull SamConversionResolver samConversionResolver, @NotNull JavaSourceElementFactory javaSourceElementFactory, @NotNull ModuleClassResolver moduleClassResolver, @NotNull PackagePartProvider packagePartProvider, @NotNull SupertypeLoopChecker supertypeLoopChecker, @NotNull LookupTracker lookupTracker, @NotNull ModuleDescriptor moduleDescriptor, @NotNull ReflectionTypes reflectionTypes, @NotNull AnnotationTypeQualifierResolver annotationTypeQualifierResolver, @NotNull SignatureEnhancement signatureEnhancement, @NotNull JavaClassesTracker javaClassesTracker, @NotNull JavaResolverSettings javaResolverSettings, @NotNull NewKotlinTypeChecker newKotlinTypeChecker, @NotNull JavaTypeEnhancementState javaTypeEnhancementState) {
        k21.i(storageManager, "storageManager");
        k21.i(javaClassFinder, "finder");
        k21.i(kotlinClassFinder, "kotlinClassFinder");
        k21.i(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        k21.i(signaturePropagator, "signaturePropagator");
        k21.i(errorReporter, "errorReporter");
        k21.i(javaResolverCache, "javaResolverCache");
        k21.i(javaPropertyInitializerEvaluator, "javaPropertyInitializerEvaluator");
        k21.i(samConversionResolver, "samConversionResolver");
        k21.i(javaSourceElementFactory, "sourceElementFactory");
        k21.i(moduleClassResolver, "moduleClassResolver");
        k21.i(packagePartProvider, "packagePartProvider");
        k21.i(supertypeLoopChecker, "supertypeLoopChecker");
        k21.i(lookupTracker, "lookupTracker");
        k21.i(moduleDescriptor, "module");
        k21.i(reflectionTypes, "reflectionTypes");
        k21.i(annotationTypeQualifierResolver, "annotationTypeQualifierResolver");
        k21.i(signatureEnhancement, "signatureEnhancement");
        k21.i(javaClassesTracker, "javaClassesTracker");
        k21.i(javaResolverSettings, "settings");
        k21.i(newKotlinTypeChecker, "kotlinTypeChecker");
        k21.i(javaTypeEnhancementState, "javaTypeEnhancementState");
        this.a = storageManager;
        this.b = javaClassFinder;
        this.c = kotlinClassFinder;
        this.d = deserializedDescriptorResolver;
        this.e = signaturePropagator;
        this.f = errorReporter;
        this.g = javaResolverCache;
        this.h = javaPropertyInitializerEvaluator;
        this.i = samConversionResolver;
        this.j = javaSourceElementFactory;
        this.k = moduleClassResolver;
        this.l = packagePartProvider;
        this.m = supertypeLoopChecker;
        this.n = lookupTracker;
        this.o = moduleDescriptor;
        this.p = reflectionTypes;
        this.q = annotationTypeQualifierResolver;
        this.r = signatureEnhancement;
        this.s = javaClassesTracker;
        this.t = javaResolverSettings;
        this.u = newKotlinTypeChecker;
        this.v = javaTypeEnhancementState;
    }

    @NotNull
    public final AnnotationTypeQualifierResolver a() {
        return this.q;
    }

    @NotNull
    public final DeserializedDescriptorResolver b() {
        return this.d;
    }

    @NotNull
    public final ErrorReporter c() {
        return this.f;
    }

    @NotNull
    public final JavaClassFinder d() {
        return this.b;
    }

    @NotNull
    public final JavaClassesTracker e() {
        return this.s;
    }

    @NotNull
    public final JavaPropertyInitializerEvaluator f() {
        return this.h;
    }

    @NotNull
    public final JavaResolverCache g() {
        return this.g;
    }

    @NotNull
    public final JavaTypeEnhancementState h() {
        return this.v;
    }

    @NotNull
    public final KotlinClassFinder i() {
        return this.c;
    }

    @NotNull
    public final NewKotlinTypeChecker j() {
        return this.u;
    }

    @NotNull
    public final LookupTracker k() {
        return this.n;
    }

    @NotNull
    public final ModuleDescriptor l() {
        return this.o;
    }

    @NotNull
    public final ModuleClassResolver m() {
        return this.k;
    }

    @NotNull
    public final PackagePartProvider n() {
        return this.l;
    }

    @NotNull
    public final ReflectionTypes o() {
        return this.p;
    }

    @NotNull
    public final JavaResolverSettings p() {
        return this.t;
    }

    @NotNull
    public final SignatureEnhancement q() {
        return this.r;
    }

    @NotNull
    public final SignaturePropagator r() {
        return this.e;
    }

    @NotNull
    public final JavaSourceElementFactory s() {
        return this.j;
    }

    @NotNull
    public final StorageManager t() {
        return this.a;
    }

    @NotNull
    public final SupertypeLoopChecker u() {
        return this.m;
    }

    @NotNull
    public final v31 v(@NotNull JavaResolverCache javaResolverCache) {
        k21.i(javaResolverCache, "javaResolverCache");
        return new v31(this.a, this.b, this.c, this.d, this.e, this.f, javaResolverCache, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v);
    }
}
