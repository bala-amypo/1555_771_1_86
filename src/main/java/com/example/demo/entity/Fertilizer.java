









// package com.example.demo.entity;


// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
// import jakarta.validation.constraints.Max;
// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.Size;
// import jakarta.persistence.Entity;



// @Entity
// @Table(name = "fertilizers")
// public class Fertilizer {
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;
    
//     @NotBlank(message = "Name should not be empty")
//     @Max(100)
//     private String name;

//     @NotBlank
//     private String npkRatio;

//     @NotBlank(message = "Recommended crops list cannot be blank")
//     @Size(max = 500, message = "The list of crops must not exceed 500 characters")
//     private String recommendedForCrops;

//     public Fertilizer() {
//     }
    
//     public Fertilizer(long id, String name, String npkRatio, String recommendedForCrops) {
//         this.id = id;
//         this.name = name;
//         this.npkRatio = npkRatio;
//         this.recommendedForCrops = recommendedForCrops;
//     }
//     public long getId() {
//         return id;
//     }
//     public String getName() {
//         return name;
//     }
//     public String getNpkRatio() {
//         return npkRatio;
//     }
//     public String getRecommendedForCrops() {
//         return recommendedForCrops;
//     }
//     public void setId(long id) {
//         this.id = id;
//     }
//     public void setName(String name) {
//         this.name = name;
//     }
//     public void setNpkRatio(String npkRatio) {
//         this.npkRatio = npkRatio;
//     }
//     public void setRecommendedForCrops(String recommendedForCrops) {
//         this.recommendedForCrops = recommendedForCrops;
//     }

    
// }
