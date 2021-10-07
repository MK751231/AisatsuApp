package jp.techacademy.masato.koshikawa.aisatsuapp

import android.app.TimePickerDialog
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.sql.Time
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.button1 -> showTimePickerDialog()
        }
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                    detectTime("$hour");
                    Log.d("UI_PARTS", "$hour:$minute")
                },
                13, 0, true)
        timePickerDialog.show()
    }

    private fun detectTime(hourOfDay: String) {
        val time = hourOfDay.toInt()

        if (time >= 2 && time <= 9) {
            textView1.text = "「おはよう」"
        } else if (time >= 10 && time <= 17) {
            textView1.text = "「こんにちは」"
        } else {
            textView1.text = "「こんばんは」"
        }
    }
}