package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.c;

/* compiled from: Taobao */
public final class ProtoBuf$Function extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Function> implements ProtoBuf$FunctionOrBuilder {
    public static Parser<ProtoBuf$Function> PARSER = new a();
    private static final ProtoBuf$Function defaultInstance;
    private int bitField0_;
    private ProtoBuf$Contract contract_;
    private int flags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private int oldFlags_;
    private int receiverTypeId_;
    private ProtoBuf$Type receiverType_;
    private int returnTypeId_;
    private ProtoBuf$Type returnType_;
    private List<ProtoBuf$TypeParameter> typeParameter_;
    private ProtoBuf$TypeTable typeTable_;
    private final ByteString unknownFields;
    private List<ProtoBuf$ValueParameter> valueParameter_;
    private List<Integer> versionRequirement_;

    /* compiled from: Taobao */
    public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ProtoBuf$Function, Builder> implements ProtoBuf$FunctionOrBuilder {
        private int bitField0_;
        private ProtoBuf$Contract contract_ = ProtoBuf$Contract.getDefaultInstance();
        private int flags_ = 6;
        private int name_;
        private int oldFlags_ = 6;
        private int receiverTypeId_;
        private ProtoBuf$Type receiverType_ = ProtoBuf$Type.getDefaultInstance();
        private int returnTypeId_;
        private ProtoBuf$Type returnType_ = ProtoBuf$Type.getDefaultInstance();
        private List<ProtoBuf$TypeParameter> typeParameter_ = Collections.emptyList();
        private ProtoBuf$TypeTable typeTable_ = ProtoBuf$TypeTable.getDefaultInstance();
        private List<ProtoBuf$ValueParameter> valueParameter_ = Collections.emptyList();
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

        private void ensureValueParameterIsMutable() {
            if ((this.bitField0_ & 256) != 256) {
                this.valueParameter_ = new ArrayList(this.valueParameter_);
                this.bitField0_ |= 256;
            }
        }

        private void ensureVersionRequirementIsMutable() {
            if ((this.bitField0_ & 1024) != 1024) {
                this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                this.bitField0_ |= 1024;
            }
        }

        private void maybeForceBuilderInitialization() {
        }

        public ProtoBuf$Function buildPartial() {
            ProtoBuf$Function protoBuf$Function = new ProtoBuf$Function(this);
            int i = this.bitField0_;
            int i2 = 1;
            if ((i & 1) != 1) {
                i2 = 0;
            }
            protoBuf$Function.flags_ = this.flags_;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            protoBuf$Function.oldFlags_ = this.oldFlags_;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            protoBuf$Function.name_ = this.name_;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            protoBuf$Function.returnType_ = this.returnType_;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            protoBuf$Function.returnTypeId_ = this.returnTypeId_;
            if ((this.bitField0_ & 32) == 32) {
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                this.bitField0_ &= -33;
            }
            protoBuf$Function.typeParameter_ = this.typeParameter_;
            if ((i & 64) == 64) {
                i2 |= 32;
            }
            protoBuf$Function.receiverType_ = this.receiverType_;
            if ((i & 128) == 128) {
                i2 |= 64;
            }
            protoBuf$Function.receiverTypeId_ = this.receiverTypeId_;
            if ((this.bitField0_ & 256) == 256) {
                this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                this.bitField0_ &= -257;
            }
            protoBuf$Function.valueParameter_ = this.valueParameter_;
            if ((i & 512) == 512) {
                i2 |= 128;
            }
            protoBuf$Function.typeTable_ = this.typeTable_;
            if ((this.bitField0_ & 1024) == 1024) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -1025;
            }
            protoBuf$Function.versionRequirement_ = this.versionRequirement_;
            if ((i & 2048) == 2048) {
                i2 |= 256;
            }
            protoBuf$Function.contract_ = this.contract_;
            protoBuf$Function.bitField0_ = i2;
            return protoBuf$Function;
        }

        public ProtoBuf$Contract getContract() {
            return this.contract_;
        }

        public ProtoBuf$Type getReceiverType() {
            return this.receiverType_;
        }

        public ProtoBuf$Type getReturnType() {
            return this.returnType_;
        }

        public ProtoBuf$TypeParameter getTypeParameter(int i) {
            return this.typeParameter_.get(i);
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public ProtoBuf$TypeTable getTypeTable() {
            return this.typeTable_;
        }

        public ProtoBuf$ValueParameter getValueParameter(int i) {
            return this.valueParameter_.get(i);
        }

        public int getValueParameterCount() {
            return this.valueParameter_.size();
        }

        public boolean hasContract() {
            return (this.bitField0_ & 2048) == 2048;
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

        public boolean hasTypeTable() {
            return (this.bitField0_ & 512) == 512;
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
            for (int i2 = 0; i2 < getValueParameterCount(); i2++) {
                if (!getValueParameter(i2).isInitialized()) {
                    return false;
                }
            }
            if (hasTypeTable() && !getTypeTable().isInitialized()) {
                return false;
            }
            if ((!hasContract() || getContract().isInitialized()) && extensionsAreInitialized()) {
                return true;
            }
            return false;
        }

        public Builder mergeContract(ProtoBuf$Contract protoBuf$Contract) {
            if ((this.bitField0_ & 2048) != 2048 || this.contract_ == ProtoBuf$Contract.getDefaultInstance()) {
                this.contract_ = protoBuf$Contract;
            } else {
                this.contract_ = ProtoBuf$Contract.newBuilder(this.contract_).mergeFrom(protoBuf$Contract).buildPartial();
            }
            this.bitField0_ |= 2048;
            return this;
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

        public Builder mergeTypeTable(ProtoBuf$TypeTable protoBuf$TypeTable) {
            if ((this.bitField0_ & 512) != 512 || this.typeTable_ == ProtoBuf$TypeTable.getDefaultInstance()) {
                this.typeTable_ = protoBuf$TypeTable;
            } else {
                this.typeTable_ = ProtoBuf$TypeTable.newBuilder(this.typeTable_).mergeFrom(protoBuf$TypeTable).buildPartial();
            }
            this.bitField0_ |= 512;
            return this;
        }

        public Builder setFlags(int i) {
            this.bitField0_ |= 1;
            this.flags_ = i;
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

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$Function build() {
            ProtoBuf$Function buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public ProtoBuf$Function getDefaultInstanceForType() {
            return ProtoBuf$Function.getDefaultInstance();
        }

        public Builder mergeFrom(ProtoBuf$Function protoBuf$Function) {
            if (protoBuf$Function == ProtoBuf$Function.getDefaultInstance()) {
                return this;
            }
            if (protoBuf$Function.hasFlags()) {
                setFlags(protoBuf$Function.getFlags());
            }
            if (protoBuf$Function.hasOldFlags()) {
                setOldFlags(protoBuf$Function.getOldFlags());
            }
            if (protoBuf$Function.hasName()) {
                setName(protoBuf$Function.getName());
            }
            if (protoBuf$Function.hasReturnType()) {
                mergeReturnType(protoBuf$Function.getReturnType());
            }
            if (protoBuf$Function.hasReturnTypeId()) {
                setReturnTypeId(protoBuf$Function.getReturnTypeId());
            }
            if (!protoBuf$Function.typeParameter_.isEmpty()) {
                if (this.typeParameter_.isEmpty()) {
                    this.typeParameter_ = protoBuf$Function.typeParameter_;
                    this.bitField0_ &= -33;
                } else {
                    ensureTypeParameterIsMutable();
                    this.typeParameter_.addAll(protoBuf$Function.typeParameter_);
                }
            }
            if (protoBuf$Function.hasReceiverType()) {
                mergeReceiverType(protoBuf$Function.getReceiverType());
            }
            if (protoBuf$Function.hasReceiverTypeId()) {
                setReceiverTypeId(protoBuf$Function.getReceiverTypeId());
            }
            if (!protoBuf$Function.valueParameter_.isEmpty()) {
                if (this.valueParameter_.isEmpty()) {
                    this.valueParameter_ = protoBuf$Function.valueParameter_;
                    this.bitField0_ &= -257;
                } else {
                    ensureValueParameterIsMutable();
                    this.valueParameter_.addAll(protoBuf$Function.valueParameter_);
                }
            }
            if (protoBuf$Function.hasTypeTable()) {
                mergeTypeTable(protoBuf$Function.getTypeTable());
            }
            if (!protoBuf$Function.versionRequirement_.isEmpty()) {
                if (this.versionRequirement_.isEmpty()) {
                    this.versionRequirement_ = protoBuf$Function.versionRequirement_;
                    this.bitField0_ &= -1025;
                } else {
                    ensureVersionRequirementIsMutable();
                    this.versionRequirement_.addAll(protoBuf$Function.versionRequirement_);
                }
            }
            if (protoBuf$Function.hasContract()) {
                mergeContract(protoBuf$Function.getContract());
            }
            mergeExtensionFields(protoBuf$Function);
            setUnknownFields(getUnknownFields().b(protoBuf$Function.unknownFields));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, java.lang.Object, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, c cVar) throws IOException {
            Throwable th;
            ProtoBuf$Function protoBuf$Function;
            ProtoBuf$Function protoBuf$Function2 = null;
            try {
                ProtoBuf$Function parsePartialFrom = ProtoBuf$Function.PARSER.parsePartialFrom(codedInputStream, cVar);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                protoBuf$Function = (ProtoBuf$Function) e.getUnfinishedMessage();
                throw e;
            } catch (Throwable th2) {
                th = th2;
                protoBuf$Function2 = protoBuf$Function;
            }
            if (protoBuf$Function2 != null) {
                mergeFrom(protoBuf$Function2);
            }
            throw th;
        }
    }

    /* compiled from: Taobao */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.a<ProtoBuf$Function> {
        a() {
        }

        /* renamed from: i */
        public ProtoBuf$Function parsePartialFrom(CodedInputStream codedInputStream, c cVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$Function(codedInputStream, cVar);
        }
    }

    static {
        ProtoBuf$Function protoBuf$Function = new ProtoBuf$Function(true);
        defaultInstance = protoBuf$Function;
        protoBuf$Function.initFields();
    }

    public static ProtoBuf$Function getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.flags_ = 6;
        this.oldFlags_ = 6;
        this.name_ = 0;
        this.returnType_ = ProtoBuf$Type.getDefaultInstance();
        this.returnTypeId_ = 0;
        this.typeParameter_ = Collections.emptyList();
        this.receiverType_ = ProtoBuf$Type.getDefaultInstance();
        this.receiverTypeId_ = 0;
        this.valueParameter_ = Collections.emptyList();
        this.typeTable_ = ProtoBuf$TypeTable.getDefaultInstance();
        this.versionRequirement_ = Collections.emptyList();
        this.contract_ = ProtoBuf$Contract.getDefaultInstance();
    }

    public static Builder newBuilder() {
        return Builder.create();
    }

    public static ProtoBuf$Function parseFrom(InputStream inputStream, c cVar) throws IOException {
        return PARSER.parseFrom(inputStream, cVar);
    }

    public ProtoBuf$Contract getContract() {
        return this.contract_;
    }

    public int getFlags() {
        return this.flags_;
    }

    public int getName() {
        return this.name_;
    }

    public int getOldFlags() {
        return this.oldFlags_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
    public Parser<ProtoBuf$Function> getParserForType() {
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
        for (int i3 = 0; i3 < this.valueParameter_.size(); i3++) {
            o += CodedOutputStream.s(6, this.valueParameter_.get(i3));
        }
        if ((this.bitField0_ & 16) == 16) {
            o += CodedOutputStream.o(7, this.returnTypeId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            o += CodedOutputStream.o(8, this.receiverTypeId_);
        }
        if ((this.bitField0_ & 1) == 1) {
            o += CodedOutputStream.o(9, this.flags_);
        }
        if ((this.bitField0_ & 128) == 128) {
            o += CodedOutputStream.s(30, this.typeTable_);
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.versionRequirement_.size(); i5++) {
            i4 += CodedOutputStream.p(this.versionRequirement_.get(i5).intValue());
        }
        int size = o + i4 + (getVersionRequirementList().size() * 2);
        if ((this.bitField0_ & 256) == 256) {
            size += CodedOutputStream.s(32, this.contract_);
        }
        int extensionsSerializedSize = size + extensionsSerializedSize() + this.unknownFields.size();
        this.memoizedSerializedSize = extensionsSerializedSize;
        return extensionsSerializedSize;
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

    public ProtoBuf$TypeTable getTypeTable() {
        return this.typeTable_;
    }

    public ProtoBuf$ValueParameter getValueParameter(int i) {
        return this.valueParameter_.get(i);
    }

    public int getValueParameterCount() {
        return this.valueParameter_.size();
    }

    public List<ProtoBuf$ValueParameter> getValueParameterList() {
        return this.valueParameter_;
    }

    public List<Integer> getVersionRequirementList() {
        return this.versionRequirement_;
    }

    public boolean hasContract() {
        return (this.bitField0_ & 256) == 256;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 1) == 1;
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

    public boolean hasTypeTable() {
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
            if (!hasReceiverType() || getReceiverType().isInitialized()) {
                for (int i2 = 0; i2 < getValueParameterCount(); i2++) {
                    if (!getValueParameter(i2).isInitialized()) {
                        this.memoizedIsInitialized = 0;
                        return false;
                    }
                }
                if (hasTypeTable() && !getTypeTable().isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                } else if (hasContract() && !getContract().isInitialized()) {
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
        for (int i2 = 0; i2 < this.valueParameter_.size(); i2++) {
            codedOutputStream.d0(6, this.valueParameter_.get(i2));
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.a0(7, this.returnTypeId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            codedOutputStream.a0(8, this.receiverTypeId_);
        }
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.a0(9, this.flags_);
        }
        if ((this.bitField0_ & 128) == 128) {
            codedOutputStream.d0(30, this.typeTable_);
        }
        for (int i3 = 0; i3 < this.versionRequirement_.size(); i3++) {
            codedOutputStream.a0(31, this.versionRequirement_.get(i3).intValue());
        }
        if ((this.bitField0_ & 256) == 256) {
            codedOutputStream.d0(32, this.contract_);
        }
        newExtensionWriter.a(19000, codedOutputStream);
        codedOutputStream.i0(this.unknownFields);
    }

    public static Builder newBuilder(ProtoBuf$Function protoBuf$Function) {
        return newBuilder().mergeFrom(protoBuf$Function);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$Function getDefaultInstanceForType() {
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

    private ProtoBuf$Function(GeneratedMessageLite.ExtendableBuilder<ProtoBuf$Function, ?> extendableBuilder) {
        super(extendableBuilder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = extendableBuilder.getUnknownFields();
    }

    private ProtoBuf$Function(boolean z) {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v17, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> */
    /* JADX DEBUG: Multi-variable search result rejected for r8v29, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter> */
    /* JADX WARN: Multi-variable type inference failed */
    private ProtoBuf$Function(CodedInputStream codedInputStream, c cVar) throws InvalidProtocolBufferException {
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
                ProtoBuf$Contract.Builder builder2 = null;
                ProtoBuf$TypeTable.Builder builder3 = null;
                ProtoBuf$Type.Builder builder4 = null;
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
                        builder4 = (this.bitField0_ & 32) == 32 ? this.receiverType_.toBuilder() : builder4;
                        ProtoBuf$Type protoBuf$Type2 = (ProtoBuf$Type) codedInputStream.u(ProtoBuf$Type.PARSER, cVar);
                        this.receiverType_ = protoBuf$Type2;
                        if (builder4 != null) {
                            builder4.mergeFrom(protoBuf$Type2);
                            this.receiverType_ = builder4.buildPartial();
                        }
                        this.bitField0_ |= 32;
                        continue;
                    case 50:
                        if (!(z2 & true)) {
                            this.valueParameter_ = new ArrayList();
                            z2 |= true;
                        }
                        this.valueParameter_.add(codedInputStream.u(ProtoBuf$ValueParameter.PARSER, cVar));
                        continue;
                    case 56:
                        this.bitField0_ |= 16;
                        this.returnTypeId_ = codedInputStream.s();
                        continue;
                    case 64:
                        this.bitField0_ |= 64;
                        this.receiverTypeId_ = codedInputStream.s();
                        continue;
                    case 72:
                        this.bitField0_ |= 1;
                        this.flags_ = codedInputStream.s();
                        continue;
                    case 242:
                        builder3 = (this.bitField0_ & 128) == 128 ? this.typeTable_.toBuilder() : builder3;
                        ProtoBuf$TypeTable protoBuf$TypeTable = (ProtoBuf$TypeTable) codedInputStream.u(ProtoBuf$TypeTable.PARSER, cVar);
                        this.typeTable_ = protoBuf$TypeTable;
                        if (builder3 != null) {
                            builder3.mergeFrom(protoBuf$TypeTable);
                            this.typeTable_ = builder3.buildPartial();
                        }
                        this.bitField0_ |= 128;
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
                    case 258:
                        builder2 = (this.bitField0_ & 256) == 256 ? this.contract_.toBuilder() : builder2;
                        ProtoBuf$Contract protoBuf$Contract = (ProtoBuf$Contract) codedInputStream.u(ProtoBuf$Contract.PARSER, cVar);
                        this.contract_ = protoBuf$Contract;
                        if (builder2 != null) {
                            builder2.mergeFrom(protoBuf$Contract);
                            this.contract_ = builder2.buildPartial();
                        }
                        this.bitField0_ |= 256;
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
                    this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
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
            this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
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
