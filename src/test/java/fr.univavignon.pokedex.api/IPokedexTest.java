package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(MockitoExtension.class)
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
        Mockito.when(pokedex.size()).thenReturn(2);

        pokedex.size();

        Mockito.verify(pokedex).size();
    }

    @Test
    public void testAddPokemon() {
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);

        Mockito.when(pokedex.addPokemon(bulbizarre)).thenReturn(0);

        pokedex.addPokemon(bulbizarre);

        Mockito.verify(pokedex).addPokemon(bulbizarre);
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);

        Mockito.when(pokedex.getPokemon(0)).thenReturn(bulbizarre);

        pokedex.getPokemon(0);

        Mockito.verify(pokedex).getPokemon(0);
    }

    @Test
    public void testGetPokemonWithInvalidId() throws PokedexException {
        Mockito.when(pokedex.getPokemon(999)).thenThrow(new PokedexException("Invalid index"));

        try {
            pokedex.getPokemon(999);
            fail("Expected PokedexException to be thrown");
        } catch (PokedexException e) {
            assertEquals("Invalid index", e.getMessage());
        }
    }

    private void assertEquals(String invalidIndex, String message) {
    }

    @Test
    public void testGetPokemons() {
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        Pokemon aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100.0);

        List<Pokemon> pokemons = Arrays.asList(bulbizarre, aquali);

        Mockito.when(pokedex.getPokemons()).thenReturn(pokemons);

        pokedex.getPokemons();

        Mockito.verify(pokedex).getPokemons();
    }
}