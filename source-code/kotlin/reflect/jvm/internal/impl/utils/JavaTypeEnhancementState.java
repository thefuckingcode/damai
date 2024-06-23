package kotlin.reflect.jvm.internal.impl.utils;

import java.util.Map;
import kotlin.Lazy;
import kotlin.b;
import kotlin.collections.x;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
public final class JavaTypeEnhancementState {
    @NotNull
    public static final a Companion = new a(null);
    @JvmField
    @NotNull
    public static final JavaTypeEnhancementState DEFAULT;
    @JvmField
    @NotNull
    public static final ReportLevel DEFAULT_REPORT_LEVEL_FOR_JSPECIFY;
    @JvmField
    @NotNull
    public static final JavaTypeEnhancementState DISABLED_JSR_305;
    @JvmField
    @NotNull
    public static final JavaTypeEnhancementState STRICT;
    @NotNull
    private final ReportLevel a;
    @Nullable
    private final ReportLevel b;
    @NotNull
    private final Map<String, ReportLevel> c;
    private final boolean d;
    @NotNull
    private final ReportLevel e;
    @NotNull
    private final Lazy f;
    private final boolean g;
    private final boolean h;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    static {
        ReportLevel reportLevel = ReportLevel.WARN;
        DEFAULT_REPORT_LEVEL_FOR_JSPECIFY = reportLevel;
        DEFAULT = new JavaTypeEnhancementState(reportLevel, null, x.i(), false, null, 24, null);
        ReportLevel reportLevel2 = ReportLevel.IGNORE;
        DISABLED_JSR_305 = new JavaTypeEnhancementState(reportLevel2, reportLevel2, x.i(), false, null, 24, null);
        ReportLevel reportLevel3 = ReportLevel.STRICT;
        STRICT = new JavaTypeEnhancementState(reportLevel3, reportLevel3, x.i(), false, null, 24, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.Map<java.lang.String, ? extends kotlin.reflect.jvm.internal.impl.utils.ReportLevel> */
    /* JADX WARN: Multi-variable type inference failed */
    public JavaTypeEnhancementState(@NotNull ReportLevel reportLevel, @Nullable ReportLevel reportLevel2, @NotNull Map<String, ? extends ReportLevel> map, boolean z, @NotNull ReportLevel reportLevel3) {
        k21.i(reportLevel, "globalJsr305Level");
        k21.i(map, "userDefinedLevelForSpecificJsr305Annotation");
        k21.i(reportLevel3, "jspecifyReportLevel");
        this.a = reportLevel;
        this.b = reportLevel2;
        this.c = map;
        this.d = z;
        this.e = reportLevel3;
        this.f = b.b(new JavaTypeEnhancementState$description$2(this));
        ReportLevel reportLevel4 = ReportLevel.IGNORE;
        boolean z2 = true;
        boolean z3 = reportLevel == reportLevel4 && reportLevel2 == reportLevel4 && map.isEmpty();
        this.g = z3;
        if (!z3 && reportLevel3 != reportLevel4) {
            z2 = false;
        }
        this.h = z2;
    }

    public final boolean a() {
        return this.h;
    }

    public final boolean b() {
        return this.g;
    }

    public final boolean c() {
        return this.d;
    }

    @NotNull
    public final ReportLevel d() {
        return this.a;
    }

    @NotNull
    public final ReportLevel e() {
        return this.e;
    }

    @Nullable
    public final ReportLevel f() {
        return this.b;
    }

    @NotNull
    public final Map<String, ReportLevel> g() {
        return this.c;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JavaTypeEnhancementState(ReportLevel reportLevel, ReportLevel reportLevel2, Map map, boolean z, ReportLevel reportLevel3, int i, m40 m40) {
        this(reportLevel, reportLevel2, map, (i & 8) != 0 ? true : z, (i & 16) != 0 ? DEFAULT_REPORT_LEVEL_FOR_JSPECIFY : reportLevel3);
    }
}
