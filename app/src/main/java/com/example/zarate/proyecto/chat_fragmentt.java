package com.example.zarate.proyecto;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class chat_fragmentt extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.chat_fragment,container,false);
        Button volver = (Button) v.findViewById(R.id.btn_volverChat);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.app.FragmentManager frgman= getFragmentManager();
                android.app.FragmentTransaction frgtran = frgman.beginTransaction();
                frgman.beginTransaction().replace(R.id.Fragment_conteiner, new Princhat_Fragment()).commit();
            }
        });
        return v;
    }
}
