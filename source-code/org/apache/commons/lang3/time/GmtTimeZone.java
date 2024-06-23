package org.apache.commons.lang3.time;

import java.util.Date;
import java.util.TimeZone;
import tb.jl1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class GmtTimeZone extends TimeZone {
    private static final int HOURS_PER_DAY = 24;
    private static final int MILLISECONDS_PER_MINUTE = 60000;
    private static final int MINUTES_PER_HOUR = 60;
    static final long serialVersionUID = 1;
    private final int offset;
    private final String zoneId;

    GmtTimeZone(boolean z, int i, int i2) {
        if (i >= 24) {
            throw new IllegalArgumentException(i + " hours out of range");
        } else if (i2 < 60) {
            int i3 = ((i * 60) + i2) * 60000;
            this.offset = z ? -i3 : i3;
            StringBuilder sb = new StringBuilder(9);
            sb.append(TimeZones.GMT_ID);
            sb.append(z ? '-' : '+');
            StringBuilder twoDigits = twoDigits(sb, i);
            twoDigits.append(jl1.CONDITION_IF_MIDDLE);
            this.zoneId = twoDigits(twoDigits, i2).toString();
        } else {
            throw new IllegalArgumentException(i2 + " minutes out of range");
        }
    }

    private static StringBuilder twoDigits(StringBuilder sb, int i) {
        sb.append((char) ((i / 10) + 48));
        sb.append((char) ((i % 10) + 48));
        return sb;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof GmtTimeZone) && this.zoneId == ((GmtTimeZone) obj).zoneId) {
            return true;
        }
        return false;
    }

    public String getID() {
        return this.zoneId;
    }

    public int getOffset(int i, int i2, int i3, int i4, int i5, int i6) {
        return this.offset;
    }

    public int getRawOffset() {
        return this.offset;
    }

    public int hashCode() {
        return this.offset;
    }

    public boolean inDaylightTime(Date date) {
        return false;
    }

    public void setRawOffset(int i) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return "[GmtTimeZone id=\"" + this.zoneId + "\",offset=" + this.offset + jl1.ARRAY_END;
    }

    public boolean useDaylightTime() {
        return false;
    }
}
