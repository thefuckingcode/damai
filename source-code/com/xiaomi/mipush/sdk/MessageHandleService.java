package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.al;
import com.xiaomi.push.eo;
import com.xiaomi.push.ey;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public class MessageHandleService extends BaseService {
    private static ConcurrentLinkedQueue<a> a = new ConcurrentLinkedQueue<>();

    /* renamed from: a  reason: collision with other field name */
    private static ExecutorService f25a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* compiled from: Taobao */
    public static class a {
        private Intent a;

        /* renamed from: a  reason: collision with other field name */
        private PushMessageReceiver f26a;

        public a(Intent intent, PushMessageReceiver pushMessageReceiver) {
            this.f26a = pushMessageReceiver;
            this.a = intent;
        }

        public Intent a() {
            return this.a;
        }

        /* renamed from: a  reason: collision with other method in class */
        public PushMessageReceiver m194a() {
            return this.f26a;
        }
    }

    protected static void a(Context context, Intent intent) {
        if (intent != null) {
            b(context);
        }
    }

    static void a(Context context, a aVar) {
        String[] stringArrayExtra;
        if (aVar != null) {
            try {
                PushMessageReceiver a2 = aVar.m194a();
                Intent a3 = aVar.a();
                int intExtra = a3.getIntExtra("message_type", 1);
                if (intExtra == 1) {
                    PushMessageHandler.a a4 = am.a(context).a(a3);
                    int intExtra2 = a3.getIntExtra("eventMessageType", -1);
                    if (a4 == null) {
                        return;
                    }
                    if (a4 instanceof MiPushMessage) {
                        MiPushMessage miPushMessage = (MiPushMessage) a4;
                        if (!miPushMessage.isArrivedMessage()) {
                            a2.onReceiveMessage(context, miPushMessage);
                        }
                        if (miPushMessage.getPassThrough() == 1) {
                            eo.a(context.getApplicationContext()).a(context.getPackageName(), a3, 2004, (String) null);
                            b.e("begin execute onReceivePassThroughMessage from " + miPushMessage.getMessageId());
                            a2.onReceivePassThroughMessage(context, miPushMessage);
                            return;
                        } else if (miPushMessage.isNotified()) {
                            if (intExtra2 == 1000) {
                                eo.a(context.getApplicationContext()).a(context.getPackageName(), a3, 1007, (String) null);
                            } else {
                                eo.a(context.getApplicationContext()).a(context.getPackageName(), a3, 3007, (String) null);
                            }
                            b.e("begin execute onNotificationMessageClicked from　" + miPushMessage.getMessageId());
                            a2.onNotificationMessageClicked(context, miPushMessage);
                            return;
                        } else {
                            b.e("begin execute onNotificationMessageArrived from " + miPushMessage.getMessageId());
                            a2.onNotificationMessageArrived(context, miPushMessage);
                            return;
                        }
                    } else if (a4 instanceof MiPushCommandMessage) {
                        MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) a4;
                        b.e("begin execute onCommandResult, command=" + miPushCommandMessage.getCommand() + ", resultCode=" + miPushCommandMessage.getResultCode() + ", reason=" + miPushCommandMessage.getReason());
                        a2.onCommandResult(context, miPushCommandMessage);
                        if (TextUtils.equals(miPushCommandMessage.getCommand(), ey.COMMAND_REGISTER.f325a)) {
                            a2.onReceiveRegisterResult(context, miPushCommandMessage);
                            PushMessageHandler.a(context, miPushCommandMessage);
                            if (miPushCommandMessage.getResultCode() != 0) {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (intExtra == 3) {
                    MiPushCommandMessage miPushCommandMessage2 = (MiPushCommandMessage) a3.getSerializableExtra(PushMessageHelper.KEY_COMMAND);
                    b.e("(Local) begin execute onCommandResult, command=" + miPushCommandMessage2.getCommand() + ", resultCode=" + miPushCommandMessage2.getResultCode() + ", reason=" + miPushCommandMessage2.getReason());
                    a2.onCommandResult(context, miPushCommandMessage2);
                    if (TextUtils.equals(miPushCommandMessage2.getCommand(), ey.COMMAND_REGISTER.f325a)) {
                        a2.onReceiveRegisterResult(context, miPushCommandMessage2);
                        PushMessageHandler.a(context, miPushCommandMessage2);
                        if (miPushCommandMessage2.getResultCode() != 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (intExtra == 5 && PushMessageHelper.ERROR_TYPE_NEED_PERMISSION.equals(a3.getStringExtra(PushMessageHelper.ERROR_TYPE)) && (stringArrayExtra = a3.getStringArrayExtra(PushMessageHelper.ERROR_MESSAGE)) != null) {
                    b.e("begin execute onRequirePermissions, lack of necessary permissions");
                    a2.onRequirePermissions(context, stringArrayExtra);
                    return;
                } else {
                    return;
                }
                i.b(context);
            } catch (RuntimeException e) {
                b.a(e);
            }
        }
    }

    public static void addJob(Context context, a aVar) {
        if (aVar != null) {
            a.add(aVar);
            b(context);
            startService(context);
        }
    }

    private static void b(Context context) {
        if (!f25a.isShutdown()) {
            f25a.execute(new z(context));
        }
    }

    /* access modifiers changed from: private */
    public static void c(Context context) {
        try {
            a(context, a.poll());
        } catch (RuntimeException e) {
            b.a(e);
        }
    }

    public static void startService(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, MessageHandleService.class));
        al.a(context).a(new y(context, intent));
    }

    /* access modifiers changed from: protected */
    @Override // com.xiaomi.mipush.sdk.BaseService
    public boolean a() {
        ConcurrentLinkedQueue<a> concurrentLinkedQueue = a;
        return concurrentLinkedQueue != null && concurrentLinkedQueue.size() > 0;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }
}
