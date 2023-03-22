import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Survey {

    private static int id = 1;
    private String title;
    private String topic;
    private String description;

    List questions = new ArrayList<String>();
    Map answers  = new HashMap<String,String>();


    public Survey() {
        id++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List getQuestions() {
        return questions;
    }

    public void setQuestions(List questions) {
        this.questions = questions;
    }

    public Map getAnswers() {
        return answers;
    }

    public void setAnswers(Map answers) {
        this.answers = answers;
    }
}
