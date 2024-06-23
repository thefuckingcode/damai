package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
public class TileOverlayOptionsCreator implements Parcelable.Creator<TileOverlayOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    @Override // android.os.Parcelable.Creator
    public TileOverlayOptions createFromParcel(Parcel parcel) {
        int readInt = parcel.readInt();
        TileProvider tileProvider = (TileProvider) parcel.readValue(TileProvider.class.getClassLoader());
        boolean z = true;
        boolean z2 = parcel.readByte() != 0;
        float readFloat = parcel.readFloat();
        int readInt2 = parcel.readInt();
        int readInt3 = parcel.readInt();
        String readString = parcel.readString();
        boolean z3 = parcel.readByte() != 0;
        if (parcel.readByte() == 0) {
            z = false;
        }
        TileOverlayOptions tileOverlayOptions = new TileOverlayOptions(readInt, null, z2, readFloat);
        if (tileProvider != null) {
            tileOverlayOptions.tileProvider(tileProvider);
        }
        tileOverlayOptions.memCacheSize(readInt2);
        tileOverlayOptions.diskCacheSize(readInt3);
        tileOverlayOptions.diskCacheDir(readString);
        tileOverlayOptions.memoryCacheEnabled(z3);
        tileOverlayOptions.diskCacheEnabled(z);
        return tileOverlayOptions;
    }

    @Override // android.os.Parcelable.Creator
    public TileOverlayOptions[] newArray(int i) {
        return new TileOverlayOptions[i];
    }
}
