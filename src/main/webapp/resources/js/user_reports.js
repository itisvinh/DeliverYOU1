const ENDPOINT = document.querySelector('#endpoint').dataset.endpoint

function displayPostPerCategory() {
    fetchPPCData()
        .then(list => {
            if (list) {
                google.charts.load('current', { packages: ['corechart'] });
                google.charts.setOnLoadCallback(drawChart);

                function drawChart() {
                    const pre_figure = [['Category', 'Mhl']]
                    const chart_figures = [...pre_figure, ...list]
                    const data = google.visualization.arrayToDataTable(chart_figures);

                    const options = {
                        title: 'According to categories of all created posts',
                        // is3D: true,
                        pieHole: 0.4
                    };

                    const chart = document.querySelector('#posts-per-cat-reports .chart')
                    // Draw
                    const chartx = new google.visualization.PieChart(chart);
                    chartx.draw(data, options);
                }
            }
        })
        .catch(error => {
            console.error(error)
            BSToast.show(document, 'Error: cannot fetch [Posts Per Category] chart data', BSToast.BACKGROUND_RED)
        })
}

displayPostPerCategory()

async function fetchPPCData() {
    return Fetch.build().method(Fetch.METHOD_POST).fetch(ENDPOINT + 'user/api/report-posts-per-category')
        .then(response => {
            switch (response.status) {
                case 200:
                    return response.json()
                case 204:
                    BSToast.show(document, 'Seems like you have not created any post yet', BSToast.BACKGROUND_YELLOW)
                    break
                default:
                    BSToast.show(document, '[Posts Per Category] chart: server error occurred', BSToast.BACKGROUND_RED)
            }
            return undefined
        })
        .then(data => {
            return data ? buildPCCData(data) : undefined
        })
}

function buildPCCData(data) {
    const fields = Object.keys(data)
    const array = []
    for (let i = 0; i < fields.length; i++)
        array.push([fields[i], data[fields[i]]])
    return array
}

// --------------------------------------
function displayMonthlySPending() {
    google.charts.load('current', { packages: ['corechart'] });
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {
        const data = google.visualization.arrayToDataTable([
            ["Month", "Value", { role: "style" }],
            ["This month", 8.94, "#b87333"],
            ["October", 10.49, "silver"],
            ["Agust", 19.30, "gold"],
            ["July", 21.45, "color: #e5e4e2"]
        ]);

        const view = new google.visualization.DataView(data);
        view.setColumns([0, 1,
            {
                calc: "stringify",
                sourceColumn: 1,
                type: "string",
                role: "annotation"
            },
            2]);

        const options = {
            title: "Values in US Dollars",
            width: 600,
            height: 400,
            bar: { groupWidth: "95%" },
            legend: { position: "none" },
        };
        const chartx = document.querySelector('#monthly-spending-reports .chart')
        const chart = new google.visualization.ColumnChart(chartx);
        chart.draw(view, options);
    }
}

displayMonthlySPending()
