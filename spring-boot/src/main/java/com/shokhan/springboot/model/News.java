package com.shokhan.springboot.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "News")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "published")
    private boolean published;

    public News(String title, String description, boolean published) {
        this.title = title;
        this.description = description;
        this.published = published;
    }
}



