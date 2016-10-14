package com.b_pachango.jm.recyclerlistview_test.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.b_pachango.jm.recyclerlistview_test.R;
import com.b_pachango.jm.recyclerlistview_test.model.Data;
import com.b_pachango.jm.recyclerlistview_test.model.DataAdapter;

import java.util.ArrayList;

public class RecyclerList extends AppCompatActivity {

    private RecyclerView recView;

    private ArrayList<Data> datosList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reclycler_list);



        datosList = new ArrayList<Data> ();

        for(int i=0; i<10;i++)
            datosList.add(new Data("Data"+i));

        recView = (RecyclerView) findViewById(R.id.RecView);
        recView.setHasFixedSize(true);

        final DataAdapter adapter = new DataAdapter(this.datosList);
        recView.setAdapter(adapter);

        recView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        //datosList.add(System.currentTimeMillis()/1000, )

    }
}
