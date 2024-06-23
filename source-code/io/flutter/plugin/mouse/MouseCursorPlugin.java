package io.flutter.plugin.mouse;

import android.annotation.TargetApi;
import android.view.PointerIcon;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.taobao.weex.ui.component.WXBasicComponentType;
import com.taobao.weex.ui.view.gesture.WXGesture;
import io.flutter.embedding.engine.systemchannels.MouseCursorChannel;
import java.util.HashMap;
import tb.by0;

@RequiresApi(24)
@TargetApi(24)
/* compiled from: Taobao */
public class MouseCursorPlugin {
    @NonNull
    private static HashMap<String, Integer> systemCursorConstants;
    @NonNull
    private final MouseCursorViewDelegate mView;
    @NonNull
    private final MouseCursorChannel mouseCursorChannel;

    /* compiled from: Taobao */
    public interface MouseCursorViewDelegate {
        PointerIcon getSystemPointerIcon(int i);

        void setPointerIcon(@NonNull PointerIcon pointerIcon);
    }

    public MouseCursorPlugin(@NonNull MouseCursorViewDelegate mouseCursorViewDelegate, @NonNull MouseCursorChannel mouseCursorChannel2) {
        this.mView = mouseCursorViewDelegate;
        this.mouseCursorChannel = mouseCursorChannel2;
        mouseCursorChannel2.setMethodHandler(new MouseCursorChannel.MouseCursorMethodHandler() {
            /* class io.flutter.plugin.mouse.MouseCursorPlugin.AnonymousClass1 */

            @Override // io.flutter.embedding.engine.systemchannels.MouseCursorChannel.MouseCursorMethodHandler
            public void activateSystemCursor(@NonNull String str) {
                MouseCursorPlugin.this.mView.setPointerIcon(MouseCursorPlugin.this.resolveSystemCursor(str));
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private PointerIcon resolveSystemCursor(@NonNull String str) {
        if (systemCursorConstants == null) {
            systemCursorConstants = new HashMap<String, Integer>() {
                /* class io.flutter.plugin.mouse.MouseCursorPlugin.AnonymousClass2 */
                private static final long serialVersionUID = 1;

                {
                    put("alias", 1010);
                    put("allScroll", 1013);
                    put("basic", 1000);
                    put(WXBasicComponentType.CELL, 1006);
                    put("click", 1002);
                    put("contextMenu", 1001);
                    put(by0.ARG_COPY, 1011);
                    put("forbidden", 1012);
                    put("grab", 1020);
                    put("grabbing", 1021);
                    put("help", 1003);
                    put(WXGesture.MOVE, 1013);
                    put("none", 0);
                    put("noDrop", 1012);
                    put("precise", 1007);
                    put("text", 1008);
                    put("resizeColumn", 1014);
                    put("resizeDown", 1015);
                    put("resizeUpLeft", 1016);
                    put("resizeDownRight", 1017);
                    put("resizeLeft", 1014);
                    put("resizeLeftRight", 1014);
                    put("resizeRight", 1014);
                    put("resizeRow", 1015);
                    put("resizeUp", 1015);
                    put("resizeUpDown", 1015);
                    put("resizeUpLeft", 1017);
                    put("resizeUpRight", 1016);
                    put("resizeUpLeftDownRight", 1017);
                    put("resizeUpRightDownLeft", 1016);
                    put("verticalText", 1009);
                    put("wait", 1004);
                    put("zoomIn", 1018);
                    put("zoomOut", 1019);
                }
            };
        }
        return this.mView.getSystemPointerIcon(systemCursorConstants.getOrDefault(str, 1000).intValue());
    }

    public void destroy() {
        this.mouseCursorChannel.setMethodHandler(null);
    }
}
