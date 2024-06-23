package com.meizu.cloud.pushsdk.notification.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() {
        /* class com.meizu.cloud.pushsdk.notification.model.a.AnonymousClass1 */

        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* renamed from: a */
        public a[] newArray(int i) {
            return new a[i];
        }
    };
    private int a = 0;
    private String b;

    public a() {
    }

    protected a(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readString();
    }

    public static a a(MessageV3 messageV3) {
        a aVar;
        try {
            aVar = !TextUtils.isEmpty(messageV3.getNotificationMessage()) ? a(new JSONObject(messageV3.getNotificationMessage()).getJSONObject("data").getJSONObject("extra").getJSONObject("no")) : null;
        } catch (Exception e) {
            DebugLogger.e("NotifyOption", "parse flyme NotifyOption setting error " + e.getMessage() + " so get from notificationMessage");
            aVar = c(messageV3.getNotificationMessage());
        }
        DebugLogger.i("NotifyOption", "current notify option is " + aVar);
        return aVar;
    }

    public static a a(JSONObject jSONObject) {
        String str;
        a aVar = new a();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull("ni")) {
                    aVar.a(jSONObject.getInt("ni"));
                }
                if (!jSONObject.isNull("nk")) {
                    aVar.a(jSONObject.getString("nk"));
                }
            } catch (JSONException e) {
                str = "parse json obj error " + e.getMessage();
            }
        } else {
            str = "no such tag NotifyOption";
            DebugLogger.e("NotifyOption", str);
        }
        return aVar;
    }

    public static int b(MessageV3 messageV3) {
        a a2 = a(messageV3);
        if (a2 != null) {
            return a2.a();
        }
        return 0;
    }

    public static a b(String str) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                DebugLogger.e("NotifyOption", "parse json string error " + e.getMessage());
            }
            return a(jSONObject);
        }
        jSONObject = null;
        return a(jSONObject);
    }

    private static a c(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return b(new JSONObject(str).getString("no"));
            }
            return null;
        } catch (JSONException e) {
            DebugLogger.e("NotifyOption", "parse notificationMessage error " + e.getMessage());
            return null;
        }
    }

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public String b() {
        return this.b;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "NotifyOption{notifyId=" + this.a + ", notifyKey='" + this.b + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
    }
}
