package ch.kdev.todo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table( name = "PROJECTS" )
public class Project {
   private Long id;
   private String name;
   private String description;

   public Project() {
   }

   @Id
   @GeneratedValue(generator="increment")
   @GenericGenerator(name="increment", strategy="increment")
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
}