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

}
