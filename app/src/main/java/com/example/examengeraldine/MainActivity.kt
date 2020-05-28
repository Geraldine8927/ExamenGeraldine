package com.example.examengeraldine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.examengeraldine.pagos.cliente
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
        fun calcular(v: View){
            if(validar()){
                var fac = cliente(txt_nom_clie.text.toString(), txt_dni.text.toString(), extraer())

                txt_cos_ser.setText("" + fac.costoservicio)
                txt_cos_inst.setText("" + fac.costoinstalacion)
                txt_desc.setText("" + fac.descuento)
                txt_total.setText("" + fac.total)

            }
        }

        fun servicio_instalacion() : String{
            when(extraer()){
                1 -> return "Duo - Telefono e Internet"
                2 -> return "Trio - Telefono + TV + Internet"
                3 -> return "Solo Internet"
                4 -> return "Solo telefono"
                else -> return "Solo Cable"
            }
        }

        fun imprimir(v: View){ var imp = Intent(this, ConfirmarPago :: class.java)
            imp.putExtra("nombrecliente", txt_nom_clie.text.toString())
            imp.putExtra("dni", txt_dni.text.toString())
            imp.putExtra("servicioinstalacion", servicio_instalacion())
            imp.putExtra("costoinstalacion", txt_cos_inst.text.toString())
            imp.putExtra("costoservicio", txt_cos_ser.text.toString())
            imp.putExtra("descuento", txt_desc.text.toString())
            imp.putExtra("total", txt_total.text.toString())

            startActivity(imp)
        }

        fun extraer(): Int{
            if(rdb_duo.isChecked) return 1
            else if(rdb_trio.isChecked) return 2
            else if(rdb_inter.isChecked) return 3
            else if(rdb_tel.isChecked) return 4
            else if(rdb_cable.isChecked) return 5
            else return 0
        }

        fun validar() : Boolean{
            if(txt_nom_clie.text.toString().equals("")) return false
            else if (txt_dni.text.toString().equals("")) return false
            else if (extraer() == 0) return false
            else return true
        }
    }
