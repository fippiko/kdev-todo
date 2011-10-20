package ch.kdev.todo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "tasks")
public class Task {
   private Long    id;
   private String  name;
   private String  description;

   private Project project;

   public Task() {
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
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   @Type(type = "string")
   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   @ManyToOne
   @NotNull
   public Project getProject() {
      return this.project;
   }

   public void setProject(Project project) {
      this.project = project;
   }
}