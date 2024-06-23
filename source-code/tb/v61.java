package tb;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.c;

/* compiled from: Taobao */
public class v61 {
    private ByteString a;
    private c b;
    private volatile boolean c;
    protected volatile MessageLite d;

    /* access modifiers changed from: protected */
    public void a(MessageLite messageLite) {
        if (this.d == null) {
            synchronized (this) {
                if (this.d == null) {
                    try {
                        if (this.a != null) {
                            this.d = (MessageLite) messageLite.getParserForType().parseFrom(this.a, this.b);
                        } else {
                            this.d = messageLite;
                        }
                    } catch (IOException unused) {
                    }
                }
            }
        }
    }

    public int b() {
        if (this.c) {
            return this.d.getSerializedSize();
        }
        return this.a.size();
    }

    public MessageLite c(MessageLite messageLite) {
        a(messageLite);
        return this.d;
    }

    public MessageLite d(MessageLite messageLite) {
        MessageLite messageLite2 = this.d;
        this.d = messageLite;
        this.a = null;
        this.c = true;
        return messageLite2;
    }
}
