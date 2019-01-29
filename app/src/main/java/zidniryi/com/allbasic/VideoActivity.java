package zidniryi.com.allbasic;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

import java.net.URI;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoActivity extends AppCompatActivity {

    @BindView(R.id.vv_video)
    VideoView vvVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED
        , WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);

        vvVideo.setVideoURI(Uri.parse("android.resource://" + getPackageName()
        + "/" + R.raw.myvid));

        //Memulai widget video
        vvVideo.setMediaController(new MediaController(this));
        vvVideo.requestFocus();
        vvVideo.start();

    }
}
