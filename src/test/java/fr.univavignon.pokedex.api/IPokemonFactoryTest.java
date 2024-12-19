package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;
    private Pokemon pokemon;

    @Before
    public void setUp() {
        pokemonFactory = new PokemonFactory();
    }

    @Test
    public void testGetPokemonCp() {
        Pokemon result = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull(result);
        assertEquals(613, result.getCp());
    }

    @Test
    public void testGetPokemonHp() {
        Pokemon result = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull(result);
        assertEquals(64, result.getHp());
    }

    @Test
    public void testGetPokemonDust() {
        Pokemon result = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull(result);
        assertEquals(4000, result.getDust());
    }

    @Test
    public void testGetPokemonCandy() {
        Pokemon result = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull(result);
        assertEquals(4, result.getCandy());
    }

    @Test
    public void testGetPokemonIv() {
        Pokemon result = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull(result);

        double iv = result.getIv();
        assertTrue(iv >= 0.0 && iv <= 100.0);
    }

}