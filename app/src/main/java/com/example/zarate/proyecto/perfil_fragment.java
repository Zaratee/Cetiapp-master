package com.example.zarate.proyecto;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class perfil_fragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.perfil_fragment,container,false);

        Typeface font = Typeface.createFromAsset(getActivity().getAssets(),"fuentes/quantify.ttf");
        TextView Grupo = (TextView) v.findViewById(R.id.txtV_Perfil);
        Grupo.setTypeface(font);
        return v;
    }
}
