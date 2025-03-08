package com.prathvi.demoprathvi.course;

import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="course_db")
public class Course {
    @Id
    private long id;

    private String title;
    private String description;

    // Parameterized constructor
//    public Course(long id, String title, String description) {
//        super();
//        this.id = id;
//        this.title = title;
//        this.description = description;
//    }

    // Default constructor
//    public Course() {
//        super();
//    }

    // Getter for id
//    public long getId() {
//        return id;
//    }

    // Setter for id
//    public void setId(long id) {
//        this.id = id;
//    }

    // Getter for title
//    public String getTitle() {
//        return title;
//    }

    // Setter for title
//    public void setTitle(String title) {
//        this.title = title;
//    }

    // Getter for description
//    public String getDescription() {
//        return description;
//    }

    // Setter for description
//    public void setDescription(String description) {
//        this.description = description;
//    }

//    @Override
//    public String toString() {
////        return "Couse{id=" + id + ", title='" + title + "', description=" + description + "}";
//    }
}
