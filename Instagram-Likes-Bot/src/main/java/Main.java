public class Main {
    public static void main(String[] args) throws InterruptedException {
        App app = new App();
        app.clickCookies();
        app.loginOp("","");
        Thread.sleep(5000);
        app.navigateToProfile("direct/fatihterim/");
        app.clickCookies();
        Thread.sleep(2000);
        app.clickFirstPost();
        app.likeAllPost();
    }
}
