package com.example.zarate.proyecto;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class docente1stAct extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView Nombr,ApellM,ApellP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docente1st);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        android.app.FragmentManager frgman= getFragmentManager();
        android.app.FragmentTransaction frgtran = frgman.beginTransaction();
        frgman.beginTransaction().replace(R.id.Fragment_conteinerdocente,new perfil_fragment()).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        Nombr = (TextView) findViewById(R.id.txtV_docenteNombreMenu);
        ApellM = (TextView) findViewById(R.id.txtV_docenteApellidoMaMenu);
        ApellP = (TextView) findViewById(R.id.txtV_docenteApellidoPaMenu) ;

        Nombr.setText(loginActDocent.Nombre);
        ApellM.setText(loginActDocent.ApelliM);
        ApellP.setText(loginActDocent.ApelliP);

        getMenuInflater().inflate(R.menu.docente1st, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        android.app.FragmentManager frgman= getFragmentManager();
        android.app.FragmentTransaction frgtran = frgman.beginTransaction();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            frgman.beginTransaction().replace(R.id.Fragment_conteinerdocente,new perfil_fragment()).commit();
            return true;
        }

        if (id == R.id.item_salirDocente) {
            android.content.Intent salir = new android.content.Intent(docente1stAct.this,MainActivity.class);
            startActivity(salir);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        android.app.FragmentManager frgman= getFragmentManager();
        android.app.FragmentTransaction frgtran = frgman.beginTransaction();
        horario_fragmentt hr_fr = new horario_fragmentt();
        int id = item.getItemId();

        if (id == R.id.nav_chat) {
            frgman.beginTransaction().replace(R.id.Fragment_conteinerdocente,new PrinchatDocent_fragment()).commit();
        } else if (id == R.id.nav_tarea) {
            frgman.beginTransaction().replace(R.id.Fragment_conteinerdocente,new tareas_fragment()).commit();
        } else if (id == R.id.nav_horario) {
            frgman.beginTransaction().replace(R.id.Fragment_conteinerdocente, new horario_fragmentt()).commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
