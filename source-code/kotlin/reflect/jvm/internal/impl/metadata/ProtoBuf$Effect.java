package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression;
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
public final class ProtoBuf$Effect extends GeneratedMessageLite implements ProtoBuf$EffectOrBuilder {
    public static Parser<ProtoBuf$Effect> PARSER = new a();
    private static final ProtoBuf$Effect defaultInstance;
    private int bitField0_;
    private ProtoBuf$Expression conclusionOfConditionalEffect_;
    private List<ProtoBuf$Expression> effectConstructorArgument_;
    private EffectType effectType_;
    private InvocationKind kind_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private final ByteString unknownFields;

    /* compiled from: Taobao */
    public static final class Builder extends GeneratedMessageLite.Builder<ProtoBuf$Effect, Builder> implements ProtoBuf$EffectOrBuilder {
        private int bitField0_;
        private ProtoBuf$Expression conclusionOfConditionalEffect_ = ProtoBuf$Expression.getDefaultInstance();
        private List<ProtoBuf$Expression> effectConstructorArgument_ = Collections.emptyList();
        private EffectType effectType_ = EffectType.RETURNS_CONSTANT;
        private InvocationKind kind_ = InvocationKind.AT_MOST_ONCE;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        /* access modifiers changed from: private */
        public static Builder create() {
            return new Builder();
        }

        private void ensureEffectConstructorArgumentIsMutable() {
            if ((this.bitField0_ & 2) != 2) {
                this.effectConstructorArgument_ = new ArrayList(this.effectConstructorArgument_);
                this.bitField0_ |= 2;
            }
        }

        private void maybeForceBuilderInitialization() {
        }

        public ProtoBuf$Effect buildPartial() {
            ProtoBuf$Effect protoBuf$Effect = new ProtoBuf$Effect(this);
            int i = this.bitField0_;
            int i2 = 1;
            if ((i & 1) != 1) {
                i2 = 0;
            }
            protoBuf$Effect.effectType_ = this.effectType_;
            if ((this.bitField0_ & 2) == 2) {
                this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
                this.bitField0_ &= -3;
            }
            protoBuf$Effect.effectConstructorArgument_ = this.effectConstructorArgument_;
            if ((i & 4) == 4) {
                i2 |= 2;
            }
            protoBuf$Effect.conclusionOfConditionalEffect_ = this.conclusionOfConditionalEffect_;
            if ((i & 8) == 8) {
                i2 |= 4;
            }
            protoBuf$Effect.kind_ = this.kind_;
            protoBuf$Effect.bitField0_ = i2;
            return protoBuf$Effect;
        }

        public ProtoBuf$Expression getConclusionOfConditionalEffect() {
            return this.conclusionOfConditionalEffect_;
        }

        public ProtoBuf$Expression getEffectConstructorArgument(int i) {
            return this.effectConstructorArgument_.get(i);
        }

        public int getEffectConstructorArgumentCount() {
            return this.effectConstructorArgument_.size();
        }

        public boolean hasConclusionOfConditionalEffect() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            for (int i = 0; i < getEffectConstructorArgumentCount(); i++) {
                if (!getEffectConstructorArgument(i).isInitialized()) {
                    return false;
                }
            }
            if (!hasConclusionOfConditionalEffect() || getConclusionOfConditionalEffect().isInitialized()) {
                return true;
            }
            return false;
        }

        public Builder mergeConclusionOfConditionalEffect(ProtoBuf$Expression protoBuf$Expression) {
            if ((this.bitField0_ & 4) != 4 || this.conclusionOfConditionalEffect_ == ProtoBuf$Expression.getDefaultInstance()) {
                this.conclusionOfConditionalEffect_ = protoBuf$Expression;
            } else {
                this.conclusionOfConditionalEffect_ = ProtoBuf$Expression.newBuilder(this.conclusionOfConditionalEffect_).mergeFrom(protoBuf$Expression).buildPartial();
            }
            this.bitField0_ |= 4;
            return this;
        }

        public Builder setEffectType(EffectType effectType) {
            Objects.requireNonNull(effectType);
            this.bitField0_ |= 1;
            this.effectType_ = effectType;
            return this;
        }

        public Builder setKind(InvocationKind invocationKind) {
            Objects.requireNonNull(invocationKind);
            this.bitField0_ |= 8;
            this.kind_ = invocationKind;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$Effect build() {
            ProtoBuf$Effect buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public ProtoBuf$Effect getDefaultInstanceForType() {
            return ProtoBuf$Effect.getDefaultInstance();
        }

        @Override // java.lang.Object, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        public Builder mergeFrom(ProtoBuf$Effect protoBuf$Effect) {
            if (protoBuf$Effect == ProtoBuf$Effect.getDefaultInstance()) {
                return this;
            }
            if (protoBuf$Effect.hasEffectType()) {
                setEffectType(protoBuf$Effect.getEffectType());
            }
            if (!protoBuf$Effect.effectConstructorArgument_.isEmpty()) {
                if (this.effectConstructorArgument_.isEmpty()) {
                    this.effectConstructorArgument_ = protoBuf$Effect.effectConstructorArgument_;
                    this.bitField0_ &= -3;
                } else {
                    ensureEffectConstructorArgumentIsMutable();
                    this.effectConstructorArgument_.addAll(protoBuf$Effect.effectConstructorArgument_);
                }
            }
            if (protoBuf$Effect.hasConclusionOfConditionalEffect()) {
                mergeConclusionOfConditionalEffect(protoBuf$Effect.getConclusionOfConditionalEffect());
            }
            if (protoBuf$Effect.hasKind()) {
                setKind(protoBuf$Effect.getKind());
            }
            setUnknownFields(getUnknownFields().b(protoBuf$Effect.unknownFields));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, c cVar) throws IOException {
            Throwable th;
            ProtoBuf$Effect protoBuf$Effect;
            ProtoBuf$Effect protoBuf$Effect2 = null;
            try {
                ProtoBuf$Effect parsePartialFrom = ProtoBuf$Effect.PARSER.parsePartialFrom(codedInputStream, cVar);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                protoBuf$Effect = (ProtoBuf$Effect) e.getUnfinishedMessage();
                throw e;
            } catch (Throwable th2) {
                th = th2;
                protoBuf$Effect2 = protoBuf$Effect;
            }
            if (protoBuf$Effect2 != null) {
                mergeFrom(protoBuf$Effect2);
            }
            throw th;
        }
    }

    /* compiled from: Taobao */
    public enum EffectType implements Internal.EnumLite {
        RETURNS_CONSTANT(0, 0),
        CALLS(1, 1),
        RETURNS_NOT_NULL(2, 2);
        
        private static Internal.EnumLiteMap<EffectType> internalValueMap = new a();
        private final int value;

        /* compiled from: Taobao */
        static class a implements Internal.EnumLiteMap<EffectType> {
            a() {
            }

            /* renamed from: a */
            public EffectType findValueByNumber(int i) {
                return EffectType.valueOf(i);
            }
        }

        private EffectType(int i, int i2) {
            this.value = i2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static EffectType valueOf(int i) {
            if (i == 0) {
                return RETURNS_CONSTANT;
            }
            if (i == 1) {
                return CALLS;
            }
            if (i != 2) {
                return null;
            }
            return RETURNS_NOT_NULL;
        }
    }

    /* compiled from: Taobao */
    public enum InvocationKind implements Internal.EnumLite {
        AT_MOST_ONCE(0, 0),
        EXACTLY_ONCE(1, 1),
        AT_LEAST_ONCE(2, 2);
        
        private static Internal.EnumLiteMap<InvocationKind> internalValueMap = new a();
        private final int value;

        /* compiled from: Taobao */
        static class a implements Internal.EnumLiteMap<InvocationKind> {
            a() {
            }

            /* renamed from: a */
            public InvocationKind findValueByNumber(int i) {
                return InvocationKind.valueOf(i);
            }
        }

        private InvocationKind(int i, int i2) {
            this.value = i2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static InvocationKind valueOf(int i) {
            if (i == 0) {
                return AT_MOST_ONCE;
            }
            if (i == 1) {
                return EXACTLY_ONCE;
            }
            if (i != 2) {
                return null;
            }
            return AT_LEAST_ONCE;
        }
    }

    /* compiled from: Taobao */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.a<ProtoBuf$Effect> {
        a() {
        }

        /* renamed from: i */
        public ProtoBuf$Effect parsePartialFrom(CodedInputStream codedInputStream, c cVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$Effect(codedInputStream, cVar);
        }
    }

    static {
        ProtoBuf$Effect protoBuf$Effect = new ProtoBuf$Effect(true);
        defaultInstance = protoBuf$Effect;
        protoBuf$Effect.initFields();
    }

    public static ProtoBuf$Effect getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.effectType_ = EffectType.RETURNS_CONSTANT;
        this.effectConstructorArgument_ = Collections.emptyList();
        this.conclusionOfConditionalEffect_ = ProtoBuf$Expression.getDefaultInstance();
        this.kind_ = InvocationKind.AT_MOST_ONCE;
    }

    public static Builder newBuilder() {
        return Builder.create();
    }

    public ProtoBuf$Expression getConclusionOfConditionalEffect() {
        return this.conclusionOfConditionalEffect_;
    }

    public ProtoBuf$Expression getEffectConstructorArgument(int i) {
        return this.effectConstructorArgument_.get(i);
    }

    public int getEffectConstructorArgumentCount() {
        return this.effectConstructorArgument_.size();
    }

    public EffectType getEffectType() {
        return this.effectType_;
    }

    public InvocationKind getKind() {
        return this.kind_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
    public Parser<ProtoBuf$Effect> getParserForType() {
        return PARSER;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int h = (this.bitField0_ & 1) == 1 ? CodedOutputStream.h(1, this.effectType_.getNumber()) + 0 : 0;
        for (int i2 = 0; i2 < this.effectConstructorArgument_.size(); i2++) {
            h += CodedOutputStream.s(2, this.effectConstructorArgument_.get(i2));
        }
        if ((this.bitField0_ & 2) == 2) {
            h += CodedOutputStream.s(3, this.conclusionOfConditionalEffect_);
        }
        if ((this.bitField0_ & 4) == 4) {
            h += CodedOutputStream.h(4, this.kind_.getNumber());
        }
        int size = h + this.unknownFields.size();
        this.memoizedSerializedSize = size;
        return size;
    }

    public boolean hasConclusionOfConditionalEffect() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasEffectType() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasKind() {
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
        for (int i = 0; i < getEffectConstructorArgumentCount(); i++) {
            if (!getEffectConstructorArgument(i).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        if (!hasConclusionOfConditionalEffect() || getConclusionOfConditionalEffect().isInitialized()) {
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
            codedOutputStream.S(1, this.effectType_.getNumber());
        }
        for (int i = 0; i < this.effectConstructorArgument_.size(); i++) {
            codedOutputStream.d0(2, this.effectConstructorArgument_.get(i));
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.d0(3, this.conclusionOfConditionalEffect_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.S(4, this.kind_.getNumber());
        }
        codedOutputStream.i0(this.unknownFields);
    }

    public static Builder newBuilder(ProtoBuf$Effect protoBuf$Effect) {
        return newBuilder().mergeFrom(protoBuf$Effect);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$Effect getDefaultInstanceForType() {
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

    private ProtoBuf$Effect(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = builder.getUnknownFields();
    }

    private ProtoBuf$Effect(boolean z) {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v4, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression> */
    /* JADX WARN: Multi-variable type inference failed */
    private ProtoBuf$Effect(CodedInputStream codedInputStream, c cVar) throws InvalidProtocolBufferException {
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
                        int n2 = codedInputStream.n();
                        EffectType valueOf = EffectType.valueOf(n2);
                        if (valueOf == null) {
                            J.o0(K);
                            J.o0(n2);
                        } else {
                            this.bitField0_ |= 1;
                            this.effectType_ = valueOf;
                        }
                    } else if (K == 18) {
                        if (!(z2 & true)) {
                            this.effectConstructorArgument_ = new ArrayList();
                            z2 |= true;
                        }
                        this.effectConstructorArgument_.add(codedInputStream.u(ProtoBuf$Expression.PARSER, cVar));
                    } else if (K == 26) {
                        ProtoBuf$Expression.Builder builder = (this.bitField0_ & 2) == 2 ? this.conclusionOfConditionalEffect_.toBuilder() : null;
                        ProtoBuf$Expression protoBuf$Expression = (ProtoBuf$Expression) codedInputStream.u(ProtoBuf$Expression.PARSER, cVar);
                        this.conclusionOfConditionalEffect_ = protoBuf$Expression;
                        if (builder != null) {
                            builder.mergeFrom(protoBuf$Expression);
                            this.conclusionOfConditionalEffect_ = builder.buildPartial();
                        }
                        this.bitField0_ |= 2;
                    } else if (K == 32) {
                        int n3 = codedInputStream.n();
                        InvocationKind valueOf2 = InvocationKind.valueOf(n3);
                        if (valueOf2 == null) {
                            J.o0(K);
                            J.o0(n3);
                        } else {
                            this.bitField0_ |= 4;
                            this.kind_ = valueOf2;
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
                if (z2 & true) {
                    this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
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
            this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
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
