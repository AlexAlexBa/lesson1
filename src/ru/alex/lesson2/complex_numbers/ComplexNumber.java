package ru.alex.lesson2.complex_numbers;

public class ComplexNumber {

    private double real;
    private double imaginary;

    public ComplexNumber(double real) {
        this.real = real;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber addition(ComplexNumber complexNumber) {
        return new ComplexNumber(this.real + complexNumber.getReal(), this.imaginary + complexNumber.getImaginary());
    }

    public ComplexNumber subtraction(ComplexNumber complexNumber) {
        return new ComplexNumber(this.real - complexNumber.getReal(), this.imaginary - complexNumber.getImaginary());
    }

    public ComplexNumber multiplication(ComplexNumber complexNumber) {
        double realTemp = this.real * complexNumber.real - this.imaginary * complexNumber.imaginary;
        double imaginaryTemp = this.real * complexNumber.imaginary + this.imaginary * complexNumber.real;
        return new ComplexNumber(realTemp,imaginaryTemp);
    }

    public double module() {
        return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginary, 2));
    }

    @Override
    public String toString() {
        return (this.imaginary < 0)
                ? (this.real + "" + this.imaginary + "i")
                : (this.real + "" + "+" + this.imaginary + "i");
    }
}
