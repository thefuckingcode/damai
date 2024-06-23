package tb;

import androidx.annotation.Nullable;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.f;
import com.caverock.ext.SVGTransform;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: Taobao */
public class o32 {
    @Nullable
    public f a(InputStream inputStream, boolean z) {
        if (inputStream == null) {
            return null;
        }
        if (z) {
            try {
                inputStream = new ByteArrayInputStream(js1.h(inputStream).getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            inputStream.reset();
            float a = SVGTransform.a(inputStream);
            inputStream.reset();
            f fVar = new f(SVG.h(inputStream));
            fVar.u(a);
            try {
                inputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return fVar;
        } catch (Exception e3) {
            e3.printStackTrace();
            try {
                inputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            return null;
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            throw th;
        }
    }
}
