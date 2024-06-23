package com.ali.user.mobile.eventbus;

import java.util.Map;

/* compiled from: Taobao */
public class Event {
    public String name;
    public Map<String, Object> params;

    public static Event newEvent(String str, Map<String, Object> map) {
        Event event = new Event();
        event.name = str;
        event.params = map;
        return event;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Event event = (Event) obj;
        String str = this.name;
        if (str != null) {
            return str.equals(event.name);
        }
        if (event.name == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.name;
        return 31 + (str == null ? 0 : str.hashCode());
    }
}
