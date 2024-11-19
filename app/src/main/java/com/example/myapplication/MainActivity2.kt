package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val nombre = intent.getStringExtra("EXTRA_TEXTO") ?: "Desconocido"

        val textView5 = findViewById<TextView>(R.id.textView5)

        textView5.text = "Bienvenido, $nombre. Elige a tu sucesor."

        val textView1 = findViewById<TextView>(R.id.textView2)
        val checkBox1 = findViewById<CheckBox>(R.id.checkBox)
        val checkBox2 = findViewById<CheckBox>(R.id.checkBox2)


        checkBox1.setOnCheckedChangeListener { _, isChecked ->
            Log.d("CHECKBOXES", "Raenira Targaryen: $isChecked")
            updateText(textView1, checkBox1, checkBox2)
        }

        checkBox2.setOnCheckedChangeListener { _, isChecked ->
            Log.d("CHECKBOXES", "Aegon Targaryen: $isChecked")
            updateText(textView1, checkBox1, checkBox2)

        }

        val button = findViewById<Button>(R.id.button2)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)

            val nom = when {
                checkBox1.isChecked && checkBox2.isChecked -> {
                    "Jugar a dos bandas es muy peligroso... Tu cabeza podrá rodar en cualquier momento."
                }

                checkBox1.isChecked -> {
                    "Has elegido a Raenira Targaryen como sucesora."
                }

                checkBox2.isChecked -> {
                    "Has elegido a Aegon Targaryen como sucesor."
                }

                else -> {
                    "Elige a tu sucesor entre Raenira y Aegon Targaryen."

                }

            }
            intent.putExtra("texto2", nom)
            startActivity(intent)
        }
}



    private fun updateText(textView: TextView, checkBox1: CheckBox, checkBox2: CheckBox) {
        when {
            checkBox1.isChecked && checkBox2.isChecked -> {
                textView.text = "Jugar a dos bandas es muy peligroso... Tu cabeza podrá rodar en cualquier momento."
            }
            checkBox1.isChecked -> {
                textView.text = "Has elegido a Raenira Targaryen como sucesora."
            }
            checkBox2.isChecked -> {
                textView.text = "Has elegido a Aegon Targaryen como sucesor."
            }
            else -> {
                textView.text = "Elige a tu sucesor entre Raenira y Aegon Targaryen."
            }
        }
    }
}
