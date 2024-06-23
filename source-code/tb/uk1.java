package tb;

import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import com.ali.alihadeviceevaluator.old.HardWareInfo;

/* compiled from: Taobao */
public class uk1 {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;

    /* JADX WARNING: Removed duplicated region for block: B:16:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0155  */
    public int a(HardWareInfo hardWareInfo) {
        int i;
        int i2;
        int i3;
        float f;
        int score;
        int round;
        int round2;
        int round3;
        int score2 = new au0().getScore(hardWareInfo);
        int score3 = new cu0().getScore(hardWareInfo);
        bu0 bu0 = new bu0();
        int score4 = bu0.getScore(hardWareInfo);
        int score5 = new gu0().getScore(hardWareInfo);
        ju0 ju0 = new ju0();
        ju0.a = i4.d().e().a;
        int score6 = ju0.getScore(hardWareInfo);
        eu0 eu0 = new eu0();
        int[] d2 = new j4().d(rs0.a);
        eu0.a = d2[0];
        eu0.b = d2[1];
        int score7 = eu0.getScore(hardWareInfo);
        int score8 = new hu0().getScore(hardWareInfo);
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            long blockSize = (long) statFs.getBlockSize();
            long blockCount = (((((long) statFs.getBlockCount()) * blockSize) / 1024) / 1024) / 1024;
            i2 = score7;
            i = score8;
            try {
                iu0 iu0 = new iu0();
                iu0.a = (int) blockCount;
                iu0.b = (int) ((((blockSize * ((long) statFs.getAvailableBlocks())) / 1024) / 1024) / 1024);
                i3 = iu0.getScore(hardWareInfo);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            i2 = score7;
            i = score8;
            i3 = 1;
            f = Float.parseFloat(i4.d().c().d);
            fu0 fu0 = new fu0();
            fu0.a = f;
            int score9 = fu0.getScore(hardWareInfo);
            int score10 = new ku0().getScore(hardWareInfo);
            int b2 = bu0.b(hardWareInfo);
            score = new du0().getScore(hardWareInfo);
            if (score == 0) {
            }
            float f2 = ((float) score3) * 0.5f;
            round = Math.round((((float) (score4 * 2)) + f2) + (((float) b2) * 0.5f)) / 3;
            this.a = round;
            if (round > 10) {
            }
            float f3 = ((float) score6) * 1.5f;
            float f4 = ((float) i2) * 0.5f;
            round2 = Math.round(f3 + f4) / 2;
            this.c = round2;
            if (round2 > 10) {
            }
            this.b = score;
            if (score > 10) {
            }
            this.d = score9;
            round3 = (int) ((float) Math.round(((float) (score2 + score)) + f2 + (((float) score4) * 2.0f) + ((float) score5) + f3 + f4 + (((float) i) * 0.5f) + (((float) i3) * 0.5f) + (((float) score9) * 0.5f) + ((float) score10)));
            this.e = round3;
            if (round3 > 100) {
            }
            hardWareInfo.i();
            Log.d(rs0.TAG, "设备分=" + this.e + ", apiScore=" + score5 + ",memScore=" + this.c + ",memLimitScore=" + i2 + ", cpuModelScore=" + score4 + ",cpuCountScore=" + score3 + ",mCpuScore=" + this.a + ", CpuHzScore=" + b2 + ",GpuScore=" + this.b + ",screenScore=" + i + ", openglScore=" + this.d + ",storeScore=" + i3 + ",useTimeScore=" + score10);
            return this.e;
        }
        try {
            f = Float.parseFloat(i4.d().c().d);
        } catch (Exception unused3) {
            f = 2.0f;
        }
        fu0 fu02 = new fu0();
        fu02.a = f;
        int score92 = fu02.getScore(hardWareInfo);
        int score102 = new ku0().getScore(hardWareInfo);
        int b22 = bu0.b(hardWareInfo);
        score = new du0().getScore(hardWareInfo);
        if (score == 0) {
            score = (int) ((((float) score4) * 0.5f) + (((float) score3) * 0.5f) + (((float) b22) * 0.25f));
        }
        float f22 = ((float) score3) * 0.5f;
        round = Math.round((((float) (score4 * 2)) + f22) + (((float) b22) * 0.5f)) / 3;
        this.a = round;
        if (round > 10) {
            this.a = 10;
        }
        float f32 = ((float) score6) * 1.5f;
        float f42 = ((float) i2) * 0.5f;
        round2 = Math.round(f32 + f42) / 2;
        this.c = round2;
        if (round2 > 10) {
            this.c = 10;
        }
        this.b = score;
        if (score > 10) {
            this.b = 10;
        }
        this.d = score92;
        round3 = (int) ((float) Math.round(((float) (score2 + score)) + f22 + (((float) score4) * 2.0f) + ((float) score5) + f32 + f42 + (((float) i) * 0.5f) + (((float) i3) * 0.5f) + (((float) score92) * 0.5f) + ((float) score102)));
        this.e = round3;
        if (round3 > 100) {
            this.e = 100;
        }
        hardWareInfo.i();
        Log.d(rs0.TAG, "设备分=" + this.e + ", apiScore=" + score5 + ",memScore=" + this.c + ",memLimitScore=" + i2 + ", cpuModelScore=" + score4 + ",cpuCountScore=" + score3 + ",mCpuScore=" + this.a + ", CpuHzScore=" + b22 + ",GpuScore=" + this.b + ",screenScore=" + i + ", openglScore=" + this.d + ",storeScore=" + i3 + ",useTimeScore=" + score102);
        return this.e;
    }
}
