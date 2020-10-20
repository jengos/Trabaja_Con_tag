package com.juannarvaez.trabajarcontabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabControlSeleccion;
    ViewPager paginas;
    AdaptadorPaginas adaptadorPaginas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabControlSeleccion = (TabLayout) findViewById(R.id.tabControlesSeleccion);
        paginas = (ViewPager) findViewById(R.id.paginas);
        adaptadorPaginas = new AdaptadorPaginas(getSupportFragmentManager(), tabControlSeleccion.getTabCount());
        paginas.setAdapter(adaptadorPaginas);
        tabControlSeleccion.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected (TabLayout.Tab tab) {
                paginas.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0) {
                    adaptadorPaginas.notifyDataSetChanged();
                }
                if (tab.getPosition() == 1) {
                    adaptadorPaginas.notifyDataSetChanged();
                }
                if (tab.getPosition() == 2) {
                    adaptadorPaginas.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        paginas .addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabControlSeleccion));

    }
}