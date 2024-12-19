package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @BeforeEach
    public void setUp() {
        pokemonFactory = new PokemonFactory();
    }

    @Test
    public void testCreatePokemon() {
        // Example data for a Pokemon (let's say Bulbizarre)
        int index = 0;  // Bulbizarre index
        String name = "Bulbizarre";
        int attack = 126;
        int defense = 126;
        int stamina = 90;
        int cp = 613;
        int hp = 64;
        int dust = 4000;
        int candy = 4;
        double iv = 0.56;

        Pokemon expectedPokemon = new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv);

        when(pokemonFactory.createPokemon(index, cp, hp, dust, candy))
                .thenReturn(expectedPokemon);

        Pokemon result = pokemonFactory.createPokemon(index, cp, hp, dust, candy);

        assertEquals(expectedPokemon.getIndex(), result.getIndex());
        assertEquals(expectedPokemon.getName(), result.getName());
        assertEquals(expectedPokemon.getAttack(), result.getAttack());
        assertEquals(expectedPokemon.getDefense(), result.getDefense());
        assertEquals(expectedPokemon.getStamina(), result.getStamina());
        assertEquals(expectedPokemon.getCp(), result.getCp());
        assertEquals(expectedPokemon.getHp(), result.getHp());
        assertEquals(expectedPokemon.getDust(), result.getDust());
        assertEquals(expectedPokemon.getCandy(), result.getCandy());
        assertEquals(expectedPokemon.getIv(), result.getIv());
    }
}
