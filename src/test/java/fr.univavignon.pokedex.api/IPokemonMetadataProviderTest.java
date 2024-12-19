package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider metadataProvider;

    @Before
    public void setUp() {
        metadataProvider = new PokemonMetadataProvider();
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(0);
        assertNotNull(metadata);
        assertEquals(0, metadata.getIndex());
        assertEquals("Bulbizarre", metadata.getName());
        assertEquals(126, metadata.getAttack());
        assertEquals(126, metadata.getDefense());
        assertEquals(90, metadata.getStamina());
    }

    @Test
    public void testGetPokemonMetadataForAquali() throws PokedexException {
        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(133);
        assertNotNull(metadata);
        assertEquals(133, metadata.getIndex());
        assertEquals("Aquali", metadata.getName());
        assertEquals(186, metadata.getAttack());
        assertEquals(168, metadata.getDefense());
        assertEquals(260, metadata.getStamina());
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataWithInvalidIndex() throws PokedexException {
        metadataProvider.getPokemonMetadata(-1);
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataWithIndexOutOfBounds() throws PokedexException {
        metadataProvider.getPokemonMetadata(155);
    }
}