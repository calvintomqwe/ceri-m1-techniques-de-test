package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        pokemonFactory = new PokemonFactory();
    }

    @Test
    public void testCreatePokemon() throws PokedexException {
        int index = 0;
        int cp = 500;
        int hp = 60;
        int dust = 4000;
        int candy = 3;

        Pokemon pokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy);

        assertNotNull(pokemon);
        assertEquals(index, pokemon.getIndex());
        assertEquals(cp, pokemon.getCp());
        assertEquals(hp, pokemon.getHp());
        assertEquals(dust, pokemon.getDust());
        assertEquals(candy, pokemon.getCandy());
    }

    @Test
    public void testCreatePokemonWithDifferentIndex() throws PokedexException {
        int index = 133;
        int cp = 1000;
        int hp = 120;
        int dust = 5000;
        int candy = 10;

        Pokemon pokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy);

        assertNotNull(pokemon);
        assertEquals(index, pokemon.getIndex());
        assertEquals(cp, pokemon.getCp());
        assertEquals(hp, pokemon.getHp());
        assertEquals(dust, pokemon.getDust());
        assertEquals(candy, pokemon.getCandy());
    }

    @Test(expected = PokedexException.class)
    public void testCreatePokemonWithInvalidIndex() throws PokedexException {
        int index = -1;
        int cp = 500;
        int hp = 60;
        int dust = 4000;
        int candy = 3;

        pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    @Test(expected = PokedexException.class)
    public void testCreatePokemonWithIndexOutOfUpperBound() throws PokedexException {
        int index = 155;
        int cp = 500;
        int hp = 60;
        int dust = 4000;
        int candy = 3;

        pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }
}