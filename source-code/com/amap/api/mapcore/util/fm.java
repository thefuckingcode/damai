package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.amap.api.maps.offlinemap.OfflineMapManager;

/* compiled from: Taobao */
public class fm extends fn implements View.OnClickListener {
    private OfflineMapManager a;
    private View b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private int g;
    private String h;

    public fm(Context context, OfflineMapManager offlineMapManager) {
        super(context);
        this.a = offlineMapManager;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.fn
    public void a() {
        View a2 = fs.a(getContext(), 2130903041, null);
        this.b = a2;
        setContentView(a2);
        this.b.setOnClickListener(new View.OnClickListener() {
            /* class com.amap.api.mapcore.util.fm.AnonymousClass1 */

            public void onClick(View view) {
                fm.this.dismiss();
            }
        });
        this.c = (TextView) this.b.findViewById(2131165191);
        TextView textView = (TextView) this.b.findViewById(2131165192);
        this.d = textView;
        textView.setText("暂停下载");
        this.e = (TextView) this.b.findViewById(2131165193);
        this.f = (TextView) this.b.findViewById(2131165194);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
    }

    public void onClick(View view) {
        try {
            int id = view.getId();
            if (id == 2131165192) {
                int i = this.g;
                if (i == 0) {
                    this.d.setText("继续下载");
                    this.a.pause();
                } else if (i == 3 || i == -1 || i == 101 || i == 102 || i == 103) {
                    this.d.setText("暂停下载");
                    this.a.downloadByCityName(this.h);
                }
                dismiss();
            } else if (id == 2131165193) {
                if (!TextUtils.isEmpty(this.h)) {
                    this.a.remove(this.h);
                    dismiss();
                }
            } else if (id == 2131165194) {
                dismiss();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(int i, String str) {
        this.c.setText(str);
        if (i == 0) {
            this.d.setText("暂停下载");
            this.d.setVisibility(0);
            this.e.setText("取消下载");
        }
        if (i == 2) {
            this.d.setVisibility(8);
            this.e.setText("取消下载");
        } else if (i == -1 || i == 101 || i == 102 || i == 103) {
            this.d.setText("继续下载");
            this.d.setVisibility(0);
        } else if (i == 3) {
            this.d.setVisibility(0);
            this.d.setText("继续下载");
            this.e.setText("取消下载");
        } else if (i == 4) {
            this.e.setText("删除");
            this.d.setVisibility(8);
        }
        this.g = i;
        this.h = str;
    }
}
