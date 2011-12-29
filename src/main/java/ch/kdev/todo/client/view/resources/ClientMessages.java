package ch.kdev.todo.client.view.resources;

/**
 * Interface to represent the messages contained in resource bundle:
 * 	/home/philipp/Development/GWT/gwt-mvp-prototype/src/main/resources/ch/kdev/todo/client/view/resources/ClientMessages.properties'.
 */
public interface ClientMessages extends com.google.gwt.i18n.client.Messages {
  
  /**
   * Translated "Add Project".
   * 
   * @return translated "Add Project"
   */
  @DefaultMessage("Add Project")
  @Key("addProject")
  String addProject();

  /**
   * Translated "Add Task".
   * 
   * @return translated "Add Task"
   */
  @DefaultMessage("Add Task")
  @Key("addTask")
  String addTask();

  /**
   * Translated "Delete Project".
   * 
   * @return translated "Delete Project"
   */
  @DefaultMessage("Delete Project")
  @Key("deleteProject")
  String deleteProject();

  /**
   * Translated "Edit Project".
   * 
   * @return translated "Edit Project"
   */
  @DefaultMessage("Edit Project")
  @Key("editProject")
  String editProject();

  /**
   * Translated "Manage Projects".
   * 
   * @return translated "Manage Projects"
   */
  @DefaultMessage("Manage Projects")
  @Key("manageProjects")
  String manageProjects();

  /**
   * Translated "View Project".
   * 
   * @return translated "View Project"
   */
  @DefaultMessage("View Project")
  @Key("viewProject")
  String viewProject();
}
