package com.example.JspStudentCrud.models;

import javax.persistence.*;

@Entity
@Table(name = "student")
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
