package org.example.issuetracker.service;

import java.util.ArrayList;
import java.util.List;

import org.example.issuetracker.model.jpa.Issue;
import org.example.issuetracker.repository.IssueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssueServiceBean implements IssueService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IssueRepository issueRepository;

	@Override
	public List<Issue> findAll() {
		logger.info("> findAll");

		List<Issue> issues = issueRepository.findAll();
		
		// if no issues found, return empty list instead of null
		if(issues == null) {
			issues = new ArrayList<Issue>();
		}
		
		logger.info("< findAll");
		return issues;
	}

}
