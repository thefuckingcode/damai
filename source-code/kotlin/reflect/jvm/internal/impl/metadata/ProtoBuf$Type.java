package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.c;

/* compiled from: Taobao */
public final class ProtoBuf$Type extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Type> implements ProtoBuf$TypeOrBuilder {
    public static Parser<ProtoBuf$Type> PARSER = new a();
    private static final ProtoBuf$Type defaultInstance;
    private int abbreviatedTypeId_;
    private ProtoBuf$Type abbreviatedType_;
    private List<Argument> argument_;
    private int bitField0_;
    private int className_;
    private int flags_;
    private int flexibleTypeCapabilitiesId_;
    private int flexibleUpperBoundId_;
    private ProtoBuf$Type flexibleUpperBound_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private boolean nullable_;
    private int outerTypeId_;
    private ProtoBuf$Type outerType_;
    private int typeAliasName_;
    private int typeParameterName_;
    private int typeParameter_;
    private final ByteString unknownFields;

    /* compiled from: Taobao */
    public static final class Argument extends GeneratedMessageLite implements ArgumentOrBuilder {
        public static Parser<Argument> PARSER = new a();
        private static final Argument defaultInstance;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Projection projection_;
        private int typeId_;
        private ProtoBuf$Type type_;
        private final ByteString unknownFields;

        /* compiled from: Taobao */
        public static final class Builder extends GeneratedMessageLite.Builder<Argument, Builder> implements ArgumentOrBuilder {
            private int bitField0_;
            private Projection projection_ = Projection.INV;
            private int typeId_;
            private ProtoBuf$Type type_ = ProtoBuf$Type.getDefaultInstance();

            private Builder() {
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Argument buildPartial() {
                Argument argument = new Argument(this);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                argument.projection_ = this.projection_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                argument.type_ = this.type_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                argument.typeId_ = this.typeId_;
                argument.bitField0_ = i2;
                return argument;
            }

            public ProtoBuf$Type getType() {
                return this.type_;
            }

            public boolean hasType() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return !hasType() || getType().isInitialized();
            }

            public Builder mergeType(ProtoBuf$Type protoBuf$Type) {
                if ((this.bitField0_ & 2) != 2 || this.type_ == ProtoBuf$Type.getDefaultInstance()) {
                    this.type_ = protoBuf$Type;
                } else {
                    this.type_ = ProtoBuf$Type.newBuilder(this.type_).mergeFrom(protoBuf$Type).buildPartial();
                }
                this.bitField0_ |= 2;
                return this;
            }

            public Builder setProjection(Projection projection) {
                Objects.requireNonNull(projection);
                this.bitField0_ |= 1;
                this.projection_ = projection;
                return this;
            }

            public Builder setTypeId(int i) {
                this.bitField0_ |= 4;
                this.typeId_ = i;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Argument build() {
                Argument buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public Argument getDefaultInstanceForType() {
                return Argument.getDefaultInstance();
            }

            @Override // java.lang.Object, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(Argument argument) {
                if (argument == Argument.getDefaultInstance()) {
                    return this;
                }
                if (argument.hasProjection()) {
                    setProjection(argument.getProjection());
                }
                if (argument.hasType()) {
                    mergeType(argument.getType());
                }
                if (argument.hasTypeId()) {
                    setTypeId(argument.getTypeId());
                }
                setUnknownFields(getUnknownFields().b(argument.unknownFields));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, c cVar) throws IOException {
                Throwable th;
                Argument argument;
                Argument argument2 = null;
                try {
                    Argument parsePartialFrom = Argument.PARSER.parsePartialFrom(codedInputStream, cVar);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    argument = (Argument) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    argument2 = argument;
                }
                if (argument2 != null) {
                    mergeFrom(argument2);
                }
                throw th;
            }
        }

        /* compiled from: Taobao */
        public enum Projection implements Internal.EnumLite {
            IN(0, 0),
            OUT(1, 1),
            INV(2, 2),
            STAR(3, 3);
            
            private static Internal.EnumLiteMap<Projection> internalValueMap = new a();
            private final int value;

            /* compiled from: Taobao */
            static class a implements Internal.EnumLiteMap<Projection> {
                a() {
                }

                /* renamed from: a */
                public Projection findValueByNumber(int i) {
                    return Projection.valueOf(i);
                }
            }

            private Projection(int i, int i2) {
                this.value = i2;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static Projection valueOf(int i) {
                if (i == 0) {
                    return IN;
                }
                if (i == 1) {
                    return OUT;
                }
                if (i == 2) {
                    return INV;
                }
                if (i != 3) {
                    return null;
                }
                return STAR;
            }
        }

        /* compiled from: Taobao */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.a<Argument> {
            a() {
            }

            /* renamed from: i */
            public Argument parsePartialFrom(CodedInputStream codedInputStream, c cVar) throws InvalidProtocolBufferException {
                return new Argument(codedInputStream, cVar);
            }
        }

        static {
            Argument argument = new Argument(true);
            defaultInstance = argument;
            argument.initFields();
        }

        public static Argument getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.projection_ = Projection.INV;
            this.type_ = ProtoBuf$Type.getDefaultInstance();
            this.typeId_ = 0;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
        public Parser<Argument> getParserForType() {
            return PARSER;
        }

        public Projection getProjection() {
            return this.projection_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + CodedOutputStream.h(1, this.projection_.getNumber());
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.s(2, this.type_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += CodedOutputStream.o(3, this.typeId_);
            }
            int size = i2 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public ProtoBuf$Type getType() {
            return this.type_;
        }

        public int getTypeId() {
            return this.typeId_;
        }

        public boolean hasProjection() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasType() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasTypeId() {
            return (this.bitField0_ & 4) == 4;
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
            if (!hasType() || getType().isInitialized()) {
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
                codedOutputStream.S(1, this.projection_.getNumber());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.d0(2, this.type_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.a0(3, this.typeId_);
            }
            codedOutputStream.i0(this.unknownFields);
        }

        public static Builder newBuilder(Argument argument) {
            return newBuilder().mergeFrom(argument);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Argument getDefaultInstanceForType() {
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

        private Argument(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Argument(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private Argument(CodedInputStream codedInputStream, c cVar) throws InvalidProtocolBufferException {
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
                            int n2 = codedInputStream.n();
                            Projection valueOf = Projection.valueOf(n2);
                            if (valueOf == null) {
                                J.o0(K);
                                J.o0(n2);
                            } else {
                                this.bitField0_ |= 1;
                                this.projection_ = valueOf;
                            }
                        } else if (K == 18) {
                            Builder builder = (this.bitField0_ & 2) == 2 ? this.type_.toBuilder() : null;
                            ProtoBuf$Type protoBuf$Type = (ProtoBuf$Type) codedInputStream.u(ProtoBuf$Type.PARSER, cVar);
                            this.type_ = protoBuf$Type;
                            if (builder != null) {
                                builder.mergeFrom(protoBuf$Type);
                                this.type_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 2;
                        } else if (K == 24) {
                            this.bitField0_ |= 4;
                            this.typeId_ = codedInputStream.s();
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

    /* compiled from: Taobao */
    public interface ArgumentOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: Taobao */
    public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ProtoBuf$Type, Builder> implements ProtoBuf$TypeOrBuilder {
        private int abbreviatedTypeId_;
        private ProtoBuf$Type abbreviatedType_ = ProtoBuf$Type.getDefaultInstance();
        private List<Argument> argument_ = Collections.emptyList();
        private int bitField0_;
        private int className_;
        private int flags_;
        private int flexibleTypeCapabilitiesId_;
        private int flexibleUpperBoundId_;
        private ProtoBuf$Type flexibleUpperBound_ = ProtoBuf$Type.getDefaultInstance();
        private boolean nullable_;
        private int outerTypeId_;
        private ProtoBuf$Type outerType_ = ProtoBuf$Type.getDefaultInstance();
        private int typeAliasName_;
        private int typeParameterName_;
        private int typeParameter_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        /* access modifiers changed from: private */
        public static Builder create() {
            return new Builder();
        }

        private void ensureArgumentIsMutable() {
            if ((this.bitField0_ & 1) != 1) {
                this.argument_ = new ArrayList(this.argument_);
                this.bitField0_ |= 1;
            }
        }

        private void maybeForceBuilderInitialization() {
        }

        public ProtoBuf$Type buildPartial() {
            ProtoBuf$Type protoBuf$Type = new ProtoBuf$Type(this);
            int i = this.bitField0_;
            int i2 = 1;
            if ((i & 1) == 1) {
                this.argument_ = Collections.unmodifiableList(this.argument_);
                this.bitField0_ &= -2;
            }
            protoBuf$Type.argument_ = this.argument_;
            if ((i & 2) != 2) {
                i2 = 0;
            }
            protoBuf$Type.nullable_ = this.nullable_;
            if ((i & 4) == 4) {
                i2 |= 2;
            }
            protoBuf$Type.flexibleTypeCapabilitiesId_ = this.flexibleTypeCapabilitiesId_;
            if ((i & 8) == 8) {
                i2 |= 4;
            }
            protoBuf$Type.flexibleUpperBound_ = this.flexibleUpperBound_;
            if ((i & 16) == 16) {
                i2 |= 8;
            }
            protoBuf$Type.flexibleUpperBoundId_ = this.flexibleUpperBoundId_;
            if ((i & 32) == 32) {
                i2 |= 16;
            }
            protoBuf$Type.className_ = this.className_;
            if ((i & 64) == 64) {
                i2 |= 32;
            }
            protoBuf$Type.typeParameter_ = this.typeParameter_;
            if ((i & 128) == 128) {
                i2 |= 64;
            }
            protoBuf$Type.typeParameterName_ = this.typeParameterName_;
            if ((i & 256) == 256) {
                i2 |= 128;
            }
            protoBuf$Type.typeAliasName_ = this.typeAliasName_;
            if ((i & 512) == 512) {
                i2 |= 256;
            }
            protoBuf$Type.outerType_ = this.outerType_;
            if ((i & 1024) == 1024) {
                i2 |= 512;
            }
            protoBuf$Type.outerTypeId_ = this.outerTypeId_;
            if ((i & 2048) == 2048) {
                i2 |= 1024;
            }
            protoBuf$Type.abbreviatedType_ = this.abbreviatedType_;
            if ((i & 4096) == 4096) {
                i2 |= 2048;
            }
            protoBuf$Type.abbreviatedTypeId_ = this.abbreviatedTypeId_;
            if ((i & 8192) == 8192) {
                i2 |= 4096;
            }
            protoBuf$Type.flags_ = this.flags_;
            protoBuf$Type.bitField0_ = i2;
            return protoBuf$Type;
        }

        public ProtoBuf$Type getAbbreviatedType() {
            return this.abbreviatedType_;
        }

        public Argument getArgument(int i) {
            return this.argument_.get(i);
        }

        public int getArgumentCount() {
            return this.argument_.size();
        }

        public ProtoBuf$Type getFlexibleUpperBound() {
            return this.flexibleUpperBound_;
        }

        public ProtoBuf$Type getOuterType() {
            return this.outerType_;
        }

        public boolean hasAbbreviatedType() {
            return (this.bitField0_ & 2048) == 2048;
        }

        public boolean hasFlexibleUpperBound() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasOuterType() {
            return (this.bitField0_ & 512) == 512;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            for (int i = 0; i < getArgumentCount(); i++) {
                if (!getArgument(i).isInitialized()) {
                    return false;
                }
            }
            if (hasFlexibleUpperBound() && !getFlexibleUpperBound().isInitialized()) {
                return false;
            }
            if (hasOuterType() && !getOuterType().isInitialized()) {
                return false;
            }
            if ((!hasAbbreviatedType() || getAbbreviatedType().isInitialized()) && extensionsAreInitialized()) {
                return true;
            }
            return false;
        }

        public Builder mergeAbbreviatedType(ProtoBuf$Type protoBuf$Type) {
            if ((this.bitField0_ & 2048) != 2048 || this.abbreviatedType_ == ProtoBuf$Type.getDefaultInstance()) {
                this.abbreviatedType_ = protoBuf$Type;
            } else {
                this.abbreviatedType_ = ProtoBuf$Type.newBuilder(this.abbreviatedType_).mergeFrom(protoBuf$Type).buildPartial();
            }
            this.bitField0_ |= 2048;
            return this;
        }

        public Builder mergeFlexibleUpperBound(ProtoBuf$Type protoBuf$Type) {
            if ((this.bitField0_ & 8) != 8 || this.flexibleUpperBound_ == ProtoBuf$Type.getDefaultInstance()) {
                this.flexibleUpperBound_ = protoBuf$Type;
            } else {
                this.flexibleUpperBound_ = ProtoBuf$Type.newBuilder(this.flexibleUpperBound_).mergeFrom(protoBuf$Type).buildPartial();
            }
            this.bitField0_ |= 8;
            return this;
        }

        public Builder mergeOuterType(ProtoBuf$Type protoBuf$Type) {
            if ((this.bitField0_ & 512) != 512 || this.outerType_ == ProtoBuf$Type.getDefaultInstance()) {
                this.outerType_ = protoBuf$Type;
            } else {
                this.outerType_ = ProtoBuf$Type.newBuilder(this.outerType_).mergeFrom(protoBuf$Type).buildPartial();
            }
            this.bitField0_ |= 512;
            return this;
        }

        public Builder setAbbreviatedTypeId(int i) {
            this.bitField0_ |= 4096;
            this.abbreviatedTypeId_ = i;
            return this;
        }

        public Builder setClassName(int i) {
            this.bitField0_ |= 32;
            this.className_ = i;
            return this;
        }

        public Builder setFlags(int i) {
            this.bitField0_ |= 8192;
            this.flags_ = i;
            return this;
        }

        public Builder setFlexibleTypeCapabilitiesId(int i) {
            this.bitField0_ |= 4;
            this.flexibleTypeCapabilitiesId_ = i;
            return this;
        }

        public Builder setFlexibleUpperBoundId(int i) {
            this.bitField0_ |= 16;
            this.flexibleUpperBoundId_ = i;
            return this;
        }

        public Builder setNullable(boolean z) {
            this.bitField0_ |= 2;
            this.nullable_ = z;
            return this;
        }

        public Builder setOuterTypeId(int i) {
            this.bitField0_ |= 1024;
            this.outerTypeId_ = i;
            return this;
        }

        public Builder setTypeAliasName(int i) {
            this.bitField0_ |= 256;
            this.typeAliasName_ = i;
            return this;
        }

        public Builder setTypeParameter(int i) {
            this.bitField0_ |= 64;
            this.typeParameter_ = i;
            return this;
        }

        public Builder setTypeParameterName(int i) {
            this.bitField0_ |= 128;
            this.typeParameterName_ = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$Type build() {
            ProtoBuf$Type buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public ProtoBuf$Type getDefaultInstanceForType() {
            return ProtoBuf$Type.getDefaultInstance();
        }

        public Builder mergeFrom(ProtoBuf$Type protoBuf$Type) {
            if (protoBuf$Type == ProtoBuf$Type.getDefaultInstance()) {
                return this;
            }
            if (!protoBuf$Type.argument_.isEmpty()) {
                if (this.argument_.isEmpty()) {
                    this.argument_ = protoBuf$Type.argument_;
                    this.bitField0_ &= -2;
                } else {
                    ensureArgumentIsMutable();
                    this.argument_.addAll(protoBuf$Type.argument_);
                }
            }
            if (protoBuf$Type.hasNullable()) {
                setNullable(protoBuf$Type.getNullable());
            }
            if (protoBuf$Type.hasFlexibleTypeCapabilitiesId()) {
                setFlexibleTypeCapabilitiesId(protoBuf$Type.getFlexibleTypeCapabilitiesId());
            }
            if (protoBuf$Type.hasFlexibleUpperBound()) {
                mergeFlexibleUpperBound(protoBuf$Type.getFlexibleUpperBound());
            }
            if (protoBuf$Type.hasFlexibleUpperBoundId()) {
                setFlexibleUpperBoundId(protoBuf$Type.getFlexibleUpperBoundId());
            }
            if (protoBuf$Type.hasClassName()) {
                setClassName(protoBuf$Type.getClassName());
            }
            if (protoBuf$Type.hasTypeParameter()) {
                setTypeParameter(protoBuf$Type.getTypeParameter());
            }
            if (protoBuf$Type.hasTypeParameterName()) {
                setTypeParameterName(protoBuf$Type.getTypeParameterName());
            }
            if (protoBuf$Type.hasTypeAliasName()) {
                setTypeAliasName(protoBuf$Type.getTypeAliasName());
            }
            if (protoBuf$Type.hasOuterType()) {
                mergeOuterType(protoBuf$Type.getOuterType());
            }
            if (protoBuf$Type.hasOuterTypeId()) {
                setOuterTypeId(protoBuf$Type.getOuterTypeId());
            }
            if (protoBuf$Type.hasAbbreviatedType()) {
                mergeAbbreviatedType(protoBuf$Type.getAbbreviatedType());
            }
            if (protoBuf$Type.hasAbbreviatedTypeId()) {
                setAbbreviatedTypeId(protoBuf$Type.getAbbreviatedTypeId());
            }
            if (protoBuf$Type.hasFlags()) {
                setFlags(protoBuf$Type.getFlags());
            }
            mergeExtensionFields(protoBuf$Type);
            setUnknownFields(getUnknownFields().b(protoBuf$Type.unknownFields));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, java.lang.Object, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, c cVar) throws IOException {
            Throwable th;
            ProtoBuf$Type protoBuf$Type;
            ProtoBuf$Type protoBuf$Type2 = null;
            try {
                ProtoBuf$Type parsePartialFrom = ProtoBuf$Type.PARSER.parsePartialFrom(codedInputStream, cVar);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                protoBuf$Type = (ProtoBuf$Type) e.getUnfinishedMessage();
                throw e;
            } catch (Throwable th2) {
                th = th2;
                protoBuf$Type2 = protoBuf$Type;
            }
            if (protoBuf$Type2 != null) {
                mergeFrom(protoBuf$Type2);
            }
            throw th;
        }
    }

    /* compiled from: Taobao */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.a<ProtoBuf$Type> {
        a() {
        }

        /* renamed from: i */
        public ProtoBuf$Type parsePartialFrom(CodedInputStream codedInputStream, c cVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$Type(codedInputStream, cVar);
        }
    }

    static {
        ProtoBuf$Type protoBuf$Type = new ProtoBuf$Type(true);
        defaultInstance = protoBuf$Type;
        protoBuf$Type.initFields();
    }

    public static ProtoBuf$Type getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.argument_ = Collections.emptyList();
        this.nullable_ = false;
        this.flexibleTypeCapabilitiesId_ = 0;
        this.flexibleUpperBound_ = getDefaultInstance();
        this.flexibleUpperBoundId_ = 0;
        this.className_ = 0;
        this.typeParameter_ = 0;
        this.typeParameterName_ = 0;
        this.typeAliasName_ = 0;
        this.outerType_ = getDefaultInstance();
        this.outerTypeId_ = 0;
        this.abbreviatedType_ = getDefaultInstance();
        this.abbreviatedTypeId_ = 0;
        this.flags_ = 0;
    }

    public static Builder newBuilder() {
        return Builder.create();
    }

    public ProtoBuf$Type getAbbreviatedType() {
        return this.abbreviatedType_;
    }

    public int getAbbreviatedTypeId() {
        return this.abbreviatedTypeId_;
    }

    public Argument getArgument(int i) {
        return this.argument_.get(i);
    }

    public int getArgumentCount() {
        return this.argument_.size();
    }

    public List<Argument> getArgumentList() {
        return this.argument_;
    }

    public int getClassName() {
        return this.className_;
    }

    public int getFlags() {
        return this.flags_;
    }

    public int getFlexibleTypeCapabilitiesId() {
        return this.flexibleTypeCapabilitiesId_;
    }

    public ProtoBuf$Type getFlexibleUpperBound() {
        return this.flexibleUpperBound_;
    }

    public int getFlexibleUpperBoundId() {
        return this.flexibleUpperBoundId_;
    }

    public boolean getNullable() {
        return this.nullable_;
    }

    public ProtoBuf$Type getOuterType() {
        return this.outerType_;
    }

    public int getOuterTypeId() {
        return this.outerTypeId_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
    public Parser<ProtoBuf$Type> getParserForType() {
        return PARSER;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int o = (this.bitField0_ & 4096) == 4096 ? CodedOutputStream.o(1, this.flags_) + 0 : 0;
        for (int i2 = 0; i2 < this.argument_.size(); i2++) {
            o += CodedOutputStream.s(2, this.argument_.get(i2));
        }
        if ((this.bitField0_ & 1) == 1) {
            o += CodedOutputStream.a(3, this.nullable_);
        }
        if ((this.bitField0_ & 2) == 2) {
            o += CodedOutputStream.o(4, this.flexibleTypeCapabilitiesId_);
        }
        if ((this.bitField0_ & 4) == 4) {
            o += CodedOutputStream.s(5, this.flexibleUpperBound_);
        }
        if ((this.bitField0_ & 16) == 16) {
            o += CodedOutputStream.o(6, this.className_);
        }
        if ((this.bitField0_ & 32) == 32) {
            o += CodedOutputStream.o(7, this.typeParameter_);
        }
        if ((this.bitField0_ & 8) == 8) {
            o += CodedOutputStream.o(8, this.flexibleUpperBoundId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            o += CodedOutputStream.o(9, this.typeParameterName_);
        }
        if ((this.bitField0_ & 256) == 256) {
            o += CodedOutputStream.s(10, this.outerType_);
        }
        if ((this.bitField0_ & 512) == 512) {
            o += CodedOutputStream.o(11, this.outerTypeId_);
        }
        if ((this.bitField0_ & 128) == 128) {
            o += CodedOutputStream.o(12, this.typeAliasName_);
        }
        if ((this.bitField0_ & 1024) == 1024) {
            o += CodedOutputStream.s(13, this.abbreviatedType_);
        }
        if ((this.bitField0_ & 2048) == 2048) {
            o += CodedOutputStream.o(14, this.abbreviatedTypeId_);
        }
        int extensionsSerializedSize = o + extensionsSerializedSize() + this.unknownFields.size();
        this.memoizedSerializedSize = extensionsSerializedSize;
        return extensionsSerializedSize;
    }

    public int getTypeAliasName() {
        return this.typeAliasName_;
    }

    public int getTypeParameter() {
        return this.typeParameter_;
    }

    public int getTypeParameterName() {
        return this.typeParameterName_;
    }

    public boolean hasAbbreviatedType() {
        return (this.bitField0_ & 1024) == 1024;
    }

    public boolean hasAbbreviatedTypeId() {
        return (this.bitField0_ & 2048) == 2048;
    }

    public boolean hasClassName() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 4096) == 4096;
    }

    public boolean hasFlexibleTypeCapabilitiesId() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasFlexibleUpperBound() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasFlexibleUpperBoundId() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasNullable() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasOuterType() {
        return (this.bitField0_ & 256) == 256;
    }

    public boolean hasOuterTypeId() {
        return (this.bitField0_ & 512) == 512;
    }

    public boolean hasTypeAliasName() {
        return (this.bitField0_ & 128) == 128;
    }

    public boolean hasTypeParameter() {
        return (this.bitField0_ & 32) == 32;
    }

    public boolean hasTypeParameterName() {
        return (this.bitField0_ & 64) == 64;
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
        for (int i = 0; i < getArgumentCount(); i++) {
            if (!getArgument(i).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        if (hasFlexibleUpperBound() && !getFlexibleUpperBound().isInitialized()) {
            this.memoizedIsInitialized = 0;
            return false;
        } else if (hasOuterType() && !getOuterType().isInitialized()) {
            this.memoizedIsInitialized = 0;
            return false;
        } else if (hasAbbreviatedType() && !getAbbreviatedType().isInitialized()) {
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
        if ((this.bitField0_ & 4096) == 4096) {
            codedOutputStream.a0(1, this.flags_);
        }
        for (int i = 0; i < this.argument_.size(); i++) {
            codedOutputStream.d0(2, this.argument_.get(i));
        }
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.L(3, this.nullable_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.a0(4, this.flexibleTypeCapabilitiesId_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.d0(5, this.flexibleUpperBound_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.a0(6, this.className_);
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.a0(7, this.typeParameter_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.a0(8, this.flexibleUpperBoundId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            codedOutputStream.a0(9, this.typeParameterName_);
        }
        if ((this.bitField0_ & 256) == 256) {
            codedOutputStream.d0(10, this.outerType_);
        }
        if ((this.bitField0_ & 512) == 512) {
            codedOutputStream.a0(11, this.outerTypeId_);
        }
        if ((this.bitField0_ & 128) == 128) {
            codedOutputStream.a0(12, this.typeAliasName_);
        }
        if ((this.bitField0_ & 1024) == 1024) {
            codedOutputStream.d0(13, this.abbreviatedType_);
        }
        if ((this.bitField0_ & 2048) == 2048) {
            codedOutputStream.a0(14, this.abbreviatedTypeId_);
        }
        newExtensionWriter.a(200, codedOutputStream);
        codedOutputStream.i0(this.unknownFields);
    }

    public static Builder newBuilder(ProtoBuf$Type protoBuf$Type) {
        return newBuilder().mergeFrom(protoBuf$Type);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$Type getDefaultInstanceForType() {
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

    private ProtoBuf$Type(GeneratedMessageLite.ExtendableBuilder<ProtoBuf$Type, ?> extendableBuilder) {
        super(extendableBuilder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = extendableBuilder.getUnknownFields();
    }

    private ProtoBuf$Type(boolean z) {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v5, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Argument> */
    /* JADX WARN: Multi-variable type inference failed */
    private ProtoBuf$Type(CodedInputStream codedInputStream, c cVar) throws InvalidProtocolBufferException {
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
                Builder builder = null;
                switch (K) {
                    case 0:
                        break;
                    case 8:
                        this.bitField0_ |= 4096;
                        this.flags_ = codedInputStream.s();
                        continue;
                    case 18:
                        if (!z2 || !true) {
                            this.argument_ = new ArrayList();
                            z2 |= true;
                        }
                        this.argument_.add(codedInputStream.u(Argument.PARSER, cVar));
                        continue;
                    case 24:
                        this.bitField0_ |= 1;
                        this.nullable_ = codedInputStream.k();
                        continue;
                    case 32:
                        this.bitField0_ |= 2;
                        this.flexibleTypeCapabilitiesId_ = codedInputStream.s();
                        continue;
                    case 42:
                        builder = (this.bitField0_ & 4) == 4 ? this.flexibleUpperBound_.toBuilder() : builder;
                        ProtoBuf$Type protoBuf$Type = (ProtoBuf$Type) codedInputStream.u(PARSER, cVar);
                        this.flexibleUpperBound_ = protoBuf$Type;
                        if (builder != null) {
                            builder.mergeFrom(protoBuf$Type);
                            this.flexibleUpperBound_ = builder.buildPartial();
                        }
                        this.bitField0_ |= 4;
                        continue;
                    case 48:
                        this.bitField0_ |= 16;
                        this.className_ = codedInputStream.s();
                        continue;
                    case 56:
                        this.bitField0_ |= 32;
                        this.typeParameter_ = codedInputStream.s();
                        continue;
                    case 64:
                        this.bitField0_ |= 8;
                        this.flexibleUpperBoundId_ = codedInputStream.s();
                        continue;
                    case 72:
                        this.bitField0_ |= 64;
                        this.typeParameterName_ = codedInputStream.s();
                        continue;
                    case 82:
                        builder = (this.bitField0_ & 256) == 256 ? this.outerType_.toBuilder() : builder;
                        ProtoBuf$Type protoBuf$Type2 = (ProtoBuf$Type) codedInputStream.u(PARSER, cVar);
                        this.outerType_ = protoBuf$Type2;
                        if (builder != null) {
                            builder.mergeFrom(protoBuf$Type2);
                            this.outerType_ = builder.buildPartial();
                        }
                        this.bitField0_ |= 256;
                        continue;
                    case 88:
                        this.bitField0_ |= 512;
                        this.outerTypeId_ = codedInputStream.s();
                        continue;
                    case 96:
                        this.bitField0_ |= 128;
                        this.typeAliasName_ = codedInputStream.s();
                        continue;
                    case 106:
                        builder = (this.bitField0_ & 1024) == 1024 ? this.abbreviatedType_.toBuilder() : builder;
                        ProtoBuf$Type protoBuf$Type3 = (ProtoBuf$Type) codedInputStream.u(PARSER, cVar);
                        this.abbreviatedType_ = protoBuf$Type3;
                        if (builder != null) {
                            builder.mergeFrom(protoBuf$Type3);
                            this.abbreviatedType_ = builder.buildPartial();
                        }
                        this.bitField0_ |= 1024;
                        continue;
                    case 112:
                        this.bitField0_ |= 2048;
                        this.abbreviatedTypeId_ = codedInputStream.s();
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
                if (z2 && true) {
                    this.argument_ = Collections.unmodifiableList(this.argument_);
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
        if (z2 && true) {
            this.argument_ = Collections.unmodifiableList(this.argument_);
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
