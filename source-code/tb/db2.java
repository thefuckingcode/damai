package tb;

import com.taobao.downloader.adpater.DownloadFactory;
import com.taobao.downloader.download.IDownloader;

/* compiled from: Taobao */
public class db2 implements DownloadFactory {
    @Override // com.taobao.downloader.adpater.DownloadFactory
    public IDownloader getDownloader(io1 io1) {
        if (1 == io1.g) {
            return new iq();
        }
        return new o40();
    }
}
