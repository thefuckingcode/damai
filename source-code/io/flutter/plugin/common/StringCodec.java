package io.flutter.plugin.common;

import com.alipay.ma.util.StringEncodeUtils;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: Taobao */
public final class StringCodec implements MessageCodec<String> {
    public static final StringCodec INSTANCE = new StringCodec();
    private static final Charset UTF8 = Charset.forName(StringEncodeUtils.UTF8);

    private StringCodec() {
    }

    @Override // io.flutter.plugin.common.MessageCodec
    public String decodeMessage(ByteBuffer byteBuffer) {
        int i;
        byte[] bArr;
        if (byteBuffer == null) {
            return null;
        }
        int remaining = byteBuffer.remaining();
        if (byteBuffer.hasArray()) {
            bArr = byteBuffer.array();
            i = byteBuffer.arrayOffset();
        } else {
            bArr = new byte[remaining];
            byteBuffer.get(bArr);
            i = 0;
        }
        return new String(bArr, i, remaining, UTF8);
    }

    public ByteBuffer encodeMessage(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes(UTF8);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bytes.length);
        allocateDirect.put(bytes);
        return allocateDirect;
    }
}
