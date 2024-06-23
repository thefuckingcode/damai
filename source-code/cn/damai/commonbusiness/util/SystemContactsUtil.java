package cn.damai.commonbusiness.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import cn.damai.common.util.CompliantUtUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class SystemContactsUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public static class ContactInfo implements Parcelable {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<ContactInfo> CREATOR = new a();
        private String contactName;
        private String phoneNum;

        /* compiled from: Taobao */
        public class a implements Parcelable.Creator<ContactInfo> {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            /* renamed from: a */
            public ContactInfo createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-1634802465")) {
                    return new ContactInfo(parcel);
                }
                return (ContactInfo) ipChange.ipc$dispatch("-1634802465", new Object[]{this, parcel});
            }

            /* renamed from: b */
            public ContactInfo[] newArray(int i) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-243652848")) {
                    return new ContactInfo[i];
                }
                return (ContactInfo[]) ipChange.ipc$dispatch("-243652848", new Object[]{this, Integer.valueOf(i)});
            }
        }

        public ContactInfo() {
        }

        public int describeContents() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1641769341")) {
                return 0;
            }
            return ((Integer) ipChange.ipc$dispatch("1641769341", new Object[]{this})).intValue();
        }

        public String getContactName() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1959641190")) {
                return this.contactName;
            }
            return (String) ipChange.ipc$dispatch("1959641190", new Object[]{this});
        }

        public String getPhoneNum() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1078648755")) {
                return this.phoneNum;
            }
            return (String) ipChange.ipc$dispatch("1078648755", new Object[]{this});
        }

        public void setContactName(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1680616496")) {
                ipChange.ipc$dispatch("-1680616496", new Object[]{this, str});
                return;
            }
            this.contactName = str;
        }

        public void setPhoneNum(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-803954805")) {
                ipChange.ipc$dispatch("-803954805", new Object[]{this, str});
                return;
            }
            this.phoneNum = str;
        }

        public void writeToParcel(Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "101410030")) {
                ipChange.ipc$dispatch("101410030", new Object[]{this, parcel, Integer.valueOf(i)});
                return;
            }
            parcel.writeString(this.contactName);
            parcel.writeString(this.phoneNum);
        }

        protected ContactInfo(Parcel parcel) {
            this.contactName = parcel.readString();
            this.phoneNum = parcel.readString();
        }
    }

    private static String a(String str) {
        int length;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-739684767")) {
            return (String) ipChange.ipc$dispatch("-739684767", new Object[]{str});
        }
        StringBuilder sb = new StringBuilder();
        if (!(str == null || (length = str.trim().length()) == 0)) {
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (Character.isDigit(charAt)) {
                    sb.append(charAt);
                }
            }
        }
        return sb.toString();
    }

    public static String b(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "41742505")) {
            return f(a(str), str2);
        }
        return (String) ipChange.ipc$dispatch("41742505", new Object[]{str, str2});
    }

    public static String c(Context context, Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-958783702")) {
            return (String) ipChange.ipc$dispatch("-958783702", new Object[]{context, uri});
        } else if (uri == null) {
            return null;
        } else {
            List<String> e = e(context, uri);
            if (e == null || e.size() <= 0) {
                return "";
            }
            String a = a(f(e.get(0), "+86"));
            CompliantUtUtils.e(a);
            return a;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007a, code lost:
        if (r9 != null) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0084, code lost:
        if (r9 != null) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0086, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0089, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008e  */
    public static ContactInfo d(Context context, Uri uri) {
        Throwable th;
        Cursor cursor;
        Exception e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "739614525")) {
            return (ContactInfo) ipChange.ipc$dispatch("739614525", new Object[]{context, uri});
        }
        Cursor cursor2 = null;
        if (uri == null) {
            return null;
        }
        try {
            long parseId = ContentUris.parseId(uri);
            cursor = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id=" + parseId, null, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() > 0 && cursor.moveToFirst()) {
                        String a = a(cursor.getString(cursor.getColumnIndex("data1")));
                        CompliantUtUtils.e(a);
                        String string = cursor.getString(cursor.getColumnIndex("display_name"));
                        ContactInfo contactInfo = new ContactInfo();
                        contactInfo.setContactName(string);
                        contactInfo.setPhoneNum(a);
                        cursor.close();
                        return contactInfo;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                    } catch (Throwable th2) {
                        th = th2;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
            e.printStackTrace();
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008a  */
    public static List<String> e(Context context, Uri uri) {
        Throwable th;
        ArrayList arrayList;
        Cursor cursor;
        Exception e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1741237242")) {
            return (List) ipChange.ipc$dispatch("1741237242", new Object[]{context, uri});
        }
        Cursor cursor2 = null;
        ArrayList arrayList2 = null;
        try {
            long parseId = ContentUris.parseId(uri);
            cursor = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id=" + parseId, null, null);
            if (cursor != null) {
                try {
                    arrayList = new ArrayList();
                    while (cursor.moveToNext()) {
                        try {
                            String string = cursor.getString(cursor.getColumnIndex("data1"));
                            if (!TextUtils.isEmpty(string)) {
                                arrayList.add(string);
                            }
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                e.printStackTrace();
                                if (cursor != null) {
                                }
                                return arrayList;
                            } catch (Throwable th2) {
                                th = th2;
                                cursor2 = cursor;
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                throw th;
                            }
                        }
                    }
                    cursor.getString(cursor.getColumnIndex("display_name"));
                    arrayList2 = arrayList;
                } catch (Exception e3) {
                    e = e3;
                    arrayList = null;
                    e.printStackTrace();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                }
            }
            if (cursor == null) {
                return arrayList2;
            }
            cursor.close();
            return arrayList2;
        } catch (Exception e4) {
            arrayList = null;
            e = e4;
            cursor = null;
            e.printStackTrace();
            if (cursor != null) {
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    private static String f(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1580350283")) {
            return (String) ipChange.ipc$dispatch("-1580350283", new Object[]{str, str2});
        } else if (TextUtils.isEmpty(str2) || str == null || str.length() == 0) {
            return str;
        } else {
            return str.startsWith(str2) ? f(str.substring(str2.length(), str.length()), str2) : str;
        }
    }

    public static void g(Activity activity, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1088993622")) {
            ipChange.ipc$dispatch("-1088993622", new Object[]{activity, Integer.valueOf(i)});
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.PICK");
        intent.setData(ContactsContract.Contacts.CONTENT_URI);
        try {
            if (intent.resolveActivity(activity.getPackageManager()) != null) {
                activity.startActivityForResult(intent, i);
            }
        } catch (ActivityNotFoundException e) {
            Log.d("contract", e.getMessage() + "");
        }
    }
}
