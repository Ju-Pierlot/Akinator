package model.repository;

import model.characters.Character;
import model.characters.ICharacters;
import model.questions.IQuestions;
import model.questions.Question;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Set;

public interface IExtension{
    void chargeFile(File file) throws FileNotFoundException;
    void saveFile() throws FileNotFoundException;
    ICharacters getCharacters();
    IQuestions getQuestions();
    ICharacters getSaveCharacters();
    IQuestions getSaveQuestions();
    void addNewCharacter(String characterName, String characterImage, String question);
    void modifyCharacter(Character character, String name, String image, String question);
    boolean createNewSave(String fileName, String path);
    Set<Character> getCharactersListToModify();
    Set<Question> getQuestionsListToModify();
    void replaceQuestions(Collection<Question> questionList);
    void replaceCharacters(Collection<Character> characterList);
}
