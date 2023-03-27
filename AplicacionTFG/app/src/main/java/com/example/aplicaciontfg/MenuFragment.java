package com.example.aplicaciontfg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MenuFragment extends Fragment {

    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        textView = view.findViewById(R.id.textView);
        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Obtener la configuración de la cámara desde MainActivity
        CameraConfig cameraConfig = MainActivity.cameraConfig;

        // Configurar la interfaz de usuario del menú, incluyendo el valor actual del contraste
        SeekBar contrastSeekBar = view.findViewById(R.id.contrastSeekBar);
        contrastSeekBar.setProgress(cameraConfig.getContrast());
        contrastSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Actualizar el valor del contraste en la variable de configuración de la cámara en MainActivity
                cameraConfig.setContrast(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

}