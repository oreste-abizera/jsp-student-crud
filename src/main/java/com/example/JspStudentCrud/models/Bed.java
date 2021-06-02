package com.example.JspStudentCrud.models;

import com.example.JspStudentCrud.models.enums.BedType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bed")
public class Bed {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;
        @Column(name = "number")
        private Integer number;
        @Column(name = "type")
        @Enumerated(EnumType.STRING)
        private BedType type;

        @ManyToMany(mappedBy = "beds", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
        private Set<Student> students = new HashSet<>();


        public Bed() {}

        public Bed(Long id, Integer number, BedType type) {
                this.id = id;
                this.number = number;
                this.type = type;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Integer getNumber() {
                return number;
        }

        public void setNumber(Integer number) {
                this.number = number;
        }

        public BedType getType() {
                return type;
        }

        public void setType(BedType type) {
                this.type = type;
        }

        public Set<Student> getStudents() {
                return students;
        }

        public void setStudents(Set<Student> students) {
                this.students = students;
        }
}