package org.example.issuetracker.service;

import java.util.List;

import org.example.issuetracker.model.jpa.Issue;

public interface IssueService {

    /**
     * Search the issue data repository for all Issue entities.
     * @return A List of Issue entities or null if none found.
     */
    List<Issue> findAll();

    /**
     * Search the issue data repository for a single Issue entity by the primary
     * key identifier.
     * @param id An issue primary key identifier.
     * @return An Issue entity or null if not found.
     */
    Issue find(Long id);

    /**
     * Create a new Issue entity in the data repository.
     * @param issue An issue entity to persist.
     * @return The persisted issue entity.
     */
    Issue create(Issue issue);

    /**
     * Update an Issue entity in the data repository.
     * @param issue An issue entity to update.
     * @return The updated issue entity.
     */
    Issue update(Issue issue);

    /**
     * Delete an Issue entity from the data repository.
     * @param id The primary key identifier of the issue to delete.
     */
    void delete(Long id);

}
