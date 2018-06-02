package br.ufal.teste.floresta;

import static org.junit.Assert.assertTrue;

import java.awt.Dimension;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class LoboTeste {

	private Lobo l;
	@BeforeEach
	public void setUp() {
		l = new Lobo(new Dimension(10,10));
	}
	
	@Test
	void testLoboTipo( ) {
		l.margem = 0;
	    assertTrue(l.margem==0 && l.getEstado().equals("MANSO")) ;
	    l.margem = 1;
	    assertTrue(l.margem==1 && l.getEstado().equals("FAMINTO")) ;
	    l.margem = 2;
	    assertTrue(l.margem==2 && l.getEstado().equals("FURIOSO")) ;
	    l.margem = 3;
	    assertTrue(l.margem==3 && l.getEstado().equals("RAIVOSO")) ;
	}
	
	public static Stream<String> stringProvider() {
	    return Stream.of("MANSO", "FAMINTO", "FURIOSO", "RAIVOSO");
	}
}
