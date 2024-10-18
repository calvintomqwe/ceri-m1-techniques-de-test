package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(MockitoExtension.class)
public class IPokemonMetadataProviderTest {

    @Mock
    private IPokemonMetadataProvider metadataProvider;

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata bulbizarreMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);

        Mockito.when(metadataProvider.getPokemonMetadata(0)).thenReturn(bulbizarreMetadata);

        metadataProvider.getPokemonMetadata(0);

        Mockito.verify(metadataProvider).getPokemonMetadata(0);
    }

    @Test
    public void testGetPokemonMetadataWithInvalidIndex() throws PokedexException {
        Mockito.when(metadataProvider.getPokemonMetadata(999)).thenThrow(new PokedexException("Invalid index"));

        try {
            metadataProvider.getPokemonMetadata(999);
            fail("Expected PokedexException to be thrown");
        } catch (PokedexException e) {
            assertEquals("Invalid index", e.getMessage());
        }
    }
}