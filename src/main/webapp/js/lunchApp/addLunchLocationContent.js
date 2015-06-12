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
    "dojo/on",
    "dojo/text!./templates/addLunchLocationContent.html"

], function (declare,_WidgetBase,_TemplatedMixin,lang,lunchApp,ValidationTextBox,DropDownSelect,Button,CheckBox,on,template) {
    return declare("lunchApp.addLunchLocationContent", [_WidgetBase, _TemplatedMixin], {
        templateString: template,
        constructor: function (args) {
            if (args.parent) {
                this._parent = args.parent;
            }
        },
        buildRendering: function () {
            this.inherited(arguments);
            lunchAppGlobal.lunchLocation = this;

            //Location name Textbox
            //Documentation for this widgets properties and events can be found here
            //https://dojotoolkit.org/api/?qs=1.10/dijit/form/ValidationTextBox
            this.txtLocationName = new ValidationTextBox({
                'class': 'textboxWidth',
                regExp: ".+",
                required: true
            }, "text").placeAt(this.lunchLocationName);

            //Location name Textbox
            this.txtLocationCity = new ValidationTextBox({
                'class': 'textboxWidth',
                value: "Columbus",
                regExp: ".+",
                required: true
            }, "text").placeAt(this.lunchLocationCity);

            //Location State Textbox
            //Disabled this textbox because odds are you are not leaving Ohio for lunch
            this.txtLocationState = new ValidationTextBox({
                'class': 'textboxWidth',
//                disabled:true,
                maxLength: "2",
                regExp: "[a-zA-Z]{2}",
                value: "OH",
                required: true
            }, "text").placeAt(this.lunchLocationState);

            //Location Address Textbox
            this.txtLocationAddress = new ValidationTextBox({
                'class': 'textboxWidth',
                regExp: ".+",
                required: true
            }, "text").placeAt(this.lunchLocationAddresss);

            //Location Zip Textbox
            this.txtLocationZip = new ValidationTextBox({
                'class': 'textboxWidth',
                regExp: "[\\d]{5}",
                required: true
            }, "text").placeAt(this.lunchLocationZip);

            //Location Website Textbox
            this.txtLocationWebsite = new ValidationTextBox({
                'class': 'textboxWidth',
                regExp: "(http:\\/\\/|https:\\/\\/)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?",
                required: false

            }, "text").placeAt(this.lunchLocationWebsite);


            var mondayCheckBox = new CheckBox({
                id:"mondayCheckbox",
                name: "dayOfWeekCheckbox",
                value: 1,
                checked: false,
                onChange: function(b){
                    console.log('onChange called with parameter = ' + b + ', and widget value = ' + this.get('value') ); 
                }
            }).placeAt(this.mondayCheckbox);
            var tuesdayCheckBox = new CheckBox({
                id:"tuesdayCheckbox",
                name: "dayOfWeekCheckbox",
                value: 1,
                checked: false,
                onChange: function(b){
                    console.log('onChange called with parameter = ' + b + ', and widget value = ' + this.get('value') ); 
                }
            }).placeAt(this.tuesdayCheckbox);
            var wednesdayCheckBox = new CheckBox({
                id:"wednesdayCheckbox",
                name: "dayOfWeekCheckbox",
                value: 1,
                checked: false,
                onChange: function(b){
                    console.log('onChange called with parameter = ' + b + ', and widget value = ' + this.get('value') ); 
                }
            }).placeAt(this.wednesdayCheckbox);
            var thursdayCheckBox = new CheckBox({
                id:"thursdayCheckbox",
                name: "dayOfWeekCheckbox",
                value: 1,
                checked: false,
                onChange: function(b){
                    console.log('onChange called with parameter = ' + b + ', and widget value = ' + this.get('value') ); 
                }
            }).placeAt(this.thursdayCheckbox);
            var fridayCheckBox = new CheckBox({
                id:"fridayCheckbox",
                name: "dayOfWeekCheckbox",
                value: 1,
                checked: false,
                onChange: function(b){
                    console.log('onChange called with parameter = ' + b + ', and widget value = ' + this.get('value') ); 
                }
            }).placeAt(this.fridayCheckbox);
            var saturdayCheckBox = new CheckBox({
                id:"saturdayCheckbox",
                name: "dayOfWeekCheckbox",
                value: 1,
                checked: false,
                onChange: function(b){
                    console.log('onChange called with parameter = ' + b + ', and widget value = ' + this.get('value') ); 
                }
            }).placeAt(this.saturdayCheckbox);
            var sundayCheckBox = new CheckBox({
                id:"sundayCheckbox",
                name: "dayOfWeekCheckbox",
                value: 1,
                checked: false,
                onChange: function(b){
                    console.log('onChange called with parameter = ' + b + ', and widget value = ' + this.get('value') ); 
                }
            }).placeAt(this.sundayCheckbox);



            //Save button for our form
            //Documentation for this widgets properties and events can be found here
            //https://dojotoolkit.org/api/?qs=1.10/dijit/form/Button
            this.btnCreateLocation = Button({
                id: "createLocationButton",
                name: "createLocation",
                label: "Create"
            }).placeAt(this.createLocation);
            //Attach a click event to the button
            on(this.btnCreateLocation, "click", lang.hitch(this, this.insertUpdateRestaurant));
            

            lunchApp.addLocationContent = this;
        },
        inserUpdateRestaurant: function (){
            if (this.dialogState == "insert"){
                this.insertRestaurant();
            }
            else{
                console.log("update")
            }
        },
        
        populateDialog: function(data){
            
           this.txtLocationName.set('value',data.name);
           this.txtLocationCity.set('value',data.city);
           this.txtLocationState.set('value',data.state);
           this.txtLocationAddress.set('value',data.address);
           this.txtLocationZip.set('value',data.zip);
           this.txtLocationWebsite.set('value',data.website);
           var test= dijit.byId(mondayCheckbox);
           this.settingCheckbox(test,data.monday);
          
           
        },
         settingCheckbox: function(test,checkValue){
               if(checkValue == 1){
                   test.checked=true;
                   }
                   else{
                       test.checked=false;
                   }
           },
        insertRestaurant: function () {
            var self = this;

            //Get the input values into variables
            var name = this.txtLocationName.get('value');
            var city = this.txtLocationCity.get('value');
            var state = this.txtLocationState.get('value');
            var address = this.txtLocationAddress.get('value');
            var zip = this.txtLocationZip.get('value');
            var website = this.txtLocationWebsite.get('value');
            
            //Get Days of Week Values
            var monday = this.getCheckboxValue(mondayCheckbox);
            var tuesday = this.getCheckboxValue(tuesdayCheckbox);
            var wednesday = this.getCheckboxValue(wednesdayCheckbox);
            var thursday = this.getCheckboxValue(thursdayCheckbox);
            var friday = this.getCheckboxValue(fridayCheckbox);
            var saturday = this.getCheckboxValue(saturdayCheckbox);
            var sunday = this.getCheckboxValue(sundayCheckbox);

            //Post to create the restaurant
            var xhrArgs = {
                url: "/lunchApp/services/insertRestaurants/",
                postData: dojo.toJson({
                    name: name,
                    city: city,
                    state: state,
                    address: address,
                    zip: zip,
                    website: website,
                    monday : monday,
                    tuesday : tuesday,
                    wednesday : wednesday,
                    thursday : thursday,
                    friday : friday,
                    saturday : saturday,
                    sunday : sunday
                    
                    
                    
                    
                }),
                handleAs: "json",
                headers: {
                    "Content-Type": "application/json"
                },
                load: function (data) {
                    //DO Stuff after the POST is finished
                    lunchAppGlobal.main.addLunchLocationDialog.hide();
                },
                error: function (error) {
                    //POST ERROR
                }
            };
            // Call the asynchronous xhrPost
            var deferred = dojo.xhrPost(xhrArgs);
        },
        
        getCheckboxValue:function(checkboxId){
            var checkboxValue;
            var isChecked = dijit.byId(checkboxId).checked;  
            if(isChecked){
                checkboxValue = 1;
            }else{
                checkboxValue = 0;
            }
          return checkboxValue;
        },
        clearDialog: function () {
            //Clear Dialog back to Default 
        },
        startup: function () {
            this.inherited(arguments);
        }
    });
});
