package com.alibaba.wireless.security.open.middletier.fc.ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge;
import com.alibaba.wireless.security.open.middletier.R;
import com.alibaba.wireless.security.open.middletier.fc.ui.IBXWebview;
import com.taobao.weex.ui.module.WXModalUIModule;
import com.uc.webview.export.media.MessageID;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import mtopsdk.common.util.SymbolExpUtil;

/* compiled from: Taobao */
public class ExtContainerActivity extends Activity {
    private static ActivityManager C;
    volatile int A = 0;
    private long B = -1;
    IBXWebview a = null;
    Handler b = null;
    long c = 0;
    String d = "";
    String e = "?action=close";
    long f;
    String g = "";
    String h = "";
    String i = null;
    String j = null;
    boolean k = false;
    boolean l = false;
    boolean m = false;
    boolean n = true;
    boolean o = false;
    boolean p = false;
    boolean q = true;
    boolean r = false;
    boolean s = true;
    boolean t = false;
    boolean u = false;
    float v = 1.0f;
    int w = 0;
    volatile int x = 0;
    volatile int y = 0;
    volatile int z = 0;

    /* compiled from: Taobao */
    private class DownloadCompleteReceiver extends BroadcastReceiver {
        private DownloadCompleteReceiver() {
        }

        private File a(Context context, long j) {
            DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
            File file = null;
            if (j != -1) {
                DownloadManager.Query query = new DownloadManager.Query();
                query.setFilterById(j);
                query.setFilterByStatus(8);
                Cursor query2 = downloadManager.query(query);
                if (query2 != null) {
                    if (query2.moveToFirst()) {
                        String string = query2.getString(query2.getColumnIndex("local_uri"));
                        if (!TextUtils.isEmpty(string)) {
                            file = new File(Uri.parse(string).getPath());
                        }
                    }
                    query2.close();
                }
            }
            return file;
        }

        public void onReceive(Context context, Intent intent) {
            Uri uri;
            if (intent != null) {
                try {
                    long longExtra = intent.getLongExtra("extra_download_id", -1);
                    if (longExtra == ExtContainerActivity.this.B && "android.intent.action.DOWNLOAD_COMPLETE".equals(intent.getAction())) {
                        ExtContainerActivity extContainerActivity = ExtContainerActivity.this;
                        if (extContainerActivity.r) {
                            extContainerActivity.startActivity(new Intent("android.intent.action.VIEW_DOWNLOADS"));
                        } else if (extContainerActivity.t) {
                            DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
                            String mimeTypeForDownloadedFile = downloadManager.getMimeTypeForDownloadedFile(longExtra);
                            if (TextUtils.isEmpty(mimeTypeForDownloadedFile)) {
                                mimeTypeForDownloadedFile = "*/*";
                            }
                            Intent intent2 = new Intent("android.intent.action.VIEW");
                            intent2.addFlags(268435456);
                            int i = Build.VERSION.SDK_INT;
                            if (i < 23) {
                                uri = downloadManager.getUriForDownloadedFile(longExtra);
                            } else if (i < 24) {
                                uri = Uri.fromFile(a(context, longExtra));
                            } else {
                                ExtContainerActivity.this.startActivity(new Intent("android.intent.action.VIEW_DOWNLOADS"));
                                uri = null;
                            }
                            if (uri != null) {
                                intent2.setDataAndType(uri, mimeTypeForDownloadedFile);
                                ExtContainerActivity.this.startActivity(intent2);
                            }
                        }
                    }
                } catch (Exception e) {
                    ExtContainerActivity.this.a(true, 2305, "", 0, e.getMessage(), "");
                }
            }
            ExtContainerActivity extContainerActivity2 = ExtContainerActivity.this;
            boolean z = extContainerActivity2.k;
            extContainerActivity2.a(z, 0, "", 0, "onReceive", "" + ExtContainerActivity.this.B);
        }
    }

    /* compiled from: Taobao */
    private class DownloadSerice implements IBXWebview.IBXDownloadService {
        private DownloadSerice() {
        }

        @Override // com.alibaba.wireless.security.open.middletier.fc.ui.IBXWebview.IBXDownloadService
        public long startDownload(String str, String str2) {
            int i;
            int i2;
            Exception e;
            AlertDialog.Builder positiveButton;
            int i3 = 0;
            try {
                ExtContainerActivity extContainerActivity = ExtContainerActivity.this;
                extContainerActivity.i = str;
                extContainerActivity.j = str2;
                if (extContainerActivity.n) {
                    final HashMap<String, String> installedMarketPackageName = AppStoreUtils.getInstalledMarketPackageName(extContainerActivity);
                    i2 = installedMarketPackageName.size();
                    try {
                        if (installedMarketPackageName.size() > 1) {
                            final String[] strArr = new String[installedMarketPackageName.size()];
                            int i4 = 0;
                            for (String str3 : installedMarketPackageName.keySet()) {
                                strArr[i4] = str3;
                                i4++;
                            }
                            positiveButton = new AlertDialog.Builder(ExtContainerActivity.this).setTitle(R.string.sg_app_store_select).setItems(strArr, new DialogInterface.OnClickListener() {
                                /* class com.alibaba.wireless.security.open.middletier.fc.ui.ExtContainerActivity.DownloadSerice.AnonymousClass1 */

                                public void onClick(DialogInterface dialogInterface, int i) {
                                    ExtContainerActivity extContainerActivity = ExtContainerActivity.this;
                                    AppStoreUtils.toMarket(extContainerActivity, ExtContainerActivity.getPackageNameWrapper(extContainerActivity), (String) installedMarketPackageName.get(strArr[i]));
                                }
                            });
                        } else if (installedMarketPackageName.size() == 1) {
                            ExtContainerActivity extContainerActivity2 = ExtContainerActivity.this;
                            AppStoreUtils.toMarket(extContainerActivity2, ExtContainerActivity.getPackageNameWrapper(extContainerActivity2), installedMarketPackageName.get(installedMarketPackageName.keySet().iterator().next()));
                            i3 = i2;
                            i = 0;
                            ExtContainerActivity extContainerActivity3 = ExtContainerActivity.this;
                            boolean z = extContainerActivity3.k;
                            extContainerActivity3.a(z, 0, "", 0, "startDownload", ExtContainerActivity.this.B + "|" + i3 + "|" + i + "|" + ExtContainerActivity.this.n + "|" + ExtContainerActivity.this.o + "|" + ExtContainerActivity.this.p);
                            return ExtContainerActivity.this.B;
                        } else {
                            extContainerActivity = ExtContainerActivity.this;
                            if (!extContainerActivity.p) {
                                positiveButton = new AlertDialog.Builder(ExtContainerActivity.this).setMessage(R.string.sg_app_store_not_exist).setPositiveButton(R.string.sg_dialog_ok, (DialogInterface.OnClickListener) null);
                            }
                        }
                        positiveButton.create().show();
                    } catch (Exception e2) {
                        e = e2;
                        ExtContainerActivity.this.a(true, 2304, "", 0, e.getMessage(), "");
                        i3 = i2;
                        i = 0;
                        ExtContainerActivity extContainerActivity32 = ExtContainerActivity.this;
                        boolean z2 = extContainerActivity32.k;
                        extContainerActivity32.a(z2, 0, "", 0, "startDownload", ExtContainerActivity.this.B + "|" + i3 + "|" + i + "|" + ExtContainerActivity.this.n + "|" + ExtContainerActivity.this.o + "|" + ExtContainerActivity.this.p);
                        return ExtContainerActivity.this.B;
                    }
                    i3 = i2;
                    i = 0;
                    ExtContainerActivity extContainerActivity322 = ExtContainerActivity.this;
                    boolean z22 = extContainerActivity322.k;
                    extContainerActivity322.a(z22, 0, "", 0, "startDownload", ExtContainerActivity.this.B + "|" + i3 + "|" + i + "|" + ExtContainerActivity.this.n + "|" + ExtContainerActivity.this.o + "|" + ExtContainerActivity.this.p);
                    return ExtContainerActivity.this.B;
                }
                if (extContainerActivity.o) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addCategory("android.intent.category.BROWSABLE");
                    intent.setData(Uri.parse(str));
                    ExtContainerActivity.this.startActivity(intent);
                } else if (extContainerActivity.p) {
                    i2 = 0;
                }
                i = 0;
                ExtContainerActivity extContainerActivity3222 = ExtContainerActivity.this;
                boolean z222 = extContainerActivity3222.k;
                extContainerActivity3222.a(z222, 0, "", 0, "startDownload", ExtContainerActivity.this.B + "|" + i3 + "|" + i + "|" + ExtContainerActivity.this.n + "|" + ExtContainerActivity.this.o + "|" + ExtContainerActivity.this.p);
                return ExtContainerActivity.this.B;
                i = extContainerActivity.a(str, str2);
                i3 = i2;
            } catch (Exception e3) {
                e = e3;
                i2 = 0;
                ExtContainerActivity.this.a(true, 2304, "", 0, e.getMessage(), "");
                i3 = i2;
                i = 0;
                ExtContainerActivity extContainerActivity32222 = ExtContainerActivity.this;
                boolean z2222 = extContainerActivity32222.k;
                extContainerActivity32222.a(z2222, 0, "", 0, "startDownload", ExtContainerActivity.this.B + "|" + i3 + "|" + i + "|" + ExtContainerActivity.this.n + "|" + ExtContainerActivity.this.o + "|" + ExtContainerActivity.this.p);
                return ExtContainerActivity.this.B;
            }
            ExtContainerActivity extContainerActivity322222 = ExtContainerActivity.this;
            boolean z22222 = extContainerActivity322222.k;
            extContainerActivity322222.a(z22222, 0, "", 0, "startDownload", ExtContainerActivity.this.B + "|" + i3 + "|" + i + "|" + ExtContainerActivity.this.n + "|" + ExtContainerActivity.this.o + "|" + ExtContainerActivity.this.p);
            return ExtContainerActivity.this.B;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int a(String str, String str2) {
        if (ContextCompat.checkSelfPermission(getApplication(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            b(str, str2);
            return 1;
        } else if (this.s) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1139);
            return 2;
        } else {
            new AlertDialog.Builder(this).setMessage(R.string.sg_permission_failed).setPositiveButton(R.string.sg_dialog_ok, (DialogInterface.OnClickListener) null).create().show();
            return 3;
        }
    }

    private String a(String str) throws MalformedURLException {
        String query = new URL(str).getQuery();
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(query)) {
            String str2 = null;
            String[] split = query.split("&");
            for (String str3 : split) {
                if (str3.startsWith("http_referer=")) {
                    this.d = str3.substring(13);
                    str2 = str3;
                } else if (!str3.equalsIgnoreCase("native=1")) {
                    sb.append(str3);
                    sb.append("&");
                }
            }
            sb.append("tmd_nc=1");
            if (str2 != null) {
                sb.append("&");
                sb.append(str2);
            }
            return str.replace(query, sb.toString());
        }
        sb.append(str);
        if (!str.endsWith("?")) {
            sb.append("?");
        }
        sb.append("tmd_nc=1");
        return sb.toString();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a() {
        this.u = true;
        if (isFinishing()) {
            return;
        }
        if (!isTaskRoot() || Build.VERSION.SDK_INT < 21) {
            finish();
        } else {
            finishAndRemoveTask();
        }
    }

    private long b(String str, String str2) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(1);
        request.setVisibleInDownloadsUi(true);
        request.setAllowedOverRoaming(true);
        request.setAllowedNetworkTypes(2);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(str, str2, getMIMEType(str)));
        DownloadManager downloadManager = (DownloadManager) getSystemService("download");
        if (this.q) {
            Toast.makeText(this, "开始下载更新包", 0).show();
        }
        long enqueue = downloadManager.enqueue(request);
        this.B = enqueue;
        return enqueue;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b() {
        if (!isFinishing()) {
            finish();
        }
    }

    /* access modifiers changed from: private */
    public static boolean b(Context context) {
        try {
            if (C == null) {
                C = (ActivityManager) context.getSystemService("activity");
            }
            ActivityManager activityManager = C;
            if (activityManager != null) {
                String packageName = context.getPackageName();
                List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
                if (runningTasks != null && runningTasks.size() > 0) {
                    ComponentName componentName = runningTasks.get(0).topActivity;
                    return packageName.equals(componentName.getPackageName()) && context.getPackageManager().getActivityInfo(componentName, 0).processName.equals(context.getApplicationInfo().processName) && !ExtContainerActivity.class.getName().equals(componentName.getClassName());
                }
            }
        } catch (Exception unused) {
        }
    }

    public static String getMIMEType(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (fileExtensionFromUrl != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return null;
    }

    public static String getPackageNameWrapper(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, String str, String str2, String str3, boolean z2, boolean z3, int i3) {
        long currentTimeMillis = System.currentTimeMillis() - this.f;
        if (z3) {
            a(z3, 0, str, currentTimeMillis, str2, str3);
        }
        if (this.l) {
            Intent intent = new Intent(IUIBridge.INTENT_SEND_LOG);
            intent.setPackage(getApplicationContext().getPackageName());
            intent.putExtra(IUIBridge.KEY_UI_LOG, "{mn:100155,ec:" + i2 + ",msg:" + str + ",tc:" + currentTimeMillis + ",cp:" + str2 + ",ext:" + str3 + ",sid:" + this.c + ",bxuid:" + this.h + "}");
            intent.putExtra(IUIBridge.KEY_UI_LOG_WAY, 6);
            intent.putExtra(IUIBridge.KEY_UI_LOG_SEND, z2);
            intent.putExtra(IUIBridge.KEY_UI_INFO, i3 + "&" + this.h);
            intent.putExtra(IUIBridge.KEY_IS_SAMPLE, this.l);
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(long j2, String str, int i2) {
        Intent intent = new Intent(str);
        intent.setPackage(getApplicationContext().getPackageName());
        intent.putExtra(IUIBridge.KEY_SESSION_ID, j2);
        intent.putExtra(IUIBridge.KEY_UI_RESULT, i2);
        intent.putExtra(IUIBridge.KEY_IS_SAMPLE, this.l);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2, int i2, String str, long j2, String str2, String str3) {
        if (z2) {
            String num = Integer.toString(100155);
            String str4 = this.g;
            UserTrackMethodJniBridge.addUtRecord(num, i2, 7, str4, j2, str, str2, str3, "" + this.c, this.h);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z2, int i2, String str, long j2, String str2, String str3) {
        if (z2) {
            String num = Integer.toString(100169);
            String str4 = this.g;
            UserTrackMethodJniBridge.addUtRecord(num, i2, 7, str4, j2, str, str2, str3, "" + this.c, this.h);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.l && this.y == 0) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2 && this.z == 0) {
                        this.z = 1;
                    }
                } else if (this.y == 0) {
                    this.y = 1;
                    a(0, "", "Dispatchtouchevent", "" + this.x + "" + this.z + "" + this.y, false, true, 21);
                }
            } else if (this.x == 0) {
                this.x = 1;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void onBackPressed() {
        if (!this.m) {
            super.onBackPressed();
            this.A = 4;
            a();
            a(this.c, IUIBridge.INTENT_ACTIVITY_RESULT, 4);
            a(0, "", "Onbackpressed", "" + this.m, false, this.k, 19);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0209  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0210  */
    public void onCreate(Bundle bundle) {
        String str;
        Exception e2;
        int i2;
        boolean z2;
        super.onCreate(bundle);
        boolean z3 = true;
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        setFinishOnTouchOutside(false);
        this.f = System.currentTimeMillis();
        this.u = false;
        this.b = new Handler(Looper.getMainLooper());
        try {
            Intent intent = getIntent();
            this.k = intent.getBooleanExtra("needUT", false);
            this.l = intent.getBooleanExtra("isSample", false);
            this.c = intent.getLongExtra("sessionId", 0);
            this.g = intent.getStringExtra("pluginVersion");
            this.h = intent.getStringExtra("bxUUID");
            this.m = intent.getBooleanExtra("hideCloseBtn", false);
            this.w = intent.getIntExtra("apiTimeOut", 0);
            this.v = intent.getFloatExtra("windowHeight", 1.0f);
            try {
                Display defaultDisplay = getWindowManager().getDefaultDisplay();
                Window window = getWindow();
                window.getDecorView().setPadding(0, 0, 0, 0);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -1;
                attributes.height = (int) (((float) defaultDisplay.getHeight()) * this.v);
                attributes.gravity = 80;
                window.setAttributes(attributes);
                i2 = -1;
            } catch (Exception e3) {
                i2 = -1;
                b(true, 2306, "", 0, e3.getMessage(), "");
            }
            String[] split = intent.getStringExtra("downloadConfig").split(SymbolExpUtil.SYMBOL_VERTICALBAR, i2);
            if (split.length >= 7) {
                this.n = Integer.valueOf(split[0]).intValue() > 0;
                this.o = Integer.valueOf(split[1]).intValue() > 0;
                this.p = Integer.valueOf(split[2]).intValue() > 0;
                this.q = Integer.valueOf(split[3]).intValue() > 0;
                this.r = Integer.valueOf(split[4]).intValue() > 0;
                this.t = Integer.valueOf(split[5]).intValue() > 0;
                this.s = Integer.valueOf(split[6]).intValue() > 0;
            }
            String a2 = a(intent.getStringExtra("location"));
            try {
                LinearLayout linearLayout = new LinearLayout(this);
                linearLayout.setOrientation(1);
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(i2, i2));
                setContentView(linearLayout);
                try {
                    Class.forName("android.taobao.windvane.extra.uc.WVUCWebView");
                    z2 = true;
                } catch (Exception unused) {
                    z2 = false;
                }
                this.a = z2 ? new BXWVWebview(this, a2) : new BXWebview(this, a2);
                linearLayout.addView((View) this.a, new ViewGroup.LayoutParams(i2, i2));
                BroadcastReceiver downloadCompleteReceiver = new DownloadCompleteReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.DOWNLOAD_COMPLETE");
                getApplication().registerReceiver(downloadCompleteReceiver, intentFilter);
                this.a.bxSetUp(this, new IUrlVerifyCallback() {
                    /* class com.alibaba.wireless.security.open.middletier.fc.ui.ExtContainerActivity.AnonymousClass1 */

                    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0046, code lost:
                        if (r11.equalsIgnoreCase(r10.a.d + r10.a.e) != false) goto L_0x0048;
                     */
                    @Override // com.alibaba.wireless.security.open.middletier.fc.ui.IUrlVerifyCallback
                    public boolean shouldOverrideUrlLoading(String str) {
                        String str2;
                        int i;
                        int i2;
                        String str3;
                        String str4;
                        if (TextUtils.isEmpty(str) || str.length() <= 1000) {
                            str2 = str;
                        } else {
                            try {
                                str4 = str.substring(0, 1000);
                            } catch (Exception unused) {
                                str4 = "";
                            }
                            str2 = str4;
                        }
                        if (!TextUtils.isEmpty(str)) {
                            if (!str.equalsIgnoreCase(ExtContainerActivity.this.d)) {
                            }
                            if (str.equalsIgnoreCase(ExtContainerActivity.this.d)) {
                                str3 = "Shouldoverrideurlloading" + "|Uisuccess";
                                i = 1;
                                i2 = 15;
                            } else {
                                i = 4;
                                str3 = "Shouldoverrideurlloading" + "|UICloseAction";
                                i2 = 16;
                            }
                            ExtContainerActivity extContainerActivity = ExtContainerActivity.this;
                            extContainerActivity.A = 1;
                            extContainerActivity.a();
                            ExtContainerActivity extContainerActivity2 = ExtContainerActivity.this;
                            extContainerActivity2.a(extContainerActivity2.c, IUIBridge.INTENT_ACTIVITY_RESULT, i);
                            ExtContainerActivity extContainerActivity3 = ExtContainerActivity.this;
                            extContainerActivity3.a(0, "", str3, str2, false, extContainerActivity3.k, i2);
                            return true;
                        }
                        ExtContainerActivity extContainerActivity4 = ExtContainerActivity.this;
                        extContainerActivity4.a(0, "", "Shouldoverrideurlloading" + "|Uifail", str2, false, extContainerActivity4.k, 17);
                        return false;
                    }
                }, new DownloadSerice());
                this.a.bxLoadUrl(a2);
                a(0, "", "Oncreate" + "|Loadurl", a2, false, this.k, 11);
                z3 = false;
            } catch (Exception e4) {
                e2 = e4;
                str = a2;
                this.k = true;
                a(2303, "" + e2.getMessage(), "Oncreate" + "|Exception", str, false, this.k, 12);
                if (z3) {
                }
            }
        } catch (Exception e5) {
            e2 = e5;
            str = "";
            this.k = true;
            a(2303, "" + e2.getMessage(), "Oncreate" + "|Exception", str, false, this.k, 12);
            if (z3) {
            }
        }
        if (z3) {
            this.A = 2;
            a();
        } else if (this.w > 0) {
            this.b.postDelayed(new Runnable() {
                /* class com.alibaba.wireless.security.open.middletier.fc.ui.ExtContainerActivity.AnonymousClass2 */

                public void run() {
                    ExtContainerActivity extContainerActivity = ExtContainerActivity.this;
                    if (!extContainerActivity.u) {
                        extContainerActivity.A = 3;
                        extContainerActivity.a();
                        ExtContainerActivity extContainerActivity2 = ExtContainerActivity.this;
                        extContainerActivity2.m = false;
                        extContainerActivity2.a(extContainerActivity2.c, IUIBridge.INTENT_ACTIVITY_RESULT, 8);
                        ExtContainerActivity extContainerActivity3 = ExtContainerActivity.this;
                        extContainerActivity3.a(0, "", "Apitimeout", "onCreate", false, extContainerActivity3.k, 18);
                    }
                }
            }, (long) this.w);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.u = true;
        super.onDestroy();
        IBXWebview iBXWebview = this.a;
        if (iBXWebview != null) {
            try {
                iBXWebview.bxDestroy();
                this.a = null;
            } catch (Exception unused) {
            }
        }
        a(0, "", "", "Ondestroy" + this.A, this.A == 0, true, 22);
    }

    public void onPause() {
        super.onPause();
        a(0, "", MessageID.onPause, MessageID.onPause, false, this.k, 14);
        this.b.postDelayed(new Runnable() {
            /* class com.alibaba.wireless.security.open.middletier.fc.ui.ExtContainerActivity.AnonymousClass3 */

            public void run() {
                ExtContainerActivity extContainerActivity = ExtContainerActivity.this;
                if (!extContainerActivity.u && ExtContainerActivity.b((Context) extContainerActivity)) {
                    ExtContainerActivity extContainerActivity2 = ExtContainerActivity.this;
                    extContainerActivity2.A = 5;
                    extContainerActivity2.a(extContainerActivity2.c, IUIBridge.INTENT_ACTIVITY_RESULT, 1);
                    ExtContainerActivity.this.b();
                    ExtContainerActivity extContainerActivity3 = ExtContainerActivity.this;
                    extContainerActivity3.a(0, "", MessageID.onPause, "", false, extContainerActivity3.k, 20);
                }
            }
        }, 1000);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        int i3;
        if (i2 == 1139) {
            if (iArr.length > 0 && iArr[0] == 0) {
                b(this.i, this.j);
                i3 = 1;
            } else if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                new AlertDialog.Builder(this).setMessage("应用更新需要授予存储权限，请到设置中开启存储权限").setPositiveButton("确定", (DialogInterface.OnClickListener) null).setNegativeButton(WXModalUIModule.CANCEL, (DialogInterface.OnClickListener) null).create().show();
                i3 = 2;
            } else {
                new AlertDialog.Builder(this).setMessage("应用更新需要授予存储权限，请到设置中开启存储权限").setPositiveButton("确定", (DialogInterface.OnClickListener) null).create().show();
                i3 = 3;
            }
            boolean z2 = this.k;
            a(z2, 0, "", 0, "onRequestPermissionsResult", "" + i3);
        }
    }

    public void onResume() {
        super.onResume();
        a(this.c, IUIBridge.INTENT_ACTIVITY_CREATE, 1);
        a(0, "", "onResume", "onResume", false, this.k, 13);
    }
}
