package com.example.JspStudentCrud.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students_tbl")
public class Student {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "first_name")
        private String firstName;
        @Column(name = "last_name")
        private String lastName;
        @Column(name = "gender")
        private String gender;

        @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
        @JoinTable(
                name = "student_beds",
                joinColumns = {@JoinColumn(name = "student_id")},
                inverseJoinColumns = {@JoinColumn(name = "bed_id")}
        )
    private Set<Bed> beds = new HashSet<Bed>();

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }


        public Set<Bed> getBeds() {
            return beds;
        }

        public void setBeds(Set<Bed> beds) {
            this.beds = beds;
        }

        public Student() {}

        public Student(String firstName, String lastName , String gender) {
            this.firstName = firstName;
            this.gender = gender;
            this.lastName = lastName;
        }
        public Student(Long id){
            this.id = id;
        }
        public Student(Long id, String firstName, String lastName , String gender) {
            this.id = id;
            this.firstName = firstName;
            this.gender = gender;
            this.lastName = lastName;
        }

}
