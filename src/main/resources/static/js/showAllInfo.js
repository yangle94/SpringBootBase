$(function() {
    // 基于准备好的dom，初始化echarts实例
    var allZhe = echarts.init(document.getElementById('allZhe'));
    var allIEZhe = echarts.init(document.getElementById('allIEZhe'));
    var allChromeZhe = echarts.init(document.getElementById('allChromeZhe'));
    var allFirefoxZhe = echarts.init(document.getElementById('allFirefoxZhe'));

    getData();

    function getData() {
        allZhe.showLoading();
        allIEZhe.showLoading();
        allChromeZhe.showLoading();
        allFirefoxZhe.showLoading();

        //ajax异步加载数据
        $.get('/seleniumInfo/findAll').done(function (data) {

            var map = {};
            data.forEach(function(element){
                var dayDay = new Date(element['createDate']).toString();

                var info = element['info'];
                var jsonObj = eval('(' + info + ')')['proxyList'];

                var date = {
                    ie : 0,
                    chrome : 0,
                    firefox : 0,
                    apend : function(date1) {
                        this.ie += date1.ie;
                        this.chrome += date1.chrome;
                        this.firefox += date1.firefox;
                    }
                };
                jsonObj.forEach(function(element1){

                    element1['browserList'].forEach(function (element2) {
                        if (element2['browserName'] === 'chrome') {
                            if(element2['status'] !== "0") {
                                date.chrome += 1;
                            }
                        } else if (element2['browserName'] === 'firefox') {
                            if(element2['status'] !== "0") {
                                date.firefox += 1;
                            }
                        } else {
                            if (element2['status'] !== "0") {
                                date.ie += 1;
                            }
                        }
                    });
                });

                if(map[dayDay]) {
                    map[dayDay].apend(date);
                } else {
                    map[dayDay] = date;
                }

            });

            var ieList = [], chromeList = [], firefoxList = [], allList = [];

            for(var key in map) {
                ieList.push(randomData(key,map[key]['ie']));
                chromeList.push(randomData(key,map[key]['chrome']));
                firefoxList.push(randomData(key,map[key]['firefox']));
                allList.push(randomData(key,map[key]['ie'] + map[key]['chrome'] + map[key]['firefox']))
            }

            allZhe.setOption(zheOption("总体趋势", allList));
            allIEZhe.setOption(zheOption("IE趋势", ieList));
            allChromeZhe.setOption(zheOption("chrome趋势", chromeList));
            allFirefoxZhe.setOption(zheOption("firefox趋势", firefoxList));

            allZhe.hideLoading();
            allIEZhe.hideLoading();
            allChromeZhe.hideLoading();
            allFirefoxZhe.hideLoading();
        });
    }

    //格式化数据
    function randomData(oneDay,value) {
        now = new Date(oneDay);
        return {
            name: now.toString(),
            value: [
                [now.getFullYear(), now.getMonth() + 1, now.getDate()].join('/'),
                value
            ]
        }
    }

    //折线
    function zheOption(title,data) {
        return {
            title: {
                text: title
            },
            tooltip: {
                trigger: 'axis',
                formatter: function (params) {
                    params = params[0];
                    var date = new Date(params.name);
                    return (date.getMonth() + 1) + '/' + date.getFullYear() + ' : ' + params.value[1];
                },
                axisPointer: {
                    animation: false
                }
            },
            xAxis: {
                type: 'time',
                splitLine: {
                    show: false
                }
            },
            yAxis: {
                type: 'value',
                boundaryGap: [0, '100%'],
                splitLine: {
                    show: false
                }
            },
            series: [{
                name: '模拟数据',
                type: 'line',
                showSymbol: false,
                hoverAnimation: false,
                data: data
            }]
        };
    }
});