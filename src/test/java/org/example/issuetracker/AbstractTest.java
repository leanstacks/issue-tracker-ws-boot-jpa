package org.example.issuetracker;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Abstract parent class for all project unit tests. Incorporates Spring unit
 * test configuration for JUnit.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(
        classes = Application.class)
public abstract class AbstractTest {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

}
