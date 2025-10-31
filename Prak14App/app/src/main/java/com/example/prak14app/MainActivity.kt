package com.example.prak14app

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.BackgroundColorSpan
import android.text.style.StyleSpan
import android.text.style.TypefaceSpan
import android.text.style.UnderlineSpan
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.provider.FontsContractCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textTop = findViewById<TextView>(R.id.textView5)
        val spannableStringTop = SpannableString(textTop.text)
        spannableStringTop.setSpan(StyleSpan(Typeface.ITALIC), 0, textTop.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE )
        textTop.text = spannableStringTop

        val textLeft = findViewById<TextView>(R.id.textView6)
        val spannableStringLeft = SpannableString(textLeft.text)
        spannableStringLeft.setSpan(StyleSpan(Typeface.BOLD_ITALIC), 0, textLeft.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE )
        textLeft.text = spannableStringLeft

        val textRight = findViewById<TextView>(R.id.textView7)
        val spannableStringRight = SpannableString(textRight.text)
        spannableStringRight.setSpan(BackgroundColorSpan(Color.BLACK), 0, textRight.length() - 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE )
        textRight.text = spannableStringRight

        val textBottom = findViewById<TextView>(R.id.textView8)
        val spannableStringBottom = SpannableString(textBottom.text)
        spannableStringBottom.setSpan(UnderlineSpan(), 0, textBottom.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE )
        textBottom.text = spannableStringBottom
    }
}