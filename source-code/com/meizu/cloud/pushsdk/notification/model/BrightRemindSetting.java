package com.meizu.cloud.pushsdk.notification.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class BrightRemindSetting implements Parcelable {
    public static final String BRIGHT_REMIND = "br";
    public static final String BRIGHT_REMIND_SETTING = "bs";
    public static final Parcelable.Creator<BrightRemindSetting> CREATOR = new Parcelable.Creator<BrightRemindSetting>() {
        /* class com.meizu.cloud.pushsdk.notification.model.BrightRemindSetting.AnonymousClass1 */

        /* renamed from: a */
        public BrightRemindSetting createFromParcel(Parcel parcel) {
            return new BrightRemindSetting(parcel);
        }

        /* renamed from: a */
        public BrightRemindSetting[] newArray(int i) {
            return new BrightRemindSetting[i];
        }
    };
    public static final String TAG = "BrightRemindSetting";
    private boolean isBrightRemind;

    public BrightRemindSetting() {
    }

    protected BrightRemindSetting(Parcel parcel) {
        this.isBrightRemind = parcel.readByte() != 1 ? false : true;
    }

    public static BrightRemindSetting parse(String str) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                DebugLogger.e(TAG, "parse json string error " + e.getMessage());
            }
            return parse(jSONObject);
        }
        jSONObject = null;
        return parse(jSONObject);
    }

    public static BrightRemindSetting parse(JSONObject jSONObject) {
        String str;
        BrightRemindSetting brightRemindSetting = new BrightRemindSetting();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull(BRIGHT_REMIND)) {
                    brightRemindSetting.setIsBrightRemind(jSONObject.getInt(BRIGHT_REMIND) != 0);
                }
            } catch (JSONException e) {
                str = "parse json obj error " + e.getMessage();
            }
        } else {
            str = "no such tag BrightRemindSetting";
            DebugLogger.e(TAG, str);
        }
        return brightRemindSetting;
    }

    public int describeContents() {
        return 0;
    }

    public boolean getIsBrightRemind() {
        return this.isBrightRemind;
    }

    public void setIsBrightRemind(boolean z) {
        this.isBrightRemind = z;
    }

    public String toString() {
        return "BrightRemindSetting{isBrightRemind=" + this.isBrightRemind + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.isBrightRemind ? (byte) 1 : 0);
    }
}
