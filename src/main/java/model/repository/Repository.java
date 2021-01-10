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

public class Repository implements IRepository{
    private IExtension loader;
    private String savesPlacesDefault;

    public Repository(String path){
        this.savesPlacesDefault = path;
    }
    @Override
    public void loadFile(File file) throws FileNotFoundException {
        if(fileExtension(file).equals("json")){
            this.loader = new JsonExtension();
        } else if (fileExtension(file).equals("txt")){
            this.loader = new TxtExtension();
        } else {
            throw new FileNotFoundException();
        }
        this.loader.chargeFile(file);
    }

    @Override
    public void saveFile() throws FileNotFoundException {
        this.loader.saveFile();
    }

    @Override
    public ICharacters getCharacters() {
        if(this.loader == null){
            return null;
        } else {
            return this.loader.getCharacters();
        }
    }

    @Override
    public IQuestions getQuestions() {
        if(this.loader == null){
            return null;
        } else {
            return this.loader.getQuestions();
        }
    }

    private String fileExtension(File file){
        if(file != null){
            String extension = file.getAbsolutePath();
            int i = extension.lastIndexOf('.');
            int p = Math.max(extension.lastIndexOf('/'), extension.lastIndexOf('\\'));
            if (i > p) {
                extension = extension.substring(i+1);
            }
            return extension;
        } else {
            return "";
        }
    }

    @Override
    public void addNewCharacter(String characterName, String characterImage, String question) {

        this.loader.addNewCharacter(formatString(characterName), characterImage, formatString(question));
    }

    @Override
    public void modifyCharacter(Character character, String name, String image, String question) {
        this.loader.modifyCharacter(character, formatString(name), image, formatString(question));
    }

    @Override
    public boolean createNewSave(String fileName) {
        this.loader = new JsonExtension();
        return this.loader.createNewSave(fileName, this.savesPlacesDefault);
    }

    private String formatString(String string){
        string = string.trim();
        char firstLetter = string.charAt(0);
        String firstLetterString = java.lang.Character.toString(firstLetter).toUpperCase();
        return firstLetterString + string.substring(1).toLowerCase();
    }

    @Override
    public Set<Character> getCharactersListToModify() {
        return this.loader.getCharactersListToModify();
    }

    @Override
    public Set<Question> getQuestionsListToModify() {
        return this.loader.getQuestionsListToModify();
    }

    @Override
    public void replaceQuestions(Collection<Question> questionList) {
        this.loader.replaceQuestions(questionList);
    }

    @Override
    public void replaceCharacters(Collection<Character> characterList) {
        this.loader.replaceCharacters(characterList);
    }
}
