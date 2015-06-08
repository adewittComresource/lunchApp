define([
    "dojo/_base/declare",
    "dijit/_WidgetBase",
    "dijit/_TemplatedMixin",
    "dojo/_base/lang",
    "./main",
    "dijit/form/ValidationTextBox",
    "dojox/form/DropDownSelect",
    "dijit/form/Button",
    "dojo/on",
    "dojo/text!./templates/addLunchLocationContent.html"
], function (declare,_WidgetBase,_TemplatedMixin,lang,lunchApp,ValidationTextBox,DropDownSelect,Button,on,template) {
    return declare("lunchApp.addLunchLocationContent", [_WidgetBase, _TemplatedMixin], {
        templateString: template,
        constructor: function (args) {
            if (args.parent) {
                this._parent = args.parent;
            }
        },
        buildRendering: function () {
            this.inherited(arguments);

            //Location name Textbox
            //Documentation for this widgets properties and events can be found here
            //https://dojotoolkit.org/api/?qs=1.10/dijit/form/ValidationTextBox
            this.txtLocationName = new ValidationTextBox({
                'class': 'textboxWidth',
                required: true
            }, "text").placeAt(this.lunchLocationName);
            
            //Location name Textbox
            this.txtLocationCity = new ValidationTextBox({
                'class': 'textboxWidth',
                value:"Columbus",
                required: true
            }, "text").placeAt(this.lunchLocationCity);
            
            //Location State Textbox
            //Disabled this textbox because odds are you are not leaving Ohio for lunch
            this.txtLocationState = new ValidationTextBox({
                'class': 'textboxWidth',
                disabled:true,
                value:"OH",
                required: true
            }, "text").placeAt(this.lunchLocationState);
            
            //Location Address Textbox
            this.txtLocationAddress = new ValidationTextBox({
                'class': 'textboxWidth',
                required: true
            }, "text").placeAt(this.lunchLocationAddresss);
            
            //Location Zip Textbox
            this.txtLocationZip = new ValidationTextBox({
                'class': 'textboxWidth',
                required: true
            }, "text").placeAt(this.lunchLocationZip);
            
            //Location Website Textbox
            this.txtLocationWebsite = new ValidationTextBox({
                'class': 'textboxWidth',
                required: false
            }, "text").placeAt(this.lunchLocationWebsite);
            
            //Save button for our form
            //Documentation for this widgets properties and events can be found here
            //https://dojotoolkit.org/api/?qs=1.10/dijit/form/Button
            this.btnCreateLocation = Button({
                id: "createLocationButton",
                name: "createLocation",
                label: "Create"
            }).placeAt(this.createLocation);
            //Attach a click event to the button
            on(this.btnCreateLocation, "click", lang.hitch(this, this.createLocation));

            lunchApp.addLocationContent = this;
        },
        createPattern: function () {
            var self = this;
            //Get Variables
            var patternName = this.txtPatternName.get('value');
            var valid = true;

            //Do validation before the POST
            if (valid) {
                //Post to create the Pattern
                var xhrArgs = {
                    url: "/SFG_Tool/services/insertPatternDataFlow/",
                    postData: dojo.toJson({patternName: patternName}),
                    handleAs: "json",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    load: function (data) {
                        //DO Stuff after the POST is finished
                    },
                    error: function (error) {
                        //POST ERROR
                    }
                };
                // Call the asynchronous xhrPost
                var deferred = dojo.xhrPost(xhrArgs);
            }
        },
        clearDialog: function () {
            //Clear Dialog back to Default 
        },
        startup: function () {
            this.inherited(arguments);
        }
    });
});