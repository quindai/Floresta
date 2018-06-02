package br.ufal.teste.floresta;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;

public class VegetacaoTeste {


	@ParameterizedTest
	@ValueSource(strings = {"NAO_TOXICO","TOXICO", "MUITO_TOXICO", "DEAD_KILLER_XTREME_TOXICO"})
	void testeToxicidade(String toxicidade) {
		ArrayList<Vegetacao> v = new ArrayList<>();
		v.add(new Cactus(new Dimension(10, 10)));
		v.add(new Cogumelo(new Dimension(10, 10)));
		v.add(new Laranjeira(new Dimension(10, 10)));
		v.add(new Arbusto(new Dimension(10, 10)));
		assertAll("toxicidades",
				() -> assertEquals(v.get(0).getToxicidadeNome(), toxicidade),
				() -> assertEquals(v.get(1).getToxicidadeNome(), toxicidade),
				() -> assertEquals(v.get(2).getToxicidadeNome(), toxicidade),
				() -> assertEquals(v.get(3).getToxicidadeNome(), toxicidade)
				);
	}
	 
	
	@Test
	public void testeToxicidade() {
		
	}
	
	@ParameterizedTest
	@ArgumentsSource(MyArgumentsProvider.class)
	void testWithArgumentsSource(String argument) {
	    assertNotNull(argument);
	}

	public class MyArgumentsProvider implements ArgumentsProvider {

	    @Override
	    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
	        return Stream.of("foo", "bar").map(Arguments::of);
	    }
	}
}
