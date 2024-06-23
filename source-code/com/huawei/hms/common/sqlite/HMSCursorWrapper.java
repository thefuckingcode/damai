package com.huawei.hms.common.sqlite;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.CursorWrapper;

/* compiled from: Taobao */
public class HMSCursorWrapper extends CursorWrapper implements CrossProcessCursor {
    private AbstractWindowedCursor mCursor;

    public HMSCursorWrapper(Cursor cursor) {
        super(cursor);
        if (cursor == null) {
            throw new IllegalArgumentException("cursor cannot be null");
        } else if (cursor instanceof CursorWrapper) {
            Cursor wrappedCursor = ((CursorWrapper) cursor).getWrappedCursor();
            if (wrappedCursor == null) {
                throw new IllegalArgumentException("getWrappedCursor cannot be null");
            } else if (wrappedCursor instanceof AbstractWindowedCursor) {
                this.mCursor = (AbstractWindowedCursor) wrappedCursor;
            } else {
                throw new IllegalArgumentException("getWrappedCursor:" + wrappedCursor + " is not a subclass for CursorWrapper");
            }
        } else {
            throw new IllegalArgumentException("cursor:" + cursor + " is not a subclass for CursorWrapper");
        }
    }

    public void fillWindow(int i, CursorWindow cursorWindow) {
        this.mCursor.fillWindow(i, cursorWindow);
    }

    public CursorWindow getWindow() {
        return this.mCursor.getWindow();
    }

    public Cursor getWrappedCursor() {
        return this.mCursor;
    }

    public boolean onMove(int i, int i2) {
        return this.mCursor.onMove(i, i2);
    }

    public void setWindow(CursorWindow cursorWindow) {
        this.mCursor.setWindow(cursorWindow);
    }
}
