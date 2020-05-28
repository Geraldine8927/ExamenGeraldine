package com.example.examengeraldine.pagos

class cliente {

    var nombrecliente: String = ""
    var dni: String = ""
    var servicioinstalacion: Int = 0
    var costoservicio: Double = 0.0
    var costoinstalacion: Double = 0.0
    var descuento: Double = 0.0
    var total: Double = 0.0

    constructor(nom_cli: String, dni: String, serv_inst: Int) {
        this.nombrecliente = nom_cli
        this.dni = dni
        this.servicioinstalacion = serv_inst
        this.costoinstalacion = calcular_instalacion(serv_inst)
        this.costoservicio = calcular_servicio(serv_inst)
        this.descuento = calcular_descuento(serv_inst)
        this.total = costoinstalacion + costoservicio - descuento

    }

    fun calcular_servicio(serv_inst: Int): Double {
        when (serv_inst) {
            1 -> return 109.00
            2 -> return 159.00
            3 -> return 89.00
            4 -> return 59.00
            else -> return 79.00
        }
    }

    fun calcular_instalacion(serv_inst: Int): Double {
        when (serv_inst) {
            1 -> return 35.00
            2 -> return 60.00
            3 -> return 15.00
            4 -> return 12.00
            else -> return 15.00
        }
    }

    fun calcular_descuento(serv_inst: Int): Double {
        when (serv_inst) {
            1 -> return 109.00 * 0.05
            2 -> return 159.00 * 0.10
            3 -> return 89.00 * 0.02
            4 -> return 59.00 * 0.01
            else -> return 79.00 * 0.01
        }
    }
}