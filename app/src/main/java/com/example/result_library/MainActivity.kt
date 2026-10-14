package com.example.result_library

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.result_library.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var TenSach_313 : String? = null
    private var TienCoc_313 : Double? = null
    private var TenNguoi_313 :String? = null
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Thái Trường Giang MSV - Tên đề tài"
        binding.btnThem.setOnClickListener {
            val edtNameSach_313 = binding.edtTenSach313.text.toString().trim()
            val edtTien_313 = binding.edtTienCoc313.text.toString().trim()
            val edtTenNguoi_313 = binding.edtTenNguoi313.text.toString().trim()

            val sotien = edtTien_313.toDoubleOrNull()
            if(edtTenNguoi_313 == null || edtNameSach_313 == null || sotien == null){
                Toast.makeText(this@MainActivity,
                    "Du lieu khong the la null va rong", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }
        binding.btnDetail.setOnClickListener {

        }
    }
}