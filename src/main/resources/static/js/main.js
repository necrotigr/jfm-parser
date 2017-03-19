var map;
var data;
function initMap() {
    var centerEurope = new google.maps.LatLng(51, 20);	 // примерный центр Европы
    var centerWorld = new google.maps.LatLng(15, 20);
    var zoomEurope = 4;
    var zoomWorld = 3;
    var latlng = centerWorld;
    var zoom = zoomWorld;

    map = new google.maps.Map(document.getElementById('map'), {
        center: latlng,
        zoom: zoom
    });
}

/**
 * Выдает маркер определенного цвета в зависимости от текущей даты и даты начала фестиваля
 *
 * По умолчанию: красный - текущий месяц, желтый - следующий месяц, синий - все остальные
 * @param startDate
 */
const url = "http://chart.apis.google.com/chart?chst=d_map_pin_letter&chld=%E2%80%A2%7C";
const color_thisMonth = "FF5555";
const color_nextMonth = "FFFF55";
const color_further = "5555FF";

function getMarkerUrl(color) {
    return url + color;
}

function initIntro() {
    document.getElementById('imgCurMonth').src = getMarkerUrl(color_thisMonth);
    document.getElementById('imgNextMonth').src = getMarkerUrl(color_nextMonth);
    document.getElementById('imgFurtherMonth').src = getMarkerUrl(color_further);
}

function getLabel(item) {
    return "<p><a href='" + item.url + "'>" + item.name + "</a></p>"
        + "<p>" + item.city + ', ' + item.country + "</p>"
        + getDateStr(item);
}

function getDateStr(item) {
    if (item.startDate != item.endDate)
        return  "<p>" + formatDate(item.startDate) + ' - ' + formatDate(item.endDate) + "</p>";
    else
        return  "<p>" + formatDate(item.startDate) + "</p>";
}

function formatDate(dateStr) {
    var t = new Date( dateStr );
    var formatted = t.toLocaleFormat("%d %b %Y");
    return formatted;
}



function getIconByDate(startDate) {

    var curMonth = new Date().getMonth();
    var month = new Date(startDate).getMonth();
    var diff = month - curMonth;
    switch (diff) {
        case 0: return getMarkerUrl(color_thisMonth);
        case 1: return getMarkerUrl(color_nextMonth);
        default: return getMarkerUrl(color_further);
    }
}

fetch('/api/get/actual')
    .then(function(response) {
        return response.json();
    }).then(function(data) {
    var allBounds =  new google.maps.LatLngBounds();

    data.forEach(function(item) {
        var latLng = {lat: item.lat, lng: item.lon};
        var festName = item.name;
        var marker = new google.maps.Marker({
            position: latLng,
            title: festName + '\n' + item.city + ', ' + item.country,
            content: getLabel(item),
            icon: getIconByDate(item.startDate)
        });
        cityBalloon = new google.maps.InfoWindow({
        });
        marker.setMap(map);
        marker.addListener('click', function() {
            cityBalloon.setContent(marker.content);
            cityBalloon.open(map, marker);
        });
        allBounds.extend(marker.getPosition());
    });
    //map.fitBounds(allBounds);
    //map.setCenter(allBounds.getCenter());

}).catch(function(ex) {
    console.log('parsing failed', ex)
});
