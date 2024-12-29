package module

import geb.Module

class MenuModule extends Module{
    static content = {
        menuButton { $("div.header-menu-wrap") }
        linksContainer { $("li.submenu_cat") }
        links { linksContainer.find("a") }
    }
}
