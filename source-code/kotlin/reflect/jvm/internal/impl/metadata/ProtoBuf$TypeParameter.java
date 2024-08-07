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
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.c;

/* compiled from: Taobao */
public final class ProtoBuf$TypeParameter extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$TypeParameter> implements ProtoBuf$TypeParameterOrBuilder {
    public static Parser<ProtoBuf$TypeParameter> PARSER = new a();
    private static final ProtoBuf$TypeParameter defaultInstance;
    private int bitField0_;
    private int id_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private boolean reified_;
    private final ByteString unknownFields;
    private int upperBoundIdMemoizedSerializedSize;
    private List<Integer> upperBoundId_;
    private List<ProtoBuf$Type> upperBound_;
    private Variance variance_;

    /* compiled from: Taobao */
    public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ProtoBuf$TypeParameter, Builder> implements ProtoBuf$TypeParameterOrBuilder {
        private int bitField0_;
        private int id_;
        private int name_;
        private boolean reified_;
        private List<Integer> upperBoundId_ = Collections.emptyList();
        private List<ProtoBuf$Type> upperBound_ = Collections.emptyList();
        private Variance variance_ = Variance.INV;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        /* access modifiers changed from: private */
        public static Builder create() {
            return new Builder();
        }

        private void ensureUpperBoundIdIsMutable() {
            if ((this.bitField0_ & 32) != 32) {
                this.upperBoundId_ = new ArrayList(this.upperBoundId_);
                this.bitField0_ |= 32;
            }
        }

        private void ensureUpperBoundIsMutable() {
            if ((this.bitField0_ & 16) != 16) {
                this.upperBound_ = new ArrayList(this.upperBound_);
                this.bitField0_ |= 16;
            }
        }

        private void maybeForceBuilderInitialization() {
        }

        public ProtoBuf$TypeParameter buildPartial() {
            ProtoBuf$TypeParameter protoBuf$TypeParameter = new ProtoBuf$TypeParameter(this);
            int i = this.bitField0_;
            int i2 = 1;
            if ((i & 1) != 1) {
                i2 = 0;
            }
            protoBuf$TypeParameter.id_ = this.id_;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            protoBuf$TypeParameter.name_ = this.name_;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            protoBuf$TypeParameter.reified_ = this.reified_;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            protoBuf$TypeParameter.variance_ = this.variance_;
            if ((this.bitField0_ & 16) == 16) {
                this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
                this.bitField0_ &= -17;
            }
            protoBuf$TypeParameter.upperBound_ = this.upperBound_;
            if ((this.bitField0_ & 32) == 32) {
                this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
                this.bitField0_ &= -33;
            }
            protoBuf$TypeParameter.upperBoundId_ = this.upperBoundId_;
            protoBuf$TypeParameter.bitField0_ = i2;
            return protoBuf$TypeParameter;
        }

        public ProtoBuf$Type getUpperBound(int i) {
            return this.upperBound_.get(i);
        }

        public int getUpperBoundCount() {
            return this.upperBound_.size();
        }

        public boolean hasId() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            if (!(hasId() && hasName())) {
                return false;
            }
            for (int i = 0; i < getUpperBoundCount(); i++) {
                if (!getUpperBound(i).isInitialized()) {
                    return false;
                }
            }
            if (!extensionsAreInitialized()) {
                return false;
            }
            return true;
        }

        public Builder setId(int i) {
            this.bitField0_ |= 1;
            this.id_ = i;
            return this;
        }

        public Builder setName(int i) {
            this.bitField0_ |= 2;
            this.name_ = i;
            return this;
        }

        public Builder setReified(boolean z) {
            this.bitField0_ |= 4;
            this.reified_ = z;
            return this;
        }

        public Builder setVariance(Variance variance) {
            Objects.requireNonNull(variance);
            this.bitField0_ |= 8;
            this.variance_ = variance;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$TypeParameter build() {
            ProtoBuf$TypeParameter buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public ProtoBuf$TypeParameter getDefaultInstanceForType() {
            return ProtoBuf$TypeParameter.getDefaultInstance();
        }

        public Builder mergeFrom(ProtoBuf$TypeParameter protoBuf$TypeParameter) {
            if (protoBuf$TypeParameter == ProtoBuf$TypeParameter.getDefaultInstance()) {
                return this;
            }
            if (protoBuf$TypeParameter.hasId()) {
                setId(protoBuf$TypeParameter.getId());
            }
            if (protoBuf$TypeParameter.hasName()) {
                setName(protoBuf$TypeParameter.getName());
            }
            if (protoBuf$TypeParameter.hasReified()) {
                setReified(protoBuf$TypeParameter.getReified());
            }
            if (protoBuf$TypeParameter.hasVariance()) {
                setVariance(protoBuf$TypeParameter.getVariance());
            }
            if (!protoBuf$TypeParameter.upperBound_.isEmpty()) {
                if (this.upperBound_.isEmpty()) {
                    this.upperBound_ = protoBuf$TypeParameter.upperBound_;
                    this.bitField0_ &= -17;
                } else {
                    ensureUpperBoundIsMutable();
                    this.upperBound_.addAll(protoBuf$TypeParameter.upperBound_);
                }
            }
            if (!protoBuf$TypeParameter.upperBoundId_.isEmpty()) {
                if (this.upperBoundId_.isEmpty()) {
                    this.upperBoundId_ = protoBuf$TypeParameter.upperBoundId_;
                    this.bitField0_ &= -33;
                } else {
                    ensureUpperBoundIdIsMutable();
                    this.upperBoundId_.addAll(protoBuf$TypeParameter.upperBoundId_);
                }
            }
            mergeExtensionFields(protoBuf$TypeParameter);
            setUnknownFields(getUnknownFields().b(protoBuf$TypeParameter.unknownFields));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, java.lang.Object, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, c cVar) throws IOException {
            Throwable th;
            ProtoBuf$TypeParameter protoBuf$TypeParameter;
            ProtoBuf$TypeParameter protoBuf$TypeParameter2 = null;
            try {
                ProtoBuf$TypeParameter parsePartialFrom = ProtoBuf$TypeParameter.PARSER.parsePartialFrom(codedInputStream, cVar);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                protoBuf$TypeParameter = (ProtoBuf$TypeParameter) e.getUnfinishedMessage();
                throw e;
            } catch (Throwable th2) {
                th = th2;
                protoBuf$TypeParameter2 = protoBuf$TypeParameter;
            }
            if (protoBuf$TypeParameter2 != null) {
                mergeFrom(protoBuf$TypeParameter2);
            }
            throw th;
        }
    }

    /* compiled from: Taobao */
    public enum Variance implements Internal.EnumLite {
        IN(0, 0),
        OUT(1, 1),
        INV(2, 2);
        
        private static Internal.EnumLiteMap<Variance> internalValueMap = new a();
        private final int value;

        /* compiled from: Taobao */
        static class a implements Internal.EnumLiteMap<Variance> {
            a() {
            }

            /* renamed from: a */
            public Variance findValueByNumber(int i) {
                return Variance.valueOf(i);
            }
        }

        private Variance(int i, int i2) {
            this.value = i2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static Variance valueOf(int i) {
            if (i == 0) {
                return IN;
            }
            if (i == 1) {
                return OUT;
            }
            if (i != 2) {
                return null;
            }
            return INV;
        }
    }

    /* compiled from: Taobao */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.a<ProtoBuf$TypeParameter> {
        a() {
        }

        /* renamed from: i */
        public ProtoBuf$TypeParameter parsePartialFrom(CodedInputStream codedInputStream, c cVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$TypeParameter(codedInputStream, cVar);
        }
    }

    static {
        ProtoBuf$TypeParameter protoBuf$TypeParameter = new ProtoBuf$TypeParameter(true);
        defaultInstance = protoBuf$TypeParameter;
        protoBuf$TypeParameter.initFields();
    }

    public static ProtoBuf$TypeParameter getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.id_ = 0;
        this.name_ = 0;
        this.reified_ = false;
        this.variance_ = Variance.INV;
        this.upperBound_ = Collections.emptyList();
        this.upperBoundId_ = Collections.emptyList();
    }

    public static Builder newBuilder() {
        return Builder.create();
    }

    public int getId() {
        return this.id_;
    }

    public int getName() {
        return this.name_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
    public Parser<ProtoBuf$TypeParameter> getParserForType() {
        return PARSER;
    }

    public boolean getReified() {
        return this.reified_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int o = (this.bitField0_ & 1) == 1 ? CodedOutputStream.o(1, this.id_) + 0 : 0;
        if ((this.bitField0_ & 2) == 2) {
            o += CodedOutputStream.o(2, this.name_);
        }
        if ((this.bitField0_ & 4) == 4) {
            o += CodedOutputStream.a(3, this.reified_);
        }
        if ((this.bitField0_ & 8) == 8) {
            o += CodedOutputStream.h(4, this.variance_.getNumber());
        }
        for (int i2 = 0; i2 < this.upperBound_.size(); i2++) {
            o += CodedOutputStream.s(5, this.upperBound_.get(i2));
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.upperBoundId_.size(); i4++) {
            i3 += CodedOutputStream.p(this.upperBoundId_.get(i4).intValue());
        }
        int i5 = o + i3;
        if (!getUpperBoundIdList().isEmpty()) {
            i5 = i5 + 1 + CodedOutputStream.p(i3);
        }
        this.upperBoundIdMemoizedSerializedSize = i3;
        int extensionsSerializedSize = i5 + extensionsSerializedSize() + this.unknownFields.size();
        this.memoizedSerializedSize = extensionsSerializedSize;
        return extensionsSerializedSize;
    }

    public ProtoBuf$Type getUpperBound(int i) {
        return this.upperBound_.get(i);
    }

    public int getUpperBoundCount() {
        return this.upperBound_.size();
    }

    public List<Integer> getUpperBoundIdList() {
        return this.upperBoundId_;
    }

    public List<ProtoBuf$Type> getUpperBoundList() {
        return this.upperBound_;
    }

    public Variance getVariance() {
        return this.variance_;
    }

    public boolean hasId() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasName() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasReified() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasVariance() {
        return (this.bitField0_ & 8) == 8;
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
        if (!hasId()) {
            this.memoizedIsInitialized = 0;
            return false;
        } else if (!hasName()) {
            this.memoizedIsInitialized = 0;
            return false;
        } else {
            for (int i = 0; i < getUpperBoundCount(); i++) {
                if (!getUpperBound(i).isInitialized()) {
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
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.a0(1, this.id_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.a0(2, this.name_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.L(3, this.reified_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.S(4, this.variance_.getNumber());
        }
        for (int i = 0; i < this.upperBound_.size(); i++) {
            codedOutputStream.d0(5, this.upperBound_.get(i));
        }
        if (getUpperBoundIdList().size() > 0) {
            codedOutputStream.o0(50);
            codedOutputStream.o0(this.upperBoundIdMemoizedSerializedSize);
        }
        for (int i2 = 0; i2 < this.upperBoundId_.size(); i2++) {
            codedOutputStream.b0(this.upperBoundId_.get(i2).intValue());
        }
        newExtensionWriter.a(1000, codedOutputStream);
        codedOutputStream.i0(this.unknownFields);
    }

    public static Builder newBuilder(ProtoBuf$TypeParameter protoBuf$TypeParameter) {
        return newBuilder().mergeFrom(protoBuf$TypeParameter);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$TypeParameter getDefaultInstanceForType() {
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

    private ProtoBuf$TypeParameter(GeneratedMessageLite.ExtendableBuilder<ProtoBuf$TypeParameter, ?> extendableBuilder) {
        super(extendableBuilder);
        this.upperBoundIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = extendableBuilder.getUnknownFields();
    }

    private ProtoBuf$TypeParameter(boolean z) {
        this.upperBoundIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v13, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> */
    /* JADX WARN: Multi-variable type inference failed */
    private ProtoBuf$TypeParameter(CodedInputStream codedInputStream, c cVar) throws InvalidProtocolBufferException {
        this.upperBoundIdMemoizedSerializedSize = -1;
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
                        this.id_ = codedInputStream.s();
                    } else if (K == 16) {
                        this.bitField0_ |= 2;
                        this.name_ = codedInputStream.s();
                    } else if (K == 24) {
                        this.bitField0_ |= 4;
                        this.reified_ = codedInputStream.k();
                    } else if (K == 32) {
                        int n2 = codedInputStream.n();
                        Variance valueOf = Variance.valueOf(n2);
                        if (valueOf == null) {
                            J.o0(K);
                            J.o0(n2);
                        } else {
                            this.bitField0_ |= 8;
                            this.variance_ = valueOf;
                        }
                    } else if (K == 42) {
                        if (!(z2 & true)) {
                            this.upperBound_ = new ArrayList();
                            z2 |= true;
                        }
                        this.upperBound_.add(codedInputStream.u(ProtoBuf$Type.PARSER, cVar));
                    } else if (K == 48) {
                        if (!(z2 & true)) {
                            this.upperBoundId_ = new ArrayList();
                            z2 |= true;
                        }
                        this.upperBoundId_.add(Integer.valueOf(codedInputStream.s()));
                    } else if (K == 50) {
                        int j = codedInputStream.j(codedInputStream.A());
                        if (!(z2 & true) && codedInputStream.e() > 0) {
                            this.upperBoundId_ = new ArrayList();
                            z2 |= true;
                        }
                        while (codedInputStream.e() > 0) {
                            this.upperBoundId_.add(Integer.valueOf(codedInputStream.s()));
                        }
                        codedInputStream.i(j);
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
                    this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
                }
                if (z2 & true) {
                    this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
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
            this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
        }
        if (z2 & true) {
            this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
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
