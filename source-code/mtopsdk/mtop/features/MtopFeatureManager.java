package mtopsdk.mtop.features;

import java.util.Set;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.intf.Mtop;

/* compiled from: Taobao */
public final class MtopFeatureManager {
    private static final String TAG = "mtopsdk.MtopFeatureManager";

    /* access modifiers changed from: package-private */
    /* renamed from: mtopsdk.mtop.features.MtopFeatureManager$1  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$mtopsdk$mtop$features$MtopFeatureManager$MtopFeatureEnum;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[MtopFeatureEnum.values().length];
            $SwitchMap$mtopsdk$mtop$features$MtopFeatureManager$MtopFeatureEnum = iArr;
            iArr[MtopFeatureEnum.SUPPORT_RELATIVE_URL.ordinal()] = 1;
            $SwitchMap$mtopsdk$mtop$features$MtopFeatureManager$MtopFeatureEnum[MtopFeatureEnum.UNIT_INFO_FEATURE.ordinal()] = 2;
            $SwitchMap$mtopsdk$mtop$features$MtopFeatureManager$MtopFeatureEnum[MtopFeatureEnum.DISABLE_WHITEBOX_SIGN.ordinal()] = 3;
            $SwitchMap$mtopsdk$mtop$features$MtopFeatureManager$MtopFeatureEnum[MtopFeatureEnum.SUPPORT_UTDID_UNIT.ordinal()] = 4;
            $SwitchMap$mtopsdk$mtop$features$MtopFeatureManager$MtopFeatureEnum[MtopFeatureEnum.DISABLE_X_COMMAND.ordinal()] = 5;
            try {
                $SwitchMap$mtopsdk$mtop$features$MtopFeatureManager$MtopFeatureEnum[MtopFeatureEnum.SUPPORT_OPEN_ACCOUNT.ordinal()] = 6;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* compiled from: Taobao */
    public enum MtopFeatureEnum {
        SUPPORT_RELATIVE_URL(1),
        UNIT_INFO_FEATURE(2),
        DISABLE_WHITEBOX_SIGN(3),
        SUPPORT_UTDID_UNIT(4),
        DISABLE_X_COMMAND(5),
        SUPPORT_OPEN_ACCOUNT(6);
        
        long feature;

        private MtopFeatureEnum(long j) {
            this.feature = j;
        }

        public long getFeature() {
            return this.feature;
        }
    }

    public static int getMtopFeatureByFeatureEnum(MtopFeatureEnum mtopFeatureEnum) {
        if (mtopFeatureEnum == null) {
            return 0;
        }
        switch (AnonymousClass1.$SwitchMap$mtopsdk$mtop$features$MtopFeatureManager$MtopFeatureEnum[mtopFeatureEnum.ordinal()]) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            default:
                return 0;
        }
    }

    public static long getMtopFeatureValue(int i) {
        if (i < 1) {
            return 0;
        }
        return (long) (1 << (i - 1));
    }

    public static long getMtopTotalFeatures(Mtop mtop) {
        if (mtop == null) {
            mtop = Mtop.instance(null);
        }
        long j = 0;
        try {
            for (Integer num : mtop.getMtopConfig().mtopFeatures) {
                j |= getMtopFeatureValue(num.intValue());
            }
        } catch (Exception e) {
            TBSdkLog.w(TAG, mtop.getInstanceId() + " [getMtopTotalFeatures] get mtop total features error.---" + e.toString());
        }
        return j;
    }

    public static void setMtopFeatureFlag(Mtop mtop, int i, boolean z) {
        if (mtop == null) {
            mtop = Mtop.instance(null);
        }
        Set<Integer> set = mtop.getMtopConfig().mtopFeatures;
        if (z) {
            set.add(Integer.valueOf(i));
        } else {
            set.remove(Integer.valueOf(i));
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, mtop.getInstanceId() + " [setMtopFeatureFlag] set feature=" + i + " , openFlag=" + z);
        }
    }
}
