package com.example.study_jam_day2_layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.study_jam_day2_layouts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)


        bindingClass.btHesapla.setOnClickListener {
            val vizeNotu = bindingClass.vizeET.text.toString()
            val finalNotu = bindingClass.finalET.text.toString()
            val vizeAgirligi = bindingClass.sinavRadioGroup.checkedRadioButtonId
            val can = bindingClass.canSwitch.isChecked
            var sonuc = 0.0
            var durum = ""

            when(vizeAgirligi) {
                R.id.radioOtuz -> {
                    sonuc = vizeNotu.toDouble() * 0.3 + finalNotu.toDouble() * 0.7
                }
                R.id.radioKirk -> {
                    sonuc = vizeNotu.toDouble() * 0.4 + finalNotu.toDouble() * 0.6
                }
                R.id.radioElli -> {
                    sonuc = vizeNotu.toDouble() * 0.5 + finalNotu.toDouble() * 0.5
                }
            }
            if(can) {
                if(sonuc >= 40) {
                    durum = "Gectiniz"
                } else {
                    durum = "Kaldiniz"
                }
            } else {
                if(sonuc >= 50) {
                    durum = "Gectiniz"
                } else {
                    durum = "Kaldiniz"
                }
            }
            bindingClass.tvDurum.text = durum
            bindingClass.tvOrtalama.text = sonuc.toString()
        }
    }
}