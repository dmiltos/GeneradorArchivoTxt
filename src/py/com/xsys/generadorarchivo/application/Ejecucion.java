package py.com.xsys.generadorarchivo.application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import py.com.xsys.generadorarchivo.dao.FacturaDao;
import py.com.xsys.generadorarchivo.model.Factura;

public class Ejecucion {

	public static void main(String[] args) {
		FacturaDao facturaDao = new FacturaDao();
		List<Factura> facturas = facturaDao.listarFacturas();
				
		JSONArray jArray =  new JSONArray();
		for (Factura fact: facturas) {			
			
			Map<String,Object> temp = new HashMap<String, Object>(); 
			temp.put("tipo", fact.getTipoFactura());
			
			JSONObject jsonObj = new JSONObject(temp);
			
			jArray.add(jsonObj);
		}
		
		try {
			FileWriter fileWriter = new FileWriter("resultado.txt", true);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			writer.write(jArray.toJSONString());
			writer.newLine();
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
