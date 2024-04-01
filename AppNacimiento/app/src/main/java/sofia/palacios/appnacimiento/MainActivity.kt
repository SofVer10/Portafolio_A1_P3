package sofia.palacios.appnacimiento

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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

        val lblResultado= findViewById<TextView>(R.id.lblResultado)
        val txtNacimiento = findViewById<EditText>(R.id.txtNacimiento)
        val btnValorar = findViewById<Button>(R.id.btnValorar)

        val objNac = Nacimiento()


        btnValorar.setOnClickListener {
            val resul = objNac.edad(txtNacimiento.text.toString().toInt())

            println("Su edad es: $resul años")

            lblResultado.text = "Su edad es: $resul años"
        }


    }
}