package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.c;

/* compiled from: Taobao */
public final class ProtoBuf$Property extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Property> implements ProtoBuf$PropertyOrBuilder {
    public static Parser<ProtoBuf$Property> PARSER = new a();
    private static final ProtoBuf$Property defaultInstance;
    private int bitField0_;
    private int flags_;
    private int getterFlags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private int oldFlags_;
    private int receiverTypeId_;
    private ProtoBuf$Type receiverType_;
    private int returnTypeId_;
    private ProtoBuf$Type returnType_;
    private int setterFlags_;
    private ProtoBuf$ValueParameter setterValueParameter_;
    private List<ProtoBuf$TypeParameter> typeParameter_;
    private final ByteString unknownFields;
    private List<Integer> versionRequirement_;

    /* compiled from: Taobao */
    public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ProtoBuf$Property, Builder> implements ProtoBuf$PropertyOrBuilder {
        private int bitField0_;
        private int flags_ = 518;
        private int getterFlags_;
        private int name_;
        private int oldFlags_ = 2054;
        private int receiverTypeId_;
        private ProtoBuf$Type receiverType_ = ProtoBuf$Type.getDefaultInstance();
        private int returnTypeId_;
        private ProtoBuf$Type returnType_ = ProtoBuf$Type.getDefaultInstance();
        private int setterFlags_;
        private ProtoBuf$ValueParameter setterValueParameter_ = ProtoBuf$ValueParameter.getDefaultInstance();
        private List<ProtoBuf$TypeParameter> typeParameter_ = Collections.emptyList();
        private List<Integer> versionRequirement_ = Collections.emptyList();

        private Builder() {
            maybeForceBuilderInitialization();
        }

        /* access modifiers changed from: private */
        public static Builder create() {
            return new Builder();
        }

        private void ensureTypeParameterIsMutable() {
            if ((this.bitField0_ & 32) != 32) {
                this.typeParameter_ = new ArrayList(this.typeParameter_);
                this.bitField0_ |= 32;
            }
        }

        private void ensureVersionRequirementIsMutable() {
            if ((this.bitField0_ & 2048) != 2048) {
                this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                this.bitField0_ |= 2048;
            }
        }

        private void maybeForceBuilderInitialization() {
        }

        public ProtoBuf$Property buildPartial() {
            ProtoBuf$Property protoBuf$Property = new ProtoBuf$Property(this);
            int i = this.bitField0_;
            int i2 = 1;
            if ((i & 1) != 1) {
                i2 = 0;
            }
            protoBuf$Property.flags_ = this.flags_;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            protoBuf$Property.oldFlags_ = this.oldFlags_;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            protoBuf$Property.name_ = this.name_;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            protoBuf$Property.returnType_ = this.returnType_;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            protoBuf$Property.returnTypeId_ = this.returnTypeId_;
            if ((this.bitField0_ & 32) == 32) {
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                this.bitField0_ &= -33;
            }
            protoBuf$Property.typeParameter_ = this.typeParameter_;
            if ((i & 64) == 64) {
                i2 |= 32;
            }
            protoBuf$Property.receiverType_ = this.receiverType_;
            if ((i & 128) == 128) {
                i2 |= 64;
            }
            protoBuf$Property.receiverTypeId_ = this.receiverTypeId_;
            if ((i & 256) == 256) {
                i2 |= 128;
            }
            protoBuf$Property.setterValueParameter_ = this.setterValueParameter_;
            if ((i & 512) == 512) {
                i2 |= 256;
            }
            protoBuf$Property.getterFlags_ = this.getterFlags_;
            if ((i & 1024) == 1024) {
                i2 |= 512;
            }
            protoBuf$Property.setterFlags_ = this.setterFlags_;
            if ((this.bitField0_ & 2048) == 2048) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -2049;
            }
            protoBuf$Property.versionRequirement_ = this.versionRequirement_;
            protoBuf$Property.bitField0_ = i2;
            return protoBuf$Property;
        }

        public ProtoBuf$Type getReceiverType() {
            return this.receiverType_;
        }

        public ProtoBuf$Type getReturnType() {
            return this.returnType_;
        }

        public ProtoBuf$ValueParameter getSetterValueParameter() {
            return this.setterValueParameter_;
        }

        public ProtoBuf$TypeParameter getTypeParameter(int i) {
            return this.typeParameter_.get(i);
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public boolean hasName() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasReceiverType() {
            return (this.bitField0_ & 64) == 64;
        }

        public boolean hasReturnType() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasSetterValueParameter() {
            return (this.bitField0_ & 256) == 256;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            if (!hasName()) {
                return false;
            }
            if (hasReturnType() && !getReturnType().isInitialized()) {
                return false;
            }
            for (int i = 0; i < getTypeParameterCount(); i++) {
                if (!getTypeParameter(i).isInitialized()) {
                    return false;
                }
            }
            if (hasReceiverType() && !getReceiverType().isInitialized()) {
                return false;
            }
            if ((!hasSetterValueParameter() || getSetterValueParameter().isInitialized()) && extensionsAreInitialized()) {
                return true;
            }
            return false;
        }

        public Builder mergeReceiverType(ProtoBuf$Type protoBuf$Type) {
            if ((this.bitField0_ & 64) != 64 || this.receiverType_ == ProtoBuf$Type.getDefaultInstance()) {
                this.receiverType_ = protoBuf$Type;
            } else {
                this.receiverType_ = ProtoBuf$Type.newBuilder(this.receiverType_).mergeFrom(protoBuf$Type).buildPartial();
            }
            this.bitField0_ |= 64;
            return this;
        }

        public Builder mergeReturnType(ProtoBuf$Type protoBuf$Type) {
            if ((this.bitField0_ & 8) != 8 || this.returnType_ == ProtoBuf$Type.getDefaultInstance()) {
                this.returnType_ = protoBuf$Type;
            } else {
                this.returnType_ = ProtoBuf$Type.newBuilder(this.returnType_).mergeFrom(protoBuf$Type).buildPartial();
            }
            this.bitField0_ |= 8;
            return this;
        }

        public Builder mergeSetterValueParameter(ProtoBuf$ValueParameter protoBuf$ValueParameter) {
            if ((this.bitField0_ & 256) != 256 || this.setterValueParameter_ == ProtoBuf$ValueParameter.getDefaultInstance()) {
                this.setterValueParameter_ = protoBuf$ValueParameter;
            } else {
                this.setterValueParameter_ = ProtoBuf$ValueParameter.newBuilder(this.setterValueParameter_).mergeFrom(protoBuf$ValueParameter).buildPartial();
            }
            this.bitField0_ |= 256;
            return this;
        }

        public Builder setFlags(int i) {
            this.bitField0_ |= 1;
            this.flags_ = i;
            return this;
        }

        public Builder setGetterFlags(int i) {
            this.bitField0_ |= 512;
            this.getterFlags_ = i;
            return this;
        }

        public Builder setName(int i) {
            this.bitField0_ |= 4;
            this.name_ = i;
            return this;
        }

        public Builder setOldFlags(int i) {
            this.bitField0_ |= 2;
            this.oldFlags_ = i;
            return this;
        }

        public Builder setReceiverTypeId(int i) {
            this.bitField0_ |= 128;
            this.receiverTypeId_ = i;
            return this;
        }

        public Builder setReturnTypeId(int i) {
            this.bitField0_ |= 16;
            this.returnTypeId_ = i;
            return this;
        }

        public Builder setSetterFlags(int i) {
            this.bitField0_ |= 1024;
            this.setterFlags_ = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$Property build() {
            ProtoBuf$Property buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public ProtoBuf$Property getDefaultInstanceForType() {
            return ProtoBuf$Property.getDefaultInstance();
        }

        public Builder mergeFrom(ProtoBuf$Property protoBuf$Property) {
            if (protoBuf$Property == ProtoBuf$Property.getDefaultInstance()) {
                return this;
            }
            if (protoBuf$Property.hasFlags()) {
                setFlags(protoBuf$Property.getFlags());
            }
            if (protoBuf$Property.hasOldFlags()) {
                setOldFlags(protoBuf$Property.getOldFlags());
            }
            if (protoBuf$Property.hasName()) {
                setName(protoBuf$Property.getName());
            }
            if (protoBuf$Property.hasReturnType()) {
                mergeReturnType(protoBuf$Property.getReturnType());
            }
            if (protoBuf$Property.hasReturnTypeId()) {
                setReturnTypeId(protoBuf$Property.getReturnTypeId());
            }
            if (!protoBuf$Property.typeParameter_.isEmpty()) {
                if (this.typeParameter_.isEmpty()) {
                    this.typeParameter_ = protoBuf$Property.typeParameter_;
                    this.bitField0_ &= -33;
                } else {
                    ensureTypeParameterIsMutable();
                    this.typeParameter_.addAll(protoBuf$Property.typeParameter_);
                }
            }
            if (protoBuf$Property.hasReceiverType()) {
                mergeReceiverType(protoBuf$Property.getReceiverType());
            }
            if (protoBuf$Property.hasReceiverTypeId()) {
                setReceiverTypeId(protoBuf$Property.getReceiverTypeId());
            }
            if (protoBuf$Property.hasSetterValueParameter()) {
                mergeSetterValueParameter(protoBuf$Property.getSetterValueParameter());
            }
            if (protoBuf$Property.hasGetterFlags()) {
                setGetterFlags(protoBuf$Property.getGetterFlags());
            }
            if (protoBuf$Property.hasSetterFlags()) {
                setSetterFlags(protoBuf$Property.getSetterFlags());
            }
            if (!protoBuf$Property.versionRequirement_.isEmpty()) {
                if (this.versionRequirement_.isEmpty()) {
                    this.versionRequirement_ = protoBuf$Property.versionRequirement_;
                    this.bitField0_ &= -2049;
                } else {
                    ensureVersionRequirementIsMutable();
                    this.versionRequirement_.addAll(protoBuf$Property.versionRequirement_);
                }
            }
            mergeExtensionFields(protoBuf$Property);
            setUnknownFields(getUnknownFields().b(protoBuf$Property.unknownFields));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, java.lang.Object, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, c cVar) throws IOException {
            Throwable th;
            ProtoBuf$Property protoBuf$Property;
            ProtoBuf$Property protoBuf$Property2 = null;
            try {
                ProtoBuf$Property parsePartialFrom = ProtoBuf$Property.PARSER.parsePartialFrom(codedInputStream, cVar);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                protoBuf$Property = (ProtoBuf$Property) e.getUnfinishedMessage();
                throw e;
            } catch (Throwable th2) {
                th = th2;
                protoBuf$Property2 = protoBuf$Property;
            }
            if (protoBuf$Property2 != null) {
                mergeFrom(protoBuf$Property2);
            }
            throw th;
        }
    }

    /* compiled from: Taobao */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.a<ProtoBuf$Property> {
        a() {
        }

        /* renamed from: i */
        public ProtoBuf$Property parsePartialFrom(CodedInputStream codedInputStream, c cVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$Property(codedInputStream, cVar);
        }
    }

    static {
        ProtoBuf$Property protoBuf$Property = new ProtoBuf$Property(true);
        defaultInstance = protoBuf$Property;
        protoBuf$Property.initFields();
    }

    public static ProtoBuf$Property getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.flags_ = 518;
        this.oldFlags_ = 2054;
        this.name_ = 0;
        this.returnType_ = ProtoBuf$Type.getDefaultInstance();
        this.returnTypeId_ = 0;
        this.typeParameter_ = Collections.emptyList();
        this.receiverType_ = ProtoBuf$Type.getDefaultInstance();
        this.receiverTypeId_ = 0;
        this.setterValueParameter_ = ProtoBuf$ValueParameter.getDefaultInstance();
        this.getterFlags_ = 0;
        this.setterFlags_ = 0;
        this.versionRequirement_ = Collections.emptyList();
    }

    public static Builder newBuilder() {
        return Builder.create();
    }

    public int getFlags() {
        return this.flags_;
    }

    public int getGetterFlags() {
        return this.getterFlags_;
    }

    public int getName() {
        return this.name_;
    }

    public int getOldFlags() {
        return this.oldFlags_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
    public Parser<ProtoBuf$Property> getParserForType() {
        return PARSER;
    }

    public ProtoBuf$Type getReceiverType() {
        return this.receiverType_;
    }

    public int getReceiverTypeId() {
        return this.receiverTypeId_;
    }

    public ProtoBuf$Type getReturnType() {
        return this.returnType_;
    }

    public int getReturnTypeId() {
        return this.returnTypeId_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int o = (this.bitField0_ & 2) == 2 ? CodedOutputStream.o(1, this.oldFlags_) + 0 : 0;
        if ((this.bitField0_ & 4) == 4) {
            o += CodedOutputStream.o(2, this.name_);
        }
        if ((this.bitField0_ & 8) == 8) {
            o += CodedOutputStream.s(3, this.returnType_);
        }
        for (int i2 = 0; i2 < this.typeParameter_.size(); i2++) {
            o += CodedOutputStream.s(4, this.typeParameter_.get(i2));
        }
        if ((this.bitField0_ & 32) == 32) {
            o += CodedOutputStream.s(5, this.receiverType_);
        }
        if ((this.bitField0_ & 128) == 128) {
            o += CodedOutputStream.s(6, this.setterValueParameter_);
        }
        if ((this.bitField0_ & 256) == 256) {
            o += CodedOutputStream.o(7, this.getterFlags_);
        }
        if ((this.bitField0_ & 512) == 512) {
            o += CodedOutputStream.o(8, this.setterFlags_);
        }
        if ((this.bitField0_ & 16) == 16) {
            o += CodedOutputStream.o(9, this.returnTypeId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            o += CodedOutputStream.o(10, this.receiverTypeId_);
        }
        if ((this.bitField0_ & 1) == 1) {
            o += CodedOutputStream.o(11, this.flags_);
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.versionRequirement_.size(); i4++) {
            i3 += CodedOutputStream.p(this.versionRequirement_.get(i4).intValue());
        }
        int size = o + i3 + (getVersionRequirementList().size() * 2) + extensionsSerializedSize() + this.unknownFields.size();
        this.memoizedSerializedSize = size;
        return size;
    }

    public int getSetterFlags() {
        return this.setterFlags_;
    }

    public ProtoBuf$ValueParameter getSetterValueParameter() {
        return this.setterValueParameter_;
    }

    public ProtoBuf$TypeParameter getTypeParameter(int i) {
        return this.typeParameter_.get(i);
    }

    public int getTypeParameterCount() {
        return this.typeParameter_.size();
    }

    public List<ProtoBuf$TypeParameter> getTypeParameterList() {
        return this.typeParameter_;
    }

    public List<Integer> getVersionRequirementList() {
        return this.versionRequirement_;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasGetterFlags() {
        return (this.bitField0_ & 256) == 256;
    }

    public boolean hasName() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasOldFlags() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasReceiverType() {
        return (this.bitField0_ & 32) == 32;
    }

    public boolean hasReceiverTypeId() {
        return (this.bitField0_ & 64) == 64;
    }

    public boolean hasReturnType() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasReturnTypeId() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasSetterFlags() {
        return (this.bitField0_ & 512) == 512;
    }

    public boolean hasSetterValueParameter() {
        return (this.bitField0_ & 128) == 128;
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
        } else if (!hasReturnType() || getReturnType().isInitialized()) {
            for (int i = 0; i < getTypeParameterCount(); i++) {
                if (!getTypeParameter(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (hasReceiverType() && !getReceiverType().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (hasSetterValueParameter() && !getSetterValueParameter().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else {
                this.memoizedIsInitialized = 1;
                return true;
            }
        } else {
            this.memoizedIsInitialized = 0;
            return false;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.a0(1, this.oldFlags_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.a0(2, this.name_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.d0(3, this.returnType_);
        }
        for (int i = 0; i < this.typeParameter_.size(); i++) {
            codedOutputStream.d0(4, this.typeParameter_.get(i));
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.d0(5, this.receiverType_);
        }
        if ((this.bitField0_ & 128) == 128) {
            codedOutputStream.d0(6, this.setterValueParameter_);
        }
        if ((this.bitField0_ & 256) == 256) {
            codedOutputStream.a0(7, this.getterFlags_);
        }
        if ((this.bitField0_ & 512) == 512) {
            codedOutputStream.a0(8, this.setterFlags_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.a0(9, this.returnTypeId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            codedOutputStream.a0(10, this.receiverTypeId_);
        }
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.a0(11, this.flags_);
        }
        for (int i2 = 0; i2 < this.versionRequirement_.size(); i2++) {
            codedOutputStream.a0(31, this.versionRequirement_.get(i2).intValue());
        }
        newExtensionWriter.a(19000, codedOutputStream);
        codedOutputStream.i0(this.unknownFields);
    }

    public static Builder newBuilder(ProtoBuf$Property protoBuf$Property) {
        return newBuilder().mergeFrom(protoBuf$Property);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$Property getDefaultInstanceForType() {
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

    private ProtoBuf$Property(GeneratedMessageLite.ExtendableBuilder<ProtoBuf$Property, ?> extendableBuilder) {
        super(extendableBuilder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = extendableBuilder.getUnknownFields();
    }

    private ProtoBuf$Property(boolean z) {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v17, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> */
    /* JADX WARN: Multi-variable type inference failed */
    private ProtoBuf$Property(CodedInputStream codedInputStream, c cVar) throws InvalidProtocolBufferException {
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
                ProtoBuf$Type.Builder builder = null;
                ProtoBuf$ValueParameter.Builder builder2 = null;
                ProtoBuf$Type.Builder builder3 = null;
                switch (K) {
                    case 0:
                        break;
                    case 8:
                        this.bitField0_ |= 2;
                        this.oldFlags_ = codedInputStream.s();
                        continue;
                    case 16:
                        this.bitField0_ |= 4;
                        this.name_ = codedInputStream.s();
                        continue;
                    case 26:
                        builder = (this.bitField0_ & 8) == 8 ? this.returnType_.toBuilder() : builder;
                        ProtoBuf$Type protoBuf$Type = (ProtoBuf$Type) codedInputStream.u(ProtoBuf$Type.PARSER, cVar);
                        this.returnType_ = protoBuf$Type;
                        if (builder != null) {
                            builder.mergeFrom(protoBuf$Type);
                            this.returnType_ = builder.buildPartial();
                        }
                        this.bitField0_ |= 8;
                        continue;
                    case 34:
                        if (!(z2 & true)) {
                            this.typeParameter_ = new ArrayList();
                            z2 |= true;
                        }
                        this.typeParameter_.add(codedInputStream.u(ProtoBuf$TypeParameter.PARSER, cVar));
                        continue;
                    case 42:
                        builder3 = (this.bitField0_ & 32) == 32 ? this.receiverType_.toBuilder() : builder3;
                        ProtoBuf$Type protoBuf$Type2 = (ProtoBuf$Type) codedInputStream.u(ProtoBuf$Type.PARSER, cVar);
                        this.receiverType_ = protoBuf$Type2;
                        if (builder3 != null) {
                            builder3.mergeFrom(protoBuf$Type2);
                            this.receiverType_ = builder3.buildPartial();
                        }
                        this.bitField0_ |= 32;
                        continue;
                    case 50:
                        builder2 = (this.bitField0_ & 128) == 128 ? this.setterValueParameter_.toBuilder() : builder2;
                        ProtoBuf$ValueParameter protoBuf$ValueParameter = (ProtoBuf$ValueParameter) codedInputStream.u(ProtoBuf$ValueParameter.PARSER, cVar);
                        this.setterValueParameter_ = protoBuf$ValueParameter;
                        if (builder2 != null) {
                            builder2.mergeFrom(protoBuf$ValueParameter);
                            this.setterValueParameter_ = builder2.buildPartial();
                        }
                        this.bitField0_ |= 128;
                        continue;
                    case 56:
                        this.bitField0_ |= 256;
                        this.getterFlags_ = codedInputStream.s();
                        continue;
                    case 64:
                        this.bitField0_ |= 512;
                        this.setterFlags_ = codedInputStream.s();
                        continue;
                    case 72:
                        this.bitField0_ |= 16;
                        this.returnTypeId_ = codedInputStream.s();
                        continue;
                    case 80:
                        this.bitField0_ |= 64;
                        this.receiverTypeId_ = codedInputStream.s();
                        continue;
                    case 88:
                        this.bitField0_ |= 1;
                        this.flags_ = codedInputStream.s();
                        continue;
                    case 248:
                        if (!(z2 & true)) {
                            this.versionRequirement_ = new ArrayList();
                            z2 |= true;
                        }
                        this.versionRequirement_.add(Integer.valueOf(codedInputStream.s()));
                        continue;
                    case 250:
                        int j = codedInputStream.j(codedInputStream.A());
                        if (!(z2 & true) && codedInputStream.e() > 0) {
                            this.versionRequirement_ = new ArrayList();
                            z2 |= true;
                        }
                        while (codedInputStream.e() > 0) {
                            this.versionRequirement_.add(Integer.valueOf(codedInputStream.s()));
                        }
                        codedInputStream.i(j);
                        continue;
                    default:
                        if (parseUnknownField(codedInputStream, J, cVar, K)) {
                            continue;
                        }
                        break;
                }
                z = true;
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e2) {
                throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
            } catch (Throwable th) {
                if (z2 & true) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                }
                if (z2 & true) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        }
        if (z2 & true) {
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
