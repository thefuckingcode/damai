package com.alient.oneservice.image;

import org.joor.a;

/* compiled from: Taobao */
public class ImageTicketProxy {
    private static ImageTicket sProxy;

    public static ImageTicket getProxy() {
        if (sProxy == null) {
            sProxy = (ImageTicket) a.j("com.alient.oneservice.provider.impl.image.ImageTicketImpl").b().f();
        }
        return sProxy;
    }

    public static void inject(Class cls) {
        if (sProxy == null && ImageTicket.class.isAssignableFrom(cls)) {
            try {
                sProxy = (ImageTicket) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
