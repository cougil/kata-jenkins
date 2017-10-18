package com.sample.katajenkins;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

public class MyControllerShould {

    private MyController controller;

    @Before
    public void initialize() {
        this.controller = new MyController();
    }

    @Test
    public void return_my_name() {
        assertThat(this.controller.myName(), is("Anonymous"));
    }
}