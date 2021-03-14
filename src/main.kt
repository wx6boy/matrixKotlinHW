import matrix.Matrix
import matrix.Complex


fun main(args: Array<String>) {
    val data = arrayOf(
        arrayOf(Complex(10.0, 3.6), Complex(4.1, 2.3), Complex(0.0, 1.7)),
        arrayOf(Complex(4.1, -1.0), Complex(6.1, 1.3), Complex(2.0, 4.1)),
        arrayOf(Complex(1.0, 3.0), Complex(1.2, 4.4), Complex(1.3, 3.0))
    )
    val matrix_first = Matrix(3, 3, data)
    val matrix_second = Matrix(3,3, data)
    val matrix_transposed = matrix_first.transpose()
    val matrix_sum = matrix_first + matrix_second;
    val matrix_times = matrix_first * matrix_second;
    println("Matrix: ")
    println(matrix_first)
    println("Transposed matrix: ")
    println(matrix_transposed)
    println("Matrix + matrix: ")
    println(matrix_sum)
    println("Matrix * transposed matrix: ")
    println(matrix_times)
}