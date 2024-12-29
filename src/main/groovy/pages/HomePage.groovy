package pages

import geb.Page
import module.MenuModule

class HomePage extends Page{

    static url = "/"

    static at = {
        title == "N Selection"
    }

    static content = {
        imageSlider (wait: true){$("body > div.init-slider-wrap")}
        menu { module(MenuModule) }
    }

    def "Show Image Slider on Home Page"(){
        imageSlider.isDisplayed()
    }

    def "Show Menu on Home Page"(){
        menu.isDisplayed()
    }

}
