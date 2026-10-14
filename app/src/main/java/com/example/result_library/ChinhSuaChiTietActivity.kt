package com.example.result_library

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.result_library.databinding.ActivityChinhsuachitietBinding

class ChinhSuaChiTietActivity: AppCompatActivity() {
    private lateinit var binding: ActivityChinhsuachitietBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChinhsuachitietBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.extras?.let {
            bundle ->
            with(binding){
                val tenSachNow_313 = bundle.getString("key_TenSach313")
                val tienCocNow_313 = bundle.getString("key_TienCoc313")
                val TenNguoiNow_313 = bundle.getString("key_TenNguoi313")

                edtTenSachSua313.setText(tenSachNow_313)
                edtTienCocSua313.setText(tienCocNow_313)
                edtTenNguoiSua313.setText(TenNguoiNow_313)
            }
        }
        binding.btnLuu.setOnClickListener {
            with(binding){
                val tenSachMoi_313 = edtTenSachSua313.text.toString()
                val tienCocMoi_313 = edtTienCocSua313.text.toString()
                val tenNguoiMoi_313 = edtTenNguoiSua313.text.toString()

                val tienSo_313 = tienCocMoi_313.toDoubleOrNull()
                val resultIntent = Intent().apply{
                    putExtra("key_TenSachMoi313", tenSachMoi_313)
                    putExtra("key_TienCocMoi313",tienSo_313)
                    putExtra("key_TenNguoiMoi313", tenNguoiMoi_313)
                }
                setResult(Activity.RESULT_OK,resultIntent)
                finish()
            }
        }
        binding.btnCancel.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}