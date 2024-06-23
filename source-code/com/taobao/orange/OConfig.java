package com.taobao.orange;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import com.taobao.orange.OConstant;

/* compiled from: Taobao */
public final class OConfig implements Parcelable {
    public static final Parcelable.Creator<OConfig> CREATOR = new Parcelable.Creator<OConfig>() {
        /* class com.taobao.orange.OConfig.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public OConfig createFromParcel(Parcel parcel) {
            return new OConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public OConfig[] newArray(int i) {
            return new OConfig[i];
        }
    };
    public String ackHost;
    public String[] ackVips;
    public String appKey;
    public String appSecret;
    public String appVersion;
    public String authCode;
    public boolean channelIndexUpdate;
    public String dcHost;
    public String[] dcVips;
    public boolean enableDiffIndex;
    public int env;
    public int indexUpdateMode;
    public String[] probeHosts;
    public boolean reportAck;
    public int serverType;
    public boolean statUsedConfig;
    public long time;
    public String userId;

    /* compiled from: Taobao */
    public static class Builder {
        private String ackHost;
        private String[] ackVips;
        private String appKey = "";
        private String appSecret = "";
        private String appVersion = "";
        private String authCode = "";
        private String dcHost;
        private String[] dcVips;
        private boolean enableDiffIndex = false;
        private int env = OConstant.ENV.ONLINE.getEnvMode();
        private int indexUpdateMode = OConstant.UPDMODE.O_XMD.ordinal();
        private String[] probeHosts;
        private boolean reportAck = false;
        private int serverType = OConstant.SERVER.TAOBAO.ordinal();
        private boolean statUsedConfig = false;
        private long time = 2000;
        private String userId = "";

        public OConfig build() {
            OConfig oConfig = new OConfig();
            int i = this.env;
            oConfig.env = i;
            oConfig.appKey = this.appKey;
            oConfig.appSecret = this.appSecret;
            oConfig.authCode = this.authCode;
            oConfig.userId = this.userId;
            oConfig.appVersion = this.appVersion;
            oConfig.serverType = this.serverType;
            oConfig.indexUpdateMode = this.indexUpdateMode;
            oConfig.reportAck = this.reportAck;
            oConfig.statUsedConfig = this.statUsedConfig;
            oConfig.time = this.time;
            String[] strArr = this.probeHosts;
            if (strArr == null || strArr.length == 0) {
                oConfig.probeHosts = OConstant.PROBE_HOSTS[i];
            } else {
                oConfig.probeHosts = strArr;
            }
            if (TextUtils.isEmpty(this.dcHost)) {
                oConfig.dcHost = this.serverType == OConstant.SERVER.TAOBAO.ordinal() ? OConstant.DC_TAOBAO_HOSTS[this.env] : OConstant.DC_YOUKU_HOSTS[this.env];
            } else {
                oConfig.dcHost = this.dcHost;
            }
            oConfig.dcVips = this.dcVips;
            if (TextUtils.isEmpty(this.ackHost)) {
                oConfig.ackHost = this.serverType == OConstant.SERVER.TAOBAO.ordinal() ? OConstant.ACK_TAOBAO_HOSTS[this.env] : OConstant.ACK_YOUKU_HOSTS[this.env];
            } else {
                oConfig.ackHost = this.ackHost;
            }
            oConfig.ackVips = this.ackVips;
            oConfig.enableDiffIndex = this.enableDiffIndex;
            return oConfig;
        }

        public Builder setAckHost(@NonNull String str) {
            this.ackHost = str;
            return this;
        }

        public Builder setAckVips(@Size(min = 1) String[] strArr) {
            this.ackVips = strArr;
            return this;
        }

        public Builder setAppKey(@NonNull String str) {
            this.appKey = str;
            return this;
        }

        public Builder setAppSecret(@NonNull String str) {
            this.appSecret = str;
            return this;
        }

        public Builder setAppVersion(@NonNull String str) {
            this.appVersion = str;
            return this;
        }

        public Builder setAuthCode(@NonNull String str) {
            this.authCode = str;
            return this;
        }

        public Builder setDcHost(@NonNull String str) {
            this.dcHost = str;
            return this;
        }

        public Builder setDcVips(@Size(min = 1) String[] strArr) {
            this.dcVips = strArr;
            return this;
        }

        public Builder setEnableDiffIndex(boolean z) {
            this.enableDiffIndex = z;
            return this;
        }

        public Builder setEnv(@IntRange(from = 0, to = 2) int i) {
            this.env = i;
            return this;
        }

        public Builder setIndexUpdateMode(@IntRange(from = 0, to = 2) int i) {
            this.indexUpdateMode = i;
            return this;
        }

        @Deprecated
        public Builder setOnlineAckHost(String str) {
            this.ackHost = str;
            return this;
        }

        @Deprecated
        public Builder setOnlineHost(String str) {
            this.dcHost = str;
            return this;
        }

        public Builder setProbeHosts(@Size(min = 1) String[] strArr) {
            this.probeHosts = strArr;
            return this;
        }

        public Builder setReportAck(boolean z) {
            this.reportAck = z;
            return this;
        }

        public Builder setServerType(@IntRange(from = 0, to = 1) int i) {
            this.serverType = i;
            return this;
        }

        public Builder setStatUsedConfig(boolean z) {
            this.statUsedConfig = z;
            return this;
        }

        public Builder setTime(long j) {
            this.time = j;
            return this;
        }

        public Builder setUserId(@Nullable String str) {
            this.userId = str;
            return this;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.env);
        parcel.writeString(this.appKey);
        parcel.writeString(this.appVersion);
        parcel.writeString(this.appSecret);
        parcel.writeString(this.authCode);
        parcel.writeString(this.userId);
        parcel.writeInt(this.serverType);
        parcel.writeInt(this.indexUpdateMode);
        parcel.writeByte(this.reportAck ? (byte) 1 : 0);
        parcel.writeByte(this.statUsedConfig ? (byte) 1 : 0);
        parcel.writeStringArray(this.probeHosts);
        parcel.writeString(this.dcHost);
        parcel.writeStringArray(this.dcVips);
        parcel.writeString(this.ackHost);
        parcel.writeStringArray(this.ackVips);
        parcel.writeLong(this.time);
        parcel.writeByte(this.channelIndexUpdate ? (byte) 1 : 0);
        parcel.writeByte(this.enableDiffIndex ? (byte) 1 : 0);
    }

    private OConfig() {
        this.time = 2000;
        this.channelIndexUpdate = false;
    }

    protected OConfig(Parcel parcel) {
        this.time = 2000;
        boolean z = false;
        this.channelIndexUpdate = false;
        this.env = parcel.readInt();
        this.appKey = parcel.readString();
        this.appVersion = parcel.readString();
        this.appSecret = parcel.readString();
        this.authCode = parcel.readString();
        this.userId = parcel.readString();
        this.serverType = parcel.readInt();
        this.indexUpdateMode = parcel.readInt();
        this.reportAck = parcel.readByte() != 0;
        this.statUsedConfig = parcel.readByte() != 0;
        this.probeHosts = parcel.createStringArray();
        this.dcHost = parcel.readString();
        this.dcVips = parcel.createStringArray();
        this.ackHost = parcel.readString();
        this.ackVips = parcel.createStringArray();
        this.time = parcel.readLong();
        this.channelIndexUpdate = parcel.readByte() != 0;
        this.enableDiffIndex = parcel.readByte() != 0 ? true : z;
    }
}
