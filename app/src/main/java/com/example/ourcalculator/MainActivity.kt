package com.example.ourcalculator

import android.content.IntentSender.OnFinished
import androidx.appcompat.app.AppCompatActivity
import android.media.RingtoneManager
import android.os.CountDownTimer
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var inNum:EditText?=null
    private var textResul:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        inNum= findViewById(R.id.inNum)
        textResul=findViewById(R.id.textResul)
    }
    fun play(view:View){
        var segundo= inNum?.text.toString().toLong()
        var timeMilisecon=segundo*1000

        object :CountDownTimer(timeMilisecon,1000){

            override fun onTick(millisUntilFinished: Long) {
                var tsecon= (millisUntilFinished/1000).toInt()
                textResul?.text= tsecon.toString().padStart(2,'0')
            }

            override fun onFinish() {
                val soundCrono= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE)
                val ring= RingtoneManager.getRingtone(this@MainActivity,soundCrono)
                ring.play()
                this.cancel()
            }

        }.start()
    }
}