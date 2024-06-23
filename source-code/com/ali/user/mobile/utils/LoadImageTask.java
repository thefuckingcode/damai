package com.ali.user.mobile.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.ListView;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: Taobao */
public class LoadImageTask extends AsyncTask<String, Void, Bitmap> {
    private boolean forceRefreshCache = false;
    private Context mContext;
    private String mImageUrl;
    private ImageView mImageView;
    private int mLimitSize = 160;
    private ListView mListView;
    private String mTargetDir;

    public LoadImageTask(Context context, ImageView imageView, String str, int i) {
        this.mContext = context;
        this.mImageView = imageView;
        this.mTargetDir = str;
        this.mLimitSize = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00ac A[SYNTHETIC, Splitter:B:60:0x00ac] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00c9 A[SYNTHETIC, Splitter:B:70:0x00c9] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d1 A[Catch:{ IOException -> 0x00cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00d6 A[SYNTHETIC, Splitter:B:77:0x00d6] */
    /* JADX WARNING: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    private void downloadImage(String str) {
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        HttpURLConnection httpURLConnection;
        Exception e;
        BufferedInputStream bufferedInputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(15000);
                if (httpURLConnection.getResponseCode() == 200) {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
                    try {
                        File file = new File(getImagePath(str));
                        if (file.exists()) {
                            file.delete();
                        }
                        try {
                            file.createNewFile();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                        try {
                            byte[] bArr = new byte[8192];
                            while (true) {
                                int read = bufferedInputStream2.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                bufferedOutputStream.write(bArr, 0, read);
                                bufferedOutputStream.flush();
                            }
                            bufferedInputStream = bufferedInputStream2;
                        } catch (Exception e3) {
                            e = e3;
                            bufferedInputStream = bufferedInputStream2;
                            try {
                                e.printStackTrace();
                                if (bufferedInputStream != null) {
                                }
                                if (bufferedOutputStream != null) {
                                }
                                if (httpURLConnection == null) {
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                        throw th;
                                    }
                                }
                                if (bufferedOutputStream != null) {
                                    bufferedOutputStream.close();
                                }
                                if (httpURLConnection != null) {
                                    try {
                                        if (httpURLConnection.getInputStream() != null) {
                                            httpURLConnection.getInputStream().close();
                                        }
                                    } catch (Throwable th3) {
                                        th3.printStackTrace();
                                    }
                                    httpURLConnection.disconnect();
                                }
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            bufferedInputStream = bufferedInputStream2;
                            if (bufferedInputStream != null) {
                            }
                            if (bufferedOutputStream != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            throw th;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        bufferedOutputStream = null;
                        bufferedInputStream = bufferedInputStream2;
                        e.printStackTrace();
                        if (bufferedInputStream != null) {
                        }
                        if (bufferedOutputStream != null) {
                        }
                        if (httpURLConnection == null) {
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedOutputStream = null;
                        bufferedInputStream = bufferedInputStream2;
                        if (bufferedInputStream != null) {
                        }
                        if (bufferedOutputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        throw th;
                    }
                } else {
                    bufferedOutputStream = null;
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                        return;
                    }
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                try {
                    if (httpURLConnection.getInputStream() != null) {
                        httpURLConnection.getInputStream().close();
                    }
                } catch (Throwable th6) {
                    th6.printStackTrace();
                }
                httpURLConnection.disconnect();
            } catch (Exception e7) {
                e = e7;
                bufferedOutputStream = null;
                e.printStackTrace();
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (httpURLConnection == null) {
                    try {
                        if (httpURLConnection.getInputStream() != null) {
                            httpURLConnection.getInputStream().close();
                        }
                    } catch (Throwable th7) {
                        th7.printStackTrace();
                    }
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th8) {
                th = th8;
                bufferedOutputStream = null;
                if (bufferedInputStream != null) {
                }
                if (bufferedOutputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                throw th;
            }
        } catch (Exception e8) {
            e = e8;
            httpURLConnection = null;
            bufferedOutputStream = null;
            e.printStackTrace();
            if (bufferedInputStream != null) {
            }
            if (bufferedOutputStream != null) {
            }
            if (httpURLConnection == null) {
            }
        } catch (Throwable th9) {
            th = th9;
            httpURLConnection = null;
            bufferedOutputStream = null;
            if (bufferedInputStream != null) {
            }
            if (bufferedOutputStream != null) {
            }
            if (httpURLConnection != null) {
            }
            throw th;
        }
    }

    private String getImagePath(String str) {
        String str2 = this.mContext.getCacheDir().getPath() + "/" + this.mTargetDir + "/";
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str2 + MD5Util.getMD5(str);
    }

    private Bitmap loadImage(String str) {
        Bitmap decodeSampledBitmapFromResource;
        File file = new File(getImagePath(str));
        if (!file.exists() || this.forceRefreshCache) {
            downloadImage(str);
        }
        if (str == null || (decodeSampledBitmapFromResource = ImageUtil.decodeSampledBitmapFromResource(file.getAbsolutePath(), this.mLimitSize)) == null) {
            return null;
        }
        return decodeSampledBitmapFromResource;
    }

    /* access modifiers changed from: protected */
    public Bitmap doInBackground(String... strArr) {
        String str = strArr[0];
        this.mImageUrl = str;
        return loadImage(str);
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Bitmap bitmap) {
        ImageView imageView;
        if (bitmap != null) {
            ImageView imageView2 = this.mImageView;
            if (imageView2 != null) {
                imageView2.setImageBitmap(bitmap);
            }
            ListView listView = this.mListView;
            if (listView != null && (imageView = (ImageView) listView.findViewWithTag(this.mImageUrl)) != null) {
                imageView.setImageBitmap(bitmap);
            }
        }
    }

    public LoadImageTask(Context context, ListView listView, String str, int i, boolean z) {
        this.mContext = context;
        this.mListView = listView;
        this.mTargetDir = str;
        this.mLimitSize = i;
        this.forceRefreshCache = z;
    }
}
