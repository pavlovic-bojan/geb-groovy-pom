import pages.HomePage

class HomePageSpec extends BaseSpec {

    def "Validate that the user is on the Home Page"() {
        when: "The user landed on the home page"
        to HomePage
        then: "The user is on home page"
        driver.currentUrl == baseUrl    }

    def "Validate that the image slider is visible on the Home Page"() {
        when: "The user landed on the home page"
        to HomePage
        then: "The image slider is visible"
        at HomePage
        page.imageSlider.displayed
    }

    def "Validate that the menu is visible on the Home Page"() {
        when: "The user landed on the home page"
        to HomePage
        then: "The menu is visible"
        at HomePage
        page.menu.menuButton.displayed
    }
}
