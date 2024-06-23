package com.youku.live.dago.widgetlib.view.usercard;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class UserCardVideoList implements Serializable {
    public long dateTimestamp = 0;
    public boolean hasNext = false;
    public List<UserCardVideo> itemList;
    public int offset = 0;
}
