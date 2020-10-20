package com.juannarvaez.trabajarcontabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GridViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GridViewFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private GridView tablaOpciones;
    private TextView opcionSeleccionada;
    private GridAdapter adapter;


    public GridViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GridViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GridViewFragment newInstance(String param1, String param2) {
        GridViewFragment fragment = new GridViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ArrayList<String> arrayList= new ArrayList<>();
        arrayList.add("¿Que es Android?");
        arrayList.add("¿Android Studio?");
        arrayList.add("Interfaz Grafica");
        arrayList.add("LinearLayout");
        arrayList.add("ConstraintLayout");
        arrayList.add("RelativeLayout");

        View vista = inflater.inflate(R.layout.fragment_grid_view, container, false);
        tablaOpciones = (GridView) vista.findViewById(R.id.tablaOpciones);
        adapter=new GridAdapter(getContext(),arrayList);
        opcionSeleccionada = (TextView) vista.findViewById(R.id.opcionSeleccionada);

        tablaOpciones.setAdapter(adapter);
        tablaOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                opcionSeleccionada.setText("La opción seleccionada  es: "+ parent.getItemAtPosition(position));
            }
        });
        return vista;
    }
}
