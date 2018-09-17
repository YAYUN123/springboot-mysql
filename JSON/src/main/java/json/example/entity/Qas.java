package json.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "qas")
public class Qas {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;


    @Column(name = "a_objects")
    public String a_objects;
    @Column(name = "question")
    public String question;
    @Column(name = "image_id")
    public Long image_id;
    @Column(name = "qa_id")
    public Long qa_id;
    @Column(name = "answer")
    public String answer;
   @Column(name = "q_objects")
    public String  q_objects;



    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Long getImage_id() {
        return image_id;
    }

    public void setImage_id(Long image_id) {
        this.image_id = image_id;
    }

    public Long getQa_id() {
        return qa_id;
    }

    public void setQa_id(Long qa_id) {
        this.qa_id = qa_id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getA_objects() {
        return a_objects;
    }

    public void setA_objects(String a_objects) {
        this.a_objects = a_objects;
    }

    public String getQ_objects() {
        return q_objects;
    }

    public void setQ_objects(String q_objects) {
        this.q_objects = q_objects;
    }

    @Override
    public String toString() {
        return "Qas{" +
                "id=" + id +
                ", a_objects='" + a_objects + '\'' +
                ", question='" + question + '\'' +
                ", image_id=" + image_id +
                ", qa_id=" + qa_id +
                ", answer='" + answer + '\'' +
                ", q_objects='" + q_objects + '\'' +
                '}';
    }
}
