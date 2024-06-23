package com.huawei.hms.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Objects;
import tb.jl1;

/* compiled from: Taobao */
public final class ConnectionResult implements Parcelable {
    public static final int API_UNAVAILABLE = 1000;
    public static final int BINDFAIL_RESOLUTION_BACKGROUND = 7;
    public static final int BINDFAIL_RESOLUTION_REQUIRED = 6;
    public static final int CANCELED = 13;
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new a();
    public static final int DEVELOPER_ERROR = 10;
    public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 9002;
    public static final int INTERNAL_ERROR = 8;
    public static final int INTERRUPTED = 15;
    public static final int INVALID_ACCOUNT = 5;
    public static final int LICENSE_CHECK_FAILED = 11;
    public static final int NETWORK_ERROR = 9000;
    public static final int RESOLUTION_REQUIRED = 9001;
    public static final int RESTRICTED_PROFILE = 9003;
    public static final int SERVICE_DISABLED = 3;
    public static final int SERVICE_INVALID = 9;
    public static final int SERVICE_MISSING = 1;
    public static final int SERVICE_MISSING_PERMISSION = 19;
    public static final int SERVICE_UNSUPPORTED = 21;
    public static final int SERVICE_UPDATING = 9004;
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
    public static final int SIGN_IN_FAILED = 9005;
    public static final int SIGN_IN_REQUIRED = 4;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 14;
    private int a;
    private PendingIntent b;
    private String c;
    private int d;

    /* compiled from: Taobao */
    static class a implements Parcelable.Creator<ConnectionResult> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public ConnectionResult createFromParcel(Parcel parcel) {
            return new ConnectionResult(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        public ConnectionResult[] newArray(int i) {
            return new ConnectionResult[i];
        }
    }

    /* synthetic */ ConnectionResult(Parcel parcel, a aVar) {
        this(parcel);
    }

    static String a(int i) {
        if (i == -1) {
            return "UNKNOWN";
        }
        if (i == 0) {
            return "SUCCESS";
        }
        if (i == 1) {
            return "SERVICE_MISSING";
        }
        if (i == 2) {
            return "SERVICE_VERSION_UPDATE_REQUIRED";
        }
        if (i == 3) {
            return "SERVICE_DISABLED";
        }
        if (i == 13) {
            return "CANCELED";
        }
        if (i == 14) {
            return "TIMEOUT";
        }
        if (i == 19) {
            return "SERVICE_MISSING_PERMISSION";
        }
        if (i == 21) {
            return "API_VERSION_UPDATE_REQUIRED";
        }
        switch (i) {
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                return "UNKNOWN_ERROR_CODE(" + i + jl1.BRACKET_END_STR;
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (!(obj instanceof ConnectionResult) || this.a != ((ConnectionResult) obj).a || this.d != ((ConnectionResult) obj).d || !this.c.equals(((ConnectionResult) obj).c) || !this.b.equals(((ConnectionResult) obj).b)) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public int getErrorCode() {
        return this.d;
    }

    public final String getErrorMessage() {
        return this.c;
    }

    public final PendingIntent getResolution() {
        return this.b;
    }

    public final boolean hasResolution() {
        return HuaweiApiAvailability.getInstance().isUserResolvableError(this.d, this.b);
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf((long) this.a), Long.valueOf((long) getErrorCode()), getErrorMessage(), this.b);
    }

    public final boolean isSuccess() {
        return this.d == 0;
    }

    public final void startResolutionForResult(Activity activity, int i) throws IntentSender.SendIntentException {
        if (hasResolution()) {
            HuaweiApiAvailability.getInstance().resolveError(activity, this.d, i, this.b);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.d);
        parcel.writeString(this.c);
        this.b.writeToParcel(parcel, i);
    }

    ConnectionResult(int i, int i2, PendingIntent pendingIntent, String str) {
        this.a = 1;
        this.b = null;
        this.c = null;
        this.a = i;
        this.d = i2;
        this.b = pendingIntent;
        this.c = str;
    }

    public ConnectionResult(int i) {
        this(i, (PendingIntent) null);
    }

    public ConnectionResult(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, null);
    }

    public ConnectionResult(int i, PendingIntent pendingIntent, String str) {
        this(1, i, pendingIntent, str);
    }

    private ConnectionResult(Parcel parcel) {
        this.a = 1;
        this.b = null;
        this.c = null;
        this.a = parcel.readInt();
        this.d = parcel.readInt();
        this.c = parcel.readString();
        Parcelable parcelable = (Parcelable) PendingIntent.CREATOR.createFromParcel(parcel);
        if (parcelable != null) {
            this.b = (PendingIntent) parcelable;
        }
    }
}
