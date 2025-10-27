package com.company.planner;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.company.planner.FilterCollection.*;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FilterCollectionTest {

    @Test
    public void transformKeepStringsShorterThant4Characters() {
        List<String> collection = asList("My", "name", "is", "John", "Doe");
        List<String> expected = asList("My", "is", "Doe");
        assertThat(transform(collection), is(expected));
    }

}