package ch.kdev.todo.domain;

//TODO change this to an entity

public class Project {
   private Integer id;
   private String name;
   private String description;

   public Project() {

   }

   public Integer getID() {
      return id;
   }

   public void setID(Integer id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }
}