<%-- 
    Document   : login
    Created on : Jun 12, 2015, 10:55:38 AM
    Author     : Rob
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN PAGE</title>
    </head>
    <body>
        <h1>Enter, and speak with the oracle of Lunch</h1>
        <div>
    <div>USER NAME:</div>
    <div id="userNameLogin" data-dojo-attach-point="userNameLogin"></div>
    <div>PASSWORD:</div>
    <div id="passwordLogin" data-dojo-attach-point="passwordLogin"></div>
    <div id="loginButton" data-dogo-attach-point="loginButton"></div>
</div>
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
    "dojo/text!./templates/loginpage.html"

], function (declare, _WidgetBase, _TemplatedMixin, lang, lunchApp, ValidationTextBox, DropDownSelect, Button, CheckBox, on, template) {
    return declare("lunchApp.loginpage", [_WidgetBase, _TemplatedMixin], {
        templateString: template,
        constructor: function (args) {
            if (args.parent) {
                this._parent = args.parent;
            }
        },
        buildRendering: function () {
            this.inherited(arguments);
            lunchAppGlobal.loginpage = this;

            //Location name Textbox
            //Documentation for this widgets properties and events can be found here
            //https://dojotoolkit.org/api/?qs=1.10/dijit/form/ValidationTextBox
            this.txtUserName = new ValidationTextBox({
                'class': 'textboxWidth',
                regExp: ".+",
                required: true
            }, "text").placeAt(this.userNameLogin);

            //Location name Textbox
            this.txtPassword = new ValidationTextBox({
                'class': 'textboxWidth',
                value: "Columbus",
                regExp: ".+",
                required: true
            }, "text").placeAt(this.passwordLogin);


            //Save button for our form
            //Documentation for this widgets properties and events can be found here
            //https://dojotoolkit.org/api/?qs=1.10/dijit/form/Button
            this.btnCreateLogin = Button({
                id: "submitLoginButton",
                name: "submitLoginButton",
                label: "login"
            }).placeAt(this.loginButton);
            //Attach a click event to the button
            on(this.btnCreateLogin, "click", lang.hitch(this, this.loginUser));

        },
        loginUser: function () {
            //login user stuff
            alert('i logged in!');
        },
        clearDialog: function () {
            //Clear Dialog back to Default 
        },
        startup: function () {
            this.inherited(arguments);
        }
    });
});

    </body>
</html>
