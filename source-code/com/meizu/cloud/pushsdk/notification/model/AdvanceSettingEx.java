package com.meizu.cloud.pushsdk.notification.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class AdvanceSettingEx implements Parcelable {
    public static final String ADVANCE_SETTING_EX = "as";
    public static final Parcelable.Creator<AdvanceSettingEx> CREATOR = new Parcelable.Creator<AdvanceSettingEx>() {
        /* class com.meizu.cloud.pushsdk.notification.model.AdvanceSettingEx.AnonymousClass1 */

        /* renamed from: a */
        public AdvanceSettingEx createFromParcel(Parcel parcel) {
            return new AdvanceSettingEx(parcel);
        }

        /* renamed from: a */
        public AdvanceSettingEx[] newArray(int i) {
            return new AdvanceSettingEx[i];
        }
    };
    public static final int MZ_PUSH_PRIORITY_DEFAULT = 0;
    public static final int MZ_PUSH_PRIORITY_HIGH = 1;
    public static final int MZ_PUSH_PRIORITY_LOW = -1;
    public static final int MZ_PUSH_PRIORITY_MAX = 2;
    public static final int MZ_PUSH_PRIORITY_MIN = -2;
    public static final String PRIORITY_DISPLAY = "pd";
    public static final String SOUND_TITLE = "st";
    public static final String TAG = "AdvanceSettingEx";
    private int priorityDisplay = 0;
    private String soundTitle;

    public AdvanceSettingEx() {
    }

    protected AdvanceSettingEx(Parcel parcel) {
        this.priorityDisplay = parcel.readInt();
        this.soundTitle = parcel.readString();
    }

    public static AdvanceSettingEx parse(String str) {
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

    public static AdvanceSettingEx parse(JSONObject jSONObject) {
        String str;
        AdvanceSettingEx advanceSettingEx = new AdvanceSettingEx();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull(PRIORITY_DISPLAY)) {
                    advanceSettingEx.setPriorityDisplay(jSONObject.getInt(PRIORITY_DISPLAY));
                }
                if (!jSONObject.isNull("st")) {
                    advanceSettingEx.setSoundTitle(jSONObject.getString("st"));
                }
            } catch (JSONException e) {
                str = "parse json obj error " + e.getMessage();
            }
        } else {
            str = "no such tag AdvanceSettingEx";
            DebugLogger.e(TAG, str);
        }
        return advanceSettingEx;
    }

    public int describeContents() {
        return 0;
    }

    public int getPriorityDisplay() {
        return this.priorityDisplay;
    }

    public String getSoundTitle() {
        return this.soundTitle;
    }

    public void setPriorityDisplay(int i) {
        if (i < -2 || i > 2) {
            i = 0;
        }
        this.priorityDisplay = i;
    }

    public void setSoundTitle(String str) {
        this.soundTitle = str;
    }

    public String toString() {
        return "AdvanceSettingEx{, priorityDisplay=" + this.priorityDisplay + ", soundTitle=" + this.soundTitle + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.priorityDisplay);
        parcel.writeString(this.soundTitle);
    }
}
