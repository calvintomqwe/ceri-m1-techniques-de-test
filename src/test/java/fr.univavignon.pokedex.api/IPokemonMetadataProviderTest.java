package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider metadataProvider;
    private PokemonMetadata metadata;

    @BeforeEach
    public void setUp() throws PokedexException {
        metadataProvider = new PokemonMetadataProvider();
    }

    @Test
    public void testGetPokemonMetadataIndex() throws PokedexException {
        // On test si l'index correspond quand on renseigne le bon pokemon
        PokemonMetadata result = metadataProvider.getPokemonMetadata(0);
        assertNotNull(result);
        assertEquals(0, result.getIndex());
    }

    @Test
    public void testGetPokemonMetadataName() throws PokedexException {
        PokemonMetadata result = metadataProvider.getPokemonMetadata(0);
        assertNotNull(result);
        assertEquals("Bulbizarre", result.getName());
    }

    @Test
    public void testGetPokemonMetadataAttack() throws PokedexException {
        PokemonMetadata result = metadataProvider.getPokemonMetadata(0);
        assertNotNull(result);
        assertEquals(126, result.getAttack());
    }

    @Test
    public void testGetPokemonMetadataDefense() throws PokedexException {
        PokemonMetadata result = metadataProvider.getPokemonMetadata(0);
        assertNotNull(result);
        assertEquals(126, result.getDefense());
    }

    @Test
    public void testGetPokemonMetadataStamina() throws PokedexException {
        PokemonMetadata result = metadataProvider.getPokemonMetadata(0);
        assertNotNull(result);
        assertEquals(90, result.getStamina());
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataInvalidIndexNegative() throws PokedexException {
        metadataProvider.getPokemonMetadata(-1);
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataInvalidIndexAbove() throws PokedexException {
        metadataProvider.getPokemonMetadata(151);
    }
}