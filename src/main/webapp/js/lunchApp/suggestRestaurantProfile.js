define([
    "dojo/_base/declare",
    "dojo/text!./templates/suggestRestaurantProfile.html",
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
], function (declare,template,_ContentPaneResizeMixin,_TemplatedMixin,JsonRest,Memory,
ObjectStore,_WidgetBase,Button,on,lang,DijitRegistry,OnDemandGrid,Pagination,Selection) {

//need to add restaurant info, map, graph


    return declare("lunchApp.suggestRestaurantProfile", [_WidgetBase, _TemplatedMixin, _ContentPaneResizeMixin], {

        templateString: template,
        constructor: function (args) {
            if (args.parent) {
                this._parent = args.parent;
            }
        },
        buildRendering: function () {
            this.inherited(arguments);
            this.containerNode = this.domNode;
            lunchAppGlobal.suggestRestaurantProfile = this;

            
        },
        startup: function () {
            this.inherited(arguments);
        }
    });
});



