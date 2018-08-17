package com.cam.listpersonalizada;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity
        implements AdapterView.OnItemLongClickListener,
        AdapterView.OnItemClickListener {

    private List<Item> list = new ArrayList<>();
    private List<Integer> imagenList= new ArrayList<>();
    private ListView listView;
    private int posicion=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        list.add(
//                new Item("Juan",1234,android.R.drawable.ic_dialog_map));
//        Item item =  new Item("maria",7866,android.R.drawable.ic_input_add);
//        list.add(item);

        imagenList.add(android.R.drawable.ic_delete);
        imagenList.add(android.R.drawable.ic_input_add);
        imagenList.add(android.R.drawable.ic_input_get);
        imagenList.add(android.R.drawable.ic_media_pause);


        MiAdapter adapter=
                new MiAdapter(this, R.layout.layoutitem,list);

        listView =  (ListView) findViewById(R.id.lvLista);

        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(this);
        listView.setOnItemClickListener(this);
    }

    public void onClick(View v){
        EditText etNombre = (EditText) findViewById(R.id.etNombre);
        EditText etNumero= (EditText) findViewById(R.id.etNumero);
        Spinner spImagen=(Spinner) findViewById(R.id.spImagen);
        int imagen=imagenList.get(spImagen.getSelectedItemPosition());

        Item i = new Item(etNombre.getText().toString(),
                Integer.valueOf(etNumero.getText().toString()),
                imagen);
        if(posicion==-1)
            list.add(i);
        else
            list.set(posicion,i);
        posicion=-1;
        MiAdapter adapter = (MiAdapter)listView.getAdapter();
        adapter.notifyDataSetChanged();
    }


    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
       list.remove(i);
       MiAdapter adapter = (MiAdapter) listView.getAdapter();
       adapter.notifyDataSetChanged();
        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        EditText etNombre = (EditText) findViewById(R.id.etNombre);
        EditText etNumero = (EditText) findViewById(R.id.etNumero);
        etNombre.setText(list.get(i).getNombre());
        etNumero.setText(String.valueOf(list.get(i).getNumero()));
        Spinner spImagen = (Spinner) findViewById(R.id.spImagen);

        spImagen.setSelection(
                imagenList.indexOf(list.get(i).getImagen()));
        posicion=i;
    }
}






