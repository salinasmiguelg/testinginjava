package cl.uss.descuentos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.internal.matchers.Equals;

import static org.junit.jupiter.api.Assertions.*;


class DescuentosServiceTest{
	private final DescuentosService service = new DescuentosService();
	@Test
	void aplicarDiezPorCientoDeDescuento() {
		double precio = 1000;
		double resultado = service.aplicarDescuento(precio, 10);
		assertEquals(900.0, resultado);
	}
	@Test 
	void rechazarPrecioNegativo(){
		assertThrows(IllegalArgumentException.class, ()->service.aplicarDescuento(-1, 10));
	}
	@ParameterizedTest(name="{0} con {1}% = {2}")
	@CsvSource({"1000,0,1000","1000,50,500","1000,100,0"})
	void calcularCasosLimite(double precio, int pct, double esperado){
		assertEquals(esperado, service.aplicarDescuento(precio, pct), 0.001);
	}
}
