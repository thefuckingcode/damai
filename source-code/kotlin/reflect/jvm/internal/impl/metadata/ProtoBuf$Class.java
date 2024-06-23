package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable;
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
public final class ProtoBuf$Class extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Class> implements ProtoBuf$ClassOrBuilder {
    public static Parser<ProtoBuf$Class> PARSER = new a();
    private static final ProtoBuf$Class defaultInstance;
    private int bitField0_;
    private int companionObjectName_;
    private List<ProtoBuf$Constructor> constructor_;
    private List<ProtoBuf$EnumEntry> enumEntry_;
    private int flags_;
    private int fqName_;
    private List<ProtoBuf$Function> function_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int nestedClassNameMemoizedSerializedSize;
    private List<Integer> nestedClassName_;
    private List<ProtoBuf$Property> property_;
    private int sealedSubclassFqNameMemoizedSerializedSize;
    private List<Integer> sealedSubclassFqName_;
    private int supertypeIdMemoizedSerializedSize;
    private List<Integer> supertypeId_;
    private List<ProtoBuf$Type> supertype_;
    private List<ProtoBuf$TypeAlias> typeAlias_;
    private List<ProtoBuf$TypeParameter> typeParameter_;
    private ProtoBuf$TypeTable typeTable_;
    private final ByteString unknownFields;
    private ProtoBuf$VersionRequirementTable versionRequirementTable_;
    private List<Integer> versionRequirement_;

    /* compiled from: Taobao */
    public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ProtoBuf$Class, Builder> implements ProtoBuf$ClassOrBuilder {
        private int bitField0_;
        private int companionObjectName_;
        private List<ProtoBuf$Constructor> constructor_ = Collections.emptyList();
        private List<ProtoBuf$EnumEntry> enumEntry_ = Collections.emptyList();
        private int flags_ = 6;
        private int fqName_;
        private List<ProtoBuf$Function> function_ = Collections.emptyList();
        private List<Integer> nestedClassName_ = Collections.emptyList();
        private List<ProtoBuf$Property> property_ = Collections.emptyList();
        private List<Integer> sealedSubclassFqName_ = Collections.emptyList();
        private List<Integer> supertypeId_ = Collections.emptyList();
        private List<ProtoBuf$Type> supertype_ = Collections.emptyList();
        private List<ProtoBuf$TypeAlias> typeAlias_ = Collections.emptyList();
        private List<ProtoBuf$TypeParameter> typeParameter_ = Collections.emptyList();
        private ProtoBuf$TypeTable typeTable_ = ProtoBuf$TypeTable.getDefaultInstance();
        private ProtoBuf$VersionRequirementTable versionRequirementTable_ = ProtoBuf$VersionRequirementTable.getDefaultInstance();
        private List<Integer> versionRequirement_ = Collections.emptyList();

        private Builder() {
            maybeForceBuilderInitialization();
        }

        /* access modifiers changed from: private */
        public static Builder create() {
            return new Builder();
        }

        private void ensureConstructorIsMutable() {
            if ((this.bitField0_ & 128) != 128) {
                this.constructor_ = new ArrayList(this.constructor_);
                this.bitField0_ |= 128;
            }
        }

        private void ensureEnumEntryIsMutable() {
            if ((this.bitField0_ & 2048) != 2048) {
                this.enumEntry_ = new ArrayList(this.enumEntry_);
                this.bitField0_ |= 2048;
            }
        }

        private void ensureFunctionIsMutable() {
            if ((this.bitField0_ & 256) != 256) {
                this.function_ = new ArrayList(this.function_);
                this.bitField0_ |= 256;
            }
        }

        private void ensureNestedClassNameIsMutable() {
            if ((this.bitField0_ & 64) != 64) {
                this.nestedClassName_ = new ArrayList(this.nestedClassName_);
                this.bitField0_ |= 64;
            }
        }

        private void ensurePropertyIsMutable() {
            if ((this.bitField0_ & 512) != 512) {
                this.property_ = new ArrayList(this.property_);
                this.bitField0_ |= 512;
            }
        }

        private void ensureSealedSubclassFqNameIsMutable() {
            if ((this.bitField0_ & 4096) != 4096) {
                this.sealedSubclassFqName_ = new ArrayList(this.sealedSubclassFqName_);
                this.bitField0_ |= 4096;
            }
        }

        private void ensureSupertypeIdIsMutable() {
            if ((this.bitField0_ & 32) != 32) {
                this.supertypeId_ = new ArrayList(this.supertypeId_);
                this.bitField0_ |= 32;
            }
        }

        private void ensureSupertypeIsMutable() {
            if ((this.bitField0_ & 16) != 16) {
                this.supertype_ = new ArrayList(this.supertype_);
                this.bitField0_ |= 16;
            }
        }

        private void ensureTypeAliasIsMutable() {
            if ((this.bitField0_ & 1024) != 1024) {
                this.typeAlias_ = new ArrayList(this.typeAlias_);
                this.bitField0_ |= 1024;
            }
        }

        private void ensureTypeParameterIsMutable() {
            if ((this.bitField0_ & 8) != 8) {
                this.typeParameter_ = new ArrayList(this.typeParameter_);
                this.bitField0_ |= 8;
            }
        }

        private void ensureVersionRequirementIsMutable() {
            if ((this.bitField0_ & 16384) != 16384) {
                this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                this.bitField0_ |= 16384;
            }
        }

        private void maybeForceBuilderInitialization() {
        }

        public ProtoBuf$Class buildPartial() {
            ProtoBuf$Class protoBuf$Class = new ProtoBuf$Class(this);
            int i = this.bitField0_;
            int i2 = 1;
            if ((i & 1) != 1) {
                i2 = 0;
            }
            protoBuf$Class.flags_ = this.flags_;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            protoBuf$Class.fqName_ = this.fqName_;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            protoBuf$Class.companionObjectName_ = this.companionObjectName_;
            if ((this.bitField0_ & 8) == 8) {
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                this.bitField0_ &= -9;
            }
            protoBuf$Class.typeParameter_ = this.typeParameter_;
            if ((this.bitField0_ & 16) == 16) {
                this.supertype_ = Collections.unmodifiableList(this.supertype_);
                this.bitField0_ &= -17;
            }
            protoBuf$Class.supertype_ = this.supertype_;
            if ((this.bitField0_ & 32) == 32) {
                this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
                this.bitField0_ &= -33;
            }
            protoBuf$Class.supertypeId_ = this.supertypeId_;
            if ((this.bitField0_ & 64) == 64) {
                this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
                this.bitField0_ &= -65;
            }
            protoBuf$Class.nestedClassName_ = this.nestedClassName_;
            if ((this.bitField0_ & 128) == 128) {
                this.constructor_ = Collections.unmodifiableList(this.constructor_);
                this.bitField0_ &= -129;
            }
            protoBuf$Class.constructor_ = this.constructor_;
            if ((this.bitField0_ & 256) == 256) {
                this.function_ = Collections.unmodifiableList(this.function_);
                this.bitField0_ &= -257;
            }
            protoBuf$Class.function_ = this.function_;
            if ((this.bitField0_ & 512) == 512) {
                this.property_ = Collections.unmodifiableList(this.property_);
                this.bitField0_ &= -513;
            }
            protoBuf$Class.property_ = this.property_;
            if ((this.bitField0_ & 1024) == 1024) {
                this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                this.bitField0_ &= -1025;
            }
            protoBuf$Class.typeAlias_ = this.typeAlias_;
            if ((this.bitField0_ & 2048) == 2048) {
                this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
                this.bitField0_ &= -2049;
            }
            protoBuf$Class.enumEntry_ = this.enumEntry_;
            if ((this.bitField0_ & 4096) == 4096) {
                this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
                this.bitField0_ &= -4097;
            }
            protoBuf$Class.sealedSubclassFqName_ = this.sealedSubclassFqName_;
            if ((i & 8192) == 8192) {
                i2 |= 8;
            }
            protoBuf$Class.typeTable_ = this.typeTable_;
            if ((this.bitField0_ & 16384) == 16384) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -16385;
            }
            protoBuf$Class.versionRequirement_ = this.versionRequirement_;
            if ((i & 32768) == 32768) {
                i2 |= 16;
            }
            protoBuf$Class.versionRequirementTable_ = this.versionRequirementTable_;
            protoBuf$Class.bitField0_ = i2;
            return protoBuf$Class;
        }

        public ProtoBuf$Constructor getConstructor(int i) {
            return this.constructor_.get(i);
        }

        public int getConstructorCount() {
            return this.constructor_.size();
        }

        public ProtoBuf$EnumEntry getEnumEntry(int i) {
            return this.enumEntry_.get(i);
        }

        public int getEnumEntryCount() {
            return this.enumEntry_.size();
        }

        public ProtoBuf$Function getFunction(int i) {
            return this.function_.get(i);
        }

        public int getFunctionCount() {
            return this.function_.size();
        }

        public ProtoBuf$Property getProperty(int i) {
            return this.property_.get(i);
        }

        public int getPropertyCount() {
            return this.property_.size();
        }

        public ProtoBuf$Type getSupertype(int i) {
            return this.supertype_.get(i);
        }

        public int getSupertypeCount() {
            return this.supertype_.size();
        }

        public ProtoBuf$TypeAlias getTypeAlias(int i) {
            return this.typeAlias_.get(i);
        }

        public int getTypeAliasCount() {
            return this.typeAlias_.size();
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

        public boolean hasFqName() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasTypeTable() {
            return (this.bitField0_ & 8192) == 8192;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            if (!hasFqName()) {
                return false;
            }
            for (int i = 0; i < getTypeParameterCount(); i++) {
                if (!getTypeParameter(i).isInitialized()) {
                    return false;
                }
            }
            for (int i2 = 0; i2 < getSupertypeCount(); i2++) {
                if (!getSupertype(i2).isInitialized()) {
                    return false;
                }
            }
            for (int i3 = 0; i3 < getConstructorCount(); i3++) {
                if (!getConstructor(i3).isInitialized()) {
                    return false;
                }
            }
            for (int i4 = 0; i4 < getFunctionCount(); i4++) {
                if (!getFunction(i4).isInitialized()) {
                    return false;
                }
            }
            for (int i5 = 0; i5 < getPropertyCount(); i5++) {
                if (!getProperty(i5).isInitialized()) {
                    return false;
                }
            }
            for (int i6 = 0; i6 < getTypeAliasCount(); i6++) {
                if (!getTypeAlias(i6).isInitialized()) {
                    return false;
                }
            }
            for (int i7 = 0; i7 < getEnumEntryCount(); i7++) {
                if (!getEnumEntry(i7).isInitialized()) {
                    return false;
                }
            }
            if ((!hasTypeTable() || getTypeTable().isInitialized()) && extensionsAreInitialized()) {
                return true;
            }
            return false;
        }

        public Builder mergeTypeTable(ProtoBuf$TypeTable protoBuf$TypeTable) {
            if ((this.bitField0_ & 8192) != 8192 || this.typeTable_ == ProtoBuf$TypeTable.getDefaultInstance()) {
                this.typeTable_ = protoBuf$TypeTable;
            } else {
                this.typeTable_ = ProtoBuf$TypeTable.newBuilder(this.typeTable_).mergeFrom(protoBuf$TypeTable).buildPartial();
            }
            this.bitField0_ |= 8192;
            return this;
        }

        public Builder mergeVersionRequirementTable(ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable) {
            if ((this.bitField0_ & 32768) != 32768 || this.versionRequirementTable_ == ProtoBuf$VersionRequirementTable.getDefaultInstance()) {
                this.versionRequirementTable_ = protoBuf$VersionRequirementTable;
            } else {
                this.versionRequirementTable_ = ProtoBuf$VersionRequirementTable.newBuilder(this.versionRequirementTable_).mergeFrom(protoBuf$VersionRequirementTable).buildPartial();
            }
            this.bitField0_ |= 32768;
            return this;
        }

        public Builder setCompanionObjectName(int i) {
            this.bitField0_ |= 4;
            this.companionObjectName_ = i;
            return this;
        }

        public Builder setFlags(int i) {
            this.bitField0_ |= 1;
            this.flags_ = i;
            return this;
        }

        public Builder setFqName(int i) {
            this.bitField0_ |= 2;
            this.fqName_ = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$Class build() {
            ProtoBuf$Class buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public ProtoBuf$Class getDefaultInstanceForType() {
            return ProtoBuf$Class.getDefaultInstance();
        }

        public Builder mergeFrom(ProtoBuf$Class protoBuf$Class) {
            if (protoBuf$Class == ProtoBuf$Class.getDefaultInstance()) {
                return this;
            }
            if (protoBuf$Class.hasFlags()) {
                setFlags(protoBuf$Class.getFlags());
            }
            if (protoBuf$Class.hasFqName()) {
                setFqName(protoBuf$Class.getFqName());
            }
            if (protoBuf$Class.hasCompanionObjectName()) {
                setCompanionObjectName(protoBuf$Class.getCompanionObjectName());
            }
            if (!protoBuf$Class.typeParameter_.isEmpty()) {
                if (this.typeParameter_.isEmpty()) {
                    this.typeParameter_ = protoBuf$Class.typeParameter_;
                    this.bitField0_ &= -9;
                } else {
                    ensureTypeParameterIsMutable();
                    this.typeParameter_.addAll(protoBuf$Class.typeParameter_);
                }
            }
            if (!protoBuf$Class.supertype_.isEmpty()) {
                if (this.supertype_.isEmpty()) {
                    this.supertype_ = protoBuf$Class.supertype_;
                    this.bitField0_ &= -17;
                } else {
                    ensureSupertypeIsMutable();
                    this.supertype_.addAll(protoBuf$Class.supertype_);
                }
            }
            if (!protoBuf$Class.supertypeId_.isEmpty()) {
                if (this.supertypeId_.isEmpty()) {
                    this.supertypeId_ = protoBuf$Class.supertypeId_;
                    this.bitField0_ &= -33;
                } else {
                    ensureSupertypeIdIsMutable();
                    this.supertypeId_.addAll(protoBuf$Class.supertypeId_);
                }
            }
            if (!protoBuf$Class.nestedClassName_.isEmpty()) {
                if (this.nestedClassName_.isEmpty()) {
                    this.nestedClassName_ = protoBuf$Class.nestedClassName_;
                    this.bitField0_ &= -65;
                } else {
                    ensureNestedClassNameIsMutable();
                    this.nestedClassName_.addAll(protoBuf$Class.nestedClassName_);
                }
            }
            if (!protoBuf$Class.constructor_.isEmpty()) {
                if (this.constructor_.isEmpty()) {
                    this.constructor_ = protoBuf$Class.constructor_;
                    this.bitField0_ &= -129;
                } else {
                    ensureConstructorIsMutable();
                    this.constructor_.addAll(protoBuf$Class.constructor_);
                }
            }
            if (!protoBuf$Class.function_.isEmpty()) {
                if (this.function_.isEmpty()) {
                    this.function_ = protoBuf$Class.function_;
                    this.bitField0_ &= -257;
                } else {
                    ensureFunctionIsMutable();
                    this.function_.addAll(protoBuf$Class.function_);
                }
            }
            if (!protoBuf$Class.property_.isEmpty()) {
                if (this.property_.isEmpty()) {
                    this.property_ = protoBuf$Class.property_;
                    this.bitField0_ &= -513;
                } else {
                    ensurePropertyIsMutable();
                    this.property_.addAll(protoBuf$Class.property_);
                }
            }
            if (!protoBuf$Class.typeAlias_.isEmpty()) {
                if (this.typeAlias_.isEmpty()) {
                    this.typeAlias_ = protoBuf$Class.typeAlias_;
                    this.bitField0_ &= -1025;
                } else {
                    ensureTypeAliasIsMutable();
                    this.typeAlias_.addAll(protoBuf$Class.typeAlias_);
                }
            }
            if (!protoBuf$Class.enumEntry_.isEmpty()) {
                if (this.enumEntry_.isEmpty()) {
                    this.enumEntry_ = protoBuf$Class.enumEntry_;
                    this.bitField0_ &= -2049;
                } else {
                    ensureEnumEntryIsMutable();
                    this.enumEntry_.addAll(protoBuf$Class.enumEntry_);
                }
            }
            if (!protoBuf$Class.sealedSubclassFqName_.isEmpty()) {
                if (this.sealedSubclassFqName_.isEmpty()) {
                    this.sealedSubclassFqName_ = protoBuf$Class.sealedSubclassFqName_;
                    this.bitField0_ &= -4097;
                } else {
                    ensureSealedSubclassFqNameIsMutable();
                    this.sealedSubclassFqName_.addAll(protoBuf$Class.sealedSubclassFqName_);
                }
            }
            if (protoBuf$Class.hasTypeTable()) {
                mergeTypeTable(protoBuf$Class.getTypeTable());
            }
            if (!protoBuf$Class.versionRequirement_.isEmpty()) {
                if (this.versionRequirement_.isEmpty()) {
                    this.versionRequirement_ = protoBuf$Class.versionRequirement_;
                    this.bitField0_ &= -16385;
                } else {
                    ensureVersionRequirementIsMutable();
                    this.versionRequirement_.addAll(protoBuf$Class.versionRequirement_);
                }
            }
            if (protoBuf$Class.hasVersionRequirementTable()) {
                mergeVersionRequirementTable(protoBuf$Class.getVersionRequirementTable());
            }
            mergeExtensionFields(protoBuf$Class);
            setUnknownFields(getUnknownFields().b(protoBuf$Class.unknownFields));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, java.lang.Object, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, c cVar) throws IOException {
            Throwable th;
            ProtoBuf$Class protoBuf$Class;
            ProtoBuf$Class protoBuf$Class2 = null;
            try {
                ProtoBuf$Class parsePartialFrom = ProtoBuf$Class.PARSER.parsePartialFrom(codedInputStream, cVar);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                protoBuf$Class = (ProtoBuf$Class) e.getUnfinishedMessage();
                throw e;
            } catch (Throwable th2) {
                th = th2;
                protoBuf$Class2 = protoBuf$Class;
            }
            if (protoBuf$Class2 != null) {
                mergeFrom(protoBuf$Class2);
            }
            throw th;
        }
    }

    /* compiled from: Taobao */
    public enum Kind implements Internal.EnumLite {
        CLASS(0, 0),
        INTERFACE(1, 1),
        ENUM_CLASS(2, 2),
        ENUM_ENTRY(3, 3),
        ANNOTATION_CLASS(4, 4),
        OBJECT(5, 5),
        COMPANION_OBJECT(6, 6);
        
        private static Internal.EnumLiteMap<Kind> internalValueMap = new a();
        private final int value;

        /* compiled from: Taobao */
        static class a implements Internal.EnumLiteMap<Kind> {
            a() {
            }

            /* renamed from: a */
            public Kind findValueByNumber(int i) {
                return Kind.valueOf(i);
            }
        }

        private Kind(int i, int i2) {
            this.value = i2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static Kind valueOf(int i) {
            switch (i) {
                case 0:
                    return CLASS;
                case 1:
                    return INTERFACE;
                case 2:
                    return ENUM_CLASS;
                case 3:
                    return ENUM_ENTRY;
                case 4:
                    return ANNOTATION_CLASS;
                case 5:
                    return OBJECT;
                case 6:
                    return COMPANION_OBJECT;
                default:
                    return null;
            }
        }
    }

    /* compiled from: Taobao */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.a<ProtoBuf$Class> {
        a() {
        }

        /* renamed from: i */
        public ProtoBuf$Class parsePartialFrom(CodedInputStream codedInputStream, c cVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$Class(codedInputStream, cVar);
        }
    }

    static {
        ProtoBuf$Class protoBuf$Class = new ProtoBuf$Class(true);
        defaultInstance = protoBuf$Class;
        protoBuf$Class.initFields();
    }

    public static ProtoBuf$Class getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.flags_ = 6;
        this.fqName_ = 0;
        this.companionObjectName_ = 0;
        this.typeParameter_ = Collections.emptyList();
        this.supertype_ = Collections.emptyList();
        this.supertypeId_ = Collections.emptyList();
        this.nestedClassName_ = Collections.emptyList();
        this.constructor_ = Collections.emptyList();
        this.function_ = Collections.emptyList();
        this.property_ = Collections.emptyList();
        this.typeAlias_ = Collections.emptyList();
        this.enumEntry_ = Collections.emptyList();
        this.sealedSubclassFqName_ = Collections.emptyList();
        this.typeTable_ = ProtoBuf$TypeTable.getDefaultInstance();
        this.versionRequirement_ = Collections.emptyList();
        this.versionRequirementTable_ = ProtoBuf$VersionRequirementTable.getDefaultInstance();
    }

    public static Builder newBuilder() {
        return Builder.create();
    }

    public static ProtoBuf$Class parseFrom(InputStream inputStream, c cVar) throws IOException {
        return PARSER.parseFrom(inputStream, cVar);
    }

    public int getCompanionObjectName() {
        return this.companionObjectName_;
    }

    public ProtoBuf$Constructor getConstructor(int i) {
        return this.constructor_.get(i);
    }

    public int getConstructorCount() {
        return this.constructor_.size();
    }

    public List<ProtoBuf$Constructor> getConstructorList() {
        return this.constructor_;
    }

    public ProtoBuf$EnumEntry getEnumEntry(int i) {
        return this.enumEntry_.get(i);
    }

    public int getEnumEntryCount() {
        return this.enumEntry_.size();
    }

    public List<ProtoBuf$EnumEntry> getEnumEntryList() {
        return this.enumEntry_;
    }

    public int getFlags() {
        return this.flags_;
    }

    public int getFqName() {
        return this.fqName_;
    }

    public ProtoBuf$Function getFunction(int i) {
        return this.function_.get(i);
    }

    public int getFunctionCount() {
        return this.function_.size();
    }

    public List<ProtoBuf$Function> getFunctionList() {
        return this.function_;
    }

    public List<Integer> getNestedClassNameList() {
        return this.nestedClassName_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
    public Parser<ProtoBuf$Class> getParserForType() {
        return PARSER;
    }

    public ProtoBuf$Property getProperty(int i) {
        return this.property_.get(i);
    }

    public int getPropertyCount() {
        return this.property_.size();
    }

    public List<ProtoBuf$Property> getPropertyList() {
        return this.property_;
    }

    public List<Integer> getSealedSubclassFqNameList() {
        return this.sealedSubclassFqName_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int o = (this.bitField0_ & 1) == 1 ? CodedOutputStream.o(1, this.flags_) + 0 : 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.supertypeId_.size(); i3++) {
            i2 += CodedOutputStream.p(this.supertypeId_.get(i3).intValue());
        }
        int i4 = o + i2;
        if (!getSupertypeIdList().isEmpty()) {
            i4 = i4 + 1 + CodedOutputStream.p(i2);
        }
        this.supertypeIdMemoizedSerializedSize = i2;
        if ((this.bitField0_ & 2) == 2) {
            i4 += CodedOutputStream.o(3, this.fqName_);
        }
        if ((this.bitField0_ & 4) == 4) {
            i4 += CodedOutputStream.o(4, this.companionObjectName_);
        }
        for (int i5 = 0; i5 < this.typeParameter_.size(); i5++) {
            i4 += CodedOutputStream.s(5, this.typeParameter_.get(i5));
        }
        for (int i6 = 0; i6 < this.supertype_.size(); i6++) {
            i4 += CodedOutputStream.s(6, this.supertype_.get(i6));
        }
        int i7 = 0;
        for (int i8 = 0; i8 < this.nestedClassName_.size(); i8++) {
            i7 += CodedOutputStream.p(this.nestedClassName_.get(i8).intValue());
        }
        int i9 = i4 + i7;
        if (!getNestedClassNameList().isEmpty()) {
            i9 = i9 + 1 + CodedOutputStream.p(i7);
        }
        this.nestedClassNameMemoizedSerializedSize = i7;
        for (int i10 = 0; i10 < this.constructor_.size(); i10++) {
            i9 += CodedOutputStream.s(8, this.constructor_.get(i10));
        }
        for (int i11 = 0; i11 < this.function_.size(); i11++) {
            i9 += CodedOutputStream.s(9, this.function_.get(i11));
        }
        for (int i12 = 0; i12 < this.property_.size(); i12++) {
            i9 += CodedOutputStream.s(10, this.property_.get(i12));
        }
        for (int i13 = 0; i13 < this.typeAlias_.size(); i13++) {
            i9 += CodedOutputStream.s(11, this.typeAlias_.get(i13));
        }
        for (int i14 = 0; i14 < this.enumEntry_.size(); i14++) {
            i9 += CodedOutputStream.s(13, this.enumEntry_.get(i14));
        }
        int i15 = 0;
        for (int i16 = 0; i16 < this.sealedSubclassFqName_.size(); i16++) {
            i15 += CodedOutputStream.p(this.sealedSubclassFqName_.get(i16).intValue());
        }
        int i17 = i9 + i15;
        if (!getSealedSubclassFqNameList().isEmpty()) {
            i17 = i17 + 2 + CodedOutputStream.p(i15);
        }
        this.sealedSubclassFqNameMemoizedSerializedSize = i15;
        if ((this.bitField0_ & 8) == 8) {
            i17 += CodedOutputStream.s(30, this.typeTable_);
        }
        int i18 = 0;
        for (int i19 = 0; i19 < this.versionRequirement_.size(); i19++) {
            i18 += CodedOutputStream.p(this.versionRequirement_.get(i19).intValue());
        }
        int size = i17 + i18 + (getVersionRequirementList().size() * 2);
        if ((this.bitField0_ & 16) == 16) {
            size += CodedOutputStream.s(32, this.versionRequirementTable_);
        }
        int extensionsSerializedSize = size + extensionsSerializedSize() + this.unknownFields.size();
        this.memoizedSerializedSize = extensionsSerializedSize;
        return extensionsSerializedSize;
    }

    public ProtoBuf$Type getSupertype(int i) {
        return this.supertype_.get(i);
    }

    public int getSupertypeCount() {
        return this.supertype_.size();
    }

    public List<Integer> getSupertypeIdList() {
        return this.supertypeId_;
    }

    public List<ProtoBuf$Type> getSupertypeList() {
        return this.supertype_;
    }

    public ProtoBuf$TypeAlias getTypeAlias(int i) {
        return this.typeAlias_.get(i);
    }

    public int getTypeAliasCount() {
        return this.typeAlias_.size();
    }

    public List<ProtoBuf$TypeAlias> getTypeAliasList() {
        return this.typeAlias_;
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

    public List<Integer> getVersionRequirementList() {
        return this.versionRequirement_;
    }

    public ProtoBuf$VersionRequirementTable getVersionRequirementTable() {
        return this.versionRequirementTable_;
    }

    public boolean hasCompanionObjectName() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasFqName() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasTypeTable() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasVersionRequirementTable() {
        return (this.bitField0_ & 16) == 16;
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
        if (!hasFqName()) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        for (int i = 0; i < getTypeParameterCount(); i++) {
            if (!getTypeParameter(i).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        for (int i2 = 0; i2 < getSupertypeCount(); i2++) {
            if (!getSupertype(i2).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        for (int i3 = 0; i3 < getConstructorCount(); i3++) {
            if (!getConstructor(i3).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        for (int i4 = 0; i4 < getFunctionCount(); i4++) {
            if (!getFunction(i4).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        for (int i5 = 0; i5 < getPropertyCount(); i5++) {
            if (!getProperty(i5).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        for (int i6 = 0; i6 < getTypeAliasCount(); i6++) {
            if (!getTypeAlias(i6).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        for (int i7 = 0; i7 < getEnumEntryCount(); i7++) {
            if (!getEnumEntry(i7).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        if (hasTypeTable() && !getTypeTable().isInitialized()) {
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
        if (getSupertypeIdList().size() > 0) {
            codedOutputStream.o0(18);
            codedOutputStream.o0(this.supertypeIdMemoizedSerializedSize);
        }
        for (int i = 0; i < this.supertypeId_.size(); i++) {
            codedOutputStream.b0(this.supertypeId_.get(i).intValue());
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.a0(3, this.fqName_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.a0(4, this.companionObjectName_);
        }
        for (int i2 = 0; i2 < this.typeParameter_.size(); i2++) {
            codedOutputStream.d0(5, this.typeParameter_.get(i2));
        }
        for (int i3 = 0; i3 < this.supertype_.size(); i3++) {
            codedOutputStream.d0(6, this.supertype_.get(i3));
        }
        if (getNestedClassNameList().size() > 0) {
            codedOutputStream.o0(58);
            codedOutputStream.o0(this.nestedClassNameMemoizedSerializedSize);
        }
        for (int i4 = 0; i4 < this.nestedClassName_.size(); i4++) {
            codedOutputStream.b0(this.nestedClassName_.get(i4).intValue());
        }
        for (int i5 = 0; i5 < this.constructor_.size(); i5++) {
            codedOutputStream.d0(8, this.constructor_.get(i5));
        }
        for (int i6 = 0; i6 < this.function_.size(); i6++) {
            codedOutputStream.d0(9, this.function_.get(i6));
        }
        for (int i7 = 0; i7 < this.property_.size(); i7++) {
            codedOutputStream.d0(10, this.property_.get(i7));
        }
        for (int i8 = 0; i8 < this.typeAlias_.size(); i8++) {
            codedOutputStream.d0(11, this.typeAlias_.get(i8));
        }
        for (int i9 = 0; i9 < this.enumEntry_.size(); i9++) {
            codedOutputStream.d0(13, this.enumEntry_.get(i9));
        }
        if (getSealedSubclassFqNameList().size() > 0) {
            codedOutputStream.o0(130);
            codedOutputStream.o0(this.sealedSubclassFqNameMemoizedSerializedSize);
        }
        for (int i10 = 0; i10 < this.sealedSubclassFqName_.size(); i10++) {
            codedOutputStream.b0(this.sealedSubclassFqName_.get(i10).intValue());
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.d0(30, this.typeTable_);
        }
        for (int i11 = 0; i11 < this.versionRequirement_.size(); i11++) {
            codedOutputStream.a0(31, this.versionRequirement_.get(i11).intValue());
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.d0(32, this.versionRequirementTable_);
        }
        newExtensionWriter.a(19000, codedOutputStream);
        codedOutputStream.i0(this.unknownFields);
    }

    public static Builder newBuilder(ProtoBuf$Class protoBuf$Class) {
        return newBuilder().mergeFrom(protoBuf$Class);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$Class getDefaultInstanceForType() {
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

    private ProtoBuf$Class(GeneratedMessageLite.ExtendableBuilder<ProtoBuf$Class, ?> extendableBuilder) {
        super(extendableBuilder);
        this.supertypeIdMemoizedSerializedSize = -1;
        this.nestedClassNameMemoizedSerializedSize = -1;
        this.sealedSubclassFqNameMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = extendableBuilder.getUnknownFields();
    }

    private ProtoBuf$Class(boolean z) {
        this.supertypeIdMemoizedSerializedSize = -1;
        this.nestedClassNameMemoizedSerializedSize = -1;
        this.sealedSubclassFqNameMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v23, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v26, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v34, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v37, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v40, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v43, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v46, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry> */
    /* JADX WARN: Multi-variable type inference failed */
    private ProtoBuf$Class(CodedInputStream codedInputStream, c cVar) throws InvalidProtocolBufferException {
        this.supertypeIdMemoizedSerializedSize = -1;
        this.nestedClassNameMemoizedSerializedSize = -1;
        this.sealedSubclassFqNameMemoizedSerializedSize = -1;
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
                ProtoBuf$TypeTable.Builder builder = null;
                ProtoBuf$VersionRequirementTable.Builder builder2 = null;
                switch (K) {
                    case 0:
                        z = true;
                        break;
                    case 8:
                        this.bitField0_ |= 1;
                        this.flags_ = codedInputStream.s();
                        break;
                    case 16:
                        if (!(z2 & true)) {
                            this.supertypeId_ = new ArrayList();
                            z2 |= true;
                        }
                        this.supertypeId_.add(Integer.valueOf(codedInputStream.s()));
                        break;
                    case 18:
                        int j = codedInputStream.j(codedInputStream.A());
                        if (!(z2 & true) && codedInputStream.e() > 0) {
                            this.supertypeId_ = new ArrayList();
                            z2 |= true;
                        }
                        while (codedInputStream.e() > 0) {
                            this.supertypeId_.add(Integer.valueOf(codedInputStream.s()));
                        }
                        codedInputStream.i(j);
                        break;
                    case 24:
                        this.bitField0_ |= 2;
                        this.fqName_ = codedInputStream.s();
                        break;
                    case 32:
                        this.bitField0_ |= 4;
                        this.companionObjectName_ = codedInputStream.s();
                        break;
                    case 42:
                        if (!(z2 & true)) {
                            this.typeParameter_ = new ArrayList();
                            z2 |= true;
                        }
                        this.typeParameter_.add(codedInputStream.u(ProtoBuf$TypeParameter.PARSER, cVar));
                        break;
                    case 50:
                        if (!(z2 & true)) {
                            this.supertype_ = new ArrayList();
                            z2 |= true;
                        }
                        this.supertype_.add(codedInputStream.u(ProtoBuf$Type.PARSER, cVar));
                        break;
                    case 56:
                        if (!(z2 & true)) {
                            this.nestedClassName_ = new ArrayList();
                            z2 |= true;
                        }
                        this.nestedClassName_.add(Integer.valueOf(codedInputStream.s()));
                        break;
                    case 58:
                        int j2 = codedInputStream.j(codedInputStream.A());
                        if (!(z2 & true) && codedInputStream.e() > 0) {
                            this.nestedClassName_ = new ArrayList();
                            z2 |= true;
                        }
                        while (codedInputStream.e() > 0) {
                            this.nestedClassName_.add(Integer.valueOf(codedInputStream.s()));
                        }
                        codedInputStream.i(j2);
                        break;
                    case 66:
                        if (!(z2 & true)) {
                            this.constructor_ = new ArrayList();
                            z2 |= true;
                        }
                        this.constructor_.add(codedInputStream.u(ProtoBuf$Constructor.PARSER, cVar));
                        break;
                    case 74:
                        if (!(z2 & true)) {
                            this.function_ = new ArrayList();
                            z2 |= true;
                        }
                        this.function_.add(codedInputStream.u(ProtoBuf$Function.PARSER, cVar));
                        break;
                    case 82:
                        if (!(z2 & true)) {
                            this.property_ = new ArrayList();
                            z2 |= true;
                        }
                        this.property_.add(codedInputStream.u(ProtoBuf$Property.PARSER, cVar));
                        break;
                    case 90:
                        if (!(z2 & true)) {
                            this.typeAlias_ = new ArrayList();
                            z2 |= true;
                        }
                        this.typeAlias_.add(codedInputStream.u(ProtoBuf$TypeAlias.PARSER, cVar));
                        break;
                    case 106:
                        if (!(z2 & true)) {
                            this.enumEntry_ = new ArrayList();
                            z2 |= true;
                        }
                        this.enumEntry_.add(codedInputStream.u(ProtoBuf$EnumEntry.PARSER, cVar));
                        break;
                    case 128:
                        if (!(z2 & true)) {
                            this.sealedSubclassFqName_ = new ArrayList();
                            z2 |= true;
                        }
                        this.sealedSubclassFqName_.add(Integer.valueOf(codedInputStream.s()));
                        break;
                    case 130:
                        int j3 = codedInputStream.j(codedInputStream.A());
                        if (!(z2 & true) && codedInputStream.e() > 0) {
                            this.sealedSubclassFqName_ = new ArrayList();
                            z2 |= true;
                        }
                        while (codedInputStream.e() > 0) {
                            this.sealedSubclassFqName_.add(Integer.valueOf(codedInputStream.s()));
                        }
                        codedInputStream.i(j3);
                        break;
                    case 242:
                        builder = (this.bitField0_ & 8) == 8 ? this.typeTable_.toBuilder() : builder;
                        ProtoBuf$TypeTable protoBuf$TypeTable = (ProtoBuf$TypeTable) codedInputStream.u(ProtoBuf$TypeTable.PARSER, cVar);
                        this.typeTable_ = protoBuf$TypeTable;
                        if (builder != null) {
                            builder.mergeFrom(protoBuf$TypeTable);
                            this.typeTable_ = builder.buildPartial();
                        }
                        this.bitField0_ |= 8;
                        break;
                    case 248:
                        if (!(z2 & true)) {
                            this.versionRequirement_ = new ArrayList();
                            z2 |= true;
                        }
                        this.versionRequirement_.add(Integer.valueOf(codedInputStream.s()));
                        break;
                    case 250:
                        int j4 = codedInputStream.j(codedInputStream.A());
                        if (!(z2 & true) && codedInputStream.e() > 0) {
                            this.versionRequirement_ = new ArrayList();
                            z2 |= true;
                        }
                        while (codedInputStream.e() > 0) {
                            this.versionRequirement_.add(Integer.valueOf(codedInputStream.s()));
                        }
                        codedInputStream.i(j4);
                        break;
                    case 258:
                        builder2 = (this.bitField0_ & 16) == 16 ? this.versionRequirementTable_.toBuilder() : builder2;
                        ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable = (ProtoBuf$VersionRequirementTable) codedInputStream.u(ProtoBuf$VersionRequirementTable.PARSER, cVar);
                        this.versionRequirementTable_ = protoBuf$VersionRequirementTable;
                        if (builder2 != null) {
                            builder2.mergeFrom(protoBuf$VersionRequirementTable);
                            this.versionRequirementTable_ = builder2.buildPartial();
                        }
                        this.bitField0_ |= 16;
                        break;
                    default:
                        if (parseUnknownField(codedInputStream, J, cVar, K)) {
                            break;
                        }
                        z = true;
                        break;
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e2) {
                throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
            } catch (Throwable th) {
                if (z2 & true) {
                    this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
                }
                if (z2 & true) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                }
                if (z2 & true) {
                    this.supertype_ = Collections.unmodifiableList(this.supertype_);
                }
                if (z2 & true) {
                    this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
                }
                if (z2 & true) {
                    this.constructor_ = Collections.unmodifiableList(this.constructor_);
                }
                if (z2 & true) {
                    this.function_ = Collections.unmodifiableList(this.function_);
                }
                if (z2 & true) {
                    this.property_ = Collections.unmodifiableList(this.property_);
                }
                if (z2 & true) {
                    this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                }
                if (z2 & true) {
                    this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
                }
                if (z2 & true) {
                    this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
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
            this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
        }
        if (z2 & true) {
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        }
        if (z2 & true) {
            this.supertype_ = Collections.unmodifiableList(this.supertype_);
        }
        if (z2 & true) {
            this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
        }
        if (z2 & true) {
            this.constructor_ = Collections.unmodifiableList(this.constructor_);
        }
        if (z2 & true) {
            this.function_ = Collections.unmodifiableList(this.function_);
        }
        if (z2 & true) {
            this.property_ = Collections.unmodifiableList(this.property_);
        }
        if (z2 & true) {
            this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
        }
        if (z2 & true) {
            this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
        }
        if (z2 & true) {
            this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
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
