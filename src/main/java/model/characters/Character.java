package model.characters;

import java.util.HashSet;
import java.util.Set;

public class Character {
    private String name;
    private String imagePath;
    private Set<String> keys;

    public Character(String name, String imagePath){
        this.name = name;
        this.imagePath = imagePath;
        this.keys = new HashSet<>();
    }
    /**
     * Add a key in the key collection
     * @param key (String)
     */
    public void addKey(String key){
        if(key != null && key.length() > 0){
            this.keys.add(key);
        }
    }
    /**
     * Remove a key from the key collection
     * @param key (String)
     */
    public void removeKey(String key){
        if(key != null && key.length() > 0){
            this.keys.remove(key);
        }
    }
    /**
     *  Set a new name to the character
     * @param name (String)
     */
    public void setName(String name){
        if(name != null && name.length() > 0){
            this.name = name;
        }
    }
    /**
     *  Get the character's name
     * @return (String) name
     */
    public String getName(){
        return this.name;
    }
    /**
     *  Set a new image's path to the character
     * @param imagePath (String)
     */
    public void setImagePath(String imagePath){
        if(imagePath != null){
            this.imagePath = imagePath;
        }
    }
    /**
     * Get the character file's path
     * @return (String) path
     */
    public String getImagePath(){
        return this.imagePath;
    }
    /**
     * Check if the character have the key in his key collection
     * @param key (String)
     * @return true if the character have the key
     */
    public boolean haveKey(String key){
        if(key != null && key.length() > 0){
            return this.keys.contains(key);
        }
        return false;
    }
    public Set<String> getKeys(){
        return this.keys;
    }
    public boolean sameName(String name){
        return this.name.equals(name);
    }
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if(obj != null){
            return this.name.equals(((Character)obj).getName());
        }
        return false;
    }

    @Override
    public String toString() {
        return this.name + " | " + this.keys.size() + " questions";
    }

    public void addKeys(Set<String> keys) {
        this.keys.addAll(keys);
    }
    public boolean noImage(){
        return this.imagePath.length() == 0;
    }
}
