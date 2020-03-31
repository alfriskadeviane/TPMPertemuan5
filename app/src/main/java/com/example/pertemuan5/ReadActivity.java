package com.example.pertemuan5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Entity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pertemuan5.Database.AppDataBase;
import com.example.pertemuan5.Database.DataDiri;

import java.util.ArrayList;

public class ReadActivity extends AppCompatActivity {
    private AppDataBase appDataBase;
    private RecyclerView rv;
    private ArrayList<DataDiri> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        //init database
        appDataBase= AppDataBase.initDb(getApplicationContext());

        //findId
        rv= findViewById(R.id.rv);
        rv.setHasFixedSize(true);

        //Panggil read
        read();

    }
    private void read()
    {
        //ngambil data dari database
        list.addAll(appDataBase.dao().getData());


        //tammpilin recyclerview
        rv.setLayoutManager(new LinearLayoutManager(this));

        AdapterBio adapterBio= new AdapterBio(this, new DataDiriListener() {
            @Override
            public void OnButtonDelete(DataDiri dataDiri) {
                appDataBase.dao().deleteData(dataDiri);
                list.clear();
                read();
            }
//            public void OnButtonUpdate(DataDiri dataDiri){
//
//                nextUpdateActivity();
//            }
        });
        adapterBio.setDataDiris(list);
                rv.setAdapter(adapterBio);
    }
    public void nextUpdateActivity(){
        Intent intent = new Intent(this,UpdateActivity.class);
        this.startActivity(intent);
    }
}
