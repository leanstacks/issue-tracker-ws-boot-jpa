package org.example.issuetracker.web.api;

import java.util.ArrayList;
import java.util.List;

import org.example.issuetracker.model.jpa.Issue;
import org.example.issuetracker.service.IssueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IssueController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IssueService issueService;

    @RequestMapping(value = "/issues", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Issue>> getAllIssues() {
        logger.info("> getAllIssues");

        List<Issue> issues = null;
        try {
            issues = issueService.findAll();

            // if no issues found, create an empty list
            if (issues == null) {
                issues = new ArrayList<Issue>();
            }
        } catch (Exception e) {
            logger.error("Unexpected Exception caught.", e);
            return new ResponseEntity<List<Issue>>(issues,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        logger.info("< getAllIssues");
        return new ResponseEntity<List<Issue>>(issues, HttpStatus.OK);
    }

}
