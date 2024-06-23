package com.taobao.aranger.core.ipc.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.IContentProvider;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.taobao.aranger.ARanger;
import com.taobao.aranger.constant.Constants;
import com.taobao.aranger.core.entity.Call;
import com.taobao.aranger.core.entity.Reply;
import com.taobao.aranger.core.handler.reply.b;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.intf.IRemoteService;
import com.taobao.aranger.utils.IPCUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import tb.jz0;
import tb.kz0;
import tb.z82;

/* compiled from: Taobao */
public class ARangerProvider extends ContentProvider implements IRemoteService {
    private static final String TAG = ARangerProvider.class.getSimpleName();
    private static final AtomicBoolean isConnectFlag = new AtomicBoolean(false);
    private final RemoteService mRemoteService = new RemoteService();

    /* compiled from: Taobao */
    private class RemoteService extends Binder implements IContentProvider {
        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.taobao.aranger.core.ipc.provider.ARangerProvider$RemoteService */
        /* JADX WARN: Multi-variable type inference failed */
        RemoteService() {
            attachInterface(this, Constants.DEFAULT_CONTENT_DESCRIPTOR);
        }

        @Keep
        public IBinder asBinder() {
            return this;
        }

        @Keep
        public Bundle call(String str, String str2, @Nullable String str3, @Nullable Bundle bundle) {
            return ARangerProvider.this.call(str2, str3, bundle);
        }

        /* access modifiers changed from: protected */
        @Override // android.os.Binder
        @Keep
        public boolean onTransact(int i, @NonNull Parcel parcel, Parcel parcel2, int i2) {
            if (i == 0) {
                if (i2 == 1) {
                    try {
                        final Call createFromParcel = Call.CREATOR.createFromParcel(parcel);
                        kz0.b(false, false, new Runnable() {
                            /* class com.taobao.aranger.core.ipc.provider.ARangerProvider.RemoteService.AnonymousClass1 */

                            public void run() {
                                try {
                                    ARangerProvider.this.sendCall(createFromParcel);
                                } catch (Exception e) {
                                    jz0.c(ARangerProvider.TAG, "[onTransact][sendCall]", e, new Object[0]);
                                }
                            }
                        });
                    } catch (Exception unused) {
                        return true;
                    }
                } else {
                    try {
                        Call createFromParcel2 = Call.CREATOR.createFromParcel(parcel);
                        Reply sendCall = ARangerProvider.this.sendCall(createFromParcel2);
                        if (!TextUtils.isEmpty(createFromParcel2.getMethodWrapper().getReturnType()) || sendCall.isError() || sendCall.getFlowParameterWrappers() != null) {
                            sendCall.writeToParcel(parcel2, 0);
                        }
                    } catch (Exception e) {
                        jz0.c(ARangerProvider.TAG, "[onTransact][sendCall]", e, new Object[0]);
                        Reply.obtain().setErrorCode(10).setErrorMessage(e.getMessage()).writeToParcel(parcel2, i2);
                    }
                }
                return true;
            } else if (i == 1) {
                try {
                    final ArrayList<String> createStringArrayList = parcel.createStringArrayList();
                    kz0.b(false, false, new Runnable() {
                        /* class com.taobao.aranger.core.ipc.provider.ARangerProvider.RemoteService.AnonymousClass2 */

                        public void run() {
                            try {
                                ARangerProvider.this.recycle(createStringArrayList);
                            } catch (Exception e) {
                                jz0.c(ARangerProvider.TAG, "[onTransact][recycle]", e, new Object[0]);
                            }
                        }
                    });
                } catch (Exception e2) {
                    jz0.c(ARangerProvider.TAG, "[onTransact][recycle] create string array list error", e2, new Object[0]);
                }
                return true;
            } else if (i != 21) {
                return true;
            } else {
                try {
                    parcel.enforceInterface(Constants.DEFAULT_CONTENT_DESCRIPTOR);
                    String str = Build.VERSION.CODENAME;
                    if (str.equalsIgnoreCase(ExifInterface.LATITUDE_SOUTH)) {
                        parcel.readInt();
                    }
                    int i3 = Build.VERSION.SDK_INT;
                    if (i3 > 17) {
                        parcel.readString();
                    }
                    if (i3 >= 29) {
                        parcel.readString();
                    }
                    if (i3 >= 30) {
                        parcel.readString();
                    }
                    if (str.equalsIgnoreCase(ExifInterface.LATITUDE_SOUTH)) {
                        parcel.readString();
                    }
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    Bundle readBundle = parcel.readBundle(getClass().getClassLoader());
                    if (readString != null) {
                        Bundle call = ARangerProvider.this.call(readString, readString2, readBundle);
                        parcel2.writeNoException();
                        parcel2.writeBundle(call);
                        return true;
                    }
                    throw new IPCException(42, "read method null from parcel.");
                } catch (Exception e3) {
                    jz0.c(ARangerProvider.TAG, "[onTransact][callTransaction]", e3, new Object[0]);
                    DatabaseUtils.writeExceptionToParcel(parcel2, e3);
                }
            }
        }

        @Keep
        public Bundle call(String str, String str2, String str3, @Nullable String str4, @Nullable Bundle bundle) {
            return ARangerProvider.this.call(str3, str4, bundle);
        }

        @Keep
        public Bundle call(String str, @Nullable String str2, String str3, String str4, @Nullable String str5, @Nullable Bundle bundle) {
            return ARangerProvider.this.call(str4, str5, bundle);
        }
    }

    public IBinder asBinder() {
        return null;
    }

    public Bundle call(String str, String str2, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        str.hashCode();
        if (str.equals("call")) {
            bundle.setClassLoader(ARanger.class.getClassLoader());
            try {
                bundle2.putParcelable(Constants.PARAM_REPLY, sendCall((Call) bundle.getParcelable("call")));
            } catch (Exception e) {
                jz0.c(TAG, "[call][sendCall]", e, new Object[0]);
                bundle2.putParcelable(Constants.PARAM_REPLY, Reply.obtain().setErrorCode(10).setErrorMessage(e.getMessage()));
            }
        } else if (str.equals(Constants.METHOD_RECYCLE_REMOTE)) {
            final ArrayList<String> stringArrayList = bundle.getStringArrayList(Constants.PARAM_KEYS);
            kz0.b(false, false, new Runnable() {
                /* class com.taobao.aranger.core.ipc.provider.ARangerProvider.AnonymousClass1 */

                public void run() {
                    try {
                        ARangerProvider.this.recycle(stringArrayList);
                    } catch (Exception e) {
                        jz0.c(ARangerProvider.TAG, "[call][recycle]", e, new Object[0]);
                    }
                }
            });
        }
        return bundle2;
    }

    @Override // com.taobao.aranger.intf.IRemoteService
    public void connect() {
        if (isConnectFlag.compareAndSet(false, true)) {
            kz0.b(false, false, new Runnable() {
                /* class com.taobao.aranger.core.ipc.provider.ARangerProvider.AnonymousClass2 */

                public void run() {
                    try {
                        Intent intent = new Intent();
                        intent.setAction(Constants.ACTION_CONNECT);
                        intent.putExtra(Constants.PARAM_PROCESS_NAME, IPCUtils.getCurrentProcessName());
                        ARanger.getContext().sendBroadcast(intent);
                    } catch (Throwable th) {
                        jz0.c(ARangerProvider.TAG, "[connect][sendBroadcast]", th, new Object[0]);
                    }
                }
            });
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Keep
    public IContentProvider getIContentProvider() {
        return this.mRemoteService;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // com.taobao.aranger.intf.IRemoteService
    public boolean isRemote() {
        return false;
    }

    public boolean onCreate() {
        connect();
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // com.taobao.aranger.intf.IService
    public void recycle(List<String> list) {
        z82.b().a(list);
    }

    @Override // com.taobao.aranger.intf.IRemoteService
    public Reply sendCall(Call call) {
        try {
            return b.a(call).handleReply();
        } catch (Exception e) {
            jz0.c(TAG, "[sendCall][handleReply]", e, new Object[0]);
            if (e instanceof IPCException) {
                return Reply.obtain().setErrorCode(((IPCException) e).getErrorCode()).setErrorMessage(e.getMessage());
            }
            return Reply.obtain().setErrorCode(11).setErrorMessage(e.getMessage());
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
