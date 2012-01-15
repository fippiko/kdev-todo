package ch.kdev.todo.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

@Entity
public class Project {
   private Long       id;
   private Long       version;
   private String     name;
   private String     description;

   private List<Task> tasks;

   public Project() {
      this.version = (long) 1;
   }

   @Id
   @GeneratedValue(generator = "increment")
   @GenericGenerator(name = "increment", strategy = "increment")
   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   @Type(type = "string")
   @Length(max = 50)
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   @Type(type = "string")
   @Length(max = 250)
   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   @OneToMany(mappedBy = "project")
   @Cascade(value={CascadeType.ALL})
   public List<Task> getTasks() {
      return this.tasks;
   }

   public void setTasks(List<Task> tasks) {
      this.tasks = tasks;
   }

   public void addTask(Task task) {
      task.setProject(this);
      this.tasks.add(task);
   }

   public void setVersion(Long version) {
      this.version = version;
   }

   public Long getVersion() {
      return this.version;
   }

   @PrePersist
   void onPersist() {
      this.version++;
   }
}