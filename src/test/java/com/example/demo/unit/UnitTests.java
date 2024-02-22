package com.example.demo.unit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

public class UnitTests {
    
    @Test
    public void ejemplo_de_test_unitario() {
        assertThat(2+2,equalTo(4) );
    }
}
