package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

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
        PokemonTrainer trainer = new PokemonTrainer("Ash", Team.MYSTIC, pokedex);

        Mockito.when(trainer.getName()).thenReturn("Ash");

        trainer.getName();

        Mockito.verify(trainer).getName();
    }

    @Test
    public void testGetTeam(){
        PokemonTrainer trainer = new PokemonTrainer("Ash", Team.MYSTIC, pokedex);    

        Mockito.when(trainer.getTeam()).thenReturn(Team.MYSTIC);

        trainer.getTeam();

        Mockito.verify(trainer).getTeam();
    }

    @Test
    public void testGetPokedex(){
        PokemonTrainer trainer = new PokemonTrainer("Ash", Team.MYSTIC, pokedex);

        Mockito.when(trainer.getPokedex()).thenReturn(pokedex);

        trainer.getPokedex();

        Mockito.verify(trainer).getPokedex();
    }
}