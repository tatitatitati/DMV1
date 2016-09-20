package com.redmine.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import redmine.pages.FirstFormPage;
import redmine.pages.TwoFormPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;



public class TestLogin extends BasicTestCase{

    private FirstFormPage firstFormPage = PageFactory.initElements(getWebDriver(), FirstFormPage.class);
    private TwoFormPage twoFormPage=PageFactory.initElements(getWebDriver(), TwoFormPage.class);


    @Test
    public void testFirstFormPresent() {
        firstFormPage.open();
        assertTrue(firstFormPage.questionPresent());
        assertTrue(firstFormPage.buttonPresent());
    }

    @Test
    public void testAddQuestion() throws Exception {
        firstFormPage.open();
        firstFormPage.writequestion("it my question").writequestionclick();
        twoFormPage.addcontacts(user).buttonNextClick();
    }

    @Test
    public void testTwoFormPresent() {
        firstFormPage.open();
        firstFormPage.writequestion("it my question").writequestionclick();
        assertTrue(twoFormPage.subjectPresent());
        assertTrue(twoFormPage.questionPresent());
        assertTrue(twoFormPage.firstnamePresent());
        assertTrue(twoFormPage.lastnamePresent());
        assertTrue(twoFormPage.emailPresent());
        assertTrue(twoFormPage.statePresent());
        assertTrue(twoFormPage.agreePresent());
        assertTrue(twoFormPage.buttonPresent());
    }

    @Test
    public void testTextFirstForm()
    {
        firstFormPage.open();
        assertTrue(firstFormPage.isTextPresent("Have a Question?"));
        assertTrue(firstFormPage.isTextPresent("Our expert research team is ready to help!"));

    }

    @Test
    public void testTextErrorFirstForm()
    {
        firstFormPage.open();
        firstFormPage.writequestionclick();
        assertTrue(firstFormPage.isTextPresent("We need to know what your question is."));
        assertTrue(firstFormPage.isTextPresent("Please, complete the form to precced."));
    }

    @Test
    public void testTextErrorTwoForm()
    {
        firstFormPage.open();
        firstFormPage.writequestion("it my question").writequestionclick();
        twoFormPage.addFirstname();
        twoFormPage.buttonNextClick();
        assertTrue(this.twoFormPage.isTextPresent("Enter your last name."));
        assertTrue(this.twoFormPage.isTextPresent("Enter a valid email address."));
        assertTrue(this.twoFormPage.isTextPresent("Please, complete the form to precced."));
    }



}