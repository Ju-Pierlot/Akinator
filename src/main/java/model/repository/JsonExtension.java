package model.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.characters.Character;
import model.characters.Characters;
import model.characters.ICharacters;
import model.questions.IQuestions;
import model.questions.Question;
import model.questions.Questions;

import java.io.*;
import java.util.*;

public class JsonExtension implements IExtension {
    private File file;

    private CharactersQuestions charactersQuestions;

    public JsonExtension(){

    }
    public JsonExtension(Characters characters, Questions questions, File file){
        this.file = file;
        this.charactersQuestions = new CharactersQuestions(characters, questions);
    }
    @Override
    public void chargeFile(File file) throws FileNotFoundException {
        this.file = file;
        loadFile();
    }
    @Override
    public void saveFile() throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        this.charactersQuestions.reloadKeys();
        String toPrint = gson.toJson(this.charactersQuestions);
        try(FileWriter fw = new FileWriter(this.file)){
            fw.write("");
            fw.write(toPrint);
        } catch (IOException e){
            throw new FileNotFoundException();
        }
    }
    @Override
    public ICharacters getCharacters() {
        if(this.charactersQuestions != null){
            if(this.charactersQuestions.getCharacters() == null) return null;
            ICharacters characters = this.charactersQuestions.getCharacters().cloneObject();
            characters.setNewCharacterSet(new HashSet<>(characters.getListCharacters()));
            return characters;
        }
        return null;
    }
    @Override
    public IQuestions getQuestions() {
        if(this.charactersQuestions != null){
            if(this.charactersQuestions.getQuestions() == null) return null;
            IQuestions questions = this.charactersQuestions.getQuestions().cloneObject();
            questions.setNewQuestionMap(new HashMap<>(questions.getMapQuestions()));
            return questions;
        }
        return null;

    }
    @Override
    public ICharacters getSaveCharacters() {
        return this.charactersQuestions.getCharacters();
    }
    @Override
    public IQuestions getSaveQuestions() {
        return this.charactersQuestions.getQuestions();
    }
    @Override
    public void addNewCharacter(String characterName, String characterImage, String question) {
        this.charactersQuestions.addNewCharacterAndQuestion(characterName, characterImage, question);
    }
    private void loadFile() throws FileNotFoundException {
        Gson gson = new Gson();
        try(Reader r = new FileReader(this.file)){
            this.charactersQuestions = gson.fromJson(r, CharactersQuestions.class);
        } catch (Exception e) {
            throw new FileNotFoundException();
        }
    }

    @Override
    public void modifyCharacter(Character character, String name, String image, String question) {
        this.charactersQuestions.modifyCharacter(character, name, image, question);
    }

    @Override
    public boolean createNewSave(String fileName, String path) {
        String pathFile = path + "/" + fileName + ".json";
        int cont = 1;
        this.file = new File(pathFile);
        try{
            while (!this.file.createNewFile()){
                if(cont > 15){
                    return false;
                }
                pathFile = path + "/" + fileName + cont + ".json";
                cont++;
                this.file = new File(pathFile);
            }
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        createDefaultSave();
        try{
            saveFile();
        } catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Set<Character> getCharactersListToModify() {
        return this.charactersQuestions.getCharactersListToModify();
    }

    @Override
    public Set<Question> getQuestionsListToModify() {
        return this.charactersQuestions.getQuestionsListToModify();
    }

    @Override
    public void replaceQuestions(Collection<Question> questionList) {
        this.charactersQuestions.replaceQuestions(questionList);
    }

    @Override
    public void replaceCharacters(Collection<Character> characterList) {
        this.charactersQuestions.replaceCharacters(characterList);
    }

    private void createDefaultSave(){
        Characters characters = new Characters();
        Character character = new Character("Exemple de personnage", "");
        character.addKey("a");
        characters.addCharacter(character);
        Questions questions = new Questions();
        questions.addQuestion(new Question("Exemple de question ?", "a"));
        this.charactersQuestions = new CharactersQuestions(characters, questions);
    }

    private class CharactersQuestions{
        private Characters allCharacters;
        private Questions allQuestions;

        public CharactersQuestions(Characters characters, Questions questions){
            this.allCharacters = characters;
            this.allQuestions = questions;
        }

        public ICharacters getCharacters() {
            return this.allCharacters;
        }
        public void reloadKeys(){
            this.allCharacters.reloadKeys();
        }

        public IQuestions getQuestions() {
            return this.allQuestions;
        }

        public void addNewCharacterAndQuestion(String characterName, String characterImage, String question){
            String key = this.allQuestions.createQuestion(question);
            Character character = new Character(characterName, characterImage);
            character.addKey(key);
            if(!this.allCharacters.addCharacter(character)){
                this.allCharacters.addKeyToTheSameCharacter(character, key);
            }
            reloadKeys();
        }
        public void modifyCharacter(Character character, String name, String image, String question){
            Character character1 = this.allCharacters.getCharacterWithSameName(name);
            String key = this.allQuestions.createQuestion(question);
            if(character1 != null && !character1.equals(character)){
                character1.addKeys(character.getKeys());
                if(character1.noImage()) character1.setImagePath(image);
                character1.addKey(key);
                this.allCharacters.removeCharacter(character);
            } else {
                character.setName(name);
                if(character.noImage()) character.setImagePath(image);
                character.addKey(key);
            }
        }
        public Set<Character> getCharactersListToModify() {
            return this.allCharacters.getCharactersListToModify();
        }

        public Set<Question> getQuestionsListToModify() {
            return this.allQuestions.getQuestionsListToModify();
        }
        public void replaceCharacters(Collection<Character> characters){
            this.allCharacters.replace(characters);
        }
        public void replaceQuestions(Collection<Question> questions){
            this.allQuestions.replace(questions);
        }
    }
}
