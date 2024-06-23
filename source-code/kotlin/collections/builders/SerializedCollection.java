package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.d0;
import kotlin.collections.l;
import kotlin.collections.m;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
public final class SerializedCollection implements Externalizable {
    @NotNull
    public static final a Companion = new a(null);
    private static final long serialVersionUID = 0;
    public static final int tagList = 0;
    public static final int tagSet = 1;
    @NotNull
    private Collection<?> collection;
    private final int tag;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    public SerializedCollection(@NotNull Collection<?> collection2, int i) {
        k21.i(collection2, "collection");
        this.collection = collection2;
        this.tag = i;
    }

    private final Object readResolve() {
        return this.collection;
    }

    @Override // java.io.Externalizable
    public void readExternal(@NotNull ObjectInput objectInput) {
        Collection<?> collection2;
        k21.i(objectInput, "input");
        byte readByte = objectInput.readByte();
        int i = readByte & 1;
        if ((readByte & -2) == 0) {
            int readInt = objectInput.readInt();
            if (readInt >= 0) {
                int i2 = 0;
                if (i == 0) {
                    List list = l.d(readInt);
                    while (i2 < readInt) {
                        list.add(objectInput.readObject());
                        i2++;
                    }
                    collection2 = l.a(list);
                } else if (i == 1) {
                    Set set = d0.b(readInt);
                    while (i2 < readInt) {
                        set.add(objectInput.readObject());
                        i2++;
                    }
                    collection2 = d0.a(set);
                } else {
                    throw new InvalidObjectException("Unsupported collection type tag: " + i + '.');
                }
                this.collection = collection2;
                return;
            }
            throw new InvalidObjectException("Illegal size value: " + readInt + '.');
        }
        throw new InvalidObjectException("Unsupported flags value: " + ((int) readByte) + '.');
    }

    @Override // java.io.Externalizable
    public void writeExternal(@NotNull ObjectOutput objectOutput) {
        k21.i(objectOutput, "output");
        objectOutput.writeByte(this.tag);
        objectOutput.writeInt(this.collection.size());
        Iterator<?> it = this.collection.iterator();
        while (it.hasNext()) {
            objectOutput.writeObject(it.next());
        }
    }

    public SerializedCollection() {
        this(m.g(), 0);
    }
}
