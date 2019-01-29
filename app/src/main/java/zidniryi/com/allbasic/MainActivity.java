package zidniryi.com.allbasic;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnpertama)
    Button btnpertama;
    @BindView(R.id.btndua)
    Button btndua;
    @BindView(R.id.btntiga)
    Button btntiga;
    @BindView(R.id.btnempat)
    Button btnempat;
    @BindView(R.id.btnlima)
    Button btnlima;
    @BindView(R.id.btnenam)
    Button btnenam;
    @BindView(R.id.btntujuh)
    Button btntujuh;
    @BindView(R.id.btndelapan)
    Button btndelapan;
    @BindView(R.id.btnsembilan)
    Button btnsembilan;
    @BindView(R.id.btnsepuluh)
    Button btnsepuluh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnpertama, R.id.btndua, R.id.btntiga, R.id.btnempat, R.id.btnlima, R.id.btnenam, R.id.btntujuh, R.id.btndelapan, R.id.btnsembilan, R.id.btnsepuluh})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnpertama:
                Toast.makeText(MainActivity.this, "Ini lho toast", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btndua:
                // aksi btndua
                Toast.makeText(this, "btn 2", Toast.LENGTH_SHORT).show();
                // menampilkan alert
                new AlertDialog.Builder(MainActivity.this).setTitle("Exit")
                        .setMessage("Yakin keluar aplikasi ?")
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // perintah positif dari user
                                finish();
                            }
                        })
                        .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // perintah negative
                            }
                        })
                        .show();
                break;
            case R.id.btntiga:
                //Intent
                startActivity(new Intent(MainActivity.this, SpinnerActivity.class));
                break;
            case R.id.btnempat:
                // Todo  menampilkan menu
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);
                //Todo Menerapkan menu dan membuat folder dan xml menu
                popupMenu.inflate(R.menu.popup_menu);
                //aksi ketika pop menu di tekan
                //Generate otomatis
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // menjalankan perintah sesuai urutan menu
                        switch (item.getItemId()){
                            case R.id.item1:
                                // menjalankan perintah utk item1
                                Toast.makeText(MainActivity.this, "Kamu klik menu 1", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.item2:
                                Toast.makeText(MainActivity.this, "Kamu klik menu 2", Toast.LENGTH_SHORT).show();

                                break;
                            case R.id.item3:
                                // share something
                                Toast.makeText(MainActivity.this, "Share something", Toast.LENGTH_LONG).show();
                                Intent inten = new Intent(Intent.ACTION_SEND);
                                inten.setType("text/plain");
                                inten.putExtra(Intent.EXTRA_SUBJECT, "Judul Share");
                                inten.putExtra(Intent.EXTRA_TEXT, "http://jooinfoo.com");
                                startActivity(Intent.createChooser(inten, "Its My Blog Bro"));
                                break;
                        }
                        return false;
                    }
                });

                //menampilkan menu
                popupMenu.show();
                break;
            case R.id.btnlima:
                startActivity(new Intent(MainActivity.this, SegitigaActivity.class));
                break;
            case R.id.btnenam:
                startActivity(new Intent(MainActivity.this, SimpleListActivity.class));
                break;
            case R.id.btntujuh:
                startActivity(new Intent(MainActivity.this, HewanListActivity.class));
                break;
            case R.id.btndelapan:
                startActivity(new Intent(MainActivity.this, VideoActivity.class));
                break;
            case R.id.btnsembilan:
                startActivity(new Intent(MainActivity.this, BrowserActivity.class));
                break;
            case R.id.btnsepuluh:
                startActivity(new Intent(MainActivity.this, GambarActivity.class));
                break;
        }
    }
}
