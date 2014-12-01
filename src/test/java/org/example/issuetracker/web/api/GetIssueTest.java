package org.example.issuetracker.web.api;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class GetIssueTest extends AbstractIssueWebTest {

    @Before
    public void setUp() {
        super.setUp(true);
    }

    @After
    public void tearDown() {
        super.tearDown();
    }

    @Test
    public void testGetAllIssues() throws Exception {
        String uri = "/issues";

        MvcResult result = mvc.perform(
                MockMvcRequestBuilders.get(uri).accept(
                        MediaType.APPLICATION_JSON)).andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();

        // Assert the Web Service HTTP Response
        Assert.assertEquals("failure - expected HTTP status code 200", 200,
                status);
        Assert.assertTrue("failure - expected value in HTTP response body",
                content.trim().length() > 0);
    }

    @Test
    public void testGetIssue() throws Exception {
        String uri = "/issues/{id}";
        Long id = testIssue.getId();

        MvcResult result = mvc.perform(
                MockMvcRequestBuilders.get(uri, id).accept(
                        MediaType.APPLICATION_JSON)).andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();

        // Assert the Web Service HTTP Response
        Assert.assertEquals("failure - expected HTTP status code 200", 200,
                status);
        Assert.assertTrue("failure - expected value in HTTP response body",
                content.trim().length() > 0);
    }

    @Test
    public void testGetIssueNotFound() throws Exception {
        String uri = "/issues/{id}";
        Long id = testIssue.getId() + 1;

        MvcResult result = mvc.perform(
                MockMvcRequestBuilders.get(uri, id).accept(
                        MediaType.APPLICATION_JSON)).andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();

        // Assert the Web Service HTTP Response
        Assert.assertEquals("failure - expected HTTP status code 404", 404,
                status);
        Assert.assertTrue("failure - expected empty HTTP response body",
                content.trim().length() == 0);
    }

}
