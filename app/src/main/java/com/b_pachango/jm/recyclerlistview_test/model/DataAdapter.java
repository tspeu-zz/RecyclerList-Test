package com.b_pachango.jm.recyclerlistview_test.model;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.b_pachango.jm.recyclerlistview_test.R;

import java.util.ArrayList;

/**
 * Created by JM_B on 01-Oct-16.
 */
// OJO System.currentTimeMillis()/1000;
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder>
        {
    private ArrayList<Data> DataList;
//constr
    public DataAdapter(ArrayList<Data> DataList){
        this.DataList = DataList;
    }


            @Override
            public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
     //se crea una vista que se infla desde el xml
                View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.data_list_view_holder, parent, false);

                DataViewHolder dataViewHolder = new DataViewHolder(itemView);
                return dataViewHolder;
            }


            @Override
            public void onBindViewHolder(DataViewHolder holder, int position) {
                    //arrayList de DataList
                //se recoge la posicion en la lista
                Data item = DataList.get(position);
                //coloca en la vista la data del ArrayList
                holder.BindData(item);
            }


            @Override
            public int getItemCount() {
                return DataList.size();
            }




/**
 * Created by JM_B on 01-Oct-16.
 * la clase RecyclerView.ViewHolder, y será bastante sencillo,
 * tan sólo tendremos que incluir como atributos las referencias a los controles
 * del layout de un elemento de la lista (en nuestro caso los dos TextView)
 * e inicializarlas en el constructor utilizando como siempre el método findViewById()
 * sobre la vista recibida como parámetro. Por comodidad añadiremos también un método auxiliar,
 * que llamaremos bindTitular(), que se encargue de asignar los contenidos de los dos
 * cuadros de texto a partir de un objeto Titular cuando nos haga falta.
 * Es el que se encarga del ui del la data
 */

public static class DataViewHolder extends RecyclerView.ViewHolder {

    private TextView date_ID , text_Data;
    private boolean check_Data;
    private ImageView checkIcon;

    public DataViewHolder(View v){
        super(v);

        date_ID = (TextView) v.findViewById(R.id.textDate_id);
        text_Data =(TextView) v.findViewById(R.id.textData);
        checkIcon = (ImageView) v.findViewById(R.id.imageCheck);

    }
//String.valueOf
    public void BindData(Data data){
        date_ID.setText(String.valueOf(data.getSeconds_since_epoch()));
        text_Data.setText(data.getData());
        checkIcon.setColorFilter(R.color.no_checked);
    }


}
/*
*  public static class TitularesViewHolder
            extends RecyclerView.ViewHolder {

        private TextView txtTitulo;
        private TextView txtSubtitulo;

        public TitularesViewHolder(View itemView) {
            super(itemView);

            txtTitulo = (TextView)itemView.findViewById(R.id.LblTitulo);
            txtSubtitulo = (TextView)itemView.findViewById(R.id.LblSubTitulo);
        }

        public void bindTitular(Titular t) {
            txtTitulo.setText(t.getTitulo());
            txtSubtitulo.setText(t.getSubtitulo());
        }
    }*/


}