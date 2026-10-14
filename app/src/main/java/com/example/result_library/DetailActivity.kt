package com.example.result_library

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.result_library.databinding.ActivityDetailBinding
import com.example.result_library.databinding.ActivityMainBinding

class DetailActivity: AppCompatActivity() {
    private lateinit var binding : ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.extras?.let {
            bundle ->
            with(binding){
                val NameBook_313 = bundle.getString("key_TenSach313")?:""
                val Money_313 = bundle.getDouble("key_SoTien313",0.0)
                val NameNguoi_313 = bundle.getString("key_TenNguoi313")?:""

                tvTenSach313.text = NameBook_313
                tvTienCoc313.text = Money_313.toString()
                tvTenNguoi313.text = NameNguoi_313
            }
        }
        binding.btnEdit.setOnClickListener {

        }
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}