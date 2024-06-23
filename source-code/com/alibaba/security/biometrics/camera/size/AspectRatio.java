package com.alibaba.security.biometrics.camera.size;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.SparseArrayCompat;

/* compiled from: Taobao */
public class AspectRatio implements Parcelable, Comparable<AspectRatio> {
    public static final Parcelable.Creator<AspectRatio> CREATOR = new Parcelable.Creator<AspectRatio>() {
        /* class com.alibaba.security.biometrics.camera.size.AspectRatio.AnonymousClass1 */

        private static AspectRatio a(Parcel parcel) {
            return AspectRatio.a(parcel.readInt(), parcel.readInt());
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AspectRatio createFromParcel(Parcel parcel) {
            return AspectRatio.a(parcel.readInt(), parcel.readInt());
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AspectRatio[] newArray(int i) {
            return new AspectRatio[i];
        }

        private static AspectRatio[] a(int i) {
            return new AspectRatio[i];
        }
    };
    public static final AspectRatio a = new AspectRatio(4, 3);
    private static final SparseArrayCompat<SparseArrayCompat<AspectRatio>> d = new SparseArrayCompat<>(16);
    public final int b;
    public final int c;

    private AspectRatio(int i, int i2) {
        this.b = i;
        this.c = i2;
    }

    public static AspectRatio a(int i, int i2) {
        int b2 = b(i, i2);
        int i3 = i / b2;
        int i4 = i2 / b2;
        SparseArrayCompat<SparseArrayCompat<AspectRatio>> sparseArrayCompat = d;
        SparseArrayCompat<AspectRatio> sparseArrayCompat2 = sparseArrayCompat.get(i3);
        if (sparseArrayCompat2 == null) {
            AspectRatio aspectRatio = new AspectRatio(i3, i4);
            SparseArrayCompat<AspectRatio> sparseArrayCompat3 = new SparseArrayCompat<>();
            sparseArrayCompat3.put(i4, aspectRatio);
            sparseArrayCompat.put(i3, sparseArrayCompat3);
            return aspectRatio;
        }
        AspectRatio aspectRatio2 = sparseArrayCompat2.get(i4);
        if (aspectRatio2 != null) {
            return aspectRatio2;
        }
        AspectRatio aspectRatio3 = new AspectRatio(i3, i4);
        sparseArrayCompat2.put(i4, aspectRatio3);
        return aspectRatio3;
    }

    private int b() {
        return this.c;
    }

    private float c() {
        return ((float) this.b) / ((float) this.c);
    }

    private AspectRatio d() {
        return a(this.c, this.b);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(AspectRatio aspectRatio) {
        AspectRatio aspectRatio2 = aspectRatio;
        if (equals(aspectRatio2)) {
            return 0;
        }
        return c() - aspectRatio2.c() > 0.0f ? 1 : -1;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof AspectRatio) {
            AspectRatio aspectRatio = (AspectRatio) obj;
            return this.b == aspectRatio.b && this.c == aspectRatio.c;
        }
    }

    public int hashCode() {
        int i = this.c;
        int i2 = this.b;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    public String toString() {
        return this.b + ":" + this.c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
    }

    public static int b(int i, int i2) {
        while (true) {
            i = i2;
            if (i == 0) {
                return i;
            }
            i2 = i % i;
        }
    }

    private static AspectRatio a(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf != -1) {
            try {
                return a(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Malformed aspect ratio: ".concat(str), e);
            }
        } else {
            throw new IllegalArgumentException("Malformed aspect ratio: ".concat(str));
        }
    }

    private int a() {
        return this.b;
    }

    private int a(AspectRatio aspectRatio) {
        if (equals(aspectRatio)) {
            return 0;
        }
        return c() - aspectRatio.c() > 0.0f ? 1 : -1;
    }

    private boolean a(a aVar) {
        int b2 = b(aVar.a, aVar.b);
        return this.b == aVar.a / b2 && this.c == aVar.b / b2;
    }
}
