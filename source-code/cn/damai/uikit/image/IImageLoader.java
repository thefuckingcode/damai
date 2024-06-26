package cn.damai.uikit.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* compiled from: Taobao */
public interface IImageLoader {

    /* compiled from: Taobao */
    public interface IImageFailListener {
        void onFail(a aVar);
    }

    /* compiled from: Taobao */
    public interface IImageSuccListener {
        void onSuccess(b bVar);
    }

    /* compiled from: Taobao */
    public interface ImageTicket {
        void cancel();
    }

    /* compiled from: Taobao */
    public static class a {
        public int a;
    }

    /* compiled from: Taobao */
    public static class b {
        public Drawable a;
        public Bitmap b;
    }

    ImageTicket load(String str, int i, int i2, int i3, int i4, IImageSuccListener iImageSuccListener, IImageFailListener iImageFailListener);

    ImageTicket load(String str, int i, int i2, IImageSuccListener iImageSuccListener, IImageFailListener iImageFailListener);

    void load(String str, int i, int i2, int i3, IImageSuccListener iImageSuccListener, IImageFailListener iImageFailListener);

    void load(String str, int i, IImageSuccListener iImageSuccListener, IImageFailListener iImageFailListener);

    ImageTicket loadinto(String str, ImageView imageView);

    ImageTicket loadinto(String str, ImageView imageView, int i, int i2);
}
