package org.example.issuetracker.service;

import java.util.List;

import org.example.issuetracker.model.jpa.Issue;

public interface IssueService {

	/**
	 * Search the issue data repository for all Issue entities. 
	 * @return A List of Issue entities or null if none found.
	 */
	List<Issue> findAll();
	
}
