package py.com.xsys.generadorarchivo.application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import py.com.xsys.generadorarchivo.dao.FacturaDao;
import py.com.xsys.generadorarchivo.model.Factura;

public class Ejecucion {
	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");
	private static final SimpleDateFormat DATE_TIME_FORMATTER = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		FacturaDao facturaDao = new FacturaDao();
		List<Factura> facturas = facturaDao.listarFacturas();
		Calendar cal = Calendar.getInstance();
				
		JSONArray jArray =  new JSONArray();
		
		for (Factura factura: facturas) {
	
			JSONObject resultado = new JSONObject();
			
			JSONObject atributos = new JSONObject();			
			atributos.put("fechaCreacion", DATE_FORMATTER.format(cal.getTime()));
			atributos.put("fechaHoraCreacion", DATE_TIME_FORMATTER.format(cal.getTime()));
			
			resultado.put("atributos", atributos);

			JSONObject informado = new JSONObject();
			informado.put("telefono", factura.getTelefono());
			informado.put("pais", factura.getPais());
			informado.put("correoElectronico", factura.getCorreo());
			informado.put("direccion", "");
			informado.put("domicilio", factura.getDireccion());
			informado.put("nombre", factura.getCliente());
			informado.put("identificacion", factura.getIdentificacion());
			informado.put("tipoIdentificacion", factura.getTipoIdentificacion());
			informado.put("dv", factura.getDigitoVerificador());
			informado.put("ruc", factura.getIdentificacion());
			informado.put("situacion", factura.getSituacion());
			
			resultado.put("informado", informado);
						
			JSONObject transaccion = new JSONObject();
			transaccion.put("condicionCompra", factura.getCondicionCompra());
			transaccion.put("cuotas", factura.getCuotas());
			transaccion.put("tipoComprobante", Integer.valueOf(factura.getTipoFactura()));
			transaccion.put("numeroComprobanteVenta", factura.getNumero());
			transaccion.put("fecha", DATE_FORMATTER.format(factura.getFecha().getTime()));
			transaccion.put("numeroTimbrado", factura.getTimbrado());
			
			resultado.put("transaccion", transaccion);
			
			JSONObject detalle = new JSONObject();
			detalle.put("cantidad", factura.getCantidad());
			detalle.put("tasaAplica", "5");
			detalle.put("precioUnitario", factura.getImporteGrav5());
			detalle.put("descripcion", factura.getDescripcion());
			
			JSONArray arrayDetalle = new JSONArray();
			arrayDetalle.add(detalle);			
			resultado.put("detalle", arrayDetalle);
			
			JSONObject retencion = new JSONObject();
			retencion.put("fecha", DATE_FORMATTER.format(cal.getTime()));
			retencion.put("moneda", factura.getMoneda());
			retencion.put("retencionRenta", false);
			retencion.put("conceptoRenta", "");
			retencion.put("retencionIva", true);
			retencion.put("conceptoIva", factura.getConceptoIva());
			retencion.put("rentaPorcentaje", 0);
			retencion.put("rentaCabezasBase", 0);
			retencion.put("rentaCabezasCantidad", 0);
			retencion.put("rentaToneladasBase", 0);
			retencion.put("rentaToneladasCantidad", 0);
			retencion.put("ivaPorcentaje5", 30);
			retencion.put("ivaPorcentaje10", 30);
			
			resultado.put("retencion", retencion);
			
			JSONObject jsonObj = new JSONObject(resultado);
			
			jArray.add(jsonObj);
			
		} // Fin for
		
		try {
			FileWriter fileWriter = new FileWriter("resultado.txt");
			BufferedWriter writer = new BufferedWriter(fileWriter);
			writer.write(jArray.toString());
			writer.newLine();
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}