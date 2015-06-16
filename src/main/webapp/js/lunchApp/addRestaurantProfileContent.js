define([
    "dojo/_base/declare",
    "dijit/_WidgetBase",
    "dijit/_TemplatedMixin",
    "dojo/_base/lang",
    "./main",
    "dijit/form/ValidationTextBox",
    "dojox/form/DropDownSelect",
    "dijit/form/Button",
    "dijit/form/CheckBox",
    "dojo/dom",
    "dojo/on",
    "dojo/text!./templates/addRestaurantProfileContent.html"

], function (declare,_WidgetBase,_TemplatedMixin,lang,lunchApp,ValidationTextBox,DropDownSelect,Button,CheckBox,dom,on,template) {
    return declare("lunchApp.addRestaurantProfileContent", [_WidgetBase, _TemplatedMixin], {
        templateString: template,
        constructor: function (args) {
            if (args.parent) {
                this._parent = args.parent;
            }
        },
        buildRendering: function () {
            this.inherited(arguments);
            lunchAppGlobal.lunchRestaurant = this;


            this.txtRestaurantName = new ValidationTextBox({
                'class': 'textboxWidth',
                regExp: ".+",
                required: true
            }, "text").placeAt(this.lunchRestaurantName);


            this.txtTimeFactor = new ValidationTextBox({
                'class': 'textboxWidth',
                regExp: ".+",
                required: true
            }, "text").placeAt(this.lunchTimeFactor);


            this.txtCostFactor = new ValidationTextBox({
                'class': 'textboxWidth',
                regExp: ".+",
                required: true
            }, "text").placeAt(this.lunchCostFactor);

           
            this.txtFullnessFactor = new ValidationTextBox({
                'class': 'textboxWidth',
                regExp: ".+",
                required: true
            }, "text").placeAt(this.lunchFullnessFactor);

           
            this.txtDeliciousnessFactor = new ValidationTextBox({
                 'class': 'textboxWidth',
                regExp: ".+",
                required: true
            }, "text").placeAt(this.lunchDeliciousnessFactor);

            
            this.txtDiscomfortFactor= new ValidationTextBox({
                  'class': 'textboxWidth',
                regExp: ".+",
                required: true
            }, "text").placeAt(this.lunchDiscomfortFactor);



            //Save button for our form
            this.btnCreateProfile = Button({
                id: "createProfileButton",
                name: "createProfile",
                label: "Create"
            }).placeAt(this.createProfile);
            //Attach a click event to the button
            on(this.btnCreateProfile, "click", lang.hitch(this, this.insertUpdateProfile));

            lunchApp.addProfileContent = this;
        },
        inserUpdateProfile: function (){
            if (this.dialogState == "insert"){
               
                this.insertProfile();
            }
            else{
                console.log("update")
            }
        },
        
         insertProfile: function () {
            var self = this;

            //Get the input values into variables
            var name = this.txtRestaurantName.get('value');
            
            //Store for View
            var dropdownRestStore = JsonRest({
                target: "/lunchApp/services/restaurants",
                idProperty: 'restaurantId'
            });

            //Protocol Dropdown select
            this.restaurantDropdown = FilteringSelect({
                id: "restaurantDropdown",
                store: new ObjectStore({objectStore: dropdownRestStore}),
                autoComplete: true,
                searchAttr: "name",
                onChange: function () {
                }
            }).placeAt(this.restaurantDropdownContainer);
             
//            var timeF = this.txtTimeFactor.get('value');
//            var costF = this.txtCostFactor.get('value');
//            var fullF = this.txtFullnessFactor.get('value');
//            var deliciousnessF = this.txtDeliciousnessFactor.get('value');
//            var discomfortF = this.txtDiscomfortFactor.get('value');

            //Post to create the restaurant
            var xhrArgs = {
                url: "/lunchApp/services/insertRestaurants/",
                postData: dojo.toJson({
                    name: name  
                }),
                     
                handleAs: "json",
                headers: {
                    "Content-Type": "application/json"
                },
                load: function (data) {
                    //DO Stuff after the POST is finished
                    lunchAppGlobal.main.addLunchProfileDialog.hide();
                },
                error: function (error) {
                    //POST ERROR
                }
            };
            // Call the asynchronous xhrPost
            var deferred = dojo.xhrPost(xhrArgs);
        },
        
       
        clearDialog: function () {
            //Clear Dialog back to Default 
        },
        startup: function () {
            this.inherited(arguments);
        }
    });
});
