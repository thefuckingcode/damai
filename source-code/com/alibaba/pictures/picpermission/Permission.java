package com.alibaba.pictures.picpermission;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.alibaba.pictures.picpermission.custom.IPermissionListener;
import com.alibaba.pictures.picpermission.exception.PicPermissionException;
import com.alibaba.pictures.picpermission.manage.PermissionModel;
import com.alibaba.pictures.picpermission.manage.PicPermissionManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.LinkedList;
import java.util.Queue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
public final class Permission {
    private static transient /* synthetic */ IpChange $ipChange;
    private final Context a;
    private final String[] b;
    private final Queue<PermissionModel> c;
    private final PermissionModel d;

    public Permission(@NotNull Context context, @Nullable String[] strArr, @Nullable Queue<PermissionModel> queue, @Nullable PermissionModel permissionModel) {
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.a = context;
        this.b = strArr;
        this.c = queue;
        this.d = permissionModel;
        if (queue != null) {
            PicPermissionManager.Companion.init(queue, context);
        } else if (strArr != null) {
            PicPermissionManager.Companion.init(strArr, context);
        } else if (permissionModel != null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(permissionModel);
            PicPermissionManager.Companion.init(linkedList, context);
        } else {
            throw new PicPermissionException("queue 和 list 不能都为空！");
        }
    }

    @NotNull
    public final Permission a(@NotNull IPermissionListener iPermissionListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1679675757")) {
            return (Permission) ipChange.ipc$dispatch("1679675757", new Object[]{this, iPermissionListener});
        }
        k21.i(iPermissionListener, "listener");
        PicPermissionManager.Companion.setPermissionListener(iPermissionListener);
        return this;
    }

    public final void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-846869235")) {
            ipChange.ipc$dispatch("-846869235", new Object[]{this});
            return;
        }
        c(false);
    }

    public final void c(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-483096729")) {
            ipChange.ipc$dispatch("-483096729", new Object[]{this, Boolean.valueOf(z)});
        } else if (k21.d(Looper.myLooper(), Looper.getMainLooper())) {
            try {
                PicPermissionManager.Companion.instance().start();
            } catch (RuntimeException e) {
                String message = e.getMessage();
                if (message != null) {
                    Log.e("Permission", message);
                }
            }
        } else if (z) {
            new Handler(Looper.getMainLooper()).post(Permission$start$1.INSTANCE);
        } else {
            PicPermissionManager.Companion.release();
            throw new UnsupportedOperationException("不可在子线程调用，请增加参数 toMainThread = true");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Permission(@NotNull Context context, @NotNull String[] strArr) {
        this(context, strArr, null, null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(strArr, "list");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Permission(@NotNull Context context, @NotNull Queue<PermissionModel> queue) {
        this(context, null, queue, null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(queue, "queue");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Permission(@NotNull Context context, @NotNull PermissionModel permissionModel) {
        this(context, null, null, permissionModel);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(permissionModel, "permission");
    }
}
