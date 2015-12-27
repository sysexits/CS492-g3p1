package cs492.kaist.org.helloworld;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        imgurImages.add(new ImageInfo("http://i.imgur.com/EdwScNg.jpg", "(source)"));
        imgurImages.add(new ImageInfo("http://i.imgur.com/RtS6Nz8.jpg", "swirley0s"));
        imgurImages.add(new ImageInfo("http://i.imgur.com/sNfABOO.png", "xZora"));
        imgurImages.add(new ImageInfo("http://i.imgur.com/FO5eMAc.jpg", "(source)"));
        imgurImages.add(new ImageInfo("http://i.imgur.com/WktFupP.jpg", "(source)"));
        imgurImages.add(new ImageInfo("http://i.imgur.com/FnmRIGi.jpg", "JesusChristSuperstar"));
        imgurImages.add(new ImageInfo("http://i.imgur.com/3rYHhEu.jpg", "Estmagnum"));
        imgurImages.add(new ImageInfo("http://i.imgur.com/360B1Fa.jpg", "Insta12345"));
        imgurImages.add(new ImageInfo("http://i.imgur.com/Ak0UDfJ.jpg", "SymphonicOtter"));
        imgurImages.add(new ImageInfo("http://i.imgur.com/nbUseMu.jpg", "kat1014"));
        imgurImages.add(new ImageInfo("http://i.imgur.com/P02XOwI.png", "bodoesntknowhockey"));
        imgurImages.add(new ImageInfo("http://i.imgur.com/fqGOW3k.jpg", "upsettispaghetti"));
        imgurImages.add(new ImageInfo("http://i.imgur.com/9ifwvpn.jpg", "MageGrace"));
        imgurImages.add(new ImageInfo("http://i.imgur.com/N4c97Yn.jpg", "MageGrace"));
        imgurImages.add(new ImageInfo("http://i.imgur.com/N4xlpmG.jpg", "MageGrace"));
        imgurImages.add(new ImageInfo("http://i.imgur.com/bv1nfDy.jpg", "MageGrace"));
        imgurImages.add(new ImageInfo("http://i.imgur.com/ocJ7ZAa.jpg", "(source)"));
        imgurImages.add(new ImageInfo("http://i.imgur.com/QzU3F0m.jpg", "Foxxygames"));
        imgurImages.add(new ImageInfo("http://i.imgur.com/JK3Z9sW.jpg", "Misfit301"));
        imgurImages.add(new ImageInfo("http://i.imgur.com/mCLwvYQ.jpg", "Misfit301"));

        mAdapter = new ImageAdapter(this.getContext(), imgurImages);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }
}
