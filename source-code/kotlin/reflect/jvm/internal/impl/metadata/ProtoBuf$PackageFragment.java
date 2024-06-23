package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.c;

/* compiled from: Taobao */
public final class ProtoBuf$PackageFragment extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$PackageFragment> implements ProtoBuf$PackageFragmentOrBuilder {
    public static Parser<ProtoBuf$PackageFragment> PARSER = new a();
    private static final ProtoBuf$PackageFragment defaultInstance;
    private int bitField0_;
    private List<ProtoBuf$Class> class__;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private ProtoBuf$Package package_;
    private ProtoBuf$QualifiedNameTable qualifiedNames_;
    private ProtoBuf$StringTable strings_;
    private final ByteString unknownFields;

    /* compiled from: Taobao */
    public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ProtoBuf$PackageFragment, Builder> implements ProtoBuf$PackageFragmentOrBuilder {
        private int bitField0_;
        private List<ProtoBuf$Class> class__ = Collections.emptyList();
        private ProtoBuf$Package package_ = ProtoBuf$Package.getDefaultInstance();
        private ProtoBuf$QualifiedNameTable qualifiedNames_ = ProtoBuf$QualifiedNameTable.getDefaultInstance();
        private ProtoBuf$StringTable strings_ = ProtoBuf$StringTable.getDefaultInstance();

        private Builder() {
            maybeForceBuilderInitialization();
        }

        /* access modifiers changed from: private */
        public static Builder create() {
            return new Builder();
        }

        private void ensureClass_IsMutable() {
            if ((this.bitField0_ & 8) != 8) {
                this.class__ = new ArrayList(this.class__);
                this.bitField0_ |= 8;
            }
        }

        private void maybeForceBuilderInitialization() {
        }

        public ProtoBuf$PackageFragment buildPartial() {
            ProtoBuf$PackageFragment protoBuf$PackageFragment = new ProtoBuf$PackageFragment(this);
            int i = this.bitField0_;
            int i2 = 1;
            if ((i & 1) != 1) {
                i2 = 0;
            }
            protoBuf$PackageFragment.strings_ = this.strings_;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            protoBuf$PackageFragment.qualifiedNames_ = this.qualifiedNames_;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            protoBuf$PackageFragment.package_ = this.package_;
            if ((this.bitField0_ & 8) == 8) {
                this.class__ = Collections.unmodifiableList(this.class__);
                this.bitField0_ &= -9;
            }
            protoBuf$PackageFragment.class__ = this.class__;
            protoBuf$PackageFragment.bitField0_ = i2;
            return protoBuf$PackageFragment;
        }

        public ProtoBuf$Class getClass_(int i) {
            return this.class__.get(i);
        }

        public int getClass_Count() {
            return this.class__.size();
        }

        public ProtoBuf$Package getPackage() {
            return this.package_;
        }

        public ProtoBuf$QualifiedNameTable getQualifiedNames() {
            return this.qualifiedNames_;
        }

        public boolean hasPackage() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasQualifiedNames() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            if (hasQualifiedNames() && !getQualifiedNames().isInitialized()) {
                return false;
            }
            if (hasPackage() && !getPackage().isInitialized()) {
                return false;
            }
            for (int i = 0; i < getClass_Count(); i++) {
                if (!getClass_(i).isInitialized()) {
                    return false;
                }
            }
            if (!extensionsAreInitialized()) {
                return false;
            }
            return true;
        }

        public Builder mergePackage(ProtoBuf$Package protoBuf$Package) {
            if ((this.bitField0_ & 4) != 4 || this.package_ == ProtoBuf$Package.getDefaultInstance()) {
                this.package_ = protoBuf$Package;
            } else {
                this.package_ = ProtoBuf$Package.newBuilder(this.package_).mergeFrom(protoBuf$Package).buildPartial();
            }
            this.bitField0_ |= 4;
            return this;
        }

        public Builder mergeQualifiedNames(ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable) {
            if ((this.bitField0_ & 2) != 2 || this.qualifiedNames_ == ProtoBuf$QualifiedNameTable.getDefaultInstance()) {
                this.qualifiedNames_ = protoBuf$QualifiedNameTable;
            } else {
                this.qualifiedNames_ = ProtoBuf$QualifiedNameTable.newBuilder(this.qualifiedNames_).mergeFrom(protoBuf$QualifiedNameTable).buildPartial();
            }
            this.bitField0_ |= 2;
            return this;
        }

        public Builder mergeStrings(ProtoBuf$StringTable protoBuf$StringTable) {
            if ((this.bitField0_ & 1) != 1 || this.strings_ == ProtoBuf$StringTable.getDefaultInstance()) {
                this.strings_ = protoBuf$StringTable;
            } else {
                this.strings_ = ProtoBuf$StringTable.newBuilder(this.strings_).mergeFrom(protoBuf$StringTable).buildPartial();
            }
            this.bitField0_ |= 1;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$PackageFragment build() {
            ProtoBuf$PackageFragment buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public ProtoBuf$PackageFragment getDefaultInstanceForType() {
            return ProtoBuf$PackageFragment.getDefaultInstance();
        }

        public Builder mergeFrom(ProtoBuf$PackageFragment protoBuf$PackageFragment) {
            if (protoBuf$PackageFragment == ProtoBuf$PackageFragment.getDefaultInstance()) {
                return this;
            }
            if (protoBuf$PackageFragment.hasStrings()) {
                mergeStrings(protoBuf$PackageFragment.getStrings());
            }
            if (protoBuf$PackageFragment.hasQualifiedNames()) {
                mergeQualifiedNames(protoBuf$PackageFragment.getQualifiedNames());
            }
            if (protoBuf$PackageFragment.hasPackage()) {
                mergePackage(protoBuf$PackageFragment.getPackage());
            }
            if (!protoBuf$PackageFragment.class__.isEmpty()) {
                if (this.class__.isEmpty()) {
                    this.class__ = protoBuf$PackageFragment.class__;
                    this.bitField0_ &= -9;
                } else {
                    ensureClass_IsMutable();
                    this.class__.addAll(protoBuf$PackageFragment.class__);
                }
            }
            mergeExtensionFields(protoBuf$PackageFragment);
            setUnknownFields(getUnknownFields().b(protoBuf$PackageFragment.unknownFields));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, java.lang.Object, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, c cVar) throws IOException {
            Throwable th;
            ProtoBuf$PackageFragment protoBuf$PackageFragment;
            ProtoBuf$PackageFragment protoBuf$PackageFragment2 = null;
            try {
                ProtoBuf$PackageFragment parsePartialFrom = ProtoBuf$PackageFragment.PARSER.parsePartialFrom(codedInputStream, cVar);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                protoBuf$PackageFragment = (ProtoBuf$PackageFragment) e.getUnfinishedMessage();
                throw e;
            } catch (Throwable th2) {
                th = th2;
                protoBuf$PackageFragment2 = protoBuf$PackageFragment;
            }
            if (protoBuf$PackageFragment2 != null) {
                mergeFrom(protoBuf$PackageFragment2);
            }
            throw th;
        }
    }

    /* compiled from: Taobao */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.a<ProtoBuf$PackageFragment> {
        a() {
        }

        /* renamed from: i */
        public ProtoBuf$PackageFragment parsePartialFrom(CodedInputStream codedInputStream, c cVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$PackageFragment(codedInputStream, cVar);
        }
    }

    static {
        ProtoBuf$PackageFragment protoBuf$PackageFragment = new ProtoBuf$PackageFragment(true);
        defaultInstance = protoBuf$PackageFragment;
        protoBuf$PackageFragment.initFields();
    }

    public static ProtoBuf$PackageFragment getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.strings_ = ProtoBuf$StringTable.getDefaultInstance();
        this.qualifiedNames_ = ProtoBuf$QualifiedNameTable.getDefaultInstance();
        this.package_ = ProtoBuf$Package.getDefaultInstance();
        this.class__ = Collections.emptyList();
    }

    public static Builder newBuilder() {
        return Builder.create();
    }

    public static ProtoBuf$PackageFragment parseFrom(InputStream inputStream, c cVar) throws IOException {
        return PARSER.parseFrom(inputStream, cVar);
    }

    public ProtoBuf$Class getClass_(int i) {
        return this.class__.get(i);
    }

    public int getClass_Count() {
        return this.class__.size();
    }

    public List<ProtoBuf$Class> getClass_List() {
        return this.class__;
    }

    public ProtoBuf$Package getPackage() {
        return this.package_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
    public Parser<ProtoBuf$PackageFragment> getParserForType() {
        return PARSER;
    }

    public ProtoBuf$QualifiedNameTable getQualifiedNames() {
        return this.qualifiedNames_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int s = (this.bitField0_ & 1) == 1 ? CodedOutputStream.s(1, this.strings_) + 0 : 0;
        if ((this.bitField0_ & 2) == 2) {
            s += CodedOutputStream.s(2, this.qualifiedNames_);
        }
        if ((this.bitField0_ & 4) == 4) {
            s += CodedOutputStream.s(3, this.package_);
        }
        for (int i2 = 0; i2 < this.class__.size(); i2++) {
            s += CodedOutputStream.s(4, this.class__.get(i2));
        }
        int extensionsSerializedSize = s + extensionsSerializedSize() + this.unknownFields.size();
        this.memoizedSerializedSize = extensionsSerializedSize;
        return extensionsSerializedSize;
    }

    public ProtoBuf$StringTable getStrings() {
        return this.strings_;
    }

    public boolean hasPackage() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasQualifiedNames() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasStrings() {
        return (this.bitField0_ & 1) == 1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.memoizedIsInitialized;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if (hasQualifiedNames() && !getQualifiedNames().isInitialized()) {
            this.memoizedIsInitialized = 0;
            return false;
        } else if (!hasPackage() || getPackage().isInitialized()) {
            for (int i = 0; i < getClass_Count(); i++) {
                if (!getClass_(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        } else {
            this.memoizedIsInitialized = 0;
            return false;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.d0(1, this.strings_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.d0(2, this.qualifiedNames_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.d0(3, this.package_);
        }
        for (int i = 0; i < this.class__.size(); i++) {
            codedOutputStream.d0(4, this.class__.get(i));
        }
        newExtensionWriter.a(200, codedOutputStream);
        codedOutputStream.i0(this.unknownFields);
    }

    public static Builder newBuilder(ProtoBuf$PackageFragment protoBuf$PackageFragment) {
        return newBuilder().mergeFrom(protoBuf$PackageFragment);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$PackageFragment getDefaultInstanceForType() {
        return defaultInstance;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder toBuilder() {
        return newBuilder(this);
    }

    private ProtoBuf$PackageFragment(GeneratedMessageLite.ExtendableBuilder<ProtoBuf$PackageFragment, ?> extendableBuilder) {
        super(extendableBuilder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = extendableBuilder.getUnknownFields();
    }

    private ProtoBuf$PackageFragment(boolean z) {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v29, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class> */
    /* JADX WARN: Multi-variable type inference failed */
    private ProtoBuf$PackageFragment(CodedInputStream codedInputStream, c cVar) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.a n = ByteString.n();
        CodedOutputStream J = CodedOutputStream.J(n, 1);
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            try {
                int K = codedInputStream.K();
                if (K != 0) {
                    ProtoBuf$StringTable.Builder builder = null;
                    ProtoBuf$Package.Builder builder2 = null;
                    ProtoBuf$QualifiedNameTable.Builder builder3 = null;
                    if (K == 10) {
                        builder = (this.bitField0_ & 1) == 1 ? this.strings_.toBuilder() : builder;
                        ProtoBuf$StringTable protoBuf$StringTable = (ProtoBuf$StringTable) codedInputStream.u(ProtoBuf$StringTable.PARSER, cVar);
                        this.strings_ = protoBuf$StringTable;
                        if (builder != null) {
                            builder.mergeFrom(protoBuf$StringTable);
                            this.strings_ = builder.buildPartial();
                        }
                        this.bitField0_ |= 1;
                    } else if (K == 18) {
                        builder3 = (this.bitField0_ & 2) == 2 ? this.qualifiedNames_.toBuilder() : builder3;
                        ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable = (ProtoBuf$QualifiedNameTable) codedInputStream.u(ProtoBuf$QualifiedNameTable.PARSER, cVar);
                        this.qualifiedNames_ = protoBuf$QualifiedNameTable;
                        if (builder3 != null) {
                            builder3.mergeFrom(protoBuf$QualifiedNameTable);
                            this.qualifiedNames_ = builder3.buildPartial();
                        }
                        this.bitField0_ |= 2;
                    } else if (K == 26) {
                        builder2 = (this.bitField0_ & 4) == 4 ? this.package_.toBuilder() : builder2;
                        ProtoBuf$Package protoBuf$Package = (ProtoBuf$Package) codedInputStream.u(ProtoBuf$Package.PARSER, cVar);
                        this.package_ = protoBuf$Package;
                        if (builder2 != null) {
                            builder2.mergeFrom(protoBuf$Package);
                            this.package_ = builder2.buildPartial();
                        }
                        this.bitField0_ |= 4;
                    } else if (K == 34) {
                        if (!(z2 & true)) {
                            this.class__ = new ArrayList();
                            z2 |= true;
                        }
                        this.class__.add(codedInputStream.u(ProtoBuf$Class.PARSER, cVar));
                    } else if (!parseUnknownField(codedInputStream, J, cVar, K)) {
                    }
                }
                z = true;
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e2) {
                throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
            } catch (Throwable th) {
                if (z2 & true) {
                    this.class__ = Collections.unmodifiableList(this.class__);
                }
                try {
                    J.I();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.unknownFields = n.f();
                    throw th2;
                }
                this.unknownFields = n.f();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.class__ = Collections.unmodifiableList(this.class__);
        }
        try {
            J.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.unknownFields = n.f();
            throw th3;
        }
        this.unknownFields = n.f();
        makeExtensionsImmutable();
    }
}
