package com.android.conversor;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
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
    	DecimalFormat df = new DecimalFormat("0.000");
    	Double resultado = 0.0;
    	Log.v("1", "antes");
    	EditText TVcantidad = (EditText)findViewById(R.id.EVCantidad); 
    	Log.v("1", "despues");
    	
    	if(TVcantidad.getText().toString().length() > 0)
    	{    
    		Log.v("1", "dentro");
    		Double cantidadIntroducida = Double.parseDouble(TVcantidad.getText().toString());    	
    	
	    	if(tagPulsado.equals("dolar"))    	
	    	{
	    		TVResultadoTexto.setText(R.string.convertidoDolar);
	    		resultado =  cantidadIntroducida * DOLAR;    		
	    	}
	    	else if(tagPulsado.equals("libra"))
	    	{
	    		TVResultadoTexto.setText(R.string.convertidoLibras);
	    		resultado = cantidadIntroducida * LIBRA;    		
	    	}
	    	else if(tagPulsado.equals("yen"))
	    	{
	    		resultado = cantidadIntroducida * YEN;
	    		TVResultadoTexto.setText(R.string.convertidoYen);
	    	}
	    	
	    	String r = df.format(resultado);
	    	TVResultadoCantidad.setText(r);	    	
    	}
    	else
    	{
    		Log.v("1", TVcantidad.getText().toString());
    		TVResultadoCantidad.setText(R.string.errorCantidadNoIntroducida);
    	}
    	
    	
    }
    
}
