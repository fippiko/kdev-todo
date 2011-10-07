package ch.kdev.todo.server.domain;

//TODO change this to an entity

public class Project {
   private String id;
   private String name;
   private String description;

   public Project(String id, String name, String description) {
      this.setID(id);
      this.setName(name);
      this.setDescription(description);
   }

   public String getID() {
      return id;
   }

   public void setID(String id) {
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