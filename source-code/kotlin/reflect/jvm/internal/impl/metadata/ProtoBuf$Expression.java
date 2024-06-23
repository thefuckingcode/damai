package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
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
public final class ProtoBuf$Expression extends GeneratedMessageLite implements ProtoBuf$ExpressionOrBuilder {
    public static Parser<ProtoBuf$Expression> PARSER = new a();
    private static final ProtoBuf$Expression defaultInstance;
    private List<ProtoBuf$Expression> andArgument_;
    private int bitField0_;
    private ConstantValue constantValue_;
    private int flags_;
    private int isInstanceTypeId_;
    private ProtoBuf$Type isInstanceType_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<ProtoBuf$Expression> orArgument_;
    private final ByteString unknownFields;
    private int valueParameterReference_;

    /* compiled from: Taobao */
    public static final class Builder extends GeneratedMessageLite.Builder<ProtoBuf$Expression, Builder> implements ProtoBuf$ExpressionOrBuilder {
        private List<ProtoBuf$Expression> andArgument_ = Collections.emptyList();
        private int bitField0_;
        private ConstantValue constantValue_ = ConstantValue.TRUE;
        private int flags_;
        private int isInstanceTypeId_;
        private ProtoBuf$Type isInstanceType_ = ProtoBuf$Type.getDefaultInstance();
        private List<ProtoBuf$Expression> orArgument_ = Collections.emptyList();
        private int valueParameterReference_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        /* access modifiers changed from: private */
        public static Builder create() {
            return new Builder();
        }

        private void ensureAndArgumentIsMutable() {
            if ((this.bitField0_ & 32) != 32) {
                this.andArgument_ = new ArrayList(this.andArgument_);
                this.bitField0_ |= 32;
            }
        }

        private void ensureOrArgumentIsMutable() {
            if ((this.bitField0_ & 64) != 64) {
                this.orArgument_ = new ArrayList(this.orArgument_);
                this.bitField0_ |= 64;
            }
        }

        private void maybeForceBuilderInitialization() {
        }

        public ProtoBuf$Expression buildPartial() {
            ProtoBuf$Expression protoBuf$Expression = new ProtoBuf$Expression(this);
            int i = this.bitField0_;
            int i2 = 1;
            if ((i & 1) != 1) {
                i2 = 0;
            }
            protoBuf$Expression.flags_ = this.flags_;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            protoBuf$Expression.valueParameterReference_ = this.valueParameterReference_;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            protoBuf$Expression.constantValue_ = this.constantValue_;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            protoBuf$Expression.isInstanceType_ = this.isInstanceType_;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            protoBuf$Expression.isInstanceTypeId_ = this.isInstanceTypeId_;
            if ((this.bitField0_ & 32) == 32) {
                this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
                this.bitField0_ &= -33;
            }
            protoBuf$Expression.andArgument_ = this.andArgument_;
            if ((this.bitField0_ & 64) == 64) {
                this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
                this.bitField0_ &= -65;
            }
            protoBuf$Expression.orArgument_ = this.orArgument_;
            protoBuf$Expression.bitField0_ = i2;
            return protoBuf$Expression;
        }

        public ProtoBuf$Expression getAndArgument(int i) {
            return this.andArgument_.get(i);
        }

        public int getAndArgumentCount() {
            return this.andArgument_.size();
        }

        public ProtoBuf$Type getIsInstanceType() {
            return this.isInstanceType_;
        }

        public ProtoBuf$Expression getOrArgument(int i) {
            return this.orArgument_.get(i);
        }

        public int getOrArgumentCount() {
            return this.orArgument_.size();
        }

        public boolean hasIsInstanceType() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            if (hasIsInstanceType() && !getIsInstanceType().isInitialized()) {
                return false;
            }
            for (int i = 0; i < getAndArgumentCount(); i++) {
                if (!getAndArgument(i).isInitialized()) {
                    return false;
                }
            }
            for (int i2 = 0; i2 < getOrArgumentCount(); i2++) {
                if (!getOrArgument(i2).isInitialized()) {
                    return false;
                }
            }
            return true;
        }

        public Builder mergeIsInstanceType(ProtoBuf$Type protoBuf$Type) {
            if ((this.bitField0_ & 8) != 8 || this.isInstanceType_ == ProtoBuf$Type.getDefaultInstance()) {
                this.isInstanceType_ = protoBuf$Type;
            } else {
                this.isInstanceType_ = ProtoBuf$Type.newBuilder(this.isInstanceType_).mergeFrom(protoBuf$Type).buildPartial();
            }
            this.bitField0_ |= 8;
            return this;
        }

        public Builder setConstantValue(ConstantValue constantValue) {
            Objects.requireNonNull(constantValue);
            this.bitField0_ |= 4;
            this.constantValue_ = constantValue;
            return this;
        }

        public Builder setFlags(int i) {
            this.bitField0_ |= 1;
            this.flags_ = i;
            return this;
        }

        public Builder setIsInstanceTypeId(int i) {
            this.bitField0_ |= 16;
            this.isInstanceTypeId_ = i;
            return this;
        }

        public Builder setValueParameterReference(int i) {
            this.bitField0_ |= 2;
            this.valueParameterReference_ = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$Expression build() {
            ProtoBuf$Expression buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public ProtoBuf$Expression getDefaultInstanceForType() {
            return ProtoBuf$Expression.getDefaultInstance();
        }

        @Override // java.lang.Object, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        public Builder mergeFrom(ProtoBuf$Expression protoBuf$Expression) {
            if (protoBuf$Expression == ProtoBuf$Expression.getDefaultInstance()) {
                return this;
            }
            if (protoBuf$Expression.hasFlags()) {
                setFlags(protoBuf$Expression.getFlags());
            }
            if (protoBuf$Expression.hasValueParameterReference()) {
                setValueParameterReference(protoBuf$Expression.getValueParameterReference());
            }
            if (protoBuf$Expression.hasConstantValue()) {
                setConstantValue(protoBuf$Expression.getConstantValue());
            }
            if (protoBuf$Expression.hasIsInstanceType()) {
                mergeIsInstanceType(protoBuf$Expression.getIsInstanceType());
            }
            if (protoBuf$Expression.hasIsInstanceTypeId()) {
                setIsInstanceTypeId(protoBuf$Expression.getIsInstanceTypeId());
            }
            if (!protoBuf$Expression.andArgument_.isEmpty()) {
                if (this.andArgument_.isEmpty()) {
                    this.andArgument_ = protoBuf$Expression.andArgument_;
                    this.bitField0_ &= -33;
                } else {
                    ensureAndArgumentIsMutable();
                    this.andArgument_.addAll(protoBuf$Expression.andArgument_);
                }
            }
            if (!protoBuf$Expression.orArgument_.isEmpty()) {
                if (this.orArgument_.isEmpty()) {
                    this.orArgument_ = protoBuf$Expression.orArgument_;
                    this.bitField0_ &= -65;
                } else {
                    ensureOrArgumentIsMutable();
                    this.orArgument_.addAll(protoBuf$Expression.orArgument_);
                }
            }
            setUnknownFields(getUnknownFields().b(protoBuf$Expression.unknownFields));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, c cVar) throws IOException {
            Throwable th;
            ProtoBuf$Expression protoBuf$Expression;
            ProtoBuf$Expression protoBuf$Expression2 = null;
            try {
                ProtoBuf$Expression parsePartialFrom = ProtoBuf$Expression.PARSER.parsePartialFrom(codedInputStream, cVar);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                protoBuf$Expression = (ProtoBuf$Expression) e.getUnfinishedMessage();
                throw e;
            } catch (Throwable th2) {
                th = th2;
                protoBuf$Expression2 = protoBuf$Expression;
            }
            if (protoBuf$Expression2 != null) {
                mergeFrom(protoBuf$Expression2);
            }
            throw th;
        }
    }

    /* compiled from: Taobao */
    public enum ConstantValue implements Internal.EnumLite {
        TRUE(0, 0),
        FALSE(1, 1),
        NULL(2, 2);
        
        private static Internal.EnumLiteMap<ConstantValue> internalValueMap = new a();
        private final int value;

        /* compiled from: Taobao */
        static class a implements Internal.EnumLiteMap<ConstantValue> {
            a() {
            }

            /* renamed from: a */
            public ConstantValue findValueByNumber(int i) {
                return ConstantValue.valueOf(i);
            }
        }

        private ConstantValue(int i, int i2) {
            this.value = i2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static ConstantValue valueOf(int i) {
            if (i == 0) {
                return TRUE;
            }
            if (i == 1) {
                return FALSE;
            }
            if (i != 2) {
                return null;
            }
            return NULL;
        }
    }

    /* compiled from: Taobao */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.a<ProtoBuf$Expression> {
        a() {
        }

        /* renamed from: i */
        public ProtoBuf$Expression parsePartialFrom(CodedInputStream codedInputStream, c cVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$Expression(codedInputStream, cVar);
        }
    }

    static {
        ProtoBuf$Expression protoBuf$Expression = new ProtoBuf$Expression(true);
        defaultInstance = protoBuf$Expression;
        protoBuf$Expression.initFields();
    }

    public static ProtoBuf$Expression getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.flags_ = 0;
        this.valueParameterReference_ = 0;
        this.constantValue_ = ConstantValue.TRUE;
        this.isInstanceType_ = ProtoBuf$Type.getDefaultInstance();
        this.isInstanceTypeId_ = 0;
        this.andArgument_ = Collections.emptyList();
        this.orArgument_ = Collections.emptyList();
    }

    public static Builder newBuilder() {
        return Builder.create();
    }

    public ProtoBuf$Expression getAndArgument(int i) {
        return this.andArgument_.get(i);
    }

    public int getAndArgumentCount() {
        return this.andArgument_.size();
    }

    public ConstantValue getConstantValue() {
        return this.constantValue_;
    }

    public int getFlags() {
        return this.flags_;
    }

    public ProtoBuf$Type getIsInstanceType() {
        return this.isInstanceType_;
    }

    public int getIsInstanceTypeId() {
        return this.isInstanceTypeId_;
    }

    public ProtoBuf$Expression getOrArgument(int i) {
        return this.orArgument_.get(i);
    }

    public int getOrArgumentCount() {
        return this.orArgument_.size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
    public Parser<ProtoBuf$Expression> getParserForType() {
        return PARSER;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int o = (this.bitField0_ & 1) == 1 ? CodedOutputStream.o(1, this.flags_) + 0 : 0;
        if ((this.bitField0_ & 2) == 2) {
            o += CodedOutputStream.o(2, this.valueParameterReference_);
        }
        if ((this.bitField0_ & 4) == 4) {
            o += CodedOutputStream.h(3, this.constantValue_.getNumber());
        }
        if ((this.bitField0_ & 8) == 8) {
            o += CodedOutputStream.s(4, this.isInstanceType_);
        }
        if ((this.bitField0_ & 16) == 16) {
            o += CodedOutputStream.o(5, this.isInstanceTypeId_);
        }
        for (int i2 = 0; i2 < this.andArgument_.size(); i2++) {
            o += CodedOutputStream.s(6, this.andArgument_.get(i2));
        }
        for (int i3 = 0; i3 < this.orArgument_.size(); i3++) {
            o += CodedOutputStream.s(7, this.orArgument_.get(i3));
        }
        int size = o + this.unknownFields.size();
        this.memoizedSerializedSize = size;
        return size;
    }

    public int getValueParameterReference() {
        return this.valueParameterReference_;
    }

    public boolean hasConstantValue() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasIsInstanceType() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasIsInstanceTypeId() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasValueParameterReference() {
        return (this.bitField0_ & 2) == 2;
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
        if (!hasIsInstanceType() || getIsInstanceType().isInitialized()) {
            for (int i = 0; i < getAndArgumentCount(); i++) {
                if (!getAndArgument(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (int i2 = 0; i2 < getOrArgumentCount(); i2++) {
                if (!getOrArgument(i2).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }
        this.memoizedIsInitialized = 0;
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.a0(1, this.flags_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.a0(2, this.valueParameterReference_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.S(3, this.constantValue_.getNumber());
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.d0(4, this.isInstanceType_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.a0(5, this.isInstanceTypeId_);
        }
        for (int i = 0; i < this.andArgument_.size(); i++) {
            codedOutputStream.d0(6, this.andArgument_.get(i));
        }
        for (int i2 = 0; i2 < this.orArgument_.size(); i2++) {
            codedOutputStream.d0(7, this.orArgument_.get(i2));
        }
        codedOutputStream.i0(this.unknownFields);
    }

    public static Builder newBuilder(ProtoBuf$Expression protoBuf$Expression) {
        return newBuilder().mergeFrom(protoBuf$Expression);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$Expression getDefaultInstanceForType() {
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

    private ProtoBuf$Expression(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = builder.getUnknownFields();
    }

    private ProtoBuf$Expression(boolean z) {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v20, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression> */
    /* JADX DEBUG: Multi-variable search result rejected for r7v23, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression> */
    /* JADX WARN: Multi-variable type inference failed */
    private ProtoBuf$Expression(CodedInputStream codedInputStream, c cVar) throws InvalidProtocolBufferException {
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
                    if (K == 8) {
                        this.bitField0_ |= 1;
                        this.flags_ = codedInputStream.s();
                    } else if (K == 16) {
                        this.bitField0_ |= 2;
                        this.valueParameterReference_ = codedInputStream.s();
                    } else if (K == 24) {
                        int n2 = codedInputStream.n();
                        ConstantValue valueOf = ConstantValue.valueOf(n2);
                        if (valueOf == null) {
                            J.o0(K);
                            J.o0(n2);
                        } else {
                            this.bitField0_ |= 4;
                            this.constantValue_ = valueOf;
                        }
                    } else if (K == 34) {
                        ProtoBuf$Type.Builder builder = (this.bitField0_ & 8) == 8 ? this.isInstanceType_.toBuilder() : null;
                        ProtoBuf$Type protoBuf$Type = (ProtoBuf$Type) codedInputStream.u(ProtoBuf$Type.PARSER, cVar);
                        this.isInstanceType_ = protoBuf$Type;
                        if (builder != null) {
                            builder.mergeFrom(protoBuf$Type);
                            this.isInstanceType_ = builder.buildPartial();
                        }
                        this.bitField0_ |= 8;
                    } else if (K == 40) {
                        this.bitField0_ |= 16;
                        this.isInstanceTypeId_ = codedInputStream.s();
                    } else if (K == 50) {
                        if (!(z2 & true)) {
                            this.andArgument_ = new ArrayList();
                            z2 |= true;
                        }
                        this.andArgument_.add(codedInputStream.u(PARSER, cVar));
                    } else if (K == 58) {
                        if (!(z2 & true)) {
                            this.orArgument_ = new ArrayList();
                            z2 |= true;
                        }
                        this.orArgument_.add(codedInputStream.u(PARSER, cVar));
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
                    this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
                }
                if (z2 & true) {
                    this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
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
            this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
        }
        if (z2 & true) {
            this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
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
