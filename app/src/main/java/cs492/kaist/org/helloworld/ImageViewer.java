package cs492.kaist.org.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;


import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by Jaehyun Jang on 12/27/2015.
 */
public class ImageViewer extends Activity {
    PhotoViewAttacher mAttacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_viewer);
        Intent myIntent = getIntent();

        String url = myIntent.getStringExtra("url");
        final ImageView imageView = (ImageView) findViewById(R.id.image_viewer);
        mAttacher = new PhotoViewAttacher(imageView);

        Callback imageLoadedCallback = new Callback() {
            @Override
            public void onSuccess() {
                if(mAttacher != null)
                    mAttacher.update();
                else
                    mAttacher = new PhotoViewAttacher(imageView);
            }

            @Override
            public void onError() {

            }
        };
        Picasso.with(this).load(url).fit().centerInside().into(imageView, imageLoadedCallback);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
