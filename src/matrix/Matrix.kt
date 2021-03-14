package matrix


class Matrix constructor(n : Int, m : Int){
    var n : Int
    var m : Int
    var data : Array <Array<Complex>>

    init{
        this.n = n
        this.m = m
        this.data = Array(n) { Array(m) { i -> Complex(0.0, 0.0) } }
    }

    constructor(n: Int, m: Int, data : Array <Array<Complex>>) : this (n, m){
        this.data = data
    }

    operator fun get(row : Int, col : Int): Complex{
        return data[row][col]
    }

    operator fun set(row : Int, col : Int, value: Complex){
        data[row][col] = value
    }

    fun transpose(): Matrix{
        val resultMatrix = Matrix(m, n)
        for (i in 0 until n){
            for (j in 0 until m){
                resultMatrix[j, i] = this[i, j]
            }
        }
        return resultMatrix
    }

    operator fun plus( otherMatrix: Matrix): Matrix{
        if (m != otherMatrix.m || n != otherMatrix.n){
            throw IncompatibleMatricesException("Matrices have different number of rows or columns")
        }
        val resultMatrix = Matrix(n, m)
        for (i in 0 until n){
            for (j in 0 until m){
                resultMatrix[i, j] = this[i, j] + otherMatrix[i, j]
            }
        }
        return resultMatrix
    }

    operator fun times( otherMatrix : Matrix): Matrix{
        if (n != otherMatrix.m || m != otherMatrix.n){
            throw IncompatibleMatricesException("Matrices have incompatible number of rows or columns")
        }
        val resultMatrix = Matrix(n, otherMatrix.m)
        for (i in 0 until n){
            for (j in 0 until otherMatrix.m){
                for (k in 0 until m){
                    resultMatrix[i, j] += this[i, k] * otherMatrix[k, j]
                }
            }
        }
        return resultMatrix
    }

    override fun toString(): String{
        val result = StringBuilder()
        for (i in 0 until n){
            for (j in 0 until m){
                result.append(data[i][j].toString() + " ")
            }
            result.append("\n")
        }
        return result.toString()
    }
}

class IncompatibleMatricesException(message:String): Exception(message)