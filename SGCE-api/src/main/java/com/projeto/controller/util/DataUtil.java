package com.projeto.controller.util;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DataUtil {
	public static String dataAtualExtenso(){
		Date data =  new Date();
		Locale local = new Locale("pt","BR");
		DateFormat formato = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy",local);
		System.out.println(formato.format(data));
		return formato.format(data);
	}
}
