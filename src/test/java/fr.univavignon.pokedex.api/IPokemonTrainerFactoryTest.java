package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class IPokemonTrainerFactoryTest {

    @Mock
    private IPokemonTrainerFactory trainerFactory;

    @Mock
    private IPokedexFactory pokedexFactory;

    @Mock
    private IPokedex pokedex;

    @Test
    public void testCreateTrainer() {
        PokemonTrainer trainer = new PokemonTrainer("Ash", Team.MYSTIC, pokedex);

        Mockito.when(trainerFactory.createTrainer("Ash", Team.MYSTIC, pokedexFactory)).thenReturn(trainer);

        trainerFactory.createTrainer("Ash", Team.MYSTIC, pokedexFactory);

        Mockito.verify(trainerFactory).createTrainer("Ash", Team.MYSTIC, pokedexFactory);

        assertEquals("Ash", trainer.getName());

        assertEquals(Team.MYSTIC, trainer.getTeam());

        assertEquals(pokedex, trainer.getPokedex());
    }

    @Test
    public void testGetName(){
        PokemonTrainer trainer = new PokemonTrainer("Ash", Team.MYSTIC, pokedex);

        String name = trainer.getName();

        assertEquals("Ash", name);
    }

    @Test
    public void testGetTeam(){
        PokemonTrainer trainer = new PokemonTrainer("Ash", Team.MYSTIC, pokedex);

        Team team = trainer.getTeam();

        assertEquals(Team.MYSTIC, team);
    }

    @Test
    public void testGetPokedex(){

        PokemonTrainer trainer = new PokemonTrainer("Ash", Team.MYSTIC, pokedex);

        IPokedex pokedex2 = trainer.getPokedex();

        assertEquals(pokedex, pokedex2);
    }
}