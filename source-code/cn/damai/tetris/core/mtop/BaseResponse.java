package cn.damai.tetris.core.mtop;

import android.os.SystemClock;
import cn.damai.tetris.core.BaseLayer;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: Taobao */
public class BaseResponse implements Serializable {
    public String args;
    public GlobalConfig globalConfig;
    public boolean isShowJuli;
    public ArrayList<BaseLayer> layers;
    public int nearByCityListSize = 0;
    public long requestFinishTime = SystemClock.elapsedRealtime();
    public long serverTime;
}
