package br.ufal.teste.floresta;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.awt.Dimension;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@DisplayName("Testes das classes do tipo Animal")
@RunWith(JUnitPlatform.class)
public class AnimalTeste {
	
	
	@Test
	void testeReproduzir() {
		assertThrows(NullPointerException.class,
	            ()->{
	             final Animal animal = null;
	             animal.mover();
	            });

	}
	
	@TestFactory
	Stream<DynamicNode> testeComer() throws Exception {
		Vegetacao c = new Cogumelo(new Dimension(10,10));
		Animal d = new Tartaruga(new Dimension(10,10));
		Animal e = new Rato(new Dimension(10,10));
		Animal a = new Lobo(new Dimension(10, 10));
		Animal b = new Coelho(new Dimension(10,10));
		
		b.x = a.getX();
		b.y = a.getY();
		
		return Stream.of(a, b, c)
				.map(input -> dynamicContainer("Comer :", Stream.of(
						dynamicTest("nao eh animal", () -> assertThrows(ClassCastException.class, () -> a.comer(c))),
						dynamicTest("comendo coelho", () -> assertTrue(a.comer(b))),
						dynamicTest("comendo tartaruga", () -> assertTrue(a.comer(d))),
						dynamicTest("rato comendo", () -> assertTrue(e.comer(c)))
						)));
	/*	assertAll("atividade comer",
				() -> assertThrows(ClassCastException.class, () -> a.comer(c))
				//() -> assertFalse(a.comer(c))			
				);
				*/
	//	return null;
	}
	
	@Test
	void testeComer1() {
		Animal a = new Lobo(new Dimension(10, 10));
		Animal b = new Coelho(new Dimension(10,10));
		assertFalse(a.comer(b));

		b.x = a.getX();
		b.y = a.getY();
		int tvida = a.getTempoVida();
		
		assertTrue(a.comer(b));
		assertNotEquals(a.getTempoVida(), tvida);
	}
	
	@Test
	void testeMover() {
		Animal a = new Lobo(new Dimension(10, 10));

		int x = a.getX();
		int y = a.getY();
		a.mover();
		
		int xx = a.getX();
		int yy = a.getY();
		
		assertFalse(x == xx);
		assertFalse(y == yy);
	}
	
}
