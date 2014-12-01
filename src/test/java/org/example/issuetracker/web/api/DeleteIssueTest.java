package org.example.issuetracker.web.api;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class DeleteIssueTest extends AbstractIssueWebTest {

    @Before
    public void setUp() {
        super.setUp(true);
    }

    @After
    public void tearDown() {
        super.tearDown();
    }

    @Test
    public void testDeleteIssue() throws Exception {
        String uri = "/issues/{id}";
        Long id = testIssue.getId();

        MvcResult result = mvc.perform(MockMvcRequestBuilders.delete(uri, id))
                .andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();

        // Assert the Web Service HTTP Response
        Assert.assertEquals("failure - expected HTTP status code 204", 204,
                status);
        Assert.assertTrue("failure - expected empty HTTP response body",
                content.trim().length() == 0);

        // Assert Data Removed from Database
        testIssue = issueService.find(id);

        Assert.assertNull("failure - expected null", testIssue);
    }

}
