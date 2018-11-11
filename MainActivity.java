package com.example.franklinsierra.frutas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //atributos
    private List<fruits> lista;
    private ListView listView;
    private int counter=0;
    adapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //lleno la lista de frutas
        lista=new ArrayList<fruits>();
        lista.add(new fruits(R.drawable.apple,"Manzana","Boyaca","reduce colesterol"));
        lista.add(new fruits(R.drawable.grapes,"Uvas","Valle","todas las vitaminas B"));
        lista.add(new fruits(R.drawable.kiwi,"Kiwi","Cauca","mejora circulacion"));
        lista.add(new fruits(R.drawable.orange,"Orange","Meta","mejora las defensas"));
        lista.add(new fruits(R.drawable.pear,"Pear","Manizalez","con hierro"));
        lista.add(new fruits(R.drawable.pineapple,"Piña","Santander","acido folico"));

        //busco el listView
        listView=(ListView)findViewById(R.id.lista);

        //cuando hago click en un item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                fruits touchFruit=lista.get(position);
                String msj=touchFruit.getInfo();
                Toast.makeText(MainActivity.this,"consumelo poque "+msj,Toast.LENGTH_SHORT).show();
            }
        });

        //enlazo con el adaptador personalizado
        myAdapter=new adapter(this,R.layout.custom_layout,lista);
        listView.setAdapter(myAdapter);

        //le pedimos que registre el contexto para borrar items
        registerForContextMenu(listView);

    }

    //creo (inflo) el menu en el accion bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu,menu);
        return true;
    }

    //lo que ocurre cuando hago click en el accion bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                this.lista.add(new fruits(R.drawable.icon_default,
                        "Agregado "+(++counter),"Desconocido","no conozco la fruta"));
                this.myAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }

    //inflo la vista del click prolongado
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.context_menu,menu);
    }

    //reaccion al click
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //tomamos la informacion del item seleccionado
        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.delete_item:
                //borramos el item clickeado
                this.lista.remove(info.position);
                this.myAdapter.notifyDataSetChanged();
                return true;

             default:
                return super.onContextItemSelected(item);
        }
    }
}
