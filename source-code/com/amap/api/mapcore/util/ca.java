package com.amap.api.mapcore.util;

/* compiled from: Taobao */
public interface ca {

    /* compiled from: Taobao */
    public enum a {
        amap_exception(-1),
        network_exception(-1),
        file_io_exception(0),
        success_no_exception(1),
        cancel_no_exception(2);
        
        private int f;

        private a(int i) {
            this.f = i;
        }
    }

    void a(long j, long j2);

    void a(a aVar);

    void n();

    void o();

    void p();
}
