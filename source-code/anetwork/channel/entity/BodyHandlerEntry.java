package anetwork.channel.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import anet.channel.request.BodyEntry;
import anetwork.channel.IBodyHandler;
import anetwork.channel.aidl.ParcelableBodyHandler;
import anetwork.channel.aidl.adapter.ParcelableBodyHandlerWrapper;
import java.io.IOException;
import java.io.OutputStream;
import tb.pd;
import tb.rd;

/* compiled from: Taobao */
public class BodyHandlerEntry implements BodyEntry {
    public static final Parcelable.Creator<BodyHandlerEntry> CREATOR = new a();
    ParcelableBodyHandler bodyHandler;

    /* compiled from: Taobao */
    static class a implements Parcelable.Creator<BodyHandlerEntry> {
        a() {
        }

        /* renamed from: a */
        public BodyHandlerEntry createFromParcel(Parcel parcel) {
            BodyHandlerEntry bodyHandlerEntry = new BodyHandlerEntry((a) null);
            bodyHandlerEntry.bodyHandler = ParcelableBodyHandler.Stub.asInterface(parcel.readStrongBinder());
            return bodyHandlerEntry;
        }

        /* renamed from: b */
        public BodyHandlerEntry[] newArray(int i) {
            return new BodyHandlerEntry[i];
        }
    }

    /* synthetic */ BodyHandlerEntry(a aVar) {
        this();
    }

    public int describeContents() {
        return 0;
    }

    @Override // anet.channel.request.BodyEntry
    public String getContentType() {
        return null;
    }

    @Override // anet.channel.request.BodyEntry
    public int writeTo(OutputStream outputStream) throws IOException {
        try {
            pd c = rd.a().c(2048);
            int i = 0;
            while (!this.bodyHandler.isCompleted()) {
                int read = this.bodyHandler.read(c.c());
                outputStream.write(c.c(), 0, read);
                i += read;
            }
            c.f();
            return i;
        } catch (RemoteException e) {
            throw new IOException("RemoteException", e);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongInterface(this.bodyHandler);
    }

    public BodyHandlerEntry(IBodyHandler iBodyHandler) {
        this.bodyHandler = null;
        this.bodyHandler = new ParcelableBodyHandlerWrapper(iBodyHandler);
    }

    private BodyHandlerEntry() {
        this.bodyHandler = null;
    }
}
