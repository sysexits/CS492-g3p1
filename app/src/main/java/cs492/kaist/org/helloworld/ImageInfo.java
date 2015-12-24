package cs492.kaist.org.helloworld;

/**
 * Created by Jaehyun Jang on 12/24/2015.
 */
public class ImageInfo {
    protected String url;
    protected String uploader;

    public ImageInfo(String url, String uploader) {
        this.url = url;
        this.uploader = uploader;
    }
}