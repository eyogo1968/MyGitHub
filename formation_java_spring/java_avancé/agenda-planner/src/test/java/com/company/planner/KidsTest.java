package com.company.planner;


import org.junit.jupiter.api.Test;

import java.util.List;

import static com.company.planner.Kids.*;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class KidsTest {

    @Test
    public void getKidNameShouldReturnNamesOfYoungerThan18() {
        Person sara = new Person("Sara Conor", 4, "Human");
        Person terminator = new Person("Terminator", 40, "Cyborg");
        Person shwarzy = new Person("Arnold Shwarz", 42, "Human");
        Person anna = new Person("Anna", 5, "Human");
        List<Person> collection = asList(sara, terminator, shwarzy, anna);
        assertThat(getKidNames(collection), hasItems("Sara Conor", "Anna"));
        assertThat(getKidNames(collection), not(contains("Terminator", "Arnold Shwarz")));
    }

}