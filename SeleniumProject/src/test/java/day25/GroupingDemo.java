package day25;


import org.testng.annotations.Test;

public class GroupingDemo {

    @Test(groups = {"smoke"})
    public void loginTest()
    {
        System.out.println("Smoke Test - Login");
    }

    @Test(groups = {"smoke"})
    public void searchTest()
    {
        System.out.println("Smoke Test - Search");
    }

    @Test(groups = {"regression"})
    public void addToCartTest()
    {
        System.out.println("Regression Test - Add To Cart");
    }

    @Test(groups = {"regression"})
    public void paymentTest()
    {
        System.out.println("Regression Test - Payment");
    }
}