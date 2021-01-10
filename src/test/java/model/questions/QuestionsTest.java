package model.questions;

import model.characters.Characters;
import model.characters.ICharacters;
import org.junit.Assert;
import org.junit.Test;

public class QuestionsTest {

    @Test
    public void createQuestions(){
        Question question1 = new Question("Est-il bleu ?", "aa");
        Question question2 = new Question("Est-il rouge ?", "ab");
        Question question3 = new Question("Est-il vert ?", "ac");

        IQuestions questions = new Questions();
        questions.addQuestion(question1);
        questions.addQuestion(question2);
        questions.addQuestion(question3);

        Assert.assertEquals(3, questions.size());
    }
    @Test
    public void insertSameQuestions(){
        Question question1 = new Question("Est-il bleu ?", "aa");
        Question question2 = new Question("Est-il bleu ?", "aa");
        Question question3 = new Question("Est-il vert ?", "ac");

        IQuestions questions = new Questions();
        questions.addQuestion(question1);
        questions.addQuestion(question2);
        questions.addQuestion(question3);

        Assert.assertEquals(2, questions.size());
    }
    @Test
    public void removeQuestion(){
        Question question1 = new Question("Est-il bleu ?", "aa");
        Question question2 = new Question("Est-il rouge ?", "ab");
        Question question3 = new Question("Est-il vert ?", "ac");

        IQuestions questions = new Questions();
        questions.addQuestion(question1);
        questions.addQuestion(question2);
        questions.addQuestion(question3);

        questions.removeQuestion(question1);

        Assert.assertEquals(2, questions.size());
    }
    @Test
    public void removeQuestionNotInQuestions(){
        Question question1 = new Question("Est-il bleu ?", "aa");
        Question question2 = new Question("Est-il rouge ?", "ab");
        Question question3 = new Question("Est-il vert ?", "ac");
        Question question4 = new Question("Est-il  jaune ?", "ad");

        IQuestions questions = new Questions();
        questions.addQuestion(question1);
        questions.addQuestion(question2);
        questions.addQuestion(question3);

        questions.removeQuestion(question4);

        Assert.assertEquals(3, questions.size());
    }
    @Test
    public void removeQuestionWithSameKeyButNotSameTitle(){
        Question question1 = new Question("Est-il bleu ?", "aa");
        Question question2 = new Question("Est-il rouge ?", "ab");
        Question question3 = new Question("Est-il vert ?", "ac");
        Question question4 = new Question("Est-il  jaune ?", "aa");

        IQuestions questions = new Questions();
        questions.addQuestion(question1);
        questions.addQuestion(question2);
        questions.addQuestion(question3);

        questions.removeQuestion(question4);

        Assert.assertEquals(2, questions.size());
    }
    @Test
    public void cloneCharacters(){
        IQuestions characters1 = new Questions();
        IQuestions characters2 = characters1;
        Assert.assertEquals(characters1, characters2);

        characters2 = characters1.cloneObject();
        Assert.assertNotEquals(characters1, characters2);
    }
}
