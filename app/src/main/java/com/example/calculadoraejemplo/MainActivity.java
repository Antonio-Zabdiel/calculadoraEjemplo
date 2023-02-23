package com.example.calculadoraejemplo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvResultado;
    double res = 0.0;
    double ram = 0.0;
    String resRam = "0";
    String operacion = "";
    boolean positivo = true;
    int decimalPlace = 0;
    boolean point = false;
    boolean newNum = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResultado = findViewById(R.id.tvResultado);
        AC();
    }

    public void UpdateRes(){
        String newRes = "";
        boolean error = Double.isNaN(res) || Double.isInfinite(res);
        if(!error) {
            newRes = String.valueOf(res);
        }
        else{
            newRes = "Operacion invalida";
        }
        writeRes(newRes);
    }

    public void writeRes(String res){
        tvResultado.setText(res);
    }

    public void Escribir(int num) {
        double numRam = num;
        double resRam = res;

        if(newNum){
            resRam = 0;
            positivo = true;
        }

        if(!positivo){
            numRam = numRam * -1;
        }

        if(newNum){
            point = false;
            decimalPlace = 0;
        }else{
            if(point){
                decimalPlace ++;
            }
        }

        if(!point){
            resRam = resRam * 10;
        }

        for(int i = 0; i < decimalPlace; i++){
            numRam = numRam/10;
        }

        resRam += numRam;
        res = resRam;
        UpdateRes();
        newNum = false;
    }

    public void Point(View view){
        if(!point){
            resRam += ".";
        }
        point = true;
    }

    public void AC(View view){
        AC();
    }

    public void AC(){
        res = 0;
        ram = 0;
        operacion = "";
        UpdateRes();
        positivo = true;
        newNum = true;
    }

    public void Percent(View view){
        Operacion("%");
    }
    public void Change(View view){
        res = res * -1;
        positivo = 0 <= res;
        UpdateRes();
    }

    public void Plus(View view){
        Operacion("+");
    }

    public void Minus(View view){
        Operacion("-");
    }

    public void Div(View view){
        Operacion("/");
    }

    public void Times(View view){
        Operacion("*");
    }

    public void Pow(View view) { Operacion("^"); }

    public void Equals(View view){
        Operacion(operacion);
        operacion = "";
        res = ram;
        UpdateRes();
    }

    public void Operacion(String operacion){
        switch (this.operacion){
            case "+":
                ram = ram + res;
                break;
            case "-":
                ram = ram - res;
                break;
            case  "*":
                ram = ram * res;
                break;
            case "/":
                ram = ram / res;
                break;
            case "%":
                ram = ram * res / 100;
                break;
            case "^":
                ram = Math.pow(ram, res);
                break;
            default:
                ram = res;
                break;
        }

        this.operacion = operacion;
        res = 0;
        UpdateRes();
        newNum = true;
    }

    public void OperacionSingle(String operacion) {
        switch (operacion) {
            case "inv":
                res = 1 / res;
                break;
            case "log":
                res = Math.log10(res);
                break;
            case "ln":
                res = Math.log(res);
                break;
            case "sin":
                res = Math.sin(Math.toRadians(res));
                break;
            case "cos":
                res = Math.cos(Math.toRadians(res));
                break;
            case "tan":
                res = Math.tan(Math.toRadians(res));
                break;
            case "rnd":
                res = Math.random();
                break;
            default:
                res = res;
                break;
        }
        UpdateRes();
        newNum = true;
    }

    public void Inverse(View view) {
        OperacionSingle("inv");
    }

    public void Log(View view){
        OperacionSingle("log");
    }

    public void Ln(View view){
        OperacionSingle("ln");
    }

    public void Sin(View view){
        OperacionSingle("sin");
    }

    public void Cos(View view){
        OperacionSingle("cos");
    }

    public void Tan(View view){
        OperacionSingle("tan");
    }

    public void Rnd(View view){
        OperacionSingle("rnd");
    }

    public void Escribir0(View view) {
        Escribir(0);
    }

    public void Escribir1(View view) {
        Escribir(1);
    }

    public void Escribir2(View view) {
        Escribir(2);
    }

    public void Escribir3(View view) {
        Escribir(3);
    }

    public void Escribir4(View view) {
        Escribir(4);
    }

    public void Escribir5(View view) {
        Escribir(5);
    }

    public void Escribir6(View view) {
        Escribir(6);
    }

    public void Escribir7(View view) {
        Escribir(7);
    }

    public void Escribir8(View view) {
        Escribir(8);
    }

    public void Escribir9(View view) {
        Escribir(9);
    }
}
