package com.paulhammant.fluentSeleniumExamples.hipmunk;

import org.openqa.selenium.WebDriver;
import org.seleniumhq.selenium.fluent.FluentWebDriverImpl;
import org.seleniumhq.selenium.fluent.FluentWebElement;

import static org.openqa.selenium.By.id;
import static org.seleniumhq.selenium.fluent.Period.secs;

public class Home extends FluentWebDriverImpl {
    public Home(WebDriver delegate) {
        super(delegate, Context.singular(null, "Home", ""));

        url().shouldMatch(".*hipmunk.com/");
    }

    protected void waitForExpandoToComplete() {
        div(id("flight-search")).getAttribute("class").within(secs(3)).shouldContain("expanded");
    }

    protected FluentWebElement searchButton() {
        return form(id("flight")).button();
    }

    protected FluentWebElement toAirportField() {
        return input(id("fac2flight"));
    }

    protected FluentWebElement fromAirportField() {
        return input(id("fac1flight"));
    }

}
