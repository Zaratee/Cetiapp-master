package com.example.zarate.proyecto;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Princhat_Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.princhat_fragment, container, false);
            TextView chat;
            chat = (TextView) v.findViewById(R.id.txtV_btnIngresarChat);
            chat.setOnClickListener(new View.OnClickListener() {
                android.app.FragmentManager frgman= getFragmentManager();
                android.app.FragmentTransaction frgtran = frgman.beginTransaction();
                @Override
                public void onClick(View v) {
                    frgman.beginTransaction().replace(R.id.Fragment_conteiner, new chat_fragmentt()).commit();
                }
            });
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(),"fuentes/quantify.ttf");
        TextView Grupo = (TextView) v.findViewById(R.id.letreroChats);
        Grupo.setTypeface(font);
            return v;
    }
}
