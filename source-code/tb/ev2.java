package tb;

import java.util.ArrayList;
import java.util.List;
import kotlin.DeprecationLevel;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmField;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ev2 {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private final b a;
    @NotNull
    private final ProtoBuf$VersionRequirement.VersionKind b;
    @NotNull
    private final DeprecationLevel c;
    @Nullable
    private final Integer d;
    @Nullable
    private final String e;

    /* compiled from: Taobao */
    public static final class a {

        /* renamed from: tb.ev2$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public /* synthetic */ class C0302a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ProtoBuf$VersionRequirement.Level.values().length];
                iArr[ProtoBuf$VersionRequirement.Level.WARNING.ordinal()] = 1;
                iArr[ProtoBuf$VersionRequirement.Level.ERROR.ordinal()] = 2;
                iArr[ProtoBuf$VersionRequirement.Level.HIDDEN.ordinal()] = 3;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final List<ev2> a(@NotNull MessageLite messageLite, @NotNull NameResolver nameResolver, @NotNull fv2 fv2) {
            List<Integer> list;
            k21.i(messageLite, "proto");
            k21.i(nameResolver, "nameResolver");
            k21.i(fv2, "table");
            if (messageLite instanceof ProtoBuf$Class) {
                list = ((ProtoBuf$Class) messageLite).getVersionRequirementList();
            } else if (messageLite instanceof ProtoBuf$Constructor) {
                list = ((ProtoBuf$Constructor) messageLite).getVersionRequirementList();
            } else if (messageLite instanceof ProtoBuf$Function) {
                list = ((ProtoBuf$Function) messageLite).getVersionRequirementList();
            } else if (messageLite instanceof ProtoBuf$Property) {
                list = ((ProtoBuf$Property) messageLite).getVersionRequirementList();
            } else if (messageLite instanceof ProtoBuf$TypeAlias) {
                list = ((ProtoBuf$TypeAlias) messageLite).getVersionRequirementList();
            } else {
                throw new IllegalStateException(k21.r("Unexpected declaration: ", messageLite.getClass()));
            }
            k21.h(list, "ids");
            ArrayList arrayList = new ArrayList();
            for (Integer num : list) {
                k21.h(num, "id");
                ev2 b = b(num.intValue(), nameResolver, fv2);
                if (b != null) {
                    arrayList.add(b);
                }
            }
            return arrayList;
        }

        @Nullable
        public final ev2 b(int i, @NotNull NameResolver nameResolver, @NotNull fv2 fv2) {
            DeprecationLevel deprecationLevel;
            k21.i(nameResolver, "nameResolver");
            k21.i(fv2, "table");
            ProtoBuf$VersionRequirement b = fv2.b(i);
            String str = null;
            if (b == null) {
                return null;
            }
            b a = b.Companion.a(b.hasVersion() ? Integer.valueOf(b.getVersion()) : null, b.hasVersionFull() ? Integer.valueOf(b.getVersionFull()) : null);
            ProtoBuf$VersionRequirement.Level level = b.getLevel();
            k21.f(level);
            int i2 = C0302a.$EnumSwitchMapping$0[level.ordinal()];
            if (i2 == 1) {
                deprecationLevel = DeprecationLevel.WARNING;
            } else if (i2 == 2) {
                deprecationLevel = DeprecationLevel.ERROR;
            } else if (i2 == 3) {
                deprecationLevel = DeprecationLevel.HIDDEN;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            Integer valueOf = b.hasErrorCode() ? Integer.valueOf(b.getErrorCode()) : null;
            if (b.hasMessage()) {
                str = nameResolver.getString(b.getMessage());
            }
            ProtoBuf$VersionRequirement.VersionKind versionKind = b.getVersionKind();
            k21.h(versionKind, "info.versionKind");
            return new ev2(a, versionKind, deprecationLevel, valueOf, str);
        }
    }

    /* compiled from: Taobao */
    public static final class b {
        @NotNull
        public static final a Companion = new a(null);
        @JvmField
        @NotNull
        public static final b INFINITY = new b(256, 256, 256);
        private final int a;
        private final int b;
        private final int c;

        /* compiled from: Taobao */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(m40 m40) {
                this();
            }

            @NotNull
            public final b a(@Nullable Integer num, @Nullable Integer num2) {
                if (num2 != null) {
                    return new b(num2.intValue() & 255, (num2.intValue() >> 8) & 255, (num2.intValue() >> 16) & 255);
                }
                if (num != null) {
                    return new b(num.intValue() & 7, (num.intValue() >> 3) & 15, (num.intValue() >> 7) & 127);
                }
                return b.INFINITY;
            }
        }

        public b(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        @NotNull
        public final String a() {
            int i;
            StringBuilder sb;
            if (this.c == 0) {
                sb = new StringBuilder();
                sb.append(this.a);
                sb.append('.');
                i = this.b;
            } else {
                sb = new StringBuilder();
                sb.append(this.a);
                sb.append('.');
                sb.append(this.b);
                sb.append('.');
                i = this.c;
            }
            sb.append(i);
            return sb.toString();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.b == bVar.b && this.c == bVar.c;
        }

        public int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.c;
        }

        @NotNull
        public String toString() {
            return a();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ b(int i, int i2, int i3, int i4, m40 m40) {
            this(i, i2, (i4 & 4) != 0 ? 0 : i3);
        }
    }

    public ev2(@NotNull b bVar, @NotNull ProtoBuf$VersionRequirement.VersionKind versionKind, @NotNull DeprecationLevel deprecationLevel, @Nullable Integer num, @Nullable String str) {
        k21.i(bVar, "version");
        k21.i(versionKind, "kind");
        k21.i(deprecationLevel, "level");
        this.a = bVar;
        this.b = versionKind;
        this.c = deprecationLevel;
        this.d = num;
        this.e = str;
    }

    @NotNull
    public final ProtoBuf$VersionRequirement.VersionKind a() {
        return this.b;
    }

    @NotNull
    public final b b() {
        return this.a;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("since ");
        sb.append(this.a);
        sb.append(' ');
        sb.append(this.c);
        Integer num = this.d;
        String str = "";
        sb.append(num != null ? k21.r(" error ", num) : str);
        String str2 = this.e;
        if (str2 != null) {
            str = k21.r(": ", str2);
        }
        sb.append(str);
        return sb.toString();
    }
}
