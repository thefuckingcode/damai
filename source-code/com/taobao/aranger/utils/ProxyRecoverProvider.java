package com.taobao.aranger.utils;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.aranger.constant.Constants;
import com.taobao.aranger.core.entity.Reply;
import com.taobao.aranger.intf.IProxyRecover;
import tb.jz0;

/* compiled from: Taobao */
public class ProxyRecoverProvider extends ContentProvider implements IProxyRecover {
    private static final String TAG = ProxyRecoverProvider.class.getSimpleName();

    @Nullable
    public Bundle call(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable Bundle bundle) {
        return call(str2, str3, bundle);
    }

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return null;
    }

    @Override // com.taobao.aranger.intf.IProxyRecover
    public String recoverProxy(String str) {
        return null;
    }

    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    @Nullable
    public Bundle call(@NonNull String str, @Nullable String str2, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        try {
            String string = bundle.getString(Constants.PARAM_PROXY_ID);
            if (!Constants.METHOD_RECOVER.equals(str) || TextUtils.isEmpty(string) || CallbackManager.e().e == null) {
                bundle2.putParcelable(Constants.PARAM_REPLY, Reply.obtain().setErrorCode(44).setErrorMessage("recover proxy has illegal params"));
            } else {
                bundle2.putParcelable(Constants.PARAM_REPLY, Reply.obtain().setResult(CallbackManager.e().e.recoverProxy(string)));
            }
        } catch (Exception e) {
            jz0.c(TAG, "[call]recover proxy]", e, new Object[0]);
            bundle2.putParcelable(Constants.PARAM_REPLY, Reply.obtain().setErrorCode(43).setErrorMessage(e.getMessage()));
        }
        return bundle2;
    }
}
