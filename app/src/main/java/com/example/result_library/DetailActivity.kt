package com.example.result_library

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.result_library.databinding.ActivityDetailBinding
import com.example.result_library.databinding.ActivityMainBinding

class DetailActivity: AppCompatActivity() {
    private val editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
        if(result.resultCode == RESULT_OK){
            result.data?.extras?.let {
                bundle ->
                binding.tvTenSach313.text = bundle.getString("key_TenSachMoi313")
                binding.tvTienCoc313.text = bundle.getDouble("key_TenCocMoi313").toString()
                binding.tvTenNguoi313.text = bundle.getString("key_TenNguoiMoi313")
            }
        }
    }
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
            with(binding){
                val intent = Intent(this@DetailActivity, ChinhSuaChiTietActivity::class.java).apply{
                    putExtra("key_TenSach313",tvTenSach313.text)
                    putExtra("key_TienCoc313",tvTienCoc313.text)
                    putExtra("key_TenNguoi313",tvTenNguoi313.text)
                }
                editLauncher.launch(intent)
            }
        }
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}