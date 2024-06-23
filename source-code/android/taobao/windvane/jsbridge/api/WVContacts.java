package android.taobao.windvane.jsbridge.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.runtimepermission.PermissionProposer;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.thread.WVThreadPool;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.security.realidentity.jsbridge.a;
import com.taobao.weex.common.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class WVContacts extends WVApiPlugin {
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE = "phone";
    private static final String[] PHONES_PROJECTION = {"display_name", "data1"};
    private static final String TAG = "WVContacts";
    private WVCallBackContext mCallback = null;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class ContactInfo {
        String name;
        String number;

        private ContactInfo() {
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void authStatus(final WVCallBackContext wVCallBackContext) {
        new AsyncTask<Void, Integer, Void>() {
            /* class android.taobao.windvane.jsbridge.api.WVContacts.AnonymousClass7 */

            /* access modifiers changed from: protected */
            public Void doInBackground(Void... voidArr) {
                Cursor cursor;
                WVResult wVResult = new WVResult();
                try {
                    cursor = ((WVApiPlugin) WVContacts.this).mContext.getContentResolver().query(Uri.parse("content://com.android.contacts/contacts"), new String[]{"_id"}, null, null, null);
                } catch (Exception unused) {
                    cursor = null;
                }
                if (cursor == null) {
                    wVResult.addData("isAuthed", "0");
                } else {
                    wVResult.addData("isAuthed", "1");
                }
                wVCallBackContext.success(wVResult);
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception unused2) {
                    }
                }
                return null;
            }
        }.execute(new Void[0]);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void choose(String str, WVCallBackContext wVCallBackContext) {
        this.mCallback = wVCallBackContext;
        Intent intent = new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
        Context context = this.mContext;
        if (context instanceof Activity) {
            try {
                ((Activity) context).startActivityForResult(intent, 4003);
            } catch (Exception e) {
                TaoLog.e("WVContacts", "open pick activity fail, " + e.getMessage());
                wVCallBackContext.error();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004b  */
    private void find(String str, WVCallBackContext wVCallBackContext) {
        String str2;
        String str3;
        List<ContactInfo> phoneContacts;
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(Constants.Name.FILTER);
            if (optJSONObject != null) {
                str3 = optJSONObject.optString("name");
                try {
                    str2 = optJSONObject.optString(KEY_PHONE);
                } catch (JSONException unused) {
                }
            } else {
                str2 = null;
                str3 = null;
            }
        } catch (JSONException unused2) {
            str3 = null;
            TaoLog.e("WVContacts", "find contacts when parse params to JSON error, params=" + str);
            str2 = null;
            phoneContacts = getPhoneContacts(null, str3, str2);
            if (phoneContacts != null) {
            }
        }
        phoneContacts = getPhoneContacts(null, str3, str2);
        if (phoneContacts != null) {
            TaoLog.w("WVContacts", "find contacts failed");
            wVCallBackContext.error(new WVResult());
            return;
        }
        WVResult wVResult = new WVResult();
        JSONArray jSONArray = new JSONArray();
        try {
            for (ContactInfo contactInfo : phoneContacts) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", contactInfo.name);
                jSONObject.put(KEY_PHONE, contactInfo.number);
                jSONArray.put(jSONObject);
            }
        } catch (JSONException e) {
            TaoLog.e("WVContacts", "put contacts error, " + e.getMessage());
        }
        wVResult.addData("contacts", jSONArray);
        wVCallBackContext.success(wVResult);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x016c A[SYNTHETIC, Splitter:B:52:0x016c] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x017b A[SYNTHETIC, Splitter:B:60:0x017b] */
    private List<ContactInfo> getPhoneContacts(String str, String str2, String str3) {
        Cursor cursor;
        Exception e;
        String[] strArr;
        String str4;
        String[] strArr2;
        if (TaoLog.getLogStatus()) {
            TaoLog.d("WVContacts", "contactId: " + str + " filterName: " + str2 + " filterNumber: " + str3);
        }
        ArrayList arrayList = new ArrayList();
        Cursor cursor2 = null;
        try {
            if (!TextUtils.isEmpty(str)) {
                strArr2 = new String[]{str};
                str4 = "_id= ?";
            } else if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                str4 = "display_name like ? AND data1 like ?";
                strArr = new String[]{"%" + str2 + "%", "%" + str3 + "%"};
                cursor = this.mContext.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, PHONES_PROJECTION, str4, strArr, null);
                if (cursor == null) {
                }
            } else if (!TextUtils.isEmpty(str2)) {
                strArr2 = new String[]{"%" + str2 + "%"};
                str4 = "display_name like ?";
            } else {
                strArr = new String[]{"%" + str3 + "%"};
                str4 = "data1 like ?";
                cursor = this.mContext.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, PHONES_PROJECTION, str4, strArr, null);
                if (cursor == null) {
                    try {
                        Log.w("WVContacts", "cursor is null.");
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        return null;
                    } catch (Exception e3) {
                        e = e3;
                        try {
                            TaoLog.e("WVContacts", "query phone error, " + e.getMessage());
                            if (cursor != null) {
                            }
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = cursor;
                            if (cursor2 != null) {
                                try {
                                    cursor2.close();
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                } else {
                    Log.d("WVContacts", "find contacts record " + cursor.getCount());
                    while (cursor.moveToNext()) {
                        String string = cursor.getString(0);
                        String string2 = cursor.getString(1);
                        if (!TextUtils.isEmpty(string) || !TextUtils.isEmpty(string2)) {
                            ContactInfo contactInfo = new ContactInfo();
                            contactInfo.name = string;
                            contactInfo.number = string2;
                            arrayList.add(contactInfo);
                        }
                        Log.d("WVContacts", "displayName: " + string + " phoneNumber: " + string2);
                    }
                    try {
                        cursor.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                    return arrayList;
                }
            }
            strArr = strArr2;
            cursor = this.mContext.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, PHONES_PROJECTION, str4, strArr, null);
            if (cursor == null) {
            }
        } catch (Exception e6) {
            e = e6;
            cursor = null;
            TaoLog.e("WVContacts", "query phone error, " + e.getMessage());
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, final String str2, final WVCallBackContext wVCallBackContext) {
        boolean z;
        if ("choose".equals(str)) {
            try {
                PermissionProposer.buildPermissionTask(this.mContext, new String[]{"android.permission.READ_CONTACTS"}).setTaskOnPermissionGranted(new Runnable() {
                    /* class android.taobao.windvane.jsbridge.api.WVContacts.AnonymousClass2 */

                    public void run() {
                        WVThreadPool.getInstance().execute(new Runnable() {
                            /* class android.taobao.windvane.jsbridge.api.WVContacts.AnonymousClass2.AnonymousClass1 */

                            public void run() {
                                AnonymousClass2 r0 = AnonymousClass2.this;
                                WVContacts.this.choose(str2, wVCallBackContext);
                            }
                        });
                    }
                }).setTaskOnPermissionDenied(new Runnable() {
                    /* class android.taobao.windvane.jsbridge.api.WVContacts.AnonymousClass1 */

                    public void run() {
                        WVResult wVResult = new WVResult();
                        wVResult.addData("msg", a.al);
                        wVCallBackContext.error(wVResult);
                    }
                }).execute();
            } catch (Exception unused) {
            }
        } else if ("find".equals(str)) {
            PermissionProposer.buildPermissionTask(this.mContext, new String[]{"android.permission.READ_CONTACTS"}).setTaskOnPermissionGranted(new Runnable() {
                /* class android.taobao.windvane.jsbridge.api.WVContacts.AnonymousClass4 */

                public void run() {
                    WVThreadPool.getInstance().execute(new Runnable() {
                        /* class android.taobao.windvane.jsbridge.api.WVContacts.AnonymousClass4.AnonymousClass1 */

                        public void run() {
                            AnonymousClass4 r0 = AnonymousClass4.this;
                            WVContacts.this.find(str2, wVCallBackContext);
                        }
                    });
                }
            }).setTaskOnPermissionDenied(new Runnable() {
                /* class android.taobao.windvane.jsbridge.api.WVContacts.AnonymousClass3 */

                public void run() {
                    WVResult wVResult = new WVResult();
                    wVResult.addData("msg", a.al);
                    wVCallBackContext.error(wVResult);
                }
            }).execute();
        } else if (!"authStatus".equals(str)) {
            return false;
        } else {
            try {
                z = new JSONObject(str2).optBoolean("autoAskAuth", true);
            } catch (JSONException unused2) {
                TaoLog.e("WVContacts", "authStatus when parse params to JSON error, params=" + str2);
                z = true;
            }
            if (!z) {
                authStatus(wVCallBackContext);
            } else {
                PermissionProposer.buildPermissionTask(this.mContext, new String[]{"android.permission.READ_CONTACTS"}).setTaskOnPermissionGranted(new Runnable() {
                    /* class android.taobao.windvane.jsbridge.api.WVContacts.AnonymousClass6 */

                    public void run() {
                        WVThreadPool.getInstance().execute(new Runnable() {
                            /* class android.taobao.windvane.jsbridge.api.WVContacts.AnonymousClass6.AnonymousClass1 */

                            public void run() {
                                AnonymousClass6 r0 = AnonymousClass6.this;
                                WVContacts.this.authStatus(wVCallBackContext);
                            }
                        });
                    }
                }).setTaskOnPermissionDenied(new Runnable() {
                    /* class android.taobao.windvane.jsbridge.api.WVContacts.AnonymousClass5 */

                    public void run() {
                        WVResult wVResult = new WVResult();
                        wVResult.addData("msg", a.al);
                        wVCallBackContext.error(wVResult);
                    }
                }).execute();
            }
        }
        WVEventService.getInstance().onEvent(3014);
        return true;
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public void onActivityResult(int i, int i2, Intent intent) {
        Uri data;
        if (i == 4003 && this.mCallback != null) {
            if (i2 == -1) {
                if (intent == null || (data = intent.getData()) == null) {
                    TaoLog.w("WVContacts", "contact data is null");
                    return;
                }
                String lastPathSegment = data.getLastPathSegment();
                if (!TextUtils.isEmpty(lastPathSegment)) {
                    List<ContactInfo> phoneContacts = getPhoneContacts(lastPathSegment, null, null);
                    if (phoneContacts == null || phoneContacts.isEmpty()) {
                        TaoLog.w("WVContacts", "contact result is empty");
                        this.mCallback.error(new WVResult());
                        return;
                    }
                    ContactInfo contactInfo = phoneContacts.get(0);
                    if (!TextUtils.isEmpty(contactInfo.number)) {
                        WVResult wVResult = new WVResult();
                        wVResult.addData("name", contactInfo.name);
                        wVResult.addData(KEY_PHONE, contactInfo.number);
                        this.mCallback.success(wVResult);
                        return;
                    }
                }
            }
            if (TaoLog.getLogStatus()) {
                TaoLog.d("WVContacts", "choose contact failed");
            }
            this.mCallback.error(new WVResult());
        }
    }
}
