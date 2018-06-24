package com.example.zarate.proyecto;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

public class perfil_fragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.perfil_fragment,container,false);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(),"fuentes/quantify.ttf");
        TextView Grupo = (TextView) v.findViewById(R.id.txtV_Perfil);
        Grupo.setTypeface(font);
        TextView nom,apellidom,apellidop,reg,carr,sem,grup;

        nom = (TextView) v.findViewById(R.id.txtV_nombreAlummnoPerfil);
        apellidom = (TextView) v.findViewById(R.id.txtV_apellidoMPerfil);
        apellidop = (TextView) v.findViewById(R.id.txtV_apellidoPPerfil);
        reg = (TextView) v.findViewById(R.id.txtV_registroAlummnoPerfil);
        switch (MainActivity.ACT) {
            case "UNO":
                nom.setText(unoAct.Nombre);
                apellidom.setText(unoAct.ApelliM);
                apellidop.setText(unoAct.ApelliP);
                reg.setText(unoAct.Regis);
                break;
            case "DOS":
                nom.setText(loginActDocent.Nombre);
                apellidom.setText(loginActDocent.ApelliM);
                apellidop.setText(loginActDocent.ApelliP);
                reg.setText(loginActDocent.Regis);
        }

        return v;
    }
}
