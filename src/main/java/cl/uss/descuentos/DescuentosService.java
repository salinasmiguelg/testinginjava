package cl.uss.descuentos;

import org.springframework.stereotype.Service;

@Service 
public class DescuentosService{

	public double  aplicarDescuento(double precio, int porcentaje) {
		if(precio<0){
			throw new IllegalArgumentException("Precio negativo");
		}
		if(porcentaje<0 || porcentaje>100){
			throw new IllegalArgumentException("Precio inválido");
		}
		return precio - (precio*porcentaje/100.0); 
	}
}
