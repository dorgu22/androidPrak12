package com.example.prak13

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private var sequenceJob: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button = findViewById<Button>(R.id.button1)
        val textView = findViewById<TextView>(R.id.textView1)

        button.setOnClickListener {
            textView.text = "Hello World!"
        }

        val phrases: List<String> = listOf("Джулия Шмячк", "Загубил вялого", "Расслоение мозжечка",
            "Ступор мозговины", "Чем выше ты поднялся, тем больнее падать")
        val button2 = findViewById<Button>(R.id.button2)

        button2.setOnClickListener {
            if(sequenceJob?.isActive == true)
            {
                return@setOnClickListener
            }

            button2.isEnabled = false

            sequenceJob = lifecycleScope.launch {
                for(i in phrases)
                {
                    textView.text = i
                    delay(1000L)
                }
            }

            button2.isEnabled = true
        }

        val button3 = findViewById<Button>(R.id.button3)
        var counter = 0

        button3.setOnClickListener {
            if(counter > 4) counter = 0

            textView.text = phrases.elementAt(counter)
            counter++
        }

        val images = listOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
        )

        val imageView = findViewById<ImageView>(R.id.imageView1)
        val button4 = findViewById<Button>(R.id.button4)
        var counterImage = 0

        button4.setOnClickListener {
            if(counterImage > 4) counterImage = 0

            imageView.setImageResource(images.elementAt(counterImage))
            counterImage++
        }

        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val textView2 = findViewById<TextView>(R.id.textView2)

        button5.setOnClickListener {
            textView2.setBackgroundColor(0xFF00FF00.toInt())
            textView2.text = "ПРАВИЛЬНО!"

            button5.isEnabled = false
            button6.isEnabled = false
        }

        button6.setOnClickListener {
            textView2.setBackgroundColor(0xFFFF0000.toInt())
            textView2.text = "НЕ ПРАВИЛЬНО!"

            button5.isEnabled = false
            button6.isEnabled = false
        }
    }
}