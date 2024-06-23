package mtopsdk.network.domain;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: Taobao */
public class ParcelableRequestBodyImpl extends RequestBody implements Parcelable {
    public static final Parcelable.Creator<ParcelableRequestBodyImpl> CREATOR = new Parcelable.Creator<ParcelableRequestBodyImpl>() {
        /* class mtopsdk.network.domain.ParcelableRequestBodyImpl.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public ParcelableRequestBodyImpl createFromParcel(Parcel parcel) {
            return new ParcelableRequestBodyImpl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ParcelableRequestBodyImpl[] newArray(int i) {
            return new ParcelableRequestBodyImpl[i];
        }
    };
    private byte[] content;
    private String contentType;

    public ParcelableRequestBodyImpl(String str, byte[] bArr) {
        this.content = bArr;
        this.contentType = str;
    }

    @Override // mtopsdk.network.domain.RequestBody
    public long contentLength() {
        byte[] bArr = this.content;
        return bArr != null ? (long) bArr.length : super.contentLength();
    }

    @Override // mtopsdk.network.domain.RequestBody
    public String contentType() {
        return this.contentType;
    }

    public int describeContents() {
        return 0;
    }

    @Override // mtopsdk.network.domain.RequestBody
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.content);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.contentType);
        parcel.writeByteArray(this.content);
    }

    protected ParcelableRequestBodyImpl(Parcel parcel) {
        this.contentType = parcel.readString();
        this.content = parcel.createByteArray();
    }
}
