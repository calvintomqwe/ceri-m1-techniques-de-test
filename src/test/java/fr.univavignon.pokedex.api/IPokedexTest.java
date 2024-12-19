package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Comparator;

@ExtendWith(MockitoExtension.class)
public class IPokedexTest {

    private IPokedex pokedex;
    private Pokemon bulbizarre;
    private Pokemon aquali;
    private Pokemon pikachu;
    private Comparator<Pokemon> byName;

    @BeforeEach
    public void setUp() throws PokedexException {

        PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        PokemonFactory pokemonFactory = new PokemonFactory();
        pokedex = new Pokedex(metadataProvider, pokemonFactory);

        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100.0);
        pikachu = new Pokemon(25, "Pikachu", 112, 90, 120, 3200, 150, 3500, 3, 35.0);

        pokedex.addPokemon(bulbizarre);
        pokedex.addPokemon(aquali);

        byName = Comparator.comparing(Pokemon::getName);

    }

    @Test
    public void testSize() {
        assertEquals(2, pokedex.size());
    }

    @Test
    public void testAddPokemon() {
        assertEquals(2, pokedex.addPokemon(pikachu));
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
        assertEquals(25, newPokemon.getIndex());  // Vérifie l'index
        assertEquals(150, newPokemon.getCp());  // Vérifie le CP
        assertEquals(120, newPokemon.getHp());  // Vérifie les HP
        assertEquals(2000, newPokemon.getDust());  // Vérifie le nombre de poussière
        assertEquals(3, newPokemon.getCandy());  // Vérifie le nombre de bonbons
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata metadata = pokedex.getPokemonMetadata(0);

        assertNotNull(metadata);
        assertEquals("Bulbizarre", metadata.getName());  // Vérifie que le nom est correct pour l'index 0
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
        anotherPokedex.addPokemon(aquali);

        assertEquals(pokedex, anotherPokedex);  // Les deux pokedex doivent être égaux

        anotherPokedex.addPokemon(pikachu);

        assertNotEquals(pokedex, anotherPokedex);  // Ils ne doivent plus être égaux après l'ajout d'un Pokémon
    }

    @Test
    public void testHashCode() {
        PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        PokemonFactory pokemonFactory = new PokemonFactory();
        IPokedex anotherPokedex = new Pokedex(metadataProvider, pokemonFactory);

        anotherPokedex.addPokemon(bulbizarre);
        anotherPokedex.addPokemon(aquali);

        assertEquals(pokedex.hashCode(), anotherPokedex.hashCode());  // Les hashCode doivent être égaux

        anotherPokedex.addPokemon(pikachu);

        assertNotEquals(pokedex.hashCode(), anotherPokedex.hashCode());  // Les hashCode doivent être différents après l'ajout d'un Pokémon
    }

    @Test
    public void testEqualsWithSelf() {
        assertEquals(pokedex, pokedex);  // Un objet est toujours égal à lui-même
    }

    @Test
    public void testEqualsWithNull() {
        assertNotEquals(pokedex, null);  // null ne doit pas être égal au Pokedex
    }


    @Test
    public void testEqualsWithDifferentClass() {
        Object notPokedex = new Object();  // Créer un objet d'une classe différente
        assertNotEquals(pokedex, notPokedex);  // Le Pokedex ne doit pas être égal à un objet d'une classe différente
    }

    @Test
    public void testEqualsWithDifferentObjectType() {
        Object notPokedex = new Object();  // Créer un objet d'une classe différente
        assertNotEquals(pokedex, notPokedex);  // Le Pokedex ne doit pas être égal à un objet d'une classe différente
    }


}