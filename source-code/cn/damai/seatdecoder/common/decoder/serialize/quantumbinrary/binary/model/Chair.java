package cn.damai.seatdecoder.common.decoder.serialize.quantumbinrary.binary.model;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.c40;
import tb.sd0;

/* compiled from: Taobao */
public class Chair {
    private static transient /* synthetic */ IpChange $ipChange;
    private static StringBuilder mSB = new StringBuilder(256);
    private final int MAX_OFFSET = 32;
    private final int NAME_NUM_ERROR = 16383;
    public int angle;
    public int chairCode = -1;
    public String chairOrigin;
    public int floorCode = -1;
    public String floorOrigin;
    public long groupId;
    public long groupPriceId;
    public long priceId;
    public int rowCode = -1;
    public String rowOrigin;
    public int secondIndex;
    public long sid;
    public int x;
    public int y;

    private String decodeName(int i, c40 c40) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "823879114")) {
            return (String) ipChange.ipc$dispatch("823879114", new Object[]{this, Integer.valueOf(i), c40});
        }
        short s = (short) ((i >>> 18) & 16383);
        byte b = (byte) ((i >>> 0) & 31);
        String b2 = c40.b((short) ((i >>> 5) & 8191));
        if (s == 16383 || s == -1 || s == 0) {
            return b2;
        }
        StringBuilder stringBuilder = getStringBuilder();
        stringBuilder.append(b2);
        stringBuilder.insert((int) b, (int) s);
        return stringBuilder.toString();
    }

    private int encodeName(String str, sd0 sd0) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1420705754")) {
            return -1;
        }
        return ((Integer) ipChange.ipc$dispatch("-1420705754", new Object[]{this, str, sd0})).intValue();
    }

    private StringBuilder getStringBuilder() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1946295729")) {
            return (StringBuilder) ipChange.ipc$dispatch("-1946295729", new Object[]{this});
        }
        mSB.setLength(0);
        return mSB;
    }

    private String insert(String str, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-378499097")) {
            return (String) ipChange.ipc$dispatch("-378499097", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        StringBuilder sb = new StringBuilder();
        if (i2 == 0) {
            sb.append(i);
            sb.append(str);
            return sb.toString();
        }
        sb.append(str);
        sb.insert(i2, i);
        return sb.toString();
    }

    public void decodeChair(int i, c40 c40) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1900486522")) {
            ipChange.ipc$dispatch("1900486522", new Object[]{this, Integer.valueOf(i), c40});
            return;
        }
        this.chairCode = i;
        this.chairOrigin = decodeName(i, c40);
    }

    public void decodeFloor(int i, c40 c40) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1798532031")) {
            ipChange.ipc$dispatch("-1798532031", new Object[]{this, Integer.valueOf(i), c40});
            return;
        }
        this.floorCode = i;
        this.floorOrigin = decodeName(i, c40);
    }

    public void decodeRow(int i, c40 c40) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1599395407")) {
            ipChange.ipc$dispatch("1599395407", new Object[]{this, Integer.valueOf(i), c40});
            return;
        }
        this.rowCode = i;
        this.rowOrigin = decodeName(i, c40);
    }

    public void encodeChair(String str, sd0 sd0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "484432927")) {
            ipChange.ipc$dispatch("484432927", new Object[]{this, str, sd0});
            return;
        }
        this.chairCode = encodeName(str, sd0);
        this.chairOrigin = str;
    }

    public void encodeFloor(String str, sd0 sd0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1143493064")) {
            ipChange.ipc$dispatch("-1143493064", new Object[]{this, str, sd0});
            return;
        }
        this.floorCode = encodeName(str, sd0);
        this.floorOrigin = str;
    }

    public void encodeRow(String str, sd0 sd0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1572572182")) {
            ipChange.ipc$dispatch("-1572572182", new Object[]{this, str, sd0});
            return;
        }
        this.rowCode = encodeName(str, sd0);
        this.rowOrigin = str;
    }
}
