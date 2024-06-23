package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.c;

/* compiled from: Taobao */
public final class ProtoBuf$VersionRequirement extends GeneratedMessageLite implements ProtoBuf$VersionRequirementOrBuilder {
    public static Parser<ProtoBuf$VersionRequirement> PARSER = new a();
    private static final ProtoBuf$VersionRequirement defaultInstance;
    private int bitField0_;
    private int errorCode_;
    private Level level_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int message_;
    private final ByteString unknownFields;
    private int versionFull_;
    private VersionKind versionKind_;
    private int version_;

    /* compiled from: Taobao */
    public static final class Builder extends GeneratedMessageLite.Builder<ProtoBuf$VersionRequirement, Builder> implements ProtoBuf$VersionRequirementOrBuilder {
        private int bitField0_;
        private int errorCode_;
        private Level level_ = Level.ERROR;
        private int message_;
        private int versionFull_;
        private VersionKind versionKind_ = VersionKind.LANGUAGE_VERSION;
        private int version_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        /* access modifiers changed from: private */
        public static Builder create() {
            return new Builder();
        }

        private void maybeForceBuilderInitialization() {
        }

        public ProtoBuf$VersionRequirement buildPartial() {
            ProtoBuf$VersionRequirement protoBuf$VersionRequirement = new ProtoBuf$VersionRequirement(this);
            int i = this.bitField0_;
            int i2 = 1;
            if ((i & 1) != 1) {
                i2 = 0;
            }
            protoBuf$VersionRequirement.version_ = this.version_;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            protoBuf$VersionRequirement.versionFull_ = this.versionFull_;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            protoBuf$VersionRequirement.level_ = this.level_;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            protoBuf$VersionRequirement.errorCode_ = this.errorCode_;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            protoBuf$VersionRequirement.message_ = this.message_;
            if ((i & 32) == 32) {
                i2 |= 32;
            }
            protoBuf$VersionRequirement.versionKind_ = this.versionKind_;
            protoBuf$VersionRequirement.bitField0_ = i2;
            return protoBuf$VersionRequirement;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder setErrorCode(int i) {
            this.bitField0_ |= 8;
            this.errorCode_ = i;
            return this;
        }

        public Builder setLevel(Level level) {
            Objects.requireNonNull(level);
            this.bitField0_ |= 4;
            this.level_ = level;
            return this;
        }

        public Builder setMessage(int i) {
            this.bitField0_ |= 16;
            this.message_ = i;
            return this;
        }

        public Builder setVersion(int i) {
            this.bitField0_ |= 1;
            this.version_ = i;
            return this;
        }

        public Builder setVersionFull(int i) {
            this.bitField0_ |= 2;
            this.versionFull_ = i;
            return this;
        }

        public Builder setVersionKind(VersionKind versionKind) {
            Objects.requireNonNull(versionKind);
            this.bitField0_ |= 32;
            this.versionKind_ = versionKind;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$VersionRequirement build() {
            ProtoBuf$VersionRequirement buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public ProtoBuf$VersionRequirement getDefaultInstanceForType() {
            return ProtoBuf$VersionRequirement.getDefaultInstance();
        }

        @Override // java.lang.Object, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        public Builder mergeFrom(ProtoBuf$VersionRequirement protoBuf$VersionRequirement) {
            if (protoBuf$VersionRequirement == ProtoBuf$VersionRequirement.getDefaultInstance()) {
                return this;
            }
            if (protoBuf$VersionRequirement.hasVersion()) {
                setVersion(protoBuf$VersionRequirement.getVersion());
            }
            if (protoBuf$VersionRequirement.hasVersionFull()) {
                setVersionFull(protoBuf$VersionRequirement.getVersionFull());
            }
            if (protoBuf$VersionRequirement.hasLevel()) {
                setLevel(protoBuf$VersionRequirement.getLevel());
            }
            if (protoBuf$VersionRequirement.hasErrorCode()) {
                setErrorCode(protoBuf$VersionRequirement.getErrorCode());
            }
            if (protoBuf$VersionRequirement.hasMessage()) {
                setMessage(protoBuf$VersionRequirement.getMessage());
            }
            if (protoBuf$VersionRequirement.hasVersionKind()) {
                setVersionKind(protoBuf$VersionRequirement.getVersionKind());
            }
            setUnknownFields(getUnknownFields().b(protoBuf$VersionRequirement.unknownFields));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, c cVar) throws IOException {
            Throwable th;
            ProtoBuf$VersionRequirement protoBuf$VersionRequirement;
            ProtoBuf$VersionRequirement protoBuf$VersionRequirement2 = null;
            try {
                ProtoBuf$VersionRequirement parsePartialFrom = ProtoBuf$VersionRequirement.PARSER.parsePartialFrom(codedInputStream, cVar);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                protoBuf$VersionRequirement = (ProtoBuf$VersionRequirement) e.getUnfinishedMessage();
                throw e;
            } catch (Throwable th2) {
                th = th2;
                protoBuf$VersionRequirement2 = protoBuf$VersionRequirement;
            }
            if (protoBuf$VersionRequirement2 != null) {
                mergeFrom(protoBuf$VersionRequirement2);
            }
            throw th;
        }
    }

    /* compiled from: Taobao */
    public enum Level implements Internal.EnumLite {
        WARNING(0, 0),
        ERROR(1, 1),
        HIDDEN(2, 2);
        
        private static Internal.EnumLiteMap<Level> internalValueMap = new a();
        private final int value;

        /* compiled from: Taobao */
        static class a implements Internal.EnumLiteMap<Level> {
            a() {
            }

            /* renamed from: a */
            public Level findValueByNumber(int i) {
                return Level.valueOf(i);
            }
        }

        private Level(int i, int i2) {
            this.value = i2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static Level valueOf(int i) {
            if (i == 0) {
                return WARNING;
            }
            if (i == 1) {
                return ERROR;
            }
            if (i != 2) {
                return null;
            }
            return HIDDEN;
        }
    }

    /* compiled from: Taobao */
    public enum VersionKind implements Internal.EnumLite {
        LANGUAGE_VERSION(0, 0),
        COMPILER_VERSION(1, 1),
        API_VERSION(2, 2);
        
        private static Internal.EnumLiteMap<VersionKind> internalValueMap = new a();
        private final int value;

        /* compiled from: Taobao */
        static class a implements Internal.EnumLiteMap<VersionKind> {
            a() {
            }

            /* renamed from: a */
            public VersionKind findValueByNumber(int i) {
                return VersionKind.valueOf(i);
            }
        }

        private VersionKind(int i, int i2) {
            this.value = i2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static VersionKind valueOf(int i) {
            if (i == 0) {
                return LANGUAGE_VERSION;
            }
            if (i == 1) {
                return COMPILER_VERSION;
            }
            if (i != 2) {
                return null;
            }
            return API_VERSION;
        }
    }

    /* compiled from: Taobao */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.a<ProtoBuf$VersionRequirement> {
        a() {
        }

        /* renamed from: i */
        public ProtoBuf$VersionRequirement parsePartialFrom(CodedInputStream codedInputStream, c cVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$VersionRequirement(codedInputStream, cVar);
        }
    }

    static {
        ProtoBuf$VersionRequirement protoBuf$VersionRequirement = new ProtoBuf$VersionRequirement(true);
        defaultInstance = protoBuf$VersionRequirement;
        protoBuf$VersionRequirement.initFields();
    }

    public static ProtoBuf$VersionRequirement getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.version_ = 0;
        this.versionFull_ = 0;
        this.level_ = Level.ERROR;
        this.errorCode_ = 0;
        this.message_ = 0;
        this.versionKind_ = VersionKind.LANGUAGE_VERSION;
    }

    public static Builder newBuilder() {
        return Builder.create();
    }

    public int getErrorCode() {
        return this.errorCode_;
    }

    public Level getLevel() {
        return this.level_;
    }

    public int getMessage() {
        return this.message_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
    public Parser<ProtoBuf$VersionRequirement> getParserForType() {
        return PARSER;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if ((this.bitField0_ & 1) == 1) {
            i2 = 0 + CodedOutputStream.o(1, this.version_);
        }
        if ((this.bitField0_ & 2) == 2) {
            i2 += CodedOutputStream.o(2, this.versionFull_);
        }
        if ((this.bitField0_ & 4) == 4) {
            i2 += CodedOutputStream.h(3, this.level_.getNumber());
        }
        if ((this.bitField0_ & 8) == 8) {
            i2 += CodedOutputStream.o(4, this.errorCode_);
        }
        if ((this.bitField0_ & 16) == 16) {
            i2 += CodedOutputStream.o(5, this.message_);
        }
        if ((this.bitField0_ & 32) == 32) {
            i2 += CodedOutputStream.h(6, this.versionKind_.getNumber());
        }
        int size = i2 + this.unknownFields.size();
        this.memoizedSerializedSize = size;
        return size;
    }

    public int getVersion() {
        return this.version_;
    }

    public int getVersionFull() {
        return this.versionFull_;
    }

    public VersionKind getVersionKind() {
        return this.versionKind_;
    }

    public boolean hasErrorCode() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasLevel() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasMessage() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasVersion() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasVersionFull() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasVersionKind() {
        return (this.bitField0_ & 32) == 32;
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
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.a0(1, this.version_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.a0(2, this.versionFull_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.S(3, this.level_.getNumber());
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.a0(4, this.errorCode_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.a0(5, this.message_);
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.S(6, this.versionKind_.getNumber());
        }
        codedOutputStream.i0(this.unknownFields);
    }

    public static Builder newBuilder(ProtoBuf$VersionRequirement protoBuf$VersionRequirement) {
        return newBuilder().mergeFrom(protoBuf$VersionRequirement);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$VersionRequirement getDefaultInstanceForType() {
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

    private ProtoBuf$VersionRequirement(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = builder.getUnknownFields();
    }

    private ProtoBuf$VersionRequirement(boolean z) {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    private ProtoBuf$VersionRequirement(CodedInputStream codedInputStream, c cVar) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.a n = ByteString.n();
        CodedOutputStream J = CodedOutputStream.J(n, 1);
        boolean z = false;
        while (!z) {
            try {
                int K = codedInputStream.K();
                if (K != 0) {
                    if (K == 8) {
                        this.bitField0_ |= 1;
                        this.version_ = codedInputStream.s();
                    } else if (K == 16) {
                        this.bitField0_ |= 2;
                        this.versionFull_ = codedInputStream.s();
                    } else if (K == 24) {
                        int n2 = codedInputStream.n();
                        Level valueOf = Level.valueOf(n2);
                        if (valueOf == null) {
                            J.o0(K);
                            J.o0(n2);
                        } else {
                            this.bitField0_ |= 4;
                            this.level_ = valueOf;
                        }
                    } else if (K == 32) {
                        this.bitField0_ |= 8;
                        this.errorCode_ = codedInputStream.s();
                    } else if (K == 40) {
                        this.bitField0_ |= 16;
                        this.message_ = codedInputStream.s();
                    } else if (K == 48) {
                        int n3 = codedInputStream.n();
                        VersionKind valueOf2 = VersionKind.valueOf(n3);
                        if (valueOf2 == null) {
                            J.o0(K);
                            J.o0(n3);
                        } else {
                            this.bitField0_ |= 32;
                            this.versionKind_ = valueOf2;
                        }
                    } else if (!parseUnknownField(codedInputStream, J, cVar, K)) {
                    }
                }
                z = true;
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e2) {
                throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
            } catch (Throwable th) {
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
