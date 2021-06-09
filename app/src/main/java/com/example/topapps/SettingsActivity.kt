package com.example.topapps

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.widget.CompoundButtonCompat
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val appSettingPrefs : SharedPreferences=getSharedPreferences("AppSettingPrefs",0)
        val sharedPrefsEdit :SharedPreferences.Editor=appSettingPrefs.edit()
        val isNightModeOn:Boolean = appSettingPrefs.getBoolean("NightMode",true)

        if(isNightModeOn){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        }

        val sw1 = findViewById<Switch>(R.id.switch1)
        sw1?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                tvTheme.text="App Theme Dark"

                sharedPrefsEdit.putBoolean("NightMode",true)
                sharedPrefsEdit.apply()
            }
            else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                sharedPrefsEdit.putBoolean("NightMode",false)
                tvTheme.text="App Theme Light"
                sharedPrefsEdit.apply()
            }
        }

    }

    }


