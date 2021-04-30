package com.example.sqlite_a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sqlite_a.database.DBController;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

public class EditTeman extends AppCompatActivity {
    private TextInputEditText eNama,eTelpon;
    private Button simpanBtn;
    String id, nm, tlp;
    DBController controller = new DBController(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_teman);

        eNama = (TextInputEditText)findViewById(R.id.edNama);
        eTelpon = (TextInputEditText)findViewById(R.id.edTelpon);
        simpanBtn = (Button)findViewById(R.id.buttonSave);

        id = getIntent().getStringExtra("id");
        nm = getIntent().getStringExtra("nm");
        tlp = getIntent().getStringExtra("tlp");

        setTitle("EditTeman");
        eNama.setText(nm);
        eTelpon.setText(tlp);

        simpanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eNama.getText().toString().equals("")||eTelpon.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Data belum komplit!", Toast.LENGTH_SHORT).show();
                }else{
                    nm = eNama.getText().toString();
                    tlp = eTelpon.getText().toString();
                    HashMap<String,String> qvalues = new HashMap<>();
                    qvalues.put("nama",nm);
                    qvalues.put("telpon",tlp);
                    controller.editData(qvalues);
                    callHome();
                }
            }
        });
    }
    public void callHome(){
        Intent intent = new Intent(EditTeman.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}