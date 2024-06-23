package com.youku.network.c;

import java.util.LinkedList;
import java.util.List;

/* compiled from: Taobao */
public class a {
    private static volatile boolean a;
    private static List<AbstractC0258a> b = new LinkedList();

    /* renamed from: com.youku.network.c.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public interface AbstractC0258a {
    }

    public static void a(AbstractC0258a aVar) {
        if (aVar != null) {
            b.remove(aVar);
        }
    }
}
