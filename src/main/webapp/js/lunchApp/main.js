/**
 * This file is the application's main JavaScript file. It is listed as a dependency in index.html and will
 * automatically load when index.html loads.
 *
 * Because this file has the special filename `main.js`, and because we've registered the `app` package in run.js,
 * whatever object this module returns can be loaded by other files simply by requiring `app` (instead of `app/main`).
 *
 * The last dependency is a plugin dependency; in this case, it is a dependency on the special functionality of the
 * `dojo/domReady` plugin, which simply waits until the DOM is ready before resolving. The `!` after the module name
 * indicates you want to use special plugin functionality; if you were to require just `dojo/domReady`, it would load
 * that module just like any other module, without the special plugin functionality. Note that this is just an example
 * to show how plugins work; because our scripts are loaded before `</body>` in index.html, we don’t need to wait for
 * DOM ready; it will already be ready.
 *
 * In all cases, whatever function is passed to define() is only invoked once, and the returned value is cached.
 *
 * More information about everything described about the loader throughout this file can be found at
 * <http://dojotoolkit.org/reference-guide/loader/amd.html>.
 */
define([ 
    "dijit/Dialog",
    "dijit/layout/TabContainer",
    "dijit/layout/BorderContainer",
    "dijit/layout/ContentPane",
    "dojo/on",
    "./addLunchLocationContent",
    "./restaurantGrid",
    'dojo/domReady!'
], function (Dialog,TabContainer,BorderContainer,ContentPane,on,addLunchLocationContent,restaurantGrid) {
    var lunchApp = {};
    lunchAppGlobal.main = lunchApp;
    
    // Main Container
    var mainContainer = BorderContainer({
        "design": "headline"
    }, "mainContainer");
    
    var mainTabContainer = new TabContainer({
        style: "height: 100%; width: 100%;",
        tabPosition:"top",
        useMenu: false, 
        useSlider: false
    });
    
    //Lunch Suggestions
    var suggestionPane = new ContentPane({
        title: "Suggestions",
        content: "Put Lunch Suggestions Here"
    });
    mainTabContainer.addChild(suggestionPane);

    var restaurantContentWidget = restaurantGrid({ parent: this });
    lunchApp.restaurantContent = restaurantContentWidget;
    //Restaurants
    var restaurantListPane = new ContentPane({
        title: "Restaurants",
        content: restaurantContentWidget
    });
    mainTabContainer.addChild(restaurantListPane);
    
    on(restaurantListPane, "show", function(item){
        restaurantContentWidget.grid.resize();
    });
    
    //Restaurant Profiles
    var restaurantProfilePane = new ContentPane({
        title: "Restaurant Profiles",
        content: "Setup of Restaurant Profiles here."
    });
    mainTabContainer.addChild(restaurantProfilePane);

    //Call this to create the widget in the DOM
    mainContainer.addChild(mainTabContainer);
    
    mainTabContainer.startup();
//    mainTabContainer.selectTab(suggestionPane);
    
    //Lunch Location Content
    var lunchLocationWidget = addLunchLocationContent({ parent: this });
    //Add Dialog for Creating New Lunch Location
    lunchApp.addLunchLocationDialog = new Dialog({
        id: "addLunchLocation",
        title: "Add Restaurant",
        content:lunchLocationWidget,
        style: "width: 50%;font-size:18px;text-align:center;"
    });

    // It is important to remember to always call startup on widgets
    // It will not hurt if you do it twice, but things will often not work right if you forget to do it
    lunchApp.addLunchLocationDialog.startup();

    // Returning a value from an AMD module means that it becomes the value of the module. In this case, we return
    // the app object, which means that other parts of the application that require app/main could get a reference
    // to the dialog
    return lunchApp;
});