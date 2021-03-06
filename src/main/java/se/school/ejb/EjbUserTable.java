package se.school.ejb;
import se.school.classes.RoleClass;
import se.school.classes.SemesterClass;
import se.school.classes.SexClass;
import se.school.classes.UserClass;
import se.school.jpa.RoleTable;
import se.school.jpa.SemesterTable;
import se.school.jpa.SexTable;
import se.school.jpa.UserTable;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
/**
 * @author Benjamin Olsson
 */
@Stateless
public class EjbUserTable {
    @PersistenceContext
    private EntityManager em;

    public UserTable validateUser(String username, String password){
        List<UserTable> userTables = (List<UserTable>) em.createNamedQuery("validate").setParameter("username",username)
                .setParameter("password", password).getResultList();

        if (!userTables.isEmpty()) {
            System.out.println("Login validation not null");
            return userTables.get(0);
        }else return null;
    }
//    public UserTable validateUserRole(long userId){
//        List<UserTable> roles = (List<UserTable>) em.createNamedQuery("findUserRole").getResultList();
//
//        return roles.get(0).getRole();
//    }

    public void dataEntryRemove( Long id) {
        UserTable table = em.find(UserTable.class, id);
        em.remove(table);
    }

    public List<UserTable> getAllUsers(String located) {
        List<UserTable> l;
        if (located.equals(""))
            l = em.createNamedQuery("selectAll").getResultList();
        else
            l = em.createNamedQuery("selectOne").setParameter("id",located).getResultList();

        return l;
    }
	
	    public void registerStudent(UserClass student, SemesterClass semester){
        UserTable userTable = new UserTable();
        SemesterTable semesterTable = em.find(SemesterTable.class, semester.getSemesterId());
        userTable.setUserId(student.getUserId());
       // userTable.getSemesterTables().add(semesterTable);
    }


//    public String getUserSex(SexClass s){
//        SexTable sex = em.find(SexTable.class, s.getSexId());
//    }

    public void userAdd( UserClass p, SexClass s, RoleClass r ) {
        UserTable userTable = new UserTable();

        SexTable sex = em.find(SexTable.class, s.getSexId());

        RoleTable role = em.find(RoleTable.class, r.getRoleId());

        userTable.setUsername(p.getUsername());
        userTable.setPassword(p.getPassword());
        userTable.getRole().add(role);
     //   userTable.setRole((List<RoleTable>) role);
        userTable.setAdress(p.getAdress());
        userTable.setSex(sex);
        userTable.setBirthDate(p.getBirthDate());
        userTable.setContactDetails(p.getContactDetails());
        userTable.setName(p.getName());
        userTable.setEmail(p.getEmail());
//        try {
//            em.persist(userTable);
//        }catch (javax.persistence.PersistenceException ex){
//            return ex.getMessage();
//        }
//
//        return "";
        em.persist(userTable);
    }

    public void userRemove(Long id) {
        UserTable userTable = em.find(UserTable.class, id);
        em.remove(userTable);
    }
}
