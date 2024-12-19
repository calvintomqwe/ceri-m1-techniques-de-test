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
    }

    @Test
    public void testGetName(){
        PokemonTrainer trainer = Mockito.mock(PokemonTrainer.class);

        Mockito.when(trainer.getName()).thenReturn("Ash");

        String name = trainer.getName();

        Mockito.verify(trainer).getName();

        assertEquals("Ash", name);
    }

    @Test
    public void testGetTeam(){
        PokemonTrainer trainer = Mockito.mock(PokemonTrainer.class);

        Mockito.when(trainer.getTeam()).thenReturn(Team.MYSTIC);

        Team team = trainer.getTeam();

        Mockito.verify(trainer).getTeam();

        assertEquals(Team.MYSTIC, team);
    }

    @Test
    public void testGetPokedex(){

        PokemonTrainer trainer = Mockito.mock(PokemonTrainer.class);

        IPokedex mockedPokedex = Mockito.mock(IPokedex.class);

        Mockito.when(trainer.getPokedex()).thenReturn(mockedPokedex);

        IPokedex pokedex = trainer.getPokedex();

        Mockito.verify(trainer).getPokedex();

        assertEquals(mockedPokedex, pokedex);
    }
}