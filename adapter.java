package com.example.franklinsierra.frutas;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class adapter extends BaseAdapter {

    //atributos
    private Context context;
    private int layout;
    private List<fruits> fruits;

    //constructor
    public adapter(Context context, int layout, List<fruits> fruits) {
        this.context = context;
        this.layout = layout;
        this.fruits = fruits;
    }

    @Override
    public int getCount() {
        //cantidad de objetos fruta
        return fruits.size();
    }

    @Override
    public Object getItem(int position) {
        return this.fruits.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //creo un holder que optimiza la busqueda en doc R
        viewHolder holder;

        if(convertView==null){
            //creo una vista
            View vista;
            LayoutInflater layoutInflater=LayoutInflater.from(this.context);
            //inflo la vista con el layout personalizado
            vista=layoutInflater.inflate(R.layout.custom_layout,null);
            convertView=vista;

            holder=new viewHolder();
            holder.imageViewIcon=(ImageView) convertView.findViewById(R.id.imageIcon);
            holder.textViewNombre=(TextView) convertView.findViewById(R.id.textViewName);
            holder.textViewOrigin=(TextView) vista.findViewById(R.id.textViewOrigin);
            convertView.setTag(holder);
        }else{
            //rescato el holder
            holder=(viewHolder)convertView.getTag();
        }

        //creo una copia del objeto fruta que llega
        fruits currentFruit=fruits.get(position);

        //inflo el icono de la fruta
        holder.imageViewIcon.setImageResource(currentFruit.getIcon());

        //inflo el Nombre del layout personalizado
        holder.textViewNombre.setText(currentFruit.getName());

        //inflo el origen del layout personalizado
        holder.textViewOrigin.setText(currentFruit.getOrigin());

        return convertView;
    }

    static class viewHolder{
        private ImageView imageViewIcon;
        private TextView textViewNombre;
        private TextView textViewOrigin;
    }
}
