package model.repository;

import model.characters.Character;
import model.characters.ICharacters;
import model.questions.IQuestions;
import model.questions.Question;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class TxtExtension implements IExtension {
    private File file;

    private ICharacters characters;
    private IQuestions questions;
    @Override
    public void chargeFile(File file){
        this.file = file;
        chargeCharacters();
        chargeQuestions();
    }

    @Override
    public void saveFile() throws FileNotFoundException {

    }

    @Override
    public ICharacters getCharacters() {
        return this.characters.cloneObject();
    }

    @Override
    public IQuestions getQuestions() {
        return this.questions.cloneObject();
    }

    @Override
    public ICharacters getSaveCharacters() {
        return this.characters;
    }

    @Override
    public IQuestions getSaveQuestions() {
        return this.questions;
    }

    private void chargeCharacters(){

    }
    private void chargeQuestions(){

    }
    @Override
    public void addNewCharacter(String characterName, String characterImage, String question) {

    }

    @Override
    public void modifyCharacter(Character character, String name, String image, String question) {

    }

    @Override
    public boolean createNewSave(String fileName, String path) {
        return false;
    }

    @Override
    public Set<Character> getCharactersListToModify() {
        return null;
    }

    @Override
    public Set<Question> getQuestionsListToModify() {
        return null;
    }

    @Override
    public void replaceQuestions(Collection<Question> questionList) {

    }

    @Override
    public void replaceCharacters(Collection<Character> characterList) {

    }
}
