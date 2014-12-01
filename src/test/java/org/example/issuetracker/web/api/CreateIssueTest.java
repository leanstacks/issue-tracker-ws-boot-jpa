package org.example.issuetracker.web.api;

import org.example.issuetracker.model.jpa.Issue;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateIssueTest extends AbstractIssueWebTest {

    @Before
    public void setUp() {
        super.setUp(false);
    }

    @After
    public void tearDown() {
        super.tearDown();
    }

    @Test
    public void testCreateIssue() throws Exception {
        String uri = "/issues";

        ObjectMapper mapper = new ObjectMapper();
        String inputJson = mapper.writeValueAsString(testIssue);

        MvcResult result = mvc.perform(
                MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON).content(inputJson))
                .andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();

        // Assert the Web Service HTTP Response
        Assert.assertEquals("failure - expected HTTP status code 201", 201,
                status);
        Assert.assertTrue("failure - expected value in HTTP response body",
                content.trim().length() > 0);

        // Map the Response Object to Assert Attribute Values
        Issue responseIssue = mapper.readValue(content, Issue.class);
        // Set the testIssue.id attribute for tearDown()
        testIssue.setId(responseIssue.getId());

        Assert.assertNotNull("failure - expected id value",
                responseIssue.getId());
        Assert.assertEquals("failure - expected type match",
                testIssue.getType(), responseIssue.getType());
        Assert.assertEquals("failure - expected priority match",
                testIssue.getPriority(), responseIssue.getPriority());
        Assert.assertEquals("failure - expected status match",
                testIssue.getStatus(), responseIssue.getStatus());
        Assert.assertEquals("failure - expected title match",
                testIssue.getTitle(), responseIssue.getTitle());
        Assert.assertEquals("failure - expected description match",
                testIssue.getDescription(), responseIssue.getDescription());
    }

}
