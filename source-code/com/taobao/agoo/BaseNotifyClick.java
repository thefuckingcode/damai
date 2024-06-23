package com.taobao.agoo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.agoo.BaseNotifyClickActivity;
import java.util.Iterator;
import java.util.Set;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.MsgDO;
import org.android.agoo.control.AgooFactory;
import org.android.agoo.control.NotifManager;

/* compiled from: Taobao */
public abstract class BaseNotifyClick {
    private String a;
    private AgooFactory b;
    private NotifManager c;
    private Context d;

    private void i(final Intent intent) {
        ThreadPoolExecutorFactory.execute(new Runnable() {
            /* class com.taobao.agoo.BaseNotifyClick.AnonymousClass1 */

            public void run() {
                Throwable th;
                Intent intent = null;
                try {
                    Intent intent2 = intent;
                    if (intent2 != null) {
                        String j = BaseNotifyClick.this.j(intent2);
                        if (TextUtils.isEmpty(j) || TextUtils.isEmpty(BaseNotifyClick.this.a)) {
                            ALog.e("accs.BaseNotifyClick", "parseMsgFromNotifyListener null!!", "source", BaseNotifyClick.this.a);
                        } else {
                            if (BaseNotifyClick.this.c == null) {
                                BaseNotifyClick.this.c = new NotifManager();
                            }
                            if (BaseNotifyClick.this.b == null) {
                                BaseNotifyClick.this.b = new AgooFactory();
                                BaseNotifyClick.this.b.init(BaseNotifyClick.this.d, BaseNotifyClick.this.c, null);
                            }
                            Bundle msgReceiverPreHandler = BaseNotifyClick.this.b.msgReceiverPreHandler(j.getBytes("UTF-8"), BaseNotifyClick.this.a, null, false);
                            String string = msgReceiverPreHandler.getString("body");
                            ALog.i("accs.BaseNotifyClick", "begin parse EncryptedMsg", new Object[0]);
                            String parseEncryptedMsg = AgooFactory.parseEncryptedMsg(string);
                            if (!TextUtils.isEmpty(parseEncryptedMsg)) {
                                msgReceiverPreHandler.putString("body", parseEncryptedMsg);
                            } else {
                                ALog.e("accs.BaseNotifyClick", "parse EncryptedMsg fail, empty", new Object[0]);
                            }
                            Intent intent3 = new Intent();
                            try {
                                intent3.putExtras(msgReceiverPreHandler);
                                BaseNotifyClick.this.b.saveMsg(j.getBytes("UTF-8"), "2");
                                BaseNotifyClick.this.k(intent3);
                                intent = intent3;
                            } catch (Throwable th2) {
                                intent = intent3;
                                th = th2;
                                try {
                                    ALog.e("accs.BaseNotifyClick", "buildMessage", th, new Object[0]);
                                    try {
                                        BaseNotifyClick.this.onMessage(intent);
                                        return;
                                    } catch (Throwable th3) {
                                        ALog.e("accs.BaseNotifyClick", "onMessage", th3, new Object[0]);
                                        return;
                                    }
                                } catch (Throwable th4) {
                                    ALog.e("accs.BaseNotifyClick", "onMessage", th4, new Object[0]);
                                }
                            }
                        }
                    }
                    try {
                        BaseNotifyClick.this.onMessage(intent);
                        return;
                    } catch (Throwable th5) {
                        ALog.e("accs.BaseNotifyClick", "onMessage", th5, new Object[0]);
                        return;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    ALog.e("accs.BaseNotifyClick", "buildMessage", th, new Object[0]);
                    BaseNotifyClick.this.onMessage(intent);
                    return;
                }
                throw th;
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String j(Intent intent) {
        String str;
        Set<BaseNotifyClickActivity.INotifyListener> set = BaseNotifyClickActivity.notifyListeners;
        if (set != null && set.size() > 0) {
            Iterator<BaseNotifyClickActivity.INotifyListener> it = BaseNotifyClickActivity.notifyListeners.iterator();
            str = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                BaseNotifyClickActivity.INotifyListener next = it.next();
                String parseMsgFromIntent = next.parseMsgFromIntent(intent);
                if (!TextUtils.isEmpty(parseMsgFromIntent)) {
                    this.a = next.getMsgSource();
                    str = parseMsgFromIntent;
                    break;
                }
                str = parseMsgFromIntent;
            }
        } else {
            ALog.e("accs.BaseNotifyClick", "no impl, try use default impl to parse intent!", new Object[0]);
            BaseNotifyClickActivity.INotifyListener defaultHuaweiMsgParseImpl = new DefaultHuaweiMsgParseImpl();
            str = defaultHuaweiMsgParseImpl.parseMsgFromIntent(intent);
            if (TextUtils.isEmpty(str)) {
                defaultHuaweiMsgParseImpl = new DefaultXiaomiMsgParseImpl();
                str = defaultHuaweiMsgParseImpl.parseMsgFromIntent(intent);
            }
            if (TextUtils.isEmpty(str)) {
                defaultHuaweiMsgParseImpl = new DefaultHonorMsgParseImpl();
                str = defaultHuaweiMsgParseImpl.parseMsgFromIntent(intent);
            }
            if (TextUtils.isEmpty(str)) {
                defaultHuaweiMsgParseImpl = new DefaultOppoMsgParseImpl();
                str = defaultHuaweiMsgParseImpl.parseMsgFromIntent(intent);
            }
            if (TextUtils.isEmpty(str)) {
                defaultHuaweiMsgParseImpl = new DefaultVivoMsgParseImpl();
                str = defaultHuaweiMsgParseImpl.parseMsgFromIntent(intent);
            }
            if (TextUtils.isEmpty(str)) {
                defaultHuaweiMsgParseImpl = new DefaultMeizuMsgParseImpl();
                str = defaultHuaweiMsgParseImpl.parseMsgFromIntent(intent);
            }
            if (TextUtils.isEmpty(str)) {
                AppMonitorAdapter.commitCount("accs", "error", "parse 3push error", 0.0d);
            } else {
                this.a = defaultHuaweiMsgParseImpl.getMsgSource();
                AppMonitorAdapter.commitCount("accs", "error", "parse 3push default " + this.a, 0.0d);
            }
        }
        ALog.i("accs.BaseNotifyClick", "parseMsgByThirdPush", "result", str, "msgSource", this.a);
        return str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void k(Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("id");
            String stringExtra2 = intent.getStringExtra(AgooConstants.MESSAGE_SOURCE);
            String stringExtra3 = intent.getStringExtra("report");
            String stringExtra4 = intent.getStringExtra(AgooConstants.MESSAGE_EXT);
            MsgDO msgDO = new MsgDO();
            msgDO.msgIds = stringExtra;
            msgDO.extData = stringExtra4;
            msgDO.messageSource = stringExtra2;
            msgDO.reportStr = stringExtra3;
            msgDO.msgStatus = "8";
            ALog.i("accs.BaseNotifyClick", "reportClickNotifyMsg messageId:" + stringExtra + " source:" + stringExtra2 + " reportStr:" + stringExtra3 + " status:" + msgDO.msgStatus, new Object[0]);
            this.c.report(msgDO, null);
        } catch (Exception e) {
            ALog.e("accs.BaseNotifyClick", "reportClickNotifyMsg exception: " + e, new Object[0]);
        }
    }

    public void onCreate(Context context, Intent intent) {
        ALog.i("accs.BaseNotifyClick", "onCreate", new Object[0]);
        this.d = context;
        i(intent);
    }

    public abstract void onMessage(Intent intent);

    public void onNewIntent(Intent intent) {
        ALog.i("accs.BaseNotifyClick", "onNewIntent", new Object[0]);
        i(intent);
    }
}
