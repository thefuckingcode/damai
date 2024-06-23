package com.opensource.svgaplayer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.SoundPool;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.opensource.svgaplayer.proto.AudioEntity;
import com.opensource.svgaplayer.proto.MovieEntity;
import com.opensource.svgaplayer.proto.MovieParams;
import com.opensource.svgaplayer.proto.SpriteEntity;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.common.WXConfig;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref$IntRef;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.b32;
import tb.c32;
import tb.f32;
import tb.k21;
import tb.s22;
import tb.ur2;
import tb.w11;

/* compiled from: Taobao */
public final class SVGAVideoEntity {
    private boolean a = true;
    @NotNull
    private b32 b = new b32(0.0d, 0.0d, 0.0d, 0.0d);
    private int c = 15;
    private int d;
    @NotNull
    private List<f32> e = m.g();
    @NotNull
    private List<s22> f = m.g();
    @Nullable
    private SoundPool g;
    @NotNull
    private HashMap<String, Bitmap> h = new HashMap<>();
    private File i;
    @Nullable
    private MovieEntity j;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class a implements SoundPool.OnLoadCompleteListener {
        final /* synthetic */ Ref$IntRef a;
        final /* synthetic */ List b;
        final /* synthetic */ Function0 c;

        a(Ref$IntRef ref$IntRef, List list, SVGAVideoEntity sVGAVideoEntity, Function0 function0, MovieEntity movieEntity) {
            this.a = ref$IntRef;
            this.b = list;
            this.c = function0;
        }

        public final void onLoadComplete(SoundPool soundPool, int i, int i2) {
            Ref$IntRef ref$IntRef = this.a;
            int i3 = ref$IntRef.element + 1;
            ref$IntRef.element = i3;
            if (i3 >= this.b.size()) {
                this.c.invoke();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class b<T, U> implements BiConsumer<String, byte[]> {
        final /* synthetic */ HashMap a;

        b(HashMap hashMap) {
            this.a = hashMap;
        }

        /* renamed from: a */
        public final void accept(@NotNull String str, @NotNull byte[] bArr) {
            k21.j(str, "aKey");
            k21.j(bArr, "bytes");
            File createTempFile = File.createTempFile(str, ".mp3");
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            fileOutputStream.close();
            HashMap hashMap = this.a;
            k21.e(createTempFile, "tmpFile");
            hashMap.put(str, createTempFile);
        }
    }

    public SVGAVideoEntity(@NotNull JSONObject jSONObject, @NotNull File file) {
        k21.j(jSONObject, "obj");
        k21.j(file, WXConfig.cacheDir);
        this.i = file;
        JSONObject optJSONObject = jSONObject.optJSONObject("movie");
        if (optJSONObject != null) {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("viewBox");
            if (optJSONObject2 != null) {
                this.b = new b32(0.0d, 0.0d, optJSONObject2.optDouble("width", 0.0d), optJSONObject2.optDouble("height", 0.0d));
            }
            this.c = optJSONObject.optInt("fps", 20);
            this.d = optJSONObject.optInt("frames", 0);
        }
        l(jSONObject);
        n(jSONObject);
    }

    private final void j(MovieEntity movieEntity, Function0<ur2> function0) {
        SoundPool soundPool;
        HashMap hashMap;
        Set<Map.Entry<String, ByteString>> entrySet;
        List<AudioEntity> list = movieEntity.audios;
        if (list != null) {
            if (!(!list.isEmpty())) {
                list = null;
            }
            if (list != null) {
                Ref$IntRef ref$IntRef = new Ref$IntRef();
                ref$IntRef.element = 0;
                SoundPool soundPool2 = new SoundPool(Math.min(12, list.size()), 2, 0);
                HashMap hashMap2 = new HashMap();
                soundPool2.setOnLoadCompleteListener(new a(ref$IntRef, list, this, function0, movieEntity));
                HashMap hashMap3 = new HashMap();
                Map<String, ByteString> map = movieEntity.images;
                if (!(map == null || (entrySet = map.entrySet()) == null)) {
                    for (T t : entrySet) {
                        String str = (String) t.getKey();
                        byte[] byteArray = ((ByteString) t.getValue()).toByteArray();
                        if (byteArray.length >= 4) {
                            List<Byte> list2 = ArraysKt___ArraysKt.N(byteArray, new w11(0, 3));
                            if (list2.get(0).byteValue() == 73 && list2.get(1).byteValue() == 68 && list2.get(2).byteValue() == 51 && list2.get(3).byteValue() == 3) {
                                k21.e(str, "imageKey");
                                k21.e(byteArray, "byteArray");
                                hashMap3.put(str, byteArray);
                            }
                        }
                    }
                }
                if (hashMap3.size() > 0) {
                    hashMap3.forEach(new b(hashMap2));
                }
                ArrayList arrayList = new ArrayList(n.q(list, 10));
                for (T t2 : list) {
                    k21.e(t2, "audio");
                    s22 s22 = new s22(t2);
                    File file = (File) hashMap2.get(t2.audioKey);
                    if (file != null) {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        FileDescriptor fd = fileInputStream.getFD();
                        Integer num = t2.startTime;
                        double intValue = (double) (num != null ? num.intValue() : 0);
                        Integer num2 = t2.totalTime;
                        int intValue2 = num2 != null ? num2.intValue() : 0;
                        hashMap = hashMap2;
                        soundPool = soundPool2;
                        s22.f(Integer.valueOf(soundPool2.load(fd, (long) ((intValue / ((double) intValue2)) * ((double) fileInputStream.available())), (long) fileInputStream.available(), 1)));
                        fileInputStream.close();
                    } else {
                        hashMap = hashMap2;
                        soundPool = soundPool2;
                    }
                    arrayList.add(s22);
                    hashMap2 = hashMap;
                    soundPool2 = soundPool;
                }
                this.f = arrayList;
                this.g = soundPool2;
                return;
            }
        }
        function0.invoke();
    }

    private final void k(MovieEntity movieEntity) {
        Set<Map.Entry<String, ByteString>> entrySet;
        Bitmap decodeFile;
        Map<String, ByteString> map = movieEntity.images;
        if (!(map == null || (entrySet = map.entrySet()) == null)) {
            for (T t : entrySet) {
                String str = (String) t.getKey();
                c32.a().inPreferredConfig = Bitmap.Config.RGB_565;
                byte[] byteArray = ((ByteString) t.getValue()).toByteArray();
                if (byteArray.length >= 4) {
                    List<Byte> list = ArraysKt___ArraysKt.N(byteArray, new w11(0, 3));
                    if (list.get(0).byteValue() != 73 || list.get(1).byteValue() != 68 || list.get(2).byteValue() != 51 || list.get(3).byteValue() != 3) {
                        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, c32.a());
                        if (decodeByteArray != null) {
                            HashMap<String, Bitmap> hashMap = this.h;
                            k21.e(str, "imageKey");
                            hashMap.put(str, decodeByteArray);
                        } else {
                            String utf8 = ((ByteString) t.getValue()).utf8();
                            if (utf8 != null) {
                                String str2 = this.i.getAbsolutePath() + "/" + utf8;
                                String str3 = null;
                                Bitmap decodeFile2 = new File(str2).exists() ? BitmapFactory.decodeFile(str2, c32.a()) : null;
                                if (decodeFile2 != null) {
                                    this.h.put(str, decodeFile2);
                                } else {
                                    String str4 = this.i.getAbsolutePath() + "/" + str + ".png";
                                    if (str4 != null) {
                                        if (new File(str4).exists()) {
                                            str3 = str4;
                                        }
                                        if (!(str3 == null || (decodeFile = BitmapFactory.decodeFile(str3, c32.a())) == null)) {
                                            this.h.put(str, decodeFile);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private final void l(JSONObject jSONObject) {
        Bitmap decodeFile;
        JSONObject optJSONObject = jSONObject.optJSONObject("images");
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                c32.a().inPreferredConfig = Bitmap.Config.RGB_565;
                String str = this.i.getAbsolutePath() + "/" + optJSONObject.get(next);
                String str2 = null;
                Bitmap decodeFile2 = new File(str).exists() ? BitmapFactory.decodeFile(str, c32.a()) : null;
                if (decodeFile2 != null) {
                    this.h.put(next, decodeFile2);
                } else {
                    String str3 = this.i.getAbsolutePath() + "/" + next + ".png";
                    if (str3 != null) {
                        if (new File(str3).exists()) {
                            str2 = str3;
                        }
                        if (!(str2 == null || (decodeFile = BitmapFactory.decodeFile(str2, c32.a())) == null)) {
                            this.h.put(next, decodeFile);
                        }
                    }
                }
            }
        }
    }

    private final void m(MovieEntity movieEntity) {
        List<f32> list;
        List<SpriteEntity> list2 = movieEntity.sprites;
        if (list2 != null) {
            list = new ArrayList<>(n.q(list2, 10));
            for (T t : list2) {
                k21.e(t, AdvanceSetting.NETWORK_TYPE);
                list.add(new f32((SpriteEntity) t));
            }
        } else {
            list = m.g();
        }
        this.e = list;
    }

    private final void n(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("sprites");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    arrayList.add(new f32(optJSONObject));
                }
            }
        }
        this.e = CollectionsKt___CollectionsKt.y0(arrayList);
    }

    public final boolean a() {
        return this.a;
    }

    @NotNull
    public final List<s22> b() {
        return this.f;
    }

    public final int c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    @NotNull
    public final HashMap<String, Bitmap> e() {
        return this.h;
    }

    @Nullable
    public final SoundPool f() {
        return this.g;
    }

    @NotNull
    public final List<f32> g() {
        return this.e;
    }

    @NotNull
    public final b32 h() {
        return this.b;
    }

    public final void i(@NotNull Function0<ur2> function0) {
        k21.j(function0, WXBridgeManager.METHOD_CALLBACK);
        MovieEntity movieEntity = this.j;
        if (movieEntity != null) {
            j(movieEntity, new SVGAVideoEntity$prepare$$inlined$let$lambda$1(this, function0));
        }
    }

    public final void o(boolean z) {
        this.a = z;
    }

    public SVGAVideoEntity(@NotNull MovieEntity movieEntity, @NotNull File file) {
        k21.j(movieEntity, "obj");
        k21.j(file, WXConfig.cacheDir);
        this.j = movieEntity;
        this.i = file;
        MovieParams movieParams = movieEntity.params;
        if (movieParams != null) {
            Float f2 = movieParams.viewBoxWidth;
            float f3 = 0.0f;
            double floatValue = (double) (f2 != null ? f2.floatValue() : 0.0f);
            Float f4 = movieParams.viewBoxHeight;
            this.b = new b32(0.0d, 0.0d, floatValue, (double) (f4 != null ? f4.floatValue() : f3));
            Integer num = movieParams.fps;
            this.c = num != null ? num.intValue() : 20;
            Integer num2 = movieParams.frames;
            this.d = num2 != null ? num2.intValue() : 0;
        }
        try {
            k(movieEntity);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        m(movieEntity);
    }
}
