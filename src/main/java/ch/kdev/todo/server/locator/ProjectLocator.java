package ch.kdev.todo.server.locator;

import java.util.ArrayList;
import java.util.List;

import ch.kdev.todo.server.domain.Project;

import com.google.web.bindery.requestfactory.shared.Locator;

public class ProjectLocator extends Locator<Project, Long> {
	
	public Long countProjects(){
		return (long) 12;
	}
	
	@Override
	public Project create(Class<? extends Project> clazz) {
		return new Project("test", "test", "test");
	}

	@Override
	public Project find(Class<? extends Project> clazz, Long id) {
		return new Project("1", "Test1", "Description of Test1");
	}

	public List<Project> findAll() {
		List<Project> allProjects = new ArrayList<Project>();

		allProjects.add(new Project("1", "Test1", "Description of Test1"));
		allProjects.add(new Project("2", "Test2", "Description of Test2"));
		allProjects.add(new Project("3", "Test3", "Description of Test3"));
		allProjects.add(new Project("4", "Test4", "Description of Test4"));

		return allProjects;
	}

	@Override
	public Class<Project> getDomainType() {
		return Project.class;
	}

	@Override
	public Long getId(Project domainObject) {
		return (long) 1;
	}

	@Override
	public Class<Long> getIdType() {
		return long.class;
	}

	@Override
	public Object getVersion(Project domainObject) {
		return 1;
	}
	
	public Project findProject(long id){
		return new Project("test", "test", "test");
	}
}