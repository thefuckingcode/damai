package anet.channel.request;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: Taobao */
public class ByteArrayEntry implements BodyEntry {
    public static final Parcelable.Creator<ByteArrayEntry> CREATOR = new a();
    private byte[] bytes;
    private String contentType;
    private int count;
    private int offset;

    /* compiled from: Taobao */
    static class a implements Parcelable.Creator<ByteArrayEntry> {
        a() {
        }

        /* renamed from: a */
        public ByteArrayEntry createFromParcel(Parcel parcel) {
            ByteArrayEntry byteArrayEntry = new ByteArrayEntry((a) null);
            byteArrayEntry.bytes = new byte[parcel.readInt()];
            parcel.readByteArray(byteArrayEntry.bytes);
            byteArrayEntry.offset = parcel.readInt();
            byteArrayEntry.count = parcel.readInt();
            byteArrayEntry.contentType = parcel.readString();
            return byteArrayEntry;
        }

        /* renamed from: b */
        public ByteArrayEntry[] newArray(int i) {
            return new ByteArrayEntry[i];
        }
    }

    /* synthetic */ ByteArrayEntry(a aVar) {
        this();
    }

    public int describeContents() {
        return 0;
    }

    @Override // anet.channel.request.BodyEntry
    public String getContentType() {
        return this.contentType;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    @Override // anet.channel.request.BodyEntry
    public int writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.bytes, this.offset, this.count);
        return this.count;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.bytes.length);
        parcel.writeByteArray(this.bytes);
        parcel.writeInt(this.offset);
        parcel.writeInt(this.count);
        parcel.writeString(this.contentType);
    }

    public ByteArrayEntry(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public ByteArrayEntry(byte[] bArr, int i, int i2) {
        this.offset = 0;
        this.count = 0;
        this.contentType = null;
        this.bytes = bArr;
        this.offset = i;
        this.count = i2;
    }

    private ByteArrayEntry() {
        this.offset = 0;
        this.count = 0;
        this.contentType = null;
    }
}
