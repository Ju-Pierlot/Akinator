package model.characters;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface ICharacters {
    boolean addCharacter(Character character);
    void removeCharacter(Character character);
    boolean containCharacter(Character character);
    int size();
    void removeCharactersWithKey(String key, boolean have);
    int removeWithKeyAndGetSize(String key, boolean have);
    ICharacters cloneObject();
    String getRandomKey();
    Set<String> getKeys();
    void setNewCharacterSet(Set<Character> characters);
    List<Character> getListCharacters();
    Set<Character> getSetCharacters();
    void removeAKey(String key);
    String getLastCharacterName();
    void addKeyToTheSameCharacter(Character character, String key);
    void reloadKeys();
    Character getCharacterWithSameName(String name);
    void addCharacters(Set<Character> lastCharactersRemove);
    boolean noKeysLeft();
    Set<Character> getCharactersListToModify();
    void replace(Collection<Character> characters);
    String getLastCharacterImage();
}
