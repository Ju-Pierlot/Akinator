package model.questions;

public class Question implements Cloneable {
    private String title;
    private String key;

    public Question(String title, String key){
        this.title = title;
        this.key = key;
    }

    public String getTitle(){
        return this.title;
    }
    public String getKey(){
        return this.key;
    }
    public void setTitle(String title){
        if(title != null && title.length() > 0){
            this.title = title;
        }
    }
    @Override
    public int hashCode() {
        return this.title.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null){
            return this.title.equals(((Question)obj).getTitle());
        }
        return false;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return this.getTitle();
    }

    public Question copy(){
        try{
            return (Question)this.clone();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
