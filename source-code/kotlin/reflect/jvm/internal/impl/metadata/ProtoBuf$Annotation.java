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
public final class ProtoBuf$Annotation extends GeneratedMessageLite implements ProtoBuf$AnnotationOrBuilder {
    public static Parser<ProtoBuf$Annotation> PARSER = new a();
    private static final ProtoBuf$Annotation defaultInstance;
    private List<Argument> argument_;
    private int bitField0_;
    private int id_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private final ByteString unknownFields;

    /* compiled from: Taobao */
    public static final class Argument extends GeneratedMessageLite implements ArgumentOrBuilder {
        public static Parser<Argument> PARSER = new a();
        private static final Argument defaultInstance;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int nameId_;
        private final ByteString unknownFields;
        private Value value_;

        /* compiled from: Taobao */
        public static final class Builder extends GeneratedMessageLite.Builder<Argument, Builder> implements ArgumentOrBuilder {
            private int bitField0_;
            private int nameId_;
            private Value value_ = Value.getDefaultInstance();

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
                argument.nameId_ = this.nameId_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                argument.value_ = this.value_;
                argument.bitField0_ = i2;
                return argument;
            }

            public Value getValue() {
                return this.value_;
            }

            public boolean hasNameId() {
                return (this.bitField0_ & 1) == 1;
            }

            public boolean hasValue() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasNameId() && hasValue() && getValue().isInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeValue(Value value) {
                if ((this.bitField0_ & 2) != 2 || this.value_ == Value.getDefaultInstance()) {
                    this.value_ = value;
                } else {
                    this.value_ = Value.newBuilder(this.value_).mergeFrom(value).buildPartial();
                }
                this.bitField0_ |= 2;
                return this;
            }

            public Builder setNameId(int i) {
                this.bitField0_ |= 1;
                this.nameId_ = i;
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
                if (argument.hasNameId()) {
                    setNameId(argument.getNameId());
                }
                if (argument.hasValue()) {
                    mergeValue(argument.getValue());
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
        public static final class Value extends GeneratedMessageLite implements ValueOrBuilder {
            public static Parser<Value> PARSER = new a();
            private static final Value defaultInstance;
            private ProtoBuf$Annotation annotation_;
            private int arrayDimensionCount_;
            private List<Value> arrayElement_;
            private int bitField0_;
            private int classId_;
            private double doubleValue_;
            private int enumValueId_;
            private int flags_;
            private float floatValue_;
            private long intValue_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private int stringValue_;
            private Type type_;
            private final ByteString unknownFields;

            /* compiled from: Taobao */
            public static final class Builder extends GeneratedMessageLite.Builder<Value, Builder> implements ValueOrBuilder {
                private ProtoBuf$Annotation annotation_ = ProtoBuf$Annotation.getDefaultInstance();
                private int arrayDimensionCount_;
                private List<Value> arrayElement_ = Collections.emptyList();
                private int bitField0_;
                private int classId_;
                private double doubleValue_;
                private int enumValueId_;
                private int flags_;
                private float floatValue_;
                private long intValue_;
                private int stringValue_;
                private Type type_ = Type.BYTE;

                private Builder() {
                    maybeForceBuilderInitialization();
                }

                /* access modifiers changed from: private */
                public static Builder create() {
                    return new Builder();
                }

                private void ensureArrayElementIsMutable() {
                    if ((this.bitField0_ & 256) != 256) {
                        this.arrayElement_ = new ArrayList(this.arrayElement_);
                        this.bitField0_ |= 256;
                    }
                }

                private void maybeForceBuilderInitialization() {
                }

                public Value buildPartial() {
                    Value value = new Value(this);
                    int i = this.bitField0_;
                    int i2 = 1;
                    if ((i & 1) != 1) {
                        i2 = 0;
                    }
                    value.type_ = this.type_;
                    if ((i & 2) == 2) {
                        i2 |= 2;
                    }
                    value.intValue_ = this.intValue_;
                    if ((i & 4) == 4) {
                        i2 |= 4;
                    }
                    value.floatValue_ = this.floatValue_;
                    if ((i & 8) == 8) {
                        i2 |= 8;
                    }
                    value.doubleValue_ = this.doubleValue_;
                    if ((i & 16) == 16) {
                        i2 |= 16;
                    }
                    value.stringValue_ = this.stringValue_;
                    if ((i & 32) == 32) {
                        i2 |= 32;
                    }
                    value.classId_ = this.classId_;
                    if ((i & 64) == 64) {
                        i2 |= 64;
                    }
                    value.enumValueId_ = this.enumValueId_;
                    if ((i & 128) == 128) {
                        i2 |= 128;
                    }
                    value.annotation_ = this.annotation_;
                    if ((this.bitField0_ & 256) == 256) {
                        this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                        this.bitField0_ &= -257;
                    }
                    value.arrayElement_ = this.arrayElement_;
                    if ((i & 512) == 512) {
                        i2 |= 256;
                    }
                    value.arrayDimensionCount_ = this.arrayDimensionCount_;
                    if ((i & 1024) == 1024) {
                        i2 |= 512;
                    }
                    value.flags_ = this.flags_;
                    value.bitField0_ = i2;
                    return value;
                }

                public ProtoBuf$Annotation getAnnotation() {
                    return this.annotation_;
                }

                public Value getArrayElement(int i) {
                    return this.arrayElement_.get(i);
                }

                public int getArrayElementCount() {
                    return this.arrayElement_.size();
                }

                public boolean hasAnnotation() {
                    return (this.bitField0_ & 128) == 128;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    if (hasAnnotation() && !getAnnotation().isInitialized()) {
                        return false;
                    }
                    for (int i = 0; i < getArrayElementCount(); i++) {
                        if (!getArrayElement(i).isInitialized()) {
                            return false;
                        }
                    }
                    return true;
                }

                public Builder mergeAnnotation(ProtoBuf$Annotation protoBuf$Annotation) {
                    if ((this.bitField0_ & 128) != 128 || this.annotation_ == ProtoBuf$Annotation.getDefaultInstance()) {
                        this.annotation_ = protoBuf$Annotation;
                    } else {
                        this.annotation_ = ProtoBuf$Annotation.newBuilder(this.annotation_).mergeFrom(protoBuf$Annotation).buildPartial();
                    }
                    this.bitField0_ |= 128;
                    return this;
                }

                public Builder setArrayDimensionCount(int i) {
                    this.bitField0_ |= 512;
                    this.arrayDimensionCount_ = i;
                    return this;
                }

                public Builder setClassId(int i) {
                    this.bitField0_ |= 32;
                    this.classId_ = i;
                    return this;
                }

                public Builder setDoubleValue(double d) {
                    this.bitField0_ |= 8;
                    this.doubleValue_ = d;
                    return this;
                }

                public Builder setEnumValueId(int i) {
                    this.bitField0_ |= 64;
                    this.enumValueId_ = i;
                    return this;
                }

                public Builder setFlags(int i) {
                    this.bitField0_ |= 1024;
                    this.flags_ = i;
                    return this;
                }

                public Builder setFloatValue(float f) {
                    this.bitField0_ |= 4;
                    this.floatValue_ = f;
                    return this;
                }

                public Builder setIntValue(long j) {
                    this.bitField0_ |= 2;
                    this.intValue_ = j;
                    return this;
                }

                public Builder setStringValue(int i) {
                    this.bitField0_ |= 16;
                    this.stringValue_ = i;
                    return this;
                }

                public Builder setType(Type type) {
                    Objects.requireNonNull(type);
                    this.bitField0_ |= 1;
                    this.type_ = type;
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Value build() {
                    Value buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
                public Value getDefaultInstanceForType() {
                    return Value.getDefaultInstance();
                }

                @Override // java.lang.Object, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public Builder clone() {
                    return create().mergeFrom(buildPartial());
                }

                public Builder mergeFrom(Value value) {
                    if (value == Value.getDefaultInstance()) {
                        return this;
                    }
                    if (value.hasType()) {
                        setType(value.getType());
                    }
                    if (value.hasIntValue()) {
                        setIntValue(value.getIntValue());
                    }
                    if (value.hasFloatValue()) {
                        setFloatValue(value.getFloatValue());
                    }
                    if (value.hasDoubleValue()) {
                        setDoubleValue(value.getDoubleValue());
                    }
                    if (value.hasStringValue()) {
                        setStringValue(value.getStringValue());
                    }
                    if (value.hasClassId()) {
                        setClassId(value.getClassId());
                    }
                    if (value.hasEnumValueId()) {
                        setEnumValueId(value.getEnumValueId());
                    }
                    if (value.hasAnnotation()) {
                        mergeAnnotation(value.getAnnotation());
                    }
                    if (!value.arrayElement_.isEmpty()) {
                        if (this.arrayElement_.isEmpty()) {
                            this.arrayElement_ = value.arrayElement_;
                            this.bitField0_ &= -257;
                        } else {
                            ensureArrayElementIsMutable();
                            this.arrayElement_.addAll(value.arrayElement_);
                        }
                    }
                    if (value.hasArrayDimensionCount()) {
                        setArrayDimensionCount(value.getArrayDimensionCount());
                    }
                    if (value.hasFlags()) {
                        setFlags(value.getFlags());
                    }
                    setUnknownFields(getUnknownFields().b(value.unknownFields));
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public Builder mergeFrom(CodedInputStream codedInputStream, c cVar) throws IOException {
                    Throwable th;
                    Value value;
                    Value value2 = null;
                    try {
                        Value parsePartialFrom = Value.PARSER.parsePartialFrom(codedInputStream, cVar);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        value = (Value) e.getUnfinishedMessage();
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        value2 = value;
                    }
                    if (value2 != null) {
                        mergeFrom(value2);
                    }
                    throw th;
                }
            }

            /* compiled from: Taobao */
            public enum Type implements Internal.EnumLite {
                BYTE(0, 0),
                CHAR(1, 1),
                SHORT(2, 2),
                INT(3, 3),
                LONG(4, 4),
                FLOAT(5, 5),
                DOUBLE(6, 6),
                BOOLEAN(7, 7),
                STRING(8, 8),
                CLASS(9, 9),
                ENUM(10, 10),
                ANNOTATION(11, 11),
                ARRAY(12, 12);
                
                private static Internal.EnumLiteMap<Type> internalValueMap = new a();
                private final int value;

                /* compiled from: Taobao */
                static class a implements Internal.EnumLiteMap<Type> {
                    a() {
                    }

                    /* renamed from: a */
                    public Type findValueByNumber(int i) {
                        return Type.valueOf(i);
                    }
                }

                private Type(int i, int i2) {
                    this.value = i2;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.value;
                }

                public static Type valueOf(int i) {
                    switch (i) {
                        case 0:
                            return BYTE;
                        case 1:
                            return CHAR;
                        case 2:
                            return SHORT;
                        case 3:
                            return INT;
                        case 4:
                            return LONG;
                        case 5:
                            return FLOAT;
                        case 6:
                            return DOUBLE;
                        case 7:
                            return BOOLEAN;
                        case 8:
                            return STRING;
                        case 9:
                            return CLASS;
                        case 10:
                            return ENUM;
                        case 11:
                            return ANNOTATION;
                        case 12:
                            return ARRAY;
                        default:
                            return null;
                    }
                }
            }

            /* compiled from: Taobao */
            static class a extends kotlin.reflect.jvm.internal.impl.protobuf.a<Value> {
                a() {
                }

                /* renamed from: i */
                public Value parsePartialFrom(CodedInputStream codedInputStream, c cVar) throws InvalidProtocolBufferException {
                    return new Value(codedInputStream, cVar);
                }
            }

            static {
                Value value = new Value(true);
                defaultInstance = value;
                value.initFields();
            }

            public static Value getDefaultInstance() {
                return defaultInstance;
            }

            private void initFields() {
                this.type_ = Type.BYTE;
                this.intValue_ = 0;
                this.floatValue_ = 0.0f;
                this.doubleValue_ = 0.0d;
                this.stringValue_ = 0;
                this.classId_ = 0;
                this.enumValueId_ = 0;
                this.annotation_ = ProtoBuf$Annotation.getDefaultInstance();
                this.arrayElement_ = Collections.emptyList();
                this.arrayDimensionCount_ = 0;
                this.flags_ = 0;
            }

            public static Builder newBuilder() {
                return Builder.create();
            }

            public ProtoBuf$Annotation getAnnotation() {
                return this.annotation_;
            }

            public int getArrayDimensionCount() {
                return this.arrayDimensionCount_;
            }

            public Value getArrayElement(int i) {
                return this.arrayElement_.get(i);
            }

            public int getArrayElementCount() {
                return this.arrayElement_.size();
            }

            public List<Value> getArrayElementList() {
                return this.arrayElement_;
            }

            public int getClassId() {
                return this.classId_;
            }

            public double getDoubleValue() {
                return this.doubleValue_;
            }

            public int getEnumValueId() {
                return this.enumValueId_;
            }

            public int getFlags() {
                return this.flags_;
            }

            public float getFloatValue() {
                return this.floatValue_;
            }

            public long getIntValue() {
                return this.intValue_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
            public Parser<Value> getParserForType() {
                return PARSER;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int h = (this.bitField0_ & 1) == 1 ? CodedOutputStream.h(1, this.type_.getNumber()) + 0 : 0;
                if ((this.bitField0_ & 2) == 2) {
                    h += CodedOutputStream.A(2, this.intValue_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    h += CodedOutputStream.l(3, this.floatValue_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    h += CodedOutputStream.f(4, this.doubleValue_);
                }
                if ((this.bitField0_ & 16) == 16) {
                    h += CodedOutputStream.o(5, this.stringValue_);
                }
                if ((this.bitField0_ & 32) == 32) {
                    h += CodedOutputStream.o(6, this.classId_);
                }
                if ((this.bitField0_ & 64) == 64) {
                    h += CodedOutputStream.o(7, this.enumValueId_);
                }
                if ((this.bitField0_ & 128) == 128) {
                    h += CodedOutputStream.s(8, this.annotation_);
                }
                for (int i2 = 0; i2 < this.arrayElement_.size(); i2++) {
                    h += CodedOutputStream.s(9, this.arrayElement_.get(i2));
                }
                if ((this.bitField0_ & 512) == 512) {
                    h += CodedOutputStream.o(10, this.flags_);
                }
                if ((this.bitField0_ & 256) == 256) {
                    h += CodedOutputStream.o(11, this.arrayDimensionCount_);
                }
                int size = h + this.unknownFields.size();
                this.memoizedSerializedSize = size;
                return size;
            }

            public int getStringValue() {
                return this.stringValue_;
            }

            public Type getType() {
                return this.type_;
            }

            public boolean hasAnnotation() {
                return (this.bitField0_ & 128) == 128;
            }

            public boolean hasArrayDimensionCount() {
                return (this.bitField0_ & 256) == 256;
            }

            public boolean hasClassId() {
                return (this.bitField0_ & 32) == 32;
            }

            public boolean hasDoubleValue() {
                return (this.bitField0_ & 8) == 8;
            }

            public boolean hasEnumValueId() {
                return (this.bitField0_ & 64) == 64;
            }

            public boolean hasFlags() {
                return (this.bitField0_ & 512) == 512;
            }

            public boolean hasFloatValue() {
                return (this.bitField0_ & 4) == 4;
            }

            public boolean hasIntValue() {
                return (this.bitField0_ & 2) == 2;
            }

            public boolean hasStringValue() {
                return (this.bitField0_ & 16) == 16;
            }

            public boolean hasType() {
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
                if (!hasAnnotation() || getAnnotation().isInitialized()) {
                    for (int i = 0; i < getArrayElementCount(); i++) {
                        if (!getArrayElement(i).isInitialized()) {
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
                    codedOutputStream.S(1, this.type_.getNumber());
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.t0(2, this.intValue_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.W(3, this.floatValue_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    codedOutputStream.Q(4, this.doubleValue_);
                }
                if ((this.bitField0_ & 16) == 16) {
                    codedOutputStream.a0(5, this.stringValue_);
                }
                if ((this.bitField0_ & 32) == 32) {
                    codedOutputStream.a0(6, this.classId_);
                }
                if ((this.bitField0_ & 64) == 64) {
                    codedOutputStream.a0(7, this.enumValueId_);
                }
                if ((this.bitField0_ & 128) == 128) {
                    codedOutputStream.d0(8, this.annotation_);
                }
                for (int i = 0; i < this.arrayElement_.size(); i++) {
                    codedOutputStream.d0(9, this.arrayElement_.get(i));
                }
                if ((this.bitField0_ & 512) == 512) {
                    codedOutputStream.a0(10, this.flags_);
                }
                if ((this.bitField0_ & 256) == 256) {
                    codedOutputStream.a0(11, this.arrayDimensionCount_);
                }
                codedOutputStream.i0(this.unknownFields);
            }

            public static Builder newBuilder(Value value) {
                return newBuilder().mergeFrom(value);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Value getDefaultInstanceForType() {
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

            private Value(GeneratedMessageLite.Builder builder) {
                super(builder);
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = builder.getUnknownFields();
            }

            private Value(boolean z) {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r6v29, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$Value> */
            /* JADX WARN: Multi-variable type inference failed */
            private Value(CodedInputStream codedInputStream, c cVar) throws InvalidProtocolBufferException {
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
                        switch (K) {
                            case 0:
                                break;
                            case 8:
                                int n2 = codedInputStream.n();
                                Type valueOf = Type.valueOf(n2);
                                if (valueOf == null) {
                                    J.o0(K);
                                    J.o0(n2);
                                    continue;
                                } else {
                                    this.bitField0_ |= 1;
                                    this.type_ = valueOf;
                                }
                            case 16:
                                this.bitField0_ |= 2;
                                this.intValue_ = codedInputStream.H();
                                continue;
                            case 29:
                                this.bitField0_ |= 4;
                                this.floatValue_ = codedInputStream.q();
                                continue;
                            case 33:
                                this.bitField0_ |= 8;
                                this.doubleValue_ = codedInputStream.m();
                                continue;
                            case 40:
                                this.bitField0_ |= 16;
                                this.stringValue_ = codedInputStream.s();
                                continue;
                            case 48:
                                this.bitField0_ |= 32;
                                this.classId_ = codedInputStream.s();
                                continue;
                            case 56:
                                this.bitField0_ |= 64;
                                this.enumValueId_ = codedInputStream.s();
                                continue;
                            case 66:
                                Builder builder = (this.bitField0_ & 128) == 128 ? this.annotation_.toBuilder() : null;
                                ProtoBuf$Annotation protoBuf$Annotation = (ProtoBuf$Annotation) codedInputStream.u(ProtoBuf$Annotation.PARSER, cVar);
                                this.annotation_ = protoBuf$Annotation;
                                if (builder != null) {
                                    builder.mergeFrom(protoBuf$Annotation);
                                    this.annotation_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 128;
                                continue;
                            case 74:
                                if (!(z2 & true)) {
                                    this.arrayElement_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.arrayElement_.add(codedInputStream.u(PARSER, cVar));
                                continue;
                            case 80:
                                this.bitField0_ |= 512;
                                this.flags_ = codedInputStream.s();
                                continue;
                            case 88:
                                this.bitField0_ |= 256;
                                this.arrayDimensionCount_ = codedInputStream.s();
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
                            this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
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
                    this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
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
        public interface ValueOrBuilder extends MessageLiteOrBuilder {
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
            this.nameId_ = 0;
            this.value_ = Value.getDefaultInstance();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public int getNameId() {
            return this.nameId_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
        public Parser<Argument> getParserForType() {
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
                i2 = 0 + CodedOutputStream.o(1, this.nameId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.s(2, this.value_);
            }
            int size = i2 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public Value getValue() {
            return this.value_;
        }

        public boolean hasNameId() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasValue() {
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
            if (!hasNameId()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasValue()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!getValue().isInitialized()) {
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
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.a0(1, this.nameId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.d0(2, this.value_);
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
                            this.bitField0_ |= 1;
                            this.nameId_ = codedInputStream.s();
                        } else if (K == 18) {
                            Value.Builder builder = (this.bitField0_ & 2) == 2 ? this.value_.toBuilder() : null;
                            Value value = (Value) codedInputStream.u(Value.PARSER, cVar);
                            this.value_ = value;
                            if (builder != null) {
                                builder.mergeFrom(value);
                                this.value_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 2;
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
    public static final class Builder extends GeneratedMessageLite.Builder<ProtoBuf$Annotation, Builder> implements ProtoBuf$AnnotationOrBuilder {
        private List<Argument> argument_ = Collections.emptyList();
        private int bitField0_;
        private int id_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        /* access modifiers changed from: private */
        public static Builder create() {
            return new Builder();
        }

        private void ensureArgumentIsMutable() {
            if ((this.bitField0_ & 2) != 2) {
                this.argument_ = new ArrayList(this.argument_);
                this.bitField0_ |= 2;
            }
        }

        private void maybeForceBuilderInitialization() {
        }

        public ProtoBuf$Annotation buildPartial() {
            ProtoBuf$Annotation protoBuf$Annotation = new ProtoBuf$Annotation(this);
            int i = 1;
            if ((this.bitField0_ & 1) != 1) {
                i = 0;
            }
            protoBuf$Annotation.id_ = this.id_;
            if ((this.bitField0_ & 2) == 2) {
                this.argument_ = Collections.unmodifiableList(this.argument_);
                this.bitField0_ &= -3;
            }
            protoBuf$Annotation.argument_ = this.argument_;
            protoBuf$Annotation.bitField0_ = i;
            return protoBuf$Annotation;
        }

        public Argument getArgument(int i) {
            return this.argument_.get(i);
        }

        public int getArgumentCount() {
            return this.argument_.size();
        }

        public boolean hasId() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            if (!hasId()) {
                return false;
            }
            for (int i = 0; i < getArgumentCount(); i++) {
                if (!getArgument(i).isInitialized()) {
                    return false;
                }
            }
            return true;
        }

        public Builder setId(int i) {
            this.bitField0_ |= 1;
            this.id_ = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$Annotation build() {
            ProtoBuf$Annotation buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public ProtoBuf$Annotation getDefaultInstanceForType() {
            return ProtoBuf$Annotation.getDefaultInstance();
        }

        @Override // java.lang.Object, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        public Builder mergeFrom(ProtoBuf$Annotation protoBuf$Annotation) {
            if (protoBuf$Annotation == ProtoBuf$Annotation.getDefaultInstance()) {
                return this;
            }
            if (protoBuf$Annotation.hasId()) {
                setId(protoBuf$Annotation.getId());
            }
            if (!protoBuf$Annotation.argument_.isEmpty()) {
                if (this.argument_.isEmpty()) {
                    this.argument_ = protoBuf$Annotation.argument_;
                    this.bitField0_ &= -3;
                } else {
                    ensureArgumentIsMutable();
                    this.argument_.addAll(protoBuf$Annotation.argument_);
                }
            }
            setUnknownFields(getUnknownFields().b(protoBuf$Annotation.unknownFields));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, c cVar) throws IOException {
            Throwable th;
            ProtoBuf$Annotation protoBuf$Annotation;
            ProtoBuf$Annotation protoBuf$Annotation2 = null;
            try {
                ProtoBuf$Annotation parsePartialFrom = ProtoBuf$Annotation.PARSER.parsePartialFrom(codedInputStream, cVar);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                protoBuf$Annotation = (ProtoBuf$Annotation) e.getUnfinishedMessage();
                throw e;
            } catch (Throwable th2) {
                th = th2;
                protoBuf$Annotation2 = protoBuf$Annotation;
            }
            if (protoBuf$Annotation2 != null) {
                mergeFrom(protoBuf$Annotation2);
            }
            throw th;
        }
    }

    /* compiled from: Taobao */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.a<ProtoBuf$Annotation> {
        a() {
        }

        /* renamed from: i */
        public ProtoBuf$Annotation parsePartialFrom(CodedInputStream codedInputStream, c cVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$Annotation(codedInputStream, cVar);
        }
    }

    static {
        ProtoBuf$Annotation protoBuf$Annotation = new ProtoBuf$Annotation(true);
        defaultInstance = protoBuf$Annotation;
        protoBuf$Annotation.initFields();
    }

    public static ProtoBuf$Annotation getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.id_ = 0;
        this.argument_ = Collections.emptyList();
    }

    public static Builder newBuilder() {
        return Builder.create();
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

    public int getId() {
        return this.id_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
    public Parser<ProtoBuf$Annotation> getParserForType() {
        return PARSER;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int o = (this.bitField0_ & 1) == 1 ? CodedOutputStream.o(1, this.id_) + 0 : 0;
        for (int i2 = 0; i2 < this.argument_.size(); i2++) {
            o += CodedOutputStream.s(2, this.argument_.get(i2));
        }
        int size = o + this.unknownFields.size();
        this.memoizedSerializedSize = size;
        return size;
    }

    public boolean hasId() {
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
        if (!hasId()) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        for (int i = 0; i < getArgumentCount(); i++) {
            if (!getArgument(i).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.a0(1, this.id_);
        }
        for (int i = 0; i < this.argument_.size(); i++) {
            codedOutputStream.d0(2, this.argument_.get(i));
        }
        codedOutputStream.i0(this.unknownFields);
    }

    public static Builder newBuilder(ProtoBuf$Annotation protoBuf$Annotation) {
        return newBuilder().mergeFrom(protoBuf$Annotation);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$Annotation getDefaultInstanceForType() {
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

    private ProtoBuf$Annotation(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = builder.getUnknownFields();
    }

    private ProtoBuf$Annotation(boolean z) {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v5, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument> */
    /* JADX WARN: Multi-variable type inference failed */
    private ProtoBuf$Annotation(CodedInputStream codedInputStream, c cVar) throws InvalidProtocolBufferException {
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
                    } else if (K == 18) {
                        if (!(z2 & true)) {
                            this.argument_ = new ArrayList();
                            z2 |= true;
                        }
                        this.argument_.add(codedInputStream.u(Argument.PARSER, cVar));
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
        if (z2 & true) {
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
