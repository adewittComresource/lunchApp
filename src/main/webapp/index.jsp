<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Lunch App Boilerplate</title>
    <!-- Application-specific CSS should be stored in your application?s package to ensure portability and to allow
         the build system to combine & minify it. -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body class="claro">
    <!-- It's important to get something displayed to users as quickly as possible; here, we show a very basic loading
         screen, which becomes hidden once the application loads -->
    <div class="lunchAppContainer">
        <div id="mainContainer"></div>
    </div>

    <!-- dojo.js is an AMD-compliant loader script. It accepts configuration either from a data-dojo-config attribute
         on the dojo.js script tag, from a global dojoConfig object (shown here), or from a global require object.
         Configuration options for the loader can be viewed at http://dojotoolkit.org/reference-guide/loader/amd.html
         along with a bunch of additional information about its features.
         NOTE: build.sh is responsible for removing the "isDebug" flag when deploying to production. If you modify
         this flag at all, you will break the build! -->
    <script>
        var dojoConfig = {
            // Enable the AMD loader
            async: true,
            // Define the base URL for all of our modules and packages
            baseUrl: '.',
            // Enable debugging
            isDebug: true,
            // Register the packages we are going to be using. These same packages should be defined in the
            // build profile in `app.profile.js`.
            packages: [
                    {name: "dojo", location: "js/dojo"},
                    {name: "dijit", location: "js/dijit"},
                    {name: "dojox", location: "js/dojox"},
                    {name: "dgrid", location: "js/dgrid"},
                    {name: "xstyle", location: "js/xstyle"},
                    {name: "put-selector", location: "js/put-selector"},
                    {name: "lunchApp", location: "js/lunchApp"}
            ],
            // Use the smaller, faster "lite" CSS selector engine, which works in all browsers IE8+
            selectorEngine: 'lite',
            // Fix the loader to use normal AMD resolution of unregistered module paths (relative to baseUrl)
            // instead of the legacy Dojo resolution method (relative to the parent directory of baseUrl)
            tlmSiblingOfDojo: false
        };
    </script>
    <script src="js/dojo/dojo.js"></script>
    <!-- Load the application. Note that this module ID is hard-coded in build.sh in order to provide
         an optimised build that loads as few as one script for the entire application. If you change the name or
         location of this module, you will need to update build.sh too. -->
    <script>
        var lunchAppGlobal = {};
        require([ 'js/lunchApp/main' ]);
    </script>
</body>
</html>