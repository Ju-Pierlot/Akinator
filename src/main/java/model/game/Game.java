package model.game;

import model.characters.Character;
import model.characters.ICharacters;
import model.questions.IQuestions;
import model.questions.Question;
import model.repository.IRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game implements IGame{
    private IRepository repository;

    private ICharacters characters;
    private IQuestions questions;

    private int tour = -1;

    private Question currentQuestion, lastQuestion;
    private Character characterToModify;

    private Set<Character> lastCharactersRemove;
    @Override
    public String getNextQuestion() {
        if(this.currentQuestion != null) this.lastQuestion = currentQuestion.copy();
        this.currentQuestion = this.questions.getQuestion(this.characters.getRandomKey());
        String lastQuestionKey = this.currentQuestion.getTitle();
        this.tour++;
        return lastQuestionKey;
    }

    @Override
    public void setRepository(IRepository repository) {
        this.repository = repository;
        this.characters = repository.getCharacters();
        this.questions = repository.getQuestions();
    }
    @Override
    public void removeKey(boolean have) {
        this.lastCharactersRemove = new HashSet<>(this.characters.getSetCharacters());
        this.characters.removeCharactersWithKey(this.currentQuestion.getKey(), have);
        this.questions.removeQuestion(this.currentQuestion);
    }
    @Override
    public void reload() {
        this.characters = repository.getCharacters();
        this.questions = repository.getQuestions();
        this.tour = -1;
    }

    @Override
    public int getCharactersSize() {
        return this.characters.size();
    }

    @Override
    public int getQuestionsSize() {
        return this.questions.size();
    }

    @Override
    public void removeLastQuestion() {
        this.questions.removeQuestion(this.currentQuestion);
        this.characters.removeAKey(this.currentQuestion.getKey());
    }

    @Override
    public String getLastCharacterName() {
        return this.characters.getLastCharacterName();
    }

    @Override
    public List<Character> getCharactersLeft() {
        return this.characters.getListCharacters();
    }

    @Override
    public void setCharacterToModify(Character character) {
        this.characterToModify = character;
    }

    @Override
    public String getCharacterToModifyName() {
        return this.characterToModify.getName();
    }

    @Override
    public String getCharacterToModifyImage() {
        return this.characterToModify.getImagePath();
    }

    @Override
    public Character getModifyCharacter() {
        return this.characterToModify;
    }

    @Override
    public boolean canGoBack() {
        int tour = this.tour;
        this.tour = 0;
        return tour > 0;
    }

    @Override
    public String getLastQuestionTitle() {
        if(this.lastQuestion != null){
            this.questions.addQuestion(this.lastQuestion);
            this.characters.addCharacters(this.lastCharactersRemove);
            this.currentQuestion = this.lastQuestion.copy();
            return this.lastQuestion.getTitle();
        }
        return "";
    }

    @Override
    public boolean noQuestionLeft() {
        return (this.questions.noQuestionLeft()|| this.characters.noKeysLeft());
    }

    @Override
    public String getLastCharacterImage() {
        return this.characters.getLastCharacterImage();
    }
}
