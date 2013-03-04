package com.android.conversor;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	public static final Double DOLAR = 1.308;
	public static final Double LIBRA = 0.810;
	public static final Double YEN = 108.733;
	
	TextView TVResultadoTexto;
	TextView TVResultadoCantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        TVResultadoTexto = (TextView)findViewById(R.id.TVResultadoTexto);
        TVResultadoCantidad = (TextView)findViewById(R.id.TVResultadoCantidad);
    }
    
    public void convertir(View v)
    {
    	String tagPulsado = String.valueOf(v.getTag());
    	DecimalFormat df = new DecimalFormat("#.00000");
    	Double resultado = 0.0;
    	Double cantidad;
    	EditText TVcantidad = (EditText)findViewById(R.id.EVCantidad);    	
    	cantidad = Double.parseDouble(TVcantidad.getText().toString());
    	
    	if(tagPulsado.equals("dolar"))
    	{
    		TVResultadoTexto.setText("Valor convertiodo a $:");
    		resultado =  cantidad * DOLAR;    		
    	}
    	else if(tagPulsado.equals("libra"))
    	{
    		TVResultadoTexto.setText("Valor convertiodo a £:");
    		resultado = cantidad * LIBRA;    		
    	}
    	else if(tagPulsado.equals("yen"))
    	{
    		resultado = cantidad * YEN;
    		TVResultadoTexto.setText("Valor convertiodo a ¥:");
    	}
    	TVResultadoCantidad.setText((resultado.toString()));
    }
    
}
