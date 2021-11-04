package com.cerengumus.horoscopeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }
    private lateinit var  newAdapter: Adapter
    private var dataList = mutableListOf<DataModel>()
    val zodiacArray  = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = GridLayoutManager(applicationContext,2)


        dataList.add(DataModel(" KOC           ARIES ",R.drawable.koc))
        dataList.add(DataModel(" BOGA     TAURUS ",R.drawable.boga))
        dataList.add(DataModel(" OGLAK   CAPRICORN ",R.drawable.oglak))
        dataList.add(DataModel(" YAY  SAGITTARIUS ",R.drawable.yay))
        dataList.add(DataModel(" KOVA  AQUARIUS ",R.drawable.kova))
        dataList.add(DataModel(" AKREP    SCORPIO ",R.drawable.akrep))
        dataList.add(DataModel(" YENGEC       CANCER ",R.drawable.yengec))
        dataList.add(DataModel(" iKiZLER    GEMINI ",R.drawable.gemini))
        dataList.add(DataModel(" ASLAN           LEO ",R.drawable.leo))
        dataList.add(DataModel(" BASAK     VIRGO ",R.drawable.basak))
        dataList.add(DataModel(" TERAZI      LIBRA ",R.drawable.terazi))
        dataList.add(DataModel(" BALIK       PISCES ",R.drawable.balik))
        newAdapter = Adapter(applicationContext){
            val intent = Intent(this,EmptyActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE,"ishfhwf")
            startActivity(intent)
        }
        recyclerView.adapter = newAdapter
        newAdapter.setDataList(dataList)





    }

}