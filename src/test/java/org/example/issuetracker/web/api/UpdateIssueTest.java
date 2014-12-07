package org.example.issuetracker.web.api;

import org.example.issuetracker.model.Issue;
import org.example.issuetracker.model.IssuePriority;
import org.example.issuetracker.model.IssueStatus;
import org.example.issuetracker.model.IssueType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UpdateIssueTest extends AbstractIssueWebTest {

    @Before
    public void setUp() {
        super.setUp(true);
    }

    @After
    public void tearDown() {
        super.tearDown();
    }

    @Test
    public void testUpdateIssue() throws Exception {
        String uri = "/issues/{id}";
        Long id = testIssue.getId();

        // Change Attribute Values
        String title = "Updated Title";
        String description = "Updated description.";
        testIssue.setType(IssueType.STORY);
        testIssue.setPriority(IssuePriority.HIGH);
        testIssue.setStatus(IssueStatus.IN_PROGRESS);
        testIssue.setTitle(title);
        testIssue.setDescription(description);

        ObjectMapper mapper = new ObjectMapper();
        String inputJson = mapper.writeValueAsString(testIssue);

        MvcResult result = mvc.perform(
                MockMvcRequestBuilders.put(uri, id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON).content(inputJson))
                .andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();

        // Assert the Web Service HTTP Response
        Assert.assertEquals("failure - expected HTTP status code 200", 200,
                status);
        Assert.assertTrue("failure - expected value in HTTP response body",
                content.trim().length() > 0);

        // Map the Response Object to Assert Attribute Values
        Issue responseIssue = mapper.readValue(content, Issue.class);

        Assert.assertEquals("failure - expected id match", id,
                responseIssue.getId());
        Assert.assertEquals("failure - expected type match", IssueType.STORY,
                responseIssue.getType());
        Assert.assertEquals("failure - expected priority match",
                IssuePriority.HIGH, responseIssue.getPriority());
        Assert.assertEquals("failure - expected status match",
                IssueStatus.IN_PROGRESS, responseIssue.getStatus());
        Assert.assertEquals("failure - expected title match", title,
                responseIssue.getTitle());
        Assert.assertEquals("failure - expected description match",
                description, responseIssue.getDescription());
    }

}
