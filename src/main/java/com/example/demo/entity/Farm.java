package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "farms")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double soilPH;
    private double waterLevel;
    private String season;

    // @ManyToOne
    // private User owner;

    @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "owner_id", nullable = false)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
private User owner;

// @ManyToOne(fetch = FetchType.EAGER)
// @JoinColumn(name = "owner_id", nullable = false)
// @JsonIgnoreProperties({"password"})
// private User owner;


}
