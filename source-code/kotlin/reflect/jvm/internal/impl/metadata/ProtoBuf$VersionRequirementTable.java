package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.c;

/* compiled from: Taobao */
public final class ProtoBuf$VersionRequirementTable extends GeneratedMessageLite implements ProtoBuf$VersionRequirementTableOrBuilder {
    public static Parser<ProtoBuf$VersionRequirementTable> PARSER = new a();
    private static final ProtoBuf$VersionRequirementTable defaultInstance;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<ProtoBuf$VersionRequirement> requirement_;
    private final ByteString unknownFields;

    /* compiled from: Taobao */
    public static final class Builder extends GeneratedMessageLite.Builder<ProtoBuf$VersionRequirementTable, Builder> implements ProtoBuf$VersionRequirementTableOrBuilder {
        private int bitField0_;
        private List<ProtoBuf$VersionRequirement> requirement_ = Collections.emptyList();

        private Builder() {
            maybeForceBuilderInitialization();
        }

        /* access modifiers changed from: private */
        public static Builder create() {
            return new Builder();
        }

        private void ensureRequirementIsMutable() {
            if ((this.bitField0_ & 1) != 1) {
                this.requirement_ = new ArrayList(this.requirement_);
                this.bitField0_ |= 1;
            }
        }

        private void maybeForceBuilderInitialization() {
        }

        public ProtoBuf$VersionRequirementTable buildPartial() {
            ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable = new ProtoBuf$VersionRequirementTable(this);
            if ((this.bitField0_ & 1) == 1) {
                this.requirement_ = Collections.unmodifiableList(this.requirement_);
                this.bitField0_ &= -2;
            }
            protoBuf$VersionRequirementTable.requirement_ = this.requirement_;
            return protoBuf$VersionRequirementTable;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$VersionRequirementTable build() {
            ProtoBuf$VersionRequirementTable buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public ProtoBuf$VersionRequirementTable getDefaultInstanceForType() {
            return ProtoBuf$VersionRequirementTable.getDefaultInstance();
        }

        @Override // java.lang.Object, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        public Builder mergeFrom(ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable) {
            if (protoBuf$VersionRequirementTable == ProtoBuf$VersionRequirementTable.getDefaultInstance()) {
                return this;
            }
            if (!protoBuf$VersionRequirementTable.requirement_.isEmpty()) {
                if (this.requirement_.isEmpty()) {
                    this.requirement_ = protoBuf$VersionRequirementTable.requirement_;
                    this.bitField0_ &= -2;
                } else {
                    ensureRequirementIsMutable();
                    this.requirement_.addAll(protoBuf$VersionRequirementTable.requirement_);
                }
            }
            setUnknownFields(getUnknownFields().b(protoBuf$VersionRequirementTable.unknownFields));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, c cVar) throws IOException {
            Throwable th;
            ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable;
            ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable2 = null;
            try {
                ProtoBuf$VersionRequirementTable parsePartialFrom = ProtoBuf$VersionRequirementTable.PARSER.parsePartialFrom(codedInputStream, cVar);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                protoBuf$VersionRequirementTable = (ProtoBuf$VersionRequirementTable) e.getUnfinishedMessage();
                throw e;
            } catch (Throwable th2) {
                th = th2;
                protoBuf$VersionRequirementTable2 = protoBuf$VersionRequirementTable;
            }
            if (protoBuf$VersionRequirementTable2 != null) {
                mergeFrom(protoBuf$VersionRequirementTable2);
            }
            throw th;
        }
    }

    /* compiled from: Taobao */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.a<ProtoBuf$VersionRequirementTable> {
        a() {
        }

        /* renamed from: i */
        public ProtoBuf$VersionRequirementTable parsePartialFrom(CodedInputStream codedInputStream, c cVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$VersionRequirementTable(codedInputStream, cVar);
        }
    }

    static {
        ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable = new ProtoBuf$VersionRequirementTable(true);
        defaultInstance = protoBuf$VersionRequirementTable;
        protoBuf$VersionRequirementTable.initFields();
    }

    public static ProtoBuf$VersionRequirementTable getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.requirement_ = Collections.emptyList();
    }

    public static Builder newBuilder() {
        return Builder.create();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
    public Parser<ProtoBuf$VersionRequirementTable> getParserForType() {
        return PARSER;
    }

    public int getRequirementCount() {
        return this.requirement_.size();
    }

    public List<ProtoBuf$VersionRequirement> getRequirementList() {
        return this.requirement_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.requirement_.size(); i3++) {
            i2 += CodedOutputStream.s(1, this.requirement_.get(i3));
        }
        int size = i2 + this.unknownFields.size();
        this.memoizedSerializedSize = size;
        return size;
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
        for (int i = 0; i < this.requirement_.size(); i++) {
            codedOutputStream.d0(1, this.requirement_.get(i));
        }
        codedOutputStream.i0(this.unknownFields);
    }

    public static Builder newBuilder(ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable) {
        return newBuilder().mergeFrom(protoBuf$VersionRequirementTable);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$VersionRequirementTable getDefaultInstanceForType() {
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

    private ProtoBuf$VersionRequirementTable(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = builder.getUnknownFields();
    }

    private ProtoBuf$VersionRequirementTable(boolean z) {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement> */
    /* JADX WARN: Multi-variable type inference failed */
    private ProtoBuf$VersionRequirementTable(CodedInputStream codedInputStream, c cVar) throws InvalidProtocolBufferException {
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
                    if (K == 10) {
                        if (!z2 || !true) {
                            this.requirement_ = new ArrayList();
                            z2 |= true;
                        }
                        this.requirement_.add(codedInputStream.u(ProtoBuf$VersionRequirement.PARSER, cVar));
                    } else if (!parseUnknownField(codedInputStream, J, cVar, K)) {
                    }
                }
                z = true;
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e2) {
                throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
            } catch (Throwable th) {
                if (z2 && true) {
                    this.requirement_ = Collections.unmodifiableList(this.requirement_);
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
            this.requirement_ = Collections.unmodifiableList(this.requirement_);
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
