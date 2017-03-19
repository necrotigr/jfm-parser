var map;
var data;
function initMap() {
    var latlng = new google.maps.LatLng(51, 20);	 // примерный центр Европы

    map = new google.maps.Map(document.getElementById('map'), {
        center: latlng,
        zoom: 4
    });
}
function getLabel(item) {
    return "<p><a href='" + item.url + "'>" + item.name + "</a></p>"
        + "<p>" + item.city + ', ' + item.country + "</p>"
        + "<p>" + formatDate(item.startDate) + ' - ' + formatDate(item.endDate) + "</p>";
}

function formatDate(dateStr) {
    var t = new Date( dateStr );
    var formatted = t.toLocaleFormat("%d %b %Y");
    return formatted;
}

fetch('/api/get/actual')
    .then(function(response) {
        return response.json();
    }).then(function(data) {
    data.forEach(function(item) {
        var latLng = {lat: item.lat, lng: item.lon};
        //var festUrl = "<a href='" + item.url + "'>" + item.name + "</a>";
        var festUrl = item.name;
        var marker = new google.maps.Marker({
            position: latLng,
            title: festUrl + '\n' + item.city + ', ' + item.country,
            content: getLabel(item)
        });
        cityBalloon = new google.maps.InfoWindow({
        });
        marker.setMap(map);
        marker.addListener('click', function() {
            cityBalloon.setContent(marker.content);
            cityBalloon.open(map, marker);
        });

    });

}).catch(function(ex) {
    console.log('parsing failed', ex)
});
