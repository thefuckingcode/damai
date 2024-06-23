package com.taobao.downloader.adpater.impl;

import com.taobao.downloader.adpater.TaskManager;
import com.taobao.downloader.download.IDownloader;
import com.taobao.downloader.util.ThreadUtil;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tb.db2;
import tb.jj2;
import tb.lb2;
import tb.we1;

/* compiled from: Taobao */
public class SimpleTaskManager implements TaskManager {
    private ConcurrentHashMap<Integer, IDownloader> a = new ConcurrentHashMap<>();

    @Override // com.taobao.downloader.adpater.TaskManager
    public void addTask(final List<lb2> list, final jj2 jj2) {
        final IDownloader downloader = new db2().getDownloader(jj2.c);
        this.a.put(Integer.valueOf(jj2.b), downloader);
        ThreadUtil.a(new Runnable() {
            /* class com.taobao.downloader.adpater.impl.SimpleTaskManager.AnonymousClass1 */

            public void run() {
                for (lb2 lb2 : list) {
                    downloader.download(lb2, jj2.d);
                }
                SimpleTaskManager.this.a.remove(Integer.valueOf(jj2.b));
            }
        }, false);
    }

    @Override // com.taobao.downloader.adpater.TaskManager
    public void modifyTask(int i, int i2) {
        IDownloader iDownloader = this.a.get(Integer.valueOf(i));
        if (iDownloader == null) {
            return;
        }
        if (1 == i2) {
            iDownloader.pause();
        } else if (2 == i2) {
            iDownloader.cancel();
        }
    }

    @Override // com.taobao.downloader.adpater.TaskManager
    public void modifyTask(int i, we1 we1) {
        throw null;
    }
}
