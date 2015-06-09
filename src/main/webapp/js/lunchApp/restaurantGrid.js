define([
    "dojo/_base/declare",
    "dojo/text!./templates/restaurantGrid.html",
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
    'dgrid/Selection',
    "./main"
], function (declare,template,_ContentPaneResizeMixin,_TemplatedMixin,JsonRest,Memory,
ObjectStore,_WidgetBase,Button,on,lang,DijitRegistry,OnDemandGrid,Pagination,Selection,lunchApp) {

    return declare("lunchApp.restaurantGrid", [_WidgetBase, _TemplatedMixin, _ContentPaneResizeMixin], {
        templateString: template,
        constructor: function (args) {
            if (args.parent) {
                this._parent = args.parent;
            }
            // Empty datastore for reset purposes
            this._dataStore = Memory({data: []});
        },
        buildRendering: function () {
            this.inherited(arguments);
            this.containerNode = this.domNode;
            lunchAppGlobal.restaurantGrid = this;

            //Empty Store
            var emptyStore = new ObjectStore({objectStore: this._dataStore});
            var restStore = JsonRest({
                target: "/lunchApp/services/restaurants",
                idProperty: 'restaurantId',
                sortParam: "sortBy"
            });

            this.grid = new OnDemandGrid({
                id: 'restaurantGrid',
                collection: restStore,
                allowTextSelection:true,
                selectionMode: 'single',
                minRowsPerPage: 2000,
                maxRowsPerPage: 2000,
                columns: {
                    name: {
                        label: "Name",
                    },
                    address: {
                        label: "Address"
                    },
                    zip: {
                        label: "City,State Zip",
                        renderCell: function (item, rowIndex, cell) {
                            //Create the dom node to be used to contain the data
                            var cityStatZipContainer = document.createElement('div');
                            //Concat the 3 fields into a variable
                            var cityStateZip = item.city + ", " + item.state +" "+ item.zip;
                            //Set the innerHTML to the variable
                            cityStatZipContainer.innerHTML = cityStateZip;
                            //Return the domNode
                            return cityStatZipContainer; 
                        }
                    },
                    website: {
                        label: 'Website',
                        renderCell: function (item, rowIndex, cell) {
                            //Create the dom node to be used to contain the data
                            var websiteContainer = document.createElement('a');
                            //Set the innerHTML to the variable
                            websiteContainer.innerHTML = item.website;
                            websiteContainer.href = item.website;
                            websiteContainer.target="_blank";
                            //Return the domNode
                            return websiteContainer; 
                        }
                    }
                }
            },this.restaurantGridContainer);

//            grid.on('dgrid-select', function (event) {
//                //set row index to current row
//                sfgTool.flowOverviewGrid.selectedIndex = event.rowIndex;
//                //get selected row
//                var selectedRow = event.rows[0].data;
//                //Check if already selected
//                if (selectedRow !== sfgTool.flowOverviewGrid.currentSelectedRow) {
//                    //enable the delete button
//                    sfgTool.flowOverviewGridHeader.deleteButton.set('disabled', false);
//                    sfgTool.flowOverviewGridHeader.copyButton.set('disabled', false);
//                    //save selected row in module
//                    sfgTool.flowOverviewGrid.currentSelectedRow = selectedRow;
//                }
//            });
//
//            grid.on('dgrid-deselect', function (event) {
//                sfgTool.flowOverviewGridHeader.deleteButton.set('disabled', true);
//                sfgTool.flowOverviewGridHeader.copyButton.set('disabled', true);
//                sfgTool.flowOverviewGrid.currentSelectedRow = "";
//            });

            this.grid.startup();
            //Populate Grid so it will load properly after login
            this.populateGrid();
            
            //Save button for our form
            //Documentation for this widgets properties and events can be found here
            //https://dojotoolkit.org/api/?qs=1.10/dijit/form/Button
            this.btnCreateNewRestaurant = Button({
                id: "createNewRestaurantButton",
                name: "createRestaurant",
                label: "Add New"
            }).placeAt(this.restaurantGridFooter);
            //Attach a click event to the button
            on(this.btnCreateNewRestaurant, "click", lang.hitch(this, this.showCreateRestaurant));
        },
        
        showCreateRestaurant:function(){
            lunchAppGlobal.main.addLunchLocationDialog.show();
        },
        
        populateGrid: function () {
            var restStore = JsonRest({
                target: "/lunchApp/services/restaurants",
                idProperty: 'restaurantId',
                sortParam: "sortBy"
            });
            this.grid.set("store",restStore);
        },
        
        startup: function () {
            this.inherited(arguments);
        }
    });
});
