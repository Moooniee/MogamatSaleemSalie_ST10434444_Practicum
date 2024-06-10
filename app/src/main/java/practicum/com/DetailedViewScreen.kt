package practicum.com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class DetailedViewScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detailed_view_screen)

        val days = intent.getStringArrayExtra("days")
        val minTemp = intent.getIntArrayExtra("minTemp")
        val maxTemp = intent.getIntArrayExtra("maxTemp")
        val weatherArray = intent.getStringArrayExtra("weatherArray")

        if (days != null && minTemp != null && maxTemp != null && weatherArray != null) {
            Log.d("DetailedViewScreen", "Days: ${days.joinToString()}")
            Log.d("DetailedViewScreen", "Min Temp: ${minTemp.joinToString()}")
            Log.d("DetailedViewScreen", "Max Temp: ${maxTemp.joinToString()}")
            Log.d("DetailedViewScreen", "Weather Array: ${weatherArray.joinToString()}")

            val detailTextView = findViewById<TextView>(R.id.deatailedView)
            var detailDisplay = ""
            var i = 0
            while (i < 7) {
                detailDisplay += "${days[i]} -  ${maxTemp[i]}/${minTemp[i]} - ${weatherArray[i]}\n"
                i++
            }
            detailTextView.text = detailDisplay
        } else {
            Toast.makeText(
                this,
                "An unknown Error has occurred. Please clear and reenter information on the main page.",
                Toast.LENGTH_LONG
            ).show()
        }

        val mainButton2 = findViewById<Button>(R.id.mainButton2)
        mainButton2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}