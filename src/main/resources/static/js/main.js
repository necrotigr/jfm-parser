var map;
function initMap() {
    var latlng = new google.maps.LatLng(51, 20);	 // примерный центр Европы

    map = new google.maps.Map(document.getElementById('map'), {
        center: latlng,
        zoom: 4
    });
}
