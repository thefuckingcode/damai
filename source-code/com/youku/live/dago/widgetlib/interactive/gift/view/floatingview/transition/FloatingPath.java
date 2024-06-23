package com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class FloatingPath {
    private static transient /* synthetic */ IpChange $ipChange;
    private Path mPath;
    private PathMeasure mPathMeasure;

    protected FloatingPath() {
        this.mPath = new Path();
    }

    public static FloatingPath create(Path path, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "670457708")) {
            return (FloatingPath) ipChange.ipc$dispatch("670457708", new Object[]{path, Boolean.valueOf(z)});
        }
        FloatingPath floatingPath = new FloatingPath(path);
        floatingPath.mPathMeasure = new PathMeasure(path, z);
        return floatingPath;
    }

    public Path getPath() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "313907008")) {
            return this.mPath;
        }
        return (Path) ipChange.ipc$dispatch("313907008", new Object[]{this});
    }

    public PathMeasure getPathMeasure() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1094097468")) {
            return this.mPathMeasure;
        }
        return (PathMeasure) ipChange.ipc$dispatch("1094097468", new Object[]{this});
    }

    protected FloatingPath(Path path) {
        this.mPath = path;
    }
}
