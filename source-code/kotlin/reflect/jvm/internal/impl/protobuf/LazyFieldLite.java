package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;

public class LazyFieldLite {
    private ByteString bytes;
    private ExtensionRegistryLite extensionRegistry;
    private volatile boolean isDirty;
    protected volatile MessageLite value;

    public MessageLite getValue(MessageLite messageLite) {
        ensureInitialized(messageLite);
        return this.value;
    }

    public MessageLite setValue(MessageLite messageLite) {
        MessageLite messageLite2 = this.value;
        this.value = messageLite;
        this.bytes = null;
        this.isDirty = true;
        return messageLite2;
    }

    public int getSerializedSize() {
        if (this.isDirty) {
            return this.value.getSerializedSize();
        }
        return this.bytes.size();
    }

    /* access modifiers changed from: protected */
    public void ensureInitialized(MessageLite messageLite) {
        if (this.value == null) {
            synchronized (this) {
                if (this.value == null) {
                    try {
                        if (this.bytes != null) {
                            this.value = (MessageLite) messageLite.getParserForType().parseFrom(this.bytes, this.extensionRegistry);
                        } else {
                            this.value = messageLite;
                        }
                    } catch (IOException unused) {
                    }
                }
            }
        }
    }
}
