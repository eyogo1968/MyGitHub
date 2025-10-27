package com.company.planner;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.company.planner.OldestPerson.*;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class OldestPersonTest {

    @Test
    public void getOldestPersonShouldReturnOldestPerson() {
        Person sara = new Person("Sara Conor", 4, "Human");
        Person terminator = new Person("Terminator", 40, "Cyborg");
        Person shwarzy = new Person("Arnold Shwarz", 42, "Human");
        List<Person> collection = asList(sara, shwarzy, terminator);
        assertThat(getOldestPerson(collection), is(shwarzy));
    }

}