package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import com.tencent.smtt.export.external.DexLoader;

public class TbsVideoCacheTask {
    public static final String KEY_VIDEO_CACHE_PARAM_FILENAME = "filename";
    public static final String KEY_VIDEO_CACHE_PARAM_FOLDERPATH = "folderPath";
    public static final String KEY_VIDEO_CACHE_PARAM_HEADER = "header";
    public static final String KEY_VIDEO_CACHE_PARAM_URL = "url";
    Context a = null;
    TbsVideoCacheListener b = null;
    private boolean c = false;
    private o d = null;
    private String e;
    private String f;
    private Object g = null;

    public TbsVideoCacheTask(Context context, Bundle bundle, TbsVideoCacheListener tbsVideoCacheListener) {
        this.a = context;
        this.b = tbsVideoCacheListener;
        if (bundle != null) {
            this.e = bundle.getString("taskId");
            this.f = bundle.getString("url");
        }
        a(bundle);
    }

    public String getTaskID() {
        return this.e;
    }

    public String getTaskUrl() {
        return this.f;
    }

    private void a(Bundle bundle) {
        DexLoader dexLoader;
        if (this.d == null) {
            d.a(true).a(this.a, false, false);
            s a2 = d.a(true).a();
            if (a2 != null) {
                dexLoader = a2.b();
            } else {
                this.b.onVideoDownloadError(this, -1, "init engine error!", null);
                dexLoader = null;
            }
            if (dexLoader != null) {
                this.d = new o(dexLoader);
            } else {
                this.b.onVideoDownloadError(this, -1, "Java dexloader invalid!", null);
            }
        }
        o oVar = this.d;
        if (oVar != null) {
            Object a3 = oVar.a(this.a, this, bundle);
            this.g = a3;
            if (a3 == null) {
                this.b.onVideoDownloadError(this, -1, "init task error!", null);
                return;
            }
            return;
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.b;
        if (tbsVideoCacheListener != null) {
            tbsVideoCacheListener.onVideoDownloadError(this, -1, "init error!", null);
        }
    }

    public void pauseTask() {
        o oVar = this.d;
        if (oVar == null || this.g == null) {
            TbsVideoCacheListener tbsVideoCacheListener = this.b;
            if (tbsVideoCacheListener != null) {
                tbsVideoCacheListener.onVideoDownloadError(this, -1, "pauseTask failed, init uncompleted!", null);
                return;
            }
            return;
        }
        oVar.a();
    }

    public void stopTask() {
        o oVar = this.d;
        if (oVar == null || this.g == null) {
            TbsVideoCacheListener tbsVideoCacheListener = this.b;
            if (tbsVideoCacheListener != null) {
                tbsVideoCacheListener.onVideoDownloadError(this, -1, "stopTask failed, init uncompleted!", null);
                return;
            }
            return;
        }
        oVar.c();
    }

    public void resumeTask() {
        o oVar = this.d;
        if (oVar == null || this.g == null) {
            TbsVideoCacheListener tbsVideoCacheListener = this.b;
            if (tbsVideoCacheListener != null) {
                tbsVideoCacheListener.onVideoDownloadError(this, -1, "resumeTask failed, init uncompleted!", null);
                return;
            }
            return;
        }
        oVar.b();
    }

    public void removeTask(boolean z) {
        o oVar = this.d;
        if (oVar == null || this.g == null) {
            TbsVideoCacheListener tbsVideoCacheListener = this.b;
            if (tbsVideoCacheListener != null) {
                tbsVideoCacheListener.onVideoDownloadError(this, -1, "removeTask failed, init uncompleted!", null);
                return;
            }
            return;
        }
        oVar.a(z);
    }

    public long getContentLength() {
        o oVar = this.d;
        if (oVar != null && this.g != null) {
            return oVar.d();
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.b;
        if (tbsVideoCacheListener == null) {
            return 0;
        }
        tbsVideoCacheListener.onVideoDownloadError(this, -1, "getContentLength failed, init uncompleted!", null);
        return 0;
    }

    public int getDownloadedSize() {
        o oVar = this.d;
        if (oVar != null && this.g != null) {
            return oVar.e();
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.b;
        if (tbsVideoCacheListener == null) {
            return 0;
        }
        tbsVideoCacheListener.onVideoDownloadError(this, -1, "getDownloadedSize failed, init uncompleted!", null);
        return 0;
    }

    public int getProgress() {
        o oVar = this.d;
        if (oVar != null && this.g != null) {
            return oVar.f();
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.b;
        if (tbsVideoCacheListener == null) {
            return 0;
        }
        tbsVideoCacheListener.onVideoDownloadError(this, -1, "getProgress failed, init uncompleted!", null);
        return 0;
    }
}
