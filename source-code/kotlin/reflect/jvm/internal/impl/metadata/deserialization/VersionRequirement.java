package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.DeprecationLevel;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* compiled from: VersionRequirement.kt */
public final class VersionRequirement {
    public static final Companion Companion = new Companion(null);
    private final Integer errorCode;
    private final ProtoBuf.VersionRequirement.VersionKind kind;
    private final DeprecationLevel level;
    private final String message;
    private final Version version;

    public VersionRequirement(Version version2, ProtoBuf.VersionRequirement.VersionKind versionKind, DeprecationLevel deprecationLevel, Integer num, String str) {
        Intrinsics.checkParameterIsNotNull(version2, "version");
        Intrinsics.checkParameterIsNotNull(versionKind, "kind");
        Intrinsics.checkParameterIsNotNull(deprecationLevel, "level");
        this.version = version2;
        this.kind = versionKind;
        this.level = deprecationLevel;
        this.errorCode = num;
        this.message = str;
    }

    public final Version getVersion() {
        return this.version;
    }

    public final ProtoBuf.VersionRequirement.VersionKind getKind() {
        return this.kind;
    }

    /* compiled from: VersionRequirement.kt */
    public static final class Version {
        public static final Companion Companion = new Companion(null);
        public static final Version INFINITY = new Version(256, 256, 256);
        private final int major;
        private final int minor;
        private final int patch;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Version)) {
                return false;
            }
            Version version = (Version) obj;
            return this.major == version.major && this.minor == version.minor && this.patch == version.patch;
        }

        public int hashCode() {
            return (((this.major * 31) + this.minor) * 31) + this.patch;
        }

        public Version(int i, int i2, int i3) {
            this.major = i;
            this.minor = i2;
            this.patch = i3;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Version(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, (i4 & 4) != 0 ? 0 : i3);
        }

        public final String asString() {
            int i;
            StringBuilder sb;
            if (this.patch == 0) {
                sb = new StringBuilder();
                sb.append(this.major);
                sb.append('.');
                i = this.minor;
            } else {
                sb = new StringBuilder();
                sb.append(this.major);
                sb.append('.');
                sb.append(this.minor);
                sb.append('.');
                i = this.patch;
            }
            sb.append(i);
            return sb.toString();
        }

        public String toString() {
            return asString();
        }

        /* compiled from: VersionRequirement.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Version decode(Integer num, Integer num2) {
                if (num2 != null) {
                    return new Version(num2.intValue() & 255, (num2.intValue() >> 8) & 255, (num2.intValue() >> 16) & 255);
                }
                if (num != null) {
                    return new Version(num.intValue() & 7, (num.intValue() >> 3) & 15, (num.intValue() >> 7) & 127);
                }
                return Version.INFINITY;
            }
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("since ");
        sb.append(this.version);
        sb.append(' ');
        sb.append(this.level);
        String str2 = "";
        if (this.errorCode != null) {
            str = " error " + this.errorCode;
        } else {
            str = str2;
        }
        sb.append(str);
        if (this.message != null) {
            str2 = ": " + this.message;
        }
        sb.append(str2);
        return sb.toString();
    }

    /* compiled from: VersionRequirement.kt */
    public static final class Companion {

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ProtoBuf.VersionRequirement.Level.values().length];
                $EnumSwitchMapping$0 = iArr;
                iArr[ProtoBuf.VersionRequirement.Level.WARNING.ordinal()] = 1;
                iArr[ProtoBuf.VersionRequirement.Level.ERROR.ordinal()] = 2;
                iArr[ProtoBuf.VersionRequirement.Level.HIDDEN.ordinal()] = 3;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<VersionRequirement> create(MessageLite messageLite, NameResolver nameResolver, VersionRequirementTable versionRequirementTable) {
            List<Integer> list;
            Intrinsics.checkParameterIsNotNull(messageLite, "proto");
            Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
            Intrinsics.checkParameterIsNotNull(versionRequirementTable, "table");
            if (messageLite instanceof ProtoBuf.Class) {
                list = ((ProtoBuf.Class) messageLite).getVersionRequirementList();
            } else if (messageLite instanceof ProtoBuf.Constructor) {
                list = ((ProtoBuf.Constructor) messageLite).getVersionRequirementList();
            } else if (messageLite instanceof ProtoBuf.Function) {
                list = ((ProtoBuf.Function) messageLite).getVersionRequirementList();
            } else if (messageLite instanceof ProtoBuf.Property) {
                list = ((ProtoBuf.Property) messageLite).getVersionRequirementList();
            } else if (messageLite instanceof ProtoBuf.TypeAlias) {
                list = ((ProtoBuf.TypeAlias) messageLite).getVersionRequirementList();
            } else {
                throw new IllegalStateException("Unexpected declaration: " + messageLite.getClass());
            }
            Intrinsics.checkExpressionValueIsNotNull(list, "ids");
            ArrayList arrayList = new ArrayList();
            for (Integer num : list) {
                Companion companion = VersionRequirement.Companion;
                Intrinsics.checkExpressionValueIsNotNull(num, "id");
                VersionRequirement create = companion.create(num.intValue(), nameResolver, versionRequirementTable);
                if (create != null) {
                    arrayList.add(create);
                }
            }
            return arrayList;
        }

        public final VersionRequirement create(int i, NameResolver nameResolver, VersionRequirementTable versionRequirementTable) {
            DeprecationLevel deprecationLevel;
            Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
            Intrinsics.checkParameterIsNotNull(versionRequirementTable, "table");
            ProtoBuf.VersionRequirement versionRequirement = versionRequirementTable.get(i);
            String str = null;
            if (versionRequirement == null) {
                return null;
            }
            Version decode = Version.Companion.decode(versionRequirement.hasVersion() ? Integer.valueOf(versionRequirement.getVersion()) : null, versionRequirement.hasVersionFull() ? Integer.valueOf(versionRequirement.getVersionFull()) : null);
            ProtoBuf.VersionRequirement.Level level = versionRequirement.getLevel();
            if (level == null) {
                Intrinsics.throwNpe();
            }
            int i2 = WhenMappings.$EnumSwitchMapping$0[level.ordinal()];
            if (i2 == 1) {
                deprecationLevel = DeprecationLevel.WARNING;
            } else if (i2 == 2) {
                deprecationLevel = DeprecationLevel.ERROR;
            } else if (i2 == 3) {
                deprecationLevel = DeprecationLevel.HIDDEN;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            Integer valueOf = versionRequirement.hasErrorCode() ? Integer.valueOf(versionRequirement.getErrorCode()) : null;
            if (versionRequirement.hasMessage()) {
                str = nameResolver.getString(versionRequirement.getMessage());
            }
            ProtoBuf.VersionRequirement.VersionKind versionKind = versionRequirement.getVersionKind();
            Intrinsics.checkExpressionValueIsNotNull(versionKind, "info.versionKind");
            return new VersionRequirement(decode, versionKind, deprecationLevel, valueOf, str);
        }
    }
}
