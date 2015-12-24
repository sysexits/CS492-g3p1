package cs492.kaist.org.helloworld;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaehyun Jang on 12/24/2015.
 */
public class Tab2Fragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    public Tab2Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2_fragment_main, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.tab2RecyclerView);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        //https://api.imgur.com/oauth2/authorize?client_id=4398fec8945527e&response_type=token

        List<ImageInfo> imgurImages = new ArrayList<ImageInfo>();
        imgurImages.add(new ImageInfo("http://i.imgur.com/Jvh1OQm.jpg", "Neebus"));
        imgurImages.add(new ImageInfo("http://i.imgur.com/6RJmSPS.jpg", ""));
        imgurImages.add(new ImageInfo("http://i.imgur.com/Jvh1OQm.jpg", "Neebus"));
        imgurImages.add(new ImageInfo("http://i.imgur.com/6RJmSPS.jpg", ""));
        imgurImages.add(new ImageInfo("http://i.imgur.com/Jvh1OQm.jpg", "Neebus"));
        imgurImages.add(new ImageInfo("http://i.imgur.com/6RJmSPS.jpg", ""));
        imgurImages.add(new ImageInfo("http://i.imgur.com/Jvh1OQm.jpg", "Neebus"));
        imgurImages.add(new ImageInfo("http://i.imgur.com/6RJmSPS.jpg", ""));
        imgurImages.add(new ImageInfo("http://i.imgur.com/Jvh1OQm.jpg", "Neebus"));
        imgurImages.add(new ImageInfo("http://i.imgur.com/6RJmSPS.jpg", ""));

        mAdapter = new ImageAdapter(this.getContext(), imgurImages);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }
}
