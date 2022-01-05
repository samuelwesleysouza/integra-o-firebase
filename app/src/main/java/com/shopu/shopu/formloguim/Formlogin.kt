package com.shopu.shopu.formloguim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.shopu.shopu.R
import com.shopu.shopu.databinding.ActivityFormcadastroBinding
import com.shopu.shopu.databinding.ActivityFormloginBinding
import com.shopu.shopu.formcadastro.formcadastro

class formlogin : AppCompatActivity() {

    lateinit var binding: ActivityFormloginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Thread.sleep(2000)
        setTheme(R.style.Theme_Main)
        setContentView(R.layout.activity_formlogin)

        binding = ActivityFormloginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.txtTeladecadastro.setOnClickListener {
        val intent = Intent(this,formcadastro::class.java)
            startActivity(intent)
        }
    }

}
