package androidx.core.os;

import android.os.Parcel;

@Deprecated
/* compiled from: Taobao */
public interface ParcelableCompatCreatorCallbacks<T> {
    T createFromParcel(Parcel parcel, ClassLoader classLoader);

    T[] newArray(int i);
}
