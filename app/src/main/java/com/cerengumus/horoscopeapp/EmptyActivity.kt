package com.cerengumus.horoscopeapp

import android.app.VoiceInteractor
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley


class EmptyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()
        setContentView(R.layout.activity_details)
        var dataModel = intent.getParcelableExtra<DataModel>(MainActivity.INTENT_PARCELABLE)
        var image = findViewById<ImageView>(R.id.image)
        var title = findViewById<TextView>(R.id.image_desc)
        if (dataModel != null) {
            image.setImageResource(dataModel.image)
        }else
            image.setImageResource(R.drawable.balik)
       populateHoroscope(title)
    }
    private fun populateHoroscope(zodiacName : TextView){
       val mreqq :  RequestQueue = Volley.newRequestQueue(this)
        val url : String = "http://www.gazetevatan.com/gunluk-burc-yorumlari--976907-astroloji/"
        val stringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener<String> { response ->
                zodiacName.text = "Response is: ${response.substring(0, 500)}"
            },
            Response.ErrorListener { zodiacName.text = "That didn't work!" })

        mreqq.add(stringRequest)

    }
}