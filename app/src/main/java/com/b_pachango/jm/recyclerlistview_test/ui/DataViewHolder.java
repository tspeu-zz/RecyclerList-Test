package com.b_pachango.jm.recyclerlistview_test.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.b_pachango.jm.recyclerlistview_test.R;
import com.b_pachango.jm.recyclerlistview_test.model.Data;

import static android.support.v7.widget.RecyclerView.ViewHolder;

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

public class DataViewHolder extends ViewHolder{
//System.currentTimeMillis()/1000;
    private TextView date_ID , text_Data;
    private boolean check_Data;
    private ImageView checkIcon;
    public Data data;

    public DataViewHolder(View v){
        super(v);

        date_ID = (TextView) v.findViewById(R.id.textDate_id);
        text_Data =(TextView) v.findViewById(R.id.textData);
        checkIcon = (ImageView) v.findViewById(R.id.imageCheck);

    }
//get data from Data model
    public void BindData(Data datos){
       // date_ID.setText(datos.getSeconds_since_epoch());

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