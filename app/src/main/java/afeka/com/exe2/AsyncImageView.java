package afeka.com.exe2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by bennya on 23/03/2018.
 */

public class AsyncImageView {
    ImageView imageView;
    String url;

    public AsyncImageView(ImageView imgView){
        this.imageView = imgView;
    }

    public AsyncImageView(ImageView imgView,String url){
        this.imageView = imgView;
        this.url = url;
        getBitmapFromUrl();
    }

    private void getBitmapFromUrl(){
        if (this.url == null) return;;

        //thread
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                final Bitmap bitmap = null;
//                imageView.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        imageView.setImageBitmap(bitmap);
//                    }
//                });
//            }
//        });
        /*---------------------------------------------------------------*/
        //asynctask
        AsyncTask<String,Void,Bitmap> task = new AsyncTask<String, Void, Bitmap>() {

            @Override
            protected Bitmap doInBackground(String... strings) {
                String imageURL = strings[0];
                try {
                    InputStream input = new URL(imageURL).openStream();
                    // Decode Bitmap
                    Bitmap bitmap = BitmapFactory.decodeStream(input);
                    return bitmap;
                }catch (Exception ex){
                    Log.e("AsyncImageView",ex.getMessage());
                }
                return null;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                super.onPostExecute(bitmap);
                imageView.setImageBitmap(bitmap);
            }
        };
        task.execute(url);

    }

    public void loadUrl(String url){
        this.url = url;
        getBitmapFromUrl();
    }

    public void refresh(){

    }


}
