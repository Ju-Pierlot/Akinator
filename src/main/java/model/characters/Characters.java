package model.characters;

import java.util.*;

public class Characters implements ICharacters, Cloneable {
    private Set<Character> characters;
    private Set<String> keys;

    public Characters(){
        this.characters = new HashSet<>();
        this.keys = new HashSet<>();
    }
    @Override
    public boolean addCharacter(Character character) {
        if(character != null){
            int size = this.characters.size();
            this.characters.add(character);
            this.keys.addAll(character.getKeys());
            if(size == this.characters.size()){
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
    @Override
    public void removeCharacter(Character character) {
        if(character != null){
            this.characters.remove(character);
            this.keys.removeAll(character.getKeys());
            for(Character character1 : this.characters){
                this.keys.addAll(character1.getKeys());
            }
        }
    }
    @Override
    public boolean containCharacter(Character character) {
        if(character != null){
            return this.characters.contains(character);
        }
        return false;
    }
    @Override
    public int size() {
        return this.characters.size();
    }

    @Override
    public void removeCharactersWithKey(String key, boolean have) {
        if(have){
            this.characters.removeIf(character -> !character.haveKey(key));
        } else {
            this.characters.removeIf(character -> character.haveKey(key));
        }
        this.keys.remove(key);
    }
    @Override
    public int removeWithKeyAndGetSize(String key, boolean have) {
        removeCharactersWithKey(key, have);
        return size();
    }

    @Override
    public ICharacters cloneObject() {
        try{
            return (ICharacters)this.clone();
        } catch (CloneNotSupportedException e){
            return null;
        }
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    @Override
    public String getRandomKey() {
        int pos = (int)(Math.random()*this.keys.size()), i = 0;
        for(String key : this.keys){
            if(i == pos){
                return key;
            }
            i++;
        }
        return "";
    }

    @Override
    public Set<String> getKeys() {
        return this.keys;
    }

    @Override
    public void setNewCharacterSet(Set<Character> characters) {
        this.characters = characters;
        for(Character character : this.characters){
            this.keys.addAll(character.getKeys());
        }
    }

    @Override
    public List<Character> getListCharacters() {
        return new ArrayList<>(this.characters);
    }

    @Override
    public void removeAKey(String key) {
        this.keys.remove(key);
    }

    @Override
    public String getLastCharacterName() {
        if(this.characters.size() == 1){
            for(Character character : this.characters){
                return character.getName();
            }
        }
        return "";
    }

    @Override
    public void addKeyToTheSameCharacter(Character character, String key) {
        for(Character character1 : this.characters){
            if(character1.equals(character)){
                character1.addKey(key);
                break;
            }
        }
    }

    @Override
    public void reloadKeys() {
        for(Character character : this.characters){
            this.keys.addAll(character.getKeys());
        }
    }
    @Override
    public Character getCharacterWithSameName(String name) {
        for(Character character : this.characters){
            if(character.sameName(name)) return character;
        }
        return null;
    }

    @Override
    public Set<Character> getSetCharacters() {
        return this.characters;
    }

    @Override
    public void addCharacters(Set<Character> lastCharactersRemove) {
        for(Character character : lastCharactersRemove){
            addCharacter(character);
        }
    }

    @Override
    public boolean noKeysLeft() {
        return this.keys.size() == 0;
    }

    @Override
    public Set<Character> getCharactersListToModify() {
        return new HashSet<>(this.characters);
    }

    @Override
    public void replace(Collection<Character> characters) {
        this.characters.clear();
        this.keys.clear();
        this.characters.addAll(characters);
        this.reloadKeys();
    }
    @Override
    public String getLastCharacterImage() {
        if(this.characters.size() == 1){
            for(Character character : this.characters){
                return character.getImagePath();
            }
        }
        return "";
    }
}
