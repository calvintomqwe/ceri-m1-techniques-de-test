package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.Comparator;

public class IPokedexTest {

    private IPokedex pokedex;
    private Pokemon bulbizarre;
    private Pokemon aquali;
    private Comparator<Pokemon> byName;

    @Before
    public void setUp() throws PokedexException {
        PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        PokemonFactory pokemonFactory = new PokemonFactory();
        pokedex = new Pokedex(metadataProvider, pokemonFactory);

        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100.0);

        pokedex.addPokemon(bulbizarre);

        byName = Comparator.comparing(Pokemon::getName);
    }

    @Test
    public void testSize() {
        int size = pokedex.size();
        assertEquals(2, size);
    }

    @Test
    public void testAddPokemon() {
        assertEquals(2, pokedex.addPokemon(bulbizarre));
        assertEquals(3, pokedex.size());
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        assertEquals(bulbizarre, pokedex.getPokemon(0));
    }

    @Test
    public void testGetPokemons() {
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertNotNull(pokemons);
        assertEquals(2, pokemons.size());
        assertEquals(bulbizarre, pokemons.get(0));
        assertEquals(aquali, pokemons.get(1));
    }

    @Test
    public void testGetPokemonsSorted() {
        List<Pokemon> pokemons = pokedex.getPokemons(byName);
        assertNotNull(pokemons);
        assertEquals(2, pokemons.size());
        assertEquals(aquali, pokemons.get(0));
    }

    @Test
    public void testGetPokemonInvalidId() {
        PokedexException exception = assertThrows(PokedexException.class, () -> {
            pokedex.getPokemon(999);
        });

        assertEquals("Invalid ID", exception.getMessage());
    }

    @Test
    public void testCreatePokemon() {
        Pokemon newPokemon = pokedex.createPokemon(25, 150, 120, 2000, 3);

        assertNotNull(newPokemon);
        assertEquals(25, newPokemon.getIndex());
        assertEquals(150, newPokemon.getCp());
        assertEquals(120, newPokemon.getHp());
        assertEquals(2000, newPokemon.getDust());
        assertEquals(3, newPokemon.getCandy());
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata metadata = pokedex.getPokemonMetadata(0);

        assertNotNull(metadata);
        assertEquals("Bulbizarre", metadata.getName());
    }

    @Test
    public void testGetPokemonInvalidIdNegative() {

        PokedexException exception = assertThrows(PokedexException.class, () -> {
            pokedex.getPokemon(-1);
        });

        assertEquals("Invalid ID", exception.getMessage());
    }

    @Test
    public void testGetPokemonInvalidIdTooHigh() {

        PokedexException exception = assertThrows(PokedexException.class, () -> {
            pokedex.getPokemon(999);  // Supposons qu'il n'y ait pas 999 Pokémon
        });

        assertEquals("Invalid ID", exception.getMessage());
    }

    @Test
    public void testEquals() {
        PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        PokemonFactory pokemonFactory = new PokemonFactory();
        IPokedex anotherPokedex = new Pokedex(metadataProvider, pokemonFactory);

        anotherPokedex.addPokemon(bulbizarre);

        assertEquals(pokedex, anotherPokedex);

        anotherPokedex.addPokemon(aquali);

        assertNotEquals(pokedex, anotherPokedex);
    }

    @Test
    public void testHashCode() {
        PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        PokemonFactory pokemonFactory = new PokemonFactory();
        IPokedex anotherPokedex = new Pokedex(metadataProvider, pokemonFactory);

        anotherPokedex.addPokemon(bulbizarre);

        assertEquals(pokedex.hashCode(), anotherPokedex.hashCode());

        anotherPokedex.addPokemon(aquali);

        assertNotEquals(pokedex.hashCode(), anotherPokedex.hashCode());
    }

    @Test
    public void testEqualsWithSelf() {
        assertEquals(pokedex, pokedex);
    }

    @Test
    public void testEqualsWithNull() {
        assertNotEquals(pokedex, null);
    }


    @Test
    public void testEqualsWithDifferentClass() {
        Object notPokedex = new Object();
        assertNotEquals(pokedex, notPokedex);
    }

    @Test
    public void testEqualsWithDifferentObjectType() {
        Object notPokedex = new Object();
        assertNotEquals(pokedex, notPokedex);
    }


}