package com.example.uielementspart2challenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ListView

var albumSongs = ArrayList<String>()
var albumURI = String

class AlbumsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_albums)
        //Map the Grid View
        val GridView = findViewById<GridView>(R.id.gridView) as GridView
        //Attach the adapter to the Grid View
        GridView.adapter = ImageAdapter(applicationContext)
        //Item click listener for the Grid View
        GridView.onItemClickListener = AdapterView.OnItemClickListener{parent, v, position, id ->
            val intent = Intent(this, AlbumDetailsActivity::class.java)
            var uri: String
            if (position == 0) {
                uri = "@drawable/divide_cover"
                albumSongs.clear()
                albumSongs.addAll(resources.getStringArray(R.array.divide))
            } else if (position == 1) {
                uri = "@drawable/abbey_road_cover"
                albumSongs.clear()
                albumSongs.addAll(resources.getStringArray(R.array.abbeyRoad))
            } else {
                uri = "@drawable/scorpion_cover"
                albumSongs.clear()
                albumSongs.addAll(resources.getStringArray(R.array.scorpion))
            }
            intent.putExtra("imageUri",  uri)
            startActivity(intent)


        }



    }




}



