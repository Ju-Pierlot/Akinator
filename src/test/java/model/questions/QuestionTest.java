package model.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class QuestionTest {
    @Test
    public void getQuestion(){
        Question question = new Question("Est-ce-qu'il est roux?", "asb");
        Assert.assertEquals("Est-ce-qu'il est roux?", question.getTitle());
    }
    @Test
    public void sameQuestion(){
        Question question = new Question("Est-ce-qu'il est roux?", "asb");
        Question question2 = new Question("Est-ce-qu'il est roux?", "azr");
        Assert.assertEquals(question, question2);
    }
    @Test
    public void getKey(){
        Question question = new Question("Est-ce-qu'il est roux?", "asb");
        Assert.assertEquals("asb", question.getKey());
    }
    @Test
    public void hashCodeQuestion(){
        Question question = new Question("Est-ce-qu'il est roux?", "asb");
        Assert.assertEquals("Est-ce-qu'il est roux?".hashCode(), question.hashCode());
    }
}
