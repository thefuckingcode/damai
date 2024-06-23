package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.internal.view.SupportMenu;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.DownloadProgressView;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;

/* compiled from: Taobao */
public class fo implements View.OnClickListener {
    private int a = 0;
    private Context b;
    private TextView c;
    private TextView d;
    private ImageView e;
    private TextView f;
    private OfflineMapManager g;
    private OfflineMapCity h;
    private boolean i = false;
    private Handler j = new Handler() {
        /* class com.amap.api.mapcore.util.fo.AnonymousClass1 */

        public void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                fo.this.a(message.arg1, message.arg2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private View k;
    private DownloadProgressView l;

    public fo(Context context, OfflineMapManager offlineMapManager) {
        this.b = context;
        b();
        this.g = offlineMapManager;
    }

    private void b() {
        View a2 = fs.a(this.b, 2130903042, null);
        this.k = a2;
        this.l = (DownloadProgressView) a2.findViewById(2131165200);
        this.c = (TextView) this.k.findViewById(2131165195);
        this.d = (TextView) this.k.findViewById(2131165199);
        this.e = (ImageView) this.k.findViewById(2131165198);
        this.f = (TextView) this.k.findViewById(2131165197);
        this.e.setOnClickListener(this);
    }

    private void c() {
        this.f.setVisibility(8);
        this.e.setVisibility(0);
        this.e.setImageResource(2130837506);
    }

    private void d() {
        this.f.setVisibility(0);
        this.e.setVisibility(0);
        this.e.setImageResource(2130837506);
        this.f.setText("已下载-有更新");
    }

    private void e() {
        this.f.setVisibility(0);
        this.e.setVisibility(8);
        this.f.setTextColor(SupportMenu.CATEGORY_MASK);
        this.f.setText("下载出现异常");
    }

    private void f() {
        this.f.setVisibility(0);
        this.e.setVisibility(8);
        this.f.setText("已下载");
        this.f.setTextColor(Color.parseColor("#898989"));
    }

    private synchronized void g() {
        this.g.pause();
        this.g.restart();
    }

    private synchronized boolean h() {
        try {
            this.g.downloadByCityName(this.h.getCity());
        } catch (AMapException e2) {
            e2.printStackTrace();
            Toast.makeText(this.b, e2.getErrorMessage(), 0).show();
            return false;
        }
        return true;
    }

    public void onClick(View view) {
        try {
            if (!eq.d(this.b)) {
                Toast.makeText(this.b, "无网络连接", 0).show();
                return;
            }
            OfflineMapCity offlineMapCity = this.h;
            if (offlineMapCity != null) {
                int state = offlineMapCity.getState();
                int i2 = this.h.getcompleteCode();
                if (state == 0) {
                    g();
                    c(i2);
                } else if (state != 1 && state != 4) {
                    if (h()) {
                        b(i2);
                    } else {
                        e();
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(int i2, int i3) throws Exception {
        if (this.a != 2 || i3 <= 3 || i3 >= 100) {
            this.l.setVisibility(8);
        } else {
            this.l.setVisibility(0);
            this.l.setProgress(i3);
        }
        if (i2 == -1) {
            e();
        } else if (i2 != 0) {
            if (i2 == 1) {
                d(i3);
            } else if (i2 == 2) {
                b(i3);
            } else if (i2 == 3) {
                c(i3);
            } else if (i2 == 4) {
                f();
            } else if (i2 == 6) {
                c();
            } else if (i2 != 7) {
                switch (i2) {
                    case 101:
                    case 102:
                    case 103:
                        e();
                        return;
                    default:
                        return;
                }
            } else {
                d();
            }
        } else if (this.a == 1) {
            this.e.setVisibility(8);
            this.f.setText("下载中");
            this.f.setTextColor(Color.parseColor("#4287ff"));
        } else {
            e(i3);
        }
    }

    private void c(int i2) {
        this.f.setVisibility(0);
        this.e.setVisibility(8);
        this.f.setTextColor(-7829368);
        this.f.setText("暂停");
    }

    private void d(int i2) {
        if (this.a != 1) {
            this.f.setVisibility(0);
            this.e.setVisibility(8);
            this.f.setText("解压中");
            this.f.setTextColor(Color.parseColor("#898989"));
        }
    }

    private void e(int i2) {
        if (this.h != null) {
            this.f.setVisibility(0);
            this.f.setText("下载中");
            this.e.setVisibility(8);
            this.f.setTextColor(Color.parseColor("#4287ff"));
        }
    }

    private void b(int i2) {
        if (this.a == 1) {
            this.e.setVisibility(8);
            this.f.setVisibility(0);
            this.f.setText("等待中");
            this.f.setTextColor(Color.parseColor("#4287ff"));
            return;
        }
        this.f.setVisibility(0);
        this.e.setVisibility(8);
        this.f.setTextColor(Color.parseColor("#4287ff"));
        this.f.setText("等待中");
    }

    public void a(int i2) {
        this.a = i2;
    }

    public View a() {
        return this.k;
    }

    public void a(OfflineMapCity offlineMapCity) {
        if (offlineMapCity != null) {
            this.h = offlineMapCity;
            this.c.setText(offlineMapCity.getCity());
            TextView textView = this.d;
            textView.setText(String.valueOf(((double) ((int) (((((double) offlineMapCity.getSize()) / 1024.0d) / 1024.0d) * 100.0d))) / 100.0d) + " M");
            a(this.h.getState(), this.h.getcompleteCode(), this.i);
        }
    }

    private void a(int i2, int i3, boolean z) {
        OfflineMapCity offlineMapCity = this.h;
        if (offlineMapCity != null) {
            offlineMapCity.setState(i2);
            this.h.setCompleteCode(i3);
        }
        Message message = new Message();
        message.arg1 = i2;
        message.arg2 = i3;
        this.j.sendMessage(message);
    }
}
