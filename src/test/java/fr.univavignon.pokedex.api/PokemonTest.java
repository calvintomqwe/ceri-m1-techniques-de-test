package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PokemonTest {

    @Test
    public void testGetIndex() {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 40, 4, 56);
        assertEquals(0, pokemon.getIndex());
    }

    @Test
    public void testGetName() {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 40, 4, 56);
        assertEquals("Bulbizarre", pokemon.getName());
    }

    @Test
    public void testGetAttack() {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 40, 4, 56);
        assertEquals(126, pokemon.getAttack());
    }

    @Test
    public void testGetDefense() {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 40, 4, 56);
        assertEquals(126, pokemon.getDefense());
    }

    @Test
    public void testGetStamina() {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 40, 4, 56);
        assertEquals(90, pokemon.getStamina());
    }

    @Test
    public void testGetCp() {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 40, 4, 56);
        assertEquals(613, pokemon.getCp());
    }

    @Test
    public void testGetHp() {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 40, 4, 56);
        assertEquals(64, pokemon.getHp());
    }

    @Test
    public void testGetDust() {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 40, 4, 56);
        assertEquals(40, pokemon.getDust());
    }

    @Test
    public void testGetCandy() {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 40, 4, 56);
        assertEquals(4, pokemon.getCandy());
    }

    @Test
    public void testGetIv() {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 40, 4, 56);
        assertEquals(56, pokemon.getIv());
    }
}
