package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory trainerFactory;
    private PokemonTrainer trainer;
    private IPokedex pokedex;
    private IPokedexFactory pokedexFactory;

    @Before
    public void setUp() {
        pokedexFactory = new PokedexFactory();
        trainerFactory = new PokemonTrainerFactory();

        pokedex = pokedexFactory.createPokedex(new PokemonMetadataProvider(), new PokemonFactory());

        trainer = trainerFactory.createTrainer("Ash", Team.MYSTIC, pokedexFactory);
    }

    @Test
    public void testGetName() {
        assertNotNull(trainer);
        assertEquals("Ash", trainer.getName());
    }

    @Test
    public void testGetTeam() {
        assertNotNull(trainer);
        assertEquals(Team.MYSTIC, trainer.getTeam());
    }

    @Test
    public void testGetPokedex() {
        assertNotNull(trainer);
        assertEquals(pokedex, trainer.getPokedex());
    }

}