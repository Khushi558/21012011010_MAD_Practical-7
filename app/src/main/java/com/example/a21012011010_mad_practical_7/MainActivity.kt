package com.example.a21012011010_mad_practical_7
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    lateinit var videoView: VideoView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        videoView= findViewById(R.id.videoViewId)
        val btn: FloatingActionButton = findViewById(R.id.button)
        initVideoPlayer()
        btn.setOnClickListener {
            Intent(this@MainActivity, YoutubeActivity::class.java).also{startActivity(it)}
        }
    }
    fun initVideoPlayer()
    {
        val mediaController = MediaController(this)
        val uri: Uri = Uri.parse("android.resource://"+ packageName + "/" + R.raw.thestoryoflight)
        videoView.setMediaController(mediaController)
        mediaController.setAnchorView(videoView)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()
    }
}