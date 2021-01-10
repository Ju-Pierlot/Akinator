package model.repository;

import jdk.internal.jline.internal.TestAccessible;
import model.characters.Character;
import model.characters.Characters;
import model.characters.ICharacters;
import model.questions.IQuestions;
import model.questions.Question;
import model.questions.Questions;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class JsonExtensionTest {

    @Test
    public void createJsonExtensionSaveAndLoad() {
        Characters characters = new Characters();

        Character character1 = new Character("Character1", "");
        Character character2 = new Character("Character2", "");
        Character character3 = new Character("Character3", "");

        character1.addKey("a");
        character1.addKey("b");
        character1.addKey("c");

        character2.addKey("a");
        character2.addKey("d");

        character3.addKey("b");
        character3.addKey("e");
        character3.addKey("f");
        character3.addKey("d");

        characters.addCharacter(character1);
        characters.addCharacter(character2);
        characters.addCharacter(character3);

        Questions questions = new Questions();

        Question question1 = new Question("Est-il bleu ?", "a");
        Question question2 = new Question("Est-il rouge ?", "b");
        Question question3 = new Question("Est-il vert ?", "c");
        Question question4 = new Question("Est-il jaune ?", "d");
        Question question5 = new Question("Est-il maron ?", "e");
        Question question6 = new Question("Est-il orange ?", "f");

        questions.addQuestion(question1);
        questions.addQuestion(question2);
        questions.addQuestion(question3);
        questions.addQuestion(question4);
        questions.addQuestion(question5);
        questions.addQuestion(question6);

        File file = new File("src/test/resources/test.json");
        deleteContent(file);

        IExtension json = new JsonExtension(characters, questions, file);
        try{
            json.saveFile();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        IExtension jsonLoad = new JsonExtension();
        try{
            jsonLoad.chargeFile(file);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        ICharacters charactersResult = jsonLoad.getCharacters();
        IQuestions questionsResult = jsonLoad.getQuestions();

        Assert.assertEquals(3, charactersResult.size());
        Assert.assertEquals(6, questionsResult.size());
    }
    @Test
    public void notTheSameObject(){
        Characters characters = new Characters();

        Character character1 = new Character("Character1", "");
        Character character2 = new Character("Character2", "");
        Character character3 = new Character("Character3", "");

        character1.addKey("a");
        character1.addKey("b");
        character1.addKey("c");

        character2.addKey("a");
        character2.addKey("d");

        character3.addKey("b");
        character3.addKey("e");
        character3.addKey("f");
        character3.addKey("d");

        characters.addCharacter(character1);
        characters.addCharacter(character2);
        characters.addCharacter(character3);

        Questions questions = new Questions();

        Question question1 = new Question("Est-il bleu ?", "a");
        Question question2 = new Question("Est-il rouge ?", "b");
        Question question3 = new Question("Est-il vert ?", "c");
        Question question4 = new Question("Est-il jaune ?", "d");
        Question question5 = new Question("Est-il maron ?", "e");
        Question question6 = new Question("Est-il orange ?", "f");

        questions.addQuestion(question1);
        questions.addQuestion(question2);
        questions.addQuestion(question3);
        questions.addQuestion(question4);
        questions.addQuestion(question5);
        questions.addQuestion(question6);

        File file = new File("src/test/resources/test.json");
        deleteContent(file);

        IExtension json = new JsonExtension(characters, questions, file);

        Assert.assertNotEquals(json.getCharacters(), json.getSaveCharacters());
        Assert.assertNotEquals(json.getQuestions(), json.getSaveQuestions());
    }
    private void deleteContent(File file){
        try(FileWriter fw = new FileWriter(file)){
            fw.write("");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
