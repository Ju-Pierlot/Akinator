package model.characters;

import org.junit.Assert;
import org.junit.Test;

public class CharactersTest {
    @Test
    public void addCharacter(){
        ICharacters characters = new Characters();
        Character freud = new Character("Freud", "");
        Assert.assertFalse(characters.containCharacter(freud));
        characters.addCharacter(freud);
        Assert.assertTrue(characters.containCharacter(freud));
    }
    @Test
    public void addNullCharacter(){
        ICharacters characters = new Characters();
        Character freud = null;
        Assert.assertFalse(characters.containCharacter(freud));
        characters.addCharacter(freud);
        Assert.assertFalse(characters.containCharacter(freud));
    }
    @Test
    public void removeCharacter(){
        ICharacters characters = new Characters();
        Character freud = new Character("Freud", "");
        Assert.assertFalse(characters.containCharacter(freud));
        characters.addCharacter(freud);
        Assert.assertTrue(characters.containCharacter(freud));
        characters.removeCharacter(freud);
        Assert.assertFalse(characters.containCharacter(freud));
    }
    @Test
    public void removeNullCharacter(){
        ICharacters characters = new Characters();
        Character freud = new Character("Freud", "");
        Assert.assertFalse(characters.containCharacter(freud));
        characters.addCharacter(freud);
        Assert.assertTrue(characters.containCharacter(freud));
        freud = null;
        characters.removeCharacter(freud);
        freud = new Character("Freud", "");
        Assert.assertTrue(characters.containCharacter(freud));
    }
    @Test
    public void containNullCharacter(){
        ICharacters characters = new Characters();
        Character freud = new Character("Freud", "");
        characters.addCharacter(freud);
        Assert.assertFalse(characters.containCharacter(null));
    }
    @Test
    public void sizeCharacters(){
        ICharacters characters = new Characters();
        Character freud = new Character("Freud", "");
        Assert.assertEquals(0, characters.size());
        characters.addCharacter(freud);
        Assert.assertEquals(1, characters.size());
    }
    @Test
    public void removeCharactersWithAKey(){
        ICharacters characters = new Characters();

        addFakeCharacters(characters);
        characters.removeCharactersWithKey("a", false);
        Assert.assertEquals(1, characters.size());

        addFakeCharacters(characters);
        characters.removeCharactersWithKey("b", false);
        Assert.assertEquals(2, characters.size());

        addFakeCharacters(characters);
        characters.removeCharactersWithKey("m", false);
        Assert.assertEquals(3, characters.size());
    }
    @Test
    public void removeCharactersWithAKeyAndGetTheSize(){
        ICharacters characters = new Characters();

        addFakeCharacters(characters);
        Assert.assertEquals(1, characters.removeWithKeyAndGetSize("a", false));

        addFakeCharacters(characters);
        Assert.assertEquals(2, characters.removeWithKeyAndGetSize("b", false));

        addFakeCharacters(characters);
        Assert.assertEquals(3, characters.removeWithKeyAndGetSize("m", false));
    }
    @Test
    public void cloneCharacters(){
        ICharacters characters1 = new Characters();
        ICharacters characters2 = characters1;
        Assert.assertEquals(characters1, characters2);

        characters2 = characters1.cloneObject();
        Assert.assertNotEquals(characters1, characters2);
    }
    private void addFakeCharacters(ICharacters characters){
        Character freud = new Character("Freud", "");
        freud.addKey("a");
        freud.addKey("b");
        freud.addKey("c");
        freud.addKey("d");
        Character jacque = new Character("Jacque", "");
        jacque.addKey("a");
        jacque.addKey("e");
        jacque.addKey("f");
        jacque.addKey("d");
        Character camille = new Character("Camille", "");
        camille.addKey("a");
        camille.addKey("e");
        camille.addKey("c");
        camille.addKey("m");
        Character gerard = new Character("Gérard", "");
        gerard.addKey("b");
        gerard.addKey("g");
        gerard.addKey("h");
        gerard.addKey("i");

        characters.addCharacter(freud);
        characters.addCharacter(jacque);
        characters.addCharacter(camille);
        characters.addCharacter(gerard);
    }
}
