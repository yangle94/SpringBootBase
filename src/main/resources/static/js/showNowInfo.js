$(function() {
    // 基于准备好的dom，初始化echarts实例
    var nowZhu = echarts.init(document.getElementById('nowZhu'));
    var nowBing = echarts.init(document.getElementById('nowBing'));

    getData();
    setInterval(function () {
        getData();
    }, 10000);

    function getData() {
        nowZhu.showLoading();
        nowBing.showLoading();

        //ajax异步加载数据
        $.get('/seleniumInfo/findNew').done(function (data) {

            var ieNum = 0, chromeNum = 0, firefoxNum = 0;
            var ieNumS = 0, chromeNumS = 0, firefoxNumS = 0;

            var info = data['info'];
            var jsonObj = eval('(' + info + ')')['proxyList'];
            jsonObj.forEach(function (element) {
                element['browserList'].forEach(function (element2) {
                    if (element2['browserName'] === 'chrome') {
                        chromeNum += 1;
                        if(element2['status'] !== "0") {
                            chromeNumS += 1;
                        }
                    } else if (element2['browserName'] === 'firefox') {
                        firefoxNum += 1;
                        if(element2['status'] !== "0") {
                            firefoxNumS += 1;
                        }
                    } else {
                        ieNum += 1;
                        if (element2['status'] !== "0") {
                            ieNumS += 1;
                        }
                    }
                });
            });
            nowBing.setOption(bingOption(ieNumS, chromeNumS, firefoxNumS));
            nowBing.hideLoading();
            nowZhu.setOption(zhuOption(ieNum, chromeNum,firefoxNum,ieNumS, chromeNumS,firefoxNumS));
            nowZhu.hideLoading();
        });
    }

    //饼状
    function bingOption(ieNum, chromeNum, firefoxNum) {
        return {
            series: [
                {
                    name: '占用比例比例',
                    type: 'pie',
                    radius: '55%',
                    data: [
                        {value: ieNum, name: 'IE'},
                        {value: chromeNum, name: 'firefox'},
                        {value: firefoxNum, name: 'chrome'}
                    ]
                }
            ]
        };
    }

    //柱状
    function zhuOption(ieNum, chromeNum, firefoxNum,ieNumS, chromeNumS, firefoxNumS) {
        return {
            tooltip : {
                trigger: 'axis',
                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            legend: {
                data:['使用量','总量']
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis : [
                {
                    type : 'category',
                    data : ['ie','chrome','firefox']
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                {
                    name:'使用量',
                    type:'bar',
                    data:[ieNumS, chromeNumS, firefoxNumS]
                },
                {
                    name:'总量',
                    type:'bar',
                    stack: '广告',
                    data:[ieNum, chromeNum, firefoxNum]
                }
            ]
        };
    }
});