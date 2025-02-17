class Coche(
    marca: String,
    modelo: String,
    numCaballos: Int,
    numPuertas: Int,
    matricula: String,
    color: String
) {
    var marca: String = marca
        private set(value) {
            require(value.isNotBlank()) { "La marca no puede ser blanca o nula" }
            field = value.capitalize()
        }

    var modelo: String = modelo
        private set(value) {
            require(value.isNotBlank()) { "El modelo no puede ser blanco o nulo" }
            field = value.capitalize()
        }

    var numCaballos: Int = numCaballos
        private set(value) {
            require(value in 70..700) { "El número de caballos debe estar entre 70 y 700" }
            field = value
        }

    var numPuertas: Int = numPuertas
        private set(value) {
            require(value in 3..5) { "El número de puertas debe estar entre 3 y 5" }
            field = value
        }

    var matricula: String = matricula
        private set(value) {
            require(value.length == 7) { "La matrícula debe tener 7 caracteres" }
            field = value
        }

    var color: String = color
        set(value) {
            require(value.isNotBlank()) { "El color no puede ser blanco o nulo" }
            field = value
        }

    init {
        require(marca.isNotBlank()) { "La marca no puede ser blanca o nula" }
        require(modelo.isNotBlank()) { "El modelo no puede ser blanco o nulo" }
        require(numCaballos in 70..700) { "El número de caballos debe estar entre 70 y 700" }
        require(numPuertas in 3..5) { "El número de puertas debe estar entre 3 y 5" }
        require(matricula.length == 7) { "La matrícula debe tener 7 caracteres" }
        require(color.isNotBlank()) { "El color no puede ser blanco o nulo" }

        this.marca = this.marca.capitalize()
        this.modelo = this.modelo.capitalize()
    }

    override fun toString(): String {
        return "Coche(marca='$marca', modelo='$modelo', numCaballos=$numCaballos, numPuertas=$numPuertas, matricula='$matricula', color='$color')"
    }
}

fun main() {
    try {
        // Instanciar varios coches
        val coche1 = Coche("ford", "fiesta", 100, 5, "1234ABC", "rojo")
        val coche2 = Coche("renault", "clio", 90, 3, "5678DEF", "azul")

        println("Coches iniciales:")
        println(coche1)
        println(coche2)

        // Modificar atributos
        coche1.color = "verde"
        // coche1.numCaballos = 80 // Esto no se puede hacer porque numCaballos es de solo lectura

        println("\nCoche1 después de modificar el color:")
        println(coche1)

        // Intentar modificaciones inválidas
        try {
            Coche("", "modelo", 100, 4, "1234ABC", "rojo")
        } catch (e: IllegalArgumentException) {
            println("\nError al crear coche con marca vacía: ${e.message}")
        }

        try {
            Coche("marca", "modelo", 60, 4, "1234ABC", "rojo")
        } catch (e: IllegalArgumentException) {
            println("\nError al crear coche con menos de 70 caballos: ${e.message}")
        }

        try {
            Coche("marca", "modelo", 100, 2, "1234ABC", "rojo")
        } catch (e: IllegalArgumentException) {
            println("\nError al crear coche con menos de 3 puertas: ${e.message}")
        }

        try {
            Coche("marca", "modelo", 100, 4, "123ABC", "rojo")
        } catch (e: IllegalArgumentException) {
            println("\nError al crear coche con matrícula inválida: ${e.message}")
        }

        try {
            coche1.color = ""
        } catch (e: IllegalArgumentException) {
            println("\nError al modificar el color a vacío: ${e.message}")
        }

    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }

}