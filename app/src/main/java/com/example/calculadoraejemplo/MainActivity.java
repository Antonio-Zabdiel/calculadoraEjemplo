package com.example.calculadoraejemplo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvResultado;
    float res = 0.0f;
    float ram = 0.0f;
    String operacion = "";
    boolean si = true;
    boolean positivo = true;
    boolean percent = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResultado = findViewById(R.id.tvResultado);
        AC();
    }

    public void UpdateRes(){
        String newRes = " ";
        if(percent){
            newRes = String.valueOf(res * 100) + "%";
        }else{
            newRes = String.valueOf(res);
        }
        tvResultado.setText(newRes);
    }

    public void Escribir(int num) {
        if(si){
            res = 0;
        }
        res = res * 10;
        if(positivo){
            res += num;
        }
        else {
            res -= num;
        }
        UpdateRes();
        si = false;
    }

    public void AC(View view){
        AC();
    }
    public void AC(){
        res = 0;
        ram = 0;
        operacion = "";
        UpdateRes();
        si = true;
        positivo = true;
    }

    public void Percent(View view){
        percent = !percent;
        UpdateRes();
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
    public void Equals(View view){
        Operacion(operacion);
        operacion = "";
        res = ram;
        UpdateRes();
        si = true;
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
            default:
                ram = res;
                break;
        }
        this.operacion = operacion;
        res = 0;
        UpdateRes();
        si = false;
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