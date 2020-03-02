package com.example.jobscheduler

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.ReceiverCallNotAllowedException
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TimePicker
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main.*
import java.security.AccessController.getContext
import java.time.Month
import java.util.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        val context = this


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mTimePicker = timePicker
        val buttonSetAlarm = buttonSetAlarm
        buttonSetAlarm.setOnClickListener {
                print("hfnbc")
                val calendar: Calendar = Calendar.getInstance()

                if (Build.VERSION.SDK_INT >= 23) {
                    calendar.set(
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH),
                        mTimePicker.getHour(),
                        mTimePicker.getMinute(),
                        0
                    )
                } else{
                    calendar.set(
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH),
                        mTimePicker.getCurrentHour(),
                        mTimePicker.getCurrentMinute(),
                        0)
                }
                setAlarm(calendar.timeInMillis,context)
        }
        /*buttonSetAlarm.setOnClickListener{
            View.OnClickListener {
                val calendar: Calendar = Calendar.getInstance()

                if (Build.VERSION.SDK_INT >= 23) {
                    calendar.set(
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH),
                        timePicker.getHour(),
                        timePicker.getMinute(),
                        0
                    )
                } else{
                    calendar.set(
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH),
                        timePicker.getCurrentHour(),
                        timePicker.getCurrentMinute(),
                        0)
                }
                setAlarm(calendar.timeInMillis,context)
            }
        }*/
        }

    private fun setAlarm(timeInMillis: Long, context: Context) {
        print("jghjhfhf")
       val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, Alarm::class.java)
        val pendingIntent = PendingIntent.getBroadcast(context,0,intent,0)
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, timeInMillis, AlarmManager.INTERVAL_DAY,pendingIntent)
        Toast.makeText(context,"Alarm is set", Toast.LENGTH_SHORT).show()
    }
}




