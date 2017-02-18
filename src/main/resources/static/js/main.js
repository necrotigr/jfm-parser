var map;
function initMap() {
    var latlng = new google.maps.LatLng(51, 20);	 // примерный центр Европы

    map = new google.maps.Map(document.getElementById('map'), {
        center: latlng,
        zoom: 4
    });
}

fetch('/api/get/actual')
    .then(function(response) {
        return response.json()
    }).then(function(json) {
    console.log('parsed json', json)
}).catch(function(ex) {
    console.log('parsing failed', ex)
});
