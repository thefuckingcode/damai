package tb;

/* compiled from: Taobao */
public class gs2 {
    public String arg;
    public String disk_size;
    public long elapsed_time;
    public String errorCode;
    public String errorMsg;
    public String fromVersion;
    public boolean success;
    public String toVersion;
    public String url;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gs2)) {
            return false;
        }
        gs2 gs2 = (gs2) obj;
        if (this.success == gs2.success && this.arg.equals(gs2.arg) && this.fromVersion.equals(gs2.fromVersion)) {
            return this.toVersion.equals(gs2.toVersion);
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.success ? 1 : 0) * 31) + this.arg.hashCode()) * 31) + this.fromVersion.hashCode()) * 31) + this.toVersion.hashCode();
    }
}
