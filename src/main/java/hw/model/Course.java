package hw.model;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "courses")
public class Course {
    public static final Random random = new Random();
    public static final String[] titles = new String[] {"JDK","JavaJunior","Linux","JavaCore"
            ,"SQL","GitHub","JavaSyntax","Tomcat","Agile"};


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Course_ID")
    private int id;
    @Column(name = "Title")
    private String title;
    @Column(name = "Duration")
    private int duration;

    public Course(int id, String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public Course(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public Course() {
    }
    public static Course create() {return new Course(titles[random.nextInt(titles.length)],random.nextInt(12,24));}

    public void updateDuration(){
        duration = random.nextInt(100, 200);
    }

    public void updateName(){
        title = titles[random.nextInt(titles.length)];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                " month}";
    }
}
