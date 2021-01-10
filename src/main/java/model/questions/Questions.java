package model.questions;

import java.util.*;

public class Questions implements IQuestions, Cloneable {
    private Map<String, Question> questions;

    public Questions(){
        this.questions = new HashMap<>();
    }
    @Override
    public void addQuestion(Question question) {
        if(question != null){
            this.questions.put(question.getKey(), question);
        }
    }
    @Override
    public void removeQuestion(Question question) {
        if(question != null){
            this.questions.remove(question.getKey());
        }
    }
    @Override
    public int size() {
        return this.questions.size();
    }

    @Override
    public IQuestions cloneObject() {
        try{
            return (IQuestions) this.clone();
        } catch (CloneNotSupportedException e){
            return null;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String getQuestionTitle(String key) {
        return this.questions.get(key).getTitle();
    }

    @Override
    public Question getQuestion(String key) {
        return this.questions.get(key);
    }

    @Override
    public int removeQuestionAndSize(String key) {
        this.questions.remove(key);
        return this.size();
    }

    @Override
    public void setNewQuestionMap(Map<String, Question> questions) {
        this.questions = questions;
    }

    @Override
    public Map<String, Question> getMapQuestions() {
        return this.questions;
    }

    @Override
    public String createQuestion(String title) {
        int keyInt = this.questions.size()*350;
        String key = Integer.toString(keyInt);
        while (this.questions.containsKey(key)){
            keyInt++;
            key = Integer.toString(keyInt);
        }
        Question question = new Question(title, key);
        if(this.questions.containsValue(question)){
            for(Question question1 : this.questions.values()){
                if(question.equals(question1)) key = question1.getKey();
            }
        } else {
            this.questions.put(key, question);
        }
        return key;
    }

    @Override
    public boolean noQuestionLeft() {
        return this.questions.size() == 0;
    }

    @Override
    public Set<Question> getQuestionsListToModify() {
        return new HashSet<>(this.questions.values());
    }

    @Override
    public void replace(Collection<Question> questions) {
        this.questions.clear();
        for (Question question : questions){
            this.questions.put(question.getKey(), question);
        }
    }
}
