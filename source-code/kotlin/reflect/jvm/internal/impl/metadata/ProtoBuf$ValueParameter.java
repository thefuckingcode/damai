package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.c;

/* compiled from: Taobao */
public final class ProtoBuf$ValueParameter extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$ValueParameter> implements ProtoBuf$ValueParameterOrBuilder {
    public static Parser<ProtoBuf$ValueParameter> PARSER = new a();
    private static final ProtoBuf$ValueParameter defaultInstance;
    private int bitField0_;
    private int flags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private int typeId_;
    private ProtoBuf$Type type_;
    private final ByteString unknownFields;
    private int varargElementTypeId_;
    private ProtoBuf$Type varargElementType_;

    /* compiled from: Taobao */
    public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ProtoBuf$ValueParameter, Builder> implements ProtoBuf$ValueParameterOrBuilder {
        private int bitField0_;
        private int flags_;
        private int name_;
        private int typeId_;
        private ProtoBuf$Type type_ = ProtoBuf$Type.getDefaultInstance();
        private int varargElementTypeId_;
        private ProtoBuf$Type varargElementType_ = ProtoBuf$Type.getDefaultInstance();

        private Builder() {
            maybeForceBuilderInitialization();
        }

        /* access modifiers changed from: private */
        public static Builder create() {
            return new Builder();
        }

        private void maybeForceBuilderInitialization() {
        }

        public ProtoBuf$ValueParameter buildPartial() {
            ProtoBuf$ValueParameter protoBuf$ValueParameter = new ProtoBuf$ValueParameter(this);
            int i = this.bitField0_;
            int i2 = 1;
            if ((i & 1) != 1) {
                i2 = 0;
            }
            protoBuf$ValueParameter.flags_ = this.flags_;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            protoBuf$ValueParameter.name_ = this.name_;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            protoBuf$ValueParameter.type_ = this.type_;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            protoBuf$ValueParameter.typeId_ = this.typeId_;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            protoBuf$ValueParameter.varargElementType_ = this.varargElementType_;
            if ((i & 32) == 32) {
                i2 |= 32;
            }
            protoBuf$ValueParameter.varargElementTypeId_ = this.varargElementTypeId_;
            protoBuf$ValueParameter.bitField0_ = i2;
            return protoBuf$ValueParameter;
        }

        public ProtoBuf$Type getType() {
            return this.type_;
        }

        public ProtoBuf$Type getVarargElementType() {
            return this.varargElementType_;
        }

        public boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasType() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasVarargElementType() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            if (!hasName()) {
                return false;
            }
            if (hasType() && !getType().isInitialized()) {
                return false;
            }
            if ((!hasVarargElementType() || getVarargElementType().isInitialized()) && extensionsAreInitialized()) {
                return true;
            }
            return false;
        }

        public Builder mergeType(ProtoBuf$Type protoBuf$Type) {
            if ((this.bitField0_ & 4) != 4 || this.type_ == ProtoBuf$Type.getDefaultInstance()) {
                this.type_ = protoBuf$Type;
            } else {
                this.type_ = ProtoBuf$Type.newBuilder(this.type_).mergeFrom(protoBuf$Type).buildPartial();
            }
            this.bitField0_ |= 4;
            return this;
        }

        public Builder mergeVarargElementType(ProtoBuf$Type protoBuf$Type) {
            if ((this.bitField0_ & 16) != 16 || this.varargElementType_ == ProtoBuf$Type.getDefaultInstance()) {
                this.varargElementType_ = protoBuf$Type;
            } else {
                this.varargElementType_ = ProtoBuf$Type.newBuilder(this.varargElementType_).mergeFrom(protoBuf$Type).buildPartial();
            }
            this.bitField0_ |= 16;
            return this;
        }

        public Builder setFlags(int i) {
            this.bitField0_ |= 1;
            this.flags_ = i;
            return this;
        }

        public Builder setName(int i) {
            this.bitField0_ |= 2;
            this.name_ = i;
            return this;
        }

        public Builder setTypeId(int i) {
            this.bitField0_ |= 8;
            this.typeId_ = i;
            return this;
        }

        public Builder setVarargElementTypeId(int i) {
            this.bitField0_ |= 32;
            this.varargElementTypeId_ = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$ValueParameter build() {
            ProtoBuf$ValueParameter buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public ProtoBuf$ValueParameter getDefaultInstanceForType() {
            return ProtoBuf$ValueParameter.getDefaultInstance();
        }

        public Builder mergeFrom(ProtoBuf$ValueParameter protoBuf$ValueParameter) {
            if (protoBuf$ValueParameter == ProtoBuf$ValueParameter.getDefaultInstance()) {
                return this;
            }
            if (protoBuf$ValueParameter.hasFlags()) {
                setFlags(protoBuf$ValueParameter.getFlags());
            }
            if (protoBuf$ValueParameter.hasName()) {
                setName(protoBuf$ValueParameter.getName());
            }
            if (protoBuf$ValueParameter.hasType()) {
                mergeType(protoBuf$ValueParameter.getType());
            }
            if (protoBuf$ValueParameter.hasTypeId()) {
                setTypeId(protoBuf$ValueParameter.getTypeId());
            }
            if (protoBuf$ValueParameter.hasVarargElementType()) {
                mergeVarargElementType(protoBuf$ValueParameter.getVarargElementType());
            }
            if (protoBuf$ValueParameter.hasVarargElementTypeId()) {
                setVarargElementTypeId(protoBuf$ValueParameter.getVarargElementTypeId());
            }
            mergeExtensionFields(protoBuf$ValueParameter);
            setUnknownFields(getUnknownFields().b(protoBuf$ValueParameter.unknownFields));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, java.lang.Object, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, c cVar) throws IOException {
            Throwable th;
            ProtoBuf$ValueParameter protoBuf$ValueParameter;
            ProtoBuf$ValueParameter protoBuf$ValueParameter2 = null;
            try {
                ProtoBuf$ValueParameter parsePartialFrom = ProtoBuf$ValueParameter.PARSER.parsePartialFrom(codedInputStream, cVar);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                protoBuf$ValueParameter = (ProtoBuf$ValueParameter) e.getUnfinishedMessage();
                throw e;
            } catch (Throwable th2) {
                th = th2;
                protoBuf$ValueParameter2 = protoBuf$ValueParameter;
            }
            if (protoBuf$ValueParameter2 != null) {
                mergeFrom(protoBuf$ValueParameter2);
            }
            throw th;
        }
    }

    /* compiled from: Taobao */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.a<ProtoBuf$ValueParameter> {
        a() {
        }

        /* renamed from: i */
        public ProtoBuf$ValueParameter parsePartialFrom(CodedInputStream codedInputStream, c cVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$ValueParameter(codedInputStream, cVar);
        }
    }

    static {
        ProtoBuf$ValueParameter protoBuf$ValueParameter = new ProtoBuf$ValueParameter(true);
        defaultInstance = protoBuf$ValueParameter;
        protoBuf$ValueParameter.initFields();
    }

    public static ProtoBuf$ValueParameter getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.flags_ = 0;
        this.name_ = 0;
        this.type_ = ProtoBuf$Type.getDefaultInstance();
        this.typeId_ = 0;
        this.varargElementType_ = ProtoBuf$Type.getDefaultInstance();
        this.varargElementTypeId_ = 0;
    }

    public static Builder newBuilder() {
        return Builder.create();
    }

    public int getFlags() {
        return this.flags_;
    }

    public int getName() {
        return this.name_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
    public Parser<ProtoBuf$ValueParameter> getParserForType() {
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
            i2 = 0 + CodedOutputStream.o(1, this.flags_);
        }
        if ((this.bitField0_ & 2) == 2) {
            i2 += CodedOutputStream.o(2, this.name_);
        }
        if ((this.bitField0_ & 4) == 4) {
            i2 += CodedOutputStream.s(3, this.type_);
        }
        if ((this.bitField0_ & 16) == 16) {
            i2 += CodedOutputStream.s(4, this.varargElementType_);
        }
        if ((this.bitField0_ & 8) == 8) {
            i2 += CodedOutputStream.o(5, this.typeId_);
        }
        if ((this.bitField0_ & 32) == 32) {
            i2 += CodedOutputStream.o(6, this.varargElementTypeId_);
        }
        int extensionsSerializedSize = i2 + extensionsSerializedSize() + this.unknownFields.size();
        this.memoizedSerializedSize = extensionsSerializedSize;
        return extensionsSerializedSize;
    }

    public ProtoBuf$Type getType() {
        return this.type_;
    }

    public int getTypeId() {
        return this.typeId_;
    }

    public ProtoBuf$Type getVarargElementType() {
        return this.varargElementType_;
    }

    public int getVarargElementTypeId() {
        return this.varargElementTypeId_;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasName() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasType() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasTypeId() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasVarargElementType() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasVarargElementTypeId() {
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
        if (!hasName()) {
            this.memoizedIsInitialized = 0;
            return false;
        } else if (hasType() && !getType().isInitialized()) {
            this.memoizedIsInitialized = 0;
            return false;
        } else if (hasVarargElementType() && !getVarargElementType().isInitialized()) {
            this.memoizedIsInitialized = 0;
            return false;
        } else if (!extensionsAreInitialized()) {
            this.memoizedIsInitialized = 0;
            return false;
        } else {
            this.memoizedIsInitialized = 1;
            return true;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.a0(1, this.flags_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.a0(2, this.name_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.d0(3, this.type_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.d0(4, this.varargElementType_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.a0(5, this.typeId_);
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.a0(6, this.varargElementTypeId_);
        }
        newExtensionWriter.a(200, codedOutputStream);
        codedOutputStream.i0(this.unknownFields);
    }

    public static Builder newBuilder(ProtoBuf$ValueParameter protoBuf$ValueParameter) {
        return newBuilder().mergeFrom(protoBuf$ValueParameter);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$ValueParameter getDefaultInstanceForType() {
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

    private ProtoBuf$ValueParameter(GeneratedMessageLite.ExtendableBuilder<ProtoBuf$ValueParameter, ?> extendableBuilder) {
        super(extendableBuilder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = extendableBuilder.getUnknownFields();
    }

    private ProtoBuf$ValueParameter(boolean z) {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    private ProtoBuf$ValueParameter(CodedInputStream codedInputStream, c cVar) throws InvalidProtocolBufferException {
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
                        this.flags_ = codedInputStream.s();
                    } else if (K != 16) {
                        ProtoBuf$Type.Builder builder = null;
                        if (K == 26) {
                            builder = (this.bitField0_ & 4) == 4 ? this.type_.toBuilder() : builder;
                            ProtoBuf$Type protoBuf$Type = (ProtoBuf$Type) codedInputStream.u(ProtoBuf$Type.PARSER, cVar);
                            this.type_ = protoBuf$Type;
                            if (builder != null) {
                                builder.mergeFrom(protoBuf$Type);
                                this.type_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 4;
                        } else if (K == 34) {
                            builder = (this.bitField0_ & 16) == 16 ? this.varargElementType_.toBuilder() : builder;
                            ProtoBuf$Type protoBuf$Type2 = (ProtoBuf$Type) codedInputStream.u(ProtoBuf$Type.PARSER, cVar);
                            this.varargElementType_ = protoBuf$Type2;
                            if (builder != null) {
                                builder.mergeFrom(protoBuf$Type2);
                                this.varargElementType_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 16;
                        } else if (K == 40) {
                            this.bitField0_ |= 8;
                            this.typeId_ = codedInputStream.s();
                        } else if (K == 48) {
                            this.bitField0_ |= 32;
                            this.varargElementTypeId_ = codedInputStream.s();
                        } else if (!parseUnknownField(codedInputStream, J, cVar, K)) {
                        }
                    } else {
                        this.bitField0_ |= 2;
                        this.name_ = codedInputStream.s();
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
