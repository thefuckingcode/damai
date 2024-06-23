package cn.damai.commonbusiness.photoselect.imageselected.model;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.photoselect.imageselected.entry.Image;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tb.sm0;
import tb.xf2;

/* compiled from: Taobao */
public class ImageModel {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public interface DataCallback {
        void onSuccess(ArrayList<sm0> arrayList);
    }

    public static String getExtensionName(String str) {
        int lastIndexOf;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1032235778")) {
            return (String) ipChange.ipc$dispatch("-1032235778", new Object[]{str});
        }
        return (str == null || str.length() <= 0 || (lastIndexOf = str.lastIndexOf(46)) <= -1 || lastIndexOf >= str.length() - 1) ? "" : str.substring(lastIndexOf + 1);
    }

    private static sm0 getFolder(String str, List<sm0> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1721608094")) {
            return (sm0) ipChange.ipc$dispatch("-1721608094", new Object[]{str, list});
        }
        if (!list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                sm0 sm0 = list.get(i);
                if (str.equals(sm0.c())) {
                    return sm0;
                }
            }
        }
        sm0 sm02 = new sm0(str);
        list.add(sm02);
        return sm02;
    }

    public static String getFolderName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2076562905")) {
            return (String) ipChange.ipc$dispatch("-2076562905", new Object[]{str});
        } else if (!xf2.i(str)) {
            return "";
        } else {
            String[] split = str.split(File.separator);
            return split.length >= 2 ? split[split.length - 2] : "";
        }
    }

    public static void loadImageForSDCard(final Context context, final DataCallback dataCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1303227020")) {
            ipChange.ipc$dispatch("-1303227020", new Object[]{context, dataCallback});
            return;
        }
        new Thread(new Runnable() {
            /* class cn.damai.commonbusiness.photoselect.imageselected.model.ImageModel.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1522452902")) {
                    ipChange.ipc$dispatch("1522452902", new Object[]{this});
                    return;
                }
                Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "_data", "_display_name", "date_added", "_id"}, null, null, "date_added");
                ArrayList arrayList = new ArrayList();
                if (query != null) {
                    while (query.moveToNext()) {
                        Uri withAppendedId = ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, query.getLong(query.getColumnIndexOrThrow("_id")));
                        String string = query.getString(query.getColumnIndex("_data"));
                        String string2 = query.getString(query.getColumnIndex("_display_name"));
                        long j = query.getLong(query.getColumnIndex("date_added"));
                        if (!".downloading".equals(ImageModel.getExtensionName(string))) {
                            Image image = new Image(string, j, string2);
                            image.uri = withAppendedId;
                            arrayList.add(image);
                        }
                    }
                    query.close();
                }
                Collections.reverse(arrayList);
                dataCallback.onSuccess(ImageModel.splitFolder(context, arrayList));
            }
        }).start();
    }

    /* access modifiers changed from: private */
    public static ArrayList<sm0> splitFolder(Context context, ArrayList<Image> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2067732654")) {
            return (ArrayList) ipChange.ipc$dispatch("-2067732654", new Object[]{context, arrayList});
        }
        ArrayList<sm0> arrayList2 = new ArrayList<>();
        arrayList2.add(new sm0(context != null ? context.getResources().getString(R$string.damai_all_image) : "所有照片", arrayList));
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                String folderName = getFolderName(arrayList.get(i).getPath());
                if (xf2.i(folderName)) {
                    getFolder(folderName, arrayList2).a(arrayList.get(i));
                }
            }
        }
        return arrayList2;
    }
}
