package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory trainerFactory;
    private IPokedexFactory pokedexFactory;

    @Before
    public void setUp() {
        trainerFactory = new PokemonTrainerFactory();
        pokedexFactory = new IPokedexFactory() {
            @Override
            public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
                return new Pokedex(metadataProvider, pokemonFactory);
            }
        };
    }

    @org.junit.Test
    @Test
    public void testCreateTrainer() throws PokedexException {
        PokemonTrainer trainer = trainerFactory.createTrainer("Ash", Team.VALOR, pokedexFactory);
        Assert.assertNotNull("Trainer is null", trainer);
        Assert.assertEquals("Incorrect name", "Ash", trainer.getName());
        Assert.assertEquals("Incorrect team", Team.VALOR, trainer.getTeam());
        Assert.assertNotNull("Pokedex is null", trainer.getPokedex());
    }
}