dojo.require("dojox.charting.Chart2D");
dojo.require("dojox.charting.axis2d.Default");
dojo.require("dojox.charting.plot2d.Default");
dojo.require("dojox.charting.plot2d.Spider");
dojo.require("dojox.charting.axis2d.Base");
dojo.ready(function (Chart, Default, Default, Spider, Base) {
    var chart = new dojox.charting.Chart("test");
    chart.addPlot("default", {
        type: "Spider",
        labelOffset: -10,
        seriesFillAlpha: 0.2,
        markerSize: 3,
        precision: 0,
        spiderType: "polygon"
    });

    var xhrArg = {
        url: "/lunchApp/services/ReadVRestaurantProfile",
        handleAs: "json",
        headers: {
            "Content-Type": "application/json"
        },
        load: function (data) {
            //testing using console
            console.log('umm not sure what is going on here');


        },
        error: function (error) {
            //POST ERROR
            console.log('error');
        }
    };

    var deferred = dojo.xhrGet(xhrArg);

//                var data = [{"Time": 0, "Cost": 0, "Fullness": 0, "Deliciousness": 0, "Discomfort": 0},
//                {"Time": 100, "Cost": 100, "Fullness": 100, "Deliciousness": 100, "Discomfort": 100},
//                {"Time": 53, "Cost": 26, "Fullness": 25, "Deliciousness": 45, "Discomfort": 55}];
    chart.addSeries("min", {data: data[0]}, {fill: "blue"});
    chart.addSeries("max", {data: data[1]}, {fill: "blue"});
    chart.addSeries("testing", {data: data[2]}, {fill: "blue"});
    chart.render();
    chart.removeSeries("min");
    chart.removeSeries("max");
});