package com.example.uskg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class HomeFragment extends Fragment {
    LinearLayout kgtu,krsu;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        kgtu = v.findViewById(R.id.kgtu);
        kgtu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(requireContext(), "KGTU", Toast.LENGTH_SHORT).show();



         View v = inflater.inflate(R.layout.fragment_home, container, false);
         krsu = v.findViewById(R.id.krsu);
         krsu.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Toast.makeText(requireContext(),"KRSU", Toast.LENGTH_SHORT).show();
             }
         });
            }
        });
        return v;

    }
}






