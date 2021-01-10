package controllers.app;

import controllers.*;
import model.characters.Character;
import model.game.IGame;
import model.questions.Question;
import model.repository.IRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class AppController implements IAppController {
    public final static int COME_FROM_SUCCESS_END = 0;
    public final static int COME_FROM_FAIL_END = 1;
    public final static int COME_FROM_MORE_CHARACTER = 2;

    private boolean saveCharged;
    private IRepository repository;
    private IGame game;
    private int comeFrom;

    private MenuController menuController;
    private SettingsController settingsController;
    private GameProgressController gameProgressController;
    private CaseOneCharacterController caseOneCharacterController;
    private SuccessEndController successEndController;
    private FailEndController failEndController;
    private AddOneCharacterController addOneCharacterController;
    private CaseMoreCharacterController caseMoreCharacterController;
    private ModifyCharacterController modifyCharacterController;
    private NoCharactersLeftController noCharactersLeftController;
    private CreateNewSaveController createNewSaveController;
    private ModifySaveController modifySaveController;

    public AppController(){
        this.saveCharged = false;
    }
    @Override
    public MenuController getMenuController() {
        return this.menuController;
    }
    @Override
    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }
    @Override
    public void saveCharged() {
        this.saveCharged = true;
    }
    @Override
    public SettingsController getSettingsController() {
        return this.settingsController;
    }
    @Override
    public void setSettingsController(SettingsController settingsController) {
        this.settingsController = settingsController;
    }
    @Override
    public boolean isFileCharged() {
        return this.saveCharged;
    }
    @Override
    public URL getMenuUrl() {
        return this.menuController.getURL();
    }
    @Override
    public URL getSettingsUrl() {
        return this.settingsController.getURL();
    }
    @Override
    public void setRepository(IRepository repository) {
        this.repository = repository;
    }
    @Override
    public boolean setFile(File file) {
        try{
            this.repository.loadFile(file);
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }
    @Override
    public void setGameProgressController(GameProgressController gameProgressController) {
        this.gameProgressController = gameProgressController;
    }
    @Override
    public URL getGameProgressUrl() {
        return this.gameProgressController.getURL();
    }

    @Override
    public GameProgressController getGameProgressController() {
        return this.gameProgressController;
    }

    @Override
    public String getNextQuestion() {
        return this.game.getNextQuestion();
    }
    @Override
    public void startGame() {

        if(this.game != null) this.game.setRepository(this.repository);
    }
    @Override
    public void setGame(IGame game) {
        this.game = game;
    }

    @Override
    public void removeKeys(boolean have) {
        this.game.removeKey(have);
    }
    @Override
    public void reloadGame() {
        this.game.reload();
    }

    @Override
    public int getCharactersSize() {
        return this.game.getCharactersSize();
    }

    @Override
    public int getQuestionsSize() {
        return this.game.getQuestionsSize();
    }

    @Override
    public void removeLastQuestion() {
        this.game.removeLastQuestion();
    }

    @Override
    public String getLastCharacterName() {
        return this.game.getLastCharacterName();
    }

    @Override
    public void setCaseOneCharacterController(CaseOneCharacterController caseOneCharacterController) {
        this.caseOneCharacterController = caseOneCharacterController;
    }

    @Override
    public URL getCaseOneCharacterUrl() {
        return this.caseOneCharacterController.getURL();
    }

    @Override
    public CaseOneCharacterController getCaseOneCharacterController() {
        return this.caseOneCharacterController;
    }

    @Override
    public URL getSuccessEndUrl() {
        return this.successEndController.getURL();
    }

    @Override
    public SuccessEndController getSuccessEndController() {
        return this.successEndController;
    }

    @Override
    public void setSuccessEndController(SuccessEndController successEndController) {
        this.successEndController = successEndController;
    }

    @Override
    public URL getFailEndUrl() {
        return this.failEndController.getURL();
    }

    @Override
    public FailEndController getFailEndController() {
        return this.failEndController;
    }

    @Override
    public void setFailEndController(FailEndController failEndController) {
        this.failEndController = failEndController;
    }

    @Override
    public void addNewCharacter(String characterName, String characterImage, String question) {
        this.repository.addNewCharacter(characterName, characterImage, question);
        this.save();
    }

    @Override
    public void setAddOneCharacterController(AddOneCharacterController addOneCharacterController) {
        this.addOneCharacterController = addOneCharacterController;
    }

    @Override
    public AddOneCharacterController getAddOneCharacterController() {
        return this.addOneCharacterController;
    }

    @Override
    public URL getAddOneCharacterUrl() {
        return this.addOneCharacterController.getURL();
    }

    @Override
    public void comeFromFail() {
        this.comeFrom = COME_FROM_FAIL_END;
    }

    @Override
    public void comeFromSuccess() {
        this.comeFrom = COME_FROM_SUCCESS_END;
    }

    @Override
    public boolean getComeFrom(int comeFrom) {
        return this.comeFrom == comeFrom;
    }

    @Override
    public void comeFromMoreCharacter() {
        this.comeFrom = COME_FROM_MORE_CHARACTER;
    }

    @Override
    public List<Character> getCharactersLeft() {
        return this.game.getCharactersLeft();
    }

    @Override
    public void setCaseMoreCharacterController(CaseMoreCharacterController caseMoreCharacterController) {
        this.caseMoreCharacterController = caseMoreCharacterController;
    }

    @Override
    public CaseMoreCharacterController getCaseMoreCharacterController() {
        return this.caseMoreCharacterController;
    }

    @Override
    public URL getCaseMoreCharacterUrl() {
        return this.caseMoreCharacterController.getURL();
    }

    @Override
    public void setCharacterToModify(Character character) {
        this.game.setCharacterToModify(character);
    }

    @Override
    public void setNewParamToCharacterToModify(String name, String image, String question) {
        this.repository.modifyCharacter(this.game.getModifyCharacter(), name, image, question);
        this.save();
    }

    @Override
    public String getCharacterToModifyName() {
        return this.game.getCharacterToModifyName();
    }

    @Override
    public String getCharacterToModifyImage() {
        return this.game.getCharacterToModifyImage();
    }

    @Override
    public void setModifyCharacterController(ModifyCharacterController modifyCharacterController) {
        this.modifyCharacterController = modifyCharacterController;
    }

    @Override
    public URL getModifyCharacterUrl() {
        return this.modifyCharacterController.getURL();
    }

    @Override
    public ModifyCharacterController getModifyCharacterController() {
        return this.modifyCharacterController;
    }

    @Override
    public void setNoCharactersLeftController(NoCharactersLeftController noCharactersLeftController) {
        this.noCharactersLeftController = noCharactersLeftController;
    }

    @Override
    public URL getNoCharactersLeftUrl() {
        return this.noCharactersLeftController.getURL();
    }

    @Override
    public NoCharactersLeftController getNoCharactersLeftController() {
        return this.noCharactersLeftController;
    }
    @Override
    public boolean canGoBackQuestion() {
        return this.game.canGoBack();
    }
    @Override
    public String goBackQuestion() {
        return this.game.getLastQuestionTitle();
    }

    @Override
    public void setCreateNewSaveController(CreateNewSaveController createNewSaveController) {
        this.createNewSaveController = createNewSaveController;
    }

    @Override
    public URL getCreateNewSaveUrl() {
        return this.createNewSaveController.getURL();
    }

    @Override
    public CreateNewSaveController getCreateNewSaveController() {
        return this.createNewSaveController;
    }

    @Override
    public boolean createNewSave(String fileName) {
        return this.repository.createNewSave(fileName);
    }

    @Override
    public boolean noQuestionLeft() {
        return this.game.noQuestionLeft();
    }

    @Override
    public Set<Character> getCharactersList() {
        return this.repository.getCharactersListToModify();
    }

    @Override
    public Set<Question> getQuestionsList() {
        return this.repository.getQuestionsListToModify();
    }

    @Override
    public URL getModifySaveUrl() {
        return this.modifySaveController.getURL();
    }

    @Override
    public ModifySaveController getModifySaveController() {
        return this.modifySaveController;
    }

    @Override
    public void setModifySaveController(ModifySaveController modifySaveController) {
        this.modifySaveController = modifySaveController;
    }
    @Override
    public String getLastCharacterImage() {
        return this.game.getLastCharacterImage();
    }

    @Override
    public void saveModifyBank(Collection<Character> characters, Collection<Question> questions) {
        this.repository.replaceCharacters(characters);
        this.repository.replaceQuestions(questions);
        this.save();
    }
    private void save(){
        try {
            this.repository.saveFile();
        } catch (Exception e){
            System.out.println("\033[31m" + "[Error] An error occurred while saving" + "\033[30m");
        }
    }
}
