define([
    "dojo/_base/declare",
    "dojo/text!./templates/restaurantGraph.html",
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
    "dojox/charting/Chart",
    "dojox/charting/axis2d/Default",
    "dojox/charting/plot2d/Default",
    "dojox/charting/plot2d/Spider",
    "dojox/charting/axis2d/Base"
], function (declare, template, _ContentPaneResizeMixin, _TemplatedMixin, JsonRest, Memory,
        ObjectStore, _WidgetBase, Button, on, lang, DijitRegistry, OnDemandGrid, Pagination, Selection, Chart, Default, Default, Spider, Base) {

    return declare("lunchApp.restaurantRadarGraph", [_WidgetBase, _TemplatedMixin, _ContentPaneResizeMixin], {
        templateString: template,
        testVar: "testing123",
        constructor: function (args) {
            if (args.parent) {
                this._parent = args.parent;
            }
        },
        buildRendering: function () {
            this.inherited(arguments);
            this.containerNode = this.domNode;
            lunchAppGlobal.restaurantRadarGraph = this;

        },
        populateChart: function () {
            this.chart = new Chart(this.restaurantGraphContainer, {title: 'restaurantChartStuff'});

            this.chart.addPlot("default", {
                type: "Spider",
                labelOffset: -10,
                seriesFillAlpha: 0.2,
                markerSize: 3,
                precision: 0,
                spiderType: "polygon"
            });

            var data = [{"Time": 0, "Cost": 0, "Fullness": 0, "Deliciousness": 0, "Discomfort": 0},
                {"Time": 100, "Cost": 100, "Fullness": 100, "Deliciousness": 100, "Discomfort": 100},
                {"Time": 53, "Cost": 26, "Fullness": 25, "Deliciousness": 45, "Discomfort": 55}];
            this.chart.addSeries("min", {data: data[0]}, {fill: "blue"});
            this.chart.addSeries("max", {data: data[1]}, {fill: "blue"});
            this.chart.addSeries("UserReview", {data: data[2]}, {fill: "blue"});
            this.chart.addSeries("AverageReview", {data: data[3]}, {fill: "red"});
            this.chart.render();
            this.chart.removeSeries("min");
            this.chart.removeSeries("max");

            var xhrArg = {
                url: "/lunchApp/services/restaurantgraphinfo",
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
        },
        loadChartData: function (data) {
            var partnerLength = data.length;
            var xSeries = [];
            var partnerSeries = [];
//       for (var i = 0; i < partnerLength; i++) {
//            var xSeriesObject = {};
//            var yObject = {};
//            var xText = data[i].x;
//            var xValue = data[i].y;
//
//            xObject.value = i + 1;
//            xObject.text = xText;
//
//            yObject.y = parseInt(xValue);
//            yObject.legend = xText;
//            yObject.tooltip = xValue;
//
//            partnerSeries.push(yObject);
//            xAxis.push(xObject);
//        }
//        // Add series
//        this.Chart.addSeries("x", { 
//            labels: series,
//            minorTicks: false
//        });
//        //this.partnerChart.addSeries("partner");
//        this.Chart.addSeries("y", { vertical: true, fixLower: "micro", fixUpper: "micro" });
//        this.pieChart.addSeries("Series A", partnerSeries);        
            this.chart.addSeries("min", {data: data[0]}, {fill: "blue"});
            this.chart.addSeries("max", {data: data[1]}, {fill: "blue"});
            this.chart.addSeries("testing", {data: data[2]}, {fill: "blue"});
            this.chart.addSeries("AverageReview", {data: data[3]}, {fill: "red"});
            this.chart.render();
            this.pieChart.resize('50%', '50%');
            this.chart.removeSeries("min");
            this.chart.removeSeries("max");
            //Hide chart standby after everything is loaded
            this.chartStandby.hide();
        },
        startup: function () {
            this.inherited(arguments);
        }

    });
});










  