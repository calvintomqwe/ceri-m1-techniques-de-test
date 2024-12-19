package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class IPokemonFactoryTest {

    @Mock
    private IPokemonFactory pokemonFactory;

    @Test
    public void testCreatePokemon() {
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);

        Mockito.when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbizarre);

        pokemonFactory.createPokemon(0, 613, 64, 4000, 4);

        Mockito.verify(pokemonFactory).createPokemon(0, 613, 64, 4000, 4);
    }

    @Test
    public void testIndex() {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 40, 4, 56);
        int index = pokemon.getIndex();
        assertEquals(0, index);
    }

    @Test
    public void testName() {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 40, 4, 56);
        String name = pokemon.getName();
        assertEquals("Bulbizarre", name);
    }

    @Test
    public void testAttack() {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 40, 4, 56);
        int attack = pokemon.getAttack();
        assertEquals(126, attack);
    }

    @Test
    public void testDefense() {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 40, 4, 56);
        int defense = pokemon.getDefense();
        assertEquals(126, defense);
    }

    @Test
    public void testStamina() {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 40, 4, 56);
        int stamina = pokemon.getStamina();
        assertEquals(90, stamina);
    }

    @Test
    public void testCp() {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 40, 4, 56);
        int cp = pokemon.getCp();
        assertEquals(613, cp);
    }

    @Test
    public void testHp() {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 40, 4, 56);
        int hp = pokemon.getHp();
        assertEquals(64, hp);
    }

    @Test
    public void testDust() {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 40, 4, 56);
        int dust = pokemon.getDust();
        assertEquals(40, dust);
    }

    @Test
    public void testCandy() {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 40, 4, 56);
        int candy = pokemon.getCandy();
        assertEquals(4, candy);
    }

    @Test
    public void testIv() {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 40, 4, 56);
        double iv = pokemon.getIv();
        assertEquals(56, iv);
    }
}
