package model.characters;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CharacterTest {
    @Test
    public void haveKey(){
        Character freud = new Character("Freud", "");
        Assert.assertFalse(freud.haveKey("b"));
    }
    @Test
    public void addAKey(){
        Character freud = new Character("Freud", "");
        freud.addKey("a");
        Assert.assertTrue(freud.haveKey("a"));
        Assert.assertFalse(freud.haveKey("b"));
        freud.addKey("b");
        Assert.assertTrue(freud.haveKey("b"));
    }
    @Test
    public void addAEmptyKey(){
        Character freud = new Character("Freud", "");
        freud.addKey("");
        Assert.assertFalse(freud.haveKey(""));
        freud.addKey("b");
        Assert.assertTrue(freud.haveKey("b"));
    }
    @Test
    public void addANullKey(){
        Character freud = new Character("Freud", "");
        freud.addKey(null);
        Assert.assertFalse(freud.haveKey(null));
        freud.addKey("b");
        Assert.assertTrue(freud.haveKey("b"));
    }
    @Test
    public void removeKey(){
        Character freud = new Character("Freud", "");
        freud.addKey("a");
        freud.addKey("d");
        Assert.assertTrue(freud.haveKey("a"));
        freud.removeKey("a");
        Assert.assertFalse(freud.haveKey("a"));
        Assert.assertTrue(freud.haveKey("d"));
    }
    @Test
    public void setName(){
        Character freud = new Character("Freud", "");
        Assert.assertEquals("Freud", freud.getName());
        freud.setName("Richard");
        Assert.assertEquals("Richard", freud.getName());
    }
    @Test
    public void setEmptyName(){
        Character freud = new Character("Freud", "");
        Assert.assertEquals("Freud", freud.getName());
        freud.setName("");
        Assert.assertEquals("Freud", freud.getName());
    }
    @Test
    public void setNullName(){
        Character freud = new Character("Freud", "");
        Assert.assertEquals("Freud", freud.getName());
        freud.setName(null);
        Assert.assertEquals("Freud", freud.getName());
    }
    @Test
    public void setImagePath(){
        Character freud = new Character("Freud", "");
        Assert.assertEquals("", freud.getImagePath());
        freud.setImagePath("../image.png");
        Assert.assertEquals("../image.png", freud.getImagePath());
    }
    @Test
    public void setEmptyImagePath(){
        Character freud = new Character("Freud", "image.png");
        Assert.assertEquals("image.png", freud.getImagePath());
        freud.setImagePath("");
        Assert.assertEquals("", freud.getImagePath());
    }
    @Test
    public void setNullImagePath(){
        Character freud = new Character("Freud", "");
        Assert.assertEquals("", freud.getImagePath());
        freud.setImagePath("image.png");
        freud.setImagePath(null);
        Assert.assertEquals("image.png", freud.getImagePath());
    }
    @Test
    public void sameCharacters(){
        Character freud = new Character("Freud", "");
        Character michael = new Character("Michael", "");
        Character jasmine = new Character("Jasmine", "");
        Assert.assertFalse(freud.equals(michael));
        Assert.assertFalse(freud.equals(jasmine));
        Assert.assertFalse(jasmine.equals(michael));
        michael.setName("Freud");
        Assert.assertTrue(freud.equals(michael));
    }
    @Test
    public void sameHashCode(){
        Character freud = new Character("Freud", "");
        Character michael = new Character("Michael", "");
        Assert.assertFalse(freud.hashCode() == michael.hashCode());
        Assert.assertTrue(freud.hashCode() == "Freud".hashCode());
        michael.setName("Freud");
        Assert.assertTrue(freud.hashCode() == michael.hashCode());
    }
}
