package com.sina.weibo.sdk.api;

import android.os.Bundle;
import java.io.Serializable;

/* compiled from: Taobao */
public class WeiboMultiMessage implements Serializable {
    private static final long serialVersionUID = -3336491646257094828L;
    public ImageObject imageObject;
    public MediaObject mediaObject;
    public MultiImageObject multiImageObject;
    public SuperGroupObject superGroupObject;
    public TextObject textObject;
    public VideoSourceObject videoSourceObject;

    public void readFromBundle(Bundle bundle) {
        this.mediaObject = (MediaObject) bundle.getParcelable("_weibo_message_media");
        this.textObject = (TextObject) bundle.getParcelable("_weibo_message_text");
        this.imageObject = (ImageObject) bundle.getParcelable("_weibo_message_image");
        this.multiImageObject = (MultiImageObject) bundle.getParcelable("_weibo_message_multi_image");
        this.videoSourceObject = (VideoSourceObject) bundle.getParcelable("_weibo_message_video_source");
        this.superGroupObject = (SuperGroupObject) bundle.getParcelable("_weibo_message_supergroup");
    }

    public Bundle writeToBundle(Bundle bundle) {
        MediaObject mediaObject2 = this.mediaObject;
        if (mediaObject2 != null) {
            bundle.putParcelable("_weibo_message_media", mediaObject2);
        } else {
            bundle.putParcelable("_weibo_message_media", null);
        }
        TextObject textObject2 = this.textObject;
        if (textObject2 != null) {
            bundle.putParcelable("_weibo_message_text", textObject2);
        } else {
            bundle.putParcelable("_weibo_message_text", null);
        }
        ImageObject imageObject2 = this.imageObject;
        if (imageObject2 != null) {
            bundle.putParcelable("_weibo_message_image", imageObject2);
        } else {
            bundle.putParcelable("_weibo_message_image", null);
        }
        MultiImageObject multiImageObject2 = this.multiImageObject;
        if (multiImageObject2 != null) {
            bundle.putParcelable("_weibo_message_multi_image", multiImageObject2);
        } else {
            bundle.putParcelable("_weibo_message_multi_image", null);
        }
        VideoSourceObject videoSourceObject2 = this.videoSourceObject;
        if (videoSourceObject2 != null) {
            bundle.putParcelable("_weibo_message_video_source", videoSourceObject2);
        } else {
            bundle.putParcelable("_weibo_message_video_source", null);
        }
        SuperGroupObject superGroupObject2 = this.superGroupObject;
        if (superGroupObject2 != null) {
            bundle.putParcelable("_weibo_message_supergroup", superGroupObject2);
        } else {
            bundle.putParcelable("_weibo_message_supergroup", null);
        }
        return bundle;
    }
}
