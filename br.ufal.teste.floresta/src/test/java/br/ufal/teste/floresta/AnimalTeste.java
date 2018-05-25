package br.ufal.teste.floresta;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.awt.Dimension;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class AnimalTeste {
	
	
	@Test
	void testeReproduzir() {
		assertThrows(NullPointerException.class,
	            ()->{
	             final Animal animal = null;
	             animal.reproduzir(new Object());
	            });

	}
	
	@TestFactory
	Stream<DynamicNode> testeComer() throws Exception {
		Vegetacao c = new Cogumelo(new Dimension(10,10));
		Animal a = new Lobo(new Dimension(10, 10));
		Animal b = new Coelho(new Dimension(10,10));
		b.x = a.getX();
		b.y = a.getY();
		return Stream.of(a, b, c)
				.map(input -> dynamicContainer("Comer :", Stream.of(
						dynamicTest("nao eh animal", () -> assertThrows(ClassCastException.class, () -> a.comer(c))),
						dynamicTest("comendo coelho", () -> assertTrue(a.comer(b)))		
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
		
		assertTrue(a.comer(b));
	}
}
