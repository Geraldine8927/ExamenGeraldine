package com.example.examengeraldine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_confirmar_pago.*

class ConfirmarPago : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmar_pago)
        btn_regresar.setOnClickListener(){
            finish()
        }

        val  bundle = intent.extras

        val nombre = bundle?.getString("nombrecliente")
        val dnicli = bundle?.getString("dni")
        val servicio = bundle?.getString("servicioinstalacion")
        val costoinsta = bundle?.getString("costoinstalacion")
        val costo = bundle?.getString("costoservicio")
        val desct = bundle?.getString("descuento")
        val total = bundle?.getString("total")

        tv_nom_clie.setText(nombre)
        tv_dni.setText(dnicli)
        tv_serv_inst.setText(servicio)
        tv_cot_inst.setText(costoinsta)
        tv_cost_serv.setText(costo)
        tv_desc.setText(desct)
        tv_total.setText(total)

    }
}
