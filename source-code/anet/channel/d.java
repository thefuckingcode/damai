package anet.channel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import tb.d92;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class d {
    private final Map<SessionRequest, List<Session>> a = new HashMap();
    private final ReentrantReadWriteLock b;
    private final ReentrantReadWriteLock.ReadLock c;
    private final ReentrantReadWriteLock.WriteLock d;

    d() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.b = reentrantReadWriteLock;
        this.c = reentrantReadWriteLock.readLock();
        this.d = reentrantReadWriteLock.writeLock();
    }

    public void a(SessionRequest sessionRequest, Session session) {
        if (sessionRequest != null && sessionRequest.y() != null && session != null) {
            this.d.lock();
            try {
                List<Session> list = this.a.get(sessionRequest);
                if (list == null) {
                    list = new ArrayList<>();
                    this.a.put(sessionRequest, list);
                }
                if (list.indexOf(session) == -1) {
                    list.add(session);
                    Collections.sort(list);
                    this.d.unlock();
                }
            } finally {
                this.d.unlock();
            }
        }
    }

    public boolean b(SessionRequest sessionRequest, Session session) {
        this.c.lock();
        try {
            List<Session> list = this.a.get(sessionRequest);
            boolean z = false;
            if (!(list == null || list.indexOf(session) == -1)) {
                z = true;
            }
            return z;
        } finally {
            this.c.unlock();
        }
    }

    public List<Session> c(SessionRequest sessionRequest) {
        ArrayList arrayList;
        this.c.lock();
        try {
            List<Session> list = this.a.get(sessionRequest);
            ArrayList arrayList2 = new ArrayList();
            if (list != null) {
                if (!list.isEmpty()) {
                    Iterator<Session> it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Session next = it.next();
                            if (next != null && next.q()) {
                                arrayList2.add(next);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    arrayList = new ArrayList(arrayList2);
                    return arrayList;
                }
            }
            arrayList = null;
            return arrayList;
        } finally {
            this.c.unlock();
        }
    }

    public List<SessionRequest> d() {
        List<SessionRequest> list = Collections.EMPTY_LIST;
        this.c.lock();
        try {
            if (this.a.isEmpty()) {
                return list;
            }
            ArrayList arrayList = new ArrayList(this.a.keySet());
            this.c.unlock();
            return arrayList;
        } finally {
            this.c.unlock();
        }
    }

    public Session e(SessionRequest sessionRequest) {
        this.c.lock();
        try {
            List<Session> list = this.a.get(sessionRequest);
            Session session = null;
            if (list != null) {
                if (!list.isEmpty()) {
                    Iterator<Session> it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Session next = it.next();
                            if (next != null && next.q()) {
                                session = next;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    this.c.unlock();
                    return session;
                }
            }
            return null;
        } finally {
            this.c.unlock();
        }
    }

    public Session f(SessionRequest sessionRequest, int i) {
        this.c.lock();
        try {
            List<Session> list = this.a.get(sessionRequest);
            Session session = null;
            if (list != null) {
                if (!list.isEmpty()) {
                    Iterator<Session> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Session next = it.next();
                        if (next != null && next.q()) {
                            if (i == d92.c || next.k.e() == i) {
                                session = next;
                            }
                        }
                    }
                    this.c.unlock();
                    return session;
                }
            }
            return null;
        } finally {
            this.c.unlock();
        }
    }

    public List<Session> g(SessionRequest sessionRequest) {
        this.c.lock();
        try {
            List<Session> list = this.a.get(sessionRequest);
            if (list != null) {
                return new ArrayList(list);
            }
            List<Session> list2 = Collections.EMPTY_LIST;
            this.c.unlock();
            return list2;
        } finally {
            this.c.unlock();
        }
    }

    public void h(SessionRequest sessionRequest, Session session) {
        this.d.lock();
        try {
            List<Session> list = this.a.get(sessionRequest);
            if (list != null) {
                list.remove(session);
                if (list.size() == 0) {
                    this.a.remove(sessionRequest);
                }
                this.d.unlock();
            }
        } finally {
            this.d.unlock();
        }
    }
}
