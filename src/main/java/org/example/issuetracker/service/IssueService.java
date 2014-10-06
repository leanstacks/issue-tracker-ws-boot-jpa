package org.example.issuetracker.service;

import java.util.List;

import org.example.issuetracker.model.jpa.Issue;

public interface IssueService {

	List<Issue> findAll();
	
}
