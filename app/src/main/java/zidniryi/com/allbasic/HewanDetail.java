package zidniryi.com.allbasic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HewanDetail extends AppCompatActivity {

    @BindView(R.id.imgdhewan)
    ImageView imgdhewan;
    @BindView(R.id.txtdhewan)
    TextView txtdhewan;
    @BindView(R.id.txtddhewan)
    TextView txtddhewan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hewan_detail);
        ButterKnife.bind(this);

        //Ambil dari intent

        Intent intent = getIntent();
        String nama = intent.getStringExtra("namahewan");
        String deskripsi = intent.getStringExtra("deskripsihewan");
        Integer gambar = intent.getIntExtra("gambarhewan",0);

        // tampilkan dalam komponen
        txtdhewan.setText(nama);
        imgdhewan.setImageResource(gambar);
        txtddhewan.setText(deskripsi);

    }
}
