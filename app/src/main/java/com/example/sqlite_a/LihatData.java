package com.example.sqlite_a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class LihatData extends AppCompatActivity {
    TextView tnama, tnomor;
    String id, nm, tlp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        tnama = findViewById(R.id.tvNamaKontak);
        tnomor = findViewById(R.id.tvNomorTelepon);

        id = getIntent().getStringExtra("id");
        nm = getIntent().getStringExtra("nama");
        tlp = getIntent().getStringExtra("telpon");

        tnama.setText(nm);
        tnomor.setText(tlp);
    }
}