package ch.kdev.todo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
public class Task {
   private Long    id;
   private Long    version;
   private String  name;
   private String  description;

   private Project project;

   public Task() {
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
   @JoinColumn(name="project_id")
   public Project getProject() {
      return this.project;
   }

   public void setProject(Project project) {
      this.project = project;
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