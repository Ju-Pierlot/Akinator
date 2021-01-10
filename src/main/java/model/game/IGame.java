package model.game;

import model.characters.Character;
import model.repository.IRepository;

import java.util.List;
import java.util.Set;

public interface IGame {

    String getNextQuestion();
    void setRepository(IRepository repository);
    void removeKey(boolean have);
    void removeLastQuestion();
    void reload();
    int getCharactersSize();
    int getQuestionsSize();
    String getLastCharacterName();
    List<Character> getCharactersLeft();
    void setCharacterToModify(Character character);
    String getCharacterToModifyName();
    String getCharacterToModifyImage();
    Character getModifyCharacter();
    boolean canGoBack();
    String getLastQuestionTitle();
    boolean noQuestionLeft();
    String getLastCharacterImage();
}
