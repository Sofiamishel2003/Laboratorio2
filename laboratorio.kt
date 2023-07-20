package com.example.laboratorio2

/**
 * Nombre: Sofía Mishell Velasquez
 * Carnet: 22049
 * Proyecto: Laboratorio 2
 * Materia: Programación de plataformas moviles
 * Archivo: laboratorio.kt
 * Descripción: programa que tiene una función de promedio, puede filtrar un
 */
private fun calcularPromedio(numbers: IntArray): Int {
    val sum=numbers.reduce { acc, num -> acc + num }
    val promedio=sum/numbers.size
    return promedio
   }
fun isPalindrome(input: String): Boolean = input == input.reversed()
private fun performOperation(n1: Int, n2:Int,suma: (Int,Int) -> Int): Int{ return suma(n1,n2) }
data class Person(val name: String, val age: Int, val gender: String)
data class Student(val name: String, val age: Int, val gender: String, val studentId: String)
fun mapPersonToStudent(person: Person): Student {
    // Suponemos que el valor de studentId no se proporciona
    return Student(person.name, person.age, person.gender, "N/A")
}
fun main() {
    val enteros = intArrayOf(3, 5, 4, 4, 3, 1, 3, 2)    //lista de enteros
    //Inciso # 1
    println("Calcular promedio con reduce : ---------------------------------------------")
    println("El promedio entero es: "+calcularPromedio(enteros))
    //Inciso # 2
    println("Extraer numeros enteros con filter : -------------------------------------")
    println("Antes :["+enteros.joinToString()+"]")
    val filteredList: List<Int> = enteros.filter { it % 2 == 0 }       // eliminar valores impares
    println("Después: $filteredList")                                           // [4, 4, 2]                                        // [2, 4, 6, 8, 10]
    //Inciso #3
    println("Verificar si es palindrome : ----------------------------------------------")
    val str1 = "radar"
    val str2 = "hola"
    println(str1+": "+isPalindrome(str1)) // Salida: true (radar es un palíndromo)
    println(str2+": "+isPalindrome(str2)) // Salida: false (hola no es un palíndromo)
    //Inciso #4 -
    println("Nombres concatenados: ------------------------------------------------------")
    val nombres = arrayOf<String>("Majo", "Fabiola", "Sofía", "Sebastian") //lista de nombres
    println(nombres.map { "¡Hola,$it!" })
    //Inciso #5
    println("Suma de 2 valores utilizando lambda cómo parametro: ------------------------")
    val sumaFunc: (Int, Int) -> Int = { a, b -> a + b }
    val result = performOperation(5, 3, sumaFunc)
    println("Sumatoria de 5 y 3 = $result")
    //Ultima parte
    println("Mapeo de objetos: ----------------------------------------------------------")
    val personList = listOf(Person("Jose", 23, "Masculino"), Person("Fabiola", 19, "Femenino"))
    val studentList = personList.map { mapPersonToStudent(it) }
    for (student in studentList) {
        println("El Estudiante ${student.name} tiene ${student.age} años.")
    }
}