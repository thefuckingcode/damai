package mtopsdk.mtop.antiattack;

import tb.jl1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class LockedEntity {
    public String key;
    public long lockInterval;
    public long lockStartTime;

    public LockedEntity(String str, long j, long j2) {
        this.key = str;
        this.lockStartTime = j;
        this.lockInterval = j2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("LockedEntity [key=");
        sb.append(this.key);
        sb.append(", lockStartTime=");
        sb.append(this.lockStartTime);
        sb.append(", lockInterval=");
        sb.append(this.lockInterval);
        sb.append(jl1.ARRAY_END_STR);
        return sb.toString();
    }
}
