package org.android.spdy;

import android.content.Context;
import com.taobao.wireless.security.sdk.SecurityGuardManager;
import com.taobao.wireless.security.sdk.dynamicdatastore.IDynamicDataStoreComponent;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: Taobao */
public class SecurityGuardCacherImp implements QuicCacher {
    private Class IDynamicDataStoreComponent;
    private Class SecurityGuardManager;
    private Object ddsComp;
    private Method getDynamicDataStoreComp;
    private Method getInstance;
    private Method getStringDDpEx;
    private volatile boolean init_ok = false;
    private Method putStringDDpEx;
    private Method removeStringDDpEx;
    private Object sgMgr;

    @Override // org.android.spdy.QuicCacher
    public synchronized void init(Context context) {
        if (!this.init_ok) {
            try {
                int i = SecurityGuardManager.e;
                this.SecurityGuardManager = SecurityGuardManager.class;
                Method declaredMethod = SecurityGuardManager.class.getDeclaredMethod("getInstance", Context.class);
                this.getInstance = declaredMethod;
                Object invoke = declaredMethod.invoke(null, context);
                this.sgMgr = invoke;
                if (invoke != null) {
                    Method declaredMethod2 = this.SecurityGuardManager.getDeclaredMethod("getDynamicDataStoreComp", new Class[0]);
                    this.getDynamicDataStoreComp = declaredMethod2;
                    Object invoke2 = declaredMethod2.invoke(this.sgMgr, new Object[0]);
                    this.ddsComp = invoke2;
                    if (invoke2 != null) {
                        this.IDynamicDataStoreComponent = IDynamicDataStoreComponent.class;
                        Class<?> cls = Integer.TYPE;
                        this.putStringDDpEx = IDynamicDataStoreComponent.class.getDeclaredMethod("putStringDDpEx", String.class, String.class, cls);
                        this.getStringDDpEx = this.IDynamicDataStoreComponent.getDeclaredMethod("getStringDDpEx", String.class, cls);
                        this.removeStringDDpEx = this.IDynamicDataStoreComponent.getDeclaredMethod("removeStringDDpEx", String.class, cls);
                        this.init_ok = true;
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
        }
    }

    @Override // org.android.spdy.QuicCacher
    public byte[] load(String str) {
        if (!this.init_ok) {
            return null;
        }
        try {
            String str2 = (String) this.getStringDDpEx.invoke(this.ddsComp, str, 0);
            if (str2 != null) {
                return str2.getBytes("ISO-8859-1");
            }
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    @Override // org.android.spdy.QuicCacher
    public void remove(String str) {
        if (this.init_ok) {
            try {
                this.removeStringDDpEx.invoke(this.ddsComp, str, 0);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // org.android.spdy.QuicCacher
    public boolean store(String str, String str2) {
        if (this.init_ok) {
            try {
                this.putStringDDpEx.invoke(this.ddsComp, str, str2, 0);
                return true;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }
}
