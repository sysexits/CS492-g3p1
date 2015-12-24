package cs492.kaist.org.helloworld;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

/**
 * Created by Jaehyun Jang on 12/24/2015.
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder>{
    private List<ImageInfo> imageList;

    public ImageAdapter(List<ImageInfo> imageList) {
        this.imageList = imageList;
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    @Override
    public void onBindViewHolder(ImageViewHolder imageViewHolder, int i) {
        ImageInfo ii = imageList.get(i);
        Drawable image = LoadImageFromUrl(ii.url);

        System.out.println(ii.url + " " + ii.uploader);

        imageViewHolder.vImage.setImageDrawable(image);
        imageViewHolder.vUploader.setText(ii.uploader);
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.img_cardview, viewGroup, false);
        CardView cardView = (CardView) itemView;
        cardView.setPreventCornerOverlap(false);
        return new ImageViewHolder(itemView);
    }


    public static Drawable LoadImageFromUrl(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "image from imgur");
            return d;
        } catch (Exception e) {
            return null;
        }
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        protected ImageView vImage;
        protected TextView vUploader;

        public ImageViewHolder(View v) {
            super(v);
            vImage = (ImageView) v.findViewById(R.id.cardViewImage);
            vUploader = (TextView) v.findViewById(R.id.cardViewImageUploader);
        }
    }
}
