package org.example.issuetracker.web.api;

import org.example.issuetracker.AbstractTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Abstract parent class for web asset unit tests such as RESTful web service
 * controllers.
 */
public abstract class AbstractWebTest extends AbstractTest {

    protected MockMvc mvc;

    @Autowired
    protected WebApplicationContext webApplicationContext;

    protected void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

}
