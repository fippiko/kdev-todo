package ch.kdev.todo.client.mapper;

import ch.kdev.todo.client.place.project.AddProjectPlace;
import ch.kdev.todo.client.place.project.EditProjectPlace;
import ch.kdev.todo.client.place.project.ManageProjectsPlace;
import ch.kdev.todo.client.place.project.ViewProjectPlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

/**
 * PlaceHistoryMapper interface is used to attach all places which the
 * PlaceHistoryHandler should be aware of. This is done via the @WithTokenizers
 * annotation or by extending PlaceHistoryMapperWithFactory and creating a
 * separate TokenizerFactory.
 */
@WithTokenizers({ManageProjectsPlace.Tokenizer.class, 
   EditProjectPlace.Tokenizer.class, 
   AddProjectPlace.Tokenizer.class, 
   ViewProjectPlace.Tokenizer.class,
   AddProjectPlace.Tokenizer.class})
public interface ClientPlaceHistoryMapper extends PlaceHistoryMapper {

}
