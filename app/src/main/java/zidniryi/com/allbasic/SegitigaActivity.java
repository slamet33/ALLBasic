package zidniryi.com.allbasic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SegitigaActivity extends AppCompatActivity {

    @BindView(R.id.numalas)
    EditText numalas;
    @BindView(R.id.numtinggi)
    EditText numtinggi;
    @BindView(R.id.btnhitung)
    Button btnhitung;
    @BindView(R.id.numhasil)
    EditText numhasil;

    //Menambahkan String
    String alas;
    String tinggi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segitiga);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnhitung)
    public void onViewClicked() {
        //Mengambil data
        alas = numalas.getText().toString();
        tinggi = numtinggi.getText().toString();

        //Validasi form
        if (TextUtils.isEmpty(alas)){
            numalas.setError("Harus Di Isi");
            numalas.requestFocus();
        }else if (TextUtils.isEmpty(tinggi)){
            numalas.setError("Harus Di Isi");
            numalas.requestFocus();
        }else{
            //Menghitung egitiga dan menampilkannya
            hitungSegitiga();
        }


    }

    private void hitungSegitiga() {
        // ubah tipe data string ke double
        double nilaialas = Double.parseDouble(alas);
        double nilaitinggi = Double.parseDouble(tinggi);

        //menghitung
        double hasil = (nilaialas * nilaitinggi) / 2;
        // tampilkan data di komponen hasil
        numhasil.setText(String.valueOf(hasil));
    }
}
