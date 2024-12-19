package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        int attack = (int) (Math.random() * 16);
        int defense = (int) (Math.random() * 16);
        int stamina = (int) (Math.random() * 16);

        int totalIV = attack + defense + stamina;
        int maxIV = 45;
        int iv = (totalIV / maxIV) * 100;

        return new Pokemon(index, "NomDuPokemon", attack, defense, stamina, cp, hp, dust, candy, iv);
    }
}