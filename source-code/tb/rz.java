package tb;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;

/* compiled from: Taobao */
public class rz implements View.OnTouchListener {
    private DXRecyclerLayout a;
    GestureDetector b = new GestureDetector(DinamicXEngine.i(), new a());

    /* compiled from: Taobao */
    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        public void onLongPress(MotionEvent motionEvent) {
            if (rz.this.a != null) {
                rz.this.a.postEvent(new lx(-6544685697300501093L));
            }
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (rz.this.a != null) {
                rz.this.a.postEvent(new lx(18903999933159L));
            }
            return super.onSingleTapUp(motionEvent);
        }
    }

    public rz(DXRecyclerLayout dXRecyclerLayout) {
        this.a = dXRecyclerLayout;
    }

    public void b(DXRecyclerLayout dXRecyclerLayout) {
        this.a = dXRecyclerLayout;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.b.onTouchEvent(motionEvent);
        return false;
    }
}
