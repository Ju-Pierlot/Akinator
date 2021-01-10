package model.questions;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface IQuestions {
    void addQuestion(Question question);
    void removeQuestion(Question question);
    int size();
    IQuestions cloneObject();
    String getQuestionTitle(String key);
    Question getQuestion(String key);
    int removeQuestionAndSize(String key);
    void setNewQuestionMap(Map<String, Question> questions);
    Map<String, Question> getMapQuestions();
    String createQuestion(String title);
    boolean noQuestionLeft();
    Set<Question> getQuestionsListToModify();
    void replace(Collection<Question> questions);
}
