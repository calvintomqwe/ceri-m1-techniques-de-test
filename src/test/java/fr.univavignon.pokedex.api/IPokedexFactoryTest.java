package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IPokedexFactoryTest {

    private IPokemonMetadataProvider provider;
    private IPokemonFactory pokemonFactory;
    private IPokedexFactory pokedexFactory;
    private IPokedex pokedex;

    @Before
    public void setUp() {
        provider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory();
        pokedexFactory = new PokedexFactory();

        pokedex = pokedexFactory.createPokedex(provider, pokemonFactory);
    }

    @Test
    public void testCreatePokedex() {
        assertNotNull(pokedex);
        assertTrue(pokedex instanceof Pokedex);
    }
}