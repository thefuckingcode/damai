package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map;
import kotlin.collections.w;
import kotlin.collections.x;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
final class SerializedMap implements Externalizable {
    @NotNull
    public static final a Companion = new a(null);
    private static final long serialVersionUID = 0;
    @NotNull
    private Map<?, ?> map;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    public SerializedMap(@NotNull Map<?, ?> map2) {
        k21.i(map2, "map");
        this.map = map2;
    }

    private final Object readResolve() {
        return this.map;
    }

    @Override // java.io.Externalizable
    public void readExternal(@NotNull ObjectInput objectInput) {
        k21.i(objectInput, "input");
        byte readByte = objectInput.readByte();
        if (readByte == 0) {
            int readInt = objectInput.readInt();
            if (readInt >= 0) {
                Map map2 = w.d(readInt);
                for (int i = 0; i < readInt; i++) {
                    map2.put(objectInput.readObject(), objectInput.readObject());
                }
                this.map = w.b(map2);
                return;
            }
            throw new InvalidObjectException("Illegal size value: " + readInt + '.');
        }
        throw new InvalidObjectException("Unsupported flags value: " + ((int) readByte));
    }

    @Override // java.io.Externalizable
    public void writeExternal(@NotNull ObjectOutput objectOutput) {
        k21.i(objectOutput, "output");
        objectOutput.writeByte(0);
        objectOutput.writeInt(this.map.size());
        for (Map.Entry<?, ?> entry : this.map.entrySet()) {
            objectOutput.writeObject(entry.getKey());
            objectOutput.writeObject(entry.getValue());
        }
    }

    public SerializedMap() {
        this(x.i());
    }
}
