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
    "dojo/text!./templates/addRestaurantProfileContent.html",
    "dijit/form/FilteringSelect",
    "dojo/store/JsonRest",
    "dojo/data/ObjectStore",
    "dojo/parser",
    "dijit/form/HorizontalSlider",
     "dijit/form/TextBox" 
], function (declare,_WidgetBase,_TemplatedMixin,lang,lunchApp,ValidationTextBox,DropDownSelect,Button,CheckBox,dom,on,template,FilteringSelect,JsonRest,ObjectStore,parser,HorizontalSlider,TextBox) {
    return declare("lunchApp.addRestaurantProfileContent", [_WidgetBase, _TemplatedMixin], {
        templateString: template,
        constructor: function (args) {
            if (args.parent) {
                this._parent = args.parent;
            }
        },
        buildRendering: function () {
            var self = this;
            this.inherited(arguments);
            lunchAppGlobal.lunchRestaurantProfile = this;
            
            var dropdownRestStore = JsonRest({
                target: "/lunchApp/services/restaurants",
                idProperty: 'restaurantId'
            });

            this.restaurantDropdown = FilteringSelect({
                id: "restaurantDropdown",
                store: new ObjectStore({objectStore: dropdownRestStore}),
//                autoComplete: true,
                searchAttr: "name"
            }).placeAt(this.restaurantDropdownContainer);

             
                this.lunchTimeFactorSlider = new HorizontalSlider({
                value: 5,
                minimum: 0,
                maximum: 10,
                intermediateChanges: true,
                style: "width:300px;",
                onChange: function (value) {
                    self.lunchTimeFactor.innerHTML = value;
                }
                }).placeAt(this.timeFactorDropdownContainer);
                
                
                this.lunchCostFactorSlider = new HorizontalSlider({
                value: 5,
                minimum: 0,
                maximum: 10,
                intermediateChanges: true,
                style: "width:300px;",
                onChange: function (value) {
                    self.lunchCostFactor.innerHTML = value;
                }
                }).placeAt(this.costFactorDropdownContainer);
                
                
            this.lunchFullnessFactorSlider = new HorizontalSlider({
                value: 5,
                minimum: 0,
                maximum: 10,
                intermediateChanges: true,
                style: "width:300px;",
                onChange: function (value) {
                    self.lunchFullnessFactor.innerHTML = value;
                }
            }).placeAt(this.fullnessDropdownContainer);
            
            this.lunchDeliciousnessFactorSlider = new HorizontalSlider({
                value: 5,
                minimum: 0,
                maximum: 10,
                intermediateChanges: true,
                style: "width:300px;",
                onChange: function (value) {
                    self.lunchDeliciousnessFactor.innerHTML = value;
                }
            }).placeAt(this.deliciousnessDropdownContainer);
            
            this.lunchDiscomfortFactorSlider = new HorizontalSlider({
                value: 5,
                minimum: 0,
                maximum: 10,
                intermediateChanges: true,
                style: "width:300px;",
                onChange: function (value) {
                    self.lunchDiscomfortFactor.innerHTML = value;
                }
            }).placeAt(this.discomfortDropdownContainer);

                this.btnCreateLocation = Button({
                id: "createProfileButton",
                name: "createProfile",
                label: "Create"
            }).placeAt(this.createProfile);
            //Attach a click event to the button
            on(this.btnCreateLocation, "click", lang.hitch(this, this.insertProfile));
        },

            insertProfile: function () {
            var self = this;

            //Get the input values into variables
            var name = this.txtLocationName.get('value');
            
            //Post to create the restaurant
            var xhrArgs = {
                url: "/lunchApp/services/insertRestaurants/",
                postData: dojo.toJson({
                    name: name,
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
        
          populateDialog: function(data){
            
            this.restaurantDropdown.set('value',data.name);
          
        },
            

      
        clearDialog: function () {
            //Clear Dialog back to Default 
        },
        startup: function () {
            this.inherited(arguments);
        }

    });
});



           
            
            
            
            
//            this.txtTimeFactor = new ValidationTextBox({
//                'class': 'textboxWidth',
//                regExp: ".+",
//                required: true
//            }, "text").placeAt(this.lunchTimeFactor);
//
//
//            this.txtCostFactor = new ValidationTextBox({
//                'class': 'textboxWidth',
//                regExp: ".+",
//                required: true
//            }, "text").placeAt(this.lunchCostFactor);
//
//           
//            this.txtFullnessFactor = new ValidationTextBox({
//                'class': 'textboxWidth',
//                regExp: ".+",
//                required: true
//            }, "text").placeAt(this.lunchFullnessFactor);
//
//           
//            this.txtDeliciousnessFactor = new ValidationTextBox({
//                 'class': 'textboxWidth',
//                regExp: ".+",
//                required: true
//            }, "text").placeAt(this.lunchDeliciousnessFactor);
//
//            
//            this.txtDiscomfortFactor= new ValidationTextBox({
//                  'class': 'textboxWidth',
//                regExp: ".+",
//                required: true
//            }, "text").placeAt(this.lunchDiscomfortFactor);
//


            //Save button for our form
//            this.btnCreateProfile = Button({
//                id: "createProfileButton",
//                name: "createProfile",
//                label: "Create"
//            }).placeAt(this.createProfile);
//            //Attach a click event to the button
//            on(this.btnCreateProfile, "click", lang.hitch(this, this.insertUpdateProfile));
//
//            lunchApp.addProfileContent = this;
//        },
//        inserUpdateProfile: function (){
//            if (this.dialogState == "insert"){
//               
//                this.insertProfile();
//            }
//            else{
//                console.log("update")

