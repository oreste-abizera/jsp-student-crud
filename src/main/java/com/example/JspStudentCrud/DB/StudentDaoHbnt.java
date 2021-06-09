package com.example.JspStudentCrud.DB;
import java.util.List;

import com.example.JspStudentCrud.models.Bed;
import com.example.JspStudentCrud.models.BedAssignment;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.JspStudentCrud.models.Student;
import com.example.JspStudentCrud.utils.HibernateUtil;


public class StudentDaoHbnt {
    /**
     * Save Student
     * @param bed
     */

    public Long saveBed(Bed bed){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Long bedId = (Long) session.save(bed);
            transaction.commit();
            return bedId;
        }catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }
        return null;
    }

    public void saveStudent(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(student);
            // commit transaction
            transaction.commit();
            System.out.println(" New student added using hibernate okay");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Long saveBedAssignment(BedAssignment bedAssignment) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            Long bedId = (Long) session.save(bedAssignment);
            // commit transaction
            transaction.commit();
            return bedId;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }
    /**
     * Update Student
     *
     * @param student
     */
    public void updateStudent(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(student);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    /**
     * Delete Student
     *
     * @param id
     */
    public void deleteStudent(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // Delete a student object
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.delete(student);
                System.out.println("student is deleted");
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    /**
     * Get Student By ID
     *
     * @param id
     * @return
     */
    public Student getStudent(Long id) {
        Transaction transaction = null;
        Student student = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an student object
            student = session.get(Student.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return student;
    }
    /**
     * Get all Students
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Student> getAllStudents() {
        Transaction transaction = null;
        List<Student> listOfStudent = null;
        String hbl = "Select p from Student p";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // get an student object
//            listOfStudent = session.createQuery("from Student").getResultList();
            // commit transaction
//            listOfStudent = session.createQuery(hbl).getResultList();
            listOfStudent = session.createQuery("from Student").list();
            System.out.println(listOfStudent);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfStudent;
    }
}