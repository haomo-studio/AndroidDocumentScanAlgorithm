package space.bestysh.scanner;

import android.graphics.Bitmap;

/**
 * Created by ysh on 17-11-25.
 */

public class Scanner {
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("scanner");
    }

    public native Bitmap scannerCrop(Bitmap img);

    public native float[] scannerCropPoint(Bitmap img);

    public native Bitmap scannerPointTransform(Bitmap img,float[] points);

}
