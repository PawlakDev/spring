package com.example.studia.models;


import jakarta.persistence.*;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "plan")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long idu;

    private String name;

    //one to many field with workouts
    @OneToMany(mappedBy = "plan")
    private List<Workouts> workouts;

    //many to one field with user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
