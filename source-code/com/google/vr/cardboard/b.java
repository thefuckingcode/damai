package com.google.vr.cardboard;

import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.net.Uri;
import android.os.RemoteException;
import android.util.Base64;
import android.util.Log;
import com.google.common.logging.nano.Vr$VREvent;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.vr.ndk.base.SdkConfigurationReader;
import com.google.vr.sdk.proto.nano.CardboardDevice;
import com.google.vr.sdk.proto.nano.Phone;
import com.google.vr.sdk.proto.nano.Preferences;
import com.google.vr.vrcore.nano.a;
import tb.xw2;

/* compiled from: Taobao */
public class b implements VrParamsProvider {
    private static final String f = "b";
    private final ContentProviderClient a;
    private final Uri b;
    private final Uri c;
    private final Uri d;
    private final Uri e;

    public b(ContentProviderClient contentProviderClient, String str) {
        if (contentProviderClient == null) {
            throw new IllegalArgumentException("ContentProviderClient must not be null");
        } else if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Authority key must be non-null and non-empty");
        } else {
            this.a = contentProviderClient;
            this.b = xw2.a(str, xw2.DEVICE_PARAMS_SETTING);
            this.c = xw2.a(str, xw2.USER_PREFS_SETTING);
            this.d = xw2.a(str, xw2.PHONE_PARAMS_SETTING);
            this.e = xw2.a(str, xw2.SDK_CONFIGURATION_PARAMS_SETTING);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0070  */
    private <T extends MessageNano> T a(T t, Uri uri, String str) {
        Throwable th;
        Cursor cursor;
        Throwable e2;
        Cursor cursor2 = null;
        try {
            cursor = this.a.query(uri, null, str, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        byte[] blob = cursor.getBlob(0);
                        if (blob == null) {
                            cursor.close();
                            return null;
                        }
                        T t2 = (T) MessageNano.mergeFrom(t, blob);
                        cursor.close();
                        return t2;
                    }
                } catch (CursorIndexOutOfBoundsException | RemoteException | InvalidProtocolBufferNanoException | IllegalArgumentException e3) {
                    e2 = e3;
                    try {
                        Log.e(f, "Error reading params from ContentProvider", e2);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
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
            String str2 = f;
            String valueOf = String.valueOf(uri);
            StringBuilder sb = new StringBuilder(valueOf.length() + 50);
            sb.append("Invalid params result from ContentProvider query: ");
            sb.append(valueOf);
            Log.e(str2, sb.toString());
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (CursorIndexOutOfBoundsException | RemoteException | InvalidProtocolBufferNanoException | IllegalArgumentException e4) {
            e2 = e4;
            cursor = null;
            Log.e(f, "Error reading params from ContentProvider", e2);
            if (cursor != null) {
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    private boolean b(MessageNano messageNano, Uri uri) {
        int i;
        if (messageNano == null) {
            try {
                i = this.a.delete(uri, null, null);
            } catch (RemoteException e2) {
                Log.e(f, "Failed to write params to ContentProvider", e2);
                return false;
            } catch (SecurityException e3) {
                Log.e(f, "Insufficient permissions to write params to ContentProvider", e3);
                return false;
            }
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("value", MessageNano.toByteArray(messageNano));
            i = this.a.update(uri, contentValues, null, null);
        }
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public void close() {
        this.a.release();
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public CardboardDevice.DeviceParams readDeviceParams() {
        return a(new CardboardDevice.DeviceParams(), this.b, null);
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public Phone.PhoneParams readPhoneParams() {
        return a(new Phone.PhoneParams(), this.d, null);
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public Vr$VREvent.SdkConfigurationParams readSdkConfigurationParams(a aVar) {
        return a(SdkConfigurationReader.DEFAULT_PARAMS, this.e, Base64.encodeToString(MessageNano.toByteArray(aVar), 0));
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public Preferences.UserPrefs readUserPrefs() {
        return a(new Preferences.UserPrefs(), this.c, null);
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public boolean updateUserPrefs(Preferences.UserPrefs userPrefs) {
        return b(userPrefs, this.c);
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public boolean writeDeviceParams(CardboardDevice.DeviceParams deviceParams) {
        return b(deviceParams, this.b);
    }
}
