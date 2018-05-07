package space.bestysh.scanner.yshscanner;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

import space.bestysh.scanner.Scanner;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        ImageView tv = (ImageView) findViewById(R.id.sample_text);
        Bitmap image = null;
        AssetManager am = getResources().getAssets();
        try
        {
            InputStream is = am.open("test7.jpg");
            image = BitmapFactory.decodeStream(is);
            is.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


        Scanner scanner=new Scanner();
        //Bitmap result=scanner.scannerCrop(image);
        float[] test=scanner.scannerCropPoint(image);
        Bitmap result=scanner.scannerPointTransform(image,test);

        Log.d("ysh","test");
        Log.d("ysh",String.valueOf(test[0]));

        tv.setImageBitmap(result);

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
