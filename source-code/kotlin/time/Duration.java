package kotlin.time;

import com.lzy.okgo.cookie.SerializableCookie;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\b@\u0018\u0000 s2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001sB\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u001b\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u001b\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\tH\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010-J\u001b\u0010)\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b.\u0010,J\u0013\u0010/\u001a\u0002002\b\u0010&\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\tHÖ\u0001J\r\u00103\u001a\u000200¢\u0006\u0004\b4\u00105J\r\u00106\u001a\u000200¢\u0006\u0004\b7\u00105J\r\u00108\u001a\u000200¢\u0006\u0004\b9\u00105J\r\u0010:\u001a\u000200¢\u0006\u0004\b;\u00105J\u001b\u0010<\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b=\u0010,J\u001b\u0010>\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b?\u0010,J\u0017\u0010@\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0004\bA\u0010(J\u001b\u0010B\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\bC\u0010,J\u001b\u0010B\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\tH\u0002ø\u0001\u0000¢\u0006\u0004\bC\u0010-J\u0001\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E2u\u0010F\u001aq\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(J\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(K\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HE0GH\b¢\u0006\u0004\bO\u0010PJx\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E2`\u0010F\u001a\\\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(K\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HE0QH\b¢\u0006\u0004\bO\u0010RJc\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E2K\u0010F\u001aG\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HE0SH\b¢\u0006\u0004\bO\u0010TJN\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E26\u0010F\u001a2\u0012\u0013\u0012\u00110V¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HE0UH\b¢\u0006\u0004\bO\u0010WJ\u0019\u0010X\u001a\u00020\u00032\n\u0010Y\u001a\u00060Zj\u0002`[¢\u0006\u0004\b\\\u0010]J\u0019\u0010^\u001a\u00020\t2\n\u0010Y\u001a\u00060Zj\u0002`[¢\u0006\u0004\b_\u0010`J\r\u0010a\u001a\u00020b¢\u0006\u0004\bc\u0010dJ\u0019\u0010e\u001a\u00020V2\n\u0010Y\u001a\u00060Zj\u0002`[¢\u0006\u0004\bf\u0010gJ\r\u0010h\u001a\u00020V¢\u0006\u0004\bi\u0010jJ\r\u0010k\u001a\u00020V¢\u0006\u0004\bl\u0010jJ\u000f\u0010m\u001a\u00020bH\u0016¢\u0006\u0004\bn\u0010dJ#\u0010m\u001a\u00020b2\n\u0010Y\u001a\u00060Zj\u0002`[2\b\b\u0002\u0010o\u001a\u00020\t¢\u0006\u0004\bn\u0010pJ\u0013\u0010q\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\br\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00008Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u001a\u0010\b\u001a\u00020\t8@X\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u0011\u0010\u0012\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0005R\u0011\u0010\u0014\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0005R\u0011\u0010\u0016\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0005R\u0011\u0010\u0018\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0005R\u0011\u0010\u001a\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0005R\u001a\u0010\u001c\u001a\u00020\t8@X\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\rR\u001a\u0010\u001f\u001a\u00020\t8@X\u0004¢\u0006\f\u0012\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\rR\u001a\u0010\"\u001a\u00020\t8@X\u0004¢\u0006\f\u0012\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006t"}, d2 = {"Lkotlin/time/Duration;", "", "value", "", "constructor-impl", "(D)D", "absoluteValue", "getAbsoluteValue-impl", "hoursComponent", "", "hoursComponent$annotations", "()V", "getHoursComponent-impl", "(D)I", "inDays", "getInDays-impl", "inHours", "getInHours-impl", "inMicroseconds", "getInMicroseconds-impl", "inMilliseconds", "getInMilliseconds-impl", "inMinutes", "getInMinutes-impl", "inNanoseconds", "getInNanoseconds-impl", "inSeconds", "getInSeconds-impl", "minutesComponent", "minutesComponent$annotations", "getMinutesComponent-impl", "nanosecondsComponent", "nanosecondsComponent$annotations", "getNanosecondsComponent-impl", "secondsComponent", "secondsComponent$annotations", "getSecondsComponent-impl", "compareTo", "other", "compareTo-LRDsOJo", "(DD)I", "div", "scale", "div-impl", "(DD)D", "(DI)D", "div-LRDsOJo", "equals", "", "", "hashCode", "isFinite", "isFinite-impl", "(D)Z", "isInfinite", "isInfinite-impl", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "minus", "minus-LRDsOJo", "plus", "plus-LRDsOJo", "precision", "precision-impl", "times", "times-impl", "toComponents", "T", "action", "Lkotlin/Function5;", "Lkotlin/ParameterName;", SerializableCookie.NAME, "days", "hours", "minutes", "seconds", "nanoseconds", "toComponents-impl", "(DLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lkotlin/Function4;", "(DLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(DLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "", "(DLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "toDouble", "unit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "toDouble-impl", "(DLjava/util/concurrent/TimeUnit;)D", "toInt", "toInt-impl", "(DLjava/util/concurrent/TimeUnit;)I", "toIsoString", "", "toIsoString-impl", "(D)Ljava/lang/String;", "toLong", "toLong-impl", "(DLjava/util/concurrent/TimeUnit;)J", "toLongMilliseconds", "toLongMilliseconds-impl", "(D)J", "toLongNanoseconds", "toLongNanoseconds-impl", "toString", "toString-impl", "decimals", "(DLjava/util/concurrent/TimeUnit;I)Ljava/lang/String;", "unaryMinus", "unaryMinus-impl", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* compiled from: Duration.kt */
public final class Duration implements Comparable<Duration> {
    public static final Companion Companion = new Companion(null);
    private static final double INFINITE = m959constructorimpl(DoubleCompanionObject.INSTANCE.getPOSITIVE_INFINITY());
    private static final double ZERO = m959constructorimpl(0.0d);
    private final double value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Duration m957boximpl(double d) {
        return new Duration(d);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static double m959constructorimpl(double d) {
        return d;
    }

    /* renamed from: div-LRDsOJo  reason: not valid java name */
    public static final double m960divLRDsOJo(double d, double d2) {
        return d / d2;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m963equalsimpl(double d, Object obj) {
        return (obj instanceof Duration) && Double.compare(d, ((Duration) obj).m1002unboximpl()) == 0;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m964equalsimpl0(double d, double d2) {
        return Double.compare(d, d2) == 0;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m977hashCodeimpl(double d) {
        long doubleToLongBits = Double.doubleToLongBits(d);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    public static /* synthetic */ void hoursComponent$annotations() {
    }

    /* renamed from: isNegative-impl  reason: not valid java name */
    public static final boolean m980isNegativeimpl(double d) {
        return d < ((double) 0);
    }

    /* renamed from: isPositive-impl  reason: not valid java name */
    public static final boolean m981isPositiveimpl(double d) {
        return d > ((double) 0);
    }

    public static /* synthetic */ void minutesComponent$annotations() {
    }

    public static /* synthetic */ void nanosecondsComponent$annotations() {
    }

    /* renamed from: precision-impl  reason: not valid java name */
    private static final int m984precisionimpl(double d, double d2) {
        if (d2 < ((double) 1)) {
            return 3;
        }
        if (d2 < ((double) 10)) {
            return 2;
        }
        return d2 < ((double) 100) ? 1 : 0;
    }

    public static /* synthetic */ void secondsComponent$annotations() {
    }

    /* renamed from: compareTo-LRDsOJo  reason: not valid java name */
    public int m1001compareToLRDsOJo(double d) {
        return m958compareToLRDsOJo(this.value, d);
    }

    public boolean equals(Object obj) {
        return m963equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m977hashCodeimpl(this.value);
    }

    public String toString() {
        return m997toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ double m1002unboximpl() {
        return this.value;
    }

    private /* synthetic */ Duration(double d) {
        this.value = d;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration duration) {
        return m1001compareToLRDsOJo(duration.m1002unboximpl());
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\n\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fR\u0016\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lkotlin/time/Duration$Companion;", "", "()V", "INFINITE", "Lkotlin/time/Duration;", "getINFINITE", "()D", "D", "ZERO", "getZERO", "convert", "", "value", "sourceUnit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "targetUnit", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
    /* compiled from: Duration.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final double getZERO() {
            return Duration.ZERO;
        }

        public final double getINFINITE() {
            return Duration.INFINITE;
        }

        public final double convert(double d, TimeUnit timeUnit, TimeUnit timeUnit2) {
            Intrinsics.checkParameterIsNotNull(timeUnit, "sourceUnit");
            Intrinsics.checkParameterIsNotNull(timeUnit2, "targetUnit");
            return DurationUnitKt.convertDurationUnit(d, timeUnit, timeUnit2);
        }
    }

    /* renamed from: unaryMinus-impl  reason: not valid java name */
    public static final double m1000unaryMinusimpl(double d) {
        return m959constructorimpl(-d);
    }

    /* renamed from: plus-LRDsOJo  reason: not valid java name */
    public static final double m983plusLRDsOJo(double d, double d2) {
        return m959constructorimpl(d + d2);
    }

    /* renamed from: minus-LRDsOJo  reason: not valid java name */
    public static final double m982minusLRDsOJo(double d, double d2) {
        return m959constructorimpl(d - d2);
    }

    /* renamed from: times-impl  reason: not valid java name */
    public static final double m986timesimpl(double d, int i) {
        double d2 = (double) i;
        Double.isNaN(d2);
        return m959constructorimpl(d * d2);
    }

    /* renamed from: times-impl  reason: not valid java name */
    public static final double m985timesimpl(double d, double d2) {
        return m959constructorimpl(d * d2);
    }

    /* renamed from: div-impl  reason: not valid java name */
    public static final double m962divimpl(double d, int i) {
        double d2 = (double) i;
        Double.isNaN(d2);
        return m959constructorimpl(d / d2);
    }

    /* renamed from: div-impl  reason: not valid java name */
    public static final double m961divimpl(double d, double d2) {
        return m959constructorimpl(d / d2);
    }

    /* renamed from: isInfinite-impl  reason: not valid java name */
    public static final boolean m979isInfiniteimpl(double d) {
        return Double.isInfinite(d);
    }

    /* renamed from: isFinite-impl  reason: not valid java name */
    public static final boolean m978isFiniteimpl(double d) {
        return !Double.isInfinite(d) && !Double.isNaN(d);
    }

    /* renamed from: getAbsoluteValue-impl  reason: not valid java name */
    public static final double m965getAbsoluteValueimpl(double d) {
        return m980isNegativeimpl(d) ? m1000unaryMinusimpl(d) : d;
    }

    /* renamed from: compareTo-LRDsOJo  reason: not valid java name */
    public static int m958compareToLRDsOJo(double d, double d2) {
        return Double.compare(d, d2);
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m990toComponentsimpl(double d, Function5<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> function5) {
        Intrinsics.checkParameterIsNotNull(function5, "action");
        return (T) function5.invoke(Integer.valueOf((int) m967getInDaysimpl(d)), Integer.valueOf(m966getHoursComponentimpl(d)), Integer.valueOf(m974getMinutesComponentimpl(d)), Integer.valueOf(m976getSecondsComponentimpl(d)), Integer.valueOf(m975getNanosecondsComponentimpl(d)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m989toComponentsimpl(double d, Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> function4) {
        Intrinsics.checkParameterIsNotNull(function4, "action");
        return (T) function4.invoke(Integer.valueOf((int) m968getInHoursimpl(d)), Integer.valueOf(m974getMinutesComponentimpl(d)), Integer.valueOf(m976getSecondsComponentimpl(d)), Integer.valueOf(m975getNanosecondsComponentimpl(d)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m988toComponentsimpl(double d, Function3<? super Integer, ? super Integer, ? super Integer, ? extends T> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "action");
        return (T) function3.invoke(Integer.valueOf((int) m971getInMinutesimpl(d)), Integer.valueOf(m976getSecondsComponentimpl(d)), Integer.valueOf(m975getNanosecondsComponentimpl(d)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m987toComponentsimpl(double d, Function2<? super Long, ? super Integer, ? extends T> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "action");
        return (T) function2.invoke(Long.valueOf((long) m973getInSecondsimpl(d)), Integer.valueOf(m975getNanosecondsComponentimpl(d)));
    }

    /* renamed from: getHoursComponent-impl  reason: not valid java name */
    public static final int m966getHoursComponentimpl(double d) {
        double r2 = m968getInHoursimpl(d);
        double d2 = (double) 24;
        Double.isNaN(d2);
        return (int) (r2 % d2);
    }

    /* renamed from: getMinutesComponent-impl  reason: not valid java name */
    public static final int m974getMinutesComponentimpl(double d) {
        double r2 = m971getInMinutesimpl(d);
        double d2 = (double) 60;
        Double.isNaN(d2);
        return (int) (r2 % d2);
    }

    /* renamed from: getSecondsComponent-impl  reason: not valid java name */
    public static final int m976getSecondsComponentimpl(double d) {
        double r2 = m973getInSecondsimpl(d);
        double d2 = (double) 60;
        Double.isNaN(d2);
        return (int) (r2 % d2);
    }

    /* renamed from: getNanosecondsComponent-impl  reason: not valid java name */
    public static final int m975getNanosecondsComponentimpl(double d) {
        return (int) (m972getInNanosecondsimpl(d) % 1.0E9d);
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    public static final double m991toDoubleimpl(double d, TimeUnit timeUnit) {
        Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
        return DurationUnitKt.convertDurationUnit(d, DurationKt.access$getStorageUnit$p(), timeUnit);
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    public static final long m994toLongimpl(double d, TimeUnit timeUnit) {
        Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
        return (long) m991toDoubleimpl(d, timeUnit);
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    public static final int m992toIntimpl(double d, TimeUnit timeUnit) {
        Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
        return (int) m991toDoubleimpl(d, timeUnit);
    }

    /* renamed from: getInDays-impl  reason: not valid java name */
    public static final double m967getInDaysimpl(double d) {
        return m991toDoubleimpl(d, TimeUnit.DAYS);
    }

    /* renamed from: getInHours-impl  reason: not valid java name */
    public static final double m968getInHoursimpl(double d) {
        return m991toDoubleimpl(d, TimeUnit.HOURS);
    }

    /* renamed from: getInMinutes-impl  reason: not valid java name */
    public static final double m971getInMinutesimpl(double d) {
        return m991toDoubleimpl(d, TimeUnit.MINUTES);
    }

    /* renamed from: getInSeconds-impl  reason: not valid java name */
    public static final double m973getInSecondsimpl(double d) {
        return m991toDoubleimpl(d, TimeUnit.SECONDS);
    }

    /* renamed from: getInMilliseconds-impl  reason: not valid java name */
    public static final double m970getInMillisecondsimpl(double d) {
        return m991toDoubleimpl(d, TimeUnit.MILLISECONDS);
    }

    /* renamed from: getInMicroseconds-impl  reason: not valid java name */
    public static final double m969getInMicrosecondsimpl(double d) {
        return m991toDoubleimpl(d, TimeUnit.MICROSECONDS);
    }

    /* renamed from: getInNanoseconds-impl  reason: not valid java name */
    public static final double m972getInNanosecondsimpl(double d) {
        return m991toDoubleimpl(d, TimeUnit.NANOSECONDS);
    }

    /* renamed from: toLongNanoseconds-impl  reason: not valid java name */
    public static final long m996toLongNanosecondsimpl(double d) {
        return m994toLongimpl(d, TimeUnit.NANOSECONDS);
    }

    /* renamed from: toLongMilliseconds-impl  reason: not valid java name */
    public static final long m995toLongMillisecondsimpl(double d) {
        return m994toLongimpl(d, TimeUnit.MILLISECONDS);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009f  */
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m997toStringimpl(double d) {
        int i;
        TimeUnit timeUnit;
        String str;
        if (m979isInfiniteimpl(d)) {
            return String.valueOf(d);
        }
        if (d == 0.0d) {
            return "0s";
        }
        double r0 = m972getInNanosecondsimpl(m965getAbsoluteValueimpl(d));
        boolean z = false;
        if (r0 < 1.0E-6d) {
            timeUnit = TimeUnit.SECONDS;
        } else {
            if (r0 < ((double) 1)) {
                timeUnit = TimeUnit.NANOSECONDS;
                i = 7;
            } else {
                if (r0 < 1000.0d) {
                    timeUnit = TimeUnit.NANOSECONDS;
                } else if (r0 < 1000000.0d) {
                    timeUnit = TimeUnit.MICROSECONDS;
                } else if (r0 < 1.0E9d) {
                    timeUnit = TimeUnit.MILLISECONDS;
                } else if (r0 < 1.0E12d) {
                    timeUnit = TimeUnit.SECONDS;
                } else if (r0 < 6.0E13d) {
                    timeUnit = TimeUnit.MINUTES;
                } else if (r0 < 3.6E15d) {
                    timeUnit = TimeUnit.HOURS;
                } else if (r0 < 8.64E20d) {
                    timeUnit = TimeUnit.DAYS;
                } else {
                    timeUnit = TimeUnit.DAYS;
                }
                i = 0;
            }
            double r2 = m991toDoubleimpl(d, timeUnit);
            StringBuilder sb = new StringBuilder();
            if (!z) {
                str = FormatToDecimalsKt.formatScientific(r2);
            } else if (i > 0) {
                str = FormatToDecimalsKt.formatUpToDecimals(r2, i);
            } else {
                str = FormatToDecimalsKt.formatToExactDecimals(r2, m984precisionimpl(d, Math.abs(r2)));
            }
            sb.append(str);
            sb.append(DurationUnitKt.shortName(timeUnit));
            return sb.toString();
        }
        i = 0;
        z = true;
        double r22 = m991toDoubleimpl(d, timeUnit);
        StringBuilder sb2 = new StringBuilder();
        if (!z) {
        }
        sb2.append(str);
        sb2.append(DurationUnitKt.shortName(timeUnit));
        return sb2.toString();
    }

    /* renamed from: toString-impl$default  reason: not valid java name */
    public static /* synthetic */ String m999toStringimpl$default(double d, TimeUnit timeUnit, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return m998toStringimpl(d, timeUnit, i);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static final String m998toStringimpl(double d, TimeUnit timeUnit, int i) {
        String str;
        Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("decimals must be not negative, but was " + i).toString());
        } else if (m979isInfiniteimpl(d)) {
            return String.valueOf(d);
        } else {
            double r6 = m991toDoubleimpl(d, timeUnit);
            StringBuilder sb = new StringBuilder();
            if (Math.abs(r6) < 1.0E14d) {
                str = FormatToDecimalsKt.formatToExactDecimals(r6, RangesKt.coerceAtMost(i, 12));
            } else {
                str = FormatToDecimalsKt.formatScientific(r6);
            }
            sb.append(str);
            sb.append(DurationUnitKt.shortName(timeUnit));
            return sb.toString();
        }
    }

    /* renamed from: toIsoString-impl  reason: not valid java name */
    public static final String m993toIsoStringimpl(double d) {
        StringBuilder sb = new StringBuilder();
        if (m980isNegativeimpl(d)) {
            sb.append('-');
        }
        sb.append("PT");
        double r7 = m965getAbsoluteValueimpl(d);
        int r1 = (int) m968getInHoursimpl(r7);
        int r2 = m974getMinutesComponentimpl(r7);
        int r3 = m976getSecondsComponentimpl(r7);
        int r72 = m975getNanosecondsComponentimpl(r7);
        boolean z = true;
        boolean z2 = r1 != 0;
        boolean z3 = (r3 == 0 && r72 == 0) ? false : true;
        if (r2 == 0 && (!z3 || !z2)) {
            z = false;
        }
        if (z2) {
            sb.append(r1);
            sb.append('H');
        }
        if (z) {
            sb.append(r2);
            sb.append('M');
        }
        if (z3 || (!z2 && !z)) {
            sb.append(r3);
            if (r72 != 0) {
                sb.append('.');
                String padStart = StringsKt.padStart(String.valueOf(r72), 9, '0');
                if (r72 % 1000000 == 0) {
                    sb.append((CharSequence) padStart, 0, 3);
                    Intrinsics.checkExpressionValueIsNotNull(sb, "this.append(value, startIndex, endIndex)");
                } else if (r72 % 1000 == 0) {
                    sb.append((CharSequence) padStart, 0, 6);
                    Intrinsics.checkExpressionValueIsNotNull(sb, "this.append(value, startIndex, endIndex)");
                } else {
                    sb.append(padStart);
                }
            }
            sb.append('S');
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
