package com.socks.ui.tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class BaseUiTest {

    protected final Faker faker = new Faker(new Locale("ru"));
}