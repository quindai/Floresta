package br.ufal.teste.floresta;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;

public class SimuladorTeste {
	
	@Test
	public void reiniciarEstadoDaAnimacaoTeste() {
		Collection<Animal> a = new ArrayList<>(10);
		Collection<Vegetacao> b = new ArrayList<>(10);
		
		assertEquals(0, a.size());
	}

}
