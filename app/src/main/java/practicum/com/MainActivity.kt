package practicum.com

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.text.NumberFormat


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val days = arrayOf<String>("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
        val minTemp = IntArray(7)
        val maxTemp = IntArray(7)
        val weatherArray = Array(7) {""}
        val addInfoButton = findViewById<Button>(R.id.addInfoButton)
        val clearButton = findViewById<Button>(R.id.clearButton)
        val detailedButton = findViewById<Button>(R.id.detailedButton)
        var inputMinNumber = findViewById<EditText>(R.id.inputMinNumber)
        var inputMaxNumber = findViewById<EditText>(R.id.inputMaxNumber)
        var inputWeather = findViewById<EditText>(R.id.inputWeather)
        val errorMsg = "Error Detected. Please enter all information."
        var total = 0f
        var aveTemp = 0f
        var aveTempText = findViewById<TextView>(R.id.aveTempText)

        var i = 0
        detailedButton.setOnClickListener {
            val intent2 = Intent(this, DetailedViewScreen::class.java)
            intent2.putExtra("days", days)
            intent2.putExtra("minTemp", minTemp)
            intent2.putExtra("maxTemp", maxTemp)
            intent2.putExtra("weatherArray", weatherArray)
            startActivity(intent2)
        }


        clearButton.setOnClickListener {
            while (i < 7) {
                minTemp[i] = 0
                maxTemp[i] = 0
                weatherArray[i] = " "
                i = i + 1
                }
            Toast.makeText(this, "Data cleared", Toast.LENGTH_SHORT).show()
            i = 0
        }


        addInfoButton.setOnClickListener {
            val inputMinText = inputMinNumber.text.toString()
            val inputMaxText = inputMaxNumber.text.toString()
            val weatherText = inputWeather.text.toString()

            if (inputMinText.isNotBlank() && inputMaxText.isNotBlank() && weatherText.isNotBlank()) {
                val inputMinNumber = inputMinText.toInt()
                val inputMaxNumber = inputMaxText.toInt()

                if (i < 7) {
                    minTemp[i] = inputMinNumber
                    maxTemp[i] = inputMaxNumber
                    weatherArray[i] = weatherText
                    Toast.makeText(this, "Data recorded", Toast.LENGTH_SHORT).show()


                    total = total + minTemp[i].toFloat() + maxTemp[i].toFloat()
                    i=i+1

                    aveTemp = (total/(i * 2)).toFloat()
                    aveTempText.text = "Average Temperature: $aveTemp"


                } else {
                    Toast.makeText(this, "You have entered data for all days.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show()
            }
        }




    }
}


