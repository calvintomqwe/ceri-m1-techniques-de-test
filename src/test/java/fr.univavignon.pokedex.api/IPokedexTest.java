package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class IPokedexTest {

    private IPokedex pokedex;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        metadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory();
        pokedex = new Pokedex(metadataProvider, pokemonFactory);
    }

    @Test
    public void testSize() {
        assertEquals(0, pokedex.size());
    }

    @Test
    public void testAddPokemon() {
        Pokemon pokemon = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56);
        int index = pokedex.addPokemon(pokemon);
        assertEquals(0, index);
        assertEquals(1, pokedex.size());
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        Pokemon pokemon = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56);
        pokedex.addPokemon(pokemon);
        Pokemon retrievedPokemon = pokedex.getPokemon(0);
        assertEquals(pokemon, retrievedPokemon);
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonInvalidId() throws PokedexException {
        pokedex.getPokemon(0);
    }

    @Test
    public void testGetPokemons() {
        Pokemon pokemon1 = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56);
        Pokemon pokemon2 = new Pokemon(1, "Ivysaur", 156, 158, 120, 1000, 123, 5000, 5, 60);
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(2, pokemons.size());
        assertTrue(pokemons.contains(pokemon1));
        assertTrue(pokemons.contains(pokemon2));
    }

    @Test
    public void testGetPokemonsWithOrder() {
        Pokemon pokemon1 = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56);
        Pokemon pokemon2 = new Pokemon(1, "Ivysaur", 156, 158, 120, 1000, 123, 5000, 5, 60);
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);
        List<Pokemon> pokemons = pokedex.getPokemons(Comparator.comparing(Pokemon::getCp));
        assertEquals(2, pokemons.size());
        assertEquals(pokemon1, pokemons.get(0));
        assertEquals(pokemon2, pokemons.get(1));
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata metadata = pokedex.getPokemonMetadata(0);
        assertNotNull(metadata);
        assertEquals(0, metadata.getIndex());
        assertEquals("Bulbizarre", metadata.getName());
    }
}