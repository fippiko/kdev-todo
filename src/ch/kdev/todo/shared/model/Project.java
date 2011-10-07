package ch.kdev.todo.shared.model;

public class Project {
   private String _id;
   private String _name;
   private String _description;

   public Project(String id, String name, String description) {
      this.setID(id);
      this.setName(name);
      this.setDescription(description);
   }

   public String getID() {
      return _id;
   }

   public void setID(String id) {
      _id = id;
   }

   public String getName() {
      return _name;
   }

   public void setName(String name) {
      this._name = name;
   }

   public String getDescription() {
      return _description;
   }

   public void setDescription(String description) {
      this._description = description;
   }

}
