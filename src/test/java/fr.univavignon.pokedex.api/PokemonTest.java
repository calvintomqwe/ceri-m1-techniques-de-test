package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokemonTest {

    @Test
    public void testGetters() {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 40, 4, 56);

        int index = pokemon.getIndex();
        String name = pokemon.getName();
        int attack = pokemon.getAttack();
        int defense = pokemon.getDefense();
        int stamina = pokemon.getStamina();
        int cp = pokemon.getCp();
        int hp = pokemon.getHp();
        int dust = pokemon.getDust();
        int candy = pokemon.getCandy();
        double iv = pokemon.getIv();

        assertEquals(0, index);
        assertEquals("Bulbizarre", name);
        assertEquals(126, attack);
        assertEquals(126, defense);
        assertEquals(90, stamina);
        assertEquals(613, cp);
        assertEquals(64, hp);
        assertEquals(40, dust);
        assertEquals(4, candy);
        assertEquals(56, iv);
    }
}

