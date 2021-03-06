package se.school.jpa;
/**
 * Created by:
 *
 * @author Pawel Koszalkowski on 9/7/2016.
 */

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CourseTable")
@NamedQueries({
        @NamedQuery(name="selectAllCourses",query="SELECT t FROM CourseTable t"),
        @NamedQuery(name="selectAllCourses2",query="SELECT c, l  FROM CourseTable c, LanguageTable l WHERE l = c.languageId"),
        @NamedQuery(name = "SelectWithJoin", query = "SELECT c FROM CourseTable c left JOIN fetch c.languageId a WHERE a = c.languageId")

})

public class CourseTable implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "courseId", updatable = false, nullable = false)
    private long courseId;
    private String courseCode;
    private String name;
    private String description;
    private String duration;
    private int maxStudents;

    @ManyToOne
    @JoinColumn(name="LANGUAGEID")
    private LanguageTable languageId;

    @ManyToOne
    @JoinColumn(name="LEVELID")
    private LevelTable levelId;

    public CourseTable(String courseCode, String name, String description, String duration, int maxStudents, LanguageTable languageId, LevelTable levelId) {

        this.courseCode = courseCode;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.maxStudents = maxStudents;
        this.languageId = languageId;
        this.levelId = levelId;
    }

    public CourseTable(){
        this.courseCode = "";
        this.name = "";
        this.description = "";
        this.duration = "";
        this.maxStudents = 0;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    public LanguageTable getLanguageId() {
        return languageId;
    }

    public void setLanguageId(LanguageTable languageId) {
        this.languageId = languageId;
    }

    public LevelTable getLevelId() {
        return levelId;
    }

    public void setLevelId(LevelTable levelId) {
        this.levelId = levelId;
    }
}
