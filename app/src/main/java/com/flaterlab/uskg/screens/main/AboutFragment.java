package com.flaterlab.uskg.screens.main;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.flaterlab.uskg.R;
import com.flaterlab.uskg.util.BaseFragment;
public class AboutFragment extends BaseFragment {

    public Button btFacebook;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_about, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btFacebook = view.findViewById(R.id.bt_link_to_facebook);

        btFacebook.setOnClickListener(v -> {
            Toast.makeText(requireContext(), "Not implemented yet", Toast.LENGTH_SHORT).show();
        });
    }
}