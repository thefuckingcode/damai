package com.sina.weibo.sdk.share;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.sina.weibo.sdk.api.VideoSourceObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.b.a;
import com.sina.weibo.sdk.b.b;
import com.sina.weibo.sdk.b.c;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Taobao */
public final class d extends AsyncTask<WeiboMultiMessage, Void, c> {
    private WeakReference<Context> B;
    private b C;

    public d(Context context, b bVar) {
        this.B = new WeakReference<>(context);
        this.C = bVar;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x005c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0096 A[Catch:{ all -> 0x0189 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x012d A[Catch:{ all -> 0x0189 }] */
    /* renamed from: a */
    public c doInBackground(WeiboMultiMessage... weiboMultiMessageArr) {
        WeiboMultiMessage weiboMultiMessage;
        Uri uri;
        boolean z;
        boolean z2;
        Context context = this.B.get();
        if (context == null || (weiboMultiMessage = weiboMultiMessageArr[0]) == null) {
            return null;
        }
        a.C0195a e = a.e(context);
        String str = e != null ? e.packageName : "";
        if (TextUtils.isEmpty(str)) {
            str = "com.sina.weibo";
        }
        c cVar = new c();
        try {
            if (!(weiboMultiMessage.imageObject == null || weiboMultiMessage.multiImageObject == null)) {
                weiboMultiMessage.imageObject = null;
            }
            if (!(weiboMultiMessage.videoSourceObject == null || (weiboMultiMessage.imageObject == null && weiboMultiMessage.multiImageObject == null))) {
                weiboMultiMessage.imageObject = null;
                weiboMultiMessage.multiImageObject = null;
            }
            if (weiboMultiMessage.multiImageObject != null) {
                ArrayList<Uri> arrayList = new ArrayList<>();
                Iterator<Uri> it = weiboMultiMessage.multiImageObject.getImageList().iterator();
                while (it.hasNext()) {
                    Uri next = it.next();
                    if (next != null) {
                        String a = b.a(context, next);
                        if (!TextUtils.isEmpty(a)) {
                            File file = new File(a);
                            if (!b.c(file)) {
                                String b = b.b(file);
                                if (!TextUtils.isEmpty(b) && b.startsWith("image/")) {
                                    z2 = true;
                                    if (!z2) {
                                        continue;
                                    } else if (Build.VERSION.SDK_INT >= 24) {
                                        arrayList.add(next);
                                        context.grantUriPermission(str, next, 1);
                                    } else {
                                        String a2 = a.a(context, next, 1);
                                        if (!TextUtils.isEmpty(a2)) {
                                            arrayList.add(Uri.fromFile(new File(a2)));
                                        } else {
                                            throw new IllegalArgumentException("image's path is null");
                                        }
                                    }
                                }
                            }
                            z2 = false;
                            if (!z2) {
                            }
                        } else {
                            throw new IllegalArgumentException("get image path is null");
                        }
                    }
                }
                weiboMultiMessage.multiImageObject.imageList = arrayList;
            }
            VideoSourceObject videoSourceObject = weiboMultiMessage.videoSourceObject;
            if (!(videoSourceObject == null || (uri = videoSourceObject.videoPath) == null)) {
                String a3 = b.a(context, uri);
                if (!TextUtils.isEmpty(a3)) {
                    File file2 = new File(a3);
                    if (!b.c(file2)) {
                        String str2 = "*/*";
                        String name = file2.getName();
                        int lastIndexOf = name.lastIndexOf(".");
                        if (lastIndexOf >= 0) {
                            String substring = name.substring(lastIndexOf);
                            if (!TextUtils.isEmpty(substring) || substring.length() >= 2) {
                                str2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(substring.substring(1).toLowerCase());
                            }
                        }
                        if (!TextUtils.isEmpty(str2) && str2.startsWith("video/")) {
                            z = true;
                            if (z) {
                                if (Build.VERSION.SDK_INT >= 24) {
                                    VideoSourceObject videoSourceObject2 = weiboMultiMessage.videoSourceObject;
                                    videoSourceObject2.videoPath = uri;
                                    videoSourceObject2.during = b.e(b.b(context, uri));
                                    context.grantUriPermission(str, weiboMultiMessage.videoSourceObject.videoPath, 1);
                                } else {
                                    String a4 = a.a(context, uri, 0);
                                    c.a("WBShareTag", "prepare video resource and video'path is".concat(String.valueOf(a4)));
                                    if (!TextUtils.isEmpty(a4)) {
                                        weiboMultiMessage.videoSourceObject.videoPath = Uri.fromFile(new File(a4));
                                        weiboMultiMessage.videoSourceObject.during = b.e(a4);
                                    } else {
                                        throw new IllegalArgumentException("video's path is null");
                                    }
                                }
                            }
                        }
                    }
                    z = false;
                    if (z) {
                    }
                } else {
                    throw new IllegalArgumentException("get video path is null");
                }
            }
            cVar.A = weiboMultiMessage;
            cVar.z = true;
        } catch (Throwable th) {
            cVar.z = false;
            String message = th.getMessage();
            if (TextUtils.isEmpty(message)) {
                message = th.toString();
            }
            cVar.errorMessage = message;
            c.b("WBShareTag", "prepare resource error is :".concat(String.valueOf(message)));
        }
        return cVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(c cVar) {
        c cVar2 = cVar;
        super.onPostExecute(cVar2);
        b bVar = this.C;
        if (bVar != null) {
            bVar.a(cVar2);
        }
    }

    /* access modifiers changed from: protected */
    public final void onPreExecute() {
        super.onPreExecute();
    }
}
