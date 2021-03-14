package matrix


class Complex constructor(re : Double, im : Double) {

    var im : Double
    var re : Double
    init{
        this.im = im
        this.re = re
    }

    override fun toString() : String{
        var result = String.format("%.2f ", re)
        if (im == 0.0) {
            return result
        }
        if (im > 0){
            result += String.format("+ %.2f", im)
        }
        else {
            result += String.format(" %.2f", im)
        }
        result += "*i"
        return result
    }

    operator fun plus(otherValue: Complex): Complex{
        return Complex(re + otherValue.re, im + otherValue.im)
    }

    operator fun plus(otherValue: Double): Complex{
        return Complex(re + otherValue, im)
    }

    operator fun minus(otherValue: Complex): Complex{
        return Complex(re - otherValue.re, im - otherValue.im)
    }

    operator fun minus(otherValue: Double): Complex{
        return Complex(re - otherValue, im)
    }

    operator fun times(otherValue: Complex): Complex{
        return Complex(re * otherValue.re - im * otherValue.im,
            re * otherValue.im + im * otherValue.re)
    }

    operator fun times(otherValue: Double): Complex{
        return Complex(re * otherValue,  im * otherValue)
    }
}