package org.example.issuetracker.web.api;

import org.example.issuetracker.model.IssuePriority;
import org.example.issuetracker.model.IssueStatus;
import org.example.issuetracker.model.IssueType;
import org.example.issuetracker.model.jpa.Issue;
import org.example.issuetracker.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Abstract parent class for unit testing project assets requiring Issue entity
 * persistence.
 */
public abstract class AbstractIssueWebTest extends AbstractWebTest {

    protected Issue testIssue;

    @Autowired
    protected IssueService issueService;

    protected void setUp(boolean save) {
        super.setUp();
        testIssue = createIssue(save);
    }

    protected void tearDown() {
        if (testIssue != null && testIssue.getId() != null) {
            issueService.delete(testIssue.getId());
        }
    }

    private Issue createIssue(boolean save) {
        Issue i = new Issue();
        i.setType(IssueType.TASK);
        i.setPriority(IssuePriority.MEDIUM);
        i.setStatus(IssueStatus.OPEN);
        i.setTitle("Test Task");
        i.setDescription("Test issue description.");
        if (save) {
            i = issueService.create(i);
        }
        return i;
    }

}
