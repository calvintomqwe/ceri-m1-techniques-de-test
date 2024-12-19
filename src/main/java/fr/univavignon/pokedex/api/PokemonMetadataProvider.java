package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {
    private static final Map<Integer, PokemonMetadata> pokemonData = new HashMap<>();

    static {
        pokemonData.put(0, new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        pokemonData.put(133, new PokemonMetadata(133, "Aquali", 186, 168, 260));
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (!pokemonData.containsKey(index)) {
            throw new PokedexException("Index invalide pour le Pokémon : " + index);
        }
        return pokemonData.get(index);
    }
}