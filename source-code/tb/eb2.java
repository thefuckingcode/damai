package tb;

import com.taobao.downloader.adpater.FileCacheManager;

/* compiled from: Taobao */
public class eb2 implements FileCacheManager {
    @Override // com.taobao.downloader.adpater.FileCacheManager
    public String getTmpCache() {
        return xh0.c(cm.a, "download-sdk/tmp");
    }
}
