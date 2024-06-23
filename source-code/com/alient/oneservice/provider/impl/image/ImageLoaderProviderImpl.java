package com.alient.oneservice.provider.impl.image;

import android.widget.ImageView;
import cn.damai.common.image.a;
import cn.damai.uikit.image.IImageLoader;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.ImageLoaderProvider;
import com.alient.oneservice.image.ImageTicket;
import com.alient.oneservice.image.SuccessEvent;

/* compiled from: Taobao */
public class ImageLoaderProviderImpl implements ImageLoaderProvider {
    @Override // com.alient.oneservice.image.ImageLoaderProvider
    public ImageTicket load(String str, final IImageSuccListener iImageSuccListener, final IImageFailListener iImageFailListener) {
        return new ImageTicketImpl(a.b().load(str, 0, 0, 0, 0, new IImageLoader.IImageSuccListener() {
            /* class com.alient.oneservice.provider.impl.image.ImageLoaderProviderImpl.AnonymousClass1 */

            @Override // cn.damai.uikit.image.IImageLoader.IImageSuccListener
            public void onSuccess(IImageLoader.b bVar) {
                SuccessEvent successEvent = new SuccessEvent();
                successEvent.bitmap = bVar.b;
                successEvent.drawable = bVar.a;
                iImageSuccListener.onSuccess(successEvent);
            }
        }, new IImageLoader.IImageFailListener() {
            /* class com.alient.oneservice.provider.impl.image.ImageLoaderProviderImpl.AnonymousClass2 */

            @Override // cn.damai.uikit.image.IImageLoader.IImageFailListener
            public void onFail(IImageLoader.a aVar) {
                FailEvent failEvent = new FailEvent();
                failEvent.resultCode = aVar.a;
                iImageFailListener.onFail(failEvent);
            }
        }));
    }

    @Override // com.alient.oneservice.image.ImageLoaderProvider
    public ImageTicket loadinto(String str, ImageView imageView) {
        return new ImageTicketImpl(a.b().loadinto(str, imageView));
    }

    @Override // com.alient.oneservice.image.ImageLoaderProvider
    public ImageTicket load(String str, int i, final IImageSuccListener iImageSuccListener, final IImageFailListener iImageFailListener) {
        return new ImageTicketImpl(a.b().load(str, i, 0, 0, 0, new IImageLoader.IImageSuccListener() {
            /* class com.alient.oneservice.provider.impl.image.ImageLoaderProviderImpl.AnonymousClass3 */

            @Override // cn.damai.uikit.image.IImageLoader.IImageSuccListener
            public void onSuccess(IImageLoader.b bVar) {
                SuccessEvent successEvent = new SuccessEvent();
                successEvent.bitmap = bVar.b;
                successEvent.drawable = bVar.a;
                iImageSuccListener.onSuccess(successEvent);
            }
        }, new IImageLoader.IImageFailListener() {
            /* class com.alient.oneservice.provider.impl.image.ImageLoaderProviderImpl.AnonymousClass4 */

            @Override // cn.damai.uikit.image.IImageLoader.IImageFailListener
            public void onFail(IImageLoader.a aVar) {
                FailEvent failEvent = new FailEvent();
                failEvent.resultCode = aVar.a;
                iImageFailListener.onFail(failEvent);
            }
        }));
    }

    @Override // com.alient.oneservice.image.ImageLoaderProvider
    public ImageTicket loadinto(String str, ImageView imageView, int i, int i2) {
        return new ImageTicketImpl(a.b().loadinto(str, imageView, i, i2));
    }
}
