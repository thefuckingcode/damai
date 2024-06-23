package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.h;
import com.airbnb.lottie.model.layer.a;
import tb.o91;

/* compiled from: Taobao */
public class MergePaths implements ContentModel {
    private final String a;
    private final MergePathsMode b;
    private final boolean c;

    /* compiled from: Taobao */
    public enum MergePathsMode {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static MergePathsMode forId(int i) {
            if (i == 1) {
                return MERGE;
            }
            if (i == 2) {
                return ADD;
            }
            if (i == 3) {
                return SUBTRACT;
            }
            if (i == 4) {
                return INTERSECT;
            }
            if (i != 5) {
                return MERGE;
            }
            return EXCLUDE_INTERSECTIONS;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode, boolean z) {
        this.a = str;
        this.b = mergePathsMode;
        this.c = z;
    }

    public MergePathsMode a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public boolean c() {
        return this.c;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    @Nullable
    public Content toContent(LottieDrawable lottieDrawable, a aVar) {
        if (lottieDrawable.enableMergePathsForKitKatAndAbove()) {
            return new h(this);
        }
        o91.c("Animation contains merge paths but they are disabled.");
        return null;
    }

    public String toString() {
        return "MergePaths{mode=" + this.b + '}';
    }
}
