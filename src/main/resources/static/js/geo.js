/*
GEO coordinaten FRA nach Google: 50.04022975461447, 8.562363397687779
CargoCity Süd Max: 50.02226014279975, 8.59146564088922

https://rechneronline.de/geo-koordinaten/#entfernung

Entfernung zwischen den beiden Punkten: 2887 Meter = 2.887km

Nord-Süd-Abstand: 2000 Meter
Ost-West-Abstand: 2081 Meter

https://stackoverflow.com/questions/18883601/function-to-calculate-distance-between-two-coordinates
https://www.geodatasource.com/developers/javascript
*/
function getDistanceFromLatLonInMeter(lat1,lon1,lat2,lon2) {
  var R = 6371; // Radius of the earth in km
  var dLat = deg2rad(lat2-lat1);  // deg2rad below
  var dLon = deg2rad(lon2-lon1);
  var a =
    Math.sin(dLat/2) * Math.sin(dLat/2) +
    Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) *
    Math.sin(dLon/2) * Math.sin(dLon/2)
    ;
  var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
  var d = R * c; // Distance in km
  return d * 1000;
}

function deg2rad(deg) {
  return deg * (Math.PI/180)
}
