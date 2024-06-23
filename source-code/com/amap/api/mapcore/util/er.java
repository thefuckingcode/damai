package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.amap.api.mapcore.util.dc;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;

/* compiled from: Taobao */
public class er extends es {
    private TileProvider e = null;

    public er(Context context, int i, int i2) {
        super(context, i, i2);
        a(context);
    }

    private void a(Context context) {
        b(context);
    }

    private void b(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null && (activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager)) != null) {
            activeNetworkInfo.isConnectedOrConnecting();
        }
    }

    private Bitmap c(dc.a aVar) {
        try {
            Tile tile = this.e.getTile(aVar.a, aVar.b, aVar.c);
            if (tile == null || tile == TileProvider.NO_TILE) {
                return null;
            }
            byte[] bArr = tile.data;
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(TileProvider tileProvider) {
        this.e = tileProvider;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.et, com.amap.api.mapcore.util.es
    public Bitmap a(Object obj) {
        return c((dc.a) obj);
    }
}
