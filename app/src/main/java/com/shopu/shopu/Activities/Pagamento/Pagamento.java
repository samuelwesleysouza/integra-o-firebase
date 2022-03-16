package com.shopu.shopu.Activities.Pagamento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import com.shopu.shopu.R;
import com.shopu.shopu.databinding.ActivityPagamentoBinding;

public class Pagamento extends AppCompatActivity {

    ActivityPagamentoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        binding = ActivityPagamentoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String tamanho_calcado = getIntent().getExtras().getString("tamanho_calcado");
                Log.d("t",tamanho_calcado);
    }
}