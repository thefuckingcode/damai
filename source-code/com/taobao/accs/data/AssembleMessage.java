package com.taobao.accs.data;

import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.ut.monitor.AssembleMonitor;
import com.taobao.accs.utl.ALog;
import com.youku.upsplayer.util.YKUpsConvert;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.EncryptUtil;
import tb.w6;

/* compiled from: Taobao */
public class AssembleMessage {
    private static final int DEFAULT_ASSEMBLE_TIMEOUT = 30000;
    private static final char[] DIGITS_LOWER = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final int SPLITTED_DATA_INDEX = 17;
    public static final int SPLITTED_DATA_MD5 = 18;
    public static final int SPLITTED_DATA_NUMS = 16;
    public static final int SPLITTED_TIME_OUT = 15;
    private static final int STATUS_COMPLETE = 2;
    private static final int STATUS_FAIL = 3;
    private static final int STATUS_TIMEOUT = 1;
    private static final int STATUS_VALID = 0;
    private static final String TAG = "AssembleMessage";
    private Map<Integer, byte[]> burstMessages = new TreeMap(new Comparator<Integer>() {
        /* class com.taobao.accs.data.AssembleMessage.AnonymousClass1 */

        public int compare(Integer num, Integer num2) {
            return num.intValue() - num2.intValue();
        }
    });
    private String dataId;
    private String dataMd5;
    private int dataNums;
    private long firstDataBurstTime;
    private volatile int status = 0;
    private ScheduledFuture<?> timeoutFuture;

    public AssembleMessage(String str, int i, String str2) {
        this.dataId = str;
        this.dataNums = i;
        this.dataMd5 = str2;
    }

    private static char[] encodeHex(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[(length << 1)];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            char[] cArr2 = DIGITS_LOWER;
            cArr[i] = cArr2[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr[i3] = cArr2[bArr[i2] & 15];
        }
        return cArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x013e  */
    public byte[] putBurst(int i, int i2, byte[] bArr) {
        long j;
        ScheduledFuture<?> scheduledFuture;
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d(TAG, "putBurst", Constants.KEY_DATA_ID, this.dataId, "index", Integer.valueOf(i));
        }
        byte[] bArr2 = null;
        if (i2 != this.dataNums) {
            ALog.e(TAG, "putBurst fail as burstNums not match", new Object[0]);
            return null;
        } else if (i < 0 || i >= i2) {
            ALog.e(TAG, "putBurst fail as burstIndex invalid", new Object[0]);
            return null;
        } else {
            synchronized (this) {
                if (this.status != 0) {
                    ALog.e(TAG, "putBurst fail", "status", Integer.valueOf(this.status));
                } else if (this.burstMessages.get(Integer.valueOf(i)) != null) {
                    ALog.e(TAG, "putBurst fail as exist old", new Object[0]);
                    return null;
                } else {
                    if (this.burstMessages.isEmpty()) {
                        this.firstDataBurstTime = System.currentTimeMillis();
                    }
                    this.burstMessages.put(Integer.valueOf(i), bArr);
                    if (this.burstMessages.size() == this.dataNums) {
                        byte[] bArr3 = null;
                        for (byte[] bArr4 : this.burstMessages.values()) {
                            if (bArr3 == null) {
                                bArr3 = bArr4;
                            } else {
                                byte[] bArr5 = new byte[(bArr3.length + bArr4.length)];
                                System.arraycopy(bArr3, 0, bArr5, 0, bArr3.length);
                                System.arraycopy(bArr4, 0, bArr5, bArr3.length, bArr4.length);
                                bArr3 = bArr5;
                            }
                        }
                        if (!TextUtils.isEmpty(this.dataMd5)) {
                            String str = new String(encodeHex(EncryptUtil.md5(bArr3)));
                            if (!this.dataMd5.equals(str)) {
                                ALog.w(TAG, "putBurst fail", Constants.KEY_DATA_ID, this.dataId, "dataMd5", this.dataMd5, "finalDataMd5", str);
                                this.status = 3;
                                long j2 = 0;
                                if (bArr2 == null) {
                                    j2 = (long) bArr2.length;
                                    j = System.currentTimeMillis() - this.firstDataBurstTime;
                                    this.status = 2;
                                    ALog.i(TAG, "putBurst completed", Constants.KEY_DATA_ID, this.dataId, "length", Long.valueOf(j2), "cost", Long.valueOf(j));
                                } else {
                                    j = 0;
                                }
                                AssembleMonitor assembleMonitor = new AssembleMonitor(this.dataId, String.valueOf(this.status));
                                assembleMonitor.assembleLength = j2;
                                assembleMonitor.assembleTimes = j;
                                w6.b().commitStat(assembleMonitor);
                                this.burstMessages.clear();
                                scheduledFuture = this.timeoutFuture;
                                if (scheduledFuture != null) {
                                    scheduledFuture.cancel(false);
                                }
                                return bArr2;
                            }
                        }
                        bArr2 = bArr3;
                        long j22 = 0;
                        if (bArr2 == null) {
                        }
                        AssembleMonitor assembleMonitor2 = new AssembleMonitor(this.dataId, String.valueOf(this.status));
                        assembleMonitor2.assembleLength = j22;
                        assembleMonitor2.assembleTimes = j;
                        w6.b().commitStat(assembleMonitor2);
                        this.burstMessages.clear();
                        scheduledFuture = this.timeoutFuture;
                        if (scheduledFuture != null) {
                        }
                        return bArr2;
                    }
                }
                return null;
            }
        }
    }

    public void setTimeOut(long j) {
        if (j <= 0) {
            j = 30000;
        }
        this.timeoutFuture = ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new Runnable() {
            /* class com.taobao.accs.data.AssembleMessage.AnonymousClass2 */

            public void run() {
                synchronized (AssembleMessage.this) {
                    if (AssembleMessage.this.status == 0) {
                        ALog.e(AssembleMessage.TAG, "timeout", Constants.KEY_DATA_ID, AssembleMessage.this.dataId);
                        AssembleMessage.this.status = 1;
                        AssembleMessage.this.burstMessages.clear();
                        w6.b().commitStat(new AssembleMonitor(AssembleMessage.this.dataId, String.valueOf(AssembleMessage.this.status)));
                    }
                }
            }
        }, j, TimeUnit.MILLISECONDS);
    }
}
