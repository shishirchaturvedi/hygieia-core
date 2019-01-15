package com.capitalone.dashboard.repository;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = { FongoConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
public abstract class FongoBaseRepositoryTest {

}
