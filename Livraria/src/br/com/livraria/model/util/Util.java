package br.com.livraria.model.util;

import java.sql.Date;

public class Util {
	
	public static Date getSqlDate(java.util.Date date) {
		Date sqlDate = null;
		if (date != null) {
			sqlDate = new java.sql.Date(date.getTime());
		}
		return sqlDate;
	}
	

}
