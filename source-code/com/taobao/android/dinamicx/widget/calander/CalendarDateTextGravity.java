package com.taobao.android.dinamicx.widget.calander;

/* compiled from: Taobao */
public enum CalendarDateTextGravity {
    Center(0),
    Top(1);
    
    private final int code;

    private CalendarDateTextGravity(int i) {
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }
}
