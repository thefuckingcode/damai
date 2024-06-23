package tb;

import com.taobao.downloader.download.protocol.DLInputStream;
import java.io.BufferedInputStream;
import java.io.InputStream;

/* compiled from: Taobao */
public class vt0 implements DLInputStream {
    private InputStream a;

    public vt0(InputStream inputStream) {
        this.a = new BufferedInputStream(inputStream, up.f);
    }

    @Override // com.taobao.downloader.download.protocol.DLInputStream
    public void close() throws Exception {
        this.a.close();
    }

    @Override // com.taobao.downloader.download.protocol.DLInputStream
    public int read(byte[] bArr) throws Exception {
        return this.a.read(bArr, 0, bArr.length);
    }
}
