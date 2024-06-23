package cn.damai.commonbusiness.seatbiz.seat.common.bean.region;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: Taobao */
public class Region implements Serializable {
    public String color;
    public boolean flag = false;
    public long id;
    public String imaggeurl;
    public String name;
    public ArrayList<Long> priceLevelIdList = new ArrayList<>();
    public HashMap<String, String> rainbowColorList = new HashMap<>();
    public ArrayList<RegionLocation> regionLocationList;
    public int state;
    public String vid;
}
