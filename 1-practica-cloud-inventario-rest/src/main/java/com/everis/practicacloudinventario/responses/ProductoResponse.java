package com.everis.practicacloudinventario.responses;

import com.everis.practicacloudinventario.model.Producto;

public class ProductoResponse {
	
	private boolean exito;
	
	private String mensaje;
	
	private Producto producto;

	public boolean isExito() {
		return exito;
	}

	public void setExito(boolean exito) {
		this.exito = exito;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
}
