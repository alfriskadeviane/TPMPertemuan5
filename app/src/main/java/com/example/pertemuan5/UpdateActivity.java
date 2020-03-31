package com.example.pertemuan5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pertemuan5.Database.AppDataBase;
import com.example.pertemuan5.Database.DataDiri;

import java.util.ArrayList;

public class UpdateActivity extends AppCompatActivity {
    private AppDataBase appDataBase;
    private ArrayList<DataDiri> list=new ArrayList<>();
    private EditText etId,etNama,etAlamat,etJK;
    private Button bEdit,bCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        appDataBase= AppDataBase.initDb(getApplicationContext());
        etId=findViewById(R.id.etId);
        etNama= findViewById(R.id.etNama);
        etAlamat= findViewById(R.id.etAlamat);
        etJK= findViewById(R.id.etJK);
        bEdit= findViewById(R.id.bEdit);
        bCancel= findViewById(R.id.bCancel);

        bEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit();
                nextReadActivity();
            }
        });

        bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextReadActivity();
            }
        });
        readEach();
    }

    public void readEach(){
        int id= getIntent().getIntExtra("id",0);
        String nama= getIntent().getStringExtra("nama");
        String alamat= getIntent().getStringExtra("alamat");
        char jk= getIntent().getCharExtra("jk",' ');
        etId.setText(""+id);
        etNama.setText(nama);
        etAlamat.setText(alamat);
        etJK.setText(""+jk);
    }
    public  void edit()
    {
        String id= etId.getText().toString();
        int Id= Integer.parseInt(id);
        String nama= etNama.getText().toString();
        String alamat = etAlamat.getText().toString();
        char jk= etJK.getText().toString().charAt(0);

        DataDiri item = new DataDiri();
        item.setId(Id);
        item.setNama(nama);
        item.setAlamat(alamat);
        item.setJk(jk);

        appDataBase.dao().updateData(item);

    }

    public void nextReadActivity(){
        Intent intent = new Intent(this,ReadActivity.class);
        this.startActivity(intent);
    }
}
