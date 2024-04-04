package sofia.palacios.AppTriangulo

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


        val txtBase = findViewById<EditText>(R.id.txtBase)
        val txtAltura = findViewById<EditText>(R.id.txtAltura)
        val btnResultado = findViewById<Button>(R.id.btnResultado)
        val lblResultado= findViewById<TextView>(R.id.lblResultado)

        val objArea = Area()

        btnResultado.setOnClickListener {
            val resul =  objArea.calcular(txtBase.text.toString().toInt(), txtAltura.text.toString().toInt())

            println("Esta es el área del triángulo: $resul")

            lblResultado.text = "El área del triángulo es: $resul"
    }
}
}