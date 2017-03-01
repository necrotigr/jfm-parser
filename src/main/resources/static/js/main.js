var map;
var data;
function initMap() {
    var latlng = new google.maps.LatLng(51, 20);	 // примерный центр Европы

    map = new google.maps.Map(document.getElementById('map'), {
        center: latlng,
        zoom: 4
    });
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
            title: festUrl + '\n' + item.city + ', ' + item.country
        });
        marker.setMap(map);
    });

}).catch(function(ex) {
    console.log('parsing failed', ex)
});
