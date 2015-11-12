package py.com.xsys.generadorarchivo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import py.com.xsys.generadorarchivo.model.ConexionBd;
import py.com.xsys.generadorarchivo.model.Factura;

public class FacturaDao {
	
	private static final String SELECT_FACTURAS = "SELECT * FROM facturas";
	private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd/MM/yyyy");
	private Calendar cal = Calendar.getInstance();
	
	public List<Factura> listarFacturas(){
		List<Factura> facturas = new ArrayList<Factura>();
		PreparedStatement statement = null;
		Connection conn = null;
		
		ConexionBd conexion = new ConexionBd();
		try {
			conn = conexion.getConnection();
			statement = conn.prepareStatement(SELECT_FACTURAS);
			ResultSet result = statement.executeQuery();
			if (result.isBeforeFirst()){
				while(result.next()) {									
					Factura factura = new Factura();
					factura.setTipoFactura(result.getString(1));
					factura.setNumero(result.getLong(2));
					factura.setTimbrado(result.getLong(3));
					cal.setTime(result.getDate(4));				
					factura.setFecha(cal);
					factura.setMoneda(result.getString(5));
					factura.setCliente(result.getString(6));
					factura.setSituacion(result.getString(7));
					factura.setDireccion(result.getString(8));
					factura.setPais(result.getString(9));
					factura.setTelefono(result.getString(10));
					factura.setCorreo(result.getString(11));
					factura.setCondicionCompra(result.getString(12));
					factura.setCuotas(result.getInt(13));
					factura.setTipoIdentificacion(result.getString(14));
					factura.setIdentificacion(result.getString(15));
					factura.setDigitoVerificador(result.getInt(16));
					factura.setDescripcion(result.getString(17));
					factura.setCantidad(result.getInt(18));
					factura.setImporteExento(result.getInt(19));
					factura.setImporteGrav10(result.getInt(20));
					factura.setConceptoIva(result.getString(21));
					
					facturas.add(factura);		
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			closePreparedStatement(statement);
			closeConnection(conn);
		}
		return facturas;
	}
	
	
	
	private void closePreparedStatement(PreparedStatement statement) {
		if (statement != null){
			try {
				statement.close();
			} catch (SQLException e) {
			//	logger.error("closePreparedStatement SQLException " + e.getMessage());
			}
		}
	}
	
	private void closeConnection(Connection c){
		if (c != null)
			try {
				c.close();
			} catch (SQLException e) {
			//	logger.error("CloseConnection SQLException " + e.getMessage());
			}
	}

}