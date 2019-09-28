var map;

DG.then(function () {
    map = DG.map('map', {
        center: [42.881895, 74.587015],
        zoom: 16,
        dragging: false,
        zoomControl: false,
        fullscreenControl: false,
        doubleClickZoom: false,
        trackResize: false,
        boxZoom: false,
    });

    const latLon = [Android.getLatitude(), Android.getLongitude()];
    map.panTo(latLon);

    DG.marker(latLon).addTo(map);
});
