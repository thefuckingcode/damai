package tb;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.alibaba.pictures.accs.AgooBroadcastReceiver;
import com.alibaba.pictures.accs.AgooMessage;
import com.alibaba.pictures.accs.DecodeOverListener;
import com.alibaba.pictures.accs.IACCSConfigProvider;
import com.alibaba.pictures.accs.INotifyActionHandler;
import com.alibaba.pictures.accs.PushAgent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AppMonitorAdapter;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Objects;
import java.util.Random;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class c4 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final String AGOO_MSG = "agoo_msg";
    @NotNull
    public static final String AGOO_MSG_ID = "AliAgooMsgID";
    @NotNull
    public static final c4 INSTANCE = new c4();
    private static final String a = ("AGOO." + c4.class.getSimpleName());

    /* compiled from: Taobao */
    public static final class a implements DecodeOverListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Context a;
        final /* synthetic */ AgooMessage b;
        final /* synthetic */ NotificationManager c;
        final /* synthetic */ int d;

        a(Context context, AgooMessage agooMessage, NotificationManager notificationManager, int i) {
            this.a = context;
            this.b = agooMessage;
            this.c = notificationManager;
            this.d = i;
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0027  */
        /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
        @Override // com.alibaba.pictures.accs.DecodeOverListener
        public void onDecodeOver(@Nullable Bitmap[] bitmapArr) {
            boolean z;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1782686595")) {
                ipChange.ipc$dispatch("1782686595", new Object[]{this, bitmapArr});
                return;
            }
            if (bitmapArr != null) {
                if (!(bitmapArr.length == 0)) {
                    z = false;
                    if (z) {
                        Bitmap bitmap = bitmapArr[0];
                        Bitmap bitmap2 = null;
                        if (bitmapArr.length >= 2) {
                            bitmap2 = bitmapArr[1];
                        }
                        this.c.notify(this.d, c4.d(this.a, this.b, bitmap, bitmap2));
                        c4 c4Var = c4.INSTANCE;
                        ALog.d(c4.a, "notified:largePushStyle", new Object[0]);
                        return;
                    }
                    return;
                }
            }
            z = true;
            if (z) {
            }
        }
    }

    private c4() {
    }

    private final boolean b(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1183388479")) {
            return ((Boolean) ipChange.ipc$dispatch("1183388479", new Object[]{this, context})).booleanValue();
        }
        try {
            return NotificationManagerCompat.from(context).areNotificationsEnabled();
        } catch (Exception unused) {
            return false;
        }
    }

    @JvmStatic
    @NotNull
    public static final Notification c(@NotNull Context context, @NotNull AgooMessage agooMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1451032650")) {
            return (Notification) ipChange.ipc$dispatch("-1451032650", new Object[]{context, agooMessage});
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(agooMessage, "agooMessage");
        return d(context, agooMessage, null, null);
    }

    @JvmStatic
    @NotNull
    public static final Notification d(@NotNull Context context, @NotNull AgooMessage agooMessage, @Nullable Bitmap bitmap, @Nullable Bitmap bitmap2) {
        NotificationCompat.Builder builder;
        Integer appTinyIconRes;
        IACCSConfigProvider f;
        Integer appIconRes;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1357178506")) {
            return (Notification) ipChange.ipc$dispatch("-1357178506", new Object[]{context, agooMessage, bitmap, bitmap2});
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(agooMessage, "agooMessage");
        Intent intent = new Intent(context, AgooBroadcastReceiver.class);
        intent.setAction("com.taobao.movie.action.PUSH_CLICK_ACTION");
        intent.setPackage(context.getPackageName());
        int pendingIntentId = agooMessage.getPendingIntentId();
        if (pendingIntentId == 0) {
            pendingIntentId = new Random().nextInt();
            agooMessage.setPendingIntentId(pendingIntentId);
        }
        intent.putExtra(AGOO_MSG, agooMessage);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, pendingIntentId, intent, 134217728);
        Intent intent2 = new Intent(context, AgooBroadcastReceiver.class);
        intent2.setAction("com.taobao.movie.action.PUSH_DELETE_ACTION");
        intent2.setPackage(context.getPackageName());
        intent2.putExtra(AGOO_MSG, agooMessage);
        PendingIntent broadcast2 = PendingIntent.getBroadcast(context, pendingIntentId, intent2, 134217728);
        if (!(bitmap != null || (f = PushAgent.INSTANCE.f()) == null || (appIconRes = f.getAppIconRes()) == null)) {
            bitmap = BitmapFactory.decodeResource(context.getResources(), appIconRes.intValue());
        }
        if (Build.VERSION.SDK_INT >= 26) {
            builder = new NotificationCompat.Builder(context, INSTANCE.f(context, agooMessage.getNotifyChannelId(), agooMessage.getNotifyChannelName(), agooMessage.getNotifyImportance()));
        } else {
            builder = new NotificationCompat.Builder(context);
        }
        IACCSConfigProvider f2 = PushAgent.INSTANCE.f();
        if (!(f2 == null || (appTinyIconRes = f2.getAppTinyIconRes()) == null)) {
            i = appTinyIconRes.intValue();
        }
        builder.setAutoCancel(true).setContentTitle(agooMessage.getTitle()).setContentText(agooMessage.getText()).setDefaults(-1).setSmallIcon(i).setLargeIcon(bitmap).setTicker(agooMessage.getTicker()).setContentIntent(broadcast).setDeleteIntent(broadcast2);
        if (bitmap2 != null) {
            NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle(builder);
            bigPictureStyle.setBigContentTitle(agooMessage.getTitle());
            bigPictureStyle.setSummaryText(agooMessage.getText());
            bigPictureStyle.bigPicture(bitmap2);
            builder.setStyle(bigPictureStyle);
        }
        String url = agooMessage.getUrl();
        if (url == null) {
            url = "--";
        }
        AppMonitorAdapter.commitAlarmSuccess("accs_agoo", "status", url);
        Notification build = builder.build();
        k21.h(build, "builder.build()");
        return build;
    }

    @JvmStatic
    public static final void e(@NotNull Context context, @Nullable AgooMessage agooMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-585208108")) {
            ipChange.ipc$dispatch("-585208108", new Object[]{context, agooMessage});
            return;
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (agooMessage != null) {
            PushAgent pushAgent = PushAgent.INSTANCE;
            if (!pushAgent.i()) {
                ALog.d(a, "开关已关闭", new Object[0]);
                AppMonitorAdapter.commitAlarmFail("accs_agoo", "status", "", "10001", "app notify switch off");
            } else if (!INSTANCE.b(context)) {
                AppMonitorAdapter.commitAlarmFail("accs_agoo", "status", "", "10002", "sys notify switch off");
            } else {
                String str = a;
                ALog.d(str, "msg:" + agooMessage, new Object[0]);
                Object systemService = context.getSystemService("notification");
                Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
                NotificationManager notificationManager = (NotificationManager) systemService;
                Integer notifyId = agooMessage.getNotifyId();
                int intValue = notifyId != null ? notifyId.intValue() : new Random().nextInt();
                if ((!TextUtils.isEmpty(agooMessage.getBigPicUrl()) || !TextUtils.isEmpty(agooMessage.getImgUrl())) && pushAgent.h() != null) {
                    INotifyActionHandler h = pushAgent.h();
                    if (h != null) {
                        h.onNotifyImgResDecode(new String[]{agooMessage.getImgUrl(), agooMessage.getBigPicUrl()}, new a(context, agooMessage, notificationManager, intValue));
                        return;
                    }
                    return;
                }
                notificationManager.notify(intValue, c(context, agooMessage));
                ALog.d(str, "notified", new Object[0]);
            }
        }
    }

    @RequiresApi(26)
    private final String f(Context context, String str, String str2, Integer num) {
        IpChange ipChange = $ipChange;
        int i = 3;
        if (AndroidInstantRuntime.support(ipChange, "-275330829")) {
            return (String) ipChange.ipc$dispatch("-275330829", new Object[]{this, context, str, str2, num});
        }
        Object systemService = context.getSystemService("notification");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        if (str == null) {
            str = "tpp_notification_universal";
        }
        if (str2 == null) {
            str2 = "消息推送";
        }
        if (num != null) {
            i = num.intValue();
        }
        NotificationChannel notificationChannel = new NotificationChannel(str, str2, i);
        notificationChannel.setLightColor(-16711936);
        notificationChannel.setLockscreenVisibility(0);
        notificationManager.createNotificationChannel(notificationChannel);
        return str;
    }
}
