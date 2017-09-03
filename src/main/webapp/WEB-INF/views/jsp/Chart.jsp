<%@ page session="true" %>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>
<style>
    #chart-card {
        padding: 0 !important;
        margin-top: 8vh;
        border: 1px solid #64b5f6;
    }

    #chart-header {
        color: white;
        text-shadow: 1px 1px 1px rgba(50, 50, 50, 0.1);
        text-align: center;
        font-size: 24px;
        padding: 10px 0;
    }

    #chart-body {
        padding-top: 40px;
        padding-bottom: 10px;
    }

    #nav-mobile > li {
        padding-left: 10px;
        padding-right: 10px
    }

    #chart, #chart-canvas {
        max-height: 780px !important;
    }

</style>

<div class="container" id="main">
    <div class="row">
        <div class="col m10 s12 offset-m1 card" id="chart-card">
            <div class="blue lighten-2 card-title" id="chart-header">
                Chart
            </div>
            <div class="col s12 card-content" id="chart-body">
                <div id="chart">
                    <canvas id="chart-canvas"></canvas>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="center-align col s12">
            <a class="btn blue" href="../">BACK</a>
        </div>
    </div>
</div>

<script>
    let chartData = ${readings};
    let ctx = document.getElementById('chart-canvas').getContext('2d');
    let myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: chartData.map((_, index) => index + 1 + ' days ago'),
            datasets: [{
                label: 'Energy Generated (MW)',
                data: chartData,
                backgroundColor: [
                    'rgba(54, 162, 235, 0.5)',
                    'rgba(54, 162, 235, 0.5)',
                    'rgba(54, 162, 235, 0.5)',
                    'rgba(54, 162, 235, 0.5)',
                    'rgba(54, 162, 235, 0.5)',
                    'rgba(54, 162, 235, 0.5)',
                    'rgba(54, 162, 235, 0.5)',
                    'rgba(54, 162, 235, 0.5)',
                    'rgba(54, 162, 235, 0.5)',
                    'rgba(54, 162, 235, 0.5)'
                ],
                borderColor: [
                    'rgba(54, 162, 235, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(54, 162, 235, 1)'
                ],
                borderWidth: 1,
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            }
        }
    });
</script>

<jsp:include page="footer.jsp"/>