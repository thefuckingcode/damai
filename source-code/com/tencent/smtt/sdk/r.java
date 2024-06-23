package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import com.tencent.smtt.export.external.DexLoader;

/* access modifiers changed from: package-private */
/* compiled from: TbsVideoView */
public class r extends FrameLayout implements MediaPlayer.OnErrorListener {
    private Object a;
    private t b;
    private VideoView c;
    private Context d = null;
    private String e;

    public r(Context context) {
        super(context.getApplicationContext());
        this.d = context;
    }

    /* access modifiers changed from: package-private */
    public void a(Bundle bundle, Object obj) {
        b(bundle, obj);
    }

    private void b(Bundle bundle, Object obj) {
        boolean z;
        a();
        if (b()) {
            bundle.putInt("callMode", bundle.getInt("callMode"));
            z = this.b.a(this.a, bundle, this, obj);
        } else {
            z = false;
        }
        if (!z) {
            VideoView videoView = this.c;
            if (videoView != null) {
                videoView.stopPlayback();
            }
            if (this.c == null) {
                this.c = new VideoView(getContext());
            }
            String string = bundle.getString("videoUrl");
            this.e = string;
            this.c.setVideoURI(Uri.parse(string));
            this.c.setOnErrorListener(this);
            Intent intent = new Intent("com.tencent.smtt.tbs.video.PLAY");
            intent.addFlags(268435456);
            Context applicationContext = getContext().getApplicationContext();
            intent.setPackage(applicationContext.getPackageName());
            applicationContext.startActivity(intent);
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        setBackgroundColor(-16777216);
        if (this.b == null) {
            d.a(true).a(getContext().getApplicationContext(), false, false);
            s a2 = d.a(true).a();
            DexLoader dexLoader = null;
            if (a2 != null) {
                dexLoader = a2.b();
            }
            if (dexLoader != null && QbSdk.canLoadVideo(getContext())) {
                this.b = new t(dexLoader);
            }
        }
        t tVar = this.b;
        if (tVar != null && this.a == null) {
            this.a = tVar.a(getContext().getApplicationContext());
        }
    }

    public boolean b() {
        return (this.b == null || this.a == null) ? false : true;
    }

    public void a(Activity activity) {
        VideoView videoView;
        if (!b() && (videoView = this.c) != null) {
            if (videoView.getParent() == null) {
                Window window = activity.getWindow();
                FrameLayout frameLayout = (FrameLayout) window.getDecorView();
                window.addFlags(1024);
                window.addFlags(128);
                frameLayout.setBackgroundColor(-16777216);
                MediaController mediaController = new MediaController(activity);
                mediaController.setMediaPlayer(this.c);
                this.c.setMediaController(mediaController);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 17;
                frameLayout.addView(this.c, layoutParams);
            }
            if (Build.VERSION.SDK_INT >= 8) {
                this.c.start();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Activity activity, int i) {
        VideoView videoView;
        VideoView videoView2;
        if (i == 3 && !b() && (videoView2 = this.c) != null) {
            videoView2.pause();
        }
        if (i == 4) {
            this.d = null;
            if (!b() && (videoView = this.c) != null) {
                videoView.stopPlayback();
                this.c = null;
            }
        }
        if (i == 2 && !b()) {
            this.d = activity;
            a(activity);
        }
        if (b()) {
            this.b.a(this.a, activity, i);
        }
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        try {
            Context context = this.d;
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing()) {
                    activity.finish();
                }
            }
            Context context2 = getContext();
            if (context2 != null) {
                Toast.makeText(context2, "播放失败，请选择其它播放器播放", 1).show();
                Context applicationContext = context2.getApplicationContext();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(268435456);
                intent.setDataAndType(Uri.parse(this.e), "video/*");
                applicationContext.startActivity(intent);
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void c() {
        if (b()) {
            this.b.a(this.a);
        }
    }
}
