package androidx.renderscript;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: Taobao */
public class BaseObj {
    private boolean mDestroyed = false;
    private long mID;
    RenderScript mRS;

    BaseObj(long j, RenderScript renderScript) {
        renderScript.validate();
        this.mRS = renderScript;
        this.mID = j;
    }

    private void helpDestroy() {
        boolean z;
        synchronized (this) {
            z = true;
            if (!this.mDestroyed) {
                this.mDestroyed = true;
            } else {
                z = false;
            }
        }
        if (z) {
            ReentrantReadWriteLock.ReadLock readLock = this.mRS.mRWLock.readLock();
            readLock.lock();
            if (this.mRS.isAlive()) {
                this.mRS.nObjDestroy(this.mID);
            }
            readLock.unlock();
            this.mRS = null;
            this.mID = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public void checkValid() {
        if (this.mID == 0 && getNObj() == null) {
            throw new RSIllegalArgumentException("Invalid object.");
        }
    }

    public void destroy() {
        if (!this.mDestroyed) {
            helpDestroy();
            return;
        }
        throw new RSInvalidStateException("Object already destroyed.");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && this.mID == ((BaseObj) obj).mID) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        helpDestroy();
        super.finalize();
    }

    /* access modifiers changed from: package-private */
    public long getID(RenderScript renderScript) {
        this.mRS.validate();
        if (!this.mDestroyed) {
            long j = this.mID;
            if (j == 0) {
                throw new RSRuntimeException("Internal error: Object id 0.");
            } else if (renderScript == null || renderScript == this.mRS) {
                return j;
            } else {
                throw new RSInvalidStateException("using object with mismatched context.");
            }
        } else {
            throw new RSInvalidStateException("using a destroyed object.");
        }
    }

    /* access modifiers changed from: package-private */
    public android.renderscript.BaseObj getNObj() {
        return null;
    }

    public int hashCode() {
        long j = this.mID;
        return (int) ((j >> 32) ^ (268435455 & j));
    }

    /* access modifiers changed from: package-private */
    public void setID(long j) {
        if (this.mID == 0) {
            this.mID = j;
            return;
        }
        throw new RSRuntimeException("Internal Error, reset of object ID.");
    }
}
