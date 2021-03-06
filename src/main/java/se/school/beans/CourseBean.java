package se.school.beans;

import se.school.ejb.*;
import se.school.classes.*;
import se.school.jpa.*;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by:
 *
 * @author Pawel Koszalkowski on 9/12/2016.
 */
@Named
@SessionScoped
public class CourseBean implements Serializable{
    private LanguageClass language = new LanguageClass();
    private CourseClass course = new CourseClass();
    private LevelClass level = new LevelClass();
    @Inject
    private EjbLanguageTable languageService;
    @Inject
    private EjbCourseTable courseService;
    @Inject
    private EjbLevelTable levelService;



    /////////////////////////language//////////////////////

    public List<LanguageTable> getLanguagesList(){
        return languageService.getAllLanguages();
    }

    public String addLanguage(){
        languageService.addLanguage(language);
        return "language";
    }
    public void editLanguage(long id){
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Sorry implementation later!");
        FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);
    }
    public String removeLanguage(long id){
        //sexService.dataEntryRemove(id);
        return "language";
    }

    //getters and setters for language
    public long getLanguageId(){
        return language.getLanguageId();
    }

    public void setLanguageId(long languageId){
        language.setLanguageId(languageId);
    }

    public String getLanguageName() {
        return language.getLanguage();
    }

    public void setLanguageName(String lan) {
        language.setLanguage(lan);
    }


    ////////////////////////level//////////////////////////
    public List<LevelTable> getLevelsList(){
        return levelService.getAllLevelss();
    }

    public String addLevel(){
        levelService.addLevel(level);
        return "level";
    }
    public void editLevel(long id){
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Sorry implementation later!");
        FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);
    }
    public String removeLevel(long id){
        //sexService.dataEntryRemove(id);
        return "level";
    }

    public long getLevelId() {
        return level.getLevelId();
    }

    public void setLevelId(long levelId) {
        level.setLevelId(levelId);
    }

    public String getLevel() {
        return level.getLevel();
    }

    public void setLevel(String levelName) {
        level.setLevel(levelName);
    }


    ////////////////// COURSE ////////////////////////////////////////////////////////////
    public String addCourse(){
        //userClass = new UserClass(getUsername(),getPassword(), getRole());
        courseService.courseAdd(course, language, level);

        return "course";
    }

    public List<CourseTable> getCourseList(){
        return courseService.getAllCourses("");

    }
    public List<CourseTable> getCourseList2(){
        return courseService.getAllCourses("sdfsd");

    }
    public void editCourse(long id){
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Sorry implementation later!");
        FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);
    }
    public String removeCourse(long id){
        courseService.removeCourse(id);
        return "course";
    }
    public  String getCourseName(){
        return course.getName();
    }
    public void setCourseName(String courseName){
        course.setName(courseName);
    }
    public  String getCourseCode(){
        return course.getCourseCode();
    }
    public void setCourseCode(String courseCode){
        course.setCourseCode(courseCode);
    }
    public long getCourseId(){
        return course.getCourseId();
    }
    public void setCourseId(long courseId){
        course.setCourseId(courseId);
    }
    public  String getCourseDescription(){
        return course.getDescription();
    }
    public void setCourseDescription(String courseDescription){
        course.setDescription(courseDescription);
    }
    public  String getCourseDuration(){
        return course.getDuration();
    }
    public void setCourseDuration(String courseDuration){
        course.setDuration(courseDuration);
    }
    public int getCourseMaxStudents(){
        return course.getMaxStudents();
    }
    public void setCourseMaxStudents(int courseMaxStudents){
        course.setMaxStudents(courseMaxStudents);
    }


}
