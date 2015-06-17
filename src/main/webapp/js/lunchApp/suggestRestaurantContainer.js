define([
    "dojo/_base/declare",
    "dojo/text!./templates/suggestRestaurantContainer.html",
    "dijit/layout/_ContentPaneResizeMixin",
    "dijit/_TemplatedMixin",
    "dojo/store/JsonRest",
    "dojo/store/Memory",
    "dojo/data/ObjectStore",
    "dijit/_WidgetBase",
    "dijit/form/Button",
    "dojo/on",
    "dojo/_base/lang",
    "dgrid/extensions/DijitRegistry",
    "dgrid/OnDemandGrid",
    'dgrid/extensions/Pagination',
    'dgrid/Selection'
], function (declare, template, _ContentPaneResizeMixin, _TemplatedMixin, JsonRest, Memory,
        ObjectStore, _WidgetBase, Button, on, lang, DijitRegistry, OnDemandGrid, Pagination, Selection) {

    return declare("lunchApp.suggestRestaurantContainer", [_WidgetBase, _TemplatedMixin, _ContentPaneResizeMixin], {
        templateString: template,
        constructor: function (args) {
            if (args.parent) {
                this._parent = args.parent;
            }
        },
        buildRendering: function () {
            this.inherited(arguments);
            this.containerNode = this.domNode;
            //This gives us access to this widget from the console
            //having access to this variable makes it much easier to debug your widgets
            //This variable can also be easily used to call this widget from other widgets methods
            lunchAppGlobal.suggestRestaurantProfile = this;
             var xhrArgs = {
                url: "/lunchApp/services/restaurantgraphinfo",
                handleAs: "json",
                headers: {
                    "Content-Type": "application/json"
                },
                load: function (data) {
                    //DO Stuff after the POST is finished
                   for (var i=0; i>data.length+1; i++){
                       
                       console.log(data[i]);
                       
                       
                   }
                },
                error: function (error) {
                    //POST ERROR
                }
            };
            // Call the asynchronous xhrPost
            var deferred = dojo.xhrGet(xhrArgs);

        },
        startup: function () {
            this.inherited(arguments);
        }
    });
});



