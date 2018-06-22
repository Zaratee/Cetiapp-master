package com.example.zarate.proyecto;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class tareas_fragment extends Fragment {

    Button mandarTarea;
    EditText recibirTareas;
    ListView listaTareas;
    ArrayList<String> arrayL;
    ArrayAdapter<String> arrayA;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tareas_fragment,container,false);
        mandarTarea = (Button) v.findViewById(R.id.btn_mandarTarea);
        recibirTareas = (EditText) v.findViewById(R.id.etxt_tarea);
        listaTareas = (ListView) v.findViewById(R.id.lstV_tareas);
        arrayL = new ArrayList<String>();
        arrayA = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,arrayL);
        listaTareas.setAdapter(arrayA);

        mandarTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = recibirTareas.getText().toString();
                arrayL.add(result);
                arrayA.notifyDataSetChanged();
            }
        });

        Typeface font = Typeface.createFromAsset(getActivity().getAssets(),"fuentes/quantify.ttf");
        TextView Grupo = (TextView) v.findViewById(R.id.txtV_Tareas);
        Grupo.setTypeface(font);
        return v;
    }
}
