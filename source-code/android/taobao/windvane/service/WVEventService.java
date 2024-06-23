package android.taobao.windvane.service;

import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.webview.IWVWebView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class WVEventService {
    private static volatile WVEventService EventManager = null;
    public static int WV_BACKWARD_EVENT = -1;
    public static int WV_EVENT = 0;
    public static int WV_FORWARD_EVENT = 1;
    private List<WVEventListener> mBackwardList = new ArrayList();
    private List<WVEventListener> mForwardList = new ArrayList();
    private WVInstantEventListener mInstantEvent;
    private List<WVEventListener> mList = new ArrayList();

    public static WVEventService getInstance() {
        if (EventManager == null) {
            synchronized (WVEventService.class) {
                if (EventManager == null) {
                    EventManager = new WVEventService();
                }
            }
        }
        return EventManager;
    }

    public synchronized void addEventListener(WVEventListener wVEventListener, int i) {
        if (wVEventListener != null) {
            if (i == WV_FORWARD_EVENT) {
                this.mForwardList.add(wVEventListener);
            } else if (i == WV_EVENT) {
                this.mList.add(wVEventListener);
            } else if (i == WV_BACKWARD_EVENT) {
                this.mBackwardList.add(wVEventListener);
            }
        }
    }

    public synchronized WVEventResult onEvent(int i, IWVWebView iWVWebView, String str, Object... objArr) {
        WVEventResult onEvent;
        WVEventResult onEvent2;
        WVEventResult onEvent3;
        WVEventContext wVEventContext = new WVEventContext(iWVWebView, str);
        int i2 = 0;
        while (true) {
            List<WVEventListener> list = this.mForwardList;
            if (list == null || i2 >= list.size()) {
                int i3 = 0;
            } else if (this.mForwardList.get(i2) != null && (onEvent3 = this.mForwardList.get(i2).onEvent(i, wVEventContext, objArr)) != null && onEvent3.isSuccess) {
                return onEvent3;
            } else {
                i2++;
            }
        }
        int i32 = 0;
        while (true) {
            List<WVEventListener> list2 = this.mList;
            if (list2 == null || i32 >= list2.size()) {
                int i4 = 0;
            } else if (this.mList.get(i32) != null && (onEvent2 = this.mList.get(i32).onEvent(i, wVEventContext, objArr)) != null && onEvent2.isSuccess) {
                return onEvent2;
            } else {
                i32++;
            }
        }
        int i42 = 0;
        while (true) {
            List<WVEventListener> list3 = this.mBackwardList;
            if (list3 == null || i42 >= list3.size()) {
            } else if (this.mBackwardList.get(i42) != null && (onEvent = this.mBackwardList.get(i42).onEvent(i, wVEventContext, objArr)) != null && onEvent.isSuccess) {
                return onEvent;
            } else {
                i42++;
            }
        }
        return new WVEventResult(false);
    }

    public WVEventResult onInstantEvent(int i, Object... objArr) {
        WVEventContext wVEventContext = new WVEventContext(null, null);
        WVInstantEventListener wVInstantEventListener = this.mInstantEvent;
        if (wVInstantEventListener != null) {
            return wVInstantEventListener.onInstantEvent(i, wVEventContext, objArr);
        }
        return null;
    }

    public synchronized void removeEventListener(WVEventListener wVEventListener) {
        if (wVEventListener != null) {
            int indexOf = this.mList.indexOf(wVEventListener);
            if (-1 != indexOf) {
                this.mList.remove(indexOf);
            }
            int indexOf2 = this.mForwardList.indexOf(wVEventListener);
            if (-1 != indexOf2) {
                this.mForwardList.remove(indexOf2);
            }
            int indexOf3 = this.mBackwardList.indexOf(wVEventListener);
            if (-1 != this.mBackwardList.indexOf(wVEventListener)) {
                this.mBackwardList.remove(indexOf3);
            }
        }
    }

    public synchronized void removeInstantEvent(WVInstantEventListener wVInstantEventListener) {
        if (wVInstantEventListener == null) {
            TaoLog.e("WVEventService", "event can not be null");
            return;
        }
        WVInstantEventListener wVInstantEventListener2 = this.mInstantEvent;
        if (wVInstantEventListener2 == null) {
            TaoLog.e("WVEventService", "event already be null");
        } else if (wVInstantEventListener2 != wVInstantEventListener) {
            TaoLog.e("WVEventService", "remove failed");
        } else {
            this.mInstantEvent = null;
        }
    }

    public synchronized void setInstantEvent(WVInstantEventListener wVInstantEventListener) {
        if (wVInstantEventListener == null) {
            TaoLog.e("WVEventService", "event can not be null");
        } else if (this.mInstantEvent != null) {
            TaoLog.e("WVEventService", "an instance has already been set, please wait it end");
        } else {
            this.mInstantEvent = wVInstantEventListener;
        }
    }

    public synchronized void addEventListener(WVEventListener wVEventListener) {
        addEventListener(wVEventListener, WV_EVENT);
    }

    public WVEventResult onEvent(int i) {
        return onEvent(i, null, null, new Object[0]);
    }

    public WVEventResult onEvent(int i, Object... objArr) {
        return onEvent(i, null, null, objArr);
    }
}
