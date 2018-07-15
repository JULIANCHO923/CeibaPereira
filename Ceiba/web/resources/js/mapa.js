            
    var  map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: 4.81465, lng: -75.693488},
          zoom: 15               
        });
      
      var marker = new google.maps.Marker({
        position: {lat: 4.81465, lng: -75.693488 },
        map: map,
        draggable: true,
        title:"Arrastrame!"
      });


    var searchBox = new google.maps.places.SearchBox(document.getElementById('address'));
  
    google.maps.event.addListener(searchBox,'places_changed',function(){
    var places = searchBox.getPlaces();
    var bounds = new google.maps.LatLngBounds();
    var i, place;
    for(i=0; place=places[i];i++){
        bounds.extend(place.geometry.location);
        marker.setPosition(place.geometry.location);   
      }
      map.fitBounds(bounds);
      map.setZoom(15);
    });
  
    google.maps.event.addListener(marker,'position_changed',function(){
      var lat = marker.getPosition().lat();                      
      var lng = marker.getPosition().lng();      
      document.getElementById("lat").value = lat;
      document.getElementById("lng").value = lng;      
      geocodeLatLng(geocoder, map, infowindow);     
  });

 
 map.addListener('zoom_changed', function() {
    var zoom = map.getZoom();
    console.log("Zoom: %o", zoom);
    document.getElementById("zoom").value = zoom;
  });

 var geocoder = new google.maps.Geocoder;
 var infowindow = new google.maps.InfoWindow;      

      function geocodeLatLng(geocoder, map, infowindow) {
        var lat = document.getElementById('lat').value;
        console.log("Lat: %o", lat);
        var lng = document.getElementById('lng').value;
        console.log("Lng: %o", lng);
        var latlng = {lat: parseFloat(lat), lng: parseFloat(lng)};

        geocoder.geocode({'location': latlng}, function(results, status) {
          if (status === 'OK') {
            if (results[1]) {   
            // window.alert( var_dump(results));      
            document.getElementById("address2").value = results[0].formatted_address;                                
             // infowindow.setContent(results[1].formatted_address);
              //infowindow.open(map, marker);
            } else {
              window.alert('No se encontraron resultados');
            }
          } else {
            //window.alert('Geocoder falló debido a: ' + status);
          }
        });
}      
    
    //-----------------
    var boxSearch = new google.maps.places.SearchBox(document.getElementById('formId:address'));
  
    google.maps.event.addListener(boxSearch,'places_changed',function(){
    var places = boxSearch.getPlaces();
    var bounds = new google.maps.LatLngBounds();
    var i, place;
    for(i=0; place=places[i];i++){
        bounds.extend(place.geometry.location);
        marker.setPosition(place.geometry.location);   
      }
      map.fitBounds(bounds);
      map.setZoom(15);
    });
  
    google.maps.event.addListener(marker,'position_changed',function(){
      var lat = marker.getPosition().lat();                      
      var lng = marker.getPosition().lng();      
      document.getElementById("formId:lat").value = lat;
      document.getElementById("formId:lng").value = lng;      
      geocodeLatLng(geocoder, map, infowindow);     
  });

 
 map.addListener('zoom_changed', function() {
    var zoom = map.getZoom();
    console.log("Zoom: %o", zoom);
    document.getElementById("zoom").value = zoom;
  });