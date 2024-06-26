package com.airbnb.lottie.animation.content;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@TargetApi(19)
/* compiled from: Taobao */
public class h implements GreedyContent, PathContent {
    private final Path a = new Path();
    private final Path b = new Path();
    private final Path c = new Path();
    private final String d;
    private final List<PathContent> e = new ArrayList();
    private final MergePaths f;

    /* compiled from: Taobao */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[MergePaths.MergePathsMode.values().length];
            a = iArr;
            iArr[MergePaths.MergePathsMode.MERGE.ordinal()] = 1;
            a[MergePaths.MergePathsMode.ADD.ordinal()] = 2;
            a[MergePaths.MergePathsMode.SUBTRACT.ordinal()] = 3;
            a[MergePaths.MergePathsMode.INTERSECT.ordinal()] = 4;
            a[MergePaths.MergePathsMode.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
        }
    }

    public h(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.d = mergePaths.b();
            this.f = mergePaths;
            return;
        }
        throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
    }

    private void a() {
        for (int i = 0; i < this.e.size(); i++) {
            this.c.addPath(this.e.get(i).getPath());
        }
    }

    @TargetApi(19)
    private void b(Path.Op op) {
        this.b.reset();
        this.a.reset();
        for (int size = this.e.size() - 1; size >= 1; size--) {
            PathContent pathContent = this.e.get(size);
            if (pathContent instanceof c) {
                c cVar = (c) pathContent;
                List<PathContent> c2 = cVar.c();
                for (int size2 = c2.size() - 1; size2 >= 0; size2--) {
                    Path path = c2.get(size2).getPath();
                    path.transform(cVar.d());
                    this.b.addPath(path);
                }
            } else {
                this.b.addPath(pathContent.getPath());
            }
        }
        PathContent pathContent2 = this.e.get(0);
        if (pathContent2 instanceof c) {
            c cVar2 = (c) pathContent2;
            List<PathContent> c3 = cVar2.c();
            for (int i = 0; i < c3.size(); i++) {
                Path path2 = c3.get(i).getPath();
                path2.transform(cVar2.d());
                this.a.addPath(path2);
            }
        } else {
            this.a.set(pathContent2.getPath());
        }
        this.c.op(this.a, this.b, op);
    }

    /* JADX WARNING: Removed duplicated region for block: B:2:0x0006  */
    @Override // com.airbnb.lottie.animation.content.GreedyContent
    public void absorbContent(ListIterator<Content> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
            while (listIterator.hasPrevious()) {
                while (listIterator.hasPrevious()) {
                }
            }
        }
        while (listIterator.hasPrevious()) {
            Content previous = listIterator.previous();
            if (previous instanceof PathContent) {
                this.e.add((PathContent) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.d;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        this.c.reset();
        if (this.f.c()) {
            return this.c;
        }
        int i = a.a[this.f.a().ordinal()];
        if (i == 1) {
            a();
        } else if (i == 2) {
            b(Path.Op.UNION);
        } else if (i == 3) {
            b(Path.Op.REVERSE_DIFFERENCE);
        } else if (i == 4) {
            b(Path.Op.INTERSECT);
        } else if (i == 5) {
            b(Path.Op.XOR);
        }
        return this.c;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < this.e.size(); i++) {
            this.e.get(i).setContents(list, list2);
        }
    }
}
