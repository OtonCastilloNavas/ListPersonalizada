package com.cam.listpersonalizada;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private List<Item> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list.add(
                new Item("Juan",1234,android.R.drawable.ic_dialog_map));
        Item item =  new Item("maria",7866,android.R.drawable.ic_input_add);
        list.add(item);

        MiAdapter adapter=
                new MiAdapter(this, R.layout.layoutitem,list);

        ListView listView =  (ListView) findViewById(R.id.lvLista);

        listView.setAdapter(adapter);
    }
}
